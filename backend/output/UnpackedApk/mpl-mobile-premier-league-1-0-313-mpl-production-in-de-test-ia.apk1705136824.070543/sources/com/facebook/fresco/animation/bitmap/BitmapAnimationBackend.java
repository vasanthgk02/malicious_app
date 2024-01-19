package com.facebook.fresco.animation.bitmap;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck.InactivityListener;
import com.facebook.fresco.animation.backend.AnimationInformation;
import com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparationStrategy;
import com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparer;
import com.facebook.fresco.animation.bitmap.preparation.DefaultBitmapFramePreparer;
import com.facebook.fresco.animation.bitmap.preparation.DefaultBitmapFramePreparer.FrameDecodeRunnable;
import com.facebook.fresco.animation.bitmap.preparation.FixedNumberBitmapFramePreparationStrategy;
import com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendFrameRenderer;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;

public class BitmapAnimationBackend implements AnimationBackend, InactivityListener {
    public static final Class<?> TAG = BitmapAnimationBackend.class;
    public final AnimationInformation mAnimationInformation;
    public Config mBitmapConfig = Config.ARGB_8888;
    public final BitmapFrameCache mBitmapFrameCache;
    public final BitmapFramePreparationStrategy mBitmapFramePreparationStrategy;
    public final BitmapFramePreparer mBitmapFramePreparer;
    public final BitmapFrameRenderer mBitmapFrameRenderer;
    public int mBitmapHeight;
    public int mBitmapWidth;
    public Rect mBounds;
    public final Paint mPaint;
    public final PlatformBitmapFactory mPlatformBitmapFactory;

    public BitmapAnimationBackend(PlatformBitmapFactory platformBitmapFactory, BitmapFrameCache bitmapFrameCache, AnimationInformation animationInformation, BitmapFrameRenderer bitmapFrameRenderer, BitmapFramePreparationStrategy bitmapFramePreparationStrategy, BitmapFramePreparer bitmapFramePreparer) {
        this.mPlatformBitmapFactory = platformBitmapFactory;
        this.mBitmapFrameCache = bitmapFrameCache;
        this.mAnimationInformation = animationInformation;
        this.mBitmapFrameRenderer = bitmapFrameRenderer;
        this.mBitmapFramePreparationStrategy = bitmapFramePreparationStrategy;
        this.mBitmapFramePreparer = bitmapFramePreparer;
        this.mPaint = new Paint(6);
        updateBitmapDimensions();
    }

    public void clear() {
        this.mBitmapFrameCache.clear();
    }

    public final boolean drawBitmapAndCache(int i, CloseableReference<Bitmap> closeableReference, Canvas canvas, int i2) {
        if (!CloseableReference.isValid(closeableReference)) {
            return false;
        }
        if (this.mBounds == null) {
            canvas.drawBitmap((Bitmap) closeableReference.get(), 0.0f, 0.0f, this.mPaint);
        } else {
            canvas.drawBitmap((Bitmap) closeableReference.get(), null, this.mBounds, this.mPaint);
        }
        if (i2 != 3) {
            this.mBitmapFrameCache.onFrameRendered(i, closeableReference, i2);
        }
        return true;
    }

    public boolean drawFrame(Drawable drawable, Canvas canvas, int i) {
        int i2 = i;
        boolean drawFrameOrFallback = drawFrameOrFallback(canvas, i2, 0);
        BitmapFramePreparationStrategy bitmapFramePreparationStrategy = this.mBitmapFramePreparationStrategy;
        if (bitmapFramePreparationStrategy != null) {
            BitmapFramePreparer bitmapFramePreparer = this.mBitmapFramePreparer;
            if (bitmapFramePreparer != null) {
                BitmapFrameCache bitmapFrameCache = this.mBitmapFrameCache;
                FixedNumberBitmapFramePreparationStrategy fixedNumberBitmapFramePreparationStrategy = (FixedNumberBitmapFramePreparationStrategy) bitmapFramePreparationStrategy;
                int i3 = 1;
                while (i3 <= fixedNumberBitmapFramePreparationStrategy.mFramesToPrepare) {
                    int frameCount = (i2 + i3) % getFrameCount();
                    if (FLog.isLoggable(2)) {
                        FLog.v(FixedNumberBitmapFramePreparationStrategy.TAG, (String) "Preparing frame %d, last drawn: %d", (Object) Integer.valueOf(frameCount), (Object) Integer.valueOf(i));
                    }
                    DefaultBitmapFramePreparer defaultBitmapFramePreparer = (DefaultBitmapFramePreparer) bitmapFramePreparer;
                    if (defaultBitmapFramePreparer != null) {
                        int hashCode = (hashCode() * 31) + frameCount;
                        synchronized (defaultBitmapFramePreparer.mPendingFrameDecodeJobs) {
                            if (defaultBitmapFramePreparer.mPendingFrameDecodeJobs.get(hashCode) != null) {
                                FLog.v(DefaultBitmapFramePreparer.TAG, (String) "Already scheduled decode job for frame %d", (Object) Integer.valueOf(frameCount));
                            } else if (bitmapFrameCache.contains(frameCount)) {
                                FLog.v(DefaultBitmapFramePreparer.TAG, (String) "Frame %d is cached already.", (Object) Integer.valueOf(frameCount));
                            } else {
                                FrameDecodeRunnable frameDecodeRunnable = r1;
                                FrameDecodeRunnable frameDecodeRunnable2 = new FrameDecodeRunnable(this, bitmapFrameCache, frameCount, hashCode);
                                defaultBitmapFramePreparer.mPendingFrameDecodeJobs.put(hashCode, frameDecodeRunnable);
                                defaultBitmapFramePreparer.mExecutorService.execute(frameDecodeRunnable);
                            }
                        }
                        i3++;
                        i2 = i;
                    } else {
                        throw null;
                    }
                }
            }
        }
        return drawFrameOrFallback;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003a, code lost:
        com.facebook.common.logging.FLog.w(TAG, (java.lang.String) "Failed to create frame bitmap", (java.lang.Throwable) r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0041, code lost:
        com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0078, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0079, code lost:
        com.facebook.common.references.CloseableReference.closeSafely(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x007c, code lost:
        throw r10;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:7:0x0012, B:10:0x001e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean drawFrameOrFallback(android.graphics.Canvas r10, int r11, int r12) {
        /*
            r9 = this;
            r0 = -1
            r1 = 3
            r2 = 2
            r3 = 0
            r4 = 1
            r5 = 0
            if (r12 == 0) goto L_0x005f
            if (r12 == r4) goto L_0x0045
            if (r12 == r2) goto L_0x001e
            if (r12 == r1) goto L_0x0012
            com.facebook.common.references.CloseableReference.closeSafely(r5)
            return r3
        L_0x0012:
            com.facebook.fresco.animation.bitmap.BitmapFrameCache r12 = r9.mBitmapFrameCache     // Catch:{ all -> 0x0078 }
            com.facebook.common.references.CloseableReference r5 = r12.getFallbackFrame(r11)     // Catch:{ all -> 0x0078 }
            boolean r12 = r9.drawBitmapAndCache(r11, r5, r10, r1)     // Catch:{ all -> 0x0078 }
            r1 = -1
            goto L_0x006a
        L_0x001e:
            com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory r12 = r9.mPlatformBitmapFactory     // Catch:{ RuntimeException -> 0x0039 }
            int r6 = r9.mBitmapWidth     // Catch:{ RuntimeException -> 0x0039 }
            int r7 = r9.mBitmapHeight     // Catch:{ RuntimeException -> 0x0039 }
            android.graphics.Bitmap$Config r8 = r9.mBitmapConfig     // Catch:{ RuntimeException -> 0x0039 }
            com.facebook.common.references.CloseableReference r5 = r12.createBitmap(r6, r7, r8)     // Catch:{ RuntimeException -> 0x0039 }
            boolean r12 = r9.renderFrameInBitmap(r11, r5)     // Catch:{ all -> 0x0078 }
            if (r12 == 0) goto L_0x0037
            boolean r12 = r9.drawBitmapAndCache(r11, r5, r10, r2)     // Catch:{ all -> 0x0078 }
            if (r12 == 0) goto L_0x0037
            r3 = 1
        L_0x0037:
            r12 = r3
            goto L_0x006a
        L_0x0039:
            r10 = move-exception
            java.lang.Class<?> r11 = TAG     // Catch:{ all -> 0x0078 }
            java.lang.String r12 = "Failed to create frame bitmap"
            com.facebook.common.logging.FLog.w(r11, r12, r10)     // Catch:{ all -> 0x0078 }
            com.facebook.common.references.CloseableReference.closeSafely(r5)
            return r3
        L_0x0045:
            com.facebook.fresco.animation.bitmap.BitmapFrameCache r12 = r9.mBitmapFrameCache     // Catch:{ all -> 0x0078 }
            int r1 = r9.mBitmapWidth     // Catch:{ all -> 0x0078 }
            int r6 = r9.mBitmapHeight     // Catch:{ all -> 0x0078 }
            com.facebook.common.references.CloseableReference r5 = r12.getBitmapToReuseForFrame(r11, r1, r6)     // Catch:{ all -> 0x0078 }
            boolean r12 = r9.renderFrameInBitmap(r11, r5)     // Catch:{ all -> 0x0078 }
            if (r12 == 0) goto L_0x005c
            boolean r12 = r9.drawBitmapAndCache(r11, r5, r10, r4)     // Catch:{ all -> 0x0078 }
            if (r12 == 0) goto L_0x005c
            r3 = 1
        L_0x005c:
            r12 = r3
            r1 = 2
            goto L_0x006a
        L_0x005f:
            com.facebook.fresco.animation.bitmap.BitmapFrameCache r12 = r9.mBitmapFrameCache     // Catch:{ all -> 0x0078 }
            com.facebook.common.references.CloseableReference r5 = r12.getCachedFrame(r11)     // Catch:{ all -> 0x0078 }
            boolean r12 = r9.drawBitmapAndCache(r11, r5, r10, r3)     // Catch:{ all -> 0x0078 }
            r1 = 1
        L_0x006a:
            com.facebook.common.references.CloseableReference.closeSafely(r5)
            if (r12 != 0) goto L_0x0077
            if (r1 != r0) goto L_0x0072
            goto L_0x0077
        L_0x0072:
            boolean r10 = r9.drawFrameOrFallback(r10, r11, r1)
            return r10
        L_0x0077:
            return r12
        L_0x0078:
            r10 = move-exception
            com.facebook.common.references.CloseableReference.closeSafely(r5)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fresco.animation.bitmap.BitmapAnimationBackend.drawFrameOrFallback(android.graphics.Canvas, int, int):boolean");
    }

    public int getFrameCount() {
        return this.mAnimationInformation.getFrameCount();
    }

    public int getFrameDurationMs(int i) {
        return this.mAnimationInformation.getFrameDurationMs(i);
    }

    public int getIntrinsicHeight() {
        return this.mBitmapHeight;
    }

    public int getIntrinsicWidth() {
        return this.mBitmapWidth;
    }

    public int getLoopCount() {
        return this.mAnimationInformation.getLoopCount();
    }

    public void onInactive() {
        this.mBitmapFrameCache.clear();
    }

    public final boolean renderFrameInBitmap(int i, CloseableReference<Bitmap> closeableReference) {
        if (!CloseableReference.isValid(closeableReference)) {
            return false;
        }
        boolean renderFrame = ((AnimatedDrawableBackendFrameRenderer) this.mBitmapFrameRenderer).renderFrame(i, (Bitmap) closeableReference.get());
        if (!renderFrame) {
            closeableReference.close();
        }
        return renderFrame;
    }

    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
    }

    public void setBounds(Rect rect) {
        this.mBounds = rect;
        AnimatedDrawableBackendFrameRenderer animatedDrawableBackendFrameRenderer = (AnimatedDrawableBackendFrameRenderer) this.mBitmapFrameRenderer;
        AnimatedDrawableBackend forNewBounds = animatedDrawableBackendFrameRenderer.mAnimatedDrawableBackend.forNewBounds(rect);
        if (forNewBounds != animatedDrawableBackendFrameRenderer.mAnimatedDrawableBackend) {
            animatedDrawableBackendFrameRenderer.mAnimatedDrawableBackend = forNewBounds;
            animatedDrawableBackendFrameRenderer.mAnimatedImageCompositor = new AnimatedImageCompositor(forNewBounds, animatedDrawableBackendFrameRenderer.mCallback);
        }
        updateBitmapDimensions();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public final void updateBitmapDimensions() {
        int width = ((AnimatedDrawableBackendFrameRenderer) this.mBitmapFrameRenderer).mAnimatedDrawableBackend.getWidth();
        this.mBitmapWidth = width;
        int i = -1;
        if (width == -1) {
            Rect rect = this.mBounds;
            this.mBitmapWidth = rect == null ? -1 : rect.width();
        }
        int height = ((AnimatedDrawableBackendFrameRenderer) this.mBitmapFrameRenderer).mAnimatedDrawableBackend.getHeight();
        this.mBitmapHeight = height;
        if (height == -1) {
            Rect rect2 = this.mBounds;
            if (rect2 != null) {
                i = rect2.height();
            }
            this.mBitmapHeight = i;
        }
    }
}
