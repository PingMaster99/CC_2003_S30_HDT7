import java.util.LinkedHashMap;

public class Association<K, V> {

    private LinkedHashMap<K, V> dictionaryMap = new LinkedHashMap<>();

    public void addEntry(K key, V value) {
        dictionaryMap.put(key, value);

    }

    public boolean containsWord(K englishWord) {
        if(dictionaryMap.containsKey(englishWord)){
            return true;
        } else {
            return false;
        }
    }

    public V getSpanishWord(K englishWord) {
        return dictionaryMap.get(englishWord);
    }


}
