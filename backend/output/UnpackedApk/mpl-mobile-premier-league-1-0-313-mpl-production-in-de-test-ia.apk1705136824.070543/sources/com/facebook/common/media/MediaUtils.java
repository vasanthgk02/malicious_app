package com.facebook.common.media;

import com.facebook.common.internal.ImmutableMap;
import java.util.Locale;
import java.util.Map;

public class MediaUtils {
    public static final Map<String, String> ADDITIONAL_ALLOWED_MIME_TYPES = ImmutableMap.of("mkv", "video/x-matroska", "glb", "model/gltf-binary");

    public static String extractMime(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        String substring = (lastIndexOf < 0 || lastIndexOf == str.length() + -1) ? null : str.substring(lastIndexOf + 1);
        if (substring == null) {
            return null;
        }
        String lowerCase = substring.toLowerCase(Locale.US);
        String str2 = MimeTypeMapWrapper.sExtensionToMimeTypeMap.get(lowerCase);
        if (str2 == null) {
            str2 = MimeTypeMapWrapper.sMimeTypeMap.getMimeTypeFromExtension(lowerCase);
        }
        if (str2 == null) {
            str2 = ADDITIONAL_ALLOWED_MIME_TYPES.get(lowerCase);
        }
        return str2;
    }

    public static boolean isVideo(String str) {
        return str != null && str.startsWith("video/");
    }
}
