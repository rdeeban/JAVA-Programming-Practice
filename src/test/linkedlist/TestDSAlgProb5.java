package test.linkedlist;

import linkedlist.LinkedList;
import linkedlist.LinkedListFunctions;
import org.junit.Assert;
import org.junit.Test;

public class TestDSAlgProb5 {

    @Test
    public void testRemoveDuplicates() {
        LinkedList list = new LinkedList(1);
        LinkedListFunctions.removeDuplicates(list);
        int exp = list.get(0);
        Assert.assertEquals(exp, 1);

        list = new LinkedList(1, 1);
        LinkedListFunctions.removeDuplicates(list);
        exp = list.length();
        Assert.assertEquals(exp, 1);

        list = new LinkedList(1, 1, 2, 2);
        LinkedListFunctions.removeDuplicates(list);
        exp = list.length();
        Assert.assertEquals(exp, 2);
    }
}
