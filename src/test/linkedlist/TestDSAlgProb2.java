package test.linkedlist;

import linkedlist.LinkedList;
import linkedlist.LinkedListFunctions;
import org.junit.Assert;
import org.junit.Test;

public class TestDSAlgProb2 {

    @Test
    public void testContainsCycle() {
        LinkedList<Integer> list = new LinkedList<>(1);
        boolean containsCycle = LinkedListFunctions.containsCycle(list);
        boolean exp = false;
        Assert.assertEquals(exp, containsCycle);

        list = new LinkedList<Integer>(true, 1);
        containsCycle = LinkedListFunctions.containsCycle(list);
        exp = true;
        Assert.assertEquals(exp, containsCycle);

        list = new LinkedList<Integer>(1, 2);
        containsCycle = LinkedListFunctions.containsCycle(list);
        exp = false;
        Assert.assertEquals(exp, containsCycle);

        list = new LinkedList<Integer>(true, 1, 2);
        containsCycle = LinkedListFunctions.containsCycle(list);
        exp = true;
        Assert.assertEquals(exp, containsCycle);

        list = new LinkedList<Integer>(1, 2, 3);
        containsCycle = LinkedListFunctions.containsCycle(list);
        exp = false;
        Assert.assertEquals(exp, containsCycle);

        list = new LinkedList<Integer>(true, 1, 2, 3);
        containsCycle = LinkedListFunctions.containsCycle(list);
        exp = true;
        Assert.assertEquals(exp, containsCycle);

        list = new LinkedList<Integer>(1, 2, 3, 4);
        containsCycle = LinkedListFunctions.containsCycle(list);
        exp = false;
        Assert.assertEquals(exp, containsCycle);

        list = new LinkedList<Integer>(true, 1, 2, 3, 4);
        containsCycle = LinkedListFunctions.containsCycle(list);
        exp = true;
        Assert.assertEquals(exp, containsCycle);
    }
}
