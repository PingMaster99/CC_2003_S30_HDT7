import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        String name = "abc";
        String name2 = "awx";

        BinaryTree<String> binaryTree = new BinaryTree<>();
        Association<String, String> dictionaryMap = new Association<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("dictionary.txt"));
            String line;

            // Generates the map
            while((line = reader.readLine()) != null) {
                binaryTree.add(line);
                line = line.replace("(", "");
                line = line.replace(")", "");
                String[] splitLine = line.split(",");
                dictionaryMap.addEntry(splitLine[0], splitLine[1]);
            }
        } catch (Exception E) {
            System.err.println("There was an error while converting the file to a map");
        }




        System.out.println(binaryTree.containsValue("(america, qwertyuiop)"));
        // Prints the binary tree in order
        binaryTree.inOrder(binaryTree.getRoot());
        String a ="WADS";
        String b = "ABC";

    }
}
