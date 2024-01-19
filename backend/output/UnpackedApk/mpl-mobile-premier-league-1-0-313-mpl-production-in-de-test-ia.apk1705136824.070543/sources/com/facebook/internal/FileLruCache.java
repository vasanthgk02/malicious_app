package com.facebook.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger.Companion;
import com.userexperior.models.recording.enums.UeCustomType;
import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import kotlin.text.Charsets;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import sfs2x.client.entities.invitation.InvitationReply;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 )2\u00020\u0001:\b'()*+,-.B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0016\u001a\u00020\u0017J\u001f\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u0002J\u0016\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0019J\u001c\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u0007J\b\u0010 \u001a\u00020\u0017H\u0002J\u0018\u0010!\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u000bH\u0002J\u0006\u0010#\u001a\u00020$J\b\u0010%\u001a\u00020\u0003H\u0016J\b\u0010&\u001a\u00020\u0017H\u0002R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/facebook/internal/FileLruCache;", "", "tag", "", "limits", "Lcom/facebook/internal/FileLruCache$Limits;", "(Ljava/lang/String;Lcom/facebook/internal/FileLruCache$Limits;)V", "condition", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "directory", "Ljava/io/File;", "isTrimInProgress", "", "isTrimPending", "lastClearCacheTime", "Ljava/util/concurrent/atomic/AtomicLong;", "location", "getLocation", "()Ljava/lang/String;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "clearCache", "", "get", "Ljava/io/InputStream;", "key", "contentTag", "interceptAndPut", "input", "openPutStream", "Ljava/io/OutputStream;", "postTrim", "renameToTargetAndTrim", "buffer", "sizeInBytesForTest", "", "toString", "trim", "BufferFile", "CloseCallbackOutputStream", "Companion", "CopyingInputStream", "Limits", "ModifiedFile", "StreamCloseCallback", "StreamHeader", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: FileLruCache.kt */
public final class FileLruCache {
    public static final FileLruCache Companion = null;
    public static final AtomicLong bufferIndex = new AtomicLong();
    public final Condition condition;
    public final File directory;
    public boolean isTrimPending;
    public final AtomicLong lastClearCacheTime;
    public final Limits limits;
    public final ReentrantLock lock;
    public final String tag;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u0006J\u0010\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/internal/FileLruCache$BufferFile;", "", "()V", "FILE_NAME_PREFIX", "", "filterExcludeBufferFiles", "Ljava/io/FilenameFilter;", "filterExcludeNonBufferFiles", "deleteAll", "", "root", "Ljava/io/File;", "excludeBufferFiles", "excludeNonBufferFiles", "newFile", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: FileLruCache.kt */
    public static final class BufferFile {
        public static final BufferFile INSTANCE = null;
        public static final FilenameFilter filterExcludeBufferFiles = $$Lambda$Uwf3BLxDu3AhwSmJosUeq5paAY.INSTANCE;
        public static final FilenameFilter filterExcludeNonBufferFiles = $$Lambda$unX9NeGxjJ5DVb3vL7tbz4CiEM.INSTANCE;

        /* renamed from: filterExcludeBufferFiles$lambda-0  reason: not valid java name */
        public static final boolean m200filterExcludeBufferFiles$lambda0(File file, String str) {
            Intrinsics.checkNotNullExpressionValue(str, "filename");
            return !CharsKt__CharKt.startsWith$default(str, (String) "buffer", false, 2);
        }

        /* renamed from: filterExcludeNonBufferFiles$lambda-1  reason: not valid java name */
        public static final boolean m201filterExcludeNonBufferFiles$lambda1(File file, String str) {
            Intrinsics.checkNotNullExpressionValue(str, "filename");
            return CharsKt__CharKt.startsWith$default(str, (String) "buffer", false, 2);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0011H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/facebook/internal/FileLruCache$CloseCallbackOutputStream;", "Ljava/io/OutputStream;", "innerStream", "callback", "Lcom/facebook/internal/FileLruCache$StreamCloseCallback;", "(Ljava/io/OutputStream;Lcom/facebook/internal/FileLruCache$StreamCloseCallback;)V", "getCallback", "()Lcom/facebook/internal/FileLruCache$StreamCloseCallback;", "getInnerStream", "()Ljava/io/OutputStream;", "close", "", "flush", "write", "buffer", "", "offset", "", "count", "oneByte", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: FileLruCache.kt */
    public static final class CloseCallbackOutputStream extends OutputStream {
        public final StreamCloseCallback callback;
        public final OutputStream innerStream;

        public CloseCallbackOutputStream(OutputStream outputStream, StreamCloseCallback streamCloseCallback) {
            Intrinsics.checkNotNullParameter(outputStream, "innerStream");
            Intrinsics.checkNotNullParameter(streamCloseCallback, "callback");
            this.innerStream = outputStream;
            this.callback = streamCloseCallback;
        }

        public void close() throws IOException {
            try {
                this.innerStream.close();
            } finally {
                this.callback.onClose();
            }
        }

        public void flush() throws IOException {
            this.innerStream.flush();
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            Intrinsics.checkNotNullParameter(bArr, "buffer");
            this.innerStream.write(bArr, i, i2);
        }

        public void write(byte[] bArr) throws IOException {
            Intrinsics.checkNotNullParameter(bArr, "buffer");
            this.innerStream.write(bArr);
        }

        public void write(int i) throws IOException {
            this.innerStream.write(i);
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000bH\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0016R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/facebook/internal/FileLruCache$CopyingInputStream;", "Ljava/io/InputStream;", "input", "output", "Ljava/io/OutputStream;", "(Ljava/io/InputStream;Ljava/io/OutputStream;)V", "getInput", "()Ljava/io/InputStream;", "getOutput", "()Ljava/io/OutputStream;", "available", "", "close", "", "mark", "readlimit", "markSupported", "", "read", "buffer", "", "offset", "length", "reset", "skip", "", "byteCount", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: FileLruCache.kt */
    public static final class CopyingInputStream extends InputStream {
        public final InputStream input;
        public final OutputStream output;

        public CopyingInputStream(InputStream inputStream, OutputStream outputStream) {
            Intrinsics.checkNotNullParameter(inputStream, "input");
            Intrinsics.checkNotNullParameter(outputStream, "output");
            this.input = inputStream;
            this.output = outputStream;
        }

        public int available() throws IOException {
            return this.input.available();
        }

        public void close() throws IOException {
            try {
                this.input.close();
            } finally {
                this.output.close();
            }
        }

        public void mark(int i) {
            throw new UnsupportedOperationException();
        }

        public boolean markSupported() {
            return false;
        }

        public int read(byte[] bArr) throws IOException {
            Intrinsics.checkNotNullParameter(bArr, "buffer");
            int read = this.input.read(bArr);
            if (read > 0) {
                this.output.write(bArr, 0, read);
            }
            return read;
        }

        public synchronized void reset() {
            throw new UnsupportedOperationException();
        }

        public long skip(long j) throws IOException {
            byte[] bArr = new byte[1024];
            long j2 = 0;
            while (j2 < j) {
                int read = read(bArr, 0, (int) Math.min(j - j2, (long) 1024));
                if (read < 0) {
                    return j2;
                }
                j2 += (long) read;
            }
            return j2;
        }

        public int read() throws IOException {
            int read = this.input.read();
            if (read >= 0) {
                this.output.write(read);
            }
            return read;
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            Intrinsics.checkNotNullParameter(bArr, "buffer");
            int read = this.input.read(bArr, i, i2);
            if (read > 0) {
                this.output.write(bArr, i, read);
            }
            return read;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/facebook/internal/FileLruCache$Limits;", "", "()V", "value", "", "byteCount", "getByteCount", "()I", "setByteCount", "(I)V", "fileCount", "getFileCount", "setFileCount", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: FileLruCache.kt */
    public static final class Limits {
        public int byteCount = 1048576;
        public int fileCount = 1024;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0000H\u0002J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/facebook/internal/FileLruCache$ModifiedFile;", "", "file", "Ljava/io/File;", "(Ljava/io/File;)V", "getFile", "()Ljava/io/File;", "modified", "", "getModified", "()J", "compareTo", "", "another", "equals", "", "", "hashCode", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: FileLruCache.kt */
    public static final class ModifiedFile implements Comparable<ModifiedFile> {
        public final File file;
        public final long modified;

        public ModifiedFile(File file2) {
            Intrinsics.checkNotNullParameter(file2, "file");
            this.file = file2;
            this.modified = file2.lastModified();
        }

        public boolean equals(Object obj) {
            return (obj instanceof ModifiedFile) && compareTo((ModifiedFile) obj) == 0;
        }

        public int hashCode() {
            return ((this.file.hashCode() + 1073) * 37) + ((int) (this.modified % ((long) Integer.MAX_VALUE)));
        }

        public int compareTo(ModifiedFile modifiedFile) {
            Intrinsics.checkNotNullParameter(modifiedFile, "another");
            long j = this.modified;
            long j2 = modifiedFile.modified;
            if (j < j2) {
                return -1;
            }
            if (j > j2) {
                return 1;
            }
            return this.file.compareTo(modifiedFile.file);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bâ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/facebook/internal/FileLruCache$StreamCloseCallback;", "", "onClose", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: FileLruCache.kt */
    public interface StreamCloseCallback {
        void onClose();
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/facebook/internal/FileLruCache$StreamHeader;", "", "()V", "HEADER_VERSION", "", "readHeader", "Lorg/json/JSONObject;", "stream", "Ljava/io/InputStream;", "writeHeader", "", "Ljava/io/OutputStream;", "header", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: FileLruCache.kt */
    public static final class StreamHeader {
        public static final JSONObject readHeader(InputStream inputStream) throws IOException {
            Intrinsics.checkNotNullParameter(inputStream, BaseParser.STREAM_STRING);
            if (inputStream.read() != 0) {
                return null;
            }
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < 3; i3++) {
                int read = inputStream.read();
                if (read == -1) {
                    Companion companion = Logger.Companion;
                    LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                    FileLruCache fileLruCache = FileLruCache.Companion;
                    Intrinsics.checkNotNullExpressionValue("FileLruCache", UeCustomType.TAG);
                    companion.log(loggingBehavior, "FileLruCache", "readHeader: stream.read returned -1 while reading header size");
                    return null;
                }
                i2 = (i2 << 8) + (read & InvitationReply.EXPIRED);
            }
            byte[] bArr = new byte[i2];
            while (i < i2) {
                int read2 = inputStream.read(bArr, i, i2 - i);
                if (read2 < 1) {
                    Companion companion2 = Logger.Companion;
                    LoggingBehavior loggingBehavior2 = LoggingBehavior.CACHE;
                    FileLruCache fileLruCache2 = FileLruCache.Companion;
                    StringBuilder outline79 = GeneratedOutlineSupport.outline79("FileLruCache", UeCustomType.TAG, "readHeader: stream.read stopped at ");
                    outline79.append(Integer.valueOf(i));
                    outline79.append(" when expected ");
                    outline79.append(i2);
                    companion2.log(loggingBehavior2, "FileLruCache", outline79.toString());
                    return null;
                }
                i += read2;
            }
            try {
                Object nextValue = new JSONTokener(new String(bArr, Charsets.UTF_8)).nextValue();
                if (nextValue instanceof JSONObject) {
                    return (JSONObject) nextValue;
                }
                Companion companion3 = Logger.Companion;
                LoggingBehavior loggingBehavior3 = LoggingBehavior.CACHE;
                FileLruCache fileLruCache3 = FileLruCache.Companion;
                Intrinsics.checkNotNullExpressionValue("FileLruCache", UeCustomType.TAG);
                companion3.log(loggingBehavior3, "FileLruCache", Intrinsics.stringPlus("readHeader: expected JSONObject, got ", nextValue.getClass().getCanonicalName()));
                return null;
            } catch (JSONException e2) {
                throw new IOException(e2.getMessage());
            }
        }
    }

    public FileLruCache(String str, Limits limits2) {
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        Intrinsics.checkNotNullParameter(limits2, "limits");
        this.tag = str;
        this.limits = limits2;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Validate.sdkInitialized();
        LockOnGetVariable<File> lockOnGetVariable = FacebookSdk.cacheDir;
        if (lockOnGetVariable != null) {
            CountDownLatch countDownLatch = lockOnGetVariable.initLatch;
            if (countDownLatch != null) {
                try {
                    countDownLatch.await();
                } catch (InterruptedException unused) {
                }
            }
            this.directory = new File((File) lockOnGetVariable.storedValue, this.tag);
            ReentrantLock reentrantLock = new ReentrantLock();
            this.lock = reentrantLock;
            this.condition = reentrantLock.newCondition();
            this.lastClearCacheTime = new AtomicLong(0);
            if (this.directory.mkdirs() || this.directory.isDirectory()) {
                BufferFile bufferFile = BufferFile.INSTANCE;
                File file = this.directory;
                Intrinsics.checkNotNullParameter(file, "root");
                File[] listFiles = file.listFiles(BufferFile.filterExcludeNonBufferFiles);
                if (listFiles != null) {
                    int i = 0;
                    int length = listFiles.length;
                    while (i < length) {
                        File file2 = listFiles[i];
                        i++;
                        file2.delete();
                    }
                    return;
                }
                return;
            }
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cacheDir");
        throw null;
    }

    public static /* synthetic */ InputStream get$default(FileLruCache fileLruCache, String str, String str2, int i) throws IOException {
        int i2 = i & 2;
        return fileLruCache.get(str, null);
    }

    /* renamed from: postTrim$lambda-3$lambda-2  reason: not valid java name */
    public static final void m199postTrim$lambda3$lambda2(FileLruCache fileLruCache) {
        ReentrantLock reentrantLock;
        long j;
        FileLruCache fileLruCache2 = fileLruCache;
        Intrinsics.checkNotNullParameter(fileLruCache2, "this$0");
        ReentrantLock reentrantLock2 = fileLruCache2.lock;
        reentrantLock2.lock();
        int i = 0;
        try {
            fileLruCache2.isTrimPending = false;
            reentrantLock2.unlock();
            try {
                Companion companion = Logger.Companion;
                LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                Intrinsics.checkNotNullExpressionValue("FileLruCache", UeCustomType.TAG);
                companion.log(loggingBehavior, "FileLruCache", "trim started");
                PriorityQueue priorityQueue = new PriorityQueue();
                File file = fileLruCache2.directory;
                BufferFile bufferFile = BufferFile.INSTANCE;
                File[] listFiles = file.listFiles(BufferFile.filterExcludeBufferFiles);
                long j2 = 0;
                if (listFiles != null) {
                    int length = listFiles.length;
                    j = 0;
                    while (i < length) {
                        File file2 = listFiles[i];
                        Intrinsics.checkNotNullExpressionValue(file2, "file");
                        priorityQueue.add(new ModifiedFile(file2));
                        Companion companion2 = Logger.Companion;
                        LoggingBehavior loggingBehavior2 = LoggingBehavior.CACHE;
                        Intrinsics.checkNotNullExpressionValue("FileLruCache", UeCustomType.TAG);
                        companion2.log(loggingBehavior2, "FileLruCache", "  trim considering time=" + Long.valueOf(r12.modified) + " name=" + r12.file.getName());
                        j2 += file2.length();
                        j++;
                        i++;
                        listFiles = listFiles;
                    }
                } else {
                    j = 0;
                }
                while (true) {
                    if (j2 > ((long) fileLruCache2.limits.byteCount) || j > ((long) fileLruCache2.limits.fileCount)) {
                        File file3 = ((ModifiedFile) priorityQueue.remove()).file;
                        Companion companion3 = Logger.Companion;
                        LoggingBehavior loggingBehavior3 = LoggingBehavior.CACHE;
                        Intrinsics.checkNotNullExpressionValue("FileLruCache", UeCustomType.TAG);
                        companion3.log(loggingBehavior3, "FileLruCache", Intrinsics.stringPlus("  trim removing ", file3.getName()));
                        j2 -= file3.length();
                        j--;
                        file3.delete();
                    } else {
                        reentrantLock = fileLruCache2.lock;
                        reentrantLock.lock();
                        try {
                            fileLruCache2.condition.signalAll();
                            return;
                        } finally {
                            reentrantLock.unlock();
                        }
                    }
                }
            } catch (Throwable th) {
                reentrantLock = fileLruCache2.lock;
                reentrantLock.lock();
                fileLruCache2.condition.signalAll();
                throw th;
            } finally {
                reentrantLock.unlock();
            }
        } catch (Throwable th2) {
            Throwable th3 = th2;
            reentrantLock2.unlock();
            throw th3;
        }
    }

    public final InputStream get(String str, String str2) throws IOException {
        Intrinsics.checkNotNullParameter(str, "key");
        File file = new File(this.directory, Utility.md5hash(str));
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 8192);
            boolean z = false;
            try {
                z = StreamHeader.readHeader(bufferedInputStream);
                if (z == null) {
                    return null;
                }
                if (!Intrinsics.areEqual(z.optString("key"), str)) {
                    bufferedInputStream.close();
                    return null;
                }
                String optString = z.optString(InlineAnimation.TAG, null);
                if (str2 != null || Intrinsics.areEqual(str2, optString)) {
                    long time = new Date().getTime();
                    Companion companion = Logger.Companion;
                    LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                    Intrinsics.checkNotNullExpressionValue("FileLruCache", UeCustomType.TAG);
                    companion.log(loggingBehavior, "FileLruCache", "Setting lastModified to " + Long.valueOf(time) + " for " + file.getName());
                    file.setLastModified(time);
                    return bufferedInputStream;
                }
                bufferedInputStream.close();
                return null;
            } finally {
                if (!z) {
                    bufferedInputStream.close();
                }
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public final OutputStream openPutStream(String str, String str2) throws IOException {
        Intrinsics.checkNotNullParameter(str, "key");
        BufferFile bufferFile = BufferFile.INSTANCE;
        File file = new File(this.directory, Intrinsics.stringPlus("buffer", Long.valueOf(bufferIndex.incrementAndGet())));
        file.delete();
        if (file.createNewFile()) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                FileLruCache$openPutStream$renameToTargetCallback$1 fileLruCache$openPutStream$renameToTargetCallback$1 = new FileLruCache$openPutStream$renameToTargetCallback$1(System.currentTimeMillis(), this, file, str);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new CloseCallbackOutputStream(fileOutputStream, fileLruCache$openPutStream$renameToTargetCallback$1), 8192);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", str);
                    if (!Utility.isNullOrEmpty(str2)) {
                        jSONObject.put(InlineAnimation.TAG, str2);
                    }
                    Intrinsics.checkNotNullParameter(bufferedOutputStream, BaseParser.STREAM_STRING);
                    Intrinsics.checkNotNullParameter(jSONObject, "header");
                    String jSONObject2 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "header.toString()");
                    byte[] bytes = jSONObject2.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                    bufferedOutputStream.write(0);
                    bufferedOutputStream.write((bytes.length >> 16) & InvitationReply.EXPIRED);
                    bufferedOutputStream.write((bytes.length >> 8) & InvitationReply.EXPIRED);
                    bufferedOutputStream.write((bytes.length >> 0) & InvitationReply.EXPIRED);
                    bufferedOutputStream.write(bytes);
                    return bufferedOutputStream;
                } catch (JSONException e2) {
                    Companion companion = Logger.Companion;
                    LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                    Intrinsics.checkNotNullExpressionValue("FileLruCache", UeCustomType.TAG);
                    companion.log(loggingBehavior, 5, (String) "FileLruCache", Intrinsics.stringPlus("Error creating JSON header for cache file: ", e2));
                    throw new IOException(e2.getMessage());
                } catch (Throwable th) {
                    bufferedOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e3) {
                Companion companion2 = Logger.Companion;
                LoggingBehavior loggingBehavior2 = LoggingBehavior.CACHE;
                Intrinsics.checkNotNullExpressionValue("FileLruCache", UeCustomType.TAG);
                companion2.log(loggingBehavior2, 5, (String) "FileLruCache", Intrinsics.stringPlus("Error creating buffer output stream: ", e3));
                throw new IOException(e3.getMessage());
            }
        } else {
            throw new IOException(Intrinsics.stringPlus("Could not create file at ", file.getAbsolutePath()));
        }
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("{FileLruCache: tag:");
        outline73.append(this.tag);
        outline73.append(" file:");
        outline73.append(this.directory.getName());
        outline73.append('}');
        return outline73.toString();
    }
}
