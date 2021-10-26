package tree.binarytree;

/*
 * Copyright (c) $originalComment.match("Copyright \(c\) (\d+)", 1, "-")$today.year.
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
