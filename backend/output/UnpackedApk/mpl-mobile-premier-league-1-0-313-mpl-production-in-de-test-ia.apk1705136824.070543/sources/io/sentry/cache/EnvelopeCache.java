package io.sentry.cache;

import com.google.firebase.crashlytics.ndk.CrashpadController;
import io.sentry.SentryEnvelope;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.cache.IEnvelopeCache.CC;
import io.sentry.transport.NoOpEnvelopeCache;
import io.sentry.util.Objects;
import java.io.File;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class EnvelopeCache extends CacheStrategy implements IEnvelopeCache {
    public static final String CRASH_MARKER_FILE = ".sentry-native/last_crash";
    public static final String PREFIX_CURRENT_SESSION_FILE = "session";
    public static final String SUFFIX_CURRENT_SESSION_FILE = ".json";
    public static final String SUFFIX_ENVELOPE_FILE = ".envelope";
    public final Map<SentryEnvelope, String> fileNameMap = new WeakHashMap();

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

    public EnvelopeCache(SentryOptions sentryOptions, String str, int i) {
        super(sentryOptions, str, i);
    }

    private File[] allEnvelopeFiles() {
        if (isDirectoryValid()) {
            File[] listFiles = this.directory.listFiles($$Lambda$EnvelopeCache$7eIJ0Vkpi1WSS08a1wqss3p1M.INSTANCE);
            if (listFiles != null) {
                return listFiles;
            }
        }
        return new File[0];
    }

    public static IEnvelopeCache create(SentryOptions sentryOptions) {
        String cacheDirPath = sentryOptions.getCacheDirPath();
        int maxCacheItems = sentryOptions.getMaxCacheItems();
        if (cacheDirPath != null) {
            return new EnvelopeCache(sentryOptions, cacheDirPath, maxCacheItems);
        }
        sentryOptions.getLogger().log(SentryLevel.WARNING, (String) "maxCacheItems is null, returning NoOpEnvelopeCache", new Object[0]);
        return NoOpEnvelopeCache.getInstance();
    }

    private File getCurrentSessionFile() {
        return new File(this.directory.getAbsolutePath(), CrashpadController.SESSION_METADATA_FILE);
    }

    private synchronized File getEnvelopeFile(SentryEnvelope sentryEnvelope) {
        String str;
        String str2;
        if (this.fileNameMap.containsKey(sentryEnvelope)) {
            str = this.fileNameMap.get(sentryEnvelope);
        } else {
            if (sentryEnvelope.getHeader().getEventId() != null) {
                str2 = sentryEnvelope.getHeader().getEventId().toString();
            } else {
                str2 = UUID.randomUUID().toString();
            }
            String str3 = str2 + SUFFIX_ENVELOPE_FILE;
            this.fileNameMap.put(sentryEnvelope, str3);
            str = str3;
        }
        return new File(this.directory.getAbsolutePath(), str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0033, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        $closeResource(r8, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0037, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Date getTimestampFromCrashMarkerFile(java.io.File r8) {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0049, IllegalArgumentException -> 0x0038 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0049, IllegalArgumentException -> 0x0038 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0049, IllegalArgumentException -> 0x0038 }
            r4.<init>(r8)     // Catch:{ IOException -> 0x0049, IllegalArgumentException -> 0x0038 }
            java.nio.charset.Charset r8 = io.sentry.cache.CacheStrategy.UTF_8     // Catch:{ IOException -> 0x0049, IllegalArgumentException -> 0x0038 }
            r3.<init>(r4, r8)     // Catch:{ IOException -> 0x0049, IllegalArgumentException -> 0x0038 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0049, IllegalArgumentException -> 0x0038 }
            java.lang.String r8 = r2.readLine()     // Catch:{ all -> 0x0031 }
            io.sentry.SentryOptions r3 = r7.options     // Catch:{ all -> 0x0031 }
            io.sentry.ILogger r3 = r3.getLogger()     // Catch:{ all -> 0x0031 }
            io.sentry.SentryLevel r4 = io.sentry.SentryLevel.DEBUG     // Catch:{ all -> 0x0031 }
            java.lang.String r5 = "Crash marker file has %s timestamp."
            r6 = 1
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x0031 }
            r6[r1] = r8     // Catch:{ all -> 0x0031 }
            r3.log(r4, r5, r6)     // Catch:{ all -> 0x0031 }
            java.util.Date r8 = io.sentry.DateUtils.getDateTime(r8)     // Catch:{ all -> 0x0031 }
            $closeResource(r0, r2)     // Catch:{ IOException -> 0x0049, IllegalArgumentException -> 0x0038 }
            return r8
        L_0x0031:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x0033 }
        L_0x0033:
            r3 = move-exception
            $closeResource(r8, r2)     // Catch:{ IOException -> 0x0049, IllegalArgumentException -> 0x0038 }
            throw r3     // Catch:{ IOException -> 0x0049, IllegalArgumentException -> 0x0038 }
        L_0x0038:
            r8 = move-exception
            io.sentry.SentryOptions r2 = r7.options
            io.sentry.ILogger r2 = r2.getLogger()
            io.sentry.SentryLevel r3 = io.sentry.SentryLevel.ERROR
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r4 = "Error converting the crash timestamp."
            r2.log(r3, r8, r4, r1)
            goto L_0x0057
        L_0x0049:
            r8 = move-exception
            io.sentry.SentryOptions r1 = r7.options
            io.sentry.ILogger r1 = r1.getLogger()
            io.sentry.SentryLevel r2 = io.sentry.SentryLevel.ERROR
            java.lang.String r3 = "Error reading the crash marker file."
            r1.log(r2, r3, r8)
        L_0x0057:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.cache.EnvelopeCache.getTimestampFromCrashMarkerFile(java.io.File):java.util.Date");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006f, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        $closeResource(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0073, code lost:
        throw r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateCurrentSession(java.io.File r7, io.sentry.SentryEnvelope r8) {
        /*
            r6 = this;
            java.lang.Iterable r8 = r8.getItems()
            java.util.Iterator r0 = r8.iterator()
            boolean r0 = r0.hasNext()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x009d
            java.util.Iterator r8 = r8.iterator()
            java.lang.Object r8 = r8.next()
            io.sentry.SentryEnvelopeItem r8 = (io.sentry.SentryEnvelopeItem) r8
            io.sentry.SentryItemType r0 = io.sentry.SentryItemType.Session
            io.sentry.SentryEnvelopeItemHeader r3 = r8.getHeader()
            io.sentry.SentryItemType r3 = r3.getType()
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0083
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0074 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0074 }
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0074 }
            byte[] r5 = r8.getData()     // Catch:{ Exception -> 0x0074 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0074 }
            java.nio.charset.Charset r5 = io.sentry.cache.CacheStrategy.UTF_8     // Catch:{ Exception -> 0x0074 }
            r3.<init>(r4, r5)     // Catch:{ Exception -> 0x0074 }
            r0.<init>(r3)     // Catch:{ Exception -> 0x0074 }
            r3 = 0
            io.sentry.ISerializer r4 = r6.serializer     // Catch:{ all -> 0x006d }
            java.lang.Class<io.sentry.Session> r5 = io.sentry.Session.class
            java.lang.Object r4 = r4.deserialize(r0, r5)     // Catch:{ all -> 0x006d }
            io.sentry.Session r4 = (io.sentry.Session) r4     // Catch:{ all -> 0x006d }
            if (r4 != 0) goto L_0x0066
            io.sentry.SentryOptions r7 = r6.options     // Catch:{ all -> 0x006d }
            io.sentry.ILogger r7 = r7.getLogger()     // Catch:{ all -> 0x006d }
            io.sentry.SentryLevel r4 = io.sentry.SentryLevel.ERROR     // Catch:{ all -> 0x006d }
            java.lang.String r5 = "Item of type %s returned null by the parser."
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x006d }
            io.sentry.SentryEnvelopeItemHeader r8 = r8.getHeader()     // Catch:{ all -> 0x006d }
            io.sentry.SentryItemType r8 = r8.getType()     // Catch:{ all -> 0x006d }
            r2[r1] = r8     // Catch:{ all -> 0x006d }
            r7.log(r4, r5, r2)     // Catch:{ all -> 0x006d }
            goto L_0x0069
        L_0x0066:
            r6.writeSessionToDisk(r7, r4)     // Catch:{ all -> 0x006d }
        L_0x0069:
            $closeResource(r3, r0)     // Catch:{ Exception -> 0x0074 }
            goto L_0x00b2
        L_0x006d:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x006f }
        L_0x006f:
            r8 = move-exception
            $closeResource(r7, r0)     // Catch:{ Exception -> 0x0074 }
            throw r8     // Catch:{ Exception -> 0x0074 }
        L_0x0074:
            r7 = move-exception
            io.sentry.SentryOptions r8 = r6.options
            io.sentry.ILogger r8 = r8.getLogger()
            io.sentry.SentryLevel r0 = io.sentry.SentryLevel.ERROR
            java.lang.String r1 = "Item failed to process."
            r8.log(r0, r1, r7)
            goto L_0x00b2
        L_0x0083:
            io.sentry.SentryOptions r7 = r6.options
            io.sentry.ILogger r7 = r7.getLogger()
            io.sentry.SentryLevel r0 = io.sentry.SentryLevel.INFO
            java.lang.Object[] r2 = new java.lang.Object[r2]
            io.sentry.SentryEnvelopeItemHeader r8 = r8.getHeader()
            io.sentry.SentryItemType r8 = r8.getType()
            r2[r1] = r8
            java.lang.String r8 = "Current envelope has a different envelope type %s"
            r7.log(r0, r8, r2)
            goto L_0x00b2
        L_0x009d:
            io.sentry.SentryOptions r8 = r6.options
            io.sentry.ILogger r8 = r8.getLogger()
            io.sentry.SentryLevel r0 = io.sentry.SentryLevel.INFO
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r7 = r7.getAbsolutePath()
            r2[r1] = r7
            java.lang.String r7 = "Current envelope %s is empty"
            r8.log(r0, r7, r2)
        L_0x00b2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.cache.EnvelopeCache.updateCurrentSession(java.io.File, io.sentry.SentryEnvelope):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0049, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        $closeResource(r8, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004d, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeEnvelopeToDisk(java.io.File r7, io.sentry.SentryEnvelope r8) {
        /*
            r6 = this;
            boolean r0 = r7.exists()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0038
            io.sentry.SentryOptions r0 = r6.options
            io.sentry.ILogger r0 = r0.getLogger()
            io.sentry.SentryLevel r3 = io.sentry.SentryLevel.DEBUG
            java.lang.Object[] r4 = new java.lang.Object[r2]
            java.lang.String r5 = r7.getAbsolutePath()
            r4[r1] = r5
            java.lang.String r5 = "Overwriting envelope to offline storage: %s"
            r0.log(r3, r5, r4)
            boolean r0 = r7.delete()
            if (r0 != 0) goto L_0x0038
            io.sentry.SentryOptions r0 = r6.options
            io.sentry.ILogger r0 = r0.getLogger()
            io.sentry.SentryLevel r3 = io.sentry.SentryLevel.ERROR
            java.lang.Object[] r4 = new java.lang.Object[r2]
            java.lang.String r5 = r7.getAbsolutePath()
            r4[r1] = r5
            java.lang.String r5 = "Failed to delete: %s"
            r0.log(r3, r5, r4)
        L_0x0038:
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x004e }
            r0.<init>(r7)     // Catch:{ Exception -> 0x004e }
            r3 = 0
            io.sentry.ISerializer r4 = r6.serializer     // Catch:{ all -> 0x0047 }
            r4.serialize(r8, r0)     // Catch:{ all -> 0x0047 }
            $closeResource(r3, r0)     // Catch:{ Exception -> 0x004e }
            goto L_0x0064
        L_0x0047:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x0049 }
        L_0x0049:
            r3 = move-exception
            $closeResource(r8, r0)     // Catch:{ Exception -> 0x004e }
            throw r3     // Catch:{ Exception -> 0x004e }
        L_0x004e:
            r8 = move-exception
            io.sentry.SentryOptions r0 = r6.options
            io.sentry.ILogger r0 = r0.getLogger()
            io.sentry.SentryLevel r3 = io.sentry.SentryLevel.ERROR
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r7 = r7.getAbsolutePath()
            r2[r1] = r7
            java.lang.String r7 = "Error writing Envelope %s to offline storage"
            r0.log(r3, r8, r7, r2)
        L_0x0064:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.cache.EnvelopeCache.writeEnvelopeToDisk(java.io.File, io.sentry.SentryEnvelope):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0058, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        $closeResource(r3, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005c, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005f, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        $closeResource(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0063, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeSessionToDisk(java.io.File r7, io.sentry.Session r8) {
        /*
            r6 = this;
            boolean r0 = r7.exists()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0038
            io.sentry.SentryOptions r0 = r6.options
            io.sentry.ILogger r0 = r0.getLogger()
            io.sentry.SentryLevel r3 = io.sentry.SentryLevel.DEBUG
            java.lang.Object[] r4 = new java.lang.Object[r2]
            java.util.UUID r5 = r8.getSessionId()
            r4[r1] = r5
            java.lang.String r5 = "Overwriting session to offline storage: %s"
            r0.log(r3, r5, r4)
            boolean r0 = r7.delete()
            if (r0 != 0) goto L_0x0038
            io.sentry.SentryOptions r0 = r6.options
            io.sentry.ILogger r0 = r0.getLogger()
            io.sentry.SentryLevel r3 = io.sentry.SentryLevel.ERROR
            java.lang.Object[] r4 = new java.lang.Object[r2]
            java.lang.String r5 = r7.getAbsolutePath()
            r4[r1] = r5
            java.lang.String r5 = "Failed to delete: %s"
            r0.log(r3, r5, r4)
        L_0x0038:
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0064 }
            r0.<init>(r7)     // Catch:{ Exception -> 0x0064 }
            java.io.BufferedWriter r7 = new java.io.BufferedWriter     // Catch:{ all -> 0x005d }
            java.io.OutputStreamWriter r3 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x005d }
            java.nio.charset.Charset r4 = io.sentry.cache.CacheStrategy.UTF_8     // Catch:{ all -> 0x005d }
            r3.<init>(r0, r4)     // Catch:{ all -> 0x005d }
            r7.<init>(r3)     // Catch:{ all -> 0x005d }
            io.sentry.ISerializer r3 = r6.serializer     // Catch:{ all -> 0x0056 }
            r3.serialize(r8, r7)     // Catch:{ all -> 0x0056 }
            r3 = 0
            $closeResource(r3, r7)     // Catch:{ all -> 0x005d }
            $closeResource(r3, r0)     // Catch:{ Exception -> 0x0064 }
            goto L_0x007a
        L_0x0056:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0058 }
        L_0x0058:
            r4 = move-exception
            $closeResource(r3, r7)     // Catch:{ all -> 0x005d }
            throw r4     // Catch:{ all -> 0x005d }
        L_0x005d:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x005f }
        L_0x005f:
            r3 = move-exception
            $closeResource(r7, r0)     // Catch:{ Exception -> 0x0064 }
            throw r3     // Catch:{ Exception -> 0x0064 }
        L_0x0064:
            r7 = move-exception
            io.sentry.SentryOptions r0 = r6.options
            io.sentry.ILogger r0 = r0.getLogger()
            io.sentry.SentryLevel r3 = io.sentry.SentryLevel.ERROR
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.util.UUID r8 = r8.getSessionId()
            r2[r1] = r8
            java.lang.String r8 = "Error writing Session to offline storage: %s"
            r0.log(r3, r7, r8, r2)
        L_0x007a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.cache.EnvelopeCache.writeSessionToDisk(java.io.File, io.sentry.Session):void");
    }

    public void discard(SentryEnvelope sentryEnvelope) {
        Objects.requireNonNull(sentryEnvelope, "Envelope is required.");
        File envelopeFile = getEnvelopeFile(sentryEnvelope);
        if (envelopeFile.exists()) {
            this.options.getLogger().log(SentryLevel.DEBUG, (String) "Discarding envelope from cache: %s", envelopeFile.getAbsolutePath());
            if (!envelopeFile.delete()) {
                this.options.getLogger().log(SentryLevel.ERROR, (String) "Failed to delete envelope: %s", envelopeFile.getAbsolutePath());
                return;
            }
            return;
        }
        this.options.getLogger().log(SentryLevel.DEBUG, (String) "Envelope was not cached: %s", envelopeFile.getAbsolutePath());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        $closeResource(r8, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0030, code lost:
        throw r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Iterator<io.sentry.SentryEnvelope> iterator() {
        /*
            r10 = this;
            java.io.File[] r0 = r10.allEnvelopeFiles()
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r0.length
            r1.<init>(r2)
            int r2 = r0.length
            r3 = 0
            r4 = 0
        L_0x000d:
            if (r4 >= r2) goto L_0x0064
            r5 = r0[r4]
            r6 = 1
            java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x004c, IOException -> 0x0031 }
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x004c, IOException -> 0x0031 }
            r8.<init>(r5)     // Catch:{ FileNotFoundException -> 0x004c, IOException -> 0x0031 }
            r7.<init>(r8)     // Catch:{ FileNotFoundException -> 0x004c, IOException -> 0x0031 }
            r8 = 0
            io.sentry.ISerializer r9 = r10.serializer     // Catch:{ all -> 0x002a }
            io.sentry.SentryEnvelope r9 = r9.deserializeEnvelope(r7)     // Catch:{ all -> 0x002a }
            r1.add(r9)     // Catch:{ all -> 0x002a }
            $closeResource(r8, r7)     // Catch:{ FileNotFoundException -> 0x004c, IOException -> 0x0031 }
            goto L_0x0061
        L_0x002a:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x002c }
        L_0x002c:
            r9 = move-exception
            $closeResource(r8, r7)     // Catch:{ FileNotFoundException -> 0x004c, IOException -> 0x0031 }
            throw r9     // Catch:{ FileNotFoundException -> 0x004c, IOException -> 0x0031 }
        L_0x0031:
            r7 = move-exception
            io.sentry.SentryOptions r8 = r10.options
            io.sentry.ILogger r8 = r8.getLogger()
            io.sentry.SentryLevel r9 = io.sentry.SentryLevel.ERROR
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.String r5 = r5.getAbsolutePath()
            r6[r3] = r5
            java.lang.String r5 = "Error while reading cached envelope from file %s"
            java.lang.String r5 = java.lang.String.format(r5, r6)
            r8.log(r9, r5, r7)
            goto L_0x0061
        L_0x004c:
            io.sentry.SentryOptions r7 = r10.options
            io.sentry.ILogger r7 = r7.getLogger()
            io.sentry.SentryLevel r8 = io.sentry.SentryLevel.DEBUG
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.String r5 = r5.getAbsolutePath()
            r6[r3] = r5
            java.lang.String r5 = "Envelope file '%s' disappeared while converting all cached files to envelopes."
            r7.log(r8, r5, r6)
        L_0x0061:
            int r4 = r4 + 1
            goto L_0x000d
        L_0x0064:
            java.util.Iterator r0 = r1.iterator()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.cache.EnvelopeCache.iterator():java.util.Iterator");
    }

    public /* synthetic */ void store(SentryEnvelope sentryEnvelope) {
        CC.$default$store(this, sentryEnvelope);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00dc, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        $closeResource(r3, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00e0, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void store(io.sentry.SentryEnvelope r12, java.lang.Object r13) {
        /*
            r11 = this;
            java.lang.String r0 = "Envelope is required."
            io.sentry.util.Objects.requireNonNull(r12, r0)
            java.io.File[] r0 = r11.allEnvelopeFiles()
            r11.rotateCacheIfNeeded(r0)
            java.io.File r0 = r11.getCurrentSessionFile()
            boolean r1 = r13 instanceof io.sentry.hints.SessionEnd
            r2 = 0
            if (r1 == 0) goto L_0x002a
            boolean r1 = r0.delete()
            if (r1 != 0) goto L_0x002a
            io.sentry.SentryOptions r1 = r11.options
            io.sentry.ILogger r1 = r1.getLogger()
            io.sentry.SentryLevel r3 = io.sentry.SentryLevel.WARNING
            java.lang.Object[] r4 = new java.lang.Object[r2]
            java.lang.String r5 = "Current envelope doesn't exist."
            r1.log(r3, r5, r4)
        L_0x002a:
            boolean r13 = r13 instanceof io.sentry.hints.SessionStart
            r1 = 1
            if (r13 == 0) goto L_0x0107
            boolean r13 = r0.exists()
            if (r13 == 0) goto L_0x0104
            io.sentry.SentryOptions r13 = r11.options
            io.sentry.ILogger r13 = r13.getLogger()
            io.sentry.SentryLevel r3 = io.sentry.SentryLevel.WARNING
            java.lang.Object[] r4 = new java.lang.Object[r2]
            java.lang.String r5 = "Current session is not ended, we'd need to end it."
            r13.log(r3, r5, r4)
            java.io.BufferedReader r13 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00e1 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00e1 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00e1 }
            r4.<init>(r0)     // Catch:{ Exception -> 0x00e1 }
            java.nio.charset.Charset r5 = io.sentry.cache.CacheStrategy.UTF_8     // Catch:{ Exception -> 0x00e1 }
            r3.<init>(r4, r5)     // Catch:{ Exception -> 0x00e1 }
            r13.<init>(r3)     // Catch:{ Exception -> 0x00e1 }
            io.sentry.ISerializer r3 = r11.serializer     // Catch:{ all -> 0x00da }
            java.lang.Class<io.sentry.Session> r4 = io.sentry.Session.class
            java.lang.Object r3 = r3.deserialize(r13, r4)     // Catch:{ all -> 0x00da }
            io.sentry.Session r3 = (io.sentry.Session) r3     // Catch:{ all -> 0x00da }
            r4 = 0
            if (r3 != 0) goto L_0x0078
            io.sentry.SentryOptions r3 = r11.options     // Catch:{ all -> 0x00da }
            io.sentry.ILogger r3 = r3.getLogger()     // Catch:{ all -> 0x00da }
            io.sentry.SentryLevel r5 = io.sentry.SentryLevel.ERROR     // Catch:{ all -> 0x00da }
            java.lang.String r6 = "Stream from path %s resulted in a null envelope."
            java.lang.Object[] r7 = new java.lang.Object[r1]     // Catch:{ all -> 0x00da }
            java.lang.String r8 = r0.getAbsolutePath()     // Catch:{ all -> 0x00da }
            r7[r2] = r8     // Catch:{ all -> 0x00da }
            r3.log(r5, r6, r7)     // Catch:{ all -> 0x00da }
            goto L_0x00d6
        L_0x0078:
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x00da }
            io.sentry.SentryOptions r6 = r11.options     // Catch:{ all -> 0x00da }
            java.lang.String r6 = r6.getCacheDirPath()     // Catch:{ all -> 0x00da }
            java.lang.String r7 = ".sentry-native/last_crash"
            r5.<init>(r6, r7)     // Catch:{ all -> 0x00da }
            boolean r6 = r5.exists()     // Catch:{ all -> 0x00da }
            if (r6 == 0) goto L_0x00bf
            io.sentry.SentryOptions r6 = r11.options     // Catch:{ all -> 0x00da }
            io.sentry.ILogger r6 = r6.getLogger()     // Catch:{ all -> 0x00da }
            io.sentry.SentryLevel r7 = io.sentry.SentryLevel.INFO     // Catch:{ all -> 0x00da }
            java.lang.String r8 = "Crash marker file exists, last Session is gonna be Crashed."
            java.lang.Object[] r9 = new java.lang.Object[r2]     // Catch:{ all -> 0x00da }
            r6.log(r7, r8, r9)     // Catch:{ all -> 0x00da }
            java.util.Date r6 = r11.getTimestampFromCrashMarkerFile(r5)     // Catch:{ all -> 0x00da }
            boolean r7 = r5.delete()     // Catch:{ all -> 0x00da }
            if (r7 != 0) goto L_0x00b9
            io.sentry.SentryOptions r7 = r11.options     // Catch:{ all -> 0x00da }
            io.sentry.ILogger r7 = r7.getLogger()     // Catch:{ all -> 0x00da }
            io.sentry.SentryLevel r8 = io.sentry.SentryLevel.ERROR     // Catch:{ all -> 0x00da }
            java.lang.String r9 = "Failed to delete the crash marker file. %s."
            java.lang.Object[] r10 = new java.lang.Object[r1]     // Catch:{ all -> 0x00da }
            java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ all -> 0x00da }
            r10[r2] = r5     // Catch:{ all -> 0x00da }
            r7.log(r8, r9, r10)     // Catch:{ all -> 0x00da }
        L_0x00b9:
            io.sentry.Session$State r5 = io.sentry.Session.State.Crashed     // Catch:{ all -> 0x00da }
            r3.update(r5, r4, r1)     // Catch:{ all -> 0x00da }
            goto L_0x00c0
        L_0x00bf:
            r6 = r4
        L_0x00c0:
            r3.end(r6)     // Catch:{ all -> 0x00da }
            io.sentry.ISerializer r5 = r11.serializer     // Catch:{ all -> 0x00da }
            io.sentry.SentryOptions r6 = r11.options     // Catch:{ all -> 0x00da }
            io.sentry.protocol.SdkVersion r6 = r6.getSdkVersion()     // Catch:{ all -> 0x00da }
            io.sentry.SentryEnvelope r3 = io.sentry.SentryEnvelope.from(r5, r3, r6)     // Catch:{ all -> 0x00da }
            java.io.File r5 = r11.getEnvelopeFile(r3)     // Catch:{ all -> 0x00da }
            r11.writeEnvelopeToDisk(r5, r3)     // Catch:{ all -> 0x00da }
        L_0x00d6:
            $closeResource(r4, r13)     // Catch:{ Exception -> 0x00e1 }
            goto L_0x00ef
        L_0x00da:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x00dc }
        L_0x00dc:
            r4 = move-exception
            $closeResource(r3, r13)     // Catch:{ Exception -> 0x00e1 }
            throw r4     // Catch:{ Exception -> 0x00e1 }
        L_0x00e1:
            r13 = move-exception
            io.sentry.SentryOptions r3 = r11.options
            io.sentry.ILogger r3 = r3.getLogger()
            io.sentry.SentryLevel r4 = io.sentry.SentryLevel.ERROR
            java.lang.String r5 = "Error processing session."
            r3.log(r4, r5, r13)
        L_0x00ef:
            boolean r13 = r0.delete()
            if (r13 != 0) goto L_0x0104
            io.sentry.SentryOptions r13 = r11.options
            io.sentry.ILogger r13 = r13.getLogger()
            io.sentry.SentryLevel r3 = io.sentry.SentryLevel.WARNING
            java.lang.Object[] r4 = new java.lang.Object[r2]
            java.lang.String r5 = "Failed to delete the current session file."
            r13.log(r3, r5, r4)
        L_0x0104:
            r11.updateCurrentSession(r0, r12)
        L_0x0107:
            java.io.File r13 = r11.getEnvelopeFile(r12)
            boolean r0 = r13.exists()
            if (r0 == 0) goto L_0x0127
            io.sentry.SentryOptions r12 = r11.options
            io.sentry.ILogger r12 = r12.getLogger()
            io.sentry.SentryLevel r0 = io.sentry.SentryLevel.WARNING
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r13 = r13.getAbsolutePath()
            r1[r2] = r13
            java.lang.String r13 = "Not adding Envelope to offline storage because it already exists: %s"
            r12.log(r0, r13, r1)
            return
        L_0x0127:
            io.sentry.SentryOptions r0 = r11.options
            io.sentry.ILogger r0 = r0.getLogger()
            io.sentry.SentryLevel r3 = io.sentry.SentryLevel.DEBUG
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r4 = r13.getAbsolutePath()
            r1[r2] = r4
            java.lang.String r2 = "Adding Envelope to offline storage: %s"
            r0.log(r3, r2, r1)
            r11.writeEnvelopeToDisk(r13, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.cache.EnvelopeCache.store(io.sentry.SentryEnvelope, java.lang.Object):void");
    }
}
