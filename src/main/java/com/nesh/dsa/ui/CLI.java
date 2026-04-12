package com.nesh.dsa.ui;

import java.util.Scanner;
// These imports connect your UI to your new logic folders
import com.nesh.dsa.scratch.*; 
import com.nesh.dsa.linked.*;
import com.nesh.dsa.hybrid.*;

public class CLI {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("   DATA STRUCTURES HUB - TASK 2.15    ");
        System.out.println("======================================");

        boolean running = true;
        while (running) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Array-Based Data Structures");
            System.out.println("2. Linked-List-Based Data Structures");
            System.out.println("3. Array-Based Linked List (Hybrid)");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            int choice = getIntInput();
            switch (choice) {
                case 1:
                    arrayBasedMenu();
                    break;
                case 2:
                    linkedListBasedMenu();
                    break;
                case 3:
                    arrayLinkedListDemo();
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void arrayBasedMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- ARRAY-BASED DATA STRUCTURES ---");
            System.out.println("1. Stack");
            System.out.println("2. Linear Queue");
            System.out.println("3. Circular Queue");
            System.out.println("4. Priority Queue");
            System.out.println("0. Back to Main Menu");
            System.out.print("Select an option: ");

            int choice = getIntInput();
            switch (choice) {
                case 1: stackDemo(true); break;
                case 2: queueDemo(true); break;
                case 3: circularQueueDemo(true); break;
                case 4: priorityQueueDemo(true); break;
                case 0: back = true; break;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    private static void linkedListBasedMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- LINKED-LIST-BASED DATA STRUCTURES ---");
            System.out.println("1. Stack");
            System.out.println("2. Linear Queue");
            System.out.println("3. Circular Queue");
            System.out.println("4. Priority Queue");
            System.out.println("0. Back to Main Menu");
            System.out.print("Select an option: ");

            int choice = getIntInput();
            switch (choice) {
                case 1: stackDemo(false); break;
                case 2: queueDemo(false); break;
                case 3: circularQueueDemo(false); break;
                case 4: priorityQueueDemo(false); break;
                case 0: back = true; break;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    private static void stackDemo(boolean isArrayBased) {
        System.out.print("Enter stack capacity: ");
        int capacity = getIntInput();
        
        Object stack;
        if (isArrayBased) {
            stack = new ArrayStack(capacity);
        } else {
            stack = new LinkedStack();
        }

        boolean back = false;
        while (!back) {
            System.out.println("\n--- STACK OPERATIONS (" + (isArrayBased ? "Array" : "Linked") + ") ---");
            System.out.println("1. Push (Add Item)");
            System.out.println("2. Pop (Remove Item)");
            System.out.println("3. Peek (View Top)");
            System.out.println("4. Display All");
            System.out.println("0. Back");
            System.out.print("Select: ");

            int choice = getIntInput();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int v = getIntInput();
                    if (isArrayBased) ((ArrayStack)stack).push(v);
                    else ((LinkedStack)stack).push(v);
                    break;
                case 2:
                    if (isArrayBased) ((ArrayStack)stack).pop();
                    else ((LinkedStack)stack).pop();
                    break;
                case 3:
                    int pk = isArrayBased ? ((ArrayStack)stack).peek() : ((LinkedStack)stack).peek();
                    if (pk != -1) System.out.println("Top element: " + pk);
                    break;
                case 4:
                    if (isArrayBased) ((ArrayStack)stack).display();
                    else ((LinkedStack)stack).display();
                    break;
                case 0: back = true; break;
            }
        }
    }

    private static void queueDemo(boolean isArrayBased) {
        System.out.print("Enter queue capacity: ");
        int capacity = getIntInput();
        
        Object queue;
        if (isArrayBased) {
            queue = new ArrayQueue(capacity);
        } else {
            queue = new LinkedQueue();
        }

        boolean back = false;
        while (!back) {
            System.out.println("\n--- LINEAR QUEUE OPERATIONS (" + (isArrayBased ? "Array" : "Linked") + ") ---");
            System.out.println("1. Enqueue  2. Dequeue  3. Peek  4. Display  0. Back");
            int choice = getIntInput();
            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    int v = getIntInput();
                    if (isArrayBased) ((ArrayQueue)queue).enqueue(v);
                    else ((LinkedQueue)queue).enqueue(v);
                    break;
                case 2:
                    if (isArrayBased) ((ArrayQueue)queue).dequeue();
                    else ((LinkedQueue)queue).dequeue();
                    break;
                case 3:
                    int p = isArrayBased ? ((ArrayQueue)queue).peek() : ((LinkedQueue)queue).peek();
                    if (p != -1) System.out.println("Front: " + p);
                    break;
                case 4:
                    if (isArrayBased) ((ArrayQueue)queue).display();
                    else ((LinkedQueue)queue).display();
                    break;
                case 0: back = true; break;
            }
        }
    }

    private static void circularQueueDemo(boolean isArrayBased) {
        System.out.print("Enter circular queue capacity: ");
        int capacity = getIntInput();
        
        Object queue;
        if (isArrayBased) {
            queue = new ArrayCircularQueue(capacity);
        } else {
            queue = new LinkedCircularQueue();
        }

        boolean back = false;
        while (!back) {
            System.out.println("\n--- CIRCULAR QUEUE OPERATIONS (" + (isArrayBased ? "Array" : "Linked") + ") ---");
            System.out.println("1. Enqueue  2. Dequeue  3. Display  0. Back");
            int choice = getIntInput();
            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    int v = getIntInput();
                    if (isArrayBased) ((ArrayCircularQueue)queue).enqueue(v);
                    else ((LinkedCircularQueue)queue).enqueue(v);
                    break;
                case 2:
                    if (isArrayBased) ((ArrayCircularQueue)queue).dequeue();
                    else ((LinkedCircularQueue)queue).dequeue();
                    break;
                case 3:
                    if (isArrayBased) ((ArrayCircularQueue)queue).display();
                    else ((LinkedCircularQueue)queue).display();
                    break;
                case 0: back = true; break;
            }
        }
    }

    private static void priorityQueueDemo(boolean isArrayBased) {
        System.out.print("Enter priority queue capacity: ");
        int capacity = getIntInput();
        
        Object queue;
        if (isArrayBased) {
            queue = new ArrayPriorityQueue(capacity);
        } else {
            queue = new LinkedPriorityQueue();
        }

        boolean back = false;
        while (!back) {
            System.out.println("\n--- PRIORITY QUEUE OPERATIONS (" + (isArrayBased ? "Array" : "Linked") + ") ---");
            System.out.println("1. Enqueue  2. Dequeue  3. Peek  4. Display  0. Back");
            int choice = getIntInput();
            switch (choice) {
                case 1:
                    System.out.print("Value: ");
                    int v = getIntInput();
                    if (isArrayBased) ((ArrayPriorityQueue)queue).enqueue(v);
                    else ((LinkedPriorityQueue)queue).enqueue(v);
                    break;
                case 2:
                    if (isArrayBased) ((ArrayPriorityQueue)queue).dequeue();
                    else ((LinkedPriorityQueue)queue).dequeue();
                    break;
                case 3:
                    int pk = isArrayBased ? ((ArrayPriorityQueue)queue).peek() : ((LinkedPriorityQueue)queue).peek();
                    if (pk != -1) System.out.println("Priority: " + pk);
                    break;
                case 4:
                    if (isArrayBased) ((ArrayPriorityQueue)queue).display();
                    else ((LinkedPriorityQueue)queue).display();
                    break;
                case 0: back = true; break;
            }
        }
    }

    private static void arrayLinkedListDemo() {
        System.out.print("Enter list capacity: ");
        ArrayLinkedList list = new ArrayLinkedList(getIntInput());

        boolean back = false;
        while (!back) {
            System.out.println("\n--- ARRAY LINKED LIST OPERATIONS ---");
            System.out.println("1. Insert Start  2. Insert End  3. Display  0. Back");
            int choice = getIntInput();
            switch (choice) {
                case 1: list.insertAtBeginning(getIntInput()); break;
                case 2: list.insertAtEnd(getIntInput()); break;
                case 3: list.display(); break;
                case 0: back = true; break;
            }
        }
    }

    private static int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter an integer: ");
            }
        }
    }
}