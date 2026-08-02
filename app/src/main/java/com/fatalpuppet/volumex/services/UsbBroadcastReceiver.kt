package com.fatalpuppet.volumex.services

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.hardware.usb.UsbManager

class UsbBroadcastReceiver(
    private val onDeviceAttached: () -> Unit,
    private val onDeviceDetached: () -> Unit
) : BroadcastReceiver() {
    override fun onReceive(
        context: Context?,
        intent: Intent?
    ) {
        when (intent?.action) {
            UsbManager.ACTION_USB_DEVICE_ATTACHED -> {
            onDeviceAttached()
            }
            UsbManager.ACTION_USB_DEVICE_DETACHED -> {
                onDeviceDetached()
            }
        }
    }
}