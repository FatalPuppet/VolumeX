package com.fatalpuppet.volumex.storage

object ScsiResponseValidator {
    fun validCsw(
        csw: CommandStatusWrapper
    ): Boolean {
        return csw.status.toInt() == 0
    }
}