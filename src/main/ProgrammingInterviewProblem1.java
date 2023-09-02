package main;

import java.util.ArrayList;

public class ProgrammingInterviewProblem1 {

    /**
     * Return the missing number in a given integer array of 1 to 100 (sorted)
     */
    public static int findMissingNumber(ArrayList<Integer> arr) {
        boolean isNumberMissing = false;
        for (int i = 0; i < 100; i ++) {
            if (i == 99 && arr.size() == 99) {
                isNumberMissing = true;
                break;
            }

            if (i + 1 < arr.get(i))
                isNumberMissing = true;
        }

        if (!isNumberMissing) throw new IllegalArgumentException("Invalid input: there are no numbers missing.");

        for (int i = 0; i < 99; i ++)
            if (i + 1 < arr.get(i))
                return i + 1;

        return 100;
    }
}
