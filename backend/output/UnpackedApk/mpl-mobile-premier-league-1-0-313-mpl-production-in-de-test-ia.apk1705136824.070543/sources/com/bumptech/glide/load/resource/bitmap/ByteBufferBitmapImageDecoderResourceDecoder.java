package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ByteBufferBitmapImageDecoderResourceDecoder implements ResourceDecoder<ByteBuffer, Bitmap> {
    public final BitmapImageDecoderResourceDecoder wrapped = new BitmapImageDecoderResourceDecoder();

    public Resource decode(Object obj, int i, int i2, Options options) throws IOException {
        return this.wrapped.decode(ImageDecoder.createSource((ByteBuffer) obj), i, i2, options);
    }

    public boolean handles(Object obj, Options options) throws IOException {
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        return true;
    }
}
