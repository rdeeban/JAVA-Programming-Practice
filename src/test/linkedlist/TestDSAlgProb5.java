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
        int exp = 1;
        int actual = list.get(0);
        Assert.assertEquals(exp, actual);
        exp = 1;
        actual = list.length();
        Assert.assertEquals(exp, actual);

        list = new LinkedList(1, 1);
        LinkedListFunctions.removeDuplicates(list);
        exp = 1;
        actual = list.get(0);
        Assert.assertEquals(exp, actual);
        exp = 1;
        actual = list.length();
        Assert.assertEquals(exp, actual);

        list = new LinkedList(1, 1, 2, 2);
        LinkedListFunctions.removeDuplicates(list);
        exp = 1;
        actual = list.get(0);
        Assert.assertEquals(exp, actual);
        exp = 2;
        actual = list.length();
        Assert.assertEquals(exp, actual);
    }
}
