package test.linkedlist;

import linkedlist.LinkedList;
import linkedlist.LinkedListFunctions;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestDSAlgProb1 {

    @Test
    public void testFindMiddleElement() {
        LinkedList list = new LinkedList(1);
        int midElem = LinkedListFunctions.findMiddleElement(list);
        int exp = 1;
        Assert.assertEquals(exp, midElem);

        list = new LinkedList(1, 2);
        midElem = LinkedListFunctions.findMiddleElement(list);
        exp = 1;
        Assert.assertEquals(exp, midElem);

        list = new LinkedList(1, 2, 3);
        midElem = LinkedListFunctions.findMiddleElement(list);
        exp = 2;
        Assert.assertEquals(exp, midElem);

        list = new LinkedList(1, 2, 3, 4);
        midElem = LinkedListFunctions.findMiddleElement(list);
        exp = 2;
        Assert.assertEquals(exp, midElem);
    }
}
