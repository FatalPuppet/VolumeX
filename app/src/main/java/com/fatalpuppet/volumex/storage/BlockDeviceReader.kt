package com.fatalpuppet.volumex.storage

interface BlockDeviceReader {

    fun open(): Boolean

    fun close()

    fun readSector(
        sectorNumber: Long,
        sectorSize: Int = 512
    ): ByteArray?

}