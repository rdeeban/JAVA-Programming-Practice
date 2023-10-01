package test.string;

import org.junit.Assert;
import org.junit.Test;
import string.StringFunctions;

public class TestDSAlgProb5 {

    @Test
    public void testStringHasOnlyDigits() {
        String s = "0";
        boolean expected = true;
        boolean actual = StringFunctions.stringHasOnlyDigits(s);
        Assert.assertEquals(expected, actual);

        s = "0a";
        expected = false;
        actual = StringFunctions.stringHasOnlyDigits(s);
        Assert.assertEquals(expected, actual);

        s = "01a";
        expected = false;
        actual = StringFunctions.stringHasOnlyDigits(s);
        Assert.assertEquals(expected, actual);

        s = "01";
        expected = true;
        actual = StringFunctions.stringHasOnlyDigits(s);
        Assert.assertEquals(expected, actual);
    }
}
