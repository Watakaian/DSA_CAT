public class ArrayBasedDataStructures {

    /**
     * (a) STACK using fixed-size array - LIFO (Last In, First Out)
     * Key idea: Use a 'top' index that starts at -1 (empty).
     * Push increases top, pop decreases it.
     * Simple and O(1) time for all operations.
     */
    static class ArrayStack {
        private int[] stack;     // Array to hold stack elements
        private int top;         // Index of the top element
        private int capacity;    // Maximum size of the stack

        // Constructor: Initialize empty stack with given capacity
        public ArrayStack(int capacity) {
            this.capacity = capacity;
            this.stack = new int[capacity];
            this.top = -1;       // Empty stack indicator
        }

        // Push: Add element to the top
        public void push(int item) {
            if (isFull()) {
                System.out.println("Stack Overflow! Cannot push " + item);
                return;
            }
            stack[++top] = item; // Increment top then insert
            System.out.println(item + " pushed into stack");
        }

        // Pop: Remove and return top element
        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack Underflow! Cannot pop");
                return -1;
            }
            int item = stack[top--]; // Take value then decrement top
            System.out.println(item + " popped from stack");
            return item;
        }

        // Peek: View top element without removing it
        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return stack[top];
        }

        // Check if stack is empty
        public boolean isEmpty() {
            return top == -1;
        }

        // Check if stack is full
        public boolean isFull() {
            return top == capacity - 1;
        }

        // Display current elements (bottom to top)
        public void display() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return;
            }
            System.out.print("Stack elements (bottom -> top): ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }

    /**
     * (b) SINGLE/LINEAR QUEUE using fixed-size array - FIFO (First In, First Out)
     * Key idea: front pointer for removal, rear pointer for insertion.
     * rear == capacity means full (space before front is wasted after dequeues).
     * This shows the classic limitation of linear queues.
     */
    static class ArrayQueue {
        private int[] queue;     // Array to hold queue elements
        private int front, rear; // Pointers for front and next available slot
        private int capacity;

        // Constructor: Initialize empty linear queue
        public ArrayQueue(int capacity) {
            this.capacity = capacity;
            this.queue = new int[capacity];
            this.front = 0;
            this.rear = 0;       // rear points to next insertion position
        }

        // Enqueue: Add element at rear
        public void enqueue(int item) {
            if (isFull()) {
                System.out.println("Linear Queue is full! Cannot enqueue " + item);
                return;
            }
            queue[rear++] = item; // Insert then move rear forward
            System.out.println(item + " enqueued into linear queue");
        }

        // Dequeue: Remove element from front
        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Linear Queue is empty! Cannot dequeue");
                return -1;
            }
            int item = queue[front++];
            System.out.println(item + " dequeued from linear queue");
            return item;
        }

        // Peek: View front element without removing
        public int peek() {
            if (isEmpty()) {
                System.out.println("Linear Queue is empty");
                return -1;
            }
            return queue[front];
        }

        // Check if empty
        public boolean isEmpty() {
            return front == rear;
        }

        // Check if full (rear reached end of array)
        public boolean isFull() {
            return rear == capacity;
        }

        // Display current elements (front to rear)
        public void display() {
            if (isEmpty()) {
                System.out.println("Linear Queue is empty");
                return;
            }
            System.out.print("Linear Queue elements (front -> rear): ");
            for (int i = front; i < rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
            System.out.println("   Note: Space before 'front' is wasted (linear queue limitation).");
        }
    }

    /**
     * (b) CIRCULAR QUEUE using fixed-size array - FIFO with wrap-around
     * Key idea: Use modulo (%) operator so rear/front wrap around to start of array.
     * 'size' variable tracks count of elements to distinguish empty vs full.
     * Solves the space wastage problem of linear queue.
     */
    static class CircularQueue {
        private int[] queue;
        private int front, rear, capacity, size;

        // Constructor: Initialize empty circular queue
        public CircularQueue(int capacity) {
            this.capacity = capacity;
            this.queue = new int[capacity];
            this.front = 0;
            this.rear = 0;
            this.size = 0;
        }

        // Enqueue: Add element at rear with wrap-around
        public void enqueue(int item) {
            if (isFull()) {
                System.out.println("Circular Queue is full! Cannot enqueue " + item);
                return;
            }
            queue[rear] = item;
            rear = (rear + 1) % capacity; // Wrap around using modulo
            size++;
            System.out.println(item + " enqueued into circular queue");
        }

        // Dequeue: Remove element from front with wrap-around
        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Circular Queue is empty! Cannot dequeue");
                return -1;
            }
            int item = queue[front];
            front = (front + 1) % capacity; // Wrap around
            size--;
            System.out.println(item + " dequeued from circular queue");
            return item;
        }

        // Peek: View front element
        public int peek() {
            if (isEmpty()) {
                System.out.println("Circular Queue is empty");
                return -1;
            }
            return queue[front];
        }

        // Check if empty
        public boolean isEmpty() {
            return size == 0;
        }

        // Check if full
        public boolean isFull() {
            return size == capacity;
        }

        // Display current elements (handles wrap-around)
        public void display() {
            if (isEmpty()) {
                System.out.println("Circular Queue is empty");
                return;
            }
            System.out.print("Circular Queue elements: ");
            int index = front;
            for (int i = 0; i < size; i++) {
                System.out.print(queue[index] + " ");
                index = (index + 1) % capacity;
            }
            System.out.println();
        }
    }

    /**
     * (b) PRIORITY QUEUE using fixed-size array (simple unsorted version)
     * Key idea: Enqueue just adds to end. Dequeue/peek finds highest priority (largest value)
     * by scanning the array, then shifts elements to remove it.
     * Not FIFO - order based on priority value. O(n) for dequeue/peek but very simple.
     */
    static class ArrayPriorityQueue {
        private int[] queue;
        private int capacity, size;

        // Constructor: Initialize empty priority queue
        public ArrayPriorityQueue(int capacity) {
            this.capacity = capacity;
            this.queue = new int[capacity];
            this.size = 0;
        }

        // Enqueue: Simply add to end (no sorting)
        public void enqueue(int item) {
            if (isFull()) {
                System.out.println("Priority Queue is full! Cannot enqueue " + item);
                return;
            }
            queue[size++] = item;
            System.out.println(item + " enqueued into priority queue (higher number = higher priority)");
        }

        // Dequeue: Find and remove highest priority element (largest value)
        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Priority Queue is empty! Cannot dequeue");
                return -1;
            }
            // Find index of maximum value (highest priority)
            int maxIndex = 0;
            for (int i = 1; i < size; i++) {
                if (queue[i] > queue[maxIndex]) {
                    maxIndex = i;
                }
            }
            int item = queue[maxIndex];
            // Shift remaining elements left to fill the gap
            for (int i = maxIndex; i < size - 1; i++) {
                queue[i] = queue[i + 1];
            }
            size--;
            System.out.println(item + " dequeued from priority queue (highest priority)");
            return item;
        }

        // Peek: View highest priority without removing
        public int peek() {
            if (isEmpty()) {
                System.out.println("Priority Queue is empty");
                return -1;
            }
            int maxIndex = 0;
            for (int i = 1; i < size; i++) {
                if (queue[i] > queue[maxIndex]) {
                    maxIndex = i;
                }
            }
            return queue[maxIndex];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }

        // Display current elements (unsorted)
        public void display() {
            if (isEmpty()) {
                System.out.println("Priority Queue is empty");
                return;
            }
            System.out.print("Priority Queue elements: ");
            for (int i = 0; i < size; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println(" (Note: Not sorted - highest value is dequeued first)");
        }
    }

    /**
     * Main method - Demo all data structures with sample operations
     * Run this to test everything works.
     * You can modify capacities or add more operations for your presentation.
     */
    public static void main(String[] args) {
        System.out.println("=== ARRAY-BASED DATA STRUCTURES DEMO (Undergraduate DSA) ===\n");

        // Stack demo
        System.out.println("1. STACK DEMO:");
        ArrayStack stack = new ArrayStack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();
        System.out.println("Peek: " + stack.peek());
        stack.pop();
        stack.display();

        // Linear Queue demo (shows space waste)
        System.out.println("\n2. LINEAR QUEUE DEMO:");
        ArrayQueue linearQ = new ArrayQueue(5);
        linearQ.enqueue(1);
        linearQ.enqueue(2);
        linearQ.enqueue(3);
        linearQ.enqueue(4);
        linearQ.enqueue(5);
        linearQ.display();
        linearQ.dequeue();
        linearQ.dequeue();
        linearQ.display();
        linearQ.enqueue(6); // Should say full even though space exists at front
        linearQ.display();

        // Circular Queue demo (shows space reuse)
        System.out.println("\n3. CIRCULAR QUEUE DEMO:");
        CircularQueue circularQ = new CircularQueue(5);
        circularQ.enqueue(100);
        circularQ.enqueue(200);
        circularQ.enqueue(300);
        circularQ.display();
        circularQ.dequeue();
        circularQ.dequeue();
        circularQ.enqueue(400); // Reuses space!
        circularQ.enqueue(500);
        circularQ.display();

        // Priority Queue demo
        System.out.println("\n4. PRIORITY QUEUE DEMO:");
        ArrayPriorityQueue pq = new ArrayPriorityQueue(5);
        pq.enqueue(5);
        pq.enqueue(15);
        pq.enqueue(3);
        pq.enqueue(20);
        pq.enqueue(10);
        pq.display();
        System.out.println("Peek highest: " + pq.peek());
        pq.dequeue(); // Should remove 20 (highest)
        pq.display();

        System.out.println("\nDemo complete! All operations implemented using arrays.");
    }
}