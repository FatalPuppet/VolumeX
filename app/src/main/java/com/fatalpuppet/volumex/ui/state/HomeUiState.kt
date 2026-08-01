package com.fatalpuppet.volumex.ui.state

import com.fatalpuppet.volumex.data.model.UsbDeviceInfo
import com.fatalpuppet.volumex.data.usb.UsbState

data class HomeUiState(

    val usbState: UsbState = UsbState.WAITING,

    val statusMessage: String = "Waiting for USB device",

    val connectedDevice: UsbDeviceInfo? = null

)