package tree.binarytree;

/*
 * Copyright (c) 2021
 *
 * OZ1SQT, Michel S. E. Sommer
 * https://Seahawk.dk
 */

import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

class BinarySearchTreeNodeTest {
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    void getLeftChild() {
       BinarySearchTreeNode node = null;
       assertNull(node);
       BinarySearchTreeNode finalNode = node;
       Assertions.assertThrows(NullPointerException.class, () -> {
            finalNode.getLeftChild();});
       Assertions.assertThrows(NullPointerException.class, () -> {
           finalNode.addLeftChild(new BinarySearchTreeNode("A"));});
       node = new BinarySearchTreeNode("N", new BinarySearchTreeNode("F"), null);
       assertEquals(node.getElement(), "N");
       assertNotEquals(node.getElement(), "F");
       assertEquals(node.getLeftChild().getElement(), "F");
       assertNull(node.getRightChild());
       assertNull(node.getLeftChild().getLeftChild());
       assertNull(node.getLeftChild().getRightChild());
    }

    @Test
    void getRightChild() {
        BinarySearchTreeNode node = null;
        assertNull(node);
        BinarySearchTreeNode finalNode = node;
        Assertions.assertThrows(NullPointerException.class, () -> {
            finalNode.getLeftChild();});
        Assertions.assertThrows(NullPointerException.class, () -> {
            finalNode.addLeftChild(new BinarySearchTreeNode("A"));});
        node = new BinarySearchTreeNode(4, null, new BinarySearchTreeNode("F", new BinarySearchTreeNode("G"), null));
        assertEquals(node.getElement(), 4);
        assertNotEquals(node.getElement(), "F");
        assertEquals(node.getRightChild().getElement(), "F");
        assertNull(node.getLeftChild());
        assertNull(node.getRightChild().getRightChild());
        assertEquals(node.getRightChild().getLeftChild().getElement(), "G");
    }
}