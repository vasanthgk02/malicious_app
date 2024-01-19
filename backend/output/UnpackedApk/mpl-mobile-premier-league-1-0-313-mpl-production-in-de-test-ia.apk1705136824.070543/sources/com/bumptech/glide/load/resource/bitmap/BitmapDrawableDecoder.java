package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import co.hyperverge.hypersnapsdk.c.k;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

public class BitmapDrawableDecoder<DataType> implements ResourceDecoder<DataType, BitmapDrawable> {
    public final ResourceDecoder<DataType, Bitmap> decoder;
    public final Resources resources;

    public BitmapDrawableDecoder(Resources resources2, ResourceDecoder<DataType, Bitmap> resourceDecoder) {
        k.checkNotNull(resources2, (String) "Argument must not be null");
        this.resources = resources2;
        k.checkNotNull(resourceDecoder, (String) "Argument must not be null");
        this.decoder = resourceDecoder;
    }

    public Resource<BitmapDrawable> decode(DataType datatype, int i, int i2, Options options) throws IOException {
        return LazyBitmapDrawableResource.obtain(this.resources, this.decoder.decode(datatype, i, i2, options));
    }

    public boolean handles(DataType datatype, Options options) throws IOException {
        return this.decoder.handles(datatype, options);
    }
}
