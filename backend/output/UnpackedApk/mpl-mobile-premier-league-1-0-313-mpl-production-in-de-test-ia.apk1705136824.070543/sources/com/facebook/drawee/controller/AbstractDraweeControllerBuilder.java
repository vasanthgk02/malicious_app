package com.facebook.drawee.controller;

import android.content.Context;
import android.graphics.drawable.Animatable;
import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects$ToStringHelper;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources$1;
import com.facebook.datasource.FirstAvailableDataSourceSupplier;
import com.facebook.datasource.IncreasingQualityDataSourceSupplier;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerFactory;
import com.facebook.drawee.components.RetryManager;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.gestures.GestureDetector;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

public abstract class AbstractDraweeControllerBuilder<BUILDER extends AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> implements SimpleDraweeControllerBuilder {
    public static final NullPointerException NO_REQUEST_EXCEPTION = new NullPointerException("No image request was specified!");
    public static final ControllerListener<Object> sAutoPlayAnimationsListener = new BaseControllerListener<Object>() {
        public void onFinalImageSet(String str, Object obj, Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    public static final AtomicLong sIdCounter = new AtomicLong();
    public boolean mAutoPlayAnimations;
    public final Set<ControllerListener> mBoundControllerListeners;
    public Object mCallerContext;
    public String mContentDescription;
    public final Context mContext;
    public ControllerListener<? super INFO> mControllerListener;
    public ControllerViewportVisibilityListener mControllerViewportVisibilityListener;
    public REQUEST mImageRequest;
    public REQUEST mLowResImageRequest;
    public REQUEST[] mMultiImageRequests;
    public DraweeController mOldController;
    public boolean mTapToRetryEnabled;
    public boolean mTryCacheOnlyFirst;

    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    public AbstractDraweeControllerBuilder(Context context, Set<ControllerListener> set) {
        this.mContext = context;
        this.mBoundControllerListeners = set;
        init();
    }

    public AbstractDraweeController build() {
        PipelineDraweeController pipelineDraweeController;
        k.checkState(this.mMultiImageRequests == null || this.mImageRequest == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        k.checkState(true, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
        CacheKey cacheKey = null;
        if (this.mImageRequest == null && this.mMultiImageRequests == null) {
            REQUEST request = this.mLowResImageRequest;
            if (request != null) {
                this.mImageRequest = request;
                this.mLowResImageRequest = null;
            }
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("AbstractDraweeControllerBuilder#buildController");
        }
        PipelineDraweeControllerBuilder pipelineDraweeControllerBuilder = (PipelineDraweeControllerBuilder) this;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("PipelineDraweeControllerBuilder#obtainController");
        }
        try {
            DraweeController draweeController = pipelineDraweeControllerBuilder.mOldController;
            String valueOf = String.valueOf(sIdCounter.getAndIncrement());
            if (draweeController instanceof PipelineDraweeController) {
                pipelineDraweeController = (PipelineDraweeController) draweeController;
            } else {
                PipelineDraweeControllerFactory pipelineDraweeControllerFactory = pipelineDraweeControllerBuilder.mPipelineDraweeControllerFactory;
                PipelineDraweeController pipelineDraweeController2 = new PipelineDraweeController(pipelineDraweeControllerFactory.mResources, pipelineDraweeControllerFactory.mDeferredReleaser, pipelineDraweeControllerFactory.mAnimatedDrawableFactory, pipelineDraweeControllerFactory.mUiThreadExecutor, pipelineDraweeControllerFactory.mMemoryCache, pipelineDraweeControllerFactory.mDrawableFactories);
                Supplier<Boolean> supplier = pipelineDraweeControllerFactory.mDebugOverlayEnabledSupplier;
                if (supplier != null) {
                    pipelineDraweeController2.mDrawDebugOverlay = ((Boolean) supplier.get()).booleanValue();
                }
                pipelineDraweeController = pipelineDraweeController2;
            }
            Supplier obtainDataSourceSupplier = pipelineDraweeControllerBuilder.obtainDataSourceSupplier(pipelineDraweeController, valueOf);
            ImageRequest imageRequest = (ImageRequest) pipelineDraweeControllerBuilder.mImageRequest;
            CacheKeyFactory cacheKeyFactory = pipelineDraweeControllerBuilder.mImagePipeline.getCacheKeyFactory();
            if (!(cacheKeyFactory == null || imageRequest == null)) {
                cacheKey = imageRequest.getPostprocessor() != null ? cacheKeyFactory.getPostprocessedBitmapCacheKey(imageRequest, pipelineDraweeControllerBuilder.mCallerContext) : cacheKeyFactory.getBitmapCacheKey(imageRequest, pipelineDraweeControllerBuilder.mCallerContext);
            }
            pipelineDraweeController.initialize(obtainDataSourceSupplier, valueOf, cacheKey, pipelineDraweeControllerBuilder.mCallerContext, null, null);
            pipelineDraweeController.initializePerformanceMonitoring(pipelineDraweeControllerBuilder.mImagePerfDataListener, pipelineDraweeControllerBuilder);
            pipelineDraweeController.mRetainImageOnFailure = false;
            pipelineDraweeController.mContentDescription = this.mContentDescription;
            if (this.mTapToRetryEnabled) {
                if (pipelineDraweeController.mRetryManager == null) {
                    pipelineDraweeController.mRetryManager = new RetryManager();
                }
                pipelineDraweeController.mRetryManager.mTapToRetryEnabled = this.mTapToRetryEnabled;
                if (pipelineDraweeController.mGestureDetector == null) {
                    GestureDetector gestureDetector = new GestureDetector(this.mContext);
                    pipelineDraweeController.mGestureDetector = gestureDetector;
                    gestureDetector.mClickListener = pipelineDraweeController;
                }
            }
            Set<ControllerListener> set = this.mBoundControllerListeners;
            if (set != null) {
                for (ControllerListener addControllerListener : set) {
                    pipelineDraweeController.addControllerListener(addControllerListener);
                }
            }
            ControllerListener<? super INFO> controllerListener = this.mControllerListener;
            if (controllerListener != null) {
                pipelineDraweeController.addControllerListener(controllerListener);
            }
            if (this.mAutoPlayAnimations) {
                pipelineDraweeController.addControllerListener(sAutoPlayAnimationsListener);
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            return pipelineDraweeController;
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    public Supplier<DataSource<IMAGE>> getDataSourceSupplierForRequest(DraweeController draweeController, String str, REQUEST request) {
        final CacheLevel cacheLevel = CacheLevel.FULL_FETCH;
        final Object obj = this.mCallerContext;
        final DraweeController draweeController2 = draweeController;
        final String str2 = str;
        final REQUEST request2 = request;
        AnonymousClass2 r0 = new Supplier<DataSource<IMAGE>>() {
            /* JADX WARNING: type inference failed for: r5v0 */
            /* JADX WARNING: type inference failed for: r1v1 */
            /* JADX WARNING: type inference failed for: r6v2, types: [com.facebook.imagepipeline.listener.RequestListener] */
            /* JADX WARNING: type inference failed for: r5v2 */
            /* JADX WARNING: type inference failed for: r1v2 */
            /* JADX WARNING: type inference failed for: r5v3, types: [com.facebook.imagepipeline.listener.RequestListener] */
            /* JADX WARNING: type inference failed for: r1v4 */
            /* JADX WARNING: type inference failed for: r3v6, types: [com.facebook.drawee.backends.pipeline.info.ImageOriginRequestListener] */
            /* JADX WARNING: type inference failed for: r5v5 */
            /* JADX WARNING: Multi-variable type inference failed */
            /* JADX WARNING: Unknown variable types count: 2 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object get() {
                /*
                    r9 = this;
                    com.facebook.drawee.controller.AbstractDraweeControllerBuilder r0 = com.facebook.drawee.controller.AbstractDraweeControllerBuilder.this
                    com.facebook.drawee.interfaces.DraweeController r1 = r8
                    java.lang.String r7 = r9
                    java.lang.Object r2 = r10
                    java.lang.Object r4 = r11
                    com.facebook.drawee.controller.AbstractDraweeControllerBuilder$CacheLevel r3 = r12
                    com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder r0 = (com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder) r0
                    r5 = 0
                    if (r0 == 0) goto L_0x007c
                    r6 = r2
                    com.facebook.imagepipeline.request.ImageRequest r6 = (com.facebook.imagepipeline.request.ImageRequest) r6
                    com.facebook.imagepipeline.core.ImagePipeline r2 = r0.mImagePipeline
                    int r0 = r3.ordinal()
                    if (r0 == 0) goto L_0x0044
                    r8 = 1
                    if (r0 == r8) goto L_0x0041
                    r8 = 2
                    if (r0 != r8) goto L_0x0025
                    com.facebook.imagepipeline.request.ImageRequest$RequestLevel r0 = com.facebook.imagepipeline.request.ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE
                    goto L_0x0046
                L_0x0025:
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r2 = "Cache level"
                    r1.append(r2)
                    r1.append(r3)
                    java.lang.String r2 = "is not supported. "
                    r1.append(r2)
                    java.lang.String r1 = r1.toString()
                    r0.<init>(r1)
                    throw r0
                L_0x0041:
                    com.facebook.imagepipeline.request.ImageRequest$RequestLevel r0 = com.facebook.imagepipeline.request.ImageRequest.RequestLevel.DISK_CACHE
                    goto L_0x0046
                L_0x0044:
                    com.facebook.imagepipeline.request.ImageRequest$RequestLevel r0 = com.facebook.imagepipeline.request.ImageRequest.RequestLevel.FULL_FETCH
                L_0x0046:
                    boolean r3 = r1 instanceof com.facebook.drawee.backends.pipeline.PipelineDraweeController
                    if (r3 == 0) goto L_0x0073
                    com.facebook.drawee.backends.pipeline.PipelineDraweeController r1 = (com.facebook.drawee.backends.pipeline.PipelineDraweeController) r1
                    monitor-enter(r1)
                    com.facebook.drawee.backends.pipeline.info.ImageOriginListener r3 = r1.mImageOriginListener     // Catch:{ all -> 0x0070 }
                    if (r3 == 0) goto L_0x005b
                    com.facebook.drawee.backends.pipeline.info.ImageOriginRequestListener r3 = new com.facebook.drawee.backends.pipeline.info.ImageOriginRequestListener     // Catch:{ all -> 0x0070 }
                    java.lang.String r5 = r1.mId     // Catch:{ all -> 0x0070 }
                    com.facebook.drawee.backends.pipeline.info.ImageOriginListener r8 = r1.mImageOriginListener     // Catch:{ all -> 0x0070 }
                    r3.<init>(r5, r8)     // Catch:{ all -> 0x0070 }
                    r5 = r3
                L_0x005b:
                    java.util.Set<com.facebook.imagepipeline.listener.RequestListener> r3 = r1.mRequestListeners     // Catch:{ all -> 0x0070 }
                    if (r3 == 0) goto L_0x006e
                    com.facebook.imagepipeline.listener.ForwardingRequestListener r3 = new com.facebook.imagepipeline.listener.ForwardingRequestListener     // Catch:{ all -> 0x0070 }
                    java.util.Set<com.facebook.imagepipeline.listener.RequestListener> r8 = r1.mRequestListeners     // Catch:{ all -> 0x0070 }
                    r3.<init>(r8)     // Catch:{ all -> 0x0070 }
                    if (r5 == 0) goto L_0x006b
                    r3.addRequestListener(r5)     // Catch:{ all -> 0x0070 }
                L_0x006b:
                    monitor-exit(r1)
                    r1 = r3
                    goto L_0x0074
                L_0x006e:
                    monitor-exit(r1)
                    goto L_0x0073
                L_0x0070:
                    r0 = move-exception
                    monitor-exit(r1)
                    throw r0
                L_0x0073:
                    r1 = r5
                L_0x0074:
                    r3 = r6
                    r5 = r0
                    r6 = r1
                    com.facebook.datasource.DataSource r0 = r2.fetchDecodedImage(r3, r4, r5, r6, r7)
                    return r0
                L_0x007c:
                    throw r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.AnonymousClass2.get():java.lang.Object");
            }

            public String toString() {
                Objects$ToStringHelper stringHelper = k.toStringHelper(this);
                stringHelper.addHolder("request", r10.toString());
                return stringHelper.toString();
            }
        };
        return r0;
    }

    public final void init() {
        this.mCallerContext = null;
        this.mImageRequest = null;
        this.mLowResImageRequest = null;
        this.mMultiImageRequests = null;
        this.mTryCacheOnlyFirst = true;
        this.mControllerListener = null;
        this.mControllerViewportVisibilityListener = null;
        this.mTapToRetryEnabled = false;
        this.mAutoPlayAnimations = false;
        this.mOldController = null;
        this.mContentDescription = null;
    }

    public Supplier<DataSource<IMAGE>> obtainDataSourceSupplier(DraweeController draweeController, String str) {
        Supplier<DataSource<IMAGE>> supplier;
        REQUEST request = this.mImageRequest;
        if (request != null) {
            supplier = getDataSourceSupplierForRequest(draweeController, str, request);
        } else {
            REQUEST[] requestArr = this.mMultiImageRequests;
            if (requestArr != null) {
                boolean z = this.mTryCacheOnlyFirst;
                ArrayList arrayList = new ArrayList(requestArr.length * 2);
                if (z) {
                    for (final REQUEST request2 : requestArr) {
                        final CacheLevel cacheLevel = CacheLevel.BITMAP_MEMORY_CACHE;
                        final Object obj = this.mCallerContext;
                        final DraweeController draweeController2 = draweeController;
                        final String str2 = str;
                        AnonymousClass2 r6 = new Supplier<DataSource<IMAGE>>() {
                            /* JADX WARNING: type inference failed for: r5v0 */
                            /* JADX WARNING: type inference failed for: r1v1 */
                            /* JADX WARNING: type inference failed for: r6v2, types: [com.facebook.imagepipeline.listener.RequestListener] */
                            /* JADX WARNING: type inference failed for: r5v2 */
                            /* JADX WARNING: type inference failed for: r1v2 */
                            /* JADX WARNING: type inference failed for: r5v3, types: [com.facebook.imagepipeline.listener.RequestListener] */
                            /* JADX WARNING: type inference failed for: r1v4 */
                            /* JADX WARNING: type inference failed for: r3v6, types: [com.facebook.drawee.backends.pipeline.info.ImageOriginRequestListener] */
                            /* JADX WARNING: type inference failed for: r5v5 */
                            /* JADX WARNING: Multi-variable type inference failed */
                            /* JADX WARNING: Unknown variable types count: 2 */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public java.lang.Object get() {
                                /*
                                    r9 = this;
                                    com.facebook.drawee.controller.AbstractDraweeControllerBuilder r0 = com.facebook.drawee.controller.AbstractDraweeControllerBuilder.this
                                    com.facebook.drawee.interfaces.DraweeController r1 = r8
                                    java.lang.String r7 = r9
                                    java.lang.Object r2 = r10
                                    java.lang.Object r4 = r11
                                    com.facebook.drawee.controller.AbstractDraweeControllerBuilder$CacheLevel r3 = r12
                                    com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder r0 = (com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder) r0
                                    r5 = 0
                                    if (r0 == 0) goto L_0x007c
                                    r6 = r2
                                    com.facebook.imagepipeline.request.ImageRequest r6 = (com.facebook.imagepipeline.request.ImageRequest) r6
                                    com.facebook.imagepipeline.core.ImagePipeline r2 = r0.mImagePipeline
                                    int r0 = r3.ordinal()
                                    if (r0 == 0) goto L_0x0044
                                    r8 = 1
                                    if (r0 == r8) goto L_0x0041
                                    r8 = 2
                                    if (r0 != r8) goto L_0x0025
                                    com.facebook.imagepipeline.request.ImageRequest$RequestLevel r0 = com.facebook.imagepipeline.request.ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE
                                    goto L_0x0046
                                L_0x0025:
                                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                                    r1.<init>()
                                    java.lang.String r2 = "Cache level"
                                    r1.append(r2)
                                    r1.append(r3)
                                    java.lang.String r2 = "is not supported. "
                                    r1.append(r2)
                                    java.lang.String r1 = r1.toString()
                                    r0.<init>(r1)
                                    throw r0
                                L_0x0041:
                                    com.facebook.imagepipeline.request.ImageRequest$RequestLevel r0 = com.facebook.imagepipeline.request.ImageRequest.RequestLevel.DISK_CACHE
                                    goto L_0x0046
                                L_0x0044:
                                    com.facebook.imagepipeline.request.ImageRequest$RequestLevel r0 = com.facebook.imagepipeline.request.ImageRequest.RequestLevel.FULL_FETCH
                                L_0x0046:
                                    boolean r3 = r1 instanceof com.facebook.drawee.backends.pipeline.PipelineDraweeController
                                    if (r3 == 0) goto L_0x0073
                                    com.facebook.drawee.backends.pipeline.PipelineDraweeController r1 = (com.facebook.drawee.backends.pipeline.PipelineDraweeController) r1
                                    monitor-enter(r1)
                                    com.facebook.drawee.backends.pipeline.info.ImageOriginListener r3 = r1.mImageOriginListener     // Catch:{ all -> 0x0070 }
                                    if (r3 == 0) goto L_0x005b
                                    com.facebook.drawee.backends.pipeline.info.ImageOriginRequestListener r3 = new com.facebook.drawee.backends.pipeline.info.ImageOriginRequestListener     // Catch:{ all -> 0x0070 }
                                    java.lang.String r5 = r1.mId     // Catch:{ all -> 0x0070 }
                                    com.facebook.drawee.backends.pipeline.info.ImageOriginListener r8 = r1.mImageOriginListener     // Catch:{ all -> 0x0070 }
                                    r3.<init>(r5, r8)     // Catch:{ all -> 0x0070 }
                                    r5 = r3
                                L_0x005b:
                                    java.util.Set<com.facebook.imagepipeline.listener.RequestListener> r3 = r1.mRequestListeners     // Catch:{ all -> 0x0070 }
                                    if (r3 == 0) goto L_0x006e
                                    com.facebook.imagepipeline.listener.ForwardingRequestListener r3 = new com.facebook.imagepipeline.listener.ForwardingRequestListener     // Catch:{ all -> 0x0070 }
                                    java.util.Set<com.facebook.imagepipeline.listener.RequestListener> r8 = r1.mRequestListeners     // Catch:{ all -> 0x0070 }
                                    r3.<init>(r8)     // Catch:{ all -> 0x0070 }
                                    if (r5 == 0) goto L_0x006b
                                    r3.addRequestListener(r5)     // Catch:{ all -> 0x0070 }
                                L_0x006b:
                                    monitor-exit(r1)
                                    r1 = r3
                                    goto L_0x0074
                                L_0x006e:
                                    monitor-exit(r1)
                                    goto L_0x0073
                                L_0x0070:
                                    r0 = move-exception
                                    monitor-exit(r1)
                                    throw r0
                                L_0x0073:
                                    r1 = r5
                                L_0x0074:
                                    r3 = r6
                                    r5 = r0
                                    r6 = r1
                                    com.facebook.datasource.DataSource r0 = r2.fetchDecodedImage(r3, r4, r5, r6, r7)
                                    return r0
                                L_0x007c:
                                    throw r5
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.controller.AbstractDraweeControllerBuilder.AnonymousClass2.get():java.lang.Object");
                            }

                            public String toString() {
                                Objects$ToStringHelper stringHelper = k.toStringHelper(this);
                                stringHelper.addHolder("request", request2.toString());
                                return stringHelper.toString();
                            }
                        };
                        arrayList.add(r6);
                    }
                }
                for (REQUEST dataSourceSupplierForRequest : requestArr) {
                    arrayList.add(getDataSourceSupplierForRequest(draweeController, str, dataSourceSupplierForRequest));
                }
                supplier = new FirstAvailableDataSourceSupplier<>(arrayList);
            } else {
                supplier = null;
            }
        }
        if (!(supplier == null || this.mLowResImageRequest == null)) {
            ArrayList arrayList2 = new ArrayList(2);
            arrayList2.add(supplier);
            arrayList2.add(getDataSourceSupplierForRequest(draweeController, str, this.mLowResImageRequest));
            supplier = new IncreasingQualityDataSourceSupplier<>(arrayList2, false);
        }
        return supplier == null ? new DataSources$1(NO_REQUEST_EXCEPTION) : supplier;
    }
}
