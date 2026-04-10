public class LinkedPriorityQueue {
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