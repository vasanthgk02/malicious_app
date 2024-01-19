package com.facebook.imagepipeline.core;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.cache.disk.DynamicDefaultDiskStorage;

public class DynamicDefaultDiskStorageFactory implements DiskStorageFactory {
    public DiskStorage get(DiskCacheConfig diskCacheConfig) {
        return new DynamicDefaultDiskStorage(diskCacheConfig.mVersion, diskCacheConfig.mBaseDirectoryPathSupplier, diskCacheConfig.mBaseDirectoryName, diskCacheConfig.mCacheErrorLogger);
    }
}
