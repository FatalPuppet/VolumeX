package com.fatalpuppet.volumex.storage

import com.fatalpuppet.volumex.storage.scsi.CommandStatusWrapper

object ScsiResponseValidator {
    fun validCsw(
        csw: CommandStatusWrapper
    ): Boolean {
        return csw.status.toInt() == 0
    }
}