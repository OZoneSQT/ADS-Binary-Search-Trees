package tree.binarytree;

/*
 * Copyright (c) $originalComment.match("Copyright \(c\) (\d+)", 1, "-")$today.year.
 *
 * OZ1SQT, Michel S. E. Sommer
 * https://Seahawk.dk
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeNodeTest extends TestBase {

    @Test
    void setAndGetParent() {
        BinaryTreeNode root = new BinaryTreeNode(6);
        BinaryTreeNode treeNode = new BinaryTreeNode(7);

        root.setParent(treeNode);
        assertEquals(treeNode, root.getPatent());
    }

}