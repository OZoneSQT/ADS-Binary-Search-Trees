package tree.binarytree;

/*
 * Copyright (c) 2021
 *
 * OZ1SQT, Michel S. E. Sommer
 * https://Seahawk.dk
 */

public class BinaryTreeNode<Element> {
    private Element element;
    private BinaryTreeNode<Element> leftChild, rightChild;

    public BinaryTreeNode(Element element) {
        this.element = element;
        this.leftChild = null;
        this.rightChild = null;
    }

    public BinaryTreeNode(Element theElement, BinaryTreeNode<Element> leftChild, BinaryTreeNode<Element> rightChild) {
        this.element = theElement;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    /**
     * Store the element in the Node
     */
    public void setElement(Element newElement) {
        this.element = newElement;
    }

    /**
     * Returns the element from the Node
     */
    public Element getElement() {
        return element;
    }

    /**
     * Add a left child to the Node
     */
    public void addLeftChild(BinaryTreeNode<Element> leftChild) {
        this.leftChild = leftChild;
    }

    /**
     * Add a right child to the Node
     */
    public void addRightChild(BinaryTreeNode<Element> rightChild) {
        this.rightChild = rightChild;
    }

    /**
     * Returns a reference to the left child or null if there is no left child
     */
    public BinaryTreeNode<Element> getLeftChild() {
        return leftChild;
    }

    /***
     * Returns a reference to the right child or null if there is no right child
     */
    public BinaryTreeNode<Element> getRightChild() {
        return rightChild;
    }

}
