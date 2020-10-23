package tree.binarytree;

import tree.util.QueueFIFO;
import tree.util.QueueInterface;

public class BinaryTree {
    private BinarySearchTree binarySearchTree;


    public BinaryTree() {
    }

    public BinaryTree(BinarySearchTree binarySearchTree) {
        this.binarySearchTree = binarySearchTree;
    }

    public BinaryTreeNode getRoot() {
        return binarySearchTree.getRoot();
    }

    public boolean isEmpty() {
        boolean isEmpty = true;
        if (getRoot() != null) {
            isEmpty = false;
        }
        return isEmpty;
    }

    public int size() {
        return 0;
    }

    public boolean contains(int findingValue) {
        boolean result = false;
        for (int i = 0; i < size(); i++) {
            if (binarySearchTree.searchKey(getRoot(), findingValue) != null) {
                result = true;
            }
        }
        return result;
    }

    public void inOrder(final BinaryTreeNode root) {
        if (root != null) {
            inOrder(root.getLeftChild());
            print(root);
            inOrder(root.getRightChild());
        }
    }

    public void preOrder(final BinaryTreeNode root) {
        if (root != null) {
            print(root);
            preOrder(root.getLeftChild());
            preOrder(root.getRightChild());
        }
    }

    public void postOrder(final BinaryTreeNode root) {
        if (root != null) {
            preOrder(root.getLeftChild());
            preOrder(root.getRightChild());
            print(root);
        }
    }

    public void levelOrder(final BinaryTreeNode root) {
        QueueInterface<BinaryTreeNode> fifo = new QueueFIFO<>(41);
        if (root == null) {
            return;
        }

        fifo.enqueue(root);
        while (!fifo.isEmpty()) {
            BinaryTreeNode tmpNode = fifo.dequeue();
            if (tmpNode.getLeftChild() != null) {
                fifo.enqueue(tmpNode.getLeftChild());
            }
            if (tmpNode.getRightChild() != null) {
                fifo.enqueue(tmpNode.getRightChild());
            }
            print(tmpNode);
        }

    }

    public int height(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode == null) {
            return 0;
        } else {
            int leftDepth = height(binaryTreeNode.getLeftChild());
            int rightDepth = height(binaryTreeNode.getRightChild());

            if (leftDepth > rightDepth)
                return (leftDepth++);
            else
                return (rightDepth++);
        }
    }

    private void print(final BinaryTreeNode root) {
        System.out.print(root.getElement() + " ");
    }

}
