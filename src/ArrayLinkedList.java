/**
 * Linked List Implemented Using Array (Static Linked List)
 *
 * Concept:
 * - We use a fixed-size array to simulate nodes.
 * - Each "node" has two fields: data and next (but next is an INDEX, not a pointer).
 * - We maintain a free list (available nodes) using the 'next' field.
 * - This combines the random access of arrays with the dynamic linking of linked lists.
 *
 * Perfect for assignments that ask: "Implement Linked List using Array"
 */

public class ArrayLinkedList {

    // Inner class representing one node in the array
    static class Node {
        int data;     // Actual value stored
        int next;     // Index of the next node (-1 means null/end)

        public Node() {
            this.data = 0;
            this.next = -1;   // -1 represents null
        }
    }

    private Node[] nodes;      // Array that holds all possible nodes
    private int capacity;      // Maximum number of nodes
    private int head;          // Index of the first node of the linked list (-1 if empty)
    private int free;          // Head of the free list (available nodes)
    private int size;          // Current number of elements in the list

    /**
     * Constructor: Initialize the array-based linked list
     * @param capacity Maximum number of nodes the list can hold
     */
    public ArrayLinkedList(int capacity) {
        this.capacity = capacity;
        this.nodes = new Node[capacity];
        this.head = -1;        // List is empty
        this.size = 0;

        // Initialize all nodes and link them into the free list
        for (int i = 0; i < capacity; i++) {
            nodes[i] = new Node();
            nodes[i].next = i + 1;   // Link to next free node
        }
        nodes[capacity - 1].next = -1;  // Last node points to null
        free = 0;                  // Free list starts at index 0
    }

    /**
     * Allocate a new node from the free list
     * @return index of allocated node, or -1 if no space
     */
    private int allocateNode() {
        if (free == -1) {
            System.out.println("No more space available in array!");
            return -1;
        }
        int newIndex = free;
        free = nodes[free].next;   // Move free pointer to next available node
        return newIndex;
    }

    /**
     * Return a node back to the free list
     * @param index Index of node to free
     */
    private void freeNode(int index) {
        nodes[index].next = free;  // Point this node to current free list
        free = index;              // Make this the new head of free list
    }

    /**
     * Insert at the beginning (like push in stack or addFirst in linked list)
     */
    public void insertAtBeginning(int data) {
        int newIndex = allocateNode();
        if (newIndex == -1) return;

        nodes[newIndex].data = data;
        nodes[newIndex].next = head;   // New node points to old head
        head = newIndex;               // Update head
        size++;
        System.out.println(data + " inserted at beginning");
    }

    /**
     * Insert at the end
     */
    public void insertAtEnd(int data) {
        int newIndex = allocateNode();
        if (newIndex == -1) return;

        nodes[newIndex].data = data;
        nodes[newIndex].next = -1;

        if (head == -1) {              // List was empty
            head = newIndex;
        } else {
            // Traverse to find the last node
            int current = head;
            while (nodes[current].next != -1) {
                current = nodes[current].next;
            }
            nodes[current].next = newIndex;   // Link last node to new node
        }
        size++;
        System.out.println(data + " inserted at end");
    }

    /**
     * Insert at a specific position (1-based index)
     */
    public void insertAtPosition(int position, int data) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position!");
            return;
        }

        if (position == 1) {
            insertAtBeginning(data);
            return;
        }

        int newIndex = allocateNode();
        if (newIndex == -1) return;

        nodes[newIndex].data = data;

        int current = head;
        for (int i = 1; i < position - 1; i++) {
            current = nodes[current].next;
        }

        nodes[newIndex].next = nodes[current].next;
        nodes[current].next = newIndex;
        size++;
        System.out.println(data + " inserted at position " + position);
    }

    /**
     * Delete from beginning
     */
    public int deleteFromBeginning() {
        if (head == -1) {
            System.out.println("List is empty! Cannot delete");
            return -1;
        }

        int deletedData = nodes[head].data;
        int temp = head;
        head = nodes[head].next;
        freeNode(temp);
        size--;
        System.out.println(deletedData + " deleted from beginning");
        return deletedData;
    }

    /**
     * Delete from end
     */
    public int deleteFromEnd() {
        if (head == -1) {
            System.out.println("List is empty!");
            return -1;
        }

        if (nodes[head].next == -1) {   // Only one node
            return deleteFromBeginning();
        }

        int current = head;
        while (nodes[nodes[current].next].next != -1) {
            current = nodes[current].next;
        }

        int deletedData = nodes[nodes[current].next].data;
        int temp = nodes[current].next;
        nodes[current].next = -1;
        freeNode(temp);
        size--;
        System.out.println(deletedData + " deleted from end");
        return deletedData;
    }

    /**
     * Search for an element and return its position (1-based)
     */
    public int search(int key) {
        int current = head;
        int position = 1;
        while (current != -1) {
            if (nodes[current].data == key) {
                return position;
            }
            current = nodes[current].next;
            position++;
        }
        return -1;   // Not found
    }

    /**
     * Display the entire linked list
     */
    public void display() {
        if (head == -1) {
            System.out.println("Array Linked List is empty");
            return;
        }

        System.out.print("Array Linked List: ");
        int current = head;
        while (current != -1) {
            System.out.print(nodes[current].data + " -> ");
            current = nodes[current].next;
        }
        System.out.println("null");
        System.out.println("Current size: " + size + " / Capacity: " + capacity);
    }

    // Getter methods for demonstration
    public boolean isEmpty() {
        return head == -1;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    /**
     * Main method - Test the Array-based Linked List
     */
    public static void main(String[] args) {
        System.out.println("=== ARRAY-BASED LINKED LIST DEMO ===\n");

        ArrayLinkedList list = new ArrayLinkedList(10);  // Capacity of 10 nodes

        list.insertAtBeginning(30);
        list.insertAtBeginning(20);
        list.insertAtBeginning(10);
        list.display();

        list.insertAtEnd(40);
        list.insertAtEnd(50);
        list.display();

        list.insertAtPosition(3, 25);
        list.display();

        System.out.println("Position of 25: " + list.search(25));

        list.deleteFromBeginning();
        list.display();

        list.deleteFromEnd();
        list.display();

        System.out.println("\nArray Linked List demonstration completed!");
        System.out.println("This shows how a linked list can be simulated using only an array.");
    }
}