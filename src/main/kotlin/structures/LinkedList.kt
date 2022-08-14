package structures

import base.Node

class LinkedList<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0

    fun isEmpty(): Boolean = size == 0

    fun push(value: T) {
        head = Node(value = value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
    }

    override fun toString(): String {
        return if (isEmpty()) {
            EMPTY_LIST
        } else head.toString()
    }

    companion object {
        const val EMPTY_LIST = "Empty list"
    }
}

//fun <T> LinkedList<T>.reversed()