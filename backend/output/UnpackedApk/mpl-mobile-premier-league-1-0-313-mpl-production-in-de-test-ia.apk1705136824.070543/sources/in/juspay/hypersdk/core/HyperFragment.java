package in.juspay.hypersdk.core;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.PromiseImpl;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import in.juspay.hypersdk.R;
import in.juspay.hypersdk.analytics.LogConstants;
import in.juspay.hypersdk.core.Labels.Android;
import in.juspay.hypersdk.core.Labels.HyperSdk;
import in.juspay.hypersdk.core.Labels.System;
import in.juspay.hypersdk.core.Labels.User;
import in.juspay.hypersdk.core.PaymentConstants.ENVIRONMENT;
import in.juspay.hypersdk.core.PaymentConstants.GodelOffReasons;
import in.juspay.hypersdk.core.PaymentConstants.LogCategory;
import in.juspay.hypersdk.core.PaymentConstants.SubCategory.Action;
import in.juspay.hypersdk.core.PaymentConstants.SubCategory.LifeCycle;
import in.juspay.hypersdk.data.KeyValueStore;
import in.juspay.hypersdk.data.PaymentSessionInfo;
import in.juspay.hypersdk.services.FileProviderService;
import in.juspay.hypersdk.services.RemoteAssetService;
import in.juspay.hypersdk.services.SdkConfigService;
import in.juspay.hypersdk.services.ServiceConstants;
import in.juspay.hypersdk.ui.ActivityLaunchDelegate;
import in.juspay.hypersdk.ui.DefaultActivityLaunchDelegate;
import in.juspay.hypersdk.ui.DefaultRequestPermissionDelegate;
import in.juspay.hypersdk.ui.HyperPaymentsCallback;
import in.juspay.hypersdk.ui.HyperPaymentsCallbackAdapter;
import in.juspay.hypersdk.ui.JuspayPaymentsCallback;
import in.juspay.hypersdk.ui.JuspayWebChromeClient;
import in.juspay.hypersdk.ui.JuspayWebView;
import in.juspay.hypersdk.ui.JuspayWebViewClient;
import in.juspay.hypersdk.ui.RequestPermissionDelegate;
import in.juspay.hypersdk.utils.IntegrationUtils;
import in.juspay.hypersdk.utils.Utils;
import in.juspay.hypersdk.utils.network.NetUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import org.apache.fontbox.cmap.CMapParser;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HyperFragment extends Fragment {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String LOG_TAG = "HyperFragment";
    public static final long ON_EXCEPTION_GODEL_OFF_STICKINESS = 86400000;
    public AcsInterface acsInterface;
    public Activity activity;
    public ActivityLaunchDelegate activityLaunchDelegate = new DefaultActivityLaunchDelegate(this);
    public List<String> allowedDeeplinkPackages = new ArrayList();
    public boolean bootLoaderDownloadAttempted;
    public JSONObject bundleParameters;
    public JSONObject config = new JSONObject();
    public List<String> disallowedPermissions = new ArrayList();
    public FrameLayout duiContainer;
    public DuiInterface duiInterface;
    public boolean duiLoaded;
    public DynamicUI dynamicUI;
    public boolean isLoggingEndpointSandbox = false;
    public boolean isPreFetchMode;
    public boolean isWebViewAdded;
    public JuspayCallback juspayCallback;
    public JuspayServices juspayServices;
    public JuspayWebView juspayWebView;
    public Bundle juspayWebviewState;
    public boolean paused = false;
    public PaymentSessionInfo paymentSessionInfo;
    public int requestCode = -1;
    public RequestPermissionDelegate requestPermissionDelegate = new DefaultRequestPermissionDelegate(this);
    public Queue<RequestQueueData> requestQueue;
    public SmsConsentHandler smsConsentHandler;
    public Queue<IntentQueueData> startActivityQueue;
    public JuspayWebChromeClient webChromeClient;
    public boolean webViewAvailable = true;
    public JuspayWebViewClient webViewClient;
    public JuspayWebViewConfigurationCallback webViewConfigurationCallback;

    public class IntentQueueData {
        public Bundle bundle;
        public Intent intent;
        public int requestCode;
        public boolean useDelegate;

        public IntentQueueData(Intent intent2, int i, Bundle bundle2, boolean z) {
            this.intent = intent2;
            this.requestCode = i;
            this.bundle = bundle2;
            this.useDelegate = z;
        }
    }

    public class RequestQueueData {
        public int requestCode;
        public String[] requests;

        public RequestQueueData(String[] strArr, int i) {
            this.requests = strArr;
            this.requestCode = i;
        }
    }

    static {
        Class<HyperFragment> cls = HyperFragment.class;
    }

    private boolean addIfPrefetchAndReturnStatus(SdkTracker sdkTracker) {
        if (!this.isPreFetchMode) {
            return true;
        }
        JSONObject bundleParameters2 = getBundleParameters();
        if (bundleParameters2 == null) {
            bundleParameters2 = new JSONObject();
        }
        try {
            bundleParameters2.put("pre_fetch", BaseParser.TRUE);
            setBundleParameters(bundleParameters2);
            return true;
        } catch (JSONException e2) {
            JSONException jSONException = e2;
            JuspayLogger.e(LOG_TAG, "Error writing to JSON", jSONException);
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.LIFECYCLE, LifeCycle.HYPER_SDK, HyperSdk.HYPER_FRAGMENT, "failed_during_add_if_prefetch", jSONException);
            return false;
        }
    }

    private void addInSharedPref(Intent intent, int i, int i2, SdkTracker sdkTracker) {
        JSONObject jSONObject = new JSONObject();
        if (intent != null) {
            jSONObject = Utils.toJSON(intent.getExtras());
        }
        try {
            JuspayServices juspayServices2 = this.juspayServices;
            KeyValueStore.write(juspayServices2, "jus_oar_" + i, new JSONObject().put(MiPushCommandMessage.KEY_RESULT_CODE, i2).put("in/juspay/godel/data", jSONObject.toString()).toString());
            sdkTracker.trackAction("system", "info", System.SHARED_PREF, "key", "jus_oar_" + i);
        } catch (JSONException e2) {
            sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.SHARED_PREF, "Failed to store intent response of onActivityResult in Shared Prefs", e2);
        }
    }

    private void addIntentQueue(IntentQueueData intentQueueData) {
        if (this.startActivityQueue == null) {
            this.startActivityQueue = new LinkedList();
        }
        this.startActivityQueue.add(intentQueueData);
    }

    private void createSMSConsent(Activity activity2) {
        try {
            PackageManager packageManager = activity2.getPackageManager();
            if (this.smsConsentHandler != null) {
                this.smsConsentHandler.unregisterConsent();
            }
            if (packageManager.checkPermission("android.permission.READ_SMS", "com.google.android.gms") == 0) {
                AnonymousClass3 r0 = new SmsConsentHandler(activity2, this.juspayServices) {
                    public void resetConsentHandler() {
                        HyperFragment.this.resetSmsConsentHandler();
                    }
                };
                this.smsConsentHandler = r0;
                r0.setIntentReceivedCallback(null);
            }
        } catch (Exception e2) {
            SdkTracker.trackAndLogBootException(LOG_TAG, LogCategory.LIFECYCLE, LifeCycle.HYPER_SDK, HyperSdk.HYPER_FRAGMENT, "Exception happened while initializing", e2);
        }
    }

    private FrameLayout createSubLayout(Activity activity2) {
        FrameLayout frameLayout = new FrameLayout(activity2);
        frameLayout.setLayoutParams(new LayoutParams(-1, -1));
        frameLayout.setVisibility(this.isPreFetchMode ? 8 : 0);
        return frameLayout;
    }

    public static void deleteFiles(Context context) {
        try {
            File[] listFiles = new File(String.valueOf(context.getCacheDir())).listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    String name = file.getName();
                    if (name.startsWith(LogConstants.PERSISTENT_LOGS_FILE) || name.startsWith(LogConstants.LOGS_FILE) || name.startsWith(LogConstants.TEMP_LOGS_FILE)) {
                        file.delete();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private void doHeadCalls() {
        new Thread() {
            public void run() {
                try {
                    JSONObject optJSONObject = HyperFragment.this.bundleParameters != null ? HyperFragment.this.bundleParameters.optJSONObject("payload") : null;
                    JSONObject optJSONObject2 = HyperFragment.this.juspayServices.getSdkConfigService().getSdkConfig().optJSONObject("headURLs");
                    if (optJSONObject != null) {
                        if (optJSONObject2 != null) {
                            JSONArray optJSONArray = optJSONObject.optString(PaymentConstants.ENV, "production").equals(ENVIRONMENT.SANDBOX) ? optJSONObject2.optJSONArray(ENVIRONMENT.SANDBOX) : optJSONObject2.optJSONArray("production");
                            if (optJSONArray != null && (HyperFragment.this.duiInterface instanceof JBridge)) {
                                NetUtils netUtils = ((JBridge) HyperFragment.this.duiInterface).getNetUtils(false);
                                for (int i = 0; i < optJSONArray.length(); i++) {
                                    netUtils.doHead(optJSONArray.get(i).toString(), null, null);
                                }
                            }
                        }
                    }
                } catch (Exception e2) {
                    SdkTracker.trackAndLogBootException(HyperFragment.LOG_TAG, LogCategory.API_CALL, "network", HyperSdk.HYPER_FRAGMENT, "Exception while trying to make head calls to urls", e2);
                }
            }
        }.start();
    }

    private Bundle extractBundle() {
        Bundle arguments = getArguments() != null ? getArguments() : new Bundle();
        this.requestCode = arguments.getInt("requestCode", -1);
        return arguments;
    }

    private JSONObject extractBundleParameters() {
        JSONObject bundleParameters2 = getBundleParameters() != null ? getBundleParameters() : Utils.toJSON(extractBundle());
        this.bundleParameters = bundleParameters2;
        this.requestCode = bundleParameters2.optInt("requestCode", -1);
        return this.bundleParameters;
    }

    public static void firstTimeSetup(Context context, JuspayServices juspayServices2) {
        SdkTracker sdkTracker = juspayServices2 != null ? juspayServices2.getSdkTracker() : null;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("jus_");
        outline73.append(IntegrationUtils.getGodelVersion(context));
        outline73.append("_");
        outline73.append(IntegrationUtils.getGodelBuildVersion(context));
        PaymentConstants.setBuildId(outline73.toString());
        String sdkName = juspayServices2.getSdkInfo().getSdkName();
        FileProviderService fileProviderService = juspayServices2.getFileProviderService();
        RemoteAssetService remoteAssetService = juspayServices2.getRemoteAssetService();
        if (KeyValueStore.read(context, sdkName, PaymentConstants.BUILD_ID, BaseParser.FALSE).equals(BaseParser.FALSE)) {
            if (sdkTracker != null) {
                sdkTracker.trackLifecycle(LifeCycle.HYPER_SDK, "info", HyperSdk.FIRST_TIME_SETUP, "started", null);
            }
            KeyValueStore.write(context, sdkName, PaymentConstants.BUILD_ID, BaseParser.TRUE);
            KeyValueStore.remove(context, sdkName, (String) ServiceConstants.ASSET_METADATA_FILE_NAME);
            File file = new File(context.getDir("juspay", 0), "payments");
            if (file.exists()) {
                Utils.deleteRecursive(file);
            }
            File file2 = new File(context.getDir("juspay", 0), fileProviderService.appendSdkNameAndVersion("manifest.json"));
            File file3 = new File(context.getDir("juspay", 0), fileProviderService.appendSdkNameAndVersion("v1-boot_loader.jsa"));
            Utils.deleteRecursive(new File(context.getDir("juspay", 0), fileProviderService.appendSdkNameAndVersion("v1-config.jsa")));
            Utils.deleteRecursive(file2);
            Utils.deleteRecursive(file3);
            try {
                remoteAssetService.getMetadata("manifest.json");
                if (sdkTracker != null) {
                    sdkTracker.trackLifecycle(LifeCycle.HYPER_SDK, "info", HyperSdk.FIRST_TIME_SETUP, com.squareup.picasso.Utils.VERB_COMPLETED, null);
                }
                new File(context.getCacheDir(), "juspay-logs-queue.dat").delete();
                new File(context.getCacheDir(), "temp-logs-queue.dat").delete();
                new File(context.getCacheDir(), "juspay-pre-logs-queue.dat").delete();
                deleteFiles(context);
            } catch (Exception e2) {
                Exception exc = e2;
                if (sdkTracker != null) {
                    sdkTracker.trackAndLogException(LOG_TAG, LogCategory.LIFECYCLE, LifeCycle.HYPER_SDK, HyperSdk.FIRST_TIME_SETUP, "Exception while fetching meta-data for manifest.json file", exc);
                }
            }
        }
    }

    public static String getBootloaderEndpoint(Context context, JSONObject jSONObject) {
        return String.format(Constants.BOOTLOADER_REMOTE_ASSET_PATH_FORMAT, new Object[]{(jSONObject == null || !jSONObject.optBoolean(PaymentConstants.BETA_ASSETS, false)) ? "release" : "beta", context.getString(R.string.remotes_version)});
    }

    public static boolean hasPackageEverExisted(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        try {
            if (VERSION.SDK_INT >= 24) {
                packageManager.getPackageInfo(str, 8192);
                return true;
            }
        } catch (NameNotFoundException unused) {
        }
        return false;
    }

    private void initializeJuspayWebview(Context context) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        JuspayServices juspayServices2 = this.juspayServices;
        SdkTracker sdkTracker = juspayServices2 != null ? juspayServices2.getSdkTracker() : null;
        this.acsInterface = new AcsInterface(this, this.juspayServices);
        if (this.juspayWebView == null) {
            if (sdkTracker != null) {
                sdkTracker.trackAction("system", "info", System.INITIALISE_JUSPAY_WEBVIEW, "started", context);
            }
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            JuspayWebView juspayWebView2 = new JuspayWebView(context);
            this.juspayWebView = juspayWebView2;
            juspayWebView2.setId(R.id.juspay_browser_view);
            this.juspayWebView.setLayoutParams(layoutParams);
            this.juspayWebView.setHorizontalScrollBarEnabled(false);
            this.juspayWebView.setVerticalScrollBarEnabled(false);
            this.juspayWebView.addJavascriptInterface(this.acsInterface, "ACSGatekeeper");
            FileProviderService fileProviderService = this.juspayServices.getFileProviderService();
            this.isWebViewAdded = false;
            this.paymentSessionInfo.setPaymentDetails(getBundleParameters() != null ? getBundleParameters() : new JSONObject());
            fileProviderService.addToFileCacheWhiteList("acs.jsa");
            prepareWebView(context);
            DuiInterface duiInterface2 = this.duiInterface;
            if (duiInterface2 != null) {
                duiInterface2.setJuspayWebView(this.juspayWebView);
                return;
            } else if (sdkTracker != null) {
                str5 = "system";
                str4 = "error";
                str3 = System.INITIALISE_JUSPAY_WEBVIEW;
                str2 = "missing";
                str = DuiInterface.LOG_TAG;
            } else {
                return;
            }
        } else if (sdkTracker != null) {
            str5 = "system";
            str4 = "error";
            str3 = System.INITIALISE_JUSPAY_WEBVIEW;
            str2 = "missing";
            str = "JuspayWebView";
        } else {
            return;
        }
        sdkTracker.trackAction(str5, str4, str3, str2, str);
    }

    private void injectWebView(FrameLayout frameLayout) {
        if (frameLayout != null) {
            JuspayWebView juspayWebView2 = this.juspayWebView;
            if (juspayWebView2 != null && frameLayout.findViewById(juspayWebView2.getId()) == null && !this.isWebViewAdded) {
                frameLayout.addView(this.juspayWebView, 0);
                this.isWebViewAdded = true;
            }
        }
    }

    private boolean isClientWhitelistedForWebViewAccess(String str) {
        JuspayServices juspayServices2 = this.juspayServices;
        JSONObject sdkConfig = juspayServices2 != null ? juspayServices2.getSdkConfigService().getSdkConfig() : SdkConfigService.getCachedSdkConfig();
        if (sdkConfig == null) {
            return false;
        }
        JSONArray optJSONArray = Utils.optJSONArray(Utils.optJSONObject(Utils.optJSONObject(sdkConfig, "godelConfig"), "webViewAccess"), "whitelistedClientIds");
        int i = 0;
        while (i < optJSONArray.length()) {
            try {
                if (str.contains(optJSONArray.getString(i))) {
                    return true;
                }
                i++;
            } catch (JSONException e2) {
                this.juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, "action", "system", System.GODEL_WEBVIEW_WHITELIST, "Failed to read whitelisted config", e2);
            }
        }
        return false;
    }

    public static boolean isPackageExisting(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        try {
            packageManager.getPackageInfo(str, 128);
            return true;
        } catch (NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean isWebViewInstalled(Context context) {
        boolean z = false;
        if (VERSION.SDK_INT >= 26) {
            try {
                JuspayLogger.d(LOG_TAG, "WebView package name - " + ((PackageInfo) Objects.requireNonNull(WebView.getCurrentWebViewPackage())).packageName);
                return isPackageExisting(context, ((PackageInfo) Objects.requireNonNull(WebView.getCurrentWebViewPackage())).packageName);
            } catch (Exception unused) {
                JuspayLogger.d(LOG_TAG, "WebView default package name - check if com.google.android.webview is present or atleast it's never installed indicating the package never existed to get updated.");
                JuspayLogger.d(LOG_TAG, "WebView isExisting: " + isPackageExisting(context, "com.google.android.webview"));
                JuspayLogger.d(LOG_TAG, "WebView hasExisted: " + hasPackageEverExisted(context, "com.google.android.webview"));
                if (isPackageExisting(context, "com.google.android.webview") || !hasPackageEverExisted(context, "com.google.android.webview")) {
                    z = true;
                }
                return z;
            }
        } else {
            PackageInfo packageInfo = (PackageInfo) Class.forName("android.webkit.WebViewFactory").getMethod("getLoadedPackageInfo", new Class[0]).invoke(null, new Object[0]);
            JuspayLogger.d(LOG_TAG, "WebView package name - " + packageInfo.packageName);
            return isPackageExisting(context, packageInfo.packageName);
        }
    }

    public static void prefetchBootLoaderFile(Context context, JSONObject jSONObject, JuspayServices juspayServices2) {
        String str;
        if (juspayServices2 == null || context == null) {
            str = "juspayServices";
        } else {
            RemoteAssetService remoteAssetService = juspayServices2.getRemoteAssetService();
            if (remoteAssetService != null) {
                remoteAssetService.renewFile(context, getBootloaderEndpoint(context, jSONObject), null);
                return;
            }
            str = "remoteAssetService";
        }
        SdkTracker.trackBootLifecycle(LifeCycle.HYPER_SDK, "error", HyperSdk.HYPER_FRAGMENT, "missing", str);
    }

    /* access modifiers changed from: private */
    public void resetInterfaces() {
        if (getDuiInterface() != null) {
            getDuiInterface().reset();
        }
    }

    private void setupAllowedDeeplinkPackages(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("payload");
        if (optJSONObject != null) {
            JSONArray optJSONArray = optJSONObject.optJSONArray("allowedDeepLinkPackages");
            this.allowedDeeplinkPackages.clear();
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString = optJSONArray.optString(i);
                    if (optString != null) {
                        this.allowedDeeplinkPackages.add(optString);
                    }
                }
            }
        }
    }

    private boolean shouldDisableGodel(Context context) {
        long j;
        if (context != null) {
            JuspayServices juspayServices2 = this.juspayServices;
            SdkTracker sdkTracker = juspayServices2 != null ? juspayServices2.getSdkTracker() : null;
            if (KeyValueStore.contains(this.juspayServices, "GODEL_EXCEPTION_OFF")) {
                JSONObject config2 = getConfig();
                long j2 = 86400000;
                if (config2 != null) {
                    j2 = config2.optLong("ON_EXCEPTION_GODEL_OFF_STICKINESS", 86400000);
                }
                long j3 = j2;
                try {
                    j = System.currentTimeMillis() - Long.parseLong(KeyValueStore.read(this.juspayServices, "GODEL_EXCEPTION_OFF", String.valueOf(System.currentTimeMillis())));
                } catch (NumberFormatException e2) {
                    NumberFormatException numberFormatException = e2;
                    j = System.currentTimeMillis();
                    if (sdkTracker != null) {
                        sdkTracker.trackAndLogException(LOG_TAG, "action", Action.USER, User.SHOULD_DISABLE_GODEL, "Failed while parsing number", numberFormatException);
                    }
                }
                String read = KeyValueStore.read(this.juspayServices, "EXCEPTION_INFO", null);
                if (sdkTracker != null) {
                    sdkTracker.trackAction(Action.USER, "info", User.SHOULD_DISABLE_GODEL, "exception_info", read);
                }
                if (j <= j3) {
                    return true;
                }
                KeyValueStore.remove(this.juspayServices, (String) "GODEL_EXCEPTION_OFF");
                KeyValueStore.remove(this.juspayServices, (String) "EXCEPTION_OFF");
            }
        }
        return false;
    }

    private void turnOffGodelIfNeeded() {
        if (shouldDisableGodel(getAttachedActivity())) {
            this.paymentSessionInfo.setGodelDisabled(GodelOffReasons.ON_GODEL_EXCEPTION);
        }
        if (!PaymentUtils.hasTelephonyService(this.juspayServices)) {
            this.juspayServices.sdkDebug(LOG_TAG, "No telephony service found.. disabling JB");
            this.paymentSessionInfo.setGodelDisabled(GodelOffReasons.TELEPHONY_NOT_FOUND);
        }
        PaymentUtils.switchOffGodelIfLowOnMemory(this, this.juspayServices, this.paymentSessionInfo);
    }

    private void udpateJuspayWebviewStateAndActivityRecreatedState(Bundle bundle) {
        boolean z = false;
        if (bundle != null) {
            try {
                this.juspayWebviewState = bundle.getBundle("juspay_webview");
                z = true;
            } catch (JSONException e2) {
                SdkTracker.trackAndLogBootException(LOG_TAG, LogCategory.LIFECYCLE, "android", Android.ON_CREATE_VIEW, "during update state", e2);
                return;
            }
        } else {
            this.juspayWebviewState = null;
            if (!this.isPreFetchMode) {
                PrefetchServices.exitPreFetch();
            }
        }
        if (getBundleParameters() != null) {
            getBundleParameters().put("activity_recreated", Boolean.toString(z));
        }
    }

    private boolean validateWebviewInstall(Context context) {
        if (isWebViewInstalled(context)) {
            return true;
        }
        exitOnError(new Intent().putExtra("payload", "{\"status\":\"FAILURE\",\"message\":\"error - com.google.android.webview not found\"}"));
        return false;
    }

    public void addWebView(String str) {
        JuspayServices juspayServices2 = this.juspayServices;
        FrameLayout frameLayout = null;
        SdkTracker sdkTracker = juspayServices2 != null ? juspayServices2.getSdkTracker() : null;
        if (getContext() == null) {
            if (sdkTracker != null) {
                sdkTracker.trackAction("system", "error", System.ADD_WEBVIEW, "missing", "Context");
            }
            return;
        }
        initializeJuspayWebview(getContext());
        try {
            frameLayout = (FrameLayout) getAttachedActivity().findViewById(Integer.parseInt(str));
        } catch (Exception e2) {
            Exception exc = e2;
            if (sdkTracker != null) {
                sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.ADD_WEBVIEW, "Exception while trying to attach WebView", exc);
            }
        }
        if (frameLayout == null) {
            if (sdkTracker != null) {
                sdkTracker.trackAction("system", "error", System.ADD_WEBVIEW, "missing", "view");
            }
            return;
        }
        turnOffGodelIfNeeded();
        injectWebView(frameLayout);
    }

    public void backPressHandler(boolean z) {
        if (getDuiInterface() != null) {
            this.duiInterface.requestKeyboardHide();
            DuiInterface duiInterface2 = getDuiInterface();
            duiInterface2.invokeFnInDUIWebview("onBackPressed", "{\"shouldShowBackPressDialog\":" + z + "}");
            return;
        }
        onBackPressedCopy();
    }

    public DuiInterface createDuiInterface() {
        return new JBridge(this.juspayServices, getAttachedActivity(), this);
    }

    public void destroy() {
        JuspayServices juspayServices2 = this.juspayServices;
        SdkTracker sdkTracker = juspayServices2 != null ? juspayServices2.getSdkTracker() : null;
        if (sdkTracker != null) {
            sdkTracker.trackLifecycle("android", "info", Android.ON_DESTROY, "Clearing ACS interface and DUI interface.", null);
        }
        AcsInterface acsInterface2 = this.acsInterface;
        if (acsInterface2 != null) {
            acsInterface2.invoke("onDestroy", "{}");
            this.acsInterface = null;
        }
        DuiInterface duiInterface2 = this.duiInterface;
        if (duiInterface2 != null) {
            duiInterface2.onWebViewReleased();
            this.duiInterface.closeBrowser("fragment being detached");
            this.duiInterface = null;
        }
        SmsConsentHandler smsConsentHandler2 = this.smsConsentHandler;
        if (smsConsentHandler2 != null) {
            smsConsentHandler2.unregisterConsent(this.activity);
            this.smsConsentHandler = null;
        }
        MPINUtil.closeAllConnections(getContext());
        if (sdkTracker != null) {
            sdkTracker.trackLifecycle("android", "info", Android.ON_DESTROY, "Clearing JuspayServices instance.", null);
        }
        JuspayServices juspayServices3 = this.juspayServices;
        if (juspayServices3 != null) {
            juspayServices3.destroy();
            this.juspayServices = null;
        }
        FrameLayout frameLayout = this.duiContainer;
        if (frameLayout != null) {
            if (frameLayout.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.duiContainer.getParent()).removeView(this.duiContainer);
            }
            this.duiContainer = null;
        }
        if (this.activity != null) {
            this.activity = null;
        }
    }

    public void exit() {
        getAttachedActivity().runOnUiThread(new Runnable() {
            public void run() {
                HyperFragment.this.config = null;
                HyperFragment.this.resetInterfaces();
                HyperFragment.this.resetWebView();
            }
        });
    }

    public void exitApp(final int i, String str) {
        JuspayServices juspayServices2 = this.juspayServices;
        SdkTracker sdkTracker = juspayServices2 != null ? juspayServices2.getSdkTracker() : null;
        if (sdkTracker != null) {
            sdkTracker.trackAction(LifeCycle.HYPER_SDK, "info", HyperSdk.EXIT_APP, "started", HyperSdk.HYPER_FRAGMENT);
        }
        if (this.juspayCallback != null) {
            final Intent intent = new Intent();
            intent.putExtra("payload", str);
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                this.juspayCallback.onResult(this.requestCode, i, intent);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        HyperFragment.this.juspayCallback.onResult(HyperFragment.this.requestCode, i, intent);
                    }
                });
            }
            if (sdkTracker != null) {
                sdkTracker.trackLifecycle(LifeCycle.HYPER_SDK, "info", HyperSdk.EXIT_APP, com.squareup.picasso.Utils.VERB_COMPLETED, null);
                return;
            }
            return;
        }
        if (sdkTracker != null) {
            sdkTracker.trackLifecycle(LifeCycle.HYPER_SDK, "critical", HyperSdk.EXIT_APP, "integration_error", "JuspayCallback is null");
        }
        JuspayLogger.e("Integration Error", "juspayCallback is null");
    }

    @Keep
    public void exitOnError(Intent intent) {
        if (this.juspayCallback != null) {
            this.juspayCallback.onResult(extractBundleParameters().optInt("requestCode", -1), 0, intent);
        }
    }

    public AcsInterface getAcsInterface() {
        return this.acsInterface;
    }

    public List<String> getAllowedDeeplinkPackages() {
        return this.allowedDeeplinkPackages;
    }

    public Activity getAttachedActivity() {
        return (!isAdded() || getActivity() == null) ? this.activity : getActivity();
    }

    public JSONObject getBundleParameters() {
        return this.bundleParameters;
    }

    public JSONObject getConfig() {
        return this.config;
    }

    public Context getContext() {
        Context context = super.getContext();
        return context == null ? JuspayCoreLib.getApplicationContext() : context;
    }

    public DuiInterface getDuiInterface() {
        return this.duiInterface;
    }

    public JuspayCallback getJuspayCallback() {
        return this.juspayCallback;
    }

    public JuspayServices getJuspayServices() {
        return this.juspayServices;
    }

    public PaymentSessionInfo getPaymentSessionInfo() {
        return this.paymentSessionInfo;
    }

    public boolean getPreFetchMode() {
        return this.isPreFetchMode;
    }

    public RequestPermissionDelegate getRequestPermissionDelegate() {
        return this.requestPermissionDelegate;
    }

    public SmsConsentHandler getSmsConsentHandler() {
        return this.smsConsentHandler;
    }

    public void insetUpdated(WindowInsets windowInsets) {
        Activity activity2 = this.activity;
        if (activity2 != null && this.dynamicUI != null) {
            float f2 = activity2.getResources().getDisplayMetrics().density;
            float systemWindowInsetTop = ((float) windowInsets.getSystemWindowInsetTop()) / f2;
            float systemWindowInsetRight = ((float) windowInsets.getSystemWindowInsetRight()) / f2;
            float systemWindowInsetBottom = ((float) windowInsets.getSystemWindowInsetBottom()) / f2;
            float systemWindowInsetLeft = ((float) windowInsets.getSystemWindowInsetLeft()) / f2;
            float stableInsetTop = ((float) windowInsets.getStableInsetTop()) / f2;
            float stableInsetRight = ((float) windowInsets.getStableInsetRight()) / f2;
            float stableInsetBottom = ((float) windowInsets.getStableInsetBottom()) / f2;
            float stableInsetLeft = ((float) windowInsets.getStableInsetLeft()) / f2;
            this.dynamicUI.addJsToWebView("window.insetUpdated(" + systemWindowInsetTop + "," + systemWindowInsetRight + "," + systemWindowInsetBottom + "," + systemWindowInsetLeft + "," + stableInsetTop + "," + stableInsetRight + "," + stableInsetBottom + "," + stableInsetLeft + ",)");
        }
    }

    public boolean isDuiLoaded() {
        return this.duiLoaded;
    }

    public boolean isNetworkAvailable(Context context) {
        JuspayServices juspayServices2 = this.juspayServices;
        NetworkInfo networkInfo = null;
        SdkTracker sdkTracker = juspayServices2 != null ? juspayServices2.getSdkTracker() : null;
        boolean z = false;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            }
            if (networkInfo != null && networkInfo.isConnected()) {
                z = true;
            }
            return z;
        } catch (Exception e2) {
            Exception exc = e2;
            if (sdkTracker != null) {
                sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.IS_NETWORK_AVAILABLE, "network failure", exc);
            }
            return false;
        }
    }

    public boolean isOnPause() {
        return this.paused;
    }

    public Boolean isWebViewAvailable() {
        return Boolean.valueOf(this.webViewAvailable);
    }

    public void loadPage() {
        if (!getBundleParameters().has("url")) {
            loadPage(getBundleParameters().optString("url"), getBundleParameters().optString("postData"));
        } else {
            loadPage("file:///android_assets/juspay/acs_blank.html", null);
        }
    }

    public void loadPage(String str, String str2) {
        JuspayServices juspayServices2 = this.juspayServices;
        SdkTracker sdkTracker = juspayServices2 != null ? juspayServices2.getSdkTracker() : null;
        try {
            getBundleParameters().put("url", str);
            getBundleParameters().put("postData", str2);
        } catch (JSONException e2) {
            JSONException jSONException = e2;
            if (sdkTracker != null) {
                sdkTracker.trackAndLogException(LOG_TAG, LogCategory.LIFECYCLE, LifeCycle.HYPER_SDK, System.LOAD_PAGE, "Failed to write to JSON bundle parameters", jSONException);
            }
        }
        JuspayWebView juspayWebView2 = this.juspayWebView;
        if (juspayWebView2 != null) {
            if (str2 != null) {
                juspayWebView2.postUrl(str, str2.getBytes());
            } else {
                juspayWebView2.loadUrl(str);
            }
        } else if (sdkTracker != null) {
            sdkTracker.trackAction("system", "error", System.LOAD_PAGE, "missing", "JuspayWebView");
        }
    }

    public JuspayWebChromeClient newWebChromeClient() {
        return new JuspayWebChromeClient(this);
    }

    public JuspayWebViewClient newWebViewClient(JuspayWebView juspayWebView2) {
        return new JuspayWebViewClient(this, juspayWebView2);
    }

    public void onActivityCreated(Bundle bundle) {
        udpateJuspayWebviewStateAndActivityRecreatedState(bundle);
        super.onActivityCreated(bundle);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r8, int r9, android.content.Intent r10) {
        /*
            r7 = this;
            super.onActivityResult(r8, r9, r10)
            in.juspay.hypersdk.core.JuspayServices r0 = r7.juspayServices
            if (r0 != 0) goto L_0x0008
            return
        L_0x0008:
            in.juspay.hypersdk.core.SdkTracker r0 = r0.getSdkTracker()
            r7.addInSharedPref(r10, r8, r9, r0)
            r1 = -1
            if (r9 != r1) goto L_0x0039
            java.lang.String r2 = "hypersdk"
            java.lang.String r3 = "info"
            java.lang.String r4 = "on_activity_result"
            java.lang.String r5 = "result_code"
            java.lang.String r6 = "RESULT_OK"
            r1 = r0
            r1.trackLifecycle(r2, r3, r4, r5, r6)
            if (r10 == 0) goto L_0x0049
            android.os.Bundle r1 = r10.getExtras()
            if (r1 == 0) goto L_0x0049
            android.os.Bundle r1 = r10.getExtras()
            org.json.JSONObject r6 = in.juspay.hypersdk.utils.Utils.toJSON(r1)
            java.lang.String r2 = "hypersdk"
            java.lang.String r3 = "info"
            java.lang.String r4 = "on_activity_result"
            java.lang.String r5 = "result_code"
            goto L_0x0045
        L_0x0039:
            if (r9 != 0) goto L_0x0049
            java.lang.String r2 = "hypersdk"
            java.lang.String r3 = "info"
            java.lang.String r4 = "on_activity_result"
            java.lang.String r5 = "result_code"
            java.lang.String r6 = "RESULT_CANCELLED"
        L_0x0045:
            r1 = r0
            r1.trackLifecycle(r2, r3, r4, r5, r6)
        L_0x0049:
            in.juspay.hypersdk.core.DuiInterface r0 = r7.duiInterface
            if (r0 == 0) goto L_0x0051
            r0.onActivityResult(r8, r9, r10)
            goto L_0x005f
        L_0x0051:
            java.lang.String r8 = "system"
            java.lang.String r9 = "critical"
            java.lang.String r10 = "on_activity_result"
            java.lang.String r0 = "dui_interface_missing"
            java.lang.String r1 = "DUI Interface is missing in HyperFragment#onActivityResult method."
            in.juspay.hypersdk.core.SdkTracker.trackBootAction(r8, r9, r10, r0, r1)
        L_0x005f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.HyperFragment.onActivityResult(int, int, android.content.Intent):void");
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        Queue<IntentQueueData> queue = this.startActivityQueue;
        if (queue != null) {
            for (IntentQueueData intentQueueData : queue) {
                startActivityForResult(intentQueueData.intent, intentQueueData.requestCode, intentQueueData.bundle, intentQueueData.useDelegate);
            }
        }
        Queue<RequestQueueData> queue2 = this.requestQueue;
        if (queue2 != null) {
            for (RequestQueueData requestQueueData : queue2) {
                requestPermissionsCheckingAllowed(requestQueueData.requests, requestQueueData.requestCode);
            }
        }
        this.startActivityQueue = null;
        this.requestQueue = null;
        if (context instanceof Activity) {
            this.activity = (Activity) context;
        }
    }

    public void onBackPressed() {
        JuspayServices juspayServices2 = this.juspayServices;
        if (juspayServices2 != null) {
            SdkTracker sdkTracker = juspayServices2.getSdkTracker();
            if (sdkTracker != null) {
                sdkTracker.trackLifecycle("android", "info", Android.BACK_PRESSED, PromiseImpl.STACK_FRAME_KEY_CLASS, "hyperFragment");
                backPressHandler(true);
            }
        }
        SdkTracker.trackBootLifecycle("android", "info", Android.BACK_PRESSED, PromiseImpl.STACK_FRAME_KEY_CLASS, "hyperFragment");
        backPressHandler(true);
    }

    public void onBackPressedCopy() {
        DynamicUI dynamicUI2 = this.dynamicUI;
        if (dynamicUI2 != null) {
            dynamicUI2.addJsToWebView("window.onBackPressed()");
        }
    }

    public void onBrowserReady(final String str, final String str2, final String str3) {
        getAttachedActivity().runOnUiThread(new Runnable() {
            public void run() {
                HyperFragment.this.addWebView(str3);
                if (HyperFragment.this.juspayWebviewState == null || HyperFragment.this.juspayWebviewState.size() == 0) {
                    HyperFragment.this.loadPage(str, str2);
                } else if (HyperFragment.this.juspayWebView != null) {
                    HyperFragment.this.juspayWebView.restoreState(HyperFragment.this.juspayWebviewState);
                }
            }
        });
    }

    public void onBrowserReady(String str, String str2, String str3, String str4, String str5, String str6) {
        JuspayServices juspayServices2 = this.juspayServices;
        final SdkTracker sdkTracker = juspayServices2 != null ? juspayServices2.getSdkTracker() : null;
        Activity attachedActivity = getAttachedActivity();
        final String str7 = str6;
        final String str8 = str;
        final String str9 = str2;
        final String str10 = str3;
        final String str11 = str4;
        final String str12 = str5;
        AnonymousClass6 r0 = new Runnable() {
            public void run() {
                HyperFragment.this.addWebView(str7);
                if ((HyperFragment.this.juspayWebviewState == null || HyperFragment.this.juspayWebviewState.size() == 0) && HyperFragment.this.juspayWebView != null) {
                    HyperFragment.this.juspayWebView.loadDataWithBaseURL(str8, str9, str10, str11, str12);
                } else if (HyperFragment.this.juspayWebView != null) {
                    HyperFragment.this.juspayWebView.restoreState(HyperFragment.this.juspayWebviewState);
                } else {
                    SdkTracker sdkTracker = sdkTracker;
                    if (sdkTracker != null) {
                        sdkTracker.trackAction("system", "error", System.ON_BROWSER_READY, "missing", "JuspayWebView");
                    }
                }
            }
        };
        attachedActivity.runOnUiThread(r0);
    }

    public void onDestroy() {
        SdkTracker.trackBootLifecycle("android", "info", Android.ON_DESTROY, "started", null);
        AcsInterface acsInterface2 = this.acsInterface;
        if (acsInterface2 != null) {
            acsInterface2.invoke("onDestroy", "{}");
        }
        SmsConsentHandler smsConsentHandler2 = this.smsConsentHandler;
        if (smsConsentHandler2 != null) {
            smsConsentHandler2.unregisterConsent(this.activity);
            this.smsConsentHandler = null;
        }
        super.onDestroy();
    }

    public void onDuiReady() {
        this.duiLoaded = true;
        JuspayServices juspayServices2 = this.juspayServices;
        SdkTracker sdkTracker = juspayServices2 != null ? juspayServices2.getSdkTracker() : null;
        if (sdkTracker != null) {
            sdkTracker.trackLifecycle(LifeCycle.HYPER_SDK, "info", HyperSdk.ON_DUI_READY, PromiseImpl.STACK_FRAME_KEY_CLASS, LOG_TAG);
        }
    }

    public void onDuiReleased() {
        JuspayServices juspayServices2 = this.juspayServices;
        SdkTracker sdkTracker = juspayServices2 != null ? juspayServices2.getSdkTracker() : null;
        if (sdkTracker != null) {
            sdkTracker.trackAction("system", "error", System.ON_DUI_RELEASED, "exit_sdk", JSONObject.NULL);
        }
        exit();
    }

    public void onMerchantEvent(JSONObject jSONObject) {
        onMerchantEvent("default", jSONObject);
    }

    public boolean onMerchantEvent(String str, JSONObject jSONObject) {
        String str2;
        if (str.equals(HyperSdk.PROCESS)) {
            setupAllowedDeeplinkPackages(jSONObject);
        }
        try {
            str2 = String.format("window.onMerchantEvent('%s',decodeURIComponent('%s'));", new Object[]{str, URLEncoder.encode(jSONObject.toString(), "UTF-8").replace(MqttTopic.SINGLE_LEVEL_WILDCARD, "%20")});
        } catch (UnsupportedEncodingException unused) {
            str2 = String.format("window.onMerchantEvent('%s',atob('%s'));", new Object[]{str, Base64.encodeToString(jSONObject.toString().getBytes(), 2)});
            JuspayLogger.e(LOG_TAG, "Failed to encode using URLEncoder");
        }
        DuiInterface duiInterface2 = this.duiInterface;
        if (duiInterface2 != null) {
            duiInterface2.invokeCustomFnInDUIWebview(str2);
            return true;
        }
        JuspayLogger.e(LOG_TAG, "duiInterface not Found on Merchant Event");
        return false;
    }

    public void onPause() {
        JuspayServices juspayServices2 = this.juspayServices;
        if (juspayServices2 == null) {
            super.onPause();
            return;
        }
        SdkTracker sdkTracker = juspayServices2.getSdkTracker();
        this.paused = true;
        sdkTracker.trackLifecycle("android", "info", Android.ON_PAUSE, PromiseImpl.STACK_FRAME_KEY_CLASS, LOG_TAG);
        if (getDuiInterface() != null) {
            getDuiInterface().invokeFnInDUIWebview("onPause", "{}");
        }
        AcsInterface acsInterface2 = this.acsInterface;
        if (acsInterface2 != null) {
            acsInterface2.invoke("onPause", "{}");
        }
        super.onPause();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        JuspayServices juspayServices2 = this.juspayServices;
        if (juspayServices2 != null) {
            SdkTracker sdkTracker = juspayServices2.getSdkTracker();
            StringBuilder outline74 = GeneratedOutlineSupport.outline74("requestCode = [", i, "],permissions = [");
            outline74.append(Arrays.toString(strArr));
            outline74.append("], grantResults = [");
            outline74.append(Arrays.toString(iArr));
            outline74.append(CMapParser.MARK_END_OF_ARRAY);
            sdkTracker.trackAction("system", "info", System.ON_REQUEST_PERMISSION_RESULT, "data", outline74.toString());
        }
        DuiInterface duiInterface2 = this.duiInterface;
        if (duiInterface2 != null) {
            duiInterface2.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public void onResume() {
        super.onResume();
        this.paused = false;
        JuspayServices juspayServices2 = this.juspayServices;
        if (juspayServices2 != null) {
            juspayServices2.getSdkTracker().trackLifecycle("android", "info", Android.ON_RESUME, PromiseImpl.STACK_FRAME_KEY_CLASS, LOG_TAG);
            if (getDuiInterface() != null) {
                getDuiInterface().invokeFnInDUIWebview("onResume", "{}");
            }
            AcsInterface acsInterface2 = this.acsInterface;
            if (acsInterface2 != null) {
                acsInterface2.invoke("onResume", "{}");
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        JuspayServices juspayServices2 = this.juspayServices;
        if (juspayServices2 == null) {
            super.onSaveInstanceState(bundle);
            return;
        }
        SdkTracker sdkTracker = juspayServices2.getSdkTracker();
        if (getDuiInterface() != null) {
            getDuiInterface().invokeFnInDUIWebview("OnSaveInstanceState", "{}");
        }
        if (this.juspayWebView != null) {
            Bundle bundle2 = new Bundle();
            this.juspayWebviewState = bundle2;
            this.juspayWebView.saveState(bundle2);
            bundle.putBundle("juspay_webview", this.juspayWebviewState);
        }
        super.onSaveInstanceState(bundle);
        sdkTracker.trackLifecycle("android", "info", Android.ON_SAVE_INSTANCE_STATE, "began", null);
    }

    public void onStop() {
        SdkTracker.trackBootLifecycle("android", "info", Android.ON_STOP, PromiseImpl.STACK_FRAME_KEY_CLASS, LOG_TAG);
        super.onStop();
        if (getDuiInterface() != null) {
            getDuiInterface().invokeFnInDUIWebview("onStop", "{}");
        }
        AcsInterface acsInterface2 = this.acsInterface;
        if (acsInterface2 != null) {
            acsInterface2.invoke("onStop", "{}");
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    public void prepareWebView(Context context) {
        String str;
        String str2;
        String str3;
        String str4;
        JuspayWebViewClient juspayWebViewClient = this.webViewClient;
        if (juspayWebViewClient == null) {
            juspayWebViewClient = newWebViewClient(this.juspayWebView);
        }
        this.webViewClient = juspayWebViewClient;
        JuspayWebChromeClient juspayWebChromeClient = this.webChromeClient;
        if (juspayWebChromeClient == null) {
            juspayWebChromeClient = newWebChromeClient();
        }
        this.webChromeClient = juspayWebChromeClient;
        JuspayServices juspayServices2 = this.juspayServices;
        JSONObject jSONObject = null;
        SdkTracker sdkTracker = juspayServices2 != null ? juspayServices2.getSdkTracker() : null;
        JuspayWebView juspayWebView2 = this.juspayWebView;
        if (juspayWebView2 != null) {
            juspayWebView2.getSettings().setJavaScriptEnabled(true);
            this.juspayWebView.getSettings().setDomStorageEnabled(true);
            try {
                jSONObject = extractBundleParameters().getJSONObject("payload");
                if (jSONObject.optBoolean("godel_receive_merchant_messages")) {
                    this.juspayWebView.addJavascriptInterface(new GodelJsInterface(this), "GodelInterface");
                }
            } catch (JSONException e2) {
                JSONException jSONException = e2;
                if (sdkTracker != null) {
                    sdkTracker.trackAndLogException(LOG_TAG, "action", "system", System.INITIALISE_JUSPAY_WEBVIEW, "Initiate payload is missing", jSONException);
                }
            }
            this.juspayWebView.setDefaultWebViewClient(this.webViewClient);
            this.juspayWebView.setDefaultWebChromeClient(this.webChromeClient);
            this.juspayWebView.getSettings().setAppCacheMaxSize(5242880);
            this.juspayWebView.getSettings().setAppCachePath(context.getApplicationContext().getCacheDir().getAbsolutePath());
            this.juspayWebView.getSettings().setAllowFileAccess(true);
            this.juspayWebView.getSettings().setAppCacheEnabled(true);
            this.juspayWebView.getSettings().setCacheMode(-1);
            if (sdkTracker != null) {
                sdkTracker.trackAction("system", "info", System.INITIALISE_JUSPAY_WEBVIEW, "enabling_third_party_cookies", Boolean.TRUE);
            }
            CookieManager.getInstance().setAcceptThirdPartyCookies(this.juspayWebView, true);
            if (!isNetworkAvailable(context)) {
                if (sdkTracker != null) {
                    sdkTracker.trackAction("system", "info", System.INITIALISE_JUSPAY_WEBVIEW, "no_network", "Setting web view to load from cache if there is no network");
                }
                this.juspayWebView.getSettings().setCacheMode(1);
            }
            if (getBundleParameters() != null) {
                if (getBundleParameters().has("clearCookies") && getBundleParameters().optBoolean("clearCookies")) {
                    if (sdkTracker != null) {
                        sdkTracker.trackAction("system", "info", System.INITIALISE_JUSPAY_WEBVIEW, "clearing", "cookies");
                    }
                    PaymentUtils.clearCookies(this.juspayServices);
                }
                if (jSONObject != null && isClientWhitelistedForWebViewAccess(jSONObject.optString(PaymentConstants.CLIENT_ID_CAMEL, ""))) {
                    JuspayWebViewConfigurationCallback juspayWebViewConfigurationCallback = this.webViewConfigurationCallback;
                    if (juspayWebViewConfigurationCallback != null) {
                        juspayWebViewConfigurationCallback.configureJuspayWebView(this.juspayWebView);
                        if (sdkTracker != null) {
                            str4 = "system";
                            str3 = "info";
                            str2 = System.GODEL_WEBVIEW_WHITELIST;
                            str = AppSettingsData.STATUS_CONFIGURED;
                        }
                    }
                }
            }
            return;
        }
        if (sdkTracker != null) {
            str4 = "system";
            str3 = "error";
            str2 = System.INITIALISE_JUSPAY_WEBVIEW;
            str = "missing";
        }
        sdkTracker.trackAction(str4, str3, str2, str, "JuspayWebView");
    }

    public void removeActivityAndContainer() {
        DuiInterface duiInterface2 = this.duiInterface;
        if (duiInterface2 instanceof JBridge) {
            duiInterface2.clearMerchantViews(this.activity);
        }
        this.activity = null;
        FrameLayout frameLayout = this.duiContainer;
        if (frameLayout != null) {
            ViewParent parent = frameLayout.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.duiContainer);
            }
            this.duiContainer = null;
        }
        DuiInterface duiInterface3 = this.duiInterface;
        if (duiInterface3 instanceof JBridge) {
            duiInterface3.setActivity(null);
        }
        JuspayServices juspayServices2 = this.juspayServices;
        if (juspayServices2 != null) {
            juspayServices2.setContainer(null);
            this.juspayServices.updateActivity(null);
        }
    }

    public void requestPermissionsCheckingAllowed(String[] strArr, int i) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (!this.disallowedPermissions.contains(str)) {
                arrayList.add(str);
            }
        }
        RequestPermissionDelegate requestPermissionDelegate2 = getRequestPermissionDelegate();
        if (isAdded() || !(requestPermissionDelegate2 instanceof DefaultRequestPermissionDelegate)) {
            getRequestPermissionDelegate().requestPermission((String[]) arrayList.toArray(new String[0]), i);
            return;
        }
        if (this.requestQueue == null) {
            this.requestQueue = new LinkedList();
        }
        this.requestQueue.add(new RequestQueueData((String[]) arrayList.toArray(new String[0]), i));
    }

    public void resetSmsConsentHandler() {
        SmsConsentHandler smsConsentHandler2 = this.smsConsentHandler;
        if (smsConsentHandler2 != null) {
            smsConsentHandler2.unregisterConsent(this.activity);
        }
        AnonymousClass7 r0 = new SmsConsentHandler(this.activity, this.juspayServices) {
            public void resetConsentHandler() {
                HyperFragment.this.resetSmsConsentHandler();
            }
        };
        this.smsConsentHandler = r0;
        r0.setIntentReceivedCallback(null);
    }

    public void resetWebView() {
        JuspayWebView juspayWebView2 = this.juspayWebView;
        if (juspayWebView2 != null) {
            juspayWebView2.setDefaultWebChromeClient(juspayWebView2.getWebChromeClient());
            JuspayWebView juspayWebView3 = this.juspayWebView;
            juspayWebView3.setDefaultWebViewClient(juspayWebView3.getWebViewClient());
            this.juspayWebView.stopLoading();
            this.juspayWebView.removeJavascriptInterface("ACSGatekeeper");
            this.juspayWebView.clearHistory();
            this.juspayWebView.destroy();
            if (this.juspayWebView.getParent() != null) {
                ((ViewManager) this.juspayWebView.getParent()).removeView(this.juspayWebView);
            }
            this.juspayWebView = null;
            this.webViewClient = null;
            this.webChromeClient = null;
            this.isWebViewAdded = false;
        } else {
            SdkTracker.trackBootAction("system", "error", Android.RESET_WEBVIEW, "missing", "JuspayWebView");
        }
        DuiInterface duiInterface2 = this.duiInterface;
        if (duiInterface2 != null) {
            duiInterface2.setJuspayWebView(null);
        }
        this.duiLoaded = false;
        this.juspayWebviewState = null;
    }

    public void setActivityLaunchDelegate(ActivityLaunchDelegate activityLaunchDelegate2) {
        this.activityLaunchDelegate = activityLaunchDelegate2;
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
        setBundleParameters(Utils.toJSON(bundle));
    }

    public void setAssetManagementFlag(Context context) {
        if (context != null) {
            KeyValueStore.write(context.getApplicationContext(), context.getString(R.string.godel_app_name), PaymentConstants.ASSET_MANAGE, BaseParser.TRUE);
        }
    }

    public void setBundleParameters(JSONObject jSONObject) {
        this.bundleParameters = jSONObject;
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("payload");
                if (jSONObject2.has("disallowedPermissions")) {
                    JSONArray jSONArray = jSONObject2.getJSONArray("disallowedPermissions");
                    this.disallowedPermissions = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        this.disallowedPermissions.add(jSONArray.getString(i));
                    }
                }
                if (jSONObject2.has(PaymentConstants.ENV)) {
                    this.isLoggingEndpointSandbox = jSONObject2.getString(PaymentConstants.ENV).toLowerCase().equals(ENVIRONMENT.SANDBOX);
                }
                setUpMerchantFragments(jSONObject2);
            } catch (JSONException e2) {
                SdkTracker.trackAndLogBootException(LOG_TAG, "action", Action.USER, "missing_payload", "Missing payload in parameters", e2);
            }
        }
    }

    public <T extends HyperPaymentsCallback & JuspayCallback> void setCallback(T t) {
        setJuspayCallback(HyperPaymentsCallbackAdapter.createDelegate(t));
    }

    public void setConfig(JSONObject jSONObject) {
        this.config = jSONObject;
    }

    public void setContainerAndActivity(Activity activity2, ViewGroup viewGroup) {
        if (activity2 != null) {
            createSMSConsent(activity2);
            DuiInterface duiInterface2 = this.duiInterface;
            if (duiInterface2 instanceof JBridge) {
                duiInterface2.clearMerchantViews(this.activity);
                this.duiInterface.setActivity(activity2);
            }
            this.activity = activity2;
            if (viewGroup != null) {
                FrameLayout createSubLayout = createSubLayout(activity2);
                viewGroup.addView(createSubLayout);
                FrameLayout frameLayout = this.duiContainer;
                if (frameLayout != null && (frameLayout.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.duiContainer.getParent()).removeView(this.duiContainer);
                }
                this.duiContainer = createSubLayout;
                DuiInterface duiInterface3 = this.duiInterface;
                if (duiInterface3 instanceof JBridge) {
                    duiInterface3.setContainer(viewGroup);
                }
                JuspayServices juspayServices2 = this.juspayServices;
                if (juspayServices2 != null) {
                    juspayServices2.setContainer(createSubLayout);
                }
            }
        }
    }

    public void setHyperCallback(JuspayCallback juspayCallback2) {
        setJuspayCallback(HyperPaymentsCallbackAdapter.createJuspayDelegate(juspayCallback2));
    }

    public void setHyperCallback(HyperPaymentsCallback hyperPaymentsCallback) {
        setJuspayCallback(HyperPaymentsCallbackAdapter.createHyperDelegate(hyperPaymentsCallback));
    }

    @Keep
    public void setHyperPaymentsCallBack(HyperPaymentsCallback hyperPaymentsCallback) {
        this.juspayCallback = HyperPaymentsCallbackAdapter.createHyperDelegate(hyperPaymentsCallback);
    }

    public void setJuspayCallback(JuspayCallback juspayCallback2) {
        if (juspayCallback2 instanceof JuspayPaymentsCallback) {
            setJuspayCallback(HyperPaymentsCallbackAdapter.createJuspayPaymentsDelegate((JuspayPaymentsCallback) juspayCallback2));
        } else {
            this.juspayCallback = juspayCallback2;
        }
    }

    public void setPreFetchMode(boolean z) {
        this.isPreFetchMode = z;
    }

    public void setRequestPermissionDelegate(RequestPermissionDelegate requestPermissionDelegate2) {
        this.requestPermissionDelegate = requestPermissionDelegate2;
    }

    public void setUpMerchantFragments(JSONObject jSONObject) {
        if (jSONObject.has(PaymentConstants.FRAGMENT_VIEW_GROUPS) && this.activity != null) {
            JuspayServices juspayServices2 = this.juspayServices;
            if (juspayServices2 != null && juspayServices2.getDynamicUI() != null) {
                try {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(PaymentConstants.FRAGMENT_VIEW_GROUPS);
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        Object opt = jSONObject2.opt(next);
                        if (opt instanceof ViewGroup) {
                            FrameLayout createSubLayout = createSubLayout(this.activity);
                            ((ViewGroup) opt).addView(createSubLayout);
                            jSONObject2.put(next, this.juspayServices.getDynamicUI().addToContainerList(createSubLayout));
                        }
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Keep
    public void setWebViewClient(JuspayWebViewClient juspayWebViewClient) {
        this.webViewClient = juspayWebViewClient;
        JuspayWebView juspayWebView2 = this.juspayWebView;
        if (juspayWebView2 != null) {
            juspayWebView2.setWebViewClient(juspayWebViewClient);
        }
    }

    public void setWebViewConfigurationCallback(JuspayWebViewConfigurationCallback juspayWebViewConfigurationCallback) {
        this.webViewConfigurationCallback = juspayWebViewConfigurationCallback;
    }

    public void start(Context context) {
        try {
            this.duiLoaded = false;
            JuspayServices juspayServices2 = new JuspayServices(context, this.duiContainer);
            this.juspayServices = juspayServices2;
            juspayServices2.setSdkTrackerEndpointSandbox(Boolean.valueOf(this.isLoggingEndpointSandbox));
            SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
            sdkTracker.trackLifecycle(LifeCycle.HYPER_SDK, "info", HyperSdk.HYPER_FRAGMENT, "juspay_service", com.squareup.picasso.Utils.VERB_CREATED);
            if (!validateWebviewInstall(context.getApplicationContext())) {
                this.webViewAvailable = false;
                sdkTracker.trackLifecycle(LifeCycle.HYPER_SDK, "error", HyperSdk.HYPER_FRAGMENT, "webview_installed", Boolean.FALSE);
                return;
            }
            sdkTracker.trackLifecycle(LifeCycle.HYPER_SDK, "info", HyperSdk.HYPER_FRAGMENT, "webview_installed", Boolean.TRUE);
            if (addIfPrefetchAndReturnStatus(sdkTracker)) {
                this.paymentSessionInfo = new PaymentSessionInfo(this, this.juspayServices);
                firstTimeSetup(context, this.juspayServices);
                JSONObject extractBundleParameters = extractBundleParameters();
                this.juspayServices.start(extractBundleParameters);
                this.dynamicUI = this.juspayServices.getDynamicUI();
                DuiInterface createDuiInterface = createDuiInterface();
                this.duiInterface = createDuiInterface;
                this.dynamicUI.addJavascriptInterface(createDuiInterface, JBridge.LOG_TAG);
                if (!this.bootLoaderDownloadAttempted) {
                    this.bootLoaderDownloadAttempted = true;
                    prefetchBootLoaderFile(getContext(), extractBundleParameters, this.juspayServices);
                }
                doHeadCalls();
                this.dynamicUI.loadBaseHtml();
                sdkTracker.trackLifecycle(LifeCycle.HYPER_SDK, "info", HyperSdk.HYPER_FRAGMENT, "url_loaded", "base.html");
            }
        } catch (Exception e2) {
            SdkTracker.trackAndLogBootException(LOG_TAG, LogCategory.LIFECYCLE, LifeCycle.HYPER_SDK, HyperSdk.HYPER_FRAGMENT, "Exception happened while initializing", e2);
            exitOnError(new Intent().putExtra("payload", "{\"status\":\"FAILURE\",\"message\":\"error while initializing\"}"));
        }
    }

    public void startActivityForResult(Intent intent, int i) {
        startActivityForResult(intent, i, null, true);
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        startActivityForResult(intent, i, bundle, true);
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle, boolean z) {
        IntentQueueData intentQueueData;
        if (z) {
            if (!(this.activityLaunchDelegate instanceof DefaultActivityLaunchDelegate) || isAdded()) {
                this.activityLaunchDelegate.startActivityForResult(intent, i, bundle);
                return;
            }
            intentQueueData = new IntentQueueData(intent, i, bundle, z);
        } else if (isAdded()) {
            super.startActivityForResult(intent, i, bundle);
            return;
        } else {
            intentQueueData = new IntentQueueData(intent, i, bundle, z);
        }
        addIntentQueue(intentQueueData);
    }
}
