package com.fatalpuppet.volumex.storage

import android.hardware.usb.*

class UsbConnectionManager(
    private val usbManager: UsbManager
) {
    fun createReader(
        device: UsbDevice
    ): UsbBlockDeviceReader {
        return UsbBlockDeviceReader(
            usbManager,
            device
        )
    }
}