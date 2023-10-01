package linkedlist;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LinkedListFunctions {

    /**
     * Find the middle element of a singly linked list in one pass
     */
    public static int findMiddleElement(LinkedList<Integer> list) {
        LinkedList.Node slow = list.head;
        LinkedList.Node fast = list.head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        assert slow != null;
        return (int) slow.data;
    }

    /**
     * Check if a linked list contains a cycle
     */
    public static boolean containsCycle(LinkedList<Integer> list) {
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
    public static void reverseLinkedListUsingLoop(LinkedList<Integer> list) {
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
    public static void removeDuplicates(LinkedList<Integer> list) {
        LinkedList.Node<Integer> cur = list.head;
        Set<Integer> seen = new HashSet<>();
        seen.add(cur.data);
        LinkedList.Node<Integer> next;
        while (cur.next != null) {
            next = cur.next;
            if (seen.contains(next.data)) {
                cur.next = next.next;
                next = cur.next;
            } else {
                seen.add(next.data);
                cur = cur.next;
            }
        }
    }

    /**
     * Find the third node's data from the end
     */
    public static int findThirdNodeFromEnd(LinkedList<Integer> list) {
        LinkedList.Node<Integer> cur = list.head;
        LinkedList.Node<Integer> twoAfterCur = cur;
        twoAfterCur = twoAfterCur.next;
        twoAfterCur = twoAfterCur.next;
        while (twoAfterCur.next != null) {
            cur = cur.next;
            twoAfterCur = twoAfterCur.next;
        }

        return cur.data;
    }

    /**
     * Find the sum of two linked lists using Stack
     */
    public static int findSum(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        Stack<Integer> stack1 = getStackFromLinkedList(list1);
        Stack<Integer> stack2 = getStackFromLinkedList(list2);
        int sum = 0;
        int exp = 0;
        int base = 10;
        int mantissa;
        int carryOver = 0;
        while (!stack1.empty() && !stack2.empty()) {
            int val1 = stack1.pop();
            int val2 = stack2.pop();
            int sumOfValues = val1 + val2 + carryOver;
            mantissa = sumOfValues % base;
            carryOver = sumOfValues / base;
            sum += (int) (mantissa * Math.pow(base, exp));
            exp ++;
        }

        while (!stack1.empty()) {
            int val1 = stack1.pop();
            mantissa = val1 % base;
            carryOver = val1 / base;
            sum += (int) (mantissa * Math.pow(base, exp));
            exp ++;
        }

        while (!stack2.empty()) {
            int val2 = stack2.pop();
            mantissa = val2 % base;
            carryOver = val2 / base;
            sum += (int) (mantissa * Math.pow(base, exp));
            exp ++;
        }

        if (carryOver == 1) {
            sum += (int) (Math.pow(base, exp));
        }

        return sum;
    }

    private static Stack<Integer> getStackFromLinkedList(LinkedList<Integer> list) {
        Stack<Integer> stack = new Stack<>();
        LinkedList.Node<Integer> cur = list.head;
        while (cur != null) {
            stack.push(cur.data);
            cur = cur.next;
        }

        return stack;
    }
}
