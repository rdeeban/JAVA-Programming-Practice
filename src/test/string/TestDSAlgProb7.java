package test.string;

import java.util.AbstractMap;

import org.junit.Assert;
import string.StringFunctions;
import org.junit.Test;

public class TestDSAlgProb7 {

    @Test
    public void testCountNumVowelsAndConsonants() {
        String s = "abc";
        AbstractMap.SimpleEntry<Integer, Integer> numVowelsAndConsonants = StringFunctions.countNumVowelsAndConsonants(s);
        int numVowels = numVowelsAndConsonants.getKey();
        int numConsonants = numVowelsAndConsonants.getValue();
        Assert.assertEquals(1, numVowels);
        Assert.assertEquals(2, numConsonants);
    }
}
