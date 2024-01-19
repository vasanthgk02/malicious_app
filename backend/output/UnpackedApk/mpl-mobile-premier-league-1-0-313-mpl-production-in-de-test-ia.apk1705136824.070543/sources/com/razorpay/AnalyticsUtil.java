package com.razorpay;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import proguard.annotation.Keep;
import proguard.annotation.KeepClassMembers;

@Keep
@KeepClassMembers
public class AnalyticsUtil {
    public static String BUILD_TYPE = null;
    public static String KEY_TYPE = null;
    public static int MERCHANT_APP_BUILD = 0;
    public static CharSequence MERCHANT_APP_NAME = null;
    public static CharSequence MERCHANT_APP_NAMESPACE = null;
    public static CharSequence MERCHANT_APP_VERSION = null;
    public static boolean isAnalyticsInitialized = false;
    public static String localOrderId = null;
    public static String localPaymentId = null;
    public static String sdkType = "standealone";
    public static String sdkVersion;
    public static int sdkVersionCode;

    public static void addFilteredPropertiesFromPayload(JSONObject jSONObject) {
        try {
            ((Class) L__R$.G__G_(18, 58115, 0)).getDeclaredMethod("R$$r_", new Class[]{JSONObject.class}).invoke(null, new Object[]{jSONObject});
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static void addProperty(String str, AnalyticsProperty analyticsProperty) {
        Class<Object> cls = Object.class;
        Class<String> cls2 = String.class;
        AnalyticsProperty$R$$r_ analyticsProperty$R$$r_ = analyticsProperty.scope;
        if (analyticsProperty$R$$r_ == AnalyticsProperty$R$$r_.PAYMENT) {
            try {
                Object[] objArr = new Object[2];
                objArr[1] = analyticsProperty.value;
                objArr[0] = str;
                ((Class) L__R$.G__G_(18, 58115, 0)).getDeclaredMethod("R$$r_", new Class[]{cls2, cls}).invoke(null, objArr);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } else {
            if (analyticsProperty$R$$r_ == AnalyticsProperty$R$$r_.ORDER) {
                try {
                    Object[] objArr2 = new Object[2];
                    objArr2[1] = analyticsProperty.value;
                    objArr2[0] = str;
                    ((Class) L__R$.G__G_(18, 58115, 0)).getMethod("d__1_", new Class[]{cls2, cls}).invoke(null, objArr2);
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 != null) {
                        throw cause2;
                    }
                    throw th2;
                }
            }
        }
    }

    public static JSONObject getAnalyticsDataForCheckout(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", "mobile_sdk");
            jSONObject.put("platform_version", sdkVersion);
            jSONObject.put("os", "android");
            jSONObject.put("os_version", VERSION.RELEASE);
            if (context.getResources().getBoolean(R.bool.isTablet)) {
                jSONObject.put("device", "tablet");
            } else {
                jSONObject.put("device", "mobile");
            }
        } catch (Exception e2) {
            reportError(e2, "critical", e2.getMessage());
        }
        return jSONObject;
    }

    public static String getAppDetail() {
        if (!isAnalyticsInitialized) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(MERCHANT_APP_NAME);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        sb.append(MERCHANT_APP_VERSION);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        sb.append(MERCHANT_APP_BUILD);
        return sb.toString();
    }

    public static String getBuildType() {
        return BUILD_TYPE;
    }

    public static Map<String, Object> getErrorProperties(String str, String str2) {
        return GeneratedOutlineSupport.outline88("error_level", str, PushMessageHelper.ERROR_MESSAGE, str2);
    }

    public static JSONObject getExtraAnalyticsPayload() {
        try {
            return (JSONObject) ((Class) L__R$.G__G_(18, 58115, 0)).getDeclaredMethod("a_$P$", null).invoke(null, null);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static String getKeyType() {
        return KEY_TYPE;
    }

    public static String getLocalOrderId() {
        if (localOrderId == null) {
            localOrderId = getUniqueId();
        }
        return localOrderId;
    }

    public static String getLocalPaymentId() {
        if (localPaymentId == null) {
            localPaymentId = getUniqueId();
        }
        return localPaymentId;
    }

    public static Map<String, Object> getPageLoadEndProperties(String str, long j) {
        HashMap outline87 = GeneratedOutlineSupport.outline87("url", str);
        outline87.put(AnalyticsConstants.PAGE_LOAD_TIME, Double.valueOf(((double) j) / 1.0E9d));
        return outline87;
    }

    public static Map<String, Object> getPageLoadStartProperties(String str) {
        return GeneratedOutlineSupport.outline87("url", str);
    }

    public static String getStackTrace(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter, true));
        return stringWriter.getBuffer().toString();
    }

    public static String getUniqueId() {
        StringBuilder sb = new StringBuilder();
        sb.append(tobase62((System.currentTimeMillis() - 1388534400000L) * 1000000));
        sb.append(tobase62((long) Math.floor(Math.random() * 1.4776336E7d)));
        return sb.toString();
    }

    public static void init(Context context, String str) {
        Throwable cause;
        Class<Object> cls = Object.class;
        Class<String> cls2 = String.class;
        if (context == null) {
            throw new RuntimeException("Context not set");
        } else if (str != null) {
            String str2 = sdkType;
            try {
                Object[] objArr = new Object[3];
                objArr[2] = sdkVersion;
                objArr[1] = str2;
                objArr[0] = context;
                ((Class) L__R$.G__G_(18, 58115, 0)).getDeclaredMethod("a_$P$", new Class[]{Context.class, cls2, cls2}).invoke(null, objArr);
                try {
                    Object[] objArr2 = new Object[2];
                    objArr2[1] = str;
                    objArr2[0] = AnalyticsConstants.MERCHANT_KEY;
                    ((Class) L__R$.G__G_(18, 58115, 0)).getDeclaredMethod("d__1_", new Class[]{cls2, cls}).invoke(null, objArr2);
                    try {
                        Object[] objArr3 = new Object[2];
                        objArr3[1] = context.getPackageName();
                        objArr3[0] = AnalyticsConstants.MERCHANT_PACKAGE;
                        ((Class) L__R$.G__G_(18, 58115, 0)).getMethod("d__1_", new Class[]{cls2, cls}).invoke(null, objArr3);
                        UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
                        if (!(defaultUncaughtExceptionHandler instanceof B_$q$)) {
                            Thread.setDefaultUncaughtExceptionHandler(new B_$q$(context, defaultUncaughtExceptionHandler));
                        }
                        isAnalyticsInitialized = true;
                    } catch (Throwable th) {
                        if (cause != null) {
                            throw cause;
                        }
                        throw th;
                    }
                } finally {
                    cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                }
            } finally {
                Throwable cause2 = th.getCause();
                if (cause2 != null) {
                    throw cause2;
                }
            }
        } else {
            throw new RuntimeException("Merchant key not set");
        }
    }

    public static boolean isCheckoutUrl(String str) {
        return str.indexOf(Y$_o$.J$_0_().c__C_()) == 0;
    }

    public static boolean isNullOrEmpty(CharSequence charSequence) {
        return TextUtils.isEmpty(charSequence) || TextUtils.getTrimmedLength(charSequence) == 0;
    }

    public static void postData() {
        if (isAnalyticsInitialized) {
            try {
                ((Class) L__R$.G__G_(18, 58115, 0)).getDeclaredMethod("R$$r_", null).invoke(null, null);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
    }

    public static void refreshOrderSession() {
        Throwable cause;
        localOrderId = getUniqueId();
        localPaymentId = getUniqueId();
        try {
            ((Class) L__R$.G__G_(18, 58115, 0)).getDeclaredMethod("G__G_", null).invoke(null, null);
            try {
                ((Class) L__R$.G__G_(18, 58115, 0)).getMethod("d__1_", null).invoke(null, null);
            } catch (Throwable th) {
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } finally {
            cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
        }
    }

    public static void refreshPaymentSession() {
        localPaymentId = getUniqueId();
        try {
            ((Class) L__R$.G__G_(18, 58115, 0)).getDeclaredMethod("d__1_", null).invoke(null, null);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static void reportError(Exception exc, String str, String str2) {
        trackEvent(AnalyticsEvent.ERROR_LOGGED, getErrorProperties(str, str2));
        exc.printStackTrace();
    }

    public static void reportUncaughtException(Throwable th) {
        trackEvent(AnalyticsEvent.ERROR_LOGGED, getErrorProperties(AnalyticsConstants.UNCAUGHT, getStackTrace(th)));
    }

    public static void reset() {
        isAnalyticsInitialized = false;
        localPaymentId = null;
        localOrderId = null;
        try {
            ((Class) L__R$.G__G_(18, 58115, 0)).getDeclaredMethod("Q_$2$", null).invoke(null, null);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static CharSequence returnUndefinedIfNull(CharSequence charSequence) {
        return isNullOrEmpty(charSequence) ? "undefined" : charSequence;
    }

    public static void saveEventsToPreferences(Context context) {
        try {
            ((Class) L__R$.G__G_(18, 58115, 0)).getDeclaredMethod("R$$r_", new Class[]{Context.class}).invoke(null, new Object[]{context});
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static void setAppDetails(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            MERCHANT_APP_NAME = returnUndefinedIfNull(packageInfo.applicationInfo.loadLabel(packageManager));
            MERCHANT_APP_VERSION = returnUndefinedIfNull(packageInfo.versionName);
            MERCHANT_APP_NAMESPACE = returnUndefinedIfNull(packageInfo.packageName);
            MERCHANT_APP_BUILD = packageInfo.versionCode;
        } catch (NameNotFoundException e2) {
            reportError(e2, "critical", e2.getMessage());
        }
        BUILD_TYPE = BaseUtils.getAppBuildType(context);
        KEY_TYPE = getKeyType(str);
    }

    public static void setLocalOrderId(String str) {
        localOrderId = str;
    }

    public static void setup(Context context, String str, String str2, int i, String str3) {
        sdkType = str2;
        sdkVersionCode = i;
        sdkVersion = str3;
        setAppDetails(context, str);
        init(context, str);
    }

    public static String tobase62(long j) {
        String str = "";
        String[] split = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".split(str);
        while (j > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(split[(int) (j % 62)]));
            sb.append(str);
            str = sb.toString();
            j = (long) Math.floor((double) (j / 62));
        }
        return str;
    }

    public static void trackEvent(AnalyticsEvent analyticsEvent) {
        try {
            ((Class) L__R$.G__G_(18, 58115, 0)).getDeclaredMethod("d__1_", new Class[]{String.class}).invoke(null, new Object[]{analyticsEvent.getEventName()});
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static void trackPage(String str, String str2) {
        Class<String> cls = String.class;
        try {
            Object[] objArr = new Object[2];
            objArr[1] = str2;
            objArr[0] = str;
            ((Class) L__R$.G__G_(18, 58115, 0)).getDeclaredMethod("G__G_", new Class[]{cls, cls}).invoke(null, objArr);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static void trackPageLoadEnd(String str, long j) {
        trackEvent(isCheckoutUrl(str) ? AnalyticsEvent.CHECKOUT_PAGE_LOAD_FINISH : AnalyticsEvent.PAGE_LOAD_FINISH, getPageLoadEndProperties(str, j));
    }

    public static void trackPageLoadStart(String str) {
        trackEvent(isCheckoutUrl(str) ? AnalyticsEvent.CHECKOUT_PAGE_LOAD_START : AnalyticsEvent.PAGE_LOAD_START, getPageLoadStartProperties(str));
    }

    public static String getKeyType(String str) {
        if (isNullOrEmpty(str)) {
            return null;
        }
        String substring = str.substring(0, 8);
        if (substring.equals("rzp_live")) {
            return "live";
        }
        if (substring.equals("rzp_test")) {
            return "test";
        }
        return null;
    }

    public static void trackEvent(AnalyticsEvent analyticsEvent, Map<String, Object> map) {
        String eventName = analyticsEvent.getEventName();
        try {
            Object[] objArr = new Object[2];
            objArr[1] = map;
            objArr[0] = eventName;
            ((Class) L__R$.G__G_(18, 58115, 0)).getDeclaredMethod("R$$r_", new Class[]{String.class, Map.class}).invoke(null, objArr);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static void trackEvent(AnalyticsEvent analyticsEvent, JSONObject jSONObject) {
        String eventName = analyticsEvent.getEventName();
        try {
            Object[] objArr = new Object[2];
            objArr[1] = jSONObject;
            objArr[0] = eventName;
            ((Class) L__R$.G__G_(18, 58115, 0)).getDeclaredMethod("R$$r_", new Class[]{String.class, JSONObject.class}).invoke(null, objArr);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }
}
