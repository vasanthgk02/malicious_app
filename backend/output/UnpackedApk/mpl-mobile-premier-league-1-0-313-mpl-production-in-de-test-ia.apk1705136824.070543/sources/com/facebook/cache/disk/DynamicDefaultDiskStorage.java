package com.facebook.cache.disk;

import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory;
import com.facebook.cache.common.NoOpCacheErrorLogger;
import com.facebook.cache.disk.DiskStorage.Entry;
import com.facebook.cache.disk.DiskStorage.Inserter;
import com.facebook.common.file.FileUtils$CreateDirectoryException;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.common.logging.LoggingDelegate;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class DynamicDefaultDiskStorage implements DiskStorage {
    public static final Class<?> TAG = DynamicDefaultDiskStorage.class;
    public final String mBaseDirectoryName;
    public final Supplier<File> mBaseDirectoryPathSupplier;
    public final CacheErrorLogger mCacheErrorLogger;
    public volatile State mCurrentState = new State(null, null);
    public final int mVersion;

    public static class State {
        public final DiskStorage delegate;
        public final File rootDirectory;

        public State(File file, DiskStorage diskStorage) {
            this.delegate = diskStorage;
            this.rootDirectory = file;
        }
    }

    public DynamicDefaultDiskStorage(int i, Supplier<File> supplier, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.mCacheErrorLogger = cacheErrorLogger;
        this.mBaseDirectoryPathSupplier = supplier;
        this.mBaseDirectoryName = str;
    }

    public void clearAll() throws IOException {
        get().clearAll();
    }

    public boolean contains(String str, Object obj) throws IOException {
        return get().contains(str, obj);
    }

    public final void createStorage() throws IOException {
        File file = new File((File) this.mBaseDirectoryPathSupplier.get(), this.mBaseDirectoryName);
        try {
            k.mkdirs(file);
            Class<?> cls = TAG;
            String absolutePath = file.getAbsolutePath();
            if (((FLogDefaultLoggingDelegate) FLog.sHandler).isLoggable(3)) {
                LoggingDelegate loggingDelegate = FLog.sHandler;
                FLogDefaultLoggingDelegate fLogDefaultLoggingDelegate = (FLogDefaultLoggingDelegate) loggingDelegate;
                fLogDefaultLoggingDelegate.println(3, cls.getSimpleName(), FLog.formatString("Created cache directory %s", absolutePath));
            }
            this.mCurrentState = new State(file, new DefaultDiskStorage(file, this.mVersion, this.mCacheErrorLogger));
        } catch (FileUtils$CreateDirectoryException e2) {
            CacheErrorLogger cacheErrorLogger = this.mCacheErrorLogger;
            CacheErrorCategory cacheErrorCategory = CacheErrorCategory.WRITE_CREATE_DIR;
            if (((NoOpCacheErrorLogger) cacheErrorLogger) != null) {
                throw e2;
            }
            throw null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.facebook.cache.disk.DiskStorage get() throws java.io.IOException {
        /*
            r2 = this;
            monitor-enter(r2)
            com.facebook.cache.disk.DynamicDefaultDiskStorage$State r0 = r2.mCurrentState     // Catch:{ all -> 0x0038 }
            com.facebook.cache.disk.DiskStorage r1 = r0.delegate     // Catch:{ all -> 0x0038 }
            if (r1 == 0) goto L_0x0014
            java.io.File r0 = r0.rootDirectory     // Catch:{ all -> 0x0038 }
            if (r0 == 0) goto L_0x0014
            boolean r0 = r0.exists()     // Catch:{ all -> 0x0038 }
            if (r0 != 0) goto L_0x0012
            goto L_0x0014
        L_0x0012:
            r0 = 0
            goto L_0x0015
        L_0x0014:
            r0 = 1
        L_0x0015:
            if (r0 == 0) goto L_0x002d
            com.facebook.cache.disk.DynamicDefaultDiskStorage$State r0 = r2.mCurrentState     // Catch:{ all -> 0x0038 }
            com.facebook.cache.disk.DiskStorage r0 = r0.delegate     // Catch:{ all -> 0x0038 }
            if (r0 == 0) goto L_0x002a
            com.facebook.cache.disk.DynamicDefaultDiskStorage$State r0 = r2.mCurrentState     // Catch:{ all -> 0x0038 }
            java.io.File r0 = r0.rootDirectory     // Catch:{ all -> 0x0038 }
            if (r0 == 0) goto L_0x002a
            com.facebook.cache.disk.DynamicDefaultDiskStorage$State r0 = r2.mCurrentState     // Catch:{ all -> 0x0038 }
            java.io.File r0 = r0.rootDirectory     // Catch:{ all -> 0x0038 }
            co.hyperverge.hypersnapsdk.c.k.deleteRecursively(r0)     // Catch:{ all -> 0x0038 }
        L_0x002a:
            r2.createStorage()     // Catch:{ all -> 0x0038 }
        L_0x002d:
            com.facebook.cache.disk.DynamicDefaultDiskStorage$State r0 = r2.mCurrentState     // Catch:{ all -> 0x0038 }
            com.facebook.cache.disk.DiskStorage r0 = r0.delegate     // Catch:{ all -> 0x0038 }
            co.hyperverge.hypersnapsdk.c.k.checkNotNull1(r0)     // Catch:{ all -> 0x0038 }
            com.facebook.cache.disk.DiskStorage r0 = (com.facebook.cache.disk.DiskStorage) r0     // Catch:{ all -> 0x0038 }
            monitor-exit(r2)
            return r0
        L_0x0038:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.cache.disk.DynamicDefaultDiskStorage.get():com.facebook.cache.disk.DiskStorage");
    }

    public Collection<Entry> getEntries() throws IOException {
        return get().getEntries();
    }

    public FileBinaryResource getResource(String str, Object obj) throws IOException {
        return get().getResource(str, obj);
    }

    public Inserter insert(String str, Object obj) throws IOException {
        return get().insert(str, obj);
    }

    public boolean isExternal() {
        try {
            return get().isExternal();
        } catch (IOException unused) {
            return false;
        }
    }

    public void purgeUnexpectedResources() {
        try {
            get().purgeUnexpectedResources();
        } catch (IOException e2) {
            FLog.e(TAG, (String) "purgeUnexpectedResources", (Throwable) e2);
        }
    }

    public long remove(Entry entry) throws IOException {
        return get().remove(entry);
    }

    public long remove(String str) throws IOException {
        return get().remove(str);
    }
}
