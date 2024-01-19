package okhttp3.internal.cache;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.okhttp3.MemoryLruCache;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import kotlin.text.Regex;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.BufferedSink;
import okio.Okio;
import okio.Sink;
import okio.Source;
import org.apache.commons.lang.StringEscapeUtils;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010)\n\u0002\b\u0007*\u0001\u0014\u0018\u0000 [2\u00020\u00012\u00020\u0002:\u0004[\\]^B7\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u00108\u001a\u000209H\u0002J\b\u0010:\u001a\u000209H\u0016J!\u0010;\u001a\u0002092\n\u0010<\u001a\u00060=R\u00020\u00002\u0006\u0010>\u001a\u00020\u0010H\u0000¢\u0006\u0002\b?J\u0006\u0010@\u001a\u000209J \u0010A\u001a\b\u0018\u00010=R\u00020\u00002\u0006\u0010B\u001a\u00020(2\b\b\u0002\u0010C\u001a\u00020\u000bH\u0007J\u0006\u0010D\u001a\u000209J\b\u0010E\u001a\u000209H\u0016J\u0017\u0010F\u001a\b\u0018\u00010GR\u00020\u00002\u0006\u0010B\u001a\u00020(H\u0002J\u0006\u0010H\u001a\u000209J\u0006\u0010I\u001a\u00020\u0010J\b\u0010J\u001a\u00020\u0010H\u0002J\b\u0010K\u001a\u00020%H\u0002J\b\u0010L\u001a\u000209H\u0002J\b\u0010M\u001a\u000209H\u0002J\u0010\u0010N\u001a\u0002092\u0006\u0010O\u001a\u00020(H\u0002J\r\u0010P\u001a\u000209H\u0000¢\u0006\u0002\bQJ\u000e\u0010R\u001a\u00020\u00102\u0006\u0010B\u001a\u00020(J\u0019\u0010S\u001a\u00020\u00102\n\u0010T\u001a\u00060)R\u00020\u0000H\u0000¢\u0006\u0002\bUJ\b\u0010V\u001a\u00020\u0010H\u0002J\u0006\u00105\u001a\u00020\u000bJ\u0010\u0010W\u001a\f\u0012\b\u0012\u00060GR\u00020\u00000XJ\u0006\u0010Y\u001a\u000209J\u0010\u0010Z\u001a\u0002092\u0006\u0010B\u001a\u00020(H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R$\u0010&\u001a\u0012\u0012\u0004\u0012\u00020(\u0012\b\u0012\u00060)R\u00020\u00000'X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R&\u0010\n\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000b8F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u000e\u00101\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107¨\u0006_"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "fileSystem", "Lokhttp3/internal/io/FileSystem;", "directory", "Ljava/io/File;", "appVersion", "", "valueCount", "maxSize", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "(Lokhttp3/internal/io/FileSystem;Ljava/io/File;IIJLokhttp3/internal/concurrent/TaskRunner;)V", "civilizedFileSystem", "", "cleanupQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "cleanupTask", "okhttp3/internal/cache/DiskLruCache$cleanupTask$1", "Lokhttp3/internal/cache/DiskLruCache$cleanupTask$1;", "closed", "getClosed$okhttp", "()Z", "setClosed$okhttp", "(Z)V", "getDirectory", "()Ljava/io/File;", "getFileSystem$okhttp", "()Lokhttp3/internal/io/FileSystem;", "hasJournalErrors", "initialized", "journalFile", "journalFileBackup", "journalFileTmp", "journalWriter", "Lokio/BufferedSink;", "lruEntries", "Ljava/util/LinkedHashMap;", "", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "getLruEntries$okhttp", "()Ljava/util/LinkedHashMap;", "value", "getMaxSize", "()J", "setMaxSize", "(J)V", "mostRecentRebuildFailed", "mostRecentTrimFailed", "nextSequenceNumber", "redundantOpCount", "size", "getValueCount$okhttp", "()I", "checkNotClosed", "", "close", "completeEdit", "editor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "success", "completeEdit$okhttp", "delete", "edit", "key", "expectedSequenceNumber", "evictAll", "flush", "get", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "initialize", "isClosed", "journalRebuildRequired", "newJournalWriter", "processJournal", "readJournal", "readJournalLine", "line", "rebuildJournal", "rebuildJournal$okhttp", "remove", "removeEntry", "entry", "removeEntry$okhttp", "removeOldestEntry", "snapshots", "", "trimToSize", "validateKey", "Companion", "Editor", "Entry", "Snapshot", "okhttp"}, k = 1, mv = {1, 4, 0})
/* compiled from: DiskLruCache.kt */
public final class DiskLruCache implements Closeable, Flushable {
    public static final long ANY_SEQUENCE_NUMBER = -1;
    public static final String CLEAN = MemoryLruCache.CLEAN;
    public static final Companion Companion = new Companion(null);
    public static final String DIRTY = MemoryLruCache.DIRTY;
    public static final String JOURNAL_FILE = MemoryLruCache.JOURNAL_FILE;
    public static final String JOURNAL_FILE_BACKUP = MemoryLruCache.JOURNAL_FILE_BACKUP;
    public static final String JOURNAL_FILE_TEMP = MemoryLruCache.JOURNAL_FILE_TEMP;
    public static final Regex LEGAL_KEY_PATTERN = new Regex((String) "[a-z0-9_-]{1,120}");
    public static final String MAGIC = "libcore.io.DiskLruCache";
    public static final String READ = MemoryLruCache.READ;
    public static final String REMOVE = MemoryLruCache.REMOVE;
    public static final String VERSION_1 = "1";
    public final int appVersion;
    public boolean civilizedFileSystem;
    public final TaskQueue cleanupQueue;
    public final DiskLruCache$cleanupTask$1 cleanupTask;
    public boolean closed;
    public final File directory;
    public final FileSystem fileSystem;
    public boolean hasJournalErrors;
    public boolean initialized;
    public final File journalFile;
    public final File journalFileBackup;
    public final File journalFileTmp;
    public BufferedSink journalWriter;
    public final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap<>(0, 0.75f, true);
    public long maxSize;
    public boolean mostRecentRebuildFailed;
    public boolean mostRecentTrimFailed;
    public long nextSequenceNumber;
    public int redundantOpCount;
    public long size;
    public final int valueCount;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00068\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00068\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00068\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00068\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\f8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00068\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u00068\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00068\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00068\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Companion;", "", "()V", "ANY_SEQUENCE_NUMBER", "", "CLEAN", "", "DIRTY", "JOURNAL_FILE", "JOURNAL_FILE_BACKUP", "JOURNAL_FILE_TEMP", "LEGAL_KEY_PATTERN", "Lkotlin/text/Regex;", "MAGIC", "READ", "REMOVE", "VERSION_1", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* compiled from: DiskLruCache.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0013\b\u0000\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\r\u0010\u0011\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0002\u001a\u00060\u0003R\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Editor;", "", "entry", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "Lokhttp3/internal/cache/DiskLruCache;", "(Lokhttp3/internal/cache/DiskLruCache;Lokhttp3/internal/cache/DiskLruCache$Entry;)V", "done", "", "getEntry$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Entry;", "written", "", "getWritten$okhttp", "()[Z", "abort", "", "commit", "detach", "detach$okhttp", "newSink", "Lokio/Sink;", "index", "", "newSource", "Lokio/Source;", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* compiled from: DiskLruCache.kt */
    public final class Editor {
        public boolean done;
        public final Entry entry;
        public final /* synthetic */ DiskLruCache this$0;
        public final boolean[] written;

        public Editor(DiskLruCache diskLruCache, Entry entry2) {
            Intrinsics.checkNotNullParameter(entry2, "entry");
            this.this$0 = diskLruCache;
            this.entry = entry2;
            this.written = entry2.getReadable$okhttp() ? null : new boolean[diskLruCache.getValueCount$okhttp()];
        }

        public final void abort() throws IOException {
            synchronized (this.this$0) {
                if (!this.done) {
                    if (Intrinsics.areEqual(this.entry.getCurrentEditor$okhttp(), this)) {
                        this.this$0.completeEdit$okhttp(this, false);
                    }
                    this.done = true;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }

        public final void commit() throws IOException {
            synchronized (this.this$0) {
                if (!this.done) {
                    if (Intrinsics.areEqual(this.entry.getCurrentEditor$okhttp(), this)) {
                        this.this$0.completeEdit$okhttp(this, true);
                    }
                    this.done = true;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }

        public final void detach$okhttp() {
            if (!Intrinsics.areEqual(this.entry.getCurrentEditor$okhttp(), this)) {
                return;
            }
            if (this.this$0.civilizedFileSystem) {
                this.this$0.completeEdit$okhttp(this, false);
            } else {
                this.entry.setZombie$okhttp(true);
            }
        }

        public final Entry getEntry$okhttp() {
            return this.entry;
        }

        public final boolean[] getWritten$okhttp() {
            return this.written;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(4:21|22|23|24) */
        /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            r5 = okio.Okio.blackhole();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0052, code lost:
            return r5;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004d */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final okio.Sink newSink(int r5) {
            /*
                r4 = this;
                okhttp3.internal.cache.DiskLruCache r0 = r4.this$0
                monitor-enter(r0)
                boolean r1 = r4.done     // Catch:{ all -> 0x005f }
                r2 = 1
                r1 = r1 ^ r2
                if (r1 == 0) goto L_0x0053
                okhttp3.internal.cache.DiskLruCache$Entry r1 = r4.entry     // Catch:{ all -> 0x005f }
                okhttp3.internal.cache.DiskLruCache$Editor r1 = r1.getCurrentEditor$okhttp()     // Catch:{ all -> 0x005f }
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r4)     // Catch:{ all -> 0x005f }
                r1 = r1 ^ r2
                if (r1 == 0) goto L_0x001c
                okio.Sink r5 = okio.Okio.blackhole()     // Catch:{ all -> 0x005f }
                monitor-exit(r0)
                return r5
            L_0x001c:
                okhttp3.internal.cache.DiskLruCache$Entry r1 = r4.entry     // Catch:{ all -> 0x005f }
                boolean r1 = r1.getReadable$okhttp()     // Catch:{ all -> 0x005f }
                if (r1 != 0) goto L_0x002b
                boolean[] r1 = r4.written     // Catch:{ all -> 0x005f }
                kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch:{ all -> 0x005f }
                r1[r5] = r2     // Catch:{ all -> 0x005f }
            L_0x002b:
                okhttp3.internal.cache.DiskLruCache$Entry r1 = r4.entry     // Catch:{ all -> 0x005f }
                java.util.List r1 = r1.getDirtyFiles$okhttp()     // Catch:{ all -> 0x005f }
                java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x005f }
                java.io.File r1 = (java.io.File) r1     // Catch:{ all -> 0x005f }
                okhttp3.internal.cache.DiskLruCache r2 = r4.this$0     // Catch:{ FileNotFoundException -> 0x004d }
                okhttp3.internal.io.FileSystem r2 = r2.getFileSystem$okhttp()     // Catch:{ FileNotFoundException -> 0x004d }
                okio.Sink r1 = r2.sink(r1)     // Catch:{ FileNotFoundException -> 0x004d }
                okhttp3.internal.cache.FaultHidingSink r2 = new okhttp3.internal.cache.FaultHidingSink     // Catch:{ all -> 0x005f }
                okhttp3.internal.cache.DiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1 r3 = new okhttp3.internal.cache.DiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1     // Catch:{ all -> 0x005f }
                r3.<init>(r4, r5)     // Catch:{ all -> 0x005f }
                r2.<init>(r1, r3)     // Catch:{ all -> 0x005f }
                monitor-exit(r0)
                return r2
            L_0x004d:
                okio.Sink r5 = okio.Okio.blackhole()     // Catch:{ all -> 0x005f }
                monitor-exit(r0)
                return r5
            L_0x0053:
                java.lang.String r5 = "Check failed."
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x005f }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x005f }
                r1.<init>(r5)     // Catch:{ all -> 0x005f }
                throw r1     // Catch:{ all -> 0x005f }
            L_0x005f:
                r5 = move-exception
                monitor-exit(r0)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.Editor.newSink(int):okio.Sink");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0042, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final okio.Source newSource(int r5) {
            /*
                r4 = this;
                okhttp3.internal.cache.DiskLruCache r0 = r4.this$0
                monitor-enter(r0)
                boolean r1 = r4.done     // Catch:{ all -> 0x004f }
                r1 = r1 ^ 1
                if (r1 == 0) goto L_0x0043
                okhttp3.internal.cache.DiskLruCache$Entry r1 = r4.entry     // Catch:{ all -> 0x004f }
                boolean r1 = r1.getReadable$okhttp()     // Catch:{ all -> 0x004f }
                r2 = 0
                if (r1 == 0) goto L_0x0041
                okhttp3.internal.cache.DiskLruCache$Entry r1 = r4.entry     // Catch:{ all -> 0x004f }
                okhttp3.internal.cache.DiskLruCache$Editor r1 = r1.getCurrentEditor$okhttp()     // Catch:{ all -> 0x004f }
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r4)     // Catch:{ all -> 0x004f }
                r1 = r1 ^ 1
                if (r1 != 0) goto L_0x0041
                okhttp3.internal.cache.DiskLruCache$Entry r1 = r4.entry     // Catch:{ all -> 0x004f }
                boolean r1 = r1.getZombie$okhttp()     // Catch:{ all -> 0x004f }
                if (r1 == 0) goto L_0x0029
                goto L_0x0041
            L_0x0029:
                okhttp3.internal.cache.DiskLruCache r1 = r4.this$0     // Catch:{ FileNotFoundException -> 0x003f }
                okhttp3.internal.io.FileSystem r1 = r1.getFileSystem$okhttp()     // Catch:{ FileNotFoundException -> 0x003f }
                okhttp3.internal.cache.DiskLruCache$Entry r3 = r4.entry     // Catch:{ FileNotFoundException -> 0x003f }
                java.util.List r3 = r3.getCleanFiles$okhttp()     // Catch:{ FileNotFoundException -> 0x003f }
                java.lang.Object r5 = r3.get(r5)     // Catch:{ FileNotFoundException -> 0x003f }
                java.io.File r5 = (java.io.File) r5     // Catch:{ FileNotFoundException -> 0x003f }
                okio.Source r2 = r1.source(r5)     // Catch:{ FileNotFoundException -> 0x003f }
            L_0x003f:
                monitor-exit(r0)
                return r2
            L_0x0041:
                monitor-exit(r0)
                return r2
            L_0x0043:
                java.lang.String r5 = "Check failed."
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x004f }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x004f }
                r1.<init>(r5)     // Catch:{ all -> 0x004f }
                throw r1     // Catch:{ all -> 0x004f }
            L_0x004f:
                r5 = move-exception
                monitor-exit(r0)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.Editor.newSource(int):okio.Source");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010.\u001a\u00020/2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000301H\u0002J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u001aH\u0002J\u001b\u00105\u001a\u0002062\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000301H\u0000¢\u0006\u0002\b7J\u0013\u00108\u001a\b\u0018\u000109R\u00020\fH\u0000¢\u0006\u0002\b:J\u0015\u0010;\u001a\u0002062\u0006\u0010<\u001a\u00020=H\u0000¢\u0006\u0002\b>R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0018\u00010\u000bR\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\"\"\u0004\b-\u0010$¨\u0006?"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Entry;", "", "key", "", "(Lokhttp3/internal/cache/DiskLruCache;Ljava/lang/String;)V", "cleanFiles", "", "Ljava/io/File;", "getCleanFiles$okhttp", "()Ljava/util/List;", "currentEditor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "getCurrentEditor$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Editor;", "setCurrentEditor$okhttp", "(Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "dirtyFiles", "getDirtyFiles$okhttp", "getKey$okhttp", "()Ljava/lang/String;", "lengths", "", "getLengths$okhttp", "()[J", "lockingSourceCount", "", "getLockingSourceCount$okhttp", "()I", "setLockingSourceCount$okhttp", "(I)V", "readable", "", "getReadable$okhttp", "()Z", "setReadable$okhttp", "(Z)V", "sequenceNumber", "", "getSequenceNumber$okhttp", "()J", "setSequenceNumber$okhttp", "(J)V", "zombie", "getZombie$okhttp", "setZombie$okhttp", "invalidLengths", "", "strings", "", "newSource", "Lokio/Source;", "index", "setLengths", "", "setLengths$okhttp", "snapshot", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "snapshot$okhttp", "writeLengths", "writer", "Lokio/BufferedSink;", "writeLengths$okhttp", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* compiled from: DiskLruCache.kt */
    public final class Entry {
        public final List<File> cleanFiles = new ArrayList();
        public Editor currentEditor;
        public final List<File> dirtyFiles = new ArrayList();
        public final String key;
        public final long[] lengths;
        public int lockingSourceCount;
        public boolean readable;
        public long sequenceNumber;
        public final /* synthetic */ DiskLruCache this$0;
        public boolean zombie;

        public Entry(DiskLruCache diskLruCache, String str) {
            Intrinsics.checkNotNullParameter(str, "key");
            this.this$0 = diskLruCache;
            this.key = str;
            this.lengths = new long[diskLruCache.getValueCount$okhttp()];
            StringBuilder sb = new StringBuilder(this.key);
            sb.append('.');
            int length = sb.length();
            int valueCount$okhttp = diskLruCache.getValueCount$okhttp();
            for (int i = 0; i < valueCount$okhttp; i++) {
                sb.append(i);
                this.cleanFiles.add(new File(diskLruCache.getDirectory(), sb.toString()));
                sb.append(".tmp");
                this.dirtyFiles.add(new File(diskLruCache.getDirectory(), sb.toString()));
                sb.setLength(length);
            }
        }

        private final Void invalidLengths(List<String> list) throws IOException {
            throw new IOException("unexpected journal line: " + list);
        }

        private final Source newSource(int i) {
            Source source = this.this$0.getFileSystem$okhttp().source(this.cleanFiles.get(i));
            if (this.this$0.civilizedFileSystem) {
                return source;
            }
            this.lockingSourceCount++;
            return new DiskLruCache$Entry$newSource$1(this, source, source);
        }

        public final List<File> getCleanFiles$okhttp() {
            return this.cleanFiles;
        }

        public final Editor getCurrentEditor$okhttp() {
            return this.currentEditor;
        }

        public final List<File> getDirtyFiles$okhttp() {
            return this.dirtyFiles;
        }

        public final String getKey$okhttp() {
            return this.key;
        }

        public final long[] getLengths$okhttp() {
            return this.lengths;
        }

        public final int getLockingSourceCount$okhttp() {
            return this.lockingSourceCount;
        }

        public final boolean getReadable$okhttp() {
            return this.readable;
        }

        public final long getSequenceNumber$okhttp() {
            return this.sequenceNumber;
        }

        public final boolean getZombie$okhttp() {
            return this.zombie;
        }

        public final void setCurrentEditor$okhttp(Editor editor) {
            this.currentEditor = editor;
        }

        public final void setLengths$okhttp(List<String> list) throws IOException {
            Intrinsics.checkNotNullParameter(list, "strings");
            if (list.size() == this.this$0.getValueCount$okhttp()) {
                try {
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        this.lengths[i] = Long.parseLong(list.get(i));
                    }
                } catch (NumberFormatException unused) {
                    invalidLengths(list);
                    throw new KotlinNothingValueException();
                }
            } else {
                invalidLengths(list);
                throw new KotlinNothingValueException();
            }
        }

        public final void setLockingSourceCount$okhttp(int i) {
            this.lockingSourceCount = i;
        }

        public final void setReadable$okhttp(boolean z) {
            this.readable = z;
        }

        public final void setSequenceNumber$okhttp(long j) {
            this.sequenceNumber = j;
        }

        public final void setZombie$okhttp(boolean z) {
            this.zombie = z;
        }

        public final Snapshot snapshot$okhttp() {
            DiskLruCache diskLruCache = this.this$0;
            if (Util.assertionsEnabled && !Thread.holdsLock(diskLruCache)) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Thread ");
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                outline73.append(currentThread.getName());
                outline73.append(" MUST hold lock on ");
                outline73.append(diskLruCache);
                throw new AssertionError(outline73.toString());
            } else if (!this.readable) {
                return null;
            } else {
                if (!this.this$0.civilizedFileSystem && (this.currentEditor != null || this.zombie)) {
                    return null;
                }
                ArrayList<Source> arrayList = new ArrayList<>();
                long[] jArr = (long[]) this.lengths.clone();
                try {
                    int valueCount$okhttp = this.this$0.getValueCount$okhttp();
                    for (int i = 0; i < valueCount$okhttp; i++) {
                        arrayList.add(newSource(i));
                    }
                    Snapshot snapshot = new Snapshot(this.this$0, this.key, this.sequenceNumber, arrayList, jArr);
                    return snapshot;
                } catch (FileNotFoundException unused) {
                    for (Source closeQuietly : arrayList) {
                        Util.closeQuietly((Closeable) closeQuietly);
                    }
                    try {
                        this.this$0.removeEntry$okhttp(this);
                    } catch (IOException unused2) {
                    }
                    return null;
                }
            }
        }

        public final void writeLengths$okhttp(BufferedSink bufferedSink) throws IOException {
            Intrinsics.checkNotNullParameter(bufferedSink, "writer");
            for (long writeDecimalLong : this.lengths) {
                bufferedSink.writeByte(32).writeDecimalLong(writeDecimalLong);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B-\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\f\u0010\u000e\u001a\b\u0018\u00010\u000fR\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0002\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Ljava/io/Closeable;", "key", "", "sequenceNumber", "", "sources", "", "Lokio/Source;", "lengths", "", "(Lokhttp3/internal/cache/DiskLruCache;Ljava/lang/String;JLjava/util/List;[J)V", "close", "", "edit", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "getLength", "index", "", "getSource", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* compiled from: DiskLruCache.kt */
    public final class Snapshot implements Closeable {
        public final String key;
        public final long[] lengths;
        public final long sequenceNumber;
        public final List<Source> sources;
        public final /* synthetic */ DiskLruCache this$0;

        public Snapshot(DiskLruCache diskLruCache, String str, long j, List<? extends Source> list, long[] jArr) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(list, "sources");
            Intrinsics.checkNotNullParameter(jArr, "lengths");
            this.this$0 = diskLruCache;
            this.key = str;
            this.sequenceNumber = j;
            this.sources = list;
            this.lengths = jArr;
        }

        public void close() {
            for (Source closeQuietly : this.sources) {
                Util.closeQuietly((Closeable) closeQuietly);
            }
        }

        public final Editor edit() throws IOException {
            return this.this$0.edit(this.key, this.sequenceNumber);
        }

        public final long getLength(int i) {
            return this.lengths[i];
        }

        public final Source getSource(int i) {
            return this.sources.get(i);
        }

        public final String key() {
            return this.key;
        }
    }

    public DiskLruCache(FileSystem fileSystem2, File file, int i, int i2, long j, TaskRunner taskRunner) {
        Intrinsics.checkNotNullParameter(fileSystem2, "fileSystem");
        Intrinsics.checkNotNullParameter(file, "directory");
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        this.fileSystem = fileSystem2;
        this.directory = file;
        this.appVersion = i;
        this.valueCount = i2;
        this.maxSize = j;
        boolean z = false;
        this.cleanupQueue = taskRunner.newQueue();
        this.cleanupTask = new DiskLruCache$cleanupTask$1(this, GeneratedOutlineSupport.outline62(new StringBuilder(), Util.okHttpName, " Cache"));
        if (j > 0) {
            if (this.valueCount > 0 ? true : z) {
                this.journalFile = new File(this.directory, JOURNAL_FILE);
                this.journalFileTmp = new File(this.directory, JOURNAL_FILE_TEMP);
                this.journalFileBackup = new File(this.directory, JOURNAL_FILE_BACKUP);
                return;
            }
            throw new IllegalArgumentException("valueCount <= 0".toString());
        }
        throw new IllegalArgumentException("maxSize <= 0".toString());
    }

    private final synchronized void checkNotClosed() {
        if (!(!this.closed)) {
            throw new IllegalStateException("cache is closed".toString());
        }
    }

    public static /* synthetic */ Editor edit$default(DiskLruCache diskLruCache, String str, long j, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            j = ANY_SEQUENCE_NUMBER;
        }
        return diskLruCache.edit(str, j);
    }

    /* access modifiers changed from: private */
    public final boolean journalRebuildRequired() {
        int i = this.redundantOpCount;
        return i >= 2000 && i >= this.lruEntries.size();
    }

    private final BufferedSink newJournalWriter() throws FileNotFoundException {
        return Okio.buffer((Sink) new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile), new DiskLruCache$newJournalWriter$faultHidingSink$1(this)));
    }

    private final void processJournal() throws IOException {
        this.fileSystem.delete(this.journalFileTmp);
        Iterator<Entry> it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "i.next()");
            Entry entry = next;
            int i = 0;
            if (entry.getCurrentEditor$okhttp() == null) {
                int i2 = this.valueCount;
                while (i < i2) {
                    this.size += entry.getLengths$okhttp()[i];
                    i++;
                }
            } else {
                entry.setCurrentEditor$okhttp(null);
                int i3 = this.valueCount;
                while (i < i3) {
                    this.fileSystem.delete(entry.getCleanFiles$okhttp().get(i));
                    this.fileSystem.delete(entry.getDirtyFiles$okhttp().get(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:18|19|(1:21)(1:22)|23|24) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r9.redundantOpCount = r7 - r9.lruEntries.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0071, code lost:
        if (r1.exhausted() == false) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0073, code lost:
        rebuildJournal$okhttp();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0077, code lost:
        r9.journalWriter = newJournalWriter();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007d, code lost:
        com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r1, null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0081, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b3, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b4, code lost:
        com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b7, code lost:
        throw r2;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0064 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:25:0x0082=Splitter:B:25:0x0082, B:18:0x0064=Splitter:B:18:0x0064} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void readJournal() throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            okhttp3.internal.io.FileSystem r1 = r9.fileSystem
            java.io.File r2 = r9.journalFile
            okio.Source r1 = r1.source(r2)
            okio.BufferedSource r1 = okio.Okio.buffer(r1)
            java.lang.String r2 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x00b1 }
            java.lang.String r3 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x00b1 }
            java.lang.String r4 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x00b1 }
            java.lang.String r5 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x00b1 }
            java.lang.String r6 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x00b1 }
            java.lang.String r7 = MAGIC     // Catch:{ all -> 0x00b1 }
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r2)     // Catch:{ all -> 0x00b1 }
            r8 = 1
            r7 = r7 ^ r8
            if (r7 != 0) goto L_0x0082
            java.lang.String r7 = VERSION_1     // Catch:{ all -> 0x00b1 }
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r3)     // Catch:{ all -> 0x00b1 }
            r7 = r7 ^ r8
            if (r7 != 0) goto L_0x0082
            int r7 = r9.appVersion     // Catch:{ all -> 0x00b1 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x00b1 }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r4)     // Catch:{ all -> 0x00b1 }
            r4 = r4 ^ r8
            if (r4 != 0) goto L_0x0082
            int r4 = r9.valueCount     // Catch:{ all -> 0x00b1 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x00b1 }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)     // Catch:{ all -> 0x00b1 }
            r4 = r4 ^ r8
            if (r4 != 0) goto L_0x0082
            int r4 = r6.length()     // Catch:{ all -> 0x00b1 }
            r7 = 0
            if (r4 <= 0) goto L_0x0057
            goto L_0x0058
        L_0x0057:
            r8 = 0
        L_0x0058:
            if (r8 != 0) goto L_0x0082
        L_0x005a:
            java.lang.String r0 = r1.readUtf8LineStrict()     // Catch:{ EOFException -> 0x0064 }
            r9.readJournalLine(r0)     // Catch:{ EOFException -> 0x0064 }
            int r7 = r7 + 1
            goto L_0x005a
        L_0x0064:
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r0 = r9.lruEntries     // Catch:{ all -> 0x00b1 }
            int r0 = r0.size()     // Catch:{ all -> 0x00b1 }
            int r7 = r7 - r0
            r9.redundantOpCount = r7     // Catch:{ all -> 0x00b1 }
            boolean r0 = r1.exhausted()     // Catch:{ all -> 0x00b1 }
            if (r0 != 0) goto L_0x0077
            r9.rebuildJournal$okhttp()     // Catch:{ all -> 0x00b1 }
            goto L_0x007d
        L_0x0077:
            okio.BufferedSink r0 = r9.newJournalWriter()     // Catch:{ all -> 0x00b1 }
            r9.journalWriter = r0     // Catch:{ all -> 0x00b1 }
        L_0x007d:
            r0 = 0
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r1, r0)
            return
        L_0x0082:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x00b1 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b1 }
            r7.<init>()     // Catch:{ all -> 0x00b1 }
            java.lang.String r8 = "unexpected journal header: ["
            r7.append(r8)     // Catch:{ all -> 0x00b1 }
            r7.append(r2)     // Catch:{ all -> 0x00b1 }
            r7.append(r0)     // Catch:{ all -> 0x00b1 }
            r7.append(r3)     // Catch:{ all -> 0x00b1 }
            r7.append(r0)     // Catch:{ all -> 0x00b1 }
            r7.append(r5)     // Catch:{ all -> 0x00b1 }
            r7.append(r0)     // Catch:{ all -> 0x00b1 }
            r7.append(r6)     // Catch:{ all -> 0x00b1 }
            r0 = 93
            r7.append(r0)     // Catch:{ all -> 0x00b1 }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x00b1 }
            r4.<init>(r0)     // Catch:{ all -> 0x00b1 }
            throw r4     // Catch:{ all -> 0x00b1 }
        L_0x00b1:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x00b3 }
        L_0x00b3:
            r2 = move-exception
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r1, r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.readJournal():void");
    }

    private final void readJournalLine(String str) throws IOException {
        String str2;
        int indexOf$default = CharsKt__CharKt.indexOf$default((CharSequence) str, ' ', 0, false, 6);
        if (indexOf$default != -1) {
            int i = indexOf$default + 1;
            int indexOf$default2 = CharsKt__CharKt.indexOf$default((CharSequence) str, ' ', i, false, 4);
            if (indexOf$default2 == -1) {
                if (str != null) {
                    str2 = str.substring(i);
                    Intrinsics.checkNotNullExpressionValue(str2, "(this as java.lang.String).substring(startIndex)");
                    if (indexOf$default == REMOVE.length() && CharsKt__CharKt.startsWith$default(str, REMOVE, false, 2)) {
                        this.lruEntries.remove(str2);
                        return;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            } else if (str != null) {
                str2 = str.substring(i, indexOf$default2);
                Intrinsics.checkNotNullExpressionValue(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            Entry entry = this.lruEntries.get(str2);
            if (entry == null) {
                entry = new Entry(this, str2);
                this.lruEntries.put(str2, entry);
            }
            if (indexOf$default2 != -1 && indexOf$default == CLEAN.length() && CharsKt__CharKt.startsWith$default(str, CLEAN, false, 2)) {
                int i2 = indexOf$default2 + 1;
                if (str != null) {
                    String substring = str.substring(i2);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                    List split$default = CharsKt__CharKt.split$default((CharSequence) substring, new char[]{' '}, false, 0, 6);
                    entry.setReadable$okhttp(true);
                    entry.setCurrentEditor$okhttp(null);
                    entry.setLengths$okhttp(split$default);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            } else if (indexOf$default2 == -1 && indexOf$default == DIRTY.length() && CharsKt__CharKt.startsWith$default(str, DIRTY, false, 2)) {
                entry.setCurrentEditor$okhttp(new Editor(this, entry));
            } else if (!(indexOf$default2 == -1 && indexOf$default == READ.length() && CharsKt__CharKt.startsWith$default(str, READ, false, 2))) {
                throw new IOException(GeneratedOutlineSupport.outline50("unexpected journal line: ", str));
            }
            return;
        }
        throw new IOException(GeneratedOutlineSupport.outline50("unexpected journal line: ", str));
    }

    private final boolean removeOldestEntry() {
        for (Entry next : this.lruEntries.values()) {
            if (!next.getZombie$okhttp()) {
                Intrinsics.checkNotNullExpressionValue(next, "toEvict");
                removeEntry$okhttp(next);
                return true;
            }
        }
        return false;
    }

    private final void validateKey(String str) {
        if (!LEGAL_KEY_PATTERN.matches(str)) {
            throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + StringEscapeUtils.CSV_QUOTE).toString());
        }
    }

    public synchronized void close() throws IOException {
        if (this.initialized) {
            if (!this.closed) {
                Collection<Entry> values = this.lruEntries.values();
                Intrinsics.checkNotNullExpressionValue(values, "lruEntries.values");
                Object[] array = values.toArray(new Entry[0]);
                if (array != null) {
                    for (Entry entry : (Entry[]) array) {
                        if (entry.getCurrentEditor$okhttp() != null) {
                            Editor currentEditor$okhttp = entry.getCurrentEditor$okhttp();
                            if (currentEditor$okhttp != null) {
                                currentEditor$okhttp.detach$okhttp();
                            }
                        }
                    }
                    trimToSize();
                    BufferedSink bufferedSink = this.journalWriter;
                    Intrinsics.checkNotNull(bufferedSink);
                    bufferedSink.close();
                    this.journalWriter = null;
                    this.closed = true;
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }
        this.closed = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0135, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void completeEdit$okhttp(okhttp3.internal.cache.DiskLruCache.Editor r9, boolean r10) throws java.io.IOException {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.String r0 = "editor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)     // Catch:{ all -> 0x0142 }
            okhttp3.internal.cache.DiskLruCache$Entry r0 = r9.getEntry$okhttp()     // Catch:{ all -> 0x0142 }
            okhttp3.internal.cache.DiskLruCache$Editor r1 = r0.getCurrentEditor$okhttp()     // Catch:{ all -> 0x0142 }
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r9)     // Catch:{ all -> 0x0142 }
            if (r1 == 0) goto L_0x0136
            r1 = 0
            if (r10 == 0) goto L_0x0061
            boolean r2 = r0.getReadable$okhttp()     // Catch:{ all -> 0x0142 }
            if (r2 != 0) goto L_0x0061
            int r2 = r8.valueCount     // Catch:{ all -> 0x0142 }
            r3 = 0
        L_0x0020:
            if (r3 >= r2) goto L_0x0061
            boolean[] r4 = r9.getWritten$okhttp()     // Catch:{ all -> 0x0142 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)     // Catch:{ all -> 0x0142 }
            boolean r4 = r4[r3]     // Catch:{ all -> 0x0142 }
            if (r4 == 0) goto L_0x0047
            okhttp3.internal.io.FileSystem r4 = r8.fileSystem     // Catch:{ all -> 0x0142 }
            java.util.List r5 = r0.getDirtyFiles$okhttp()     // Catch:{ all -> 0x0142 }
            java.lang.Object r5 = r5.get(r3)     // Catch:{ all -> 0x0142 }
            java.io.File r5 = (java.io.File) r5     // Catch:{ all -> 0x0142 }
            boolean r4 = r4.exists(r5)     // Catch:{ all -> 0x0142 }
            if (r4 != 0) goto L_0x0044
            r9.abort()     // Catch:{ all -> 0x0142 }
            monitor-exit(r8)
            return
        L_0x0044:
            int r3 = r3 + 1
            goto L_0x0020
        L_0x0047:
            r9.abort()     // Catch:{ all -> 0x0142 }
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0142 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0142 }
            r10.<init>()     // Catch:{ all -> 0x0142 }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r10.append(r0)     // Catch:{ all -> 0x0142 }
            r10.append(r3)     // Catch:{ all -> 0x0142 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0142 }
            r9.<init>(r10)     // Catch:{ all -> 0x0142 }
            throw r9     // Catch:{ all -> 0x0142 }
        L_0x0061:
            int r9 = r8.valueCount     // Catch:{ all -> 0x0142 }
        L_0x0063:
            if (r1 >= r9) goto L_0x00af
            java.util.List r2 = r0.getDirtyFiles$okhttp()     // Catch:{ all -> 0x0142 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x0142 }
            java.io.File r2 = (java.io.File) r2     // Catch:{ all -> 0x0142 }
            if (r10 == 0) goto L_0x00a7
            boolean r3 = r0.getZombie$okhttp()     // Catch:{ all -> 0x0142 }
            if (r3 != 0) goto L_0x00a7
            okhttp3.internal.io.FileSystem r3 = r8.fileSystem     // Catch:{ all -> 0x0142 }
            boolean r3 = r3.exists(r2)     // Catch:{ all -> 0x0142 }
            if (r3 == 0) goto L_0x00ac
            java.util.List r3 = r0.getCleanFiles$okhttp()     // Catch:{ all -> 0x0142 }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ all -> 0x0142 }
            java.io.File r3 = (java.io.File) r3     // Catch:{ all -> 0x0142 }
            okhttp3.internal.io.FileSystem r4 = r8.fileSystem     // Catch:{ all -> 0x0142 }
            r4.rename(r2, r3)     // Catch:{ all -> 0x0142 }
            long[] r2 = r0.getLengths$okhttp()     // Catch:{ all -> 0x0142 }
            r4 = r2[r1]     // Catch:{ all -> 0x0142 }
            okhttp3.internal.io.FileSystem r2 = r8.fileSystem     // Catch:{ all -> 0x0142 }
            long r2 = r2.size(r3)     // Catch:{ all -> 0x0142 }
            long[] r6 = r0.getLengths$okhttp()     // Catch:{ all -> 0x0142 }
            r6[r1] = r2     // Catch:{ all -> 0x0142 }
            long r6 = r8.size     // Catch:{ all -> 0x0142 }
            long r6 = r6 - r4
            long r6 = r6 + r2
            r8.size = r6     // Catch:{ all -> 0x0142 }
            goto L_0x00ac
        L_0x00a7:
            okhttp3.internal.io.FileSystem r3 = r8.fileSystem     // Catch:{ all -> 0x0142 }
            r3.delete(r2)     // Catch:{ all -> 0x0142 }
        L_0x00ac:
            int r1 = r1 + 1
            goto L_0x0063
        L_0x00af:
            r9 = 0
            r0.setCurrentEditor$okhttp(r9)     // Catch:{ all -> 0x0142 }
            boolean r9 = r0.getZombie$okhttp()     // Catch:{ all -> 0x0142 }
            if (r9 == 0) goto L_0x00be
            r8.removeEntry$okhttp(r0)     // Catch:{ all -> 0x0142 }
            monitor-exit(r8)
            return
        L_0x00be:
            int r9 = r8.redundantOpCount     // Catch:{ all -> 0x0142 }
            r1 = 1
            int r9 = r9 + r1
            r8.redundantOpCount = r9     // Catch:{ all -> 0x0142 }
            okio.BufferedSink r9 = r8.journalWriter     // Catch:{ all -> 0x0142 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)     // Catch:{ all -> 0x0142 }
            boolean r2 = r0.getReadable$okhttp()     // Catch:{ all -> 0x0142 }
            r3 = 10
            r4 = 32
            if (r2 != 0) goto L_0x00f3
            if (r10 == 0) goto L_0x00d6
            goto L_0x00f3
        L_0x00d6:
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r10 = r8.lruEntries     // Catch:{ all -> 0x0142 }
            java.lang.String r1 = r0.getKey$okhttp()     // Catch:{ all -> 0x0142 }
            r10.remove(r1)     // Catch:{ all -> 0x0142 }
            java.lang.String r10 = REMOVE     // Catch:{ all -> 0x0142 }
            okio.BufferedSink r10 = r9.writeUtf8(r10)     // Catch:{ all -> 0x0142 }
            r10.writeByte(r4)     // Catch:{ all -> 0x0142 }
            java.lang.String r10 = r0.getKey$okhttp()     // Catch:{ all -> 0x0142 }
            r9.writeUtf8(r10)     // Catch:{ all -> 0x0142 }
            r9.writeByte(r3)     // Catch:{ all -> 0x0142 }
            goto L_0x0118
        L_0x00f3:
            r0.setReadable$okhttp(r1)     // Catch:{ all -> 0x0142 }
            java.lang.String r1 = CLEAN     // Catch:{ all -> 0x0142 }
            okio.BufferedSink r1 = r9.writeUtf8(r1)     // Catch:{ all -> 0x0142 }
            r1.writeByte(r4)     // Catch:{ all -> 0x0142 }
            java.lang.String r1 = r0.getKey$okhttp()     // Catch:{ all -> 0x0142 }
            r9.writeUtf8(r1)     // Catch:{ all -> 0x0142 }
            r0.writeLengths$okhttp(r9)     // Catch:{ all -> 0x0142 }
            r9.writeByte(r3)     // Catch:{ all -> 0x0142 }
            if (r10 == 0) goto L_0x0118
            long r1 = r8.nextSequenceNumber     // Catch:{ all -> 0x0142 }
            r3 = 1
            long r3 = r3 + r1
            r8.nextSequenceNumber = r3     // Catch:{ all -> 0x0142 }
            r0.setSequenceNumber$okhttp(r1)     // Catch:{ all -> 0x0142 }
        L_0x0118:
            r9.flush()     // Catch:{ all -> 0x0142 }
            long r9 = r8.size     // Catch:{ all -> 0x0142 }
            long r0 = r8.maxSize     // Catch:{ all -> 0x0142 }
            int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x0129
            boolean r9 = r8.journalRebuildRequired()     // Catch:{ all -> 0x0142 }
            if (r9 == 0) goto L_0x0134
        L_0x0129:
            okhttp3.internal.concurrent.TaskQueue r0 = r8.cleanupQueue     // Catch:{ all -> 0x0142 }
            okhttp3.internal.cache.DiskLruCache$cleanupTask$1 r1 = r8.cleanupTask     // Catch:{ all -> 0x0142 }
            r2 = 0
            r4 = 2
            r5 = 0
            okhttp3.internal.concurrent.TaskQueue.schedule$default(r0, r1, r2, r4, r5)     // Catch:{ all -> 0x0142 }
        L_0x0134:
            monitor-exit(r8)
            return
        L_0x0136:
            java.lang.String r9 = "Check failed."
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0142 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0142 }
            r10.<init>(r9)     // Catch:{ all -> 0x0142 }
            throw r10     // Catch:{ all -> 0x0142 }
        L_0x0142:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.completeEdit$okhttp(okhttp3.internal.cache.DiskLruCache$Editor, boolean):void");
    }

    public final void delete() throws IOException {
        close();
        this.fileSystem.deleteContents(this.directory);
    }

    public final Editor edit(String str) throws IOException {
        return edit$default(this, str, 0, 2, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0029, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized okhttp3.internal.cache.DiskLruCache.Editor edit(java.lang.String r11, long r12) throws java.io.IOException {
        /*
            r10 = this;
            monitor-enter(r10)
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)     // Catch:{ all -> 0x008f }
            r10.initialize()     // Catch:{ all -> 0x008f }
            r10.checkNotClosed()     // Catch:{ all -> 0x008f }
            r10.validateKey(r11)     // Catch:{ all -> 0x008f }
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r0 = r10.lruEntries     // Catch:{ all -> 0x008f }
            java.lang.Object r0 = r0.get(r11)     // Catch:{ all -> 0x008f }
            okhttp3.internal.cache.DiskLruCache$Entry r0 = (okhttp3.internal.cache.DiskLruCache.Entry) r0     // Catch:{ all -> 0x008f }
            long r1 = ANY_SEQUENCE_NUMBER     // Catch:{ all -> 0x008f }
            r3 = 0
            int r4 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x002a
            if (r0 == 0) goto L_0x0028
            long r1 = r0.getSequenceNumber$okhttp()     // Catch:{ all -> 0x008f }
            int r4 = (r1 > r12 ? 1 : (r1 == r12 ? 0 : -1))
            if (r4 == 0) goto L_0x002a
        L_0x0028:
            monitor-exit(r10)
            return r3
        L_0x002a:
            if (r0 == 0) goto L_0x0031
            okhttp3.internal.cache.DiskLruCache$Editor r12 = r0.getCurrentEditor$okhttp()     // Catch:{ all -> 0x008f }
            goto L_0x0032
        L_0x0031:
            r12 = r3
        L_0x0032:
            if (r12 == 0) goto L_0x0036
            monitor-exit(r10)
            return r3
        L_0x0036:
            if (r0 == 0) goto L_0x0040
            int r12 = r0.getLockingSourceCount$okhttp()     // Catch:{ all -> 0x008f }
            if (r12 == 0) goto L_0x0040
            monitor-exit(r10)
            return r3
        L_0x0040:
            boolean r12 = r10.mostRecentTrimFailed     // Catch:{ all -> 0x008f }
            if (r12 != 0) goto L_0x0082
            boolean r12 = r10.mostRecentRebuildFailed     // Catch:{ all -> 0x008f }
            if (r12 == 0) goto L_0x0049
            goto L_0x0082
        L_0x0049:
            okio.BufferedSink r12 = r10.journalWriter     // Catch:{ all -> 0x008f }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)     // Catch:{ all -> 0x008f }
            java.lang.String r13 = DIRTY     // Catch:{ all -> 0x008f }
            okio.BufferedSink r13 = r12.writeUtf8(r13)     // Catch:{ all -> 0x008f }
            r1 = 32
            okio.BufferedSink r13 = r13.writeByte(r1)     // Catch:{ all -> 0x008f }
            okio.BufferedSink r13 = r13.writeUtf8(r11)     // Catch:{ all -> 0x008f }
            r1 = 10
            r13.writeByte(r1)     // Catch:{ all -> 0x008f }
            r12.flush()     // Catch:{ all -> 0x008f }
            boolean r12 = r10.hasJournalErrors     // Catch:{ all -> 0x008f }
            if (r12 == 0) goto L_0x006c
            monitor-exit(r10)
            return r3
        L_0x006c:
            if (r0 != 0) goto L_0x0078
            okhttp3.internal.cache.DiskLruCache$Entry r0 = new okhttp3.internal.cache.DiskLruCache$Entry     // Catch:{ all -> 0x008f }
            r0.<init>(r10, r11)     // Catch:{ all -> 0x008f }
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r12 = r10.lruEntries     // Catch:{ all -> 0x008f }
            r12.put(r11, r0)     // Catch:{ all -> 0x008f }
        L_0x0078:
            okhttp3.internal.cache.DiskLruCache$Editor r11 = new okhttp3.internal.cache.DiskLruCache$Editor     // Catch:{ all -> 0x008f }
            r11.<init>(r10, r0)     // Catch:{ all -> 0x008f }
            r0.setCurrentEditor$okhttp(r11)     // Catch:{ all -> 0x008f }
            monitor-exit(r10)
            return r11
        L_0x0082:
            okhttp3.internal.concurrent.TaskQueue r4 = r10.cleanupQueue     // Catch:{ all -> 0x008f }
            okhttp3.internal.cache.DiskLruCache$cleanupTask$1 r5 = r10.cleanupTask     // Catch:{ all -> 0x008f }
            r6 = 0
            r8 = 2
            r9 = 0
            okhttp3.internal.concurrent.TaskQueue.schedule$default(r4, r5, r6, r8, r9)     // Catch:{ all -> 0x008f }
            monitor-exit(r10)
            return r3
        L_0x008f:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.edit(java.lang.String, long):okhttp3.internal.cache.DiskLruCache$Editor");
    }

    public final synchronized void evictAll() throws IOException {
        initialize();
        Collection<Entry> values = this.lruEntries.values();
        Intrinsics.checkNotNullExpressionValue(values, "lruEntries.values");
        Object[] array = values.toArray(new Entry[0]);
        if (array != null) {
            for (Entry entry : (Entry[]) array) {
                Intrinsics.checkNotNullExpressionValue(entry, "entry");
                removeEntry$okhttp(entry);
            }
            this.mostRecentTrimFailed = false;
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    public synchronized void flush() throws IOException {
        if (this.initialized) {
            checkNotClosed();
            trimToSize();
            BufferedSink bufferedSink = this.journalWriter;
            Intrinsics.checkNotNull(bufferedSink);
            bufferedSink.flush();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0057, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized okhttp3.internal.cache.DiskLruCache.Snapshot get(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            monitor-enter(r7)
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)     // Catch:{ all -> 0x005c }
            r7.initialize()     // Catch:{ all -> 0x005c }
            r7.checkNotClosed()     // Catch:{ all -> 0x005c }
            r7.validateKey(r8)     // Catch:{ all -> 0x005c }
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r0 = r7.lruEntries     // Catch:{ all -> 0x005c }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x005c }
            okhttp3.internal.cache.DiskLruCache$Entry r0 = (okhttp3.internal.cache.DiskLruCache.Entry) r0     // Catch:{ all -> 0x005c }
            r1 = 0
            if (r0 == 0) goto L_0x005a
            java.lang.String r2 = "lruEntries[key] ?: return null"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)     // Catch:{ all -> 0x005c }
            okhttp3.internal.cache.DiskLruCache$Snapshot r0 = r0.snapshot$okhttp()     // Catch:{ all -> 0x005c }
            if (r0 == 0) goto L_0x0058
            int r1 = r7.redundantOpCount     // Catch:{ all -> 0x005c }
            int r1 = r1 + 1
            r7.redundantOpCount = r1     // Catch:{ all -> 0x005c }
            okio.BufferedSink r1 = r7.journalWriter     // Catch:{ all -> 0x005c }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch:{ all -> 0x005c }
            java.lang.String r2 = READ     // Catch:{ all -> 0x005c }
            okio.BufferedSink r1 = r1.writeUtf8(r2)     // Catch:{ all -> 0x005c }
            r2 = 32
            okio.BufferedSink r1 = r1.writeByte(r2)     // Catch:{ all -> 0x005c }
            okio.BufferedSink r8 = r1.writeUtf8(r8)     // Catch:{ all -> 0x005c }
            r1 = 10
            r8.writeByte(r1)     // Catch:{ all -> 0x005c }
            boolean r8 = r7.journalRebuildRequired()     // Catch:{ all -> 0x005c }
            if (r8 == 0) goto L_0x0056
            okhttp3.internal.concurrent.TaskQueue r1 = r7.cleanupQueue     // Catch:{ all -> 0x005c }
            okhttp3.internal.cache.DiskLruCache$cleanupTask$1 r2 = r7.cleanupTask     // Catch:{ all -> 0x005c }
            r3 = 0
            r5 = 2
            r6 = 0
            okhttp3.internal.concurrent.TaskQueue.schedule$default(r1, r2, r3, r5, r6)     // Catch:{ all -> 0x005c }
        L_0x0056:
            monitor-exit(r7)
            return r0
        L_0x0058:
            monitor-exit(r7)
            return r1
        L_0x005a:
            monitor-exit(r7)
            return r1
        L_0x005c:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.get(java.lang.String):okhttp3.internal.cache.DiskLruCache$Snapshot");
    }

    public final boolean getClosed$okhttp() {
        return this.closed;
    }

    public final File getDirectory() {
        return this.directory;
    }

    public final FileSystem getFileSystem$okhttp() {
        return this.fileSystem;
    }

    public final LinkedHashMap<String, Entry> getLruEntries$okhttp() {
        return this.lruEntries;
    }

    public final synchronized long getMaxSize() {
        try {
        }
        return this.maxSize;
    }

    public final int getValueCount$okhttp() {
        return this.valueCount;
    }

    public final synchronized void initialize() throws IOException {
        if (Util.assertionsEnabled) {
            if (!Thread.holdsLock(this)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
                sb.append(currentThread.getName());
                sb.append(" MUST hold lock on ");
                sb.append(this);
                throw new AssertionError(sb.toString());
            }
        }
        if (!this.initialized) {
            if (this.fileSystem.exists(this.journalFileBackup)) {
                if (this.fileSystem.exists(this.journalFile)) {
                    this.fileSystem.delete(this.journalFileBackup);
                } else {
                    this.fileSystem.rename(this.journalFileBackup, this.journalFile);
                }
            }
            this.civilizedFileSystem = Util.isCivilized(this.fileSystem, this.journalFileBackup);
            if (this.fileSystem.exists(this.journalFile)) {
                try {
                    readJournal();
                    processJournal();
                    this.initialized = true;
                    return;
                } catch (IOException e2) {
                    Platform platform = Platform.Companion.get();
                    platform.log("DiskLruCache " + this.directory + " is corrupt: " + e2.getMessage() + ", removing", 5, e2);
                    delete();
                    this.closed = false;
                } catch (Throwable th) {
                    this.closed = false;
                    throw th;
                }
            }
            rebuildJournal$okhttp();
            this.initialized = true;
        }
    }

    public final synchronized boolean isClosed() {
        try {
        }
        return this.closed;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00be, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00c2, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void rebuildJournal$okhttp() throws java.io.IOException {
        /*
            r7 = this;
            monitor-enter(r7)
            okio.BufferedSink r0 = r7.journalWriter     // Catch:{ all -> 0x00c3 }
            if (r0 == 0) goto L_0x0008
            r0.close()     // Catch:{ all -> 0x00c3 }
        L_0x0008:
            okhttp3.internal.io.FileSystem r0 = r7.fileSystem     // Catch:{ all -> 0x00c3 }
            java.io.File r1 = r7.journalFileTmp     // Catch:{ all -> 0x00c3 }
            okio.Sink r0 = r0.sink(r1)     // Catch:{ all -> 0x00c3 }
            okio.BufferedSink r0 = okio.Okio.buffer(r0)     // Catch:{ all -> 0x00c3 }
            r1 = 0
            java.lang.String r2 = MAGIC     // Catch:{ all -> 0x00bc }
            okio.BufferedSink r2 = r0.writeUtf8(r2)     // Catch:{ all -> 0x00bc }
            r3 = 10
            r2.writeByte(r3)     // Catch:{ all -> 0x00bc }
            java.lang.String r2 = VERSION_1     // Catch:{ all -> 0x00bc }
            okio.BufferedSink r2 = r0.writeUtf8(r2)     // Catch:{ all -> 0x00bc }
            r2.writeByte(r3)     // Catch:{ all -> 0x00bc }
            int r2 = r7.appVersion     // Catch:{ all -> 0x00bc }
            long r4 = (long) r2     // Catch:{ all -> 0x00bc }
            okio.BufferedSink r2 = r0.writeDecimalLong(r4)     // Catch:{ all -> 0x00bc }
            r2.writeByte(r3)     // Catch:{ all -> 0x00bc }
            int r2 = r7.valueCount     // Catch:{ all -> 0x00bc }
            long r4 = (long) r2     // Catch:{ all -> 0x00bc }
            okio.BufferedSink r2 = r0.writeDecimalLong(r4)     // Catch:{ all -> 0x00bc }
            r2.writeByte(r3)     // Catch:{ all -> 0x00bc }
            r0.writeByte(r3)     // Catch:{ all -> 0x00bc }
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r2 = r7.lruEntries     // Catch:{ all -> 0x00bc }
            java.util.Collection r2 = r2.values()     // Catch:{ all -> 0x00bc }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x00bc }
        L_0x004a:
            boolean r4 = r2.hasNext()     // Catch:{ all -> 0x00bc }
            if (r4 == 0) goto L_0x0089
            java.lang.Object r4 = r2.next()     // Catch:{ all -> 0x00bc }
            okhttp3.internal.cache.DiskLruCache$Entry r4 = (okhttp3.internal.cache.DiskLruCache.Entry) r4     // Catch:{ all -> 0x00bc }
            okhttp3.internal.cache.DiskLruCache$Editor r5 = r4.getCurrentEditor$okhttp()     // Catch:{ all -> 0x00bc }
            r6 = 32
            if (r5 == 0) goto L_0x0072
            java.lang.String r5 = DIRTY     // Catch:{ all -> 0x00bc }
            okio.BufferedSink r5 = r0.writeUtf8(r5)     // Catch:{ all -> 0x00bc }
            r5.writeByte(r6)     // Catch:{ all -> 0x00bc }
            java.lang.String r4 = r4.getKey$okhttp()     // Catch:{ all -> 0x00bc }
            r0.writeUtf8(r4)     // Catch:{ all -> 0x00bc }
            r0.writeByte(r3)     // Catch:{ all -> 0x00bc }
            goto L_0x004a
        L_0x0072:
            java.lang.String r5 = CLEAN     // Catch:{ all -> 0x00bc }
            okio.BufferedSink r5 = r0.writeUtf8(r5)     // Catch:{ all -> 0x00bc }
            r5.writeByte(r6)     // Catch:{ all -> 0x00bc }
            java.lang.String r5 = r4.getKey$okhttp()     // Catch:{ all -> 0x00bc }
            r0.writeUtf8(r5)     // Catch:{ all -> 0x00bc }
            r4.writeLengths$okhttp(r0)     // Catch:{ all -> 0x00bc }
            r0.writeByte(r3)     // Catch:{ all -> 0x00bc }
            goto L_0x004a
        L_0x0089:
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r0, r1)     // Catch:{ all -> 0x00c3 }
            okhttp3.internal.io.FileSystem r0 = r7.fileSystem     // Catch:{ all -> 0x00c3 }
            java.io.File r1 = r7.journalFile     // Catch:{ all -> 0x00c3 }
            boolean r0 = r0.exists(r1)     // Catch:{ all -> 0x00c3 }
            if (r0 == 0) goto L_0x009f
            okhttp3.internal.io.FileSystem r0 = r7.fileSystem     // Catch:{ all -> 0x00c3 }
            java.io.File r1 = r7.journalFile     // Catch:{ all -> 0x00c3 }
            java.io.File r2 = r7.journalFileBackup     // Catch:{ all -> 0x00c3 }
            r0.rename(r1, r2)     // Catch:{ all -> 0x00c3 }
        L_0x009f:
            okhttp3.internal.io.FileSystem r0 = r7.fileSystem     // Catch:{ all -> 0x00c3 }
            java.io.File r1 = r7.journalFileTmp     // Catch:{ all -> 0x00c3 }
            java.io.File r2 = r7.journalFile     // Catch:{ all -> 0x00c3 }
            r0.rename(r1, r2)     // Catch:{ all -> 0x00c3 }
            okhttp3.internal.io.FileSystem r0 = r7.fileSystem     // Catch:{ all -> 0x00c3 }
            java.io.File r1 = r7.journalFileBackup     // Catch:{ all -> 0x00c3 }
            r0.delete(r1)     // Catch:{ all -> 0x00c3 }
            okio.BufferedSink r0 = r7.newJournalWriter()     // Catch:{ all -> 0x00c3 }
            r7.journalWriter = r0     // Catch:{ all -> 0x00c3 }
            r0 = 0
            r7.hasJournalErrors = r0     // Catch:{ all -> 0x00c3 }
            r7.mostRecentRebuildFailed = r0     // Catch:{ all -> 0x00c3 }
            monitor-exit(r7)
            return
        L_0x00bc:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x00be }
        L_0x00be:
            r2 = move-exception
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r0, r1)     // Catch:{ all -> 0x00c3 }
            throw r2     // Catch:{ all -> 0x00c3 }
        L_0x00c3:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.rebuildJournal$okhttp():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        return r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean remove(java.lang.String r7) throws java.io.IOException {
        /*
            r6 = this;
            monitor-enter(r6)
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)     // Catch:{ all -> 0x0033 }
            r6.initialize()     // Catch:{ all -> 0x0033 }
            r6.checkNotClosed()     // Catch:{ all -> 0x0033 }
            r6.validateKey(r7)     // Catch:{ all -> 0x0033 }
            java.util.LinkedHashMap<java.lang.String, okhttp3.internal.cache.DiskLruCache$Entry> r0 = r6.lruEntries     // Catch:{ all -> 0x0033 }
            java.lang.Object r7 = r0.get(r7)     // Catch:{ all -> 0x0033 }
            okhttp3.internal.cache.DiskLruCache$Entry r7 = (okhttp3.internal.cache.DiskLruCache.Entry) r7     // Catch:{ all -> 0x0033 }
            r0 = 0
            if (r7 == 0) goto L_0x0031
            java.lang.String r1 = "lruEntries[key] ?: return false"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)     // Catch:{ all -> 0x0033 }
            boolean r7 = r6.removeEntry$okhttp(r7)     // Catch:{ all -> 0x0033 }
            if (r7 == 0) goto L_0x002f
            long r1 = r6.size     // Catch:{ all -> 0x0033 }
            long r3 = r6.maxSize     // Catch:{ all -> 0x0033 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x002f
            r6.mostRecentTrimFailed = r0     // Catch:{ all -> 0x0033 }
        L_0x002f:
            monitor-exit(r6)
            return r7
        L_0x0031:
            monitor-exit(r6)
            return r0
        L_0x0033:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.remove(java.lang.String):boolean");
    }

    public final boolean removeEntry$okhttp(Entry entry) throws IOException {
        Intrinsics.checkNotNullParameter(entry, "entry");
        if (!this.civilizedFileSystem) {
            if (entry.getLockingSourceCount$okhttp() > 0) {
                BufferedSink bufferedSink = this.journalWriter;
                if (bufferedSink != null) {
                    bufferedSink.writeUtf8(DIRTY);
                    bufferedSink.writeByte(32);
                    bufferedSink.writeUtf8(entry.getKey$okhttp());
                    bufferedSink.writeByte(10);
                    bufferedSink.flush();
                }
            }
            if (entry.getLockingSourceCount$okhttp() > 0 || entry.getCurrentEditor$okhttp() != null) {
                entry.setZombie$okhttp(true);
                return true;
            }
        }
        Editor currentEditor$okhttp = entry.getCurrentEditor$okhttp();
        if (currentEditor$okhttp != null) {
            currentEditor$okhttp.detach$okhttp();
        }
        int i = this.valueCount;
        for (int i2 = 0; i2 < i; i2++) {
            this.fileSystem.delete(entry.getCleanFiles$okhttp().get(i2));
            this.size -= entry.getLengths$okhttp()[i2];
            entry.getLengths$okhttp()[i2] = 0;
        }
        this.redundantOpCount++;
        BufferedSink bufferedSink2 = this.journalWriter;
        if (bufferedSink2 != null) {
            bufferedSink2.writeUtf8(REMOVE);
            bufferedSink2.writeByte(32);
            bufferedSink2.writeUtf8(entry.getKey$okhttp());
            bufferedSink2.writeByte(10);
        }
        this.lruEntries.remove(entry.getKey$okhttp());
        if (journalRebuildRequired()) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, null);
        }
        return true;
    }

    public final void setClosed$okhttp(boolean z) {
        this.closed = z;
    }

    public final synchronized void setMaxSize(long j) {
        this.maxSize = j;
        if (this.initialized) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, null);
        }
    }

    public final synchronized long size() throws IOException {
        try {
            initialize();
        }
        return this.size;
    }

    public final synchronized Iterator<Snapshot> snapshots() throws IOException {
        try {
            initialize();
        }
        return new DiskLruCache$snapshots$1(this);
    }

    public final void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            if (!removeOldestEntry()) {
                return;
            }
        }
        this.mostRecentTrimFailed = false;
    }
}
