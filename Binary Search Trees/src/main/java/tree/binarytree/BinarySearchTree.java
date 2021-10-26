package tree.binarytree;

/*
 * Copyright (c) $originalComment.match("Copyright \(c\) (\d+)", 1, "-")$today.year.
 *
 * OZ1SQT, Michel S. E. Sommer
 * https://Seahawk.dk
 */

import java.util.ArrayList;

public class BinarySearchTree extends BinaryTree {
    private BinaryTreeNode root;
    private InsertNode insertNode = new InsertNode();
    private DeleteNode deleteNode = new DeleteNode();

    public BinarySearchTree() {
        super();
    }

    public void addElement(final BinaryTreeNode treeRoot, final int value) {
        root = insertNode.add(treeRoot, value);
    }

    public void removeElement(final BinaryTreeNode treeRoot, final int value) {
        root = deleteNode.delete(treeRoot, value);
    }

    // note
    public void removeAllOccurrences(final BinaryTreeNode treeRoot, final int value) {
        for (int i = 0; i < size(treeRoot); i++) {
            BinaryTreeNode treeNode = searchKey(root, value);
            if (treeNode.getElement() == value) {
                removeElement(treeRoot, value);
            }
        }
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    // Need test
    public Integer findMax(final BinaryTreeNode root) {
        getValue(root);
        ArrayList<Integer> arrayList = getArrayList();
        int value = 0;

        for (int i = 0; i < arrayList.size(); i++) {
            if (value < arrayList.get(i)) {
                value = arrayList.get(i);
            }
        }

        return value;
    }

    // Need test
    public int findMin(final BinaryTreeNode root) {
        getValue(root);
        ArrayList<Integer> arrayList = getArrayList();
        int value = 0;

        for (int i = 0; i < arrayList.size(); i++) {
            if (value > arrayList.get(i)) {
                value = arrayList.get(i);
            }
        }

        return value;
    }

    // Need test
    public void removeMin() {
        removeElement(root, findMin(root));
    }

    // Need test
    public void removeMax() {
        removeElement(root, findMax(root));
    }

    // Need test
    public BinaryTreeNode searchKey(final BinaryTreeNode treeRoot, final int findingValue) {
        if (treeRoot == null) {
            return null;
        }

        if (findingValue == treeRoot.getElement()) {
            return treeRoot;
        } else if (findingValue > treeRoot.getElement()) {
            return searchKey(treeRoot.getRightChild(), findingValue);
        } else {
            return searchKey(treeRoot.getLeftChild(), findingValue);
        }
    }

    public String toString() {
        return "BinarySearchTree [root=" + root + "]";
    }

}
