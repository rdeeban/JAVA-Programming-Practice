package test.arrays;

import org.junit.Test;

import static arrays.ArrayFunctions.quicksort;
import static org.junit.Assert.assertArrayEquals;


public class TestDSAlgProb7 {

    @Test
    public void testQuicksortArrayOfSize1() {
        int[] list = new int[]{1};
        quicksort(list);
        int[] expected = new int[]{1};
        assertArrayEquals(expected, list);
    }

    @Test
    public void testQuicksortArrayOfSize2() {
        int[] list = new int[]{2, 1};
        quicksort(list);
        int[] expected = new int[]{1, 2};
        assertArrayEquals(expected, list);
    }

    @Test
    public void testQuicksortArrayOfSize3() {
       int[] list = new int[]{3, 2, 1};
       quicksort(list);
       int[] expected = new int[]{1, 2, 3};
       assertArrayEquals(expected, list);
    }
}
