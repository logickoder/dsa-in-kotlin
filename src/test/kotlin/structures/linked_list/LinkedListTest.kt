package structures.linked_list

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test

class LinkedListTest {
    private lateinit var list: LinkedList<Int>

    @Before
    fun setUp() {
        list = LinkedList()
    }

    @Test
    fun isEmpty() {
        list.apply {
            assert(isEmpty())
            assertEquals(toString(), LinkedList.EMPTY_LIST)
            push(1)
            assert(isEmpty().not())
            assertNotEquals(toString(), LinkedList.EMPTY_LIST)
        }
    }

    @Test
    fun push() {
        list.apply {
            push(3)
            assertEquals(toString(), "3")
            push(2)
            assertEquals(toString(), "2 -> 3")
            push(1)
            assertEquals(toString(), "1 -> 2 -> 3")
        }
    }

    @Test
    fun pushFluent() {
        list.apply {
            // testing the fluent interface style
            push(4).push(3).push(2).push(1)
            assertEquals(toString(), "1 -> 2 -> 3 -> 4")
        }
    }

    @Test
    fun append() {
        list.apply {
            append(1)
            assertEquals(toString(), "1")
            append(2)
            assertEquals(toString(), "1 -> 2")
            append(3)
            assertEquals(toString(), "1 -> 2 -> 3")
        }
    }

    @Test
    fun appendFluent() {
        list.apply {
            // testing the fluent interface style
            append(4).append(3).append(2).append(1)
            assertEquals(toString(), "4 -> 3 -> 2 -> 1")
        }
    }

    @Test
    fun pop() {
        list.apply {
            append(1).append(2).append(3)
            assertEquals(pop(), 1)
            assertEquals(toString(), "2 -> 3")
            assertEquals(pop(), 2)
            assertEquals(toString(), "3")
            assertEquals(pop(), 3)
            assertEquals(pop(), null)
        }
    }

    @Test
    fun removeLast() {
        list.apply {
            append(1).append(2).append(3)
            assertEquals(removeLast(), 3)
            assertEquals(toString(), "1 -> 2")
            assertEquals(removeLast(), 2)
            assertEquals(toString(), "1")
            assertEquals(removeLast(), 1)
            assertEquals(removeLast(), null)
        }
    }

    @Test
    fun removeAfter() {
        list.apply {
            append(1).append(2).append(3)
            assertEquals(removeAfter(nodeAt(1)!!), 3)
            assertEquals(removeAfter(nodeAt(0)!!), 2)
            assertEquals(removeLast(), 1)
            assertEquals(removeLast(), null)
        }
    }

    @Test
    fun nodeAt() {
        list.apply {
            push(1)
            assertEquals(nodeAt(0)?.value, 1)
            append(2)
            assertEquals(nodeAt(1)?.value, 2)
            push(3)
            assertEquals(nodeAt(0)?.value, 3)
            assertEquals(nodeAt(2)?.value, 2)
            append(4)
            assertEquals(nodeAt(3)?.value, 4)
            assertEquals(nodeAt(4), null)
            assertEquals(nodeAt(-1), null)
        }
    }

    @Test
    fun indexOf() {
        list.apply {
            append(1).append(2).append(4).append(3)
            assertEquals(indexOf(nodeAt(0)!!), 0)
            assertEquals(indexOf(nodeAt(1)!!), 1)
            assertEquals(indexOf(nodeAt(3)!!), 3)
            assertEquals(indexOf(nodeAt(2)!!), 2)
            assertEquals(indexOf(Node(3)), 3)
            assertEquals(indexOf(Node(5)), -1)
            assertEquals(indexOf(Node(0)), -1)
            assertEquals(indexOf(Node(-1)), -1)
        }
    }

    @Test
    fun insertViaIndex() {
        list.apply {
            append(1).append(2).append(3)
            insert(12, 0)
            assertEquals(nodeAt(1)?.value, 12)
            insert(14, 3)
            assertEquals(nodeAt(4)?.value, 14)
            assertEquals(insert(13, Node(2)), null)
            insert(15, nodeAt(4)!!)
            assertEquals(nodeAt(5)?.value, 15)
        }
    }

    @Test
    fun insertViaNode() {
        list.apply {
            append(1).append(2).append(3)
            var middleNode = nodeAt(1)
            (1..3).forEach {
                middleNode = insert(-1 * it, middleNode!!)
                assertEquals(nodeAt(1 + it), middleNode)
            }
            (1..3).forEach {
                middleNode = insert(-1 * it, index = it)
                assertEquals(nodeAt(1 + it), middleNode)
            }
        }
    }

    @Test
    fun reversed() {
        list.apply {
            append(1).append(2).append(3)
            assertEquals(toString(), "1 -> 2 -> 3")
            assertEquals(reversed().toString(), "3 -> 2 -> 1")
        }
    }

    @Test
    fun middle() {
        list.apply {
            append(1).append(2).append(3)
            assertEquals(middle?.value, 2)
            append(4)
            assertEquals(middle?.value, 3)
            append(5)
            assertEquals(middle?.value, 3)
        }
    }
}