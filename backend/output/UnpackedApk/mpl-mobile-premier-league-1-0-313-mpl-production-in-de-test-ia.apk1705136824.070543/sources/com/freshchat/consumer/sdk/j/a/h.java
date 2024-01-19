package com.freshchat.consumer.sdk.j.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.j.ad;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.q;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.squareup.picasso.NetworkRequestHandler;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class h extends e {
    public static b sf = null;
    public static File sg = null;
    public static boolean sh = true;
    public static final Object si = new Object();
    public static h sj;

    public h(Context context, int i) {
        super(context, i);
        if (sj == null) {
            synchronized (h.class) {
                if (sj == null) {
                    sj = this;
                    d(context);
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r9v11 */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r9v12 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: type inference failed for: r0v12 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r7v2 */
    /* JADX WARNING: type inference failed for: r9v18 */
    /* JADX WARNING: type inference failed for: r0v15 */
    /* JADX WARNING: type inference failed for: r0v16 */
    /* JADX WARNING: type inference failed for: r0v17 */
    /* JADX WARNING: type inference failed for: r0v18 */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x001d */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:2:0x001d A[LOOP:0: B:2:0x001d->B:61:0x001d, LOOP_START, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:42:0x0092=Splitter:B:42:0x0092, B:48:0x009f=Splitter:B:48:0x009f} */
    /* JADX WARNING: Unknown variable types count: 7 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap bK(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "ImageFetcher"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "processBitmap - "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            com.freshchat.consumer.sdk.j.ai.d(r0, r1)
            java.lang.String r0 = com.freshchat.consumer.sdk.j.a.d.bJ(r9)
            java.lang.Object r1 = si
            monitor-enter(r1)
        L_0x001d:
            boolean r2 = sh     // Catch:{ all -> 0x00b6 }
            if (r2 == 0) goto L_0x0027
            java.lang.Object r2 = si     // Catch:{ InterruptedException -> 0x001d }
            r2.wait()     // Catch:{ InterruptedException -> 0x001d }
            goto L_0x001d
        L_0x0027:
            com.freshchat.consumer.sdk.j.a.b r2 = sf     // Catch:{ all -> 0x00b6 }
            r3 = 0
            if (r2 == 0) goto L_0x00b4
            r2 = 1
            r4 = 0
            com.freshchat.consumer.sdk.j.a.b r5 = sf     // Catch:{ IOException -> 0x009d, IllegalStateException -> 0x0090, all -> 0x008e }
            com.freshchat.consumer.sdk.j.a.b$c r5 = r5.bE(r0)     // Catch:{ IOException -> 0x009d, IllegalStateException -> 0x0090, all -> 0x008e }
            if (r5 != 0) goto L_0x005c
            java.lang.String r5 = "ImageFetcher"
            java.lang.String r6 = "processBitmap, not found in http cache, downloading..."
            com.freshchat.consumer.sdk.j.ai.d(r5, r6)     // Catch:{ IOException -> 0x009d, IllegalStateException -> 0x0090, all -> 0x008e }
            com.freshchat.consumer.sdk.j.a.b r5 = sf     // Catch:{ IOException -> 0x009d, IllegalStateException -> 0x0090, all -> 0x008e }
            com.freshchat.consumer.sdk.j.a.b$a r5 = r5.bF(r0)     // Catch:{ IOException -> 0x009d, IllegalStateException -> 0x0090, all -> 0x008e }
            if (r5 == 0) goto L_0x0056
            java.io.OutputStream r6 = r5.x(r4)     // Catch:{ IOException -> 0x009d, IllegalStateException -> 0x0090, all -> 0x008e }
            boolean r9 = r8.a(r9, r6)     // Catch:{ IOException -> 0x009d, IllegalStateException -> 0x0090, all -> 0x008e }
            if (r9 == 0) goto L_0x0053
            r5.commit()     // Catch:{ IOException -> 0x009d, IllegalStateException -> 0x0090, all -> 0x008e }
            goto L_0x0056
        L_0x0053:
            r5.abort()     // Catch:{ IOException -> 0x009d, IllegalStateException -> 0x0090, all -> 0x008e }
        L_0x0056:
            com.freshchat.consumer.sdk.j.a.b r9 = sf     // Catch:{ IOException -> 0x009d, IllegalStateException -> 0x0090, all -> 0x008e }
            com.freshchat.consumer.sdk.j.a.b$c r5 = r9.bE(r0)     // Catch:{ IOException -> 0x009d, IllegalStateException -> 0x0090, all -> 0x008e }
        L_0x005c:
            if (r5 == 0) goto L_0x0084
            java.io.InputStream r9 = r5.ad(r4)     // Catch:{ IOException -> 0x009d, IllegalStateException -> 0x0090, all -> 0x008e }
            java.io.FileInputStream r9 = (java.io.FileInputStream) r9     // Catch:{ IOException -> 0x009d, IllegalStateException -> 0x0090, all -> 0x008e }
            java.io.FileDescriptor r0 = r9.getFD()     // Catch:{ IOException -> 0x007f, IllegalStateException -> 0x007a, all -> 0x0076 }
            if (r0 == 0) goto L_0x0072
            int r5 = r8.ka     // Catch:{ IOException -> 0x007f, IllegalStateException -> 0x007a, all -> 0x0076 }
            int r6 = r8.kb     // Catch:{ IOException -> 0x007f, IllegalStateException -> 0x007a, all -> 0x0076 }
            android.graphics.Bitmap r3 = com.freshchat.consumer.sdk.j.a.e.a(r0, r5, r6)     // Catch:{ IOException -> 0x007f, IllegalStateException -> 0x007a, all -> 0x0076 }
        L_0x0072:
            r7 = r3
            r3 = r9
            r9 = r7
            goto L_0x0085
        L_0x0076:
            r0 = move-exception
            r3 = r9
            r9 = r0
            goto L_0x00ac
        L_0x007a:
            r0 = move-exception
            r7 = r0
            r0 = r9
            r9 = r7
            goto L_0x0092
        L_0x007f:
            r0 = move-exception
            r7 = r0
            r0 = r9
            r9 = r7
            goto L_0x009f
        L_0x0084:
            r9 = r3
        L_0x0085:
            java.io.Closeable[] r0 = new java.io.Closeable[r2]     // Catch:{ all -> 0x00b6 }
            r0[r4] = r3     // Catch:{ all -> 0x00b6 }
            com.freshchat.consumer.sdk.j.ad.a(r0)     // Catch:{ all -> 0x00b6 }
            r3 = r9
            goto L_0x00b4
        L_0x008e:
            r9 = move-exception
            goto L_0x00ac
        L_0x0090:
            r9 = move-exception
            r0 = r3
        L_0x0092:
            com.freshchat.consumer.sdk.j.q.a(r9)     // Catch:{ all -> 0x00aa }
            java.io.Closeable[] r9 = new java.io.Closeable[r2]     // Catch:{ all -> 0x00b6 }
            r9[r4] = r0     // Catch:{ all -> 0x00b6 }
            com.freshchat.consumer.sdk.j.ad.a(r9)     // Catch:{ all -> 0x00b6 }
            goto L_0x00b4
        L_0x009d:
            r9 = move-exception
            r0 = r3
        L_0x009f:
            com.freshchat.consumer.sdk.j.q.a(r9)     // Catch:{ all -> 0x00aa }
            java.io.Closeable[] r9 = new java.io.Closeable[r2]     // Catch:{ all -> 0x00b6 }
            r9[r4] = r0     // Catch:{ all -> 0x00b6 }
            com.freshchat.consumer.sdk.j.ad.a(r9)     // Catch:{ all -> 0x00b6 }
            goto L_0x00b4
        L_0x00aa:
            r9 = move-exception
            r3 = r0
        L_0x00ac:
            java.io.Closeable[] r0 = new java.io.Closeable[r2]     // Catch:{ all -> 0x00b6 }
            r0[r4] = r3     // Catch:{ all -> 0x00b6 }
            com.freshchat.consumer.sdk.j.ad.a(r0)     // Catch:{ all -> 0x00b6 }
            throw r9     // Catch:{ all -> 0x00b6 }
        L_0x00b4:
            monitor-exit(r1)     // Catch:{ all -> 0x00b6 }
            return r3
        L_0x00b6:
            r9 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00b6 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.j.a.h.bK(java.lang.String):android.graphics.Bitmap");
    }

    private void bi(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            i.a(context, R.string.freshchat_error_message_not_connected_to_internet);
        }
    }

    private void d(Context context) {
        bi(context);
        sg = d.R(context, NetworkRequestHandler.SCHEME_HTTP);
    }

    private void ka() {
        synchronized (si) {
            if ((sf == null || sf.isClosed()) && d.c(sg) > 10485760) {
                try {
                    sf = b.a(sg, 1, 1, 10485760);
                    ai.d("ImageFetcher", "HTTP cache initialized");
                } catch (IOException unused) {
                    sf = null;
                }
            }
            sh = false;
            si.notifyAll();
        }
    }

    public static void kb() {
    }

    public boolean a(String str, OutputStream outputStream) {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        if (as.isEmpty(str)) {
            return false;
        }
        kb();
        URLConnection uRLConnection = null;
        try {
            URLConnection uRLConnection2 = (URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection());
            try {
                bufferedInputStream = new BufferedInputStream(uRLConnection2.getInputStream(), 8192);
            } catch (IOException e2) {
                e = e2;
                bufferedInputStream = null;
                bufferedOutputStream = null;
                uRLConnection = uRLConnection2;
                try {
                    ai.d("FRESHCHAT", "Failed to load URL " + str);
                    q.a(e);
                    ((HttpURLConnection) uRLConnection).disconnect();
                    ad.a(bufferedInputStream, bufferedOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    if (uRLConnection != null && (uRLConnection instanceof HttpURLConnection)) {
                        ((HttpURLConnection) uRLConnection).disconnect();
                    }
                    ad.a(bufferedInputStream, bufferedOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = null;
                bufferedOutputStream = null;
                uRLConnection = uRLConnection2;
                ((HttpURLConnection) uRLConnection).disconnect();
                ad.a(bufferedInputStream, bufferedOutputStream);
                throw th;
            }
            try {
                bufferedOutputStream = new BufferedOutputStream(outputStream, 8192);
                while (true) {
                    try {
                        int read = bufferedInputStream.read();
                        if (read == -1) {
                            break;
                        }
                        bufferedOutputStream.write(read);
                    } catch (IOException e3) {
                        e = e3;
                        uRLConnection = uRLConnection2;
                        ai.d("FRESHCHAT", "Failed to load URL " + str);
                        q.a(e);
                        if (uRLConnection != null && (uRLConnection instanceof HttpURLConnection)) {
                            ((HttpURLConnection) uRLConnection).disconnect();
                        }
                        ad.a(bufferedInputStream, bufferedOutputStream);
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        uRLConnection = uRLConnection2;
                        ((HttpURLConnection) uRLConnection).disconnect();
                        ad.a(bufferedInputStream, bufferedOutputStream);
                        throw th;
                    }
                }
                if (uRLConnection2 instanceof HttpURLConnection) {
                    ((HttpURLConnection) uRLConnection2).disconnect();
                }
                ad.a(bufferedInputStream, bufferedOutputStream);
                return true;
            } catch (IOException e4) {
                e = e4;
                bufferedOutputStream = null;
                uRLConnection = uRLConnection2;
                ai.d("FRESHCHAT", "Failed to load URL " + str);
                q.a(e);
                ((HttpURLConnection) uRLConnection).disconnect();
                ad.a(bufferedInputStream, bufferedOutputStream);
                return false;
            } catch (Throwable th4) {
                th = th4;
                bufferedOutputStream = null;
                uRLConnection = uRLConnection2;
                ((HttpURLConnection) uRLConnection).disconnect();
                ad.a(bufferedInputStream, bufferedOutputStream);
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            bufferedInputStream = null;
            bufferedOutputStream = null;
            ai.d("FRESHCHAT", "Failed to load URL " + str);
            q.a(e);
            ((HttpURLConnection) uRLConnection).disconnect();
            ad.a(bufferedInputStream, bufferedOutputStream);
            return false;
        } catch (Throwable th5) {
            th = th5;
            bufferedInputStream = null;
            bufferedOutputStream = null;
            ((HttpURLConnection) uRLConnection).disconnect();
            ad.a(bufferedInputStream, bufferedOutputStream);
            throw th;
        }
    }

    public Bitmap d(Object obj) {
        return bK(String.valueOf(obj));
    }

    public void fp() {
        super.fp();
        ka();
    }

    public void fr() {
        super.fr();
        synchronized (si) {
            if (sf != null && !sf.isClosed()) {
                try {
                    sf.delete();
                    ai.d("ImageFetcher", "HTTP cache cleared");
                } catch (IOException e2) {
                    q.a(e2);
                }
                sf = null;
                sh = true;
                ka();
            }
        }
    }

    public void fs() {
        super.fs();
        synchronized (si) {
            if (sf != null) {
                try {
                    sf.flush();
                    ai.d("ImageFetcher", "HTTP cache flushed");
                } catch (IOException e2) {
                    q.a(e2);
                }
            }
        }
    }

    public void ft() {
        super.ft();
        synchronized (si) {
            if (sf != null) {
                try {
                    if (!sf.isClosed()) {
                        sf.close();
                        sf = null;
                        ai.d("ImageFetcher", "HTTP cache closed");
                    }
                } catch (IOException e2) {
                    q.a(e2);
                }
            }
        }
    }
}
