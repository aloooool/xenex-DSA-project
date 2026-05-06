import lru.DoublyLinkedList;

public class LRUCache {
    private DoublyLinkedList linkedlist ;
    private HashTable hashTable;
    private int capacity;
    private int currentSize;

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.currentSize = 0 ;
        this.hashTable = new HashTable();
        this.linkedlist = new DoublyLinkedList();
    }

    public int get(int key){
        Node node = hashTable.search(key);
        if(node == null)
            return -1;
        linkedlist.moveNodeToFront(node);
        return node.value;
    }

    public void put(int key , int value ){
        Node existNode = hashTable.search(key);
        if(existNode != null){
            existNode.setNodeValue(value);
            linkedlist.moveNodeToFront(existNode);
            return;
        }
        if(currentSize == capacity){
            Node lruNode = linkedlist.removeLRU();
            hashTable.remove(lruNode.key);
            currentSize--;
        }
        Node newNode = new Node(key,value);
        linkedlist.insertAtFront(newNode);
        hashTable.insert(key , newNode);
        currentSize++;
    }
}
