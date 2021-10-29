package tree.binarytree;

/*
 * Copyright (c) 2021
 *
 * OZ1SQT, Michel S. E. Sommer
 * https://Seahawk.dk
 */

public class InsertNode {

    public BinaryTreeNode add(final BinaryTreeNode treeRoot, final int addingValue) {
        if (treeRoot == null) {
            return new BinaryTreeNode(addingValue);
        }

        if (addingValue < treeRoot.getElement()) {
            treeRoot.addLeftChild(add(treeRoot.getLeftChild(), addingValue));
        } else if (addingValue == treeRoot.getElement()) {
            return treeRoot;
        } else {
            treeRoot.addRightChild(add(treeRoot.getRightChild(), addingValue));
        }

        return treeRoot;
    }

    public <T> BinaryTreeNode add(T element) {
    }
}
