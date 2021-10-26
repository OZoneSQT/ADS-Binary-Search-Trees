package tree.binarytree;

/*
 * Copyright (c) 2021
 *
 * OZ1SQT, Michel S. E. Sommer
 * https://Seahawk.dk
 */

public class BinarySearchTreeNode extends BinaryTreeNode {

    public BinarySearchTreeNode(int value) {
        super(value);
    }

    public BinaryTreeNode setParent(BinaryTreeNode hostNode, BinaryTreeNode parentNode) {
        hostNode.setParent(parentNode);
        return hostNode;
    }

    public BinaryTreeNode getPatent(BinaryTreeNode binaryTreeNode) {
        BinaryTreeNode parentNode = binaryTreeNode.getPatent();
        return parentNode;
    }

}
