package test.string;

import org.junit.Assert;
import org.junit.Test;
import string.StringFunctions;

public class TestDSAlgProb4 {

    @Test
    public void testReverseStringUsingRecursion() {
        String s = "abc";
        String expected = "cba";
        String actual = StringFunctions.reverseStringUsingRecursion(s);
        Assert.assertEquals(expected, actual);
    }
}
