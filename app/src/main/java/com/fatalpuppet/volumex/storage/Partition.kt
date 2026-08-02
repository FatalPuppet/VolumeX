package com.fatalpuppet.volumex.storage

data class Partition(

    val name: String,

    val startSector: Long,

    val sectorCount: Long,

    val typeGuid: String

)