public class ArrayBasedDataStructures {

    static class ArrayStack {
        private int[] stack;     // Array to hold stack elements
        private int top;         // Index of the top element
        private int capacity;    // Maximum size of the stack

        // empty stack with capacity provided when creating stack
        public ArrayStack(int capacity) {
            this.capacity = capacity;
            this.stack = new int[capacity];
            this.top = -1;       // Empty stack
        }

        public void push(int item) {
            if (isFull()) {
                System.out.println("Stack Overflow! Cannot push " + item);
                return;
            }
            stack[++top] = item; // Increment top then insert
            System.out.println(item + " pushed into stack");
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack Underflow! Cannot pop");
                return -1;
            }
            int item = stack[top--]; // Take value then decrement top
            System.out.println(item + " popped from stack");
            return item;
        }

        // Viewing of top element without removing it
        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return stack[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == capacity - 1;
        }

        // Display current elements (bottom to top)
        public void display() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return;
            }
            System.out.print("Stack elements (bottom to top): ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }

    static class ArrayQueue {
        private int[] queue;     // Array to hold queue elements
        private int front, rear; // Pointers for front and next available slot
        private int capacity;

        public ArrayQueue(int capacity) {
            this.capacity = capacity;
            this.queue = new int[capacity];
            this.front = 0;
            this.rear = 0;       // rear points to next insertion position
        }

        public void enqueue(int item) {
            if (isFull()) {
                System.out.println("Linear Queue is full! Cannot enqueue " + item);
                return;
            }
            queue[rear++] = item; // Insert then move rear forward
            System.out.println(item + " enqueued into linear queue");
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Linear Queue is empty! Cannot dequeue");
                return -1;
            }
            int item = queue[front++];
            System.out.println(item + " dequeued from linear queue");
            return item;
        }

        // View front element without removing it
        public int peek() {
            if (isEmpty()) {
                System.out.println("Linear Queue is empty");
                return -1;
            }
            return queue[front];
        }

        public boolean isEmpty() {
            return front == rear;
        }

        public boolean isFull() {
            return rear == capacity;
        }

        // Display current elements (front to rear)
        public void display() {
            if (isEmpty()) {
                System.out.println("Linear Queue is empty");
                return;
            }
            System.out.print("Linear Queue elements (front to rear): ");
            for (int i = front; i < rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }

    static class CircularQueue {
        private int[] queue;
        private int front, rear, capacity, size;

        public CircularQueue(int capacity) {
            this.capacity = capacity;
            this.queue = new int[capacity];
            this.front = 0;
            this.rear = 0;
            this.size = 0;
        }

        public void enqueue(int item) {
            if (isFull()) {
                System.out.println("Circular Queue is full, Cannot enqueue " + item);
                return;
            }
            queue[rear] = item;
            rear = (rear + 1) % capacity; 
            size++;
            System.out.println(item + " enqueued into circular queue");
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Circular Queue is empty, Cannot dequeue");
                return -1;
            }
            int item = queue[front];
            front = (front + 1) % capacity; 
            size--;
            System.out.println(item + " dequeued from circular queue");
            return item;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Circular Queue is empty");
                return -1;
            }
            return queue[front];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }

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

    static class ArrayPriorityQueue {
        private int[] queue;
        private int capacity, size;

        public ArrayPriorityQueue(int capacity) {
            this.capacity = capacity;
            this.queue = new int[capacity];
            this.size = 0;
        }

        public void enqueue(int item) {
            if (isFull()) {
                System.out.println("Priority Queue is full! Cannot enqueue " + item);
                return;
            }
            queue[size++] = item;
            System.out.println(item + " enqueued into priority queue (higher number = higher priority)");
        }

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

        // Viewing of highest priority no. without removing
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


    public static void main(String[] args) {
        System.out.println("ARRAY-BASED DATA STRUCTURES");
        System.out.println("---------------------------");

        // Stack demo
        System.out.println("1. STACK:");
        ArrayStack stack = new ArrayStack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();
        System.out.println("Peek: " + stack.peek());
        stack.pop();
        stack.display();

        System.out.println("\n2. SIMPLE QUEUE:");
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
        linearQ.enqueue(6); 
        linearQ.display();

        System.out.println("\n3. CIRCULAR QUEUE:");
        CircularQueue circularQ = new CircularQueue(5);
        circularQ.enqueue(100);
        circularQ.enqueue(200);
        circularQ.enqueue(300);
        circularQ.display();
        circularQ.dequeue();
        circularQ.dequeue();
        circularQ.enqueue(400);
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
        pq.dequeue();
        pq.display();

    }
}