package com.fatalpuppet.volumex.storage

data class CommandStatusWrapper(

    val tag: Int,

    val residue: Int,

    val status: Byte

)