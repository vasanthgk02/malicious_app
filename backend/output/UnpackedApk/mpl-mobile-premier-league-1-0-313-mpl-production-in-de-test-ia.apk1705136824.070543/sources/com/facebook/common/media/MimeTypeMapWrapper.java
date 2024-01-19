package com.facebook.common.media;

import android.webkit.MimeTypeMap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;

public class MimeTypeMapWrapper {
    public static final Map<String, String> sExtensionToMimeTypeMap = ImmutableMap.of("heif", "image/heif", "heic", "image/heic");
    public static final MimeTypeMap sMimeTypeMap = MimeTypeMap.getSingleton();

    static {
        ImmutableMap.of("image/heif", "heif", "image/heic", "heic");
    }
}
