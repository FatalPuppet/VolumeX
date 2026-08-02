package com.fatalpuppet.volumex.storage

class BlockDeviceReader {
    fun readSector(
        sector: Long,
        sectorSize: Int = 512
    ): ByteArray {
        throw NotImplementedError(
            "Raw sector reading not implemented yet."
        )
    }
}