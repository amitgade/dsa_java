package dynamicarray;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by amitgade on 30-Jan-2021
 */
public class DynamicArrayTest {
    DynamicArray array;

    @Before
    public void setUp() throws Exception {
        array = new DynamicArray(3);
    }

    @Test
    public void getAndSet() {
        array.set(0, "a");
        Assert.assertEquals("a", array.get(0));
    }

    @Test
    public void insert() {
        array.add("a");
        array.add("b");
        array.add("c");

        array.insert(1, "d");

        Assert.assertEquals(4, array.size());
        Assert.assertEquals("a", array.get(0));
        Assert.assertEquals("d", array.get(1));
        Assert.assertEquals("b", array.get(2));
        Assert.assertEquals("c", array.get(3));
    }

    @Test
    public void delete() {
        array.add("a");
        array.add("b");
        array.add("c");

        array.delete(1);

        Assert.assertEquals(2, array.size());
        Assert.assertEquals("a", array.get(0));
        Assert.assertEquals("c", array.get(1));
    }

    @Test
    public void deleteLast() {
        array.add("a");
        array.add("b");

        array.delete(1);

        Assert.assertEquals(1, array.size());
        Assert.assertEquals("a", array.get(0));
    }

    @Test
    public void isEmpty() {

        Assert.assertEquals(true, array.isEmpty());

        array.add("a");
        array.add("b");

        array.delete(1);

        Assert.assertEquals(false, array.isEmpty());
    }

    @Test
    public void contains() {
        Assert.assertEquals(false, array.contains("a"));

        array.add("a");
        array.add("b");

        Assert.assertEquals(true, array.contains("a"));

    }
}