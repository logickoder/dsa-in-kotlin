package structures.linked_list


/**
 * Inserts a new node after the specified [index]
 */
fun <T> LinkedList<T>.insert(value: T, index: Int) = insert(value, nodeAt(index)!!)

fun <T> LinkedList<T>.reversed(): LinkedList<T> {
    val iterator = iterator()
    val list = LinkedList<T>()
    while (iterator.hasNext()) {
        list.push(iterator.next())
    }
    return list
}

val <T> LinkedList<T>.middle: Node<T>?
    get() {
        var slow = nodeAt(0)
        var fast = nodeAt(0)
        while (fast != null) {
            fast = fast.next
            if (fast != null) {
                fast = fast.next
                slow = slow?.next
            }
        }
        return slow
    }