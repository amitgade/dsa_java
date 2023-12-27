package linkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by amitgade on 29-Jan-2021
 */
public class LinkedListTest {

    private LinkedList linkedList;

    @Before
    public void setUp() throws Exception {
        linkedList = new LinkedList();
    }

    @Test
    public void addFirst() {
        linkedList.addFront(1);
        linkedList.addFront(2);
        linkedList.addFront(3);

        Assert.assertEquals(3, linkedList.getFirst());
        Assert.assertEquals(1, linkedList.getLast());
    }

    @Test
    public void getFist() {
        linkedList.addFront(1);
        Assert.assertEquals(1, linkedList.getFirst());
    }

    @Test
    public void getLast() {
        linkedList.addFront(1);
        linkedList.addFront(2);
        linkedList.addFront(3);

        Assert.assertEquals(1, linkedList.getLast());
    }

    @Test
    public void addBack() {
        linkedList.addBack(1);
        linkedList.addBack(2);
        linkedList.addBack(3);

        Assert.assertEquals(1, linkedList.getFirst());
        Assert.assertEquals(3, linkedList.getLast());
    }

    @Test
    public void size() {
        Assert.assertEquals(0, linkedList.getSize());
        linkedList.addFront(1);
        linkedList.addFront(2);
        Assert.assertEquals(2, linkedList.getSize());
    }

    @Test
    public void clear() {
        linkedList.addFront(1);
        linkedList.addFront(2);
        Assert.assertEquals(2, linkedList.getSize());

        linkedList.clear();
        Assert.assertEquals(0,linkedList.getSize());
    }

    @Test
    public void deleteValue() {

        linkedList.deleteValue(1);
        Assert.assertEquals(0,linkedList.getSize());

        linkedList.addFront(1);
        linkedList.addFront(2);
        linkedList.addFront(3);

        linkedList.deleteValue(3);
        Assert.assertEquals(2, linkedList.getSize());
        Assert.assertEquals(2, linkedList.getFirst());
        Assert.assertEquals(1, linkedList.getLast());
    }
}