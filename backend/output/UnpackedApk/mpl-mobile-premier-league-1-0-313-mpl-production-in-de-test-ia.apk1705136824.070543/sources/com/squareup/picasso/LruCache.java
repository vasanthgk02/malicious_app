package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;

public final class LruCache implements Cache {
    public final android.util.LruCache<String, BitmapAndSize> cache;

    public static final class BitmapAndSize {
        public final Bitmap bitmap;
        public final int byteCount;

        public BitmapAndSize(Bitmap bitmap2, int i) {
            this.bitmap = bitmap2;
            this.byteCount = i;
        }
    }

    public LruCache(Context context) {
        this(Utils.calculateMemoryCacheSize(context));
    }

    public void clear() {
        this.cache.evictAll();
    }

    public void clearKeyUri(String str) {
        for (String next : this.cache.snapshot().keySet()) {
            if (next.startsWith(str) && next.length() > str.length() && next.charAt(str.length()) == 10) {
                this.cache.remove(next);
            }
        }
    }

    public int evictionCount() {
        return this.cache.evictionCount();
    }

    public Bitmap get(String str) {
        BitmapAndSize bitmapAndSize = this.cache.get(str);
        if (bitmapAndSize != null) {
            return bitmapAndSize.bitmap;
        }
        return null;
    }

    public int hitCount() {
        return this.cache.hitCount();
    }

    public int maxSize() {
        return this.cache.maxSize();
    }

    public int missCount() {
        return this.cache.missCount();
    }

    public int putCount() {
        return this.cache.putCount();
    }

    public void set(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || bitmap == null");
        }
        int bitmapBytes = Utils.getBitmapBytes(bitmap);
        if (bitmapBytes > maxSize()) {
            this.cache.remove(str);
        } else {
            this.cache.put(str, new BitmapAndSize(bitmap, bitmapBytes));
        }
    }

    public int size() {
        return this.cache.size();
    }

    public LruCache(int i) {
        this.cache = new android.util.LruCache<String, BitmapAndSize>(i) {
            public int sizeOf(String str, BitmapAndSize bitmapAndSize) {
                return bitmapAndSize.byteCount;
            }
        };
    }
}
