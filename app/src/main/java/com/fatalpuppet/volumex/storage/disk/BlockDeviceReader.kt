package com.fatalpuppet.volumex.storage.disk

interface BlockDeviceReader {

    fun open(): Boolean
    fun close()
    fun isOpen(): Boolean
    fun readSector(lba: Long): ByteArray?
    fun sectorSize(): Int
}