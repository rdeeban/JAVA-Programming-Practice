package test.string;

import org.junit.Assert;
import org.junit.Test;
import string.StringFunctions;

public class TestDSAlgProb8 {

    @Test
    public void testCountCharacterOccurrence() {
        String s = "abc";
        char c = 'a';
        int expected = 1;
        int actual = StringFunctions.countCharacterOccurrence(s, c);
        Assert.assertEquals(expected, actual);

        s = "abcdd";
        c = 'd';
        expected = 2;
        actual = StringFunctions.countCharacterOccurrence(s, c);
        Assert.assertEquals(expected, actual);
    }
}
