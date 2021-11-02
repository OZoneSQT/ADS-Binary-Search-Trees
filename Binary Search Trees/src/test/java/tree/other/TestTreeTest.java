package tree.other;

import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import tree.binarytree.BinarySearchTree;
import tree.binarytree.BinarySearchTreeNode;
import tree.binarytree.BinaryTree;
import tree.binarytree.BinaryTreeNode;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TestTreeTest {
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    void getRoot() {
        TestNode node = null;
        TestTree tree = new TestTree();
        node = tree.getRoot();
        assertNull(node);
        tree.setRoot(new TestNode("F"));
        assertNotNull(tree.getRoot());
    }

    @Test
    void setRoot() {
        TestNode root = new TestNode("F");
        TestTree tree = new TestTree();
        tree.setRoot(root);
        assertEquals(root, tree.getRoot());
        assertEquals(root.getElement(), tree.getRoot().getElement());
    }

    @Test
    void isEmpty() {
        TestNode root = new TestNode("F");
        TestTree tree = new TestTree();
        assertTrue(tree.isEmpty());
        tree.setRoot(root);
        assertFalse(tree.isEmpty());
    }

    @Test
    void size() {
        TestNode root = new TestNode("F");
        TestTree tree = new TestTree();
        assertTrue(tree.isEmpty());
        Assertions.assertThrows(NullPointerException.class, () -> {
            tree.size();});
        tree.setRoot(root);
        assertFalse(tree.isEmpty());
        assertEquals(tree.size(), 1);
    }

    @Test
    void contains() {
        TestNode root = new TestNode("F");
        TestTree tree = new TestTree();
        assertTrue(tree.isEmpty());
        tree.setRoot(root);
        assertFalse(tree.isEmpty());
        assertTrue(tree.contains("F"));
        root.addRightChild(new TestNode("T"));
        assertTrue(tree.contains("F"));
        assertTrue(tree.contains("T"));
        assertFalse(tree.contains("P"));
    }

    @Test
    void inOrder() {
        TestNode root = new TestNode("A");
        TestTree tree = new TestTree();
        assertTrue(tree.isEmpty());
        tree.setRoot(root);
        root.addLeftChild(new TestNode("B", new TestNode("C"), new TestNode("D")));
        System.out.println(tree.inOrder());
    }

    @Test
    void preOrder() {
        TestNode root = new TestNode("A");
        TestTree tree = new TestTree();
        assertTrue(tree.isEmpty());
        tree.setRoot(root);
        root.addLeftChild(new TestNode("B", new TestNode("C"), new TestNode("D")));
        System.out.println(tree.preOrder());
    }

    @Test
    void postOrder() {
        TestNode root = new TestNode("A");
        TestTree tree = new TestTree();
        assertTrue(tree.isEmpty());
        tree.setRoot(root);
        root.addLeftChild(new TestNode("B", new TestNode("C"), new TestNode("D")));
        System.out.println(tree.postOrder());
    }

    @Test
    void levelOrder() {
        TestNode root = new TestNode("A");
        TestTree tree = new TestTree();
        assertTrue(tree.isEmpty());
        tree.setRoot(root);
        root.addLeftChild(new TestNode("B", new TestNode("C"), new TestNode("D")));
        System.out.println(tree.levelOrder());
    }

    @Test
    void height() {
        TestNode root = new TestNode("A");
        TestTree tree = new TestTree();
        assertTrue(tree.isEmpty());
        tree.setRoot(root);
        root.addLeftChild(new TestNode("B", new TestNode("C"), new TestNode("D")));
        // System.out.println(tree.height());
        assertEquals(tree.height(), 2);
    }

    @Test
    void insertElement() {
        TestTree<Integer> tree = null;
        TestTree<Integer> finalTree = tree;
        Assertions.assertThrows(NullPointerException.class, () -> {
            finalTree.size();});
        tree = new TestTree<>();
        tree.setRoot(new TestNode<>(99, null, null));
        System.out.println(tree.getRoot().getElement());
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
        System.out.println(tree.getRoot().getElement());

        assertFalse(tree.isEmpty());

        System.out.println(tree.inOrder());

        assertTrue(tree.contains(0));
        assertTrue(tree.contains(1));
        assertTrue(tree.contains(2));
        assertTrue(tree.contains(3));
        assertTrue(tree.contains(4));
        assertTrue(tree.contains(5));
        assertFalse(tree.contains(6));
    }

    @Test
    void removeElement() {
        TestTree tree = new TestTree();
        assertTrue(tree.isEmpty());
        tree.setRoot(new TestNode(1));
        System.out.println(tree.getRoot().getElement());
        tree.getRoot().addLeftChild(new TestNode(2, new TestNode(3,
                new TestNode(4), new TestNode(5)),
                new TestNode(6, new TestNode(7),
                        new TestNode(8, new TestNode(9), null))));

        System.out.println(tree.inOrder());
    //    assertTrue(tree.contains(3));
    //   assertTrue(tree.contains(4));
    //    assertTrue(tree.contains(5));

    //    assertTrue(tree.contains(2));
        tree.removeElement(2);
    //    assertFalse(tree.contains(2));

   //     assertTrue(tree.contains(9));
        tree.removeElement(9);
    //    assertFalse(tree.contains(9));
        System.out.println(tree.inOrder());
  //      assertTrue(tree.contains(3));
   //     assertTrue(tree.contains(4));
   //     assertTrue(tree.contains(5));
    }

    @Test
    void findMin() {
        TestTree tree = new TestTree();
        assertTrue(tree.isEmpty());
        tree.setRoot(new TestNode(1));
        System.out.println(tree.getRoot().getElement());
        tree.getRoot().addLeftChild(new TestNode(2, new TestNode(3,
                new TestNode(4), new TestNode(5)),
                new TestNode(6, new TestNode(7),
                        new TestNode(8, new TestNode(9), null))));
        System.out.println(tree.inOrder());
        System.out.println(tree.findMin());
        assertEquals(1, tree.findMin());
        assertNotEquals(7, tree.findMin());
    }

    @Test
    void findMax() {
        TestTree tree = new TestTree();
        assertTrue(tree.isEmpty());
        tree.setRoot(new TestNode(1));
        System.out.println(tree.getRoot().getElement());
        tree.getRoot().addLeftChild(new TestNode(2, new TestNode(3,
                new TestNode(4), new TestNode(5)),
                new TestNode(6, new TestNode(7),
                        new TestNode(8, new TestNode(9), null))));
        System.out.println(tree.inOrder());
        System.out.println(tree.findMin());
        assertEquals(9, tree.findMax());
        assertNotEquals(7, tree.findMax());
    }

    @Test
    void rebalance() {
        TestTree tree = new TestTree();
        assertTrue(tree.isEmpty());
        tree.setRoot(new TestNode(1));
        tree.getRoot().addLeftChild(new TestNode(2, new TestNode(3,
                new TestNode(4), new TestNode(5)),
                new TestNode(6, new TestNode(7),
                        new TestNode(8, new TestNode(9), null))));
        ArrayList<Integer> pre = tree.inOrder();
        System.out.println(pre);
        tree.rebalance();
        ArrayList<Integer> post = tree.inOrder();
        System.out.println(post);
        assertFalse(pre.equals(post));
    }
}