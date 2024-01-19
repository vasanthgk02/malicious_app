package io.sentry;

import io.sentry.cache.EnvelopeCache;
import io.sentry.util.Objects;
import java.io.File;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class EnvelopeSender extends DirectoryProcessor implements IEnvelopeSender {
    public final IHub hub;
    public final ILogger logger;
    public final ISerializer serializer;

    public EnvelopeSender(IHub iHub, ISerializer iSerializer, ILogger iLogger, long j) {
        super(iLogger, j);
        this.hub = (IHub) Objects.requireNonNull(iHub, "Hub is required.");
        this.serializer = (ISerializer) Objects.requireNonNull(iSerializer, "Serializer is required.");
        this.logger = (ILogger) Objects.requireNonNull(iLogger, "Logger is required.");
    }

    private void safeDelete(File file, String str) {
        try {
            if (!file.delete()) {
                this.logger.log(SentryLevel.ERROR, (String) "Failed to delete '%s' %s", file.getAbsolutePath(), str);
            }
        } catch (Exception e2) {
            this.logger.log(SentryLevel.ERROR, e2, "Failed to delete '%s' %s", file.getAbsolutePath(), str);
        }
    }

    public boolean isRelevantFileName(String str) {
        return str.endsWith(EnvelopeCache.SUFFIX_ENVELOPE_FILE);
    }

    public /* bridge */ /* synthetic */ void processDirectory(File file) {
        super.processDirectory(file);
    }

    public void processEnvelopeFile(String str, Object obj) {
        Objects.requireNonNull(str, "Path is required.");
        processFile(new File(str), obj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00d5, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00de, code lost:
        throw r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void processFile(java.io.File r12, java.lang.Object r13) {
        /*
            r11 = this;
            java.lang.String r0 = "Deleted file %s."
            java.lang.String r1 = "after trying to capture it"
            java.lang.String r2 = "File not deleted since retry was marked. %s."
            boolean r3 = r12.isFile()
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L_0x0020
            io.sentry.ILogger r13 = r11.logger
            io.sentry.SentryLevel r0 = io.sentry.SentryLevel.DEBUG
            java.lang.Object[] r1 = new java.lang.Object[r4]
            java.lang.String r12 = r12.getAbsolutePath()
            r1[r5] = r12
            java.lang.String r12 = "'%s' is not a file."
            r13.log(r0, r12, r1)
            return
        L_0x0020:
            java.lang.String r3 = r12.getName()
            boolean r3 = r11.isRelevantFileName(r3)
            if (r3 != 0) goto L_0x003c
            io.sentry.ILogger r13 = r11.logger
            io.sentry.SentryLevel r0 = io.sentry.SentryLevel.DEBUG
            java.lang.Object[] r1 = new java.lang.Object[r4]
            java.lang.String r12 = r12.getAbsolutePath()
            r1[r5] = r12
            java.lang.String r12 = "File '%s' doesn't match extension expected."
            r13.log(r0, r12, r1)
            return
        L_0x003c:
            java.io.File r3 = r12.getParentFile()
            boolean r3 = r3.canWrite()
            if (r3 != 0) goto L_0x0058
            io.sentry.ILogger r13 = r11.logger
            io.sentry.SentryLevel r0 = io.sentry.SentryLevel.WARNING
            java.lang.Object[] r1 = new java.lang.Object[r4]
            java.lang.String r12 = r12.getAbsolutePath()
            r1[r5] = r12
            java.lang.String r12 = "File '%s' cannot be deleted so it will not be processed."
            r13.log(r0, r12, r1)
            return
        L_0x0058:
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x0187, IOException -> 0x0146, Exception -> 0x00e2 }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0187, IOException -> 0x0146, Exception -> 0x00e2 }
            r6.<init>(r12)     // Catch:{ FileNotFoundException -> 0x0187, IOException -> 0x0146, Exception -> 0x00e2 }
            r3.<init>(r6)     // Catch:{ FileNotFoundException -> 0x0187, IOException -> 0x0146, Exception -> 0x00e2 }
            io.sentry.ISerializer r6 = r11.serializer     // Catch:{ all -> 0x00d3 }
            io.sentry.SentryEnvelope r6 = r6.deserializeEnvelope(r3)     // Catch:{ all -> 0x00d3 }
            if (r6 != 0) goto L_0x007c
            io.sentry.ILogger r6 = r11.logger     // Catch:{ all -> 0x00d3 }
            io.sentry.SentryLevel r7 = io.sentry.SentryLevel.ERROR     // Catch:{ all -> 0x00d3 }
            java.lang.String r8 = "Failed to deserialize cached envelope %s"
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ all -> 0x00d3 }
            java.lang.String r10 = r12.getAbsolutePath()     // Catch:{ all -> 0x00d3 }
            r9[r5] = r10     // Catch:{ all -> 0x00d3 }
            r6.log(r7, r8, r9)     // Catch:{ all -> 0x00d3 }
            goto L_0x0081
        L_0x007c:
            io.sentry.IHub r7 = r11.hub     // Catch:{ all -> 0x00d3 }
            r7.captureEnvelope(r6, r13)     // Catch:{ all -> 0x00d3 }
        L_0x0081:
            boolean r6 = r13 instanceof io.sentry.hints.Flushable     // Catch:{ all -> 0x00d3 }
            if (r6 == 0) goto L_0x009a
            r6 = r13
            io.sentry.hints.Flushable r6 = (io.sentry.hints.Flushable) r6     // Catch:{ all -> 0x00d3 }
            boolean r6 = r6.waitFlush()     // Catch:{ all -> 0x00d3 }
            if (r6 != 0) goto L_0x009f
            io.sentry.ILogger r6 = r11.logger     // Catch:{ all -> 0x00d3 }
            io.sentry.SentryLevel r7 = io.sentry.SentryLevel.WARNING     // Catch:{ all -> 0x00d3 }
            java.lang.String r8 = "Timed out waiting for envelope submission."
            java.lang.Object[] r9 = new java.lang.Object[r5]     // Catch:{ all -> 0x00d3 }
            r6.log(r7, r8, r9)     // Catch:{ all -> 0x00d3 }
            goto L_0x009f
        L_0x009a:
            io.sentry.ILogger r6 = r11.logger     // Catch:{ all -> 0x00d3 }
            io.sentry.util.LogUtils.logIfNotFlushable(r6, r13)     // Catch:{ all -> 0x00d3 }
        L_0x009f:
            r3.close()     // Catch:{ FileNotFoundException -> 0x0187, IOException -> 0x0146, Exception -> 0x00e2 }
            boolean r3 = r13 instanceof io.sentry.hints.Retryable
            if (r3 == 0) goto L_0x01c8
            io.sentry.hints.Retryable r13 = (io.sentry.hints.Retryable) r13
            boolean r13 = r13.isRetry()
            if (r13 != 0) goto L_0x00c2
            r11.safeDelete(r12, r1)
            io.sentry.ILogger r13 = r11.logger
            io.sentry.SentryLevel r1 = io.sentry.SentryLevel.DEBUG
            java.lang.Object[] r2 = new java.lang.Object[r4]
            java.lang.String r12 = r12.getAbsolutePath()
            r2[r5] = r12
            r13.log(r1, r0, r2)
            goto L_0x01cd
        L_0x00c2:
            io.sentry.ILogger r13 = r11.logger
            io.sentry.SentryLevel r0 = io.sentry.SentryLevel.INFO
            java.lang.Object[] r1 = new java.lang.Object[r4]
            java.lang.String r12 = r12.getAbsolutePath()
            r1[r5] = r12
            r13.log(r0, r2, r1)
            goto L_0x01cd
        L_0x00d3:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x00d5 }
        L_0x00d5:
            r7 = move-exception
            r3.close()     // Catch:{ all -> 0x00da }
            goto L_0x00de
        L_0x00da:
            r3 = move-exception
            r6.addSuppressed(r3)     // Catch:{ FileNotFoundException -> 0x0187, IOException -> 0x0146, Exception -> 0x00e2 }
        L_0x00de:
            throw r7     // Catch:{ FileNotFoundException -> 0x0187, IOException -> 0x0146, Exception -> 0x00e2 }
        L_0x00df:
            r3 = move-exception
            goto L_0x01ce
        L_0x00e2:
            r3 = move-exception
            io.sentry.ILogger r6 = r11.logger     // Catch:{ all -> 0x00df }
            io.sentry.SentryLevel r7 = io.sentry.SentryLevel.ERROR     // Catch:{ all -> 0x00df }
            java.lang.String r8 = "Failed to capture cached envelope %s"
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ all -> 0x00df }
            java.lang.String r10 = r12.getAbsolutePath()     // Catch:{ all -> 0x00df }
            r9[r5] = r10     // Catch:{ all -> 0x00df }
            r6.log(r7, r3, r8, r9)     // Catch:{ all -> 0x00df }
            boolean r6 = r13 instanceof io.sentry.hints.Retryable     // Catch:{ all -> 0x00df }
            if (r6 == 0) goto L_0x0110
            r6 = r13
            io.sentry.hints.Retryable r6 = (io.sentry.hints.Retryable) r6     // Catch:{ all -> 0x00df }
            r6.setRetry(r5)     // Catch:{ all -> 0x00df }
            io.sentry.ILogger r6 = r11.logger     // Catch:{ all -> 0x00df }
            io.sentry.SentryLevel r7 = io.sentry.SentryLevel.INFO     // Catch:{ all -> 0x00df }
            java.lang.String r8 = "File '%s' won't retry."
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ all -> 0x00df }
            java.lang.String r10 = r12.getAbsolutePath()     // Catch:{ all -> 0x00df }
            r9[r5] = r10     // Catch:{ all -> 0x00df }
            r6.log(r7, r3, r8, r9)     // Catch:{ all -> 0x00df }
            goto L_0x0115
        L_0x0110:
            io.sentry.ILogger r3 = r11.logger     // Catch:{ all -> 0x00df }
            io.sentry.util.LogUtils.logIfNotRetryable(r3, r13)     // Catch:{ all -> 0x00df }
        L_0x0115:
            boolean r3 = r13 instanceof io.sentry.hints.Retryable
            if (r3 == 0) goto L_0x01c8
            io.sentry.hints.Retryable r13 = (io.sentry.hints.Retryable) r13
            boolean r13 = r13.isRetry()
            if (r13 != 0) goto L_0x0135
            r11.safeDelete(r12, r1)
            io.sentry.ILogger r13 = r11.logger
            io.sentry.SentryLevel r1 = io.sentry.SentryLevel.DEBUG
            java.lang.Object[] r2 = new java.lang.Object[r4]
            java.lang.String r12 = r12.getAbsolutePath()
            r2[r5] = r12
            r13.log(r1, r0, r2)
            goto L_0x01cd
        L_0x0135:
            io.sentry.ILogger r13 = r11.logger
            io.sentry.SentryLevel r0 = io.sentry.SentryLevel.INFO
            java.lang.Object[] r1 = new java.lang.Object[r4]
            java.lang.String r12 = r12.getAbsolutePath()
            r1[r5] = r12
            r13.log(r0, r2, r1)
            goto L_0x01cd
        L_0x0146:
            r3 = move-exception
            io.sentry.ILogger r6 = r11.logger     // Catch:{ all -> 0x00df }
            io.sentry.SentryLevel r7 = io.sentry.SentryLevel.ERROR     // Catch:{ all -> 0x00df }
            java.lang.String r8 = "I/O on file '%s' failed."
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ all -> 0x00df }
            java.lang.String r10 = r12.getAbsolutePath()     // Catch:{ all -> 0x00df }
            r9[r5] = r10     // Catch:{ all -> 0x00df }
            r6.log(r7, r3, r8, r9)     // Catch:{ all -> 0x00df }
            boolean r3 = r13 instanceof io.sentry.hints.Retryable
            if (r3 == 0) goto L_0x01c8
            io.sentry.hints.Retryable r13 = (io.sentry.hints.Retryable) r13
            boolean r13 = r13.isRetry()
            if (r13 != 0) goto L_0x0177
            r11.safeDelete(r12, r1)
            io.sentry.ILogger r13 = r11.logger
            io.sentry.SentryLevel r1 = io.sentry.SentryLevel.DEBUG
            java.lang.Object[] r2 = new java.lang.Object[r4]
            java.lang.String r12 = r12.getAbsolutePath()
            r2[r5] = r12
            r13.log(r1, r0, r2)
            goto L_0x01cd
        L_0x0177:
            io.sentry.ILogger r13 = r11.logger
            io.sentry.SentryLevel r0 = io.sentry.SentryLevel.INFO
            java.lang.Object[] r1 = new java.lang.Object[r4]
            java.lang.String r12 = r12.getAbsolutePath()
            r1[r5] = r12
            r13.log(r0, r2, r1)
            goto L_0x01cd
        L_0x0187:
            r3 = move-exception
            io.sentry.ILogger r6 = r11.logger     // Catch:{ all -> 0x00df }
            io.sentry.SentryLevel r7 = io.sentry.SentryLevel.ERROR     // Catch:{ all -> 0x00df }
            java.lang.String r8 = "File '%s' cannot be found."
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ all -> 0x00df }
            java.lang.String r10 = r12.getAbsolutePath()     // Catch:{ all -> 0x00df }
            r9[r5] = r10     // Catch:{ all -> 0x00df }
            r6.log(r7, r3, r8, r9)     // Catch:{ all -> 0x00df }
            boolean r3 = r13 instanceof io.sentry.hints.Retryable
            if (r3 == 0) goto L_0x01c8
            io.sentry.hints.Retryable r13 = (io.sentry.hints.Retryable) r13
            boolean r13 = r13.isRetry()
            if (r13 != 0) goto L_0x01b8
            r11.safeDelete(r12, r1)
            io.sentry.ILogger r13 = r11.logger
            io.sentry.SentryLevel r1 = io.sentry.SentryLevel.DEBUG
            java.lang.Object[] r2 = new java.lang.Object[r4]
            java.lang.String r12 = r12.getAbsolutePath()
            r2[r5] = r12
            r13.log(r1, r0, r2)
            goto L_0x01cd
        L_0x01b8:
            io.sentry.ILogger r13 = r11.logger
            io.sentry.SentryLevel r0 = io.sentry.SentryLevel.INFO
            java.lang.Object[] r1 = new java.lang.Object[r4]
            java.lang.String r12 = r12.getAbsolutePath()
            r1[r5] = r12
            r13.log(r0, r2, r1)
            goto L_0x01cd
        L_0x01c8:
            io.sentry.ILogger r12 = r11.logger
            io.sentry.util.LogUtils.logIfNotRetryable(r12, r13)
        L_0x01cd:
            return
        L_0x01ce:
            boolean r6 = r13 instanceof io.sentry.hints.Retryable
            if (r6 == 0) goto L_0x01fd
            io.sentry.hints.Retryable r13 = (io.sentry.hints.Retryable) r13
            boolean r13 = r13.isRetry()
            if (r13 != 0) goto L_0x01ed
            r11.safeDelete(r12, r1)
            io.sentry.ILogger r13 = r11.logger
            io.sentry.SentryLevel r1 = io.sentry.SentryLevel.DEBUG
            java.lang.Object[] r2 = new java.lang.Object[r4]
            java.lang.String r12 = r12.getAbsolutePath()
            r2[r5] = r12
            r13.log(r1, r0, r2)
            goto L_0x0202
        L_0x01ed:
            io.sentry.ILogger r13 = r11.logger
            io.sentry.SentryLevel r0 = io.sentry.SentryLevel.INFO
            java.lang.Object[] r1 = new java.lang.Object[r4]
            java.lang.String r12 = r12.getAbsolutePath()
            r1[r5] = r12
            r13.log(r0, r2, r1)
            goto L_0x0202
        L_0x01fd:
            io.sentry.ILogger r12 = r11.logger
            io.sentry.util.LogUtils.logIfNotRetryable(r12, r13)
        L_0x0202:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.EnvelopeSender.processFile(java.io.File, java.lang.Object):void");
    }
}
