package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.backends.pipeline.info.ImagePerfDataListener;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.components.DeferredReleaserConcurrentImpl;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.Set;

public class PipelineDraweeControllerBuilderSupplier implements Supplier<PipelineDraweeControllerBuilder> {
    public final Set<ControllerListener> mBoundControllerListeners;
    public final Context mContext;
    public final ImagePerfDataListener mDefaultImagePerfDataListener;
    public final ImagePipeline mImagePipeline;
    public final PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;

    public PipelineDraweeControllerBuilderSupplier(Context context) {
        DeferredReleaser deferredReleaser;
        ImagePipelineFactory instance = ImagePipelineFactory.getInstance();
        this.mContext = context;
        this.mImagePipeline = instance.getImagePipeline();
        PipelineDraweeControllerFactory pipelineDraweeControllerFactory = new PipelineDraweeControllerFactory();
        this.mPipelineDraweeControllerFactory = pipelineDraweeControllerFactory;
        Resources resources = context.getResources();
        synchronized (DeferredReleaser.class) {
            if (DeferredReleaser.sInstance == null) {
                DeferredReleaser.sInstance = new DeferredReleaserConcurrentImpl();
            }
            deferredReleaser = DeferredReleaser.sInstance;
        }
        DrawableFactory animatedDrawableFactory = instance.getAnimatedDrawableFactory(context);
        if (UiThreadImmediateExecutorService.sInstance == null) {
            UiThreadImmediateExecutorService.sInstance = new UiThreadImmediateExecutorService();
        }
        UiThreadImmediateExecutorService uiThreadImmediateExecutorService = UiThreadImmediateExecutorService.sInstance;
        MemoryCache<CacheKey, CloseableImage> bitmapMemoryCache = this.mImagePipeline.getBitmapMemoryCache();
        pipelineDraweeControllerFactory.mResources = resources;
        pipelineDraweeControllerFactory.mDeferredReleaser = deferredReleaser;
        pipelineDraweeControllerFactory.mAnimatedDrawableFactory = animatedDrawableFactory;
        pipelineDraweeControllerFactory.mUiThreadExecutor = uiThreadImmediateExecutorService;
        pipelineDraweeControllerFactory.mMemoryCache = bitmapMemoryCache;
        pipelineDraweeControllerFactory.mDrawableFactories = null;
        pipelineDraweeControllerFactory.mDebugOverlayEnabledSupplier = null;
        this.mBoundControllerListeners = null;
        this.mDefaultImagePerfDataListener = null;
    }

    public Object get() {
        PipelineDraweeControllerBuilder pipelineDraweeControllerBuilder = new PipelineDraweeControllerBuilder(this.mContext, this.mPipelineDraweeControllerFactory, this.mImagePipeline, this.mBoundControllerListeners);
        pipelineDraweeControllerBuilder.mImagePerfDataListener = this.mDefaultImagePerfDataListener;
        return pipelineDraweeControllerBuilder;
    }
}
