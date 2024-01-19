package com.facebook.imagepipeline.cache;

import android.net.Uri;
import android.os.SystemClock;
import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;

public class BitmapMemoryCacheKey implements CacheKey {
    public final long mCacheTime;
    public final Object mCallerContext;
    public final int mHash;
    public final ImageDecodeOptions mImageDecodeOptions;
    public final CacheKey mPostprocessorCacheKey;
    public final String mPostprocessorName;
    public final ResizeOptions mResizeOptions;
    public final RotationOptions mRotationOptions;
    public final String mSourceString;

    public BitmapMemoryCacheKey(String str, ResizeOptions resizeOptions, RotationOptions rotationOptions, ImageDecodeOptions imageDecodeOptions, CacheKey cacheKey, String str2, Object obj) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        if (str != null) {
            this.mSourceString = str;
            this.mResizeOptions = resizeOptions;
            this.mRotationOptions = rotationOptions;
            this.mImageDecodeOptions = imageDecodeOptions;
            this.mPostprocessorCacheKey = cacheKey;
            this.mPostprocessorName = str2;
            Integer valueOf = Integer.valueOf(str.hashCode());
            int i6 = 0;
            Integer valueOf2 = Integer.valueOf(resizeOptions != null ? resizeOptions.hashCode() : 0);
            Integer valueOf3 = Integer.valueOf(rotationOptions.hashCode());
            ImageDecodeOptions imageDecodeOptions2 = this.mImageDecodeOptions;
            CacheKey cacheKey2 = this.mPostprocessorCacheKey;
            if (valueOf == null) {
                i = 0;
            } else {
                i = valueOf.hashCode();
            }
            if (valueOf2 == null) {
                i2 = 0;
            } else {
                i2 = valueOf2.hashCode();
            }
            if (valueOf3 == null) {
                i3 = 0;
            } else {
                i3 = valueOf3.hashCode();
            }
            if (imageDecodeOptions2 == null) {
                i4 = 0;
            } else {
                i4 = imageDecodeOptions2.hashCode();
            }
            if (cacheKey2 == null) {
                i5 = 0;
            } else {
                i5 = cacheKey2.hashCode();
            }
            this.mHash = ((((((((((i + 31) * 31) + i2) * 31) + i3) * 31) + i4) * 31) + i5) * 31) + (str2 != null ? str2.hashCode() : i6);
            this.mCallerContext = obj;
            if (RealtimeSinceBootClock.get() != null) {
                this.mCacheTime = SystemClock.elapsedRealtime();
                return;
            }
            throw null;
        }
        throw null;
    }

    public boolean containsUri(Uri uri) {
        return getUriString().contains(uri.toString());
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof BitmapMemoryCacheKey)) {
            return false;
        }
        BitmapMemoryCacheKey bitmapMemoryCacheKey = (BitmapMemoryCacheKey) obj;
        if (this.mHash == bitmapMemoryCacheKey.mHash && this.mSourceString.equals(bitmapMemoryCacheKey.mSourceString) && k.equal(this.mResizeOptions, bitmapMemoryCacheKey.mResizeOptions) && k.equal(this.mRotationOptions, bitmapMemoryCacheKey.mRotationOptions) && k.equal(this.mImageDecodeOptions, bitmapMemoryCacheKey.mImageDecodeOptions) && k.equal(this.mPostprocessorCacheKey, bitmapMemoryCacheKey.mPostprocessorCacheKey) && k.equal(this.mPostprocessorName, bitmapMemoryCacheKey.mPostprocessorName)) {
            z = true;
        }
        return z;
    }

    public Object getCallerContext() {
        return this.mCallerContext;
    }

    public long getInBitmapCacheSince() {
        return this.mCacheTime;
    }

    public String getPostprocessorName() {
        return this.mPostprocessorName;
    }

    public String getUriString() {
        return this.mSourceString;
    }

    public int hashCode() {
        return this.mHash;
    }

    public boolean isResourceIdForDebugging() {
        return false;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", new Object[]{this.mSourceString, this.mResizeOptions, this.mRotationOptions, this.mImageDecodeOptions, this.mPostprocessorCacheKey, this.mPostprocessorName, Integer.valueOf(this.mHash)});
    }
}
