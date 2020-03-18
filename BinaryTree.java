import java.io.BufferedReader;
import java.io.FileReader;

// https://www.baeldung.com/java-binary-tree
public class BinaryTree {

    private Node root;
    public Node getRoot() {
        return root;
    }

    public class Node {
        String value;
        Node left;
        Node right;

        Node(String value) {
            this.value = value;
            right = null;
            left = null;
        }
    }



    private BinaryTree() {

    }

    public static BinaryTree generateTree(String document) {
        BinaryTree binaryTree = new BinaryTree();

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


    private Node insertElement(Node current, String value) {

        if(current == null) {
            return new Node(value);
        }
        if(value.compareTo(current.value) < 0) {
            current.left = insertElement(current.left, value);
        } else if (value.compareTo(current.value) > 0) {
            current.right = insertElement(current.right,value);
        } else {
            return current;
        }
        return current;
    }

    public void add(String entry) {
        root = insertElement(root, entry);
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(" " + node.value);
            inOrder(node.right);
        }
    }
}