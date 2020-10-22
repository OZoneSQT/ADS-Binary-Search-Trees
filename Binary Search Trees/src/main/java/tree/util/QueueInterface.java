package tree.util;

public interface QueueInterface<T> {
    void enqueue(T element);
    T dequeue();
    T first();
    int size();
    boolean isEmpty();
    int indexOf(T element);
    boolean contains(T element);
}