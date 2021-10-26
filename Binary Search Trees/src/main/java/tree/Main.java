package tree;

/*
 * Copyright (c) $originalComment.match("Copyright \(c\) (\d+)", 1, "-")$today.year.
 *
 * OZ1SQT, Michel S. E. Sommer
 * https://Seahawk.dk
 */

import tree.binarytree.BinarySearchTree;
import tree.binarytree.BinaryTreeNode;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        BinaryTreeNode treeRoot = new BinaryTreeNode(1);
        binarySearchTree.addElement(treeRoot, 6);
        binarySearchTree.addElement(treeRoot, 4);
        binarySearchTree.addElement(treeRoot, 8);
        binarySearchTree.addElement(treeRoot, 32);
        binarySearchTree.addElement(treeRoot, 10);
        binarySearchTree.addElement(treeRoot, 7);
        binarySearchTree.addElement(treeRoot, 31);
        binarySearchTree.addElement(treeRoot, 5);
        binarySearchTree.addElement(treeRoot, 99);
        binarySearchTree.addElement(treeRoot, 9);
        binarySearchTree.addElement(treeRoot, 11);

        System.out.print("\nInOrder : ");
        binarySearchTree.inOrder(binarySearchTree.getRoot());

        System.out.print("\nLevelOrder: ");
        binarySearchTree.levelOrder(binarySearchTree.getRoot());

        System.out.print("\nPreOrder: ");
        binarySearchTree.preOrder(binarySearchTree.getRoot());

        System.out.print("\nPostOrder: ");
        binarySearchTree.postOrder(binarySearchTree.getRoot());

    }

}
