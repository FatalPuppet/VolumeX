package com.fatalpuppet.volumex.storage.scsi

interface ScsiTransport {

    fun inquiry(): ScsiResult

    fun readCapacity(): ScsiResult

    fun readSector(
        lba: Long
    ): ScsiResult

}