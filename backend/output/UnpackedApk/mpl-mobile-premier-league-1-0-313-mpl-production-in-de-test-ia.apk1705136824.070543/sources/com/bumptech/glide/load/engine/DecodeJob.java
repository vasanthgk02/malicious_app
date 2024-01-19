package com.bumptech.glide.load.engine;

import android.os.Build.VERSION;
import android.util.Log;
import androidx.core.util.Pools$Pool;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback;
import com.bumptech.glide.load.engine.Engine.LazyDiskCacheProvider;
import com.bumptech.glide.load.engine.EngineJob.CallLoadFailed;
import com.bumptech.glide.load.engine.EngineJob.CallResourceReady;
import com.bumptech.glide.load.engine.EngineJob.EngineResourceFactory;
import com.bumptech.glide.load.engine.EngineJob.ResourceCallbackAndExecutor;
import com.bumptech.glide.load.engine.EngineJob.ResourceCallbacksAndExecutors;
import com.bumptech.glide.load.engine.EngineResource.ResourceListener;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.pool.FactoryPools.Poolable;
import com.bumptech.glide.util.pool.StateVerifier;
import com.bumptech.glide.util.pool.StateVerifier.DefaultStateVerifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DecodeJob<R> implements FetcherReadyCallback, Runnable, Comparable<DecodeJob<?>>, Poolable {
    public Callback<R> callback;
    public Key currentAttemptingKey;
    public Object currentData;
    public DataSource currentDataSource;
    public DataFetcher<?> currentFetcher;
    public volatile DataFetcherGenerator currentGenerator;
    public Key currentSourceKey;
    public Thread currentThread;
    public final DecodeHelper<R> decodeHelper = new DecodeHelper<>();
    public final DeferredEncodeManager<?> deferredEncodeManager = new DeferredEncodeManager<>();
    public final DiskCacheProvider diskCacheProvider;
    public DiskCacheStrategy diskCacheStrategy;
    public GlideContext glideContext;
    public int height;
    public volatile boolean isCallbackNotified;
    public volatile boolean isCancelled;
    public EngineKey loadKey;
    public Object model;
    public boolean onlyRetrieveFromCache;
    public Options options;
    public int order;
    public final Pools$Pool<DecodeJob<?>> pool;
    public Priority priority;
    public final ReleaseManager releaseManager = new ReleaseManager();
    public RunReason runReason;
    public Key signature;
    public Stage stage;
    public long startFetchTime;
    public final StateVerifier stateVerifier = new DefaultStateVerifier();
    public final List<Throwable> throwables = new ArrayList();
    public int width;

    public interface Callback<R> {
    }

    public final class DecodeCallback<Z> implements com.bumptech.glide.load.engine.DecodePath.DecodeCallback<Z> {
        public final DataSource dataSource;

        public DecodeCallback(DataSource dataSource2) {
            this.dataSource = dataSource2;
        }
    }

    public static class DeferredEncodeManager<Z> {
        public ResourceEncoder<Z> encoder;
        public Key key;
        public LockedResource<Z> toEncode;
    }

    public interface DiskCacheProvider {
    }

    public static class ReleaseManager {
        public boolean isEncodeComplete;
        public boolean isFailed;
        public boolean isReleased;

        public final boolean isComplete(boolean z) {
            return (this.isFailed || z || this.isEncodeComplete) && this.isReleased;
        }
    }

    public enum RunReason {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    public enum Stage {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    public DecodeJob(DiskCacheProvider diskCacheProvider2, Pools$Pool<DecodeJob<?>> pools$Pool) {
        this.diskCacheProvider = diskCacheProvider2;
        this.pool = pools$Pool;
    }

    public int compareTo(Object obj) {
        DecodeJob decodeJob = (DecodeJob) obj;
        int ordinal = this.priority.ordinal() - decodeJob.priority.ordinal();
        return ordinal == 0 ? this.order - decodeJob.order : ordinal;
    }

    public final <Data> Resource<R> decodeFromData(DataFetcher<?> dataFetcher, Data data, DataSource dataSource) throws GlideException {
        if (data == null) {
            dataFetcher.cleanup();
            return null;
        }
        try {
            long logTime = LogTime.getLogTime();
            Resource<R> decodeFromFetcher = decodeFromFetcher(data, dataSource);
            if (Log.isLoggable("DecodeJob", 2)) {
                logWithTimeAndKey("Decoded result " + decodeFromFetcher, logTime, null);
            }
            return decodeFromFetcher;
        } finally {
            dataFetcher.cleanup();
        }
    }

    public final <Data> Resource<R> decodeFromFetcher(Data data, DataSource dataSource) throws GlideException {
        DecodeHelper<R> decodeHelper2 = this.decodeHelper;
        LoadPath<Data, TResource, Transcode> loadPath = decodeHelper2.glideContext.getRegistry().getLoadPath(data.getClass(), decodeHelper2.resourceClass, decodeHelper2.transcodeClass);
        Options options2 = this.options;
        if (VERSION.SDK_INT >= 26) {
            boolean z = dataSource == DataSource.RESOURCE_DISK_CACHE || this.decodeHelper.isScaleOnlyOrNoTransform;
            Boolean bool = (Boolean) options2.get(Downsampler.ALLOW_HARDWARE_CONFIG);
            if (bool == null || (bool.booleanValue() && !z)) {
                options2 = new Options();
                options2.putAll(this.options);
                options2.values.put(Downsampler.ALLOW_HARDWARE_CONFIG, Boolean.valueOf(z));
            }
        }
        Options options3 = options2;
        DataRewinder rewinder = this.glideContext.getRegistry().getRewinder(data);
        try {
            return loadPath.load(rewinder, options3, this.width, this.height, new DecodeCallback(dataSource));
        } finally {
            rewinder.cleanup();
        }
    }

    public final void decodeFromRetrievedData() {
        Resource resource;
        LockedResource lockedResource;
        Resource resource2;
        boolean isComplete;
        DeferredEncodeManager<?> deferredEncodeManager2;
        if (Log.isLoggable("DecodeJob", 2)) {
            long j = this.startFetchTime;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("data: ");
            outline73.append(this.currentData);
            outline73.append(", cache key: ");
            outline73.append(this.currentSourceKey);
            outline73.append(", fetcher: ");
            outline73.append(this.currentFetcher);
            logWithTimeAndKey("Retrieved data", j, outline73.toString());
        }
        try {
            resource = decodeFromData(this.currentFetcher, this.currentData, this.currentDataSource);
        } catch (GlideException e2) {
            Key key = this.currentAttemptingKey;
            DataSource dataSource = this.currentDataSource;
            e2.key = key;
            e2.dataSource = dataSource;
            e2.dataClass = null;
            this.throwables.add(e2);
            resource = 0;
        }
        if (resource != 0) {
            DataSource dataSource2 = this.currentDataSource;
            if (resource instanceof Initializable) {
                ((Initializable) resource).initialize();
            }
            if (this.deferredEncodeManager.toEncode != null) {
                LockedResource obtain = LockedResource.obtain(resource);
                lockedResource = obtain;
                resource2 = obtain;
            } else {
                lockedResource = 0;
                resource2 = resource;
            }
            setNotifiedOrThrow();
            EngineJob engineJob = (EngineJob) this.callback;
            synchronized (engineJob) {
                engineJob.resource = resource2;
                engineJob.dataSource = dataSource2;
            }
            synchronized (engineJob) {
                engineJob.stateVerifier.throwIfRecycled();
                if (engineJob.isCancelled) {
                    engineJob.resource.recycle();
                    engineJob.release();
                } else if (engineJob.cbs.isEmpty()) {
                    throw new IllegalStateException("Received a resource without any callbacks to notify");
                } else if (!engineJob.hasResource) {
                    EngineResourceFactory engineResourceFactory = engineJob.engineResourceFactory;
                    Resource<?> resource3 = engineJob.resource;
                    boolean z = engineJob.isCacheable;
                    Key key2 = engineJob.key;
                    ResourceListener resourceListener = engineJob.resourceListener;
                    if (engineResourceFactory != null) {
                        EngineResource engineResource = new EngineResource(resource3, z, true, key2, resourceListener);
                        engineJob.engineResource = engineResource;
                        engineJob.hasResource = true;
                        ResourceCallbacksAndExecutors resourceCallbacksAndExecutors = engineJob.cbs;
                        if (resourceCallbacksAndExecutors != null) {
                            ArrayList arrayList = new ArrayList(resourceCallbacksAndExecutors.callbacksAndExecutors);
                            engineJob.incrementPendingCallbacks(arrayList.size() + 1);
                            Key key3 = engineJob.key;
                            EngineResource<?> engineResource2 = engineJob.engineResource;
                            ((Engine) engineJob.engineJobListener).onEngineJobComplete(engineJob, key3, engineResource2);
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                ResourceCallbackAndExecutor resourceCallbackAndExecutor = (ResourceCallbackAndExecutor) it.next();
                                resourceCallbackAndExecutor.executor.execute(new CallResourceReady(resourceCallbackAndExecutor.cb));
                            }
                            engineJob.decrementPendingCallbacks();
                        } else {
                            throw null;
                        }
                    } else {
                        throw null;
                    }
                } else {
                    throw new IllegalStateException("Already have resource");
                }
            }
            this.stage = Stage.ENCODE;
            try {
                if (this.deferredEncodeManager.toEncode != null) {
                    deferredEncodeManager2 = this.deferredEncodeManager;
                    DiskCacheProvider diskCacheProvider2 = this.diskCacheProvider;
                    Options options2 = this.options;
                    if (deferredEncodeManager2 != null) {
                        ((LazyDiskCacheProvider) diskCacheProvider2).getDiskCache().put(deferredEncodeManager2.key, new DataCacheWriter(deferredEncodeManager2.encoder, deferredEncodeManager2.toEncode, options2));
                        deferredEncodeManager2.toEncode.unlock();
                    } else {
                        throw null;
                    }
                }
                if (lockedResource != 0) {
                    lockedResource.unlock();
                }
                ReleaseManager releaseManager2 = this.releaseManager;
                synchronized (releaseManager2) {
                    releaseManager2.isEncodeComplete = true;
                    isComplete = releaseManager2.isComplete(false);
                }
                if (isComplete) {
                    releaseInternal();
                }
            } catch (Throwable th) {
                if (lockedResource != 0) {
                    lockedResource.unlock();
                }
                throw th;
            }
        } else {
            runGenerators();
        }
    }

    public final DataFetcherGenerator getNextGenerator() {
        int ordinal = this.stage.ordinal();
        if (ordinal == 1) {
            return new ResourceCacheGenerator(this.decodeHelper, this);
        }
        if (ordinal == 2) {
            return new DataCacheGenerator(this.decodeHelper, this);
        }
        if (ordinal == 3) {
            return new SourceGenerator(this.decodeHelper, this);
        }
        if (ordinal == 5) {
            return null;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unrecognized stage: ");
        outline73.append(this.stage);
        throw new IllegalStateException(outline73.toString());
    }

    public final Stage getNextStage(Stage stage2) {
        Stage stage3;
        Stage stage4;
        int ordinal = stage2.ordinal();
        if (ordinal == 0) {
            if (this.diskCacheStrategy.decodeCachedResource()) {
                stage3 = Stage.RESOURCE_CACHE;
            } else {
                stage3 = getNextStage(Stage.RESOURCE_CACHE);
            }
            return stage3;
        } else if (ordinal == 1) {
            if (this.diskCacheStrategy.decodeCachedData()) {
                stage4 = Stage.DATA_CACHE;
            } else {
                stage4 = getNextStage(Stage.DATA_CACHE);
            }
            return stage4;
        } else if (ordinal == 2) {
            return this.onlyRetrieveFromCache ? Stage.FINISHED : Stage.SOURCE;
        } else if (ordinal == 3 || ordinal == 5) {
            return Stage.FINISHED;
        } else {
            throw new IllegalArgumentException("Unrecognized stage: " + stage2);
        }
    }

    public StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    public final void logWithTimeAndKey(String str, long j, String str2) {
        StringBuilder outline78 = GeneratedOutlineSupport.outline78(str, " in ");
        outline78.append(LogTime.getElapsedMillis(j));
        outline78.append(", load key: ");
        outline78.append(this.loadKey);
        outline78.append(str2 != null ? GeneratedOutlineSupport.outline50(", ", str2) : "");
        outline78.append(", thread: ");
        outline78.append(Thread.currentThread().getName());
        outline78.toString();
    }

    public final void notifyFailed() {
        boolean isComplete;
        setNotifiedOrThrow();
        GlideException glideException = new GlideException((String) "Failed to load resource", (List<Throwable>) new ArrayList<Throwable>(this.throwables));
        EngineJob engineJob = (EngineJob) this.callback;
        synchronized (engineJob) {
            engineJob.exception = glideException;
        }
        synchronized (engineJob) {
            engineJob.stateVerifier.throwIfRecycled();
            if (engineJob.isCancelled) {
                engineJob.release();
            } else if (engineJob.cbs.isEmpty()) {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            } else if (!engineJob.hasLoadFailed) {
                engineJob.hasLoadFailed = true;
                Key key = engineJob.key;
                ResourceCallbacksAndExecutors resourceCallbacksAndExecutors = engineJob.cbs;
                if (resourceCallbacksAndExecutors != null) {
                    ArrayList arrayList = new ArrayList(resourceCallbacksAndExecutors.callbacksAndExecutors);
                    engineJob.incrementPendingCallbacks(arrayList.size() + 1);
                    ((Engine) engineJob.engineJobListener).onEngineJobComplete(engineJob, key, null);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ResourceCallbackAndExecutor resourceCallbackAndExecutor = (ResourceCallbackAndExecutor) it.next();
                        resourceCallbackAndExecutor.executor.execute(new CallLoadFailed(resourceCallbackAndExecutor.cb));
                    }
                    engineJob.decrementPendingCallbacks();
                } else {
                    throw null;
                }
            } else {
                throw new IllegalStateException("Already failed once");
            }
        }
        ReleaseManager releaseManager2 = this.releaseManager;
        synchronized (releaseManager2) {
            releaseManager2.isFailed = true;
            isComplete = releaseManager2.isComplete(false);
        }
        if (isComplete) {
            releaseInternal();
        }
    }

    public void onDataFetcherFailed(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        dataFetcher.cleanup();
        GlideException glideException = new GlideException((String) "Fetching data failed", (Throwable) exc);
        Class<?> dataClass = dataFetcher.getDataClass();
        glideException.key = key;
        glideException.dataSource = dataSource;
        glideException.dataClass = dataClass;
        this.throwables.add(glideException);
        if (Thread.currentThread() != this.currentThread) {
            this.runReason = RunReason.SWITCH_TO_SOURCE_SERVICE;
            ((EngineJob) this.callback).reschedule(this);
            return;
        }
        runGenerators();
    }

    public void onDataFetcherReady(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.currentSourceKey = key;
        this.currentData = obj;
        this.currentFetcher = dataFetcher;
        this.currentDataSource = dataSource;
        this.currentAttemptingKey = key2;
        if (Thread.currentThread() != this.currentThread) {
            this.runReason = RunReason.DECODE_DATA;
            ((EngineJob) this.callback).reschedule(this);
            return;
        }
        decodeFromRetrievedData();
    }

    public final void releaseInternal() {
        ReleaseManager releaseManager2 = this.releaseManager;
        synchronized (releaseManager2) {
            releaseManager2.isEncodeComplete = false;
            releaseManager2.isReleased = false;
            releaseManager2.isFailed = false;
        }
        DeferredEncodeManager<?> deferredEncodeManager2 = this.deferredEncodeManager;
        deferredEncodeManager2.key = null;
        deferredEncodeManager2.encoder = null;
        deferredEncodeManager2.toEncode = null;
        DecodeHelper<R> decodeHelper2 = this.decodeHelper;
        decodeHelper2.glideContext = null;
        decodeHelper2.model = null;
        decodeHelper2.signature = null;
        decodeHelper2.resourceClass = null;
        decodeHelper2.transcodeClass = null;
        decodeHelper2.options = null;
        decodeHelper2.priority = null;
        decodeHelper2.transformations = null;
        decodeHelper2.diskCacheStrategy = null;
        decodeHelper2.loadData.clear();
        decodeHelper2.isLoadDataSet = false;
        decodeHelper2.cacheKeys.clear();
        decodeHelper2.isCacheKeysSet = false;
        this.isCallbackNotified = false;
        this.glideContext = null;
        this.signature = null;
        this.options = null;
        this.priority = null;
        this.loadKey = null;
        this.callback = null;
        this.stage = null;
        this.currentGenerator = null;
        this.currentThread = null;
        this.currentSourceKey = null;
        this.currentData = null;
        this.currentDataSource = null;
        this.currentFetcher = null;
        this.startFetchTime = 0;
        this.isCancelled = false;
        this.model = null;
        this.throwables.clear();
        this.pool.release(this);
    }

    public void reschedule() {
        this.runReason = RunReason.SWITCH_TO_SOURCE_SERVICE;
        ((EngineJob) this.callback).reschedule(this);
    }

    public void run() {
        DataFetcher<?> dataFetcher = this.currentFetcher;
        try {
            if (this.isCancelled) {
                notifyFailed();
                if (dataFetcher != null) {
                    dataFetcher.cleanup();
                }
                return;
            }
            runWrapped();
            if (dataFetcher != null) {
                dataFetcher.cleanup();
            }
        } catch (CallbackException e2) {
            throw e2;
        } catch (Throwable th) {
            if (dataFetcher != null) {
                dataFetcher.cleanup();
            }
            throw th;
        }
    }

    public final void runGenerators() {
        this.currentThread = Thread.currentThread();
        this.startFetchTime = LogTime.getLogTime();
        boolean z = false;
        while (!this.isCancelled && this.currentGenerator != null) {
            z = this.currentGenerator.startNext();
            if (z) {
                break;
            }
            this.stage = getNextStage(this.stage);
            this.currentGenerator = getNextGenerator();
            if (this.stage == Stage.SOURCE) {
                this.runReason = RunReason.SWITCH_TO_SOURCE_SERVICE;
                ((EngineJob) this.callback).reschedule(this);
                return;
            }
        }
        if ((this.stage == Stage.FINISHED || this.isCancelled) && !z) {
            notifyFailed();
        }
    }

    public final void runWrapped() {
        int ordinal = this.runReason.ordinal();
        if (ordinal == 0) {
            this.stage = getNextStage(Stage.INITIALIZE);
            this.currentGenerator = getNextGenerator();
            runGenerators();
        } else if (ordinal == 1) {
            runGenerators();
        } else if (ordinal == 2) {
            decodeFromRetrievedData();
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unrecognized run reason: ");
            outline73.append(this.runReason);
            throw new IllegalStateException(outline73.toString());
        }
    }

    public final void setNotifiedOrThrow() {
        this.stateVerifier.throwIfRecycled();
        if (this.isCallbackNotified) {
            throw new IllegalStateException("Already notified", this.throwables.isEmpty() ? null : (Throwable) GeneratedOutlineSupport.outline30(this.throwables, 1));
        }
        this.isCallbackNotified = true;
    }
}
