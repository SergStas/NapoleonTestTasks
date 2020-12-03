package com.sergstas.hw_1_dataclass_03_12_20_

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun checkCreation() {
        val client = ClientData(0, "John", "Johnson", null)
        assertEquals(0, client.ID)
        assertEquals("John", client.FirstName)
        assertEquals("Johnson", client.LastName)
        assertEquals(null, client.Email)
    }

    @Test
    fun checkSort() {
        val first = ClientData(1, "a", "a", null)
        val second = ClientData(2, "b", "b", null)
        val third = ClientData(3, "c", "c", null)
        val fourth = ClientData(4, "d", "d", null)
        val expected = arrayListOf(first, second, third, fourth)
        val actual = arrayListOf(second, fourth, first, third)
        actual.bubbleSort()
        assertEquals(expected.size, actual.size)
        for (i in 0 until expected.size)
            assertEquals(expected[i], actual[i])
        assertEquals(expected, actual)
    }
}