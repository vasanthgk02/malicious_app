package com.facebook.fresco.animation.bitmap.cache;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.imagepipeline.animated.impl.AnimatedFrameCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;

public class FrescoFrameCache implements BitmapFrameCache {
    public static final Class<?> TAG = FrescoFrameCache.class;
    public final AnimatedFrameCache mAnimatedFrameCache;
    public final boolean mEnableBitmapReusing;
    public CloseableReference<CloseableImage> mLastRenderedItem;
    public final SparseArray<CloseableReference<CloseableImage>> mPreparedPendingFrames = new SparseArray<>();

    public FrescoFrameCache(AnimatedFrameCache animatedFrameCache, boolean z) {
        this.mAnimatedFrameCache = animatedFrameCache;
        this.mEnableBitmapReusing = z;
    }

    public static CloseableReference<Bitmap> convertToBitmapReferenceAndClose(CloseableReference<CloseableImage> closeableReference) {
        try {
            if (CloseableReference.isValid(closeableReference) && (closeableReference.get() instanceof CloseableStaticBitmap)) {
                CloseableStaticBitmap closeableStaticBitmap = (CloseableStaticBitmap) closeableReference.get();
                if (closeableStaticBitmap != null) {
                    CloseableReference<Bitmap> cloneUnderlyingBitmapReference = closeableStaticBitmap.cloneUnderlyingBitmapReference();
                    closeableReference.close();
                    return cloneUnderlyingBitmapReference;
                }
            }
            return null;
        } finally {
            CloseableReference.closeSafely(closeableReference);
        }
    }

    public synchronized void clear() {
        CloseableReference.closeSafely(this.mLastRenderedItem);
        this.mLastRenderedItem = null;
        for (int i = 0; i < this.mPreparedPendingFrames.size(); i++) {
            CloseableReference valueAt = this.mPreparedPendingFrames.valueAt(i);
            if (valueAt != null) {
                valueAt.close();
            }
        }
        this.mPreparedPendingFrames.clear();
    }

    public synchronized boolean contains(int i) {
        return this.mAnimatedFrameCache.contains(i);
    }

    public synchronized CloseableReference<Bitmap> getBitmapToReuseForFrame(int i, int i2, int i3) {
        if (!this.mEnableBitmapReusing) {
            return null;
        }
        return convertToBitmapReferenceAndClose(this.mAnimatedFrameCache.getForReuse());
    }

    public synchronized CloseableReference<Bitmap> getCachedFrame(int i) {
        return convertToBitmapReferenceAndClose(this.mAnimatedFrameCache.get(i));
    }

    public synchronized CloseableReference<Bitmap> getFallbackFrame(int i) {
        return convertToBitmapReferenceAndClose(CloseableReference.cloneOrNull(this.mLastRenderedItem));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onFramePrepared(int r4, com.facebook.common.references.CloseableReference<android.graphics.Bitmap> r5, int r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            r6 = 0
            com.facebook.imagepipeline.image.CloseableStaticBitmap r0 = new com.facebook.imagepipeline.image.CloseableStaticBitmap     // Catch:{ all -> 0x0045 }
            com.facebook.imagepipeline.image.QualityInfo r1 = com.facebook.imagepipeline.image.ImmutableQualityInfo.FULL_QUALITY     // Catch:{ all -> 0x0045 }
            r2 = 0
            r0.<init>(r5, r1, r2)     // Catch:{ all -> 0x0045 }
            com.facebook.common.references.CloseableReference r6 = com.facebook.common.references.CloseableReference.of(r0)     // Catch:{ all -> 0x0045 }
            if (r6 != 0) goto L_0x0017
            if (r6 == 0) goto L_0x0015
            r6.close()     // Catch:{ all -> 0x004a }
        L_0x0015:
            monitor-exit(r3)
            return
        L_0x0017:
            com.facebook.imagepipeline.animated.impl.AnimatedFrameCache r5 = r3.mAnimatedFrameCache     // Catch:{ all -> 0x0045 }
            com.facebook.common.references.CloseableReference r5 = r5.cache(r4, r6)     // Catch:{ all -> 0x0045 }
            boolean r0 = com.facebook.common.references.CloseableReference.isValid(r5)     // Catch:{ all -> 0x0045 }
            if (r0 == 0) goto L_0x0040
            android.util.SparseArray<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> r0 = r3.mPreparedPendingFrames     // Catch:{ all -> 0x0045 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0045 }
            com.facebook.common.references.CloseableReference r0 = (com.facebook.common.references.CloseableReference) r0     // Catch:{ all -> 0x0045 }
            com.facebook.common.references.CloseableReference.closeSafely(r0)     // Catch:{ all -> 0x0045 }
            android.util.SparseArray<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> r0 = r3.mPreparedPendingFrames     // Catch:{ all -> 0x0045 }
            r0.put(r4, r5)     // Catch:{ all -> 0x0045 }
            java.lang.Class<?> r5 = TAG     // Catch:{ all -> 0x0045 }
            java.lang.String r0 = "cachePreparedFrame(%d) cached. Pending frames: %s"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0045 }
            android.util.SparseArray<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> r1 = r3.mPreparedPendingFrames     // Catch:{ all -> 0x0045 }
            com.facebook.common.logging.FLog.v(r5, r0, r4, r1)     // Catch:{ all -> 0x0045 }
        L_0x0040:
            com.facebook.common.references.CloseableReference.closeSafely(r6)     // Catch:{ all -> 0x004a }
            monitor-exit(r3)
            return
        L_0x0045:
            r4 = move-exception
            com.facebook.common.references.CloseableReference.closeSafely(r6)     // Catch:{ all -> 0x004a }
            throw r4     // Catch:{ all -> 0x004a }
        L_0x004a:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fresco.animation.bitmap.cache.FrescoFrameCache.onFramePrepared(int, com.facebook.common.references.CloseableReference, int):void");
    }

    public synchronized void onFrameRendered(int i, CloseableReference<Bitmap> closeableReference, int i2) {
        if (closeableReference != null) {
            removePreparedReference(i);
            try {
                CloseableReference of = CloseableReference.of(new CloseableStaticBitmap(closeableReference, ImmutableQualityInfo.FULL_QUALITY, 0));
                if (of != null) {
                    CloseableReference.closeSafely(this.mLastRenderedItem);
                    this.mLastRenderedItem = this.mAnimatedFrameCache.cache(i, of);
                }
                if (of != null) {
                    of.close();
                }
            } catch (Throwable th) {
                CloseableReference.closeSafely((CloseableReference<?>) null);
                throw th;
            }
        } else {
            throw null;
        }
    }

    public final synchronized void removePreparedReference(int i) {
        CloseableReference closeableReference = this.mPreparedPendingFrames.get(i);
        if (closeableReference != null) {
            this.mPreparedPendingFrames.delete(i);
            CloseableReference.closeSafely(closeableReference);
            FLog.v(TAG, (String) "removePreparedReference(%d) removed. Pending frames: %s", (Object) Integer.valueOf(i), (Object) this.mPreparedPendingFrames);
        }
    }
}
