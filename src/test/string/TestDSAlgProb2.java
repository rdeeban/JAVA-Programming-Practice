package test.string;

import org.junit.Assert;
import org.junit.Test;
import string.StringFunctions;

public class TestDSAlgProb2 {

    @Test
    public void testCheckTwoStringsAreAnagrams() {
        String s1 = "cat";
        String s2 = "act";
        boolean expected = true;
        boolean actual = StringFunctions.checkTwoStringsAreAnagrams(s1, s2);
        Assert.assertEquals(expected, actual);

        s1 = "cata";
        s2 = "ct";
        expected = false;
        actual = StringFunctions.checkTwoStringsAreAnagrams(s1, s2);
        Assert.assertEquals(expected, actual);

        s1 = "schoolmaster";
        s2 = "theclassroom";
        expected = true;
        actual = StringFunctions.checkTwoStringsAreAnagrams(s1, s2);
        Assert.assertEquals(expected, actual);

        s1 = "scholmaster";
        s2 = "theclassroom";
        expected = false;
        actual = StringFunctions.checkTwoStringsAreAnagrams(s1, s2);
        Assert.assertEquals(expected, actual);
    }
}
