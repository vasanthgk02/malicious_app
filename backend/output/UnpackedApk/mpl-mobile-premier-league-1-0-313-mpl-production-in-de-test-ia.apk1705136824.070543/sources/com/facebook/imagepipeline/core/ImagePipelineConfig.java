package com.facebook.imagepipeline.core;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.callercontext.CallerContextVerifier;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.webp.BitmapCreator;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.common.webp.WebpBitmapFactory.WebpErrorLogger;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.ImageCacheStatsTracker;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.cache.MemoryCache.CacheTrimStrategy;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.facebook.imagepipeline.debug.CloseableReferenceLeakTracker;
import com.facebook.imagepipeline.debug.NoOpCloseableReferenceLeakTracker;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ImageDecoderConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.listener.RequestListener2;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import java.util.Collections;
import java.util.Set;

public class ImagePipelineConfig {
    public static DefaultImageRequestConfig sDefaultImageRequestConfig = new DefaultImageRequestConfig();
    public final MemoryCache<CacheKey, CloseableImage> mBitmapCache;
    public final Config mBitmapConfig;
    public final Supplier<MemoryCacheParams> mBitmapMemoryCacheParamsSupplier;
    public final CacheTrimStrategy mBitmapMemoryCacheTrimStrategy;
    public final CacheKeyFactory mCacheKeyFactory;
    public final CallerContextVerifier mCallerContextVerifier;
    public final CloseableReferenceLeakTracker mCloseableReferenceLeakTracker;
    public final Context mContext;
    public final boolean mDiskCacheEnabled;
    public final boolean mDownsampleEnabled;
    public final MemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
    public final Supplier<MemoryCacheParams> mEncodedMemoryCacheParamsSupplier;
    public final ExecutorSupplier mExecutorSupplier;
    public final FileCacheFactory mFileCacheFactory;
    public final int mHttpNetworkTimeout;
    public final ImageCacheStatsTracker mImageCacheStatsTracker;
    public final ImageDecoder mImageDecoder;
    public final ImageDecoderConfig mImageDecoderConfig;
    public final ImagePipelineExperiments mImagePipelineExperiments;
    public final ImageTranscoderFactory mImageTranscoderFactory;
    public final Integer mImageTranscoderType;
    public final Supplier<Boolean> mIsPrefetchEnabledSupplier;
    public final DiskCacheConfig mMainDiskCacheConfig;
    public final int mMemoryChunkType;
    public final MemoryTrimmableRegistry mMemoryTrimmableRegistry;
    public final NetworkFetcher mNetworkFetcher;
    public final PlatformBitmapFactory mPlatformBitmapFactory;
    public final PoolFactory mPoolFactory;
    public final ProgressiveJpegConfig mProgressiveJpegConfig;
    public final Set<RequestListener2> mRequestListener2s;
    public final Set<RequestListener> mRequestListeners;
    public final boolean mResizeAndRotateEnabledForNetwork;
    public final DiskCacheConfig mSmallImageDiskCacheConfig;

    public static class Builder {
        public Config mBitmapConfig;
        public MemoryCache<CacheKey, CloseableImage> mBitmapMemoryCache;
        public Supplier<MemoryCacheParams> mBitmapMemoryCacheParamsSupplier;
        public CacheTrimStrategy mBitmapMemoryCacheTrimStrategy;
        public CacheKeyFactory mCacheKeyFactory;
        public CallerContextVerifier mCallerContextVerifier;
        public CloseableReferenceLeakTracker mCloseableReferenceLeakTracker;
        public final Context mContext;
        public boolean mDiskCacheEnabled;
        public boolean mDownsampleEnabled;
        public MemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
        public Supplier<MemoryCacheParams> mEncodedMemoryCacheParamsSupplier;
        public ExecutorSupplier mExecutorSupplier;
        public final com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder mExperimentsBuilder;
        public FileCacheFactory mFileCacheFactory;
        public int mHttpConnectionTimeout;
        public ImageCacheStatsTracker mImageCacheStatsTracker;
        public ImageDecoder mImageDecoder;
        public ImageDecoderConfig mImageDecoderConfig;
        public ImageTranscoderFactory mImageTranscoderFactory;
        public Integer mImageTranscoderType;
        public Supplier<Boolean> mIsPrefetchEnabledSupplier;
        public DiskCacheConfig mMainDiskCacheConfig;
        public Integer mMemoryChunkType;
        public MemoryTrimmableRegistry mMemoryTrimmableRegistry;
        public NetworkFetcher mNetworkFetcher;
        public PlatformBitmapFactory mPlatformBitmapFactory;
        public PoolFactory mPoolFactory;
        public ProgressiveJpegConfig mProgressiveJpegConfig;
        public Set<RequestListener2> mRequestListener2s;
        public Set<RequestListener> mRequestListeners;
        public boolean mResizeAndRotateEnabledForNetwork;
        public DiskCacheConfig mSmallImageDiskCacheConfig;

        public ImagePipelineConfig build() {
            return new ImagePipelineConfig(this);
        }

        public com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder experiment() {
            return this.mExperimentsBuilder;
        }

        public Integer getImageTranscoderType() {
            return this.mImageTranscoderType;
        }

        public Integer getMemoryChunkType() {
            return this.mMemoryChunkType;
        }

        public boolean isDiskCacheEnabled() {
            return this.mDiskCacheEnabled;
        }

        public boolean isDownsampleEnabled() {
            return this.mDownsampleEnabled;
        }

        public Builder setBitmapMemoryCache(MemoryCache<CacheKey, CloseableImage> memoryCache) {
            this.mBitmapMemoryCache = memoryCache;
            return this;
        }

        public Builder setBitmapMemoryCacheParamsSupplier(Supplier<MemoryCacheParams> supplier) {
            if (supplier != null) {
                this.mBitmapMemoryCacheParamsSupplier = supplier;
                return this;
            }
            throw null;
        }

        public Builder setBitmapMemoryCacheTrimStrategy(CacheTrimStrategy cacheTrimStrategy) {
            this.mBitmapMemoryCacheTrimStrategy = cacheTrimStrategy;
            return this;
        }

        public Builder setBitmapsConfig(Config config) {
            this.mBitmapConfig = config;
            return this;
        }

        public Builder setCacheKeyFactory(CacheKeyFactory cacheKeyFactory) {
            this.mCacheKeyFactory = cacheKeyFactory;
            return this;
        }

        public Builder setCallerContextVerifier(CallerContextVerifier callerContextVerifier) {
            this.mCallerContextVerifier = callerContextVerifier;
            return this;
        }

        public Builder setCloseableReferenceLeakTracker(CloseableReferenceLeakTracker closeableReferenceLeakTracker) {
            this.mCloseableReferenceLeakTracker = closeableReferenceLeakTracker;
            return this;
        }

        public Builder setDiskCacheEnabled(boolean z) {
            this.mDiskCacheEnabled = z;
            return this;
        }

        public Builder setDownsampleEnabled(boolean z) {
            this.mDownsampleEnabled = z;
            return this;
        }

        public Builder setEncodedMemoryCache(MemoryCache<CacheKey, PooledByteBuffer> memoryCache) {
            this.mEncodedMemoryCache = memoryCache;
            return this;
        }

        public Builder setEncodedMemoryCacheParamsSupplier(Supplier<MemoryCacheParams> supplier) {
            if (supplier != null) {
                this.mEncodedMemoryCacheParamsSupplier = supplier;
                return this;
            }
            throw null;
        }

        public Builder setExecutorSupplier(ExecutorSupplier executorSupplier) {
            this.mExecutorSupplier = executorSupplier;
            return this;
        }

        public Builder setFileCacheFactory(FileCacheFactory fileCacheFactory) {
            this.mFileCacheFactory = fileCacheFactory;
            return this;
        }

        public Builder setHttpConnectionTimeout(int i) {
            this.mHttpConnectionTimeout = i;
            return this;
        }

        public Builder setImageCacheStatsTracker(ImageCacheStatsTracker imageCacheStatsTracker) {
            this.mImageCacheStatsTracker = imageCacheStatsTracker;
            return this;
        }

        public Builder setImageDecoder(ImageDecoder imageDecoder) {
            this.mImageDecoder = imageDecoder;
            return this;
        }

        public Builder setImageDecoderConfig(ImageDecoderConfig imageDecoderConfig) {
            this.mImageDecoderConfig = imageDecoderConfig;
            return this;
        }

        public Builder setImageTranscoderFactory(ImageTranscoderFactory imageTranscoderFactory) {
            this.mImageTranscoderFactory = imageTranscoderFactory;
            return this;
        }

        public Builder setImageTranscoderType(int i) {
            this.mImageTranscoderType = Integer.valueOf(i);
            return this;
        }

        public Builder setIsPrefetchEnabledSupplier(Supplier<Boolean> supplier) {
            this.mIsPrefetchEnabledSupplier = supplier;
            return this;
        }

        public Builder setMainDiskCacheConfig(DiskCacheConfig diskCacheConfig) {
            this.mMainDiskCacheConfig = diskCacheConfig;
            return this;
        }

        public Builder setMemoryChunkType(int i) {
            this.mMemoryChunkType = Integer.valueOf(i);
            return this;
        }

        public Builder setMemoryTrimmableRegistry(MemoryTrimmableRegistry memoryTrimmableRegistry) {
            this.mMemoryTrimmableRegistry = memoryTrimmableRegistry;
            return this;
        }

        public Builder setNetworkFetcher(NetworkFetcher networkFetcher) {
            this.mNetworkFetcher = networkFetcher;
            return this;
        }

        public Builder setPlatformBitmapFactory(PlatformBitmapFactory platformBitmapFactory) {
            this.mPlatformBitmapFactory = platformBitmapFactory;
            return this;
        }

        public Builder setPoolFactory(PoolFactory poolFactory) {
            this.mPoolFactory = poolFactory;
            return this;
        }

        public Builder setProgressiveJpegConfig(ProgressiveJpegConfig progressiveJpegConfig) {
            this.mProgressiveJpegConfig = progressiveJpegConfig;
            return this;
        }

        public Builder setRequestListener2s(Set<RequestListener2> set) {
            this.mRequestListener2s = set;
            return this;
        }

        public Builder setRequestListeners(Set<RequestListener> set) {
            this.mRequestListeners = set;
            return this;
        }

        public Builder setResizeAndRotateEnabledForNetwork(boolean z) {
            this.mResizeAndRotateEnabledForNetwork = z;
            return this;
        }

        public Builder setSmallImageDiskCacheConfig(DiskCacheConfig diskCacheConfig) {
            this.mSmallImageDiskCacheConfig = diskCacheConfig;
            return this;
        }

        public Builder(Context context) {
            this.mDownsampleEnabled = false;
            this.mImageTranscoderType = null;
            this.mMemoryChunkType = null;
            this.mResizeAndRotateEnabledForNetwork = true;
            this.mHttpConnectionTimeout = -1;
            this.mExperimentsBuilder = new com.facebook.imagepipeline.core.ImagePipelineExperiments.Builder(this);
            this.mDiskCacheEnabled = true;
            this.mCloseableReferenceLeakTracker = new NoOpCloseableReferenceLeakTracker();
            if (context != null) {
                this.mContext = context;
                return;
            }
            throw null;
        }
    }

    public static class DefaultImageRequestConfig {
        public boolean mProgressiveRenderingEnabled;

        public boolean isProgressiveRenderingEnabled() {
            return this.mProgressiveRenderingEnabled;
        }

        public void setProgressiveRenderingEnabled(boolean z) {
            this.mProgressiveRenderingEnabled = z;
        }

        public DefaultImageRequestConfig() {
            this.mProgressiveRenderingEnabled = false;
        }
    }

    public static DefaultImageRequestConfig getDefaultImageRequestConfig() {
        return sDefaultImageRequestConfig;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003c A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.cache.disk.DiskCacheConfig getDefaultMainDiskCacheConfig(android.content.Context r3) {
        /*
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()     // Catch:{ all -> 0x0040 }
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = "DiskCacheConfig.getDefaultMainDiskCacheConfig"
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection(r0)     // Catch:{ all -> 0x0040 }
        L_0x000b:
            com.facebook.cache.disk.DiskCacheConfig$Builder r0 = new com.facebook.cache.disk.DiskCacheConfig$Builder     // Catch:{ all -> 0x0040 }
            r1 = 0
            r0.<init>(r3, r1)     // Catch:{ all -> 0x0040 }
            com.facebook.common.internal.Supplier<java.io.File> r3 = r0.mBaseDirectoryPathSupplier     // Catch:{ all -> 0x0040 }
            if (r3 != 0) goto L_0x001c
            android.content.Context r3 = r0.mContext     // Catch:{ all -> 0x0040 }
            if (r3 == 0) goto L_0x001a
            goto L_0x001c
        L_0x001a:
            r3 = 0
            goto L_0x001d
        L_0x001c:
            r3 = 1
        L_0x001d:
            java.lang.String r2 = "Either a non-null context or a base directory path or supplier must be provided."
            co.hyperverge.hypersnapsdk.c.k.checkState(r3, r2)     // Catch:{ all -> 0x0040 }
            com.facebook.common.internal.Supplier<java.io.File> r3 = r0.mBaseDirectoryPathSupplier     // Catch:{ all -> 0x0040 }
            if (r3 != 0) goto L_0x0031
            android.content.Context r3 = r0.mContext     // Catch:{ all -> 0x0040 }
            if (r3 == 0) goto L_0x0031
            com.facebook.cache.disk.DiskCacheConfig$Builder$1 r3 = new com.facebook.cache.disk.DiskCacheConfig$Builder$1     // Catch:{ all -> 0x0040 }
            r3.<init>()     // Catch:{ all -> 0x0040 }
            r0.mBaseDirectoryPathSupplier = r3     // Catch:{ all -> 0x0040 }
        L_0x0031:
            com.facebook.cache.disk.DiskCacheConfig r3 = new com.facebook.cache.disk.DiskCacheConfig     // Catch:{ all -> 0x0040 }
            r3.<init>(r0, r1)     // Catch:{ all -> 0x0040 }
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r0 == 0) goto L_0x003f
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x003f:
            return r3
        L_0x0040:
            r3 = move-exception
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r0 == 0) goto L_0x004a
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x004a:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.core.ImagePipelineConfig.getDefaultMainDiskCacheConfig(android.content.Context):com.facebook.cache.disk.DiskCacheConfig");
    }

    public static Builder newBuilder(Context context) {
        return new Builder(context);
    }

    public static void resetDefaultRequestConfig() {
        sDefaultImageRequestConfig = new DefaultImageRequestConfig();
    }

    public static void setWebpBitmapFactory(WebpBitmapFactory webpBitmapFactory, ImagePipelineExperiments imagePipelineExperiments, BitmapCreator bitmapCreator) {
        WebpSupportStatus.sWebpBitmapFactory = webpBitmapFactory;
        WebpErrorLogger webpErrorLogger = imagePipelineExperiments.getWebpErrorLogger();
        if (webpErrorLogger != null) {
            webpBitmapFactory.setWebpErrorLogger(webpErrorLogger);
        }
        if (bitmapCreator != null) {
            webpBitmapFactory.setBitmapCreator(bitmapCreator);
        }
    }

    public MemoryCache<CacheKey, CloseableImage> getBitmapCacheOverride() {
        return this.mBitmapCache;
    }

    public Config getBitmapConfig() {
        return this.mBitmapConfig;
    }

    public Supplier<MemoryCacheParams> getBitmapMemoryCacheParamsSupplier() {
        return this.mBitmapMemoryCacheParamsSupplier;
    }

    public CacheTrimStrategy getBitmapMemoryCacheTrimStrategy() {
        return this.mBitmapMemoryCacheTrimStrategy;
    }

    public CacheKeyFactory getCacheKeyFactory() {
        return this.mCacheKeyFactory;
    }

    public CallerContextVerifier getCallerContextVerifier() {
        return this.mCallerContextVerifier;
    }

    public CloseableReferenceLeakTracker getCloseableReferenceLeakTracker() {
        return this.mCloseableReferenceLeakTracker;
    }

    public Context getContext() {
        return this.mContext;
    }

    public MemoryCache<CacheKey, PooledByteBuffer> getEncodedMemoryCacheOverride() {
        return this.mEncodedMemoryCache;
    }

    public Supplier<MemoryCacheParams> getEncodedMemoryCacheParamsSupplier() {
        return this.mEncodedMemoryCacheParamsSupplier;
    }

    public ExecutorSupplier getExecutorSupplier() {
        return this.mExecutorSupplier;
    }

    public ImagePipelineExperiments getExperiments() {
        return this.mImagePipelineExperiments;
    }

    public FileCacheFactory getFileCacheFactory() {
        return this.mFileCacheFactory;
    }

    public ImageCacheStatsTracker getImageCacheStatsTracker() {
        return this.mImageCacheStatsTracker;
    }

    public ImageDecoder getImageDecoder() {
        return this.mImageDecoder;
    }

    public ImageDecoderConfig getImageDecoderConfig() {
        return this.mImageDecoderConfig;
    }

    public ImageTranscoderFactory getImageTranscoderFactory() {
        return this.mImageTranscoderFactory;
    }

    public Integer getImageTranscoderType() {
        return this.mImageTranscoderType;
    }

    public Supplier<Boolean> getIsPrefetchEnabledSupplier() {
        return this.mIsPrefetchEnabledSupplier;
    }

    public DiskCacheConfig getMainDiskCacheConfig() {
        return this.mMainDiskCacheConfig;
    }

    public int getMemoryChunkType() {
        return this.mMemoryChunkType;
    }

    public MemoryTrimmableRegistry getMemoryTrimmableRegistry() {
        return this.mMemoryTrimmableRegistry;
    }

    public NetworkFetcher getNetworkFetcher() {
        return this.mNetworkFetcher;
    }

    public PlatformBitmapFactory getPlatformBitmapFactory() {
        return this.mPlatformBitmapFactory;
    }

    public PoolFactory getPoolFactory() {
        return this.mPoolFactory;
    }

    public ProgressiveJpegConfig getProgressiveJpegConfig() {
        return this.mProgressiveJpegConfig;
    }

    public Set<RequestListener2> getRequestListener2s() {
        return Collections.unmodifiableSet(this.mRequestListener2s);
    }

    public Set<RequestListener> getRequestListeners() {
        return Collections.unmodifiableSet(this.mRequestListeners);
    }

    public DiskCacheConfig getSmallImageDiskCacheConfig() {
        return this.mSmallImageDiskCacheConfig;
    }

    public boolean isDiskCacheEnabled() {
        return this.mDiskCacheEnabled;
    }

    public boolean isDownsampleEnabled() {
        return this.mDownsampleEnabled;
    }

    public boolean isResizeAndRotateEnabledForNetwork() {
        return this.mResizeAndRotateEnabledForNetwork;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0200, code lost:
        r4 = com.facebook.common.webp.WebpSupportStatus.sIsWebpSupportRequired;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ImagePipelineConfig(com.facebook.imagepipeline.core.ImagePipelineConfig.Builder r4) {
        /*
            r3 = this;
            r3.<init>()
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r0 == 0) goto L_0x000e
            java.lang.String r0 = "ImagePipelineConfig()"
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection(r0)
        L_0x000e:
            com.facebook.imagepipeline.core.ImagePipelineExperiments$Builder r0 = r4.mExperimentsBuilder
            com.facebook.imagepipeline.core.ImagePipelineExperiments r0 = r0.build()
            r3.mImagePipelineExperiments = r0
            com.facebook.common.internal.Supplier r0 = r4.mBitmapMemoryCacheParamsSupplier
            if (r0 != 0) goto L_0x0030
            com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier r0 = new com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier
            android.content.Context r1 = r4.mContext
            java.lang.String r2 = "activity"
            java.lang.Object r1 = r1.getSystemService(r2)
            android.app.ActivityManager r1 = (android.app.ActivityManager) r1
            r0.<init>(r1)
            goto L_0x0034
        L_0x0030:
            com.facebook.common.internal.Supplier r0 = r4.mBitmapMemoryCacheParamsSupplier
        L_0x0034:
            r3.mBitmapMemoryCacheParamsSupplier = r0
            com.facebook.imagepipeline.cache.MemoryCache$CacheTrimStrategy r0 = r4.mBitmapMemoryCacheTrimStrategy
            if (r0 != 0) goto L_0x0042
            com.facebook.imagepipeline.cache.BitmapMemoryCacheTrimStrategy r0 = new com.facebook.imagepipeline.cache.BitmapMemoryCacheTrimStrategy
            r0.<init>()
            goto L_0x0046
        L_0x0042:
            com.facebook.imagepipeline.cache.MemoryCache$CacheTrimStrategy r0 = r4.mBitmapMemoryCacheTrimStrategy
        L_0x0046:
            r3.mBitmapMemoryCacheTrimStrategy = r0
            android.graphics.Bitmap$Config r0 = r4.mBitmapConfig
            if (r0 != 0) goto L_0x0051
            android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.ARGB_8888
            goto L_0x0055
        L_0x0051:
            android.graphics.Bitmap$Config r0 = r4.mBitmapConfig
        L_0x0055:
            r3.mBitmapConfig = r0
            com.facebook.imagepipeline.cache.CacheKeyFactory r0 = r4.mCacheKeyFactory
            if (r0 != 0) goto L_0x0062
            com.facebook.imagepipeline.cache.DefaultCacheKeyFactory r0 = com.facebook.imagepipeline.cache.DefaultCacheKeyFactory.getInstance()
            goto L_0x0066
        L_0x0062:
            com.facebook.imagepipeline.cache.CacheKeyFactory r0 = r4.mCacheKeyFactory
        L_0x0066:
            r3.mCacheKeyFactory = r0
            android.content.Context r0 = r4.mContext
            co.hyperverge.hypersnapsdk.c.k.checkNotNull1(r0)
            r3.mContext = r0
            com.facebook.imagepipeline.core.FileCacheFactory r0 = r4.mFileCacheFactory
            if (r0 != 0) goto L_0x0082
            com.facebook.imagepipeline.core.DiskStorageCacheFactory r0 = new com.facebook.imagepipeline.core.DiskStorageCacheFactory
            com.facebook.imagepipeline.core.DynamicDefaultDiskStorageFactory r1 = new com.facebook.imagepipeline.core.DynamicDefaultDiskStorageFactory
            r1.<init>()
            r0.<init>(r1)
            goto L_0x0086
        L_0x0082:
            com.facebook.imagepipeline.core.FileCacheFactory r0 = r4.mFileCacheFactory
        L_0x0086:
            r3.mFileCacheFactory = r0
            boolean r0 = r4.mDownsampleEnabled
            r3.mDownsampleEnabled = r0
            com.facebook.common.internal.Supplier r0 = r4.mEncodedMemoryCacheParamsSupplier
            if (r0 != 0) goto L_0x009a
            com.facebook.imagepipeline.cache.DefaultEncodedMemoryCacheParamsSupplier r0 = new com.facebook.imagepipeline.cache.DefaultEncodedMemoryCacheParamsSupplier
            r0.<init>()
            goto L_0x009e
        L_0x009a:
            com.facebook.common.internal.Supplier r0 = r4.mEncodedMemoryCacheParamsSupplier
        L_0x009e:
            r3.mEncodedMemoryCacheParamsSupplier = r0
            com.facebook.imagepipeline.cache.ImageCacheStatsTracker r0 = r4.mImageCacheStatsTracker
            if (r0 != 0) goto L_0x00ab
            com.facebook.imagepipeline.cache.NoOpImageCacheStatsTracker r0 = com.facebook.imagepipeline.cache.NoOpImageCacheStatsTracker.getInstance()
            goto L_0x00af
        L_0x00ab:
            com.facebook.imagepipeline.cache.ImageCacheStatsTracker r0 = r4.mImageCacheStatsTracker
        L_0x00af:
            r3.mImageCacheStatsTracker = r0
            com.facebook.imagepipeline.decoder.ImageDecoder r0 = r4.mImageDecoder
            r3.mImageDecoder = r0
            com.facebook.imagepipeline.transcoder.ImageTranscoderFactory r0 = getImageTranscoderFactory(r4)
            r3.mImageTranscoderFactory = r0
            java.lang.Integer r0 = r4.mImageTranscoderType
            r3.mImageTranscoderType = r0
            com.facebook.common.internal.Supplier r0 = r4.mIsPrefetchEnabledSupplier
            if (r0 != 0) goto L_0x00cf
            com.facebook.imagepipeline.core.ImagePipelineConfig$1 r0 = new com.facebook.imagepipeline.core.ImagePipelineConfig$1
            r0.<init>()
            goto L_0x00d3
        L_0x00cf:
            com.facebook.common.internal.Supplier r0 = r4.mIsPrefetchEnabledSupplier
        L_0x00d3:
            r3.mIsPrefetchEnabledSupplier = r0
            com.facebook.cache.disk.DiskCacheConfig r0 = r4.mMainDiskCacheConfig
            if (r0 != 0) goto L_0x00e4
            android.content.Context r0 = r4.mContext
            com.facebook.cache.disk.DiskCacheConfig r0 = getDefaultMainDiskCacheConfig(r0)
            goto L_0x00e8
        L_0x00e4:
            com.facebook.cache.disk.DiskCacheConfig r0 = r4.mMainDiskCacheConfig
        L_0x00e8:
            r3.mMainDiskCacheConfig = r0
            com.facebook.common.memory.MemoryTrimmableRegistry r0 = r4.mMemoryTrimmableRegistry
            if (r0 != 0) goto L_0x00f5
            com.facebook.common.memory.NoOpMemoryTrimmableRegistry r0 = com.facebook.common.memory.NoOpMemoryTrimmableRegistry.getInstance()
            goto L_0x00f9
        L_0x00f5:
            com.facebook.common.memory.MemoryTrimmableRegistry r0 = r4.mMemoryTrimmableRegistry
        L_0x00f9:
            r3.mMemoryTrimmableRegistry = r0
            com.facebook.imagepipeline.core.ImagePipelineExperiments r0 = r3.mImagePipelineExperiments
            int r0 = getMemoryChunkType(r4, r0)
            r3.mMemoryChunkType = r0
            int r0 = r4.mHttpConnectionTimeout
            if (r0 >= 0) goto L_0x010c
            r0 = 30000(0x7530, float:4.2039E-41)
            goto L_0x0110
        L_0x010c:
            int r0 = r4.mHttpConnectionTimeout
        L_0x0110:
            r3.mHttpNetworkTimeout = r0
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r0 == 0) goto L_0x011d
            java.lang.String r0 = "ImagePipelineConfig->mNetworkFetcher"
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection(r0)
        L_0x011d:
            com.facebook.imagepipeline.producers.NetworkFetcher r0 = r4.mNetworkFetcher
            if (r0 != 0) goto L_0x012b
            com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher r0 = new com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher
            int r1 = r3.mHttpNetworkTimeout
            r0.<init>(r1)
            goto L_0x012f
        L_0x012b:
            com.facebook.imagepipeline.producers.NetworkFetcher r0 = r4.mNetworkFetcher
        L_0x012f:
            r3.mNetworkFetcher = r0
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r0 == 0) goto L_0x013a
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x013a:
            com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory r0 = r4.mPlatformBitmapFactory
            r3.mPlatformBitmapFactory = r0
            com.facebook.imagepipeline.memory.PoolFactory r0 = r4.mPoolFactory
            if (r0 != 0) goto L_0x0154
            com.facebook.imagepipeline.memory.PoolFactory r0 = new com.facebook.imagepipeline.memory.PoolFactory
            com.facebook.imagepipeline.memory.PoolConfig$Builder r1 = com.facebook.imagepipeline.memory.PoolConfig.newBuilder()
            com.facebook.imagepipeline.memory.PoolConfig r1 = r1.build()
            r0.<init>(r1)
            goto L_0x0158
        L_0x0154:
            com.facebook.imagepipeline.memory.PoolFactory r0 = r4.mPoolFactory
        L_0x0158:
            r3.mPoolFactory = r0
            com.facebook.imagepipeline.decoder.ProgressiveJpegConfig r0 = r4.mProgressiveJpegConfig
            if (r0 != 0) goto L_0x0166
            com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig r0 = new com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig
            r0.<init>()
            goto L_0x016a
        L_0x0166:
            com.facebook.imagepipeline.decoder.ProgressiveJpegConfig r0 = r4.mProgressiveJpegConfig
        L_0x016a:
            r3.mProgressiveJpegConfig = r0
            java.util.Set r0 = r4.mRequestListeners
            if (r0 != 0) goto L_0x0178
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            goto L_0x017c
        L_0x0178:
            java.util.Set r0 = r4.mRequestListeners
        L_0x017c:
            r3.mRequestListeners = r0
            java.util.Set r0 = r4.mRequestListener2s
            if (r0 != 0) goto L_0x018a
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            goto L_0x018e
        L_0x018a:
            java.util.Set r0 = r4.mRequestListener2s
        L_0x018e:
            r3.mRequestListener2s = r0
            boolean r0 = r4.mResizeAndRotateEnabledForNetwork
            r3.mResizeAndRotateEnabledForNetwork = r0
            com.facebook.cache.disk.DiskCacheConfig r0 = r4.mSmallImageDiskCacheConfig
            if (r0 != 0) goto L_0x019f
            com.facebook.cache.disk.DiskCacheConfig r0 = r3.mMainDiskCacheConfig
            goto L_0x01a3
        L_0x019f:
            com.facebook.cache.disk.DiskCacheConfig r0 = r4.mSmallImageDiskCacheConfig
        L_0x01a3:
            r3.mSmallImageDiskCacheConfig = r0
            com.facebook.imagepipeline.decoder.ImageDecoderConfig r0 = r4.mImageDecoderConfig
            r3.mImageDecoderConfig = r0
            com.facebook.imagepipeline.memory.PoolFactory r0 = r3.mPoolFactory
            int r0 = r0.getFlexByteArrayPoolMaxNumThreads()
            com.facebook.imagepipeline.core.ExecutorSupplier r1 = r4.mExecutorSupplier
            if (r1 != 0) goto L_0x01bd
            com.facebook.imagepipeline.core.DefaultExecutorSupplier r1 = new com.facebook.imagepipeline.core.DefaultExecutorSupplier
            r1.<init>(r0)
            goto L_0x01c1
        L_0x01bd:
            com.facebook.imagepipeline.core.ExecutorSupplier r1 = r4.mExecutorSupplier
        L_0x01c1:
            r3.mExecutorSupplier = r1
            boolean r0 = r4.mDiskCacheEnabled
            r3.mDiskCacheEnabled = r0
            com.facebook.callercontext.CallerContextVerifier r0 = r4.mCallerContextVerifier
            r3.mCallerContextVerifier = r0
            com.facebook.imagepipeline.debug.CloseableReferenceLeakTracker r0 = r4.mCloseableReferenceLeakTracker
            r3.mCloseableReferenceLeakTracker = r0
            com.facebook.imagepipeline.cache.MemoryCache r0 = r4.mBitmapMemoryCache
            r3.mBitmapCache = r0
            com.facebook.imagepipeline.cache.MemoryCache r4 = r4.mEncodedMemoryCache
            r3.mEncodedMemoryCache = r4
            com.facebook.imagepipeline.core.ImagePipelineExperiments r4 = r3.mImagePipelineExperiments
            com.facebook.common.webp.WebpBitmapFactory r4 = r4.getWebpBitmapFactory()
            if (r4 == 0) goto L_0x01f8
            com.facebook.imagepipeline.bitmaps.HoneycombBitmapCreator r0 = new com.facebook.imagepipeline.bitmaps.HoneycombBitmapCreator
            com.facebook.imagepipeline.memory.PoolFactory r1 = r3.getPoolFactory()
            r0.<init>(r1)
            com.facebook.imagepipeline.core.ImagePipelineExperiments r1 = r3.mImagePipelineExperiments
            setWebpBitmapFactory(r4, r1, r0)
            goto L_0x0202
        L_0x01f8:
            com.facebook.imagepipeline.core.ImagePipelineExperiments r4 = r3.mImagePipelineExperiments
            boolean r4 = r4.isWebpSupportEnabled()
            if (r4 == 0) goto L_0x0202
            boolean r4 = com.facebook.common.webp.WebpSupportStatus.sIsWebpSupportRequired
        L_0x0202:
            boolean r4 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r4 == 0) goto L_0x020b
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x020b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.core.ImagePipelineConfig.<init>(com.facebook.imagepipeline.core.ImagePipelineConfig$Builder):void");
    }

    public static ImageTranscoderFactory getImageTranscoderFactory(Builder builder) {
        if (builder.mImageTranscoderFactory != null && builder.mImageTranscoderType != null) {
            throw new IllegalStateException("You can't define a custom ImageTranscoderFactory and provide an ImageTranscoderType");
        } else if (builder.mImageTranscoderFactory != null) {
            return builder.mImageTranscoderFactory;
        } else {
            return null;
        }
    }

    public static int getMemoryChunkType(Builder builder, ImagePipelineExperiments imagePipelineExperiments) {
        if (builder.mMemoryChunkType != null) {
            return builder.mMemoryChunkType.intValue();
        }
        if (imagePipelineExperiments.getMemoryType() == 2 && VERSION.SDK_INT >= 27) {
            return 2;
        }
        if (imagePipelineExperiments.getMemoryType() == 1) {
            return 1;
        }
        if (imagePipelineExperiments.getMemoryType() == 0) {
        }
        return 0;
    }
}
