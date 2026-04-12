package com.nesh.dsa.linked;

public class LinkedPriorityQueue {
    private Node head;

    public void enqueue(int data) {
        Node newNode = new Node(data);
        // Insert in descending order for priority
        if (head == null || head.data < data) {
            newNode.next = head;
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null && temp.next.data >= data) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        System.out.println(data + " added to Linked Priority Queue");
    }

    public void dequeue() {
        if (head == null) return;
        System.out.println(head.data + " removed (highest priority)");
        head = head.next;
    }

    public int peek() {
        return (head != null) ? head.data : -1;
    }

    public void display() {
        Node temp = head;
        System.out.print("Priority Queue (High to Low): ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}