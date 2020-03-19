/**
 * <h1>BinaryTree</h1>
 * Methods used to generate a binary tree
 * <p>
 * Reference: https://www.baeldung.com/java-binary-tree
 *
 * @author Pablo Ruiz (PingMaster99)
 * @version 1.0
 * @since 2020-03-18
 **/
public class BinaryTree<E> {

    // This will be the root node
    private Node root;

    /**
     * Gets the root of the binary tree
     * @return root
     */
    public Node getRoot() {
        return root;
    }

    /**
     * Constructor for the binary tree
     */
    public BinaryTree() {
    }

    /**
     * Inserts an element to the binary tree (recursive)
     * @return Node with the inserted element
     */
    private Node insertElement(Node current, E value) {

        // Gets the String associates with the object to be introduced
        String valueString = String.valueOf(value);

        // If there is nothing in the current node, it inserts it
        if(current == null) {
            return new Node(value);
        }

        // If the object to insert has a value less than the current node, it goes to the left
        if(valueString.compareTo(String.valueOf(current.value)) < 0) {
            current.left = insertElement(current.left, value);
        // If not, it goes to the right
        } else if (valueString.compareTo(String.valueOf(current.value)) > 0) {
            current.right = insertElement(current.right,value);
        // If they are equal, it means it is the same element
        } else {
            return current;
        }
        // Returns the current node
        return current;
    }

    /**
     * Inserts an element to the binary tree; calls the recursive method so that they are set correctly
     * @param element what is going to be added to the tree
     */
    public void add(E element) {
        // Inserts elements in the original root
        root = insertElement(root, element);
    }

    /**
     * Transverses the binary tree in order and prints it
     * @param node starting point
     */
    public void inOrder(Node node) {
        // If the node is null, it means that there is no value introduced
        if (node != null) {
            // Gets all the nodes to the left (less in magnitude)
            inOrder(node.left);
            // Prints its value
            System.out.print(" " + node.value);
            // Once all nodes to the left are done, prints the ones to the right
            inOrder(node.right);
        }
    }

    /**
     * Calls the recursive method to see if the tree contains a specific value
     * @param value value being searched
     */
    public boolean containsValue(E value) {
        // Returns if it contains it or not
        return containsNodeRecursive(root, value);
    }

    /**
     * Calls the recursive method to see if the tree contains a specific value
     * @param current node to start the search
     * @param value value being searched
     * @return boolean that indicates if the tree contains the element or not
     */
    private boolean containsNodeRecursive(Node current, E value) {
        String valueString = String.valueOf(value);
        // A null node doesn't contain values
        if (current == null) {
            return false;
        }
        // Tree contains the element only if both node value and searched value are equal
        if (valueString.compareTo(String.valueOf(current.value)) == 0) {
            return true;
        }
        return valueString.compareTo(String.valueOf(current.value)) < 0
                ? containsNodeRecursive(current.left, value)    // Value searched for is less than current value
                : containsNodeRecursive(current.right, value);  // Value searched for is greater than current value
    }
}