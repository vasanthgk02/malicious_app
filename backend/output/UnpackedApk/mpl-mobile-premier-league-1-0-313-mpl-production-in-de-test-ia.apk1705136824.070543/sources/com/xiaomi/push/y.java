package com.xiaomi.push;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.razorpay.AnalyticsConstants;
import com.reactnativecommunity.webview.RNCWebViewManager;
import com.squareup.picasso.NetworkRequestHandler;
import com.xiaomi.mipush.sdk.Constants;
import in.juspay.hypersdk.core.InflateView;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import org.jboss.netty.handler.codec.http.HttpHeaders.Names;

public class y {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f4992a = Pattern.compile("([^\\s;]+)(.*)");

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f4993b = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f4994c = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    public static final class a extends FilterInputStream {

        /* renamed from: a  reason: collision with root package name */
        public boolean f4995a;

        public a(InputStream inputStream) {
            super(inputStream);
        }

        public int read(byte[] bArr, int i, int i2) {
            if (!this.f4995a) {
                int read = super.read(bArr, i, i2);
                if (read != -1) {
                    return read;
                }
            }
            this.f4995a = true;
            return -1;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f4996a;

        /* renamed from: a  reason: collision with other field name */
        public Map<String, String> f952a;

        public String toString() {
            return String.format("resCode = %1$d, headers = %2$s", new Object[]{Integer.valueOf(this.f4996a), this.f952a.toString()});
        }
    }

    public static int a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return -1;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return -1;
            }
            return activeNetworkInfo.getType();
        } catch (Exception unused) {
            return -1;
        }
    }

    /* JADX WARNING: type inference failed for: r8v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r8v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r8v3 */
    /* JADX WARNING: type inference failed for: r8v4 */
    /* JADX WARNING: type inference failed for: r8v5, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r8v10, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r8v11, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r8v12, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r8v14 */
    /* JADX WARNING: type inference failed for: r8v15, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r8v16 */
    /* JADX WARNING: type inference failed for: r8v17 */
    /* JADX WARNING: type inference failed for: r8v18 */
    /* JADX WARNING: type inference failed for: r8v19 */
    /* JADX WARNING: type inference failed for: r8v20 */
    /* JADX WARNING: type inference failed for: r8v21 */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x010a, code lost:
        r6 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x010b, code lost:
        r8 = 0;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00be */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r8v3
      assigns: []
      uses: []
      mth insns count: 111
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x010a A[ExcHandler: all (th java.lang.Throwable), Splitter:B:24:0x0082] */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.xiaomi.push.w a(android.content.Context r6, java.lang.String r7, java.lang.String r8, java.util.Map<java.lang.String, java.lang.String> r9, java.lang.String r10) {
        /*
            com.xiaomi.push.w r0 = new com.xiaomi.push.w
            r0.<init>()
            r1 = 0
            java.net.URL r2 = a(r7)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            java.net.HttpURLConnection r6 = a(r6, r2)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            r2 = 10000(0x2710, float:1.4013E-41)
            r6.setConnectTimeout(r2)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            r2 = 15000(0x3a98, float:2.102E-41)
            r6.setReadTimeout(r2)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            if (r8 != 0) goto L_0x001c
            java.lang.String r8 = "GET"
        L_0x001c:
            r6.setRequestMethod(r8)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            r8 = 0
            if (r9 == 0) goto L_0x004e
            java.lang.String r2 = "gzip"
            java.lang.String r3 = "Content-Encoding"
            java.lang.Object r3 = r9.get(r3)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            java.util.Set r3 = r9.keySet()     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ IOException -> 0x0116, all -> 0x010a }
        L_0x0038:
            boolean r4 = r3.hasNext()     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            if (r4 == 0) goto L_0x004f
            java.lang.Object r4 = r3.next()     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            java.lang.Object r5 = r9.get(r4)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            r6.setRequestProperty(r4, r5)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            goto L_0x0038
        L_0x004e:
            r2 = 0
        L_0x004f:
            boolean r9 = android.text.TextUtils.isEmpty(r10)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            r3 = 1
            if (r9 != 0) goto L_0x0082
            r6.setDoOutput(r3)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            byte[] r9 = r10.getBytes()     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            if (r2 == 0) goto L_0x0069
            java.util.zip.GZIPOutputStream r10 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            java.io.OutputStream r2 = r6.getOutputStream()     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            r10.<init>(r2)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            goto L_0x006d
        L_0x0069:
            java.io.OutputStream r10 = r6.getOutputStream()     // Catch:{ IOException -> 0x0116, all -> 0x010a }
        L_0x006d:
            int r2 = r9.length     // Catch:{ IOException -> 0x007d, all -> 0x0078 }
            r10.write(r9, r8, r2)     // Catch:{ IOException -> 0x007d, all -> 0x0078 }
            r10.flush()     // Catch:{ IOException -> 0x007d, all -> 0x0078 }
            r10.close()     // Catch:{ IOException -> 0x007d, all -> 0x0078 }
            goto L_0x0082
        L_0x0078:
            r6 = move-exception
            r8 = r1
            r1 = r10
            goto L_0x010c
        L_0x007d:
            r6 = move-exception
            r8 = r1
            r1 = r10
            goto L_0x0118
        L_0x0082:
            int r9 = r6.getResponseCode()     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            r0.f4991a = r9     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            r9.<init>()     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            java.lang.String r10 = "Http POST Response Code: "
            r9.append(r10)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            int r10 = r0.f4991a     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            r9.append(r10)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            java.lang.String r9 = r9.toString()     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            com.xiaomi.channel.commonutils.logger.b.a(r9)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
        L_0x009e:
            java.lang.String r9 = r6.getHeaderFieldKey(r8)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            java.lang.String r10 = r6.getHeaderField(r8)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            if (r9 != 0) goto L_0x0101
            if (r10 != 0) goto L_0x0101
            java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00be, all -> 0x010a }
            java.io.InputStreamReader r9 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00be, all -> 0x010a }
            com.xiaomi.push.y$a r10 = new com.xiaomi.push.y$a     // Catch:{ IOException -> 0x00be, all -> 0x010a }
            java.io.InputStream r2 = r6.getInputStream()     // Catch:{ IOException -> 0x00be, all -> 0x010a }
            r10.<init>(r2)     // Catch:{ IOException -> 0x00be, all -> 0x010a }
            r9.<init>(r10)     // Catch:{ IOException -> 0x00be, all -> 0x010a }
            r8.<init>(r9)     // Catch:{ IOException -> 0x00be, all -> 0x010a }
            goto L_0x00d1
        L_0x00be:
            java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            java.io.InputStreamReader r9 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            com.xiaomi.push.y$a r10 = new com.xiaomi.push.y$a     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            java.io.InputStream r6 = r6.getErrorStream()     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            r10.<init>(r6)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            r9.<init>(r10)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            r8.<init>(r9)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
        L_0x00d1:
            java.lang.String r6 = r8.readLine()     // Catch:{ IOException -> 0x00ff, all -> 0x00fd }
            java.lang.StringBuffer r9 = new java.lang.StringBuffer     // Catch:{ IOException -> 0x00ff, all -> 0x00fd }
            r9.<init>()     // Catch:{ IOException -> 0x00ff, all -> 0x00fd }
            java.lang.String r10 = "line.separator"
            java.lang.String r10 = java.lang.System.getProperty(r10)     // Catch:{ IOException -> 0x00ff, all -> 0x00fd }
        L_0x00e0:
            if (r6 == 0) goto L_0x00ed
            r9.append(r6)     // Catch:{ IOException -> 0x00ff, all -> 0x00fd }
            r9.append(r10)     // Catch:{ IOException -> 0x00ff, all -> 0x00fd }
            java.lang.String r6 = r8.readLine()     // Catch:{ IOException -> 0x00ff, all -> 0x00fd }
            goto L_0x00e0
        L_0x00ed:
            java.lang.String r6 = r9.toString()     // Catch:{ IOException -> 0x00ff, all -> 0x00fd }
            r0.f950a = r6     // Catch:{ IOException -> 0x00ff, all -> 0x00fd }
            r8.close()     // Catch:{ IOException -> 0x00ff, all -> 0x00fd }
            com.xiaomi.push.h.a(r1)
            com.xiaomi.push.h.a(r1)
            return r0
        L_0x00fd:
            r6 = move-exception
            goto L_0x010c
        L_0x00ff:
            r6 = move-exception
            goto L_0x0118
        L_0x0101:
            java.util.Map<java.lang.String, java.lang.String> r2 = r0.f951a     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            r2.put(r9, r10)     // Catch:{ IOException -> 0x0116, all -> 0x010a }
            int r8 = r8 + 1
            int r8 = r8 + r3
            goto L_0x009e
        L_0x010a:
            r6 = move-exception
            r8 = r1
        L_0x010c:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ all -> 0x013f }
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x013f }
            r7.<init>(r6)     // Catch:{ all -> 0x013f }
            throw r7     // Catch:{ all -> 0x013f }
        L_0x0116:
            r6 = move-exception
            r8 = r1
        L_0x0118:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ all -> 0x013f }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x013f }
            r10.<init>()     // Catch:{ all -> 0x013f }
            java.lang.String r0 = "err while request "
            r10.append(r0)     // Catch:{ all -> 0x013f }
            r10.append(r7)     // Catch:{ all -> 0x013f }
            java.lang.String r7 = ":"
            r10.append(r7)     // Catch:{ all -> 0x013f }
            java.lang.Class r6 = r6.getClass()     // Catch:{ all -> 0x013f }
            java.lang.String r6 = r6.getSimpleName()     // Catch:{ all -> 0x013f }
            r10.append(r6)     // Catch:{ all -> 0x013f }
            java.lang.String r6 = r10.toString()     // Catch:{ all -> 0x013f }
            r9.<init>(r6)     // Catch:{ all -> 0x013f }
            throw r9     // Catch:{ all -> 0x013f }
        L_0x013f:
            r6 = move-exception
            com.xiaomi.push.h.a(r1)
            com.xiaomi.push.h.a(r8)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.y.a(android.content.Context, java.lang.String, java.lang.String, java.util.Map, java.lang.String):com.xiaomi.push.w");
    }

    public static w a(Context context, String str, Map<String, String> map) {
        return a(context, str, (String) RNCWebViewManager.HTTP_METHOD_POST, (Map<String, String>) null, a(map));
    }

    public static InputStream a(Context context, URL url, boolean z, String str, String str2) {
        return a(context, url, z, str, str2, null, null);
    }

    public static InputStream a(Context context, URL url, boolean z, String str, String str2, Map<String, String> map, b bVar) {
        if (context == null) {
            throw new IllegalArgumentException("context");
        } else if (url != null) {
            URL url2 = !z ? new URL(a(url.toString())) : url;
            try {
                HttpURLConnection.setFollowRedirects(true);
                HttpURLConnection a2 = a(context, url2);
                a2.setConnectTimeout(10000);
                a2.setReadTimeout(15000);
                if (!TextUtils.isEmpty(str)) {
                    a2.setRequestProperty("User-Agent", str);
                }
                if (str2 != null) {
                    a2.setRequestProperty(Names.COOKIE, str2);
                }
                if (map != null) {
                    for (String next : map.keySet()) {
                        a2.setRequestProperty(next, map.get(next));
                    }
                }
                if (bVar != null && (url.getProtocol().equals(NetworkRequestHandler.SCHEME_HTTP) || url.getProtocol().equals(NetworkRequestHandler.SCHEME_HTTPS))) {
                    bVar.f4996a = a2.getResponseCode();
                    if (bVar.f952a == null) {
                        bVar.f952a = new HashMap();
                    }
                    int i = 0;
                    while (true) {
                        String headerFieldKey = a2.getHeaderFieldKey(i);
                        String headerField = a2.getHeaderField(i);
                        if (headerFieldKey == null && headerField == null) {
                            break;
                        }
                        if (!TextUtils.isEmpty(headerFieldKey)) {
                            if (!TextUtils.isEmpty(headerField)) {
                                bVar.f952a.put(headerFieldKey, headerField);
                            }
                        }
                        i++;
                    }
                }
                return new a(a2.getInputStream());
            } catch (IOException e2) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("IOException:");
                outline73.append(e2.getClass().getSimpleName());
                throw new IOException(outline73.toString());
            } catch (Throwable th) {
                throw new IOException(th.getMessage());
            }
        } else {
            throw new IllegalArgumentException("url");
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m879a(Context context) {
        if (d(context)) {
            return AnalyticsConstants.WIFI;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return "";
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "";
            }
            return (activeNetworkInfo.getTypeName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + activeNetworkInfo.getSubtypeName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + activeNetworkInfo.getExtraInfo()).toLowerCase();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String a(Context context, URL url) {
        return a(context, url, false, null, "UTF-8", null);
    }

    public static String a(Context context, URL url, boolean z, String str, String str2, String str3) {
        InputStream inputStream;
        try {
            inputStream = a(context, url, z, str, str3);
            try {
                StringBuilder sb = new StringBuilder(1024);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str2));
                char[] cArr = new char[4096];
                while (true) {
                    int read = bufferedReader.read(cArr);
                    if (-1 != read) {
                        sb.append(cArr, 0, read);
                    } else {
                        h.a((Closeable) inputStream);
                        return sb.toString();
                    }
                }
            } catch (Throwable th) {
                th = th;
                h.a((Closeable) inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            h.a((Closeable) inputStream);
            throw th;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        new String();
        return String.format("%s&key=%s", new Object[]{str, ac.a(String.format("%sbe988a6134bc8254465424e5a70ef037", new Object[]{str}))});
    }

    public static String a(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Entry next : map.entrySet()) {
            if (!(next.getKey() == null || next.getValue() == null)) {
                try {
                    stringBuffer.append(URLEncoder.encode((String) next.getKey(), "UTF-8"));
                    stringBuffer.append(InflateView.SETTER_EQUALS);
                    stringBuffer.append(URLEncoder.encode((String) next.getValue(), "UTF-8"));
                    stringBuffer.append("&");
                } catch (UnsupportedEncodingException e2) {
                    com.xiaomi.channel.commonutils.logger.b.a("Failed to convert from params map to string: " + e2);
                    com.xiaomi.channel.commonutils.logger.b.a("map: " + map.toString());
                    return null;
                }
            }
        }
        if (stringBuffer.length() > 0) {
            stringBuffer = stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    /* renamed from: a  reason: collision with other method in class */
    public static HttpURLConnection m880a(Context context, URL url) {
        boolean equals = NetworkRequestHandler.SCHEME_HTTP.equals(url.getProtocol());
        return (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
    }

    /* renamed from: a  reason: collision with other method in class */
    public static URL m881a(String str) {
        return new URL(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m882a(Context context) {
        return a(context) >= 0;
    }

    public static boolean b(Context context) {
        boolean z;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            if (VERSION.SDK_INT >= 23) {
                try {
                    NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                    if (networkCapabilities != null) {
                        z = networkCapabilities.hasCapability(16);
                    }
                } catch (Exception unused) {
                }
            } else {
                z = a(context);
            }
            return z && c(context);
        }
        z = false;
        if (z) {
            return false;
        }
    }

    public static boolean c(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            networkInfo = null;
        }
        return networkInfo != null && networkInfo.isConnected();
    }

    public static boolean d(Context context) {
        boolean z = false;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return false;
            }
            if (1 == activeNetworkInfo.getType()) {
                z = true;
            }
            return z;
        } catch (Exception unused) {
        }
    }
}
