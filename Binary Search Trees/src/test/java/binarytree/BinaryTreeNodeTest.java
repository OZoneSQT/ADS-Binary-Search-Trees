package binarytree;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeNodeTest {
    private BinaryTreeNode binaryTreeRootNode;
    @BeforeEach
    void setUp() {
        int element = 1;
        binaryTreeRootNode = new BinaryTreeNode(element);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void setElement() {

    }

    @Test
    void getElement() {
    }

    @Test
    void addLeftChild() {
    }

    @Test
    void addRightChild() {
    }

    @Test
    void getLeftChild() {
    }

    @Test
    void getRightChild() {
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