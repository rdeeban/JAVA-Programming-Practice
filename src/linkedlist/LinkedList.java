package linkedlist;

public class LinkedList {
    Node head;

    static class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    /**
     * Constructs a Linked List
     */
    public LinkedList(int... nums) {
        for (int i = nums.length - 1; i >= 0; i --) {
            add(nums[i]);
        }
    }

    /**
     * Constructs a (Circular) Linked List
     */
    public LinkedList(boolean circular, int... nums) {
        this(nums);
        if (circular) {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }

            cur.next = head;
        }
    }

    /**
     * Inserts a new Node at front of the list.
     */
    public void add(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    /**
     * Gets the node at index
     */
    public int get(int index) {
        Node cur = head;
        int curIndex = 0;
        while (cur.next != null) {
            if (curIndex == index) return cur.data;
            cur = cur.next;
            curIndex ++;
        }

        if (cur == null) throw new IllegalArgumentException(String.format("Invalid index: %d", index));
        return cur.data;
    }

    public int length() {
        Node cur = head;
        int length = 0;
        while (cur != null) {
            length ++;
            cur = cur.next;
        }

        return length;
    }
}
