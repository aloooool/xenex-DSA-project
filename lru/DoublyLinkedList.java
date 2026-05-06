package lru;

public class DoublyLinkedList {
    Node head;
    Node tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public void insertAtFront(int key, int value) {
        Node start = new Node(key, value);
        if (head == null) {
            head = start;
            tail = start;
        } else {
            start.next = head;
            head.prev = start;
            head = start;
        }
    }

    public void moveNodeToFront(Node node) {

        if (node == null || node == head) {
            return;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }

        if (node == tail) {
            tail = node.prev;
        }

        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        }

        head = node;

        if (tail == null) {
            tail = head;
        }
    }

    void removeNode(Node node) {
        if (node == null) {
            return;
        }

        if (node == head && node == tail) {
            head = tail = null;
        } else if (node == head) {
            head = head.next;
            head.prev = null;
        } else if (node == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        node.prev = null;
        node.next = null;
=======
    public Node removeLRU(){
        //please add the body , it's only skeleton code to run LRUCache class
        return null;
>>>>>>> main
    }
}
