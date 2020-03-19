import java.util.LinkedHashMap;
/**
 * <h1>Association</h1>
 * Methods used to define the dictionary
 * <p>
 *
 * @author Pablo Ruiz (PingMaster99)
 * @version 1.0
 * @since 2020-03-18
 **/
public class Association<K, V> {

    // Uses a linked hash map to save the word associations
    private LinkedHashMap<K, V> dictionaryMap = new LinkedHashMap<>();

    /**
     * Adds a dictionary entry
     * @param english word in English
     * @param spanish word in Spanish
     */
    public void addEntry(K english, V spanish) {
        dictionaryMap.put(english, spanish);

    }

    /**
     * Checks if a word is in the dictionary
     * @param englishWord word in English
     * @return boolean if it contains the word
     */
    public boolean containsWord(K englishWord) {
        if(dictionaryMap.containsKey(englishWord)){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gets the word in Spanish from an English word
     * @param englishWord word in english
     * @return the word in Spanish
     */
    public V getSpanishWord(K englishWord) {
        return dictionaryMap.get(englishWord);
    }
}
