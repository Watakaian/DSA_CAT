public class ArrayStack {
    private int[] stack;     // Array to hold stack elements
    private int top;         // Index of the top element
    private int capacity;    // Maximum size of the stack

    // empty stack with capacity provided when creating stack
    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.stack = new int[capacity];
        this.top = -1;       // Empty stack
    }

    public void push(int item) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push " + item);
            return;
        }
        stack[++top] = item; // Increment top then insert
        System.out.println(item + " pushed into stack");
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Cannot pop");
            return -1;
        }
        int item = stack[top--]; // Take value then decrement top
        System.out.println(item + " popped from stack");
        return item;
    }

    // Viewing of top element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    // Display current elements (bottom to top)
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack elements (bottom to top): ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
}