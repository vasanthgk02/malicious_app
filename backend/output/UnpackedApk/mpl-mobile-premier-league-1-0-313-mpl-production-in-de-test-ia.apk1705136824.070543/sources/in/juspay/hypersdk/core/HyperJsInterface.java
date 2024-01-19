package in.juspay.hypersdk.core;

import android.os.AsyncTask;
import android.util.Base64;
import android.webkit.JavascriptInterface;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.network.HttpGetRequest;
import com.razorpay.AnalyticsConstants;
import com.reactnativecommunity.webview.RNCWebViewManager;
import in.juspay.hypersdk.core.Labels.System;
import in.juspay.hypersdk.utils.Utils;
import in.juspay.hypersdk.utils.network.JuspayHttpResponse;
import in.juspay.hypersdk.utils.network.NetUtils;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.fontbox.cmap.CMap;
import org.json.JSONException;
import org.json.JSONObject;

public class HyperJsInterface extends JsInterface {
    public static final String LOG_TAG = "HyperJsInterface";
    public final HyperFragment fragment;
    public final JuspayServices juspayServices;

    public static class ApiCallTask extends AsyncTask<Void, Void, JuspayHttpResponse> {
        public String callback;
        public String data;
        public String headers;
        public boolean isSSLPinned;
        public JuspayServices juspayServices;
        public String method;
        public String url;

        public ApiCallTask(String str, String str2, String str3, String str4, boolean z, String str5, JuspayServices juspayServices2) {
            this.method = str;
            this.url = str2;
            this.data = str3;
            this.headers = str4;
            this.isSSLPinned = z;
            this.callback = str5;
            this.juspayServices = juspayServices2;
        }

        private HashMap<String, String> toMap(String str) {
            HashMap<String, String> hashMap = new HashMap<>();
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.getString(next));
                }
                return hashMap;
            } catch (JSONException unused) {
                this.juspayServices.sdkDebug(HyperJsInterface.LOG_TAG, "Not a json string. Passing as such");
                return null;
            }
        }

        public JuspayHttpResponse doInBackground(Void... voidArr) {
            try {
                NetUtils netUtils = new NetUtils(0, 0, this.isSSLPinned);
                HashMap<String, String> map = toMap(this.headers);
                HashMap<String, String> map2 = toMap(this.data);
                if (HttpGetRequest.METHOD_GET.equals(this.method)) {
                    return new JuspayHttpResponse(netUtils.doGet(this.url, map, map2));
                }
                if (RNCWebViewManager.HTTP_METHOD_POST.equals(this.method)) {
                    return map2 == null ? new JuspayHttpResponse(netUtils.postUrl(new URL(this.url), (Map<String, String>) map, this.data)) : new JuspayHttpResponse(netUtils.postUrl(new URL(this.url), (Map<String, String>) map, (Map<String, String>) map2));
                }
                return null;
            } catch (Exception e2) {
                return new JuspayHttpResponse(-1, e2.getLocalizedMessage().getBytes(), null);
            }
        }

        public void onPostExecute(JuspayHttpResponse juspayHttpResponse) {
            String str;
            super.onPostExecute(juspayHttpResponse);
            DynamicUI dynamicUI = this.juspayServices.getDynamicUI();
            if (juspayHttpResponse != null) {
                JuspayLogger.e(HyperJsInterface.LOG_TAG, "Please check if HTTP method (GET, POST, ..) is supported");
                if (juspayHttpResponse.responseCode == -1) {
                    String encodeToString = Base64.encodeToString("{}".getBytes(), 2);
                    StringBuilder outline78 = GeneratedOutlineSupport.outline78(encodeToString, CMap.SPACE);
                    outline78.append(juspayHttpResponse.responseCode);
                    JuspayLogger.d("Response inserted: ", outline78.toString());
                    str = String.format("window.callUICallback('%s','%s','%s','%s','%s');", new Object[]{this.callback, AnalyticsConstants.FAILURE, encodeToString, Integer.valueOf(juspayHttpResponse.responseCode), new String(Base64.encode(this.url.getBytes(), 2))});
                    if (dynamicUI == null) {
                        return;
                    }
                } else {
                    String encodeToString2 = juspayHttpResponse.responsePayload == null ? "" : Base64.encodeToString(new String(juspayHttpResponse.responsePayload).getBytes(), 2);
                    JuspayServices juspayServices2 = this.juspayServices;
                    StringBuilder outline782 = GeneratedOutlineSupport.outline78(encodeToString2, CMap.SPACE);
                    byte[] bArr = juspayHttpResponse.responsePayload;
                    if (bArr == null) {
                        bArr = new byte[0];
                    }
                    outline782.append(new String(bArr));
                    juspayServices2.sdkDebug("Response inserted: ", outline782.toString());
                    str = String.format("window.callUICallback('%s','%s','%s','%s','%s');", new Object[]{this.callback, "success", encodeToString2, Integer.valueOf(juspayHttpResponse.responseCode), new String(Base64.encode(this.url.getBytes(), 2))});
                    if (dynamicUI == null) {
                        return;
                    }
                }
            } else {
                str = String.format("window.callUICallback('%s','%s','%s','%s','%s');", new Object[]{this.callback, AnalyticsConstants.FAILURE, Base64.encodeToString("{}".getBytes(), 2), Integer.valueOf(-1), new String(Base64.encode(this.url.getBytes(), 2))});
                if (dynamicUI == null) {
                    return;
                }
            }
            dynamicUI.addJsToWebView(str);
        }
    }

    public HyperJsInterface(JuspayServices juspayServices2, HyperFragment hyperFragment) {
        super(juspayServices2);
        this.juspayServices = juspayServices2;
        this.fragment = hyperFragment;
    }

    @JavascriptInterface
    public String checkPermission(String[] strArr) {
        JSONObject jSONObject = new JSONObject();
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        for (String str : strArr) {
            try {
                jSONObject.put(str, Utils.checkIfGranted(this.juspayServices, str));
            } catch (JSONException e2) {
                sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.JBRIDGE, "Caught this exception while setting in JSON: ", e2);
            }
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public void downloadApps(String str) {
        JuspayLogger.e(LOG_TAG, "Method downloadApps() has empty body");
    }

    @JavascriptInterface
    public void exitApp(int i, String str) {
        HyperFragment hyperFragment = this.fragment;
        if (hyperFragment != null) {
            hyperFragment.exitApp(i, str);
        }
    }

    @JavascriptInterface
    public void hideKeyboard() {
        JuspayLogger.e(LOG_TAG, "Method hideKeyboard() has empty body");
    }

    @JavascriptInterface
    public void invokeFnInDUIWebview(String str) {
        DynamicUI dynamicUI = this.juspayServices.getDynamicUI();
        if (dynamicUI != null) {
            dynamicUI.addJsToWebView(str);
        }
    }

    @JavascriptInterface
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        JuspayLogger.e(LOG_TAG, "Please override onRequestPermissionsResult");
    }

    @JavascriptInterface
    public void requestPermission(String[] strArr, String str) {
        HyperFragment hyperFragment = this.fragment;
        if (hyperFragment != null) {
            hyperFragment.requestPermissionsCheckingAllowed(strArr, Integer.parseInt(str));
        }
    }

    @JavascriptInterface
    public void setClickFeedback(String str) {
        JuspayLogger.e(LOG_TAG, "Method setClickFeedback(String) has empty body");
    }
}
