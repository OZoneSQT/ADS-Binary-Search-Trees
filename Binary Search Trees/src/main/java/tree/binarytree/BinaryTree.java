package tree.binarytree;

/*
 * Copyright (c) 2021
 *
 * OZ1SQT, Michel S. E. Sommer
 * https://Seahawk.dk
 */

import tree.util.QueueFIFO;
import tree.util.QueueInterface;

import java.util.ArrayList;

public class BinaryTree {
    private BinarySearchTree binarySearchTree;
    private ArrayList<Integer> arrayList = new ArrayList();

    public BinaryTree() {
    }

    public BinaryTree(BinarySearchTree binarySearchTree) {
        this.binarySearchTree = binarySearchTree;
    }

    /**
     * Returns a reference to the root or null if tree is empty
     * @return
     */
    public BinaryTreeNode getRoot() {
        return binarySearchTree.getRoot();
    }

    /**
     * Determines whether the tree is empty
     * @return
     */
    public boolean isEmpty() {
        boolean isEmpty = true;
        if (getRoot() != null) {
            isEmpty = false;
        }
        return isEmpty;
    }

    /**
     * Returns the number of elements in the tree
     * @param root
     * @return
     */
    public int size(final BinaryTreeNode root) {
        getValue(root);
        return arrayList.size();
    }

    /**
     * Determines if an element is present in the tree
     * @param root
     * @param findingValue
     * @return
     */
    // Need test - traverse and compare elements
    public boolean contains(final BinaryTreeNode root, int findingValue) {
        boolean result = false;
        getValue(root);

        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) == findingValue) {
                result = true;
            }
        }
        return result;
    }

    /**
     * Set the root of the tree
     * @param binaryTreeNode
     */
    // Need test
    public void setRoot(BinaryTreeNode binaryTreeNode) {

    }

    // Need test
    public void getValue(final BinaryTreeNode root) {
        if (root != null) {
            getValue(root.getLeftChild());
            arrayList.add(root.getElement());
            getValue(root.getRightChild());
        }
    }

    // Need test
    public ArrayList getArrayList() {
        return arrayList;
    }

    /**
     * Returns a inOrder representation of the tree or null if the tree is empty
     * @param root
     */
    // Has to return ArrayList
    public void inOrder(final BinaryTreeNode root) {
        if (root != null) {
            inOrder(root.getLeftChild());
            print(root);
            inOrder(root.getRightChild());
        }
    }

    /**
     * Returns a preOrder representation of the tree or null if the tree is empty
     * @param root
     */
    // Has to return ArrayList
    public void preOrder(final BinaryTreeNode root) {
        if (root != null) {
            print(root);
            preOrder(root.getLeftChild());
            preOrder(root.getRightChild());
        }
    }

    /**
     * Returns a postOrder representation of the tree or null if the tree is empty
     * @param root
     */
    // Has to return ArrayList
    public void postOrder(final BinaryTreeNode root) {
        if (root != null) {
            preOrder(root.getLeftChild());
            preOrder(root.getRightChild());
            print(root);
        }
    }

    /**
     * Returns a level Order representation of the tree or null if the tree is empty
     * @param root
     */
    // Has to return ArrayList
    public void levelOrder(final BinaryTreeNode root) {
        QueueInterface<BinaryTreeNode> fifo = new QueueFIFO<>(41);
        if (root == null) {
            return;
        }

        fifo.enqueue(root);
        while (!fifo.isEmpty()) {
            BinaryTreeNode tmpNode = fifo.dequeue();
            if (tmpNode.getLeftChild() != null) {
                fifo.enqueue(tmpNode.getLeftChild());
            }
            if (tmpNode.getRightChild() != null) {
                fifo.enqueue(tmpNode.getRightChild());
            }
            print(tmpNode);
        }

    }

    /**
     * Returns the height of the tree or -1 if the tree is empty
     * @param binaryTreeNode
     * @return
     */
    // Need test
    //TODO Returns only root
    public int height(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode == null) {
            return 0;
        } else {
            int leftDepth = height(binaryTreeNode.getLeftChild());
            int rightDepth = height(binaryTreeNode.getRightChild());

            if (leftDepth > rightDepth)
                return (leftDepth++);
            else
                return (rightDepth++);
        }
    }

    private void print(final BinaryTreeNode root) {
        System.out.print(root.getElement() + " ");
    }

}
