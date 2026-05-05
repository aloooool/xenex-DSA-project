package lru;

public class DoublyLinkedList{
    Node head;
    Node tail;
public DoublyLinkedList(){
        head = null;
        tail = null;
    }

    public void insertAtFront(int key ,int value){
        Node start = new Node(key, value);
        if (head == null){
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
}
