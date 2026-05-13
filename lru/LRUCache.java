package lru;

public class LRUCache {
    private DoublyLinkedList lista;
    private HashTable hashTable;
    private int capacity;
    private int currentSize;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.currentSize = 0;
        this.hashTable = new HashTable(capacity);
        this.lista = new DoublyLinkedList(true);
    }

    // Get value by key - O(1)
    public int get(int key) {
        Node node = hashTable.search(key);
        if (node == null) {
            return -1;
        }
        // Move the accessed node to the front (most recently used)
        lista.moveNodeToFront(node);
        return node.value;
    }
    // Put key-value pair into cache - O(1)
    public void put(int key, int value) {
        Node existNode = hashTable.search(key);

        if (existNode != null) {
            // Update existing node
            existNode.value = value;
            lista.moveNodeToFront(existNode);
            return;
        }

        // Handle capacity before inserting new node
        if (isFull()) {
            Node lruNode = lista.removeLRU();
            hashTable.remove(lruNode.key);
            currentSize--;
        }

        // Create and insert new node
        Node newNode = new Node(key, value);
        lista.insertAtFront(newNode);
        hashTable.insert(newNode);
        currentSize++;
    }
    // Remove a specific key - O(1)
    public void remove(int key) {
        Node node = hashTable.search(key);
        if (node != null) {
            lista.removeNode(node);
            hashTable.remove(key);
            currentSize--;
        }
    }
    // Display cache contents from most to least recently used
    public void display() {
        lista.display();
    }
    // Get current cache size
    public int getSize() {
        return currentSize;
    }
    // Get cache capacity
    public int getCapacity() {
        return capacity;
    }
    // Check if cache is empty
    public boolean isEmpty() {
        return currentSize == 0;
    }
    // Check if cache is full
    public boolean isFull() {
        return currentSize == capacity;
    }
}
