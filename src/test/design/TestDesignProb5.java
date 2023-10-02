package test.design;

import org.junit.Assert;
import org.junit.Test;
import pastebin.Pastebin;

public class TestDesignProb5 {

    @Test
    public void testPastebin() {
        Pastebin pastebin = new Pastebin();
        String text1 = "paste me";
        String link1 = pastebin.getLink(text1);
        String text2 = "paste me";
        String link2 = pastebin.getLink(text2);
        Assert.assertNotEquals(link1, link2);
        String paste1 = pastebin.getPaste(link1);
        String paste2 = pastebin.getPaste(link2);
        Assert.assertEquals(paste1, paste2);
    }
}
