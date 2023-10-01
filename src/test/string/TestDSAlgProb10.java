package test.string;

import org.junit.Assert;
import org.junit.Test;
import string.StringFunctions;

public class TestDSAlgProb10 {

    @Test
    public void testReverseWords() {
        String s = "I am a happy person";
        String expected = "person happy a am I";
        String actual = StringFunctions.reverseWords(s);
        Assert.assertEquals(expected, actual);

        s = "I am a happy";
        expected = "happy a am I";
        actual = StringFunctions.reverseWords(s);
        Assert.assertEquals(expected, actual);
    }
}
