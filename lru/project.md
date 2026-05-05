# LRU Cache System - Data Structures Project

## Project Overview
In this project, you will implement an **LRU (Least Recently Used) Cache System** that supports fast data access and automatic eviction of outdated items. 
Modern systems such as web browsers, operating systems, and databases use caching to improve performance. 
However, cache size is limited, so systems must decide which item should be removed when the cache is full. 
This project solves that problem using the LRU policy, where the least recently used item is evicted first.

## System Requirements

### Core Design Constraints
You are **NOT** allowed to use built-in data structures like:
* `LinkedHashMap` 
* `HashMap` (for full solution logic) 

**You must implement from scratch:**
1.  Hash Table
2.  Doubly Linked List

---

## System Design
The system uses two data structures to achieve its goals 10

* **Hash Table:** Provides direct access by key $\rightarrow O(1)$
* **Doubly Linked List:** Maintains usage order
    * **Head:** Most Recently Used
    * **Tail:** Least Recently Used

---

## Implementation Tasks

### Phase 1: List & Node Foundation
* **Task 1: Node Design** – Create a `Node` class containing `key`, `value`, `prev`, and `next` references, 
* **Task 2: DLL Initialization** – Implement the list with `head` and `tail` pointers, handling empty cases,
* **Task 3: Insert at Front** – Create a method to add nodes to the front (marking them as recently used),
* **Task 4: Remove a Node** – Implement a method to remove a node from any position (head, tail, or middle)

### Phase 2: Logic & Ordering
* **Task 5: Move Node to Front** – Create a method that removes a node from its current position and re-inserts it at the front after access,
* **Task 6: Remove LRU Item** – Implement a method to remove the node at the tail and return it for deletion from the hash table,

### Phase 3: Hash Table & Integration
* **Task 7: Hash Setup** – Design a hash function and a table that maps keys to node references, handling collisions,
* **Task 8: Hash Operations** – Provide $O(1)$ methods for insert, search, and remove within the table,
* **Task 9: LRU Core Logic** – Build the main class coordinating the Hash Table and DLL for `get` and `put`,

### Phase 4: Finalization
* **Task 10: Capacity & Testing** – Implement the rule that evicts the tail node when capacity is exceeded,

---

## Testing & Deliverables

### Testing Requirements
Students must verify
* Insertion until full capacity.
* Repeated element access.
* Eviction correctness and update behavior.
* Edge cases (empty cache, repeated access).

### Deliverables
1.  **Source Code:** Clean, modular Java implementation
2.  **Report:** Must include system design explanation, complexity analysis, and test cases

---

## Grading Rubric
| Criteria | Weight |
| :--- | :--- |
| Correctness | 30% |
| Data Structure Implementation | 25% |
| Design & Integration | 20% |
| Complexity Analysis | 10% |
| Code Quality | 10% |
| Discussion | 5% |