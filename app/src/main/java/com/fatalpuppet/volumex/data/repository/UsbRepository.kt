package com.fatalpuppet.volumex.data.repository

import android.content.Context
import android.hardware.usb.UsbDevice
import android.hardware.usb.UsbManager
import com.fatalpuppet.volumex.services.UsbService
import com.fatalpuppet.volumex.storage.disk.DiskScanner
import com.fatalpuppet.volumex.storage.usb.UsbBlockDeviceReader

class UsbRepository(
    private val context: Context
) {
    private var blockDeviceReader: UsbBlockDeviceReader? = null
    private val usbService = UsbService(context)
    private val diskScanner = DiskScanner()

    fun registerReceiver(
        onAttach: () -> Unit,
        onDetach: () -> Unit
    ) {
        usbService.registerReceiver(
            onAttach,
            onDetach
        )
    }
    fun isUsbSupported() =
        usbService.isUsbHostSupported()

    fun getConnectedDevices(): List<UsbDevice> =
        usbService.getConnectedDevices()

    fun openFirstDevice(): Boolean {
        val device = usbService
            .getConnectedDevices()
            .firstOrNull()
            ?: return false
        return openDevice(device)
    }
    fun openDevice(device: UsbDevice): Boolean {
        val usbManager =
            context.getSystemService(
                Context.USB_SERVICE
            ) as UsbManager
        val reader = UsbBlockDeviceReader(
            usbManager,
            device
        )
        if (!reader.open()) {
            return false
        }
        blockDeviceReader = reader
        android.util.Log.i(
            "VolumeX",
            "USB block device opened successfully"
        )
        return true
    }

    fun devices() =
        diskScanner.scan(
            usbService.getDeviceInfo()
        )
    fun deviceCount(): Int =
        usbService.getConnectedDeviceCount()
    fun hasDevices(): Boolean =
        usbService.hasConnectedDevices()
    fun unregisterUsbEvents() {
        usbService.unregisterReceiver()
    }
    fun readSectorZero(): ByteArray? {
        val reader =
            blockDeviceReader
                ?: return null
        return reader.readSector(0)
    }
}