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

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    void getRoot() {
        BinaryTreeNode node = null;
        BinaryTree tree = new BinaryTree();
        node = tree.getRoot();
        assertNull(node);
        tree.setRoot(new BinaryTreeNode("F"));
        assertNotNull(tree.getRoot());
    }

    @Test
    void setRoot() {
        BinaryTreeNode root = new BinaryTreeNode("F");
        BinaryTree tree = new BinaryTree();
        tree.setRoot(root);
        assertEquals(root, tree.getRoot());
        assertEquals(root.getElement(), tree.getRoot().getElement());
    }

    @Test
    void isEmpty() {
        BinaryTreeNode root = new BinaryTreeNode("F");
        BinaryTree tree = new BinaryTree();
        assertTrue(tree.isEmpty());
        tree.setRoot(root);
        assertFalse(tree.isEmpty());
    }

    @Test
    void size() {
        BinaryTreeNode root = new BinaryTreeNode("F");
        BinaryTree tree = new BinaryTree();
        assertTrue(tree.isEmpty());
        Assertions.assertThrows(NullPointerException.class, () -> {
            tree.size();});
        tree.setRoot(root);
        assertFalse(tree.isEmpty());
        assertEquals(tree.size(), 1);
    }

    @Test
    void contains() {
        BinaryTreeNode root = new BinaryTreeNode("F");
        BinaryTree tree = new BinaryTree();
        assertTrue(tree.isEmpty());
        tree.setRoot(root);
        assertFalse(tree.isEmpty());
        assertTrue(tree.contains("F"));
        root.addRightChild(new BinaryTreeNode("T"));
        assertTrue(tree.contains("F"));
        assertTrue(tree.contains("T"));
        assertFalse(tree.contains("P"));
    }

    @Test
    void inOrder() {
        BinaryTreeNode root = new BinaryTreeNode("A");
        BinaryTree tree = new BinaryTree();
        assertTrue(tree.isEmpty());
        tree.setRoot(root);
        root.addLeftChild(new BinaryTreeNode("B", new BinaryTreeNode("C"), new BinaryTreeNode("D")));
        System.out.println(tree.inOrder());
    }

    @Test
    void preOrder() {
        BinaryTreeNode root = new BinaryTreeNode("A");
        BinaryTree tree = new BinaryTree();
        assertTrue(tree.isEmpty());
        tree.setRoot(root);
        root.addLeftChild(new BinaryTreeNode("B", new BinaryTreeNode("C"), new BinaryTreeNode("D")));
        System.out.println(tree.preOrder());
    }

    @Test
    void postOrder() {
        BinaryTreeNode root = new BinaryTreeNode("A");
        BinaryTree tree = new BinaryTree();
        assertTrue(tree.isEmpty());
        tree.setRoot(root);
        root.addLeftChild(new BinaryTreeNode("B", new BinaryTreeNode("C"), new BinaryTreeNode("D")));
        System.out.println(tree.postOrder());
    }

    @Test
    void levelOrder() {
        BinaryTreeNode root = new BinaryTreeNode("A");
        BinaryTree tree = new BinaryTree();
        assertTrue(tree.isEmpty());
        tree.setRoot(root);
        root.addLeftChild(new BinaryTreeNode("B", new BinaryTreeNode("C"), new BinaryTreeNode("D")));
        System.out.println(tree.levelOrder());
    }

    @Test
    void height() {
        BinaryTreeNode root = new BinaryTreeNode("A");
        BinaryTree tree = new BinaryTree();
        assertTrue(tree.isEmpty());
        tree.setRoot(root);
        root.addLeftChild(new BinaryTreeNode("B", new BinaryTreeNode("C"), new BinaryTreeNode("D")));
        // System.out.println(tree.height());
        assertEquals(tree.height(), 2);
    }

}