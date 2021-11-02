package tree.other;

import tree.util.QueueFIFO;
import tree.util.QueueInterface;

import java.util.ArrayList;

public class TestTree <AnyType extends Comparable<? super AnyType>> {
    private TestNode<AnyType> root;

    public TestTree() {
        this.root = null;
    }

    /**
     * Returns a reference to the root or null if tree is empty
     */
    public TestNode<AnyType> getRoot() {
        return root;
    }

    /**
     * Set the root of the tree
     */
    public void setRoot(TestNode<AnyType> root) {
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

    private int size(TestNode<AnyType> root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + size(root.getRightChild()) + size(root.getLeftChild());
        }
    }

    /**
     * Determines if an element is present in the tree
     */
    public boolean contains(AnyType element) {
        return contains(root, element);
    }

    private boolean contains(TestNode<AnyType> root, AnyType element) {
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
    public ArrayList<AnyType> inOrder() {
        ArrayList<AnyType> tree = new ArrayList<>();
        if (isEmpty()) {
            return null;
        }
        return traverseInOrder(root, tree);
    }

    private ArrayList<AnyType> traverseInOrder(TestNode<AnyType> root, ArrayList<AnyType> tree) {
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
    public ArrayList<AnyType> preOrder() {
        ArrayList<AnyType> tree = new ArrayList<>();
        if (isEmpty()) {
            return null;
        }
        return traversePreOrder(root, tree);
    }

    private ArrayList<AnyType> traversePreOrder(TestNode<AnyType> root, ArrayList<AnyType> tree) {
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
    public ArrayList<AnyType> postOrder() {
        ArrayList<AnyType> output = new ArrayList<>();
        if (isEmpty()) {
            return null;
        }
        return traversePostOrder(root, output);
    }

    private ArrayList<AnyType> traversePostOrder(TestNode<AnyType> root, ArrayList<AnyType> output) {
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
    public ArrayList<AnyType> levelOrder() {
        if (isEmpty()) {
            return null;
        }

        QueueInterface<TestNode<AnyType>> fifo = new QueueFIFO<>(41);
        ArrayList<AnyType> list = new ArrayList<>();
        fifo.enqueue(root);

        return traverseLevelOrder(list, fifo);
    }

    private ArrayList<AnyType> traverseLevelOrder(ArrayList<AnyType> list, QueueInterface<TestNode<AnyType>> fifo) {

        while (!fifo.isEmpty()) {
            TestNode tmpNode = fifo.dequeue();
            if (tmpNode.getLeftChild() != null) {
                fifo.enqueue(tmpNode.getLeftChild());
            }
            if (tmpNode.getRightChild() != null) {
                fifo.enqueue(tmpNode.getRightChild());
            }

            list.add((AnyType) tmpNode.getElement());
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

    public int height(TestNode<AnyType> root) {
        if (root == null) {
            return -1;
        } else {
            return 1 + Math.max(height(root.getLeftChild()), height(root.getRightChild()));
        }
    }

    private int log(int n, int log) {
        int result = (int) (Math.log(n) / Math.log(log));
        return result;
    }


    /**
     * Add an element to the tree. Do nothing if present
     */
    public void insertElement(AnyType element) {
        setRoot(insert(element, root));
    }

    private TestNode<AnyType> insert(AnyType element, TestNode<AnyType> root) {
        if (root == null) {
            return new TestNode(element);
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

    private TestNode<AnyType> remove(AnyType element, TestNode<AnyType> root) {
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
    public TestNode<AnyType> findMin() {
        return findMin(root.getLeftChild());
    }

    private TestNode<AnyType> findMin(TestNode<AnyType> root) {
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
    public TestNode<AnyType> findMax() {
        // return findMaxElement();
        return findMax(root);
    }

    private TestNode<AnyType> findMax(TestNode<AnyType> root) {
        if (root == null) {
            return null;
        }

        return findMax(root, null);
    }

    private TestNode<AnyType> findMax(TestNode<AnyType> root, AnyType element) {
        if(root.getElement().compareTo(element) >= 0 && root.getRightChild() != null){
            root = findMax(root.getRightChild(), root.getElement());
        }

        return root;
    }

    private TestNode<AnyType> findMaxElement() {
        ArrayList<AnyType> tree = inOrder();
        TestNode<AnyType> node = new TestNode<>(tree.get(tree.size()));

        return node;
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
    private void rebalance(TestNode<AnyType> root) {
        ArrayList<AnyType> tree = inOrder();
        int center = tree.size() / 2;

        // if equal length, select element to the right of center (to fill up from left)
        if (tree.size() % 2 == 0) {
            center++;
        }

        setRoot(new TestNode(tree.get(center), null, null));

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
    private TestNode<AnyType> rebalance(TestNode<AnyType> root, int ALLOWED_IMBALANCE ) {

        if( root == null )
            return root;

        if( height(root.getLeftChild()) - height( root.getRightChild() ) > ALLOWED_IMBALANCE )
            if( height( root.getLeftChild().getLeftChild() ) >= height( root.getRightChild().getRightChild() ) )
                root = rotateWithLeftChild( root );
            else
                root = doubleWithLeftChild( root );
        else
        if( height(  ) - height( root.getLeftChild() ) > ALLOWED_IMBALANCE )
            if( height( root.getRightChild().getRightChild() ) >= height( root.getRightChild().getLeftChild() ) )
                root = rotateWithRightChild( root );
            else
                root = doubleWithRightChild( root );
        return root;

    }

    private TestNode<AnyType> rotateWithLeftChild(TestNode<AnyType> root) {
        TestNode<AnyType> node = root.getLeftChild();
        root.addLeftChild(node.getRightChild());
        node.addRightChild(root);
        return node;
    }

    private TestNode<AnyType> doubleWithLeftChild(TestNode<AnyType> root) {
        root.addLeftChild(rotateWithLeftChild(root));
        return rotateWithLeftChild( root );
    }

    private TestNode<AnyType> rotateWithRightChild(TestNode<AnyType> root) {
        TestNode<AnyType> node = root.getRightChild();
        root.addRightChild(node.getLeftChild());
        node.addLeftChild(root);
        return node;
    }

    private TestNode<AnyType> doubleWithRightChild(TestNode<AnyType> root) {
        root.addRightChild(rotateWithRightChild(root));
        return rotateWithRightChild( root );
    }

}