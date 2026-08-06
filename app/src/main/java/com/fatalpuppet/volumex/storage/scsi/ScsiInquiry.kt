package com.fatalpuppet.volumex.storage.scsi

object ScsiInquiry {
    fun command(): ByteArray {
        return byteArrayOf(
            0x12,
            0,
            0,
            0,
            36,
            0
        )
    }
}