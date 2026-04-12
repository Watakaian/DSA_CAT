package com.nesh.dsa.scratch;

public class ArrayQueue {
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