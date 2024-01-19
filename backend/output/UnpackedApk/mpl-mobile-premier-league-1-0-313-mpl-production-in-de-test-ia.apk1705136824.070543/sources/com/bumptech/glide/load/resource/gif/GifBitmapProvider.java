package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

public final class GifBitmapProvider implements BitmapProvider {
    public final ArrayPool arrayPool;
    public final BitmapPool bitmapPool;

    public GifBitmapProvider(BitmapPool bitmapPool2, ArrayPool arrayPool2) {
        this.bitmapPool = bitmapPool2;
        this.arrayPool = arrayPool2;
    }

    public byte[] obtainByteArray(int i) {
        ArrayPool arrayPool2 = this.arrayPool;
        if (arrayPool2 == null) {
            return new byte[i];
        }
        return (byte[]) arrayPool2.get(i, byte[].class);
    }
}
