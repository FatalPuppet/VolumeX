package com.fatalpuppet.volumex.services

import android.content.Context
import android.hardware.usb.UsbDevice
import android.hardware.usb.UsbManager
import android.content.BroadcastReceiver
import android.content.IntentFilter

class UsbService(
    private val context: Context
) {
    private val usbManager =
        context.getSystemService(Context.USB_SERVICE) as UsbManager
    private var receiver: BroadcastReceiver? = null
    fun isUsbHostSupported(): Boolean {
        return context.packageManager.hasSystemFeature(
            android.content.pm.PackageManager.FEATURE_USB_HOST
        )
    }
    fun getConnectedDevices(): List<UsbDevice> {
        return usbManager.deviceList.values.toList()
    }
    fun registerReceiver(
        onAttach: () -> Unit,
        onDetach: () -> Unit
    ) {
        receiver = UsbBroadcastReceiver(
            onAttach,
            onDetach
        )
        val filter = IntentFilter().apply {
            addAction(UsbManager.ACTION_USB_DEVICE_ATTACHED)
            addAction(UsbManager.ACTION_USB_DEVICE_DETACHED)
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            context.registerReceiver(
                receiver,
                filter,
                Context.RECEIVER_NOT_EXPORTED
            )
        } else {
            @Suppress("DEPRECATION")
            context.registerReceiver(
                receiver,
                filter
            )
        }
    }
    fun unregisterReceiver() {
        receiver?.let {
            context.unregisterReceiver(it)
        }
    }
}