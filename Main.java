import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        String name = "abc";
        String name2 = "awx";

        BinaryTree<String> binaryTree = new BinaryTree<>();
        Association<String, String> dictionaryMap = new Association<>();

        // Generates the dictionary and the tree.
        try {
            BufferedReader reader = new BufferedReader(new FileReader("dictionary.txt"));
            String line;

            // Generates the map
            while((line = reader.readLine()) != null) {
                binaryTree.add(line);
                line = line.replace("(", "");
                line = line.replace(")", "");
                String[] splitLine = line.split(",");
                splitLine[1] = splitLine[1].replace(" ", "");   // Removes additional space
                dictionaryMap.addEntry(splitLine[0], splitLine[1]);
            }
        } catch (Exception E) {
            System.err.println("There was an error while converting the file to a map");
        }


        // Prints the binary tree in order
        System.out.println("The binary tree in order is: ");
        binaryTree.inOrder(binaryTree.getRoot());
        System.out.println();
        System.out.println();


        System.out.println("The translated document is: ");
        // Reads the document to be translated
        try {
            BufferedReader reader = new BufferedReader(new FileReader("text.txt"));
            String line;

            // Gets the words needed to translate
            while((line = reader.readLine()) != null) {
                String translatedLine = "";
                String[] wordsToTranslate = new String[0];
                if(line.length() > 0) {
                    wordsToTranslate = line.split(" ");
                }

                for(int i = 0; i < wordsToTranslate.length; i ++) {
                    char lastCharacter = wordsToTranslate[i].charAt(wordsToTranslate[i].length() - 1);
                    boolean punctuation = false;
                    boolean uppercase = false;


                    if(lastCharacter == '.' || lastCharacter == ';' || lastCharacter == ':' || lastCharacter == ','
                            || lastCharacter == '!' || lastCharacter == '?') {
                        wordsToTranslate[i] = wordsToTranslate[i].replace("" + lastCharacter, "");
                        punctuation = true;
                    }

                    String originalWord = wordsToTranslate[i];

                    if (Character.isUpperCase(wordsToTranslate[i].charAt(0))){
                        uppercase = true;
                    }

                    wordsToTranslate[i] = wordsToTranslate[i].toLowerCase();

                    if(dictionaryMap.containsWord(wordsToTranslate[i])) {
                        String translatedWord = dictionaryMap.getSpanishWord(wordsToTranslate[i]);
                        // If the original word was in uppercase, the translated one is too
                        if(uppercase) {
                            translatedWord = translatedWord.replace(translatedWord.charAt(0) + "",
                                    (translatedWord.charAt(0) + "").toUpperCase());
                        }
                        translatedLine = translatedLine + " " + translatedWord;
                    } else {
                        translatedLine = translatedLine + " *" + originalWord + "*";
                    }

                    if(punctuation) {
                        translatedLine += lastCharacter + "";
                    }

                }
                System.out.println(translatedLine);
            }
        } catch (Exception E) {
            System.err.println("There was an error while converting the file to a map");
        }
    }
}
