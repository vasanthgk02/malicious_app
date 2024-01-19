package com.facebook.imagepipeline.bitmaps;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.core.CloseableReferenceFactory;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;

@TargetApi(21)
public class ArtBitmapFactory extends PlatformBitmapFactory {
    public final BitmapPool mBitmapPool;
    public final CloseableReferenceFactory mCloseableReferenceFactory;

    public ArtBitmapFactory(BitmapPool bitmapPool, CloseableReferenceFactory closeableReferenceFactory) {
        this.mBitmapPool = bitmapPool;
        this.mCloseableReferenceFactory = closeableReferenceFactory;
    }

    public CloseableReference<Bitmap> createBitmapInternal(int i, int i2, Config config) {
        Bitmap bitmap = (Bitmap) this.mBitmapPool.get(BitmapUtil.getSizeInByteForBitmap(i, i2, config));
        k.checkArgument(bitmap.getAllocationByteCount() >= BitmapUtil.getPixelSizeForBitmapConfig(config) * (i * i2));
        bitmap.reconfigure(i, i2, config);
        return this.mCloseableReferenceFactory.create(bitmap, this.mBitmapPool);
    }
}
