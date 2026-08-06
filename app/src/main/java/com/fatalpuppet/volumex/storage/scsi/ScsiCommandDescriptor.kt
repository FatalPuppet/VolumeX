package com.fatalpuppet.volumex.storage.scsi

data class ScsiCommandDescriptor(

    val command: ByteArray,

    val expectedLength: Int,

    val direction: ScsiCommandDirection

)