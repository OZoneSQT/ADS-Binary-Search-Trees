package tree.binarytree;

/*
 * Copyright (c) 2021
 *
 * OZ1SQT, Michel S. E. Sommer
 * https://Seahawk.dk
 */

public class BinarySearchTreeNode<Element> extends BinaryTreeNode<Element> {

    private Element element;

    public BinarySearchTreeNode(Element element) {
        super(element);
    }

    public BinarySearchTreeNode(Element element, BinarySearchTreeNode<Element> leftChild, BinarySearchTreeNode<Element> rightChild) {
        super(element, leftChild, rightChild);
    }

    /**
     * Returns a reference to the left child or null if there is no left child
     */
    public BinarySearchTreeNode<Element> getLeftChild() {
        return (BinarySearchTreeNode) super.getLeftChild();
    }

    /***
     * Returns a reference to the right child or null if there is no right child
     */
    public BinarySearchTreeNode<Element> getRightChild() {
        return (BinarySearchTreeNode) super.getRightChild();
    }

    public void addLeftChild(Element element) {
        super.addLeftChild(new BinarySearchTreeNode<Element>(element));
    }

    public void addRightChild(Element element) {
        super.addRightChild(new BinarySearchTreeNode<Element>(element));
    }

}
