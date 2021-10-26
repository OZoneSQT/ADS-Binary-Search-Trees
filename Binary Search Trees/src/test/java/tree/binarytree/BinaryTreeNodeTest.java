package tree.binarytree;

/*
 * Copyright (c) 2021
 *
 * OZ1SQT, Michel S. E. Sommer
 * https://Seahawk.dk
 */

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

class BinaryTreeNodeTest extends TestBase {

    BinaryTreeNode binaryNode = new BinaryTreeNode(1);

    @Test
    public void leafNode() {
        assertEquals(1, binaryNode.getElement());
        assertNull(binaryNode.getLeftChild());
        assertNull(binaryNode.getRightChild());
        System.out.println(binaryNode.toString());
    }

    @Test
    public void hasLeftNode() {
        binaryNode.addLeftChild(new BinaryTreeNode(0));
        assertEquals(1, binaryNode.getElement());
        assertNotNull(binaryNode.getLeftChild());
        assertEquals(0, binaryNode.getLeftChild().getElement());
        System.out.println(binaryNode.toString());
    }

    @Test
    public void hasRightNode() {
        binaryNode.addRightChild(new BinaryTreeNode(3));
        assertEquals(1, binaryNode.getElement());
        assertNotNull(binaryNode.getRightChild());
        assertEquals(3, binaryNode.getRightChild().getElement());
        System.out.println(binaryNode.toString());
    }

    @Test
    public void hasTwoNodes() {
        binaryNode.addLeftChild(new BinaryTreeNode(0));
        binaryNode.addRightChild(new BinaryTreeNode(3));
        assertEquals(0, binaryNode.getLeftChild().getElement());
        assertEquals(3, binaryNode.getRightChild().getElement());
        System.out.println(binaryNode.toString());
    }

}