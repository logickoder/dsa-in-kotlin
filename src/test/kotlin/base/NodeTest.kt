package base

import org.junit.Assert.assertEquals
import org.junit.Test

class NodeTest {
    @Test
    fun creatingAndLinkingNodes() {
        val node1 = Node(value = 1)
        val node2 = Node(value = 2)
        val node3 = Node(value = 3)
        node1.next = node2
        node2.next = node3
        println(node1)
        assertEquals(node1.value, 1)
        assertEquals(node1.next!!.value, 2)
        assertEquals(node1.next?.next!!.value, 3)
    }
}