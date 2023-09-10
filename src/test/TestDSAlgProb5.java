package test;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static arrays.ArrayFunctions.findDuplicateNumbersInArrayContainingMultipleDuplicates;
import static org.junit.Assert.assertEquals;

public class TestDSAlgProb5 {

    @Test
    public void testProblem5ArrayOfLength4With2Duplicates() {
        int[] arr = new int[]{1, 1, 2, 2};
        List<Integer> dupNums = findDuplicateNumbersInArrayContainingMultipleDuplicates(arr);
        List<Integer> expectedDupNums = Arrays.asList(1, 2);
        assertEquals(expectedDupNums, dupNums);
    }

    @Test
    public void testProblem5ArrayOfLength6With4Duplicates() {
        int[] arr = new int[]{1, 1, 2, 2, 3, 3};
        List<Integer> dupNums = findDuplicateNumbersInArrayContainingMultipleDuplicates(arr);
        List<Integer> expectedDupNums = Arrays.asList(1, 2, 3);
        assertEquals(expectedDupNums, dupNums);
    }
}
