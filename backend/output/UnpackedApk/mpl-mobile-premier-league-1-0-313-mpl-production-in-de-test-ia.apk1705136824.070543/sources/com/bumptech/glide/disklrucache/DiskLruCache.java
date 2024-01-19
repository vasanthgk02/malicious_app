package com.bumptech.glide.disklrucache;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.okhttp3.MemoryLruCache;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.fontbox.cmap.CMap;

public final class DiskLruCache implements Closeable {
    public final int appVersion;
    public final Callable<Void> cleanupCallable;
    public final File directory;
    public final ThreadPoolExecutor executorService;
    public final File journalFile;
    public final File journalFileBackup;
    public final File journalFileTmp;
    public Writer journalWriter;
    public final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap<>(0, 0.75f, true);
    public long maxSize;
    public long nextSequenceNumber = 0;
    public int redundantOpCount;
    public long size = 0;
    public final int valueCount;

    public static final class DiskLruCacheThreadFactory implements ThreadFactory {
        public DiskLruCacheThreadFactory(AnonymousClass1 r1) {
        }

        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    public final class Editor {
        public boolean committed;
        public final Entry entry;
        public final boolean[] written;

        public Editor(Entry entry2, AnonymousClass1 r3) {
            boolean[] zArr;
            this.entry = entry2;
            if (entry2.readable) {
                zArr = null;
            } else {
                zArr = new boolean[DiskLruCache.this.valueCount];
            }
            this.written = zArr;
        }

        public void abort() throws IOException {
            DiskLruCache.access$2100(DiskLruCache.this, this, false);
        }

        public File getFile(int i) throws IOException {
            File file;
            synchronized (DiskLruCache.this) {
                if (this.entry.currentEditor == this) {
                    if (!this.entry.readable) {
                        this.written[i] = true;
                    }
                    file = this.entry.dirtyFiles[i];
                    if (!DiskLruCache.this.directory.exists()) {
                        DiskLruCache.this.directory.mkdirs();
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
            return file;
        }
    }

    public final class Entry {
        public File[] cleanFiles;
        public Editor currentEditor;
        public File[] dirtyFiles;
        public final String key;
        public final long[] lengths;
        public boolean readable;
        public long sequenceNumber;

        public Entry(String str, AnonymousClass1 r8) {
            this.key = str;
            int i = DiskLruCache.this.valueCount;
            this.lengths = new long[i];
            this.cleanFiles = new File[i];
            this.dirtyFiles = new File[i];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i2 = 0; i2 < DiskLruCache.this.valueCount; i2++) {
                sb.append(i2);
                this.cleanFiles[i2] = new File(DiskLruCache.this.directory, sb.toString());
                sb.append(".tmp");
                this.dirtyFiles[i2] = new File(DiskLruCache.this.directory, sb.toString());
                sb.setLength(length);
            }
        }

        public String getLengths() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long append : this.lengths) {
                sb.append(' ');
                sb.append(append);
            }
            return sb.toString();
        }

        public final IOException invalidLengths(String[] strArr) throws IOException {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("unexpected journal line: ");
            outline73.append(Arrays.toString(strArr));
            throw new IOException(outline73.toString());
        }
    }

    public final class Value {
        public final File[] files;

        public Value(String str, long j, File[] fileArr, long[] jArr, AnonymousClass1 r7) {
            this.files = fileArr;
        }
    }

    public DiskLruCache(File file, int i, int i2, long j) {
        File file2 = file;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DiskLruCacheThreadFactory(null));
        this.executorService = threadPoolExecutor;
        this.cleanupCallable = new Callable<Void>() {
            public Object call() throws Exception {
                synchronized (DiskLruCache.this) {
                    if (DiskLruCache.this.journalWriter != null) {
                        DiskLruCache.this.trimToSize();
                        if (DiskLruCache.this.journalRebuildRequired()) {
                            DiskLruCache.this.rebuildJournal();
                            DiskLruCache.this.redundantOpCount = 0;
                        }
                    }
                }
                return null;
            }
        };
        this.directory = file2;
        this.appVersion = i;
        this.journalFile = new File(file2, MemoryLruCache.JOURNAL_FILE);
        this.journalFileTmp = new File(file2, MemoryLruCache.JOURNAL_FILE_TEMP);
        this.journalFileBackup = new File(file2, MemoryLruCache.JOURNAL_FILE_BACKUP);
        this.valueCount = i2;
        this.maxSize = j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void access$2100(com.bumptech.glide.disklrucache.DiskLruCache r9, com.bumptech.glide.disklrucache.DiskLruCache.Editor r10, boolean r11) throws java.io.IOException {
        /*
            monitor-enter(r9)
            com.bumptech.glide.disklrucache.DiskLruCache$Entry r0 = r10.entry     // Catch:{ all -> 0x00f8 }
            com.bumptech.glide.disklrucache.DiskLruCache$Editor r1 = r0.currentEditor     // Catch:{ all -> 0x00f8 }
            if (r1 != r10) goto L_0x00f2
            r1 = 0
            if (r11 == 0) goto L_0x0046
            boolean r2 = r0.readable     // Catch:{ all -> 0x00f8 }
            if (r2 != 0) goto L_0x0046
            r2 = 0
        L_0x000f:
            int r3 = r9.valueCount     // Catch:{ all -> 0x00f8 }
            if (r2 >= r3) goto L_0x0046
            boolean[] r3 = r10.written     // Catch:{ all -> 0x00f8 }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x00f8 }
            if (r3 == 0) goto L_0x002c
            java.io.File[] r3 = r0.dirtyFiles     // Catch:{ all -> 0x00f8 }
            r3 = r3[r2]     // Catch:{ all -> 0x00f8 }
            boolean r3 = r3.exists()     // Catch:{ all -> 0x00f8 }
            if (r3 != 0) goto L_0x0029
            r10.abort()     // Catch:{ all -> 0x00f8 }
            monitor-exit(r9)
            goto L_0x00f1
        L_0x0029:
            int r2 = r2 + 1
            goto L_0x000f
        L_0x002c:
            r10.abort()     // Catch:{ all -> 0x00f8 }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00f8 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f8 }
            r11.<init>()     // Catch:{ all -> 0x00f8 }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r11.append(r0)     // Catch:{ all -> 0x00f8 }
            r11.append(r2)     // Catch:{ all -> 0x00f8 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00f8 }
            r10.<init>(r11)     // Catch:{ all -> 0x00f8 }
            throw r10     // Catch:{ all -> 0x00f8 }
        L_0x0046:
            int r10 = r9.valueCount     // Catch:{ all -> 0x00f8 }
            if (r1 >= r10) goto L_0x0076
            java.io.File[] r10 = r0.dirtyFiles     // Catch:{ all -> 0x00f8 }
            r10 = r10[r1]     // Catch:{ all -> 0x00f8 }
            if (r11 == 0) goto L_0x0070
            boolean r2 = r10.exists()     // Catch:{ all -> 0x00f8 }
            if (r2 == 0) goto L_0x0073
            java.io.File[] r2 = r0.cleanFiles     // Catch:{ all -> 0x00f8 }
            r2 = r2[r1]     // Catch:{ all -> 0x00f8 }
            r10.renameTo(r2)     // Catch:{ all -> 0x00f8 }
            long[] r10 = r0.lengths     // Catch:{ all -> 0x00f8 }
            r3 = r10[r1]     // Catch:{ all -> 0x00f8 }
            long r5 = r2.length()     // Catch:{ all -> 0x00f8 }
            long[] r10 = r0.lengths     // Catch:{ all -> 0x00f8 }
            r10[r1] = r5     // Catch:{ all -> 0x00f8 }
            long r7 = r9.size     // Catch:{ all -> 0x00f8 }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.size = r7     // Catch:{ all -> 0x00f8 }
            goto L_0x0073
        L_0x0070:
            deleteIfExists(r10)     // Catch:{ all -> 0x00f8 }
        L_0x0073:
            int r1 = r1 + 1
            goto L_0x0046
        L_0x0076:
            int r10 = r9.redundantOpCount     // Catch:{ all -> 0x00f8 }
            r1 = 1
            int r10 = r10 + r1
            r9.redundantOpCount = r10     // Catch:{ all -> 0x00f8 }
            r10 = 0
            r0.currentEditor = r10     // Catch:{ all -> 0x00f8 }
            boolean r10 = r0.readable     // Catch:{ all -> 0x00f8 }
            r10 = r10 | r11
            r2 = 10
            r3 = 32
            if (r10 == 0) goto L_0x00b7
            r0.readable = r1     // Catch:{ all -> 0x00f8 }
            java.io.Writer r10 = r9.journalWriter     // Catch:{ all -> 0x00f8 }
            java.lang.String r1 = "CLEAN"
            r10.append(r1)     // Catch:{ all -> 0x00f8 }
            java.io.Writer r10 = r9.journalWriter     // Catch:{ all -> 0x00f8 }
            r10.append(r3)     // Catch:{ all -> 0x00f8 }
            java.io.Writer r10 = r9.journalWriter     // Catch:{ all -> 0x00f8 }
            java.lang.String r1 = r0.key     // Catch:{ all -> 0x00f8 }
            r10.append(r1)     // Catch:{ all -> 0x00f8 }
            java.io.Writer r10 = r9.journalWriter     // Catch:{ all -> 0x00f8 }
            java.lang.String r1 = r0.getLengths()     // Catch:{ all -> 0x00f8 }
            r10.append(r1)     // Catch:{ all -> 0x00f8 }
            java.io.Writer r10 = r9.journalWriter     // Catch:{ all -> 0x00f8 }
            r10.append(r2)     // Catch:{ all -> 0x00f8 }
            if (r11 == 0) goto L_0x00d6
            long r10 = r9.nextSequenceNumber     // Catch:{ all -> 0x00f8 }
            r1 = 1
            long r1 = r1 + r10
            r9.nextSequenceNumber = r1     // Catch:{ all -> 0x00f8 }
            r0.sequenceNumber = r10     // Catch:{ all -> 0x00f8 }
            goto L_0x00d6
        L_0x00b7:
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.disklrucache.DiskLruCache$Entry> r10 = r9.lruEntries     // Catch:{ all -> 0x00f8 }
            java.lang.String r11 = r0.key     // Catch:{ all -> 0x00f8 }
            r10.remove(r11)     // Catch:{ all -> 0x00f8 }
            java.io.Writer r10 = r9.journalWriter     // Catch:{ all -> 0x00f8 }
            java.lang.String r11 = "REMOVE"
            r10.append(r11)     // Catch:{ all -> 0x00f8 }
            java.io.Writer r10 = r9.journalWriter     // Catch:{ all -> 0x00f8 }
            r10.append(r3)     // Catch:{ all -> 0x00f8 }
            java.io.Writer r10 = r9.journalWriter     // Catch:{ all -> 0x00f8 }
            java.lang.String r11 = r0.key     // Catch:{ all -> 0x00f8 }
            r10.append(r11)     // Catch:{ all -> 0x00f8 }
            java.io.Writer r10 = r9.journalWriter     // Catch:{ all -> 0x00f8 }
            r10.append(r2)     // Catch:{ all -> 0x00f8 }
        L_0x00d6:
            java.io.Writer r10 = r9.journalWriter     // Catch:{ all -> 0x00f8 }
            flushWriter(r10)     // Catch:{ all -> 0x00f8 }
            long r10 = r9.size     // Catch:{ all -> 0x00f8 }
            long r0 = r9.maxSize     // Catch:{ all -> 0x00f8 }
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x00e9
            boolean r10 = r9.journalRebuildRequired()     // Catch:{ all -> 0x00f8 }
            if (r10 == 0) goto L_0x00f0
        L_0x00e9:
            java.util.concurrent.ThreadPoolExecutor r10 = r9.executorService     // Catch:{ all -> 0x00f8 }
            java.util.concurrent.Callable<java.lang.Void> r11 = r9.cleanupCallable     // Catch:{ all -> 0x00f8 }
            r10.submit(r11)     // Catch:{ all -> 0x00f8 }
        L_0x00f0:
            monitor-exit(r9)
        L_0x00f1:
            return
        L_0x00f2:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00f8 }
            r10.<init>()     // Catch:{ all -> 0x00f8 }
            throw r10     // Catch:{ all -> 0x00f8 }
        L_0x00f8:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.access$2100(com.bumptech.glide.disklrucache.DiskLruCache, com.bumptech.glide.disklrucache.DiskLruCache$Editor, boolean):void");
    }

    @TargetApi(26)
    public static void closeWriter(Writer writer) throws IOException {
        if (VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static void deleteIfExists(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    @TargetApi(26)
    public static void flushWriter(Writer writer) throws IOException {
        if (VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static DiskLruCache open(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 > 0) {
            File file2 = new File(file, MemoryLruCache.JOURNAL_FILE_BACKUP);
            if (file2.exists()) {
                File file3 = new File(file, MemoryLruCache.JOURNAL_FILE);
                if (file3.exists()) {
                    file2.delete();
                } else {
                    renameTo(file2, file3, false);
                }
            }
            DiskLruCache diskLruCache = new DiskLruCache(file, i, i2, j);
            if (diskLruCache.journalFile.exists()) {
                try {
                    diskLruCache.readJournal();
                    diskLruCache.processJournal();
                    return diskLruCache;
                } catch (IOException e2) {
                    PrintStream printStream = System.out;
                    printStream.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                    diskLruCache.close();
                    Util.deleteContents(diskLruCache.directory);
                }
            }
            file.mkdirs();
            DiskLruCache diskLruCache2 = new DiskLruCache(file, i, i2, j);
            diskLruCache2.rebuildJournal();
            return diskLruCache2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    public static void renameTo(File file, File file2, boolean z) throws IOException {
        if (z) {
            deleteIfExists(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public final void checkNotClosed() {
        if (this.journalWriter == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void close() throws IOException {
        if (this.journalWriter != null) {
            Iterator it = new ArrayList(this.lruEntries.values()).iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                if (entry.currentEditor != null) {
                    entry.currentEditor.abort();
                }
            }
            trimToSize();
            closeWriter(this.journalWriter);
            this.journalWriter = null;
        }
    }

    public Editor edit(String str) throws IOException {
        synchronized (this) {
            checkNotClosed();
            Entry entry = this.lruEntries.get(str);
            if (entry == null) {
                entry = new Entry(str, null);
                this.lruEntries.put(str, entry);
            } else if (entry.currentEditor != null) {
                return null;
            }
            Editor editor = new Editor(entry, null);
            entry.currentEditor = editor;
            this.journalWriter.append(MemoryLruCache.DIRTY);
            this.journalWriter.append(' ');
            this.journalWriter.append(str);
            this.journalWriter.append(10);
            flushWriter(this.journalWriter);
            return editor;
        }
    }

    public synchronized Value get(String str) throws IOException {
        checkNotClosed();
        Entry entry = this.lruEntries.get(str);
        if (entry == null) {
            return null;
        }
        if (!entry.readable) {
            return null;
        }
        for (File exists : entry.cleanFiles) {
            if (!exists.exists()) {
                return null;
            }
        }
        this.redundantOpCount++;
        this.journalWriter.append(MemoryLruCache.READ);
        this.journalWriter.append(' ');
        this.journalWriter.append(str);
        this.journalWriter.append(10);
        if (journalRebuildRequired()) {
            this.executorService.submit(this.cleanupCallable);
        }
        Value value = new Value(str, entry.sequenceNumber, entry.cleanFiles, entry.lengths, null);
        return value;
    }

    public final boolean journalRebuildRequired() {
        int i = this.redundantOpCount;
        return i >= 2000 && i >= this.lruEntries.size();
    }

    public final void processJournal() throws IOException {
        deleteIfExists(this.journalFileTmp);
        Iterator<Entry> it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            int i = 0;
            if (next.currentEditor == null) {
                while (i < this.valueCount) {
                    this.size += next.lengths[i];
                    i++;
                }
            } else {
                next.currentEditor = null;
                while (i < this.valueCount) {
                    deleteIfExists(next.cleanFiles[i]);
                    deleteIfExists(next.dirtyFiles[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:16|17|(1:19)|(1:21)(1:22)|23|24|38) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r9.redundantOpCount = r2 - r9.lruEntries.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006d, code lost:
        if (r1.end == -1) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006f, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        if (r0 != false) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0072, code lost:
        rebuildJournal();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0076, code lost:
        r9.journalWriter = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(r9.journalFile, true), com.bumptech.glide.disklrucache.Util.US_ASCII));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0090, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0060 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:16:0x0060=Splitter:B:16:0x0060, B:28:0x0091=Splitter:B:28:0x0091} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void readJournal() throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            com.bumptech.glide.disklrucache.StrictLineReader r1 = new com.bumptech.glide.disklrucache.StrictLineReader
            java.io.FileInputStream r2 = new java.io.FileInputStream
            java.io.File r3 = r9.journalFile
            r2.<init>(r3)
            java.nio.charset.Charset r3 = com.bumptech.glide.disklrucache.Util.US_ASCII
            r1.<init>(r2, r3)
            java.lang.String r2 = r1.readLine()     // Catch:{ all -> 0x00bf }
            java.lang.String r3 = r1.readLine()     // Catch:{ all -> 0x00bf }
            java.lang.String r4 = r1.readLine()     // Catch:{ all -> 0x00bf }
            java.lang.String r5 = r1.readLine()     // Catch:{ all -> 0x00bf }
            java.lang.String r6 = r1.readLine()     // Catch:{ all -> 0x00bf }
            java.lang.String r7 = "libcore.io.DiskLruCache"
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x00bf }
            if (r7 == 0) goto L_0x0091
            java.lang.String r7 = "1"
            boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x00bf }
            if (r7 == 0) goto L_0x0091
            int r7 = r9.appVersion     // Catch:{ all -> 0x00bf }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x00bf }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x00bf }
            if (r4 == 0) goto L_0x0091
            int r4 = r9.valueCount     // Catch:{ all -> 0x00bf }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x00bf }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00bf }
            if (r4 == 0) goto L_0x0091
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x00bf }
            if (r4 == 0) goto L_0x0091
            r0 = 0
            r2 = 0
        L_0x0056:
            java.lang.String r3 = r1.readLine()     // Catch:{ EOFException -> 0x0060 }
            r9.readJournalLine(r3)     // Catch:{ EOFException -> 0x0060 }
            int r2 = r2 + 1
            goto L_0x0056
        L_0x0060:
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.disklrucache.DiskLruCache$Entry> r3 = r9.lruEntries     // Catch:{ all -> 0x00bf }
            int r3 = r3.size()     // Catch:{ all -> 0x00bf }
            int r2 = r2 - r3
            r9.redundantOpCount = r2     // Catch:{ all -> 0x00bf }
            int r2 = r1.end     // Catch:{ all -> 0x00bf }
            r3 = -1
            r4 = 1
            if (r2 != r3) goto L_0x0070
            r0 = 1
        L_0x0070:
            if (r0 == 0) goto L_0x0076
            r9.rebuildJournal()     // Catch:{ all -> 0x00bf }
            goto L_0x008b
        L_0x0076:
            java.io.BufferedWriter r0 = new java.io.BufferedWriter     // Catch:{ all -> 0x00bf }
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x00bf }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x00bf }
            java.io.File r5 = r9.journalFile     // Catch:{ all -> 0x00bf }
            r3.<init>(r5, r4)     // Catch:{ all -> 0x00bf }
            java.nio.charset.Charset r4 = com.bumptech.glide.disklrucache.Util.US_ASCII     // Catch:{ all -> 0x00bf }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x00bf }
            r0.<init>(r2)     // Catch:{ all -> 0x00bf }
            r9.journalWriter = r0     // Catch:{ all -> 0x00bf }
        L_0x008b:
            r1.close()     // Catch:{ RuntimeException -> 0x008f, Exception -> 0x008e }
        L_0x008e:
            return
        L_0x008f:
            r0 = move-exception
            throw r0
        L_0x0091:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x00bf }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bf }
            r7.<init>()     // Catch:{ all -> 0x00bf }
            java.lang.String r8 = "unexpected journal header: ["
            r7.append(r8)     // Catch:{ all -> 0x00bf }
            r7.append(r2)     // Catch:{ all -> 0x00bf }
            r7.append(r0)     // Catch:{ all -> 0x00bf }
            r7.append(r3)     // Catch:{ all -> 0x00bf }
            r7.append(r0)     // Catch:{ all -> 0x00bf }
            r7.append(r5)     // Catch:{ all -> 0x00bf }
            r7.append(r0)     // Catch:{ all -> 0x00bf }
            r7.append(r6)     // Catch:{ all -> 0x00bf }
            java.lang.String r0 = "]"
            r7.append(r0)     // Catch:{ all -> 0x00bf }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x00bf }
            r4.<init>(r0)     // Catch:{ all -> 0x00bf }
            throw r4     // Catch:{ all -> 0x00bf }
        L_0x00bf:
            r0 = move-exception
            r1.close()     // Catch:{ RuntimeException -> 0x00c4, Exception -> 0x00c3 }
        L_0x00c3:
            throw r0
        L_0x00c4:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.DiskLruCache.readJournal():void");
    }

    public final void readJournalLine(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                str2 = str.substring(i);
                if (indexOf == 6 && str.startsWith(MemoryLruCache.REMOVE)) {
                    this.lruEntries.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i, indexOf2);
            }
            Entry entry = this.lruEntries.get(str2);
            if (entry == null) {
                entry = new Entry(str2, null);
                this.lruEntries.put(str2, entry);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith(MemoryLruCache.CLEAN)) {
                String[] split = str.substring(indexOf2 + 1).split(CMap.SPACE);
                entry.readable = true;
                entry.currentEditor = null;
                if (split.length == DiskLruCache.this.valueCount) {
                    int i2 = 0;
                    while (i2 < split.length) {
                        try {
                            entry.lengths[i2] = Long.parseLong(split[i2]);
                            i2++;
                        } catch (NumberFormatException unused) {
                            entry.invalidLengths(split);
                            throw null;
                        }
                    }
                } else {
                    entry.invalidLengths(split);
                    throw null;
                }
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith(MemoryLruCache.DIRTY)) {
                entry.currentEditor = new Editor(entry, null);
            } else if (!(indexOf2 == -1 && indexOf == 4 && str.startsWith(MemoryLruCache.READ))) {
                throw new IOException(GeneratedOutlineSupport.outline50("unexpected journal line: ", str));
            }
            return;
        }
        throw new IOException(GeneratedOutlineSupport.outline50("unexpected journal line: ", str));
    }

    public final synchronized void rebuildJournal() throws IOException {
        if (this.journalWriter != null) {
            closeWriter(this.journalWriter);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFileTmp), Util.US_ASCII));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.appVersion));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.valueCount));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (Entry next : this.lruEntries.values()) {
                if (next.currentEditor != null) {
                    bufferedWriter.write("DIRTY " + next.key + 10);
                } else {
                    bufferedWriter.write("CLEAN " + next.key + next.getLengths() + 10);
                }
            }
            closeWriter(bufferedWriter);
            if (this.journalFile.exists()) {
                renameTo(this.journalFile, this.journalFileBackup, true);
            }
            renameTo(this.journalFileTmp, this.journalFile, false);
            this.journalFileBackup.delete();
            this.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, true), Util.US_ASCII));
        } finally {
            closeWriter(bufferedWriter);
        }
    }

    public final void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            String str = (String) this.lruEntries.entrySet().iterator().next().getKey();
            synchronized (this) {
                checkNotClosed();
                Entry entry = this.lruEntries.get(str);
                if (entry != null) {
                    if (entry.currentEditor == null) {
                        for (int i = 0; i < this.valueCount; i++) {
                            File file = entry.cleanFiles[i];
                            if (file.exists()) {
                                if (!file.delete()) {
                                    throw new IOException("failed to delete " + file);
                                }
                            }
                            this.size -= entry.lengths[i];
                            entry.lengths[i] = 0;
                        }
                        this.redundantOpCount++;
                        this.journalWriter.append(MemoryLruCache.REMOVE);
                        this.journalWriter.append(' ');
                        this.journalWriter.append(str);
                        this.journalWriter.append(10);
                        this.lruEntries.remove(str);
                        if (journalRebuildRequired()) {
                            this.executorService.submit(this.cleanupCallable);
                        }
                    }
                }
            }
        }
    }
}
