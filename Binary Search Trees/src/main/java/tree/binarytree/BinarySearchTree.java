package tree.binarytree;

/*
 * Copyright (c) 2021
 *
 * OZ1SQT, Michel S. E. Sommer
 * https://Seahawk.dk
 */

import java.util.ArrayList;

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> extends BinaryTree<AnyType> {
    private BinarySearchTreeNode root;
  //  private InsertNode insertNode = new InsertNode();
   //  private DeleteNode deleteNode = new DeleteNode();

    public BinarySearchTree() {
        super();
    }

    /**
     * Add an element to the tree. Do nothing if present
     */
    public void insertElement(AnyType element) {
        if (!contains(element)) {
            this.root = insert(element);
        }
    }

    private BinarySearchTreeNode insert(AnyType element) {
        if (isEmpty()) {
            setRoot(new BinarySearchTreeNode(element));
        }

        //TODO calc location from size
        //Left Child    =>     2n+1      =>      int pos = ( 2 * size() + 1 )
        //Right Child   =>    2(n+1)     =>      int pos = ( 2 * ( size() + 1 ) )

        return root;
    }

    /**
     * Remove an element from the tree Do nothing if not present
     */
    public void removeElement(AnyType element) {
        if (contains(element)) {
            root = deleteNode.delete(element);
            rebalance();
        }
    }

    /**
     * Returns the minimum element of the tree
     */
    // Need test
    public AnyType findMin() {
        ArrayList<AnyType> list = super.inOrder();
        return list.get(0);
    }

    /**
     * Returns the maximum element of the tree
     */
    // Need test
    public AnyType findMax() {
        ArrayList<AnyType> list = super.inOrder();
        return list.get(list.size());
    }

    /**
     * Determines if an element is present in the tree
     */
    public boolean contains(AnyType element) {
        return super.contains(element);
    }

    /**
     * Rebalance the entire tree, the outcome must be a balanced tree.
     */
    public void rebalance() {
        // divide and conquer array then put into tree again
        // if equal length, select element to the right of center (to fill up from left)
        // https://github.com/DanielRailean/ADS1-A2021/blob/main/AVLTree/src/AVLTree.java
    }

    private BinarySearchTreeNode updateNode(BinarySearchTreeNode binarySearchTreeNode) {
        return null;
    }

    private BinarySearchTreeNode rotateLeft(BinarySearchTreeNode binarySearchTreeNode) {
        return null;
    }

    private BinarySearchTreeNode rotateRight(BinarySearchTreeNode binarySearchTreeNode) {
        return null;
    }

    private BinarySearchTreeNode isInBalance(BinarySearchTreeNode binarySearchTreeNode) {
        return null;
    }

}
