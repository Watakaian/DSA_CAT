package com.nesh.dsa.scratch;

public class ArrayCircularQueue {
    private int[] queue;
    private int front, rear, capacity, size;

    public ArrayCircularQueue(int capacity) {
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