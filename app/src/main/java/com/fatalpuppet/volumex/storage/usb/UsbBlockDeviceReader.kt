package com.fatalpuppet.volumex.storage.usb

import android.hardware.usb.*
import android.util.Log
import com.fatalpuppet.volumex.storage.disk.BlockDeviceReader
import com.fatalpuppet.volumex.storage.scsi.ScsiCommandFactory
import com.fatalpuppet.volumex.storage.scsi.ScsiDebug
import com.fatalpuppet.volumex.storage.scsi.ScsiExecutor
import com.fatalpuppet.volumex.storage.scsi.ScsiTransaction

class UsbBlockDeviceReader(
    private val usbManager: UsbManager,
    private val device: UsbDevice,
) : BlockDeviceReader {
    private var connection: UsbDeviceConnection? = null
    private val interfaceScanner = UsbInterfaceScanner()
    private var massStorage: UsbMassStorageInterface? = null
    private var claimed = false
    private var transport: BulkUsbTransport? = null
    private var connectionInfo: UsbConnectionInfo? = null
    private var scsiExecutor: ScsiExecutor? = null

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
        Log.d("VolumeX", "UsbBlockDeviceReader.open()")
        if (claimed) {
            transport = BulkUsbTransport(
                connection = connection!!,
                bulkIn = massStorage!!.bulkIn,
                bulkOut = massStorage!!.bulkOut
            )
            connectionInfo = getConnectionInfo()
        }
        val bulkTransport = BulkOnlyTransport(
            transport!!
        )
        scsiExecutor = ScsiExecutor(bulkTransport)
        Log.d("VolumeX", "SCSI Executor created")

        val transaction = testUnitReady()
        Log.d("VolumeX", "Calling TEST UNIT READY")

        Log.d("VolumeX", "Logging transaction")
        ScsiDebug.transaction(transaction)
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
        lba: Long
    ): ByteArray? {
        return null
    }
    override fun sectorSize(): Int {
        return 512
    }

    fun testUnitReady(): ScsiTransaction {
        val executor =
            scsiExecutor
                ?: return ScsiTransaction(
                    "TEST UNIT READY",
                    false,
                    0,
                    "Transport unavailable"
                )
        return executor.execute(
            "TEST UNIT READY",
            ScsiCommandFactory.testUnitReady(),
            0
        )
    }
    override fun isOpen(): Boolean =
        connection != null &&
                claimed &&
                transport != null

}