package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayFunctions {

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