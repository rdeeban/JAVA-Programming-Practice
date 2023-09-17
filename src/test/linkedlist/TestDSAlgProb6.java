package test.linkedlist;

import linkedlist.LinkedList;
import org.junit.Assert;
import org.junit.Test;

public class TestDSAlgProb6 {

    @Test
    public void testLength() {
        LinkedList list = new LinkedList(1);
        int actual = list.length();
        int exp = 1;
        Assert.assertEquals(exp, actual);

        list = new LinkedList(1, 1);
        actual = list.length();
        exp = 2;
        Assert.assertEquals(exp, actual);
    }
}
