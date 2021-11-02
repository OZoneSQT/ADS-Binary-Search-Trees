package tree.binarytree;

/*
 * Copyright (c) 2021
 *
 * OZ1SQT, Michel S. E. Sommer
 * https://Seahawk.dk
 */

import java.util.ArrayList;

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> extends BinaryTree<AnyType> {
    private BinarySearchTreeNode root;

    public BinarySearchTree() {
        super();
        root = null;
    }

    /**
     * Add an element to the tree. Do nothing if present
     */
    public void insertElement(AnyType element) {
        setRoot(insert(element, root));
    }

    private BinarySearchTreeNode<AnyType> insert(AnyType element, BinarySearchTreeNode<AnyType> root) {
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
    public void removeElement(AnyType element) {
        setRoot(remove(element, root));
    }

    private BinarySearchTreeNode<AnyType> remove(AnyType element, BinarySearchTreeNode<AnyType> root) {
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
     * Returns the maximum element of the tree
     */
    public BinarySearchTreeNode<AnyType> findMax() {
        // return findMaxElement();
        return findMax(root);
    }

    private BinarySearchTreeNode<AnyType> findMax(BinarySearchTreeNode<AnyType> root) {
        if (root == null) {
            return null;
        }

        return findMax(root, null);
    }

    private BinarySearchTreeNode<AnyType> findMax(BinarySearchTreeNode<AnyType> root, AnyType element) {
        if(root.getElement().compareTo(element) >= 0 && root.getRightChild() != null){
            root = findMax(root.getRightChild(), root.getElement());
        }

        return root;
    }

    private BinarySearchTreeNode<AnyType> findMaxElement() {
        ArrayList<AnyType> tree = inOrder();
        BinarySearchTreeNode<AnyType> node = new BinarySearchTreeNode<>(tree.get(tree.size()));

        return node;
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
        int ALLOWED_IMBALANCE = 1;

        if (root != null) {
            // rebalance(root, ALLOWED_IMBALANCE);
            rebalance(root);
        }
    }

    /*
     * Rebalance using an inorder "divide and conquer" array then put into the tree again
     */
    private void rebalance(BinarySearchTreeNode<AnyType> root) {
        ArrayList<AnyType> tree = inOrder();
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
    private BinarySearchTreeNode<AnyType> rebalance(BinarySearchTreeNode<AnyType> root, int ALLOWED_IMBALANCE ) {

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

    private BinarySearchTreeNode<AnyType> rotateWithLeftChild(BinarySearchTreeNode<AnyType> root) {
        BinarySearchTreeNode<AnyType> node = root.getLeftChild();
        root.addLeftChild(node.getRightChild());
        node.addRightChild(root);
        return node;
    }

    private BinarySearchTreeNode<AnyType> doubleWithLeftChild(BinarySearchTreeNode<AnyType> root) {
        root.addLeftChild(rotateWithLeftChild(root));
        return rotateWithLeftChild( root );
    }

    private BinarySearchTreeNode<AnyType> rotateWithRightChild(BinarySearchTreeNode<AnyType> root) {
        BinarySearchTreeNode<AnyType> node = root.getRightChild();
        root.addRightChild(node.getLeftChild());
        node.addLeftChild(root);
        return node;
    }

    private BinarySearchTreeNode<AnyType> doubleWithRightChild(BinarySearchTreeNode<AnyType> root) {
        root.addRightChild(rotateWithRightChild(root));
        return rotateWithRightChild( root );
    }

}
