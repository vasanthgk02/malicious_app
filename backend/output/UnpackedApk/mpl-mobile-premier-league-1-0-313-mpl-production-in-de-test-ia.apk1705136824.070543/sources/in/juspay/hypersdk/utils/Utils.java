package in.juspay.hypersdk.utils;

import a.a.a.a.d.b;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Base64;
import androidx.annotation.Keep;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import in.juspay.hypersdk.core.InflateView;
import in.juspay.hypersdk.core.JuspayLogger;
import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.core.Labels.System;
import in.juspay.hypersdk.services.SdkConfigService;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.zip.GZIPOutputStream;
import org.apache.pdfbox.filter.ASCII85InputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utils {
    public static final char[] CHARACTER_SET = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', ASCII85InputStream.PADDING_U, 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_', '.', ASCII85InputStream.TERMINATOR};
    public static final int LENGTH = 128;
    public static final String LOG_TAG = "Utils";

    public static String base64UrlEncode(byte[] bArr) {
        return Base64.encodeToString(bArr, 0).split(InflateView.SETTER_EQUALS)[0].replace('+', '-').replace('/', '_');
    }

    public static boolean checkIfGranted(JuspayServices juspayServices, String str) {
        Context context = juspayServices.getContext();
        boolean z = true;
        if (VERSION.SDK_INT >= 23) {
            if (b.checkSelfPermission(context, str) != 0) {
                z = false;
            }
            return z;
        }
        try {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                return true;
            }
            juspayServices.sdkDebug(LOG_TAG, "permissions not found:" + str);
            return false;
        } catch (Throwable th) {
            juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, "action", "system", System.UTIL, GeneratedOutlineSupport.outline52("Exception trying to fetch permission info: ", str, " returning FALSE"), th);
            return false;
        }
    }

    public static boolean contains(JSONArray jSONArray, Object obj) {
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                if (jSONArray.get(i).equals(obj)) {
                    return true;
                }
                i++;
            } catch (JSONException unused) {
            }
        }
        return false;
    }

    public static JSONArray defaultNonNull(JSONArray jSONArray) {
        return jSONArray == null ? new JSONArray() : jSONArray;
    }

    public static JSONObject defaultNonNull(JSONObject jSONObject) {
        return jSONObject == null ? new JSONObject() : jSONObject;
    }

    @Keep
    public static void deleteRecursive(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                for (File deleteRecursive : file.listFiles()) {
                    deleteRecursive(deleteRecursive);
                }
            }
            file.delete();
        }
    }

    public static String generateCodeChallenge(String str) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException unused) {
            messageDigest = null;
        }
        return base64UrlEncode(messageDigest.digest(str.getBytes(Charset.defaultCharset())));
    }

    public static String getCodeVerifier() {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 128; i++) {
            char[] cArr = CHARACTER_SET;
            sb.append(cArr[secureRandom.nextInt(cArr.length)]);
        }
        return sb.toString();
    }

    public static String getIPAddress(JuspayServices juspayServices) {
        try {
            for (T inetAddresses : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                Iterator<T> it = Collections.list(inetAddresses.getInetAddresses()).iterator();
                while (true) {
                    if (it.hasNext()) {
                        InetAddress inetAddress = (InetAddress) it.next();
                        if (!inetAddress.isLoopbackAddress()) {
                            String upperCase = inetAddress.getHostAddress().toUpperCase();
                            if (isIPv4Address(upperCase)) {
                                return upperCase;
                            }
                        }
                    }
                }
            }
        } catch (Exception e2) {
            juspayServices.getSdkTracker().trackException("action", "system", System.UTIL, "Failed to Retreive IP address", e2);
        }
        return "";
    }

    public static String getLogLevelFromThrowable(Throwable th) {
        return th instanceof Error ? "critical" : th instanceof Exception ? "error" : "warning";
    }

    public static MemoryInfo getMemoryInfo(Context context) {
        try {
            MemoryInfo memoryInfo = new MemoryInfo();
            ActivityManager activityManager = context != null ? (ActivityManager) context.getSystemService("activity") : null;
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static byte[] gzipContent(byte[] bArr) {
        GZIPOutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        try {
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            JuspayLogger.d(LOG_TAG, "Gzipping complete");
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
        throw th;
    }

    public static <T> boolean includes(JSONArray jSONArray, T t) {
        if (jSONArray == null) {
            return false;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            if (t.equals(jSONArray.opt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isIPv4Address(String str) {
        String[] split = str.split("\\.");
        if (split.length != 4) {
            return false;
        }
        int length = split.length;
        int i = 0;
        while (i < length) {
            try {
                int parseInt = Integer.parseInt(split[i]);
                if (parseInt >= 0 && parseInt <= 255) {
                    i++;
                }
            } catch (NumberFormatException unused) {
            }
            return false;
        }
        return true;
    }

    public static boolean isUiFeatureEnabled(JuspayServices juspayServices, String str) {
        JSONObject cachedSdkConfig = juspayServices == null ? SdkConfigService.getCachedSdkConfig() : juspayServices.getSdkConfigService().getSdkConfig();
        if (cachedSdkConfig == null) {
            cachedSdkConfig = SdkConfigService.getCachedSdkConfig();
        }
        if (cachedSdkConfig == null) {
            return true;
        }
        JSONObject optJSONObject = optJSONObject(optJSONObject(cachedSdkConfig, "uiFeatures"), str);
        if (!optJSONObject.optBoolean(RNGestureHandlerModule.KEY_ENABLED)) {
            return false;
        }
        if (juspayServices == null) {
            return true;
        }
        JSONArray optJSONArray = optJSONArray(optJSONObject, "blacklistedClientIds");
        String str2 = null;
        try {
            str2 = juspayServices.getSessionInfo().getClientId();
        } catch (JSONException e2) {
            juspayServices.getSdkTracker().trackException("config", "system", System.UTIL, "Exception while getting client ID", e2);
        }
        return !includes(optJSONArray, str2);
    }

    public static JSONArray optJSONArray(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        return optJSONArray == null ? new JSONArray() : optJSONArray;
    }

    public static JSONObject optJSONObject(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        return optJSONObject == null ? new JSONObject() : optJSONObject;
    }

    @Keep
    public static JSONObject toJSON(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        if (bundle != null) {
            try {
                for (String str : bundle.keySet()) {
                    Object obj = bundle.get(str);
                    jSONObject.put(str, obj == null ? JSONObject.NULL : obj instanceof ArrayList ? toJSONArray((ArrayList) obj) : obj instanceof Bundle ? toJSON((Bundle) obj) : String.valueOf(obj));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    @Keep
    public static JSONArray toJSONArray(ArrayList<Object> arrayList) {
        JSONArray jSONArray = new JSONArray();
        Iterator<Object> it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof ArrayList) {
                next = toJSONArray((ArrayList) next);
            } else if (!(next instanceof JSONObject)) {
                next = String.valueOf(next);
            }
            jSONArray.put(next);
        }
        return jSONArray;
    }
}
