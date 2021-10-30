package tree.binarytree;

/*
 * Copyright (c) 2021
 *
 * OZ1SQT, Michel S. E. Sommer
 * https://Seahawk.dk
 */

public class BinaryTreeNode<AnyType> {
    private AnyType element;
    private BinaryTreeNode leftChild, rightChild;

    public BinaryTreeNode(AnyType element) {
        super();
        this.element = element;
        this.leftChild = null;
        this.rightChild = null;
    }

    /**
     * Store the element in the Node
     * @param newElement
     */
    public void setElement(AnyType newElement) {
        this.element = newElement;
    }

    /**
     * Returns the element from the Node
     * @return
     */
    /* public element getElement() => element = int */
    public AnyType getElement() {
        return element;
    }

    /**
     * Add a left child to the Node
     * @param leftChild
     */
    public void addLeftChild(final BinaryTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    /**
     * Add a right child to the Node
     * @param rightChild
     */
    public void addRightChild(BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
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
