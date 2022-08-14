package structures.linked_list

class LinkedListIterator<T>(
    private val list: LinkedList<T>
) : MutableIterator<T> {
    private var index = 0
    private var node: Node<T>? = null

    override fun hasNext() = index < list.size

    override fun next(): T {
        if (!hasNext())
            throw IndexOutOfBoundsException()

        node = if (index == 0) {
            list.nodeAt(0)
        } else node?.next

        ++index
        return node?.value!!
    }

    override fun remove() {
        if (index == 1) {
            list.pop()
        } else {
            val prevNode = list.nodeAt(index - 2) ?: return
            list.removeAfter(prevNode)
            node = prevNode
        }
        --index
    }
}