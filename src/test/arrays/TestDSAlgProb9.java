package test.arrays;

import org.junit.Test;

import static arrays.ArrayFunctions.reverseArrayInPlace;
import static org.junit.Assert.assertArrayEquals;

public class TestDSAlgProb9 {

    @Test
    public void testReverseArrayInPlace() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        reverseArrayInPlace(arr);
        int[] expected = new int[]{5, 4, 3, 2, 1};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testReverseArrayInPlaceOneElement() {
        int[] arr = new int[]{1};
        reverseArrayInPlace(arr);
        int[] expected = new int[]{1};
        assertArrayEquals(expected, arr);
    }
}
