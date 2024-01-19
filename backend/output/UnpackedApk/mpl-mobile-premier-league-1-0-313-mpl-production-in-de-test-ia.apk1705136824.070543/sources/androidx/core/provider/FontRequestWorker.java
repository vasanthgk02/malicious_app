package androidx.core.provider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Consumer;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders.Values;

public class FontRequestWorker {
    public static final ExecutorService DEFAULT_EXECUTOR_SERVICE;
    public static final Object LOCK = new Object();
    public static final SimpleArrayMap<String, ArrayList<Consumer<TypefaceResult>>> PENDING_REPLIES = new SimpleArrayMap<>();
    public static final LruCache<String, Typeface> sTypefaceCache = new LruCache<>(16);

    public static final class TypefaceResult {
        public final int mResult;
        public final Typeface mTypeface;

        public TypefaceResult(int i) {
            this.mTypeface = null;
            this.mResult = i;
        }

        @SuppressLint({"WrongConstant"})
        public TypefaceResult(Typeface typeface) {
            this.mTypeface = typeface;
            this.mResult = 0;
        }
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, (long) 10000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new RequestExecutor$DefaultThreadFactory("fonts-androidx", 10));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        DEFAULT_EXECUTOR_SERVICE = threadPoolExecutor;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.core.provider.FontRequestWorker.TypefaceResult getFontSync(java.lang.String r7, android.content.Context r8, androidx.core.provider.FontRequest r9, int r10) {
        /*
            androidx.collection.LruCache<java.lang.String, android.graphics.Typeface> r0 = sTypefaceCache
            java.lang.Object r0 = r0.get(r7)
            android.graphics.Typeface r0 = (android.graphics.Typeface) r0
            if (r0 == 0) goto L_0x0010
            androidx.core.provider.FontRequestWorker$TypefaceResult r7 = new androidx.core.provider.FontRequestWorker$TypefaceResult
            r7.<init>(r0)
            return r7
        L_0x0010:
            r0 = 0
            androidx.core.provider.FontsContractCompat$FontFamilyResult r9 = androidx.core.provider.FontProvider.getFontFamilyResult(r8, r9, r0)     // Catch:{ NameNotFoundException -> 0x0061 }
            int r1 = r9.mStatusCode
            r2 = -3
            r3 = 1
            if (r1 == 0) goto L_0x0020
            if (r1 == r3) goto L_0x001e
            goto L_0x0035
        L_0x001e:
            r1 = -2
            goto L_0x003e
        L_0x0020:
            androidx.core.provider.FontsContractCompat$FontInfo[] r1 = r9.mFonts
            r4 = 0
            if (r1 == 0) goto L_0x003d
            int r5 = r1.length
            if (r5 != 0) goto L_0x0029
            goto L_0x003d
        L_0x0029:
            int r3 = r1.length
            r5 = 0
        L_0x002b:
            if (r5 >= r3) goto L_0x003c
            r6 = r1[r5]
            int r6 = r6.mResultCode
            if (r6 == 0) goto L_0x0039
            if (r6 >= 0) goto L_0x0037
        L_0x0035:
            r1 = -3
            goto L_0x003e
        L_0x0037:
            r1 = r6
            goto L_0x003e
        L_0x0039:
            int r5 = r5 + 1
            goto L_0x002b
        L_0x003c:
            r3 = 0
        L_0x003d:
            r1 = r3
        L_0x003e:
            if (r1 == 0) goto L_0x0046
            androidx.core.provider.FontRequestWorker$TypefaceResult r7 = new androidx.core.provider.FontRequestWorker$TypefaceResult
            r7.<init>(r1)
            return r7
        L_0x0046:
            androidx.core.provider.FontsContractCompat$FontInfo[] r9 = r9.mFonts
            androidx.core.graphics.TypefaceCompatBaseImpl r1 = androidx.core.graphics.TypefaceCompat.sTypefaceCompatImpl
            android.graphics.Typeface r8 = r1.createFromFontInfo(r8, r0, r9, r10)
            if (r8 == 0) goto L_0x005b
            androidx.collection.LruCache<java.lang.String, android.graphics.Typeface> r9 = sTypefaceCache
            r9.put(r7, r8)
            androidx.core.provider.FontRequestWorker$TypefaceResult r7 = new androidx.core.provider.FontRequestWorker$TypefaceResult
            r7.<init>(r8)
            return r7
        L_0x005b:
            androidx.core.provider.FontRequestWorker$TypefaceResult r7 = new androidx.core.provider.FontRequestWorker$TypefaceResult
            r7.<init>(r2)
            return r7
        L_0x0061:
            androidx.core.provider.FontRequestWorker$TypefaceResult r7 = new androidx.core.provider.FontRequestWorker$TypefaceResult
            r8 = -1
            r7.<init>(r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.FontRequestWorker.getFontSync(java.lang.String, android.content.Context, androidx.core.provider.FontRequest, int):androidx.core.provider.FontRequestWorker$TypefaceResult");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0053, code lost:
        r7 = new androidx.core.provider.FontRequestWorker.AnonymousClass3();
        r3 = DEFAULT_EXECUTOR_SERVICE;
        r4 = new androidx.core.provider.FontRequestWorker.AnonymousClass4();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0063, code lost:
        if (android.os.Looper.myLooper() != null) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0065, code lost:
        r5 = new android.os.Handler(android.os.Looper.getMainLooper());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006f, code lost:
        r5 = new android.os.Handler();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0074, code lost:
        r3.execute(new androidx.core.provider.RequestExecutor$ReplyRunnable(r5, r7, r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007c, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Typeface requestFontAsync(final android.content.Context r3, final androidx.core.provider.FontRequest r4, final int r5, java.util.concurrent.Executor r6, final androidx.core.provider.CallbackWithHandler r7) {
        /*
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = r4.mIdentifier
            r6.append(r0)
            java.lang.String r0 = "-"
            r6.append(r0)
            r6.append(r5)
            java.lang.String r6 = r6.toString()
            androidx.collection.LruCache<java.lang.String, android.graphics.Typeface> r0 = sTypefaceCache
            java.lang.Object r0 = r0.get(r6)
            android.graphics.Typeface r0 = (android.graphics.Typeface) r0
            if (r0 == 0) goto L_0x002d
            androidx.core.provider.FontsContractCompat$FontRequestCallback r3 = r7.mCallback
            android.os.Handler r4 = r7.mCallbackHandler
            androidx.core.provider.CallbackWithHandler$1 r5 = new androidx.core.provider.CallbackWithHandler$1
            r5.<init>(r7, r3, r0)
            r4.post(r5)
            return r0
        L_0x002d:
            androidx.core.provider.FontRequestWorker$2 r0 = new androidx.core.provider.FontRequestWorker$2
            r0.<init>()
            java.lang.Object r7 = LOCK
            monitor-enter(r7)
            androidx.collection.SimpleArrayMap<java.lang.String, java.util.ArrayList<androidx.core.util.Consumer<androidx.core.provider.FontRequestWorker$TypefaceResult>>> r1 = PENDING_REPLIES     // Catch:{ all -> 0x007d }
            java.lang.Object r1 = r1.get(r6)     // Catch:{ all -> 0x007d }
            java.util.ArrayList r1 = (java.util.ArrayList) r1     // Catch:{ all -> 0x007d }
            r2 = 0
            if (r1 == 0) goto L_0x0045
            r1.add(r0)     // Catch:{ all -> 0x007d }
            monitor-exit(r7)     // Catch:{ all -> 0x007d }
            return r2
        L_0x0045:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x007d }
            r1.<init>()     // Catch:{ all -> 0x007d }
            r1.add(r0)     // Catch:{ all -> 0x007d }
            androidx.collection.SimpleArrayMap<java.lang.String, java.util.ArrayList<androidx.core.util.Consumer<androidx.core.provider.FontRequestWorker$TypefaceResult>>> r0 = PENDING_REPLIES     // Catch:{ all -> 0x007d }
            r0.put(r6, r1)     // Catch:{ all -> 0x007d }
            monitor-exit(r7)     // Catch:{ all -> 0x007d }
            androidx.core.provider.FontRequestWorker$3 r7 = new androidx.core.provider.FontRequestWorker$3
            r7.<init>(r6, r3, r4, r5)
            java.util.concurrent.ExecutorService r3 = DEFAULT_EXECUTOR_SERVICE
            androidx.core.provider.FontRequestWorker$4 r4 = new androidx.core.provider.FontRequestWorker$4
            r4.<init>(r6)
            android.os.Looper r5 = android.os.Looper.myLooper()
            if (r5 != 0) goto L_0x006f
            android.os.Handler r5 = new android.os.Handler
            android.os.Looper r6 = android.os.Looper.getMainLooper()
            r5.<init>(r6)
            goto L_0x0074
        L_0x006f:
            android.os.Handler r5 = new android.os.Handler
            r5.<init>()
        L_0x0074:
            androidx.core.provider.RequestExecutor$ReplyRunnable r6 = new androidx.core.provider.RequestExecutor$ReplyRunnable
            r6.<init>(r5, r7, r4)
            r3.execute(r6)
            return r2
        L_0x007d:
            r3 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x007d }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.FontRequestWorker.requestFontAsync(android.content.Context, androidx.core.provider.FontRequest, int, java.util.concurrent.Executor, androidx.core.provider.CallbackWithHandler):android.graphics.Typeface");
    }

    public static Typeface requestFontSync(final Context context, final FontRequest fontRequest, CallbackWithHandler callbackWithHandler, final int i, int i2) {
        final String str = fontRequest.mIdentifier + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i;
        Typeface typeface = (Typeface) sTypefaceCache.get(str);
        if (typeface != null) {
            callbackWithHandler.mCallbackHandler.post(new Runnable(callbackWithHandler, callbackWithHandler.mCallback, typeface) {
                public void run() {
                    fontsContractCompat$FontRequestCallback.onTypefaceRetrieved(typeface);
                }
            });
            return typeface;
        } else if (i2 == -1) {
            TypefaceResult fontSync = getFontSync(str, context, fontRequest, i);
            callbackWithHandler.onTypefaceResult(fontSync);
            return fontSync.mTypeface;
        } else {
            try {
                TypefaceResult typefaceResult = (TypefaceResult) DEFAULT_EXECUTOR_SERVICE.submit(new Callable<TypefaceResult>() {
                    public Object call() throws Exception {
                        return FontRequestWorker.getFontSync(str, context, fontRequest, i);
                    }
                }).get((long) i2, TimeUnit.MILLISECONDS);
                callbackWithHandler.onTypefaceResult(typefaceResult);
                return typefaceResult.mTypeface;
            } catch (ExecutionException e2) {
                throw new RuntimeException(e2);
            } catch (InterruptedException e3) {
                throw e3;
            } catch (TimeoutException unused) {
                throw new InterruptedException(Values.TIMEOUT);
            } catch (InterruptedException unused2) {
                callbackWithHandler.mCallbackHandler.post(new Runnable(callbackWithHandler, callbackWithHandler.mCallback, -3) {
                    public void run() {
                        fontsContractCompat$FontRequestCallback2.onTypefaceRequestFailed(i);
                    }
                });
                return null;
            }
        }
    }
}
