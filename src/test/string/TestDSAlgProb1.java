package test.string;

import org.junit.Assert;
import org.junit.Test;
import string.StringFunctions;

public class TestDSAlgProb1 {

    @Test
    public void testPrintDuplicateCharacters() {
        String actual = StringFunctions.printDuplicateCharacters("xxx");
        String expected = "xx";
        Assert.assertEquals(expected, actual);
    }
}
