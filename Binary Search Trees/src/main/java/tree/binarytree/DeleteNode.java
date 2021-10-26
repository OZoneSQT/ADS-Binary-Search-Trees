package tree.binarytree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DeleteNode {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private BinarySearchTree binarySearchTree;

    public void setBinarySearchTree(BinarySearchTree binarySearchTree) {
        this.binarySearchTree = binarySearchTree;
    }

    public BinaryTreeNode delete(final BinaryTreeNode binaryTreeNode, final int deletingValue) {
        if (binaryTreeNode == null) {
            logger.info("delete return null for {}", deletingValue);
            return null;
        }
        if (deletingValue == binaryTreeNode.getElement()) {
            logger.info("found the deleting node{}", binaryTreeNode.toString());
            if (binaryTreeNode.getLeftChild() == null) {
                if (binaryTreeNode.getRightChild() == null) {
                    // delete the leaf node
                    logger.info("return null because the to-be-delete node {} is a leaf node", deletingValue);
                    return null;
                } else {
                    // only right child
                    logger.info("return the right node because the to-be-delete node {} has right child node", deletingValue);
                    return binaryTreeNode.getRightChild();
                }
            } else {
                if (binaryTreeNode.getRightChild() == null) {
                    // only Left child
                    logger.info("return the left node because the to-be-delete node {} has left child node", deletingValue);
                    return binaryTreeNode.getLeftChild();
                } else {
                    // has both children
                    int minTreeNode = binarySearchTree.findMin(binaryTreeNode.getRightChild());
                    logger.info("Replace key with with the minumu value {} and reset the right node", minTreeNode);
                    binaryTreeNode.setElement(minTreeNode);
                    binaryTreeNode.setRightChild(delete(binaryTreeNode.getRightChild(), minTreeNode));
                    return binaryTreeNode;
                }
            }
        } else if (deletingValue < binaryTreeNode.getElement()) {
            BinaryTreeNode tempTreeNode = delete(binaryTreeNode.getLeftChild(), deletingValue);
            if (tempTreeNode == null || (binaryTreeNode.getLeftChild() != null && !binaryTreeNode.getLeftChild().equals(tempTreeNode))) {
                binaryTreeNode.setLeftChild(tempTreeNode);
            }
            return binaryTreeNode;
        } else {
            BinaryTreeNode tempTreeNode = delete(binaryTreeNode.getRightChild(), deletingValue);
            binaryTreeNode.setRightChild(tempTreeNode);
            return binaryTreeNode;
        }
    }

}
