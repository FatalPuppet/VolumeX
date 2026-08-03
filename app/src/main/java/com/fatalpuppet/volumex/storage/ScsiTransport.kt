package com.fatalpuppet.volumex.storage

interface ScsiTransport {

    fun inquiry(): ScsiResult

    fun readCapacity(): ScsiResult

    fun readSector(
        lba: Long
    ): ScsiResult

}