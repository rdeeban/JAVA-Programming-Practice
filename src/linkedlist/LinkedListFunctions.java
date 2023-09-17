package linkedlist;


import java.util.HashSet;
import java.util.Set;

public class LinkedListFunctions {

    /**
     * Find the middle element of a singly linked list in one pass
     */
    public static int findMiddleElement(LinkedList list) {
        LinkedList.Node slow = list.head;
        LinkedList.Node fast = list.head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        assert slow != null;
        return slow.data;
    }

    /**
     * Check if a linked list contains a cycle
     */
    public static boolean containsCycle(LinkedList list) {
        LinkedList.Node slow = list.head;
        LinkedList.Node fast = list.head;
        int numIters = 0;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            numIters ++;
            if (fast == slow) {
                break;
            }
        }

        return fast == slow && numIters > 0;
    }

    /**
     * Reverse a Linked List using recursion
     */
    public static void reverseLinkedListUsingRecursion(LinkedList list) {
        if (list.head.next != null) {
            list.head = getHeadOfReversed(list.head);
        }
    }

    private static LinkedList.Node getHeadOfReversed(LinkedList.Node node) {
        if (node.next != null) {
            LinkedList.Node tmp = node.next;
            LinkedList.Node reversed = getHeadOfReversed(node.next);
            node.next = null;
            tmp.next = node;
            return reversed;
        }

        return node;
    }

    /**
     * Reverse a Linked List using a loop
     */
    public static void reverseLinkedListUsingLoop(LinkedList list) {
        LinkedList.Node cur = list.head;
        if (cur.next != null) {
            LinkedList.Node next = cur.next;
            cur.next = null;
            LinkedList.Node tmp;
            while (next.next != null) {
                tmp = next.next;
                next.next = cur;
                cur = next;
                next = tmp;
            }

            next.next = cur;
            list.head = next;
        }
    }

    /**
     * Remove duplicates in a Linked List
     */
    public static void removeDuplicates(LinkedList list) {
        LinkedList.Node cur = list.head;
        Set<Integer> seen = new HashSet<>();
        while (cur.next != null) {
            LinkedList.Node next = cur.next;
            if (seen.contains(next.data)) {
                cur.next = next.next;
                next = cur.next;
            } else {
                seen.add(next.data);
                cur = cur.next;
            }
        }
    }
}
