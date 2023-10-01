package string;

import java.util.*;
import linkedlist.LinkedList;
import linkedlist.LinkedListFunctions;

public class StringFunctions {

    /**
     * Return duplicate characters from a string
     */
    public static String printDuplicateCharacters(String s) {
        StringBuilder sb = new StringBuilder();
        Set<Character> seenChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (seenChars.contains(c)) {
                sb.append(c);
            }

            seenChars.add(c);
        }
        return sb.toString();
    }

    /**
     * Return whether two strings are anagrams of each other
     */
    public static boolean checkTwoStringsAreAnagrams(String s1, String s2) {
        Map<Character, Integer> h1 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            h1.put(c, h1.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> h2 = new HashMap<>();
        for (char c : s2.toCharArray()) {
            h2.put(c, h2.getOrDefault(c, 0) + 1);
        }

        return h1.equals(h2);
    }

    /**
     * Return the first non-repeated character from a string
     */
    public static char findFirstNonRepeatedCharacter(String s) {
        LinkedHashMap<Character, Integer> h = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            h.put(c, h.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : h.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            if (count == 1) {
                return c;
            }
        }

        return '\0';
    }

    /**
     * Reverse a string using recursion
     */
    public static String reverseStringUsingRecursion(String s) {
        LinkedList<Character> list = new LinkedList<>();
        for (char c : s.toCharArray()) {
            list.add(c);
        }

        LinkedListFunctions.reverseLinkedListUsingRecursion(list);
        StringBuilder sb = new StringBuilder();
        LinkedList.Node<Character> cur = list.getHead();
        while (cur != null) {
            sb.append(cur.data);
            cur = cur.next;
        }

        return sb.toString();
    }

    /**
     * Return whether a string contains only digits
     */
    public static boolean stringHasOnlyDigits(String s) {
        boolean hasOnlyDigits = true;
        for (char c : s.toCharArray()) {
            if (c < 48 || c >= 58) hasOnlyDigits = false;
        }

        return hasOnlyDigits;
    }

    /**
     * Count the number of vowels and consonants in a given string
     */
    public static AbstractMap.SimpleEntry<Integer, Integer> countNumVowelsAndConsonants(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        int numVowels = 0;
        int numConsonants = 0;
        for (char c : s.toCharArray()) {
            if (vowels.contains(c)) {
                numVowels ++;
            } else {
                numConsonants ++;
            }
        }

        return new AbstractMap.SimpleEntry<>(numVowels, numConsonants);
    }

    /**
     * Count character occurrence
     */
    public static int countCharacterOccurrence(String s, char c) {
        Map<Character, Integer> h = new HashMap<>();
        for (char ch : s.toCharArray()) {
            h.put(ch, h.getOrDefault(ch, 0) + 1);
        }

        return h.getOrDefault(c, 0);
    }

    /**
     * Find permutations of a given string
     */
    public static Set<String> findPermutations(String s) {
        Set<String> permutations = new HashSet<>();
        findPermutationsHelper("", s, permutations);
        return permutations;
    }

    private static void findPermutationsHelper(String permutationPrefix, String charsLeft, Set<String> permutations) {
        if (charsLeft.length() == 0) {
            permutations.add(permutationPrefix.toString());
            return;
        }

        for (int i = 0; i < charsLeft.length(); i ++) {
            String leftStringPart = charsLeft.substring(0, i);
            String rightStringPart = charsLeft.substring(i + 1);
            findPermutationsHelper(permutationPrefix + charsLeft.charAt(i), leftStringPart + rightStringPart, permutations);
        }
    }

    /**
     * Reverse words in a given sentence
     */
    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        int numWords = words.length;
        for (int i = 0; i < numWords / 2; i ++) {
            int j = numWords - i - 1;
            String tmp = words[i];
            words[i] = words[j];
            words[j] = tmp;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numWords; i ++) {
            sb.append(words[i]);
            if (i < numWords - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    /**
     * Checks whether two strings are rotations of each other
     */
    public static boolean checkTwoStringsAreRotations(String s1, String s2) {
        int m = s1.length();
        String s2JoinedWithItself = s2 + s2;
        int n = s2JoinedWithItself.length();
        if (m > n) return false;

        for (int i = 0; i < n - m; i ++) {
            if (s1.equals(s2JoinedWithItself.substring(i, i + m))) {
                return true;
            }
        }

        return false;
    }

    /**
     * Check whether a given string is a palindrome
     */
    public static boolean checkStringIsPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i ++) {
            int j = n - i - 1;
            if (s.charAt(i) != s.charAt(j)) return false;
        }

        return true;
    }
}
