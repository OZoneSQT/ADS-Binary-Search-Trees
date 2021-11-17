package tree.binarytree;

/*
 * Copyright (c) 2021
 *
 * OZ1SQT, Michel S. E. Sommer
 * https://Seahawk.dk
 */

import tree.util.QueueFIFO;
import tree.util.QueueInterface;

import java.util.ArrayList;

public class BinaryTree<Element extends Comparable<? super Element>> {
    private BinaryTreeNode<Element> root;

    public BinaryTree() {
        this.root = null;
    }

    /**
     * Returns a reference to the root or null if tree is empty
     */
    public Element getRoot() {
        return root.getElement();
    }


    public BinaryTreeNode<Element> getRootNode() {
        return root;
    }


    /**
     * Set the root of the tree
     */
    public void setRoot(BinaryTreeNode<Element> root) {
        this.root = root;
    }

    /**
     * Determines whether the tree is empty
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Returns the number of elements in the tree size
     */
    public int size() {
        return inOrder().size();
        // return size(root);
    }

    private int size(BinaryTreeNode<Element> root){
        if(root == null) {
            return 0;
        } else {
            return 1 + size(root.getRightChild()) + size(root.getLeftChild());
        }
    }

    /**
     * Determines if an element is present in the tree
     */
    public boolean contains(Element element) {
        // boolean result = contains(root, element);
        boolean result = inOrder().contains(element);       // test method
        return result;
    }

    private boolean contains(BinaryTreeNode<Element> root, Element element) {
        if (root == null) {
            return false;
        }

        int compareResult = element.compareTo(root.getElement());

        if (compareResult < 0) {
            return contains(root.getLeftChild(), element);
        } else if (compareResult > 0) {
            return contains(root.getRightChild(), element);
        } else {
            return true;    // match
        }
    }

    /**
     * Returns a inOrder representation of the tree or null if the tree is empty
     */
    /*
    public ArrayList<AnyType> inOrder() {
        ArrayList<Element> resultArray = new ArrayList<>();
        ArrayList<AnyType> tempArray = inOrderArray();

        for (int i = 0; i < tempArray.size(); i++) {
            AnyType temp = tempArray.get(i);
            resultArray.add(temp.get(i).getElement();
        }

        return resultArray;
    }
    */

    public ArrayList<Element> inOrder() {
        ArrayList<Element> tree = new ArrayList<>();
        if (isEmpty()) {
            return null;
        }
        return traverseInOrder(root, tree);
    }

    private ArrayList<Element> traverseInOrder(BinaryTreeNode<Element> root, ArrayList<Element> tree) {
        if (root != null) {
            traverseInOrder(root.getLeftChild(), tree);
            tree.add(root.getElement());
            traverseInOrder(root.getRightChild(), tree);
        }
        return tree;
    }

    /**
     * Returns a preOrder representation of the tree or null if the tree is empty
     */
    /*
    public ArrayList<AnyType> preOrder() {
        ArrayList<Element> resultArray = new ArrayList<>();
        ArrayList<AnyType> tempArray = preOrderArray();

        for (int i = 0; i < tempArray.size(); i++) {
            AnyType temp = tempArray.get(i);
            resultArray.add(temp.get(i).getElement();
        }

        return resultArray;
    }
    */

    public ArrayList<Element> preOrder() {
        ArrayList<Element> tree = new ArrayList<>();
        if (isEmpty()) {
            return null;
        }
        return traversePreOrder(root, tree);
    }

    private ArrayList<Element> traversePreOrder(BinaryTreeNode<Element> root, ArrayList<Element> tree) {
        if (root != null) {
            tree.add(root.getElement());
            traversePreOrder(root.getLeftChild(), tree);
            traversePreOrder(root.getRightChild(), tree);
        }
        return tree;
    }

    /**
     * Returns a postOrder representation of the tree or null if the tree is empty
     */
    /*
    public ArrayList<Element> postOrder() {
        ArrayList<Element> resultArray = new ArrayList<>();
        ArrayList<AnyType> tempArray = postOrderArray();

        for (int i = 0; i < tempArray.size(); i++) {
            AnyType temp = tempArray.get(i);
            resultArray.add(temp.get(i).getElement();
        }

        return resultArray;
    }
    */

    public ArrayList<Element> postOrder() {
        ArrayList<Element> output = new ArrayList<>();
        if (isEmpty()) {
            return null;
        }

        return traversePostOrder(root, output);
    }

    private ArrayList<Element> traversePostOrder(BinaryTreeNode<Element> root, ArrayList<Element> output) {
        if (root != null) {
            traversePreOrder(root.getLeftChild(), output);
            traversePreOrder(root.getRightChild(), output);
            output.add(root.getElement());
        }
        return output;
    }

    /**
     * Returns a level Order representation of the tree or null if the tree is empty
     */
    /*
    public ArrayList<Element> levelOrder() {
        ArrayList<Element> resultArray = new ArrayList<>();
        ArrayList<AnyType> tempArray = levelOrderArray();

        for (int i = 0; i < tempArray.size(); i++) {
            AnyType temp = tempArray.get(i);
            resultArray.add(temp.get(i).getElement();
        }

        return resultArray;
    }
    */

    public ArrayList<Element> levelOrder() {
        if (isEmpty()) {
            return null;
        }

        QueueInterface<BinaryTreeNode<Element>> fifo = new QueueFIFO<>(41);
        ArrayList<Element> list = new ArrayList<>();
        fifo.enqueue(root);

        return traverseLevelOrder(list, fifo);
    }

    private ArrayList<Element> traverseLevelOrder(ArrayList<Element> list, QueueInterface<BinaryTreeNode<Element>> fifo) {

        while (!fifo.isEmpty()) {
            BinaryTreeNode tmpNode = fifo.dequeue();
            if (tmpNode.getLeftChild() != null) {
                fifo.enqueue(tmpNode.getLeftChild());
            }
            if (tmpNode.getRightChild() != null) {
                fifo.enqueue(tmpNode.getRightChild());
            }

            list.add((Element) tmpNode.getElement());
        }

        return list;
    }

    /**
     * Returns the height of the tree or -1 if the tree is empty
     */
    public int height() {
        // log(size(), 2);
        return height(root);
    }

    public int height(BinaryTreeNode<Element> root) {
        if (root == null) {
            return -1;
        } else {
            return 1 + Math.max(height(root.getLeftChild()), height(root.getRightChild()));
        }
    }

    private int log(int n, int log) {
        int result = (int)(Math.log(n) / Math.log(log));
        return result;
    }

}

