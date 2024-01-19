package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;

public class EncodedCacheKeyMultiplexProducer extends MultiplexProducer<Pair<CacheKey, RequestLevel>, EncodedImage> {
    public final CacheKeyFactory mCacheKeyFactory;

    public EncodedCacheKeyMultiplexProducer(CacheKeyFactory cacheKeyFactory, boolean z, Producer producer) {
        super(producer, "EncodedCacheKeyMultiplexProducer", z);
        this.mCacheKeyFactory = cacheKeyFactory;
    }

    public EncodedImage cloneOrNull(EncodedImage encodedImage) {
        return EncodedImage.cloneOrNull(encodedImage);
    }

    public Pair<CacheKey, RequestLevel> getKey(ProducerContext producerContext) {
        return Pair.create(this.mCacheKeyFactory.getEncodedCacheKey(producerContext.getImageRequest(), producerContext.getCallerContext()), producerContext.getLowestPermittedRequestLevel());
    }
}
