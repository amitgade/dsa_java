package stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by amitgade on 30-Jan-2021
 */
public class StackTest {

    private Stack stack;

    @Before
    public void setUp() throws Exception {
        stack = new Stack();
    }

    @Test
    public void push() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Assert.assertEquals(3,stack.getSize());
    }

    @Test
    public void popAndPop() {
        stack.push(11);
        stack.push(21);
        stack.push(31);

        Assert.assertEquals(31,stack.pop());
        Assert.assertEquals(2,stack.getSize());
        Assert.assertEquals(21,stack.peek());
        Assert.assertEquals(2,stack.getSize());
    }

}