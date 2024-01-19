package com.facebook.fresco.animation.bitmap;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;

public interface BitmapFrameCache {
    void clear();

    boolean contains(int i);

    CloseableReference<Bitmap> getBitmapToReuseForFrame(int i, int i2, int i3);

    CloseableReference<Bitmap> getCachedFrame(int i);

    CloseableReference<Bitmap> getFallbackFrame(int i);

    void onFramePrepared(int i, CloseableReference<Bitmap> closeableReference, int i2);

    void onFrameRendered(int i, CloseableReference<Bitmap> closeableReference, int i2);
}
