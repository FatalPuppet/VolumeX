package com.fatalpuppet.volumex.storage.scsi

data class ScsiInquiryResponse(

    val vendor: String,

    val product: String,

    val revision: String

)