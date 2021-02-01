package hashtables;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pojos.Employee;

import static org.junit.Assert.*;

/**
 * Created by amitgade on 01-Feb-2021
 */
public class SimpleHashTableTest {

    SimpleHashTable simpleHashTable;

    @Before
    public void setUp() throws Exception {
        simpleHashTable = new SimpleHashTable();
    }

    @Test
    public void putAndGet() {
        Employee samjones = new Employee("Sam", "Jones", 12331);
        Employee sampitroda = new Employee("Sam", "Pitroda", 12345);
        Employee jackjill = new Employee("Jack", "Jill", 12311);
        Employee ganpatgawde = new Employee("Ganpat", "Gawde", 14437);
        Employee dadakondke = new Employee("Dada", "Kondke", 11231);

        simpleHashTable.put("Jones", samjones);
        simpleHashTable.put("Jill", jackjill);
        simpleHashTable.put("Kondke",dadakondke);
//        simpleHashTable.put("Gawde", ganpatgawde); // this will cause collision

        Assert.assertEquals(samjones, simpleHashTable.get("Jones"));
        Assert.assertEquals(jackjill, simpleHashTable.get("Jill"));
        Assert.assertEquals(dadakondke, simpleHashTable.get("Kondke"));

        simpleHashTable.printHasTable();
    }
}