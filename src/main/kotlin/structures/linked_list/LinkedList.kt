package structures.linked_list

class LinkedList<T> : MutableCollection<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    override var size = 0
        private set

    override fun isEmpty(): Boolean {
        return size == 0
    }

    /**
     * Adds a value to the head of the list
     */
    fun push(value: T): LinkedList<T> {
        head = Node(value = value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
        return this
    }

    /**
     * Adds a value to the tail of the list
     */
    fun append(value: T): LinkedList<T> {
        if (isEmpty()) {
            push(value)
            return this
        }
        tail?.next = Node(value = value)
        tail = tail?.next

        size++
        return this
    }

    /**
     * Inserts a new node after the specified [afterNode]
     */
    fun insert(value: T, afterNode: Node<T>): Node<T>? {
        val index = indexOf(afterNode)
        return if (index != -1) {
            val node = Node(value, afterNode.next)
            afterNode.next = node
            ++size
            node
        } else null
    }

    /**
     * Removes the value at the head of the list
     */
    fun pop(): T? {
        return if (isEmpty()) {
            null
        } else {
            val result = head
            head = head?.next
            if (tail == result) {
                tail = head
            }
            --size
            result?.value
        }
    }

    /**
     * Removes the value at the tail of the list
     */
    fun removeLast(): T? {
        val result = tail
        tail = nodeAt(size - 2)
        tail?.next = null
        if (head == result) {
            head = tail
        }
        --size
        return result?.value
    }

    /**
     * Removes the value after the specified node
     */
    fun removeAfter(node: Node<T>): T? {
        if (indexOf(node) == -1) {
            return null
        }
        val result = node.next
        node.next = node.next?.next
        if (result == tail) {
            tail = node
        }
        --size
        return result?.value
    }

    /**
     * Returns the node at a specified index
     */
    fun nodeAt(index: Int): Node<T>? {
        return if (index >= size || index < 0) {
            null
        } else {
            var currentNode = head
            for (i in 1..index) {
                currentNode = currentNode?.next
            }
            currentNode
        }
    }

    /**
     * Returns the index of the node or -1 if the node is not in the list
     */
    fun indexOf(node: Node<T>): Int {
        var currentNode = head
        var currentIndex = 0
        while (currentNode != null && currentNode != node && currentIndex < size) {
            currentNode = currentNode.next
            ++currentIndex
        }
        return if (currentNode == node) {
            currentIndex
        } else -1
    }

    override fun iterator() = LinkedListIterator(this)

    override fun contains(element: T): Boolean {
        for (item in this) {
            if (item == element) return true
        }
        return false
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        for (item in elements) {
            if (!contains(item)) return false
        }
        return true
    }

    override fun add(element: T): Boolean {
        append(element)
        return true
    }

    override fun addAll(elements: Collection<T>): Boolean {
        for (item in elements) {
            append(item)
        }
        return true
    }

    override fun clear() {
        head = null
        tail = null
        size = 0
    }

    override fun remove(element: T): Boolean {
        val iterator = iterator()
        while (iterator.hasNext()) {
            if (iterator.next() == element) {
                iterator.remove()
                return true
            }
        }
        return false
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        var result = false
        for (item in elements) {
            result = remove(item) || result
        }
        return result
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        var result = false
        val iterator = this.iterator()
        while (iterator.hasNext()) {
            if (elements.contains(iterator.next()).not()) {
                iterator.remove()
                result = true
            }
        }
        return result
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

