package queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by amitgade on 30-Jan-2021
 */
public class QueueTest {

    private Queue queue;

    @Before
    public void setUp() throws Exception {
        queue = new Queue();
    }

    @Test
    public void add() {
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.printQueue();

        Assert.assertEquals(3, queue.getSize());
    }

    @Test
    public void removeAndPeek() {
        queue.add(12);
        queue.add(22);
        queue.add(32);
        queue.printQueue();

        Assert.assertEquals(12, queue.remove());
        Assert.assertEquals(2, queue.getSize());
        queue.printQueue();

        Assert.assertEquals(22, queue.peek());
        Assert.assertEquals(2, queue.getSize());
        queue.printQueue();
    }
}