package lru;

public class LRUCache {
    DoublyLinkedList dll ;
    HashTable hashTable;
    int capacity;
    int currentSize;

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.currentSize = 0 ;
        this.hashTable = new HashTable(capacity);
        this.dll = new DoublyLinkedList();
    }

    public int get(int key){
        Node node = hashTable.search(key);
        if(node == null)
            return -1;
        dll.moveNodeToFront(node);
        return node.value;
    }

    public void put(int key , int value ){
        Node existNode = hashTable.search(key);
        if(existNode != null){
            existNode.value = value;
            dll.moveNodeToFront(existNode);
            return;
        }
        if(currentSize == capacity){
            Node lruNode = dll.removeLRU();
            hashTable.remove(lruNode.key);
            currentSize--;
        }
        Node newNode = new Node(key,value);
        dll.insertAtFront(newNode.key,newNode.value);
        hashTable.insert(key , value);
        currentSize++;
    }
}
