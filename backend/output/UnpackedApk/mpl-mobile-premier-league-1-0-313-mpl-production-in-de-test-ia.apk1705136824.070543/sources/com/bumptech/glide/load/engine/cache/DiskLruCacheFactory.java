package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.engine.cache.DiskCache.Factory;

public class DiskLruCacheFactory implements Factory {
    public final CacheDirectoryGetter cacheDirectoryGetter;
    public final long diskCacheSize;

    public interface CacheDirectoryGetter {
    }

    public DiskLruCacheFactory(CacheDirectoryGetter cacheDirectoryGetter2, long j) {
        this.diskCacheSize = j;
        this.cacheDirectoryGetter = cacheDirectoryGetter2;
    }
}
