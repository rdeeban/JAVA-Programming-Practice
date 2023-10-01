package test.string;

import org.junit.Assert;
import org.junit.Test;

import string.StringFunctions;

public class TestDSAlgProb12 {

    @Test
    public void testCheckStringIsPalindrome() {
        String s = "aba";
        boolean expected = true;
        boolean actual = StringFunctions.checkStringIsPalindrome(s);
        Assert.assertEquals(expected, actual);

        s = "abba";
        expected = true;
        actual = StringFunctions.checkStringIsPalindrome(s);
        Assert.assertEquals(expected, actual);

        s = "abca";
        expected = false;
        actual = StringFunctions.checkStringIsPalindrome(s);
        Assert.assertEquals(expected, actual);
    }
}
