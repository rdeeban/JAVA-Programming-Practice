package test.linkedlist;

import linkedlist.LinkedList;
import linkedlist.LinkedListFunctions;
import org.junit.Assert;
import org.junit.Test;

public class TestDSAlgProb7 {

    @Test
    public void testFindThirdNodeFromEnd() {
        LinkedList<Integer> list = new LinkedList<>(1, 2, 3);
        int data = LinkedListFunctions.findThirdNodeFromEnd(list);
        Assert.assertEquals(1, data);

        list = new LinkedList<>(1, 2, 3, 4);
        data = LinkedListFunctions.findThirdNodeFromEnd(list);
        Assert.assertEquals(2, data);
    }
}
