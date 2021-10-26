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

    public BinaryTreeNode getRoot() {
        return binarySearchTree.getRoot();
    }

    public boolean isEmpty() {
        boolean isEmpty = true;
        if (getRoot() != null) {
            isEmpty = false;
        }
        return isEmpty;
    }

    public int size(final BinaryTreeNode root) {
        getValue(root);
        return arrayList.size();
    }

    // Need test
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

    public void inOrder(final BinaryTreeNode root) {
        if (root != null) {
            inOrder(root.getLeftChild());
            print(root);
            inOrder(root.getRightChild());
        }
    }

    public void preOrder(final BinaryTreeNode root) {
        if (root != null) {
            print(root);
            preOrder(root.getLeftChild());
            preOrder(root.getRightChild());
        }
    }

    public void postOrder(final BinaryTreeNode root) {
        if (root != null) {
            preOrder(root.getLeftChild());
            preOrder(root.getRightChild());
            print(root);
        }
    }

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
