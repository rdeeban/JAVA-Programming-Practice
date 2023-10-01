package test.string;

import org.junit.Assert;
import org.junit.Test;
import string.StringFunctions;

import java.util.HashSet;
import java.util.Set;

public class TestDSAlgProb9 {

    @Test
    public void testFindPermutations() {
        String s = "abc";
        Set<String> expectedPermutations = new HashSet<>();
        expectedPermutations.add("abc");
        expectedPermutations.add("acb");
        expectedPermutations.add("bac");
        expectedPermutations.add("bca");
        expectedPermutations.add("cab");
        expectedPermutations.add("cba");
        Set<String> permutations = StringFunctions.findPermutations(s);
        Assert.assertEquals(expectedPermutations, permutations);
    }
}
