package com.freshchat.consumer.sdk.j.a;

import android.graphics.Bitmap;
import androidx.collection.LruCache;

public class g extends LruCache<String, Bitmap> {
    public final /* synthetic */ d rV;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public g(d dVar, int i) {
        // this.rV = dVar;
        super(i);
    }

    /* renamed from: b */
    public int sizeOf(String str, Bitmap bitmap) {
        return d.b(bitmap);
    }
}
