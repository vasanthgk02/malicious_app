package in.juspay.hypersdk.core;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieSyncManager;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.updater.downloadmanager.utils.Constants;
import com.mpl.androidapp.updater.util.UpdaterConstant.Response;
import com.mpl.androidapp.utils.Constant;
import com.razorpay.AnalyticsConstants;
import com.reactnativecommunity.webview.RNCWebViewManager;
import in.juspay.hypersdk.core.Labels.Android;
import in.juspay.hypersdk.core.Labels.HyperSdk;
import in.juspay.hypersdk.core.Labels.System;
import in.juspay.hypersdk.core.PaymentConstants.LogCategory;
import in.juspay.hypersdk.core.PaymentConstants.SubCategory.LifeCycle;
import in.juspay.hypersdk.data.KeyValueStore;
import in.juspay.hypersdk.data.SessionInfo;
import in.juspay.hypersdk.services.RemoteAssetService;
import in.juspay.hypersdk.ui.HyperPaymentsCallback;
import in.juspay.hypersdk.ui.JuspayWebView;
import in.juspay.hypersdk.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import okhttp3.HttpUrl;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DuiInterface extends HyperJsInterface {
    public static final String LOG_TAG = "DuiInterface";
    public Activity activity;
    public HyperFragment browserFragment;
    public ViewGroup container;
    public final Context context;
    public final DynamicUI dynamicUI;
    public final JuspayServices juspayServices;
    public int lastFocusedEditView = -1;
    public Map<String, Object> listenerMap;
    public ArrayList<Integer> merchantViewIds = new ArrayList<>();
    public final RemoteAssetService remoteAssetService;
    public final SdkTracker sdkTracker;
    public final SessionInfo sessionInfo;

    public DuiInterface(JuspayServices juspayServices2, Activity activity2, HyperFragment hyperFragment) {
        super(juspayServices2, hyperFragment);
        this.juspayServices = juspayServices2;
        this.activity = activity2;
        this.context = juspayServices2.getContext();
        this.sdkTracker = juspayServices2.getSdkTracker();
        this.dynamicUI = juspayServices2.getDynamicUI();
        this.sessionInfo = juspayServices2.getSessionInfo();
        this.remoteAssetService = juspayServices2.getRemoteAssetService();
        this.browserFragment = hyperFragment;
        this.listenerMap = new HashMap();
    }

    @JavascriptInterface
    public void addDataToSharedPrefs(String str, String str2) {
        KeyValueStore.write(this.juspayServices, str, str2);
    }

    @JavascriptInterface
    public void attach(String str, String str2, String str3) {
        if (!isHookSupported(str)) {
            JuspayLogger.e(LOG_TAG, "Unsupported hook: " + str);
            return;
        }
        try {
            detach(new String[]{str});
            JuspayDuiHook juspayDuiHook = null;
            if ("SMS_CONSENT".equals(str)) {
                juspayDuiHook = PaymentUtils.getSMSConsent(this.browserFragment, str3);
            } else if (PaymentConstants.SMS_RECEIVE.equals(str)) {
                juspayDuiHook = PaymentUtils.getSMSReceiver(this.browserFragment, str3);
            } else if (PaymentConstants.CLIPBOARD.equals(str)) {
                juspayDuiHook = PaymentUtils.getClipboardListener(this.browserFragment, str3);
            } else if (PaymentConstants.NETWORK_STATUS.equals(str)) {
                juspayDuiHook = PaymentUtils.getConnectivityReceiver(this.browserFragment, str3);
            } else if (PaymentConstants.SEND_SMS.equals(str)) {
                juspayDuiHook = PaymentUtils.getSendSMSReceiver(this.browserFragment, str3);
            } else if (PaymentConstants.DELIVER_SMS.equals(str)) {
                juspayDuiHook = PaymentUtils.getDeliveredSMSReceiver();
            } else {
                JuspayServices juspayServices2 = this.juspayServices;
                juspayServices2.sdkDebug(LOG_TAG, "Unknown Hook: " + str);
            }
            if (juspayDuiHook == null || this.activity == null) {
                this.juspayServices.sdkDebug(LOG_TAG, "Nothing to attach");
            } else {
                this.listenerMap.put(str, juspayDuiHook);
                juspayDuiHook.attach(this.activity);
            }
        } catch (Exception e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "Error while retrieving arguments", e2);
        }
    }

    @JavascriptInterface
    public void attachMerchantView(final int i, final String str) {
        if (this.activity != null) {
            HyperFragment hyperFragment = this.browserFragment;
            if (hyperFragment != null && hyperFragment.getJuspayCallback() != null) {
                this.activity.runOnUiThread(new Runnable() {
                    public void run() {
                        ViewGroup viewGroup = null;
                        try {
                            if (DuiInterface.this.activity != null) {
                                viewGroup = (ViewGroup) DuiInterface.this.activity.findViewById(i);
                            }
                            if (viewGroup == null && DuiInterface.this.container != null) {
                                viewGroup = (ViewGroup) DuiInterface.this.container.findViewById(i);
                            }
                            JuspayCallback juspayCallback = DuiInterface.this.browserFragment.getJuspayCallback();
                            if (viewGroup != null && (juspayCallback instanceof HyperPaymentsCallback)) {
                                DuiInterface.this.merchantViewIds.add(Integer.valueOf(i));
                                View merchantView = ((HyperPaymentsCallback) juspayCallback).getMerchantView(viewGroup, MerchantViewType.valueOf(str));
                                if (merchantView != null) {
                                    viewGroup.addView(merchantView);
                                }
                            }
                        } catch (Exception e2) {
                            DuiInterface.this.sdkTracker.trackAndLogException(DuiInterface.LOG_TAG, "action", "system", System.JBRIDGE, "Error while attaching merchant view", e2);
                        }
                    }
                });
            }
        }
    }

    @JavascriptInterface
    public String checkPermission(String[] strArr) {
        JSONObject jSONObject = new JSONObject();
        int i = 0;
        while (i < strArr.length) {
            try {
                jSONObject.put(strArr[i].replace("android.permission.", ""), Utils.checkIfGranted(this.juspayServices, strArr[i]));
                i++;
            } catch (JSONException e2) {
                this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.READ_SMS_PERMISSION, "Error while inserting in json", e2);
            }
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public String checkReadSMSPermission() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("android.permission.READ_SMS".replace("android.permission.", ""), Utils.checkIfGranted(this.juspayServices, "android.permission.READ_SMS"));
            jSONObject.put("android.permission.RECEIVE_SMS".replace("android.permission.", ""), Utils.checkIfGranted(this.juspayServices, "android.permission.RECEIVE_SMS"));
        } catch (JSONException e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.READ_SMS_PERMISSION, "Error while inserting in json", e2);
        }
        return jSONObject.toString();
    }

    public void clearMerchantViews(final Activity activity2) {
        if (activity2 != null) {
            activity2.runOnUiThread(new Runnable() {
                public void run() {
                    Iterator it = DuiInterface.this.merchantViewIds.iterator();
                    while (it.hasNext()) {
                        View findViewById = activity2.findViewById(((Integer) it.next()).intValue());
                        if (findViewById instanceof ViewGroup) {
                            ((ViewGroup) findViewById).removeAllViews();
                        }
                    }
                }
            });
        }
    }

    @JavascriptInterface
    public void closeBrowser(String str) {
        reset();
    }

    @JavascriptInterface
    public void detach(String[] strArr) {
        for (String str : strArr) {
            if (this.listenerMap.containsKey(str) && this.activity != null) {
                if (this.listenerMap.get(str) instanceof JuspayDuiHook) {
                    ((JuspayDuiHook) this.listenerMap.get(str)).detach(this.activity);
                }
                this.listenerMap.remove(str);
            }
        }
    }

    @JavascriptInterface
    public void doHandShake(String str, String str2) {
        try {
            SdkTracker sdkTracker2 = this.sdkTracker;
            sdkTracker2.trackAction("system", "info", System.JBRIDGE, "dui_interface_do_handshake", "Doing handshake with following parameters: " + str);
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("packageName");
            String string2 = jSONObject.getString("className");
            int i = jSONObject.getInt("code");
            JSONObject jSONObject2 = new JSONObject(jSONObject.getString("payload"));
            Bundle bundle = new Bundle();
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle.putString(next, jSONObject2.getString(next));
            }
            MPINUtil.communicate(string, string2, i, bundle, this.browserFragment, str2);
        } catch (Exception e2) {
            MPINUtil.reportBindFailure(-1, this.browserFragment, str2);
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "Exception at doHandShake", e2);
        }
    }

    @JavascriptInterface
    public String execute(String str, String str2, String str3, String str4) {
        try {
            JSONObject jSONObject = new JSONObject(str3);
            if (this.listenerMap.containsKey(str) && this.activity != null) {
                return ((JuspayDuiHook) this.listenerMap.get(str)).execute(this.activity, str2, jSONObject, str4);
            }
        } catch (JSONException e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, GeneratedOutlineSupport.outline53("Error while executing ", str2, " with args ", str3), e2);
        }
        return "";
    }

    @JavascriptInterface
    public String fetchFromInbox(String str) {
        Activity activity2 = this.activity;
        return activity2 != null ? PaymentUtils.readSmsFromInbox(this.juspayServices, activity2, str) : "";
    }

    @JavascriptInterface
    public String getClipboardItems() {
        try {
            ClipboardManager clipboardManager = (ClipboardManager) this.context.getSystemService("clipboard");
            if (clipboardManager != null) {
                return new JSONArray(ClipboardListener.getClipboardItems(clipboardManager, this.juspayServices)).toString();
            }
            this.sdkTracker.trackAction("system", "error", System.CLIPBOARD, "missing", "clipboardManager");
            return new JSONArray().toString();
        } catch (Exception e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.CLIPBOARD, "Error while trying to get clipboard items", e2);
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
    }

    @JavascriptInterface
    public String getConfigVariables() {
        try {
            return PaymentUtils.getConfigVariableDeclarations(this.juspayServices.getContext(), this.juspayServices.getSessionInfo());
        } catch (JSONException e2) {
            JuspayLogger.e(LOG_TAG, "", e2);
            return "var clientId = null;var juspayDeviceId = null;var juspayAndroidId = null;var godelRemotesVersion = null;var godelVersion = null;var buildVersion = null;var os_version = null;";
        }
    }

    @JavascriptInterface
    public String getDataFromSharedPrefs(String str, String str2) {
        return KeyValueStore.read(this.juspayServices, str, str2);
    }

    @JavascriptInterface
    public String getIndexBundleHash(String str) {
        String replace = str.replace(".zip", ".jsa");
        try {
            return this.remoteAssetService.getMetadata(replace.substring(replace.lastIndexOf("/") + 1).replace(".zip", ".jsa")).getString(PaymentConstants.ATTR_HASH_IN_DISK);
        } catch (Exception e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "exception during IndexBundleHash", e2);
            return null;
        }
    }

    @JavascriptInterface
    public String getKeysInSharedPrefs() {
        try {
            JSONArray jSONArray = new JSONArray();
            for (String put : KeyValueStore.getAll(this.juspayServices).keySet()) {
                jSONArray.put(put);
            }
            return jSONArray.toString();
        } catch (Exception e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.SHARED_PREF, "Exception while getting all keys from shared prefs", e2);
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
    }

    @JavascriptInterface
    public String getNetworkType() {
        return this.sessionInfo.getNetworkInfo();
    }

    @JavascriptInterface
    public String getPackageInfo(String str) {
        HyperFragment hyperFragment = this.browserFragment;
        if (hyperFragment != null) {
            try {
                PackageInfo packageInfo = hyperFragment.getContext().getPackageManager().getPackageInfo(str, 0);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("packageName", packageInfo.packageName);
                jSONObject.put(Constant.HEADER_APP_VERSION_NAME, packageInfo.versionName);
                jSONObject.put(Response.VERSION_CODE, packageInfo.versionCode);
                return jSONObject.toString();
            } catch (Exception e2) {
                this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "Exception at getPackageInfo", e2);
            }
        }
        return "{}";
    }

    @JavascriptInterface
    public String getPaymentDetails() {
        return this.browserFragment.getPaymentSessionInfo().getPaymentDetails().toString();
    }

    @JavascriptInterface
    public float getPixels() {
        return this.context.getResources().getDisplayMetrics().density;
    }

    @JavascriptInterface
    public int getResourceIdentifier(String str, String str2) {
        try {
            return this.context.getResources().getIdentifier(str, str2, this.context.getPackageName());
        } catch (Exception unused) {
            return 0;
        }
    }

    @JavascriptInterface
    public String getSessionAttribute(String str) {
        return getSessionAttribute(str, "");
    }

    @JavascriptInterface
    public String getSessionDetails() {
        return this.browserFragment.getPaymentSessionInfo().getSessionDetails().toString();
    }

    @JavascriptInterface
    public String getSessionInfo() {
        this.browserFragment.getPaymentSessionInfo().createSessionDataMap();
        return this.sessionInfo.getSessionData().toString();
    }

    @JavascriptInterface
    public void invokeCallbackInACSWebview(String str, String str2) {
        if (this.browserFragment != null) {
            final String format = String.format("window.__PROXY_FN['%s'](atob('%s'))", new Object[]{str, Base64.encodeToString(str2.getBytes(), 2)});
            final JuspayWebView juspayWebView = getJuspayWebView();
            Activity activity2 = this.activity;
            if (!(activity2 == null || juspayWebView == null)) {
                activity2.runOnUiThread(new Runnable() {
                    public void run() {
                        juspayWebView.addJsToWebView(format);
                    }
                });
            }
        }
    }

    @JavascriptInterface
    public void invokeCallbackInDUIWebview(String str, String str2) {
        String format = String.format("window.callUICallback('%s',atob('%s'));", new Object[]{str, Base64.encodeToString(str2.getBytes(), 2)});
        DynamicUI dynamicUI2 = this.dynamicUI;
        if (dynamicUI2 != null) {
            dynamicUI2.addJsToWebView(format);
        }
    }

    @JavascriptInterface
    public void invokeCustomFnInDUIWebview(String str) {
        DynamicUI dynamicUI2 = this.dynamicUI;
        if (dynamicUI2 != null) {
            dynamicUI2.addJsToWebView(str);
        }
    }

    @JavascriptInterface
    public void invokeFnInDUIWebview(String str, String str2) {
        this.dynamicUI.addJsToWebView(String.format("window[\"onEvent'\"]('%s',atob('%s'))", new Object[]{str, Base64.encodeToString(str2.getBytes(), 2)}));
    }

    @JavascriptInterface
    public void invokeFnInDUIWebview(String str, String str2, String str3) {
        HyperFragment hyperFragment = this.browserFragment;
        if (hyperFragment != null && hyperFragment.getAcsInterface() != null) {
            this.browserFragment.getAcsInterface().invoke(str, str2, str3);
        }
    }

    @JavascriptInterface
    public void invokeInACSWebview(String str, String str2) {
        if (this.browserFragment != null) {
            final String format = String.format("javascript:window.onAcsFunctionCalled('%s',atob('%s'))", new Object[]{str, Base64.encodeToString(str2.getBytes(), 2)});
            final JuspayWebView juspayWebView = getJuspayWebView();
            Activity activity2 = this.activity;
            if (!(activity2 == null || juspayWebView == null)) {
                activity2.runOnUiThread(new Runnable() {
                    public void run() {
                        juspayWebView.addJsToWebView(format);
                    }
                });
            }
        }
    }

    @JavascriptInterface
    public void invokeInACSWebview(String str, String str2, String str3) {
        if (this.browserFragment != null) {
            final String format = String.format("javascript:window.onAcsFunctionCalled('%s',atob('%s'),'%s')", new Object[]{str, Base64.encodeToString(str2.getBytes(), 2), str3});
            final JuspayWebView juspayWebView = getJuspayWebView();
            if (juspayWebView != null) {
                Activity activity2 = this.activity;
                if (activity2 != null) {
                    activity2.runOnUiThread(new Runnable() {
                        public void run() {
                            juspayWebView.addJsToWebView(format);
                        }
                    });
                }
            }
        }
    }

    @JavascriptInterface
    public String isAppInstalled(String str) {
        HyperFragment hyperFragment = this.browserFragment;
        if (hyperFragment != null) {
            try {
                hyperFragment.getContext().getPackageManager().getPackageInfo(str, 128);
            } catch (NameNotFoundException unused) {
                return BaseParser.FALSE;
            }
        }
        return BaseParser.TRUE;
    }

    @JavascriptInterface
    public String isDeviceSecure() {
        try {
            if (VERSION.SDK_INT >= 23) {
                KeyguardManager keyguardManager = (KeyguardManager) this.context.getSystemService("keyguard");
                if (keyguardManager != null) {
                    return keyguardManager.isDeviceSecure() ? "SECURE" : "NOT_SECURE";
                }
            }
        } catch (Exception e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "Exception while checking KeyguardManager.isDeviceSecure()", e2);
        }
        return "UNKNOWN";
    }

    @android.webkit.JavascriptInterface
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isHookSupported(java.lang.String r8) {
        /*
            r7 = this;
            int r0 = r8.hashCode()
            r1 = 0
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r0) {
                case -1102737597: goto L_0x0040;
                case -1031869708: goto L_0x0036;
                case -901079619: goto L_0x002c;
                case 1186196854: goto L_0x0022;
                case 1205336831: goto L_0x0018;
                case 2031367170: goto L_0x000e;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x004a
        L_0x000e:
            java.lang.String r0 = "SEND_SMS"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x004a
            r8 = 4
            goto L_0x004b
        L_0x0018:
            java.lang.String r0 = "DELIVER_SMS"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x004a
            r8 = 5
            goto L_0x004b
        L_0x0022:
            java.lang.String r0 = "CLIPBOARD"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x004a
            r8 = 2
            goto L_0x004b
        L_0x002c:
            java.lang.String r0 = "SMS_RECEIVE"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x004a
            r8 = 0
            goto L_0x004b
        L_0x0036:
            java.lang.String r0 = "SMS_CONSENT"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x004a
            r8 = 1
            goto L_0x004b
        L_0x0040:
            java.lang.String r0 = "NETWORK_STATUS"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x004a
            r8 = 3
            goto L_0x004b
        L_0x004a:
            r8 = -1
        L_0x004b:
            if (r8 == 0) goto L_0x0058
            if (r8 == r6) goto L_0x0058
            if (r8 == r5) goto L_0x0058
            if (r8 == r4) goto L_0x0058
            if (r8 == r3) goto L_0x0058
            if (r8 == r2) goto L_0x0058
            return r1
        L_0x0058:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.DuiInterface.isHookSupported(java.lang.String):boolean");
    }

    @JavascriptInterface
    public boolean isOnline() {
        Activity activity2 = this.activity;
        ConnectivityManager connectivityManager = activity2 != null ? (ConnectivityManager) activity2.getSystemService("connectivity") : null;
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @JavascriptInterface
    public void loadUrl(final String str, final String str2) {
        final JuspayWebView juspayWebView = getJuspayWebView();
        Activity activity2 = this.activity;
        if (activity2 != null && juspayWebView != null && str != null) {
            activity2.runOnUiThread(new Runnable() {
                public void run() {
                    String str = str2;
                    if (str != null) {
                        juspayWebView.postUrl(str, str.getBytes());
                    } else {
                        juspayWebView.loadUrl(str);
                    }
                }
            });
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        String str;
        StringBuilder sb;
        for (Object next : this.listenerMap.values()) {
            if ((next instanceof ResultAwaitingDuiHook) && ((ResultAwaitingDuiHook) next).onActivityResult(i, i2, intent)) {
                SdkTracker sdkTracker2 = this.sdkTracker;
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Result consumed by ResultAwaitingDuiHook ");
                outline73.append(next.getClass().getName());
                sdkTracker2.trackAction("system", "info", System.JBRIDGE, Android.ON_ACTIVITY_RESULT, outline73.toString());
                return;
            }
        }
        if (intent != null) {
            JSONObject json = Utils.toJSON(intent.getExtras());
            String encodeToString = Base64.encodeToString(json.toString().getBytes(), 2);
            SdkTracker sdkTracker3 = this.sdkTracker;
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Passing data to micro-app. Data is ");
            outline732.append(json.toString());
            sdkTracker3.trackAction("system", "info", System.JBRIDGE, Android.ON_ACTIVITY_RESULT, outline732.toString());
            sb = GeneratedOutlineSupport.outline75("window.onActivityResult('", i, "', '", i2, "', atob('");
            sb.append(encodeToString);
            str = "'))";
        } else {
            this.sdkTracker.trackAction("system", "info", System.JBRIDGE, Android.ON_ACTIVITY_RESULT, "Got empty data in onActivityResult. Passing callback to micro-app.");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("window.onActivityResult('");
            sb2.append(i);
            sb2.append("', '");
            sb2.append(i2);
            str = "', '{}')";
            sb = sb2;
        }
        sb.append(str);
        invokeFnInDUIWebview(sb.toString());
    }

    @JavascriptInterface
    public void onDuiReady() {
        HyperFragment hyperFragment = this.browserFragment;
        if (hyperFragment != null) {
            hyperFragment.onDuiReady();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        try {
            Map<String, Object> map = this.listenerMap;
            Object obj = map.get(PaymentConstants.REQUEST_PERMISSION_PREFIX + i);
            if (obj instanceof String) {
                JSONObject jSONObject = new JSONObject();
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    jSONObject.put(strArr[i2].replace("android.permission.", ""), iArr[i2] == 0);
                }
                invokeCallbackInDUIWebview((String) obj, jSONObject.toString());
            } else if (obj instanceof Callback) {
                Message obtain = Message.obtain();
                obtain.obj = iArr;
                ((Callback) obj).handleMessage(obtain);
            } else {
                JuspayLogger.e(LOG_TAG, "callback instance not understandable");
            }
        } catch (Exception e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.ON_REQUEST_PERMISSION_RESULT, "Error while inserting in json", e2);
        }
    }

    @JavascriptInterface
    public void onWebViewReady(String str, String str2) {
        if (URLUtil.isValidUrl(str2)) {
            onWebViewReady(str, str2, null);
        } else {
            this.sdkTracker.trackAction("system", "error", System.ON_WEBVIEW_READY, "valid_url", Boolean.FALSE);
        }
    }

    @JavascriptInterface
    public void onWebViewReady(String str, String str2, String str3) {
        HyperFragment hyperFragment = this.browserFragment;
        if (hyperFragment != null) {
            hyperFragment.onBrowserReady(str2, str3, str);
        }
    }

    @JavascriptInterface
    public void onWebViewReady(String str, String str2, String str3, String str4) {
        if (str4.equalsIgnoreCase("base64")) {
            try {
                byte[] decode = Base64.decode(str3, 2);
                if (this.browserFragment != null) {
                    this.browserFragment.onBrowserReady(str2, new String(decode), RNCWebViewManager.HTML_MIME_TYPE, "UTF-8", null, str);
                }
            } catch (Exception e2) {
                this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.ON_WEBVIEW_READY, "Exception while trying to decode content", e2);
            }
        } else {
            String str5 = str3;
            HyperFragment hyperFragment = this.browserFragment;
            if (hyperFragment != null) {
                hyperFragment.onBrowserReady(str2, str3, RNCWebViewManager.HTML_MIME_TYPE, "UTF-8", null, str);
            }
        }
    }

    @JavascriptInterface
    public void onWebViewReleased() {
        HyperFragment hyperFragment = this.browserFragment;
        if (hyperFragment != null) {
            hyperFragment.onDuiReleased();
        }
    }

    @JavascriptInterface
    public void openAppWithExplicitIntent(String str, String str2, String str3, int i, int i2) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("data", str3);
            Intent intent = new Intent();
            if (i2 >= 0) {
                intent.setFlags(i2);
            }
            intent.putExtras(bundle);
            intent.setComponent(new ComponentName(str, str2));
            if (i >= 0 && this.browserFragment != null) {
                this.browserFragment.startActivityForResult(intent, i);
            } else if (this.browserFragment != null) {
                this.browserFragment.startActivity(intent);
            }
        } catch (Exception e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "on method openAppWithExplicitIntent: ", e2);
        }
    }

    @JavascriptInterface
    public void refreshPage() {
        PaymentUtils.refreshPage(getJuspayWebView());
    }

    @JavascriptInterface
    public void requestKeyboardHide() {
        Activity activity2 = this.activity;
        if (activity2 != null) {
            activity2.runOnUiThread(new Runnable() {
                public void run() {
                    SdkTracker access$300;
                    String str;
                    String str2;
                    String str3;
                    String str4;
                    String str5;
                    try {
                        if (DuiInterface.this.browserFragment != null) {
                            View currentFocus = DuiInterface.this.activity.getCurrentFocus();
                            if (currentFocus == null) {
                                currentFocus = DuiInterface.this.activity.getWindow().getDecorView();
                            }
                            InputMethodManager inputMethodManager = (InputMethodManager) DuiInterface.this.activity.getSystemService("input_method");
                            if (inputMethodManager == null || currentFocus.getRootView() == null) {
                                access$300 = DuiInterface.this.sdkTracker;
                                str = "system";
                                str2 = "error";
                                str3 = System.KEYBOARD;
                                str4 = "hidden";
                                str5 = "failed";
                            } else {
                                inputMethodManager.hideSoftInputFromWindow(currentFocus.getRootView().getWindowToken(), 0);
                                access$300 = DuiInterface.this.sdkTracker;
                                str = "system";
                                str2 = "info";
                                str3 = System.KEYBOARD;
                                str4 = "hidden";
                                str5 = "success";
                            }
                        } else {
                            DuiInterface.this.sdkTracker.trackAction("system", "error", System.KEYBOARD, "data", "hide");
                            access$300 = DuiInterface.this.sdkTracker;
                            str = "system";
                            str2 = "error";
                            str3 = System.KEYBOARD;
                            str4 = "missing";
                            str5 = "browserFragment";
                        }
                        access$300.trackAction(str, str2, str3, str4, str5);
                    } catch (Exception e2) {
                        DuiInterface.this.sdkTracker.trackAndLogException(DuiInterface.LOG_TAG, "action", "system", System.KEYBOARD, "Hide Keyboard Exception", e2);
                    }
                }
            });
        }
    }

    @JavascriptInterface
    public void requestKeyboardShow() {
        JuspayWebView juspayWebView = getJuspayWebView();
        Activity activity2 = this.activity;
        if (activity2 != null && juspayWebView != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity2.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(juspayWebView, 1);
            }
        }
    }

    @JavascriptInterface
    public void requestKeyboardShow(final String str) {
        Activity activity2 = this.activity;
        if (activity2 != null) {
            activity2.runOnUiThread(new Runnable() {
                public void run() {
                    try {
                        if (DuiInterface.this.activity != null && DuiInterface.this.browserFragment != null) {
                            int parseInt = Integer.parseInt(str);
                            InputMethodManager inputMethodManager = (InputMethodManager) DuiInterface.this.activity.getSystemService("input_method");
                            View findViewById = DuiInterface.this.activity.findViewById(parseInt);
                            View view = null;
                            if (DuiInterface.this.lastFocusedEditView != -1) {
                                view = DuiInterface.this.activity.findViewById(DuiInterface.this.lastFocusedEditView);
                            }
                            if (!(inputMethodManager == null || findViewById == null)) {
                                if (!(view == null || DuiInterface.this.lastFocusedEditView == parseInt)) {
                                    view.clearFocus();
                                }
                                findViewById.requestFocus();
                                inputMethodManager.showSoftInput(findViewById, 1);
                            }
                            if (parseInt != DuiInterface.this.lastFocusedEditView) {
                                DuiInterface.this.lastFocusedEditView = Integer.parseInt(str);
                            }
                        }
                    } catch (Exception e2) {
                        DuiInterface.this.sdkTracker.trackAndLogException(DuiInterface.LOG_TAG, "action", "system", System.KEYBOARD, "Show Keyboard Exception", e2);
                    }
                }
            });
        }
    }

    public void requestPermission(String[] strArr, String str, Callback callback) {
        HyperFragment hyperFragment = this.browserFragment;
        if (hyperFragment != null) {
            hyperFragment.requestPermissionsCheckingAllowed(strArr, Integer.parseInt(str));
            Map<String, Object> map = this.listenerMap;
            map.put(PaymentConstants.REQUEST_PERMISSION_PREFIX + str, callback);
        }
    }

    @JavascriptInterface
    public void requestPermission(String[] strArr, String str, String str2) {
        HyperFragment hyperFragment = this.browserFragment;
        if (hyperFragment != null) {
            hyperFragment.requestPermissionsCheckingAllowed(strArr, Integer.parseInt(str));
            Map<String, Object> map = this.listenerMap;
            map.put(PaymentConstants.REQUEST_PERMISSION_PREFIX + str, str2);
        }
    }

    @JavascriptInterface
    public void requestSMSPermission(String str) {
        requestPermission(new String[]{"android.permission.READ_SMS", "android.permission.RECEIVE_SMS"}, String.valueOf(7), str);
    }

    public void reset() {
        try {
            ArrayList arrayList = new ArrayList();
            for (String next : this.listenerMap.keySet()) {
                if (this.listenerMap.get(next) instanceof JuspayDuiHook) {
                    arrayList.add(next);
                }
            }
            detach((String[]) arrayList.toArray(new String[arrayList.size()]));
        } catch (Exception e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "Exception while removing Dui Hooks", e2);
        }
    }

    @android.webkit.JavascriptInterface
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void runInJuspayBrowser(java.lang.String r9, final java.lang.String r10, final java.lang.String r11) {
        /*
            r8 = this;
            in.juspay.hypersdk.core.JuspayServices r0 = r8.juspayServices
            in.juspay.hypersdk.core.SdkTracker r0 = r0.getSdkTracker()
            int r1 = r9.hashCode()
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r1) {
                case -1881018714: goto L_0x002f;
                case -1349867671: goto L_0x0025;
                case -1349761029: goto L_0x001b;
                case -245602922: goto L_0x0011;
                default: goto L_0x0010;
            }
        L_0x0010:
            goto L_0x0039
        L_0x0011:
            java.lang.String r1 = "onStartWaitingDialogCreated"
            boolean r1 = r9.equals(r1)
            if (r1 == 0) goto L_0x0039
            r1 = 2
            goto L_0x003a
        L_0x001b:
            java.lang.String r1 = "onEvent"
            boolean r1 = r9.equals(r1)
            if (r1 == 0) goto L_0x0039
            r1 = 3
            goto L_0x003a
        L_0x0025:
            java.lang.String r1 = "onError"
            boolean r1 = r9.equals(r1)
            if (r1 == 0) goto L_0x0039
            r1 = 0
            goto L_0x003a
        L_0x002f:
            java.lang.String r1 = "onBundleLoaded"
            boolean r1 = r9.equals(r1)
            if (r1 == 0) goto L_0x0039
            r1 = 1
            goto L_0x003a
        L_0x0039:
            r1 = -1
        L_0x003a:
            if (r1 == 0) goto L_0x00e5
            if (r1 == r4) goto L_0x00e2
            if (r1 == r3) goto L_0x00d1
            if (r1 == r2) goto L_0x0050
            java.lang.String r10 = "system"
            java.lang.String r11 = "error"
            java.lang.String r0 = "run_in_juspay_browser"
            java.lang.String r1 = "missing"
            in.juspay.hypersdk.core.SdkTracker.trackBootAction(r10, r11, r0, r1, r9)
            goto L_0x00ea
        L_0x0050:
            in.juspay.hypersdk.core.HyperFragment r9 = r8.browserFragment
            java.lang.String r1 = "onJOSReady"
            java.lang.String r2 = "event"
            if (r9 == 0) goto L_0x00a9
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0087 }
            r9.<init>(r10)     // Catch:{ JSONException -> 0x0087 }
            java.lang.String r3 = ""
            java.lang.String r9 = r9.optString(r2, r3)     // Catch:{ JSONException -> 0x0087 }
            boolean r9 = r9.equals(r1)     // Catch:{ JSONException -> 0x0087 }
            if (r9 == 0) goto L_0x0097
            in.juspay.hypersdk.core.HyperFragment r9 = r8.browserFragment     // Catch:{ JSONException -> 0x0087 }
            boolean r9 = r9.getPreFetchMode()     // Catch:{ JSONException -> 0x0087 }
            if (r9 == 0) goto L_0x007c
            in.juspay.hypersdk.core.HyperFragment r9 = r8.browserFragment     // Catch:{ JSONException -> 0x0087 }
            java.lang.String r1 = "prefetch"
            in.juspay.hypersdk.core.HyperFragment r2 = r8.browserFragment     // Catch:{ JSONException -> 0x0087 }
        L_0x0077:
            org.json.JSONObject r2 = r2.getBundleParameters()     // Catch:{ JSONException -> 0x0087 }
            goto L_0x0083
        L_0x007c:
            in.juspay.hypersdk.core.HyperFragment r9 = r8.browserFragment     // Catch:{ JSONException -> 0x0087 }
            java.lang.String r1 = "initiate"
            in.juspay.hypersdk.core.HyperFragment r2 = r8.browserFragment     // Catch:{ JSONException -> 0x0087 }
            goto L_0x0077
        L_0x0083:
            r9.onMerchantEvent(r1, r2)     // Catch:{ JSONException -> 0x0087 }
            goto L_0x00ea
        L_0x0087:
            r9 = move-exception
            r7 = r9
            java.lang.String r2 = "DuiInterface"
            java.lang.String r3 = "lifecycle"
            java.lang.String r4 = "hypersdk"
            java.lang.String r5 = "run_in_juspay_browser"
            java.lang.String r6 = "error while dealing with json onEvent"
            r1 = r0
            r1.trackAndLogException(r2, r3, r4, r5, r6, r7)
        L_0x0097:
            android.os.Handler r9 = new android.os.Handler
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            r9.<init>(r1)
            in.juspay.hypersdk.core.DuiInterface$7 r1 = new in.juspay.hypersdk.core.DuiInterface$7
            r1.<init>(r10, r11, r0)
            r9.post(r1)
            goto L_0x00ea
        L_0x00a9:
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00bc }
            r9.<init>(r10)     // Catch:{ JSONException -> 0x00bc }
            java.lang.String r9 = r9.getString(r2)     // Catch:{ JSONException -> 0x00bc }
            boolean r9 = r9.equals(r1)     // Catch:{ JSONException -> 0x00bc }
            if (r9 == 0) goto L_0x00ea
            in.juspay.hypersdk.core.PrefetchServices.prefetchOnEvent()     // Catch:{ JSONException -> 0x00bc }
            goto L_0x00ea
        L_0x00bc:
            r9 = move-exception
            r7 = r9
            java.lang.String r9 = "error while dealing with json onEvent "
            java.lang.String r6 = com.android.tools.r8.GeneratedOutlineSupport.outline50(r9, r10)
            java.lang.String r2 = "DuiInterface"
            java.lang.String r3 = "lifecycle"
            java.lang.String r4 = "hypersdk"
            java.lang.String r5 = "run_in_juspay_browser"
            r1 = r0
            r1.trackAndLogException(r2, r3, r4, r5, r6, r7)
            goto L_0x00ea
        L_0x00d1:
            android.app.Activity r9 = r8.activity
            if (r9 == 0) goto L_0x00ea
            in.juspay.hypersdk.core.HyperFragment r11 = r8.browserFragment
            if (r11 == 0) goto L_0x00ea
            in.juspay.hypersdk.core.DuiInterface$6 r11 = new in.juspay.hypersdk.core.DuiInterface$6
            r11.<init>(r10, r0)
            r9.runOnUiThread(r11)
            goto L_0x00ea
        L_0x00e2:
            java.lang.String r9 = "loaded"
            goto L_0x00e7
        L_0x00e5:
            java.lang.String r9 = "not_loaded"
        L_0x00e7:
            r8.updateLoaded(r10, r9)
        L_0x00ea:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.DuiInterface.runInJuspayBrowser(java.lang.String, java.lang.String, java.lang.String):void");
    }

    @JavascriptInterface
    public void runInJuspayWebView(final String str) {
        final JuspayWebView juspayWebView = getJuspayWebView();
        if (this.browserFragment != null && juspayWebView != null) {
            Activity activity2 = this.activity;
            if (activity2 != null) {
                activity2.runOnUiThread(new Runnable() {
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                            r5 = this;
                            java.lang.String r0 = r4
                            int r1 = r0.hashCode()
                            switch(r1) {
                                case -2056769213: goto L_0x0046;
                                case -1576267742: goto L_0x003c;
                                case -1326530834: goto L_0x0032;
                                case -1241591313: goto L_0x0028;
                                case -934641255: goto L_0x001e;
                                case -318289731: goto L_0x0014;
                                case 1275285273: goto L_0x000a;
                                default: goto L_0x0009;
                            }
                        L_0x0009:
                            goto L_0x0050
                        L_0x000a:
                            java.lang.String r1 = "loadFirstPage"
                            boolean r0 = r0.equals(r1)
                            if (r0 == 0) goto L_0x0050
                            r0 = 6
                            goto L_0x0051
                        L_0x0014:
                            java.lang.String r1 = "goForward"
                            boolean r0 = r0.equals(r1)
                            if (r0 == 0) goto L_0x0050
                            r0 = 5
                            goto L_0x0051
                        L_0x001e:
                            java.lang.String r1 = "reload"
                            boolean r0 = r0.equals(r1)
                            if (r0 == 0) goto L_0x0050
                            r0 = 3
                            goto L_0x0051
                        L_0x0028:
                            java.lang.String r1 = "goBack"
                            boolean r0 = r0.equals(r1)
                            if (r0 == 0) goto L_0x0050
                            r0 = 4
                            goto L_0x0051
                        L_0x0032:
                            java.lang.String r1 = "requestPasswordKeyboardShow"
                            boolean r0 = r0.equals(r1)
                            if (r0 == 0) goto L_0x0050
                            r0 = 2
                            goto L_0x0051
                        L_0x003c:
                            java.lang.String r1 = "requestNumericKeyboardShow"
                            boolean r0 = r0.equals(r1)
                            if (r0 == 0) goto L_0x0050
                            r0 = 0
                            goto L_0x0051
                        L_0x0046:
                            java.lang.String r1 = "requestPhoneKeyboardShow"
                            boolean r0 = r0.equals(r1)
                            if (r0 == 0) goto L_0x0050
                            r0 = 1
                            goto L_0x0051
                        L_0x0050:
                            r0 = -1
                        L_0x0051:
                            switch(r0) {
                                case 0: goto L_0x0089;
                                case 1: goto L_0x0083;
                                case 2: goto L_0x007d;
                                case 3: goto L_0x0077;
                                case 4: goto L_0x0071;
                                case 5: goto L_0x006b;
                                case 6: goto L_0x0063;
                                default: goto L_0x0054;
                            }
                        L_0x0054:
                            java.lang.String r0 = r4
                            java.lang.String r1 = "system"
                            java.lang.String r2 = "error"
                            java.lang.String r3 = "run_in_juspay_webview"
                            java.lang.String r4 = "missing"
                            in.juspay.hypersdk.core.SdkTracker.trackBootAction(r1, r2, r3, r4, r0)
                            goto L_0x008e
                        L_0x0063:
                            in.juspay.hypersdk.core.DuiInterface r0 = in.juspay.hypersdk.core.DuiInterface.this
                            in.juspay.hypersdk.core.HyperFragment r0 = r0.browserFragment
                            r0.loadPage()
                            goto L_0x008e
                        L_0x006b:
                            in.juspay.hypersdk.ui.JuspayWebView r0 = r0
                            r0.goForward()
                            goto L_0x008e
                        L_0x0071:
                            in.juspay.hypersdk.ui.JuspayWebView r0 = r0
                            r0.goBack()
                            goto L_0x008e
                        L_0x0077:
                            in.juspay.hypersdk.ui.JuspayWebView r0 = r0
                            in.juspay.hypersdk.core.PaymentUtils.refreshPage(r0)
                            goto L_0x008e
                        L_0x007d:
                            in.juspay.hypersdk.ui.JuspayWebView r0 = r0
                            r0.requestPasswordKeyboardShow()
                            goto L_0x008e
                        L_0x0083:
                            in.juspay.hypersdk.ui.JuspayWebView r0 = r0
                            r0.requestPhoneKeyboardShow()
                            goto L_0x008e
                        L_0x0089:
                            in.juspay.hypersdk.ui.JuspayWebView r0 = r0
                            r0.requestNumericKeyboardShow()
                        L_0x008e:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.DuiInterface.AnonymousClass8.run():void");
                    }
                });
            }
        }
    }

    @JavascriptInterface
    public void runInJuspayWebView(final String str, final String str2) {
        final JuspayWebView juspayWebView = getJuspayWebView();
        Activity activity2 = this.activity;
        if (activity2 != null && juspayWebView != null) {
            activity2.runOnUiThread(new Runnable() {
                /* JADX WARNING: Removed duplicated region for block: B:13:0x006f  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r8 = this;
                        in.juspay.hypersdk.ui.JuspayWebView r0 = r0     // Catch:{ NoSuchMethodException -> 0x0055, InvocationTargetException -> 0x0041, IllegalAccessException -> 0x002d }
                        java.lang.Class r0 = r0.getClass()     // Catch:{ NoSuchMethodException -> 0x0055, InvocationTargetException -> 0x0041, IllegalAccessException -> 0x002d }
                        java.lang.String r1 = r4     // Catch:{ NoSuchMethodException -> 0x0055, InvocationTargetException -> 0x0041, IllegalAccessException -> 0x002d }
                        r2 = 1
                        java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ NoSuchMethodException -> 0x0055, InvocationTargetException -> 0x0041, IllegalAccessException -> 0x002d }
                        r4 = 0
                        r5 = 0
                        r3[r5] = r4     // Catch:{ NoSuchMethodException -> 0x0055, InvocationTargetException -> 0x0041, IllegalAccessException -> 0x002d }
                        java.lang.reflect.Method r0 = r0.getMethod(r1, r3)     // Catch:{ NoSuchMethodException -> 0x0055, InvocationTargetException -> 0x0041, IllegalAccessException -> 0x002d }
                        in.juspay.hypersdk.ui.JuspayWebView r1 = r0     // Catch:{ NoSuchMethodException -> 0x0055, InvocationTargetException -> 0x0041, IllegalAccessException -> 0x002d }
                        java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ NoSuchMethodException -> 0x0055, InvocationTargetException -> 0x0041, IllegalAccessException -> 0x002d }
                        r2[r5] = r4     // Catch:{ NoSuchMethodException -> 0x0055, InvocationTargetException -> 0x0041, IllegalAccessException -> 0x002d }
                        java.lang.Object r0 = r0.invoke(r1, r2)     // Catch:{ NoSuchMethodException -> 0x0055, InvocationTargetException -> 0x0041, IllegalAccessException -> 0x002d }
                        java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ NoSuchMethodException -> 0x0055, InvocationTargetException -> 0x0041, IllegalAccessException -> 0x002d }
                        java.lang.String r1 = r5     // Catch:{ NoSuchMethodException -> 0x0055, InvocationTargetException -> 0x0041, IllegalAccessException -> 0x002d }
                        if (r1 == 0) goto L_0x002c
                        in.juspay.hypersdk.core.DuiInterface r1 = in.juspay.hypersdk.core.DuiInterface.this     // Catch:{ NoSuchMethodException -> 0x0055, InvocationTargetException -> 0x0041, IllegalAccessException -> 0x002d }
                        java.lang.String r2 = r5     // Catch:{ NoSuchMethodException -> 0x0055, InvocationTargetException -> 0x0041, IllegalAccessException -> 0x002d }
                        r1.invokeCallbackInDUIWebview(r2, r0)     // Catch:{ NoSuchMethodException -> 0x0055, InvocationTargetException -> 0x0041, IllegalAccessException -> 0x002d }
                    L_0x002c:
                        return
                    L_0x002d:
                        r0 = move-exception
                        r7 = r0
                        in.juspay.hypersdk.core.DuiInterface r0 = in.juspay.hypersdk.core.DuiInterface.this
                        in.juspay.hypersdk.core.SdkTracker r1 = r0.sdkTracker
                        java.lang.String r2 = "DuiInterface"
                        java.lang.String r3 = "action"
                        java.lang.String r4 = "system"
                        java.lang.String r5 = "run_in_juspay_webview"
                        java.lang.String r6 = "Not allowed to access"
                        goto L_0x0068
                    L_0x0041:
                        r0 = move-exception
                        r7 = r0
                        in.juspay.hypersdk.core.DuiInterface r0 = in.juspay.hypersdk.core.DuiInterface.this
                        in.juspay.hypersdk.core.SdkTracker r1 = r0.sdkTracker
                        java.lang.String r2 = "DuiInterface"
                        java.lang.String r3 = "action"
                        java.lang.String r4 = "system"
                        java.lang.String r5 = "run_in_juspay_webview"
                        java.lang.String r6 = "Error while Invoking"
                        goto L_0x0068
                    L_0x0055:
                        r0 = move-exception
                        r7 = r0
                        in.juspay.hypersdk.core.DuiInterface r0 = in.juspay.hypersdk.core.DuiInterface.this
                        in.juspay.hypersdk.core.SdkTracker r1 = r0.sdkTracker
                        java.lang.String r2 = "DuiInterface"
                        java.lang.String r3 = "action"
                        java.lang.String r4 = "system"
                        java.lang.String r5 = "run_in_juspay_webview"
                        java.lang.String r6 = "Method Not found"
                    L_0x0068:
                        r1.trackAndLogException(r2, r3, r4, r5, r6, r7)
                        java.lang.String r0 = r5
                        if (r0 == 0) goto L_0x0076
                        in.juspay.hypersdk.core.DuiInterface r1 = in.juspay.hypersdk.core.DuiInterface.this
                        java.lang.String r2 = ""
                        r1.invokeCallbackInDUIWebview(r0, r2)
                    L_0x0076:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.DuiInterface.AnonymousClass9.run():void");
                }
            });
        }
    }

    public void setActivity(Activity activity2) {
        this.activity = activity2;
    }

    @JavascriptInterface
    public void setCardBrand(String str) {
        this.browserFragment.getPaymentSessionInfo().setPaymentDetails("card_brand", str);
    }

    @JavascriptInterface
    public void setConfig(String str) {
        try {
            this.browserFragment.setConfig(new JSONObject(str));
        } catch (JSONException e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "Error while capturing config json", e2);
        }
    }

    public void setContainer(ViewGroup viewGroup) {
        this.container = viewGroup;
    }

    @JavascriptInterface
    public void setIsRupaySupportedAdded(boolean z) {
        PaymentUtils.setIsRupaySupportedAdded(z);
    }

    @JavascriptInterface
    public void setSessionDetails(String str, String str2) {
        this.browserFragment.getPaymentSessionInfo().addToSessionDetails(str, str2);
    }

    @JavascriptInterface
    public void setSessionInfo() {
    }

    @JavascriptInterface
    public String shouldShowRequestPermissionRationale(String str) {
        try {
            if (this.activity != null && VERSION.SDK_INT >= 23) {
                return String.valueOf(this.activity.shouldShowRequestPermissionRationale(str));
            }
        } catch (Exception e2) {
            this.sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.PERMISSION, "Exception while checking shouldShowRequestPermissionRationale", e2);
        }
        return null;
    }

    @JavascriptInterface
    public void storeCookies() {
        CookieSyncManager.getInstance().sync();
    }

    @JavascriptInterface
    public void suppressKeyboard() {
        Activity activity2 = this.activity;
        if (activity2 != null) {
            activity2.runOnUiThread(new Runnable() {
                public void run() {
                    DuiInterface.this.activity.getWindow().setSoftInputMode(3);
                }
            });
        }
    }

    @JavascriptInterface
    public void updateLoaded(String str, String str2) {
        SdkTracker sdkTracker2 = this.juspayServices.getSdkTracker();
        String str3 = "";
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(Constants.DOWNLOADER_FILE_NAME)) {
                str3 = jSONObject.getString(Constants.DOWNLOADER_FILE_NAME);
            }
            JSONObject jSONObject2 = new JSONObject(getDataFromSharedPrefs(PaymentConstants.JP_HASH_AND_STATUS, "{}"));
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject2.has(str3)) {
                jSONObject3 = jSONObject2.getJSONObject(str3);
            } else {
                SdkTracker.trackBootAction("system", "critical", HyperSdk.AUTO_FALLBACK, AnalyticsConstants.LOADED, "hash doesn't have a filename");
            }
            jSONObject3.put("status", str2);
            jSONObject2.put(str3, jSONObject3);
            addDataToSharedPrefs(PaymentConstants.JP_HASH_AND_STATUS, jSONObject2.toString());
            JuspayLogger.d(LOG_TAG, "udpateLoaded: ");
        } catch (Exception e2) {
            sdkTracker2.trackAndLogException(LOG_TAG, LogCategory.LIFECYCLE, LifeCycle.HYPER_SDK, HyperSdk.AUTO_FALLBACK, GeneratedOutlineSupport.outline50("Exception while updating the loaded status for file ", str3), e2);
        }
    }
}
