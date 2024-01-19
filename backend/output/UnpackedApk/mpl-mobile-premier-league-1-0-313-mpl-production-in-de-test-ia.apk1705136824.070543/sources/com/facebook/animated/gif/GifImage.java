package com.facebook.animated.gif;

import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.BlendOperation;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;
import com.facebook.imagepipeline.animated.factory.AnimatedImageDecoder;
import com.facebook.soloader.SoLoader;
import java.nio.ByteBuffer;

@DoNotStrip
public class GifImage implements AnimatedImage, AnimatedImageDecoder {
    public static volatile boolean sInitialized;
    @DoNotStrip
    public long mNativeContext;

    @DoNotStrip
    public GifImage() {
    }

    public static synchronized void ensure() {
        synchronized (GifImage.class) {
            if (!sInitialized) {
                sInitialized = true;
                SoLoader.loadLibrary("gifimage");
            }
        }
    }

    @DoNotStrip
    public static native GifImage nativeCreateFromDirectByteBuffer(ByteBuffer byteBuffer);

    @DoNotStrip
    public static native GifImage nativeCreateFromNativeMemory(long j, int i);

    @DoNotStrip
    private native void nativeDispose();

    @DoNotStrip
    private native void nativeFinalize();

    @DoNotStrip
    private native int nativeGetDuration();

    @DoNotStrip
    private native GifFrame nativeGetFrame(int i);

    @DoNotStrip
    private native int nativeGetFrameCount();

    @DoNotStrip
    private native int[] nativeGetFrameDurations();

    @DoNotStrip
    private native int nativeGetHeight();

    @DoNotStrip
    private native int nativeGetLoopCount();

    @DoNotStrip
    private native int nativeGetSizeInBytes();

    @DoNotStrip
    private native int nativeGetWidth();

    public AnimatedImage decode(ByteBuffer byteBuffer) {
        ensure();
        byteBuffer.rewind();
        return nativeCreateFromDirectByteBuffer(byteBuffer);
    }

    public void dispose() {
        nativeDispose();
    }

    public boolean doesRenderSupportScaling() {
        return false;
    }

    public void finalize() {
        nativeFinalize();
    }

    public int getDuration() {
        return nativeGetDuration();
    }

    public AnimatedImageFrame getFrame(int i) {
        return nativeGetFrame(i);
    }

    public int getFrameCount() {
        return nativeGetFrameCount();
    }

    public int[] getFrameDurations() {
        return nativeGetFrameDurations();
    }

    public AnimatedDrawableFrameInfo getFrameInfo(int i) {
        DisposalMethod disposalMethod;
        GifFrame nativeGetFrame = nativeGetFrame(i);
        try {
            int xOffset = nativeGetFrame.getXOffset();
            int yOffset = nativeGetFrame.getYOffset();
            int width = nativeGetFrame.getWidth();
            int height = nativeGetFrame.getHeight();
            BlendOperation blendOperation = BlendOperation.BLEND_WITH_PREVIOUS;
            int disposalMode = nativeGetFrame.getDisposalMode();
            if (disposalMode == 0) {
                disposalMethod = DisposalMethod.DISPOSE_DO_NOT;
            } else if (disposalMode == 1) {
                disposalMethod = DisposalMethod.DISPOSE_DO_NOT;
            } else if (disposalMode == 2) {
                disposalMethod = DisposalMethod.DISPOSE_TO_BACKGROUND;
            } else if (disposalMode == 3) {
                disposalMethod = DisposalMethod.DISPOSE_TO_PREVIOUS;
            } else {
                disposalMethod = DisposalMethod.DISPOSE_DO_NOT;
            }
            AnimatedDrawableFrameInfo animatedDrawableFrameInfo = new AnimatedDrawableFrameInfo(i, xOffset, yOffset, width, height, blendOperation, disposalMethod);
            return animatedDrawableFrameInfo;
        } finally {
            nativeGetFrame.dispose();
        }
    }

    public int getHeight() {
        return nativeGetHeight();
    }

    public int getLoopCount() {
        int nativeGetLoopCount = nativeGetLoopCount();
        if (nativeGetLoopCount == -1) {
            return 1;
        }
        if (nativeGetLoopCount != 0) {
            return nativeGetLoopCount + 1;
        }
        return 0;
    }

    public int getSizeInBytes() {
        return nativeGetSizeInBytes();
    }

    public int getWidth() {
        return nativeGetWidth();
    }

    @DoNotStrip
    public GifImage(long j) {
        this.mNativeContext = j;
    }

    public AnimatedImage decode(long j, int i) {
        ensure();
        k.checkArgument(j != 0);
        return nativeCreateFromNativeMemory(j, i);
    }
}
