package com.fatalpuppet.volumex.storage

data class UsbInterfaceInfo(

    val interfaceNumber: Int,

    val interfaceClass: Int,

    val endpointCount: Int,

    val bulkInFound: Boolean,

    val bulkOutFound: Boolean

)