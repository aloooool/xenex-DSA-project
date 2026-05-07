package lru;

public class HashTable {
    public DoublyLinkedList[] lru;
    public int capacity;


    public HashTable(int capacity) {
        this.capacity = capacity;
        this.lru = new DoublyLinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            lru[i] = new DoublyLinkedList(); 
        }
    }

    public int hash(int key) {
        return key % capacity;
    }

    public Node search(int key) {
        int index = hash(key);
        return lru[index].getNode(key);
        
    }
    
    public void remove(int key){
        int index = hash(key);
        lru[index].removeNode(lru[index].getNode(key));
    }

    public void insert(int key,int value){
        int index = hash(key);
        lru[index].insertAtFront(key, value);

    }
}
