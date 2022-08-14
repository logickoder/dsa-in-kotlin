package structures

import org.junit.Assert.assertEquals
import org.junit.Test

class LinkedListTest {

    @Test
    fun isEmpty() {
        val list = LinkedList<Int>()
        assert(list.isEmpty())
        list.push(1)
        assert(list.isEmpty().not())
    }

    @Test
    fun push() {
        val list = LinkedList<Int>()
        assertEquals(list.toString(), LinkedList.EMPTY_LIST)
        list.push(3)
        assertEquals(list.toString(), "3")
        list.push(2)
        assertEquals(list.toString(), "2 -> 3")
        list.push(1)
        assertEquals(list.toString(), "1 -> 2 -> 3")
        println(list)
    }
}