package main;

import java.util.Set;
import java.util.List;
import java.util.HashSet;

public class ProgrammingInterviewProblem2 {

    /**
     * Return the duplicate number on a given integer array
     */
    public static int findDuplicateNumber(List<Integer> arr) {
        boolean dupNumMissing = false;
        Set<Integer> seenNums = new HashSet<>();
        for (int num : arr) {
            if (seenNums.contains(num)) {
                return num;
            } else {
                seenNums.add(num);
            }
        }

        if (!dupNumMissing) throw new IllegalArgumentException(
                "Invalid input: there is no duplicate number.");

        return 0;
    }
}
