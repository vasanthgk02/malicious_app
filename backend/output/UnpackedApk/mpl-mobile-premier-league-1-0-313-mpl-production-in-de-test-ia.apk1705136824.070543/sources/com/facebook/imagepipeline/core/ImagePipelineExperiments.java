package com.facebook.imagepipeline.core;

import android.content.Context;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers$1;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.common.webp.WebpBitmapFactory.WebpErrorLogger;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.CloseableImage;

public class ImagePipelineExperiments {
    public final int mBitmapCloseableRefType;
    public boolean mBitmapPrepareToDrawForPrefetch;
    public final int mBitmapPrepareToDrawMaxSizeBytes;
    public final int mBitmapPrepareToDrawMinSizeBytes;
    public final boolean mDecodeCancellationEnabled;
    public boolean mDownsampleIfLargeBitmap;
    public final boolean mDownscaleFrameToDrawableDimensions;
    public boolean mEncodedCacheEnabled;
    public final boolean mExperimentalThreadHandoffQueueEnabled;
    public final boolean mGingerbreadDecoderEnabled;
    public boolean mKeepCancelledFetchAsLowPriority;
    public final Supplier<Boolean> mLazyDataSource;
    public final int mMaxBitmapSize;
    public final long mMemoryType;
    public final boolean mNativeCodeDisabled;
    public final boolean mPartialImageCachingEnabled;
    public final ProducerFactoryMethod mProducerFactoryMethod;
    public final Supplier<Boolean> mSuppressBitmapPrefetchingSupplier;
    public final boolean mUseBitmapPrepareToDraw;
    public final boolean mUseDownsamplingRatioForResizing;
    public final WebpBitmapFactory mWebpBitmapFactory;
    public final WebpErrorLogger mWebpErrorLogger;
    public final boolean mWebpSupportEnabled;

    public static class Builder {
        public int mBitmapCloseableRefType;
        public boolean mBitmapPrepareToDrawForPrefetch = false;
        public int mBitmapPrepareToDrawMaxSizeBytes = 0;
        public int mBitmapPrepareToDrawMinSizeBytes = 0;
        public final com.facebook.imagepipeline.core.ImagePipelineConfig.Builder mConfigBuilder;
        public boolean mDecodeCancellationEnabled = false;
        public boolean mDownsampleIfLargeBitmap;
        public boolean mDownscaleFrameToDrawableDimensions;
        public boolean mEncodedCacheEnabled = true;
        public boolean mExperimentalThreadHandoffQueueEnabled;
        public boolean mGingerbreadDecoderEnabled;
        public boolean mKeepCancelledFetchAsLowPriority;
        public Supplier<Boolean> mLazyDataSource;
        public int mMaxBitmapSize = 2048;
        public long mMemoryType = 0;
        public boolean mNativeCodeDisabled = false;
        public boolean mPartialImageCachingEnabled = false;
        public ProducerFactoryMethod mProducerFactoryMethod;
        public Supplier<Boolean> mSuppressBitmapPrefetchingSupplier = new Suppliers$1(Boolean.FALSE);
        public boolean mUseBitmapPrepareToDraw = false;
        public boolean mUseDownsamplingRatioForResizing = false;
        public WebpBitmapFactory mWebpBitmapFactory;
        public WebpErrorLogger mWebpErrorLogger;
        public boolean mWebpSupportEnabled = false;

        public Builder(com.facebook.imagepipeline.core.ImagePipelineConfig.Builder builder) {
            this.mConfigBuilder = builder;
        }

        public ImagePipelineExperiments build() {
            return new ImagePipelineExperiments(this);
        }

        public boolean isPartialImageCachingEnabled() {
            return this.mPartialImageCachingEnabled;
        }

        public com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setBitmapCloseableRefType(int i) {
            this.mBitmapCloseableRefType = i;
            return this.mConfigBuilder;
        }

        public com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setBitmapPrepareToDraw(boolean z, int i, int i2, boolean z2) {
            this.mUseBitmapPrepareToDraw = z;
            this.mBitmapPrepareToDrawMinSizeBytes = i;
            this.mBitmapPrepareToDrawMaxSizeBytes = i2;
            this.mBitmapPrepareToDrawForPrefetch = z2;
            return this.mConfigBuilder;
        }

        public com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setDecodeCancellationEnabled(boolean z) {
            this.mDecodeCancellationEnabled = z;
            return this.mConfigBuilder;
        }

        public com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setDownsampleIfLargeBitmap(boolean z) {
            this.mDownsampleIfLargeBitmap = z;
            return this.mConfigBuilder;
        }

        public com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setEncodedCacheEnabled(boolean z) {
            this.mEncodedCacheEnabled = z;
            return this.mConfigBuilder;
        }

        public com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setExperimentalMemoryType(long j) {
            this.mMemoryType = j;
            return this.mConfigBuilder;
        }

        public com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setExperimentalThreadHandoffQueueEnabled(boolean z) {
            this.mExperimentalThreadHandoffQueueEnabled = z;
            return this.mConfigBuilder;
        }

        public com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setGingerbreadDecoderEnabled(boolean z) {
            this.mGingerbreadDecoderEnabled = z;
            return this.mConfigBuilder;
        }

        public com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setKeepCancelledFetchAsLowPriority(boolean z) {
            this.mKeepCancelledFetchAsLowPriority = z;
            return this.mConfigBuilder;
        }

        public com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setLazyDataSource(Supplier<Boolean> supplier) {
            this.mLazyDataSource = supplier;
            return this.mConfigBuilder;
        }

        public com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setMaxBitmapSize(int i) {
            this.mMaxBitmapSize = i;
            return this.mConfigBuilder;
        }

        public com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setNativeCodeDisabled(boolean z) {
            this.mNativeCodeDisabled = z;
            return this.mConfigBuilder;
        }

        public com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setPartialImageCachingEnabled(boolean z) {
            this.mPartialImageCachingEnabled = z;
            return this.mConfigBuilder;
        }

        public com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setProducerFactoryMethod(ProducerFactoryMethod producerFactoryMethod) {
            this.mProducerFactoryMethod = producerFactoryMethod;
            return this.mConfigBuilder;
        }

        public com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setShouldDownscaleFrameToDrawableDimensions(boolean z) {
            this.mDownscaleFrameToDrawableDimensions = z;
            return this.mConfigBuilder;
        }

        public com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setSuppressBitmapPrefetchingSupplier(Supplier<Boolean> supplier) {
            this.mSuppressBitmapPrefetchingSupplier = supplier;
            return this.mConfigBuilder;
        }

        public com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setUseDownsampligRatioForResizing(boolean z) {
            this.mUseDownsamplingRatioForResizing = z;
            return this.mConfigBuilder;
        }

        public com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setWebpBitmapFactory(WebpBitmapFactory webpBitmapFactory) {
            this.mWebpBitmapFactory = webpBitmapFactory;
            return this.mConfigBuilder;
        }

        public com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setWebpErrorLogger(WebpErrorLogger webpErrorLogger) {
            this.mWebpErrorLogger = webpErrorLogger;
            return this.mConfigBuilder;
        }

        public com.facebook.imagepipeline.core.ImagePipelineConfig.Builder setWebpSupportEnabled(boolean z) {
            this.mWebpSupportEnabled = z;
            return this.mConfigBuilder;
        }
    }

    public static class DefaultProducerFactoryMethod implements ProducerFactoryMethod {
        public ProducerFactory createProducerFactory(Context context, ByteArrayPool byteArrayPool, ImageDecoder imageDecoder, ProgressiveJpegConfig progressiveJpegConfig, boolean z, boolean z2, boolean z3, ExecutorSupplier executorSupplier, PooledByteBufferFactory pooledByteBufferFactory, MemoryCache<CacheKey, CloseableImage> memoryCache, MemoryCache<CacheKey, PooledByteBuffer> memoryCache2, BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, PlatformBitmapFactory platformBitmapFactory, int i, int i2, boolean z4, int i3, CloseableReferenceFactory closeableReferenceFactory, boolean z5) {
            ProducerFactory producerFactory = new ProducerFactory(context, byteArrayPool, imageDecoder, progressiveJpegConfig, z, z2, z3, executorSupplier, pooledByteBufferFactory, memoryCache, memoryCache2, bufferedDiskCache, bufferedDiskCache2, cacheKeyFactory, platformBitmapFactory, i, i2, z4, i3, closeableReferenceFactory, z5);
            return producerFactory;
        }
    }

    public interface ProducerFactoryMethod {
        ProducerFactory createProducerFactory(Context context, ByteArrayPool byteArrayPool, ImageDecoder imageDecoder, ProgressiveJpegConfig progressiveJpegConfig, boolean z, boolean z2, boolean z3, ExecutorSupplier executorSupplier, PooledByteBufferFactory pooledByteBufferFactory, MemoryCache<CacheKey, CloseableImage> memoryCache, MemoryCache<CacheKey, PooledByteBuffer> memoryCache2, BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, PlatformBitmapFactory platformBitmapFactory, int i, int i2, boolean z4, int i3, CloseableReferenceFactory closeableReferenceFactory, boolean z5);
    }

    public static Builder newBuilder(com.facebook.imagepipeline.core.ImagePipelineConfig.Builder builder) {
        return new Builder(builder);
    }

    public int getBitmapCloseableRefType() {
        return this.mBitmapCloseableRefType;
    }

    public boolean getBitmapPrepareToDrawForPrefetch() {
        return this.mBitmapPrepareToDrawForPrefetch;
    }

    public int getBitmapPrepareToDrawMaxSizeBytes() {
        return this.mBitmapPrepareToDrawMaxSizeBytes;
    }

    public int getBitmapPrepareToDrawMinSizeBytes() {
        return this.mBitmapPrepareToDrawMinSizeBytes;
    }

    public int getMaxBitmapSize() {
        return this.mMaxBitmapSize;
    }

    public long getMemoryType() {
        return this.mMemoryType;
    }

    public ProducerFactoryMethod getProducerFactoryMethod() {
        return this.mProducerFactoryMethod;
    }

    public Supplier<Boolean> getSuppressBitmapPrefetchingSupplier() {
        return this.mSuppressBitmapPrefetchingSupplier;
    }

    public boolean getUseBitmapPrepareToDraw() {
        return this.mUseBitmapPrepareToDraw;
    }

    public boolean getUseDownsamplingRatioForResizing() {
        return this.mUseDownsamplingRatioForResizing;
    }

    public WebpBitmapFactory getWebpBitmapFactory() {
        return this.mWebpBitmapFactory;
    }

    public WebpErrorLogger getWebpErrorLogger() {
        return this.mWebpErrorLogger;
    }

    public boolean isDecodeCancellationEnabled() {
        return this.mDecodeCancellationEnabled;
    }

    public boolean isEncodedCacheEnabled() {
        return this.mEncodedCacheEnabled;
    }

    public boolean isExperimentalThreadHandoffQueueEnabled() {
        return this.mExperimentalThreadHandoffQueueEnabled;
    }

    public boolean isGingerbreadDecoderEnabled() {
        return this.mGingerbreadDecoderEnabled;
    }

    public Supplier<Boolean> isLazyDataSource() {
        return this.mLazyDataSource;
    }

    public boolean isNativeCodeDisabled() {
        return this.mNativeCodeDisabled;
    }

    public boolean isPartialImageCachingEnabled() {
        return this.mPartialImageCachingEnabled;
    }

    public boolean isWebpSupportEnabled() {
        return this.mWebpSupportEnabled;
    }

    public boolean shouldDownsampleIfLargeBitmap() {
        return this.mDownsampleIfLargeBitmap;
    }

    public boolean shouldDownscaleFrameToDrawableDimensions() {
        return this.mDownscaleFrameToDrawableDimensions;
    }

    public boolean shouldKeepCancelledFetchAsLowPriority() {
        return this.mKeepCancelledFetchAsLowPriority;
    }

    public ImagePipelineExperiments(Builder builder) {
        this.mWebpSupportEnabled = builder.mWebpSupportEnabled;
        this.mWebpErrorLogger = builder.mWebpErrorLogger;
        this.mDecodeCancellationEnabled = builder.mDecodeCancellationEnabled;
        this.mWebpBitmapFactory = builder.mWebpBitmapFactory;
        this.mUseDownsamplingRatioForResizing = builder.mUseDownsamplingRatioForResizing;
        this.mUseBitmapPrepareToDraw = builder.mUseBitmapPrepareToDraw;
        this.mBitmapPrepareToDrawMinSizeBytes = builder.mBitmapPrepareToDrawMinSizeBytes;
        this.mBitmapPrepareToDrawMaxSizeBytes = builder.mBitmapPrepareToDrawMaxSizeBytes;
        this.mBitmapPrepareToDrawForPrefetch = builder.mBitmapPrepareToDrawForPrefetch;
        this.mMaxBitmapSize = builder.mMaxBitmapSize;
        this.mNativeCodeDisabled = builder.mNativeCodeDisabled;
        this.mPartialImageCachingEnabled = builder.mPartialImageCachingEnabled;
        if (builder.mProducerFactoryMethod == null) {
            this.mProducerFactoryMethod = new DefaultProducerFactoryMethod();
        } else {
            this.mProducerFactoryMethod = builder.mProducerFactoryMethod;
        }
        this.mLazyDataSource = builder.mLazyDataSource;
        this.mGingerbreadDecoderEnabled = builder.mGingerbreadDecoderEnabled;
        this.mDownscaleFrameToDrawableDimensions = builder.mDownscaleFrameToDrawableDimensions;
        this.mBitmapCloseableRefType = builder.mBitmapCloseableRefType;
        this.mSuppressBitmapPrefetchingSupplier = builder.mSuppressBitmapPrefetchingSupplier;
        this.mExperimentalThreadHandoffQueueEnabled = builder.mExperimentalThreadHandoffQueueEnabled;
        this.mMemoryType = builder.mMemoryType;
        this.mKeepCancelledFetchAsLowPriority = builder.mKeepCancelledFetchAsLowPriority;
        this.mDownsampleIfLargeBitmap = builder.mDownsampleIfLargeBitmap;
        this.mEncodedCacheEnabled = builder.mEncodedCacheEnabled;
    }
}