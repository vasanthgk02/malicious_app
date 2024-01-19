package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;

public abstract class BitmapTransformation implements Transformation<Bitmap> {
    public abstract Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2);

    public final Resource<Bitmap> transform(Context context, Resource<Bitmap> resource, int i, int i2) {
        if (Util.isValidDimensions(i, i2)) {
            BitmapPool bitmapPool = Glide.get(context).getBitmapPool();
            Bitmap bitmap = (Bitmap) resource.get();
            if (i == Integer.MIN_VALUE) {
                i = bitmap.getWidth();
            }
            if (i2 == Integer.MIN_VALUE) {
                i2 = bitmap.getHeight();
            }
            Bitmap transform = transform(bitmapPool, bitmap, i, i2);
            return bitmap.equals(transform) ? resource : BitmapResource.obtain(transform, bitmapPool);
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline44("Cannot apply transformation on width: ", i, " or height: ", i2, " less than or equal to zero and not Target.SIZE_ORIGINAL"));
    }
}
