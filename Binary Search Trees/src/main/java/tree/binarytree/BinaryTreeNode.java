package tree.binarytree;

/*
 * Copyright (c) 2021
 *
 * OZ1SQT, Michel S. E. Sommer
 * https://Seahawk.dk
 */

public class BinaryTreeNode<T> {
    private T element;
    private BinaryTreeNode leftChild, rightChild;

    public BinaryTreeNode(final T element) {
        super();
        this.element = element;
        this.leftChild = null;
        this.rightChild = null;
    }

    /**
     * Store the element in the Node
     * @param newElement
     */
    public T setElement(final T newElement) {
        if (element.equals(newElement)) {
            this.element = newElement;
        }
        return element;
    }

    /**
     * Returns the element from the Node
     * @return
     */
    /* public element getElement() => element = int */
    public T getElement() {
        return element;
    }

    /**
     * Add a left child to the Node
     * @param leftChild
     */
    public void addLeftChild(final BinaryTreeNode leftChild) {
        if (leftChild == null) {
            this.leftChild = null;
        } else if (!leftChild.equals(getLeftChild())) {
            this.leftChild = leftChild;
        }
    }

    /**
     * Add a right child to the Node
     * @param rightChild
     */
    public void addRightChild(final BinaryTreeNode rightChild) {
        if (rightChild == null) {
            this.rightChild = null;
        } else if (!rightChild.equals(getRightChild())) {
            this.rightChild = rightChild;
        }
    }

    /**
     * Returns a reference to the left child or null if there is no left child
     * @return
     */
    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }

    /***
     * Returns a reference to the right child or null if there is no right child
     * @return
     */
    public BinaryTreeNode getRightChild() {
        return rightChild;
    }

}
