package com.fatalpuppet.volumex.storage

import android.hardware.usb.*
import android.util.Log

class UsbBlockDeviceReader(
    private val usbManager: UsbManager,
    private val device: UsbDevice,
) : BlockDeviceReader {
    private var connection: UsbDeviceConnection? = null
    private val interfaceScanner = UsbInterfaceScanner()
    private var massStorage: UsbMassStorageInterface? = null
    private var claimed = false

    fun getConnectionInfo(): UsbConnectionInfo? {

        val storage = massStorage ?: return null

        return UsbConnectionInfo(
            vendorId = device.vendorId,
            productId = device.productId,
            manufacturer = device.manufacturerName,
            product = device.productName,
            interfaceNumber = storage.interfaceNumber,
            endpointIn = storage.bulkIn.address,
            endpointOut = storage.bulkOut.address
        )
    }

    override fun open(): Boolean {
        connection = usbManager.openDevice(device)
            ?: return false
        interfaceScanner.inspectDevice(device)
        massStorage =
            interfaceScanner.findMassStorageInterface(device)
                ?: return false
        claimed = connection!!.claimInterface(
            massStorage!!.usbInterface,
            true
        )
        Log.d(
            "VolumeX",
            "USB interface claimed = $claimed"
        )
        return claimed
    }
    override fun close() {
        if (claimed) {
            massStorage?.let {
                connection?.releaseInterface(
                    it.usbInterface
                )
                Log.d(
                    "VolumeX",
                    "USB interface released"
                )
            }
        }
        connection?.close()
        connection = null
        claimed = false
    }
    override fun readSector(
        sectorNumber: Long,
        sectorSize: Int
    ): ByteArray? {
        return null
    }

    fun isOpen(): Boolean {
        return connection != null && claimed
    }
}