public class ArrayPriorityQueue {
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