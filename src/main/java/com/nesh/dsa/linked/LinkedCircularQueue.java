package com.nesh.dsa.linked;

public class LinkedCircularQueue {
    private Node front, rear;

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (front == null) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        rear.next = front; // The "Circular" link
        System.out.println(data + " enqueued to Linked Circular Queue");
    }

    public void dequeue() {
        if (front == null) {
            System.out.println("Queue Empty");
            return;
        }
        if (front == rear) {
            System.out.println(front.data + " dequeued");
            front = rear = null;
        } else {
            System.out.println(front.data + " dequeued");
            front = front.next;
            rear.next = front;
        }
    }

    public void display() {
        if (front == null) return;
        Node temp = front;
        System.out.print("Linked Circular Queue: ");
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != front);
        System.out.println();
    }
}