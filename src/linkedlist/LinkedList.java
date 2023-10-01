package linkedlist;

public class LinkedList<T> {
    Node head;
    Node tail;

    public static class Node<T> {
        public T data;
        public Node next;
        Node(T d)
        {
            data = d;
            next = null;
        }
    }

    /**
     * Constructs a Linked List
     */
    public LinkedList(T... elems) {
        for (int i = 0; i < elems.length; i ++) {
            add(elems[i]);
        }
    }

    /**
     * Constructs a (Circular) Linked List
     */
    public LinkedList(boolean circular, T... elems) {
        this(elems);
        if (circular) {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }

            cur.next = head;
        }
    }

    public Node<T> getHead() {
        return head;
    }

    /**
     * Inserts a new Node at front of the list.
     */
    public void add(T data) {
        if (head == null) {
            head = new Node<T>(data);
            tail = head;
        } else {
            tail.next = new Node<T>(data);
            tail = tail.next;
        }
    }

    /**
     * Gets the node at index
     */
    public T get(int index) {
        Node cur = head;
        int curIndex = 0;
        while (cur.next != null) {
            if (curIndex == index) return (T) cur.data;
            cur = cur.next;
            curIndex ++;
        }

        if (cur == null) throw new IllegalArgumentException(String.format("Invalid index: %d", index));
        return (T) cur.data;
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
