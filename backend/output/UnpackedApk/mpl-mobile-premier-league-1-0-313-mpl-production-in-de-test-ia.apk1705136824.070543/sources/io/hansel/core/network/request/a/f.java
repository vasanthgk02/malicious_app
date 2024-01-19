package io.hansel.core.network.request.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import io.hansel.core.network.request.a.a.C0077a;

public class f implements C0077a {
    public Bitmap a(int i, int i2, Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }

    public byte[] a(int i) {
        return new byte[i];
    }

    public int[] b(int i) {
        return new int[i];
    }
}
