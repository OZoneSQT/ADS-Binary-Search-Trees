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

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    //TODO Keeps overwriting root, seance root keeps holding the value null
    @Test
    void insertElement() {
        BinarySearchTree<Integer> tree = null;
        BinarySearchTree<Integer> finalTree = tree;
        Assertions.assertThrows(NullPointerException.class, () -> {
            finalTree.size();});
        tree = new BinarySearchTree<>();
        tree.setRoot(new BinarySearchTreeNode<>(99, null, null));
        System.out.println(tree.getRootNode().getElement());
        assertFalse(tree.contains(1));
        System.out.println(tree.getRoot());
        tree.insertElement(0);
        System.out.println(tree.inOrder());
        tree.insertElement(1);
        System.out.println(tree.inOrder());
        tree.insertElement(2);
        System.out.println(tree.inOrder());
        tree.insertElement(3);
        System.out.println(tree.inOrder());
        tree.insertElement(4);
        System.out.println(tree.inOrder());
        tree.insertElement(5);
        System.out.println(tree.getRootNode().getElement());
        assertFalse(tree.isEmpty());
        System.out.println(tree.inOrder());
        // assertTrue(tree.contains(0));
        // assertTrue(tree.contains(1));
        // assertTrue(tree.contains(2));
        // assertTrue(tree.contains(3));
        // assertTrue(tree.contains(4));
        assertTrue(tree.contains(5));
        // assertFalse(tree.contains(6));
    }

    @Test
    void removeElement() {
        BinarySearchTree tree = new BinarySearchTree();
        assertTrue(tree.isEmpty());
        tree.setRoot(new BinarySearchTreeNode(1));
        System.out.println(tree.getRootNode().getElement());
        tree.getRootNode().addLeftChild(new BinarySearchTreeNode(2, new BinarySearchTreeNode(3,
                new BinarySearchTreeNode(4), new BinarySearchTreeNode(5)),
                new BinarySearchTreeNode(6, new BinarySearchTreeNode(7),
                        new BinarySearchTreeNode(8, new BinarySearchTreeNode(9), null))));

        assertTrue(tree.contains(3));
        assertTrue(tree.contains(4));
        assertTrue(tree.contains(5));

        assertTrue(tree.contains(2));
        tree.removeElement(2);
        assertFalse(tree.contains(2));

        assertTrue(tree.contains(9));
        tree.removeElement(9);
        assertFalse(tree.contains(9));

        assertTrue(tree.contains(3));
        assertTrue(tree.contains(4));
        assertTrue(tree.contains(5));
    }

    @Test
    void findMin() {
        BinarySearchTree tree = new BinarySearchTree();
        assertTrue(tree.isEmpty());
        tree.setRoot(new BinarySearchTreeNode(1));
        System.out.println(tree.getRootNode().getElement());
        tree.getRootNode().addLeftChild(new BinarySearchTreeNode(2, new BinarySearchTreeNode(3,
                new BinarySearchTreeNode(4), new BinarySearchTreeNode(5)),
                new BinarySearchTreeNode(6, new BinarySearchTreeNode(7),
                        new BinarySearchTreeNode(8, new BinarySearchTreeNode(9), null))));
        System.out.println(tree.inOrder());
        System.out.println(tree.findMin());
        assertEquals(1, tree.findMin());
        assertNotEquals(7, tree.findMin());
    }

    @Test
    void findMax() {
        BinarySearchTree tree = new BinarySearchTree();
        assertTrue(tree.isEmpty());
        tree.setRoot(new BinarySearchTreeNode(1));
        System.out.println(tree.getRootNode().getElement());
        tree.getRootNode().addLeftChild(new BinarySearchTreeNode(2, new BinarySearchTreeNode(3,
                new BinarySearchTreeNode(4), new BinarySearchTreeNode(5)),
                new BinarySearchTreeNode(6, new BinarySearchTreeNode(7),
                        new BinarySearchTreeNode(8, new BinarySearchTreeNode(9), null))));
        System.out.println(tree.inOrder());
        System.out.println(tree.findMin());
        assertEquals(9, tree.findMax());
        assertNotEquals(7, tree.findMax());
    }

    @Test
    void contains() {
        BinarySearchTree tree = new BinarySearchTree();
        assertTrue(tree.isEmpty());
        tree.setRoot(new BinarySearchTreeNode(1));
        tree.getRootNode().addLeftChild(new BinarySearchTreeNode(2, new BinarySearchTreeNode(3,
                new BinarySearchTreeNode(4), new BinarySearchTreeNode(5)),
                new BinarySearchTreeNode(6, new BinarySearchTreeNode(7),
                        new BinarySearchTreeNode(8, new BinarySearchTreeNode(9), null))));
        assertTrue(tree.contains(2));   //TODO all assertTrue fails, Is it the right root that is called?
        assertTrue(tree.contains(6));
        assertTrue(tree.contains(7));
        assertFalse(tree.contains(0));
        assertFalse(tree.contains(10));
    }

    @Test
    void rebalance() {
        BinarySearchTree tree = new BinarySearchTree();
        assertTrue(tree.isEmpty());
        tree.setRoot(new BinarySearchTreeNode(1));
        tree.getRootNode().addLeftChild(new BinarySearchTreeNode(2, new BinarySearchTreeNode(3,
                new BinarySearchTreeNode(4), new BinarySearchTreeNode(5)),
                new BinarySearchTreeNode(6, new BinarySearchTreeNode(7),
                        new BinarySearchTreeNode(8, new BinarySearchTreeNode(9), null))));
        ArrayList<Integer> pre = tree.inOrder();
        System.out.println(pre);
        tree.rebalance();
        ArrayList<Integer> post = tree.inOrder();
        System.out.println(post);
        assertFalse(pre.equals(post));
    }

}