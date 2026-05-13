package lru;
public class Node {
    public int key;
    public int value;
    
    // Pointers for the main LRU Doubly Linked List
    public Node prev;
    public Node next;
    
    // Pointers for the Hash Table collision list (chaining)
    public Node hashPrev;
    public Node hashNext;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
        this.hashPrev = null;
        this.hashNext = null;
    }
}