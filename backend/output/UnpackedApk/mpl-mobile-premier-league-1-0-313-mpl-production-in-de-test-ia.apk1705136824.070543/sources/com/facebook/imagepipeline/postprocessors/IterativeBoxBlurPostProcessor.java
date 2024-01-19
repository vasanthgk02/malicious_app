package com.facebook.imagepipeline.postprocessors;

import android.graphics.Bitmap;
import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;

public class IterativeBoxBlurPostProcessor extends BasePostprocessor {
    public static final int DEFAULT_ITERATIONS = 3;
    public final int mBlurRadius;
    public CacheKey mCacheKey;
    public final int mIterations;

    public IterativeBoxBlurPostProcessor(int i) {
        this(3, i);
    }

    public CacheKey getPostprocessorCacheKey() {
        if (this.mCacheKey == null) {
            this.mCacheKey = new SimpleCacheKey(String.format(null, "i%dr%d", new Object[]{Integer.valueOf(this.mIterations), Integer.valueOf(this.mBlurRadius)}));
        }
        return this.mCacheKey;
    }

    public void process(Bitmap bitmap) {
        NativeBlurFilter.iterativeBoxBlur(bitmap, this.mIterations, this.mBlurRadius);
    }

    public IterativeBoxBlurPostProcessor(int i, int i2) {
        boolean z = true;
        k.checkArgument(i > 0);
        k.checkArgument(i2 <= 0 ? false : z);
        this.mIterations = i;
        this.mBlurRadius = i2;
    }
}
