import java.io.BufferedReader;
import java.io.FileReader;

// https://www.baeldung.com/java-binary-tree
public class BinaryTree<E> {

    private Node root;
    public Node getRoot() {
        return root;
    }

    public class Node<E> {
        E value;
        Node left;
        Node right;

        Node(E value) {
            this.value = value;
            right = null;
            left = null;
        }
    }



    public BinaryTree() {

    }


    public static BinaryTree<String> generateTree(String document) {
        BinaryTree<String> binaryTree = new BinaryTree<>();
        Association<String, String> dictionaryMap = new Association<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(document));
            String line;

            // Generates the map
            while((line = reader.readLine()) != null) {
                binaryTree.add(line);
            }
        } catch (Exception E) {
            System.err.println("There was an error while converting the file to a map");
        }
        return binaryTree;
    }


    private Node insertElement(Node current, E value) {
        String valueString = String.valueOf(value);

        if(current == null) {
            return new Node(value);
        }
        if(valueString.compareTo(String.valueOf(current.value)) < 0) {
            current.left = insertElement(current.left, value);
        } else if (valueString.compareTo(String.valueOf(current.value)) > 0) {
            current.right = insertElement(current.right,value);
        } else {
            return current;
        }
        return current;
    }

    public void add(E entry) {
        root = insertElement(root, entry);
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(" " + node.value);
            inOrder(node.right);
        }
    }

    public boolean containsValue(E value) {
        return containsNodeRecursive(root, value);
    }

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