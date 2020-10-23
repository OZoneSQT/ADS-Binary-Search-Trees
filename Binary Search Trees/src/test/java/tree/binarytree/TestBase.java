package tree.binarytree;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tree.util.QueueFIFO;
import tree.util.QueueInterface;

import static org.junit.Assert.assertTrue;

public class TestBase {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected QueueInterface<BinaryTreeNode> queueInterface = new QueueFIFO<>(41);

    protected BinarySearchTree binarySearchTree = new BinarySearchTree(queueInterface);
    protected BinaryTree binaryTree = new BinaryTree(queueInterface, binarySearchTree);

    protected DeleteNode deleteNode = new DeleteNode();
    protected InsertNode insertNode = new InsertNode();

    @Rule
    public TestName testName = new TestName();

    @Before
    public void setup() {
        assertTrue(binarySearchTree.isEmpty());
        logger.info("Start {}", testName.getMethodName());
    }

    @After
    public void cleanup() {
        logger.info("End {}", testName.getMethodName());
    }

}
