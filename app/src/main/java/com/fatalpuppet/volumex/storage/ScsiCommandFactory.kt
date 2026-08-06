package com.fatalpuppet.volumex.storage

import com.fatalpuppet.volumex.storage.scsi.CommandBlockWrapper

object ScsiCommandFactory {

    fun testUnitReady(): CommandBlockWrapper {

        val command = ScsiTestUnitReady.command()

        return CommandBlockWrapper(

            tag = CommandTagGenerator.next(),

            dataTransferLength = 0,

            flags = 0x00,

            lun = 0,

            commandLength = command.size.toByte(),

            command = command

        )

    }

    fun inquiry(): CommandBlockWrapper {

        val command = ScsiInquiry.command()

        return CommandBlockWrapper(

            tag = CommandTagGenerator.next(),

            dataTransferLength = 36,

            flags = 0x80.toByte(),

            lun = 0,

            commandLength = command.size.toByte(),

            command = command

        )

    }

}