package com.facebook.imagepipeline.image;

import com.facebook.common.logging.FLog;
import java.io.Closeable;

public abstract class CloseableImage implements Closeable, ImageInfo, HasImageMetadata {
    public static final String TAG = "CloseableImage";
    public OriginalEncodedImageInfo mOriginalEncodedImageInfo;

    public abstract void close();

    public void finalize() throws Throwable {
        if (!isClosed()) {
            FLog.w((String) TAG, (String) "finalize: %s %x still open.", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
            try {
                close();
            } finally {
                super.finalize();
            }
        }
    }

    public OriginalEncodedImageInfo getOriginalEncodedImageInfo() {
        return this.mOriginalEncodedImageInfo;
    }

    public QualityInfo getQualityInfo() {
        return ImmutableQualityInfo.FULL_QUALITY;
    }

    public abstract int getSizeInBytes();

    public abstract boolean isClosed();

    public boolean isStateful() {
        return false;
    }

    public void setOriginalEncodedImageInfo(OriginalEncodedImageInfo originalEncodedImageInfo) {
        this.mOriginalEncodedImageInfo = originalEncodedImageInfo;
    }
}
