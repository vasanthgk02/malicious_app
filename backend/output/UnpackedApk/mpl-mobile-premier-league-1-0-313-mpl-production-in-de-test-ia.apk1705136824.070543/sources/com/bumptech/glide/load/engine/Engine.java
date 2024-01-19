package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.core.util.Pools$Pool;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.ActiveResources.ResourceWeakReference;
import com.bumptech.glide.load.engine.DecodeJob.DiskCacheProvider;
import com.bumptech.glide.load.engine.EngineResource.ResourceListener;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskCacheAdapter;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.load.engine.cache.DiskLruCacheWrapper;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory.AnonymousClass1;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.cache.MemoryCache.ResourceRemovedListener;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.FactoryPools.Factory;
import java.io.File;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import org.apache.commons.net.ftp.FTPReply;

public class Engine implements EngineJobListener, ResourceRemovedListener, ResourceListener {
    public static final boolean VERBOSE_IS_LOGGABLE = Log.isLoggable("Engine", 2);
    public final ActiveResources activeResources;
    public final MemoryCache cache;
    public final DecodeJobFactory decodeJobFactory;
    public final LazyDiskCacheProvider diskCacheProvider;
    public final EngineJobFactory engineJobFactory;
    public final Jobs jobs;
    public final EngineKeyFactory keyFactory;
    public final ResourceRecycler resourceRecycler;

    public static class DecodeJobFactory {
        public int creationOrder;
        public final DiskCacheProvider diskCacheProvider;
        public final Pools$Pool<DecodeJob<?>> pool = FactoryPools.threadSafe(FTPReply.FILE_STATUS_OK, new Factory<DecodeJob<?>>() {
            public Object create() {
                DecodeJobFactory decodeJobFactory = DecodeJobFactory.this;
                return new DecodeJob(decodeJobFactory.diskCacheProvider, decodeJobFactory.pool);
            }
        });

        public DecodeJobFactory(DiskCacheProvider diskCacheProvider2) {
            this.diskCacheProvider = diskCacheProvider2;
        }
    }

    public static class EngineJobFactory {
        public final GlideExecutor animationExecutor;
        public final GlideExecutor diskCacheExecutor;
        public final EngineJobListener engineJobListener;
        public final Pools$Pool<EngineJob<?>> pool = FactoryPools.threadSafe(FTPReply.FILE_STATUS_OK, new Factory<EngineJob<?>>() {
            public Object create() {
                EngineJobFactory engineJobFactory = EngineJobFactory.this;
                EngineJob engineJob = new EngineJob(engineJobFactory.diskCacheExecutor, engineJobFactory.sourceExecutor, engineJobFactory.sourceUnlimitedExecutor, engineJobFactory.animationExecutor, engineJobFactory.engineJobListener, engineJobFactory.resourceListener, engineJobFactory.pool);
                return engineJob;
            }
        });
        public final ResourceListener resourceListener;
        public final GlideExecutor sourceExecutor;
        public final GlideExecutor sourceUnlimitedExecutor;

        public EngineJobFactory(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener2, ResourceListener resourceListener2) {
            this.diskCacheExecutor = glideExecutor;
            this.sourceExecutor = glideExecutor2;
            this.sourceUnlimitedExecutor = glideExecutor3;
            this.animationExecutor = glideExecutor4;
            this.engineJobListener = engineJobListener2;
            this.resourceListener = resourceListener2;
        }
    }

    public static class LazyDiskCacheProvider implements DiskCacheProvider {
        public volatile DiskCache diskCache;
        public final DiskCache.Factory factory;

        public LazyDiskCacheProvider(DiskCache.Factory factory2) {
            this.factory = factory2;
        }

        public DiskCache getDiskCache() {
            if (this.diskCache == null) {
                synchronized (this) {
                    try {
                        if (this.diskCache == null) {
                            DiskLruCacheFactory diskLruCacheFactory = (DiskLruCacheFactory) this.factory;
                            AnonymousClass1 r1 = (AnonymousClass1) diskLruCacheFactory.cacheDirectoryGetter;
                            File cacheDir = r4.getCacheDir();
                            DiskLruCacheWrapper diskLruCacheWrapper = null;
                            if (cacheDir == null) {
                                cacheDir = null;
                            } else if (Glide.DEFAULT_DISK_CACHE_DIR != null) {
                                cacheDir = new File(cacheDir, Glide.DEFAULT_DISK_CACHE_DIR);
                            }
                            if (cacheDir != null) {
                                if (!cacheDir.mkdirs()) {
                                    if (cacheDir.exists()) {
                                        if (!cacheDir.isDirectory()) {
                                        }
                                    }
                                }
                                diskLruCacheWrapper = new DiskLruCacheWrapper(cacheDir, diskLruCacheFactory.diskCacheSize);
                            }
                            this.diskCache = diskLruCacheWrapper;
                        }
                        if (this.diskCache == null) {
                            this.diskCache = new DiskCacheAdapter();
                        }
                    }
                }
            }
            return this.diskCache;
        }
    }

    public class LoadStatus {
        public final ResourceCallback cb;
        public final EngineJob<?> engineJob;

        public LoadStatus(ResourceCallback resourceCallback, EngineJob<?> engineJob2) {
            this.cb = resourceCallback;
            this.engineJob = engineJob2;
        }
    }

    public Engine(MemoryCache memoryCache, DiskCache.Factory factory, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, boolean z) {
        this.cache = memoryCache;
        this.diskCacheProvider = new LazyDiskCacheProvider(factory);
        ActiveResources activeResources2 = new ActiveResources(z);
        this.activeResources = activeResources2;
        synchronized (this) {
            synchronized (activeResources2) {
                activeResources2.listener = this;
            }
        }
        this.keyFactory = new EngineKeyFactory();
        this.jobs = new Jobs();
        EngineJobFactory engineJobFactory2 = new EngineJobFactory(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, this, this);
        this.engineJobFactory = engineJobFactory2;
        this.decodeJobFactory = new DecodeJobFactory(this.diskCacheProvider);
        this.resourceRecycler = new ResourceRecycler();
        ((LruResourceCache) memoryCache).listener = this;
    }

    public static void logWithTimeAndKey(String str, long j, Key key) {
        StringBuilder outline78 = GeneratedOutlineSupport.outline78(str, " in ");
        outline78.append(LogTime.getElapsedMillis(j));
        outline78.append("ms, key: ");
        outline78.append(key);
        outline78.toString();
    }

    public <R> LoadStatus load(GlideContext glideContext, Object obj, Key key, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, Options options, boolean z3, boolean z4, boolean z5, boolean z6, ResourceCallback resourceCallback, Executor executor) {
        long logTime = VERBOSE_IS_LOGGABLE ? LogTime.getLogTime() : 0;
        if (this.keyFactory != null) {
            EngineKey engineKey = new EngineKey(obj, key, i, i2, map, cls, cls2, options);
            synchronized (this) {
                EngineResource<?> loadFromMemory = loadFromMemory(engineKey, z3, logTime);
                if (loadFromMemory == null) {
                    LoadStatus waitForExistingOrStartNewJob = waitForExistingOrStartNewJob(glideContext, obj, key, i, i2, cls, cls2, priority, diskCacheStrategy, map, z, z2, options, z3, z4, z5, z6, resourceCallback, executor, engineKey, logTime);
                    return waitForExistingOrStartNewJob;
                }
                ((SingleRequest) resourceCallback).onResourceReady(loadFromMemory, DataSource.MEMORY_CACHE);
                return null;
            }
        }
        throw null;
    }

    public final EngineResource<?> loadFromMemory(EngineKey engineKey, boolean z, long j) {
        EngineResource<?> engineResource;
        Y remove;
        EngineResource<?> engineResource2;
        if (!z) {
            return null;
        }
        ActiveResources activeResources2 = this.activeResources;
        synchronized (activeResources2) {
            ResourceWeakReference resourceWeakReference = activeResources2.activeEngineResources.get(engineKey);
            if (resourceWeakReference == null) {
                engineResource = null;
            } else {
                engineResource = (EngineResource) resourceWeakReference.get();
                if (engineResource == null) {
                    activeResources2.cleanupActiveReference(resourceWeakReference);
                }
            }
        }
        if (engineResource != null) {
            engineResource.acquire();
        }
        if (engineResource != null) {
            if (VERBOSE_IS_LOGGABLE) {
                logWithTimeAndKey("Loaded resource from active resources", j, engineKey);
            }
            return engineResource;
        }
        LruResourceCache lruResourceCache = (LruResourceCache) this.cache;
        synchronized (lruResourceCache) {
            remove = lruResourceCache.cache.remove(engineKey);
            if (remove != null) {
                lruResourceCache.currentSize -= (long) lruResourceCache.getSize(remove);
            }
        }
        Resource resource = (Resource) remove;
        if (resource == null) {
            engineResource2 = null;
        } else if (resource instanceof EngineResource) {
            engineResource2 = (EngineResource) resource;
        } else {
            EngineResource<?> engineResource3 = new EngineResource<>(resource, true, true, engineKey, this);
            engineResource2 = engineResource3;
        }
        if (engineResource2 != null) {
            engineResource2.acquire();
            this.activeResources.activate(engineKey, engineResource2);
        }
        if (engineResource2 == null) {
            return null;
        }
        if (VERBOSE_IS_LOGGABLE) {
            logWithTimeAndKey("Loaded resource from cache", j, engineKey);
        }
        return engineResource2;
    }

    public synchronized void onEngineJobComplete(EngineJob<?> engineJob, Key key, EngineResource<?> engineResource) {
        if (engineResource != null) {
            if (engineResource.isMemoryCacheable) {
                this.activeResources.activate(key, engineResource);
            }
        }
        Jobs jobs2 = this.jobs;
        if (jobs2 != null) {
            Map<Key, EngineJob<?>> jobMap = jobs2.getJobMap(engineJob.onlyRetrieveFromCache);
            if (engineJob.equals(jobMap.get(key))) {
                jobMap.remove(key);
            }
        } else {
            throw null;
        }
    }

    public void onResourceReleased(Key key, EngineResource<?> engineResource) {
        ActiveResources activeResources2 = this.activeResources;
        synchronized (activeResources2) {
            ResourceWeakReference remove = activeResources2.activeEngineResources.remove(key);
            if (remove != null) {
                remove.resource = null;
                remove.clear();
            }
        }
        if (engineResource.isMemoryCacheable) {
            ((LruResourceCache) this.cache).put(key, engineResource);
        } else {
            this.resourceRecycler.recycle(engineResource, false);
        }
    }

    public void release(Resource<?> resource) {
        if (resource instanceof EngineResource) {
            ((EngineResource) resource).release();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    public void shutdown() {
        EngineJobFactory engineJobFactory2 = this.engineJobFactory;
        Executors.shutdownAndAwaitTermination(engineJobFactory2.diskCacheExecutor);
        Executors.shutdownAndAwaitTermination(engineJobFactory2.sourceExecutor);
        Executors.shutdownAndAwaitTermination(engineJobFactory2.sourceUnlimitedExecutor);
        Executors.shutdownAndAwaitTermination(engineJobFactory2.animationExecutor);
        LazyDiskCacheProvider lazyDiskCacheProvider = this.diskCacheProvider;
        synchronized (lazyDiskCacheProvider) {
            if (lazyDiskCacheProvider.diskCache != null) {
                lazyDiskCacheProvider.diskCache.clear();
            }
        }
        ActiveResources activeResources2 = this.activeResources;
        activeResources2.isShutdown = true;
        Executor executor = activeResources2.monitorClearedResourcesExecutor;
        if (executor instanceof ExecutorService) {
            Executors.shutdownAndAwaitTermination((ExecutorService) executor);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00eb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <R> com.bumptech.glide.load.engine.Engine.LoadStatus waitForExistingOrStartNewJob(com.bumptech.glide.GlideContext r17, java.lang.Object r18, com.bumptech.glide.load.Key r19, int r20, int r21, java.lang.Class<?> r22, java.lang.Class<R> r23, com.bumptech.glide.Priority r24, com.bumptech.glide.load.engine.DiskCacheStrategy r25, java.util.Map<java.lang.Class<?>, com.bumptech.glide.load.Transformation<?>> r26, boolean r27, boolean r28, com.bumptech.glide.load.Options r29, boolean r30, boolean r31, boolean r32, boolean r33, com.bumptech.glide.request.ResourceCallback r34, java.util.concurrent.Executor r35, com.bumptech.glide.load.engine.EngineKey r36, long r37) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = r21
            r6 = r24
            r7 = r25
            r8 = r29
            r9 = r33
            r10 = r34
            r11 = r35
            r12 = r36
            r13 = r37
            com.bumptech.glide.load.engine.Jobs r15 = r1.jobs
            if (r9 == 0) goto L_0x0023
            java.util.Map<com.bumptech.glide.load.Key, com.bumptech.glide.load.engine.EngineJob<?>> r15 = r15.onlyCacheJobs
            goto L_0x0025
        L_0x0023:
            java.util.Map<com.bumptech.glide.load.Key, com.bumptech.glide.load.engine.EngineJob<?>> r15 = r15.jobs
        L_0x0025:
            java.lang.Object r15 = r15.get(r12)
            com.bumptech.glide.load.engine.EngineJob r15 = (com.bumptech.glide.load.engine.EngineJob) r15
            if (r15 == 0) goto L_0x003f
            r15.addCallback(r10, r11)
            boolean r0 = VERBOSE_IS_LOGGABLE
            if (r0 == 0) goto L_0x0039
            java.lang.String r0 = "Added to existing load"
            logWithTimeAndKey(r0, r13, r12)
        L_0x0039:
            com.bumptech.glide.load.engine.Engine$LoadStatus r0 = new com.bumptech.glide.load.engine.Engine$LoadStatus
            r0.<init>(r10, r15)
            return r0
        L_0x003f:
            com.bumptech.glide.load.engine.Engine$EngineJobFactory r15 = r1.engineJobFactory
            androidx.core.util.Pools$Pool<com.bumptech.glide.load.engine.EngineJob<?>> r15 = r15.pool
            java.lang.Object r15 = r15.acquire()
            com.bumptech.glide.load.engine.EngineJob r15 = (com.bumptech.glide.load.engine.EngineJob) r15
            java.lang.String r13 = "Argument must not be null"
            co.hyperverge.hypersnapsdk.c.k.checkNotNull(r15, r13)
            monitor-enter(r15)
            r15.key = r12     // Catch:{ all -> 0x0117 }
            r13 = r30
            r15.isCacheable = r13     // Catch:{ all -> 0x0117 }
            r13 = r31
            r15.useUnlimitedSourceGeneratorPool = r13     // Catch:{ all -> 0x0117 }
            r13 = r32
            r15.useAnimationPool = r13     // Catch:{ all -> 0x0117 }
            r15.onlyRetrieveFromCache = r9     // Catch:{ all -> 0x0117 }
            monitor-exit(r15)
            com.bumptech.glide.load.engine.Engine$DecodeJobFactory r13 = r1.decodeJobFactory
            androidx.core.util.Pools$Pool<com.bumptech.glide.load.engine.DecodeJob<?>> r14 = r13.pool
            java.lang.Object r14 = r14.acquire()
            com.bumptech.glide.load.engine.DecodeJob r14 = (com.bumptech.glide.load.engine.DecodeJob) r14
            java.lang.String r10 = "Argument must not be null"
            co.hyperverge.hypersnapsdk.c.k.checkNotNull(r14, r10)
            int r10 = r13.creationOrder
            int r11 = r10 + 1
            r13.creationOrder = r11
            com.bumptech.glide.load.engine.DecodeHelper<R> r11 = r14.decodeHelper
            com.bumptech.glide.load.engine.DecodeJob$DiskCacheProvider r13 = r14.diskCacheProvider
            r11.glideContext = r0
            r11.model = r2
            r11.signature = r3
            r11.width = r4
            r11.height = r5
            r11.diskCacheStrategy = r7
            r1 = r22
            r11.resourceClass = r1
            r11.diskCacheProvider = r13
            r1 = r23
            r11.transcodeClass = r1
            r11.priority = r6
            r11.options = r8
            r1 = r26
            r11.transformations = r1
            r1 = r27
            r11.isTransformationRequired = r1
            r1 = r28
            r11.isScaleOnlyOrNoTransform = r1
            r14.glideContext = r0
            r14.signature = r3
            r14.priority = r6
            r14.loadKey = r12
            r14.width = r4
            r14.height = r5
            r14.diskCacheStrategy = r7
            r14.onlyRetrieveFromCache = r9
            r14.options = r8
            r14.callback = r15
            r14.order = r10
            com.bumptech.glide.load.engine.DecodeJob$RunReason r0 = com.bumptech.glide.load.engine.DecodeJob.RunReason.INITIALIZE
            r14.runReason = r0
            r14.model = r2
            r1 = r16
            com.bumptech.glide.load.engine.Jobs r0 = r1.jobs
            if (r0 == 0) goto L_0x0115
            boolean r2 = r15.onlyRetrieveFromCache
            java.util.Map r0 = r0.getJobMap(r2)
            r0.put(r12, r15)
            r0 = r34
            r2 = r35
            r15.addCallback(r0, r2)
            monitor-enter(r15)
            r15.decodeJob = r14     // Catch:{ all -> 0x0112 }
            com.bumptech.glide.load.engine.DecodeJob$Stage r2 = com.bumptech.glide.load.engine.DecodeJob.Stage.INITIALIZE     // Catch:{ all -> 0x0112 }
            com.bumptech.glide.load.engine.DecodeJob$Stage r2 = r14.getNextStage(r2)     // Catch:{ all -> 0x0112 }
            com.bumptech.glide.load.engine.DecodeJob$Stage r3 = com.bumptech.glide.load.engine.DecodeJob.Stage.RESOURCE_CACHE     // Catch:{ all -> 0x0112 }
            if (r2 == r3) goto L_0x00e5
            com.bumptech.glide.load.engine.DecodeJob$Stage r3 = com.bumptech.glide.load.engine.DecodeJob.Stage.DATA_CACHE     // Catch:{ all -> 0x0112 }
            if (r2 != r3) goto L_0x00e3
            goto L_0x00e5
        L_0x00e3:
            r2 = 0
            goto L_0x00e6
        L_0x00e5:
            r2 = 1
        L_0x00e6:
            if (r2 == 0) goto L_0x00eb
            com.bumptech.glide.load.engine.executor.GlideExecutor r2 = r15.diskCacheExecutor     // Catch:{ all -> 0x0112 }
            goto L_0x00fb
        L_0x00eb:
            boolean r2 = r15.useUnlimitedSourceGeneratorPool     // Catch:{ all -> 0x0112 }
            if (r2 == 0) goto L_0x00f2
            com.bumptech.glide.load.engine.executor.GlideExecutor r2 = r15.sourceUnlimitedExecutor     // Catch:{ all -> 0x0112 }
            goto L_0x00fb
        L_0x00f2:
            boolean r2 = r15.useAnimationPool     // Catch:{ all -> 0x0112 }
            if (r2 == 0) goto L_0x00f9
            com.bumptech.glide.load.engine.executor.GlideExecutor r2 = r15.animationExecutor     // Catch:{ all -> 0x0112 }
            goto L_0x00fb
        L_0x00f9:
            com.bumptech.glide.load.engine.executor.GlideExecutor r2 = r15.sourceExecutor     // Catch:{ all -> 0x0112 }
        L_0x00fb:
            java.util.concurrent.ExecutorService r2 = r2.delegate     // Catch:{ all -> 0x0112 }
            r2.execute(r14)     // Catch:{ all -> 0x0112 }
            monitor-exit(r15)
            boolean r2 = VERBOSE_IS_LOGGABLE
            if (r2 == 0) goto L_0x010c
            java.lang.String r2 = "Started new load"
            r3 = r37
            logWithTimeAndKey(r2, r3, r12)
        L_0x010c:
            com.bumptech.glide.load.engine.Engine$LoadStatus r2 = new com.bumptech.glide.load.engine.Engine$LoadStatus
            r2.<init>(r0, r15)
            return r2
        L_0x0112:
            r0 = move-exception
            monitor-exit(r15)
            throw r0
        L_0x0115:
            r0 = 0
            throw r0
        L_0x0117:
            r0 = move-exception
            monitor-exit(r15)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.Engine.waitForExistingOrStartNewJob(com.bumptech.glide.GlideContext, java.lang.Object, com.bumptech.glide.load.Key, int, int, java.lang.Class, java.lang.Class, com.bumptech.glide.Priority, com.bumptech.glide.load.engine.DiskCacheStrategy, java.util.Map, boolean, boolean, com.bumptech.glide.load.Options, boolean, boolean, boolean, boolean, com.bumptech.glide.request.ResourceCallback, java.util.concurrent.Executor, com.bumptech.glide.load.engine.EngineKey, long):com.bumptech.glide.load.engine.Engine$LoadStatus");
    }
}
