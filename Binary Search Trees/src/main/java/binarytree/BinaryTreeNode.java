package binarytree;

public class BinaryTreeNode<K,AnyType> {
    boolean isRoot = true;
    private K nodeId;
    private AnyType element;
    private BinaryTreeNode<K,AnyType> leftChild, rightChild, parentNode;

    public BinaryTreeNode(K nodeId, AnyType element) {
        this.isRoot = false;
        this.nodeId = nodeId;

        if (element == null) {
            throw new IllegalArgumentException("Null is not allowed");
        } else {
            this.element = element;
        }
    }

    public BinaryTreeNode(K nodeId, AnyType element, BinaryTreeNode<K,AnyType> parentNode) {
        this.isRoot = false;
        this.nodeId = nodeId;
        this.parentNode = parentNode;

        if (element == null) {
            throw new IllegalArgumentException("Null is not allowed");
        } else {
            this.element = element;
        }
    }

    // Store the element in the Node
    public void setElement(AnyType element) {
        if (element == null) {
            throw new IllegalArgumentException("Null is not allowed");
        } else {
            this.element = element;
        }
    }

    // Returns the element from the Node
    public AnyType getElement() {
        return element;
    }

    // Add a left child to the Node
    public void addLeftChild(BinaryTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    // Add a right child to the Node
    public void addRightChild(BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    // Returns a reference to the left child
    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }

    // Returns a reference to the right child
    public BinaryTreeNode getRightChild() {
        return rightChild;
    }

    public BinaryTreeNode getParentNode() {
        return parentNode;
    }

    public void setParentNode(BinaryTreeNode parentNode) {
        this.parentNode = parentNode;
    }

    public boolean isNodeRoot() {
        return parentNode == null;
    }

    public K getNodeId() {
        return nodeId;
    }

}
