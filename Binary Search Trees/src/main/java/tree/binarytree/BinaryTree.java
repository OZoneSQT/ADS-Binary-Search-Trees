package tree.binarytree;

/*
 * Copyright (c) 2021
 *
 * OZ1SQT, Michel S. E. Sommer
 * https://Seahawk.dk
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<AnyType> {
    private BinaryTreeNode root;

    public BinaryTree() {
        this.root = null;
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
        return root == null;
    }

    /**
     * Returns the number of elements in the tree size
     * @return
     */
    public int size() {
        return inOrder().size();
    }

    /**
     * Determines if an element is present in the tree
     * @return
     */
    public boolean contains(AnyType element) {
        return contains(getRoot(), element);
    }

    private boolean contains(BinaryTreeNode root, AnyType element) {
        if (root == null) {
            return false;
        } else if (element.equals(root.getElement())) {
            return true;
        } else {
            return contains(root.getLeftChild(), element) || contains(root.getRightChild(), element);
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
        return inOrder(root, tree);
    }

    private ArrayList inOrder(BinaryTreeNode root, ArrayList tree) {
        if (root != null) {
            inOrder(root.getLeftChild(), tree);
            tree.add(root);
            inOrder(root.getRightChild(), tree);
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
        return preOrder(root, tree);
    }

    private ArrayList preOrder(BinaryTreeNode root, ArrayList tree) {
        if (root != null) {
            tree.add(root.getElement());
            preOrder(root.getLeftChild(), tree);
            preOrder(root.getRightChild(), tree);
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
        return postOrder(root, output);
    }

    private ArrayList postOrder(BinaryTreeNode root, ArrayList output) {
        if (root != null) {
            preOrder(root.getLeftChild(), output);
            preOrder(root.getRightChild(), output);
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
        return levelOrder(root, output);
    }

    private ArrayList levelOrder(BinaryTreeNode root, ArrayList output) {
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
        int leftDept = 0;
        int rightDept = 0;

        if (getMinHeight(getRoot(), leftDept) > getMaxHeight(getRoot(), rightDept)) {
            return leftDept;
        } else {
            return rightDept;
        }
    }

    private int getMinHeight(BinaryTreeNode root, int height) {
        if (root == null) {
            return height;
        } else {
            height++;
            getMinHeight(root.getLeftChild(), height);
        }
        return height;
    }

    private int getMaxHeight(BinaryTreeNode root, int height) {
        if (root == null) {
            return height;
        } else {
            height++;
            getMaxHeight(root.getRightChild(), height);
        }
        return height;
    }

    private int log(int n, int log) {
        int result = (int)(Math.log(n) / Math.log(log));
        return result;
    }

}

