package com.facebook.cache.disk;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.NoOpCacheErrorLogger;
import com.facebook.cache.common.NoOpCacheEventListener;
import com.facebook.common.disk.DiskTrimmableRegistry;
import com.facebook.common.disk.NoOpDiskTrimmableRegistry;
import com.facebook.common.internal.Supplier;
import java.io.File;

public class DiskCacheConfig {
    public final String mBaseDirectoryName;
    public final Supplier<File> mBaseDirectoryPathSupplier;
    public final CacheErrorLogger mCacheErrorLogger;
    public final CacheEventListener mCacheEventListener;
    public final Context mContext;
    public final long mDefaultSizeLimit;
    public final DiskTrimmableRegistry mDiskTrimmableRegistry;
    public final EntryEvictionComparatorSupplier mEntryEvictionComparatorSupplier;
    public final boolean mIndexPopulateAtStartupEnabled;
    public final long mLowDiskSpaceSizeLimit;
    public final long mMinimumSizeLimit;
    public final int mVersion;

    public static class Builder {
        public String mBaseDirectoryName = "image_cache";
        public Supplier<File> mBaseDirectoryPathSupplier;
        public final Context mContext;
        public EntryEvictionComparatorSupplier mEntryEvictionComparatorSupplier = new DefaultEntryEvictionComparatorSupplier();
        public long mMaxCacheSize = 41943040;
        public long mMaxCacheSizeOnLowDiskSpace = 10485760;
        public long mMaxCacheSizeOnVeryLowDiskSpace = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
        public int mVersion = 1;

        public Builder(Context context, AnonymousClass1 r4) {
            this.mContext = context;
        }
    }

    public DiskCacheConfig(Builder builder, AnonymousClass1 r4) {
        NoOpCacheErrorLogger noOpCacheErrorLogger;
        NoOpCacheEventListener noOpCacheEventListener;
        NoOpDiskTrimmableRegistry noOpDiskTrimmableRegistry;
        this.mVersion = builder.mVersion;
        String str = builder.mBaseDirectoryName;
        k.checkNotNull1(str);
        this.mBaseDirectoryName = str;
        Supplier<File> supplier = builder.mBaseDirectoryPathSupplier;
        k.checkNotNull1(supplier);
        this.mBaseDirectoryPathSupplier = supplier;
        this.mDefaultSizeLimit = builder.mMaxCacheSize;
        this.mLowDiskSpaceSizeLimit = builder.mMaxCacheSizeOnLowDiskSpace;
        this.mMinimumSizeLimit = builder.mMaxCacheSizeOnVeryLowDiskSpace;
        EntryEvictionComparatorSupplier entryEvictionComparatorSupplier = builder.mEntryEvictionComparatorSupplier;
        k.checkNotNull1(entryEvictionComparatorSupplier);
        this.mEntryEvictionComparatorSupplier = entryEvictionComparatorSupplier;
        synchronized (NoOpCacheErrorLogger.class) {
            if (NoOpCacheErrorLogger.sInstance == null) {
                NoOpCacheErrorLogger.sInstance = new NoOpCacheErrorLogger();
            }
            noOpCacheErrorLogger = NoOpCacheErrorLogger.sInstance;
        }
        this.mCacheErrorLogger = noOpCacheErrorLogger;
        synchronized (NoOpCacheEventListener.class) {
            if (NoOpCacheEventListener.sInstance == null) {
                NoOpCacheEventListener.sInstance = new NoOpCacheEventListener();
            }
            noOpCacheEventListener = NoOpCacheEventListener.sInstance;
        }
        this.mCacheEventListener = noOpCacheEventListener;
        synchronized (NoOpDiskTrimmableRegistry.class) {
            if (NoOpDiskTrimmableRegistry.sInstance == null) {
                NoOpDiskTrimmableRegistry.sInstance = new NoOpDiskTrimmableRegistry();
            }
            noOpDiskTrimmableRegistry = NoOpDiskTrimmableRegistry.sInstance;
        }
        this.mDiskTrimmableRegistry = noOpDiskTrimmableRegistry;
        this.mContext = builder.mContext;
        this.mIndexPopulateAtStartupEnabled = false;
    }
}
