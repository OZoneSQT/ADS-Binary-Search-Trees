package tree.binarytree;

/*
 * Copyright (c) 2021
 *
 * OZ1SQT, Michel S. E. Sommer
 * https://Seahawk.dk
 */

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

@EnableRuleMigrationSupport
class BinarySearchTreeTest extends TestBase {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void addFourNodes() {
        BinaryTreeNode root = insertNode.add(null, 6);

        binarySearchTree.addElement(null,6);
        assertEquals(6, root.getElement());

        binarySearchTree.addElement(root, 4);
        assertEquals(4, root.getLeftChild().getElement());

        binarySearchTree.addElement(root, 4);
        assertEquals(4, root.getLeftChild().getElement());

        binarySearchTree.addElement(root, 10);
        assertEquals(10, root.getRightChild().getElement());

    }

    @Test
    void deleteLeftLeaf() {
        BinaryTreeNode root = insertNode.add(null, 6);

        binarySearchTree.addElement(root, 4);
        binarySearchTree.addElement(root, 2);
        binarySearchTree.addElement(root, 10);
        binarySearchTree.removeElement(root, 2);

        BinaryTreeNode found2 = binarySearchTree.searchKey(root, 2);
        assertNull(found2);
    }

    @Test
    void deleteRightLeaf() {
        BinaryTreeNode root = insertNode.add(null, 6);

        binarySearchTree.addElement(root, 4);
        binarySearchTree.addElement(root, 2);
        binarySearchTree.addElement(root, 10);
        binarySearchTree.removeElement(root, 10);

        BinaryTreeNode found10 = binarySearchTree.searchKey(root, 10);
        assertNull(found10);
    }

    @Test
    void deleteLeftSubtree() {
        BinaryTreeNode root = insertNode.add(null, 6);

        binarySearchTree.addElement(root, 4);
        binarySearchTree.addElement(root, 2);
        binarySearchTree.addElement(root, 10);
        binarySearchTree.removeElement(root, 4);

        BinaryTreeNode found4 = binarySearchTree.searchKey(root, 4);
        assertNull(found4);
    }

    @Test
    void deleteRightSubtree() {
        BinaryTreeNode root = insertNode.add(null, 6);

        binarySearchTree.addElement(root, 4);
        binarySearchTree.addElement(root, 2);
        binarySearchTree.addElement(root, 10);
        binarySearchTree.addElement(root, 8);
        binarySearchTree.removeElement(root, 10);

        BinaryTreeNode found10 = binarySearchTree.searchKey(root, 10);
        assertNull(found10);
    }

    @Test
    void deleteFullSubtree() {
        expectedException.expect(NullPointerException.class);

        BinaryTreeNode root = insertNode.add(null, 6);

        binarySearchTree.addElement(root, 4);
        binarySearchTree.addElement(root, 2);
        binarySearchTree.addElement(root, 10);
        binarySearchTree.addElement(root, 8);
        binarySearchTree.addElement(root, 11);
        binarySearchTree.removeElement(root, 10);

        BinaryTreeNode found10 = binarySearchTree.searchKey(root, 10);

    }

    @Test
    void removeAllOccurrences() {
    }

    @Test
    void getRoot() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void findMax() {
    }

    @Test
    void findMin() {
    }

    @Test
    void removeMin() {
    }

    @Test
    void removeMax() {
    }

    @Test
    void searchKey() {
    }

    @Test
    void testToString() {
    }

}