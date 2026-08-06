package com.fatalpuppet.volumex.storage.disk

import com.fatalpuppet.volumex.storage.DeviceConnectionState

data class DiskInfo(

    val name: String,

    val vendorId: Int,

    val productId: Int,

    val capacity: Long? = null,

    val partitionCount: Int = 0,

    val connectionState: DeviceConnectionState = DeviceConnectionState.DISCONNECTED

)