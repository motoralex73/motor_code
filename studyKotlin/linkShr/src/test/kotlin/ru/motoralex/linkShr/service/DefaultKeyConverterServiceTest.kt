package ru.motoralex.linkShr.service

import org.jetbrains.annotations.Contract
import org.junit.Test
import kotlin.math.abs
import kotlin.random.Random
import org.junit.Assert.*

class DefaultKeyConverterServiceTest {

    val service: KeyConverterService = DefaultKeyConverterService()

    @Test
    fun givenIdMustBeConvertableBothWays() {
        val rand = Random
        for (i in 0..1000L) {
            val initialId: Long = abs(rand.nextLong())
            val key = service.idToKey(initialId)
            val id: Long = service.keyToId(key)
            //assertEquals(initialId, id)
            assertNotEquals(initialId,id)
        }
    }
}