package pastebin;

import java.util.HashMap;

public class Pastebin {

    private HashMap<String, String> linkToTextMap;
    private static int GEN_ID = 0;

    public Pastebin() {
        linkToTextMap = new HashMap<>();
    }

    public String getLink(String text) {
        String link = String.valueOf(GEN_ID++);
        linkToTextMap.put(link, text);
        return link;
    }

    public String getPaste(String link) {
        return linkToTextMap.get(link);
    }
}
