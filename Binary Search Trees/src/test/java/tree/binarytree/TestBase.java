package tree.binarytree;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertTrue;


public class TestBase {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected BinarySearchTree binarySearchTree = new BinarySearchTree();
    protected BinaryTree binaryTree = new BinaryTree();

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
