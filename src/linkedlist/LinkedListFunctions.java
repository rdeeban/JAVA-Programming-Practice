package arrays;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListFunctions {

    /**
     * Find the middle element of a singly linked list in one pass
     */
    public static int findMiddleElement(LinkedList<Integer> list) {
        // start two pointers at the head
        // at each iteration, progress one pointer by one node and the other pointer by two nodes
        // when the other reaches the end, the first will be pointing at the middle element
        Iterator<Integer> slow = list.iterator();
        Iterator<Integer> fast = list.iterator();
        while (fast != null) {
            slow.next();
            fast.next();
            fast.next();
        }
        return slow.next();
    }
}
