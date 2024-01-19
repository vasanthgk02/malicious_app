package com.airbnb.lottie;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.airbnb.lottie.model.LottieCompositionCache;
import com.airbnb.lottie.parser.LottieCompositionMoshiParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.sentry.cache.EnvelopeCache;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.Okio;

public class LottieCompositionFactory {
    public static final byte[] MAGIC = {80, 75, 3, 4};
    public static final Map<String, LottieTask<LottieComposition>> taskCache = new HashMap();

    public static LottieTask<LottieComposition> cache(final String str, Callable<LottieResult<LottieComposition>> callable) {
        final LottieComposition lottieComposition = null;
        if (str != null) {
            LottieCompositionCache lottieCompositionCache = LottieCompositionCache.INSTANCE;
            if (lottieCompositionCache != null) {
                lottieComposition = (LottieComposition) lottieCompositionCache.cache.get(str);
            } else {
                throw null;
            }
        }
        if (lottieComposition != null) {
            return new LottieTask<>(new Callable<LottieResult<LottieComposition>>() {
                public Object call() throws Exception {
                    return new LottieResult(LottieComposition.this);
                }
            }, false);
        }
        if (str != null && taskCache.containsKey(str)) {
            return taskCache.get(str);
        }
        LottieTask<LottieComposition> lottieTask = new LottieTask<>(callable, false);
        if (str != null) {
            lottieTask.addListener(new LottieListener<LottieComposition>() {
                public void onResult(Object obj) {
                    LottieComposition lottieComposition = (LottieComposition) obj;
                    LottieCompositionFactory.taskCache.remove(str);
                }
            });
            lottieTask.addFailureListener(new LottieListener<Throwable>() {
                public void onResult(Object obj) {
                    Throwable th = (Throwable) obj;
                    LottieCompositionFactory.taskCache.remove(str);
                }
            });
            taskCache.put(str, lottieTask);
        }
        return lottieTask;
    }

    public static LottieTask<LottieComposition> fromAsset(Context context, final String str) {
        final String outline50 = GeneratedOutlineSupport.outline50("asset_", str);
        final Context applicationContext = context.getApplicationContext();
        return cache(outline50, new Callable<LottieResult<LottieComposition>>() {
            public Object call() throws Exception {
                return LottieCompositionFactory.fromAssetSync(r1, r2, null);
            }
        });
    }

    public static LottieResult<LottieComposition> fromAssetSync(Context context, String str) {
        return fromAssetSync(context, str, "asset_" + str);
    }

    public static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream inputStream, String str) {
        try {
            return fromJsonReaderSyncInternal(JsonReader.of(Okio.buffer(Okio.source(inputStream))), str, true);
        } finally {
            Utils.closeQuietly(inputStream);
        }
    }

    public static LottieResult<LottieComposition> fromJsonReaderSyncInternal(JsonReader jsonReader, String str, boolean z) {
        try {
            LottieComposition parse = LottieCompositionMoshiParser.parse(jsonReader);
            if (str != null) {
                LottieCompositionCache.INSTANCE.put(str, parse);
            }
            LottieResult<LottieComposition> lottieResult = new LottieResult<>(parse);
            if (z) {
                Utils.closeQuietly(jsonReader);
            }
            return lottieResult;
        } catch (Exception e2) {
            LottieResult<LottieComposition> lottieResult2 = new LottieResult<>((Throwable) e2);
            if (z) {
                Utils.closeQuietly(jsonReader);
            }
            return lottieResult2;
        } catch (Throwable th) {
            if (z) {
                Utils.closeQuietly(jsonReader);
            }
            throw th;
        }
    }

    public static LottieTask<LottieComposition> fromRawRes(Context context, final int i, String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return cache(null, new Callable<LottieResult<LottieComposition>>(null) {
            public Object call() throws Exception {
                Context context = (Context) weakReference.get();
                if (context == null) {
                    context = applicationContext;
                }
                return LottieCompositionFactory.fromRawResSync(context, i, null);
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0032, code lost:
        if (((com.airbnb.lottie.utils.LogcatLogger) com.airbnb.lottie.utils.Logger.INSTANCE) != null) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        r6 = java.lang.Boolean.FALSE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0054, code lost:
        throw null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> fromRawResSync(android.content.Context r5, int r6, java.lang.String r7) {
        /*
            android.content.res.Resources r5 = r5.getResources()     // Catch:{ NotFoundException -> 0x0055 }
            java.io.InputStream r5 = r5.openRawResource(r6)     // Catch:{ NotFoundException -> 0x0055 }
            okio.Source r5 = okio.Okio.source(r5)     // Catch:{ NotFoundException -> 0x0055 }
            okio.BufferedSource r5 = okio.Okio.buffer(r5)     // Catch:{ NotFoundException -> 0x0055 }
            okio.BufferedSource r6 = r5.peek()     // Catch:{ Exception -> 0x002e }
            byte[] r0 = MAGIC     // Catch:{ Exception -> 0x002e }
            int r1 = r0.length     // Catch:{ Exception -> 0x002e }
            r2 = 0
        L_0x0018:
            if (r2 >= r1) goto L_0x0028
            byte r3 = r0[r2]     // Catch:{ Exception -> 0x002e }
            byte r4 = r6.readByte()     // Catch:{ Exception -> 0x002e }
            if (r4 == r3) goto L_0x0025
            java.lang.Boolean r6 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x002e }
            goto L_0x0036
        L_0x0025:
            int r2 = r2 + 1
            goto L_0x0018
        L_0x0028:
            r6.close()     // Catch:{ Exception -> 0x002e }
            java.lang.Boolean r6 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x002e }
            goto L_0x0036
        L_0x002e:
            com.airbnb.lottie.LottieLogger r6 = com.airbnb.lottie.utils.Logger.INSTANCE     // Catch:{ NotFoundException -> 0x0055 }
            com.airbnb.lottie.utils.LogcatLogger r6 = (com.airbnb.lottie.utils.LogcatLogger) r6     // Catch:{ NotFoundException -> 0x0055 }
            if (r6 == 0) goto L_0x0053
            java.lang.Boolean r6 = java.lang.Boolean.FALSE     // Catch:{ NotFoundException -> 0x0055 }
        L_0x0036:
            boolean r6 = r6.booleanValue()     // Catch:{ NotFoundException -> 0x0055 }
            if (r6 == 0) goto L_0x004a
            java.util.zip.ZipInputStream r6 = new java.util.zip.ZipInputStream     // Catch:{ NotFoundException -> 0x0055 }
            java.io.InputStream r5 = r5.inputStream()     // Catch:{ NotFoundException -> 0x0055 }
            r6.<init>(r5)     // Catch:{ NotFoundException -> 0x0055 }
            com.airbnb.lottie.LottieResult r5 = fromZipStreamSync(r6, r7)     // Catch:{ NotFoundException -> 0x0055 }
            return r5
        L_0x004a:
            java.io.InputStream r5 = r5.inputStream()     // Catch:{ NotFoundException -> 0x0055 }
            com.airbnb.lottie.LottieResult r5 = fromJsonInputStreamSync(r5, r7)     // Catch:{ NotFoundException -> 0x0055 }
            return r5
        L_0x0053:
            r5 = 0
            throw r5     // Catch:{ NotFoundException -> 0x0055 }
        L_0x0055:
            r5 = move-exception
            com.airbnb.lottie.LottieResult r6 = new com.airbnb.lottie.LottieResult
            r6.<init>(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieCompositionFactory.fromRawResSync(android.content.Context, int, java.lang.String):com.airbnb.lottie.LottieResult");
    }

    public static LottieTask<LottieComposition> fromUrl(Context context, String str) {
        return fromUrl(context, str, "url_" + str);
    }

    public static LottieResult<LottieComposition> fromZipStreamSync(ZipInputStream zipInputStream, String str) {
        try {
            return fromZipStreamSyncInternal(zipInputStream, str);
        } finally {
            Utils.closeQuietly(zipInputStream);
        }
    }

    public static LottieResult<LottieComposition> fromZipStreamSyncInternal(ZipInputStream zipInputStream, String str) {
        LottieImageAsset lottieImageAsset;
        String[] split;
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            LottieComposition lottieComposition = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(EnvelopeCache.SUFFIX_CURRENT_SESSION_FILE)) {
                    lottieComposition = fromJsonReaderSyncInternal(JsonReader.of(Okio.buffer(Okio.source((InputStream) zipInputStream))), null, false).value;
                } else {
                    if (!name.contains(".png")) {
                        if (!name.contains(".webp")) {
                            zipInputStream.closeEntry();
                        }
                    }
                    hashMap.put(split[name.split("/").length - 1], BitmapFactory.decodeStream(zipInputStream));
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (lottieComposition == null) {
                return new LottieResult<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Entry entry : hashMap.entrySet()) {
                String str2 = (String) entry.getKey();
                Iterator<LottieImageAsset> it = lottieComposition.images.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        lottieImageAsset = null;
                        break;
                    }
                    lottieImageAsset = it.next();
                    if (lottieImageAsset.fileName.equals(str2)) {
                        break;
                    }
                }
                if (lottieImageAsset != null) {
                    lottieImageAsset.bitmap = Utils.resizeBitmapIfNeeded((Bitmap) entry.getValue(), lottieImageAsset.width, lottieImageAsset.height);
                }
            }
            for (Entry next : lottieComposition.images.entrySet()) {
                if (((LottieImageAsset) next.getValue()).bitmap == null) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("There is no image for ");
                    outline73.append(((LottieImageAsset) next.getValue()).fileName);
                    return new LottieResult<>((Throwable) new IllegalStateException(outline73.toString()));
                }
            }
            if (str != null) {
                LottieCompositionCache.INSTANCE.put(str, lottieComposition);
            }
            return new LottieResult<>(lottieComposition);
        } catch (IOException e2) {
            return new LottieResult<>((Throwable) e2);
        }
    }

    public static String rawResCacheKey(Context context, int i) {
        return GeneratedOutlineSupport.outline61(GeneratedOutlineSupport.outline73("rawRes"), (context.getResources().getConfiguration().uiMode & 48) == 32 ? "_night_" : "_day_", i);
    }

    public static LottieTask<LottieComposition> fromUrl(final Context context, final String str, final String str2) {
        return cache(str2, new Callable<LottieResult<LottieComposition>>() {
            /* JADX WARNING: Removed duplicated region for block: B:50:0x00af  */
            /* JADX WARNING: Removed duplicated region for block: B:59:0x00d3  */
            /* JADX WARNING: Removed duplicated region for block: B:60:0x00da  */
            /* JADX WARNING: Removed duplicated region for block: B:71:0x011f A[SYNTHETIC, Splitter:B:71:0x011f] */
            /* JADX WARNING: Removed duplicated region for block: B:76:0x0149 A[Catch:{ Exception -> 0x0164, all -> 0x0162 }] */
            /* JADX WARNING: Removed duplicated region for block: B:93:0x0179  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object call() throws java.lang.Exception {
                /*
                    r10 = this;
                    android.content.Context r0 = r1
                    com.airbnb.lottie.network.NetworkFetcher r1 = com.airbnb.lottie.L.networkFetcher
                    if (r1 != 0) goto L_0x003b
                    java.lang.Class<com.airbnb.lottie.network.NetworkFetcher> r2 = com.airbnb.lottie.network.NetworkFetcher.class
                    monitor-enter(r2)
                    com.airbnb.lottie.network.NetworkFetcher r1 = com.airbnb.lottie.L.networkFetcher     // Catch:{ all -> 0x0038 }
                    if (r1 != 0) goto L_0x0036
                    com.airbnb.lottie.network.NetworkFetcher r1 = new com.airbnb.lottie.network.NetworkFetcher     // Catch:{ all -> 0x0038 }
                    com.airbnb.lottie.network.NetworkCache r3 = com.airbnb.lottie.L.networkCache     // Catch:{ all -> 0x0038 }
                    if (r3 != 0) goto L_0x002c
                    java.lang.Class<com.airbnb.lottie.network.NetworkCache> r3 = com.airbnb.lottie.network.NetworkCache.class
                    monitor-enter(r3)     // Catch:{ all -> 0x0038 }
                    com.airbnb.lottie.network.NetworkCache r4 = com.airbnb.lottie.L.networkCache     // Catch:{ all -> 0x0029 }
                    if (r4 != 0) goto L_0x0026
                    com.airbnb.lottie.network.NetworkCache r4 = new com.airbnb.lottie.network.NetworkCache     // Catch:{ all -> 0x0029 }
                    com.airbnb.lottie.L$1 r5 = new com.airbnb.lottie.L$1     // Catch:{ all -> 0x0029 }
                    r5.<init>(r0)     // Catch:{ all -> 0x0029 }
                    r4.<init>(r5)     // Catch:{ all -> 0x0029 }
                    com.airbnb.lottie.L.networkCache = r4     // Catch:{ all -> 0x0029 }
                L_0x0026:
                    monitor-exit(r3)     // Catch:{ all -> 0x0029 }
                    r3 = r4
                    goto L_0x002c
                L_0x0029:
                    r0 = move-exception
                    monitor-exit(r3)     // Catch:{ all -> 0x0029 }
                    throw r0     // Catch:{ all -> 0x0038 }
                L_0x002c:
                    com.airbnb.lottie.network.DefaultLottieNetworkFetcher r0 = new com.airbnb.lottie.network.DefaultLottieNetworkFetcher     // Catch:{ all -> 0x0038 }
                    r0.<init>()     // Catch:{ all -> 0x0038 }
                    r1.<init>(r3, r0)     // Catch:{ all -> 0x0038 }
                    com.airbnb.lottie.L.networkFetcher = r1     // Catch:{ all -> 0x0038 }
                L_0x0036:
                    monitor-exit(r2)     // Catch:{ all -> 0x0038 }
                    goto L_0x003b
                L_0x0038:
                    r0 = move-exception
                    monitor-exit(r2)     // Catch:{ all -> 0x0038 }
                    throw r0
                L_0x003b:
                    java.lang.String r0 = r2
                    java.lang.String r2 = r3
                    r3 = 0
                    r4 = 0
                    if (r2 != 0) goto L_0x0045
                    goto L_0x00d0
                L_0x0045:
                    com.airbnb.lottie.network.NetworkCache r5 = r1.networkCache
                    if (r5 == 0) goto L_0x0190
                    java.io.File r6 = new java.io.File     // Catch:{ FileNotFoundException -> 0x00ab }
                    java.io.File r7 = r5.parentDir()     // Catch:{ FileNotFoundException -> 0x00ab }
                    com.airbnb.lottie.network.FileExtension r8 = com.airbnb.lottie.network.FileExtension.JSON     // Catch:{ FileNotFoundException -> 0x00ab }
                    java.lang.String r8 = com.airbnb.lottie.network.NetworkCache.filenameForUrl(r0, r8, r4)     // Catch:{ FileNotFoundException -> 0x00ab }
                    r6.<init>(r7, r8)     // Catch:{ FileNotFoundException -> 0x00ab }
                    boolean r7 = r6.exists()     // Catch:{ FileNotFoundException -> 0x00ab }
                    if (r7 == 0) goto L_0x005f
                    goto L_0x0076
                L_0x005f:
                    java.io.File r6 = new java.io.File     // Catch:{ FileNotFoundException -> 0x00ab }
                    java.io.File r5 = r5.parentDir()     // Catch:{ FileNotFoundException -> 0x00ab }
                    com.airbnb.lottie.network.FileExtension r7 = com.airbnb.lottie.network.FileExtension.ZIP     // Catch:{ FileNotFoundException -> 0x00ab }
                    java.lang.String r7 = com.airbnb.lottie.network.NetworkCache.filenameForUrl(r0, r7, r4)     // Catch:{ FileNotFoundException -> 0x00ab }
                    r6.<init>(r5, r7)     // Catch:{ FileNotFoundException -> 0x00ab }
                    boolean r5 = r6.exists()     // Catch:{ FileNotFoundException -> 0x00ab }
                    if (r5 == 0) goto L_0x0075
                    goto L_0x0076
                L_0x0075:
                    r6 = r3
                L_0x0076:
                    if (r6 != 0) goto L_0x0079
                    goto L_0x00ab
                L_0x0079:
                    java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00ab }
                    r5.<init>(r6)     // Catch:{ FileNotFoundException -> 0x00ab }
                    java.lang.String r7 = r6.getAbsolutePath()
                    java.lang.String r8 = ".zip"
                    boolean r7 = r7.endsWith(r8)
                    if (r7 == 0) goto L_0x008d
                    com.airbnb.lottie.network.FileExtension r7 = com.airbnb.lottie.network.FileExtension.ZIP
                    goto L_0x008f
                L_0x008d:
                    com.airbnb.lottie.network.FileExtension r7 = com.airbnb.lottie.network.FileExtension.JSON
                L_0x008f:
                    java.lang.String r8 = "Cache hit for "
                    java.lang.String r9 = " at "
                    java.lang.StringBuilder r8 = com.android.tools.r8.GeneratedOutlineSupport.outline80(r8, r0, r9)
                    java.lang.String r6 = r6.getAbsolutePath()
                    r8.append(r6)
                    java.lang.String r6 = r8.toString()
                    com.airbnb.lottie.utils.Logger.debug(r6)
                    android.util.Pair r6 = new android.util.Pair
                    r6.<init>(r7, r5)
                    goto L_0x00ac
                L_0x00ab:
                    r6 = r3
                L_0x00ac:
                    if (r6 != 0) goto L_0x00af
                    goto L_0x00d0
                L_0x00af:
                    java.lang.Object r5 = r6.first
                    com.airbnb.lottie.network.FileExtension r5 = (com.airbnb.lottie.network.FileExtension) r5
                    java.lang.Object r6 = r6.second
                    java.io.InputStream r6 = (java.io.InputStream) r6
                    com.airbnb.lottie.network.FileExtension r7 = com.airbnb.lottie.network.FileExtension.ZIP
                    if (r5 != r7) goto L_0x00c5
                    java.util.zip.ZipInputStream r5 = new java.util.zip.ZipInputStream
                    r5.<init>(r6)
                    com.airbnb.lottie.LottieResult r5 = com.airbnb.lottie.LottieCompositionFactory.fromZipStreamSync(r5, r0)
                    goto L_0x00c9
                L_0x00c5:
                    com.airbnb.lottie.LottieResult r5 = com.airbnb.lottie.LottieCompositionFactory.fromJsonInputStreamSync(r6, r0)
                L_0x00c9:
                    V r5 = r5.value
                    if (r5 == 0) goto L_0x00d0
                    com.airbnb.lottie.LottieComposition r5 = (com.airbnb.lottie.LottieComposition) r5
                    goto L_0x00d1
                L_0x00d0:
                    r5 = r3
                L_0x00d1:
                    if (r5 == 0) goto L_0x00da
                    com.airbnb.lottie.LottieResult r0 = new com.airbnb.lottie.LottieResult
                    r0.<init>(r5)
                    goto L_0x0175
                L_0x00da:
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder
                    r5.<init>()
                    java.lang.String r6 = "Animation for "
                    r5.append(r6)
                    r5.append(r0)
                    java.lang.String r6 = " not found in cache. Fetching from network."
                    r5.append(r6)
                    java.lang.String r5 = r5.toString()
                    com.airbnb.lottie.utils.Logger.debug(r5)
                    java.lang.String r5 = "LottieFetchResult close failed "
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder
                    r6.<init>()
                    java.lang.String r7 = "Fetching "
                    r6.append(r7)
                    r6.append(r0)
                    java.lang.String r6 = r6.toString()
                    com.airbnb.lottie.utils.Logger.debug(r6)
                    com.airbnb.lottie.network.DefaultLottieNetworkFetcher r6 = r1.fetcher     // Catch:{ Exception -> 0x0164 }
                    com.airbnb.lottie.network.DefaultLottieFetchResult r3 = r6.fetchSync(r0)     // Catch:{ Exception -> 0x0164 }
                    java.net.HttpURLConnection r6 = r3.connection     // Catch:{ IOException -> 0x011c }
                    int r6 = r6.getResponseCode()     // Catch:{ IOException -> 0x011c }
                    int r6 = r6 / 100
                    r7 = 2
                    if (r6 != r7) goto L_0x011c
                    r6 = 1
                    goto L_0x011d
                L_0x011c:
                    r6 = 0
                L_0x011d:
                    if (r6 == 0) goto L_0x0149
                    java.net.HttpURLConnection r6 = r3.connection     // Catch:{ Exception -> 0x0164 }
                    java.io.InputStream r6 = r6.getInputStream()     // Catch:{ Exception -> 0x0164 }
                    java.net.HttpURLConnection r7 = r3.connection     // Catch:{ Exception -> 0x0164 }
                    java.lang.String r7 = r7.getContentType()     // Catch:{ Exception -> 0x0164 }
                    com.airbnb.lottie.LottieResult r0 = r1.fromInputStream(r0, r6, r7, r2)     // Catch:{ Exception -> 0x0164 }
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0164 }
                    r1.<init>()     // Catch:{ Exception -> 0x0164 }
                    java.lang.String r2 = "Completed fetch from network. Success: "
                    r1.append(r2)     // Catch:{ Exception -> 0x0164 }
                    V r2 = r0.value     // Catch:{ Exception -> 0x0164 }
                    if (r2 == 0) goto L_0x013e
                    r4 = 1
                L_0x013e:
                    r1.append(r4)     // Catch:{ Exception -> 0x0164 }
                    java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0164 }
                    com.airbnb.lottie.utils.Logger.debug(r1)     // Catch:{ Exception -> 0x0164 }
                    goto L_0x0157
                L_0x0149:
                    com.airbnb.lottie.LottieResult r0 = new com.airbnb.lottie.LottieResult     // Catch:{ Exception -> 0x0164 }
                    java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0164 }
                    java.lang.String r2 = r3.error()     // Catch:{ Exception -> 0x0164 }
                    r1.<init>(r2)     // Catch:{ Exception -> 0x0164 }
                    r0.<init>(r1)     // Catch:{ Exception -> 0x0164 }
                L_0x0157:
                    java.net.HttpURLConnection r1 = r3.connection     // Catch:{ IOException -> 0x015d }
                    r1.disconnect()     // Catch:{ IOException -> 0x015d }
                    goto L_0x0175
                L_0x015d:
                    r1 = move-exception
                    com.airbnb.lottie.utils.Logger.warning(r5, r1)
                    goto L_0x0175
                L_0x0162:
                    r0 = move-exception
                    goto L_0x0185
                L_0x0164:
                    r0 = move-exception
                    com.airbnb.lottie.LottieResult r1 = new com.airbnb.lottie.LottieResult     // Catch:{ all -> 0x0162 }
                    r1.<init>(r0)     // Catch:{ all -> 0x0162 }
                    if (r3 == 0) goto L_0x0174
                    r3.close()     // Catch:{ IOException -> 0x0170 }
                    goto L_0x0174
                L_0x0170:
                    r0 = move-exception
                    com.airbnb.lottie.utils.Logger.warning(r5, r0)
                L_0x0174:
                    r0 = r1
                L_0x0175:
                    java.lang.String r1 = r3
                    if (r1 == 0) goto L_0x0184
                    V r2 = r0.value
                    if (r2 == 0) goto L_0x0184
                    com.airbnb.lottie.model.LottieCompositionCache r3 = com.airbnb.lottie.model.LottieCompositionCache.INSTANCE
                    com.airbnb.lottie.LottieComposition r2 = (com.airbnb.lottie.LottieComposition) r2
                    r3.put(r1, r2)
                L_0x0184:
                    return r0
                L_0x0185:
                    if (r3 == 0) goto L_0x018f
                    r3.close()     // Catch:{ IOException -> 0x018b }
                    goto L_0x018f
                L_0x018b:
                    r1 = move-exception
                    com.airbnb.lottie.utils.Logger.warning(r5, r1)
                L_0x018f:
                    throw r0
                L_0x0190:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieCompositionFactory.AnonymousClass1.call():java.lang.Object");
            }
        });
    }

    public static LottieResult<LottieComposition> fromAssetSync(Context context, String str, String str2) {
        try {
            if (!str.endsWith(".zip")) {
                if (!str.endsWith(".lottie")) {
                    return fromJsonInputStreamSync(context.getAssets().open(str), str2);
                }
            }
            return fromZipStreamSync(new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e2) {
            return new LottieResult<>((Throwable) e2);
        }
    }

    public static LottieTask<LottieComposition> fromAsset(Context context, final String str, String str2) {
        final Context applicationContext = context.getApplicationContext();
        return cache(null, new Callable<LottieResult<LottieComposition>>(null) {
            public Object call() throws Exception {
                return LottieCompositionFactory.fromAssetSync(applicationContext, str, null);
            }
        });
    }
}
