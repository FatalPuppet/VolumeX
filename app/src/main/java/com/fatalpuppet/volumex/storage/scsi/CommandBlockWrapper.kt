package com.fatalpuppet.volumex.storage.scsi

data class CommandBlockWrapper(
    val tag: Int,
    val dataTransferLength: Int,
    val flags: Byte,
    val lun: Byte,
    val commandLength: Byte,
    val command: ByteArray
)