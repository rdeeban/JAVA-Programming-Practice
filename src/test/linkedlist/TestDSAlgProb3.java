package test.linkedlist;

import linkedlist.LinkedList;
import linkedlist.LinkedListFunctions;
import org.junit.Assert;
import org.junit.Test;

public class TestDSAlgProb3 {

    @Test
    public void testReverseLinkedListUsingRecursion() {
        LinkedList<Integer> list = new LinkedList<>(1);
        LinkedListFunctions.reverseLinkedListUsingRecursion(list);
        int exp = list.get(0);
        Assert.assertEquals(exp, 1);

        list = new LinkedList<>(1, 2);
        LinkedListFunctions.reverseLinkedListUsingRecursion(list);
        exp = list.get(0);
        Assert.assertEquals(exp, 2);
        exp = list.get(1);
        Assert.assertEquals(exp, 1);

        list = new LinkedList<>(1, 2, 3);
        LinkedListFunctions.reverseLinkedListUsingRecursion(list);
        exp = list.get(0);
        Assert.assertEquals(exp, 3);
        exp = list.get(1);
        Assert.assertEquals(exp, 2);
        exp = list.get(2);
        Assert.assertEquals(exp, 1);

        list = new LinkedList<>(1, 2, 3, 4);
        LinkedListFunctions.reverseLinkedListUsingRecursion(list);
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
