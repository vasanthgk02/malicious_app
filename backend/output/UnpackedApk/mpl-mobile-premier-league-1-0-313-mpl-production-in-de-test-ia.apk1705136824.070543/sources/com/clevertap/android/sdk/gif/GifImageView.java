package com.clevertap.android.sdk.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;
import androidx.appcompat.widget.AppCompatImageView;

public class GifImageView extends AppCompatImageView implements Runnable {
    public boolean animating;
    public OnAnimationStart animationStartCallback = null;
    public OnAnimationStop animationStopCallback = null;
    public Thread animationThread;
    public final Runnable cleanupRunnable = new Runnable() {
        public void run() {
            GifImageView gifImageView = GifImageView.this;
            gifImageView.tmpBitmap = null;
            gifImageView.gifDecoder = null;
            gifImageView.animationThread = null;
            gifImageView.shouldClear = false;
        }
    };
    public OnFrameAvailable frameCallback = null;
    public long framesDisplayDuration = -1;
    public GifDecoder gifDecoder;
    public final Handler handler = new Handler(Looper.getMainLooper());
    public boolean renderFrame;
    public boolean shouldClear;
    public Bitmap tmpBitmap;
    public final Runnable updateResults = new Runnable() {
        public void run() {
            Bitmap bitmap = GifImageView.this.tmpBitmap;
            if (bitmap != null && !bitmap.isRecycled()) {
                GifImageView gifImageView = GifImageView.this;
                gifImageView.setImageBitmap(gifImageView.tmpBitmap);
                GifImageView.this.setScaleType(ScaleType.FIT_CENTER);
            }
        }
    };

    public interface OnAnimationStart {
        void onAnimationStart();
    }

    public interface OnAnimationStop {
        void onAnimationStop();
    }

    public interface OnFrameAvailable {
        Bitmap onFrameAvailable(Bitmap bitmap);
    }

    public GifImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void clear() {
        this.animating = false;
        this.renderFrame = false;
        this.shouldClear = true;
        this.animating = false;
        Thread thread = this.animationThread;
        if (thread != null) {
            thread.interrupt();
            this.animationThread = null;
        }
        this.handler.post(this.cleanupRunnable);
    }

    public int getFrameCount() {
        return this.gifDecoder.header.frameCount;
    }

    public long getFramesDisplayDuration() {
        return this.framesDisplayDuration;
    }

    public int getGifHeight() {
        return this.gifDecoder.header.height;
    }

    public int getGifWidth() {
        return this.gifDecoder.header.width;
    }

    public OnAnimationStop getOnAnimationStop() {
        return this.animationStopCallback;
    }

    public OnFrameAvailable getOnFrameAvailable() {
        return this.frameCallback;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clear();
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0050 A[Catch:{ ArrayIndexOutOfBoundsException | IllegalArgumentException -> 0x006b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r10 = this;
            com.clevertap.android.sdk.gif.GifImageView$OnAnimationStart r0 = r10.animationStartCallback
            if (r0 == 0) goto L_0x0007
            r0.onAnimationStart()
        L_0x0007:
            boolean r0 = r10.animating
            if (r0 != 0) goto L_0x0011
            boolean r0 = r10.renderFrame
            if (r0 != 0) goto L_0x0011
            goto L_0x00ad
        L_0x0011:
            com.clevertap.android.sdk.gif.GifDecoder r0 = r10.gifDecoder
            com.clevertap.android.sdk.gif.GifHeader r1 = r0.header
            int r1 = r1.frameCount
            r2 = -1
            r3 = 0
            if (r1 > 0) goto L_0x001d
        L_0x001b:
            r5 = 0
            goto L_0x003e
        L_0x001d:
            int r4 = r0.framePointer
            r5 = 1
            int r1 = r1 + -1
            if (r4 != r1) goto L_0x0029
            int r1 = r0.loopIndex
            int r1 = r1 + r5
            r0.loopIndex = r1
        L_0x0029:
            com.clevertap.android.sdk.gif.GifHeader r1 = r0.header
            int r1 = r1.loopCount
            if (r1 == r2) goto L_0x0034
            int r4 = r0.loopIndex
            if (r4 <= r1) goto L_0x0034
            goto L_0x001b
        L_0x0034:
            int r1 = r0.framePointer
            int r1 = r1 + r5
            com.clevertap.android.sdk.gif.GifHeader r4 = r0.header
            int r4 = r4.frameCount
            int r1 = r1 % r4
            r0.framePointer = r1
        L_0x003e:
            r0 = 0
            long r6 = java.lang.System.nanoTime()     // Catch:{ ArrayIndexOutOfBoundsException | IllegalArgumentException -> 0x006b }
            com.clevertap.android.sdk.gif.GifDecoder r4 = r10.gifDecoder     // Catch:{ ArrayIndexOutOfBoundsException | IllegalArgumentException -> 0x006b }
            android.graphics.Bitmap r4 = r4.getNextFrame()     // Catch:{ ArrayIndexOutOfBoundsException | IllegalArgumentException -> 0x006b }
            r10.tmpBitmap = r4     // Catch:{ ArrayIndexOutOfBoundsException | IllegalArgumentException -> 0x006b }
            com.clevertap.android.sdk.gif.GifImageView$OnFrameAvailable r8 = r10.frameCallback     // Catch:{ ArrayIndexOutOfBoundsException | IllegalArgumentException -> 0x006b }
            if (r8 == 0) goto L_0x0058
            com.clevertap.android.sdk.gif.GifImageView$OnFrameAvailable r8 = r10.frameCallback     // Catch:{ ArrayIndexOutOfBoundsException | IllegalArgumentException -> 0x006b }
            android.graphics.Bitmap r4 = r8.onFrameAvailable(r4)     // Catch:{ ArrayIndexOutOfBoundsException | IllegalArgumentException -> 0x006b }
            r10.tmpBitmap = r4     // Catch:{ ArrayIndexOutOfBoundsException | IllegalArgumentException -> 0x006b }
        L_0x0058:
            long r8 = java.lang.System.nanoTime()     // Catch:{ ArrayIndexOutOfBoundsException | IllegalArgumentException -> 0x006b }
            long r8 = r8 - r6
            r6 = 1000000(0xf4240, double:4.940656E-318)
            long r8 = r8 / r6
            android.os.Handler r4 = r10.handler     // Catch:{ ArrayIndexOutOfBoundsException | IllegalArgumentException -> 0x0069 }
            java.lang.Runnable r6 = r10.updateResults     // Catch:{ ArrayIndexOutOfBoundsException | IllegalArgumentException -> 0x0069 }
            r4.post(r6)     // Catch:{ ArrayIndexOutOfBoundsException | IllegalArgumentException -> 0x0069 }
            goto L_0x006c
        L_0x0069:
            goto L_0x006c
        L_0x006b:
            r8 = r0
        L_0x006c:
            r10.renderFrame = r3
            boolean r4 = r10.animating
            if (r4 == 0) goto L_0x00ab
            if (r5 != 0) goto L_0x0075
            goto L_0x00ab
        L_0x0075:
            com.clevertap.android.sdk.gif.GifDecoder r4 = r10.gifDecoder     // Catch:{ InterruptedException -> 0x0091 }
            com.clevertap.android.sdk.gif.GifHeader r5 = r4.header     // Catch:{ InterruptedException -> 0x0091 }
            int r6 = r5.frameCount     // Catch:{ InterruptedException -> 0x0091 }
            if (r6 <= 0) goto L_0x0094
            int r4 = r4.framePointer     // Catch:{ InterruptedException -> 0x0091 }
            if (r4 >= 0) goto L_0x0082
            goto L_0x0094
        L_0x0082:
            if (r4 < 0) goto L_0x0093
            if (r4 >= r6) goto L_0x0093
            java.util.List<com.clevertap.android.sdk.gif.GifFrame> r2 = r5.frames     // Catch:{ InterruptedException -> 0x0091 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ InterruptedException -> 0x0091 }
            com.clevertap.android.sdk.gif.GifFrame r2 = (com.clevertap.android.sdk.gif.GifFrame) r2     // Catch:{ InterruptedException -> 0x0091 }
            int r2 = r2.delay     // Catch:{ InterruptedException -> 0x0091 }
            goto L_0x0093
        L_0x0091:
            goto L_0x00a6
        L_0x0093:
            r3 = r2
        L_0x0094:
            long r2 = (long) r3     // Catch:{ InterruptedException -> 0x0091 }
            long r2 = r2 - r8
            int r3 = (int) r2     // Catch:{ InterruptedException -> 0x0091 }
            if (r3 <= 0) goto L_0x00a6
            long r4 = r10.framesDisplayDuration     // Catch:{ InterruptedException -> 0x0091 }
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x00a2
            long r0 = r10.framesDisplayDuration     // Catch:{ InterruptedException -> 0x0091 }
            goto L_0x00a3
        L_0x00a2:
            long r0 = (long) r3     // Catch:{ InterruptedException -> 0x0091 }
        L_0x00a3:
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0091 }
        L_0x00a6:
            boolean r0 = r10.animating
            if (r0 != 0) goto L_0x0007
            goto L_0x00ad
        L_0x00ab:
            r10.animating = r3
        L_0x00ad:
            boolean r0 = r10.shouldClear
            if (r0 == 0) goto L_0x00b8
            android.os.Handler r0 = r10.handler
            java.lang.Runnable r1 = r10.cleanupRunnable
            r0.post(r1)
        L_0x00b8:
            r0 = 0
            r10.animationThread = r0
            com.clevertap.android.sdk.gif.GifImageView$OnAnimationStop r0 = r10.animationStopCallback
            if (r0 == 0) goto L_0x00c2
            r0.onAnimationStop()
        L_0x00c2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.gif.GifImageView.run():void");
    }

    public void setBytes(byte[] bArr) {
        boolean z;
        GifDecoder gifDecoder2 = new GifDecoder();
        this.gifDecoder = gifDecoder2;
        try {
            gifDecoder2.read(bArr);
            if (this.animating) {
                startAnimationThread();
            } else {
                GifDecoder gifDecoder3 = this.gifDecoder;
                if (gifDecoder3.framePointer != 0) {
                    if (-1 >= gifDecoder3.header.frameCount) {
                        z = false;
                    } else {
                        gifDecoder3.framePointer = -1;
                        z = true;
                    }
                    if (z && !this.animating) {
                        this.renderFrame = true;
                        startAnimationThread();
                    }
                }
            }
        } catch (Exception unused) {
            this.gifDecoder = null;
        }
    }

    public void setFramesDisplayDuration(long j) {
        this.framesDisplayDuration = j;
    }

    public void setOnAnimationStart(OnAnimationStart onAnimationStart) {
        this.animationStartCallback = onAnimationStart;
    }

    public void setOnAnimationStop(OnAnimationStop onAnimationStop) {
        this.animationStopCallback = onAnimationStop;
    }

    public void setOnFrameAvailable(OnFrameAvailable onFrameAvailable) {
        this.frameCallback = onFrameAvailable;
    }

    public final void startAnimationThread() {
        if ((this.animating || this.renderFrame) && this.gifDecoder != null && this.animationThread == null) {
            Thread thread = new Thread(this);
            this.animationThread = thread;
            thread.start();
        }
    }
}
