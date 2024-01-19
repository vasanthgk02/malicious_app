package com.facebook.drawee.backends.pipeline.info;

import com.facebook.fresco.ui.common.DimensionsInfo;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;

public class ImagePerfState {
    public Object mCallerContext;
    public String mComponentTag;
    public long mControllerCancelTimeMs = -1;
    public long mControllerFailureTimeMs = -1;
    public long mControllerFinalImageSetTimeMs = -1;
    public ImageRequest[] mControllerFirstAvailableImageRequests;
    public String mControllerId;
    public ImageRequest mControllerImageRequest;
    public long mControllerIntermediateImageSetTimeMs = -1;
    public ImageRequest mControllerLowResImageRequest;
    public long mControllerSubmitTimeMs = -1;
    public DimensionsInfo mDimensionsInfo;
    public Throwable mErrorThrowable;
    public long mImageDrawTimeMs = -1;
    public ImageInfo mImageInfo;
    public int mImageLoadStatus = -1;
    public int mImageOrigin = 1;
    public ImageRequest mImageRequest;
    public long mImageRequestEndTimeMs = -1;
    public long mImageRequestStartTimeMs = -1;
    public long mInvisibilityEventTimeMs = -1;
    public boolean mIsPrefetch;
    public int mOnScreenHeightPx = -1;
    public int mOnScreenWidthPx = -1;
    public String mRequestId;
    public String mUltimateProducerName;
    public long mVisibilityEventTimeMs = -1;
    public int mVisibilityState = -1;

    public void resetPointsTimestamps() {
        this.mImageRequestStartTimeMs = -1;
        this.mImageRequestEndTimeMs = -1;
        this.mControllerSubmitTimeMs = -1;
        this.mControllerFinalImageSetTimeMs = -1;
        this.mControllerFailureTimeMs = -1;
        this.mControllerCancelTimeMs = -1;
        this.mVisibilityEventTimeMs = -1;
        this.mInvisibilityEventTimeMs = -1;
        this.mImageDrawTimeMs = -1;
    }

    public ImagePerfData snapshot() {
        ImagePerfData imagePerfData = new ImagePerfData(this.mControllerId, this.mRequestId, this.mImageRequest, this.mCallerContext, this.mImageInfo, this.mControllerImageRequest, this.mControllerLowResImageRequest, this.mControllerFirstAvailableImageRequests, this.mControllerSubmitTimeMs, this.mControllerIntermediateImageSetTimeMs, this.mControllerFinalImageSetTimeMs, this.mControllerFailureTimeMs, this.mControllerCancelTimeMs, this.mImageRequestStartTimeMs, this.mImageRequestEndTimeMs, this.mImageOrigin, this.mUltimateProducerName, this.mIsPrefetch, this.mOnScreenWidthPx, this.mOnScreenHeightPx, this.mErrorThrowable, this.mVisibilityState, this.mVisibilityEventTimeMs, this.mInvisibilityEventTimeMs, this.mComponentTag, this.mImageDrawTimeMs);
        return imagePerfData;
    }
}
