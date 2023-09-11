package test;

import org.junit.Test;
import urlshortener.UrlShortener;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestDesignProb2 {

    @Test
    public void testUrlShortener() {
        UrlShortener urlShortener = new UrlShortener();
        String longUrl1 = "really long URL";
        String longUrl2 = "really long URL 2";
        urlShortener.shortenUrl(longUrl1);
        String shortUrl1 = urlShortener.getShortUrl(longUrl1);
        assertTrue(shortUrl1.length() < longUrl1.length());
        urlShortener.shortenUrl(longUrl2);
        String shortUrl2 = urlShortener.getShortUrl(longUrl2);
        assertTrue(shortUrl2.length() < longUrl2.length());
        int count = urlShortener.getCount();
        assertEquals(2, count);
        int averageLength = urlShortener.getAverageLength();
        assertEquals(15, averageLength);
        int minLength = urlShortener.getMinLength();
        assertEquals(14, minLength);
        int maxLength = urlShortener.getMaxLength();
        assertEquals(16, maxLength);
    }
}
