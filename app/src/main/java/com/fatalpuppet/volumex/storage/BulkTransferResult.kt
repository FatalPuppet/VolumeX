package com.fatalpuppet.volumex.storage

data class BulkTransferResult(

    val success: Boolean,

    val bytesTransferred: Int,

    val data: ByteArray?

)