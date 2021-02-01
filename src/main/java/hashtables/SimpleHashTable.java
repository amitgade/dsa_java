package hashtables;

import pojos.Employee;

/**
 * Created by amitgade on 01-Feb-2021
 */
public class SimpleHashTable {
    private Employee[] hashTable;

    public SimpleHashTable() {
        hashTable = new Employee[10];
    }

    private int hashKey(String key) {
        return key.length() % hashTable.length;
    }

    public void put(String key, Employee employee) {
        // hash the key
        int hashedKey = hashKey(key);
        if (hashTable[hashedKey] != null) {
            System.out.println("Sorry! There is already an employee at this place.");
            return;
        }
        hashTable[hashedKey] = employee;
    }

    public Employee get(String key) {
        int hashedKey = hashKey(key);
        return hashTable[hashedKey];
    }

    public void printHashTable() {
        for (int i = 0; i < hashTable.length; i++) {
            System.out.println(hashTable[i]);
        }
    }

}
