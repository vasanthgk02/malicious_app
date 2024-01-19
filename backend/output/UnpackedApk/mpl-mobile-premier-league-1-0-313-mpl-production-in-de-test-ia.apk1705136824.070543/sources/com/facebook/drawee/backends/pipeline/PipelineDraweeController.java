package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Objects$ToStringHelper;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.time.AwakeTimeSinceBootClock;
import com.facebook.datasource.DataSource;
import com.facebook.drawable.base.DrawableWithCaches;
import com.facebook.drawee.backends.pipeline.debug.DebugOverlayImageOriginColor;
import com.facebook.drawee.backends.pipeline.debug.DebugOverlayImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ForwardingImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.drawee.backends.pipeline.info.ImagePerfDataListener;
import com.facebook.drawee.backends.pipeline.info.ImagePerfMonitor;
import com.facebook.drawee.backends.pipeline.info.ImagePerfState;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
import com.facebook.drawee.debug.listener.ImageLoadingTimeControllerListener;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.Executor;

public class PipelineDraweeController extends AbstractDraweeController<CloseableReference<CloseableImage>, ImageInfo> {
    public static final Class<?> TAG = PipelineDraweeController.class;
    public CacheKey mCacheKey;
    public ImmutableList<DrawableFactory> mCustomDrawableFactories;
    public Supplier<DataSource<CloseableReference<CloseableImage>>> mDataSourceSupplier;
    public DebugOverlayImageOriginListener mDebugOverlayImageOriginListener;
    public final DrawableFactory mDefaultDrawableFactory;
    public boolean mDrawDebugOverlay;
    public final ImmutableList<DrawableFactory> mGlobalDrawableFactories;
    public ImageOriginListener mImageOriginListener;
    public ImagePerfMonitor mImagePerfMonitor;
    public final MemoryCache<CacheKey, CloseableImage> mMemoryCache;
    public Set<RequestListener> mRequestListeners;

    public PipelineDraweeController(Resources resources, DeferredReleaser deferredReleaser, DrawableFactory drawableFactory, Executor executor, MemoryCache<CacheKey, CloseableImage> memoryCache, ImmutableList<DrawableFactory> immutableList) {
        super(deferredReleaser, executor, null, null);
        this.mDefaultDrawableFactory = new DefaultDrawableFactory(resources, drawableFactory);
        this.mGlobalDrawableFactories = immutableList;
        this.mMemoryCache = memoryCache;
    }

    public synchronized void addImageOriginListener(ImageOriginListener imageOriginListener) {
        if (this.mImageOriginListener instanceof ForwardingImageOriginListener) {
            ForwardingImageOriginListener forwardingImageOriginListener = (ForwardingImageOriginListener) this.mImageOriginListener;
            synchronized (forwardingImageOriginListener) {
                forwardingImageOriginListener.mImageOriginListeners.add(imageOriginListener);
            }
        } else if (this.mImageOriginListener != null) {
            this.mImageOriginListener = new ForwardingImageOriginListener(this.mImageOriginListener, imageOriginListener);
        } else {
            this.mImageOriginListener = imageOriginListener;
        }
    }

    public synchronized void addRequestListener(RequestListener requestListener) {
        if (this.mRequestListeners == null) {
            this.mRequestListeners = new HashSet();
        }
        this.mRequestListeners.add(requestListener);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing() != false) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004a, code lost:
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing() != false) goto L_0x002b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.drawable.Drawable createDrawable(java.lang.Object r4) {
        /*
            r3 = this;
            com.facebook.common.references.CloseableReference r4 = (com.facebook.common.references.CloseableReference) r4
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()     // Catch:{ all -> 0x0065 }
            if (r0 == 0) goto L_0x000d
            java.lang.String r0 = "PipelineDraweeController#createDrawable"
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection(r0)     // Catch:{ all -> 0x0065 }
        L_0x000d:
            boolean r0 = com.facebook.common.references.CloseableReference.isValid(r4)     // Catch:{ all -> 0x0065 }
            co.hyperverge.hypersnapsdk.c.k.checkState(r0)     // Catch:{ all -> 0x0065 }
            java.lang.Object r4 = r4.get()     // Catch:{ all -> 0x0065 }
            com.facebook.imagepipeline.image.CloseableImage r4 = (com.facebook.imagepipeline.image.CloseableImage) r4     // Catch:{ all -> 0x0065 }
            r3.maybeUpdateDebugOverlay(r4)     // Catch:{ all -> 0x0065 }
            com.facebook.common.internal.ImmutableList<com.facebook.imagepipeline.drawable.DrawableFactory> r0 = r3.mCustomDrawableFactories     // Catch:{ all -> 0x0065 }
            android.graphics.drawable.Drawable r0 = r3.maybeCreateDrawableFromFactories(r0, r4)     // Catch:{ all -> 0x0065 }
            if (r0 == 0) goto L_0x002f
            boolean r4 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r4 == 0) goto L_0x004d
        L_0x002b:
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
            goto L_0x004d
        L_0x002f:
            com.facebook.common.internal.ImmutableList<com.facebook.imagepipeline.drawable.DrawableFactory> r0 = r3.mGlobalDrawableFactories     // Catch:{ all -> 0x0065 }
            android.graphics.drawable.Drawable r0 = r3.maybeCreateDrawableFromFactories(r0, r4)     // Catch:{ all -> 0x0065 }
            if (r0 == 0) goto L_0x003e
            boolean r4 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r4 == 0) goto L_0x004d
            goto L_0x002b
        L_0x003e:
            com.facebook.imagepipeline.drawable.DrawableFactory r0 = r3.mDefaultDrawableFactory     // Catch:{ all -> 0x0065 }
            android.graphics.drawable.Drawable r0 = r0.createDrawable(r4)     // Catch:{ all -> 0x0065 }
            if (r0 == 0) goto L_0x004e
            boolean r4 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r4 == 0) goto L_0x004d
            goto L_0x002b
        L_0x004d:
            return r0
        L_0x004e:
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException     // Catch:{ all -> 0x0065 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0065 }
            r1.<init>()     // Catch:{ all -> 0x0065 }
            java.lang.String r2 = "Unrecognized image class: "
            r1.append(r2)     // Catch:{ all -> 0x0065 }
            r1.append(r4)     // Catch:{ all -> 0x0065 }
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x0065 }
            r0.<init>(r4)     // Catch:{ all -> 0x0065 }
            throw r0     // Catch:{ all -> 0x0065 }
        L_0x0065:
            r4 = move-exception
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r0 == 0) goto L_0x006f
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x006f:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.backends.pipeline.PipelineDraweeController.createDrawable(java.lang.Object):android.graphics.drawable.Drawable");
    }

    public int getImageHash(Object obj) {
        CloseableReference closeableReference = (CloseableReference) obj;
        if (closeableReference == null || !closeableReference.isValid()) {
            return 0;
        }
        return System.identityHashCode(closeableReference.mSharedReference.get());
    }

    public Object getImageInfo(Object obj) {
        CloseableReference closeableReference = (CloseableReference) obj;
        k.checkState(CloseableReference.isValid(closeableReference));
        return (ImageInfo) closeableReference.get();
    }

    public void initialize(Supplier<DataSource<CloseableReference<CloseableImage>>> supplier, String str, CacheKey cacheKey, Object obj, ImmutableList<DrawableFactory> immutableList, ImageOriginListener imageOriginListener) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("PipelineDraweeController#initialize");
        }
        init(str, obj);
        this.mJustConstructed = false;
        this.mDataSourceSupplier = supplier;
        maybeUpdateDebugOverlay(null);
        this.mCacheKey = cacheKey;
        this.mCustomDrawableFactories = null;
        synchronized (this) {
            this.mImageOriginListener = null;
        }
        maybeUpdateDebugOverlay(null);
        addImageOriginListener(null);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    public synchronized void initializePerformanceMonitoring(ImagePerfDataListener imagePerfDataListener, AbstractDraweeControllerBuilder<PipelineDraweeControllerBuilder, ImageRequest, CloseableReference<CloseableImage>, ImageInfo> abstractDraweeControllerBuilder) {
        if (this.mImagePerfMonitor != null) {
            this.mImagePerfMonitor.reset();
        }
        if (imagePerfDataListener != null) {
            if (this.mImagePerfMonitor == null) {
                this.mImagePerfMonitor = new ImagePerfMonitor(AwakeTimeSinceBootClock.get(), this);
            }
            ImagePerfMonitor imagePerfMonitor = this.mImagePerfMonitor;
            if (imagePerfMonitor != null) {
                if (imagePerfMonitor.mImagePerfDataListeners == null) {
                    imagePerfMonitor.mImagePerfDataListeners = new LinkedList();
                }
                imagePerfMonitor.mImagePerfDataListeners.add(imagePerfDataListener);
                this.mImagePerfMonitor.setEnabled(true);
                ImagePerfState imagePerfState = this.mImagePerfMonitor.mImagePerfState;
                imagePerfState.mControllerImageRequest = (ImageRequest) abstractDraweeControllerBuilder.mImageRequest;
                imagePerfState.mControllerLowResImageRequest = (ImageRequest) abstractDraweeControllerBuilder.mLowResImageRequest;
                imagePerfState.mControllerFirstAvailableImageRequests = (ImageRequest[]) abstractDraweeControllerBuilder.mMultiImageRequests;
            } else {
                throw null;
            }
        }
    }

    public final Drawable maybeCreateDrawableFromFactories(ImmutableList<DrawableFactory> immutableList, CloseableImage closeableImage) {
        if (immutableList == null) {
            return null;
        }
        Iterator it = immutableList.iterator();
        while (it.hasNext()) {
            DrawableFactory drawableFactory = (DrawableFactory) it.next();
            if (drawableFactory.supportsImageType(closeableImage)) {
                Drawable createDrawable = drawableFactory.createDrawable(closeableImage);
                if (createDrawable != null) {
                    return createDrawable;
                }
            }
        }
        return null;
    }

    public final void maybeUpdateDebugOverlay(CloseableImage closeableImage) {
        int i;
        if (this.mDrawDebugOverlay) {
            if (this.mControllerOverlay == null) {
                DebugControllerOverlayDrawable debugControllerOverlayDrawable = new DebugControllerOverlayDrawable();
                ImageLoadingTimeControllerListener imageLoadingTimeControllerListener = new ImageLoadingTimeControllerListener(debugControllerOverlayDrawable);
                this.mDebugOverlayImageOriginListener = new DebugOverlayImageOriginListener();
                addControllerListener(imageLoadingTimeControllerListener);
                this.mControllerOverlay = debugControllerOverlayDrawable;
                SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
                if (settableDraweeHierarchy != null) {
                    settableDraweeHierarchy.setControllerOverlay(debugControllerOverlayDrawable);
                }
            }
            if (this.mImageOriginListener == null) {
                addImageOriginListener(this.mDebugOverlayImageOriginListener);
            }
            Drawable drawable = this.mControllerOverlay;
            if (drawable instanceof DebugControllerOverlayDrawable) {
                DebugControllerOverlayDrawable debugControllerOverlayDrawable2 = (DebugControllerOverlayDrawable) drawable;
                String str = this.mId;
                if (str == null) {
                    str = "none";
                }
                debugControllerOverlayDrawable2.mControllerId = str;
                debugControllerOverlayDrawable2.invalidateSelf();
                SettableDraweeHierarchy settableDraweeHierarchy2 = this.mSettableDraweeHierarchy;
                ScalingUtils$ScaleType scalingUtils$ScaleType = null;
                if (settableDraweeHierarchy2 != null) {
                    ScaleTypeDrawable activeScaleTypeDrawable = ImageOriginUtils.getActiveScaleTypeDrawable(settableDraweeHierarchy2.getTopLevelDrawable());
                    if (activeScaleTypeDrawable != null) {
                        scalingUtils$ScaleType = activeScaleTypeDrawable.mScaleType;
                    }
                }
                debugControllerOverlayDrawable2.mScaleType = scalingUtils$ScaleType;
                int i2 = this.mDebugOverlayImageOriginListener.mImageOrigin;
                String str2 = i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? i2 != 6 ? "unknown" : "local" : "memory_bitmap" : "memory_encoded" : "disk" : "network";
                Integer num = DebugOverlayImageOriginColor.IMAGE_ORIGIN_COLOR_MAP.get(Integer.valueOf(i2));
                if (num == null) {
                    i = -1;
                } else {
                    i = num.intValue();
                }
                debugControllerOverlayDrawable2.mOriginText = str2;
                debugControllerOverlayDrawable2.mOriginColor = i;
                debugControllerOverlayDrawable2.invalidateSelf();
                if (closeableImage != null) {
                    int width = closeableImage.getWidth();
                    int height = closeableImage.getHeight();
                    debugControllerOverlayDrawable2.mWidthPx = width;
                    debugControllerOverlayDrawable2.mHeightPx = height;
                    debugControllerOverlayDrawable2.invalidateSelf();
                    debugControllerOverlayDrawable2.mImageSizeBytes = closeableImage.getSizeInBytes();
                } else {
                    debugControllerOverlayDrawable2.reset();
                }
            }
        }
    }

    public void releaseDrawable(Drawable drawable) {
        if (drawable instanceof DrawableWithCaches) {
            ((DrawableWithCaches) drawable).dropCaches();
        }
    }

    public void setHierarchy(DraweeHierarchy draweeHierarchy) {
        super.setHierarchy(draweeHierarchy);
        maybeUpdateDebugOverlay(null);
    }

    public String toString() {
        Objects$ToStringHelper stringHelper = k.toStringHelper(this);
        stringHelper.addHolder("super", super.toString());
        stringHelper.addHolder("dataSourceSupplier", this.mDataSourceSupplier);
        return stringHelper.toString();
    }
}
