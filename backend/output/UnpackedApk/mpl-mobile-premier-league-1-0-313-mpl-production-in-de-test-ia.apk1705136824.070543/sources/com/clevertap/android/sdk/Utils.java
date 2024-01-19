package com.clevertap.android.sdk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.task.Task;
import com.google.firebase.messaging.RemoteMessage;
import com.mpl.androidapp.updater.downloadmanager.utils.Constants;
import com.razorpay.AnalyticsConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class Utils {
    public static boolean haveVideoPlayerSupport;

    static {
        boolean z;
        Class<?> cls = null;
        try {
            Class<?> cls2 = Class.forName("com.google.android.exoplayer2.SimpleExoPlayer");
            Class<?> cls3 = Class.forName("com.google.android.exoplayer2.source.hls.HlsMediaSource");
            cls = Class.forName("com.google.android.exoplayer2.ui.PlayerView");
            Logger.d("ExoPlayer is present");
            z = true;
        } catch (Throwable unused) {
            Logger.d("ExoPlayer library files are missing!!!");
            Logger.d("Please add ExoPlayer dependencies to render InApp or Inbox messages playing video. For more information checkout CleverTap documentation.");
            if (cls != null) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("ExoPlayer classes not found ");
                outline73.append(cls.getName());
                Logger.d(outline73.toString());
            } else {
                Logger.d("ExoPlayer classes not found");
            }
            z = false;
        }
        haveVideoPlayerSupport = z;
    }

    public static boolean containsIgnoreCase(Collection<String> collection, String str) {
        if (!(collection == null || str == null)) {
            for (String equalsIgnoreCase : collection) {
                if (str.equalsIgnoreCase(equalsIgnoreCase)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static HashMap<String, Object> convertBundleObjectToHashMap(Bundle bundle) {
        HashMap<String, Object> hashMap = new HashMap<>();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj instanceof Bundle) {
                hashMap.putAll(convertBundleObjectToHashMap((Bundle) obj));
            } else {
                hashMap.put(str, bundle.get(str));
            }
        }
        return hashMap;
    }

    public static ArrayList<HashMap<String, Object>> convertJSONArrayOfJSONObjectsToArrayListOfHashMaps(JSONArray jSONArray) {
        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                arrayList.add(convertJSONObjectToHashMap(jSONArray.getJSONObject(i)));
            } catch (JSONException e2) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Could not convert JSONArray of JSONObjects to ArrayList of HashMaps - ");
                outline73.append(e2.getMessage());
                Logger.v(outline73.toString());
            }
        }
        return arrayList;
    }

    public static ArrayList<String> convertJSONArrayToArrayList(JSONArray jSONArray) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                arrayList.add(jSONArray.getString(i));
            } catch (JSONException e2) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Could not convert JSONArray to ArrayList - ");
                outline73.append(e2.getMessage());
                Logger.v(outline73.toString());
            }
        }
        return arrayList;
    }

    public static HashMap<String, Object> convertJSONObjectToHashMap(JSONObject jSONObject) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if (obj instanceof JSONObject) {
                    hashMap.putAll(convertJSONObjectToHashMap((JSONObject) obj));
                } else {
                    hashMap.put(next, jSONObject.get(next));
                }
            } catch (Throwable unused) {
            }
        }
        return hashMap;
    }

    public static Bitmap drawableToBitmap(Drawable drawable) throws NullPointerException {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static Bitmap getAppIcon(Context context) throws NullPointerException {
        try {
            Drawable applicationLogo = context.getPackageManager().getApplicationLogo(context.getApplicationInfo());
            if (applicationLogo != null) {
                return drawableToBitmap(applicationLogo);
            }
            throw new Exception("Logo is null");
        } catch (Exception e2) {
            e2.printStackTrace();
            return drawableToBitmap(context.getPackageManager().getApplicationIcon(context.getApplicationInfo()));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0069 A[SYNTHETIC, Splitter:B:18:0x0069] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0076 A[SYNTHETIC, Splitter:B:26:0x0076] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap getBitmapFromURL(java.lang.String r6) {
        /*
            java.lang.String r0 = "Couldn't close connection!"
            java.lang.String r1 = "///"
            java.lang.String r2 = "/"
            java.lang.String r6 = r6.replace(r1, r2)
            java.lang.String r1 = "//"
            java.lang.String r6 = r6.replace(r1, r2)
            java.lang.String r1 = "http:/"
            java.lang.String r2 = "http://"
            java.lang.String r6 = r6.replace(r1, r2)
            java.lang.String r1 = "https:/"
            java.lang.String r2 = "https://"
            java.lang.String r6 = r6.replace(r1, r2)
            r1 = 0
            java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x004e, all -> 0x004c }
            r2.<init>(r6)     // Catch:{ IOException -> 0x004e, all -> 0x004c }
            java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x004e, all -> 0x004c }
            java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch:{ IOException -> 0x004e, all -> 0x004c }
            java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch:{ IOException -> 0x004e, all -> 0x004c }
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x004e, all -> 0x004c }
            r3 = 1
            r2.setDoInput(r3)     // Catch:{ IOException -> 0x004a }
            r2.connect()     // Catch:{ IOException -> 0x004a }
            java.io.InputStream r3 = r2.getInputStream()     // Catch:{ IOException -> 0x004a }
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeStream(r3)     // Catch:{ IOException -> 0x004a }
            r2.disconnect()     // Catch:{ all -> 0x0045 }
            goto L_0x0049
        L_0x0045:
            r1 = move-exception
            com.clevertap.android.sdk.Logger.v(r0, r1)
        L_0x0049:
            return r6
        L_0x004a:
            r3 = move-exception
            goto L_0x0050
        L_0x004c:
            r6 = move-exception
            goto L_0x0074
        L_0x004e:
            r3 = move-exception
            r2 = r1
        L_0x0050:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0072 }
            r4.<init>()     // Catch:{ all -> 0x0072 }
            java.lang.String r5 = "Couldn't download the notification icon. URL was: "
            r4.append(r5)     // Catch:{ all -> 0x0072 }
            r4.append(r6)     // Catch:{ all -> 0x0072 }
            java.lang.String r6 = r4.toString()     // Catch:{ all -> 0x0072 }
            com.clevertap.android.sdk.Logger.v(r6)     // Catch:{ all -> 0x0072 }
            r3.printStackTrace()     // Catch:{ all -> 0x0072 }
            if (r2 == 0) goto L_0x0071
            r2.disconnect()     // Catch:{ all -> 0x006d }
            goto L_0x0071
        L_0x006d:
            r6 = move-exception
            com.clevertap.android.sdk.Logger.v(r0, r6)
        L_0x0071:
            return r1
        L_0x0072:
            r6 = move-exception
            r1 = r2
        L_0x0074:
            if (r1 == 0) goto L_0x007e
            r1.disconnect()     // Catch:{ all -> 0x007a }
            goto L_0x007e
        L_0x007a:
            r1 = move-exception
            com.clevertap.android.sdk.Logger.v(r0, r1)
        L_0x007e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.Utils.getBitmapFromURL(java.lang.String):android.graphics.Bitmap");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        com.clevertap.android.sdk.Logger.v("Error processing image bytes from url: " + r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006f, code lost:
        if (r2 != null) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r2.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0075, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0076, code lost:
        com.clevertap.android.sdk.Logger.v((java.lang.String) "Couldn't close connection!", r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0079, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007a, code lost:
        r8 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007b, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x005b */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007e A[SYNTHETIC, Splitter:B:28:0x007e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] getByteArrayFromImageURL(java.lang.String r8) {
        /*
            java.lang.String r0 = "Couldn't close connection!"
            java.lang.String r1 = "///"
            java.lang.String r2 = "/"
            java.lang.String r8 = r8.replace(r1, r2)
            java.lang.String r1 = "//"
            java.lang.String r8 = r8.replace(r1, r2)
            java.lang.String r1 = "http:/"
            java.lang.String r2 = "http://"
            java.lang.String r8 = r8.replace(r1, r2)
            java.lang.String r1 = "https:/"
            java.lang.String r2 = "https://"
            java.lang.String r8 = r8.replace(r1, r2)
            r1 = 0
            java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            r2.<init>(r8)     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            javax.net.ssl.HttpsURLConnection r2 = (javax.net.ssl.HttpsURLConnection) r2     // Catch:{ IOException -> 0x005a, all -> 0x0058 }
            java.io.InputStream r3 = r2.getInputStream()     // Catch:{ IOException -> 0x005b }
            r4 = 8192(0x2000, float:1.148E-41)
            byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x005b }
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x005b }
            r5.<init>()     // Catch:{ IOException -> 0x005b }
        L_0x003f:
            int r6 = r3.read(r4)     // Catch:{ IOException -> 0x005b }
            r7 = -1
            if (r6 == r7) goto L_0x004b
            r7 = 0
            r5.write(r4, r7, r6)     // Catch:{ IOException -> 0x005b }
            goto L_0x003f
        L_0x004b:
            byte[] r8 = r5.toByteArray()     // Catch:{ IOException -> 0x005b }
            r2.disconnect()     // Catch:{ all -> 0x0053 }
            goto L_0x0057
        L_0x0053:
            r1 = move-exception
            com.clevertap.android.sdk.Logger.v(r0, r1)
        L_0x0057:
            return r8
        L_0x0058:
            r8 = move-exception
            goto L_0x007c
        L_0x005a:
            r2 = r1
        L_0x005b:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x007a }
            r3.<init>()     // Catch:{ all -> 0x007a }
            java.lang.String r4 = "Error processing image bytes from url: "
            r3.append(r4)     // Catch:{ all -> 0x007a }
            r3.append(r8)     // Catch:{ all -> 0x007a }
            java.lang.String r8 = r3.toString()     // Catch:{ all -> 0x007a }
            com.clevertap.android.sdk.Logger.v(r8)     // Catch:{ all -> 0x007a }
            if (r2 == 0) goto L_0x0079
            r2.disconnect()     // Catch:{ all -> 0x0075 }
            goto L_0x0079
        L_0x0075:
            r8 = move-exception
            com.clevertap.android.sdk.Logger.v(r0, r8)
        L_0x0079:
            return r1
        L_0x007a:
            r8 = move-exception
            r1 = r2
        L_0x007c:
            if (r1 == 0) goto L_0x0086
            r1.disconnect()     // Catch:{ all -> 0x0082 }
            goto L_0x0086
        L_0x0082:
            r1 = move-exception
            com.clevertap.android.sdk.Logger.v(r0, r1)
        L_0x0086:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.Utils.getByteArrayFromImageURL(java.lang.String):byte[]");
    }

    @SuppressLint({"MissingPermission"})
    public static String getCurrentNetworkType(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return "Unavailable";
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo == null || !networkInfo.isConnected()) {
                return getDeviceNetworkType(context);
            }
            return "WiFi";
        } catch (Throwable unused) {
            return "Unavailable";
        }
    }

    @SuppressLint({"MissingPermission"})
    public static String getDeviceNetworkType(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return "Unavailable";
        }
        int i = 0;
        if (VERSION.SDK_INT < 30) {
            i = telephonyManager.getNetworkType();
        } else if (hasPermission(context, "android.permission.READ_PHONE_STATE")) {
            try {
                i = telephonyManager.getDataNetworkType();
            } catch (SecurityException e2) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Security Exception caught while fetch network type");
                outline73.append(e2.getMessage());
                Logger.d(outline73.toString());
            }
        } else {
            Logger.d("READ_PHONE_STATE permission not asked by the app or not granted by the user");
        }
        if (i == 20) {
            return "5G";
        }
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return AnalyticsConstants.NETWORK_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return AnalyticsConstants.NETWORK_3G;
            case 13:
                return AnalyticsConstants.NETWORK_4G;
            default:
                return Constants.DOWNLOAD_STATUS_UNKNOWN;
        }
    }

    public static long getMemoryConsumption() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    public static Bitmap getNotificationBitmap(String str, boolean z, Context context) throws NullPointerException {
        return getNotificationBitmapWithSizeConstraints(str, z, context, -1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00e3, code lost:
        com.clevertap.android.sdk.Logger.v("Image size is larger than " + r1 + " bytes. Cancelling download!");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        r5.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0101, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0102, code lost:
        r2 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0123, code lost:
        r16 = r3;
        r1 = new byte[16384];
        com.clevertap.android.sdk.Logger.v("Total download size for bitmap = " + r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x013d, code lost:
        if (r0 == false) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x013f, code lost:
        r0 = new java.io.ByteArrayInputStream(r11.toByteArray());
        r2 = new java.io.ByteArrayOutputStream();
        r3 = new java.util.zip.GZIPInputStream(r0);
        r12 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0154, code lost:
        r0 = r3.read(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0159, code lost:
        if (r0 == -1) goto L_0x0162;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x015b, code lost:
        r12 = r12 + ((long) r0);
        r2.write(r1, 0, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0162, code lost:
        com.clevertap.android.sdk.Logger.v("Total decompressed download size for bitmap = " + r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x017a, code lost:
        if (r6 == -1) goto L_0x0197;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x017e, code lost:
        if (r6 == r14) goto L_0x0197;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0180, code lost:
        com.clevertap.android.sdk.Logger.d("File not loaded completely not going forward. URL was: " + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        r5.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        r1 = android.graphics.BitmapFactory.decodeByteArray(r2.toByteArray(), 0, (int) r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        r5.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01a9, code lost:
        if (r6 == -1) goto L_0x01c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01ad, code lost:
        if (r6 == r14) goto L_0x01c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        com.clevertap.android.sdk.Logger.d("File not loaded completely not going forward. URL was: " + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        r5.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        r1 = android.graphics.BitmapFactory.decodeByteArray(r11.toByteArray(), 0, (int) r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        r5.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01d4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01d5, code lost:
        com.clevertap.android.sdk.Logger.v(r16, r0);
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0224 A[SYNTHETIC, Splitter:B:105:0x0224] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x020b A[SYNTHETIC, Splitter:B:93:0x020b] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0217  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:70:0x01c5=Splitter:B:70:0x01c5, B:58:0x0197=Splitter:B:58:0x0197} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap getNotificationBitmapWithSizeConstraints(java.lang.String r16, boolean r17, android.content.Context r18, int r19) throws java.lang.NullPointerException {
        /*
            r0 = r16
            r1 = r19
            if (r0 == 0) goto L_0x022e
            java.lang.String r2 = ""
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0010
            goto L_0x022e
        L_0x0010:
            java.lang.String r2 = "http"
            boolean r2 = r0.startsWith(r2)
            if (r2 != 0) goto L_0x001e
            java.lang.String r2 = "http://static.wizrocket.com/android/ico//"
            java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline50(r2, r0)
        L_0x001e:
            r2 = -1
            if (r1 != r2) goto L_0x0027
            android.graphics.Bitmap r0 = getBitmapFromURL(r0)
            goto L_0x0214
        L_0x0027:
            java.lang.String r3 = "Couldn't close connection!"
            java.lang.String r4 = "/"
            java.lang.String r5 = "///"
            java.lang.String r0 = r0.replace(r5, r4)
            java.lang.String r5 = "//"
            java.lang.String r0 = r0.replace(r5, r4)
            java.lang.String r4 = "http:/"
            java.lang.String r5 = "http://"
            java.lang.String r0 = r0.replace(r4, r5)
            java.lang.String r4 = "https:/"
            java.lang.String r5 = "https://"
            java.lang.String r4 = r0.replace(r4, r5)
            java.net.URL r0 = new java.net.URL     // Catch:{ IOException -> 0x01ee, all -> 0x01e9 }
            r0.<init>(r4)     // Catch:{ IOException -> 0x01ee, all -> 0x01e9 }
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ IOException -> 0x01ee, all -> 0x01e9 }
            java.lang.Object r0 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r0)     // Catch:{ IOException -> 0x01ee, all -> 0x01e9 }
            java.net.URLConnection r0 = (java.net.URLConnection) r0     // Catch:{ IOException -> 0x01ee, all -> 0x01e9 }
            r5 = r0
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ IOException -> 0x01ee, all -> 0x01e9 }
            r0 = 1
            r5.setDoInput(r0)     // Catch:{ IOException -> 0x01e6, all -> 0x01e3 }
            r5.setUseCaches(r0)     // Catch:{ IOException -> 0x01e6, all -> 0x01e3 }
            java.lang.String r6 = "Accept-Encoding"
            java.lang.String r7 = "gzip, deflate"
            r5.addRequestProperty(r6, r7)     // Catch:{ IOException -> 0x01e6, all -> 0x01e3 }
            r5.connect()     // Catch:{ IOException -> 0x01e6, all -> 0x01e3 }
            int r6 = r5.getResponseCode()     // Catch:{ IOException -> 0x01e6, all -> 0x01e3 }
            r7 = 200(0xc8, float:2.8E-43)
            java.lang.String r8 = "File not loaded completely not going forward. URL was: "
            if (r6 == r7) goto L_0x008f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01e6, all -> 0x01e3 }
            r0.<init>()     // Catch:{ IOException -> 0x01e6, all -> 0x01e3 }
            r0.append(r8)     // Catch:{ IOException -> 0x01e6, all -> 0x01e3 }
            r0.append(r4)     // Catch:{ IOException -> 0x01e6, all -> 0x01e3 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x01e6, all -> 0x01e3 }
            com.clevertap.android.sdk.Logger.d(r0)     // Catch:{ IOException -> 0x01e6, all -> 0x01e3 }
            r5.disconnect()     // Catch:{ all -> 0x008b }
            goto L_0x0213
        L_0x008b:
            r0 = move-exception
            r2 = r3
            goto L_0x0210
        L_0x008f:
            int r6 = r5.getContentLength()     // Catch:{ IOException -> 0x01e6, all -> 0x01e3 }
            long r6 = (long) r6     // Catch:{ IOException -> 0x01e6, all -> 0x01e3 }
            java.lang.String r9 = r5.getContentEncoding()     // Catch:{ IOException -> 0x01e6, all -> 0x01e3 }
            if (r9 == 0) goto L_0x00a7
            java.lang.String r9 = r5.getContentEncoding()     // Catch:{ IOException -> 0x01e6, all -> 0x01e3 }
            java.lang.String r10 = "gzip"
            boolean r9 = r9.contains(r10)     // Catch:{ IOException -> 0x01e6, all -> 0x01e3 }
            if (r9 == 0) goto L_0x00a7
            goto L_0x00a8
        L_0x00a7:
            r0 = 0
        L_0x00a8:
            java.io.InputStream r9 = r5.getInputStream()     // Catch:{ IOException -> 0x01e6, all -> 0x01e3 }
            r10 = 16384(0x4000, float:2.2959E-41)
            byte[] r10 = new byte[r10]     // Catch:{ IOException -> 0x01e6, all -> 0x01e3 }
            java.io.ByteArrayOutputStream r11 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x01e6, all -> 0x01e3 }
            r11.<init>()     // Catch:{ IOException -> 0x01e6, all -> 0x01e3 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01e6, all -> 0x01e3 }
            r12.<init>()     // Catch:{ IOException -> 0x01e6, all -> 0x01e3 }
            java.lang.String r13 = "Downloading "
            r12.append(r13)     // Catch:{ IOException -> 0x01e6, all -> 0x01e3 }
            r12.append(r4)     // Catch:{ IOException -> 0x01e6, all -> 0x01e3 }
            java.lang.String r13 = "...."
            r12.append(r13)     // Catch:{ IOException -> 0x01e6, all -> 0x01e3 }
            java.lang.String r12 = r12.toString()     // Catch:{ IOException -> 0x01e6, all -> 0x01e3 }
            com.clevertap.android.sdk.Logger.v(r12)     // Catch:{ IOException -> 0x01e6, all -> 0x01e3 }
            r14 = 0
        L_0x00d0:
            int r12 = r9.read(r10)     // Catch:{ IOException -> 0x01e6, all -> 0x01e3 }
            if (r12 == r2) goto L_0x0123
            r16 = r3
            long r2 = (long) r12
            long r14 = r14 + r2
            r2 = 0
            r11.write(r10, r2, r12)     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            long r2 = (long) r1     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            int r12 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r12 <= 0) goto L_0x0106
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            r0.<init>()     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            java.lang.String r2 = "Image size is larger than "
            r0.append(r2)     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            r0.append(r1)     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            java.lang.String r1 = " bytes. Cancelling download!"
            r0.append(r1)     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            com.clevertap.android.sdk.Logger.v(r0)     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            r5.disconnect()     // Catch:{ all -> 0x0101 }
            goto L_0x0213
        L_0x0101:
            r0 = move-exception
            r2 = r16
            goto L_0x0210
        L_0x0106:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            r2.<init>()     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            java.lang.String r3 = "Downloaded "
            r2.append(r3)     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            r2.append(r14)     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            java.lang.String r3 = " bytes"
            r2.append(r3)     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            com.clevertap.android.sdk.Logger.v(r2)     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            r2 = -1
            r3 = r16
            goto L_0x00d0
        L_0x0123:
            r16 = r3
            r1 = 16384(0x4000, float:2.2959E-41)
            byte[] r1 = new byte[r1]     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            r2.<init>()     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            java.lang.String r3 = "Total download size for bitmap = "
            r2.append(r3)     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            r2.append(r14)     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            com.clevertap.android.sdk.Logger.v(r2)     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            if (r0 == 0) goto L_0x01a5
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            byte[] r2 = r11.toByteArray()     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            r0.<init>(r2)     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            r2.<init>()     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            java.util.zip.GZIPInputStream r3 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            r3.<init>(r0)     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            r12 = 0
        L_0x0154:
            int r0 = r3.read(r1)     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            r9 = -1
            if (r0 == r9) goto L_0x0162
            long r9 = (long) r0     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            long r12 = r12 + r9
            r9 = 0
            r2.write(r1, r9, r0)     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            goto L_0x0154
        L_0x0162:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            r0.<init>()     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            java.lang.String r1 = "Total decompressed download size for bitmap = "
            r0.append(r1)     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            r0.append(r12)     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            com.clevertap.android.sdk.Logger.v(r0)     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            r0 = -1
            int r3 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r3 == 0) goto L_0x0197
            int r0 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x0197
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            r0.<init>()     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            r0.append(r8)     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            r0.append(r4)     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            com.clevertap.android.sdk.Logger.d(r0)     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            r5.disconnect()     // Catch:{ all -> 0x0101 }
            goto L_0x0213
        L_0x0197:
            byte[] r0 = r2.toByteArray()     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            int r1 = (int) r12     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            r2 = 0
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeByteArray(r0, r2, r1)     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            r5.disconnect()     // Catch:{ all -> 0x01d4 }
            goto L_0x01d2
        L_0x01a5:
            r0 = -1
            int r2 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r2 == 0) goto L_0x01c5
            int r0 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x01c5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            r0.<init>()     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            r0.append(r8)     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            r0.append(r4)     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            com.clevertap.android.sdk.Logger.d(r0)     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            r5.disconnect()     // Catch:{ all -> 0x0101 }
            goto L_0x0213
        L_0x01c5:
            byte[] r0 = r11.toByteArray()     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            int r1 = (int) r14     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            r2 = 0
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeByteArray(r0, r2, r1)     // Catch:{ IOException -> 0x01df, all -> 0x01db }
            r5.disconnect()     // Catch:{ all -> 0x01d4 }
        L_0x01d2:
            r0 = r1
            goto L_0x0214
        L_0x01d4:
            r0 = move-exception
            r2 = r16
            com.clevertap.android.sdk.Logger.v(r2, r0)
            goto L_0x01d2
        L_0x01db:
            r0 = move-exception
            r2 = r16
            goto L_0x01ec
        L_0x01df:
            r0 = move-exception
            r2 = r16
            goto L_0x01f2
        L_0x01e3:
            r0 = move-exception
            r2 = r3
            goto L_0x01ec
        L_0x01e6:
            r0 = move-exception
            r2 = r3
            goto L_0x01f2
        L_0x01e9:
            r0 = move-exception
            r2 = r3
            r5 = 0
        L_0x01ec:
            r1 = r0
            goto L_0x0222
        L_0x01ee:
            r0 = move-exception
            r2 = r3
            r1 = 0
            r5 = r1
        L_0x01f2:
            r0.printStackTrace()     // Catch:{ all -> 0x0220 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0220 }
            r0.<init>()     // Catch:{ all -> 0x0220 }
            java.lang.String r1 = "Couldn't download the file. URL was: "
            r0.append(r1)     // Catch:{ all -> 0x0220 }
            r0.append(r4)     // Catch:{ all -> 0x0220 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0220 }
            com.clevertap.android.sdk.Logger.v(r0)     // Catch:{ all -> 0x0220 }
            if (r5 == 0) goto L_0x0213
            r5.disconnect()     // Catch:{ all -> 0x020f }
            goto L_0x0213
        L_0x020f:
            r0 = move-exception
        L_0x0210:
            com.clevertap.android.sdk.Logger.v(r2, r0)
        L_0x0213:
            r0 = 0
        L_0x0214:
            if (r0 == 0) goto L_0x0217
            goto L_0x021f
        L_0x0217:
            if (r17 == 0) goto L_0x021e
            android.graphics.Bitmap r0 = getAppIcon(r18)
            goto L_0x021f
        L_0x021e:
            r0 = 0
        L_0x021f:
            return r0
        L_0x0220:
            r0 = move-exception
            goto L_0x01ec
        L_0x0222:
            if (r5 == 0) goto L_0x022d
            r5.disconnect()     // Catch:{ all -> 0x0228 }
            goto L_0x022d
        L_0x0228:
            r0 = move-exception
            r3 = r0
            com.clevertap.android.sdk.Logger.v(r2, r3)
        L_0x022d:
            throw r1
        L_0x022e:
            if (r17 == 0) goto L_0x0235
            android.graphics.Bitmap r0 = getAppIcon(r18)
            goto L_0x0236
        L_0x0235:
            r0 = 0
        L_0x0236:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.Utils.getNotificationBitmapWithSizeConstraints(java.lang.String, boolean, android.content.Context, int):android.graphics.Bitmap");
    }

    public static Bitmap getNotificationBitmapWithTimeoutAndSize(String str, boolean z, Context context, CleverTapInstanceConfig cleverTapInstanceConfig, long j, int i) throws NullPointerException {
        Exception e2;
        Future future;
        Task ioTask = CTExecutorFactory.executors(cleverTapInstanceConfig).ioTask();
        $$Lambda$Utils$iUQCAbz8w1WFRgT_vJOVt9tUxz4 r0 = new Callable(str, z, context, i) {
            public final /* synthetic */ String f$0;
            public final /* synthetic */ boolean f$1;
            public final /* synthetic */ Context f$2;
            public final /* synthetic */ int f$3;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final Object call() {
                return Utils.getNotificationBitmapWithSizeConstraints(this.f$0, this.f$1, this.f$2, this.f$3);
            }
        };
        Executor executor = ioTask.executor;
        if (executor instanceof ExecutorService) {
            Object obj = null;
            try {
                future = ((ExecutorService) executor).submit(r0);
                try {
                    obj = future.get(j, TimeUnit.MILLISECONDS);
                } catch (Exception e3) {
                    e2 = e3;
                    e2.printStackTrace();
                    if (future != null && !future.isCancelled()) {
                        future.cancel(true);
                    }
                    Logger.v("submitAndGetResult :: " + "getNotificationBitmap" + " task timed out");
                    return (Bitmap) obj;
                }
            } catch (Exception e4) {
                e2 = e4;
                future = null;
                e2.printStackTrace();
                future.cancel(true);
                Logger.v("submitAndGetResult :: " + "getNotificationBitmap" + " task timed out");
                return (Bitmap) obj;
            }
            return (Bitmap) obj;
        }
        throw new UnsupportedOperationException("Can't use this method without ExecutorService, Use Execute alternatively ");
    }

    public static int getNow() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    public static int getThumbnailImage(Context context, String str) {
        if (context != null) {
            return context.getResources().getIdentifier(str, "drawable", context.getPackageName());
        }
        return -1;
    }

    public static boolean hasPermission(Context context, String str) {
        try {
            if (ContextCompat.checkSelfPermission(context, str) == 0) {
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean isActivityDead(Activity activity) {
        boolean z = true;
        if (activity == null) {
            return true;
        }
        if (!activity.isFinishing() && !activity.isDestroyed()) {
            z = false;
        }
        return z;
    }

    public static boolean isRenderFallback(RemoteMessage remoteMessage) {
        return !Boolean.parseBoolean(remoteMessage.getData().get("wzrk_tsr_fb")) && Boolean.parseBoolean(remoteMessage.getData().get("wzrk_fallback"));
    }

    public static boolean isServiceAvailable(Context context, Class cls) {
        if (cls == null) {
            return false;
        }
        try {
            for (ServiceInfo serviceInfo : context.getPackageManager().getPackageInfo(context.getPackageName(), 4).services) {
                if (serviceInfo.name.equals(cls.getName())) {
                    Logger.v("Service " + serviceInfo.name + " found");
                    return true;
                }
            }
        } catch (NameNotFoundException e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Intent Service name not found exception - ");
            outline73.append(e2.getLocalizedMessage());
            Logger.d(outline73.toString());
        }
        return false;
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    public static void setPackageNameFromResolveInfoList(Context context, Intent intent) {
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities != null) {
            String packageName = context.getPackageName();
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                if (packageName.equals(resolveInfo.activityInfo.packageName)) {
                    intent.setPackage(packageName);
                    return;
                }
            }
        }
    }

    public static Bundle stringToBundle(String str) throws JSONException {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle.putString(next, jSONObject.getString(next));
            }
        }
        return bundle;
    }

    public static boolean validateCTID(String str) {
        if (str == null) {
            Logger.i("CLEVERTAP_USE_CUSTOM_ID has been set as 1 in AndroidManifest.xml but custom CleverTap ID passed is NULL.");
            return false;
        } else if (str.isEmpty()) {
            Logger.i("CLEVERTAP_USE_CUSTOM_ID has been set as 1 in AndroidManifest.xml but custom CleverTap ID passed is empty.");
            return false;
        } else if (str.length() > 64) {
            Logger.i("Custom CleverTap ID passed is greater than 64 characters. ");
            return false;
        } else if (str.matches("[A-Za-z0-9()!:$@_-]*")) {
            return true;
        } else {
            Logger.i("Custom CleverTap ID cannot contain special characters apart from :,(,),_,!,@,$ and - ");
            return false;
        }
    }
}
