package com.fatalpuppet.volumex.storage.scsi

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