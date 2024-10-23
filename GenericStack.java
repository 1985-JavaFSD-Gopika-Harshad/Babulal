package CodingQuestion;

import java.util.ArrayList;
import java.util.List;

public class GenericStack<T> {
    private List<T> stack;

    public GenericStack() {
        stack = new ArrayList<>();
    }

    // Adds an item to the top of the stack
    public void push(T item) {
        stack.add(item);
    }

    // Removes and returns the item at the top of the stack
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.remove(stack.size() - 1);
    }

    // Returns the item at the top of the stack without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.get(stack.size() - 1);
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // Returns the number of items in the stack
    public int size() {
        return stack.size();
    }

    public static void main(String[] args) {
        GenericStack<String> stringStack = new GenericStack<>();
        stringStack.push("Hello");
        stringStack.push("World");

        System.out.println("Top element: " + stringStack.peek()); // Should print "World"
        System.out.println("Stack size: " + stringStack.size());  // Should print 2

        System.out.println("Popped: " + stringStack.pop());       // Should print "World"
        System.out.println("Stack size after pop: " + stringStack.size()); // Should print 1
    }
}
