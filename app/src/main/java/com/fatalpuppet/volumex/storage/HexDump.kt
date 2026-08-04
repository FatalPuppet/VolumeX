package com.fatalpuppet.volumex.storage

object HexDump {

    fun format(

        data: ByteArray

    ): String {

        return data.joinToString(" ") {

            "%02X".format(it)

        }

    }

}