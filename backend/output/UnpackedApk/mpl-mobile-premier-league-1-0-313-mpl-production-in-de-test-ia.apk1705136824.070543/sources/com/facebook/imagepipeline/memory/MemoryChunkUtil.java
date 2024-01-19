package com.facebook.imagepipeline.memory;

import co.hyperverge.hypersnapsdk.c.k;

public class MemoryChunkUtil {
    public static int adjustByteCount(int i, int i2, int i3) {
        return Math.min(Math.max(0, i3 - i), i2);
    }

    public static void checkBounds(int i, int i2, int i3, int i4, int i5) {
        boolean z = true;
        k.checkArgument(i4 >= 0);
        k.checkArgument(i >= 0);
        k.checkArgument(i3 >= 0);
        k.checkArgument(i + i4 <= i5);
        if (i3 + i4 > i2) {
            z = false;
        }
        k.checkArgument(z);
    }
}
