package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ByteBufferBitmapDecoder implements ResourceDecoder<ByteBuffer, Bitmap> {
    public final Downsampler downsampler;

    public ByteBufferBitmapDecoder(Downsampler downsampler2) {
        this.downsampler = downsampler2;
    }

    public Resource decode(Object obj, int i, int i2, Options options) throws IOException {
        return this.downsampler.decode(ByteBufferUtil.toStream((ByteBuffer) obj), i, i2, options, Downsampler.EMPTY_CALLBACKS);
    }

    public boolean handles(Object obj, Options options) throws IOException {
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        if (this.downsampler != null) {
            return true;
        }
        throw null;
    }
}
