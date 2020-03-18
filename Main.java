public class Main {
    public static void main(String[] args) {
        String name = "abc";
        String name2 = "awx";
        // Generates a single binary tree (there can only be one dictionary at a time)
        BinaryTree binaryTree = BinaryTree.generateTree("dictionary.txt");
        binaryTree.inOrder(binaryTree.getRoot());
        String a ="WADS";
        String b = "ABC";


    }


}
