package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Map;
import org.apache.pdfbox.pdfparser.BaseParser;

public class BitmapMemoryCacheProducer implements Producer<CloseableReference<CloseableImage>> {
    public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
    public static final String PRODUCER_NAME = "BitmapMemoryCacheProducer";
    public final CacheKeyFactory mCacheKeyFactory;
    public final Producer<CloseableReference<CloseableImage>> mInputProducer;
    public final MemoryCache<CacheKey, CloseableImage> mMemoryCache;

    public BitmapMemoryCacheProducer(MemoryCache<CacheKey, CloseableImage> memoryCache, CacheKeyFactory cacheKeyFactory, Producer<CloseableReference<CloseableImage>> producer) {
        this.mMemoryCache = memoryCache;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
    }

    public String getProducerName() {
        return PRODUCER_NAME;
    }

    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("BitmapMemoryCacheProducer#produceResults");
            }
            ProducerListener2 producerListener = producerContext.getProducerListener();
            producerListener.onProducerStart(producerContext, getProducerName());
            CacheKey bitmapCacheKey = this.mCacheKeyFactory.getBitmapCacheKey(producerContext.getImageRequest(), producerContext.getCallerContext());
            CloseableReference closeableReference = this.mMemoryCache.get(bitmapCacheKey);
            Map map = null;
            if (closeableReference != null) {
                boolean isOfFullQuality = ((CloseableImage) closeableReference.get()).getQualityInfo().isOfFullQuality();
                if (isOfFullQuality) {
                    producerListener.onProducerFinishWithSuccess(producerContext, getProducerName(), producerListener.requiresExtraMap(producerContext, getProducerName()) ? ImmutableMap.of("cached_value_found", BaseParser.TRUE) : null);
                    producerListener.onUltimateProducerReached(producerContext, getProducerName(), true);
                    producerContext.setExtra(1, "memory_bitmap");
                    consumer.onProgressUpdate(1.0f);
                }
                consumer.onNewResult(closeableReference, BaseConsumer.simpleStatusForIsLast(isOfFullQuality));
                closeableReference.close();
                if (isOfFullQuality) {
                    return;
                }
            }
            if (producerContext.getLowestPermittedRequestLevel().getValue() >= RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
                producerListener.onProducerFinishWithSuccess(producerContext, getProducerName(), producerListener.requiresExtraMap(producerContext, getProducerName()) ? ImmutableMap.of("cached_value_found", BaseParser.FALSE) : null);
                producerListener.onUltimateProducerReached(producerContext, getProducerName(), false);
                producerContext.setExtra(1, "memory_bitmap");
                consumer.onNewResult(null, 1);
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return;
            }
            Consumer<CloseableReference<CloseableImage>> wrapConsumer = wrapConsumer(consumer, bitmapCacheKey, producerContext.getImageRequest().isMemoryCacheEnabled());
            String producerName = getProducerName();
            if (producerListener.requiresExtraMap(producerContext, getProducerName())) {
                map = ImmutableMap.of("cached_value_found", BaseParser.FALSE);
            }
            producerListener.onProducerFinishWithSuccess(producerContext, producerName, map);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("mInputProducer.produceResult");
            }
            this.mInputProducer.produceResults(wrapConsumer, producerContext);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    public Consumer<CloseableReference<CloseableImage>> wrapConsumer(Consumer<CloseableReference<CloseableImage>> consumer, final CacheKey cacheKey, final boolean z) {
        return new DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>>(consumer) {
            public void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, int i) {
                CloseableReference<CloseableImage> closeableReference2;
                CloseableReference closeableReference3;
                try {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.beginSection("BitmapMemoryCacheProducer#onNewResultImpl");
                    }
                    boolean isLast = BaseConsumer.isLast(i);
                    closeableReference2 = null;
                    if (closeableReference == null) {
                        if (isLast) {
                            getConsumer().onNewResult(null, i);
                        }
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                        }
                        return;
                    }
                    if (!((CloseableImage) closeableReference.get()).isStateful()) {
                        if (!BaseConsumer.statusHasFlag(i, 8)) {
                            if (!isLast) {
                                closeableReference3 = BitmapMemoryCacheProducer.this.mMemoryCache.get(cacheKey);
                                if (closeableReference3 != null) {
                                    QualityInfo qualityInfo = ((CloseableImage) closeableReference.get()).getQualityInfo();
                                    QualityInfo qualityInfo2 = ((CloseableImage) closeableReference3.get()).getQualityInfo();
                                    if (qualityInfo2.isOfFullQuality() || qualityInfo2.getQuality() >= qualityInfo.getQuality()) {
                                        getConsumer().onNewResult(closeableReference3, i);
                                        closeableReference3.close();
                                        if (FrescoSystrace.isTracing()) {
                                            FrescoSystrace.endSection();
                                        }
                                        return;
                                    }
                                    closeableReference3.close();
                                }
                            }
                            if (z) {
                                closeableReference2 = BitmapMemoryCacheProducer.this.mMemoryCache.cache(cacheKey, closeableReference);
                            }
                            if (isLast) {
                                getConsumer().onProgressUpdate(1.0f);
                            }
                            Consumer consumer = getConsumer();
                            if (closeableReference2 != null) {
                                closeableReference = closeableReference2;
                            }
                            consumer.onNewResult(closeableReference, i);
                            if (closeableReference2 != null) {
                                closeableReference2.close();
                            }
                            if (FrescoSystrace.isTracing()) {
                                FrescoSystrace.endSection();
                            }
                            return;
                        }
                    }
                    getConsumer().onNewResult(closeableReference, i);
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                } catch (Throwable th) {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                    throw th;
                }
            }
        };
    }
}
