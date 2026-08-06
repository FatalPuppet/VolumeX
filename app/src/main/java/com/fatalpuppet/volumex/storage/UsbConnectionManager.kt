package com.fatalpuppet.volumex.storage

import android.hardware.usb.*
import com.fatalpuppet.volumex.storage.usb.UsbBlockDeviceReader

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