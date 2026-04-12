package com.nesh.dsa.linked;

public class LinkedStack {
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