package com.fatalpuppet.volumex.storage.scsi

import android.util.Log
import com.fatalpuppet.volumex.storage.disk.HexDump

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