package com.facebook.animated.webp;

import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.BlendOperation;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;
import com.facebook.imagepipeline.animated.factory.AnimatedImageDecoder;
import com.facebook.imagepipeline.nativecode.StaticWebpNativeLoader;
import java.nio.ByteBuffer;

@DoNotStrip
public class WebPImage implements AnimatedImage, AnimatedImageDecoder {
    @DoNotStrip
    public long mNativeContext;

    @DoNotStrip
    public WebPImage() {
    }

    public static native WebPImage nativeCreateFromDirectByteBuffer(ByteBuffer byteBuffer);

    public static native WebPImage nativeCreateFromNativeMemory(long j, int i);

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetDuration();

    private native WebPFrame nativeGetFrame(int i);

    private native int nativeGetFrameCount();

    private native int[] nativeGetFrameDurations();

    private native int nativeGetHeight();

    private native int nativeGetLoopCount();

    private native int nativeGetSizeInBytes();

    private native int nativeGetWidth();

    public AnimatedImage decode(ByteBuffer byteBuffer) {
        StaticWebpNativeLoader.ensure();
        byteBuffer.rewind();
        return nativeCreateFromDirectByteBuffer(byteBuffer);
    }

    public void dispose() {
        nativeDispose();
    }

    public boolean doesRenderSupportScaling() {
        return true;
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
        WebPFrame nativeGetFrame = nativeGetFrame(i);
        try {
            AnimatedDrawableFrameInfo animatedDrawableFrameInfo = new AnimatedDrawableFrameInfo(i, nativeGetFrame.getXOffset(), nativeGetFrame.getYOffset(), nativeGetFrame.getWidth(), nativeGetFrame.getHeight(), nativeGetFrame.isBlendWithPreviousFrame() ? BlendOperation.BLEND_WITH_PREVIOUS : BlendOperation.NO_BLEND, nativeGetFrame.shouldDisposeToBackgroundColor() ? DisposalMethod.DISPOSE_TO_BACKGROUND : DisposalMethod.DISPOSE_DO_NOT);
            return animatedDrawableFrameInfo;
        } finally {
            nativeGetFrame.dispose();
        }
    }

    public int getHeight() {
        return nativeGetHeight();
    }

    public int getLoopCount() {
        return nativeGetLoopCount();
    }

    public int getSizeInBytes() {
        return nativeGetSizeInBytes();
    }

    public int getWidth() {
        return nativeGetWidth();
    }

    @DoNotStrip
    public WebPImage(long j) {
        this.mNativeContext = j;
    }

    public AnimatedImage decode(long j, int i) {
        StaticWebpNativeLoader.ensure();
        k.checkArgument(j != 0);
        return nativeCreateFromNativeMemory(j, i);
    }
}
