package com.fatalpuppet.volumex.storage.scsi

data class ScsiTransaction(

    val command: String,

    val success: Boolean,

    val elapsedMs: Long,

    val message: String,

    val timestamp: Long = System.currentTimeMillis()
)