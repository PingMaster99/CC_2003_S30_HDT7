/**
 * <h1>Node</h1>
 * Methods used to define nodes in the binary tree
 * <p>
 * Reference: https://www.baeldung.com/java-binary-tree
 *
 * @author Pablo Ruiz (PingMaster99)
 * @version 1.0
 * @since 2020-03-18
 **/
public class Node<E> {

    E value;      // Value of the node
    Node left;    // Node to the right
    Node right;   // Node to the left


    /**
     * Node constructor that defines the structure of a node in the tree
     * @param value of the node
     */
    Node(E value) {
        // Sets the desired value
        this.value = value;
        // As it is a new node, both right and left nodes are not defined
        right = null;
        left = null;
    }
}