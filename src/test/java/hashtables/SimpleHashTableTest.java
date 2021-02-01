package hashtables;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pojos.Employee;

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
        Employee samjones = new Employee("Sam", "Jones", 12331);
        Employee sampitroda = new Employee("Sam", "Pitroda", 12345);
        Employee jackjill = new Employee("Jack", "Jill", 12311);
        Employee ganpatgawde = new Employee("Ganpat", "Gawde", 14437);
        Employee dadakondke = new Employee("Dada", "Kondke", 11231);

        hashTable.put("Jones", samjones);
        hashTable.put("Jill", jackjill);
        hashTable.put("Kondke",dadakondke);
//        simpleHashTable.put("Gawde", ganpatgawde); // this will cause collision

        Assert.assertEquals(samjones, hashTable.get("Jones"));
        Assert.assertEquals(jackjill, hashTable.get("Jill"));
        Assert.assertEquals(dadakondke, hashTable.get("Kondke"));

//        hashTable.printHashTable();
    }
}