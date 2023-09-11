package urlshortener;

import java.util.HashMap;

public class UrlShortener {

    private HashMap<String, String> database;

    public UrlShortener() {
        this.database = new HashMap<>();
    }

    public void shortenUrl(String url) {
        String shortUrl = url.substring(1);
        database.put(url, shortUrl);
    }

    public String getShortUrl(String url) {
        return database.get(url);
    }

    public int getCount() {
        return database.size();
    }

    public int getAverageLength() {
        int sum = 0;
        for (String shortUrl : database.values()) {
            sum += shortUrl.length();
        }

        return sum / database.size();
    }

    public int getMinLength() {
        int minLength = Integer.MAX_VALUE;
        for (String shortUrl : database.values()) {
            int urlLength = shortUrl.length();
            if (minLength > urlLength) {
                minLength = urlLength;
            }
        }

        return minLength;
    }

    public int getMaxLength() {
        int maxLength = Integer.MIN_VALUE;
        for (String shortUrl : database.values()) {
            int urlLength = shortUrl.length();
            if (maxLength < urlLength) {
                maxLength = urlLength;
            }
        }

        return maxLength;
    }
}
