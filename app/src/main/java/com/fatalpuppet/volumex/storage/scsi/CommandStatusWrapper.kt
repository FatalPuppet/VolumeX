package com.fatalpuppet.volumex.storage.scsi

data class CommandStatusWrapper(

    val tag: Int,

    val residue: Int,

    val status: Byte

)