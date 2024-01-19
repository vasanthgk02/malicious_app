package com.bumptech.glide.request;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.Engine.LoadStatus;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.StateVerifier;
import com.bumptech.glide.util.pool.StateVerifier.DefaultStateVerifier;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import org.apache.fontbox.cmap.CMapParser;

public final class SingleRequest<R> implements Request, SizeReadyCallback, ResourceCallback {
    public static final boolean IS_VERBOSE_LOGGABLE = Log.isLoggable("Request", 2);
    public final TransitionFactory<? super R> animationFactory;
    public final Executor callbackExecutor;
    public final Context context;
    public volatile Engine engine;
    public Drawable errorDrawable;
    public Drawable fallbackDrawable;
    public final GlideContext glideContext;
    public int height;
    public boolean isCallingCallbacks;
    public LoadStatus loadStatus;
    public final Object model;
    public final int overrideHeight;
    public final int overrideWidth;
    public Drawable placeholderDrawable;
    public final Priority priority;
    public final RequestCoordinator requestCoordinator;
    public final List<RequestListener<R>> requestListeners;
    public final Object requestLock;
    public final BaseRequestOptions<?> requestOptions;
    public RuntimeException requestOrigin;
    public Resource<R> resource;
    public long startTime;
    public final StateVerifier stateVerifier;
    public Status status;
    public final String tag;
    public final Target<R> target;
    public final RequestListener<R> targetListener;
    public final Class<R> transcodeClass;
    public int width;

    public enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    public SingleRequest(Context context2, GlideContext glideContext2, Object obj, Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i, int i2, Priority priority2, Target<R> target2, RequestListener<R> requestListener, List<RequestListener<R>> list, RequestCoordinator requestCoordinator2, Engine engine2, TransitionFactory<? super R> transitionFactory, Executor executor) {
        this.tag = IS_VERBOSE_LOGGABLE ? String.valueOf(super.hashCode()) : null;
        this.stateVerifier = new DefaultStateVerifier();
        this.requestLock = obj;
        this.context = context2;
        this.glideContext = glideContext2;
        this.model = obj2;
        this.transcodeClass = cls;
        this.requestOptions = baseRequestOptions;
        this.overrideWidth = i;
        this.overrideHeight = i2;
        this.priority = priority2;
        this.target = target2;
        this.targetListener = requestListener;
        this.requestListeners = list;
        this.requestCoordinator = requestCoordinator2;
        this.engine = engine2;
        this.animationFactory = transitionFactory;
        this.callbackExecutor = executor;
        this.status = Status.PENDING;
        if (this.requestOrigin == null && glideContext2.isLoggingRequestOriginsEnabled()) {
            this.requestOrigin = new RuntimeException("Glide request origin trace");
        }
    }

    public final void assertNotCallingCallbacks() {
        if (this.isCallingCallbacks) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x009b, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0088  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void begin() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.requestLock
            monitor-enter(r0)
            r4.assertNotCallingCallbacks()     // Catch:{ all -> 0x00a4 }
            com.bumptech.glide.util.pool.StateVerifier r1 = r4.stateVerifier     // Catch:{ all -> 0x00a4 }
            r1.throwIfRecycled()     // Catch:{ all -> 0x00a4 }
            long r1 = com.bumptech.glide.util.LogTime.getLogTime()     // Catch:{ all -> 0x00a4 }
            r4.startTime = r1     // Catch:{ all -> 0x00a4 }
            java.lang.Object r1 = r4.model     // Catch:{ all -> 0x00a4 }
            if (r1 != 0) goto L_0x003c
            int r1 = r4.overrideWidth     // Catch:{ all -> 0x00a4 }
            int r2 = r4.overrideHeight     // Catch:{ all -> 0x00a4 }
            boolean r1 = com.bumptech.glide.util.Util.isValidDimensions(r1, r2)     // Catch:{ all -> 0x00a4 }
            if (r1 == 0) goto L_0x0027
            int r1 = r4.overrideWidth     // Catch:{ all -> 0x00a4 }
            r4.width = r1     // Catch:{ all -> 0x00a4 }
            int r1 = r4.overrideHeight     // Catch:{ all -> 0x00a4 }
            r4.height = r1     // Catch:{ all -> 0x00a4 }
        L_0x0027:
            android.graphics.drawable.Drawable r1 = r4.getFallbackDrawable()     // Catch:{ all -> 0x00a4 }
            if (r1 != 0) goto L_0x002f
            r1 = 5
            goto L_0x0030
        L_0x002f:
            r1 = 3
        L_0x0030:
            com.bumptech.glide.load.engine.GlideException r2 = new com.bumptech.glide.load.engine.GlideException     // Catch:{ all -> 0x00a4 }
            java.lang.String r3 = "Received null model"
            r2.<init>(r3)     // Catch:{ all -> 0x00a4 }
            r4.onLoadFailed(r2, r1)     // Catch:{ all -> 0x00a4 }
            monitor-exit(r0)     // Catch:{ all -> 0x00a4 }
            return
        L_0x003c:
            com.bumptech.glide.request.SingleRequest$Status r1 = r4.status     // Catch:{ all -> 0x00a4 }
            com.bumptech.glide.request.SingleRequest$Status r2 = com.bumptech.glide.request.SingleRequest.Status.RUNNING     // Catch:{ all -> 0x00a4 }
            if (r1 == r2) goto L_0x009c
            com.bumptech.glide.request.SingleRequest$Status r1 = r4.status     // Catch:{ all -> 0x00a4 }
            com.bumptech.glide.request.SingleRequest$Status r2 = com.bumptech.glide.request.SingleRequest.Status.COMPLETE     // Catch:{ all -> 0x00a4 }
            if (r1 != r2) goto L_0x0051
            com.bumptech.glide.load.engine.Resource<R> r1 = r4.resource     // Catch:{ all -> 0x00a4 }
            com.bumptech.glide.load.DataSource r2 = com.bumptech.glide.load.DataSource.MEMORY_CACHE     // Catch:{ all -> 0x00a4 }
            r4.onResourceReady(r1, r2)     // Catch:{ all -> 0x00a4 }
            monitor-exit(r0)     // Catch:{ all -> 0x00a4 }
            return
        L_0x0051:
            com.bumptech.glide.request.SingleRequest$Status r1 = com.bumptech.glide.request.SingleRequest.Status.WAITING_FOR_SIZE     // Catch:{ all -> 0x00a4 }
            r4.status = r1     // Catch:{ all -> 0x00a4 }
            int r1 = r4.overrideWidth     // Catch:{ all -> 0x00a4 }
            int r2 = r4.overrideHeight     // Catch:{ all -> 0x00a4 }
            boolean r1 = com.bumptech.glide.util.Util.isValidDimensions(r1, r2)     // Catch:{ all -> 0x00a4 }
            if (r1 == 0) goto L_0x0067
            int r1 = r4.overrideWidth     // Catch:{ all -> 0x00a4 }
            int r2 = r4.overrideHeight     // Catch:{ all -> 0x00a4 }
            r4.onSizeReady(r1, r2)     // Catch:{ all -> 0x00a4 }
            goto L_0x006c
        L_0x0067:
            com.bumptech.glide.request.target.Target<R> r1 = r4.target     // Catch:{ all -> 0x00a4 }
            r1.getSize(r4)     // Catch:{ all -> 0x00a4 }
        L_0x006c:
            com.bumptech.glide.request.SingleRequest$Status r1 = r4.status     // Catch:{ all -> 0x00a4 }
            com.bumptech.glide.request.SingleRequest$Status r2 = com.bumptech.glide.request.SingleRequest.Status.RUNNING     // Catch:{ all -> 0x00a4 }
            if (r1 == r2) goto L_0x0078
            com.bumptech.glide.request.SingleRequest$Status r1 = r4.status     // Catch:{ all -> 0x00a4 }
            com.bumptech.glide.request.SingleRequest$Status r2 = com.bumptech.glide.request.SingleRequest.Status.WAITING_FOR_SIZE     // Catch:{ all -> 0x00a4 }
            if (r1 != r2) goto L_0x0091
        L_0x0078:
            com.bumptech.glide.request.RequestCoordinator r1 = r4.requestCoordinator     // Catch:{ all -> 0x00a4 }
            if (r1 == 0) goto L_0x0085
            boolean r1 = r1.canNotifyStatusChanged(r4)     // Catch:{ all -> 0x00a4 }
            if (r1 == 0) goto L_0x0083
            goto L_0x0085
        L_0x0083:
            r1 = 0
            goto L_0x0086
        L_0x0085:
            r1 = 1
        L_0x0086:
            if (r1 == 0) goto L_0x0091
            com.bumptech.glide.request.target.Target<R> r1 = r4.target     // Catch:{ all -> 0x00a4 }
            android.graphics.drawable.Drawable r2 = r4.getPlaceholderDrawable()     // Catch:{ all -> 0x00a4 }
            r1.onLoadStarted(r2)     // Catch:{ all -> 0x00a4 }
        L_0x0091:
            boolean r1 = IS_VERBOSE_LOGGABLE     // Catch:{ all -> 0x00a4 }
            if (r1 == 0) goto L_0x009a
            long r1 = r4.startTime     // Catch:{ all -> 0x00a4 }
            com.bumptech.glide.util.LogTime.getElapsedMillis(r1)     // Catch:{ all -> 0x00a4 }
        L_0x009a:
            monitor-exit(r0)     // Catch:{ all -> 0x00a4 }
            return
        L_0x009c:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00a4 }
            java.lang.String r2 = "Cannot restart a running request"
            r1.<init>(r2)     // Catch:{ all -> 0x00a4 }
            throw r1     // Catch:{ all -> 0x00a4 }
        L_0x00a4:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00a4 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.begin():void");
    }

    public final void cancel() {
        assertNotCallingCallbacks();
        this.stateVerifier.throwIfRecycled();
        this.target.removeCallback(this);
        LoadStatus loadStatus2 = this.loadStatus;
        if (loadStatus2 != null) {
            synchronized (Engine.this) {
                loadStatus2.engineJob.removeCallback(loadStatus2.cb);
            }
            this.loadStatus = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003e, code lost:
        if (r2 == null) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0040, code lost:
        r4.engine.release(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0045, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clear() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.requestLock
            monitor-enter(r0)
            r4.assertNotCallingCallbacks()     // Catch:{ all -> 0x0046 }
            com.bumptech.glide.util.pool.StateVerifier r1 = r4.stateVerifier     // Catch:{ all -> 0x0046 }
            r1.throwIfRecycled()     // Catch:{ all -> 0x0046 }
            com.bumptech.glide.request.SingleRequest$Status r1 = r4.status     // Catch:{ all -> 0x0046 }
            com.bumptech.glide.request.SingleRequest$Status r2 = com.bumptech.glide.request.SingleRequest.Status.CLEARED     // Catch:{ all -> 0x0046 }
            if (r1 != r2) goto L_0x0013
            monitor-exit(r0)     // Catch:{ all -> 0x0046 }
            return
        L_0x0013:
            r4.cancel()     // Catch:{ all -> 0x0046 }
            com.bumptech.glide.load.engine.Resource<R> r1 = r4.resource     // Catch:{ all -> 0x0046 }
            r2 = 0
            if (r1 == 0) goto L_0x0020
            com.bumptech.glide.load.engine.Resource<R> r1 = r4.resource     // Catch:{ all -> 0x0046 }
            r4.resource = r2     // Catch:{ all -> 0x0046 }
            r2 = r1
        L_0x0020:
            com.bumptech.glide.request.RequestCoordinator r1 = r4.requestCoordinator     // Catch:{ all -> 0x0046 }
            if (r1 == 0) goto L_0x002d
            boolean r1 = r1.canNotifyCleared(r4)     // Catch:{ all -> 0x0046 }
            if (r1 == 0) goto L_0x002b
            goto L_0x002d
        L_0x002b:
            r1 = 0
            goto L_0x002e
        L_0x002d:
            r1 = 1
        L_0x002e:
            if (r1 == 0) goto L_0x0039
            com.bumptech.glide.request.target.Target<R> r1 = r4.target     // Catch:{ all -> 0x0046 }
            android.graphics.drawable.Drawable r3 = r4.getPlaceholderDrawable()     // Catch:{ all -> 0x0046 }
            r1.onLoadCleared(r3)     // Catch:{ all -> 0x0046 }
        L_0x0039:
            com.bumptech.glide.request.SingleRequest$Status r1 = com.bumptech.glide.request.SingleRequest.Status.CLEARED     // Catch:{ all -> 0x0046 }
            r4.status = r1     // Catch:{ all -> 0x0046 }
            monitor-exit(r0)     // Catch:{ all -> 0x0046 }
            if (r2 == 0) goto L_0x0045
            com.bumptech.glide.load.engine.Engine r0 = r4.engine
            r0.release(r2)
        L_0x0045:
            return
        L_0x0046:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0046 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.clear():void");
    }

    public final Drawable getFallbackDrawable() {
        if (this.fallbackDrawable == null) {
            Drawable fallbackDrawable2 = this.requestOptions.getFallbackDrawable();
            this.fallbackDrawable = fallbackDrawable2;
            if (fallbackDrawable2 == null && this.requestOptions.getFallbackId() > 0) {
                this.fallbackDrawable = loadDrawable(this.requestOptions.getFallbackId());
            }
        }
        return this.fallbackDrawable;
    }

    public final Drawable getPlaceholderDrawable() {
        if (this.placeholderDrawable == null) {
            Drawable placeholderDrawable2 = this.requestOptions.getPlaceholderDrawable();
            this.placeholderDrawable = placeholderDrawable2;
            if (placeholderDrawable2 == null && this.requestOptions.getPlaceholderId() > 0) {
                this.placeholderDrawable = loadDrawable(this.requestOptions.getPlaceholderId());
            }
        }
        return this.placeholderDrawable;
    }

    public boolean isAnyResourceSet() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.status == Status.COMPLETE;
        }
        return z;
    }

    public boolean isCleared() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.status == Status.CLEARED;
        }
        return z;
    }

    public boolean isComplete() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.status == Status.COMPLETE;
        }
        return z;
    }

    public boolean isEquivalentTo(Request request) {
        int i;
        int i2;
        Object obj;
        Class<R> cls;
        BaseRequestOptions<?> baseRequestOptions;
        Priority priority2;
        int size;
        int i3;
        int i4;
        Object obj2;
        Class<R> cls2;
        BaseRequestOptions<?> baseRequestOptions2;
        Priority priority3;
        int size2;
        Request request2 = request;
        if (!(request2 instanceof SingleRequest)) {
            return false;
        }
        synchronized (this.requestLock) {
            i = this.overrideWidth;
            i2 = this.overrideHeight;
            obj = this.model;
            cls = this.transcodeClass;
            baseRequestOptions = this.requestOptions;
            priority2 = this.priority;
            size = this.requestListeners != null ? this.requestListeners.size() : 0;
        }
        SingleRequest singleRequest = (SingleRequest) request2;
        synchronized (singleRequest.requestLock) {
            i3 = singleRequest.overrideWidth;
            i4 = singleRequest.overrideHeight;
            obj2 = singleRequest.model;
            cls2 = singleRequest.transcodeClass;
            baseRequestOptions2 = singleRequest.requestOptions;
            priority3 = singleRequest.priority;
            size2 = singleRequest.requestListeners != null ? singleRequest.requestListeners.size() : 0;
        }
        return i == i3 && i2 == i4 && Util.bothModelsNullEquivalentOrEquals(obj, obj2) && cls.equals(cls2) && baseRequestOptions.equals(baseRequestOptions2) && priority2 == priority3 && size == size2;
    }

    public final boolean isFirstReadyResource() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        return requestCoordinator2 == null || !requestCoordinator2.getRoot().isAnyResourceSet();
    }

    public boolean isRunning() {
        boolean z;
        synchronized (this.requestLock) {
            if (this.status != Status.RUNNING) {
                if (this.status != Status.WAITING_FOR_SIZE) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public final Drawable loadDrawable(int i) {
        Theme theme = this.requestOptions.getTheme() != null ? this.requestOptions.getTheme() : this.context.getTheme();
        GlideContext glideContext2 = this.glideContext;
        return DrawableDecoderCompat.getDrawable(glideContext2, glideContext2, i, theme);
    }

    /* JADX INFO: finally extract failed */
    public final void onLoadFailed(GlideException glideException, int i) {
        boolean z;
        this.stateVerifier.throwIfRecycled();
        synchronized (this.requestLock) {
            if (glideException != null) {
                int logLevel = this.glideContext.getLogLevel();
                if (logLevel <= i) {
                    "Load failed for " + this.model + " with size [" + this.width + "x" + this.height + CMapParser.MARK_END_OF_ARRAY;
                    if (logLevel <= 4) {
                        ArrayList arrayList = new ArrayList();
                        glideException.addRootCauses(glideException, arrayList);
                        int size = arrayList.size();
                        int i2 = 0;
                        while (i2 < size) {
                            int i3 = i2 + 1;
                            Throwable th = (Throwable) arrayList.get(i2);
                            i2 = i3;
                        }
                    }
                }
                this.loadStatus = null;
                this.status = Status.FAILED;
                boolean z2 = true;
                this.isCallingCallbacks = true;
                try {
                    if (this.requestListeners != null) {
                        z = false;
                        for (RequestListener<R> onLoadFailed : this.requestListeners) {
                            z |= onLoadFailed.onLoadFailed(glideException, this.model, this.target, isFirstReadyResource());
                        }
                    } else {
                        z = false;
                    }
                    if (this.targetListener == null || !this.targetListener.onLoadFailed(glideException, this.model, this.target, isFirstReadyResource())) {
                        z2 = false;
                    }
                    if (!z && !z2) {
                        setErrorPlaceholder();
                    }
                    this.isCallingCallbacks = false;
                    RequestCoordinator requestCoordinator2 = this.requestCoordinator;
                    if (requestCoordinator2 != null) {
                        requestCoordinator2.onRequestFailed(this);
                    }
                } catch (Throwable th2) {
                    this.isCallingCallbacks = false;
                    throw th2;
                }
            } else {
                throw null;
            }
        }
    }

    public void onResourceReady(Resource<?> resource2, DataSource dataSource) {
        this.stateVerifier.throwIfRecycled();
        Resource<?> resource3 = null;
        try {
            synchronized (this.requestLock) {
                try {
                    this.loadStatus = null;
                    if (resource2 == null) {
                        onLoadFailed(new GlideException("Expected to receive a Resource<R> with an object of " + this.transcodeClass + " inside, but instead got null."), 5);
                        return;
                    }
                    Object obj = resource2.get();
                    if (obj != null) {
                        if (this.transcodeClass.isAssignableFrom(obj.getClass())) {
                            RequestCoordinator requestCoordinator2 = this.requestCoordinator;
                            if (!(requestCoordinator2 == null || requestCoordinator2.canSetImage(this))) {
                                try {
                                    this.resource = null;
                                    this.status = Status.COMPLETE;
                                    this.engine.release(resource2);
                                    return;
                                } catch (Throwable th) {
                                    resource3 = resource2;
                                    th = th;
                                    throw th;
                                }
                            } else {
                                onResourceReady(resource2, obj, dataSource);
                                return;
                            }
                        }
                    }
                    this.resource = null;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Expected to receive an object of ");
                    sb.append(this.transcodeClass);
                    sb.append(" but instead got ");
                    sb.append(obj != null ? obj.getClass() : "");
                    sb.append("{");
                    sb.append(obj);
                    sb.append("} inside Resource{");
                    sb.append(resource2);
                    sb.append("}.");
                    sb.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                    onLoadFailed(new GlideException(sb.toString()), 5);
                    this.engine.release(resource2);
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            }
        } catch (Throwable th3) {
            if (resource3 != null) {
                this.engine.release(resource3);
            }
            throw th3;
        }
    }

    public void onSizeReady(int i, int i2) {
        Object obj;
        int i3;
        int i4 = i;
        int i5 = i2;
        this.stateVerifier.throwIfRecycled();
        Object obj2 = this.requestLock;
        synchronized (obj2) {
            try {
                if (IS_VERBOSE_LOGGABLE) {
                    LogTime.getElapsedMillis(this.startTime);
                }
                if (this.status == Status.WAITING_FOR_SIZE) {
                    this.status = Status.RUNNING;
                    float sizeMultiplier = this.requestOptions.getSizeMultiplier();
                    if (i4 != Integer.MIN_VALUE) {
                        i4 = Math.round(((float) i4) * sizeMultiplier);
                    }
                    this.width = i4;
                    if (i5 == Integer.MIN_VALUE) {
                        i3 = i5;
                    } else {
                        i3 = Math.round(sizeMultiplier * ((float) i5));
                    }
                    this.height = i3;
                    if (IS_VERBOSE_LOGGABLE) {
                        LogTime.getElapsedMillis(this.startTime);
                    }
                    obj = obj2;
                    try {
                    } catch (Throwable th) {
                        th = th;
                        while (true) {
                            try {
                                break;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                        throw th;
                    }
                    try {
                        this.loadStatus = this.engine.load(this.glideContext, this.model, this.requestOptions.getSignature(), this.width, this.height, this.requestOptions.getResourceClass(), this.transcodeClass, this.priority, this.requestOptions.getDiskCacheStrategy(), this.requestOptions.getTransformations(), this.requestOptions.isTransformationRequired(), this.requestOptions.isScaleOnlyOrNoTransform(), this.requestOptions.getOptions(), this.requestOptions.isMemoryCacheable(), this.requestOptions.getUseUnlimitedSourceGeneratorsPool(), this.requestOptions.getUseAnimationPool(), this.requestOptions.getOnlyRetrieveFromCache(), this, this.callbackExecutor);
                        if (this.status != Status.RUNNING) {
                            this.loadStatus = null;
                        }
                        if (IS_VERBOSE_LOGGABLE) {
                            LogTime.getElapsedMillis(this.startTime);
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        while (true) {
                            break;
                        }
                        throw th;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                obj = obj2;
                while (true) {
                    break;
                }
                throw th;
            }
        }
    }

    public void pause() {
        synchronized (this.requestLock) {
            if (isRunning()) {
                clear();
            }
        }
    }

    public final void setErrorPlaceholder() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        if (requestCoordinator2 == null || requestCoordinator2.canNotifyStatusChanged(this)) {
            Drawable drawable = null;
            if (this.model == null) {
                drawable = getFallbackDrawable();
            }
            if (drawable == null) {
                if (this.errorDrawable == null) {
                    Drawable errorPlaceholder = this.requestOptions.getErrorPlaceholder();
                    this.errorDrawable = errorPlaceholder;
                    if (errorPlaceholder == null && this.requestOptions.getErrorId() > 0) {
                        this.errorDrawable = loadDrawable(this.requestOptions.getErrorId());
                    }
                }
                drawable = this.errorDrawable;
            }
            if (drawable == null) {
                drawable = getPlaceholderDrawable();
            }
            this.target.onLoadFailed(drawable);
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a2 A[Catch:{ all -> 0x00b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onResourceReady(com.bumptech.glide.load.engine.Resource<R> r11, R r12, com.bumptech.glide.load.DataSource r13) {
        /*
            r10 = this;
            boolean r6 = r10.isFirstReadyResource()
            com.bumptech.glide.request.SingleRequest$Status r0 = com.bumptech.glide.request.SingleRequest.Status.COMPLETE
            r10.status = r0
            r10.resource = r11
            com.bumptech.glide.GlideContext r11 = r10.glideContext
            int r11 = r11.getLogLevel()
            r0 = 3
            if (r11 > r0) goto L_0x0060
            java.lang.String r11 = "Finished loading "
            java.lang.StringBuilder r11 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r11)
            java.lang.Class r0 = r12.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r11.append(r0)
            java.lang.String r0 = " from "
            r11.append(r0)
            r11.append(r13)
            java.lang.String r0 = " for "
            r11.append(r0)
            java.lang.Object r0 = r10.model
            r11.append(r0)
            java.lang.String r0 = " with size ["
            r11.append(r0)
            int r0 = r10.width
            r11.append(r0)
            java.lang.String r0 = "x"
            r11.append(r0)
            int r0 = r10.height
            r11.append(r0)
            java.lang.String r0 = "] in "
            r11.append(r0)
            long r0 = r10.startTime
            double r0 = com.bumptech.glide.util.LogTime.getElapsedMillis(r0)
            r11.append(r0)
            java.lang.String r0 = " ms"
            r11.append(r0)
            r11.toString()
        L_0x0060:
            r11 = 1
            r10.isCallingCallbacks = r11
            r7 = 0
            java.util.List<com.bumptech.glide.request.RequestListener<R>> r0 = r10.requestListeners     // Catch:{ all -> 0x00b7 }
            if (r0 == 0) goto L_0x0089
            java.util.List<com.bumptech.glide.request.RequestListener<R>> r0 = r10.requestListeners     // Catch:{ all -> 0x00b7 }
            java.util.Iterator r8 = r0.iterator()     // Catch:{ all -> 0x00b7 }
            r0 = 0
            r9 = 0
        L_0x0070:
            boolean r0 = r8.hasNext()     // Catch:{ all -> 0x00b7 }
            if (r0 == 0) goto L_0x008a
            java.lang.Object r0 = r8.next()     // Catch:{ all -> 0x00b7 }
            com.bumptech.glide.request.RequestListener r0 = (com.bumptech.glide.request.RequestListener) r0     // Catch:{ all -> 0x00b7 }
            java.lang.Object r2 = r10.model     // Catch:{ all -> 0x00b7 }
            com.bumptech.glide.request.target.Target<R> r3 = r10.target     // Catch:{ all -> 0x00b7 }
            r1 = r12
            r4 = r13
            r5 = r6
            boolean r0 = r0.onResourceReady(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00b7 }
            r9 = r9 | r0
            goto L_0x0070
        L_0x0089:
            r9 = 0
        L_0x008a:
            com.bumptech.glide.request.RequestListener<R> r0 = r10.targetListener     // Catch:{ all -> 0x00b7 }
            if (r0 == 0) goto L_0x009e
            com.bumptech.glide.request.RequestListener<R> r0 = r10.targetListener     // Catch:{ all -> 0x00b7 }
            java.lang.Object r2 = r10.model     // Catch:{ all -> 0x00b7 }
            com.bumptech.glide.request.target.Target<R> r3 = r10.target     // Catch:{ all -> 0x00b7 }
            r1 = r12
            r4 = r13
            r5 = r6
            boolean r0 = r0.onResourceReady(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00b7 }
            if (r0 == 0) goto L_0x009e
            goto L_0x009f
        L_0x009e:
            r11 = 0
        L_0x009f:
            r11 = r11 | r9
            if (r11 != 0) goto L_0x00ad
            com.bumptech.glide.request.transition.TransitionFactory<? super R> r11 = r10.animationFactory     // Catch:{ all -> 0x00b7 }
            com.bumptech.glide.request.transition.Transition r11 = r11.build(r13, r6)     // Catch:{ all -> 0x00b7 }
            com.bumptech.glide.request.target.Target<R> r13 = r10.target     // Catch:{ all -> 0x00b7 }
            r13.onResourceReady(r12, r11)     // Catch:{ all -> 0x00b7 }
        L_0x00ad:
            r10.isCallingCallbacks = r7
            com.bumptech.glide.request.RequestCoordinator r11 = r10.requestCoordinator
            if (r11 == 0) goto L_0x00b6
            r11.onRequestSuccess(r10)
        L_0x00b6:
            return
        L_0x00b7:
            r11 = move-exception
            r10.isCallingCallbacks = r7
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.onResourceReady(com.bumptech.glide.load.engine.Resource, java.lang.Object, com.bumptech.glide.load.DataSource):void");
    }
}
