package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.common.internal.Objects$ToStringHelper;
import com.facebook.common.logging.FLog;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.components.DeferredReleaser.Releasable;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.components.DraweeEventTracker.Event;
import com.facebook.drawee.components.RetryManager;
import com.facebook.drawee.gestures.GestureDetector;
import com.facebook.drawee.gestures.GestureDetector.ClickListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.concurrent.Executor;

public abstract class AbstractDraweeController<T, INFO> implements DraweeController, Releasable, ClickListener {
    public static final Class<?> TAG = AbstractDraweeController.class;
    public Object mCallerContext;
    public String mContentDescription;
    public ControllerListener<INFO> mControllerListener;
    public Drawable mControllerOverlay;
    public DataSource<T> mDataSource;
    public final DeferredReleaser mDeferredReleaser;
    public Drawable mDrawable;
    public final DraweeEventTracker mEventTracker;
    public T mFetchedImage;
    public GestureDetector mGestureDetector;
    public boolean mHasFetchFailed;
    public String mId;
    public boolean mIsAttached;
    public boolean mIsRequestSubmitted;
    public boolean mJustConstructed;
    public boolean mRetainImageOnFailure;
    public RetryManager mRetryManager;
    public SettableDraweeHierarchy mSettableDraweeHierarchy;
    public final Executor mUiThreadImmediateExecutor;

    public static class InternalForwardingListener<INFO> extends ForwardingControllerListener<INFO> {
    }

    public AbstractDraweeController(DeferredReleaser deferredReleaser, Executor executor, String str, Object obj) {
        this.mEventTracker = DraweeEventTracker.sEnabled ? new DraweeEventTracker() : DraweeEventTracker.sInstance;
        this.mJustConstructed = true;
        this.mDeferredReleaser = deferredReleaser;
        this.mUiThreadImmediateExecutor = executor;
        init(null, null);
    }

    public void addControllerListener(ControllerListener<? super INFO> controllerListener) {
        if (controllerListener != null) {
            ControllerListener<INFO> controllerListener2 = this.mControllerListener;
            if (controllerListener2 instanceof InternalForwardingListener) {
                ((InternalForwardingListener) controllerListener2).addListener(controllerListener);
            } else if (controllerListener2 != null) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("AbstractDraweeController#createInternal");
                }
                InternalForwardingListener internalForwardingListener = new InternalForwardingListener();
                internalForwardingListener.addListener(controllerListener2);
                internalForwardingListener.addListener(controllerListener);
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                this.mControllerListener = internalForwardingListener;
            } else {
                this.mControllerListener = controllerListener;
            }
        } else {
            throw null;
        }
    }

    public abstract Drawable createDrawable(T t);

    public ControllerListener<INFO> getControllerListener() {
        ControllerListener<INFO> controllerListener = this.mControllerListener;
        return controllerListener == null ? BaseControllerListener.NO_OP_LISTENER : controllerListener;
    }

    public int getImageHash(T t) {
        return System.identityHashCode(t);
    }

    public abstract INFO getImageInfo(T t);

    public final synchronized void init(String str, Object obj) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("AbstractDraweeController#init");
        }
        this.mEventTracker.recordEvent(Event.ON_INIT_CONTROLLER);
        if (!this.mJustConstructed && this.mDeferredReleaser != null) {
            this.mDeferredReleaser.cancelDeferredRelease(this);
        }
        this.mIsAttached = false;
        releaseFetch();
        this.mRetainImageOnFailure = false;
        if (this.mRetryManager != null) {
            RetryManager retryManager = this.mRetryManager;
            retryManager.mTapToRetryEnabled = false;
            retryManager.mMaxTapToRetryAttempts = 4;
            retryManager.mTapToRetryAttempts = 0;
        }
        if (this.mGestureDetector != null) {
            GestureDetector gestureDetector = this.mGestureDetector;
            gestureDetector.mClickListener = null;
            gestureDetector.mIsCapturingGesture = false;
            gestureDetector.mIsClickCandidate = false;
            this.mGestureDetector.mClickListener = this;
        }
        if (this.mControllerListener instanceof InternalForwardingListener) {
            InternalForwardingListener internalForwardingListener = (InternalForwardingListener) this.mControllerListener;
            synchronized (internalForwardingListener) {
                internalForwardingListener.mListeners.clear();
            }
        } else {
            this.mControllerListener = null;
        }
        if (this.mSettableDraweeHierarchy != null) {
            this.mSettableDraweeHierarchy.reset();
            this.mSettableDraweeHierarchy.setControllerOverlay(null);
            this.mSettableDraweeHierarchy = null;
        }
        this.mControllerOverlay = null;
        if (FLog.isLoggable(2)) {
            FLog.v(TAG, (String) "controller %x %s -> %s: initialize", (Object) Integer.valueOf(System.identityHashCode(this)), (Object) this.mId, (Object) str);
        }
        this.mId = str;
        this.mCallerContext = obj;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    public final boolean isExpectedDataSource(String str, DataSource<T> dataSource) {
        boolean z = true;
        if (dataSource == null && this.mDataSource == null) {
            return true;
        }
        if (!str.equals(this.mId) || dataSource != this.mDataSource || !this.mIsRequestSubmitted) {
            z = false;
        }
        return z;
    }

    public final void logMessageAndFailure(String str, Throwable th) {
        if (FLog.isLoggable(2)) {
            FLog.v(TAG, (String) "controller %x %s: %s: failure: %s", (Object) Integer.valueOf(System.identityHashCode(this)), (Object) this.mId, (Object) str, (Object) th);
        }
    }

    public final void logMessageAndImage(String str, T t) {
        if (FLog.isLoggable(2)) {
            Class<?> cls = TAG;
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(System.identityHashCode(this));
            objArr[1] = this.mId;
            objArr[2] = str;
            objArr[3] = t != null ? t.getClass().getSimpleName() : "<null>";
            objArr[4] = Integer.valueOf(getImageHash(t));
            if (((FLogDefaultLoggingDelegate) FLog.sHandler).isLoggable(2)) {
                ((FLogDefaultLoggingDelegate) FLog.sHandler).println(2, cls.getSimpleName(), FLog.formatString("controller %x %s: %s: image: %s %x", objArr));
            }
        }
    }

    public final void onFailureInternal(String str, DataSource<T> dataSource, Throwable th, boolean z) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("AbstractDraweeController#onFailureInternal");
        }
        if (!isExpectedDataSource(str, dataSource)) {
            logMessageAndFailure("ignore_old_datasource @ onFailure", th);
            dataSource.close();
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            return;
        }
        this.mEventTracker.recordEvent(z ? Event.ON_DATASOURCE_FAILURE : Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            logMessageAndFailure("final_failed @ onFailure", th);
            this.mDataSource = null;
            this.mHasFetchFailed = true;
            if (this.mRetainImageOnFailure) {
                Drawable drawable = this.mDrawable;
                if (drawable != null) {
                    this.mSettableDraweeHierarchy.setImage(drawable, 1.0f, true);
                    getControllerListener().onFailure(this.mId, th);
                }
            }
            if (shouldRetryOnTap()) {
                this.mSettableDraweeHierarchy.setRetry(th);
            } else {
                this.mSettableDraweeHierarchy.setFailure(th);
            }
            getControllerListener().onFailure(this.mId, th);
        } else {
            logMessageAndFailure("intermediate_failed @ onFailure", th);
            getControllerListener().onIntermediateImageFailed(this.mId, th);
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    public final void onNewResultInternal(String str, DataSource<T> dataSource, T t, float f2, boolean z, boolean z2, boolean z3) {
        Drawable createDrawable;
        T t2;
        Drawable drawable;
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("AbstractDraweeController#onNewResultInternal");
            }
            if (!isExpectedDataSource(str, dataSource)) {
                logMessageAndImage("ignore_old_datasource @ onNewResult", t);
                CloseableReference.closeSafely((CloseableReference) t);
                dataSource.close();
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return;
            }
            this.mEventTracker.recordEvent(z ? Event.ON_DATASOURCE_RESULT : Event.ON_DATASOURCE_RESULT_INT);
            try {
                createDrawable = createDrawable(t);
                t2 = this.mFetchedImage;
                drawable = this.mDrawable;
                this.mFetchedImage = t;
                this.mDrawable = createDrawable;
                Animatable animatable = null;
                if (z) {
                    logMessageAndImage("set_final_result @ onNewResult", t);
                    this.mDataSource = null;
                    this.mSettableDraweeHierarchy.setImage(createDrawable, 1.0f, z2);
                    ControllerListener controllerListener = getControllerListener();
                    Object imageInfo = getImageInfo(t);
                    Drawable drawable2 = this.mDrawable;
                    if (drawable2 instanceof Animatable) {
                        animatable = (Animatable) drawable2;
                    }
                    controllerListener.onFinalImageSet(str, imageInfo, animatable);
                } else if (z3) {
                    logMessageAndImage("set_temporary_result @ onNewResult", t);
                    this.mSettableDraweeHierarchy.setImage(createDrawable, 1.0f, z2);
                    ControllerListener controllerListener2 = getControllerListener();
                    Object imageInfo2 = getImageInfo(t);
                    Drawable drawable3 = this.mDrawable;
                    if (drawable3 instanceof Animatable) {
                        animatable = (Animatable) drawable3;
                    }
                    controllerListener2.onFinalImageSet(str, imageInfo2, animatable);
                } else {
                    logMessageAndImage("set_intermediate_result @ onNewResult", t);
                    this.mSettableDraweeHierarchy.setImage(createDrawable, f2, z2);
                    getControllerListener().onIntermediateImageSet(str, getImageInfo(t));
                }
                if (!(drawable == null || drawable == createDrawable)) {
                    releaseDrawable(drawable);
                }
                if (!(t2 == null || t2 == t)) {
                    logMessageAndImage("release_previous_result @ onNewResult", t2);
                    CloseableReference.closeSafely((CloseableReference) t2);
                }
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            } catch (Exception e2) {
                logMessageAndImage("drawable_failed @ onNewResult", t);
                CloseableReference.closeSafely((CloseableReference) t);
                onFailureInternal(str, dataSource, e2, z);
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
        } catch (Throwable th) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            throw th;
        }
    }

    public void release() {
        this.mEventTracker.recordEvent(Event.ON_RELEASE_CONTROLLER);
        RetryManager retryManager = this.mRetryManager;
        if (retryManager != null) {
            retryManager.mTapToRetryAttempts = 0;
        }
        GestureDetector gestureDetector = this.mGestureDetector;
        if (gestureDetector != null) {
            gestureDetector.mIsCapturingGesture = false;
            gestureDetector.mIsClickCandidate = false;
        }
        SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
        if (settableDraweeHierarchy != null) {
            settableDraweeHierarchy.reset();
        }
        releaseFetch();
    }

    public abstract void releaseDrawable(Drawable drawable);

    public final void releaseFetch() {
        boolean z = this.mIsRequestSubmitted;
        this.mIsRequestSubmitted = false;
        this.mHasFetchFailed = false;
        DataSource<T> dataSource = this.mDataSource;
        if (dataSource != null) {
            dataSource.close();
            this.mDataSource = null;
        }
        Drawable drawable = this.mDrawable;
        if (drawable != null) {
            releaseDrawable(drawable);
        }
        if (this.mContentDescription != null) {
            this.mContentDescription = null;
        }
        this.mDrawable = null;
        T t = this.mFetchedImage;
        if (t != null) {
            logMessageAndImage("release", t);
            CloseableReference.closeSafely((CloseableReference) this.mFetchedImage);
            this.mFetchedImage = null;
        }
        if (z) {
            getControllerListener().onRelease(this.mId);
        }
    }

    public void setHierarchy(DraweeHierarchy draweeHierarchy) {
        if (FLog.isLoggable(2)) {
            FLog.v(TAG, (String) "controller %x %s: setHierarchy: %s", (Object) Integer.valueOf(System.identityHashCode(this)), (Object) this.mId, (Object) draweeHierarchy);
        }
        this.mEventTracker.recordEvent(draweeHierarchy != null ? Event.ON_SET_HIERARCHY : Event.ON_CLEAR_HIERARCHY);
        if (this.mIsRequestSubmitted) {
            this.mDeferredReleaser.cancelDeferredRelease(this);
            release();
        }
        SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
        if (settableDraweeHierarchy != null) {
            settableDraweeHierarchy.setControllerOverlay(null);
            this.mSettableDraweeHierarchy = null;
        }
        if (draweeHierarchy != null) {
            k.checkArgument(draweeHierarchy instanceof SettableDraweeHierarchy);
            SettableDraweeHierarchy settableDraweeHierarchy2 = (SettableDraweeHierarchy) draweeHierarchy;
            this.mSettableDraweeHierarchy = settableDraweeHierarchy2;
            settableDraweeHierarchy2.setControllerOverlay(this.mControllerOverlay);
        }
    }

    public final boolean shouldRetryOnTap() {
        if (this.mHasFetchFailed) {
            RetryManager retryManager = this.mRetryManager;
            if (retryManager != null) {
                if (retryManager.mTapToRetryEnabled && retryManager.mTapToRetryAttempts < retryManager.mMaxTapToRetryAttempts) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0044, code lost:
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing() != false) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005b, code lost:
        r6 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void submitRequest() {
        /*
            r11 = this;
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = "AbstractDraweeController#submitRequest"
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection(r0)
        L_0x000b:
            r0 = r11
            com.facebook.drawee.backends.pipeline.PipelineDraweeController r0 = (com.facebook.drawee.backends.pipeline.PipelineDraweeController) r0
            boolean r1 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r1 == 0) goto L_0x0019
            java.lang.String r1 = "PipelineDraweeController#getCachedImage"
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection(r1)
        L_0x0019:
            com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> r1 = r0.mMemoryCache     // Catch:{ all -> 0x0145 }
            r2 = 0
            if (r1 == 0) goto L_0x0052
            com.facebook.cache.common.CacheKey r1 = r0.mCacheKey     // Catch:{ all -> 0x0145 }
            if (r1 != 0) goto L_0x0023
            goto L_0x0052
        L_0x0023:
            com.facebook.imagepipeline.cache.MemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> r1 = r0.mMemoryCache     // Catch:{ all -> 0x0145 }
            com.facebook.cache.common.CacheKey r3 = r0.mCacheKey     // Catch:{ all -> 0x0145 }
            com.facebook.common.references.CloseableReference r1 = r1.get(r3)     // Catch:{ all -> 0x0145 }
            if (r1 == 0) goto L_0x0047
            java.lang.Object r3 = r1.get()     // Catch:{ all -> 0x0145 }
            com.facebook.imagepipeline.image.CloseableImage r3 = (com.facebook.imagepipeline.image.CloseableImage) r3     // Catch:{ all -> 0x0145 }
            com.facebook.imagepipeline.image.QualityInfo r3 = r3.getQualityInfo()     // Catch:{ all -> 0x0145 }
            boolean r3 = r3.isOfFullQuality()     // Catch:{ all -> 0x0145 }
            if (r3 != 0) goto L_0x0047
            r1.close()     // Catch:{ all -> 0x0145 }
            boolean r1 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r1 == 0) goto L_0x005b
            goto L_0x0058
        L_0x0047:
            boolean r3 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r3 == 0) goto L_0x0050
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x0050:
            r6 = r1
            goto L_0x005c
        L_0x0052:
            boolean r1 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r1 == 0) goto L_0x005b
        L_0x0058:
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x005b:
            r6 = r2
        L_0x005c:
            r1 = 0
            r3 = 1
            if (r6 == 0) goto L_0x00b6
            boolean r4 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r4 == 0) goto L_0x006b
            java.lang.String r4 = "AbstractDraweeController#submitRequest->cache"
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection(r4)
        L_0x006b:
            r11.mDataSource = r2
            r11.mIsRequestSubmitted = r3
            r11.mHasFetchFailed = r1
            com.facebook.drawee.components.DraweeEventTracker r1 = r11.mEventTracker
            com.facebook.drawee.components.DraweeEventTracker$Event r2 = com.facebook.drawee.components.DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT
            r1.recordEvent(r2)
            com.facebook.drawee.controller.ControllerListener r1 = r11.getControllerListener()
            java.lang.String r2 = r11.mId
            java.lang.Object r4 = r11.mCallerContext
            r1.onSubmit(r2, r4)
            java.lang.String r1 = r11.mId
            monitor-enter(r0)
            com.facebook.drawee.backends.pipeline.info.ImageOriginListener r2 = r0.mImageOriginListener     // Catch:{ all -> 0x00b3 }
            if (r2 == 0) goto L_0x0092
            com.facebook.drawee.backends.pipeline.info.ImageOriginListener r2 = r0.mImageOriginListener     // Catch:{ all -> 0x00b3 }
            r4 = 5
            java.lang.String r5 = "PipelineDraweeController"
            r2.onImageLoaded(r1, r4, r3, r5)     // Catch:{ all -> 0x00b3 }
        L_0x0092:
            monitor-exit(r0)     // Catch:{ all -> 0x00b3 }
            java.lang.String r4 = r11.mId
            com.facebook.datasource.DataSource<T> r5 = r11.mDataSource
            r7 = 1065353216(0x3f800000, float:1.0)
            r8 = 1
            r9 = 1
            r10 = 1
            r3 = r11
            r3.onNewResultInternal(r4, r5, r6, r7, r8, r9, r10)
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r0 == 0) goto L_0x00a9
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x00a9:
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r0 == 0) goto L_0x00b2
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x00b2:
            return
        L_0x00b3:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00b3 }
            throw r1
        L_0x00b6:
            com.facebook.drawee.components.DraweeEventTracker r2 = r11.mEventTracker
            com.facebook.drawee.components.DraweeEventTracker$Event r4 = com.facebook.drawee.components.DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT
            r2.recordEvent(r4)
            com.facebook.drawee.controller.ControllerListener r2 = r11.getControllerListener()
            java.lang.String r4 = r11.mId
            java.lang.Object r5 = r11.mCallerContext
            r2.onSubmit(r4, r5)
            com.facebook.drawee.interfaces.SettableDraweeHierarchy r2 = r11.mSettableDraweeHierarchy
            r4 = 0
            r2.setProgress(r4, r3)
            r11.mIsRequestSubmitted = r3
            r11.mHasFetchFailed = r1
            boolean r1 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r1 == 0) goto L_0x00dd
            java.lang.String r1 = "PipelineDraweeController#getDataSource"
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection(r1)
        L_0x00dd:
            r1 = 2
            boolean r2 = com.facebook.common.logging.FLog.isLoggable(r1)
            if (r2 == 0) goto L_0x00f3
            java.lang.Class<?> r2 = com.facebook.drawee.backends.pipeline.PipelineDraweeController.TAG
            int r3 = java.lang.System.identityHashCode(r0)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = "controller %x: getDataSource"
            com.facebook.common.logging.FLog.v(r2, r4, r3)
        L_0x00f3:
            com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>> r0 = r0.mDataSourceSupplier
            java.lang.Object r0 = r0.get()
            com.facebook.datasource.DataSource r0 = (com.facebook.datasource.DataSource) r0
            boolean r2 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r2 == 0) goto L_0x0104
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x0104:
            r11.mDataSource = r0
            boolean r0 = com.facebook.common.logging.FLog.isLoggable(r1)
            if (r0 == 0) goto L_0x0127
            java.lang.Class<?> r0 = TAG
            java.lang.String r1 = "controller %x %s: submitRequest: dataSource: %x"
            int r2 = java.lang.System.identityHashCode(r11)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r3 = r11.mId
            com.facebook.datasource.DataSource<T> r4 = r11.mDataSource
            int r4 = java.lang.System.identityHashCode(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            com.facebook.common.logging.FLog.v(r0, r1, r2, r3, r4)
        L_0x0127:
            java.lang.String r0 = r11.mId
            com.facebook.datasource.DataSource<T> r1 = r11.mDataSource
            boolean r1 = r1.hasResult()
            com.facebook.drawee.controller.AbstractDraweeController$1 r2 = new com.facebook.drawee.controller.AbstractDraweeController$1
            r2.<init>(r0, r1)
            com.facebook.datasource.DataSource<T> r0 = r11.mDataSource
            java.util.concurrent.Executor r1 = r11.mUiThreadImmediateExecutor
            r0.subscribe(r2, r1)
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r0 == 0) goto L_0x0144
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x0144:
            return
        L_0x0145:
            r0 = move-exception
            boolean r1 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r1 == 0) goto L_0x014f
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x014f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.controller.AbstractDraweeController.submitRequest():void");
    }

    public String toString() {
        Objects$ToStringHelper stringHelper = k.toStringHelper(this);
        stringHelper.add((String) "isAttached", this.mIsAttached);
        stringHelper.add((String) "isRequestSubmitted", this.mIsRequestSubmitted);
        stringHelper.add((String) "hasFetchFailed", this.mHasFetchFailed);
        stringHelper.add((String) "fetchedImage", getImageHash(this.mFetchedImage));
        stringHelper.addHolder("events", this.mEventTracker.toString());
        return stringHelper.toString();
    }
}
