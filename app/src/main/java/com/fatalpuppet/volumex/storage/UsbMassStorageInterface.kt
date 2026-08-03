package com.fatalpuppet.volumex.storage

import android.hardware.usb.UsbEndpoint
import android.hardware.usb.UsbInterface
import android.hardware.usb.*

data class UsbMassStorageInterface(

    val usbInterface: UsbInterface,

    val bulkIn: UsbEndpoint,

    val bulkOut: UsbEndpoint,

    val interfaceNumber: Int

)