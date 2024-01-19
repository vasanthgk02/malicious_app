package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import co.hyperverge.hypersnapsdk.c.k;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;

public class BitmapResource implements Resource<Bitmap>, Initializable {
    public final Bitmap bitmap;
    public final BitmapPool bitmapPool;

    public BitmapResource(Bitmap bitmap2, BitmapPool bitmapPool2) {
        k.checkNotNull(bitmap2, (String) "Bitmap must not be null");
        this.bitmap = bitmap2;
        k.checkNotNull(bitmapPool2, (String) "BitmapPool must not be null");
        this.bitmapPool = bitmapPool2;
    }

    public static BitmapResource obtain(Bitmap bitmap2, BitmapPool bitmapPool2) {
        if (bitmap2 == null) {
            return null;
        }
        return new BitmapResource(bitmap2, bitmapPool2);
    }

    public Object get() {
        return this.bitmap;
    }

    public Class<Bitmap> getResourceClass() {
        return Bitmap.class;
    }

    public int getSize() {
        return Util.getBitmapByteSize(this.bitmap);
    }

    public void initialize() {
        this.bitmap.prepareToDraw();
    }

    public void recycle() {
        this.bitmapPool.put(this.bitmap);
    }
}
