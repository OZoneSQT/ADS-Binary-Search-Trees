package tree.binarytree;

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
            treeRoot.setLeftChild(add(treeRoot.getLeftChild(), addingValue));
        } else if (addingValue == treeRoot.getElement()) {
            return treeRoot;
        } else {
            treeRoot.setRightChild(add(treeRoot.getRightChild(), addingValue));
        }

        return treeRoot;
    }

}
