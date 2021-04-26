package tree.binarytree;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

class BinaryTreeTest extends TestBase {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

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
        expectedException.expect(NullPointerException.class);
        BinaryTreeNode root = insertNode.add(null, 6);

        binaryTree.getRoot();


        /*
        expectedException.expect(NullPointerException.class);

        BinaryTreeNode root = new BinaryTreeNode(9);

        insertNode.add(root, 4);
        insertNode.add(root, 2);
        insertNode.add(root, 10);

        System.out.println(binaryTree.getRoot().getElement());

         */
    }

    @Test
    void isEmpty() {
        assertTrue(binarySearchTree.isEmpty());
    }

    @Test
    void sizeZero() {
        BinaryTreeNode root = null;

        assertEquals(0, binaryTree.size(root));
    }

    @Test
    void sizeOne() {
        BinaryTreeNode root = insertNode.add(null, 6);

        assertEquals(1, binaryTree.size(root));
    }

    @Test
    void sizeMore() {
        BinaryTreeNode root = insertNode.add(null, 6);
        insertNode.add(root, 4);
        insertNode.add(root, 3);
        insertNode.add(root, 1);
        insertNode.add(root, 7);

        assertEquals(5, binaryTree.size(root));
    }

    @Test
    void contains() {

    }

    @Test
    void heightZero() {
        BinaryTreeNode root = null;

        assertEquals(0, binaryTree.height(root));
    }

    @Test
    void heightOne() {
        BinaryTreeNode root = insertNode.add(null, 6);

        assertEquals(0, binaryTree.height(root));
    }

    @Test
    void heightMore() {

    }

}