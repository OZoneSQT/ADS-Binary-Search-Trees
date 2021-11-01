package tree.binarytree;

/*
 * Copyright (c) 2021
 *
 * OZ1SQT, Michel S. E. Sommer
 * https://Seahawk.dk
 */

import other.BinaryNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<AnyType extends Comparable<? super AnyType>> {
    private BinaryTreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    /**
     * Returns a reference to the root or null if tree is empty
     */
    public BinaryTreeNode getRoot() {
        return root;
    }

    /**
     * Set the root of the tree
     */
    public void setRoot(BinaryTreeNode root) {
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
    public ArrayList inOrder() {
        ArrayList<BinaryTreeNode> tree = new ArrayList<>();
        if (isEmpty()) {
            return null;
        }
        return traverseInOrder(root, tree);
    }

    private ArrayList traverseInOrder(BinaryTreeNode root, ArrayList tree) {
        if (root != null) {
            traverseInOrder(root.getLeftChild(), tree);
            tree.add(root);
            traverseInOrder(root.getRightChild(), tree);
        }
        return tree;
    }

    /**
     * Returns a preOrder representation of the tree or null if the tree is empty
     */
    public ArrayList preOrder() {
        ArrayList<AnyType> tree = new ArrayList<>();
        if (isEmpty()) {
            return null;
        }
        return traversePreOrder(root, tree);
    }

    private ArrayList traversePreOrder(BinaryTreeNode root, ArrayList tree) {
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
    public ArrayList postOrder() {
        ArrayList<AnyType> output = new ArrayList<>();
        if (isEmpty()) {
            return null;
        }
        return traversePostOrder(root, output);
    }

    private ArrayList traversePostOrder(BinaryTreeNode root, ArrayList output) {
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
    public ArrayList levelOrder() {
        ArrayList<AnyType> output = new ArrayList<>();

        if (isEmpty()) {
            return null;
        }
        return traverseLevelOrder(root, output);
    }

    private ArrayList traverseLevelOrder(BinaryTreeNode root, ArrayList output) {
        Queue<AnyType> queue = new LinkedList<>();
        if (root == null) {
            return output;
        }

        queue.add((AnyType) root.getElement());
        while (!queue.isEmpty()) {
            AnyType tmpNode = queue.poll();
            if (tmpNode != null) {
                queue.add(tmpNode);
            }
            if (tmpNode != null) {
                queue.add(tmpNode);
            }
            output.add(tmpNode);
        }

        return output;
    }

    /**
     * Returns the height of the tree or -1 if the tree is empty
     */
    public int height() {
        // log(size(), 2);
        return height(root);
    }

    private int height(BinaryTreeNode<AnyType> root) {
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

