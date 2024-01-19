package com.facebook.imagepipeline.producers;

import android.util.SparseArray;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.image.EncodedImageOrigin;
import com.facebook.imagepipeline.producers.ProducerContext.ExtraKeys;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import java.util.ArrayList;
import java.util.List;

public class BaseProducerContext implements ProducerContext {
    public final List<ProducerContextCallbacks> mCallbacks;
    public final Object mCallerContext;
    public EncodedImageOrigin mEncodedImageOrigin;
    public final SparseArray<String> mExtras;
    public final String mId;
    public final ImagePipelineConfig mImagePipelineConfig;
    public final ImageRequest mImageRequest;
    public boolean mIsCancelled;
    public boolean mIsIntermediateResultExpected;
    public boolean mIsPrefetch;
    public final RequestLevel mLowestPermittedRequestLevel;
    public Priority mPriority;
    public final ProducerListener2 mProducerListener;
    public final String mUiComponentId;

    public BaseProducerContext(ImageRequest imageRequest, String str, ProducerListener2 producerListener2, Object obj, RequestLevel requestLevel, boolean z, boolean z2, Priority priority, ImagePipelineConfig imagePipelineConfig) {
        this(imageRequest, str, null, producerListener2, obj, requestLevel, z, z2, priority, imagePipelineConfig);
    }

    public static void callOnCancellationRequested(List<ProducerContextCallbacks> list) {
        if (list != null) {
            for (ProducerContextCallbacks onCancellationRequested : list) {
                onCancellationRequested.onCancellationRequested();
            }
        }
    }

    public static void callOnIsIntermediateResultExpectedChanged(List<ProducerContextCallbacks> list) {
        if (list != null) {
            for (ProducerContextCallbacks onIsIntermediateResultExpectedChanged : list) {
                onIsIntermediateResultExpectedChanged.onIsIntermediateResultExpectedChanged();
            }
        }
    }

    public static void callOnIsPrefetchChanged(List<ProducerContextCallbacks> list) {
        if (list != null) {
            for (ProducerContextCallbacks onIsPrefetchChanged : list) {
                onIsPrefetchChanged.onIsPrefetchChanged();
            }
        }
    }

    public static void callOnPriorityChanged(List<ProducerContextCallbacks> list) {
        if (list != null) {
            for (ProducerContextCallbacks onPriorityChanged : list) {
                onPriorityChanged.onPriorityChanged();
            }
        }
    }

    public void addCallbacks(ProducerContextCallbacks producerContextCallbacks) {
        boolean z;
        synchronized (this) {
            this.mCallbacks.add(producerContextCallbacks);
            z = this.mIsCancelled;
        }
        if (z) {
            producerContextCallbacks.onCancellationRequested();
        }
    }

    public void cancel() {
        callOnCancellationRequested(cancelNoCallbacks());
    }

    public synchronized List<ProducerContextCallbacks> cancelNoCallbacks() {
        if (this.mIsCancelled) {
            return null;
        }
        this.mIsCancelled = true;
        return new ArrayList(this.mCallbacks);
    }

    public Object getCallerContext() {
        return this.mCallerContext;
    }

    public EncodedImageOrigin getEncodedImageOrigin() {
        return this.mEncodedImageOrigin;
    }

    public String getExtra(int i) {
        return this.mExtras.get(i, "");
    }

    public String getId() {
        return this.mId;
    }

    public ImagePipelineConfig getImagePipelineConfig() {
        return this.mImagePipelineConfig;
    }

    public ImageRequest getImageRequest() {
        return this.mImageRequest;
    }

    public RequestLevel getLowestPermittedRequestLevel() {
        return this.mLowestPermittedRequestLevel;
    }

    public synchronized Priority getPriority() {
        return this.mPriority;
    }

    public ProducerListener2 getProducerListener() {
        return this.mProducerListener;
    }

    public String getUiComponentId() {
        return this.mUiComponentId;
    }

    public synchronized boolean isCancelled() {
        return this.mIsCancelled;
    }

    public synchronized boolean isIntermediateResultExpected() {
        return this.mIsIntermediateResultExpected;
    }

    public synchronized boolean isPrefetch() {
        return this.mIsPrefetch;
    }

    public void setEncodedImageOrigin(EncodedImageOrigin encodedImageOrigin) {
        this.mEncodedImageOrigin = encodedImageOrigin;
    }

    public void setExtra(@ExtraKeys int i, String str) {
        this.mExtras.put(i, str);
    }

    public synchronized List<ProducerContextCallbacks> setIsIntermediateResultExpectedNoCallbacks(boolean z) {
        try {
            if (z == this.mIsIntermediateResultExpected) {
                return null;
            }
            this.mIsIntermediateResultExpected = z;
            return new ArrayList(this.mCallbacks);
        }
    }

    public synchronized List<ProducerContextCallbacks> setIsPrefetchNoCallbacks(boolean z) {
        try {
            if (z == this.mIsPrefetch) {
                return null;
            }
            this.mIsPrefetch = z;
            return new ArrayList(this.mCallbacks);
        }
    }

    public synchronized List<ProducerContextCallbacks> setPriorityNoCallbacks(Priority priority) {
        try {
            if (priority == this.mPriority) {
                return null;
            }
            this.mPriority = priority;
            return new ArrayList(this.mCallbacks);
        }
    }

    public BaseProducerContext(ImageRequest imageRequest, String str, String str2, ProducerListener2 producerListener2, Object obj, RequestLevel requestLevel, boolean z, boolean z2, Priority priority, ImagePipelineConfig imagePipelineConfig) {
        this.mExtras = new SparseArray<>();
        this.mEncodedImageOrigin = EncodedImageOrigin.NOT_SET;
        this.mImageRequest = imageRequest;
        this.mId = str;
        this.mUiComponentId = str2;
        this.mProducerListener = producerListener2;
        this.mCallerContext = obj;
        this.mLowestPermittedRequestLevel = requestLevel;
        this.mIsPrefetch = z;
        this.mPriority = priority;
        this.mIsIntermediateResultExpected = z2;
        this.mIsCancelled = false;
        this.mCallbacks = new ArrayList();
        this.mImagePipelineConfig = imagePipelineConfig;
    }
}
