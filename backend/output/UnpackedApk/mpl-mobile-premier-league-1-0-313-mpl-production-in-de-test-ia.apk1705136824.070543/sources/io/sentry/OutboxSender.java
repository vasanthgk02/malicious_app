package io.sentry;

import io.sentry.hints.Flushable;
import io.sentry.protocol.SentryId;
import io.sentry.util.LogUtils;
import io.sentry.util.Objects;
import java.io.File;
import java.nio.charset.Charset;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class OutboxSender extends DirectoryProcessor implements IEnvelopeSender {
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    public final IEnvelopeReader envelopeReader;
    public final IHub hub;
    public final ILogger logger;
    public final ISerializer serializer;

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

    public OutboxSender(IHub iHub, IEnvelopeReader iEnvelopeReader, ISerializer iSerializer, ILogger iLogger, long j) {
        super(iLogger, j);
        this.hub = (IHub) Objects.requireNonNull(iHub, "Hub is required.");
        this.envelopeReader = (IEnvelopeReader) Objects.requireNonNull(iEnvelopeReader, "Envelope reader is required.");
        this.serializer = (ISerializer) Objects.requireNonNull(iSerializer, "Serializer is required.");
        this.logger = (ILogger) Objects.requireNonNull(iLogger, "Logger is required.");
    }

    private void logEnvelopeItemNull(SentryEnvelopeItem sentryEnvelopeItem, int i) {
        this.logger.log(SentryLevel.ERROR, (String) "Item %d of type %s returned null by the parser.", Integer.valueOf(i), sentryEnvelopeItem.getHeader().getType());
    }

    private void logItemCaptured(int i) {
        this.logger.log(SentryLevel.DEBUG, (String) "Item %d is being captured.", Integer.valueOf(i));
    }

    private void logTimeout(SentryId sentryId) {
        this.logger.log(SentryLevel.WARNING, (String) "Timed out waiting for event id submission: %s", sentryId);
    }

    private void logUnexpectedEventId(SentryEnvelope sentryEnvelope, SentryId sentryId, int i) {
        this.logger.log(SentryLevel.ERROR, (String) "Item %d of has a different event id (%s) to the envelope header (%s)", Integer.valueOf(i), sentryEnvelope.getHeader().getEventId(), sentryId);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ca, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        $closeResource(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ce, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x016d, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        $closeResource(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0171, code lost:
        throw r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void processEnvelope(io.sentry.SentryEnvelope r12, java.lang.Object r13) throws java.io.IOException {
        /*
            r11 = this;
            io.sentry.ILogger r0 = r11.logger
            io.sentry.SentryLevel r1 = io.sentry.SentryLevel.DEBUG
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.Iterable r4 = r12.getItems()
            int r4 = io.sentry.util.CollectionUtils.size(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5 = 0
            r3[r5] = r4
            java.lang.String r4 = "Processing Envelope with %d item(s)"
            r0.log(r1, r4, r3)
            java.lang.Iterable r0 = r12.getItems()
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L_0x0024:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0200
            java.lang.Object r3 = r0.next()
            io.sentry.SentryEnvelopeItem r3 = (io.sentry.SentryEnvelopeItem) r3
            int r1 = r1 + r2
            io.sentry.SentryEnvelopeItemHeader r4 = r3.getHeader()
            if (r4 != 0) goto L_0x0049
            io.sentry.ILogger r3 = r11.logger
            io.sentry.SentryLevel r4 = io.sentry.SentryLevel.ERROR
            java.lang.Object[] r6 = new java.lang.Object[r2]
            java.lang.Integer r7 = java.lang.Integer.valueOf(r1)
            r6[r5] = r7
            java.lang.String r7 = "Item %d has no header"
            r3.log(r4, r7, r6)
            goto L_0x0024
        L_0x0049:
            io.sentry.SentryItemType r4 = io.sentry.SentryItemType.Event
            io.sentry.SentryEnvelopeItemHeader r6 = r3.getHeader()
            io.sentry.SentryItemType r6 = r6.getType()
            boolean r4 = r4.equals(r6)
            r6 = 0
            java.lang.String r7 = "Item failed to process."
            if (r4 == 0) goto L_0x00d9
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00cf }
            java.io.InputStreamReader r8 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00cf }
            java.io.ByteArrayInputStream r9 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x00cf }
            byte[] r10 = r3.getData()     // Catch:{ Exception -> 0x00cf }
            r9.<init>(r10)     // Catch:{ Exception -> 0x00cf }
            java.nio.charset.Charset r10 = UTF_8     // Catch:{ Exception -> 0x00cf }
            r8.<init>(r9, r10)     // Catch:{ Exception -> 0x00cf }
            r4.<init>(r8)     // Catch:{ Exception -> 0x00cf }
            io.sentry.ISerializer r8 = r11.serializer     // Catch:{ all -> 0x00c8 }
            java.lang.Class<io.sentry.SentryEvent> r9 = io.sentry.SentryEvent.class
            java.lang.Object r8 = r8.deserialize(r4, r9)     // Catch:{ all -> 0x00c8 }
            io.sentry.SentryEvent r8 = (io.sentry.SentryEvent) r8     // Catch:{ all -> 0x00c8 }
            if (r8 != 0) goto L_0x0081
            r11.logEnvelopeItemNull(r3, r1)     // Catch:{ all -> 0x00c8 }
            goto L_0x00c3
        L_0x0081:
            io.sentry.SentryEnvelopeHeader r3 = r12.getHeader()     // Catch:{ all -> 0x00c8 }
            io.sentry.protocol.SentryId r3 = r3.getEventId()     // Catch:{ all -> 0x00c8 }
            if (r3 == 0) goto L_0x00a9
            io.sentry.SentryEnvelopeHeader r3 = r12.getHeader()     // Catch:{ all -> 0x00c8 }
            io.sentry.protocol.SentryId r3 = r3.getEventId()     // Catch:{ all -> 0x00c8 }
            io.sentry.protocol.SentryId r9 = r8.getEventId()     // Catch:{ all -> 0x00c8 }
            boolean r3 = r3.equals(r9)     // Catch:{ all -> 0x00c8 }
            if (r3 != 0) goto L_0x00a9
            io.sentry.protocol.SentryId r3 = r8.getEventId()     // Catch:{ all -> 0x00c8 }
            r11.logUnexpectedEventId(r12, r3, r1)     // Catch:{ all -> 0x00c8 }
            $closeResource(r6, r4)     // Catch:{ Exception -> 0x00cf }
            goto L_0x0024
        L_0x00a9:
            io.sentry.IHub r3 = r11.hub     // Catch:{ all -> 0x00c8 }
            r3.captureEvent(r8, r13)     // Catch:{ all -> 0x00c8 }
            r11.logItemCaptured(r1)     // Catch:{ all -> 0x00c8 }
            boolean r3 = r11.waitFlush(r13)     // Catch:{ all -> 0x00c8 }
            if (r3 != 0) goto L_0x00c3
            io.sentry.protocol.SentryId r3 = r8.getEventId()     // Catch:{ all -> 0x00c8 }
            r11.logTimeout(r3)     // Catch:{ all -> 0x00c8 }
            $closeResource(r6, r4)     // Catch:{ Exception -> 0x00cf }
            goto L_0x0200
        L_0x00c3:
            $closeResource(r6, r4)     // Catch:{ Exception -> 0x00cf }
            goto L_0x01d5
        L_0x00c8:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x00ca }
        L_0x00ca:
            r6 = move-exception
            $closeResource(r3, r4)     // Catch:{ Exception -> 0x00cf }
            throw r6     // Catch:{ Exception -> 0x00cf }
        L_0x00cf:
            r3 = move-exception
            io.sentry.ILogger r4 = r11.logger
            io.sentry.SentryLevel r6 = io.sentry.SentryLevel.ERROR
            r4.log(r6, r7, r3)
            goto L_0x01d5
        L_0x00d9:
            io.sentry.SentryItemType r4 = io.sentry.SentryItemType.Transaction
            io.sentry.SentryEnvelopeItemHeader r8 = r3.getHeader()
            io.sentry.SentryItemType r8 = r8.getType()
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x017b
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0172 }
            java.io.InputStreamReader r8 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0172 }
            java.io.ByteArrayInputStream r9 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0172 }
            byte[] r10 = r3.getData()     // Catch:{ Exception -> 0x0172 }
            r9.<init>(r10)     // Catch:{ Exception -> 0x0172 }
            java.nio.charset.Charset r10 = UTF_8     // Catch:{ Exception -> 0x0172 }
            r8.<init>(r9, r10)     // Catch:{ Exception -> 0x0172 }
            r4.<init>(r8)     // Catch:{ Exception -> 0x0172 }
            io.sentry.ISerializer r8 = r11.serializer     // Catch:{ all -> 0x016b }
            java.lang.Class<io.sentry.protocol.SentryTransaction> r9 = io.sentry.protocol.SentryTransaction.class
            java.lang.Object r8 = r8.deserialize(r4, r9)     // Catch:{ all -> 0x016b }
            io.sentry.protocol.SentryTransaction r8 = (io.sentry.protocol.SentryTransaction) r8     // Catch:{ all -> 0x016b }
            if (r8 != 0) goto L_0x010e
            r11.logEnvelopeItemNull(r3, r1)     // Catch:{ all -> 0x016b }
            goto L_0x0167
        L_0x010e:
            io.sentry.SentryEnvelopeHeader r3 = r12.getHeader()     // Catch:{ all -> 0x016b }
            io.sentry.protocol.SentryId r3 = r3.getEventId()     // Catch:{ all -> 0x016b }
            if (r3 == 0) goto L_0x0136
            io.sentry.SentryEnvelopeHeader r3 = r12.getHeader()     // Catch:{ all -> 0x016b }
            io.sentry.protocol.SentryId r3 = r3.getEventId()     // Catch:{ all -> 0x016b }
            io.sentry.protocol.SentryId r9 = r8.getEventId()     // Catch:{ all -> 0x016b }
            boolean r3 = r3.equals(r9)     // Catch:{ all -> 0x016b }
            if (r3 != 0) goto L_0x0136
            io.sentry.protocol.SentryId r3 = r8.getEventId()     // Catch:{ all -> 0x016b }
            r11.logUnexpectedEventId(r12, r3, r1)     // Catch:{ all -> 0x016b }
            $closeResource(r6, r4)     // Catch:{ Exception -> 0x0172 }
            goto L_0x0024
        L_0x0136:
            io.sentry.protocol.Contexts r3 = r8.getContexts()     // Catch:{ all -> 0x016b }
            io.sentry.SpanContext r3 = r3.getTrace()     // Catch:{ all -> 0x016b }
            if (r3 == 0) goto L_0x014d
            io.sentry.protocol.Contexts r3 = r8.getContexts()     // Catch:{ all -> 0x016b }
            io.sentry.SpanContext r3 = r3.getTrace()     // Catch:{ all -> 0x016b }
            java.lang.Boolean r9 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x016b }
            r3.setSampled(r9)     // Catch:{ all -> 0x016b }
        L_0x014d:
            io.sentry.IHub r3 = r11.hub     // Catch:{ all -> 0x016b }
            r3.captureTransaction(r8, r13)     // Catch:{ all -> 0x016b }
            r11.logItemCaptured(r1)     // Catch:{ all -> 0x016b }
            boolean r3 = r11.waitFlush(r13)     // Catch:{ all -> 0x016b }
            if (r3 != 0) goto L_0x0167
            io.sentry.protocol.SentryId r3 = r8.getEventId()     // Catch:{ all -> 0x016b }
            r11.logTimeout(r3)     // Catch:{ all -> 0x016b }
            $closeResource(r6, r4)     // Catch:{ Exception -> 0x0172 }
            goto L_0x0200
        L_0x0167:
            $closeResource(r6, r4)     // Catch:{ Exception -> 0x0172 }
            goto L_0x01d5
        L_0x016b:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x016d }
        L_0x016d:
            r6 = move-exception
            $closeResource(r3, r4)     // Catch:{ Exception -> 0x0172 }
            throw r6     // Catch:{ Exception -> 0x0172 }
        L_0x0172:
            r3 = move-exception
            io.sentry.ILogger r4 = r11.logger
            io.sentry.SentryLevel r6 = io.sentry.SentryLevel.ERROR
            r4.log(r6, r7, r3)
            goto L_0x01d5
        L_0x017b:
            io.sentry.SentryEnvelope r4 = new io.sentry.SentryEnvelope
            io.sentry.SentryEnvelopeHeader r6 = r12.getHeader()
            io.sentry.protocol.SentryId r6 = r6.getEventId()
            io.sentry.SentryEnvelopeHeader r7 = r12.getHeader()
            io.sentry.protocol.SdkVersion r7 = r7.getSdkVersion()
            r4.<init>(r6, r7, r3)
            io.sentry.IHub r6 = r11.hub
            r6.captureEnvelope(r4, r13)
            io.sentry.ILogger r4 = r11.logger
            io.sentry.SentryLevel r6 = io.sentry.SentryLevel.DEBUG
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]
            io.sentry.SentryEnvelopeItemHeader r8 = r3.getHeader()
            io.sentry.SentryItemType r8 = r8.getType()
            java.lang.String r8 = r8.getItemType()
            r7[r5] = r8
            java.lang.Integer r8 = java.lang.Integer.valueOf(r1)
            r7[r2] = r8
            java.lang.String r8 = "%s item %d is being captured."
            r4.log(r6, r8, r7)
            boolean r4 = r11.waitFlush(r13)
            if (r4 != 0) goto L_0x01d5
            io.sentry.ILogger r12 = r11.logger
            io.sentry.SentryLevel r13 = io.sentry.SentryLevel.WARNING
            java.lang.Object[] r0 = new java.lang.Object[r2]
            io.sentry.SentryEnvelopeItemHeader r1 = r3.getHeader()
            io.sentry.SentryItemType r1 = r1.getType()
            java.lang.String r1 = r1.getItemType()
            r0[r5] = r1
            java.lang.String r1 = "Timed out waiting for item type submission: %s"
            r12.log(r13, r1, r0)
            goto L_0x0200
        L_0x01d5:
            boolean r3 = r13 instanceof io.sentry.hints.SubmissionResult
            if (r3 == 0) goto L_0x01f4
            r3 = r13
            io.sentry.hints.SubmissionResult r3 = (io.sentry.hints.SubmissionResult) r3
            boolean r3 = r3.isSuccess()
            if (r3 != 0) goto L_0x01f4
            io.sentry.ILogger r12 = r11.logger
            io.sentry.SentryLevel r13 = io.sentry.SentryLevel.WARNING
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0[r5] = r1
            java.lang.String r1 = "Envelope had a failed capture at item %d. No more items will be sent."
            r12.log(r13, r1, r0)
            goto L_0x0200
        L_0x01f4:
            boolean r3 = r13 instanceof io.sentry.hints.Resettable
            if (r3 == 0) goto L_0x0024
            r3 = r13
            io.sentry.hints.Resettable r3 = (io.sentry.hints.Resettable) r3
            r3.reset()
            goto L_0x0024
        L_0x0200:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.OutboxSender.processEnvelope(io.sentry.SentryEnvelope, java.lang.Object):void");
    }

    private boolean waitFlush(Object obj) {
        if (obj instanceof Flushable) {
            return ((Flushable) obj).waitFlush();
        }
        LogUtils.logIfNotFlushable(this.logger, obj);
        return true;
    }

    public boolean isRelevantFileName(String str) {
        return str != null && !str.startsWith("session");
    }

    public /* bridge */ /* synthetic */ void processDirectory(File file) {
        super.processDirectory(file);
    }

    public void processEnvelopeFile(String str, Object obj) {
        Objects.requireNonNull(str, "Path is required.");
        processFile(new File(str), obj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0096, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        $closeResource(r4, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009a, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void processFile(java.io.File r11, java.lang.Object r12) {
        /*
            r10 = this;
            java.lang.String r0 = "Failed to delete: %s"
            java.lang.String r1 = "File is required."
            io.sentry.util.Objects.requireNonNull(r11, r1)
            java.lang.String r1 = r11.getName()
            boolean r1 = r10.isRelevantFileName(r1)
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L_0x0025
            io.sentry.ILogger r12 = r10.logger
            io.sentry.SentryLevel r0 = io.sentry.SentryLevel.DEBUG
            java.lang.Object[] r1 = new java.lang.Object[r3]
            java.lang.String r11 = r11.getAbsolutePath()
            r1[r2] = r11
            java.lang.String r11 = "File '%s' should be ignored."
            r12.log(r0, r11, r1)
            return
        L_0x0025:
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x009d }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ IOException -> 0x009d }
            r4.<init>(r11)     // Catch:{ IOException -> 0x009d }
            r1.<init>(r4)     // Catch:{ IOException -> 0x009d }
            r4 = 0
            io.sentry.IEnvelopeReader r5 = r10.envelopeReader     // Catch:{ all -> 0x0094 }
            io.sentry.SentryEnvelope r5 = r5.read(r1)     // Catch:{ all -> 0x0094 }
            if (r5 != 0) goto L_0x004a
            io.sentry.ILogger r5 = r10.logger     // Catch:{ all -> 0x0094 }
            io.sentry.SentryLevel r6 = io.sentry.SentryLevel.ERROR     // Catch:{ all -> 0x0094 }
            java.lang.String r7 = "Stream from path %s resulted in a null envelope."
            java.lang.Object[] r8 = new java.lang.Object[r3]     // Catch:{ all -> 0x0094 }
            java.lang.String r9 = r11.getAbsolutePath()     // Catch:{ all -> 0x0094 }
            r8[r2] = r9     // Catch:{ all -> 0x0094 }
            r5.log(r6, r7, r8)     // Catch:{ all -> 0x0094 }
            goto L_0x005e
        L_0x004a:
            r10.processEnvelope(r5, r12)     // Catch:{ all -> 0x0094 }
            io.sentry.ILogger r5 = r10.logger     // Catch:{ all -> 0x0094 }
            io.sentry.SentryLevel r6 = io.sentry.SentryLevel.DEBUG     // Catch:{ all -> 0x0094 }
            java.lang.String r7 = "File '%s' is done."
            java.lang.Object[] r8 = new java.lang.Object[r3]     // Catch:{ all -> 0x0094 }
            java.lang.String r9 = r11.getAbsolutePath()     // Catch:{ all -> 0x0094 }
            r8[r2] = r9     // Catch:{ all -> 0x0094 }
            r5.log(r6, r7, r8)     // Catch:{ all -> 0x0094 }
        L_0x005e:
            $closeResource(r4, r1)     // Catch:{ IOException -> 0x009d }
            boolean r1 = r12 instanceof io.sentry.hints.Retryable
            if (r1 == 0) goto L_0x00da
            io.sentry.hints.Retryable r12 = (io.sentry.hints.Retryable) r12
            boolean r12 = r12.isRetry()
            if (r12 != 0) goto L_0x00df
            boolean r12 = r11.delete()     // Catch:{ RuntimeException -> 0x0083 }
            if (r12 != 0) goto L_0x00df
            io.sentry.ILogger r12 = r10.logger     // Catch:{ RuntimeException -> 0x0083 }
            io.sentry.SentryLevel r1 = io.sentry.SentryLevel.ERROR     // Catch:{ RuntimeException -> 0x0083 }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ RuntimeException -> 0x0083 }
            java.lang.String r5 = r11.getAbsolutePath()     // Catch:{ RuntimeException -> 0x0083 }
            r4[r2] = r5     // Catch:{ RuntimeException -> 0x0083 }
            r12.log(r1, r0, r4)     // Catch:{ RuntimeException -> 0x0083 }
            goto L_0x00df
        L_0x0083:
            r12 = move-exception
            io.sentry.ILogger r1 = r10.logger
            io.sentry.SentryLevel r4 = io.sentry.SentryLevel.ERROR
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r11 = r11.getAbsolutePath()
            r3[r2] = r11
            r1.log(r4, r12, r0, r3)
            goto L_0x00df
        L_0x0094:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0096 }
        L_0x0096:
            r5 = move-exception
            $closeResource(r4, r1)     // Catch:{ IOException -> 0x009d }
            throw r5     // Catch:{ IOException -> 0x009d }
        L_0x009b:
            r1 = move-exception
            goto L_0x00e0
        L_0x009d:
            r1 = move-exception
            io.sentry.ILogger r4 = r10.logger     // Catch:{ all -> 0x009b }
            io.sentry.SentryLevel r5 = io.sentry.SentryLevel.ERROR     // Catch:{ all -> 0x009b }
            java.lang.String r6 = "Error processing envelope."
            r4.log(r5, r6, r1)     // Catch:{ all -> 0x009b }
            boolean r1 = r12 instanceof io.sentry.hints.Retryable
            if (r1 == 0) goto L_0x00da
            io.sentry.hints.Retryable r12 = (io.sentry.hints.Retryable) r12
            boolean r12 = r12.isRetry()
            if (r12 != 0) goto L_0x00df
            boolean r12 = r11.delete()     // Catch:{ RuntimeException -> 0x00c9 }
            if (r12 != 0) goto L_0x00df
            io.sentry.ILogger r12 = r10.logger     // Catch:{ RuntimeException -> 0x00c9 }
            io.sentry.SentryLevel r1 = io.sentry.SentryLevel.ERROR     // Catch:{ RuntimeException -> 0x00c9 }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ RuntimeException -> 0x00c9 }
            java.lang.String r5 = r11.getAbsolutePath()     // Catch:{ RuntimeException -> 0x00c9 }
            r4[r2] = r5     // Catch:{ RuntimeException -> 0x00c9 }
            r12.log(r1, r0, r4)     // Catch:{ RuntimeException -> 0x00c9 }
            goto L_0x00df
        L_0x00c9:
            r12 = move-exception
            io.sentry.ILogger r1 = r10.logger
            io.sentry.SentryLevel r4 = io.sentry.SentryLevel.ERROR
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r11 = r11.getAbsolutePath()
            r3[r2] = r11
            r1.log(r4, r12, r0, r3)
            goto L_0x00df
        L_0x00da:
            io.sentry.ILogger r11 = r10.logger
            io.sentry.util.LogUtils.logIfNotRetryable(r11, r12)
        L_0x00df:
            return
        L_0x00e0:
            boolean r4 = r12 instanceof io.sentry.hints.Retryable
            if (r4 == 0) goto L_0x0113
            io.sentry.hints.Retryable r12 = (io.sentry.hints.Retryable) r12
            boolean r12 = r12.isRetry()
            if (r12 != 0) goto L_0x0118
            boolean r12 = r11.delete()     // Catch:{ RuntimeException -> 0x0102 }
            if (r12 != 0) goto L_0x0118
            io.sentry.ILogger r12 = r10.logger     // Catch:{ RuntimeException -> 0x0102 }
            io.sentry.SentryLevel r4 = io.sentry.SentryLevel.ERROR     // Catch:{ RuntimeException -> 0x0102 }
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ RuntimeException -> 0x0102 }
            java.lang.String r6 = r11.getAbsolutePath()     // Catch:{ RuntimeException -> 0x0102 }
            r5[r2] = r6     // Catch:{ RuntimeException -> 0x0102 }
            r12.log(r4, r0, r5)     // Catch:{ RuntimeException -> 0x0102 }
            goto L_0x0118
        L_0x0102:
            r12 = move-exception
            io.sentry.ILogger r4 = r10.logger
            io.sentry.SentryLevel r5 = io.sentry.SentryLevel.ERROR
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r11 = r11.getAbsolutePath()
            r3[r2] = r11
            r4.log(r5, r12, r0, r3)
            goto L_0x0118
        L_0x0113:
            io.sentry.ILogger r11 = r10.logger
            io.sentry.util.LogUtils.logIfNotRetryable(r11, r12)
        L_0x0118:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.OutboxSender.processFile(java.io.File, java.lang.Object):void");
    }
}
