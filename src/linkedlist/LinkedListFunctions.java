package linkedlist;


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

        return slow.data;
    }

    /**
     * Check if a linked list contains a cycle
     */
    public static boolean containsCycle(LinkedList list) {
        return false;
    }
}
