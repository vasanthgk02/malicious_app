package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

public interface GifDecoder {

    public interface BitmapProvider {
    }

    void advance();

    void clear();

    int getByteSize();

    int getCurrentFrameIndex();

    ByteBuffer getData();

    int getFrameCount();

    int getNextDelay();

    Bitmap getNextFrame();

    void resetFrameIndex();
}
