import static org.junit.Assert.*;
/**
 * <h1>BinaryTreeTest</h1>
 * Tests to try out the insertion of elements and
 * search of values in the binary tree
 * <p>
 *
 * @author Pablo Ruiz (PingMaster99)
 * @version 1.0
 * @since 2020-03-18
 **/
public class BinaryTreeTest {
    /**
     * Test to see if the adding elements to the tree is working
     */
    @org.junit.Test
    public void add() {
        BinaryTree<String> binaryTree = new BinaryTree<>();
        // The binary tree contains only one element
        binaryTree.add("This is a test");
        // As it only contains one element, its root value should be the added String
        assertEquals(binaryTree.getRoot().value, "This is a test");

        // By adding new elements, we can confirm they are in the tree
        binaryTree.add("New element");
        assertTrue(binaryTree.containsValue("New element"));
    }

    /**
     * Test to see if searching values in the tree is working
     */
    @org.junit.Test
    public void containsValue() {
        BinaryTree<String> binaryTree = new BinaryTree<>();
        // We add the original tree elements
        binaryTree.add("(cat, gato)");
        binaryTree.add("(computer, computadora)");

        // The added values should be in the tree
        assertTrue(binaryTree.containsValue("(cat, gato)"));
        assertTrue(binaryTree.containsValue("(computer, computadora)"));

        // This value is not in the tree
        assertFalse(binaryTree.containsValue("This value is not on the tree"));
    }
}