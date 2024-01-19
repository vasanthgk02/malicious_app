package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.common.references.CloseableReference;
import java.util.List;

public class AnimatedImageResult {
    public List<CloseableReference<Bitmap>> mDecodedFrames;
    public final int mFrameForPreview;
    public final AnimatedImage mImage;
    public CloseableReference<Bitmap> mPreviewBitmap;

    public AnimatedImageResult(AnimatedImageResultBuilder animatedImageResultBuilder) {
        AnimatedImage image = animatedImageResultBuilder.getImage();
        k.checkNotNull1(image);
        this.mImage = image;
        this.mFrameForPreview = animatedImageResultBuilder.getFrameForPreview();
        this.mPreviewBitmap = animatedImageResultBuilder.getPreviewBitmap();
        this.mDecodedFrames = animatedImageResultBuilder.getDecodedFrames();
    }

    public static AnimatedImageResult forAnimatedImage(AnimatedImage animatedImage) {
        return new AnimatedImageResult(animatedImage);
    }

    public static AnimatedImageResultBuilder newBuilder(AnimatedImage animatedImage) {
        return new AnimatedImageResultBuilder(animatedImage);
    }

    public synchronized void dispose() {
        CloseableReference.closeSafely(this.mPreviewBitmap);
        this.mPreviewBitmap = null;
        CloseableReference.closeSafely((Iterable<? extends CloseableReference<?>>) this.mDecodedFrames);
        this.mDecodedFrames = null;
    }

    public synchronized CloseableReference<Bitmap> getDecodedFrame(int i) {
        if (this.mDecodedFrames == null) {
            return null;
        }
        return CloseableReference.cloneOrNull(this.mDecodedFrames.get(i));
    }

    public int getFrameForPreview() {
        return this.mFrameForPreview;
    }

    public AnimatedImage getImage() {
        return this.mImage;
    }

    public synchronized CloseableReference<Bitmap> getPreviewBitmap() {
        return CloseableReference.cloneOrNull(this.mPreviewBitmap);
    }

    public synchronized boolean hasDecodedFrame(int i) {
        return (this.mDecodedFrames == null || this.mDecodedFrames.get(i) == null) ? false : true;
    }

    public AnimatedImageResult(AnimatedImage animatedImage) {
        if (animatedImage != null) {
            this.mImage = animatedImage;
            this.mFrameForPreview = 0;
            return;
        }
        throw null;
    }
}
