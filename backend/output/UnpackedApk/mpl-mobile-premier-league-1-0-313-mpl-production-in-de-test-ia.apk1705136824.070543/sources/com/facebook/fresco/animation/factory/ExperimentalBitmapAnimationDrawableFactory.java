package com.facebook.fresco.animation.factory;

import android.net.Uri;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.time.MonotonicClock;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public class ExperimentalBitmapAnimationDrawableFactory implements DrawableFactory {
    public final AnimatedDrawableBackendProvider mAnimatedDrawableBackendProvider;
    public final CountingMemoryCache<CacheKey, CloseableImage> mBackingCache;
    public final Supplier<Integer> mCachingStrategySupplier;
    public final ExecutorService mExecutorServiceForFramePreparing;
    public final MonotonicClock mMonotonicClock;
    public final Supplier<Integer> mNumberOfFramesToPrepareSupplier;
    public final PlatformBitmapFactory mPlatformBitmapFactory;
    public final ScheduledExecutorService mScheduledExecutorServiceForUiThread;

    public static class AnimationFrameCacheKey implements CacheKey {
        public final String mAnimationUriString;

        public AnimationFrameCacheKey(int i) {
            this.mAnimationUriString = GeneratedOutlineSupport.outline41("anim://", i);
        }

        public boolean containsUri(Uri uri) {
            return uri.toString().startsWith(this.mAnimationUriString);
        }

        public String getUriString() {
            return this.mAnimationUriString;
        }
    }

    public ExperimentalBitmapAnimationDrawableFactory(AnimatedDrawableBackendProvider animatedDrawableBackendProvider, ScheduledExecutorService scheduledExecutorService, ExecutorService executorService, MonotonicClock monotonicClock, PlatformBitmapFactory platformBitmapFactory, CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache, Supplier<Integer> supplier, Supplier<Integer> supplier2) {
        this.mAnimatedDrawableBackendProvider = animatedDrawableBackendProvider;
        this.mScheduledExecutorServiceForUiThread = scheduledExecutorService;
        this.mExecutorServiceForFramePreparing = executorService;
        this.mMonotonicClock = monotonicClock;
        this.mPlatformBitmapFactory = platformBitmapFactory;
        this.mBackingCache = countingMemoryCache;
        this.mCachingStrategySupplier = supplier;
        this.mNumberOfFramesToPrepareSupplier = supplier2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0095  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.drawable.Drawable createDrawable(com.facebook.imagepipeline.image.CloseableImage r10) {
        /*
            r9 = this;
            com.facebook.fresco.animation.drawable.AnimatedDrawable2 r0 = new com.facebook.fresco.animation.drawable.AnimatedDrawable2
            com.facebook.imagepipeline.image.CloseableAnimatedImage r10 = (com.facebook.imagepipeline.image.CloseableAnimatedImage) r10
            com.facebook.imagepipeline.animated.base.AnimatedImageResult r10 = r10.getImageResult()
            com.facebook.imagepipeline.animated.base.AnimatedImage r1 = r10.getImage()
            android.graphics.Rect r2 = new android.graphics.Rect
            int r3 = r1.getWidth()
            int r1 = r1.getHeight()
            r4 = 0
            r2.<init>(r4, r4, r3, r1)
            com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider r1 = r9.mAnimatedDrawableBackendProvider
            com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend r1 = r1.get(r10, r2)
            com.facebook.common.internal.Supplier<java.lang.Integer> r2 = r9.mCachingStrategySupplier
            java.lang.Object r2 = r2.get()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r3 = 1
            if (r2 == r3) goto L_0x0057
            r3 = 2
            if (r2 == r3) goto L_0x0041
            r10 = 3
            if (r2 == r10) goto L_0x003b
            com.facebook.fresco.animation.bitmap.cache.NoOpCache r10 = new com.facebook.fresco.animation.bitmap.cache.NoOpCache
            r10.<init>()
            goto L_0x006d
        L_0x003b:
            com.facebook.fresco.animation.bitmap.cache.KeepLastFrameCache r10 = new com.facebook.fresco.animation.bitmap.cache.KeepLastFrameCache
            r10.<init>()
            goto L_0x006d
        L_0x0041:
            com.facebook.fresco.animation.bitmap.cache.FrescoFrameCache r2 = new com.facebook.fresco.animation.bitmap.cache.FrescoFrameCache
            com.facebook.imagepipeline.animated.impl.AnimatedFrameCache r3 = new com.facebook.imagepipeline.animated.impl.AnimatedFrameCache
            com.facebook.fresco.animation.factory.ExperimentalBitmapAnimationDrawableFactory$AnimationFrameCacheKey r5 = new com.facebook.fresco.animation.factory.ExperimentalBitmapAnimationDrawableFactory$AnimationFrameCacheKey
            int r10 = r10.hashCode()
            r5.<init>(r10)
            com.facebook.imagepipeline.cache.CountingMemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> r10 = r9.mBackingCache
            r3.<init>(r5, r10)
            r2.<init>(r3, r4)
            goto L_0x006c
        L_0x0057:
            com.facebook.fresco.animation.bitmap.cache.FrescoFrameCache r2 = new com.facebook.fresco.animation.bitmap.cache.FrescoFrameCache
            com.facebook.imagepipeline.animated.impl.AnimatedFrameCache r4 = new com.facebook.imagepipeline.animated.impl.AnimatedFrameCache
            com.facebook.fresco.animation.factory.ExperimentalBitmapAnimationDrawableFactory$AnimationFrameCacheKey r5 = new com.facebook.fresco.animation.factory.ExperimentalBitmapAnimationDrawableFactory$AnimationFrameCacheKey
            int r10 = r10.hashCode()
            r5.<init>(r10)
            com.facebook.imagepipeline.cache.CountingMemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> r10 = r9.mBackingCache
            r4.<init>(r5, r10)
            r2.<init>(r4, r3)
        L_0x006c:
            r10 = r2
        L_0x006d:
            r4 = r10
            com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendFrameRenderer r6 = new com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendFrameRenderer
            r6.<init>(r4, r1)
            com.facebook.common.internal.Supplier<java.lang.Integer> r10 = r9.mNumberOfFramesToPrepareSupplier
            java.lang.Object r10 = r10.get()
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            r2 = 0
            if (r10 <= 0) goto L_0x0095
            com.facebook.fresco.animation.bitmap.preparation.FixedNumberBitmapFramePreparationStrategy r2 = new com.facebook.fresco.animation.bitmap.preparation.FixedNumberBitmapFramePreparationStrategy
            r2.<init>(r10)
            com.facebook.fresco.animation.bitmap.preparation.DefaultBitmapFramePreparer r10 = new com.facebook.fresco.animation.bitmap.preparation.DefaultBitmapFramePreparer
            com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory r3 = r9.mPlatformBitmapFactory
            android.graphics.Bitmap$Config r5 = android.graphics.Bitmap.Config.ARGB_8888
            java.util.concurrent.ExecutorService r7 = r9.mExecutorServiceForFramePreparing
            r10.<init>(r3, r6, r5, r7)
            r8 = r10
            r7 = r2
            goto L_0x0097
        L_0x0095:
            r7 = r2
            r8 = r7
        L_0x0097:
            com.facebook.fresco.animation.bitmap.BitmapAnimationBackend r10 = new com.facebook.fresco.animation.bitmap.BitmapAnimationBackend
            com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory r3 = r9.mPlatformBitmapFactory
            com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendAnimationInformation r5 = new com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendAnimationInformation
            r5.<init>(r1)
            r2 = r10
            r2.<init>(r3, r4, r5, r6, r7, r8)
            com.facebook.common.time.MonotonicClock r1 = r9.mMonotonicClock
            java.util.concurrent.ScheduledExecutorService r2 = r9.mScheduledExecutorServiceForUiThread
            com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck r3 = new com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck
            r3.<init>(r10, r10, r1, r2)
            r0.<init>(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fresco.animation.factory.ExperimentalBitmapAnimationDrawableFactory.createDrawable(com.facebook.imagepipeline.image.CloseableImage):android.graphics.drawable.Drawable");
    }

    public boolean supportsImageType(CloseableImage closeableImage) {
        return closeableImage instanceof CloseableAnimatedImage;
    }
}
