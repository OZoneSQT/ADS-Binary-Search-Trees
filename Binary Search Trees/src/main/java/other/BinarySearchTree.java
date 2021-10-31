package other;

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {
    private BinaryNode<AnyType> root;
    
    public BinarySearchTree() {
        this.root = null;
    }
    
    public void makeEmpty() {
        this.root = null;
    }
    
    public boolean isEmpty() {
        return root == null;
    }
    
    public boolean contains(AnyType element) {
        return contains(element, root);
    }

    private boolean contains(AnyType element, BinaryNode<AnyType> root) {
        if (root == null) {
            return false;
        }
        
        int compareResult = element.compareTo(root.getElement());
        
        if (compareResult < 0) {
            return contains(element, root.getLeftChild());
        } else if (compareResult > 0) {
            return contains(element, root.getRightChild());
        } else {
            return true;    // match
        }
    }

    public BinaryNode<AnyType> findMin() {
        return findMin(root.getLeftChild());
    }

    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> root) {
        if (root == null) {
            return null;
        } else if (root.getLeftChild() == null) {
            return root;
        } else {
            return findMin(root);
        }
    }
    
    public BinaryNode<AnyType> findMax() {
        return findMax(root.getRightChild());
    }

    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> root) {
        if (root != null) {
            while (root.getRightChild() != null) {
                root = root.getRightChild();
            }
        }
        return root;
    }

    public void insert(AnyType element) {
        root = insert(element, root);
    }

    private BinaryNode<AnyType> insert(AnyType element, BinaryNode<AnyType> root) {
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

    public void remove(AnyType element) {
        root = remove(element, root);
    }

    private BinaryNode<AnyType> remove(AnyType element, BinaryNode<AnyType> root) {
        if (root == null) {
            return root;
        }

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

    // InOrder
    public void printTree() {
        if (isEmpty()) {
            System.out.println("Tree is empty");
        } else printTree(root);
    }

    private void printTree(BinaryNode<AnyType> root) {
        if (root != null) {
            printTree(root.getLeftChild());
            System.out.println(root.getElement());
            printTree(root.getRightChild());
        }
    }

    public int height() {
        return height(root);
    }

    private int height(BinaryNode<AnyType> root) {
        if (root == null) {
            return -1;
        } else {
            return 1 + Math.max(height(root.getLeftChild()), height(root.getRightChild()));
        }
    }

    public void checkBalance () {
        checkBalance(root);
    }

    private int checkBalance(BinaryNode<AnyType> root) {
        if (root == null) {
            return -1;
        }if (root != null) {
            int hl = checkBalance(root.getLeftChild());
            int hr = checkBalance(root.getRightChild());
            if ( Math.abs( height( root.getLeftChild() ) - height( root.getRightChild() ) ) > 1 ||
                    height( root.getLeftChild() ) != hl || height( root.getRightChild() ) != hr ) { }
        }
        return height(root);
    }

    public void balance() {
        balance(root);
    }

    private BinaryNode<AnyType> balance( BinaryNode<AnyType> root ) {
        int ALLOWED_IMBALANCE = 1;
        if( root == null )
            return root;

        if( height( root.getLeftChild() ) - height( root.getRightChild() ) > ALLOWED_IMBALANCE )
            if( height( root.getLeftChild().getLeftChild() ) >= height( root.getRightChild().getRightChild() ) )
                root = rotateWithLeftChild( root );
            else
                root = doubleWithLeftChild( root );
        else
        if( height( root.getRightChild() ) - height( root.getLeftChild() ) > ALLOWED_IMBALANCE )
            if( height( root.getRightChild().getRightChild() ) >= height( root.getRightChild().getLeftChild() ) )
                root = rotateWithRightChild( root );
            else
                root = doubleWithRightChild( root );
        return root;
    }

    private BinaryNode<AnyType> rotateWithLeftChild(BinaryNode<AnyType> root) {
        BinaryNode<AnyType> node = root.getLeftChild();
        root.setLeftChild(node.getRightChild());
        node.setRightChild(root);
        return node;
    }

    private BinaryNode<AnyType> doubleWithLeftChild(BinaryNode<AnyType> root) {
        root.setLeftChild(rotateWithLeftChild(root));
        return rotateWithLeftChild( root );
    }

    private BinaryNode<AnyType> rotateWithRightChild(BinaryNode<AnyType> root) {
        BinaryNode<AnyType> node = root.getRightChild();
        root.setRightChild(node.getLeftChild());
        node.setLeftChild(root);
        return node;
    }

    private BinaryNode<AnyType> doubleWithRightChild(BinaryNode<AnyType> root) {
        root.setRightChild(rotateWithRightChild(root));
        return rotateWithRightChild( root );
    }

}
