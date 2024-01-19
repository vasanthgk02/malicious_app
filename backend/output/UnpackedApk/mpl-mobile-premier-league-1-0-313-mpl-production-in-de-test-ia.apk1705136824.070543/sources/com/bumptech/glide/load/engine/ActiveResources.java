package com.bumptech.glide.load.engine;

import android.os.Process;
import co.hyperverge.hypersnapsdk.c.k;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.EngineResource.ResourceListener;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public final class ActiveResources {
    public final Map<Key, ResourceWeakReference> activeEngineResources = new HashMap();
    public final boolean isActiveResourceRetentionAllowed;
    public volatile boolean isShutdown;
    public ResourceListener listener;
    public final Executor monitorClearedResourcesExecutor;
    public final ReferenceQueue<EngineResource<?>> resourceReferenceQueue = new ReferenceQueue<>();

    public static final class ResourceWeakReference extends WeakReference<EngineResource<?>> {
        public final boolean isCacheable;
        public final Key key;
        public Resource<?> resource;

        public ResourceWeakReference(Key key2, EngineResource<?> engineResource, ReferenceQueue<? super EngineResource<?>> referenceQueue, boolean z) {
            Resource<Z> resource2;
            super(engineResource, referenceQueue);
            k.checkNotNull(key2, (String) "Argument must not be null");
            this.key = key2;
            if (!engineResource.isMemoryCacheable || !z) {
                resource2 = null;
            } else {
                resource2 = engineResource.resource;
                k.checkNotNull(resource2, (String) "Argument must not be null");
            }
            this.resource = resource2;
            this.isCacheable = engineResource.isMemoryCacheable;
        }
    }

    public ActiveResources(boolean z) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() {
            public Thread newThread(final Runnable runnable) {
                return new Thread(new Runnable(this) {
                    public void run() {
                        Process.setThreadPriority(10);
                        runnable.run();
                    }
                }, "glide-active-resources");
            }
        });
        this.isActiveResourceRetentionAllowed = z;
        this.monitorClearedResourcesExecutor = newSingleThreadExecutor;
        newSingleThreadExecutor.execute(new Runnable() {
            public void run() {
                ActiveResources activeResources = ActiveResources.this;
                while (!activeResources.isShutdown) {
                    try {
                        activeResources.cleanupActiveReference((ResourceWeakReference) activeResources.resourceReferenceQueue.remove());
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });
    }

    public synchronized void activate(Key key, EngineResource<?> engineResource) {
        ResourceWeakReference put = this.activeEngineResources.put(key, new ResourceWeakReference(key, engineResource, this.resourceReferenceQueue, this.isActiveResourceRetentionAllowed));
        if (put != null) {
            put.resource = null;
            put.clear();
        }
    }

    public void cleanupActiveReference(ResourceWeakReference resourceWeakReference) {
        synchronized (this) {
            this.activeEngineResources.remove(resourceWeakReference.key);
            if (resourceWeakReference.isCacheable) {
                if (resourceWeakReference.resource != null) {
                    EngineResource engineResource = new EngineResource(resourceWeakReference.resource, true, false, resourceWeakReference.key, this.listener);
                    this.listener.onResourceReleased(resourceWeakReference.key, engineResource);
                }
            }
        }
    }
}
