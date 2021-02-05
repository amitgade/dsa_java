package hashtables;

/**
 * Created by amitgade on 01-Feb-2021
 */
public class ChainedHashTable {
    private class HashEntry { // think of as a LinkedLis node
        String key;
        String value;
        HashEntry next;

        public HashEntry(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return "HashEntry{" +
                    "key='" + key +
                    "'" + '}';
        }
    }

    private static final int INITIAL_SIZE = 16;
    private HashEntry[] data;

    public ChainedHashTable() {
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
            // Handle collision... walk to the end of LinkedList
            HashEntry currentEntry = data[index];
            while (currentEntry.next != null) {
                currentEntry = currentEntry.next;
            }
            // Add our new entry here
            currentEntry.next = entry;
        }
    }

    public int getIndex(String key) {
        // get the hashcode
        int hashCode = key.hashCode();

        // convert to index
        int index = (hashCode & 0x7fffffff) % INITIAL_SIZE;

        // Hack to force collision for testing
        if (key.equals("John") || key.equals("Shiv")) {
            index = 7;
        }
        return index;
    }

    public String get(String key) {
        // get the index
        int index = getIndex(key);

        // get current list of entries / find the bucket / head of linkedlist
        HashEntry currentEntry = data[index];

        // While there are elements in the linked list...
        while (currentEntry != null) {
            if (currentEntry.key.equals(key)) { // Check for match
                return currentEntry.value;      // if match found return
            }
            currentEntry = currentEntry.next;   // else go to next node in chain
        }
        return null;                            // return null if no match found
    }

    public void remove(String key) {
        // get the index
        int index = getIndex(key);

        // get current list of entries / find the bucket / head of linkedlist
        HashEntry currentEntry = data[index];

        // if no match found
        if (currentEntry == null) {
            return;
        }
        // if we are to delete head
        if (currentEntry.key.equals(key)) {
            data[index] = currentEntry.next;
            return;
        }

        while (currentEntry.next != null) {
            if (currentEntry.next.key.equals(key)) {
                currentEntry.next = currentEntry.next.next;
                return;
            }
        }
    }

    @Override
    public String toString() {
        int bucket = 0;
        StringBuilder hashTableStr = new StringBuilder();
        for (HashEntry entry : data) {
            if (entry == null) {
                bucket++;
                continue;
            }
            hashTableStr.append("\n bucket[")
                    .append(bucket)
                    .append("] = ")
                    .append(entry.toString());
            bucket++;
            HashEntry temp = entry.next;
            while (temp != null) {
                hashTableStr.append(" -> ");
                hashTableStr.append(temp.toString());
                temp = temp.next;
            }
        }
        return hashTableStr.toString();
    }
}
