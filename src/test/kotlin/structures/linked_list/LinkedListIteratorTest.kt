package structures.linked_list

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class LinkedListIteratorTest {
    private lateinit var list: LinkedList<Int>

    @Before
    fun setUp() {
        list = LinkedList()
    }

    @Test
    fun hasNext() {
        list.apply {
            assertEquals(iterator().hasNext(), false)
            push(1)
            assertEquals(iterator().hasNext(), true)
            pop()
            assertEquals(iterator().hasNext(), false)
        }
    }

    @Test
    fun next() {
        list.apply {
            push(1)
            assertEquals(iterator().next(), 1)
            append(2).append(3)
            val iterator = iterator()
            (1..3).forEach {
                assertEquals(iterator.next(), it)
            }
        }
    }

    @Test
    fun remove() {
        list.apply {
            append(1).append(2).append(3)
            val iterator = iterator()
            assertEquals(iterator.next(), 1)
            iterator.remove()
            assertEquals(iterator.next(), 2)
            iterator.remove()
            assertEquals(iterator.next(), 3)
            append(1)
            assertEquals(iterator.next(), 1)
        }
    }
}