package com.fatalpuppet.volumex.storage

import java.util.concurrent.atomic.AtomicInteger

object CommandTagGenerator {

    private val counter = AtomicInteger(1)

    fun next(): Int {

        return counter.getAndIncrement()

    }

}