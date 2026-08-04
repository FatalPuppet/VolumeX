package com.fatalpuppet.volumex.storage

data class ScsiSense(

    val key: Int,

    val asc: Int,

    val ascq: Int

)