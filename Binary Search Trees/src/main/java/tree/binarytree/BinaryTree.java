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

public class BinaryTree<T> {
    private BinaryTreeNode root;
    private int size;
    private ArrayList<BinaryTreeNode> binarySearchTree;

    public BinaryTree() {
        this.root = null;
        this.binarySearchTree = new ArrayList<>();
    }

    /**
     * Returns a reference to the root or null if tree is empty
     * @return
     */
    public BinaryTreeNode getRoot() {
        return root;
    }

    /**
     * Set the root of the tree
     * @param root
     */
    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    /**
     * Determines whether the tree is empty
     * @return
     */
    public boolean isEmpty() {
        if (root == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the number of elements in the tree
     * @return
     */
    public int size() {
        return inOrder(root).size();
    }

    /**
     * Determines if an element is present in the tree
     * @return
     */
    public boolean contains(T element) {
        ArrayList<BinaryTreeNode> arrayList = inOrder(root);
        boolean result = false;
        for (int i = 0; i < arrayList.size(); i++) {
            BinaryTreeNode node = arrayList.get(i);
            if (element.equals(node.getElement())) {
                result = true;
                i = arrayList.size();
            }
        }
        return result;
    }

    /**
     * Returns a inOrder representation of the tree or null if the tree is empty
     */
    public ArrayList<BinaryTreeNode> inOrder() {
        if (binarySearchTree.isEmpty()) {
            return null;
        }
        return inOrder(root);
    }

    private ArrayList<BinaryTreeNode> inOrder(final BinaryTreeNode root) {
        if (root != null) {
            inOrder(root.getLeftChild());
            binarySearchTree.add(root);
            inOrder(root.getRightChild());
        }
        return binarySearchTree;
    }

    /**
     * Returns a preOrder representation of the tree or null if the tree is empty
     */
    public ArrayList<BinaryTreeNode> preOrder() {
        if (binarySearchTree.isEmpty()) {
            return null;
        }
        return preOrder(root);
    }

    private ArrayList<BinaryTreeNode> preOrder(final BinaryTreeNode root) {
        if (root != null) {
            binarySearchTree.add(root);
            preOrder(root.getLeftChild());
            preOrder(root.getRightChild());
        }
        return binarySearchTree;
    }

    /**
     * Returns a postOrder representation of the tree or null if the tree is empty
     */
    public ArrayList<BinaryTreeNode> postOrder() {
        if (binarySearchTree.isEmpty()) {
            return null;
        }
        return postOrder(root);
    }

    private ArrayList<BinaryTreeNode> postOrder(final BinaryTreeNode root) {
        if (root != null) {
            preOrder(root.getLeftChild());
            preOrder(root.getRightChild());
            binarySearchTree.add(root);
        }
        return binarySearchTree;
    }

    /**
     * Returns a level Order representation of the tree or null if the tree is empty
     */
    public ArrayList<BinaryTreeNode> levelOrder() {
        if (binarySearchTree.isEmpty()) {
            return null;
        }
        return levelOrder(root);
    }

    // Has to return ArrayList
    public ArrayList<BinaryTreeNode> levelOrder(final BinaryTreeNode root) {
        QueueInterface<BinaryTreeNode> fifo = new QueueFIFO<>(41);
        if (root == null) {
            return binarySearchTree;
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
            binarySearchTree.add(tmpNode);
        }

        return binarySearchTree;
    }

    /**
     * Returns the height of the tree or -1 if the tree is empty
     */
    // Need test
    //TODO Returns only root
    public int height() {
        return log(size(), 2);

     /*
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

       */

    }

    private int log(int n, int log) {
        int result = (int)(Math.log(n) / Math.log(log));
        return result;
    }

}

