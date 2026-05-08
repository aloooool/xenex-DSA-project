package lru;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== LRU Cache System Test ===\n");

        // Create LRU Cache with capacity 3
        LRUCache cache = new LRUCache(3);

        System.out.println("--- Test 1: Insert until full capacity ---");
        cache.put(1, 10);
        System.out.println("After put(1, 10):");
        cache.display();

        cache.put(2, 20);
        System.out.println("After put(2, 20):");
        cache.display();

        cache.put(3, 30);
        System.out.println("After put(3, 30):");
        cache.display();

        System.out.println("\n--- Test 2: Access elements (move to front) ---");
        int val = cache.get(1);
        System.out.println("get(1) returned: " + val);
        System.out.println("After get(1):");
        cache.display();

        System.out.println("\n--- Test 3: Insert when full (evict LRU) ---");
        cache.put(4, 40);
        System.out.println("After put(4, 40) - Key 2 should be evicted:");
        cache.display();

        System.out.println("\n--- Test 4: Verify evicted item is gone ---");
        val = cache.get(2);
        System.out.println("get(2) returned: " + val + " (expected: -1, as it was evicted)");

        System.out.println("\n--- Test 5: Update existing key ---");
        cache.put(3, 35);
        System.out.println("After put(3, 35) - updating key 3:");
        cache.display();

        System.out.println("\n--- Test 6: Get and verify order ---");
        cache.get(4);
        System.out.println("After get(4):");
        cache.display();

        System.out.println("\n--- Test 7: Remove specific key ---");
        cache.remove(1);
        System.out.println("After remove(1):");
        cache.display();

        System.out.println("\n--- Test 8: Insert after removal ---");
        cache.put(5, 50);
        System.out.println("After put(5, 50):");
        cache.display();

        System.out.println("\n--- Test 9: Fill cache again ---");
        cache.put(6, 60);
        System.out.println("After put(6, 60):");
        cache.display();

        System.out.println("\n--- Test 10: Edge case - get non-existent key ---");
        val = cache.get(100);
        System.out.println("get(100) returned: " + val + " (expected: -1)");

        System.out.println("\n--- Test 11: Cache state ---");
        System.out.println("Current size: " + cache.getSize());
        System.out.println("Capacity: " + cache.getCapacity());
        System.out.println("Is Full: " + cache.isFull());
        System.out.println("Is Empty: " + cache.isEmpty());

        System.out.println("\n=== All Tests Completed ===");
    }
}
