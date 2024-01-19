package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;

public class AnimatedDrawableBackendImpl implements AnimatedDrawableBackend {
    public final AnimatedDrawableUtil mAnimatedDrawableUtil;
    public final AnimatedImage mAnimatedImage;
    public final AnimatedImageResult mAnimatedImageResult;
    public final boolean mDownscaleFrameToDrawableDimensions;
    public final int mDurationMs;
    public final int[] mFrameDurationsMs;
    public final AnimatedDrawableFrameInfo[] mFrameInfos;
    public final int[] mFrameTimestampsMs;
    public final Rect mRenderDstRect = new Rect();
    public final Rect mRenderSrcRect = new Rect();
    public final Rect mRenderedBounds;
    public Bitmap mTempBitmap;

    public AnimatedDrawableBackendImpl(AnimatedDrawableUtil animatedDrawableUtil, AnimatedImageResult animatedImageResult, Rect rect, boolean z) {
        this.mAnimatedDrawableUtil = animatedDrawableUtil;
        this.mAnimatedImageResult = animatedImageResult;
        AnimatedImage image = animatedImageResult.getImage();
        this.mAnimatedImage = image;
        int[] frameDurations = image.getFrameDurations();
        this.mFrameDurationsMs = frameDurations;
        this.mAnimatedDrawableUtil.fixFrameDurations(frameDurations);
        this.mDurationMs = this.mAnimatedDrawableUtil.getTotalDurationFromFrameDurations(this.mFrameDurationsMs);
        this.mFrameTimestampsMs = this.mAnimatedDrawableUtil.getFrameTimeStampsFromDurations(this.mFrameDurationsMs);
        this.mRenderedBounds = getBoundsToUse(this.mAnimatedImage, rect);
        this.mDownscaleFrameToDrawableDimensions = z;
        this.mFrameInfos = new AnimatedDrawableFrameInfo[this.mAnimatedImage.getFrameCount()];
        for (int i = 0; i < this.mAnimatedImage.getFrameCount(); i++) {
            this.mFrameInfos[i] = this.mAnimatedImage.getFrameInfo(i);
        }
    }

    private synchronized void clearTempBitmap() {
        if (this.mTempBitmap != null) {
            this.mTempBitmap.recycle();
            this.mTempBitmap = null;
        }
    }

    public static Rect getBoundsToUse(AnimatedImage animatedImage, Rect rect) {
        if (rect == null) {
            return new Rect(0, 0, animatedImage.getWidth(), animatedImage.getHeight());
        }
        return new Rect(0, 0, Math.min(rect.width(), animatedImage.getWidth()), Math.min(rect.height(), animatedImage.getHeight()));
    }

    private synchronized void prepareTempBitmapForThisSize(int i, int i2) {
        if (this.mTempBitmap != null && (this.mTempBitmap.getWidth() < i || this.mTempBitmap.getHeight() < i2)) {
            clearTempBitmap();
        }
        if (this.mTempBitmap == null) {
            this.mTempBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        }
        this.mTempBitmap.eraseColor(0);
    }

    private void renderImageDoesNotSupportScaling(Canvas canvas, AnimatedImageFrame animatedImageFrame) {
        int i;
        int i2;
        int i3;
        int i4;
        if (this.mDownscaleFrameToDrawableDimensions) {
            float max = Math.max(((float) animatedImageFrame.getWidth()) / ((float) Math.min(animatedImageFrame.getWidth(), canvas.getWidth())), ((float) animatedImageFrame.getHeight()) / ((float) Math.min(animatedImageFrame.getHeight(), canvas.getHeight())));
            i3 = (int) (((float) animatedImageFrame.getWidth()) / max);
            i2 = (int) (((float) animatedImageFrame.getHeight()) / max);
            i = (int) (((float) animatedImageFrame.getXOffset()) / max);
            i4 = (int) (((float) animatedImageFrame.getYOffset()) / max);
        } else {
            i3 = animatedImageFrame.getWidth();
            i2 = animatedImageFrame.getHeight();
            i = animatedImageFrame.getXOffset();
            i4 = animatedImageFrame.getYOffset();
        }
        synchronized (this) {
            prepareTempBitmapForThisSize(i3, i2);
            animatedImageFrame.renderFrame(i3, i2, this.mTempBitmap);
            canvas.save();
            canvas.translate((float) i, (float) i4);
            canvas.drawBitmap(this.mTempBitmap, 0.0f, 0.0f, null);
            canvas.restore();
        }
    }

    private void renderImageSupportsScaling(Canvas canvas, AnimatedImageFrame animatedImageFrame) {
        double width = ((double) this.mRenderedBounds.width()) / ((double) this.mAnimatedImage.getWidth());
        double height = ((double) this.mRenderedBounds.height()) / ((double) this.mAnimatedImage.getHeight());
        int round = (int) Math.round(((double) animatedImageFrame.getWidth()) * width);
        int round2 = (int) Math.round(((double) animatedImageFrame.getHeight()) * height);
        int xOffset = (int) (((double) animatedImageFrame.getXOffset()) * width);
        int yOffset = (int) (((double) animatedImageFrame.getYOffset()) * height);
        synchronized (this) {
            int width2 = this.mRenderedBounds.width();
            int height2 = this.mRenderedBounds.height();
            prepareTempBitmapForThisSize(width2, height2);
            animatedImageFrame.renderFrame(round, round2, this.mTempBitmap);
            this.mRenderSrcRect.set(0, 0, width2, height2);
            this.mRenderDstRect.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            canvas.drawBitmap(this.mTempBitmap, this.mRenderSrcRect, this.mRenderDstRect, null);
        }
    }

    public synchronized void dropCaches() {
        clearTempBitmap();
    }

    public AnimatedDrawableBackend forNewBounds(Rect rect) {
        if (getBoundsToUse(this.mAnimatedImage, rect).equals(this.mRenderedBounds)) {
            return this;
        }
        return new AnimatedDrawableBackendImpl(this.mAnimatedDrawableUtil, this.mAnimatedImageResult, rect, this.mDownscaleFrameToDrawableDimensions);
    }

    public AnimatedImageResult getAnimatedImageResult() {
        return this.mAnimatedImageResult;
    }

    public int getDurationMs() {
        return this.mDurationMs;
    }

    public int getDurationMsForFrame(int i) {
        return this.mFrameDurationsMs[i];
    }

    public int getFrameCount() {
        return this.mAnimatedImage.getFrameCount();
    }

    public int getFrameForPreview() {
        return this.mAnimatedImageResult.getFrameForPreview();
    }

    public int getFrameForTimestampMs(int i) {
        return this.mAnimatedDrawableUtil.getFrameForTimestampMs(this.mFrameTimestampsMs, i);
    }

    public AnimatedDrawableFrameInfo getFrameInfo(int i) {
        return this.mFrameInfos[i];
    }

    public int getHeight() {
        return this.mAnimatedImage.getHeight();
    }

    public int getLoopCount() {
        return this.mAnimatedImage.getLoopCount();
    }

    public synchronized int getMemoryUsage() {
        int i;
        i = 0;
        if (this.mTempBitmap != null) {
            i = 0 + this.mAnimatedDrawableUtil.getSizeOfBitmap(this.mTempBitmap);
        }
        return i + this.mAnimatedImage.getSizeInBytes();
    }

    public CloseableReference<Bitmap> getPreDecodedFrame(int i) {
        return this.mAnimatedImageResult.getDecodedFrame(i);
    }

    public int getRenderedHeight() {
        return this.mRenderedBounds.height();
    }

    public int getRenderedWidth() {
        return this.mRenderedBounds.width();
    }

    public int getTimestampMsForFrame(int i) {
        k.checkElementIndex(i, this.mFrameTimestampsMs.length);
        return this.mFrameTimestampsMs[i];
    }

    public int getWidth() {
        return this.mAnimatedImage.getWidth();
    }

    public boolean hasPreDecodedFrame(int i) {
        return this.mAnimatedImageResult.hasDecodedFrame(i);
    }

    public void renderFrame(int i, Canvas canvas) {
        AnimatedImageFrame frame = this.mAnimatedImage.getFrame(i);
        try {
            if (this.mAnimatedImage.doesRenderSupportScaling()) {
                renderImageSupportsScaling(canvas, frame);
            } else {
                renderImageDoesNotSupportScaling(canvas, frame);
            }
        } finally {
            frame.dispose();
        }
    }
}