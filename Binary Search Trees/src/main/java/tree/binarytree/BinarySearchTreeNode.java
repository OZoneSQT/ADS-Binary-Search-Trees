package tree.binarytree;

/*
 * Copyright (c) 2021
 *
 * OZ1SQT, Michel S. E. Sommer
 * https://Seahawk.dk
 */


public class BinarySearchTreeNode<AnyType> extends BinaryTreeNode<AnyType> {

    private AnyType element;

    public BinarySearchTreeNode(AnyType element) {
        super(element);
    }

    public BinarySearchTreeNode(AnyType element, BinarySearchTreeNode<AnyType> leftChild, BinarySearchTreeNode<AnyType> rightChild) {
        super(element, leftChild, rightChild);
    }

    /**
     * Returns a reference to the left child or null if there is no left child
     */
    public BinarySearchTreeNode<AnyType> getLeftChild() {
        return (BinarySearchTreeNode) super.getLeftChild();
    }

    /***
     * Returns a reference to the right child or null if there is no right child
     */
    public BinarySearchTreeNode<AnyType> getRightChild() {
        return (BinarySearchTreeNode) super.getRightChild();
    }
}
