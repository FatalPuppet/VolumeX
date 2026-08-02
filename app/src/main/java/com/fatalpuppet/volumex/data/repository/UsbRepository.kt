package com.fatalpuppet.volumex.data.repository

import android.content.Context
import android.hardware.usb.UsbDevice
import com.fatalpuppet.volumex.services.UsbService

class UsbRepository(
    context: Context
) {

    private val usbService =
        UsbService(context)

    fun isUsbSupported() =
        usbService.isUsbHostSupported()

    fun connectedDevices(): List<UsbDevice> =
        usbService.getConnectedDevices()

    fun registerUsbEvents(
        onAttach: () -> Unit,
        onDetach: () -> Unit
    ) {
        usbService.registerReceiver(
            onAttach,
            onDetach
        )
    }
    fun devices() =
        usbService.getDeviceInfo()
    fun deviceCount(): Int =
        usbService.getConnectedDeviceCount()
    fun hasDevices(): Boolean =
        usbService.hasConnectedDevices()
    fun unregisterUsbEvents() {
        usbService.unregisterReceiver()
    }
}