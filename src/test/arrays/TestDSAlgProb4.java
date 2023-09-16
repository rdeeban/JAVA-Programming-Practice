package test.arrays;

import org.junit.Test;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;

import static arrays.ArrayFunctions.findAllPairsOfNumbersThatSumToANumber;
import static org.junit.Assert.assertEquals;

public class TestDSAlgProb4 {

    @Test
    public void testProblem4ArrayOfLength2NoPairExists() {
        int[] arr = new int[]{1, 2};
        List<AbstractMap.SimpleEntry<Integer,Integer>> pairs = findAllPairsOfNumbersThatSumToANumber(arr, 1);
        List<AbstractMap.SimpleEntry<Integer,Integer>> expectedPairs = List.of();
        assertEquals(expectedPairs, pairs);
    }

    @Test
    public void testProblem4ArrayOfLength2OnePairExists() {
        int[] arr = new int[]{1, 2};
        List<AbstractMap.SimpleEntry<Integer,Integer>> pairs = findAllPairsOfNumbersThatSumToANumber(arr, 3);
        List<AbstractMap.SimpleEntry<Integer,Integer>> expectedPairs = List.of(new AbstractMap.SimpleEntry<>(1, 2));
        assertEquals(expectedPairs, pairs);
    }

    @Test
    public void testProblem4ArrayOfLength3NoPairExists() {
        int[] arr = new int[]{1, 2, 3};
        List<AbstractMap.SimpleEntry<Integer,Integer>> pairs = findAllPairsOfNumbersThatSumToANumber(arr, 1);
        List<AbstractMap.SimpleEntry<Integer,Integer>> expectedPairs = List.of();
        assertEquals(expectedPairs, pairs);
    }

    @Test
    public void testProblem4ArrayOfLength3OnePairExists() {
        int[] arr = new int[]{1, 2, 3};
        List<AbstractMap.SimpleEntry<Integer,Integer>> pairs = findAllPairsOfNumbersThatSumToANumber(arr, 3);
        List<AbstractMap.SimpleEntry<Integer,Integer>> expectedPairs = List.of(new AbstractMap.SimpleEntry<>(1, 2));
        assertEquals(expectedPairs, pairs);
    }

    @Test
    public void testProblem4ArrayOfLength3TwoPairsExist() {
        int[] arr = new int[]{1, 4, 2, 3};
        List<AbstractMap.SimpleEntry<Integer,Integer>> pairs = findAllPairsOfNumbersThatSumToANumber(arr, 5);
        List<AbstractMap.SimpleEntry<Integer,Integer>> expectedPairs = Arrays.asList(new AbstractMap.SimpleEntry<>(1, 4), new AbstractMap.SimpleEntry<>(2, 3));
        assertEquals(expectedPairs, pairs);
    }
}
