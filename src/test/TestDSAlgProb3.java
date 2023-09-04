package test;

import org.junit.Test;

import java.util.AbstractMap;

import static arrays.ArrayFunctions.findLargestAndSmallestNumber;
import static org.junit.Assert.assertEquals;

public class TestDSAlgProb3 {

    @Test
    public void testProblem3ArrayOfLength1() {
        int[] arr = new int[]{1};
        AbstractMap.SimpleEntry<Integer,Integer> largestAndSmallestNumbers = findLargestAndSmallestNumber(arr);
        AbstractMap.SimpleEntry<Integer,Integer> expectedLargestAndSmallestNumbers = new AbstractMap.SimpleEntry<>(1, 1);
        assertEquals(expectedLargestAndSmallestNumbers, largestAndSmallestNumbers);
    }

    @Test
    public void testProblem3ArrayOfLength2() {
        int[] arr = new int[]{1, 2};
        AbstractMap.SimpleEntry<Integer,Integer> largestAndSmallestNumbers = findLargestAndSmallestNumber(arr);
        AbstractMap.SimpleEntry<Integer,Integer> expectedLargestAndSmallestNumbers = new AbstractMap.SimpleEntry<>(2, 1);
        assertEquals(expectedLargestAndSmallestNumbers, largestAndSmallestNumbers);
    }

    @Test
    public void testProblem3ArrayOfLength3() {
        int[] arr = new int[]{2, 1, 3};
        AbstractMap.SimpleEntry<Integer,Integer> largestAndSmallestNumbers = findLargestAndSmallestNumber(arr);
        AbstractMap.SimpleEntry<Integer,Integer> expectedLargestAndSmallestNumbers = new AbstractMap.SimpleEntry<>(3, 1);
        assertEquals(expectedLargestAndSmallestNumbers, largestAndSmallestNumbers);
    }
}
