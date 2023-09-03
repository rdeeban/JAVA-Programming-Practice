package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import arrays.ArrayFunctions;
import org.junit.Test;

import java.util.List;
import java.util.Arrays;

public class TestDSAlgProb2 {

    private static List<Integer> prob2Arr;

    @Test
    public void testProblem2InvalidInputNoDuplicateNumberInArrayOfSizeFour() {
        prob2Arr = Arrays.asList(1, 2, 3, 4);
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> ArrayFunctions.findDuplicateNumber(prob2Arr));
        assertEquals("Invalid input: there is no duplicate number.", exception.getMessage());
    }

    @Test
    public void testProblem2DuplicateNumberInSecondPositionAndDuplicatedNumberRightBeforeInArrayOfSizeFour() {
        prob2Arr = Arrays.asList(1, 1, 2, 3);
        int duplicateNum = ArrayFunctions.findDuplicateNumber(prob2Arr);
        assertEquals(1, duplicateNum);
    }

    @Test
    public void testProblem2DuplicateNumberInThirdPositionAndDuplicatedNumberRightBeforeInArrayOfSizeFour() {
        prob2Arr = Arrays.asList(1, 2, 2, 3);
        int duplicateNum = ArrayFunctions.findDuplicateNumber(prob2Arr);
        assertEquals(2, duplicateNum);
    }

    @Test
    public void testProblem2DuplicateNumberInFourthPositionAndDuplicatedNumberRightBeforeInArrayOfSizeFour() {
        prob2Arr = Arrays.asList(1, 2, 3, 3);
        int duplicateNum = ArrayFunctions.findDuplicateNumber(prob2Arr);
        assertEquals(3, duplicateNum);
    }

    @Test
    public void testProblem2DuplicateNumberInLastPositionAndDuplicatedNumberInFirstPositionInArrayOfSizeFour() {
        prob2Arr = Arrays.asList(1, 2, 3, 1);
        int duplicateNum = ArrayFunctions.findDuplicateNumber(prob2Arr);
        assertEquals(1, duplicateNum);
    }
}
