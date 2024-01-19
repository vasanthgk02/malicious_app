package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;

public class SettableProducerContext extends BaseProducerContext {
    public SettableProducerContext(ProducerContext producerContext) {
        this(producerContext.getImageRequest(), producerContext.getId(), producerContext.getUiComponentId(), producerContext.getProducerListener(), producerContext.getCallerContext(), producerContext.getLowestPermittedRequestLevel(), producerContext.isPrefetch(), producerContext.isIntermediateResultExpected(), producerContext.getPriority(), producerContext.getImagePipelineConfig());
    }

    public void setIsIntermediateResultExpected(boolean z) {
        BaseProducerContext.callOnIsIntermediateResultExpectedChanged(setIsIntermediateResultExpectedNoCallbacks(z));
    }

    public void setIsPrefetch(boolean z) {
        BaseProducerContext.callOnIsPrefetchChanged(setIsPrefetchNoCallbacks(z));
    }

    public void setPriority(Priority priority) {
        BaseProducerContext.callOnPriorityChanged(setPriorityNoCallbacks(priority));
    }

    public SettableProducerContext(ImageRequest imageRequest, ProducerContext producerContext) {
        this(imageRequest, producerContext.getId(), producerContext.getUiComponentId(), producerContext.getProducerListener(), producerContext.getCallerContext(), producerContext.getLowestPermittedRequestLevel(), producerContext.isPrefetch(), producerContext.isIntermediateResultExpected(), producerContext.getPriority(), producerContext.getImagePipelineConfig());
    }

    public SettableProducerContext(ImageRequest imageRequest, String str, ProducerListener2 producerListener2, Object obj, RequestLevel requestLevel, boolean z, boolean z2, Priority priority, ImagePipelineConfig imagePipelineConfig) {
        super(imageRequest, str, producerListener2, obj, requestLevel, z, z2, priority, imagePipelineConfig);
    }

    public SettableProducerContext(ImageRequest imageRequest, String str, String str2, ProducerListener2 producerListener2, Object obj, RequestLevel requestLevel, boolean z, boolean z2, Priority priority, ImagePipelineConfig imagePipelineConfig) {
        super(imageRequest, str, str2, producerListener2, obj, requestLevel, z, z2, priority, imagePipelineConfig);
    }
}