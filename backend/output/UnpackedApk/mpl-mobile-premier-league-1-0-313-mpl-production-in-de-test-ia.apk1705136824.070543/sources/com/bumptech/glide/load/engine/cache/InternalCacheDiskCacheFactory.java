package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter;

public final class InternalCacheDiskCacheFactory extends DiskLruCacheFactory {
    public InternalCacheDiskCacheFactory(final Context context) {
        super(new CacheDirectoryGetter(Glide.DEFAULT_DISK_CACHE_DIR) {
        }, 262144000);
    }
}
