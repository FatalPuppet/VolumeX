package com.fatalpuppet.volumex.storage

import android.util.Log

object ScsiCommandLogger {

    private const val TAG = "VolumeX"

    fun sent(command: ByteArray) {
        Log.d(
            TAG,
            "TX : ${HexDump.format(command)}"
        )
    }

    fun received(data: ByteArray) {
        Log.d(
            TAG,
            "RX : ${HexDump.format(data)}"
        )
    }

}