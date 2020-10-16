package binarytree;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;

@EnableRuleMigrationSupport
class BinaryTreeNodeTest {
    private BinaryTreeNode binaryTreeRootNode;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @BeforeEach
    void setUp() {
        int element = 1;
        binaryTreeRootNode = new BinaryTreeNode(element);
    }

    @Test
    void setupNewTreeNodeRootNull() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Null is not allowed");

        binaryTreeRootNode = new BinaryTreeNode(null);
    }

    @Test
    void createTreeNodeNull() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Null is not allowed");

        BinaryTreeNode binaryTreeNodeLeft;
        binaryTreeNodeLeft = new BinaryTreeNode(null, binaryTreeRootNode);
        binaryTreeRootNode.addLeftChild(binaryTreeNodeLeft);
    }

    @Test
    void modifyElement() {
        int elementA = 2;
        int elementB = 3;
        BinaryTreeNode binaryTreeNodeLeft;
        binaryTreeNodeLeft = new BinaryTreeNode(elementA, binaryTreeRootNode);
        binaryTreeRootNode.addLeftChild(binaryTreeNodeLeft);

        assertEquals(elementA, binaryTreeRootNode.getLeftChild().getElement());

        binaryTreeRootNode.getLeftChild().setElement(elementB);

        assertEquals(elementB, binaryTreeRootNode.getLeftChild().getElement());
    }

    @Test
    void modifyElementNull() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Null is not allowed");

        binaryTreeRootNode.setElement(null);
    }

    @Test
    void addChild() {
        int elementA = 2;
        int elementB = 3;
        BinaryTreeNode binaryTreeNodeLeft, binaryTreeNodeRight;
        binaryTreeNodeLeft = new BinaryTreeNode(elementA, binaryTreeRootNode);
        binaryTreeNodeRight = new BinaryTreeNode(elementB, binaryTreeRootNode);
        binaryTreeRootNode.addLeftChild(binaryTreeNodeLeft);
        binaryTreeRootNode.addRightChild(binaryTreeNodeRight);

        assertEquals(binaryTreeNodeLeft, binaryTreeRootNode.getLeftChild());
        assertEquals(binaryTreeNodeRight, binaryTreeRootNode.getRightChild());
    }

    @Test
    void getLeftChildValue() {
        int elementA = 2;
        BinaryTreeNode binaryTreeNodeLeft;
        binaryTreeNodeLeft = new BinaryTreeNode(elementA, binaryTreeRootNode);
        binaryTreeRootNode.addLeftChild(binaryTreeNodeLeft);

        assertEquals(elementA, binaryTreeRootNode.getLeftChild().getElement());
    }

    @Test
    void getRightChildValue() {
        int elementA = 2;
        int elementB = 3;
        BinaryTreeNode binaryTreeNodeLeft, binaryTreeNodeRight;
        binaryTreeNodeLeft = new BinaryTreeNode(elementA, binaryTreeRootNode);
        binaryTreeNodeRight = new BinaryTreeNode(elementB, binaryTreeRootNode);
        binaryTreeRootNode.addLeftChild(binaryTreeNodeLeft);
        binaryTreeRootNode.addRightChild(binaryTreeNodeRight);

        assertEquals(elementA, binaryTreeRootNode.getLeftChild().getElement());
        assertEquals(elementB, binaryTreeRootNode.getRightChild().getElement());
    }

    @Test
    void getParentNode() {
        int element = 2;
        BinaryTreeNode binaryTreeNode;
        binaryTreeNode = new BinaryTreeNode(element, binaryTreeRootNode);

        assertEquals(binaryTreeRootNode, binaryTreeNode.getParentNode());
    }

    @Test
    void setParentNode() {
        int elementA = 2;
        int elementB = 3;
        BinaryTreeNode binaryTreeNode, binaryTreeNodeOther;
        binaryTreeNode = new BinaryTreeNode(elementA, binaryTreeRootNode);
        binaryTreeNodeOther = new BinaryTreeNode(elementB, binaryTreeRootNode);
        binaryTreeNode.setParentNode(binaryTreeNodeOther);

        assertEquals(binaryTreeNodeOther, binaryTreeNode.getParentNode());
    }

    @Test
    void isNodeRootTrue() {
        assertTrue(binaryTreeRootNode.isNodeRoot());
    }

    @Test
    void isNodeRootFalse() {
        int element = 2;
        BinaryTreeNode binaryTreeNode;
        binaryTreeNode = new BinaryTreeNode(element, binaryTreeRootNode);

        assertFalse(binaryTreeNode.isNodeRoot());
    }

}