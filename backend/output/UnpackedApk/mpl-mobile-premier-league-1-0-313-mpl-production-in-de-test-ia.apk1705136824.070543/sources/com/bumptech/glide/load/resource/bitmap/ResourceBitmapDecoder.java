package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.dylanvann.fastimage.FastImageSource;
import java.io.IOException;

public class ResourceBitmapDecoder implements ResourceDecoder<Uri, Bitmap> {
    public final BitmapPool bitmapPool;
    public final ResourceDrawableDecoder drawableDecoder;

    public ResourceBitmapDecoder(ResourceDrawableDecoder resourceDrawableDecoder, BitmapPool bitmapPool2) {
        this.drawableDecoder = resourceDrawableDecoder;
        this.bitmapPool = bitmapPool2;
    }

    public Resource decode(Object obj, int i, int i2, Options options) throws IOException {
        Resource decode = this.drawableDecoder.decode((Uri) obj);
        if (decode == null) {
            return null;
        }
        return DrawableToBitmapConverter.convert(this.bitmapPool, (Drawable) decode.get(), i, i2);
    }

    public boolean handles(Object obj, Options options) throws IOException {
        return FastImageSource.ANDROID_RESOURCE_SCHEME.equals(((Uri) obj).getScheme());
    }
}
