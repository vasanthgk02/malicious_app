package com.appsflyer.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import com.appsflyer.AFLogger;
import com.appsflyer.deeplink.DeepLinkListener;
import com.appsflyer.deeplink.DeepLinkResult;
import com.appsflyer.deeplink.DeepLinkResult.Error;
import com.dylanvann.fastimage.FastImageSource;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.jboss.netty.handler.codec.http.HttpHeaders.Names;
import org.json.JSONException;
import org.json.JSONObject;

public final class f {
    public static volatile boolean AFInAppEventParameterName;
    public static final int AFInAppEventType = ((int) TimeUnit.SECONDS.toMillis(2));
    public static String[] AFKeystoreWrapper;
    public static String[] AFLogger$LogLevel;
    public static f AppsFlyer2dXConversionCallback;
    public static Intent valueOf;
    public String AFVersionDeclaration;
    public Map<String, String> getLevel;
    public List<List<String>> init = new ArrayList();
    public DeepLinkListener values;

    private Uri AFInAppEventParameterName(Object obj, Iterator<String> it) {
        while (obj != JSONObject.NULL) {
            if (!it.hasNext()) {
                Uri parse = Uri.parse(obj.toString());
                if (parse == null || parse.getScheme() == null || parse.getHost() == null) {
                    return null;
                }
                return parse;
            }
            try {
                obj = new JSONObject(obj.toString()).get(it.next());
            } catch (JSONException unused) {
                return null;
            }
        }
        return null;
    }

    public static Uri AFKeystoreWrapper(Intent intent) {
        if (intent == null || !"android.intent.action.VIEW".equals(intent.getAction())) {
            return null;
        }
        return intent.getData();
    }

    public static boolean values(String str) {
        if (AFKeystoreWrapper == null || str.contains("af_tranid=")) {
            return false;
        }
        StringBuilder sb = new StringBuilder("Validate if link ");
        sb.append(str);
        sb.append(" belongs to ESP domains: ");
        sb.append(Arrays.asList(AFKeystoreWrapper));
        AFLogger.AFKeystoreWrapper(sb.toString());
        try {
            return Arrays.asList(AFKeystoreWrapper).contains(new URL(str).getHost());
        } catch (MalformedURLException unused) {
            return false;
        }
    }

    public final void AFInAppEventType(final Context context, final Map<String, Object> map, final Uri uri) {
        if (values(uri.toString())) {
            AFInAppEventParameterName = true;
            if (k.values == null) {
                k.values = new k();
            }
            k kVar = k.values;
            if (kVar.valueOf == null) {
                kVar.valueOf = Executors.newSingleThreadScheduledExecutor(kVar.AFInAppEventType);
            }
            kVar.valueOf.execute(new Runnable() {
                public static Map<String, Object> AFInAppEventType(Uri uri) {
                    HashMap hashMap = new HashMap();
                    try {
                        StringBuilder sb = new StringBuilder("ESP deeplink resolving is started: ");
                        sb.append(uri.toString());
                        AFLogger.AFInAppEventParameterName(sb.toString());
                        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(uri.toString()).openConnection()));
                        httpURLConnection.setInstanceFollowRedirects(false);
                        httpURLConnection.setReadTimeout(f.AFInAppEventType);
                        httpURLConnection.setConnectTimeout(f.AFInAppEventType);
                        httpURLConnection.setRequestProperty("User-agent", "Dalvik/2.1.0 (Linux; U; Android 6.0.1; Nexus 5 Build/M4B30Z)");
                        httpURLConnection.setRequestProperty("af-esp", "6.5.4");
                        int responseCode = httpURLConnection.getResponseCode();
                        hashMap.put("status", Integer.valueOf(responseCode));
                        if (300 <= responseCode && responseCode <= 305) {
                            hashMap.put(FastImageSource.LOCAL_RESOURCE_SCHEME, httpURLConnection.getHeaderField(Names.LOCATION));
                        }
                        httpURLConnection.disconnect();
                        AFLogger.AFInAppEventParameterName("ESP deeplink resolving is finished");
                    } catch (Throwable th) {
                        hashMap.put("error", th.getLocalizedMessage());
                        AFLogger.valueOf(th.getMessage(), th);
                    }
                    return hashMap;
                }

                public final void run() {
                    String str;
                    Integer num;
                    String str2;
                    long currentTimeMillis = System.currentTimeMillis();
                    String obj = uri.toString();
                    ArrayList arrayList = new ArrayList();
                    Number number = null;
                    Object obj2 = null;
                    int i = 0;
                    while (true) {
                        if (i >= 5) {
                            break;
                        }
                        Map<String, Object> AFInAppEventType2 = AFInAppEventType(Uri.parse(obj));
                        str = (String) AFInAppEventType2.get(FastImageSource.LOCAL_RESOURCE_SCHEME);
                        num = (Integer) AFInAppEventType2.get("status");
                        str2 = (String) AFInAppEventType2.get("error");
                        if (str == null || !f.values(str)) {
                            Number number2 = num;
                            obj2 = str2;
                            obj = str;
                            number = number2;
                        } else {
                            if (i < 4) {
                                arrayList.add(str);
                            }
                            i++;
                            Number number3 = num;
                            obj2 = str2;
                            obj = str;
                            number = number3;
                        }
                    }
                    Number number22 = num;
                    obj2 = str2;
                    obj = str;
                    number = number22;
                    HashMap hashMap = new HashMap();
                    hashMap.put(FastImageSource.LOCAL_RESOURCE_SCHEME, obj != null ? obj : "");
                    hashMap.put("status", Integer.valueOf(number != null ? number.intValue() : -1));
                    if (obj2 != null) {
                        hashMap.put("error", obj2);
                    }
                    if (!arrayList.isEmpty()) {
                        hashMap.put("redirects", arrayList);
                    }
                    hashMap.put("latency", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    synchronized (map) {
                        map.put("af_deeplink_r", hashMap);
                        map.put("af_deeplink", uri.toString());
                    }
                    ac.AFInAppEventParameterName().AFInAppEventType(context, map, obj != null ? Uri.parse(obj) : uri);
                    f.AFInAppEventParameterName = false;
                }
            });
        } else {
            ac.AFInAppEventParameterName().AFInAppEventType(context, map, uri);
        }
        valueOf = null;
    }

    public static f valueOf() {
        if (AppsFlyer2dXConversionCallback == null) {
            AppsFlyer2dXConversionCallback = new f();
        }
        return AppsFlyer2dXConversionCallback;
    }

    public final void valueOf(Map<String, Object> map, cl clVar, Intent intent, bv bvVar, Context context) {
        Error error;
        SharedPreferences AFInAppEventType2 = ac.AFInAppEventType(context);
        if (!values(intent, context, map) && this.values != null && ac.AFInAppEventParameterName().valueOf(AFInAppEventType2, false) == 0 && !AFInAppEventType2.getBoolean("ddl_sent", false)) {
            ar arVar = new ar(context, clVar);
            AFLogger.AFInAppEventParameterName("[DDL] start");
            FutureTask futureTask = new FutureTask(new Callable<DeepLinkResult>() {
                public final /* synthetic */ Object call() throws Exception {
                    Application AFInAppEventType = ar.this.AFKeystoreWrapper;
                    ar.valueOf(ar.this);
                    ar.this.AFInAppEventParameterName(AFInAppEventType);
                    return ar.AFInAppEventType(ar.this, AFInAppEventType);
                }
            });
            new Thread(futureTask).start();
            try {
                DeepLinkResult deepLinkResult = (DeepLinkResult) futureTask.get(ar.onInstallConversionDataLoadedNative, TimeUnit.MILLISECONDS);
                arVar.onAppOpenAttributionNative.AFInAppEventType(deepLinkResult, ar.onInstallConversionDataLoadedNative);
                ao.AFInAppEventType(deepLinkResult);
            } catch (InterruptedException | ExecutionException e2) {
                AFLogger.AFInAppEventParameterName((String) "[DDL] Error occurred", e2);
                if (e2.getCause() instanceof IOException) {
                    error = Error.NETWORK;
                } else {
                    error = Error.UNEXPECTED;
                }
                DeepLinkResult deepLinkResult2 = new DeepLinkResult(null, error);
                arVar.onAppOpenAttributionNative.AFInAppEventType(deepLinkResult2, ar.onInstallConversionDataLoadedNative);
                ao.AFInAppEventType(deepLinkResult2);
            } catch (TimeoutException unused) {
                StringBuilder sb = new StringBuilder("[DDL] Timeout, didn't manage to find deferred deep link after ");
                sb.append(arVar.onAttributionFailureNative);
                sb.append(" attempt(s) within ");
                sb.append(ar.onInstallConversionDataLoadedNative);
                sb.append(" milliseconds");
                AFLogger.AFInAppEventParameterName(sb.toString());
                DeepLinkResult deepLinkResult3 = new DeepLinkResult(null, Error.TIMEOUT);
                arVar.onAppOpenAttributionNative.AFInAppEventType(deepLinkResult3, ar.onInstallConversionDataLoadedNative);
                ao.AFInAppEventType(deepLinkResult3);
            }
        }
        bvVar.AFInAppEventType((String) "ddl_sent", true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x006e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean values(android.content.Intent r9, android.content.Context r10, java.util.Map<java.lang.String, java.lang.Object> r11) {
        /*
            r8 = this;
            java.lang.String r0 = "android.intent.action.VIEW"
            r1 = 0
            if (r9 == 0) goto L_0x0014
            java.lang.String r2 = r9.getAction()
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0014
            android.net.Uri r2 = r9.getData()
            goto L_0x0015
        L_0x0014:
            r2 = r1
        L_0x0015:
            android.content.Intent r3 = valueOf
            if (r3 == 0) goto L_0x0028
            java.lang.String r4 = r3.getAction()
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0028
            android.net.Uri r0 = r3.getData()
            goto L_0x0029
        L_0x0028:
            r0 = r1
        L_0x0029:
            android.os.Bundle r3 = r9.getExtras()
            java.util.List<java.util.List<java.lang.String>> r4 = r8.init
            if (r4 == 0) goto L_0x008f
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x008f
            if (r3 != 0) goto L_0x003a
            goto L_0x008f
        L_0x003a:
            java.util.List<java.util.List<java.lang.String>> r4 = r8.init
            java.util.Iterator r4 = r4.iterator()
        L_0x0040:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x008f
            java.lang.Object r5 = r4.next()
            java.util.List r5 = (java.util.List) r5
            if (r5 != 0) goto L_0x0050
        L_0x004e:
            r6 = r1
            goto L_0x006c
        L_0x0050:
            java.util.Iterator r6 = r5.iterator()
            boolean r7 = r6.hasNext()
            if (r7 != 0) goto L_0x005b
            goto L_0x004e
        L_0x005b:
            java.lang.Object r7 = r6.next()
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r7 = r3.getString(r7)
            if (r7 != 0) goto L_0x0068
            goto L_0x004e
        L_0x0068:
            android.net.Uri r6 = r8.AFInAppEventParameterName(r7, r6)
        L_0x006c:
            if (r6 == 0) goto L_0x0040
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "Found deeplink in push payload at "
            r1.<init>(r3)
            java.lang.String r3 = r5.toString()
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.appsflyer.AFLogger.AFInAppEventParameterName(r1)
            java.util.Map r1 = com.appsflyer.internal.ac.AFInAppEventType(r11)
            java.util.List<java.util.List<java.lang.String>> r3 = r8.init
            java.lang.String r4 = "payloadKey"
            r1.put(r4, r3)
            r1 = r6
        L_0x008f:
            r3 = 1
            java.lang.String r4 = " w/af_consumed"
            r5 = 0
            java.lang.String r6 = "af_consumed"
            if (r2 == 0) goto L_0x00c1
            boolean r0 = r9.hasExtra(r6)
            if (r0 != 0) goto L_0x00a8
            long r0 = java.lang.System.currentTimeMillis()
            r9.putExtra(r6, r0)
            r8.AFInAppEventType(r10, r11, r2)
            return r3
        L_0x00a8:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "skipping re-use of previously consumed deep link: "
            r9.<init>(r10)
            java.lang.String r10 = r2.toString()
            r9.append(r10)
            r9.append(r4)
            java.lang.String r9 = r9.toString()
            com.appsflyer.AFLogger.values(r9)
            return r5
        L_0x00c1:
            if (r0 == 0) goto L_0x00f1
            android.content.Intent r9 = valueOf
            boolean r9 = r9.hasExtra(r6)
            if (r9 != 0) goto L_0x00d8
            android.content.Intent r9 = valueOf
            long r1 = java.lang.System.currentTimeMillis()
            r9.putExtra(r6, r1)
            r8.AFInAppEventType(r10, r11, r0)
            return r3
        L_0x00d8:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "skipping re-use of previously consumed trampoline deep link: "
            r9.<init>(r10)
            java.lang.String r10 = r0.toString()
            r9.append(r10)
            r9.append(r4)
            java.lang.String r9 = r9.toString()
            com.appsflyer.AFLogger.values(r9)
            return r5
        L_0x00f1:
            if (r1 == 0) goto L_0x011d
            boolean r0 = r9.hasExtra(r6)
            if (r0 != 0) goto L_0x0104
            long r4 = java.lang.System.currentTimeMillis()
            r9.putExtra(r6, r4)
            r8.AFInAppEventType(r10, r11, r1)
            return r3
        L_0x0104:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "skipping re-use of previously consumed deep link from push: "
            r9.<init>(r10)
            java.lang.String r10 = r1.toString()
            r9.append(r10)
            r9.append(r4)
            java.lang.String r9 = r9.toString()
            com.appsflyer.AFLogger.values(r9)
            return r5
        L_0x011d:
            java.lang.String r9 = "No deep link detected"
            com.appsflyer.AFLogger.AFInAppEventParameterName(r9)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.f.values(android.content.Intent, android.content.Context, java.util.Map):boolean");
    }
}
