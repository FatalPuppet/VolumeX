package com.fatalpuppet.volumex.storage

import android.util.Log

object ScsiDebug {

    private const val TAG = "VolumeX"

    fun transaction(
        tx: ScsiTransaction
    ) {
        Log.d(
            TAG,
            "${tx.command} | Success=${tx.success} | ${tx.elapsedMs} ms | ${tx.message}"
        )
        ScsiTransactionHistory.add(tx)
    }
}