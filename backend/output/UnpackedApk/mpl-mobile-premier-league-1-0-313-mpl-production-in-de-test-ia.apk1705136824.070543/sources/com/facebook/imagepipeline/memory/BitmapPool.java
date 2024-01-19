package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.Pool;

public interface BitmapPool extends Pool<Bitmap> {
    /* synthetic */ V get(int i);

    /* synthetic */ void release(V v);

    /* synthetic */ void trim(MemoryTrimType memoryTrimType);
}
