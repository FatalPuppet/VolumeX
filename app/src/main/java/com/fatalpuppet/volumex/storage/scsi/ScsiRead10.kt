package com.fatalpuppet.volumex.storage.scsi

object ScsiRead10 {

    fun command(

        lba: Long,

        blocks: Int

    ): ByteArray {

        val cmd = ByteArray(10)

        cmd[0] = 0x28

        cmd[2] = (lba shr 24).toByte()

        cmd[3] = (lba shr 16).toByte()

        cmd[4] = (lba shr 8).toByte()

        cmd[5] = lba.toByte()

        cmd[7] = (blocks shr 8).toByte()

        cmd[8] = blocks.toByte()

        return cmd

    }

}