package util;

public interface StackInterface<AnyType> {

    /**
     * Add element to stack
     * @param element
     */
    void push(AnyType element);

    /**
     * Preview last element added to stack
     * @return
     */
    AnyType peek();

    /**
     * Return and remove, last added element from stack
     * @return
     */
    AnyType pop();

    /**
     * Return size of stack
     * @return
     */
    int size();

    /**
     * Return the value true if stack is empty, else return false
     * @return
     */
    boolean isEmpty();

}
