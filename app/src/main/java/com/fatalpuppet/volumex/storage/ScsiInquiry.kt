package com.fatalpuppet.volumex.storage

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