package tree.binarytree;

/*
 * Copyright (c) 2021
 *
 * OZ1SQT, Michel S. E. Sommer
 * https://Seahawk.dk
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeNodeTest {

    @Test
    void setElement() {
        BinaryTreeNode node = null;
        assertNull(node);
        node = new BinaryTreeNode(3);
        assertNotNull(node);
        assertFalse(node.getElement() == null);
        assertEquals(node.getElement(), 3);
    }

    @Test
    void getElement() {
        BinaryTreeNode node = null;
        assertNull(node);
        node = new BinaryTreeNode(3);
        assertNotNull(node);
        assertNotEquals(node.getElement(), 5);
        assertEquals(node.getElement(), 3);
        assertNull(node.getRightChild());
        assertNull(node.getLeftChild());
    }

    @Test
    void addLeftChild() {
        BinaryTreeNode node = new BinaryTreeNode(3);
        assertFalse(node.getElement() == null);
        assertEquals(node.getElement(), 3);
        assertEquals(node.getLeftChild(), null);
        assertEquals(node.getRightChild(), null);
        node.addLeftChild(new BinaryTreeNode(2));
        assertEquals(node.getLeftChild().getElement(), 2);
        assertTrue(node.getRightChild() == null);
    }

    @Test
    void addRightChild() {
        BinaryTreeNode node = null;
        node = new BinaryTreeNode(3);
        assertEquals(node.getLeftChild(), null);
        assertEquals(node.getRightChild(), null);
        node.addRightChild(new BinaryTreeNode(5));
        assertNotEquals(node.getRightChild().getElement(), 3);
        assertEquals(node.getRightChild().getElement(), 5);
        assertTrue(node.getLeftChild() == null);
    }

    @Test
    void getLeftChild() {
        BinaryTreeNode node = null;

        node = new BinaryTreeNode(3, new BinaryTreeNode(7), null);
        assertNull(node.getRightChild());
        assertEquals(node.getLeftChild().getElement(), 7);
    }

    @Test
    void getRightChild() {
        BinaryTreeNode node = null;
        node = new BinaryTreeNode(3, null, new BinaryTreeNode(7));
        assertNull(node.getRightChild().getLeftChild());
        assertEquals(node.getRightChild().getRightChild().getElement(), 11);
        assertEquals(node.getRightChild().getElement(), 7);
    }
}