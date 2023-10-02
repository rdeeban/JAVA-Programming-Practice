package instagram;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.io.File;

public class Instagram {
    private static int PHOTO_ID = 0;
    private static int FILTER_ID = 0;

    private Map<Integer, InstagramPhoto> instagramPhotos;
    private Map<String, InstagramTag> instagramTags;
    private Map<Integer, InstagramFilter> instagramFilters;

    private static class InstagramPhoto {

        private final File image;
        private Set<InstagramTag> tags;
        private Set<InstagramFilter> filters;

        public InstagramPhoto(File image) {
            this.image = image;
            tags = new HashSet<>();
            filters = new HashSet<>();
        }

        private void addTag(InstagramTag instagramTag) {
            tags.add(instagramTag);
        }

        private void addFilter(InstagramFilter instagramFilter) {
            filters.add(instagramFilter);
        }
    }

    private static class InstagramTag {
        private static int TAG_ID = 0;
        private final int tagId;
        private final String tag;

        public InstagramTag(String tag) {
            tagId = TAG_ID ++;
            this.tag = tag;
        }
    }

    private static class InstagramFilter {
        private static int FILTER_ID = 0;
        private int filterId;

        public InstagramFilter() {
            filterId = FILTER_ID ++;
        }
    }

    public Instagram() {
        instagramPhotos = new HashMap<>();
        instagramTags = new HashMap<>();
        instagramFilters = new HashMap<>();
        instagramFilters.put(FILTER_ID ++, new InstagramFilter());
    }

    /**
     * Adds a photo and returns the photo ID
     * @param uploadPath file path
     * @return photo ID
     */
    public int uploadPhoto(String uploadPath) {
        File photo = new File(uploadPath);
        int photoId = PHOTO_ID;
        InstagramPhoto instagramPhoto = new InstagramPhoto(photo);
        instagramPhotos.put(photoId, instagramPhoto);
        PHOTO_ID ++;
        return photoId;
    }

    /**
     * Adds a tag to the photo
     * @param photoId Instagram photo ID
     * @param tag Instagram tag
     */
    public void tagPhoto(int photoId, String tag) {
        InstagramTag instagramTag;
        if (instagramTags.containsKey(tag)) {
            instagramTag = instagramTags.get(tag);
        } else {
            instagramTag = new InstagramTag(tag);
        }

        instagramPhotos.get(photoId).addTag(instagramTag);
    }

    /**
     * Adds a filter to the photo
     * @param photoId Instagram photo ID
     * @param filterId Instagram filter
     */
    public void addFilter(int photoId, int filterId) {
        instagramPhotos.get(photoId).addFilter(instagramFilters.get(filterId));
    }
}
