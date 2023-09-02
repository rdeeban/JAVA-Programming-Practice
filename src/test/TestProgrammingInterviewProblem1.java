package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import main.ProgrammingInterviewProblem1;
import org.junit.Test;

import java.util.ArrayList;

public class TestProgrammingInterviewProblem1 {

    private static ArrayList<Integer> prob1Arr;

    @Test
    public void testProblem1InvalidInputNoNumberMissingCase() {
        prob1Arr = new ArrayList<>();
        for (int i = 1; i <= 100; i ++)
            prob1Arr.add(i);

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> ProgrammingInterviewProblem1.findMissingNumber(prob1Arr));
        assertEquals("Invalid input: there are no numbers missing.", exception.getMessage());
    }

    @Test
    public void testProblem1FirstNumberMissingCase() {
        prob1Arr = new ArrayList<>();
        for (int i = 1; i <= 100; i ++)
            if (i != 1)
                prob1Arr.add(i);

        int missingNumber = ProgrammingInterviewProblem1.findMissingNumber(prob1Arr);
        assertEquals(1, missingNumber);
    }

    @Test
    public void testProblem1LastNumberMissingCase() {
        prob1Arr = new ArrayList<>();
        for (int i = 1; i <= 100; i ++)
            if (i != 100)
                prob1Arr.add(i);

        int missingNumber = ProgrammingInterviewProblem1.findMissingNumber(prob1Arr);
        assertEquals(100, missingNumber);
    }

    @Test
    public void testProblem1MissingNumberGeneralCase() {
        prob1Arr = new ArrayList<>();
        for (int i = 1; i <= 100; i ++)
            if (i != 2)
                prob1Arr.add(i);

        int missingNumber = ProgrammingInterviewProblem1.findMissingNumber(prob1Arr);
        assertEquals(2, missingNumber);
    }
}