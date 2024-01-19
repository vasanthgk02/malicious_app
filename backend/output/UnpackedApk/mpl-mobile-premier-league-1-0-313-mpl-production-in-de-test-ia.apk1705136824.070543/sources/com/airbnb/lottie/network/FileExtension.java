package com.airbnb.lottie.network;

import com.airbnb.lottie.utils.Logger;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.sentry.cache.EnvelopeCache;

public enum FileExtension {
    JSON(EnvelopeCache.SUFFIX_CURRENT_SESSION_FILE),
    ZIP(".zip");
    
    public final String extension;

    /* access modifiers changed from: public */
    FileExtension(String str) {
        this.extension = str;
    }

    public static FileExtension forFile(String str) {
        for (FileExtension fileExtension : values()) {
            if (str.endsWith(fileExtension.extension)) {
                return fileExtension;
            }
        }
        Logger.warning("Unable to find correct extension for " + str);
        return JSON;
    }

    public String tempExtension() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73(".temp");
        outline73.append(this.extension);
        return outline73.toString();
    }

    public String toString() {
        return this.extension;
    }
}
