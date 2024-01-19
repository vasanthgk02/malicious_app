package com.facebook.cache.disk;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory;
import com.facebook.cache.common.NoOpCacheErrorLogger;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.DiskStorage.Entry;
import com.facebook.cache.disk.DiskStorage.Inserter;
import com.facebook.common.file.FileTreeVisitor;
import com.facebook.common.file.FileUtils$CreateDirectoryException;
import com.facebook.common.file.FileUtils$ParentDirNotFoundException;
import com.facebook.common.file.FileUtils$RenameException;
import com.facebook.common.internal.CountingOutputStream;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DefaultDiskStorage implements DiskStorage {
    public static final Class<?> TAG = DefaultDiskStorage.class;
    public static final long TEMP_FILE_LIFETIME_MS = TimeUnit.MINUTES.toMillis(30);
    public final CacheErrorLogger mCacheErrorLogger;
    public final Clock mClock;
    public final boolean mIsExternal;
    public final File mRootDirectory;
    public final File mVersionDirectory;

    public class EntriesCollector implements FileTreeVisitor {
        public final List<Entry> result = new ArrayList();

        public EntriesCollector(AnonymousClass1 r2) {
        }

        public void postVisitDirectory(File file) {
        }

        public void preVisitDirectory(File file) {
        }

        public void visitFile(File file) {
            FileInfo access$000 = DefaultDiskStorage.access$000(DefaultDiskStorage.this, file);
            if (access$000 != null && access$000.type == ".cnt") {
                this.result.add(new EntryImpl(access$000.resourceId, file, null));
            }
        }
    }

    public static class EntryImpl implements Entry {
        public final String id;
        public final FileBinaryResource resource;
        public long size;
        public long timestamp;

        public EntryImpl(String str, File file, AnonymousClass1 r3) {
            if (str != null) {
                this.id = str;
                this.resource = FileBinaryResource.createOrNull(file);
                this.size = -1;
                this.timestamp = -1;
                return;
            }
            throw null;
        }

        public String getId() {
            return this.id;
        }

        public long getSize() {
            if (this.size < 0) {
                this.size = this.resource.size();
            }
            return this.size;
        }

        public long getTimestamp() {
            if (this.timestamp < 0) {
                this.timestamp = this.resource.mFile.lastModified();
            }
            return this.timestamp;
        }
    }

    public static class FileInfo {
        public final String resourceId;
        public final String type;

        public FileInfo(String str, String str2) {
            this.type = str;
            this.resourceId = str2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.type);
            sb.append("(");
            return GeneratedOutlineSupport.outline62(sb, this.resourceId, ")");
        }
    }

    public static class IncompleteFileException extends IOException {
        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public IncompleteFileException(long j, long j2) {
            // StringBuilder outline76 = GeneratedOutlineSupport.outline76("File was not written completely. Expected: ", j, ", found: ");
            // outline76.append(j2);
            super(outline76.toString());
        }
    }

    public class InserterImpl implements Inserter {
        public final String mResourceId;
        public final File mTemporaryFile;

        public InserterImpl(String str, File file) {
            this.mResourceId = str;
            this.mTemporaryFile = file;
        }

        public boolean cleanUp() {
            return !this.mTemporaryFile.exists() || this.mTemporaryFile.delete();
        }

        public FileBinaryResource commit(Object obj) throws IOException {
            File contentFileFor = DefaultDiskStorage.this.getContentFileFor(this.mResourceId);
            try {
                k.rename(this.mTemporaryFile, contentFileFor);
                if (contentFileFor.exists()) {
                    if (((SystemClock) DefaultDiskStorage.this.mClock) != null) {
                        contentFileFor.setLastModified(System.currentTimeMillis());
                    } else {
                        throw null;
                    }
                }
                return FileBinaryResource.createOrNull(contentFileFor);
            } catch (FileUtils$RenameException e2) {
                Throwable cause = e2.getCause();
                if (cause == null) {
                    CacheErrorCategory cacheErrorCategory = CacheErrorCategory.WRITE_RENAME_FILE_OTHER;
                } else if (cause instanceof FileUtils$ParentDirNotFoundException) {
                    CacheErrorCategory cacheErrorCategory2 = CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND;
                } else if (cause instanceof FileNotFoundException) {
                    CacheErrorCategory cacheErrorCategory3 = CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND;
                } else {
                    CacheErrorCategory cacheErrorCategory4 = CacheErrorCategory.WRITE_RENAME_FILE_OTHER;
                }
                CacheErrorLogger cacheErrorLogger = DefaultDiskStorage.this.mCacheErrorLogger;
                Class<?> cls = DefaultDiskStorage.TAG;
                if (((NoOpCacheErrorLogger) cacheErrorLogger) != null) {
                    throw e2;
                }
                throw null;
            }
        }

        /* JADX INFO: finally extract failed */
        public void writeData(WriterCallback writerCallback, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.mTemporaryFile);
                try {
                    CountingOutputStream countingOutputStream = new CountingOutputStream(fileOutputStream);
                    writerCallback.write(countingOutputStream);
                    countingOutputStream.flush();
                    long j = countingOutputStream.mCount;
                    fileOutputStream.close();
                    if (this.mTemporaryFile.length() != j) {
                        throw new IncompleteFileException(j, this.mTemporaryFile.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e2) {
                CacheErrorLogger cacheErrorLogger = DefaultDiskStorage.this.mCacheErrorLogger;
                CacheErrorCategory cacheErrorCategory = CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND;
                Class<?> cls = DefaultDiskStorage.TAG;
                if (((NoOpCacheErrorLogger) cacheErrorLogger) != null) {
                    throw e2;
                }
                throw null;
            }
        }
    }

    public class PurgingVisitor implements FileTreeVisitor {
        public boolean insideBaseDirectory;

        public PurgingVisitor(AnonymousClass1 r2) {
        }

        public void postVisitDirectory(File file) {
            if (!DefaultDiskStorage.this.mRootDirectory.equals(file) && !this.insideBaseDirectory) {
                file.delete();
            }
            if (this.insideBaseDirectory && file.equals(DefaultDiskStorage.this.mVersionDirectory)) {
                this.insideBaseDirectory = false;
            }
        }

        public void preVisitDirectory(File file) {
            if (!this.insideBaseDirectory && file.equals(DefaultDiskStorage.this.mVersionDirectory)) {
                this.insideBaseDirectory = true;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x002a, code lost:
            if (r3 > (java.lang.System.currentTimeMillis() - com.facebook.cache.disk.DefaultDiskStorage.TEMP_FILE_LIFETIME_MS)) goto L_0x0037;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void visitFile(java.io.File r10) {
            /*
                r9 = this;
                boolean r0 = r9.insideBaseDirectory
                if (r0 == 0) goto L_0x003a
                com.facebook.cache.disk.DefaultDiskStorage r0 = com.facebook.cache.disk.DefaultDiskStorage.this
                com.facebook.cache.disk.DefaultDiskStorage$FileInfo r0 = com.facebook.cache.disk.DefaultDiskStorage.access$000(r0, r10)
                r1 = 0
                r2 = 1
                if (r0 != 0) goto L_0x000f
                goto L_0x0038
            L_0x000f:
                java.lang.String r0 = r0.type
                java.lang.String r3 = ".tmp"
                if (r0 != r3) goto L_0x002f
                long r3 = r10.lastModified()
                com.facebook.cache.disk.DefaultDiskStorage r0 = com.facebook.cache.disk.DefaultDiskStorage.this
                com.facebook.common.time.Clock r0 = r0.mClock
                com.facebook.common.time.SystemClock r0 = (com.facebook.common.time.SystemClock) r0
                if (r0 == 0) goto L_0x002d
                long r5 = java.lang.System.currentTimeMillis()
                long r7 = com.facebook.cache.disk.DefaultDiskStorage.TEMP_FILE_LIFETIME_MS
                long r5 = r5 - r7
                int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r0 <= 0) goto L_0x0038
                goto L_0x0037
            L_0x002d:
                r10 = 0
                throw r10
            L_0x002f:
                java.lang.String r3 = ".cnt"
                if (r0 != r3) goto L_0x0034
                r1 = 1
            L_0x0034:
                co.hyperverge.hypersnapsdk.c.k.checkState(r1)
            L_0x0037:
                r1 = 1
            L_0x0038:
                if (r1 != 0) goto L_0x003d
            L_0x003a:
                r10.delete()
            L_0x003d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.cache.disk.DefaultDiskStorage.PurgingVisitor.visitFile(java.io.File):void");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|(1:10)(1:11)) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        throw null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r7 = com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.OTHER;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        if (((com.facebook.cache.common.NoOpCacheErrorLogger) r9) != null) goto L_0x0021;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001a */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006f A[SYNTHETIC, Splitter:B:23:0x006f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DefaultDiskStorage(java.io.File r7, int r8, com.facebook.cache.common.CacheErrorLogger r9) {
        /*
            r6 = this;
            r6.<init>()
            r6.mRootDirectory = r7
            r0 = 0
            r1 = 0
            java.io.File r2 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x0023 }
            if (r2 == 0) goto L_0x002b
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0023 }
            java.lang.String r7 = r7.getCanonicalPath()     // Catch:{ IOException -> 0x001a }
            boolean r7 = r7.contains(r2)     // Catch:{ IOException -> 0x001a }
            goto L_0x002c
        L_0x001a:
            com.facebook.cache.common.CacheErrorLogger$CacheErrorCategory r7 = com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.OTHER     // Catch:{ Exception -> 0x0023 }
            r7 = r9
            com.facebook.cache.common.NoOpCacheErrorLogger r7 = (com.facebook.cache.common.NoOpCacheErrorLogger) r7     // Catch:{ Exception -> 0x0023 }
            if (r7 == 0) goto L_0x0022
            goto L_0x002b
        L_0x0022:
            throw r1     // Catch:{ Exception -> 0x0023 }
        L_0x0023:
            com.facebook.cache.common.CacheErrorLogger$CacheErrorCategory r7 = com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.OTHER
            r7 = r9
            com.facebook.cache.common.NoOpCacheErrorLogger r7 = (com.facebook.cache.common.NoOpCacheErrorLogger) r7
            if (r7 == 0) goto L_0x0093
        L_0x002b:
            r7 = 0
        L_0x002c:
            r6.mIsExternal = r7
            java.io.File r7 = new java.io.File
            java.io.File r2 = r6.mRootDirectory
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = "v2"
            r3[r0] = r4
            r4 = 100
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5 = 1
            r3[r5] = r4
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r4 = 2
            r3[r4] = r8
            java.lang.String r8 = "%s.ols%d.%d"
            java.lang.String r8 = java.lang.String.format(r1, r8, r3)
            r7.<init>(r2, r8)
            r6.mVersionDirectory = r7
            r6.mCacheErrorLogger = r9
            java.io.File r7 = r6.mRootDirectory
            boolean r7 = r7.exists()
            if (r7 != 0) goto L_0x005f
            goto L_0x006c
        L_0x005f:
            java.io.File r7 = r6.mVersionDirectory
            boolean r7 = r7.exists()
            if (r7 != 0) goto L_0x006d
            java.io.File r7 = r6.mRootDirectory
            co.hyperverge.hypersnapsdk.c.k.deleteRecursively(r7)
        L_0x006c:
            r0 = 1
        L_0x006d:
            if (r0 == 0) goto L_0x008e
            java.io.File r7 = r6.mVersionDirectory     // Catch:{ FileUtils$CreateDirectoryException -> 0x0075 }
            co.hyperverge.hypersnapsdk.c.k.mkdirs(r7)     // Catch:{ FileUtils$CreateDirectoryException -> 0x0075 }
            goto L_0x008e
        L_0x0075:
            com.facebook.cache.common.CacheErrorLogger r7 = r6.mCacheErrorLogger
            com.facebook.cache.common.CacheErrorLogger$CacheErrorCategory r8 = com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR
            java.lang.String r8 = "version directory could not be created: "
            java.lang.StringBuilder r8 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r8)
            java.io.File r9 = r6.mVersionDirectory
            r8.append(r9)
            r8.toString()
            com.facebook.cache.common.NoOpCacheErrorLogger r7 = (com.facebook.cache.common.NoOpCacheErrorLogger) r7
            if (r7 == 0) goto L_0x008d
            goto L_0x008e
        L_0x008d:
            throw r1
        L_0x008e:
            com.facebook.common.time.SystemClock r7 = com.facebook.common.time.SystemClock.INSTANCE
            r6.mClock = r7
            return
        L_0x0093:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.cache.disk.DefaultDiskStorage.<init>(java.io.File, int, com.facebook.cache.common.CacheErrorLogger):void");
    }

    public static FileInfo access$000(DefaultDiskStorage defaultDiskStorage, File file) {
        FileInfo fileInfo;
        if (defaultDiskStorage != null) {
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0) {
                String access$800 = access$800(name.substring(lastIndexOf));
                if (access$800 != null) {
                    String substring = name.substring(0, lastIndexOf);
                    if (access$800.equals(".tmp")) {
                        int lastIndexOf2 = substring.lastIndexOf(46);
                        if (lastIndexOf2 > 0) {
                            substring = substring.substring(0, lastIndexOf2);
                        }
                    }
                    fileInfo = new FileInfo(access$800, substring);
                    if (fileInfo == null && new File(defaultDiskStorage.getSubdirectoryPath(fileInfo.resourceId)).equals(file.getParentFile())) {
                        return fileInfo;
                    }
                    return null;
                }
            }
            fileInfo = null;
            if (fileInfo == null) {
                return null;
            }
            return fileInfo;
        }
        throw null;
    }

    public static String access$800(String str) {
        if (".cnt".equals(str)) {
            return ".cnt";
        }
        if (".tmp".equals(str)) {
            return ".tmp";
        }
        return null;
    }

    public void clearAll() {
        k.deleteContents(this.mRootDirectory);
    }

    public boolean contains(String str, Object obj) {
        return getContentFileFor(str).exists();
    }

    public final long doRemove(File file) {
        if (!file.exists()) {
            return 0;
        }
        long length = file.length();
        if (file.delete()) {
            return length;
        }
        return -1;
    }

    public File getContentFileFor(String str) {
        return new File(GeneratedOutlineSupport.outline63(GeneratedOutlineSupport.outline73(getSubdirectoryPath(str)), File.separator, str, ".cnt"));
    }

    public Collection getEntries() throws IOException {
        EntriesCollector entriesCollector = new EntriesCollector(null);
        k.walkFileTree(this.mVersionDirectory, entriesCollector);
        return Collections.unmodifiableList(entriesCollector.result);
    }

    public FileBinaryResource getResource(String str, Object obj) {
        File contentFileFor = getContentFileFor(str);
        if (!contentFileFor.exists()) {
            return null;
        }
        if (((SystemClock) this.mClock) != null) {
            contentFileFor.setLastModified(System.currentTimeMillis());
            return FileBinaryResource.createOrNull(contentFileFor);
        }
        throw null;
    }

    public final String getSubdirectoryPath(String str) {
        String valueOf = String.valueOf(Math.abs(str.hashCode() % 100));
        StringBuilder sb = new StringBuilder();
        sb.append(this.mVersionDirectory);
        return GeneratedOutlineSupport.outline62(sb, File.separator, valueOf);
    }

    public Inserter insert(String str, Object obj) throws IOException {
        File file = new File(getSubdirectoryPath(str));
        if (!file.exists()) {
            try {
                k.mkdirs(file);
            } catch (FileUtils$CreateDirectoryException e2) {
                CacheErrorLogger cacheErrorLogger = this.mCacheErrorLogger;
                CacheErrorCategory cacheErrorCategory = CacheErrorCategory.WRITE_CREATE_DIR;
                if (((NoOpCacheErrorLogger) cacheErrorLogger) != null) {
                    throw e2;
                }
                throw null;
            }
        }
        try {
            return new InserterImpl(str, File.createTempFile(str + ".", ".tmp", file));
        } catch (IOException e3) {
            CacheErrorLogger cacheErrorLogger2 = this.mCacheErrorLogger;
            CacheErrorCategory cacheErrorCategory2 = CacheErrorCategory.WRITE_CREATE_TEMPFILE;
            if (((NoOpCacheErrorLogger) cacheErrorLogger2) != null) {
                throw e3;
            }
            throw null;
        }
    }

    public boolean isExternal() {
        return this.mIsExternal;
    }

    public void purgeUnexpectedResources() {
        k.walkFileTree(this.mRootDirectory, new PurgingVisitor(null));
    }

    public long remove(Entry entry) {
        return doRemove(((EntryImpl) entry).resource.mFile);
    }

    public long remove(String str) {
        return doRemove(getContentFileFor(str));
    }
}
