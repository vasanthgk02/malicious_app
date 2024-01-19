package com.facebook.fresco.animation.bitmap.preparation;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.SparseArray;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.fresco.animation.bitmap.BitmapFrameRenderer;
import com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendFrameRenderer;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.concurrent.ExecutorService;

public class DefaultBitmapFramePreparer implements BitmapFramePreparer {
    public static final Class<?> TAG = DefaultBitmapFramePreparer.class;
    public final Config mBitmapConfig;
    public final BitmapFrameRenderer mBitmapFrameRenderer;
    public final ExecutorService mExecutorService;
    public final SparseArray<Runnable> mPendingFrameDecodeJobs = new SparseArray<>();
    public final PlatformBitmapFactory mPlatformBitmapFactory;

    public class FrameDecodeRunnable implements Runnable {
        public final AnimationBackend mAnimationBackend;
        public final BitmapFrameCache mBitmapFrameCache;
        public final int mFrameNumber;
        public final int mHashCode;

        public FrameDecodeRunnable(AnimationBackend animationBackend, BitmapFrameCache bitmapFrameCache, int i, int i2) {
            this.mAnimationBackend = animationBackend;
            this.mBitmapFrameCache = bitmapFrameCache;
            this.mFrameNumber = i;
            this.mHashCode = i2;
        }

        public final boolean prepareFrameAndCache(int i, int i2) {
            CloseableReference closeableReference;
            int i3 = 2;
            if (i2 == 1) {
                closeableReference = this.mBitmapFrameCache.getBitmapToReuseForFrame(i, this.mAnimationBackend.getIntrinsicWidth(), this.mAnimationBackend.getIntrinsicHeight());
            } else if (i2 != 2) {
                CloseableReference.closeSafely((CloseableReference<?>) null);
                return false;
            } else {
                try {
                    closeableReference = DefaultBitmapFramePreparer.this.mPlatformBitmapFactory.createBitmap(this.mAnimationBackend.getIntrinsicWidth(), this.mAnimationBackend.getIntrinsicHeight(), DefaultBitmapFramePreparer.this.mBitmapConfig);
                    i3 = -1;
                } catch (RuntimeException e2) {
                    FLog.w(DefaultBitmapFramePreparer.TAG, (String) "Failed to create frame bitmap", (Throwable) e2);
                    CloseableReference.closeSafely((CloseableReference<?>) null);
                    return false;
                } catch (Throwable th) {
                    CloseableReference.closeSafely((CloseableReference<?>) null);
                    throw th;
                }
            }
            boolean renderFrameAndCache = renderFrameAndCache(i, closeableReference, i2);
            if (closeableReference != null) {
                closeableReference.close();
            }
            return (renderFrameAndCache || i3 == -1) ? renderFrameAndCache : prepareFrameAndCache(i, i3);
        }

        public final boolean renderFrameAndCache(int i, CloseableReference<Bitmap> closeableReference, int i2) {
            if (!CloseableReference.isValid(closeableReference)) {
                return false;
            }
            if (!((AnimatedDrawableBackendFrameRenderer) DefaultBitmapFramePreparer.this.mBitmapFrameRenderer).renderFrame(i, (Bitmap) closeableReference.get())) {
                return false;
            }
            FLog.v(DefaultBitmapFramePreparer.TAG, (String) "Frame %d ready.", (Object) Integer.valueOf(this.mFrameNumber));
            synchronized (DefaultBitmapFramePreparer.this.mPendingFrameDecodeJobs) {
                this.mBitmapFrameCache.onFramePrepared(this.mFrameNumber, closeableReference, i2);
            }
            return true;
        }

        public void run() {
            try {
                if (this.mBitmapFrameCache.contains(this.mFrameNumber)) {
                    FLog.v(DefaultBitmapFramePreparer.TAG, (String) "Frame %d is cached already.", (Object) Integer.valueOf(this.mFrameNumber));
                    synchronized (DefaultBitmapFramePreparer.this.mPendingFrameDecodeJobs) {
                        DefaultBitmapFramePreparer.this.mPendingFrameDecodeJobs.remove(this.mHashCode);
                    }
                    return;
                }
                if (prepareFrameAndCache(this.mFrameNumber, 1)) {
                    FLog.v(DefaultBitmapFramePreparer.TAG, (String) "Prepared frame frame %d.", (Object) Integer.valueOf(this.mFrameNumber));
                } else {
                    FLog.e(DefaultBitmapFramePreparer.TAG, (String) "Could not prepare frame %d.", Integer.valueOf(this.mFrameNumber));
                }
                synchronized (DefaultBitmapFramePreparer.this.mPendingFrameDecodeJobs) {
                    DefaultBitmapFramePreparer.this.mPendingFrameDecodeJobs.remove(this.mHashCode);
                }
            } catch (Throwable th) {
                synchronized (DefaultBitmapFramePreparer.this.mPendingFrameDecodeJobs) {
                    DefaultBitmapFramePreparer.this.mPendingFrameDecodeJobs.remove(this.mHashCode);
                    throw th;
                }
            }
        }
    }

    public DefaultBitmapFramePreparer(PlatformBitmapFactory platformBitmapFactory, BitmapFrameRenderer bitmapFrameRenderer, Config config, ExecutorService executorService) {
        this.mPlatformBitmapFactory = platformBitmapFactory;
        this.mBitmapFrameRenderer = bitmapFrameRenderer;
        this.mBitmapConfig = config;
        this.mExecutorService = executorService;
    }
}
