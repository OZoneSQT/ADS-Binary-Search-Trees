package tree.other;


import tree.binarytree.BinarySearchTreeNode;

public class TestNode<AnyType> {
    private AnyType element;
    private TestNode<AnyType> leftChild, rightChild;

    public TestNode(AnyType element) {
        this.element = element;
        this.leftChild = null;
        this.rightChild = null;
    }

    public TestNode(AnyType theElement, TestNode<AnyType> leftChild, TestNode<AnyType> rightChild) {
        this.element = theElement;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    /**
     * Store the element in the Node
     */
    public void setElement(AnyType newElement) {
        this.element = newElement;
    }

    /**
     * Returns the element from the Node
     */
    public AnyType getElement() {
        return element;
    }

    /**
     * Add a left child to the Node
     */
    public void addLeftChild(TestNode<AnyType> leftChild) {
        this.leftChild = leftChild;
    }

    /**
     * Add a right child to the Node
     */
    public void addRightChild(TestNode<AnyType> rightChild) {
        this.rightChild = rightChild;
    }

    /**
     * Returns a reference to the left child or null if there is no left child
     */
    public TestNode<AnyType> getLeftChild() {
        return leftChild;
    }

    /***
     * Returns a reference to the right child or null if there is no right child
     */
    public TestNode<AnyType> getRightChild() {
        return rightChild;
    }

}
