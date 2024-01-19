package io.sentry.cache;

import io.sentry.ISerializer;
import io.sentry.SentryEnvelope;
import io.sentry.SentryEnvelopeItem;
import io.sentry.SentryItemType;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.Session;
import io.sentry.Session.State;
import io.sentry.util.Objects;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public abstract class CacheStrategy {
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    public final File directory;
    public final int maxSize;
    public final SentryOptions options;
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

    public CacheStrategy(SentryOptions sentryOptions, String str, int i) {
        Objects.requireNonNull(str, "Directory is required.");
        this.options = (SentryOptions) Objects.requireNonNull(sentryOptions, "SentryOptions is required.");
        this.serializer = sentryOptions.getSerializer();
        this.directory = new File(str);
        this.maxSize = i;
    }

    private SentryEnvelope buildNewEnvelope(SentryEnvelope sentryEnvelope, SentryEnvelopeItem sentryEnvelopeItem) {
        ArrayList arrayList = new ArrayList();
        for (SentryEnvelopeItem add : sentryEnvelope.getItems()) {
            arrayList.add(add);
        }
        arrayList.add(sentryEnvelopeItem);
        return new SentryEnvelope(sentryEnvelope.getHeader(), arrayList);
    }

    private Session getFirstSession(SentryEnvelope sentryEnvelope) {
        for (SentryEnvelopeItem next : sentryEnvelope.getItems()) {
            if (isSessionType(next)) {
                return readSession(next);
            }
        }
        return null;
    }

    private boolean isSessionType(SentryEnvelopeItem sentryEnvelopeItem) {
        if (sentryEnvelopeItem == null) {
            return false;
        }
        return sentryEnvelopeItem.getHeader().getType().equals(SentryItemType.Session);
    }

    private boolean isValidEnvelope(SentryEnvelope sentryEnvelope) {
        return sentryEnvelope.getItems().iterator().hasNext();
    }

    private boolean isValidSession(Session session) {
        boolean z = false;
        if (!session.getStatus().equals(State.Ok)) {
            return false;
        }
        if (session.getSessionId() != null) {
            z = true;
        }
        return z;
    }

    private void moveInitFlagIfNecessary(File file, File[] fileArr) {
        SentryEnvelope readEnvelope = readEnvelope(file);
        if (readEnvelope != null && isValidEnvelope(readEnvelope)) {
            Session firstSession = getFirstSession(readEnvelope);
            if (firstSession != null && isValidSession(firstSession)) {
                Boolean init = firstSession.getInit();
                if (init != null && init.booleanValue()) {
                    int length = fileArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        File file2 = fileArr[i];
                        SentryEnvelope readEnvelope2 = readEnvelope(file2);
                        if (readEnvelope2 != null && isValidEnvelope(readEnvelope2)) {
                            SentryEnvelopeItem sentryEnvelopeItem = null;
                            Iterator<SentryEnvelopeItem> it = readEnvelope2.getItems().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                SentryEnvelopeItem next = it.next();
                                if (isSessionType(next)) {
                                    Session readSession = readSession(next);
                                    if (readSession != null && isValidSession(readSession)) {
                                        Boolean init2 = readSession.getInit();
                                        if (init2 != null && init2.booleanValue()) {
                                            this.options.getLogger().log(SentryLevel.ERROR, (String) "Session %s has 2 times the init flag.", firstSession.getSessionId());
                                            return;
                                        } else if (firstSession.getSessionId() != null && firstSession.getSessionId().equals(readSession.getSessionId())) {
                                            readSession.setInitAsTrue();
                                            try {
                                                sentryEnvelopeItem = SentryEnvelopeItem.fromSession(this.serializer, readSession);
                                                it.remove();
                                                break;
                                            } catch (IOException e2) {
                                                this.options.getLogger().log(SentryLevel.ERROR, e2, "Failed to create new envelope item for the session %s", firstSession.getSessionId());
                                            }
                                        }
                                    }
                                }
                            }
                            if (sentryEnvelopeItem != null) {
                                SentryEnvelope buildNewEnvelope = buildNewEnvelope(readEnvelope2, sentryEnvelopeItem);
                                long lastModified = file2.lastModified();
                                if (!file2.delete()) {
                                    this.options.getLogger().log(SentryLevel.WARNING, (String) "File can't be deleted: %s", file2.getAbsolutePath());
                                }
                                saveNewEnvelope(buildNewEnvelope, file2, lastModified);
                            }
                        }
                        i++;
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        $closeResource(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001b, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private io.sentry.SentryEnvelope readEnvelope(java.io.File r5) {
        /*
            r4 = this;
            r0 = 0
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x001c }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x001c }
            r2.<init>(r5)     // Catch:{ IOException -> 0x001c }
            r1.<init>(r2)     // Catch:{ IOException -> 0x001c }
            io.sentry.ISerializer r5 = r4.serializer     // Catch:{ all -> 0x0015 }
            io.sentry.SentryEnvelope r5 = r5.deserializeEnvelope(r1)     // Catch:{ all -> 0x0015 }
            $closeResource(r0, r1)     // Catch:{ IOException -> 0x001c }
            return r5
        L_0x0015:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0017 }
        L_0x0017:
            r2 = move-exception
            $closeResource(r5, r1)     // Catch:{ IOException -> 0x001c }
            throw r2     // Catch:{ IOException -> 0x001c }
        L_0x001c:
            r5 = move-exception
            io.sentry.SentryOptions r1 = r4.options
            io.sentry.ILogger r1 = r1.getLogger()
            io.sentry.SentryLevel r2 = io.sentry.SentryLevel.ERROR
            java.lang.String r3 = "Failed to deserialize the envelope."
            r1.log(r2, r3, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.cache.CacheStrategy.readEnvelope(java.io.File):io.sentry.SentryEnvelope");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        $closeResource(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private io.sentry.Session readSession(io.sentry.SentryEnvelopeItem r5) {
        /*
            r4 = this;
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x002b }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x002b }
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x002b }
            byte[] r5 = r5.getData()     // Catch:{ Exception -> 0x002b }
            r3.<init>(r5)     // Catch:{ Exception -> 0x002b }
            java.nio.charset.Charset r5 = UTF_8     // Catch:{ Exception -> 0x002b }
            r2.<init>(r3, r5)     // Catch:{ Exception -> 0x002b }
            r1.<init>(r2)     // Catch:{ Exception -> 0x002b }
            io.sentry.ISerializer r5 = r4.serializer     // Catch:{ all -> 0x0024 }
            java.lang.Class<io.sentry.Session> r2 = io.sentry.Session.class
            java.lang.Object r5 = r5.deserialize(r1, r2)     // Catch:{ all -> 0x0024 }
            io.sentry.Session r5 = (io.sentry.Session) r5     // Catch:{ all -> 0x0024 }
            $closeResource(r0, r1)     // Catch:{ Exception -> 0x002b }
            return r5
        L_0x0024:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0026 }
        L_0x0026:
            r2 = move-exception
            $closeResource(r5, r1)     // Catch:{ Exception -> 0x002b }
            throw r2     // Catch:{ Exception -> 0x002b }
        L_0x002b:
            r5 = move-exception
            io.sentry.SentryOptions r1 = r4.options
            io.sentry.ILogger r1 = r1.getLogger()
            io.sentry.SentryLevel r2 = io.sentry.SentryLevel.ERROR
            java.lang.String r3 = "Failed to deserialize the session."
            r1.log(r2, r3, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.cache.CacheStrategy.readSession(io.sentry.SentryEnvelopeItem):io.sentry.Session");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0014, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        $closeResource(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0018, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void saveNewEnvelope(io.sentry.SentryEnvelope r4, java.io.File r5, long r6) {
        /*
            r3 = this;
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0019 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x0019 }
            r1 = 0
            io.sentry.ISerializer r2 = r3.serializer     // Catch:{ all -> 0x0012 }
            r2.serialize(r4, r0)     // Catch:{ all -> 0x0012 }
            r5.setLastModified(r6)     // Catch:{ all -> 0x0012 }
            $closeResource(r1, r0)     // Catch:{ Exception -> 0x0019 }
            goto L_0x0027
        L_0x0012:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0014 }
        L_0x0014:
            r5 = move-exception
            $closeResource(r4, r0)     // Catch:{ Exception -> 0x0019 }
            throw r5     // Catch:{ Exception -> 0x0019 }
        L_0x0019:
            r4 = move-exception
            io.sentry.SentryOptions r5 = r3.options
            io.sentry.ILogger r5 = r5.getLogger()
            io.sentry.SentryLevel r6 = io.sentry.SentryLevel.ERROR
            java.lang.String r7 = "Failed to serialize the new envelope to the disk."
            r5.log(r6, r7, r4)
        L_0x0027:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.cache.CacheStrategy.saveNewEnvelope(io.sentry.SentryEnvelope, java.io.File, long):void");
    }

    private void sortFilesOldestToNewest(File[] fileArr) {
        if (fileArr.length > 1) {
            Arrays.sort(fileArr, $$Lambda$CacheStrategy$vtbFyy0YlpKkCL4ESa4Q9QK9zEw.INSTANCE);
        }
    }

    public boolean isDirectoryValid() {
        if (this.directory.isDirectory() && this.directory.canWrite() && this.directory.canRead()) {
            return true;
        }
        this.options.getLogger().log(SentryLevel.ERROR, (String) "The directory for caching files is inaccessible.: %s", this.directory.getAbsolutePath());
        return false;
    }

    public void rotateCacheIfNeeded(File[] fileArr) {
        int length = fileArr.length;
        if (length >= this.maxSize) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "Cache folder if full (respecting maxSize). Rotating files", new Object[0]);
            int i = (length - this.maxSize) + 1;
            sortFilesOldestToNewest(fileArr);
            File[] fileArr2 = (File[]) Arrays.copyOfRange(fileArr, i, length);
            for (int i2 = 0; i2 < i; i2++) {
                File file = fileArr[i2];
                moveInitFlagIfNecessary(file, fileArr2);
                if (!file.delete()) {
                    this.options.getLogger().log(SentryLevel.WARNING, (String) "File can't be deleted: %s", file.getAbsolutePath());
                }
            }
        }
    }
}
