package com.fatalpuppet.volumex.storage.disk

object HexDump {

    fun firstBytes(
        data: ByteArray,
        count: Int = 32
    ): String {

        return data
            .take(count)
            .joinToString(" ") {
                "%02X".format(it)
            }

    }

}