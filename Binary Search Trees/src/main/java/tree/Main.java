package tree;

import tree.binarytree.BinarySearchTree;
import tree.binarytree.BinaryTree;
import tree.binarytree.BinaryTreeNode;
import tree.util.QueueFIFO;
import tree.util.QueueInterface;

public class Main {

    public static void main(String[] args) {
        QueueFIFO<BinaryTreeNode> queueFIFO = new QueueFIFO<>(31);
        QueueInterface queueInterface = queueFIFO;
        BinarySearchTree binarySearchTree = new BinarySearchTree(queueInterface);
        BinaryTree binaryTree = new BinaryTree(queueInterface, binarySearchTree);





    }

}
