package tree.binarytree;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertNull;

@EnableRuleMigrationSupport
class DeleteNodeTest extends TestBase {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    void deleteLeftLeaf() {
        BinaryTreeNode root = insertNode.add(null, 6);

        insertNode.add(root, 4);
        insertNode.add(root, 2);
        insertNode.add(root, 10);
        deleteNode.delete(root, 2);

        BinaryTreeNode found2 = binarySearchTree.searchKey(root, 2);
        assertNull(found2);
    }

    @Test
    void deleteRightLeaf() {
        BinaryTreeNode root = insertNode.add(null, 6);

        insertNode.add(root, 4);
        insertNode.add(root, 2);
        insertNode.add(root, 10);
        deleteNode.delete(root, 10);

        BinaryTreeNode found10 = binarySearchTree.searchKey(root, 10);
        assertNull(found10);
    }

    @Test
    void deleteLeftSubtree() {
        BinaryTreeNode root = insertNode.add(null, 6);

        insertNode.add(root, 4);
        insertNode.add(root, 2);
        insertNode.add(root, 10);
        deleteNode.delete(root, 4);

        BinaryTreeNode found4 = binarySearchTree.searchKey(root, 4);
        assertNull(found4);
    }

    @Test
    void deleteRightSubtree() {
        BinaryTreeNode root = insertNode.add(null, 6);

        insertNode.add(root, 4);
        insertNode.add(root, 2);
        insertNode.add(root, 10);
        insertNode.add(root, 8);
        deleteNode.delete(root, 10);

        BinaryTreeNode found10 = binarySearchTree.searchKey(root, 10);
        assertNull(found10);
    }

    @Test
    void deleteFullSubtree() {
        expectedException.expect(NullPointerException.class);

        BinaryTreeNode root = insertNode.add(null, 6);

        insertNode.add(root, 4);
        insertNode.add(root, 2);
        insertNode.add(root, 10);
        insertNode.add(root, 8);
        insertNode.add(root, 11);
        deleteNode.delete(root, 10);
    }

}