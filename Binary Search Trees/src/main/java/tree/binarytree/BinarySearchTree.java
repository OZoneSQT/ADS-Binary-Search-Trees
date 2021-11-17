package tree.binarytree;

/*
 * Copyright (c) 2021
 *
 * OZ1SQT, Michel S. E. Sommer
 * https://Seahawk.dk
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BinarySearchTree<Element extends Comparable<? super Element>> extends BinaryTree<Element> {
    private BinarySearchTreeNode root;

    public BinarySearchTree() {
        super();
    }

    /**
     * Add an element to the tree. Do nothing if present
     */
    public void insertElement(Element element) {
        setRoot(insert(element, root));
    }

    private BinarySearchTreeNode<Element> insert(Element element, BinarySearchTreeNode<Element> root) {
        if (root == null) {
            return new BinarySearchTreeNode(element);
        }

        //TODO Insert keeps calling root
        /*
         *   ensure new node is set as root
         */

        int compareResult = element.compareTo(root.getElement());

        if (compareResult < 0) {
            root.addLeftChild(insert(element, root.getLeftChild()));
        } else if (compareResult >= 0) {
            root.addRightChild(insert(element, root.getRightChild()));
        } else {
            ;
        }

        return root;
    }

    private int getPosition() {
        //Left Child    =>     2n+1      =>      int pos = ( 2 * size() + 1 )
        //Right Child   =>    2(n+1)     =>      int pos = ( 2 * ( size() + 1 ) )

        if ( ( size() % 2 ) == 0) {
            return ( 2 * size() + 1 );
        } else {
            return ( 2 * ( size() + 1 ) );
        }
    }

    /**
     * Remove an element from the tree Do nothing if not present
     */
    public void removeElement(Element element) {
        setRoot(remove(element, root));
    }

    private BinarySearchTreeNode<Element> remove(Element element, BinarySearchTreeNode<Element> root) {
        if (root == null) {
            return null;
        }

        int compareResult = element.compareTo(root.getElement());

        if (compareResult < 0) {
            root.addLeftChild(remove(element, root));
        } else if (compareResult > 0) {
            root.addRightChild(remove(element, root));
        } else if (root.getLeftChild() != null && root.getRightChild() != null) {
            root.setElement(findMin(root.getRightChild()).getElement());
            root.addRightChild(remove(root.getElement(), root.getRightChild()));
        } else {
            root = (root.getLeftChild() != null) ? root.getLeftChild() : root.getRightChild();
        }
        return root;
    }

    /**
     * Returns the minimum element of the tree
     */
    public Element findMin() {
        /*
        BinarySearchTreeNode<Element> minElement = findMin(root.getLeftChild());
        Element element = minElement.getElement();
        */
        Element element = levelOrder().get(0); // test

        return element;
    }

    /*
    public BinarySearchTreeNode<Element> findMin() {
        return findMin(root.getLeftChild());
    }
    */

    private BinarySearchTreeNode<Element> findMin(BinarySearchTreeNode<Element> root) {
        if (root == null) {
            return null;
        } else if (root.getLeftChild() == null) {
            return root;
        } else {
            return findMin(root);
        }
    }

    /**
     * Returns the maximum element of the tree
     */
    public Element findMax() {
        // return findMaxElement();
        /*
        BinarySearchTreeNode<Element> maxElement = findMax(root.getLeftChild());
        Element element = maxElement.getElement();
        */

        // test
        ArrayList<Element> list = inOrder();
        Collections.sort(list);
        Element element = list.get(list.size()-1);

        return element;
    }

    /*
    public BinarySearchTreeNode<Element> findMax() {
        // return findMaxElement();
        return findMax(root);
    }
    */

    private BinarySearchTreeNode<Element> findMax(BinarySearchTreeNode<Element> root) {
        if (root == null) {
            return null;
        }

        return findMax(root, null);
    }

    private BinarySearchTreeNode<Element> findMax(BinarySearchTreeNode<Element> root, Element element) {
        if(root.getElement().compareTo(element) >= 0 && root.getRightChild() != null){
            root = findMax(root.getRightChild(), root.getElement());
        }

        return root;
    }

    private BinarySearchTreeNode<Element> findMaxElement() {
        ArrayList<Element> tree = inOrder();
        BinarySearchTreeNode<Element> node = new BinarySearchTreeNode<>(tree.get(tree.size()));

        return node;
    }

    /**
     * Determines if an element is present in the tree
     */
    public boolean contains(Element element) {
        return super.contains(element);
    }

    /**
     * Rebalance the entire tree, the outcome must be a balanced tree.
     */
    public void rebalance() {
        int ALLOWED_IMBALANCE = 1;

        if (root != null) {
            // rebalance(root, ALLOWED_IMBALANCE);
            rebalance(root);
        }
    }

    /*
     * Rebalance using an inorder "divide and conquer" array then put into the tree again
     */
    private void rebalance(BinarySearchTreeNode<Element> root) {
        ArrayList<Element> tree = inOrder();
        int center = tree.size() / 2;

        // if equal length, select element to the right of center (to fill up from left)
        if (tree.size() % 2 == 0) {
            center++;
        }

        setRoot(new BinarySearchTreeNode(tree.get(center), null, null));

        for (int i = 0; i < center - 1 ; i++) {
            if ((tree.get(center - 1 - i)) != null) {
                insertElement(tree.get(center - 1 - i));
            }
            if ((tree.get(center - 1 - i)) != null) {
                insertElement(tree.get(center + 1 + i));
            }
        }
    }

    /*
     * Rebalance using "AVL" rotation of nodes
     */
    private BinarySearchTreeNode<Element> rebalance(BinarySearchTreeNode<Element> root, int ALLOWED_IMBALANCE ) {

        if( root == null )
            return root;

        if( super.height(root.getLeftChild()) - super.height( root.getRightChild() ) > ALLOWED_IMBALANCE )
            if( super.height( root.getLeftChild().getLeftChild() ) >= super.height( root.getRightChild().getRightChild() ) )
                root = rotateWithLeftChild( root );
            else
                root = doubleWithLeftChild( root );
        else
        if( height(  ) - super.height( root.getLeftChild() ) > ALLOWED_IMBALANCE )
            if( super.height( root.getRightChild().getRightChild() ) >= super.height( root.getRightChild().getLeftChild() ) )
                root = rotateWithRightChild( root );
            else
                root = doubleWithRightChild( root );
        return root;
    }

    private BinarySearchTreeNode<Element> rotateWithLeftChild(BinarySearchTreeNode<Element> root) {
        BinarySearchTreeNode<Element> node = root.getLeftChild();
        root.addLeftChild(node.getRightChild());
        node.addRightChild(root);
        return node;
    }

    private BinarySearchTreeNode<Element> doubleWithLeftChild(BinarySearchTreeNode<Element> root) {
        root.addLeftChild(rotateWithLeftChild(root));
        return rotateWithLeftChild( root );
    }

    private BinarySearchTreeNode<Element> rotateWithRightChild(BinarySearchTreeNode<Element> root) {
        BinarySearchTreeNode<Element> node = root.getRightChild();
        root.addRightChild(node.getLeftChild());
        node.addLeftChild(root);
        return node;
    }

    private BinarySearchTreeNode<Element> doubleWithRightChild(BinarySearchTreeNode<Element> root) {
        root.addRightChild(rotateWithRightChild(root));
        return rotateWithRightChild( root );
    }

}