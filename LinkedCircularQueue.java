public class LinkedCircularQueue {
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