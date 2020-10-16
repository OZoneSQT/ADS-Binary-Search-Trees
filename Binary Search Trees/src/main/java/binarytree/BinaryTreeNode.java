package binarytree;

public class BinaryTreeNode<AnyType> {
    boolean isRoot = true;
    private AnyType element;
    private BinaryTreeNode leftChild, rightChild, parentNode;

    public BinaryTreeNode(AnyType element) {
            this.isRoot = false;
            this.element = element;
    }

    public BinaryTreeNode(AnyType element, BinaryTreeNode parentNode) {
            this.isRoot = false;
            this.element = element;
            this.parentNode = parentNode;
    }

    // Store the element in the Node
    public void setElement(AnyType element) {
        this.element = element;
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

}
