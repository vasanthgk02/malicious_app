package android.support.v4.media;

import android.media.MediaDescription;
import android.net.Uri;

public class MediaDescriptionCompatApi23 {

    public static class Builder {
        public static void setMediaUri(Object obj, Uri uri) {
            ((android.media.MediaDescription.Builder) obj).setMediaUri(uri);
        }
    }

    public static Uri getMediaUri(Object obj) {
        return ((MediaDescription) obj).getMediaUri();
    }
}
