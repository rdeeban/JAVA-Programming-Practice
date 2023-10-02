package test.design;

import instagram.Instagram;
import org.junit.Test;

import java.util.AbstractMap;

public class TestDesignProb6 {

    @Test
    public void testInstagram() {
        Instagram instagram = new Instagram();
        String uploadPath = "/path/to/photo";
        int photoId = instagram.uploadPhoto(uploadPath);
        String tag = "tag";
        instagram.tagPhoto(photoId, tag);
        int filterId = 0;
        instagram.addFilter(photoId, filterId);
    }
}
