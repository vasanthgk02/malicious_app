package in.juspay.hypersdk.core;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.network.NetworkingModule;
import in.juspay.hypersdk.analytics.LogPusher;
import in.juspay.hypersdk.analytics.LogSessioniser;
import in.juspay.hypersdk.core.Labels.System;
import in.juspay.hypersdk.data.KeyValueStore;
import in.juspay.hypersdk.data.SessionInfo;
import in.juspay.hypersdk.security.EncryptionHelper;
import in.juspay.hypersdk.services.FileProviderService;
import in.juspay.hypersdk.services.RemoteAssetService;
import in.juspay.hypersdk.ui.JuspayWebView;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

public class JsInterface {
    public static final String LOG_TAG = "JsInterface";
    public static final int maxSecondsToLoad = 60;
    public final Context context;
    public final FileProviderService fileProviderService;
    public final JuspayServices juspayServices;
    public JuspayWebView juspayWebView;
    public final RemoteAssetService remoteAssetService;
    public final SdkTracker sdkTracker;
    public final SessionInfo sessionInfo;

    public JsInterface(JuspayServices juspayServices2) {
        this.context = juspayServices2.getContext();
        this.juspayServices = juspayServices2;
        this.sessionInfo = juspayServices2.getSessionInfo();
        this.sdkTracker = juspayServices2.getSdkTracker();
        this.remoteAssetService = juspayServices2.getRemoteAssetService();
        this.fileProviderService = juspayServices2.getFileProviderService();
    }

    @JavascriptInterface
    public void addToLogList(String str) {
        if (this.sessionInfo.getSessionId() != null) {
            this.sdkTracker.track(str);
        } else {
            SdkTracker.addToBootLogs(str);
        }
    }

    @JavascriptInterface
    public String getFilePath(String str) {
        return this.fileProviderService.appendSdkNameAndVersion(str);
    }

    @JavascriptInterface
    public String getFromSharedPrefs(String str) {
        return KeyValueStore.read(this.juspayServices, str, "__failed");
    }

    public JuspayWebView getJuspayWebView() {
        return this.juspayWebView;
    }

    @JavascriptInterface
    public String getLogList() {
        JuspayLogger.e(LOG_TAG, "No one should call JBridge.getLogList() method. It will be removed in future.");
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    @JavascriptInterface
    public String getMd5(String str) {
        return EncryptionHelper.md5(str.getBytes());
    }

    @JavascriptInterface
    public String getResourceById(int i) {
        return this.context.getResources().getString(i);
    }

    @JavascriptInterface
    public String getResourceByName(String str) {
        return getResourceById(this.context.getResources().getIdentifier(str, NetworkingModule.REQUEST_BODY_KEY_STRING, this.context.getPackageName()));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:2|3|4|5|(1:7)(1:8)|9|(1:11)|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0097, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0098, code lost:
        r1.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x004d */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0068 A[Catch:{ JSONException -> 0x0097 }] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0055 A[Catch:{ JSONException -> 0x0097 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x005c A[Catch:{ JSONException -> 0x0097 }] */
    @android.webkit.JavascriptInterface
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getRootFragmentSize() {
        /*
            r6 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            in.juspay.hypersdk.core.JuspayServices r1 = r6.juspayServices
            android.widget.FrameLayout r1 = r1.getContainer()
            java.lang.String r2 = "width"
            java.lang.String r3 = "height"
            java.lang.String r4 = ""
            if (r1 == 0) goto L_0x0072
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x004d }
            r1.<init>()     // Catch:{ JSONException -> 0x004d }
            in.juspay.hypersdk.core.JuspayServices r5 = r6.juspayServices     // Catch:{ JSONException -> 0x004d }
            android.widget.FrameLayout r5 = r5.getContainer()     // Catch:{ JSONException -> 0x004d }
            int r5 = r5.getHeight()     // Catch:{ JSONException -> 0x004d }
            r1.append(r5)     // Catch:{ JSONException -> 0x004d }
            r1.append(r4)     // Catch:{ JSONException -> 0x004d }
            java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x004d }
            r0.put(r3, r1)     // Catch:{ JSONException -> 0x004d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x004d }
            r1.<init>()     // Catch:{ JSONException -> 0x004d }
            in.juspay.hypersdk.core.JuspayServices r5 = r6.juspayServices     // Catch:{ JSONException -> 0x004d }
            android.widget.FrameLayout r5 = r5.getContainer()     // Catch:{ JSONException -> 0x004d }
            int r5 = r5.getWidth()     // Catch:{ JSONException -> 0x004d }
            r1.append(r5)     // Catch:{ JSONException -> 0x004d }
            r1.append(r4)     // Catch:{ JSONException -> 0x004d }
            java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x004d }
            r0.put(r2, r1)     // Catch:{ JSONException -> 0x004d }
            goto L_0x009b
        L_0x004d:
            in.juspay.hypersdk.data.SessionInfo r1 = r6.sessionInfo     // Catch:{ JSONException -> 0x0097 }
            java.lang.String r1 = r1.getScreenHeight()     // Catch:{ JSONException -> 0x0097 }
            if (r1 == 0) goto L_0x005c
            in.juspay.hypersdk.data.SessionInfo r1 = r6.sessionInfo     // Catch:{ JSONException -> 0x0097 }
            java.lang.String r1 = r1.getScreenHeight()     // Catch:{ JSONException -> 0x0097 }
            goto L_0x005d
        L_0x005c:
            r1 = r4
        L_0x005d:
            r0.put(r3, r1)     // Catch:{ JSONException -> 0x0097 }
            in.juspay.hypersdk.data.SessionInfo r1 = r6.sessionInfo     // Catch:{ JSONException -> 0x0097 }
            java.lang.String r1 = r1.getScreenWidth()     // Catch:{ JSONException -> 0x0097 }
            if (r1 == 0) goto L_0x006e
            in.juspay.hypersdk.data.SessionInfo r1 = r6.sessionInfo     // Catch:{ JSONException -> 0x0097 }
            java.lang.String r4 = r1.getScreenWidth()     // Catch:{ JSONException -> 0x0097 }
        L_0x006e:
            r0.put(r2, r4)     // Catch:{ JSONException -> 0x0097 }
            goto L_0x009b
        L_0x0072:
            in.juspay.hypersdk.data.SessionInfo r1 = r6.sessionInfo     // Catch:{ JSONException -> 0x0097 }
            java.lang.String r1 = r1.getScreenHeight()     // Catch:{ JSONException -> 0x0097 }
            if (r1 == 0) goto L_0x0081
            in.juspay.hypersdk.data.SessionInfo r1 = r6.sessionInfo     // Catch:{ JSONException -> 0x0097 }
            java.lang.String r1 = r1.getScreenHeight()     // Catch:{ JSONException -> 0x0097 }
            goto L_0x0082
        L_0x0081:
            r1 = r4
        L_0x0082:
            r0.put(r3, r1)     // Catch:{ JSONException -> 0x0097 }
            in.juspay.hypersdk.data.SessionInfo r1 = r6.sessionInfo     // Catch:{ JSONException -> 0x0097 }
            java.lang.String r1 = r1.getScreenWidth()     // Catch:{ JSONException -> 0x0097 }
            if (r1 == 0) goto L_0x0093
            in.juspay.hypersdk.data.SessionInfo r1 = r6.sessionInfo     // Catch:{ JSONException -> 0x0097 }
            java.lang.String r4 = r1.getScreenWidth()     // Catch:{ JSONException -> 0x0097 }
        L_0x0093:
            r0.put(r2, r4)     // Catch:{ JSONException -> 0x0097 }
            goto L_0x009b
        L_0x0097:
            r1 = move-exception
            r1.printStackTrace()
        L_0x009b:
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.JsInterface.getRootFragmentSize():java.lang.String");
    }

    @JavascriptInterface
    public String getSessionAttribute(String str, String str2) {
        return this.sessionInfo.get(str, str2);
    }

    @JavascriptInterface
    public String getSessionId() {
        return this.sessionInfo.getSessionId();
    }

    @JavascriptInterface
    public String getSessionInfo() {
        this.sessionInfo.createSessionDataMap();
        return this.sessionInfo.toString();
    }

    @JavascriptInterface
    public boolean isFilePresent(String str) {
        return this.fileProviderService.isFilePresent(this.context, str);
    }

    @JavascriptInterface
    public boolean isNetworkAvailable() {
        return this.context != null && this.sessionInfo.isNetworkAvailable();
    }

    @JavascriptInterface
    public String loadFileInDUI(String str) {
        return this.fileProviderService.readFromFile(this.context, str, 60);
    }

    @JavascriptInterface
    public String loadFileInDUI(String str, int i) {
        return this.fileProviderService.readFromFile(this.context, str, i);
    }

    @JavascriptInterface
    public void postLogs(String str, String str2) {
        JuspayLogger.e(LOG_TAG, "No one should call JBridge.postLogs() method. It will be removed in future.");
    }

    @JavascriptInterface
    public void removeAttribute(String str) {
        this.sessionInfo.removeAttribute(str);
    }

    @JavascriptInterface
    public void removeDataFromSharedPrefs(String str) {
        KeyValueStore.remove(this.juspayServices, str);
    }

    @JavascriptInterface
    public void removeFromSharedPrefs(String str) {
        KeyValueStore.remove(this.juspayServices.getSdkInfo().getSdkName(), str);
    }

    @JavascriptInterface
    public void renewFile(String str) {
        renewFile(str, null, null);
    }

    @JavascriptInterface
    public void renewFile(String str, String str2) {
        renewFile(str, str2, null);
    }

    @JavascriptInterface
    public void renewFile(String str, String str2, String str3) {
        this.remoteAssetService.renewFile(this.context, str, str3, str2);
    }

    @JavascriptInterface
    public void renewSdkConfig() {
        this.juspayServices.getSdkConfigService().renewConfig(this.context);
    }

    @JavascriptInterface
    public String requestPendingLogs(String str) {
        try {
            return LogSessioniser.getLogsFromSessionId(new JSONObject(str));
        } catch (JSONException unused) {
            return "{}";
        }
    }

    @JavascriptInterface
    public void sessioniseLogs(String str) {
        try {
            LogSessioniser.sessioniseLogs(new JSONObject(str));
        } catch (JSONException e2) {
            this.sdkTracker.trackException("action", "system", System.JBRIDGE, GeneratedOutlineSupport.outline50("Logs request has invalid format", str), e2);
        }
    }

    @JavascriptInterface
    public void setAnalyticsEndPoint(String str) {
        JuspayLogger.e(LOG_TAG, "No one should call JBridge.setAnalyticsEndPoint() method. It will be removed in future.");
    }

    @JavascriptInterface
    public boolean setAnalyticsHeader(String str) {
        try {
            LogPusher.setHeaders(new JSONObject(str));
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    @JavascriptInterface
    public void setInSharedPrefs(String str, String str2) {
        KeyValueStore.write(this.juspayServices, str, str2);
    }

    public void setJuspayWebView(JuspayWebView juspayWebView2) {
        this.juspayWebView = juspayWebView2;
    }

    @JavascriptInterface
    public void setSessionAttribute(String str, String str2) {
        this.sessionInfo.set(str, str2);
    }

    @JavascriptInterface
    public void setSessionId(String str) {
        JuspayLogger.d(LOG_TAG, "JBridge.setSessionId() is intended for changing the Session ID of the SDK. Not to be called by each micro-app");
        JuspayLogger.d(LOG_TAG, "Attempted Session ID: " + str);
    }

    @JavascriptInterface
    public void submitAllLogs() {
    }

    @JavascriptInterface
    public void toast(String str) {
        Toast.makeText(this.context, str, 1).show();
    }

    @JavascriptInterface
    public void updateLogList(String str) {
        JuspayLogger.e(LOG_TAG, "No one should call JBridge.updateLogList() method. It will be removed in future.");
    }
}
