package com.bumptech.glide.load.engine;

import androidx.core.util.Pools$Pool;
import co.hyperverge.hypersnapsdk.c.k;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DecodeJob.Callback;
import com.bumptech.glide.load.engine.DecodeJob.ReleaseManager;
import com.bumptech.glide.load.engine.EngineResource.ResourceListener;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.pool.FactoryPools.Poolable;
import com.bumptech.glide.util.pool.StateVerifier;
import com.bumptech.glide.util.pool.StateVerifier.DefaultStateVerifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public class EngineJob<R> implements Callback<R>, Poolable {
    public static final EngineResourceFactory DEFAULT_FACTORY = new EngineResourceFactory();
    public final GlideExecutor animationExecutor;
    public final ResourceCallbacksAndExecutors cbs = new ResourceCallbacksAndExecutors();
    public DataSource dataSource;
    public DecodeJob<R> decodeJob;
    public final GlideExecutor diskCacheExecutor;
    public final EngineJobListener engineJobListener;
    public EngineResource<?> engineResource;
    public final EngineResourceFactory engineResourceFactory;
    public GlideException exception;
    public boolean hasLoadFailed;
    public boolean hasResource;
    public boolean isCacheable;
    public volatile boolean isCancelled;
    public Key key;
    public boolean onlyRetrieveFromCache;
    public final AtomicInteger pendingCallbacks = new AtomicInteger();
    public final Pools$Pool<EngineJob<?>> pool;
    public Resource<?> resource;
    public final ResourceListener resourceListener;
    public final GlideExecutor sourceExecutor;
    public final GlideExecutor sourceUnlimitedExecutor;
    public final StateVerifier stateVerifier = new DefaultStateVerifier();
    public boolean useAnimationPool;
    public boolean useUnlimitedSourceGeneratorPool;

    public class CallLoadFailed implements Runnable {
        public final ResourceCallback cb;

        public CallLoadFailed(ResourceCallback resourceCallback) {
            this.cb = resourceCallback;
        }

        public void run() {
            SingleRequest singleRequest = (SingleRequest) this.cb;
            singleRequest.stateVerifier.throwIfRecycled();
            synchronized (singleRequest.requestLock) {
                synchronized (EngineJob.this) {
                    if (EngineJob.this.cbs.callbacksAndExecutors.contains(new ResourceCallbackAndExecutor(this.cb, Executors.DIRECT_EXECUTOR))) {
                        EngineJob engineJob = EngineJob.this;
                        ResourceCallback resourceCallback = this.cb;
                        if (engineJob != null) {
                            try {
                                ((SingleRequest) resourceCallback).onLoadFailed(engineJob.exception, 5);
                            } catch (Throwable th) {
                                throw new CallbackException(th);
                            }
                        } else {
                            throw null;
                        }
                    }
                    EngineJob.this.decrementPendingCallbacks();
                }
            }
        }
    }

    public class CallResourceReady implements Runnable {
        public final ResourceCallback cb;

        public CallResourceReady(ResourceCallback resourceCallback) {
            this.cb = resourceCallback;
        }

        public void run() {
            SingleRequest singleRequest = (SingleRequest) this.cb;
            singleRequest.stateVerifier.throwIfRecycled();
            synchronized (singleRequest.requestLock) {
                synchronized (EngineJob.this) {
                    if (EngineJob.this.cbs.callbacksAndExecutors.contains(new ResourceCallbackAndExecutor(this.cb, Executors.DIRECT_EXECUTOR))) {
                        EngineJob.this.engineResource.acquire();
                        EngineJob engineJob = EngineJob.this;
                        ResourceCallback resourceCallback = this.cb;
                        if (engineJob != null) {
                            try {
                                ((SingleRequest) resourceCallback).onResourceReady(engineJob.engineResource, engineJob.dataSource);
                                EngineJob.this.removeCallback(this.cb);
                            } catch (Throwable th) {
                                throw new CallbackException(th);
                            }
                        } else {
                            throw null;
                        }
                    }
                    EngineJob.this.decrementPendingCallbacks();
                }
            }
        }
    }

    public static class EngineResourceFactory {
    }

    public static final class ResourceCallbackAndExecutor {
        public final ResourceCallback cb;
        public final Executor executor;

        public ResourceCallbackAndExecutor(ResourceCallback resourceCallback, Executor executor2) {
            this.cb = resourceCallback;
            this.executor = executor2;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ResourceCallbackAndExecutor) {
                return this.cb.equals(((ResourceCallbackAndExecutor) obj).cb);
            }
            return false;
        }

        public int hashCode() {
            return this.cb.hashCode();
        }
    }

    public static final class ResourceCallbacksAndExecutors implements Iterable<ResourceCallbackAndExecutor> {
        public final List<ResourceCallbackAndExecutor> callbacksAndExecutors = new ArrayList(2);

        public boolean isEmpty() {
            return this.callbacksAndExecutors.isEmpty();
        }

        public Iterator<ResourceCallbackAndExecutor> iterator() {
            return this.callbacksAndExecutors.iterator();
        }
    }

    public EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener2, ResourceListener resourceListener2, Pools$Pool<EngineJob<?>> pools$Pool) {
        EngineResourceFactory engineResourceFactory2 = DEFAULT_FACTORY;
        this.diskCacheExecutor = glideExecutor;
        this.sourceExecutor = glideExecutor2;
        this.sourceUnlimitedExecutor = glideExecutor3;
        this.animationExecutor = glideExecutor4;
        this.engineJobListener = engineJobListener2;
        this.resourceListener = resourceListener2;
        this.pool = pools$Pool;
        this.engineResourceFactory = engineResourceFactory2;
    }

    public synchronized void addCallback(ResourceCallback resourceCallback, Executor executor) {
        this.stateVerifier.throwIfRecycled();
        this.cbs.callbacksAndExecutors.add(new ResourceCallbackAndExecutor(resourceCallback, executor));
        boolean z = true;
        if (this.hasResource) {
            incrementPendingCallbacks(1);
            executor.execute(new CallResourceReady(resourceCallback));
        } else if (this.hasLoadFailed) {
            incrementPendingCallbacks(1);
            executor.execute(new CallLoadFailed(resourceCallback));
        } else {
            if (this.isCancelled) {
                z = false;
            }
            k.checkArgument(z, (String) "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    public void cancel() {
        if (!isDone()) {
            this.isCancelled = true;
            DecodeJob<R> decodeJob2 = this.decodeJob;
            decodeJob2.isCancelled = true;
            DataFetcherGenerator dataFetcherGenerator = decodeJob2.currentGenerator;
            if (dataFetcherGenerator != null) {
                dataFetcherGenerator.cancel();
            }
            EngineJobListener engineJobListener2 = this.engineJobListener;
            Key key2 = this.key;
            Engine engine = (Engine) engineJobListener2;
            synchronized (engine) {
                Jobs jobs = engine.jobs;
                if (jobs != null) {
                    Map<Key, EngineJob<?>> jobMap = jobs.getJobMap(this.onlyRetrieveFromCache);
                    if (equals(jobMap.get(key2))) {
                        jobMap.remove(key2);
                    }
                } else {
                    throw null;
                }
            }
        }
    }

    public void decrementPendingCallbacks() {
        EngineResource<?> engineResource2;
        synchronized (this) {
            this.stateVerifier.throwIfRecycled();
            k.checkArgument(isDone(), (String) "Not yet complete!");
            int decrementAndGet = this.pendingCallbacks.decrementAndGet();
            k.checkArgument(decrementAndGet >= 0, (String) "Can't decrement below 0");
            if (decrementAndGet == 0) {
                engineResource2 = this.engineResource;
                release();
            } else {
                engineResource2 = null;
            }
        }
        if (engineResource2 != null) {
            engineResource2.release();
        }
    }

    public StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    public synchronized void incrementPendingCallbacks(int i) {
        k.checkArgument(isDone(), (String) "Not yet complete!");
        if (this.pendingCallbacks.getAndAdd(i) == 0 && this.engineResource != null) {
            this.engineResource.acquire();
        }
    }

    public final boolean isDone() {
        return this.hasLoadFailed || this.hasResource || this.isCancelled;
    }

    public final synchronized void release() {
        boolean isComplete;
        if (this.key != null) {
            this.cbs.callbacksAndExecutors.clear();
            this.key = null;
            this.engineResource = null;
            this.resource = null;
            this.hasLoadFailed = false;
            this.isCancelled = false;
            this.hasResource = false;
            DecodeJob<R> decodeJob2 = this.decodeJob;
            ReleaseManager releaseManager = decodeJob2.releaseManager;
            synchronized (releaseManager) {
                releaseManager.isReleased = true;
                isComplete = releaseManager.isComplete(false);
            }
            if (isComplete) {
                decodeJob2.releaseInternal();
            }
            this.decodeJob = null;
            this.exception = null;
            this.dataSource = null;
            this.pool.release(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public synchronized void removeCallback(ResourceCallback resourceCallback) {
        boolean z;
        this.stateVerifier.throwIfRecycled();
        this.cbs.callbacksAndExecutors.remove(new ResourceCallbackAndExecutor(resourceCallback, Executors.DIRECT_EXECUTOR));
        if (this.cbs.isEmpty()) {
            cancel();
            if (!this.hasResource) {
                if (!this.hasLoadFailed) {
                    z = false;
                    if (z && this.pendingCallbacks.get() == 0) {
                        release();
                    }
                }
            }
            z = true;
            release();
        }
    }

    public void reschedule(DecodeJob<?> decodeJob2) {
        GlideExecutor glideExecutor;
        if (this.useUnlimitedSourceGeneratorPool) {
            glideExecutor = this.sourceUnlimitedExecutor;
        } else {
            glideExecutor = this.useAnimationPool ? this.animationExecutor : this.sourceExecutor;
        }
        glideExecutor.delegate.execute(decodeJob2);
    }
}
