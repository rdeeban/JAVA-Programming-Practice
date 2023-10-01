package test.linkedlist;

import linkedlist.LinkedList;
import linkedlist.LinkedListFunctions;
import org.junit.Assert;
import org.junit.Test;

public class TestDSAlgProb8 {

    @Test
    public void testFindSum() {
        LinkedList<Integer> list1 = new LinkedList<>(4, 5);
        LinkedList<Integer> list2 = new LinkedList<>(3, 6);
        int sum = LinkedListFunctions.findSum(list1, list2);
        int exp = 81;
        Assert.assertEquals(exp, sum);

        list1 = new LinkedList<>(9, 5);
        list2 = new LinkedList<>(3, 6);
        sum = LinkedListFunctions.findSum(list1, list2);
        exp = 131;
        Assert.assertEquals(exp, sum);
    }
}
