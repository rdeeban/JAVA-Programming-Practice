package test.string;

import org.junit.Assert;
import org.junit.Test;
import string.StringFunctions;

public class TestDSAlgProb3 {

    @Test
    public void testFindFirstNonRepeatedCharacter() {
        String s = "ccbba";
        char expected = 'a';
        char actual = StringFunctions.findFirstNonRepeatedCharacter(s);
        Assert.assertEquals(expected, actual);

        s = "axpxpabc";
        expected = 'b';
        actual = StringFunctions.findFirstNonRepeatedCharacter(s);
        Assert.assertEquals(expected, actual);
    }
}
