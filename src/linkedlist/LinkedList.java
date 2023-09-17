package linkedlist;

public class LinkedList {
    Node head;

    class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    public LinkedList(int... nums) {
        for (int num : nums) {
            push(num);
        }
    }

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

    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }
}
