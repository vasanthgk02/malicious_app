package io.sentry;

import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import io.sentry.SentryEnvelopeItem.CachedItem;
import io.sentry.util.Objects;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.Callable;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class SentryEnvelopeItem {
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    public byte[] data;
    public final Callable<byte[]> dataFactory;
    public final SentryEnvelopeItemHeader header;

    public static class CachedItem {
        public byte[] bytes;
        public final Callable<byte[]> dataFactory;

        public CachedItem(Callable<byte[]> callable) {
            this.dataFactory = callable;
        }

        public static byte[] orEmptyArray(byte[] bArr) {
            return bArr != null ? bArr : new byte[0];
        }

        public byte[] getBytes() throws Exception {
            if (this.bytes == null) {
                Callable<byte[]> callable = this.dataFactory;
                if (callable != null) {
                    this.bytes = callable.call();
                }
            }
            return orEmptyArray(this.bytes);
        }
    }

    public static /* synthetic */ void $closeResource(Throwable th, AutoCloseable autoCloseable) {
        if (th != null) {
            try {
                autoCloseable.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else {
            autoCloseable.close();
        }
    }

    public SentryEnvelopeItem(SentryEnvelopeItemHeader sentryEnvelopeItemHeader, byte[] bArr) {
        this.header = (SentryEnvelopeItemHeader) Objects.requireNonNull(sentryEnvelopeItemHeader, "SentryEnvelopeItemHeader is required.");
        this.data = bArr;
        this.dataFactory = null;
    }

    public static SentryEnvelopeItem fromAttachment(Attachment attachment, long j) {
        CachedItem cachedItem = new CachedItem(new Callable(j) {
            public final /* synthetic */ long f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return SentryEnvelopeItem.lambda$fromAttachment$9(Attachment.this, this.f$1);
            }
        });
        SentryEnvelopeItemHeader sentryEnvelopeItemHeader = new SentryEnvelopeItemHeader(SentryItemType.Attachment, (Callable<Integer>) new Callable() {
            public final Object call() {
                return Integer.valueOf(CachedItem.this.getBytes().length);
            }
        }, attachment.getContentType(), attachment.getFilename(), attachment.getAttachmentType());
        return new SentryEnvelopeItem(sentryEnvelopeItemHeader, (Callable<byte[]>) new Callable() {
            public final Object call() {
                return CachedItem.this.getBytes();
            }
        });
    }

    public static SentryEnvelopeItem fromEvent(ISerializer iSerializer, SentryBaseEvent sentryBaseEvent) throws IOException {
        Objects.requireNonNull(iSerializer, "ISerializer is required.");
        Objects.requireNonNull(sentryBaseEvent, "SentryEvent is required.");
        CachedItem cachedItem = new CachedItem(new Callable(sentryBaseEvent) {
            public final /* synthetic */ SentryBaseEvent f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return SentryEnvelopeItem.lambda$fromEvent$3(ISerializer.this, this.f$1);
            }
        });
        return new SentryEnvelopeItem(new SentryEnvelopeItemHeader(SentryItemType.resolve(sentryBaseEvent), new Callable() {
            public final Object call() {
                return Integer.valueOf(CachedItem.this.getBytes().length);
            }
        }, DefaultSettingsSpiCall.ACCEPT_JSON_VALUE, null), (Callable<byte[]>) new Callable() {
            public final Object call() {
                return CachedItem.this.getBytes();
            }
        });
    }

    public static SentryEnvelopeItem fromSession(ISerializer iSerializer, Session session) throws IOException {
        Objects.requireNonNull(iSerializer, "ISerializer is required.");
        Objects.requireNonNull(session, "Session is required.");
        CachedItem cachedItem = new CachedItem(new Callable(session) {
            public final /* synthetic */ Session f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return SentryEnvelopeItem.lambda$fromSession$0(ISerializer.this, this.f$1);
            }
        });
        return new SentryEnvelopeItem(new SentryEnvelopeItemHeader(SentryItemType.Session, new Callable() {
            public final Object call() {
                return Integer.valueOf(CachedItem.this.getBytes().length);
            }
        }, DefaultSettingsSpiCall.ACCEPT_JSON_VALUE, null), (Callable<byte[]>) new Callable() {
            public final Object call() {
                return CachedItem.this.getBytes();
            }
        });
    }

    public static SentryEnvelopeItem fromUserFeedback(ISerializer iSerializer, UserFeedback userFeedback) {
        Objects.requireNonNull(iSerializer, "ISerializer is required.");
        Objects.requireNonNull(userFeedback, "UserFeedback is required.");
        CachedItem cachedItem = new CachedItem(new Callable(userFeedback) {
            public final /* synthetic */ UserFeedback f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return SentryEnvelopeItem.lambda$fromUserFeedback$6(ISerializer.this, this.f$1);
            }
        });
        return new SentryEnvelopeItem(new SentryEnvelopeItemHeader(SentryItemType.UserFeedback, new Callable() {
            public final Object call() {
                return Integer.valueOf(CachedItem.this.getBytes().length);
            }
        }, DefaultSettingsSpiCall.ACCEPT_JSON_VALUE, null), (Callable<byte[]>) new Callable() {
            public final Object call() {
                return CachedItem.this.getBytes();
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0094, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        $closeResource(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0098, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x009b, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        $closeResource(r0, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x009f, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00a2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        $closeResource(r11, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00a6, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ byte[] lambda$fromAttachment$9(io.sentry.Attachment r9, long r10) throws java.lang.Exception {
        /*
            byte[] r0 = r9.getBytes()
            r1 = 2
            r2 = 3
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L_0x003e
            byte[] r0 = r9.getBytes()
            int r0 = r0.length
            long r5 = (long) r0
            int r0 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r0 > 0) goto L_0x0019
            byte[] r9 = r9.getBytes()
            return r9
        L_0x0019:
            io.sentry.exception.SentryEnvelopeException r0 = new io.sentry.exception.SentryEnvelopeException
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r5 = r9.getFilename()
            r2[r4] = r5
            byte[] r9 = r9.getBytes()
            int r9 = r9.length
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r2[r3] = r9
            java.lang.Long r9 = java.lang.Long.valueOf(r10)
            r2[r1] = r9
            java.lang.String r9 = "Dropping attachment with filename '%s', because the size of the passed bytes with %d bytes is bigger than the maximum allowed attachment size of %d bytes."
            java.lang.String r9 = java.lang.String.format(r9, r2)
            r0.<init>(r9)
            throw r0
        L_0x003e:
            java.lang.String r0 = r9.getPathname()
            if (r0 == 0) goto L_0x0107
            java.io.File r0 = new java.io.File     // Catch:{ IOException | SecurityException -> 0x00f3 }
            java.lang.String r5 = r9.getPathname()     // Catch:{ IOException | SecurityException -> 0x00f3 }
            r0.<init>(r5)     // Catch:{ IOException | SecurityException -> 0x00f3 }
            boolean r5 = r0.isFile()     // Catch:{ IOException | SecurityException -> 0x00f3 }
            if (r5 == 0) goto L_0x00df
            boolean r5 = r0.canRead()     // Catch:{ IOException | SecurityException -> 0x00f3 }
            if (r5 == 0) goto L_0x00cb
            long r5 = r0.length()     // Catch:{ IOException | SecurityException -> 0x00f3 }
            int r7 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r7 > 0) goto L_0x00a7
            java.io.FileInputStream r10 = new java.io.FileInputStream     // Catch:{ IOException | SecurityException -> 0x00f3 }
            java.lang.String r11 = r9.getPathname()     // Catch:{ IOException | SecurityException -> 0x00f3 }
            r10.<init>(r11)     // Catch:{ IOException | SecurityException -> 0x00f3 }
            java.io.BufferedInputStream r11 = new java.io.BufferedInputStream     // Catch:{ all -> 0x00a0 }
            r11.<init>(r10)     // Catch:{ all -> 0x00a0 }
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0099 }
            r0.<init>()     // Catch:{ all -> 0x0099 }
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch:{ all -> 0x0092 }
        L_0x0078:
            int r2 = r11.read(r1)     // Catch:{ all -> 0x0092 }
            r5 = -1
            if (r2 == r5) goto L_0x0083
            r0.write(r1, r4, r2)     // Catch:{ all -> 0x0092 }
            goto L_0x0078
        L_0x0083:
            byte[] r1 = r0.toByteArray()     // Catch:{ all -> 0x0092 }
            r2 = 0
            $closeResource(r2, r0)     // Catch:{ all -> 0x0099 }
            $closeResource(r2, r11)     // Catch:{ all -> 0x00a0 }
            $closeResource(r2, r10)     // Catch:{ IOException | SecurityException -> 0x00f3 }
            return r1
        L_0x0092:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0094 }
        L_0x0094:
            r2 = move-exception
            $closeResource(r1, r0)     // Catch:{ all -> 0x0099 }
            throw r2     // Catch:{ all -> 0x0099 }
        L_0x0099:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x009b }
        L_0x009b:
            r1 = move-exception
            $closeResource(r0, r11)     // Catch:{ all -> 0x00a0 }
            throw r1     // Catch:{ all -> 0x00a0 }
        L_0x00a0:
            r11 = move-exception
            throw r11     // Catch:{ all -> 0x00a2 }
        L_0x00a2:
            r0 = move-exception
            $closeResource(r11, r10)     // Catch:{ IOException | SecurityException -> 0x00f3 }
            throw r0     // Catch:{ IOException | SecurityException -> 0x00f3 }
        L_0x00a7:
            io.sentry.exception.SentryEnvelopeException r5 = new io.sentry.exception.SentryEnvelopeException     // Catch:{ IOException | SecurityException -> 0x00f3 }
            java.lang.String r6 = "Dropping attachment, because the size of the it located at '%s' with %d bytes is bigger than the maximum allowed attachment size of %d bytes."
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ IOException | SecurityException -> 0x00f3 }
            java.lang.String r7 = r9.getPathname()     // Catch:{ IOException | SecurityException -> 0x00f3 }
            r2[r4] = r7     // Catch:{ IOException | SecurityException -> 0x00f3 }
            long r7 = r0.length()     // Catch:{ IOException | SecurityException -> 0x00f3 }
            java.lang.Long r0 = java.lang.Long.valueOf(r7)     // Catch:{ IOException | SecurityException -> 0x00f3 }
            r2[r3] = r0     // Catch:{ IOException | SecurityException -> 0x00f3 }
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ IOException | SecurityException -> 0x00f3 }
            r2[r1] = r10     // Catch:{ IOException | SecurityException -> 0x00f3 }
            java.lang.String r10 = java.lang.String.format(r6, r2)     // Catch:{ IOException | SecurityException -> 0x00f3 }
            r5.<init>(r10)     // Catch:{ IOException | SecurityException -> 0x00f3 }
            throw r5     // Catch:{ IOException | SecurityException -> 0x00f3 }
        L_0x00cb:
            io.sentry.exception.SentryEnvelopeException r10 = new io.sentry.exception.SentryEnvelopeException     // Catch:{ IOException | SecurityException -> 0x00f3 }
            java.lang.String r11 = "Reading the attachment %s failed, because can't read the file."
            java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch:{ IOException | SecurityException -> 0x00f3 }
            java.lang.String r1 = r9.getPathname()     // Catch:{ IOException | SecurityException -> 0x00f3 }
            r0[r4] = r1     // Catch:{ IOException | SecurityException -> 0x00f3 }
            java.lang.String r11 = java.lang.String.format(r11, r0)     // Catch:{ IOException | SecurityException -> 0x00f3 }
            r10.<init>(r11)     // Catch:{ IOException | SecurityException -> 0x00f3 }
            throw r10     // Catch:{ IOException | SecurityException -> 0x00f3 }
        L_0x00df:
            io.sentry.exception.SentryEnvelopeException r10 = new io.sentry.exception.SentryEnvelopeException     // Catch:{ IOException | SecurityException -> 0x00f3 }
            java.lang.String r11 = "Reading the attachment %s failed, because the file located at the path is not a file."
            java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch:{ IOException | SecurityException -> 0x00f3 }
            java.lang.String r1 = r9.getPathname()     // Catch:{ IOException | SecurityException -> 0x00f3 }
            r0[r4] = r1     // Catch:{ IOException | SecurityException -> 0x00f3 }
            java.lang.String r11 = java.lang.String.format(r11, r0)     // Catch:{ IOException | SecurityException -> 0x00f3 }
            r10.<init>(r11)     // Catch:{ IOException | SecurityException -> 0x00f3 }
            throw r10     // Catch:{ IOException | SecurityException -> 0x00f3 }
        L_0x00f3:
            io.sentry.exception.SentryEnvelopeException r10 = new io.sentry.exception.SentryEnvelopeException
            java.lang.Object[] r11 = new java.lang.Object[r3]
            java.lang.String r9 = r9.getPathname()
            r11[r4] = r9
            java.lang.String r9 = "Reading the attachment %s failed."
            java.lang.String r9 = java.lang.String.format(r9, r11)
            r10.<init>(r9)
            throw r10
        L_0x0107:
            io.sentry.exception.SentryEnvelopeException r10 = new io.sentry.exception.SentryEnvelopeException
            java.lang.Object[] r11 = new java.lang.Object[r3]
            java.lang.String r9 = r9.getFilename()
            r11[r4] = r9
            java.lang.String r9 = "Couldn't attach the attachment %s.\nPlease check that either bytes or a path is set."
            java.lang.String r9 = java.lang.String.format(r9, r11)
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.SentryEnvelopeItem.lambda$fromAttachment$9(io.sentry.Attachment, long):byte[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0022, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        $closeResource(r4, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0026, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0029, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002a, code lost:
        $closeResource(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002d, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ byte[] lambda$fromEvent$3(io.sentry.ISerializer r4, io.sentry.SentryBaseEvent r5) throws java.lang.Exception {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            java.io.BufferedWriter r1 = new java.io.BufferedWriter     // Catch:{ all -> 0x0027 }
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x0027 }
            java.nio.charset.Charset r3 = UTF_8     // Catch:{ all -> 0x0027 }
            r2.<init>(r0, r3)     // Catch:{ all -> 0x0027 }
            r1.<init>(r2)     // Catch:{ all -> 0x0027 }
            r4.serialize(r5, r1)     // Catch:{ all -> 0x0020 }
            byte[] r4 = r0.toByteArray()     // Catch:{ all -> 0x0020 }
            r5 = 0
            $closeResource(r5, r1)     // Catch:{ all -> 0x0027 }
            $closeResource(r5, r0)
            return r4
        L_0x0020:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0022 }
        L_0x0022:
            r5 = move-exception
            $closeResource(r4, r1)     // Catch:{ all -> 0x0027 }
            throw r5     // Catch:{ all -> 0x0027 }
        L_0x0027:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0029 }
        L_0x0029:
            r5 = move-exception
            $closeResource(r4, r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.SentryEnvelopeItem.lambda$fromEvent$3(io.sentry.ISerializer, io.sentry.SentryBaseEvent):byte[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0022, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        $closeResource(r4, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0026, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0029, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002a, code lost:
        $closeResource(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002d, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ byte[] lambda$fromSession$0(io.sentry.ISerializer r4, io.sentry.Session r5) throws java.lang.Exception {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            java.io.BufferedWriter r1 = new java.io.BufferedWriter     // Catch:{ all -> 0x0027 }
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x0027 }
            java.nio.charset.Charset r3 = UTF_8     // Catch:{ all -> 0x0027 }
            r2.<init>(r0, r3)     // Catch:{ all -> 0x0027 }
            r1.<init>(r2)     // Catch:{ all -> 0x0027 }
            r4.serialize(r5, r1)     // Catch:{ all -> 0x0020 }
            byte[] r4 = r0.toByteArray()     // Catch:{ all -> 0x0020 }
            r5 = 0
            $closeResource(r5, r1)     // Catch:{ all -> 0x0027 }
            $closeResource(r5, r0)
            return r4
        L_0x0020:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0022 }
        L_0x0022:
            r5 = move-exception
            $closeResource(r4, r1)     // Catch:{ all -> 0x0027 }
            throw r5     // Catch:{ all -> 0x0027 }
        L_0x0027:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0029 }
        L_0x0029:
            r5 = move-exception
            $closeResource(r4, r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.SentryEnvelopeItem.lambda$fromSession$0(io.sentry.ISerializer, io.sentry.Session):byte[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0022, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        $closeResource(r4, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0026, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0029, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002a, code lost:
        $closeResource(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002d, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ byte[] lambda$fromUserFeedback$6(io.sentry.ISerializer r4, io.sentry.UserFeedback r5) throws java.lang.Exception {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            java.io.BufferedWriter r1 = new java.io.BufferedWriter     // Catch:{ all -> 0x0027 }
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x0027 }
            java.nio.charset.Charset r3 = UTF_8     // Catch:{ all -> 0x0027 }
            r2.<init>(r0, r3)     // Catch:{ all -> 0x0027 }
            r1.<init>(r2)     // Catch:{ all -> 0x0027 }
            r4.serialize(r5, r1)     // Catch:{ all -> 0x0020 }
            byte[] r4 = r0.toByteArray()     // Catch:{ all -> 0x0020 }
            r5 = 0
            $closeResource(r5, r1)     // Catch:{ all -> 0x0027 }
            $closeResource(r5, r0)
            return r4
        L_0x0020:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0022 }
        L_0x0022:
            r5 = move-exception
            $closeResource(r4, r1)     // Catch:{ all -> 0x0027 }
            throw r5     // Catch:{ all -> 0x0027 }
        L_0x0027:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0029 }
        L_0x0029:
            r5 = move-exception
            $closeResource(r4, r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.SentryEnvelopeItem.lambda$fromUserFeedback$6(io.sentry.ISerializer, io.sentry.UserFeedback):byte[]");
    }

    public byte[] getData() throws Exception {
        if (this.data == null) {
            Callable<byte[]> callable = this.dataFactory;
            if (callable != null) {
                this.data = callable.call();
            }
        }
        return this.data;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0031, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        $closeResource(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0035, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.sentry.SentryEvent getEvent(io.sentry.ISerializer r6) throws java.lang.Exception {
        /*
            r5 = this;
            io.sentry.SentryEnvelopeItemHeader r0 = r5.header
            r1 = 0
            if (r0 == 0) goto L_0x0036
            io.sentry.SentryItemType r0 = r0.getType()
            io.sentry.SentryItemType r2 = io.sentry.SentryItemType.Event
            if (r0 == r2) goto L_0x000e
            goto L_0x0036
        L_0x000e:
            java.io.BufferedReader r0 = new java.io.BufferedReader
            java.io.InputStreamReader r2 = new java.io.InputStreamReader
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream
            byte[] r4 = r5.getData()
            r3.<init>(r4)
            java.nio.charset.Charset r4 = UTF_8
            r2.<init>(r3, r4)
            r0.<init>(r2)
            java.lang.Class<io.sentry.SentryEvent> r2 = io.sentry.SentryEvent.class
            java.lang.Object r6 = r6.deserialize(r0, r2)     // Catch:{ all -> 0x002f }
            io.sentry.SentryEvent r6 = (io.sentry.SentryEvent) r6     // Catch:{ all -> 0x002f }
            $closeResource(r1, r0)
            return r6
        L_0x002f:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0031 }
        L_0x0031:
            r1 = move-exception
            $closeResource(r6, r0)
            throw r1
        L_0x0036:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.SentryEnvelopeItem.getEvent(io.sentry.ISerializer):io.sentry.SentryEvent");
    }

    public SentryEnvelopeItemHeader getHeader() {
        return this.header;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0031, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        $closeResource(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0035, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.sentry.protocol.SentryTransaction getTransaction(io.sentry.ISerializer r6) throws java.lang.Exception {
        /*
            r5 = this;
            io.sentry.SentryEnvelopeItemHeader r0 = r5.header
            r1 = 0
            if (r0 == 0) goto L_0x0036
            io.sentry.SentryItemType r0 = r0.getType()
            io.sentry.SentryItemType r2 = io.sentry.SentryItemType.Transaction
            if (r0 == r2) goto L_0x000e
            goto L_0x0036
        L_0x000e:
            java.io.BufferedReader r0 = new java.io.BufferedReader
            java.io.InputStreamReader r2 = new java.io.InputStreamReader
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream
            byte[] r4 = r5.getData()
            r3.<init>(r4)
            java.nio.charset.Charset r4 = UTF_8
            r2.<init>(r3, r4)
            r0.<init>(r2)
            java.lang.Class<io.sentry.protocol.SentryTransaction> r2 = io.sentry.protocol.SentryTransaction.class
            java.lang.Object r6 = r6.deserialize(r0, r2)     // Catch:{ all -> 0x002f }
            io.sentry.protocol.SentryTransaction r6 = (io.sentry.protocol.SentryTransaction) r6     // Catch:{ all -> 0x002f }
            $closeResource(r1, r0)
            return r6
        L_0x002f:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0031 }
        L_0x0031:
            r1 = move-exception
            $closeResource(r6, r0)
            throw r1
        L_0x0036:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.SentryEnvelopeItem.getTransaction(io.sentry.ISerializer):io.sentry.protocol.SentryTransaction");
    }

    public SentryEnvelopeItem(SentryEnvelopeItemHeader sentryEnvelopeItemHeader, Callable<byte[]> callable) {
        this.header = (SentryEnvelopeItemHeader) Objects.requireNonNull(sentryEnvelopeItemHeader, "SentryEnvelopeItemHeader is required.");
        this.dataFactory = (Callable) Objects.requireNonNull(callable, "DataFactory is required.");
        this.data = null;
    }
}
