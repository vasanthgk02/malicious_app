package com.facebook.imagepipeline.postprocessors;

import android.content.Context;
import android.graphics.Bitmap;
import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.filter.IterativeBoxBlurFilter;
import com.facebook.imagepipeline.filter.RenderScriptBlurFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;

public class BlurPostProcessor extends BasePostprocessor {
    public static final int DEFAULT_ITERATIONS = 3;
    public static final boolean canUseRenderScript = RenderScriptBlurFilter.canUseRenderScript();
    public final int mBlurRadius;
    public CacheKey mCacheKey;
    public final Context mContext;
    public final int mIterations;

    public BlurPostProcessor(int i, Context context, int i2) {
        boolean z = true;
        k.checkArgument(i > 0 && i <= 25);
        k.checkArgument(i2 <= 0 ? false : z);
        if (context != null) {
            this.mIterations = i2;
            this.mBlurRadius = i;
            this.mContext = context;
            return;
        }
        throw null;
    }

    public CacheKey getPostprocessorCacheKey() {
        String str;
        if (this.mCacheKey == null) {
            if (canUseRenderScript) {
                str = String.format(null, "IntrinsicBlur;%d", new Object[]{Integer.valueOf(this.mBlurRadius)});
            } else {
                str = String.format(null, "IterativeBoxBlur;%d;%d", new Object[]{Integer.valueOf(this.mIterations), Integer.valueOf(this.mBlurRadius)});
            }
            this.mCacheKey = new SimpleCacheKey(str);
        }
        return this.mCacheKey;
    }

    public void process(Bitmap bitmap, Bitmap bitmap2) {
        if (canUseRenderScript) {
            RenderScriptBlurFilter.blurBitmap(bitmap, bitmap2, this.mContext, this.mBlurRadius);
        } else {
            super.process(bitmap, bitmap2);
        }
    }

    public void process(Bitmap bitmap) {
        IterativeBoxBlurFilter.boxBlurBitmapInPlace(bitmap, this.mIterations, this.mBlurRadius);
    }

    public BlurPostProcessor(int i, Context context) {
        this(i, context, 3);
    }
}
