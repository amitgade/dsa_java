package hashtables;

/**
 * Created by amitgade on 01-Feb-2021
 */
public class ChainedHashTable {

//    public static class StoredEmployee {
//        String key;
//        Employee employee;
//
//        public StoredEmployee(String key, Employee employee) {
//            this.key = key;
//            this.employee = employee;
//        }
//    }
//
//    private LinkedList<StoredEmployee>[] hashTable;
//
//    public ChainedHashTable() {
//        this.hashTable = new LinkedList[10];
//        for (int i = 0; i < hashTable.length; i++) {
//            hashTable[i] = new LinkedList<StoredEmployee>();
//        }
//    }
//
//    public void put(String key, Employee employee) {
//        int hashedKey = hashKey(key);
//        hashTable[hashedKey].add(new StoredEmployee(key, employee));
//    }
//
//    public Employee get(String key) {
//        int hashedKey = hashKey(key);
//        ListIterator<StoredEmployee> iterator = hashTable[hashedKey].listIterator();
//        StoredEmployee employee = null;
//        while (iterator.hasNext()) {
//            employee = iterator.next();
//            if (employee.key.equals(key)) {
//                return employee.employee;
//            }
//        }
//
//        return null;
//    }
//
//    public Employee remove(String key) {
//        int hashedKey = hashKey(key);
//        ListIterator<StoredEmployee> iterator = hashTable[hashedKey].listIterator();
//        StoredEmployee employee = null;
//        int index = 0;
//        while (iterator.hasNext()) {
//            index++;
//            employee = iterator.next();
//            if (employee.key.equals(key)) {
//                iterator.remove();
//                return employee.employee;
//            }
//        }
//
//        return null;
//    }
//
//
//    public int hashKey(String key) {
//        return key.length() % hashTable.length;
//    }
//
//    public void printHashTable() {
//        for (int i = 0; i < hashTable.length; i++) {
//            if (hashTable[i].isEmpty()) {
//                System.out.println("Position " + i + " : empty");
//            } else {
//                System.out.print("Position " + i + " : ");
//                ListIterator<StoredEmployee> iterator = hashTable[i].listIterator();
//                while (iterator.hasNext()) {
//                    System.out.print(iterator.next().employee);
//                    System.out.print("->");
//                }
//                System.out.println("null");
//            }
//
//
//        }
//    }

    private class HashEntry { // think of as a LinkedLis node
        String key;
        String value;
        HashEntry next;

        public HashEntry(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
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

    @Override
    public String toString() {
        int bucket = 0;
        StringBuilder hashTableStr = new StringBuilder();
        for (HashEntry entry : data) {
            if(entry == null) {
                continue;
            }
            hashTableStr.append("\n bucket[")
                    .append(bucket)
                    .append("] = ")
                    .append(entry.toString());
            bucket++;
            HashEntry temp = entry.next;
            while(temp != null) {
                hashTableStr.append(" -> ");
                hashTableStr.append(temp.toString());
                temp = temp.next;
            }
        }
        return hashTableStr.toString();
    }
}
