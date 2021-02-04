package hashtables;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by amitgade on 01-Feb-2021
 */
public class ChainedHashTableTest {

    private ChainedHashTable hashTable;

    @Before
    public void setUp() throws Exception {
        hashTable = new ChainedHashTable();
    }

    @Test
    public void putAndGet() {
        hashTable.put("John", "Doe");
        hashTable.put("Jack", "Sparrow");
        hashTable.put("Nikola","Tesla");
        hashTable.put("Henry", "Ford"); // this will cause collision
        hashTable.put("Shiv", "Khera"); // this will cause collision

        assertEquals("John", hashTable.get("Doe"));
        assertEquals("Jack", hashTable.get("Sparrow"));
        assertEquals("Nikola", hashTable.get("Tesla"));
        assertEquals("Henry", hashTable.get("Ford"));

        System.out.println(hashTable);
    }

    @Test
    public void remove() {
        hashTable.put("John", "Doe");
        hashTable.put("Jack", "Sparrow");
        hashTable.put("Nikola","Tesla");
        hashTable.put("Henry", "Ford");
        hashTable.put("Shiv", "Khera"); // this will cause collision
        System.out.println(hashTable);
        System.out.println("-------------");
        hashTable.remove("John");

        assertEquals(null, hashTable.get("John"));

        System.out.println(hashTable);
    }
}