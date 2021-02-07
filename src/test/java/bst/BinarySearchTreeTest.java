package bst;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by amitgade on 07-Feb-2021
 */
public class BinarySearchTreeTest {

    private BinarySearchTree bst;

    @Before
    public void setUp() throws Exception {
        bst = new BinarySearchTree();
    }

    @Test
    public void insert() {
        bst.insert(5,"a");
        bst.insert(3,"b");
        bst.insert(2,"c");
        bst.insert(1,"d");
        bst.insert(7,"e");
        bst.insert(6,"f");
        bst.insert(8,"g");

        Assert.assertEquals("a", bst.find(5));
        Assert.assertEquals("b", bst.find(3));
        Assert.assertEquals("c", bst.find(2));
        Assert.assertEquals("d", bst.find(1));
        Assert.assertEquals("e", bst.find(7));
        Assert.assertEquals("f", bst.find(6));
        Assert.assertEquals("g", bst.find(8));
    }
}