package sorting;

import java.util.Arrays;

/**
 * Created by amitgade on 12-Feb-2021
 */
public class BubbleSort {
    public int[] sortArray(int[] array, boolean isAscendingSort) {
        int[]sortedArray = Arrays.copyOf(array, array.length);
        for (int i = 0; i < sortedArray.length; i++) {
            for (int j = i; j < sortedArray.length; j++) {
                if (isAscendingSort ? sortedArray[j] < sortedArray[i] : sortedArray[i] < sortedArray[j]) {
                    swap(sortedArray, i, j);
                }
            }
        }
        return sortedArray;
    }

    private void swap(int[] sortedArray, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = sortedArray[j];
        sortedArray[j] = sortedArray[i];
        sortedArray[i] = temp;
    }
}
