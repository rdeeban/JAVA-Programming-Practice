package test;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static arrays.ArrayFunctions.removeDuplicatesFromArray;
import static org.junit.Assert.assertEquals;

public class TestDSAlgProb6 {
    @Test
    public void testProblem6ArrayOfLength2With1Duplicates() {
        int[] arr = new int[]{1, 1};
        List<Integer> uniqueNumList = removeDuplicatesFromArray(arr);
        List<Integer> expected = Arrays.asList(1);
        assertEquals(expected, uniqueNumList);
    }

    @Test
    public void testProblem6ArrayOfLength3With2Duplicates() {
        int[] arr = new int[]{1, 1, 1};
        List<Integer> uniqueNumList = removeDuplicatesFromArray(arr);
        List<Integer> expected = Arrays.asList(1);
        assertEquals(expected, uniqueNumList);
    }

    @Test
    public void testProblem6ArrayOfLength4With2Duplicates() {
        int[] arr = new int[]{1, 1, 2, 2};
        List<Integer> uniqueNumList = removeDuplicatesFromArray(arr);
        List<Integer> expected = Arrays.asList(1, 2);
        assertEquals(expected, uniqueNumList);
    }
}
