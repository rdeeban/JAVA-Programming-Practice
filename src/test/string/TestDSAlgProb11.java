package test.string;

import org.junit.Assert;
import org.junit.Test;
import string.StringFunctions;

public class TestDSAlgProb11 {

    @Test
    public void testCheckTwoStringsAreRotations() {
        String s1 = "a";
        String s2 = "a";
        boolean expected = true;
        boolean actual = StringFunctions.checkTwoStringsAreRotations(s1, s2);
        Assert.assertEquals(expected, actual);

        s1 = "cat";
        s2 = "atc";
        expected = true;
        actual = StringFunctions.checkTwoStringsAreRotations(s1, s2);
        Assert.assertEquals(expected, actual);

        s1 = "abcd";
        s2 = "cdab";
        expected = true;
        actual = StringFunctions.checkTwoStringsAreRotations(s1, s2);
        Assert.assertEquals(expected, actual);

        s1 = "a";
        s2 = "b";
        expected = false;
        actual = StringFunctions.checkTwoStringsAreRotations(s1, s2);
        Assert.assertEquals(expected, actual);

        s1 = "cat";
        s2 = "at";
        expected = false;
        actual = StringFunctions.checkTwoStringsAreRotations(s1, s2);
        Assert.assertEquals(expected, actual);

        s1 = "abcd";
        s2 = "cda";
        expected = false;
        actual = StringFunctions.checkTwoStringsAreRotations(s1, s2);
        Assert.assertEquals(expected, actual);
    }
}
