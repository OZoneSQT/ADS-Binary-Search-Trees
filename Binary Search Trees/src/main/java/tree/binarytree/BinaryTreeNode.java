package tree.binarytree;

/*
 * Copyright (c) 2021
 *
 * OZ1SQT, Michel S. E. Sommer
 * https://Seahawk.dk
 */

import other.BinaryNode;

public class BinaryTreeNode<AnyType> {
    private AnyType element;
    private BinaryTreeNode<AnyType> leftChild, rightChild;

    public BinaryTreeNode(AnyType element) {
        this.element = element;
        this.leftChild = null;
        this.rightChild = null;
    }

    public
    BinaryTreeNode(AnyType theElement, BinaryTreeNode<AnyType> leftChild, BinaryTreeNode<AnyType> rightChild) {
        this.element = theElement;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    /**
     * Store the element in the Node
     */
    public void setElement(AnyType newElement) {
        this.element = newElement;
    }

    /**
     * Returns the element from the Node
     */
    public AnyType getElement() {
        return element;
    }

    /**
     * Add a left child to the Node
     */
    public void addLeftChild(BinaryTreeNode<AnyType> leftChild) {
        this.leftChild = leftChild;
    }

    /**
     * Add a right child to the Node
     */
    public void addRightChild(BinaryTreeNode<AnyType> rightChild) {
        this.rightChild = rightChild;
    }

    /**
     * Returns a reference to the left child or null if there is no left child
     */
    public BinaryTreeNode<AnyType> getLeftChild() {
        return leftChild;
    }

    /***
     * Returns a reference to the right child or null if there is no right child
     */
    public BinaryTreeNode<AnyType> getRightChild() {
        return rightChild;
    }

}
