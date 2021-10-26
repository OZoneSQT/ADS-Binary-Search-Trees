package tree.binarytree;

/*
 * Copyright (c) 2021
 *
 * OZ1SQT, Michel S. E. Sommer
 * https://Seahawk.dk
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InsertNode {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public BinaryTreeNode add(final BinaryTreeNode treeRoot, final int addingValue) {
        if (treeRoot == null) {
            logger.info("Create a new leaf node with keyvalue:{} ", addingValue);
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

}
