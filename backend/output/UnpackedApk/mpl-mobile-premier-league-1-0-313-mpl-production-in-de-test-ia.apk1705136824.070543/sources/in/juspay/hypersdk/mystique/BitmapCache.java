package in.juspay.hypersdk.mystique;

import android.graphics.Bitmap;
import android.util.LruCache;

public class BitmapCache {
    public static BitmapCache bitmapCache;
    public LruCache<String, Bitmap> bitmapStore;

    public BitmapCache() {
        initializeCache(50);
    }

    public static BitmapCache getInstance() {
        if (bitmapCache == null) {
            bitmapCache = new BitmapCache();
        }
        return bitmapCache;
    }

    public void clear() {
        this.bitmapStore.evictAll();
    }

    public Bitmap get(String str) {
        return this.bitmapStore.get(str);
    }

    public void getSize() {
        this.bitmapStore.size();
    }

    public void initializeCache(int i) {
        this.bitmapStore = new LruCache<>(i);
    }

    public void put(String str, Bitmap bitmap) {
        this.bitmapStore.put(str, bitmap);
    }
}
