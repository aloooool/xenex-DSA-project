package lru;

public class DoublyLinkedList {
    Node head;
    Node tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }
    private boolean isempty(){
        return head == null;
    }

    public void insertAtFront(int key, int value) {
        Node start = new Node(key, value);
        if (isempty()) {
            head = start;
            tail = start;
        } else {
            start.next = head;
            head.prev = start;
            head = start;
        }
    }

    public void moveNodeToFront(Node node) {

       Node temp = node;
       removeNode(node);
       insertAtFront(temp.key, temp.value);
    }

    void removeNode(Node node) {
        if (isempty()) {
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
    }
    public Node removeLRU() {

        if (isempty()) return null;

        Node removed = tail;

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        return removed;
    }
    public int search(int key){
        if(isempty()){
            return -1; 
        }else{
            Node temp = head;
            while(temp != null && temp.key !=key){
                temp= temp.next;            
            }
            if(temp == null){
                return -1;
            }
            return temp.value;
        }
    }
    public Node getNode(int key){
        if(isempty()){
            return null; 
        }else{
            Node temp = head;
            while(temp != null && temp.key !=key){
                temp= temp.next;            
            }
            if(temp == null){
                return null;
            }
            return temp;
        }
    }
}
