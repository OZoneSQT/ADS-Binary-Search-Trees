package util;

import java.util.ArrayDeque;

public class StackLIFO<AnyType> implements StackInterface<AnyType> {
    private ArrayDeque<AnyType> stack;
    private int count;

    public StackLIFO() {
    }

    public void push(AnyType element) throws IllegalArgumentException, IllegalStateException {
        if(stack == null) {
            stack = new ArrayDeque<>();
        }

        if(element == null) {
            throw new IllegalArgumentException("Null is not allowed");
        }

        stack.addLast(element);
        count++;
    }

    public AnyType peek() {
        if(count == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        AnyType result = stack.peekLast();
        return result;
    }

    public AnyType pop() throws IllegalStateException {
        if(count == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        AnyType result = stack.pollLast();
        return result;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        boolean result = false;
        if (count == 0) {
            result = true;
        }
        return result;
    }

}
