package com.facebook.imagepipeline.cache;

import bolts.Task;
import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.instrumentation.FrescoInstrumenter;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public class BufferedDiskCache {
    public static final Class<?> TAG = BufferedDiskCache.class;
    public final FileCache mFileCache;
    public final ImageCacheStatsTracker mImageCacheStatsTracker;
    public final PooledByteBufferFactory mPooledByteBufferFactory;
    public final PooledByteStreams mPooledByteStreams;
    public final Executor mReadExecutor;
    public final StagingArea mStagingArea = StagingArea.getInstance();
    public final Executor mWriteExecutor;

    public BufferedDiskCache(FileCache fileCache, PooledByteBufferFactory pooledByteBufferFactory, PooledByteStreams pooledByteStreams, Executor executor, Executor executor2, ImageCacheStatsTracker imageCacheStatsTracker) {
        this.mFileCache = fileCache;
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
        this.mPooledByteStreams = pooledByteStreams;
        this.mReadExecutor = executor;
        this.mWriteExecutor = executor2;
        this.mImageCacheStatsTracker = imageCacheStatsTracker;
    }

    /* access modifiers changed from: private */
    public boolean checkInStagingAreaAndFileCache(CacheKey cacheKey) {
        EncodedImage encodedImage = this.mStagingArea.get(cacheKey);
        if (encodedImage != null) {
            encodedImage.close();
            FLog.v(TAG, (String) "Found image for %s in staging area", (Object) cacheKey.getUriString());
            this.mImageCacheStatsTracker.onStagingAreaHit(cacheKey);
            return true;
        }
        FLog.v(TAG, (String) "Did not find image for %s in staging area", (Object) cacheKey.getUriString());
        this.mImageCacheStatsTracker.onStagingAreaMiss(cacheKey);
        try {
            return ((DiskStorageCache) this.mFileCache).hasKey(cacheKey);
        } catch (Exception unused) {
            return false;
        }
    }

    private Task<Boolean> containsAsync(final CacheKey cacheKey) {
        try {
            final Object onBeforeSubmitWork = FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_containsAsync");
            return Task.call(new Callable<Boolean>() {
                public Boolean call() throws Exception {
                    Object onBeginWork = FrescoInstrumenter.onBeginWork(onBeforeSubmitWork, null);
                    try {
                        return Boolean.valueOf(BufferedDiskCache.this.checkInStagingAreaAndFileCache(cacheKey));
                    } finally {
                        FrescoInstrumenter.onEndWork(onBeginWork);
                    }
                }
            }, this.mReadExecutor);
        } catch (Exception e2) {
            FLog.w(TAG, e2, "Failed to schedule disk-cache read for %s", cacheKey.getUriString());
            return Task.forError(e2);
        }
    }

    private Task<EncodedImage> foundPinnedImage(CacheKey cacheKey, EncodedImage encodedImage) {
        FLog.v(TAG, (String) "Found image for %s in staging area", (Object) cacheKey.getUriString());
        this.mImageCacheStatsTracker.onStagingAreaHit(cacheKey);
        return Task.forResult(encodedImage);
    }

    private Task<EncodedImage> getAsync(final CacheKey cacheKey, final AtomicBoolean atomicBoolean) {
        try {
            final Object onBeforeSubmitWork = FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_getAsync");
            return Task.call(new Callable<EncodedImage>() {
                public EncodedImage call() throws Exception {
                    CloseableReference of;
                    Object onBeginWork = FrescoInstrumenter.onBeginWork(onBeforeSubmitWork, null);
                    try {
                        if (!atomicBoolean.get()) {
                            EncodedImage encodedImage = BufferedDiskCache.this.mStagingArea.get(cacheKey);
                            if (encodedImage != null) {
                                FLog.v(BufferedDiskCache.TAG, (String) "Found image for %s in staging area", (Object) cacheKey.getUriString());
                                BufferedDiskCache.this.mImageCacheStatsTracker.onStagingAreaHit(cacheKey);
                            } else {
                                FLog.v(BufferedDiskCache.TAG, (String) "Did not find image for %s in staging area", (Object) cacheKey.getUriString());
                                BufferedDiskCache.this.mImageCacheStatsTracker.onStagingAreaMiss(cacheKey);
                                try {
                                    PooledByteBuffer access$400 = BufferedDiskCache.this.readFromDiskCache(cacheKey);
                                    if (access$400 == null) {
                                        FrescoInstrumenter.onEndWork(onBeginWork);
                                        return null;
                                    }
                                    of = CloseableReference.of(access$400);
                                    EncodedImage encodedImage2 = new EncodedImage(of);
                                    if (of != null) {
                                        of.close();
                                    }
                                    encodedImage = encodedImage2;
                                } catch (Exception unused) {
                                    FrescoInstrumenter.onEndWork(onBeginWork);
                                    return null;
                                } catch (Throwable th) {
                                    if (of != null) {
                                        of.close();
                                    }
                                    throw th;
                                }
                            }
                            if (!Thread.interrupted()) {
                                return encodedImage;
                            }
                            FLog.v(BufferedDiskCache.TAG, "Host thread was interrupted, decreasing reference count");
                            encodedImage.close();
                            throw new InterruptedException();
                        }
                        throw new CancellationException();
                    } finally {
                        FrescoInstrumenter.onEndWork(onBeginWork);
                    }
                }
            }, this.mReadExecutor);
        } catch (Exception e2) {
            FLog.w(TAG, e2, "Failed to schedule disk-cache read for %s", cacheKey.getUriString());
            return Task.forError(e2);
        }
    }

    /* access modifiers changed from: private */
    public PooledByteBuffer readFromDiskCache(CacheKey cacheKey) throws IOException {
        FileInputStream fileInputStream;
        try {
            FLog.v(TAG, (String) "Disk cache read for %s", (Object) cacheKey.getUriString());
            FileBinaryResource resource = ((DiskStorageCache) this.mFileCache).getResource(cacheKey);
            if (resource == null) {
                FLog.v(TAG, (String) "Disk cache miss for %s", (Object) cacheKey.getUriString());
                this.mImageCacheStatsTracker.onDiskCacheMiss(cacheKey);
                return null;
            }
            FLog.v(TAG, (String) "Found entry in disk cache for %s", (Object) cacheKey.getUriString());
            this.mImageCacheStatsTracker.onDiskCacheHit(cacheKey);
            fileInputStream = new FileInputStream(resource.mFile);
            PooledByteBuffer newByteBuffer = this.mPooledByteBufferFactory.newByteBuffer(fileInputStream, (int) resource.size());
            fileInputStream.close();
            FLog.v(TAG, (String) "Successful read from disk cache for %s", (Object) cacheKey.getUriString());
            return newByteBuffer;
        } catch (IOException e2) {
            FLog.w(TAG, e2, "Exception reading from cache for %s", cacheKey.getUriString());
            this.mImageCacheStatsTracker.onDiskCacheGetFail(cacheKey);
            throw e2;
        } catch (Throwable th) {
            fileInputStream.close();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public void writeToDiskCache(CacheKey cacheKey, final EncodedImage encodedImage) {
        FLog.v(TAG, (String) "About to write to disk-cache for key %s", (Object) cacheKey.getUriString());
        try {
            ((DiskStorageCache) this.mFileCache).insert(cacheKey, new WriterCallback() {
                public void write(OutputStream outputStream) throws IOException {
                    BufferedDiskCache.this.mPooledByteStreams.copy(encodedImage.getInputStream(), outputStream);
                }
            });
            this.mImageCacheStatsTracker.onDiskCachePut(cacheKey);
            FLog.v(TAG, (String) "Successful disk-cache write for key %s", (Object) cacheKey.getUriString());
        } catch (IOException e2) {
            FLog.w(TAG, e2, "Failed to write to disk-cache for key %s", cacheKey.getUriString());
        }
    }

    public Task<Void> clearAll() {
        this.mStagingArea.clearAll();
        final Object onBeforeSubmitWork = FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_clearAll");
        try {
            return Task.call(new Callable<Void>() {
                public Void call() throws Exception {
                    Object onBeginWork = FrescoInstrumenter.onBeginWork(onBeforeSubmitWork, null);
                    try {
                        BufferedDiskCache.this.mStagingArea.clearAll();
                        ((DiskStorageCache) BufferedDiskCache.this.mFileCache).clearAll();
                        return null;
                    } finally {
                        FrescoInstrumenter.onEndWork(onBeginWork);
                    }
                }
            }, this.mWriteExecutor);
        } catch (Exception e2) {
            FLog.w(TAG, e2, "Failed to schedule disk-cache clear", new Object[0]);
            return Task.forError(e2);
        }
    }

    public Task<Boolean> contains(CacheKey cacheKey) {
        if (containsSync(cacheKey)) {
            return Task.forResult(Boolean.TRUE);
        }
        return containsAsync(cacheKey);
    }

    public boolean containsSync(CacheKey cacheKey) {
        return this.mStagingArea.containsKey(cacheKey) || ((DiskStorageCache) this.mFileCache).hasKeySync(cacheKey);
    }

    public boolean diskCheckSync(CacheKey cacheKey) {
        if (containsSync(cacheKey)) {
            return true;
        }
        return checkInStagingAreaAndFileCache(cacheKey);
    }

    public Task<EncodedImage> get(CacheKey cacheKey, AtomicBoolean atomicBoolean) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("BufferedDiskCache#get");
            }
            EncodedImage encodedImage = this.mStagingArea.get(cacheKey);
            if (encodedImage != null) {
                return foundPinnedImage(cacheKey, encodedImage);
            }
            Task<EncodedImage> async = getAsync(cacheKey, atomicBoolean);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            return async;
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    public long getSize() {
        return ((DiskStorageCache) this.mFileCache).mCacheStats.getSize();
    }

    public void put(final CacheKey cacheKey, EncodedImage encodedImage) {
        final EncodedImage cloneOrNull;
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("BufferedDiskCache#put");
            }
            if (cacheKey != null) {
                k.checkArgument(EncodedImage.isValid(encodedImage));
                this.mStagingArea.put(cacheKey, encodedImage);
                cloneOrNull = EncodedImage.cloneOrNull(encodedImage);
                final Object onBeforeSubmitWork = FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_putAsync");
                this.mWriteExecutor.execute(new Runnable() {
                    public void run() {
                        Object onBeginWork = FrescoInstrumenter.onBeginWork(onBeforeSubmitWork, null);
                        try {
                            BufferedDiskCache.this.writeToDiskCache(cacheKey, cloneOrNull);
                        } finally {
                            BufferedDiskCache.this.mStagingArea.remove(cacheKey, cloneOrNull);
                            EncodedImage.closeSafely(cloneOrNull);
                            FrescoInstrumenter.onEndWork(onBeginWork);
                        }
                    }
                });
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                    return;
                }
                return;
            }
            throw null;
        } catch (Exception e2) {
            FLog.w(TAG, e2, "Failed to schedule disk-cache write for %s", cacheKey.getUriString());
            this.mStagingArea.remove(cacheKey, encodedImage);
            EncodedImage.closeSafely(cloneOrNull);
        } catch (Throwable th) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            throw th;
        }
    }

    public Task<Void> remove(final CacheKey cacheKey) {
        if (cacheKey != null) {
            this.mStagingArea.remove(cacheKey);
            try {
                final Object onBeforeSubmitWork = FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_remove");
                return Task.call(new Callable<Void>() {
                    public Void call() throws Exception {
                        Object onBeginWork = FrescoInstrumenter.onBeginWork(onBeforeSubmitWork, null);
                        try {
                            BufferedDiskCache.this.mStagingArea.remove(cacheKey);
                            ((DiskStorageCache) BufferedDiskCache.this.mFileCache).remove(cacheKey);
                            return null;
                        } finally {
                            FrescoInstrumenter.onEndWork(onBeginWork);
                        }
                    }
                }, this.mWriteExecutor);
            } catch (Exception e2) {
                FLog.w(TAG, e2, "Failed to schedule disk-cache remove for %s", cacheKey.getUriString());
                return Task.forError(e2);
            }
        } else {
            throw null;
        }
    }
}
