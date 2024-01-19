package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.DefaultConnectivityMonitor;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.manager.NullConnectivityMonitor;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.manager.TargetTracker;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class RequestManager implements ComponentCallbacks2, LifecycleListener, ModelTypes<RequestBuilder<Drawable>> {
    public static final RequestOptions DECODE_TYPE_BITMAP = ((RequestOptions) RequestOptions.decodeTypeOf(Bitmap.class).lock());
    public static final RequestOptions DECODE_TYPE_GIF = ((RequestOptions) RequestOptions.decodeTypeOf(GifDrawable.class).lock());
    public static final RequestOptions DOWNLOAD_ONLY_OPTIONS = ((RequestOptions) ((RequestOptions) RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.DATA).priority(Priority.LOW)).skipMemoryCache(true));
    public final Runnable addSelfToLifecycle;
    public final ConnectivityMonitor connectivityMonitor;
    public final Context context;
    public final CopyOnWriteArrayList<RequestListener<Object>> defaultRequestListeners;
    public final Glide glide;
    public final Lifecycle lifecycle;
    public final Handler mainHandler;
    public boolean pauseAllRequestsOnTrimMemoryModerate;
    public RequestOptions requestOptions;
    public final RequestTracker requestTracker;
    public final TargetTracker targetTracker;
    public final RequestManagerTreeNode treeNode;

    public static class ClearTarget extends CustomViewTarget<View, Object> {
        public ClearTarget(View view) {
            super(view);
        }

        public void onLoadFailed(Drawable drawable) {
        }

        public void onResourceCleared(Drawable drawable) {
        }

        public void onResourceReady(Object obj, Transition<? super Object> transition) {
        }
    }

    public class RequestManagerConnectivityListener implements ConnectivityListener {
        public final RequestTracker requestTracker;

        public RequestManagerConnectivityListener(RequestTracker requestTracker2) {
            this.requestTracker = requestTracker2;
        }

        public void onConnectivityChanged(boolean z) {
            if (z) {
                synchronized (RequestManager.this) {
                    RequestTracker requestTracker2 = this.requestTracker;
                    Iterator it = ((ArrayList) Util.getSnapshot(requestTracker2.requests)).iterator();
                    while (it.hasNext()) {
                        Request request = (Request) it.next();
                        if (!request.isComplete() && !request.isCleared()) {
                            request.clear();
                            if (!requestTracker2.isPaused) {
                                request.begin();
                            } else {
                                requestTracker2.pendingRequests.add(request);
                            }
                        }
                    }
                }
            }
        }
    }

    public RequestManager(Glide glide2, Lifecycle lifecycle2, RequestManagerTreeNode requestManagerTreeNode, Context context2) {
        this(glide2, lifecycle2, requestManagerTreeNode, new RequestTracker(), glide2.getConnectivityMonitorFactory(), context2);
    }

    private void untrackOrDelegate(Target<?> target) {
        boolean untrack = untrack(target);
        Request request = target.getRequest();
        if (!untrack && !this.glide.removeFromManagers(target) && request != null) {
            target.setRequest(null);
            request.clear();
        }
    }

    private synchronized void updateRequestOptions(RequestOptions requestOptions2) {
        this.requestOptions = (RequestOptions) this.requestOptions.apply(requestOptions2);
    }

    public RequestManager addDefaultRequestListener(RequestListener<Object> requestListener) {
        this.defaultRequestListeners.add(requestListener);
        return this;
    }

    public synchronized RequestManager applyDefaultRequestOptions(RequestOptions requestOptions2) {
        updateRequestOptions(requestOptions2);
        return this;
    }

    public <ResourceType> RequestBuilder<ResourceType> as(Class<ResourceType> cls) {
        return new RequestBuilder<>(this.glide, this, cls, this.context);
    }

    public RequestBuilder<Bitmap> asBitmap() {
        return as(Bitmap.class).apply((BaseRequestOptions<?>) DECODE_TYPE_BITMAP);
    }

    public RequestBuilder<Drawable> asDrawable() {
        return as(Drawable.class);
    }

    public RequestBuilder<File> asFile() {
        return as(File.class).apply((BaseRequestOptions<?>) RequestOptions.skipMemoryCacheOf(true));
    }

    public RequestBuilder<GifDrawable> asGif() {
        return as(GifDrawable.class).apply((BaseRequestOptions<?>) DECODE_TYPE_GIF);
    }

    public void clear(View view) {
        clear((Target<?>) new ClearTarget<Object>(view));
    }

    public RequestBuilder<File> download(Object obj) {
        return downloadOnly().load(obj);
    }

    public RequestBuilder<File> downloadOnly() {
        return as(File.class).apply((BaseRequestOptions<?>) DOWNLOAD_ONLY_OPTIONS);
    }

    public List<RequestListener<Object>> getDefaultRequestListeners() {
        return this.defaultRequestListeners;
    }

    public synchronized RequestOptions getDefaultRequestOptions() {
        try {
        }
        return this.requestOptions;
    }

    public <T> TransitionOptions<?, T> getDefaultTransitionOptions(Class<T> cls) {
        return this.glide.getGlideContext().getDefaultTransitionOptions(cls);
    }

    public synchronized boolean isPaused() {
        return this.requestTracker.isPaused;
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public synchronized void onDestroy() {
        this.targetTracker.onDestroy();
        for (T clear : Util.getSnapshot(this.targetTracker.targets)) {
            clear((Target<?>) clear);
        }
        this.targetTracker.targets.clear();
        RequestTracker requestTracker2 = this.requestTracker;
        Iterator it = ((ArrayList) Util.getSnapshot(requestTracker2.requests)).iterator();
        while (it.hasNext()) {
            requestTracker2.clearAndRemove((Request) it.next());
        }
        requestTracker2.pendingRequests.clear();
        this.lifecycle.removeListener(this);
        this.lifecycle.removeListener(this.connectivityMonitor);
        this.mainHandler.removeCallbacks(this.addSelfToLifecycle);
        this.glide.unregisterRequestManager(this);
    }

    public void onLowMemory() {
    }

    public synchronized void onStart() {
        resumeRequests();
        this.targetTracker.onStart();
    }

    public synchronized void onStop() {
        pauseRequests();
        this.targetTracker.onStop();
    }

    public void onTrimMemory(int i) {
        if (i == 60 && this.pauseAllRequestsOnTrimMemoryModerate) {
            pauseAllRequestsRecursive();
        }
    }

    public synchronized void pauseAllRequests() {
        RequestTracker requestTracker2 = this.requestTracker;
        requestTracker2.isPaused = true;
        Iterator it = ((ArrayList) Util.getSnapshot(requestTracker2.requests)).iterator();
        while (it.hasNext()) {
            Request request = (Request) it.next();
            if (request.isRunning() || request.isComplete()) {
                request.clear();
                requestTracker2.pendingRequests.add(request);
            }
        }
    }

    public synchronized void pauseAllRequestsRecursive() {
        pauseAllRequests();
        for (RequestManager pauseAllRequests : this.treeNode.getDescendants()) {
            pauseAllRequests.pauseAllRequests();
        }
    }

    public synchronized void pauseRequests() {
        RequestTracker requestTracker2 = this.requestTracker;
        requestTracker2.isPaused = true;
        Iterator it = ((ArrayList) Util.getSnapshot(requestTracker2.requests)).iterator();
        while (it.hasNext()) {
            Request request = (Request) it.next();
            if (request.isRunning()) {
                request.pause();
                requestTracker2.pendingRequests.add(request);
            }
        }
    }

    public synchronized void pauseRequestsRecursive() {
        pauseRequests();
        for (RequestManager pauseRequests : this.treeNode.getDescendants()) {
            pauseRequests.pauseRequests();
        }
    }

    public synchronized void resumeRequests() {
        RequestTracker requestTracker2 = this.requestTracker;
        requestTracker2.isPaused = false;
        Iterator it = ((ArrayList) Util.getSnapshot(requestTracker2.requests)).iterator();
        while (it.hasNext()) {
            Request request = (Request) it.next();
            if (!request.isComplete() && !request.isRunning()) {
                request.begin();
            }
        }
        requestTracker2.pendingRequests.clear();
    }

    public synchronized void resumeRequestsRecursive() {
        Util.assertMainThread();
        resumeRequests();
        for (RequestManager resumeRequests : this.treeNode.getDescendants()) {
            resumeRequests.resumeRequests();
        }
    }

    public synchronized RequestManager setDefaultRequestOptions(RequestOptions requestOptions2) {
        setRequestOptions(requestOptions2);
        return this;
    }

    public void setPauseAllRequestsOnTrimMemoryModerate(boolean z) {
        this.pauseAllRequestsOnTrimMemoryModerate = z;
    }

    public synchronized void setRequestOptions(RequestOptions requestOptions2) {
        this.requestOptions = (RequestOptions) ((RequestOptions) requestOptions2.clone()).autoClone();
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.requestTracker + ", treeNode=" + this.treeNode + "}";
    }

    public synchronized void track(Target<?> target, Request request) {
        this.targetTracker.targets.add(target);
        RequestTracker requestTracker2 = this.requestTracker;
        requestTracker2.requests.add(request);
        if (!requestTracker2.isPaused) {
            request.begin();
        } else {
            request.clear();
            Log.isLoggable("RequestTracker", 2);
            requestTracker2.pendingRequests.add(request);
        }
    }

    public synchronized boolean untrack(Target<?> target) {
        try {
            Request request = target.getRequest();
            if (request == null) {
                return true;
            }
            if (!this.requestTracker.clearAndRemove(request)) {
                return false;
            }
            this.targetTracker.targets.remove(target);
            target.setRequest(null);
            return true;
        }
    }

    public void clear(Target<?> target) {
        if (target != null) {
            untrackOrDelegate(target);
        }
    }

    public RequestManager(Glide glide2, Lifecycle lifecycle2, RequestManagerTreeNode requestManagerTreeNode, RequestTracker requestTracker2, ConnectivityMonitorFactory connectivityMonitorFactory, Context context2) {
        ConnectivityMonitor connectivityMonitor2;
        this.targetTracker = new TargetTracker();
        this.addSelfToLifecycle = new Runnable() {
            public void run() {
                RequestManager requestManager = RequestManager.this;
                requestManager.lifecycle.addListener(requestManager);
            }
        };
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.glide = glide2;
        this.lifecycle = lifecycle2;
        this.treeNode = requestManagerTreeNode;
        this.requestTracker = requestTracker2;
        this.context = context2;
        Context applicationContext = context2.getApplicationContext();
        RequestManagerConnectivityListener requestManagerConnectivityListener = new RequestManagerConnectivityListener(requestTracker2);
        if (((DefaultConnectivityMonitorFactory) connectivityMonitorFactory) != null) {
            boolean z = ContextCompat.checkSelfPermission(applicationContext, "android.permission.ACCESS_NETWORK_STATE") == 0;
            Log.isLoggable("ConnectivityMonitor", 3);
            if (z) {
                connectivityMonitor2 = new DefaultConnectivityMonitor(applicationContext, requestManagerConnectivityListener);
            } else {
                connectivityMonitor2 = new NullConnectivityMonitor();
            }
            this.connectivityMonitor = connectivityMonitor2;
            if (Util.isOnBackgroundThread()) {
                this.mainHandler.post(this.addSelfToLifecycle);
            } else {
                lifecycle2.addListener(this);
            }
            lifecycle2.addListener(this.connectivityMonitor);
            this.defaultRequestListeners = new CopyOnWriteArrayList<>(glide2.getGlideContext().getDefaultRequestListeners());
            setRequestOptions(glide2.getGlideContext().getDefaultRequestOptions());
            glide2.registerRequestManager(this);
            return;
        }
        throw null;
    }

    public RequestBuilder<Drawable> load(Bitmap bitmap) {
        return asDrawable().load(bitmap);
    }

    public RequestBuilder<Drawable> load(Drawable drawable) {
        return asDrawable().load(drawable);
    }

    public RequestBuilder<Drawable> load(String str) {
        return asDrawable().load(str);
    }

    public RequestBuilder<Drawable> load(Uri uri) {
        return asDrawable().load(uri);
    }

    public RequestBuilder<Drawable> load(File file) {
        return asDrawable().load(file);
    }

    public RequestBuilder<Drawable> load(Integer num) {
        return asDrawable().load(num);
    }

    @Deprecated
    public RequestBuilder<Drawable> load(URL url) {
        return asDrawable().load(url);
    }

    public RequestBuilder<Drawable> load(byte[] bArr) {
        return asDrawable().load(bArr);
    }

    public RequestBuilder<Drawable> load(Object obj) {
        return asDrawable().load(obj);
    }
}
