package lru;

public class DoublyLinkedList {
    public Node head;
    public Node tail;
    public Node headLRU;
    public Node tailLRU;
    boolean isLRU;
    int size = 0;

    public DoublyLinkedList(boolean isLRU) {
        this.isLRU = isLRU;
        head = null;
        tail = null;
        headLRU = null;
        tailLRU = null;
    }
    // comlexty o(1)
    private boolean isEmpty() {
        return head == null;
    }
    private boolean isEmpty(boolean t) {
        return headLRU == null;
    }
    // Insert a new node at the front (most recently used position)
    // comlexty o(1)
    public void insertAtFront(Node node) {
        
        size++;
        if (isLRU){
            if (isEmpty(true)) {
                headLRU = node;
                tailLRU = node;
                node.prev = null;
                node.next = null;
            } else {
                node.next = headLRU;
                node.prev = null;
                headLRU.prev = node;
                headLRU = node;
            }
            return;
        }
        size++;
        if (isEmpty()) {
            head = node;
            tail = node;
            node.hashPrev = null;
            node.hashNext = null;
        } else {
            node.hashNext = head;
            node.hashPrev = null;
            head.hashPrev = node;
            head = node;
        }
        
    }
    // Remove a node from any position
    // comlexty o(1)
    public void removeNode(Node node) {
        if (isLRU) {
            if (isEmpty(true) || node == null) {
                return;
            }
            
            if (node == headLRU && node == tailLRU) {
                // Only one node
                headLRU = tailLRU = null;
            } else if (node == headLRU) {
                // Removing headLRU
                headLRU = headLRU.next;
                headLRU.prev = null;
            } else if (node == tailLRU) {
                // Removing tailLRU
                tailLRU = tailLRU.prev;
                tailLRU.next = null;
            } else {
                // Removing middle node
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }

            node.prev = null;
            node.next = null;
            size--;
            return;
        }
        if (isEmpty() || node == null) {
            return;
        }
        
        if (node == head && node == tail) {
            // Only one node
            head = tail = null;
        } else if (node == head) {
            // Removing head
            head = head.hashNext;
            head.hashPrev = null;
        } else if (node == tail) {
            // Removing tail
            tail = tail.hashPrev;
            tail.hashNext = null;
        } else {
            // Removing middle node
            node.hashPrev.hashNext = node.hashNext;
            node.hashNext.hashPrev = node.hashPrev;
        }

        node.hashPrev = null;
        node.hashNext = null;

        size--;
    }

    // Move an existing node to the front (most recently used)
    // comlexty o(1)
    public void moveNodeToFront(Node node) {
        if (node == null || isEmpty(true)) {
            return;
        }
        if (node == headLRU) {
            return; // Already at front
        }
        removeNode(node);
        insertAtFront(node); 
    }

    // Remove and return the least recently used node (tail)
    // comlexty o(1) 
    public Node removeLRU() {
        if (isLRU) {
            if (isEmpty(true)) {
                return null;
            }
            Node removed = tailLRU;
            removeNode(removed);
            return removed;
        }
        if (isEmpty()) {
                return null;
            }
            Node removed = tail;
            removeNode(removed);
            return removed;
    }
    // Display the cache from most recent to least recent
    // comlexty o(n) 
    public void display() {
        if (isEmpty(true)) {
            System.out.println("Cache is empty");
            return;
        }
        System.out.print("Cache (Most Recent -> Least Recent): ");
        Node temp = headLRU;
        while (temp != null) {
            System.out.print("[Key: " + temp.key + ", Value: " + temp.value + "] ");
            temp = temp.next;
        }
        System.out.println();
    }
    // takes key returns value  
    // comlexty o(1) but in overloading o(n)
    public Node getNode(int key){
        if(isEmpty()){
            return null; 
        }else{
            Node temp = head;
            while(temp != null && temp.key !=key){
                temp= temp.hashNext;            
            }
            if(temp == null){
                return null;
            }
            return temp;
        }
    }
    public int getSize(){
        return this.size;
    }
}
