package lru;

public class HashTable {
    private Node[] table;
    private int capacity;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.table = new Node[capacity];
    }

    // Hash function: maps key to index
    private int hash(int key) {
        return key % capacity;
    }

    // Search for a node by key - O(1) average case
    public Node search(int key) {
        int index = hash(key);
        Node current = table[index];

        // Linear probing for collision resolution
        while (current != null) {
            if (current.key == key) {
                return current;
            }
            // In this simple implementation, we use a single slot
            // For proper chaining, you'd traverse a linked list here
            break;
        }
        return null;
    }

    // Insert a node into the hash table - O(1) average case
    public void insert(Node node) {
        if (node == null) {
            return;
        }

        int index = hash(node.key);
        table[index] = node;
    }

    // Remove a node by key - O(1) average case
    public void remove(int key) {
        int index = hash(key);

        if (table[index] != null && table[index].key == key) {
            table[index] = null;
        }
    }

    // Get all nodes in the hash table (for debugging/display purposes)
    public Node[] getTable() {
        return table;
    }
}
