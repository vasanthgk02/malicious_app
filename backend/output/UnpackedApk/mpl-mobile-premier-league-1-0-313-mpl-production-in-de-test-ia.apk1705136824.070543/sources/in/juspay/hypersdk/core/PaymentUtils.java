package in.juspay.hypersdk.core;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.telephony.SmsManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.URLUtil;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.Toast;
import androidx.annotation.Keep;
import androidx.core.content.ContextCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.datepicker.DatePickerDialogModule;
import com.google.firebase.crashlytics.internal.network.HttpGetRequest;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.mpl.androidapp.webview.view.customviews.WebViewGamesContainer;
import com.netcore.android.notification.SMTNotificationConstants;
import com.reactnativecommunity.webview.RNCWebViewManager;
import com.rudderstack.android.sdk.core.RudderTraits;
import in.juspay.hypersdk.core.ClipboardListener.OnClipboardChangeListener;
import in.juspay.hypersdk.core.Labels.Device;
import in.juspay.hypersdk.core.Labels.SDK;
import in.juspay.hypersdk.core.Labels.System;
import in.juspay.hypersdk.core.PaymentConstants.GodelOffReasons;
import in.juspay.hypersdk.core.PaymentConstants.LogCategory;
import in.juspay.hypersdk.core.PaymentConstants.SubCategory.ApiCall;
import in.juspay.hypersdk.data.PaymentSessionInfo;
import in.juspay.hypersdk.data.SessionInfo;
import in.juspay.hypersdk.services.FileProviderService;
import in.juspay.hypersdk.ui.JuspayWebView;
import in.juspay.hypersdk.utils.IntegrationUtils;
import in.juspay.hypersdk.utils.Utils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;
import org.apache.fontbox.cmap.CMap;
import org.apache.fontbox.cmap.CMapParser;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.apache.pdfbox.pdmodel.interactive.form.PDChoice;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PaymentUtils extends Utils {
    public static final String LOG_TAG = "PaymentUtils";
    public static boolean isRupaySupportedAdded;

    public static class DeliverReceiver extends BroadcastReceiver implements JuspayDuiHook {
        public static final String LOG_TAG = "DeliverReceiver";

        @Keep
        public DeliverReceiver() {
        }

        public void attach(Activity activity) {
            activity.registerReceiver(this, new IntentFilter("SMS_DELIVERED"));
            JuspayLogger.d(LOG_TAG, "Attaching the DeliverReceiver");
        }

        public void detach(Activity activity) {
            if (activity != null) {
                activity.unregisterReceiver(this);
            }
        }

        public String execute(Activity activity, String str, JSONObject jSONObject, String str2) {
            return null;
        }

        public void onReceive(Context context, Intent intent) {
            String str;
            int resultCode = getResultCode();
            if (resultCode == -1) {
                str = "SMS DELIVERED";
            } else if (resultCode == 0) {
                str = "SMS NOT DELIVERED";
            } else {
                return;
            }
            Toast.makeText(context, str, 0).show();
        }
    }

    public static class SentReceiver extends BroadcastReceiver implements JuspayDuiHook {
        public static final String LOG_TAG = "SentReceiver";
        public String callback;
        public final HyperFragment paymentFragment;

        @Keep
        public SentReceiver() {
            this.paymentFragment = null;
        }

        public SentReceiver(HyperFragment hyperFragment, String str) {
            setCallback(str);
            this.paymentFragment = hyperFragment;
        }

        public void attach(Activity activity) {
            activity.registerReceiver(this, new IntentFilter("SMS_SENT"));
            this.paymentFragment.getJuspayServices().sdkDebug(LOG_TAG, "Attaching the SentReceiver");
        }

        public void detach(Activity activity) {
            if (activity != null) {
                activity.unregisterReceiver(this);
            }
        }

        public String execute(Activity activity, String str, JSONObject jSONObject, String str2) {
            return null;
        }

        public void onReceive(Context context, Intent intent) {
            StringBuilder sb;
            DuiInterface duiInterface;
            String str;
            HyperFragment hyperFragment = this.paymentFragment;
            if (hyperFragment != null && hyperFragment.getDuiInterface() != null) {
                int resultCode = getResultCode();
                if (resultCode == -1) {
                    Toast.makeText(context, "SMS SENT", 0).show();
                    if (this.callback != null) {
                        duiInterface = this.paymentFragment.getDuiInterface();
                        sb = GeneratedOutlineSupport.outline73("window.callUICallback(\"");
                        sb.append(this.callback);
                        str = "\", \"SUCCESS\")";
                    } else {
                        return;
                    }
                } else if (resultCode == 1) {
                    Toast.makeText(context, "SMS GENERIC FAILURE", 0).show();
                    if (this.callback != null) {
                        duiInterface = this.paymentFragment.getDuiInterface();
                        sb = GeneratedOutlineSupport.outline73("window.callUICallback(\"");
                        sb.append(this.callback);
                        str = "\", \"Generic failure\", \"837\")";
                    } else {
                        return;
                    }
                } else if (resultCode == 2) {
                    Toast.makeText(context, "SMS RADIO OFF", 0).show();
                    if (this.callback != null) {
                        duiInterface = this.paymentFragment.getDuiInterface();
                        sb = GeneratedOutlineSupport.outline73("window.callUICallback(\"");
                        sb.append(this.callback);
                        str = "\", \"Radio off\", \"840\")";
                    } else {
                        return;
                    }
                } else if (resultCode == 3) {
                    Toast.makeText(context, "SMS NULL PDU", 0).show();
                    if (this.callback != null) {
                        duiInterface = this.paymentFragment.getDuiInterface();
                        sb = GeneratedOutlineSupport.outline73("window.callUICallback(\"");
                        sb.append(this.callback);
                        str = "\", \"Null PDU\", \"839\")";
                    } else {
                        return;
                    }
                } else if (resultCode == 4) {
                    Toast.makeText(context, "SMS NO SERVICE", 0).show();
                    if (this.callback != null) {
                        duiInterface = this.paymentFragment.getDuiInterface();
                        sb = GeneratedOutlineSupport.outline73("window.callUICallback(\"");
                        sb.append(this.callback);
                        str = "\", \"No service\", \"838\")";
                    } else {
                        return;
                    }
                } else if (this.callback != null) {
                    duiInterface = this.paymentFragment.getDuiInterface();
                    sb = GeneratedOutlineSupport.outline73("window.callUICallback(\"");
                    sb.append(this.callback);
                    str = "\", \"Unable to Send SMS\", \"837\")";
                } else {
                    return;
                }
                sb.append(str);
                duiInterface.invokeFnInDUIWebview(sb.toString());
            }
        }

        public void setCallback(String str) {
            this.callback = str;
        }
    }

    public static WebResourceResponse addAcsToJSFile(HyperFragment hyperFragment, JuspayServices juspayServices, WebResourceRequest webResourceRequest) {
        SequenceInputStream sequenceInputStream;
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(webResourceRequest.getUrl().toString()).openConnection()));
        for (String next : webResourceRequest.getRequestHeaders().keySet()) {
            httpURLConnection.setRequestProperty(next, webResourceRequest.getRequestHeaders().get(next));
        }
        httpURLConnection.setDoOutput(false);
        String contentType = httpURLConnection.getContentType();
        String substring = (contentType == null || contentType.indexOf(59) <= -1) ? contentType : contentType.substring(0, contentType.indexOf(59));
        String str = null;
        if (contentType != null && contentType.indexOf(59) > -1) {
            Matcher matcher = Pattern.compile("charset=([\\w\\d-_]+)").matcher(contentType);
            if (matcher.find()) {
                str = matcher.group(1);
            }
        }
        String str2 = str;
        HashMap hashMap = new HashMap();
        for (String str3 : httpURLConnection.getHeaderFields().keySet()) {
            hashMap.put(str3, httpURLConnection.getHeaderField(str3));
        }
        int responseCode = httpURLConnection.getResponseCode();
        String responseMessage = httpURLConnection.getResponseMessage();
        InputStream inputStream = httpURLConnection.getInputStream();
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(String.format("window.addEventListener('load', function() { if(!window.GK) { %s } });", new Object[]{getAcsScript(hyperFragment, juspayServices)}).getBytes(StandardCharsets.UTF_8));
            try {
                sequenceInputStream = new SequenceInputStream(byteArrayInputStream, inputStream);
                WebResourceResponse webResourceResponse = new WebResourceResponse(substring, str2, responseCode, responseMessage, hashMap, sequenceInputStream);
                sequenceInputStream.close();
                byteArrayInputStream.close();
                if (inputStream != null) {
                    inputStream.close();
                }
                return webResourceResponse;
            } catch (Throwable th) {
                byteArrayInputStream.close();
                throw th;
            }
            throw th;
        } catch (Throwable th2) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    public static SmsReceiver checkAndGetSMSReceiver(HyperFragment hyperFragment, String str) {
        JuspayServices juspayServices = hyperFragment.getJuspayServices();
        SdkTracker sdkTracker = juspayServices.getSdkTracker();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
        intentFilter.setPriority(999);
        try {
            if (Utils.checkIfGranted(juspayServices, "android.permission.RECEIVE_SMS")) {
                SmsReceiver smsReceiver = new SmsReceiver(hyperFragment, str);
                smsReceiver.setIntentFilter(intentFilter);
                return smsReceiver;
            }
        } catch (Throwable th) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.UTIL, "Failed to register SMS broadcast receiver (Ignoring)", th);
        }
        return null;
    }

    public static void clearCookies(JuspayServices juspayServices) {
        Context context = juspayServices.getContext();
        SdkTracker sdkTracker = juspayServices.getSdkTracker();
        try {
            CookieSyncManager.createInstance(context).sync();
            CookieManager.getInstance().removeAllCookie();
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.UTIL, "Failed to clear cookies", e2);
        }
    }

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

    public static String getAcsScript(HyperFragment hyperFragment, JuspayServices juspayServices) {
        FileProviderService fileProviderService = juspayServices.getFileProviderService();
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("window.juspayContext = {}; juspayContext['web_lab_rules'] = ");
        outline73.append(getWebLabRules(hyperFragment, juspayServices));
        StringBuilder outline78 = GeneratedOutlineSupport.outline78(outline73.toString(), ", ");
        outline78.append(fileProviderService.readFromFile(juspayServices.getContext(), PaymentConstants.ACS));
        return outline78.toString();
    }

    public static ClipboardListener getClipboardListener(final HyperFragment hyperFragment, final String str) {
        if (hyperFragment.getContext() == null) {
            return null;
        }
        return new ClipboardListener(new OnClipboardChangeListener() {
            public void onClipboardChange(ArrayList<String> arrayList) {
                if (HyperFragment.this.getDuiInterface() != null) {
                    HyperFragment.this.getDuiInterface().invokeCallbackInDUIWebview(str, new JSONArray(arrayList).toString());
                }
            }
        }, hyperFragment.getJuspayServices());
    }

    public static String getConfigVariableDeclarations(Context context, SessionInfo sessionInfo) {
        String deviceId = sessionInfo.getDeviceId();
        String androidId = sessionInfo.getAndroidId();
        if (deviceId == null || deviceId.isEmpty()) {
            deviceId = "";
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("var clientId = '");
        outline73.append(sessionInfo.getClientId());
        outline73.append("';var juspayDeviceId = '");
        outline73.append(deviceId);
        outline73.append("';var juspayAndroidId = '");
        outline73.append(androidId);
        outline73.append("';var godelRemotesVersion = '");
        outline73.append(PaymentSessionInfo.getGodelRemotesVersion(context));
        outline73.append("';var godelVersion = '");
        outline73.append(IntegrationUtils.getGodelVersion(context));
        outline73.append("';var buildVersion = '");
        outline73.append(IntegrationUtils.getGodelBuildVersion(context));
        outline73.append("';var os_version = '");
        outline73.append(SessionInfo.getOSVersion());
        outline73.append("';");
        return outline73.toString();
    }

    public static ConnectivityReceiver getConnectivityReceiver(HyperFragment hyperFragment, String str) {
        SdkTracker sdkTracker = hyperFragment.getJuspayServices().getSdkTracker();
        try {
            return new ConnectivityReceiver(hyperFragment);
        } catch (Throwable th) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.UTIL, "Failed to register Connectivity receiver (Ignoring)", th);
            return null;
        }
    }

    public static JuspayDuiHook getDeliveredSMSReceiver() {
        return new DeliverReceiver();
    }

    public static List<Pattern> getExcludeUrlsPatternList(SdkTracker sdkTracker, JSONObject jSONObject) {
        Throwable th;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Throwable th2;
        LinkedList linkedList = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            LinkedList linkedList2 = new LinkedList();
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("exclude_url_patterns");
                if (isNotNull(jSONArray)) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        linkedList2.add(Pattern.compile(jSONArray.get(i).toString()));
                    }
                }
                return linkedList2;
            } catch (JSONException e2) {
                th2 = e2;
                linkedList = linkedList2;
                str5 = LOG_TAG;
                str4 = "action";
                str3 = "system";
                str2 = System.UTIL;
                str = "Json Exception while fetching excludeUrlPatterns from config";
                sdkTracker.trackAndLogException(str5, str4, str3, str2, str, th);
                return linkedList;
            } catch (Exception e3) {
                th = e3;
                linkedList = linkedList2;
                str5 = LOG_TAG;
                str4 = "action";
                str3 = "system";
                str2 = System.UTIL;
                str = "Exception while compiling patterns in excludeUrlPatterns from config";
                sdkTracker.trackAndLogException(str5, str4, str3, str2, str, th);
                return linkedList;
            }
        } catch (JSONException e4) {
            th2 = e4;
            str5 = LOG_TAG;
            str4 = "action";
            str3 = "system";
            str2 = System.UTIL;
            str = "Json Exception while fetching excludeUrlPatterns from config";
            sdkTracker.trackAndLogException(str5, str4, str3, str2, str, th);
            return linkedList;
        } catch (Exception e5) {
            th = e5;
            str5 = LOG_TAG;
            str4 = "action";
            str3 = "system";
            str2 = System.UTIL;
            str = "Exception while compiling patterns in excludeUrlPatterns from config";
            sdkTracker.trackAndLogException(str5, str4, str3, str2, str, th);
            return linkedList;
        }
    }

    public static List<String> getRupaySpecificDomains(HyperFragment hyperFragment, JuspayServices juspayServices) {
        Throwable th;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        SdkTracker sdkTracker;
        Throwable th2;
        ArrayList arrayList = null;
        if (hyperFragment.getConfig() == null) {
            return null;
        }
        try {
            JSONArray jSONArray = hyperFragment.getConfig().getJSONArray("rupay_specific_domains");
            String str6 = LOG_TAG;
            juspayServices.sdkDebug(str6, "printing urlArray" + jSONArray);
            if (!isNotNull(jSONArray)) {
                return null;
            }
            int length = jSONArray.length();
            ArrayList arrayList2 = new ArrayList(length);
            int i = 0;
            while (i < length) {
                try {
                    arrayList2.add(jSONArray.get(i).toString());
                    i++;
                } catch (JSONException e2) {
                    th2 = e2;
                    arrayList = arrayList2;
                    sdkTracker = juspayServices.getSdkTracker();
                    str5 = LOG_TAG;
                    str4 = "action";
                    str3 = "system";
                    str2 = System.UTIL;
                    str = "Json Exception while fetching Rupay Urls from config";
                    sdkTracker.trackAndLogException(str5, str4, str3, str2, str, th);
                    return arrayList;
                } catch (Exception e3) {
                    th = e3;
                    arrayList = arrayList2;
                    sdkTracker = juspayServices.getSdkTracker();
                    str5 = LOG_TAG;
                    str4 = "action";
                    str3 = "system";
                    str2 = System.UTIL;
                    str = "Exception while getting rupay urls from config";
                    sdkTracker.trackAndLogException(str5, str4, str3, str2, str, th);
                    return arrayList;
                }
            }
            return arrayList2;
        } catch (JSONException e4) {
            th2 = e4;
            sdkTracker = juspayServices.getSdkTracker();
            str5 = LOG_TAG;
            str4 = "action";
            str3 = "system";
            str2 = System.UTIL;
            str = "Json Exception while fetching Rupay Urls from config";
            sdkTracker.trackAndLogException(str5, str4, str3, str2, str, th);
            return arrayList;
        } catch (Exception e5) {
            th = e5;
            sdkTracker = juspayServices.getSdkTracker();
            str5 = LOG_TAG;
            str4 = "action";
            str3 = "system";
            str2 = System.UTIL;
            str = "Exception while getting rupay urls from config";
            sdkTracker.trackAndLogException(str5, str4, str3, str2, str, th);
            return arrayList;
        }
    }

    public static SmsReceiver getSMSConsent(HyperFragment hyperFragment, String str) {
        if (hyperFragment.getContext() != null) {
            SdkTracker sdkTracker = hyperFragment.getJuspayServices().getSdkTracker();
            try {
                SmsReceiver smsReceiver = new SmsReceiver(hyperFragment, str);
                smsReceiver.setIntentFilter(null);
                return smsReceiver;
            } catch (Exception e2) {
                sdkTracker.trackAndLogException(LOG_TAG, LogCategory.API_CALL, ApiCall.SDK, SDK.PAYMENT_UTILS, "Failed to register SMS Consent", e2);
                return null;
            }
        } else {
            throw new IllegalStateException("BrowserFragment doesn't have a context");
        }
    }

    public static SmsReceiver getSMSReceiver(HyperFragment hyperFragment, String str) {
        return checkAndGetSMSReceiver(hyperFragment, str);
    }

    public static JuspayDuiHook getSendSMSReceiver(HyperFragment hyperFragment, String str) {
        return new SentReceiver(hyperFragment, str);
    }

    public static String getSimNo(String str) {
        return "";
    }

    public static JSONObject getWebLabRules(HyperFragment hyperFragment, JuspayServices juspayServices) {
        try {
            return hyperFragment.getConfig() != null ? hyperFragment.getConfig().getJSONObject("weblab") : new JSONObject();
        } catch (Exception e2) {
            juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, "action", "system", System.UTIL, "Unable to find weblab key in config", e2);
            return null;
        }
    }

    public static boolean hasTelephonyService(JuspayServices juspayServices) {
        Context context = juspayServices.getContext();
        SdkTracker sdkTracker = juspayServices.getSdkTracker();
        boolean z = false;
        try {
            if (((TelephonyManager) context.getSystemService("phone")).getPhoneType() != 0) {
                z = true;
            }
            return z;
        } catch (Throwable th) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.UTIL, "Exception while trying to get telephony service. Returning false.", th);
            return false;
        }
    }

    public static boolean isAcsToBeAddedToResource(HyperFragment hyperFragment, JuspayServices juspayServices, URL url) {
        List<String> rupaySpecificDomains = getRupaySpecificDomains(hyperFragment, juspayServices);
        if (rupaySpecificDomains == null) {
            return false;
        }
        for (String contains : rupaySpecificDomains) {
            if (url.toString().toLowerCase().contains(contains) && url.getPath().toLowerCase().endsWith(".js") && !url.getPath().toLowerCase().endsWith(".jsp")) {
                return true;
            }
        }
        return false;
    }

    public static boolean isClassAvailable(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static boolean isDualSim(Context context) {
        return ContextCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") == 0 && SubscriptionManager.from(context).getActiveSubscriptionInfoCount() > 1;
    }

    public static boolean isNotNull(JSONArray jSONArray) {
        return (jSONArray == null || jSONArray == JSONObject.NULL) ? false : true;
    }

    public static boolean isSimSupport(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return (telephonyManager == null || telephonyManager.getSimState() == 1) ? false : true;
    }

    public static void logMemoryInfo(SdkTracker sdkTracker, MemoryInfo memoryInfo) {
        SdkTracker sdkTracker2 = sdkTracker;
        sdkTracker2.trackContext("device", "info", Device.MEMORY, "available_memory", Long.valueOf(memoryInfo.availMem));
        sdkTracker2.trackContext("device", "info", Device.MEMORY, "threshold_memory", Long.valueOf(memoryInfo.threshold));
        sdkTracker.trackContext("device", "info", Device.MEMORY, "total_memory", Long.valueOf(memoryInfo.totalMem));
    }

    public static String readSmsFromInbox(JuspayServices juspayServices, Activity activity, String str) {
        Cursor query;
        String string;
        String string2;
        String valueOf;
        JSONArray jSONArray = null;
        if (Utils.checkIfGranted(juspayServices, "android.permission.READ_SMS")) {
            Uri parse = Uri.parse("content://sms/inbox");
            String[] strArr = {"_id", RudderTraits.ADDRESS_KEY, SMTNotificationConstants.NOTIF_BODY_KEY, DatePickerDialogModule.ARG_DATE};
            try {
                int i = 0;
                query = activity.getContentResolver().query(parse, strArr, "date > ?", new String[]{"" + str}, "date DESC");
                if (query != null) {
                    i = query.getCount();
                }
                if (i > 0) {
                    jSONArray = new JSONArray();
                }
                while (query != null && query.moveToNext()) {
                    juspayServices.sdkDebug(LOG_TAG, "From: " + string + " : " + string2 + CMap.SPACE + valueOf);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("from", string);
                    jSONObject.put(SMTNotificationConstants.NOTIF_BODY_KEY, string2);
                    jSONObject.put("time", valueOf);
                    if (jSONArray != null) {
                        jSONArray.put(jSONObject);
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (Exception e2) {
                juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, "action", "system", System.UTIL, "Exception while trying to read previous sms from Inbox", e2);
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            juspayServices.getSdkTracker().trackAction("system", "error", System.UTIL, "readsmsfrominbox", "No permission to read SMS");
        }
        return (jSONArray == null || jSONArray.length() == 0) ? HttpUrl.PATH_SEGMENT_ENCODE_SET_URI : jSONArray.toString();
        throw th;
    }

    public static void refreshPage(JuspayWebView juspayWebView) {
        if (juspayWebView != null) {
            juspayWebView.addJsToWebView("window.location.reload(true);");
        }
    }

    public static void sendSMS(HyperFragment hyperFragment, Bundle bundle, Runnable runnable) {
        JuspayServices juspayServices = hyperFragment.getJuspayServices();
        SdkTracker sdkTracker = juspayServices.getSdkTracker();
        if (hyperFragment.getContext() == null) {
            SdkTracker sdkTracker2 = sdkTracker;
            sdkTracker2.trackAction("system", "error", System.UTIL, "sendsms", "failed");
            sdkTracker2.trackAction("system", "error", System.UTIL, "missing", "context");
            return;
        }
        int i = VERSION.SDK_INT >= 23 ? PDChoice.FLAG_COMMIT_ON_SEL_CHANGE : 0;
        PendingIntent broadcast = PendingIntent.getBroadcast(hyperFragment.getContext(), 0, new Intent("SMS_SENT"), i);
        PendingIntent broadcast2 = PendingIntent.getBroadcast(hyperFragment.getContext(), 0, new Intent("SMS_DELIVERED"), i);
        if (!bundle.getBoolean("use_yes_bank", false)) {
            HyperFragment hyperFragment2 = hyperFragment;
            boolean sendSMS = sendSMS(hyperFragment.getContext(), hyperFragment2, Integer.parseInt(bundle.getString("simSlot")), bundle.getString("mobileNumber"), null, bundle.getString("token"), broadcast, broadcast2);
            String str = LOG_TAG;
            juspayServices.sdkDebug(str, "" + sendSMS);
        }
    }

    @SuppressLint({"PrivateApi"})
    @TargetApi(22)
    public static boolean sendSMS(Context context, HyperFragment hyperFragment, int i, String str, String str2, String str3, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        SmsManager smsManager;
        int i2 = i;
        JuspayServices juspayServices = hyperFragment.getJuspayServices();
        SdkTracker sdkTracker = juspayServices.getSdkTracker();
        String str4 = "isms";
        if (i2 == 0) {
            try {
                if (Build.MODEL.equals("Philips T939")) {
                    str4 = "isms0";
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return false;
            } catch (Exception e2) {
                sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.UTIL, "Exception while sending SMS", e2);
                return false;
            }
        } else if (i2 == 1) {
            str4 = "isms2";
        }
        Method declaredMethod = Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", new Class[]{String.class});
        declaredMethod.setAccessible(true);
        Object invoke = declaredMethod.invoke(null, new Object[]{str4});
        Method declaredMethod2 = Class.forName("com.android.internal.telephony.ISms$Stub").getDeclaredMethod("asInterface", new Class[]{IBinder.class});
        declaredMethod2.setAccessible(true);
        declaredMethod2.invoke(null, new Object[]{invoke});
        String str5 = LOG_TAG;
        juspayServices.sdkDebug(str5, "send msg: " + str3);
        if (isDualSim(context)) {
            ArrayList arrayList = new ArrayList();
            for (SubscriptionInfo subscriptionId : SubscriptionManager.from(context).getActiveSubscriptionInfoList()) {
                int subscriptionId2 = subscriptionId.getSubscriptionId();
                arrayList.add(Integer.valueOf(subscriptionId2));
                String str6 = LOG_TAG;
                juspayServices.sdkDebug(str6, "subscriptionId:" + subscriptionId2);
            }
            smsManager = SmsManager.getSmsManagerForSubscriptionId(((Integer) arrayList.get(i2)).intValue());
        } else {
            smsManager = SmsManager.getDefault();
        }
        smsManager.sendTextMessage(str, null, str3, pendingIntent, pendingIntent2);
        return true;
    }

    public static void setIsRupaySupportedAdded(boolean z) {
        isRupaySupportedAdded = z;
    }

    @TargetApi(11)
    public static WebResourceResponse shouldExcludeResource(HyperFragment hyperFragment, SdkTracker sdkTracker, String str) {
        String str2;
        JSONObject config = hyperFragment.getConfig();
        Pattern compile = Pattern.compile(".*\\.(gif|jpg|jpeg|png)([;?].*)?$");
        Bitmap createBitmap = Bitmap.createBitmap(1, 1, Config.ARGB_4444);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        List<Pattern> excludeUrlsPatternList = getExcludeUrlsPatternList(sdkTracker, config);
        if (excludeUrlsPatternList == null) {
            excludeUrlsPatternList = new ArrayList<>();
        }
        for (Pattern matcher : excludeUrlsPatternList) {
            if (matcher.matcher(str).matches()) {
                if (compile.matcher(str).matches()) {
                    str2 = RNCWebViewManager.HTML_MIME_TYPE;
                } else {
                    byteArray = "[blocked]".getBytes();
                    str2 = "text/plain";
                }
                return new WebResourceResponse(str2, WebViewGamesContainer.ENCODING_NAME, new ByteArrayInputStream(byteArray));
            }
        }
        return null;
    }

    @TargetApi(21)
    public static WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest, HyperFragment hyperFragment) {
        JuspayServices juspayServices = hyperFragment.getJuspayServices();
        SdkTracker sdkTracker = juspayServices.getSdkTracker();
        try {
            if (juspayServices.getSessionInfo().get("inject_acs_into_iframes", BaseParser.FALSE).equals(BaseParser.TRUE) && webResourceRequest.getMethod().equals(HttpGetRequest.METHOD_GET) && webResourceRequest.getUrl().toString().matches(".*\\.jsp?$") && hyperFragment.getConfig() != null) {
                JSONArray jSONArray = hyperFragment.getConfig().getJSONArray("bank_js_urls");
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (Pattern.compile(jSONArray.getString(i)).matcher(webResourceRequest.getUrl().toString()).find()) {
                        return addAcsToJSFile(hyperFragment, juspayServices, webResourceRequest);
                    }
                }
                return null;
            }
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.UTIL, "Exception while adding ACS to js file", e2);
        }
        return null;
    }

    public static WebResourceResponse shouldInterceptRequest(WebView webView, String str, HyperFragment hyperFragment) {
        SequenceInputStream sequenceInputStream;
        JuspayServices juspayServices = hyperFragment.getJuspayServices();
        SdkTracker sdkTracker = juspayServices.getSdkTracker();
        try {
            juspayServices.sdkDebug(LOG_TAG, String.format("Intercepted URL: %s", new Object[]{str}));
            if (!URLUtil.isValidUrl(str) || !isAcsToBeAddedToResource(hyperFragment, juspayServices, new URL(str)) || isRupaySupportedAdded) {
                WebResourceResponse shouldExcludeResource = shouldExcludeResource(hyperFragment, sdkTracker, str);
                if (shouldExcludeResource == null) {
                    return null;
                }
                sdkTracker.trackAction("system", "info", System.UTIL, "url_excluded", str);
                return shouldExcludeResource;
            }
            URL url = new URL(str);
            juspayServices.sdkDebug(LOG_TAG, String.format("Intercepted URL and modified: %s", new Object[]{str}));
            setIsRupaySupportedAdded(true);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(getAcsScript(hyperFragment, juspayServices).getBytes(StandardCharsets.UTF_8));
            try {
                sequenceInputStream = new SequenceInputStream(byteArrayInputStream, FirebasePerfUrlConnection.openStream(url));
                WebResourceResponse webResourceResponse = new WebResourceResponse("text/javascript", WebViewGamesContainer.ENCODING_NAME, sequenceInputStream);
                sequenceInputStream.close();
                byteArrayInputStream.close();
                return webResourceResponse;
            } catch (Throwable th) {
                byteArrayInputStream.close();
                throw th;
            }
            throw th;
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.UTIL, "Error while Caching Files", e2);
            return null;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }

    public static void switchOffGodelIfLowOnMemory(HyperFragment hyperFragment, JuspayServices juspayServices, PaymentSessionInfo paymentSessionInfo) {
        int i;
        try {
            Context context = juspayServices.getContext();
            SdkTracker sdkTracker = juspayServices.getSdkTracker();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            MemoryInfo memoryInfo = new MemoryInfo();
            try {
                i = getWebLabRules(hyperFragment, juspayServices).getInt("shouldUseMemory");
                sdkTracker.trackAction("system", "info", System.UTIL, "weblab_shouldUseMemory", i + " MB");
            } catch (Exception e2) {
                sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.UTIL, "Exception while fetching shouldUseMemory from config", e2);
                i = 4;
            }
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                int memoryClass = activityManager.getMemoryClass();
                if (memoryClass < i) {
                    paymentSessionInfo.setGodelDisabled(GodelOffReasons.LOW_ON_MEMORY);
                    sdkTracker.trackAction("system", "info", System.UTIL, "switching_godel_off", "low on memory - Available memory : " + memoryClass + " MB");
                }
                logMemoryInfo(sdkTracker, memoryInfo);
                sdkTracker.trackAction("system", "info", System.UTIL, "switchoffgodeliflowonmemory", memoryClass + " MB <" + i);
            }
        } catch (Exception unused) {
        }
    }

    public static JSONArray toJSONArray(Object obj) {
        JSONArray jSONArray = new JSONArray();
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                jSONArray.put(wrap(Array.get(obj, i)));
            }
            return jSONArray;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Not a primitive array: ");
        outline73.append(obj.getClass());
        throw new JSONException(outline73.toString());
    }

    @Keep
    public static String toJavascriptArray(ArrayList<String> arrayList) {
        if (arrayList == null) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("[");
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            outline73.append("\"");
            outline73.append(it.next());
            outline73.append("\"");
            if (it.hasNext()) {
                outline73.append(",");
            }
        }
        outline73.append(CMapParser.MARK_END_OF_ARRAY);
        return outline73.toString();
    }

    public static boolean validatePinning(X509Certificate[] x509CertificateArr, Set<String> set) {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            for (X509Certificate x509Certificate : x509CertificateArr) {
                byte[] encoded = x509Certificate.getPublicKey().getEncoded();
                instance.update(encoded, 0, encoded.length);
                String encodeToString = Base64.encodeToString(instance.digest(), 2);
                sb.append("    sha256/");
                sb.append(encodeToString);
                sb.append(" : ");
                sb.append(x509Certificate.getSubjectDN().toString());
                sb.append("\n");
                if (set.contains(encodeToString)) {
                    return true;
                }
            }
            JuspayLogger.d(LOG_TAG, sb.toString());
            return false;
        } catch (NoSuchAlgorithmException unused) {
            throw new CertificateException("couldn't create digest");
        }
    }

    public static Object wrap(Object obj) {
        if (obj == null) {
            return JSONObject.NULL;
        }
        if (!(obj instanceof JSONArray) && !(obj instanceof JSONObject)) {
            if (obj.equals(JSONObject.NULL)) {
                return obj;
            }
            try {
                if (obj instanceof Collection) {
                    return new JSONArray((Collection) obj);
                }
                if (obj.getClass().isArray()) {
                    return toJSONArray(obj);
                }
                if (obj instanceof Map) {
                    return new JSONObject((Map) obj);
                }
                if (!(obj instanceof Boolean) && !(obj instanceof Byte) && !(obj instanceof Character) && !(obj instanceof Double) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Short)) {
                    if (!(obj instanceof String)) {
                        if (obj.getClass().getPackage().getName().startsWith("java.")) {
                            obj = obj.toString();
                        }
                        obj = null;
                    }
                }
                return obj;
            } catch (Exception unused) {
            }
        }
        return obj;
    }
}
