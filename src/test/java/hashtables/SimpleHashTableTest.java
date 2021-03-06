package hashtables;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by amitgade on 01-Feb-2021
 */
public class SimpleHashTableTest {

    SimpleHashTable hashTable;

    @Before
    public void setUp() throws Exception {
        hashTable = new SimpleHashTable();
    }

    @Test
    public void putAndGet() {
        hashTable.put("John", "Doe");
        hashTable.put("Jack", "Sparrow");
        hashTable.put("Nikola","Tesla");
        hashTable.put("Henry", "Ford"); // this will cause collision
        hashTable.put("Shiv", "Khera"); // this will cause collision

        assertEquals("Doe", hashTable.get("John"));
        assertEquals("Sparrow", hashTable.get("Jack"));
        assertEquals("Tesla", hashTable.get("Nikola"));
        assertEquals("Ford", hashTable.get("Henry"));
        assertEquals("Khera", hashTable.get("Shiv"));

//        System.out.println(hashTable);
    }

    @Test
    public void remove() {
        hashTable.put("John", "Doe");
        hashTable.put("Jack", "Sparrow");
        hashTable.put("Nikola","Tesla");
        hashTable.put("Henry", "Ford");
        hashTable.put("Shiv", "Khera"); // this will cause collision

        hashTable.remove("John");
        assertEquals(null, hashTable.get("John"));

//        System.out.println(hashTable);
    }
}