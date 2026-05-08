package lru;

public class DoublyLinkedList {
    public Node head;
    public Node tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    private boolean isEmpty() {
        return head == null;
    }

    // Insert a new node at the front (most recently used position)
    public void insertAtFront(Node node) {
        if (isEmpty()) {
            head = node;
            tail = node;
            node.prev = null;
            node.next = null;
        } else {
            node.next = head;
            node.prev = null;
            head.prev = node;
            head = node;
        }
    }

    // Remove a node from any position
    public void removeNode(Node node) {
        if (isEmpty() || node == null) {
            return;
        }

        if (node == head && node == tail) {
            // Only one node
            head = tail = null;
        } else if (node == head) {
            // Removing head
            head = head.next;
            head.prev = null;
        } else if (node == tail) {
            // Removing tail
            tail = tail.prev;
            tail.next = null;
        } else {
            // Removing middle node
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        node.prev = null;
        node.next = null;
    }

    // Move an existing node to the front (most recently used)
    public void moveNodeToFront(Node node) {
        if (node == null || isEmpty()) {
            return;
        }

        if (node == head) {
            return; // Already at front
        }

        removeNode(node);
        insertAtFront(node);
    }

    // Remove and return the least recently used node (tail)
    public Node removeLRU() {
        if (isEmpty()) {
            return null;
        }

        Node removed = tail;

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        removed.prev = null;
        removed.next = null;
        return removed;
    }

    // Display the cache from most recent to least recent
    public void display() {
        if (isEmpty()) {
            System.out.println("Cache is empty");
            return;
        }

        System.out.print("Cache (Most Recent -> Least Recent): ");
        Node temp = head;
        while (temp != null) {
            System.out.print("[Key: " + temp.key + ", Value: " + temp.value + "] ");
            temp = temp.next;
        }
        System.out.println();
    }
}
