package lru;

public class Node {
    public Node prev;
    public Node next;
    public int key;
    public int value;
    
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}
    
    

