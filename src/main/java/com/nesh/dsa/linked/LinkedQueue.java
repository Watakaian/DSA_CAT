package com.nesh.dsa.linked;

public class LinkedQueue {
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