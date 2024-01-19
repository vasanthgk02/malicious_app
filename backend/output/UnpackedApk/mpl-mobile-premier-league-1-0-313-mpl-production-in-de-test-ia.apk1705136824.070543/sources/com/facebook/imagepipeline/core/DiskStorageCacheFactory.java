package com.facebook.imagepipeline.core;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.cache.disk.DiskStorageCache.Params;
import com.facebook.cache.disk.FileCache;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DiskStorageCacheFactory implements FileCacheFactory {
    public DiskStorageFactory mDiskStorageFactory;

    public DiskStorageCacheFactory(DiskStorageFactory diskStorageFactory) {
        this.mDiskStorageFactory = diskStorageFactory;
    }

    public static DiskStorageCache buildDiskStorageCache(DiskCacheConfig diskCacheConfig, DiskStorage diskStorage) {
        return buildDiskStorageCache(diskCacheConfig, diskStorage, Executors.newSingleThreadExecutor());
    }

    public FileCache get(DiskCacheConfig diskCacheConfig) {
        return buildDiskStorageCache(diskCacheConfig, this.mDiskStorageFactory.get(diskCacheConfig));
    }

    public static DiskStorageCache buildDiskStorageCache(DiskCacheConfig diskCacheConfig, DiskStorage diskStorage, Executor executor) {
        Params params = new Params(diskCacheConfig.mMinimumSizeLimit, diskCacheConfig.mLowDiskSpaceSizeLimit, diskCacheConfig.mDefaultSizeLimit);
        DiskStorageCache diskStorageCache = new DiskStorageCache(diskStorage, diskCacheConfig.mEntryEvictionComparatorSupplier, params, diskCacheConfig.mCacheEventListener, diskCacheConfig.mCacheErrorLogger, diskCacheConfig.mDiskTrimmableRegistry, executor, diskCacheConfig.mIndexPopulateAtStartupEnabled);
        return diskStorageCache;
    }
}
