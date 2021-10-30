package tree.util;

/*
 * Copyright (c) 2021
 *
 * OZ1SQT, Michel S. E. Sommer
 * https://Seahawk.dk
 */

public interface QueueInterface<AnyType> {
    void enqueue(AnyType element);
    AnyType dequeue();
    AnyType first();
    int size();
    boolean isEmpty();
    int indexOf(AnyType element);
    boolean contains(AnyType element);
}