package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import co.hyperverge.hypersnapsdk.c.k;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public final class RoundedCorners extends BitmapTransformation {
    public static final byte[] ID_BYTES = "com.bumptech.glide.load.resource.bitmap.RoundedCorners".getBytes(Key.CHARSET);
    public final int roundingRadius;

    public RoundedCorners(int i) {
        k.checkArgument(i > 0, (String) "roundingRadius must be greater than 0.");
        this.roundingRadius = i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RoundedCorners) || this.roundingRadius != ((RoundedCorners) obj).roundingRadius) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (Util.hashCode(this.roundingRadius) * 31) - 569625254;
    }

    public Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        return TransformationUtils.roundedCorners(bitmapPool, bitmap, this.roundingRadius);
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.roundingRadius).array());
    }
}
