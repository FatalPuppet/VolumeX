package com.fatalpuppet.volumex.permissions

import android.content.Context
import android.hardware.usb.UsbDevice

class UsbPermissionManager(
    private val context: Context
) {

    fun hasPermission(
        device: UsbDevice
    ): Boolean {

        return false

    }

    fun requestPermission(
        device: UsbDevice
    ) {

        // Implementation coming next

    }

}