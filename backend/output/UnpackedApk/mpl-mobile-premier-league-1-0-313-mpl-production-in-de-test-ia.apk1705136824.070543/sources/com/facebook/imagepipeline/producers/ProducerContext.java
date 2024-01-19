package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.image.EncodedImageOrigin;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;

public interface ProducerContext {

    public @interface ExtraKeys {
        public static final int ORIGIN = 1;
    }

    void addCallbacks(ProducerContextCallbacks producerContextCallbacks);

    Object getCallerContext();

    EncodedImageOrigin getEncodedImageOrigin();

    String getExtra(@ExtraKeys int i);

    String getId();

    ImagePipelineConfig getImagePipelineConfig();

    ImageRequest getImageRequest();

    RequestLevel getLowestPermittedRequestLevel();

    Priority getPriority();

    ProducerListener2 getProducerListener();

    String getUiComponentId();

    boolean isIntermediateResultExpected();

    boolean isPrefetch();

    void setEncodedImageOrigin(EncodedImageOrigin encodedImageOrigin);

    void setExtra(@ExtraKeys int i, String str);
}
