package lru;
public class HashTable {
    public DoublyLinkedList[] lista;
    public int capacity;
    int total_table_size;
    public HashTable(int capacity) {
        this.capacity = capacity;
        this.lista = new DoublyLinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            lista[i] = new DoublyLinkedList(false); 
        }
    }
    public int get_tableSize(){
        return total_table_size;
    }
    // comlexty o(1)
    public int hash(int key) {
        return key % capacity;
    }
    // comlexty o(1) but in overloading o(n)
    public Node search(int key) {
        return lista[hash(key)].getNode(key);
    }
    // comlexty o(1) but in overloading o(n)
    public void remove(int key){
        Node t = search(key);
        if (t != null) {
            total_table_size--;
            lista[hash(key)].removeNode(t);   
        }
    }
    // comlexty o(1)
    public void insert(Node node){
        if (total_table_size < capacity) {
            total_table_size++;
            lista[hash(node.key)].insertAtFront(node);   
        }

    }

}

