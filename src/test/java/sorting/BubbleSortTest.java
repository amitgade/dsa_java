package sorting;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by amitgade on 12-Feb-2021
 */
public class BubbleSortTest {
    BubbleSort bubbleSort;

    @Before
    public void setUp() throws Exception {
        bubbleSort = new BubbleSort();
    }

    @Test
    public void ascendingSort() {
        int[] array = {1, -3, 17, 13, 81, 9, 64};
        System.out.println(Arrays.toString(array));
        int[] sortedArray = bubbleSort.sortArray(array, true);
        System.out.println(Arrays.toString(sortedArray));
    }

    @Test
    public void descendingSort() {
        int[] array = {1, -3, 17, 13, 81, 9, 64};
        System.out.println(Arrays.toString(array));
        int[] sortedArray = bubbleSort.sortArray(array, false);
        System.out.println(Arrays.toString(sortedArray));
    }
}