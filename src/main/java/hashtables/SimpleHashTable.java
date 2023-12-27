package hashtables;

import java.util.Arrays;

/**
 * Created by amitgade on 01-Feb-2021
 */
public class SimpleHashTable {

    private class HashEntry { // think of as a LinkedLis node
        String key;
        String value;

        public HashEntry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "HashEntry{" +
                    "key='" + key + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    private static final int INITIAL_SIZE = 16;
    private HashEntry[] data;

    public SimpleHashTable() {
        data = new HashEntry[INITIAL_SIZE];
    }

    public void put(String key, String value) {
        // get the index
        int index = getIndex(key);

        // create LinkedList entry
        HashEntry entry = new HashEntry(key, value);

        // if no entry.. add it means this is 1st node at particular index
        if (data[index] == null) {
            data[index] = entry;
        } else {
            // we found collision
            System.out.println("Sorry, we found collision. Cannot add the element.");
        }
    }

    public int getIndex(String key) {
        // get the hashcode
        int hashCode = key.hashCode();

        // convert to index
        int index = (hashCode & 0x7fffffff) % INITIAL_SIZE;

        return index;
    }

    public String get(String key) {
        // get the index
        int index = getIndex(key);

        // get entry
        HashEntry entry = data[index];

        if (entry != null && entry.key == key) {
            return entry.value;
        }
        return null;
    }

    public void remove(String key) {
        int index = getIndex(key);
        if (data[index].key.equals(key)) {
            data[index] = null;
        }
    }

    @Override
    public String toString() {
        return "SimpleHashTable{" +
                "data=" + Arrays.toString(data) +
                "}";
    }
}
