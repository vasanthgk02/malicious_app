package com.facebook.drawee.backends.pipeline.info;

import android.graphics.Rect;
import com.facebook.common.time.MonotonicClock;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.backends.pipeline.info.internal.ImagePerfControllerListener;
import com.facebook.drawee.backends.pipeline.info.internal.ImagePerfImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.internal.ImagePerfRequestListener;
import com.facebook.drawee.controller.AbstractDraweeController.InternalForwardingListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import java.util.List;

public class ImagePerfMonitor {
    public boolean mEnabled;
    public ForwardingRequestListener mForwardingRequestListener;
    public ImageOriginListener mImageOriginListener;
    public ImageOriginRequestListener mImageOriginRequestListener;
    public ImagePerfControllerListener mImagePerfControllerListener;
    public List<ImagePerfDataListener> mImagePerfDataListeners;
    public ImagePerfRequestListener mImagePerfRequestListener;
    public final ImagePerfState mImagePerfState = new ImagePerfState();
    public final MonotonicClock mMonotonicClock;
    public final PipelineDraweeController mPipelineDraweeController;

    public ImagePerfMonitor(MonotonicClock monotonicClock, PipelineDraweeController pipelineDraweeController) {
        this.mMonotonicClock = monotonicClock;
        this.mPipelineDraweeController = pipelineDraweeController;
    }

    public void notifyListenersOfVisibilityStateUpdate(ImagePerfState imagePerfState, int i) {
        if (this.mEnabled) {
            List<ImagePerfDataListener> list = this.mImagePerfDataListeners;
            if (list != null && !list.isEmpty()) {
                ImagePerfData snapshot = imagePerfState.snapshot();
                for (ImagePerfDataListener onImageVisibilityUpdated : this.mImagePerfDataListeners) {
                    onImageVisibilityUpdated.onImageVisibilityUpdated(snapshot, i);
                }
            }
        }
    }

    public void notifyStatusUpdated(ImagePerfState imagePerfState, int i) {
        imagePerfState.mImageLoadStatus = i;
        if (this.mEnabled) {
            List<ImagePerfDataListener> list = this.mImagePerfDataListeners;
            if (list != null && !list.isEmpty()) {
                if (i == 3) {
                    SettableDraweeHierarchy settableDraweeHierarchy = this.mPipelineDraweeController.mSettableDraweeHierarchy;
                    if (!(settableDraweeHierarchy == null || settableDraweeHierarchy.getTopLevelDrawable() == null)) {
                        Rect bounds = settableDraweeHierarchy.getTopLevelDrawable().getBounds();
                        this.mImagePerfState.mOnScreenWidthPx = bounds.width();
                        this.mImagePerfState.mOnScreenHeightPx = bounds.height();
                    }
                }
                ImagePerfData snapshot = imagePerfState.snapshot();
                for (ImagePerfDataListener onImageLoadStatusUpdated : this.mImagePerfDataListeners) {
                    onImageLoadStatusUpdated.onImageLoadStatusUpdated(snapshot, i);
                }
            }
        }
    }

    public void reset() {
        List<ImagePerfDataListener> list = this.mImagePerfDataListeners;
        if (list != null) {
            list.clear();
        }
        setEnabled(false);
        ImagePerfState imagePerfState = this.mImagePerfState;
        imagePerfState.mRequestId = null;
        imagePerfState.mImageRequest = null;
        imagePerfState.mCallerContext = null;
        imagePerfState.mImageInfo = null;
        imagePerfState.mControllerImageRequest = null;
        imagePerfState.mControllerLowResImageRequest = null;
        imagePerfState.mControllerFirstAvailableImageRequests = null;
        imagePerfState.mImageOrigin = 1;
        imagePerfState.mUltimateProducerName = null;
        imagePerfState.mIsPrefetch = false;
        imagePerfState.mOnScreenWidthPx = -1;
        imagePerfState.mOnScreenHeightPx = -1;
        imagePerfState.mErrorThrowable = null;
        imagePerfState.mImageLoadStatus = -1;
        imagePerfState.mVisibilityState = -1;
        imagePerfState.mComponentTag = null;
        imagePerfState.mDimensionsInfo = null;
        imagePerfState.resetPointsTimestamps();
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
        if (z) {
            if (this.mImagePerfControllerListener == null) {
                this.mImagePerfControllerListener = new ImagePerfControllerListener(this.mMonotonicClock, this.mImagePerfState, this);
            }
            if (this.mImagePerfRequestListener == null) {
                this.mImagePerfRequestListener = new ImagePerfRequestListener(this.mMonotonicClock, this.mImagePerfState);
            }
            if (this.mImageOriginListener == null) {
                this.mImageOriginListener = new ImagePerfImageOriginListener(this.mImagePerfState, this);
            }
            ImageOriginRequestListener imageOriginRequestListener = this.mImageOriginRequestListener;
            if (imageOriginRequestListener == null) {
                this.mImageOriginRequestListener = new ImageOriginRequestListener(this.mPipelineDraweeController.mId, this.mImageOriginListener);
            } else {
                imageOriginRequestListener.mControllerId = this.mPipelineDraweeController.mId;
            }
            if (this.mForwardingRequestListener == null) {
                this.mForwardingRequestListener = new ForwardingRequestListener(this.mImagePerfRequestListener, this.mImageOriginRequestListener);
            }
            ImageOriginListener imageOriginListener = this.mImageOriginListener;
            if (imageOriginListener != null) {
                this.mPipelineDraweeController.addImageOriginListener(imageOriginListener);
            }
            ImagePerfControllerListener imagePerfControllerListener = this.mImagePerfControllerListener;
            if (imagePerfControllerListener != null) {
                this.mPipelineDraweeController.addControllerListener(imagePerfControllerListener);
            }
            ForwardingRequestListener forwardingRequestListener = this.mForwardingRequestListener;
            if (forwardingRequestListener != null) {
                this.mPipelineDraweeController.addRequestListener(forwardingRequestListener);
                return;
            }
            return;
        }
        ImageOriginListener imageOriginListener2 = this.mImageOriginListener;
        if (imageOriginListener2 != null) {
            PipelineDraweeController pipelineDraweeController = this.mPipelineDraweeController;
            synchronized (pipelineDraweeController) {
                if (pipelineDraweeController.mImageOriginListener instanceof ForwardingImageOriginListener) {
                    ForwardingImageOriginListener forwardingImageOriginListener = (ForwardingImageOriginListener) pipelineDraweeController.mImageOriginListener;
                    synchronized (forwardingImageOriginListener) {
                        forwardingImageOriginListener.mImageOriginListeners.remove(imageOriginListener2);
                    }
                } else if (pipelineDraweeController.mImageOriginListener == imageOriginListener2) {
                    pipelineDraweeController.mImageOriginListener = null;
                }
            }
        }
        ImagePerfControllerListener imagePerfControllerListener2 = this.mImagePerfControllerListener;
        if (imagePerfControllerListener2 != null) {
            PipelineDraweeController pipelineDraweeController2 = this.mPipelineDraweeController;
            if (imagePerfControllerListener2 != null) {
                ControllerListener<INFO> controllerListener = pipelineDraweeController2.mControllerListener;
                if (controllerListener instanceof InternalForwardingListener) {
                    InternalForwardingListener internalForwardingListener = (InternalForwardingListener) controllerListener;
                    synchronized (internalForwardingListener) {
                        int indexOf = internalForwardingListener.mListeners.indexOf(imagePerfControllerListener2);
                        if (indexOf != -1) {
                            internalForwardingListener.mListeners.set(indexOf, null);
                        }
                    }
                } else if (controllerListener == imagePerfControllerListener2) {
                    pipelineDraweeController2.mControllerListener = null;
                }
            } else {
                throw null;
            }
        }
        ForwardingRequestListener forwardingRequestListener2 = this.mForwardingRequestListener;
        if (forwardingRequestListener2 != null) {
            PipelineDraweeController pipelineDraweeController3 = this.mPipelineDraweeController;
            synchronized (pipelineDraweeController3) {
                if (pipelineDraweeController3.mRequestListeners != null) {
                    pipelineDraweeController3.mRequestListeners.remove(forwardingRequestListener2);
                }
            }
        }
    }
}
