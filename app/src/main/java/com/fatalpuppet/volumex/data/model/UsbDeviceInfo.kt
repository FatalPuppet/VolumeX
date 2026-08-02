package com.fatalpuppet.volumex.data.models

data class UsbDeviceInfo(
    val deviceName: String,
    val manufacturer: String?,
    val productName: String?,
    val vendorId: Int,
    val productId: Int,
    val serialNumber: String?
)