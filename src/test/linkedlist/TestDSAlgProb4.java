package test.linkedlist;

import linkedlist.LinkedList;
import linkedlist.LinkedListFunctions;
import org.junit.Assert;
import org.junit.Test;

public class TestDSAlgProb4 {

    @Test
    public void testReverseLinkedListUsingLoop() {
        LinkedList<Integer> list = new LinkedList<>(1);
        LinkedListFunctions.reverseLinkedListUsingLoop(list);
        int exp = list.get(0);
        Assert.assertEquals(exp, 1);

        list = new LinkedList<>(1, 2);
        LinkedListFunctions.reverseLinkedListUsingLoop(list);
        exp = list.get(0);
        Assert.assertEquals(exp, 2);
        exp = list.get(1);
        Assert.assertEquals(exp, 1);

        list = new LinkedList<>(1, 2, 3);
        LinkedListFunctions.reverseLinkedListUsingLoop(list);
        exp = list.get(0);
        Assert.assertEquals(exp, 3);
        exp = list.get(1);
        Assert.assertEquals(exp, 2);
        exp = list.get(2);
        Assert.assertEquals(exp, 1);

        list = new LinkedList<>(1, 2, 3, 4);
        LinkedListFunctions.reverseLinkedListUsingLoop(list);
        exp = list.get(0);
        Assert.assertEquals(exp, 4);
        exp = list.get(1);
        Assert.assertEquals(exp, 3);
        exp = list.get(2);
        Assert.assertEquals(exp, 2);
        exp = list.get(3);
        Assert.assertEquals(exp, 1);
    }
}
