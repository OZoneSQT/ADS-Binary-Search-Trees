package tree.binarytree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BinaryTreeNode {
    private int keyValue;
    private BinaryTreeNode leftChild, rightChild, parentNode;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public BinaryTreeNode(final int value) {
        super();
        this.keyValue = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    public int getElement() {
        return keyValue;
    }

    public void setElement(final int value) {
        if (value != this.keyValue) {
            logger.info("Node:{} has a new key value {}", this.toString(), value);
            this.keyValue = value;
        }
    }

    public void setLeftChild(final BinaryTreeNode leftChild) {
        if (leftChild == null) {
            this.leftChild = null;
        } else if (!leftChild.equals(getLeftChild())) {
            logger.info("Node:{} sets new left child:{}", this.toString(), (leftChild == null ? null : leftChild.toString()));
            this.leftChild = leftChild;
        }
    }

    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }

    public void setRightChild(final BinaryTreeNode rightChild) {
        if (rightChild == null) {
            this.rightChild = null;
        } else if (!rightChild.equals(getRightChild())) {
            logger.info("Node:{} sets new right child:{}", this.toString(), (rightChild == null ? null : rightChild.toString()));
            this.rightChild = rightChild;
        }
    }

    public BinaryTreeNode getRightChild() {
        return rightChild;
    }

    public void setParent(BinaryTreeNode parentNode) {
        this.parentNode = parentNode;
    }

    public BinaryTreeNode getPatent() {
        return parentNode;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BinaryTreeNode other = (BinaryTreeNode) obj;
        if (keyValue != other.keyValue)
            return false;
        if (leftChild == null) {
            if (other.leftChild != null)
                return false;
        } else if (!leftChild.equals(other.leftChild))
            return false;
        if (rightChild == null) {
            if (other.rightChild != null)
                return false;
        } else if (!rightChild.equals(other.rightChild))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + keyValue;
        result = prime * result + ((leftChild == null) ? 0 : leftChild.hashCode());
        result = prime * result + ((rightChild == null) ? 0 : rightChild.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "BinaryNode [keyValue: " + keyValue + ", left child: " + leftChild + ", right child: " + rightChild + "]";
    }

}
