package lru;

public class HashTable {
    private Node[] table;
    private int capacity;
    private static final Node DELETED = new Node (-1,-1);

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.table = new Node[capacity];
    }

    // Hash function: maps key to index
    private int hash(int key) {
        return Math.abs(key)% capacity;  //solve if key is negative
    }

    // Search for a node by key - O(n) worst case
    public Node search(int key) {
        int index = hash(key);
        int start = index;

        while (table[index] != null) {

            if (table[index] != DELETED && table[index].key == key) {
                return table[index];
            }

            index = (index + 1) % capacity;
            if (index == start) break; // full cycle
        }
        return null;
    }

    // Insert a node into the hash table - o(n) worst case
    public void insert(Node node) {
        int index = hash(node.key);

        while (table[index] != null && table[index] != DELETED) {

            if (table[index].key == node.key) {
                table[index] = node;
                return;
            }
            index = (index + 1) % capacity;
        }
        table[index] = node;
    }

    // Remove a node by key - o(n) worst case
    public void remove(int key) {
        int index = hash(key);
        int start = index;

        while (table[index] != null) {

            if (table[index] != DELETED && table[index].key == key) {
                table[index] = DELETED;
                return;
            }
            index = (index + 1) % capacity;
            if (index == start) break;
        }
    }

    // Get all nodes in the hash table (for debugging/display purposes)
    public Node[] getTable() {
        return table;
    }
}
