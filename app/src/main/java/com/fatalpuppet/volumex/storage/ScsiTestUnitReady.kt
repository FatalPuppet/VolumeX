package com.fatalpuppet.volumex.storage

object ScsiTestUnitReady {
    fun command(): ByteArray {
        return byteArrayOf(
            ScsiOpcodes.TEST_UNIT_READY,
            0,
            0,
            0,
            0,
            0
        )
    }
}