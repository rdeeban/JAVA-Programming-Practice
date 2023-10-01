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
        Map<Character, Integer> h2 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            h1.put(c, h1.getOrDefault(c, 0) + 1);
        }

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
}
