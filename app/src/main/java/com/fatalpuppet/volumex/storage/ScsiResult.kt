package com.fatalpuppet.volumex.storage

data class ScsiResult(

    val success: Boolean,

    val data: ByteArray?,

    val message: String

)
