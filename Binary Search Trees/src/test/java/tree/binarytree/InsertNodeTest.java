package tree.binarytree;

/*
 * Copyright (c) 2021
 *
 * OZ1SQT, Michel S. E. Sommer
 * https://Seahawk.dk
 */

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class InsertNodeTest extends TestBase {

    @Test
    public void addFourNodes() {
        BinaryTreeNode root = insertNode.add(null, 6);
        assertEquals(6, root.getElement());

        insertNode.add(root, 4);
        assertEquals(4, root.getLeftChild().getElement());

        insertNode.add(root, 4);
        assertEquals(4, root.getLeftChild().getElement());

        insertNode.add(root, 10);
        assertEquals(10, root.getRightChild().getElement());

    }
}