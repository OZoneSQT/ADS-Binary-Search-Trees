package tree.binarytree;

/*
 * Copyright (c) 2021
 *
 * OZ1SQT, Michel S. E. Sommer
 * https://Seahawk.dk
 */

import other.BinaryNode;

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> extends BinaryTree<AnyType> {
    private BinarySearchTreeNode root;

    public BinarySearchTree() {
        super();
    }

    /**
     * Add an element to the tree. Do nothing if present
     */
    public void insertElement(AnyType element) {
        root = insert(element, root);
    }

    private BinarySearchTreeNode<AnyType> insert(AnyType element, BinarySearchTreeNode<AnyType> root) {
        if (root == null) {
            return new BinaryNode<>(element, null, null);
        }

        int compareResult = element.compareTo(root.getElement());

        if (compareResult < 0) {
            root.setLeftChild(insert(element, root.getLeftChild()));
        } else if (compareResult > 0) {
            root.getRightChild(insert(element, root.getRightChild());
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
    public void removeElement(AnyType element) {
        root = remove(element, root);
    }

    private BinarySearchTreeNode<AnyType> remove(AnyType element, BinarySearchTreeNode<AnyType> root) {
        if (root == null) {
            return root;
        }

        // http://users.cis.fiu.edu/~weiss/dsaajava3/code/BinarySearchTree.java
        // http://users.cis.fiu.edu/~weiss/dsaajava3/code/AvlTree.java

        int compareResult = element.compareTo(root.getElement());

        if (compareResult < 0) {
            root.setLeftChild(remove(element, root.getLeftChild()));
        } else if (compareResult > 0) {
            root.setRightChild(remove(element, root.getRightChild()));
        } else if (root.getLeftChild() != null && root.getRightChild() != null) {
            root.getElement(findMin(root.getRightChild()).getElement();
            root.setRightChild(remove(root.getElement(), root.getRightChild()));
        } else {
            root = (root.getLeftChild() != null) ? root.getLeftChild() : root.getRightChild();
        }
        return root;
    }

    /**
     * Returns the minimum element of the tree
     */
    public BinarySearchTreeNode<AnyType> findMin() {
        return findMin(root.getLeftChild());
    }

    private BinarySearchTreeNode<AnyType> findMin(BinarySearchTreeNode<AnyType> root) {
        if (root == null) {
            return null;
        } else if (root.getLeftChild() == null) {
            return root;
        } else {
            return findMin(root);
        }
    }


    /**
     * Determines if an element is present in the tree
     */
    public boolean contains(AnyType element) {
        return super.contains(element);
    }

    /**
     * Rebalance the entire tree, the outcome must be a balanced tree.
     */
    public void rebalance() {
        // divide and conquer array then put into tree again
        // if equal length, select element to the right of center (to fill up from left)

        rebalance(root);
    }

    private BinarySearchTreeNode<AnyType> rebalance(BinarySearchTreeNode<AnyType> root ) {
        int ALLOWED_IMBALANCE = 1;
        if( root == null )
            return root;

        if( super.height( root.getLeftChild() ) - super.height( root.getRightChild() ) > ALLOWED_IMBALANCE )
            if( super.height( root.getLeftChild().getLeftChild() ) >= super.height( root.getRightChild().getRightChild() ) )
                root = rotateWithLeftChild( root );
            else
                root = doubleWithLeftChild( root );
        else
        if( super.height( root.getRightChild() ) - super.height( root.getLeftChild() ) > ALLOWED_IMBALANCE )
            if( super.height( root.getRightChild().getRightChild() ) >= super.height( root.getRightChild().getLeftChild() ) )
                root = rotateWithRightChild( root );
            else
                root = doubleWithRightChild( root );
        return root;
    }

    private BinarySearchTreeNode<AnyType> rotateWithLeftChild(BinarySearchTreeNode<AnyType> root) {
        BinarySearchTreeNode<AnyType> node = root.getLeftChild();
        root.setLeftChild(node.getRightChild());
        node.setRightChild(root);
        return node;
    }

    private BinarySearchTreeNode<AnyType> doubleWithLeftChild(BinarySearchTreeNode<AnyType> root) {
        root.setLeftChild(rotateWithLeftChild(root));
        return rotateWithLeftChild( root );
    }

    private BinarySearchTreeNode<AnyType> rotateWithRightChild(BinarySearchTreeNode<AnyType> root) {
        BinaryNode<AnyType> node = root.getRightChild();
        root.setRightChild(node.getLeftChild());
        node.setLeftChild(root);
        return node;
    }

    private BinarySearchTreeNode<AnyType> doubleWithRightChild(BinarySearchTreeNode<AnyType> root) {
        root.setRightChild(rotateWithRightChild(root));
        return rotateWithRightChild( root );
    }





}
