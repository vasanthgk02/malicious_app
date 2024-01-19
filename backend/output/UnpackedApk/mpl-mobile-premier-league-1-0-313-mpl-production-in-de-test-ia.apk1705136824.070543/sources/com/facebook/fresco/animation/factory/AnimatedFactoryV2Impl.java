package com.facebook.fresco.animation.factory;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.executors.DefaultSerialExecutorService;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Supplier;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.factory.AnimatedFactory;
import com.facebook.imagepipeline.animated.factory.AnimatedImageFactory;
import com.facebook.imagepipeline.animated.factory.AnimatedImageFactoryImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.core.ExecutorSupplier;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.QualityInfo;

@DoNotStrip
public class AnimatedFactoryV2Impl implements AnimatedFactory {
    public AnimatedDrawableBackendProvider mAnimatedDrawableBackendProvider;
    public DrawableFactory mAnimatedDrawableFactory;
    public AnimatedDrawableUtil mAnimatedDrawableUtil;
    public AnimatedImageFactory mAnimatedImageFactory;
    public final CountingMemoryCache<CacheKey, CloseableImage> mBackingCache;
    public final boolean mDownscaleFrameToDrawableDimensions;
    public final ExecutorSupplier mExecutorSupplier;
    public final PlatformBitmapFactory mPlatformBitmapFactory;

    @DoNotStrip
    public AnimatedFactoryV2Impl(PlatformBitmapFactory platformBitmapFactory, ExecutorSupplier executorSupplier, CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache, boolean z) {
        this.mPlatformBitmapFactory = platformBitmapFactory;
        this.mExecutorSupplier = executorSupplier;
        this.mBackingCache = countingMemoryCache;
        this.mDownscaleFrameToDrawableDimensions = z;
    }

    public DrawableFactory getAnimatedDrawableFactory(Context context) {
        if (this.mAnimatedDrawableFactory == null) {
            AnonymousClass3 r7 = new Supplier<Integer>(this) {
                public Object get() {
                    return Integer.valueOf(2);
                }
            };
            DefaultSerialExecutorService defaultSerialExecutorService = new DefaultSerialExecutorService(this.mExecutorSupplier.forDecode());
            AnonymousClass4 r8 = new Supplier<Integer>(this) {
                public Object get() {
                    return Integer.valueOf(3);
                }
            };
            if (this.mAnimatedDrawableBackendProvider == null) {
                this.mAnimatedDrawableBackendProvider = new AnimatedDrawableBackendProvider() {
                    public AnimatedDrawableBackend get(AnimatedImageResult animatedImageResult, Rect rect) {
                        AnimatedFactoryV2Impl animatedFactoryV2Impl = AnimatedFactoryV2Impl.this;
                        if (animatedFactoryV2Impl.mAnimatedDrawableUtil == null) {
                            animatedFactoryV2Impl.mAnimatedDrawableUtil = new AnimatedDrawableUtil();
                        }
                        return new AnimatedDrawableBackendImpl(animatedFactoryV2Impl.mAnimatedDrawableUtil, animatedImageResult, rect, AnimatedFactoryV2Impl.this.mDownscaleFrameToDrawableDimensions);
                    }
                };
            }
            AnimatedDrawableBackendProvider animatedDrawableBackendProvider = this.mAnimatedDrawableBackendProvider;
            if (UiThreadImmediateExecutorService.sInstance == null) {
                UiThreadImmediateExecutorService.sInstance = new UiThreadImmediateExecutorService();
            }
            ExperimentalBitmapAnimationDrawableFactory experimentalBitmapAnimationDrawableFactory = new ExperimentalBitmapAnimationDrawableFactory(animatedDrawableBackendProvider, UiThreadImmediateExecutorService.sInstance, defaultSerialExecutorService, RealtimeSinceBootClock.get(), this.mPlatformBitmapFactory, this.mBackingCache, r7, r8);
            this.mAnimatedDrawableFactory = experimentalBitmapAnimationDrawableFactory;
        }
        return this.mAnimatedDrawableFactory;
    }

    public ImageDecoder getGifDecoder(final Config config) {
        return new ImageDecoder() {
            public CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
                AnimatedFactoryV2Impl animatedFactoryV2Impl = AnimatedFactoryV2Impl.this;
                if (animatedFactoryV2Impl.mAnimatedImageFactory == null) {
                    animatedFactoryV2Impl.mAnimatedImageFactory = new AnimatedImageFactoryImpl(new AnimatedDrawableBackendProvider() {
                        public AnimatedDrawableBackend get(AnimatedImageResult animatedImageResult, Rect rect) {
                            AnimatedFactoryV2Impl animatedFactoryV2Impl = AnimatedFactoryV2Impl.this;
                            if (animatedFactoryV2Impl.mAnimatedDrawableUtil == null) {
                                animatedFactoryV2Impl.mAnimatedDrawableUtil = new AnimatedDrawableUtil();
                            }
                            return new AnimatedDrawableBackendImpl(animatedFactoryV2Impl.mAnimatedDrawableUtil, animatedImageResult, rect, AnimatedFactoryV2Impl.this.mDownscaleFrameToDrawableDimensions);
                        }
                    }, animatedFactoryV2Impl.mPlatformBitmapFactory);
                }
                return animatedFactoryV2Impl.mAnimatedImageFactory.decodeGif(encodedImage, imageDecodeOptions, config);
            }
        };
    }

    public ImageDecoder getWebPDecoder(final Config config) {
        return new ImageDecoder() {
            public CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
                AnimatedFactoryV2Impl animatedFactoryV2Impl = AnimatedFactoryV2Impl.this;
                if (animatedFactoryV2Impl.mAnimatedImageFactory == null) {
                    animatedFactoryV2Impl.mAnimatedImageFactory = new AnimatedImageFactoryImpl(new AnimatedDrawableBackendProvider() {
                        public AnimatedDrawableBackend get(AnimatedImageResult animatedImageResult, Rect rect) {
                            AnimatedFactoryV2Impl animatedFactoryV2Impl = AnimatedFactoryV2Impl.this;
                            if (animatedFactoryV2Impl.mAnimatedDrawableUtil == null) {
                                animatedFactoryV2Impl.mAnimatedDrawableUtil = new AnimatedDrawableUtil();
                            }
                            return new AnimatedDrawableBackendImpl(animatedFactoryV2Impl.mAnimatedDrawableUtil, animatedImageResult, rect, AnimatedFactoryV2Impl.this.mDownscaleFrameToDrawableDimensions);
                        }
                    }, animatedFactoryV2Impl.mPlatformBitmapFactory);
                }
                return animatedFactoryV2Impl.mAnimatedImageFactory.decodeWebP(encodedImage, imageDecodeOptions, config);
            }
        };
    }
}
