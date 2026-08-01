package com.fatalpuppet.volumex.data.model

data class UsbDeviceInfo(

    val manufacturer: String? = null,

    val product: String? = null,

    val vendorId: Int = 0,

    val productId: Int = 0,

    val interfaceCount: Int = 0

)