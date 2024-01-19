package com.facebook.imagepipeline.transcoder;

import com.facebook.imageformat.ImageFormat;

public class SimpleImageTranscoderFactory implements ImageTranscoderFactory {
    public final int mMaxBitmapSize;

    public SimpleImageTranscoderFactory(int i) {
        this.mMaxBitmapSize = i;
    }

    public ImageTranscoder createImageTranscoder(ImageFormat imageFormat, boolean z) {
        return new SimpleImageTranscoder(z, this.mMaxBitmapSize);
    }
}