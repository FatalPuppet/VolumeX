package com.fatalpuppet.volumex.storage.scsi

data class ScsiSense(

    val key: Int,

    val asc: Int,

    val ascq: Int

)