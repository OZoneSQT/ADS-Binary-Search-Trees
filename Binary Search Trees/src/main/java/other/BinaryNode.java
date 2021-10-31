package other;

public class BinaryNode<AnyType> {

    private AnyType element;
    private BinaryNode<AnyType> leftChild, rightChild;

    BinaryNode(AnyType theElement) {
        this(theElement, null, null);
    }

    BinaryNode(AnyType theElement, BinaryNode<AnyType> leftChild, BinaryNode<AnyType> rightChild) {
        this.element = theElement;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public AnyType getElement() {
        return element;
    }

    public void setLeftChild(BinaryNode<AnyType> leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryNode<AnyType> getLeftChild() {
        return  leftChild;
    }

    public void setRightChild(BinaryNode<AnyType> rightChild) {
        this.rightChild = rightChild;
    }

    public BinaryNode<AnyType> getRightChild() {
        return rightChild;
    }
}
