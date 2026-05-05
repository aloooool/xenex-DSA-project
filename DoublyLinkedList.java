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
}