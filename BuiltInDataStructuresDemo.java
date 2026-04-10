import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class BuiltInDataStructuresDemo {

    public static void main(String[] args) {
        // 1. STACK 
        System.out.println("1. Using java.util.Stack (LIFO)");
        Stack<Integer> stack = new Stack<>();

        // Push operation
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Stack after pushes: " + stack);

        // Peek (view top element without removing)
        System.out.println("Top element (peek): " + stack.peek());

        // Pop operation
        System.out.println("Popped: " + stack.pop());
        System.out.println("Stack after pop: " + stack);

        // Check if empty
        System.out.println("Is stack empty? " + stack.isEmpty());
        System.out.println("Current size: " + stack.size());

        // Search (returns 1-based position from top)
        System.out.println("Position of 20 from top: " + stack.search(20));

        System.out.println("----------------------------------------\n");

        // 2. QUEUE (using LinkedList) 
        System.out.println("2. Using Queue Interface with LinkedList (FIFO)");
        Queue<Integer> queue = new LinkedList<>();

        // Enqueue (add elements at rear)
        queue.offer(100);   
        queue.offer(200);
        queue.offer(300);
        queue.offer(400);

        System.out.println("Queue after enqueues: " + queue);

        // Peek front element
        System.out.println("Front element (peek): " + queue.peek());

        // Dequeue (remove from front)
        System.out.println("Dequeued: " + queue.poll());
        System.out.println("Queue after dequeue: " + queue);

        System.out.println("Is queue empty? " + queue.isEmpty());
        System.out.println("Current size: " + queue.size());

        System.out.println("----------------------------------------\n");

        // 3. LINKEDLIST 
        System.out.println("3. Using java.util.LinkedList directly");
        LinkedList<String> list = new LinkedList<>();

        // Add elements (at end by default)
        list.add("Apple");
        list.add("Banana");
        list.add("Strawberry");
        list.add("Date");

        System.out.println("LinkedList: " + list);

        // Add at specific positions
        list.addFirst("Mango");           // Add at beginning
        list.addLast("Grapes");       // Add at end

        System.out.println("After addFirst and addLast: " + list);

        // Access by index (LinkedList is slow for random access)
        System.out.println("Element at index 2: " + list.get(2));

        // Remove operations
        System.out.println("Removed first: " + list.removeFirst());
        System.out.println("Removed last: " + list.removeLast());
        System.out.println("After removing first and last: " + list);

        // Remove specific element
        list.remove("Banana");
        System.out.println("After removing 'Banana': " + list);

        // Check containment
        System.out.println("Contains 'Grapes'? " + list.contains("Grapes"));

        // Iterate using for-each
        System.out.print("Iterating the list: ");
        for (String fruit : list) {
            System.out.print(fruit + " ");
        }
        System.out.println();

        // Clear the list
        list.clear();
        System.out.println("List after clear: " + list);
        System.out.println("Is list empty? " + list.isEmpty());

        System.out.println("----------------------------------------\n");

        // Simple Task Manager
        System.out.println("4. Practical Example - Undo/Redo using Stack + Task Queue");

        Stack<String> undoStack = new Stack<>();
        Queue<String> taskQueue = new LinkedList<>();

        // Add tasks to queue
        taskQueue.offer("Save file");
        taskQueue.offer("Print document");
        taskQueue.offer("Send email");

        System.out.println("Pending tasks: " + taskQueue);

        // Process tasks (FIFO)
        while (!taskQueue.isEmpty()) {
            String task = taskQueue.poll();
            System.out.println("Processing: " + task);
            undoStack.push(task);   // Save for undo
        }

        System.out.println("Undo stack (last done first): " + undoStack);

        // Undo last action
        if (!undoStack.isEmpty()) {
            System.out.println("Undoing: " + undoStack.pop());
        }

    }
}