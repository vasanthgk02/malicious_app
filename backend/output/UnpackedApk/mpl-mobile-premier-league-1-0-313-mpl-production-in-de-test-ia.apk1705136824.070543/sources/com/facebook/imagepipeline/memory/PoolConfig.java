package com.facebook.imagepipeline.memory;

import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import com.facebook.imagepipeline.systrace.FrescoSystrace;

public class PoolConfig {
    public static final int BITMAP_POOL_MAX_BITMAP_SIZE_DEFAULT = 4194304;
    public final int mBitmapPoolMaxBitmapSize;
    public final int mBitmapPoolMaxPoolSize;
    public final PoolParams mBitmapPoolParams;
    public final PoolStatsTracker mBitmapPoolStatsTracker;
    public final String mBitmapPoolType;
    public final PoolParams mFlexByteArrayPoolParams;
    public final boolean mIgnoreBitmapPoolHardCap;
    public final PoolParams mMemoryChunkPoolParams;
    public final PoolStatsTracker mMemoryChunkPoolStatsTracker;
    public final MemoryTrimmableRegistry mMemoryTrimmableRegistry;
    public final boolean mRegisterLruBitmapPoolAsMemoryTrimmable;
    public final PoolParams mSmallByteArrayPoolParams;
    public final PoolStatsTracker mSmallByteArrayPoolStatsTracker;

    public static class Builder {
        public int mBitmapPoolMaxBitmapSize;
        public int mBitmapPoolMaxPoolSize;
        public PoolParams mBitmapPoolParams;
        public PoolStatsTracker mBitmapPoolStatsTracker;
        public String mBitmapPoolType;
        public PoolParams mFlexByteArrayPoolParams;
        public boolean mIgnoreBitmapPoolHardCap;
        public PoolParams mMemoryChunkPoolParams;
        public PoolStatsTracker mMemoryChunkPoolStatsTracker;
        public MemoryTrimmableRegistry mMemoryTrimmableRegistry;
        public boolean mRegisterLruBitmapPoolAsMemoryTrimmable;
        public PoolParams mSmallByteArrayPoolParams;
        public PoolStatsTracker mSmallByteArrayPoolStatsTracker;

        public PoolConfig build() {
            return new PoolConfig(this);
        }

        public Builder setBitmapPoolMaxBitmapSize(int i) {
            this.mBitmapPoolMaxBitmapSize = i;
            return this;
        }

        public Builder setBitmapPoolMaxPoolSize(int i) {
            this.mBitmapPoolMaxPoolSize = i;
            return this;
        }

        public Builder setBitmapPoolParams(PoolParams poolParams) {
            if (poolParams != null) {
                this.mBitmapPoolParams = poolParams;
                return this;
            }
            throw null;
        }

        public Builder setBitmapPoolStatsTracker(PoolStatsTracker poolStatsTracker) {
            if (poolStatsTracker != null) {
                this.mBitmapPoolStatsTracker = poolStatsTracker;
                return this;
            }
            throw null;
        }

        public Builder setBitmapPoolType(String str) {
            this.mBitmapPoolType = str;
            return this;
        }

        public Builder setFlexByteArrayPoolParams(PoolParams poolParams) {
            this.mFlexByteArrayPoolParams = poolParams;
            return this;
        }

        public Builder setIgnoreBitmapPoolHardCap(boolean z) {
            this.mIgnoreBitmapPoolHardCap = z;
            return this;
        }

        public Builder setMemoryTrimmableRegistry(MemoryTrimmableRegistry memoryTrimmableRegistry) {
            this.mMemoryTrimmableRegistry = memoryTrimmableRegistry;
            return this;
        }

        public Builder setNativeMemoryChunkPoolParams(PoolParams poolParams) {
            if (poolParams != null) {
                this.mMemoryChunkPoolParams = poolParams;
                return this;
            }
            throw null;
        }

        public Builder setNativeMemoryChunkPoolStatsTracker(PoolStatsTracker poolStatsTracker) {
            if (poolStatsTracker != null) {
                this.mMemoryChunkPoolStatsTracker = poolStatsTracker;
                return this;
            }
            throw null;
        }

        public Builder setRegisterLruBitmapPoolAsMemoryTrimmable(boolean z) {
            this.mRegisterLruBitmapPoolAsMemoryTrimmable = z;
            return this;
        }

        public Builder setSmallByteArrayPoolParams(PoolParams poolParams) {
            if (poolParams != null) {
                this.mSmallByteArrayPoolParams = poolParams;
                return this;
            }
            throw null;
        }

        public Builder setSmallByteArrayPoolStatsTracker(PoolStatsTracker poolStatsTracker) {
            if (poolStatsTracker != null) {
                this.mSmallByteArrayPoolStatsTracker = poolStatsTracker;
                return this;
            }
            throw null;
        }

        public Builder() {
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public int getBitmapPoolMaxBitmapSize() {
        return this.mBitmapPoolMaxBitmapSize;
    }

    public int getBitmapPoolMaxPoolSize() {
        return this.mBitmapPoolMaxPoolSize;
    }

    public PoolParams getBitmapPoolParams() {
        return this.mBitmapPoolParams;
    }

    public PoolStatsTracker getBitmapPoolStatsTracker() {
        return this.mBitmapPoolStatsTracker;
    }

    public String getBitmapPoolType() {
        return this.mBitmapPoolType;
    }

    public PoolParams getFlexByteArrayPoolParams() {
        return this.mFlexByteArrayPoolParams;
    }

    public PoolParams getMemoryChunkPoolParams() {
        return this.mMemoryChunkPoolParams;
    }

    public PoolStatsTracker getMemoryChunkPoolStatsTracker() {
        return this.mMemoryChunkPoolStatsTracker;
    }

    public MemoryTrimmableRegistry getMemoryTrimmableRegistry() {
        return this.mMemoryTrimmableRegistry;
    }

    public PoolParams getSmallByteArrayPoolParams() {
        return this.mSmallByteArrayPoolParams;
    }

    public PoolStatsTracker getSmallByteArrayPoolStatsTracker() {
        return this.mSmallByteArrayPoolStatsTracker;
    }

    public boolean isIgnoreBitmapPoolHardCap() {
        return this.mIgnoreBitmapPoolHardCap;
    }

    public boolean isRegisterLruBitmapPoolAsMemoryTrimmable() {
        return this.mRegisterLruBitmapPoolAsMemoryTrimmable;
    }

    public PoolConfig(Builder builder) {
        PoolParams poolParams;
        PoolStatsTracker poolStatsTracker;
        PoolParams poolParams2;
        MemoryTrimmableRegistry memoryTrimmableRegistry;
        PoolParams poolParams3;
        PoolStatsTracker poolStatsTracker2;
        PoolParams poolParams4;
        PoolStatsTracker poolStatsTracker3;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("PoolConfig()");
        }
        if (builder.mBitmapPoolParams == null) {
            poolParams = DefaultBitmapPoolParams.get();
        } else {
            poolParams = builder.mBitmapPoolParams;
        }
        this.mBitmapPoolParams = poolParams;
        if (builder.mBitmapPoolStatsTracker == null) {
            poolStatsTracker = NoOpPoolStatsTracker.getInstance();
        } else {
            poolStatsTracker = builder.mBitmapPoolStatsTracker;
        }
        this.mBitmapPoolStatsTracker = poolStatsTracker;
        if (builder.mFlexByteArrayPoolParams == null) {
            poolParams2 = DefaultFlexByteArrayPoolParams.get();
        } else {
            poolParams2 = builder.mFlexByteArrayPoolParams;
        }
        this.mFlexByteArrayPoolParams = poolParams2;
        if (builder.mMemoryTrimmableRegistry == null) {
            memoryTrimmableRegistry = NoOpMemoryTrimmableRegistry.getInstance();
        } else {
            memoryTrimmableRegistry = builder.mMemoryTrimmableRegistry;
        }
        this.mMemoryTrimmableRegistry = memoryTrimmableRegistry;
        if (builder.mMemoryChunkPoolParams == null) {
            poolParams3 = DefaultNativeMemoryChunkPoolParams.get();
        } else {
            poolParams3 = builder.mMemoryChunkPoolParams;
        }
        this.mMemoryChunkPoolParams = poolParams3;
        if (builder.mMemoryChunkPoolStatsTracker == null) {
            poolStatsTracker2 = NoOpPoolStatsTracker.getInstance();
        } else {
            poolStatsTracker2 = builder.mMemoryChunkPoolStatsTracker;
        }
        this.mMemoryChunkPoolStatsTracker = poolStatsTracker2;
        if (builder.mSmallByteArrayPoolParams == null) {
            poolParams4 = DefaultByteArrayPoolParams.get();
        } else {
            poolParams4 = builder.mSmallByteArrayPoolParams;
        }
        this.mSmallByteArrayPoolParams = poolParams4;
        if (builder.mSmallByteArrayPoolStatsTracker == null) {
            poolStatsTracker3 = NoOpPoolStatsTracker.getInstance();
        } else {
            poolStatsTracker3 = builder.mSmallByteArrayPoolStatsTracker;
        }
        this.mSmallByteArrayPoolStatsTracker = poolStatsTracker3;
        this.mBitmapPoolType = builder.mBitmapPoolType == null ? "legacy" : builder.mBitmapPoolType;
        this.mBitmapPoolMaxPoolSize = builder.mBitmapPoolMaxPoolSize;
        this.mBitmapPoolMaxBitmapSize = builder.mBitmapPoolMaxBitmapSize > 0 ? builder.mBitmapPoolMaxBitmapSize : 4194304;
        this.mRegisterLruBitmapPoolAsMemoryTrimmable = builder.mRegisterLruBitmapPoolAsMemoryTrimmable;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        this.mIgnoreBitmapPoolHardCap = builder.mIgnoreBitmapPoolHardCap;
    }
}