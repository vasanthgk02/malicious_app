package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.memory.MemoryTrimType;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

public class DummyTrackingInUseBitmapPool implements BitmapPool {
    public final Set<Bitmap> mInUseValues = Collections.newSetFromMap(new IdentityHashMap());

    public void trim(MemoryTrimType memoryTrimType) {
    }

    public Bitmap get(int i) {
        Bitmap createBitmap = Bitmap.createBitmap(1, (int) Math.ceil(((double) i) / 2.0d), Config.RGB_565);
        this.mInUseValues.add(createBitmap);
        return createBitmap;
    }

    public void release(Bitmap bitmap) {
        if (bitmap != null) {
            this.mInUseValues.remove(bitmap);
            bitmap.recycle();
            return;
        }
        throw null;
    }
}
