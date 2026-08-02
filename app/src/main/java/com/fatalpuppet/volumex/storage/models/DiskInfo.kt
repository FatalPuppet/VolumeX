package com.fatalpuppet.volumex.storage.models

data class DiskInfo(

    val name: String,

    val vendorId: Int,

    val productId: Int,

    val capacity: Long? = null,

    val partitionCount: Int = 0

)