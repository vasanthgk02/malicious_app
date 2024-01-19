package com.facebook.imagepipeline.core;

import android.net.Uri;
import bolts.Continuation;
import bolts.ExecutorException;
import bolts.Task;
import bolts.TaskCompletionSource;
import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.cache.common.CacheKey;
import com.facebook.callercontext.CallerContextVerifier;
import com.facebook.common.internal.Objects$ToStringHelper;
import com.facebook.common.internal.Predicate;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.SimpleDataSource;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.datasource.CloseableProducerToDataSourceAdapter;
import com.facebook.imagepipeline.datasource.ProducerToDataSourceAdapter;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.listener.ForwardingRequestListener2;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.listener.RequestListener2;
import com.facebook.imagepipeline.producers.InternalRequestListener;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.CacheChoice;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;

public class ImagePipeline {
    public static final CancellationException PREFETCH_EXCEPTION = new CancellationException("Prefetching is not enabled");
    public final MemoryCache<CacheKey, CloseableImage> mBitmapMemoryCache;
    public final CacheKeyFactory mCacheKeyFactory;
    public final CallerContextVerifier mCallerContextVerifier;
    public final ImagePipelineConfig mConfig;
    public final MemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
    public AtomicLong mIdCounter = new AtomicLong();
    public final Supplier<Boolean> mIsPrefetchEnabledSupplier;
    public final Supplier<Boolean> mLazyDataSource;
    public final BufferedDiskCache mMainBufferedDiskCache;
    public final ProducerSequenceFactory mProducerSequenceFactory;
    public final RequestListener mRequestListener;
    public final RequestListener2 mRequestListener2;
    public final BufferedDiskCache mSmallImageBufferedDiskCache;
    public final Supplier<Boolean> mSuppressBitmapPrefetchingSupplier;
    public final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;

    /* renamed from: com.facebook.imagepipeline.core.ImagePipeline$9  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass9 {
        public static final /* synthetic */ int[] $SwitchMap$com$facebook$imagepipeline$request$ImageRequest$CacheChoice;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000e */
        static {
            /*
                com.facebook.imagepipeline.request.ImageRequest$CacheChoice[] r0 = com.facebook.imagepipeline.request.ImageRequest.CacheChoice.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$imagepipeline$request$ImageRequest$CacheChoice = r0
                com.facebook.imagepipeline.request.ImageRequest$CacheChoice r1 = com.facebook.imagepipeline.request.ImageRequest.CacheChoice.DEFAULT     // Catch:{ NoSuchFieldError -> 0x000e }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                int[] r0 = $SwitchMap$com$facebook$imagepipeline$request$ImageRequest$CacheChoice     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.facebook.imagepipeline.request.ImageRequest$CacheChoice r1 = com.facebook.imagepipeline.request.ImageRequest.CacheChoice.SMALL     // Catch:{ NoSuchFieldError -> 0x0016 }
                r1 = 0
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.core.ImagePipeline.AnonymousClass9.<clinit>():void");
        }
    }

    public ImagePipeline(ProducerSequenceFactory producerSequenceFactory, Set<RequestListener> set, Set<RequestListener2> set2, Supplier<Boolean> supplier, MemoryCache<CacheKey, CloseableImage> memoryCache, MemoryCache<CacheKey, PooledByteBuffer> memoryCache2, BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, ThreadHandoffProducerQueue threadHandoffProducerQueue, Supplier<Boolean> supplier2, Supplier<Boolean> supplier3, CallerContextVerifier callerContextVerifier, ImagePipelineConfig imagePipelineConfig) {
        this.mProducerSequenceFactory = producerSequenceFactory;
        this.mRequestListener = new ForwardingRequestListener(set);
        this.mRequestListener2 = new ForwardingRequestListener2(set2);
        this.mIsPrefetchEnabledSupplier = supplier;
        this.mBitmapMemoryCache = memoryCache;
        this.mEncodedMemoryCache = memoryCache2;
        this.mMainBufferedDiskCache = bufferedDiskCache;
        this.mSmallImageBufferedDiskCache = bufferedDiskCache2;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mThreadHandoffProducerQueue = threadHandoffProducerQueue;
        this.mSuppressBitmapPrefetchingSupplier = supplier2;
        this.mLazyDataSource = supplier3;
        this.mCallerContextVerifier = callerContextVerifier;
        this.mConfig = imagePipelineConfig;
    }

    private Predicate<CacheKey> predicateForUri(final Uri uri) {
        return new Predicate<CacheKey>() {
            public boolean apply(CacheKey cacheKey) {
                return cacheKey.containsUri(uri);
            }
        };
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <T> com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<T>> submitFetchRequest(com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<T>> r15, com.facebook.imagepipeline.request.ImageRequest r16, com.facebook.imagepipeline.request.ImageRequest.RequestLevel r17, java.lang.Object r18, com.facebook.imagepipeline.listener.RequestListener r19, java.lang.String r20) {
        /*
            r14 = this;
            r1 = r14
            boolean r0 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "ImagePipeline#submitFetchRequest"
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection(r0)
        L_0x000c:
            com.facebook.imagepipeline.producers.InternalRequestListener r0 = new com.facebook.imagepipeline.producers.InternalRequestListener
            r3 = r16
            r2 = r19
            com.facebook.imagepipeline.listener.RequestListener r2 = r14.getRequestListenerForRequest(r3, r2)
            com.facebook.imagepipeline.listener.RequestListener2 r4 = r1.mRequestListener2
            r0.<init>(r2, r4)
            com.facebook.callercontext.CallerContextVerifier r2 = r1.mCallerContextVerifier
            r4 = 0
            r7 = r18
            if (r2 == 0) goto L_0x0025
            r2.verifyCallerContext(r7, r4)
        L_0x0025:
            com.facebook.imagepipeline.request.ImageRequest$RequestLevel r2 = r16.getLowestPermittedRequestLevel()     // Catch:{ Exception -> 0x006e }
            r5 = r17
            com.facebook.imagepipeline.request.ImageRequest$RequestLevel r8 = com.facebook.imagepipeline.request.ImageRequest.RequestLevel.getMax(r2, r5)     // Catch:{ Exception -> 0x006e }
            com.facebook.imagepipeline.producers.SettableProducerContext r13 = new com.facebook.imagepipeline.producers.SettableProducerContext     // Catch:{ Exception -> 0x006e }
            java.lang.String r5 = r14.generateUniqueFutureId()     // Catch:{ Exception -> 0x006e }
            r9 = 0
            boolean r2 = r16.getProgressiveRenderingEnabled()     // Catch:{ Exception -> 0x006e }
            if (r2 != 0) goto L_0x0049
            android.net.Uri r2 = r16.getSourceUri()     // Catch:{ Exception -> 0x006e }
            boolean r2 = com.facebook.common.util.UriUtil.isNetworkUri(r2)     // Catch:{ Exception -> 0x006e }
            if (r2 != 0) goto L_0x0047
            goto L_0x0049
        L_0x0047:
            r10 = 0
            goto L_0x004b
        L_0x0049:
            r2 = 1
            r10 = 1
        L_0x004b:
            com.facebook.imagepipeline.common.Priority r11 = r16.getPriority()     // Catch:{ Exception -> 0x006e }
            com.facebook.imagepipeline.core.ImagePipelineConfig r12 = r1.mConfig     // Catch:{ Exception -> 0x006e }
            r2 = r13
            r3 = r16
            r4 = r5
            r5 = r20
            r6 = r0
            r7 = r18
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x006e }
            r2 = r15
            com.facebook.datasource.DataSource r0 = com.facebook.imagepipeline.datasource.CloseableProducerToDataSourceAdapter.create(r15, r13, r0)     // Catch:{ Exception -> 0x006e }
            boolean r2 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r2 == 0) goto L_0x006b
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x006b:
            return r0
        L_0x006c:
            r0 = move-exception
            goto L_0x007d
        L_0x006e:
            r0 = move-exception
            com.facebook.datasource.DataSource r0 = co.hyperverge.hypersnapsdk.c.k.immediateFailedDataSource(r0)     // Catch:{ all -> 0x006c }
            boolean r2 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r2 == 0) goto L_0x007c
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x007c:
            return r0
        L_0x007d:
            boolean r2 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r2 == 0) goto L_0x0086
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x0086:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.core.ImagePipeline.submitFetchRequest(com.facebook.imagepipeline.producers.Producer, com.facebook.imagepipeline.request.ImageRequest, com.facebook.imagepipeline.request.ImageRequest$RequestLevel, java.lang.Object, com.facebook.imagepipeline.listener.RequestListener, java.lang.String):com.facebook.datasource.DataSource");
    }

    private DataSource<Void> submitPrefetchRequest(Producer<Void> producer, ImageRequest imageRequest, RequestLevel requestLevel, Object obj, Priority priority) {
        ImageRequest imageRequest2 = imageRequest;
        InternalRequestListener internalRequestListener = new InternalRequestListener(getRequestListenerForRequest(imageRequest, null), this.mRequestListener2);
        CallerContextVerifier callerContextVerifier = this.mCallerContextVerifier;
        if (callerContextVerifier != null) {
            callerContextVerifier.verifyCallerContext(obj, true);
        } else {
            Object obj2 = obj;
        }
        try {
            ImageRequest imageRequest3 = imageRequest;
            InternalRequestListener internalRequestListener2 = internalRequestListener;
            Object obj3 = obj;
            SettableProducerContext settableProducerContext = new SettableProducerContext(imageRequest3, generateUniqueFutureId(), internalRequestListener2, obj3, RequestLevel.getMax(imageRequest.getLowestPermittedRequestLevel(), requestLevel), true, false, priority, this.mConfig);
            Producer<Void> producer2 = producer;
            return ProducerToDataSourceAdapter.create(producer, settableProducerContext, internalRequestListener);
        } catch (Exception e2) {
            return k.immediateFailedDataSource(e2);
        }
    }

    public void clearCaches() {
        clearMemoryCaches();
        clearDiskCaches();
    }

    public void clearDiskCaches() {
        this.mMainBufferedDiskCache.clearAll();
        this.mSmallImageBufferedDiskCache.clearAll();
    }

    public void clearMemoryCaches() {
        AnonymousClass5 r0 = new Predicate<CacheKey>() {
            public boolean apply(CacheKey cacheKey) {
                return true;
            }
        };
        this.mBitmapMemoryCache.removeAll(r0);
        this.mEncodedMemoryCache.removeAll(r0);
    }

    public void evictFromCache(Uri uri) {
        evictFromMemoryCache(uri);
        evictFromDiskCache(uri);
    }

    public void evictFromDiskCache(Uri uri) {
        evictFromDiskCache(ImageRequest.fromUri(uri));
    }

    public void evictFromMemoryCache(Uri uri) {
        Predicate<CacheKey> predicateForUri = predicateForUri(uri);
        this.mBitmapMemoryCache.removeAll(predicateForUri);
        this.mEncodedMemoryCache.removeAll(predicateForUri);
    }

    public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest imageRequest, Object obj) {
        return fetchDecodedImage(imageRequest, obj, RequestLevel.FULL_FETCH);
    }

    public DataSource<CloseableReference<PooledByteBuffer>> fetchEncodedImage(ImageRequest imageRequest, Object obj) {
        return fetchEncodedImage(imageRequest, obj, null);
    }

    public DataSource<CloseableReference<CloseableImage>> fetchImageFromBitmapCache(ImageRequest imageRequest, Object obj) {
        return fetchDecodedImage(imageRequest, obj, RequestLevel.BITMAP_MEMORY_CACHE);
    }

    public String generateUniqueFutureId() {
        return String.valueOf(this.mIdCounter.getAndIncrement());
    }

    public MemoryCache<CacheKey, CloseableImage> getBitmapMemoryCache() {
        return this.mBitmapMemoryCache;
    }

    public CacheKey getCacheKey(ImageRequest imageRequest, Object obj) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ImagePipeline#getCacheKey");
        }
        CacheKeyFactory cacheKeyFactory = this.mCacheKeyFactory;
        CacheKey cacheKey = null;
        if (!(cacheKeyFactory == null || imageRequest == null)) {
            cacheKey = imageRequest.getPostprocessor() != null ? cacheKeyFactory.getPostprocessedBitmapCacheKey(imageRequest, obj) : cacheKeyFactory.getBitmapCacheKey(imageRequest, obj);
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return cacheKey;
    }

    public CacheKeyFactory getCacheKeyFactory() {
        return this.mCacheKeyFactory;
    }

    public CloseableReference<CloseableImage> getCachedImage(CacheKey cacheKey) {
        MemoryCache<CacheKey, CloseableImage> memoryCache = this.mBitmapMemoryCache;
        if (memoryCache == null || cacheKey == null) {
            return null;
        }
        CloseableReference<CloseableImage> closeableReference = memoryCache.get(cacheKey);
        if (closeableReference == null || ((CloseableImage) closeableReference.get()).getQualityInfo().isOfFullQuality()) {
            return closeableReference;
        }
        closeableReference.close();
        return null;
    }

    public ImagePipelineConfig getConfig() {
        return this.mConfig;
    }

    public Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier(final ImageRequest imageRequest, final Object obj, final RequestLevel requestLevel) {
        return new Supplier<DataSource<CloseableReference<CloseableImage>>>() {
            public String toString() {
                Objects$ToStringHelper stringHelper = k.toStringHelper(this);
                stringHelper.addHolder("uri", imageRequest.getSourceUri());
                return stringHelper.toString();
            }

            public DataSource<CloseableReference<CloseableImage>> get() {
                return ImagePipeline.this.fetchDecodedImage(imageRequest, obj, requestLevel);
            }
        };
    }

    public Supplier<DataSource<CloseableReference<PooledByteBuffer>>> getEncodedImageDataSourceSupplier(final ImageRequest imageRequest, final Object obj) {
        return new Supplier<DataSource<CloseableReference<PooledByteBuffer>>>() {
            public String toString() {
                Objects$ToStringHelper stringHelper = k.toStringHelper(this);
                stringHelper.addHolder("uri", imageRequest.getSourceUri());
                return stringHelper.toString();
            }

            public DataSource<CloseableReference<PooledByteBuffer>> get() {
                return ImagePipeline.this.fetchEncodedImage(imageRequest, obj);
            }
        };
    }

    public ProducerSequenceFactory getProducerSequenceFactory() {
        return this.mProducerSequenceFactory;
    }

    public RequestListener getRequestListenerForRequest(ImageRequest imageRequest, RequestListener requestListener) {
        if (requestListener == null) {
            if (imageRequest.getRequestListener() == null) {
                return this.mRequestListener;
            }
            return new ForwardingRequestListener(this.mRequestListener, imageRequest.getRequestListener());
        } else if (imageRequest.getRequestListener() == null) {
            return new ForwardingRequestListener(this.mRequestListener, requestListener);
        } else {
            return new ForwardingRequestListener(this.mRequestListener, requestListener, imageRequest.getRequestListener());
        }
    }

    public long getUsedDiskCacheSize() {
        return this.mSmallImageBufferedDiskCache.getSize() + this.mMainBufferedDiskCache.getSize();
    }

    public boolean hasCachedImage(CacheKey cacheKey) {
        MemoryCache<CacheKey, CloseableImage> memoryCache = this.mBitmapMemoryCache;
        if (memoryCache == null || cacheKey == null) {
            return false;
        }
        return memoryCache.contains(cacheKey);
    }

    public boolean isInBitmapMemoryCache(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.mBitmapMemoryCache.contains(predicateForUri(uri));
    }

    public DataSource<Boolean> isInDiskCache(Uri uri) {
        return isInDiskCache(ImageRequest.fromUri(uri));
    }

    public boolean isInDiskCacheSync(Uri uri) {
        return isInDiskCacheSync(uri, CacheChoice.SMALL) || isInDiskCacheSync(uri, CacheChoice.DEFAULT);
    }

    public Supplier<Boolean> isLazyDataSource() {
        return this.mLazyDataSource;
    }

    public boolean isPaused() {
        return this.mThreadHandoffProducerQueue.isQueueing();
    }

    public void pause() {
        this.mThreadHandoffProducerQueue.startQueueing();
    }

    public DataSource<Void> prefetchToBitmapCache(ImageRequest imageRequest, Object obj) {
        return prefetchToBitmapCache(imageRequest, obj, Priority.MEDIUM);
    }

    @Deprecated
    public DataSource<Void> prefetchToBitmapCacheWithHighPriority(ImageRequest imageRequest, Object obj) {
        return prefetchToBitmapCache(imageRequest, obj, Priority.HIGH);
    }

    public DataSource<Void> prefetchToDiskCache(ImageRequest imageRequest, Object obj) {
        return prefetchToDiskCache(imageRequest, obj, Priority.MEDIUM);
    }

    public DataSource<Void> prefetchToEncodedCache(ImageRequest imageRequest, Object obj) {
        return prefetchToEncodedCache(imageRequest, obj, Priority.MEDIUM);
    }

    public void resume() {
        this.mThreadHandoffProducerQueue.stopQueuing();
    }

    private DataSource<Void> prefetchToBitmapCache(ImageRequest imageRequest, Object obj, Priority priority) {
        boolean z;
        Producer<Void> producer;
        if (!((Boolean) this.mIsPrefetchEnabledSupplier.get()).booleanValue()) {
            return k.immediateFailedDataSource(PREFETCH_EXCEPTION);
        }
        try {
            Boolean shouldDecodePrefetches = imageRequest.shouldDecodePrefetches();
            if (shouldDecodePrefetches != null) {
                z = !shouldDecodePrefetches.booleanValue();
            } else {
                z = ((Boolean) this.mSuppressBitmapPrefetchingSupplier.get()).booleanValue();
            }
            if (z) {
                producer = this.mProducerSequenceFactory.getEncodedImagePrefetchProducerSequence(imageRequest);
            } else {
                producer = this.mProducerSequenceFactory.getDecodedImagePrefetchProducerSequence(imageRequest);
            }
            return submitPrefetchRequest(producer, imageRequest, RequestLevel.FULL_FETCH, obj, priority);
        } catch (Exception e2) {
            return k.immediateFailedDataSource(e2);
        }
    }

    public void evictFromDiskCache(ImageRequest imageRequest) {
        CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        this.mMainBufferedDiskCache.remove(encodedCacheKey);
        this.mSmallImageBufferedDiskCache.remove(encodedCacheKey);
    }

    public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest imageRequest, Object obj, RequestListener requestListener) {
        return fetchDecodedImage(imageRequest, obj, RequestLevel.FULL_FETCH, requestListener);
    }

    public DataSource<CloseableReference<PooledByteBuffer>> fetchEncodedImage(ImageRequest imageRequest, Object obj, RequestListener requestListener) {
        k.checkNotNull1(imageRequest.getSourceUri());
        try {
            Producer<CloseableReference<PooledByteBuffer>> encodedImageProducerSequence = this.mProducerSequenceFactory.getEncodedImageProducerSequence(imageRequest);
            if (imageRequest.getResizeOptions() != null) {
                imageRequest = ImageRequestBuilder.fromRequest(imageRequest).setResizeOptions(null).build();
            }
            return submitFetchRequest(encodedImageProducerSequence, imageRequest, RequestLevel.FULL_FETCH, obj, requestListener, null);
        } catch (Exception e2) {
            return k.immediateFailedDataSource(e2);
        }
    }

    public Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier(ImageRequest imageRequest, Object obj, RequestLevel requestLevel, RequestListener requestListener) {
        final ImageRequest imageRequest2 = imageRequest;
        final Object obj2 = obj;
        final RequestLevel requestLevel2 = requestLevel;
        final RequestListener requestListener2 = requestListener;
        AnonymousClass2 r0 = new Supplier<DataSource<CloseableReference<CloseableImage>>>() {
            public String toString() {
                Objects$ToStringHelper stringHelper = k.toStringHelper(this);
                stringHelper.addHolder("uri", imageRequest2.getSourceUri());
                return stringHelper.toString();
            }

            public DataSource<CloseableReference<CloseableImage>> get() {
                return ImagePipeline.this.fetchDecodedImage(imageRequest2, obj2, requestLevel2, requestListener2);
            }
        };
        return r0;
    }

    public DataSource<Boolean> isInDiskCache(ImageRequest imageRequest) {
        boolean z;
        final CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        final SimpleDataSource simpleDataSource = new SimpleDataSource();
        Task<Boolean> contains = this.mMainBufferedDiskCache.contains(encodedCacheKey);
        AnonymousClass7 r3 = new Continuation<Boolean, Task<Boolean>>() {
            public Task<Boolean> then(Task<Boolean> task) throws Exception {
                if (task.isCancelled() || task.isFaulted() || !((Boolean) task.getResult()).booleanValue()) {
                    return ImagePipeline.this.mSmallImageBufferedDiskCache.contains(encodedCacheKey);
                }
                return Task.forResult(Boolean.TRUE);
            }
        };
        if (contains != null) {
            Executor executor = Task.IMMEDIATE_EXECUTOR;
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            synchronized (contains.lock) {
                synchronized (contains.lock) {
                    z = contains.complete;
                }
                if (!z) {
                    contains.continuations.add(new Continuation<TResult, Void>(contains, taskCompletionSource, r3, executor) {
                        public final /* synthetic */ Continuation val$continuation;
                        public final /* synthetic */ CancellationToken val$ct = null;
                        public final /* synthetic */ Executor val$executor;
                        public final /* synthetic */ TaskCompletionSource val$tcs;

                        {
                            this.val$tcs = r2;
                            this.val$continuation = r3;
                            this.val$executor = r4;
                        }

                        public Object then(Task task) throws Exception {
                            TaskCompletionSource taskCompletionSource = this.val$tcs;
                            Continuation continuation = this.val$continuation;
                            try {
                                this.val$executor.execute(new Runnable(continuation, task) {
                                    public final /* synthetic */ Continuation val$continuation;
                                    public final /* synthetic */ CancellationToken val$ct = null;
                                    public final /* synthetic */ Task val$task;

                                    {
                                        this.val$continuation = r3;
                                        this.val$task = r4;
                                    }

                                    public void run() {
                                        try {
                                            Task task = (Task) this.val$continuation.then(this.val$task);
                                            if (task == null) {
                                                TaskCompletionSource.this.setResult(null);
                                            } else {
                                                task.continueWith(new Continuation<TContinuationResult, Void>() {
                                                    public Object then(Task task) throws Exception {
                                                        if (task.isCancelled()) {
                                                            TaskCompletionSource.this.setCancelled();
                                                        } else if (task.isFaulted()) {
                                                            TaskCompletionSource.this.setError(task.getError());
                                                        } else {
                                                            TaskCompletionSource.this.setResult(task.getResult());
                                                        }
                                                        return null;
                                                    }
                                                });
                                            }
                                        } catch (CancellationException unused) {
                                            TaskCompletionSource.this.setCancelled();
                                        } catch (Exception e2) {
                                            TaskCompletionSource.this.setError(e2);
                                        }
                                    }
                                });
                            } catch (Exception e2) {
                                taskCompletionSource.setError(new ExecutorException(e2));
                            }
                            return null;
                        }
                    });
                }
            }
            if (z) {
                try {
                    executor.execute(new Runnable(r3, contains) {
                        public final /* synthetic */ Continuation val$continuation;
                        public final /* synthetic */ CancellationToken val$ct = null;
                        public final /* synthetic */ Task val$task;

                        {
                            this.val$continuation = r3;
                            this.val$task = r4;
                        }

                        public void run() {
                            try {
                                Task task = (Task) this.val$continuation.then(this.val$task);
                                if (task == null) {
                                    TaskCompletionSource.this.setResult(null);
                                } else {
                                    task.continueWith(new Continuation<TContinuationResult, Void>() {
                                        public Object then(Task task) throws Exception {
                                            if (task.isCancelled()) {
                                                TaskCompletionSource.this.setCancelled();
                                            } else if (task.isFaulted()) {
                                                TaskCompletionSource.this.setError(task.getError());
                                            } else {
                                                TaskCompletionSource.this.setResult(task.getResult());
                                            }
                                            return null;
                                        }
                                    });
                                }
                            } catch (CancellationException unused) {
                                TaskCompletionSource.this.setCancelled();
                            } catch (Exception e2) {
                                TaskCompletionSource.this.setError(e2);
                            }
                        }
                    });
                } catch (Exception e2) {
                    taskCompletionSource.setError(new ExecutorException(e2));
                }
            }
            taskCompletionSource.task.continueWith(new Continuation<Boolean, Void>() {
                public Void then(Task<Boolean> task) throws Exception {
                    simpleDataSource.setResult(Boolean.valueOf(!task.isCancelled() && !task.isFaulted() && ((Boolean) task.getResult()).booleanValue()));
                    return null;
                }
            });
            return simpleDataSource;
        }
        throw null;
    }

    public DataSource<Void> prefetchToDiskCache(ImageRequest imageRequest, Object obj, Priority priority) {
        if (!((Boolean) this.mIsPrefetchEnabledSupplier.get()).booleanValue()) {
            return k.immediateFailedDataSource(PREFETCH_EXCEPTION);
        }
        try {
            return submitPrefetchRequest(this.mProducerSequenceFactory.getEncodedImagePrefetchProducerSequence(imageRequest), imageRequest, RequestLevel.FULL_FETCH, obj, priority);
        } catch (Exception e2) {
            return k.immediateFailedDataSource(e2);
        }
    }

    public DataSource<Void> prefetchToEncodedCache(ImageRequest imageRequest, Object obj, Priority priority) {
        if (!((Boolean) this.mIsPrefetchEnabledSupplier.get()).booleanValue()) {
            return k.immediateFailedDataSource(PREFETCH_EXCEPTION);
        }
        try {
            return submitPrefetchRequest(this.mProducerSequenceFactory.getEncodedImagePrefetchProducerSequence(imageRequest), imageRequest, RequestLevel.FULL_FETCH, obj, priority);
        } catch (Exception e2) {
            return k.immediateFailedDataSource(e2);
        }
    }

    public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest imageRequest, Object obj, RequestLevel requestLevel) {
        return fetchDecodedImage(imageRequest, obj, requestLevel, null);
    }

    public Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier(ImageRequest imageRequest, Object obj, RequestLevel requestLevel, RequestListener requestListener, String str) {
        final ImageRequest imageRequest2 = imageRequest;
        final Object obj2 = obj;
        final RequestLevel requestLevel2 = requestLevel;
        final RequestListener requestListener2 = requestListener;
        final String str2 = str;
        AnonymousClass3 r0 = new Supplier<DataSource<CloseableReference<CloseableImage>>>() {
            public String toString() {
                Objects$ToStringHelper stringHelper = k.toStringHelper(this);
                stringHelper.addHolder("uri", imageRequest2.getSourceUri());
                return stringHelper.toString();
            }

            public DataSource<CloseableReference<CloseableImage>> get() {
                return ImagePipeline.this.fetchDecodedImage(imageRequest2, obj2, requestLevel2, requestListener2, str2);
            }
        };
        return r0;
    }

    public boolean isInBitmapMemoryCache(ImageRequest imageRequest) {
        if (imageRequest == null) {
            return false;
        }
        CloseableReference closeableReference = this.mBitmapMemoryCache.get(this.mCacheKeyFactory.getBitmapCacheKey(imageRequest, null));
        try {
            boolean isValid = CloseableReference.isValid(closeableReference);
            if (closeableReference != null) {
                closeableReference.close();
            }
            return isValid;
        } catch (Throwable th) {
            CloseableReference.closeSafely(closeableReference);
            throw th;
        }
    }

    public boolean isInDiskCacheSync(Uri uri, CacheChoice cacheChoice) {
        return isInDiskCacheSync(ImageRequestBuilder.newBuilderWithSource(uri).setCacheChoice(cacheChoice).build());
    }

    public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest imageRequest, Object obj, RequestLevel requestLevel, RequestListener requestListener) {
        return fetchDecodedImage(imageRequest, obj, requestLevel, requestListener, null);
    }

    public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest imageRequest, Object obj, RequestLevel requestLevel, RequestListener requestListener, String str) {
        try {
            return submitFetchRequest(this.mProducerSequenceFactory.getDecodedImageProducerSequence(imageRequest), imageRequest, requestLevel, obj, requestListener, str);
        } catch (Exception e2) {
            return k.immediateFailedDataSource(e2);
        }
    }

    public boolean isInDiskCacheSync(ImageRequest imageRequest) {
        CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        int ordinal = imageRequest.getCacheChoice().ordinal();
        if (ordinal == 0) {
            return this.mSmallImageBufferedDiskCache.diskCheckSync(encodedCacheKey);
        }
        if (ordinal != 1) {
            return false;
        }
        return this.mMainBufferedDiskCache.diskCheckSync(encodedCacheKey);
    }

    public <T> DataSource<CloseableReference<T>> submitFetchRequest(Producer<CloseableReference<T>> producer, SettableProducerContext settableProducerContext, RequestListener requestListener) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ImagePipeline#submitFetchRequest");
        }
        try {
            DataSource<CloseableReference<T>> create = CloseableProducerToDataSourceAdapter.create(producer, settableProducerContext, new InternalRequestListener(requestListener, this.mRequestListener2));
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            return create;
        } catch (Exception e2) {
            DataSource<CloseableReference<T>> immediateFailedDataSource = k.immediateFailedDataSource(e2);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            return immediateFailedDataSource;
        } catch (Throwable th) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            throw th;
        }
    }
}
