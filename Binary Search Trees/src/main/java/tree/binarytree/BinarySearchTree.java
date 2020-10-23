package tree.binarytree;

import tree.util.QueueInterface;

public class BinarySearchTree extends BinaryTree {
    private BinaryTreeNode root;
    private InsertNode insertNode = new InsertNode();
    private DeleteNode deleteNode = new DeleteNode();
    private QueueInterface queueInterface;

    public BinarySearchTree(QueueInterface queueInterface) {
        super();
        this.queueInterface = queueInterface;
        deleteNode.setBinarySearchTree(this);
    }

    public void addElement(final int value) {
        root = insertNode.add(root, value);
    }

    public void removeElement(final int deletingValue) {
        root = deleteNode.delete(root, deletingValue);
    }

    public void removeAllOccurrences(final int deletingValue) {
        for (int i = 0; i < queueInterface.size(); i++) {
            BinaryTreeNode treeNode = searchKey(root, deletingValue);
            if (treeNode.getElement() == deletingValue) {
                removeElement(deletingValue);
            }
        }
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Integer findMax(final BinaryTreeNode root) {
        return root.getRightChild() == null ? root.getElement() : findMax(root.getRightChild());
    }

    public int findMin(final BinaryTreeNode root) {
        return root.getLeftChild() == null ? root.getElement() : findMin(root.getLeftChild());
    }

    public void removeMin() {
        int element = findMin(root);
        removeElement(element);
    }

    public void removeMax() {
        int element = findMax(root);
        removeElement(element);
    }

    public BinaryTreeNode searchKey(final BinaryTreeNode treeRoot, final int findingValue) {
        if (treeRoot == null) {
            return null;
        }

        if (findingValue == treeRoot.getElement()) {
            return treeRoot;
        } else if (findingValue > treeRoot.getElement()) {
            return searchKey(treeRoot.getRightChild(), findingValue);
        } else {
            return searchKey(treeRoot.getLeftChild(), findingValue);
        }
    }

    public String toString() {
        return "BinarySearchTree [root=" + root + "]";
    }

}
