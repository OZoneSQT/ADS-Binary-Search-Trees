package tree.util;

/*
 * Copyright (c) 2021
 *
 * OZ1SQT, Michel S. E. Sommer
 * https://Seahawk.dk
 */

public class QueueFIFO<AnyType> implements QueueInterface<AnyType> {

    private AnyType[] queue;
    private int  count;
    private int capacity;

    public QueueFIFO(int capacity) {
        this.capacity = capacity;
    }

    public void enqueue(AnyType element) throws IllegalArgumentException, IllegalStateException {
        if(queue == null) {
            queue = (AnyType[])(new Object[capacity]);
        }
        if(element == null) {
            throw new IllegalArgumentException("Null is not allowed");
        } else if(count == capacity) {
            throw new IllegalStateException("Queue is full");
        }
        queue[count] = element;
        count++;
    }

    public AnyType dequeue() throws IllegalStateException {
        if(count == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        AnyType genericQueue = queue[0];
        for (int i = 1; i < count; i++) {
            queue[i-1] = queue[i];
        }
        count--;
        return genericQueue;
    }

    public AnyType first() throws IllegalStateException {
        if(count == 0) throw new IllegalStateException("Queue is empty");
        return queue[0];
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int indexOf(AnyType element) {
        if(element == null) {
            for (int i = 0; i < count; i++) {
                if (queue[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < count; i++) {
                if (element.equals(queue[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean contains(AnyType element) {
        if(element == null) return false;
        for (AnyType t : queue) {
            if(element.equals(t)) return true;
        }
        return false;
    }
}
