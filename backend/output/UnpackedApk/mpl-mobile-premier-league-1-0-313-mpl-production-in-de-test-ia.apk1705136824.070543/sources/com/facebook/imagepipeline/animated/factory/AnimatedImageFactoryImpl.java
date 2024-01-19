package com.facebook.imagepipeline.animated.factory;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import java.util.ArrayList;
import java.util.List;

public class AnimatedImageFactoryImpl implements AnimatedImageFactory {
    public static AnimatedImageDecoder sGifAnimatedImageDecoder = loadIfPresent("com.facebook.animated.gif.GifImage");
    public static AnimatedImageDecoder sWebpAnimatedImageDecoder = loadIfPresent("com.facebook.animated.webp.WebPImage");
    public final AnimatedDrawableBackendProvider mAnimatedDrawableBackendProvider;
    public final PlatformBitmapFactory mBitmapFactory;

    public AnimatedImageFactoryImpl(AnimatedDrawableBackendProvider animatedDrawableBackendProvider, PlatformBitmapFactory platformBitmapFactory) {
        this.mAnimatedDrawableBackendProvider = animatedDrawableBackendProvider;
        this.mBitmapFactory = platformBitmapFactory;
    }

    @SuppressLint({"NewApi"})
    private CloseableReference<Bitmap> createBitmap(int i, int i2, Config config) {
        CloseableReference<Bitmap> createBitmapInternal = this.mBitmapFactory.createBitmapInternal(i, i2, config);
        ((Bitmap) createBitmapInternal.get()).eraseColor(0);
        ((Bitmap) createBitmapInternal.get()).setHasAlpha(true);
        return createBitmapInternal;
    }

    private CloseableReference<Bitmap> createPreviewBitmap(AnimatedImage animatedImage, Config config, int i) {
        CloseableReference<Bitmap> createBitmap = createBitmap(animatedImage.getWidth(), animatedImage.getHeight(), config);
        new AnimatedImageCompositor(this.mAnimatedDrawableBackendProvider.get(AnimatedImageResult.forAnimatedImage(animatedImage), null), new Callback() {
            public CloseableReference<Bitmap> getCachedBitmap(int i) {
                return null;
            }

            public void onIntermediateResult(int i, Bitmap bitmap) {
            }
        }).renderFrame(i, (Bitmap) createBitmap.get());
        return createBitmap;
    }

    private List<CloseableReference<Bitmap>> decodeAllFrames(AnimatedImage animatedImage, Config config) {
        AnimatedDrawableBackend animatedDrawableBackend = this.mAnimatedDrawableBackendProvider.get(AnimatedImageResult.forAnimatedImage(animatedImage), null);
        final ArrayList arrayList = new ArrayList(animatedDrawableBackend.getFrameCount());
        AnimatedImageCompositor animatedImageCompositor = new AnimatedImageCompositor(animatedDrawableBackend, new Callback() {
            public CloseableReference<Bitmap> getCachedBitmap(int i) {
                return CloseableReference.cloneOrNull((CloseableReference) arrayList.get(i));
            }

            public void onIntermediateResult(int i, Bitmap bitmap) {
            }
        });
        for (int i = 0; i < animatedDrawableBackend.getFrameCount(); i++) {
            CloseableReference<Bitmap> createBitmap = createBitmap(animatedDrawableBackend.getWidth(), animatedDrawableBackend.getHeight(), config);
            animatedImageCompositor.renderFrame(i, (Bitmap) createBitmap.get());
            arrayList.add(createBitmap);
        }
        return arrayList;
    }

    private CloseableImage getCloseableImage(ImageDecodeOptions imageDecodeOptions, AnimatedImage animatedImage, Config config) {
        List<CloseableReference<Bitmap>> list;
        CloseableReference closeableReference = null;
        try {
            int frameCount = imageDecodeOptions.useLastFrameForPreview ? animatedImage.getFrameCount() - 1 : 0;
            if (imageDecodeOptions.forceStaticImage) {
                CloseableStaticBitmap closeableStaticBitmap = new CloseableStaticBitmap(createPreviewBitmap(animatedImage, config, frameCount), ImmutableQualityInfo.FULL_QUALITY, 0);
                CloseableReference.closeSafely((CloseableReference<?>) null);
                CloseableReference.closeSafely((Iterable<? extends CloseableReference<?>>) null);
                return closeableStaticBitmap;
            }
            if (imageDecodeOptions.decodeAllFrames) {
                list = decodeAllFrames(animatedImage, config);
                try {
                    closeableReference = CloseableReference.cloneOrNull(list.get(frameCount));
                } catch (Throwable th) {
                    th = th;
                    CloseableReference.closeSafely((CloseableReference<?>) null);
                    CloseableReference.closeSafely((Iterable<? extends CloseableReference<?>>) list);
                    throw th;
                }
            } else {
                list = null;
            }
            if (imageDecodeOptions.decodePreviewFrame && closeableReference == null) {
                closeableReference = createPreviewBitmap(animatedImage, config, frameCount);
            }
            CloseableAnimatedImage closeableAnimatedImage = new CloseableAnimatedImage(AnimatedImageResult.newBuilder(animatedImage).setPreviewBitmap(closeableReference).setFrameForPreview(frameCount).setDecodedFrames(list).build());
            CloseableReference.closeSafely(closeableReference);
            CloseableReference.closeSafely((Iterable<? extends CloseableReference<?>>) list);
            return closeableAnimatedImage;
        } catch (Throwable th2) {
            th = th2;
            list = null;
            CloseableReference.closeSafely((CloseableReference<?>) null);
            CloseableReference.closeSafely((Iterable<? extends CloseableReference<?>>) list);
            throw th;
        }
    }

    public static AnimatedImageDecoder loadIfPresent(String str) {
        try {
            return (AnimatedImageDecoder) Class.forName(str).newInstance();
        } catch (Throwable unused) {
            return null;
        }
    }

    public CloseableImage decodeGif(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions, Config config) {
        AnimatedImage animatedImage;
        if (sGifAnimatedImageDecoder != null) {
            CloseableReference<PooledByteBuffer> byteBufferRef = encodedImage.getByteBufferRef();
            k.checkNotNull1(byteBufferRef);
            try {
                PooledByteBuffer pooledByteBuffer = (PooledByteBuffer) byteBufferRef.get();
                if (pooledByteBuffer.getByteBuffer() != null) {
                    animatedImage = sGifAnimatedImageDecoder.decode(pooledByteBuffer.getByteBuffer());
                } else {
                    animatedImage = sGifAnimatedImageDecoder.decode(pooledByteBuffer.getNativePtr(), pooledByteBuffer.size());
                }
                return getCloseableImage(imageDecodeOptions, animatedImage, config);
            } finally {
                byteBufferRef.close();
            }
        } else {
            throw new UnsupportedOperationException("To encode animated gif please add the dependency to the animated-gif module");
        }
    }

    public CloseableImage decodeWebP(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions, Config config) {
        AnimatedImage animatedImage;
        if (sWebpAnimatedImageDecoder != null) {
            CloseableReference<PooledByteBuffer> byteBufferRef = encodedImage.getByteBufferRef();
            k.checkNotNull1(byteBufferRef);
            try {
                PooledByteBuffer pooledByteBuffer = (PooledByteBuffer) byteBufferRef.get();
                if (pooledByteBuffer.getByteBuffer() != null) {
                    animatedImage = sWebpAnimatedImageDecoder.decode(pooledByteBuffer.getByteBuffer());
                } else {
                    animatedImage = sWebpAnimatedImageDecoder.decode(pooledByteBuffer.getNativePtr(), pooledByteBuffer.size());
                }
                return getCloseableImage(imageDecodeOptions, animatedImage, config);
            } finally {
                byteBufferRef.close();
            }
        } else {
            throw new UnsupportedOperationException("To encode animated webp please add the dependency to the animated-webp module");
        }
    }
}
