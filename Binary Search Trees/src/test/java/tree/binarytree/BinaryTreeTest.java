package tree.binarytree;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class BinaryTreeTest extends TestBase {

    @Test
    public void searchNode() {
        BinaryTreeNode root = insertNode.add(null, 6);

        insertNode.add(root, 4);
        insertNode.add(root, 2);
        insertNode.add(root, 10);

        BinaryTreeNode found12 = binarySearchTree.searchKey(root, 22);
        assertNull(found12);

        BinaryTreeNode found2 = binarySearchTree.searchKey(root, 2);
        assertNotNull(found2);
        assertEquals(2, found2.getElement());

        int max = binarySearchTree.findMax(root);
        assertEquals(10, max);

        int min = binarySearchTree.findMin(root);
        assertEquals(2, min);
    }

    @Test
    void getRoot() {
        BinaryTreeNode root = insertNode.add(null, 6);

        insertNode.add(root, 4);
        insertNode.add(root, 2);
        insertNode.add(root, 10);

        assertEquals(null, binaryTree.getRoot());
    }

    @Test
    void isEmpty() {
        assertTrue(binarySearchTree.isEmpty());
    }

    @Test
    void size() {
        BinaryTreeNode root = insertNode.add(null, 6);

        assertEquals(0, binaryTree.size());
    }

    @Test
    void contains() {

    }

    @Test
    void height() {

    }

}