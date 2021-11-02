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

public class BinaryTree<AnyType extends Comparable<? super AnyType>> {
    private BinaryTreeNode<AnyType> root;

    public BinaryTree() {
        this.root = null;
    }

    /**
     * Returns a reference to the root or null if tree is empty
     */
    public BinaryTreeNode<AnyType> getRoot() {
        return root;
    }

    /**
     * Set the root of the tree
     */
    public void setRoot(BinaryTreeNode<AnyType> root) {
        this.root = root;
    }

    /**
     * Determines whether the tree is empty
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Returns the number of elements in the tree size
     */
    public int size() {
        return inOrder().size();
        // return size(root);
    }

    private int size(BinaryTreeNode<AnyType> root){
        if(root == null) {
            return 0;
        } else {
            return 1 + size(root.getRightChild()) + size(root.getLeftChild());
        }
    }

    /**
     * Determines if an element is present in the tree
     */
    public boolean contains(AnyType element) {
        return contains(root, element);
    }

    private boolean contains(BinaryTreeNode<AnyType> root, AnyType element) {
        if (root == null) {
            return false;
        }

        int compareResult = element.compareTo(root.getElement());

        if (compareResult < 0) {
            return contains(root.getLeftChild(), element);
        } else if (compareResult > 0) {
            return contains(root.getRightChild(), element);
        } else {
            return true;    // match
        }
    }

    /**
     * Returns a inOrder representation of the tree or null if the tree is empty
     */
    public ArrayList<AnyType> inOrder() {
        ArrayList<AnyType> tree = new ArrayList<>();
        if (isEmpty()) {
            return null;
        }
        return traverseInOrder(root, tree);
    }

    private ArrayList<AnyType> traverseInOrder(BinaryTreeNode<AnyType> root, ArrayList<AnyType> tree) {
        if (root != null) {
            traverseInOrder(root.getLeftChild(), tree);
            tree.add(root.getElement());
            traverseInOrder(root.getRightChild(), tree);
        }
        return tree;
    }

    /**
     * Returns a preOrder representation of the tree or null if the tree is empty
     */
    public ArrayList<AnyType> preOrder() {
        ArrayList<AnyType> tree = new ArrayList<>();
        if (isEmpty()) {
            return null;
        }
        return traversePreOrder(root, tree);
    }

    private ArrayList<AnyType> traversePreOrder(BinaryTreeNode<AnyType> root, ArrayList<AnyType> tree) {
        if (root != null) {
            tree.add(root.getElement());
            traversePreOrder(root.getLeftChild(), tree);
            traversePreOrder(root.getRightChild(), tree);
        }
        return tree;
    }

    /**
     * Returns a postOrder representation of the tree or null if the tree is empty
     */
    public ArrayList<AnyType> postOrder() {
        ArrayList<AnyType> output = new ArrayList<>();
        if (isEmpty()) {
            return null;
        }
        return traversePostOrder(root, output);
    }

    private ArrayList<AnyType> traversePostOrder(BinaryTreeNode<AnyType> root, ArrayList<AnyType> output) {
        if (root != null) {
            traversePreOrder(root.getLeftChild(), output);
            traversePreOrder(root.getRightChild(), output);
            output.add(root.getElement());
        }
        return output;
    }

    /**
     * Returns a level Order representation of the tree or null if the tree is empty
     */
    public ArrayList<AnyType> levelOrder() {
        if (isEmpty()) {
            return null;
        }

        QueueInterface<BinaryTreeNode<AnyType>> fifo = new QueueFIFO<>(41);
        ArrayList<AnyType> list = new ArrayList<>();
        fifo.enqueue(root);

        return traverseLevelOrder(list, fifo);
    }

    private ArrayList<AnyType> traverseLevelOrder(ArrayList<AnyType> list, QueueInterface<BinaryTreeNode<AnyType>> fifo) {

        while (!fifo.isEmpty()) {
            BinaryTreeNode tmpNode = fifo.dequeue();
            if (tmpNode.getLeftChild() != null) {
                fifo.enqueue(tmpNode.getLeftChild());
            }
            if (tmpNode.getRightChild() != null) {
                fifo.enqueue(tmpNode.getRightChild());
            }

            list.add((AnyType) tmpNode.getElement());
        }

        return list;
    }

    /**
     * Returns the height of the tree or -1 if the tree is empty
     */
    public int height() {
        // log(size(), 2);
        return height(root);
    }

    public int height(BinaryTreeNode<AnyType> root) {
        if (root == null) {
            return -1;
        } else {
            return 1 + Math.max(height(root.getLeftChild()), height(root.getRightChild()));
        }
    }

    private int log(int n, int log) {
        int result = (int)(Math.log(n) / Math.log(log));
        return result;
    }

}

