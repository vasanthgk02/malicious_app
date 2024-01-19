package com.facebook.imagepipeline.core;

import android.content.Context;
import android.os.Build.VERSION;
import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.internal.AndroidPredicates$1;
import com.facebook.common.internal.Objects$ToStringHelper;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.animated.factory.AnimatedFactory;
import com.facebook.imagepipeline.animated.factory.AnimatedFactoryProvider;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactoryProvider;
import com.facebook.imagepipeline.cache.BitmapCountingMemoryCacheFactory;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheFactory;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.EncodedCountingMemoryCacheFactory;
import com.facebook.imagepipeline.cache.EncodedMemoryCacheFactory;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.decoder.DefaultImageDecoder;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imagepipeline.platform.PlatformDecoderFactory;
import com.facebook.imagepipeline.producers.ExperimentalThreadHandoffProducerQueueImpl;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueueImpl;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import com.facebook.imagepipeline.transcoder.MultiImageTranscoderFactory;
import com.facebook.imagepipeline.transcoder.SimpleImageTranscoderFactory;

public class ImagePipelineFactory {
    public static final Class<?> TAG = ImagePipelineFactory.class;
    public static ImagePipelineFactory sInstance;
    public AnimatedFactory mAnimatedFactory;
    public CountingMemoryCache<CacheKey, CloseableImage> mBitmapCountingMemoryCache;
    public InstrumentedMemoryCache<CacheKey, CloseableImage> mBitmapMemoryCache;
    public final CloseableReferenceFactory mCloseableReferenceFactory;
    public final ImagePipelineConfig mConfig;
    public CountingMemoryCache<CacheKey, PooledByteBuffer> mEncodedCountingMemoryCache;
    public InstrumentedMemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
    public ImageDecoder mImageDecoder;
    public ImagePipeline mImagePipeline;
    public ImageTranscoderFactory mImageTranscoderFactory;
    public BufferedDiskCache mMainBufferedDiskCache;
    public FileCache mMainFileCache;
    public PlatformBitmapFactory mPlatformBitmapFactory;
    public PlatformDecoder mPlatformDecoder;
    public ProducerFactory mProducerFactory;
    public ProducerSequenceFactory mProducerSequenceFactory;
    public BufferedDiskCache mSmallImageBufferedDiskCache;
    public FileCache mSmallImageFileCache;
    public final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;

    public ImagePipelineFactory(ImagePipelineConfig imagePipelineConfig) {
        ThreadHandoffProducerQueue threadHandoffProducerQueue;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ImagePipelineConfig()");
        }
        if (imagePipelineConfig != null) {
            this.mConfig = imagePipelineConfig;
            if (imagePipelineConfig.getExperiments().isExperimentalThreadHandoffQueueEnabled()) {
                threadHandoffProducerQueue = new ExperimentalThreadHandoffProducerQueueImpl(imagePipelineConfig.getExecutorSupplier().forLightweightBackgroundTasks());
            } else {
                threadHandoffProducerQueue = new ThreadHandoffProducerQueueImpl(imagePipelineConfig.getExecutorSupplier().forLightweightBackgroundTasks());
            }
            this.mThreadHandoffProducerQueue = threadHandoffProducerQueue;
            CloseableReference.sBitmapCloseableRefType = imagePipelineConfig.getExperiments().getBitmapCloseableRefType();
            this.mCloseableReferenceFactory = new CloseableReferenceFactory(imagePipelineConfig.getCloseableReferenceLeakTracker());
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
                return;
            }
            return;
        }
        throw null;
    }

    private AnimatedFactory getAnimatedFactory() {
        if (this.mAnimatedFactory == null) {
            this.mAnimatedFactory = AnimatedFactoryProvider.getAnimatedFactory(getPlatformBitmapFactory(), this.mConfig.getExecutorSupplier(), getBitmapCountingMemoryCache(), this.mConfig.getExperiments().shouldDownscaleFrameToDrawableDimensions());
        }
        return this.mAnimatedFactory;
    }

    private ImageDecoder getImageDecoder() {
        ImageDecoder imageDecoder;
        if (this.mImageDecoder == null) {
            if (this.mConfig.getImageDecoder() != null) {
                this.mImageDecoder = this.mConfig.getImageDecoder();
            } else {
                AnimatedFactory animatedFactory = getAnimatedFactory();
                ImageDecoder imageDecoder2 = null;
                if (animatedFactory != null) {
                    imageDecoder2 = animatedFactory.getGifDecoder(this.mConfig.getBitmapConfig());
                    imageDecoder = animatedFactory.getWebPDecoder(this.mConfig.getBitmapConfig());
                } else {
                    imageDecoder = null;
                }
                if (this.mConfig.getImageDecoderConfig() == null) {
                    this.mImageDecoder = new DefaultImageDecoder(imageDecoder2, imageDecoder, getPlatformDecoder());
                } else {
                    this.mImageDecoder = new DefaultImageDecoder(imageDecoder2, imageDecoder, getPlatformDecoder(), this.mConfig.getImageDecoderConfig().getCustomImageDecoders());
                    ImageFormatChecker instance = ImageFormatChecker.getInstance();
                    instance.mCustomImageFormatCheckers = this.mConfig.getImageDecoderConfig().getCustomImageFormats();
                    instance.updateMaxHeaderLength();
                }
            }
        }
        return this.mImageDecoder;
    }

    private ImageTranscoderFactory getImageTranscoderFactory() {
        if (this.mImageTranscoderFactory == null) {
            if (this.mConfig.getImageTranscoderFactory() == null && this.mConfig.getImageTranscoderType() == null && this.mConfig.getExperiments().isNativeCodeDisabled()) {
                this.mImageTranscoderFactory = new SimpleImageTranscoderFactory(this.mConfig.getExperiments().getMaxBitmapSize());
            } else {
                this.mImageTranscoderFactory = new MultiImageTranscoderFactory(this.mConfig.getExperiments().getMaxBitmapSize(), this.mConfig.getExperiments().getUseDownsamplingRatioForResizing(), this.mConfig.getImageTranscoderFactory(), this.mConfig.getImageTranscoderType());
            }
        }
        return this.mImageTranscoderFactory;
    }

    public static ImagePipelineFactory getInstance() {
        ImagePipelineFactory imagePipelineFactory = sInstance;
        k.checkNotNull(imagePipelineFactory, (Object) "ImagePipelineFactory was not initialized!");
        return imagePipelineFactory;
    }

    private ProducerFactory getProducerFactory() {
        if (this.mProducerFactory == null) {
            this.mProducerFactory = this.mConfig.getExperiments().getProducerFactoryMethod().createProducerFactory(this.mConfig.getContext(), this.mConfig.getPoolFactory().getSmallByteArrayPool(), getImageDecoder(), this.mConfig.getProgressiveJpegConfig(), this.mConfig.isDownsampleEnabled(), this.mConfig.isResizeAndRotateEnabledForNetwork(), this.mConfig.getExperiments().isDecodeCancellationEnabled(), this.mConfig.getExecutorSupplier(), this.mConfig.getPoolFactory().getPooledByteBufferFactory(this.mConfig.getMemoryChunkType()), getBitmapMemoryCache(), getEncodedMemoryCache(), getMainBufferedDiskCache(), getSmallImageBufferedDiskCache(), this.mConfig.getCacheKeyFactory(), getPlatformBitmapFactory(), this.mConfig.getExperiments().getBitmapPrepareToDrawMinSizeBytes(), this.mConfig.getExperiments().getBitmapPrepareToDrawMaxSizeBytes(), this.mConfig.getExperiments().getBitmapPrepareToDrawForPrefetch(), this.mConfig.getExperiments().getMaxBitmapSize(), getCloseableReferenceFactory(), this.mConfig.getExperiments().shouldKeepCancelledFetchAsLowPriority());
        }
        return this.mProducerFactory;
    }

    private ProducerSequenceFactory getProducerSequenceFactory() {
        boolean z = VERSION.SDK_INT >= 24 && this.mConfig.getExperiments().getUseBitmapPrepareToDraw();
        if (this.mProducerSequenceFactory == null) {
            ProducerSequenceFactory producerSequenceFactory = new ProducerSequenceFactory(this.mConfig.getContext().getApplicationContext().getContentResolver(), getProducerFactory(), this.mConfig.getNetworkFetcher(), this.mConfig.isResizeAndRotateEnabledForNetwork(), this.mConfig.getExperiments().isWebpSupportEnabled(), this.mThreadHandoffProducerQueue, this.mConfig.isDownsampleEnabled(), z, this.mConfig.getExperiments().isPartialImageCachingEnabled(), this.mConfig.isDiskCacheEnabled(), getImageTranscoderFactory());
            this.mProducerSequenceFactory = producerSequenceFactory;
        }
        return this.mProducerSequenceFactory;
    }

    private BufferedDiskCache getSmallImageBufferedDiskCache() {
        if (this.mSmallImageBufferedDiskCache == null) {
            BufferedDiskCache bufferedDiskCache = new BufferedDiskCache(getSmallImageFileCache(), this.mConfig.getPoolFactory().getPooledByteBufferFactory(this.mConfig.getMemoryChunkType()), this.mConfig.getPoolFactory().getPooledByteStreams(), this.mConfig.getExecutorSupplier().forLocalStorageRead(), this.mConfig.getExecutorSupplier().forLocalStorageWrite(), this.mConfig.getImageCacheStatsTracker());
            this.mSmallImageBufferedDiskCache = bufferedDiskCache;
        }
        return this.mSmallImageBufferedDiskCache;
    }

    public static synchronized boolean hasBeenInitialized() {
        boolean z;
        synchronized (ImagePipelineFactory.class) {
            z = sInstance != null;
        }
        return z;
    }

    public static synchronized void initialize(Context context) {
        synchronized (ImagePipelineFactory.class) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ImagePipelineFactory#initialize");
            }
            initialize(ImagePipelineConfig.newBuilder(context).build());
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    public static void setInstance(ImagePipelineFactory imagePipelineFactory) {
        sInstance = imagePipelineFactory;
    }

    public static synchronized void shutDown() {
        synchronized (ImagePipelineFactory.class) {
            if (sInstance != null) {
                sInstance.getBitmapMemoryCache().removeAll(new AndroidPredicates$1());
                sInstance.getEncodedMemoryCache().removeAll(new AndroidPredicates$1());
                sInstance = null;
            }
        }
    }

    public DrawableFactory getAnimatedDrawableFactory(Context context) {
        AnimatedFactory animatedFactory = getAnimatedFactory();
        if (animatedFactory == null) {
            return null;
        }
        return animatedFactory.getAnimatedDrawableFactory(context);
    }

    public CountingMemoryCache<CacheKey, CloseableImage> getBitmapCountingMemoryCache() {
        if (this.mBitmapCountingMemoryCache == null) {
            this.mBitmapCountingMemoryCache = BitmapCountingMemoryCacheFactory.get(this.mConfig.getBitmapMemoryCacheParamsSupplier(), this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getBitmapMemoryCacheTrimStrategy());
        }
        return this.mBitmapCountingMemoryCache;
    }

    public InstrumentedMemoryCache<CacheKey, CloseableImage> getBitmapMemoryCache() {
        MemoryCache memoryCache;
        if (this.mBitmapMemoryCache == null) {
            if (this.mConfig.getBitmapCacheOverride() != null) {
                memoryCache = this.mConfig.getBitmapCacheOverride();
            } else {
                memoryCache = getBitmapCountingMemoryCache();
            }
            this.mBitmapMemoryCache = BitmapMemoryCacheFactory.get(memoryCache, this.mConfig.getImageCacheStatsTracker());
        }
        return this.mBitmapMemoryCache;
    }

    public CloseableReferenceFactory getCloseableReferenceFactory() {
        return this.mCloseableReferenceFactory;
    }

    public CountingMemoryCache<CacheKey, PooledByteBuffer> getEncodedCountingMemoryCache() {
        if (this.mEncodedCountingMemoryCache == null) {
            this.mEncodedCountingMemoryCache = EncodedCountingMemoryCacheFactory.get(this.mConfig.getEncodedMemoryCacheParamsSupplier(), this.mConfig.getMemoryTrimmableRegistry());
        }
        return this.mEncodedCountingMemoryCache;
    }

    public InstrumentedMemoryCache<CacheKey, PooledByteBuffer> getEncodedMemoryCache() {
        MemoryCache memoryCache;
        if (this.mEncodedMemoryCache == null) {
            if (this.mConfig.getEncodedMemoryCacheOverride() != null) {
                memoryCache = this.mConfig.getEncodedMemoryCacheOverride();
            } else {
                memoryCache = getEncodedCountingMemoryCache();
            }
            this.mEncodedMemoryCache = EncodedMemoryCacheFactory.get(memoryCache, this.mConfig.getImageCacheStatsTracker());
        }
        return this.mEncodedMemoryCache;
    }

    public ImagePipeline getImagePipeline() {
        if (this.mImagePipeline == null) {
            ImagePipeline imagePipeline = new ImagePipeline(getProducerSequenceFactory(), this.mConfig.getRequestListeners(), this.mConfig.getRequestListener2s(), this.mConfig.getIsPrefetchEnabledSupplier(), getBitmapMemoryCache(), getEncodedMemoryCache(), getMainBufferedDiskCache(), getSmallImageBufferedDiskCache(), this.mConfig.getCacheKeyFactory(), this.mThreadHandoffProducerQueue, this.mConfig.getExperiments().getSuppressBitmapPrefetchingSupplier(), this.mConfig.getExperiments().isLazyDataSource(), this.mConfig.getCallerContextVerifier(), this.mConfig);
            this.mImagePipeline = imagePipeline;
        }
        return this.mImagePipeline;
    }

    public BufferedDiskCache getMainBufferedDiskCache() {
        if (this.mMainBufferedDiskCache == null) {
            BufferedDiskCache bufferedDiskCache = new BufferedDiskCache(getMainFileCache(), this.mConfig.getPoolFactory().getPooledByteBufferFactory(this.mConfig.getMemoryChunkType()), this.mConfig.getPoolFactory().getPooledByteStreams(), this.mConfig.getExecutorSupplier().forLocalStorageRead(), this.mConfig.getExecutorSupplier().forLocalStorageWrite(), this.mConfig.getImageCacheStatsTracker());
            this.mMainBufferedDiskCache = bufferedDiskCache;
        }
        return this.mMainBufferedDiskCache;
    }

    public FileCache getMainFileCache() {
        if (this.mMainFileCache == null) {
            this.mMainFileCache = this.mConfig.getFileCacheFactory().get(this.mConfig.getMainDiskCacheConfig());
        }
        return this.mMainFileCache;
    }

    public PlatformBitmapFactory getPlatformBitmapFactory() {
        if (this.mPlatformBitmapFactory == null) {
            this.mPlatformBitmapFactory = PlatformBitmapFactoryProvider.buildPlatformBitmapFactory(this.mConfig.getPoolFactory(), getPlatformDecoder(), getCloseableReferenceFactory());
        }
        return this.mPlatformBitmapFactory;
    }

    public PlatformDecoder getPlatformDecoder() {
        if (this.mPlatformDecoder == null) {
            this.mPlatformDecoder = PlatformDecoderFactory.buildPlatformDecoder(this.mConfig.getPoolFactory(), this.mConfig.getExperiments().isGingerbreadDecoderEnabled());
        }
        return this.mPlatformDecoder;
    }

    public FileCache getSmallImageFileCache() {
        if (this.mSmallImageFileCache == null) {
            this.mSmallImageFileCache = this.mConfig.getFileCacheFactory().get(this.mConfig.getSmallImageDiskCacheConfig());
        }
        return this.mSmallImageFileCache;
    }

    public String reportData() {
        Objects$ToStringHelper objects$ToStringHelper = new Objects$ToStringHelper("ImagePipelineFactory", null);
        objects$ToStringHelper.addHolder("bitmapCountingMemoryCache", this.mBitmapCountingMemoryCache.reportData());
        objects$ToStringHelper.addHolder("encodedCountingMemoryCache", this.mEncodedCountingMemoryCache.reportData());
        return objects$ToStringHelper.toString();
    }

    public static synchronized void initialize(ImagePipelineConfig imagePipelineConfig) {
        synchronized (ImagePipelineFactory.class) {
            if (sInstance != null) {
                FLog.w(TAG, (String) "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            sInstance = new ImagePipelineFactory(imagePipelineConfig);
        }
    }
}
