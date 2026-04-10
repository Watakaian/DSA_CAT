import java.util.Scanner;

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
            System.out.println("3. Array-Based Linked List");
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
                case 1:
                    stackDemo(true);
                    break;
                case 2:
                    queueDemo(true);
                    break;
                case 3:
                    circularQueueDemo(true);
                    break;
                case 4:
                    priorityQueueDemo(true);
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
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
                case 1:
                    stackDemo(false);
                    break;
                case 2:
                    queueDemo(false);
                    break;
                case 3:
                    circularQueueDemo(false);
                    break;
                case 4:
                    priorityQueueDemo(false);
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void stackDemo(boolean isArrayBased) {
        System.out.print("Enter stack capacity: ");
        int capacity = getIntInput();
        
        Object stack;
        if (isArrayBased) {
            stack = new ArrayBasedDataStructures.ArrayStack(capacity);
        } else {
            stack = new LinkedListBasedDataStructures.LinkedStack();
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
                    int pushVal = getIntInput();
                    if (isArrayBased) ((ArrayBasedDataStructures.ArrayStack)stack).push(pushVal);
                    else ((LinkedListBasedDataStructures.LinkedStack)stack).push(pushVal);
                    break;
                case 2:
                    if (isArrayBased) ((ArrayBasedDataStructures.ArrayStack)stack).pop();
                    else ((LinkedListBasedDataStructures.LinkedStack)stack).pop();
                    break;
                case 3:
                    int peekVal = isArrayBased ? ((ArrayBasedDataStructures.ArrayStack)stack).peek() : ((LinkedListBasedDataStructures.LinkedStack)stack).peek();
                    if (peekVal != -1) System.out.println("Top element: " + peekVal);
                    break;
                case 4:
                    if (isArrayBased) ((ArrayBasedDataStructures.ArrayStack)stack).display();
                    else ((LinkedListBasedDataStructures.LinkedStack)stack).display();
                    break;
                case 0:
                    back = true;
                    break;
            }
        }
    }

    private static void queueDemo(boolean isArrayBased) {
        System.out.print("Enter queue capacity: ");
        int capacity = getIntInput();
        
        Object queue;
        if (isArrayBased) {
            queue = new ArrayBasedDataStructures.ArrayQueue(capacity);
        } else {
            queue = new LinkedListBasedDataStructures.LinkedQueue();
        }

        boolean back = false;
        while (!back) {
            System.out.println("\n--- LINEAR QUEUE OPERATIONS (" + (isArrayBased ? "Array" : "Linked") + ") ---");
            System.out.println("1. Enqueue (Add Item)");
            System.out.println("2. Dequeue (Remove Item)");
            System.out.println("3. Peek (View Front)");
            System.out.println("4. Display All");
            System.out.println("0. Back");
            System.out.print("Select: ");

            int choice = getIntInput();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    int val = getIntInput();
                    if (isArrayBased) ((ArrayBasedDataStructures.ArrayQueue)queue).enqueue(val);
                    else ((LinkedListBasedDataStructures.LinkedQueue)queue).enqueue(val);
                    break;
                case 2:
                    if (isArrayBased) ((ArrayBasedDataStructures.ArrayQueue)queue).dequeue();
                    else ((LinkedListBasedDataStructures.LinkedQueue)queue).dequeue();
                    break;
                case 3:
                    int peekVal = isArrayBased ? ((ArrayBasedDataStructures.ArrayQueue)queue).peek() : ((LinkedListBasedDataStructures.LinkedQueue)queue).peek();
                    if (peekVal != -1) System.out.println("Front element: " + peekVal);
                    break;
                case 4:
                    if (isArrayBased) ((ArrayBasedDataStructures.ArrayQueue)queue).display();
                    else ((LinkedListBasedDataStructures.LinkedQueue)queue).display();
                    break;
                case 0:
                    back = true;
                    break;
            }
        }
    }

    private static void circularQueueDemo(boolean isArrayBased) {
        System.out.print("Enter circular queue capacity: ");
        int capacity = getIntInput();
        
        Object queue;
        if (isArrayBased) {
            queue = new ArrayBasedDataStructures.CircularQueue(capacity);
        } else {
            queue = new LinkedListBasedDataStructures.LinkedCircularQueue();
        }

        boolean back = false;
        while (!back) {
            System.out.println("\n--- CIRCULAR QUEUE OPERATIONS (" + (isArrayBased ? "Array" : "Linked") + ") ---");
            System.out.println("1. Enqueue (Add Item)");
            System.out.println("2. Dequeue (Remove Item)");
            System.out.println("3. Peek (View Front)");
            System.out.println("4. Display All");
            System.out.println("0. Back");
            System.out.print("Select: ");

            int choice = getIntInput();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    int val = getIntInput();
                    if (isArrayBased) ((ArrayBasedDataStructures.CircularQueue)queue).enqueue(val);
                    else ((LinkedListBasedDataStructures.LinkedCircularQueue)queue).enqueue(val);
                    break;
                case 2:
                    if (isArrayBased) ((ArrayBasedDataStructures.CircularQueue)queue).dequeue();
                    else ((LinkedListBasedDataStructures.LinkedCircularQueue)queue).dequeue();
                    break;
                case 3:
                    int peekVal = isArrayBased ? ((ArrayBasedDataStructures.CircularQueue)queue).peek() : ((LinkedListBasedDataStructures.LinkedCircularQueue)queue).peek();
                    if (peekVal != -1) System.out.println("Front element: " + peekVal);
                    break;
                case 4:
                    if (isArrayBased) ((ArrayBasedDataStructures.CircularQueue)queue).display();
                    else ((LinkedListBasedDataStructures.LinkedCircularQueue)queue).display();
                    break;
                case 0:
                    back = true;
                    break;
            }
        }
    }

    private static void priorityQueueDemo(boolean isArrayBased) {
        System.out.print("Enter priority queue capacity: ");
        int capacity = getIntInput();
        
        Object queue;
        if (isArrayBased) {
            queue = new ArrayBasedDataStructures.ArrayPriorityQueue(capacity);
        } else {
            queue = new LinkedListBasedDataStructures.LinkedPriorityQueue();
        }

        boolean back = false;
        while (!back) {
            System.out.println("\n--- PRIORITY QUEUE OPERATIONS (" + (isArrayBased ? "Array" : "Linked") + ") ---");
            System.out.println("1. Enqueue (Add Item)");
            System.out.println("2. Dequeue (Remove Highest Priority)");
            System.out.println("3. Peek (View Highest Priority)");
            System.out.println("4. Display All");
            System.out.println("0. Back");
            System.out.print("Select: ");

            int choice = getIntInput();
            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    int val = getIntInput();
                    if (isArrayBased) ((ArrayBasedDataStructures.ArrayPriorityQueue)queue).enqueue(val);
                    else ((LinkedListBasedDataStructures.LinkedPriorityQueue)queue).enqueue(val);
                    break;
                case 2:
                    if (isArrayBased) ((ArrayBasedDataStructures.ArrayPriorityQueue)queue).dequeue();
                    else ((LinkedListBasedDataStructures.LinkedPriorityQueue)queue).dequeue();
                    break;
                case 3:
                    int peekVal = isArrayBased ? ((ArrayBasedDataStructures.ArrayPriorityQueue)queue).peek() : ((LinkedListBasedDataStructures.LinkedPriorityQueue)queue).peek();
                    if (peekVal != -1) System.out.println("Highest priority: " + peekVal);
                    break;
                case 4:
                    if (isArrayBased) ((ArrayBasedDataStructures.ArrayPriorityQueue)queue).display();
                    else ((LinkedListBasedDataStructures.LinkedPriorityQueue)queue).display();
                    break;
                case 0:
                    back = true;
                    break;
            }
        }
    }

    private static void arrayLinkedListDemo() {
        System.out.print("Enter list capacity: ");
        int capacity = getIntInput();
        ArrayLinkedList list = new ArrayLinkedList(capacity);

        boolean back = false;
        while (!back) {
            System.out.println("\n--- ARRAY LINKED LIST OPERATIONS ---");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete from Beginning");
            System.out.println("5. Delete from End");
            System.out.println("6. Search");
            System.out.println("7. Display");
            System.out.println("0. Back");
            System.out.print("Select: ");

            int choice = getIntInput();
            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    list.insertAtBeginning(getIntInput());
                    break;
                case 2:
                    System.out.print("Enter value: ");
                    list.insertAtEnd(getIntInput());
                    break;
                case 3:
                    System.out.print("Position: ");
                    int pos = getIntInput();
                    System.out.print("Value: ");
                    list.insertAtPosition(pos, getIntInput());
                    break;
                case 4:
                    list.deleteFromBeginning();
                    break;
                case 5:
                    list.deleteFromEnd();
                    break;
                case 6:
                    System.out.print("Enter value to search: ");
                    int sVal = getIntInput();
                    int sPos = list.search(sVal);
                    if (sPos != -1) System.out.println("Found at position " + sPos);
                    else System.out.println("Not found.");
                    break;
                case 7:
                    list.display();
                    break;
                case 0:
                    back = true;
                    break;
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
