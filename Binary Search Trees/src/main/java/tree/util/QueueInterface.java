package tree.util;

/*
 * Copyright (c) $originalComment.match("Copyright \(c\) (\d+)", 1, "-")$today.year.
 *
 * OZ1SQT, Michel S. E. Sommer
 * https://Seahawk.dk
 */

public interface QueueInterface<T> {
    void enqueue(T element);
    T dequeue();
    T first();
    int size();
    boolean isEmpty();
    int indexOf(T element);
    boolean contains(T element);
}