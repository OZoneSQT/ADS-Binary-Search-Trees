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
    private int nodeId = 0;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @BeforeEach
    void setUp() {
        int element = 1;
        binaryTreeRootNode = new BinaryTreeNode(generateNodeId(), element);
    }

    private int generateNodeId() {
        nodeId++;
        return nodeId -1;
    }

    @Test
    void getNodeIdRoot() {
        assertEquals(0, binaryTreeRootNode.getNodeId());
    }

    @Test
    void getNodeIdLeftChild() {
        int elementA = 2;
        BinaryTreeNode binaryTreeNodeLeft;
        binaryTreeNodeLeft = new BinaryTreeNode(generateNodeId(), elementA, binaryTreeRootNode);
        binaryTreeRootNode.addLeftChild(binaryTreeNodeLeft);
        assertEquals(1, binaryTreeNodeLeft.getNodeId());
    }

    @Test
    void getNodeIdLeftAndRightChild() {
        int elementA = 2;
        int elementB = 3;
        BinaryTreeNode binaryTreeNodeLeft, binaryTreeNodeRight;
        binaryTreeNodeLeft = new BinaryTreeNode(generateNodeId(), elementA, binaryTreeRootNode);
        binaryTreeNodeRight = new BinaryTreeNode(generateNodeId(), elementB, binaryTreeRootNode);
        binaryTreeRootNode.addLeftChild(binaryTreeNodeLeft);

        assertEquals(1, binaryTreeNodeLeft.getNodeId());
        assertEquals(2, binaryTreeNodeRight.getNodeId());
    }

    @Test
    void setupNewTreeNodeRootNull() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Null is not allowed");

        binaryTreeRootNode = new BinaryTreeNode(generateNodeId(), null);
    }

    @Test
    void createTreeNodeNull() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Null is not allowed");

        BinaryTreeNode binaryTreeNodeLeft;
        binaryTreeNodeLeft = new BinaryTreeNode(generateNodeId(), null, binaryTreeRootNode);
        binaryTreeRootNode.addLeftChild(binaryTreeNodeLeft);
    }

    @Test
    void modifyElement() {
        int elementA = 2;
        int elementB = 3;
        BinaryTreeNode binaryTreeNodeLeft;
        binaryTreeNodeLeft = new BinaryTreeNode(generateNodeId(), elementA, binaryTreeRootNode);
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
        binaryTreeNodeLeft = new BinaryTreeNode(generateNodeId(), elementA, binaryTreeRootNode);
        binaryTreeNodeRight = new BinaryTreeNode(generateNodeId(), elementB, binaryTreeRootNode);
        binaryTreeRootNode.addLeftChild(binaryTreeNodeLeft);
        binaryTreeRootNode.addRightChild(binaryTreeNodeRight);

        assertEquals(binaryTreeNodeLeft, binaryTreeRootNode.getLeftChild());
        assertEquals(binaryTreeNodeRight, binaryTreeRootNode.getRightChild());
    }

    @Test
    void getLeftChildValue() {
        int elementA = 2;
        BinaryTreeNode binaryTreeNodeLeft;
        binaryTreeNodeLeft = new BinaryTreeNode(generateNodeId(), elementA, binaryTreeRootNode);
        binaryTreeRootNode.addLeftChild(binaryTreeNodeLeft);

        assertEquals(elementA, binaryTreeRootNode.getLeftChild().getElement());
    }

    @Test
    void getRightChildValue() {
        int elementA = 2;
        int elementB = 3;
        BinaryTreeNode binaryTreeNodeLeft, binaryTreeNodeRight;
        binaryTreeNodeLeft = new BinaryTreeNode(generateNodeId(), elementA, binaryTreeRootNode);
        binaryTreeNodeRight = new BinaryTreeNode(generateNodeId(), elementB, binaryTreeRootNode);
        binaryTreeRootNode.addLeftChild(binaryTreeNodeLeft);
        binaryTreeRootNode.addRightChild(binaryTreeNodeRight);

        assertEquals(elementA, binaryTreeRootNode.getLeftChild().getElement());
        assertEquals(elementB, binaryTreeRootNode.getRightChild().getElement());
    }

    @Test
    void getParentNode() {
        int element = 2;
        BinaryTreeNode binaryTreeNode;
        binaryTreeNode = new BinaryTreeNode(generateNodeId(), element, binaryTreeRootNode);

        assertEquals(binaryTreeRootNode, binaryTreeNode.getParentNode());
    }

    @Test
    void setParentNode() {
        int elementA = 2;
        int elementB = 3;
        BinaryTreeNode binaryTreeNode, binaryTreeNodeOther;
        binaryTreeNode = new BinaryTreeNode(generateNodeId(), elementA, binaryTreeRootNode);
        binaryTreeNodeOther = new BinaryTreeNode(generateNodeId(), elementB, binaryTreeRootNode);
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
        binaryTreeNode = new BinaryTreeNode(generateNodeId(), element, binaryTreeRootNode);

        assertFalse(binaryTreeNode.isNodeRoot());
    }

}