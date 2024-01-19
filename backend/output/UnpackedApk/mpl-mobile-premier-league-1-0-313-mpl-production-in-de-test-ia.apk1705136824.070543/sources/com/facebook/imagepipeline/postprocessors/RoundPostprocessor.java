package com.facebook.imagepipeline.postprocessors;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.filter.InPlaceRoundFilter;
import com.facebook.imagepipeline.filter.XferRoundFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;

public class RoundPostprocessor extends BasePostprocessor {
    public static final boolean ENABLE_ANTI_ALIASING = true;
    public static final boolean canUseXferRoundFilter = XferRoundFilter.canUseXferRoundFilter();
    public CacheKey mCacheKey;
    public final boolean mEnableAntiAliasing;

    public RoundPostprocessor() {
        this(true);
    }

    public CacheKey getPostprocessorCacheKey() {
        if (this.mCacheKey == null) {
            if (canUseXferRoundFilter) {
                this.mCacheKey = new SimpleCacheKey("XferRoundFilter");
            } else {
                this.mCacheKey = new SimpleCacheKey("InPlaceRoundFilter");
            }
        }
        return this.mCacheKey;
    }

    public void process(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null) {
            throw null;
        } else if (bitmap2 == null) {
            throw null;
        } else if (canUseXferRoundFilter) {
            XferRoundFilter.xferRoundBitmap(bitmap, bitmap2, this.mEnableAntiAliasing);
        } else {
            super.process(bitmap, bitmap2);
        }
    }

    public RoundPostprocessor(boolean z) {
        this.mEnableAntiAliasing = z;
    }

    public void process(Bitmap bitmap) {
        InPlaceRoundFilter.roundBitmapInPlace(bitmap);
    }
}
