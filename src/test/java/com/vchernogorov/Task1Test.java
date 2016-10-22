package com.vchernogorov;

import com.vchernogorov.task1.BubbleSorter;
import com.vchernogorov.task1.Sorter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Task1Test {

    @Test
    public void bubbleSort() {
        Sorter sorter = new BubbleSorter();
        int[] actualArray = new int[] { 1, 0, -1, 2 };
        sorter.sort(actualArray);
        int[] expectedArray = new int[] { -1, 0, 1, 2};
        assertArrayEquals(expectedArray, actualArray);
    }
}
