package tree.binarytree;

/*
 * Copyright (c) 2021
 *
 * OZ1SQT, Michel S. E. Sommer
 * https://Seahawk.dk
 */

import java.util.ArrayList;

public class BinarySearchTree<T> extends BinaryTree {
    private BinaryTreeNode root;
    private InsertNode insertNode = new InsertNode();
    private DeleteNode deleteNode = new DeleteNode();

    public BinarySearchTree() {
        super();
    }

    /**
     * Add an element to the tree. Do nothing if present
     */
    public void insertElement(T element) {
        //TODO if not present, call contains
        root = insertNode.add(element);
    }

    /**
     * Remove an element from the tree Do nothing if not present
     * @param treeRoot
     * @param value
     */
    public void removeElement(T element) {
        root = deleteNode.delete(element);
    }

    /**
     * Returns the minimum element of the tree
     * @param root
     * @return
     */
    // Need test
    public int findMin() {

                    //TODO Traverse() or go most to the left
        return 0;
    }

    /**
     * Returns the maximum element of the tree
     * @param root
     * @return
     */
    // Need test
    public int findMax() {

                //TODO Traverse inorder() or go most to the right
        return 0;
    }

    /**
     * Determines if an element is present in the tree
     */
    public boolean contains(T element) {
        return false;
    }

    /**
     * Rebalance the entire tree, the outcome must be a balanced tree.
     */
    public void rebalance() {
        // divide and conquer array then put into tree again
        // if equal length, select element to the right of center (to fill up from left)
    }

}
