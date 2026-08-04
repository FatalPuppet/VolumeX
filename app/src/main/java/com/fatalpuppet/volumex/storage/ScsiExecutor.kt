package com.fatalpuppet.volumex.storage

class ScsiExecutor(
    private val transport: BulkOnlyTransport
) {
    fun execute(
        name: String,
        cbw: CommandBlockWrapper,
        expectedLength: Int
    ): ScsiTransaction {
        val (result, elapsed) =
            TransactionTimer.measure {
                transport.execute(
                    CommandBlockWrapperBuilder.build(cbw),
                    expectedLength
                )
            }
        return ScsiTransaction(
            command = name,
            success = result.success,
            elapsedMs = elapsed,
            message = result.message
        )
    }
}