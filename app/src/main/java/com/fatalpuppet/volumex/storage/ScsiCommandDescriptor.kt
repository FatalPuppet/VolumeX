package com.fatalpuppet.volumex.storage

data class ScsiCommandDescriptor(

    val command: ByteArray,

    val expectedLength: Int,

    val direction: ScsiCommandDirection

)