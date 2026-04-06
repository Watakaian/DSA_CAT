class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListBasedDataStructures {

    static class LinkedStack {
        private Node top;        // Head of the list (top of stack)
        private int size;

        public LinkedStack() {
            this.top = null;
            this.size = 0;
        }

        public void push(int item) {
            Node newNode = new Node(item);
            newNode.next = top;
            top = newNode;
            size++;
            System.out.println(item + " pushed into stack");
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack Underflow! Cannot pop");
                return -1;
            }
            int item = top.data;
            top = top.next;      // Move top to next node
            size--;
            System.out.println(item + " popped from stack");
            return item;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return top.data;
        }

        public boolean isEmpty() {
            return top == null;
        }

        public int getSize() {
            return size;
        }

        // Display stack from top to bottom
        public void display() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return;
            }
            System.out.print("Stack (Top to Bottom): ");
            Node current = top;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }


    static class LinkedQueue {
        private Node front, rear;
        private int size;

        public LinkedQueue() {
            this.front = null;
            this.rear = null;
            this.size = 0;
        }

        public void enqueue(int item) {
            Node newNode = new Node(item);
            if (isEmpty()) {
                front = rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
            size++;
            System.out.println(item + " enqueued into linear queue");
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Linear Queue is empty! Cannot dequeue");
                return -1;
            }
            int item = front.data;
            front = front.next;
            if (front == null) {
                rear = null;     // Queue becomes empty
            }
            size--;
            System.out.println(item + " dequeued from linear queue");
            return item;
        }

        // Peek front element
        public int peek() {
            if (isEmpty()) {
                System.out.println("Linear Queue is empty");
                return -1;
            }
            return front.data;
        }

        public boolean isEmpty() {
            return front == null;
        }

        public int getSize() {
            return size;
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Linear Queue is empty");
                return;
            }
            System.out.print("Linear Queue (Front to Rear): ");
            Node current = front;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    static class LinkedCircularQueue {
        private Node front, rear;
        private int size;

        public LinkedCircularQueue() {
            this.front = null;
            this.rear = null;
            this.size = 0;
        }

        // Add at rear and make rear.next = front
        public void enqueue(int item) {
            Node newNode = new Node(item);
            if (isEmpty()) {
                front = rear = newNode;
                rear.next = front;        // Point back to front (circular)
            } else {
                rear.next = newNode;
                rear = newNode;
                rear.next = front;        // Maintain circular link
            }
            size++;
            System.out.println(item + " enqueued into circular queue");
        }

        // Remove from front and update rear.next
        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Circular Queue is empty! Cannot dequeue");
                return -1;
            }
            int item = front.data;

            if (front == rear) {          // Only one element
                front = rear = null;
            } else {
                front = front.next;
                rear.next = front;        // Update circular link
            }
            size--;
            System.out.println(item + " dequeued from circular queue");
            return item;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Circular Queue is empty");
                return -1;
            }
            return front.data;
        }

        public boolean isEmpty() {
            return front == null;
        }

        public int getSize() {
            return size;
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Circular Queue is empty");
                return;
            }
            System.out.print("Circular Queue: ");
            Node current = front;
            do {
                System.out.print(current.data + " ");
                current = current.next;
            } while (current != front);
            System.out.println();
        }
    }


    static class LinkedPriorityQueue {
        private Node front;
        private int size;

        public LinkedPriorityQueue() {
            this.front = null;
            this.size = 0;
        }

        // Insert in sorted position (descending order)
        public void enqueue(int item) {
            Node newNode = new Node(item);

            // Empty or new item has highest priority
            if (isEmpty() || item > front.data) {
                newNode.next = front;
                front = newNode;
            } else {
                Node current = front;
                // Find position where next node has lower priority
                while (current.next != null && current.next.data >= item) {
                    current = current.next;
                }
                newNode.next = current.next;
                current.next = newNode;
            }
            size++;
            System.out.println(item + " enqueued into priority queue (higher number = higher priority)");
        }

        // Remove highest priority (front of list)
        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Priority Queue is empty! Cannot dequeue");
                return -1;
            }
            int item = front.data;
            front = front.next;
            size--;
            System.out.println(item + " dequeued from priority queue (highest priority)");
            return item;
        }

        // Peek highest priority
        public int peek() {
            if (isEmpty()) {
                System.out.println("Priority Queue is empty");
                return -1;
            }
            return front.data;
        }

        public boolean isEmpty() {
            return front == null;
        }

        public int getSize() {
            return size;
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Priority Queue is empty");
                return;
            }
            System.out.print("Priority Queue (Highest -> Lowest priority): ");
            Node current = front;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    /**
     * Main method - Demonstration of all linked list implementations
     */
    public static void main(String[] args) {
        System.out.println("LINKED LIST BASED DATA STRUCTURES\n");
        System.out.println("---------------------------------\n");

        // 1. Stack Demo
        System.out.println("1. LINKED STACK:");
        LinkedStack stack = new LinkedStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();
        System.out.println("Peek: " + stack.peek());
        stack.pop();
        stack.display();

        // 2. Linear Queue Demo
        System.out.println("\n2. LINKED LINEAR:");
        LinkedQueue linearQ = new LinkedQueue();
        linearQ.enqueue(1);
        linearQ.enqueue(2);
        linearQ.enqueue(3);
        linearQ.display();
        linearQ.dequeue();
        linearQ.dequeue();
        linearQ.enqueue(4);
        linearQ.display();

        // 3. Circular Queue Demo
        System.out.println("\n3. LINKED CIRCULAR QUEUE:");
        LinkedCircularQueue circularQ = new LinkedCircularQueue();
        circularQ.enqueue(100);
        circularQ.enqueue(200);
        circularQ.enqueue(300);
        circularQ.display();
        circularQ.dequeue();
        circularQ.enqueue(400);
        circularQ.display();

        // 4. Priority Queue Demo
        System.out.println("\n4. LINKED PRIORITY QUEUE:");
        LinkedPriorityQueue pq = new LinkedPriorityQueue();
        pq.enqueue(5);
        pq.enqueue(15);
        pq.enqueue(3);
        pq.enqueue(20);
        pq.enqueue(10);
        pq.display();
        System.out.println("Peek highest: " + pq.peek());
        pq.dequeue();   
        pq.display();

        System.out.println("\nAll linked list implementations completed successfully!");
    }
}