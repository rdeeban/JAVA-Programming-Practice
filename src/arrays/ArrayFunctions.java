package arrays;

import java.util.*;

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

    /**
     * Return the largest and smallest number given an unsorted integer array
     */
    public static AbstractMap.SimpleEntry<Integer, Integer> findLargestAndSmallestNumber(int[] arr) {
        int maxNum = Integer.MIN_VALUE, minNum = Integer.MAX_VALUE;
        for (int j : arr) {
            if (j > maxNum) maxNum = j;
            if (j < minNum) minNum = j;
        }

        return new AbstractMap.SimpleEntry<>(maxNum, minNum);
    }

    /**
     * Return all pairs of an integer array whose sum is equal to a given number
     */
    public static List<AbstractMap.SimpleEntry<Integer, Integer>> findAllPairsOfNumbersThatSumToANumber(int[] arr, int num) {
        List<AbstractMap.SimpleEntry<Integer, Integer>> allPairs = new ArrayList<>();
        for (int j = 1; j < arr.length; j ++) {
            for (int i = 0; i < j; i ++) {
                if (arr[i] + arr[j] == num) {
                    allPairs.add(new AbstractMap.SimpleEntry<>(arr[i], arr[j]));
                }
            }
        }

        return allPairs;
    }

    /**
     * Return duplicate numbers in an array that contains multiple duplicates
     */
    public static List<Integer> findDuplicateNumbersInArrayContainingMultipleDuplicates(int[] arr) {
        List<Integer> dupNums = new ArrayList<>();
        for (int j = 1; j < arr.length; j ++) {
            for (int i = 0; i < j; i ++) {
                if (arr[i] == arr[j]) {
                    dupNums.add(arr[i]);
                }
            }
        }

        return dupNums;
    }

    /**
     * Return a list with duplicates removed from a given array of numbers
     */
    public static List<Integer> removeDuplicatesFromArray(int[] arr) {
        boolean[] dupNum = new boolean[arr.length];
        for (int j = 1; j < arr.length; j ++) {
            for (int i = 0; i < j; i ++) {
                if (!dupNum[i] && arr[i] == arr[j]) {
                    dupNum[j] = true;
                }
            }
        }

        List<Integer> numListWithDupsRemoved = new ArrayList<>();
        for (int i = 0; i < arr.length; i ++) {
            if (!dupNum[i]) {
                numListWithDupsRemoved.add(arr[i]);
            }
        }

        return numListWithDupsRemoved;
    }

    /**
     * Return an integer array sorted in place using the quicksort algorithm
     */
    public static void quicksort(int[] arr) {
        quicksortHelper(arr, 0, arr.length - 1);
    }

    private static void quicksortHelper(int[] arr, int h, int k) {
        if (h < k) {
            int partitionIndex = partition(arr, h, k);
            quicksortHelper(arr, h, partitionIndex);
            quicksortHelper(arr, partitionIndex + 1, k);
        }
    }

    private static int partition(int[] arr, int h, int k) {
        int i = h;
        int j = k + 1;
        while (i + 1 < j) {
            if (arr[i + 1] <= arr[i]) {
                swap(arr, i, i + 1);
                i ++;
            } else {
                j --;
            }
        }

        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * Return a list with elements in reverse order
     */
    public static void reverseArrayInPlace(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i ++) {
            swap(arr, i, n - i - 1);
        }
    }
}
