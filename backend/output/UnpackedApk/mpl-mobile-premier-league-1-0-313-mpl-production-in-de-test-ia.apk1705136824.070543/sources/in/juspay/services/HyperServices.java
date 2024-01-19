package in.juspay.services;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.webkit.WebViewClient;
import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleRegistry;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.razorpay.AnalyticsConstants;
import in.juspay.hypersdk.R;
import in.juspay.hypersdk.analytics.LogPusher;
import in.juspay.hypersdk.core.HyperFragment;
import in.juspay.hypersdk.core.JuspayCoreLib;
import in.juspay.hypersdk.core.JuspayLogger;
import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.core.JuspayWebViewConfigurationCallback;
import in.juspay.hypersdk.core.Labels.Android;
import in.juspay.hypersdk.core.Labels.HyperSdk;
import in.juspay.hypersdk.core.Labels.System;
import in.juspay.hypersdk.core.MerchantViewType;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hypersdk.core.PaymentConstants.LogCategory;
import in.juspay.hypersdk.core.PaymentConstants.SubCategory.Action;
import in.juspay.hypersdk.core.PaymentConstants.SubCategory.LifeCycle;
import in.juspay.hypersdk.core.PrefetchServices;
import in.juspay.hypersdk.core.SdkTracker;
import in.juspay.hypersdk.data.JuspayResponseHandler;
import in.juspay.hypersdk.data.JuspayResponseHandlerDummyImpl;
import in.juspay.hypersdk.data.KeyValueStore;
import in.juspay.hypersdk.services.SdkConfigService;
import in.juspay.hypersdk.ui.ActivityLaunchDelegate;
import in.juspay.hypersdk.ui.HyperPaymentsCallback;
import in.juspay.hypersdk.ui.HyperPaymentsCallbackAdapter;
import in.juspay.hypersdk.ui.JuspayPaymentsCallback;
import in.juspay.hypersdk.ui.RequestPermissionDelegate;
import in.juspay.hypersdk.utils.IntegrationUtils;
import in.juspay.hypersdk.utils.Utils;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
public class HyperServices {
    public static final String CRASHED = "CRASHED";
    public static final String LOG_TAG = "HyperServices";
    public static final String REQUEST_ID = "requestId";
    public FragmentActivity activity;
    public final HashMap<WeakReference<FragmentActivity>, String> activityIds;
    public ActivityLaunchDelegate activityLaunchDelegate;
    public ViewGroup container;
    public final Context context;
    public String currentActivityId;
    public HyperFragment fragment;
    public final String fragmentTag;
    public a hyperExceptionHandler;
    public boolean isDUIReady;
    public boolean isFragmentAttached;
    public boolean isLogPusherRunning;
    public final boolean isWebViewAvailable;
    public boolean jpConsumingBackPress;
    public HyperPaymentsCallback merchantCallback;
    public String merchantClientId;
    public final Queue<Runnable> processWaitingQueue;
    public final Queue<JSONObject> queue;
    public String requestId;
    public RequestPermissionDelegate requestPermissionDelegate;
    public final AtomicReference<a> sdkStateReference;
    public JuspayWebViewConfigurationCallback webViewConfigurationCallback;

    /* renamed from: in.juspay.services.HyperServices$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5013a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001d */
        static {
            /*
                in.juspay.services.a[] r0 = in.juspay.services.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5013a = r0
                r1 = 1
                in.juspay.services.a r2 = in.juspay.services.a.INSTANTIATED     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = f5013a     // Catch:{ NoSuchFieldError -> 0x0016 }
                in.juspay.services.a r3 = in.juspay.services.a.INITIATE_STARTED     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = f5013a     // Catch:{ NoSuchFieldError -> 0x001d }
                in.juspay.services.a r3 = in.juspay.services.a.INITIATE_COMPLETED     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f5013a     // Catch:{ NoSuchFieldError -> 0x0024 }
                in.juspay.services.a r2 = in.juspay.services.a.TERMINATED     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: in.juspay.services.HyperServices.AnonymousClass2.<clinit>():void");
        }
    }

    public static class a implements UncaughtExceptionHandler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<HyperServices> f5031a;

        /* renamed from: b  reason: collision with root package name */
        public UncaughtExceptionHandler f5032b;

        public a(HyperServices hyperServices) {
            this.f5031a = new WeakReference<>(hyperServices);
            SdkTracker.trackBootLifecycle(LifeCycle.HYPER_SDK, "info", HyperSdk.EXCEPTION_HANDLER, "ExceptionHandler", "created HyperExceptionHandler");
        }

        public void a() {
            this.f5032b = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
            SdkTracker.trackBootLifecycle(LifeCycle.HYPER_SDK, "info", HyperSdk.EXCEPTION_HANDLER, "ExceptionHandler", "registered HyperExceptionHandler as default uncaught exception handler");
        }

        public void b() {
            UncaughtExceptionHandler uncaughtExceptionHandler = this.f5032b;
            if (uncaughtExceptionHandler == null || !(uncaughtExceptionHandler instanceof a)) {
                Thread.setDefaultUncaughtExceptionHandler(this.f5032b);
            }
            this.f5031a = new WeakReference<>(null);
            this.f5032b = null;
            SdkTracker.trackBootLifecycle(LifeCycle.HYPER_SDK, "info", HyperSdk.EXCEPTION_HANDLER, "ExceptionHandler", "destroyed HyperExceptionHandler and registered merchant's exception handler as default");
        }

        public void uncaughtException(Thread thread, Throwable th) {
            HyperServices hyperServices = (HyperServices) this.f5031a.get();
            if (hyperServices != null) {
                JuspayLogger.w("UncaughtExceptionHandler", "sending crash to tracker");
                hyperServices.uncaughtException(thread, th);
            }
            if (this.f5032b != null) {
                JuspayLogger.w("UncaughtExceptionHandler", "forwarding crash to merchant");
                this.f5032b.uncaughtException(thread, th);
                return;
            }
            JuspayLogger.e("UncaughtExceptionHandler", "merchant exception handler not found, exiting");
            System.exit(1);
        }
    }

    @Deprecated
    @Keep
    public HyperServices(Activity activity2) {
        String str;
        this.queue = new LinkedList();
        this.isFragmentAttached = false;
        this.processWaitingQueue = new LinkedList();
        this.isLogPusherRunning = false;
        if (activity2 != null) {
            str = String.format(" (%s)", new Object[]{activity2.getClass().getName()});
        } else {
            str = "";
        }
        throw new InstantiationException(GeneratedOutlineSupport.outline52("Instantiating HyperServices with plain Activity", str, " is not allowed, please pass FragmentActivity"));
    }

    @Keep
    public HyperServices(Context context2) {
        this.queue = new LinkedList();
        this.isFragmentAttached = false;
        this.processWaitingQueue = new LinkedList();
        this.isLogPusherRunning = false;
        this.fragmentTag = UUID.randomUUID().toString();
        this.context = context2;
        JuspayCoreLib.setApplicationContext(context2.getApplicationContext());
        this.activityIds = new HashMap<>();
        this.jpConsumingBackPress = false;
        this.hyperExceptionHandler = new a(this);
        this.sdkStateReference = new AtomicReference<>(a.INSTANTIATED);
        this.isWebViewAvailable = HyperFragment.isWebViewInstalled(context2);
    }

    @Keep
    public HyperServices(FragmentActivity fragmentActivity) {
        this(fragmentActivity, (ViewGroup) fragmentActivity.getWindow().getDecorView().findViewById(16908290));
        SdkTracker.trackBootLifecycle(LifeCycle.HYPER_SDK, "info", HyperSdk.HYPER_SERVICE, "view_group", Boolean.FALSE);
    }

    @Keep
    public HyperServices(FragmentActivity fragmentActivity, ViewGroup viewGroup) {
        this(fragmentActivity.getApplicationContext());
        this.activity = fragmentActivity;
        this.container = viewGroup;
        this.currentActivityId = getIdForActivity(fragmentActivity);
        SdkTracker.trackBootLifecycle(LifeCycle.HYPER_SDK, "info", HyperSdk.HYPER_SERVICE, "sdk_create", "success");
    }

    /* access modifiers changed from: private */
    public void addFragment() {
        this.isFragmentAttached = true;
        HyperFragment hyperFragment = this.fragment;
        if (hyperFragment == null || !hyperFragment.isAdded()) {
            FragmentTransaction fragmentTransaction = null;
            FragmentActivity fragmentActivity = this.activity;
            if (!(fragmentActivity == null || this.fragment == null)) {
                fragmentTransaction = fragmentActivity.getSupportFragmentManager().beginTransaction().add((Fragment) this.fragment, this.fragmentTag);
            }
            commitFragmentTransaction(fragmentTransaction);
            ViewGroup viewGroup = this.container;
            if (viewGroup != null) {
                viewGroup.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener() {
                    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        view.onApplyWindowInsets(windowInsets);
                        HyperFragment hyperFragment = HyperServices.this.fragment;
                        if (hyperFragment != null) {
                            hyperFragment.insetUpdated(windowInsets);
                        }
                        return windowInsets;
                    }
                });
            }
            return;
        }
        SdkTracker.trackBootLifecycle(LifeCycle.HYPER_SDK, "warning", Android.FRAGMENT_OPERATION, "addFragment()", "Fragment addition skipped");
    }

    private synchronized void addToQueue(JSONObject jSONObject) {
        this.queue.add(jSONObject);
    }

    private void commitFragmentTransaction(FragmentTransaction fragmentTransaction) {
        if (useCommit()) {
            fragmentTransaction.commitAllowingStateLoss();
        } else {
            fragmentTransaction.commitNowAllowingStateLoss();
        }
    }

    /* access modifiers changed from: private */
    public void createAndSetupFragment(JSONObject jSONObject, HyperPaymentsCallback hyperPaymentsCallback) {
        this.merchantCallback = hyperPaymentsCallback;
        JSONObject modifyParams = modifyParams(jSONObject);
        HyperFragment createFragment = createFragment();
        this.fragment = createFragment;
        createFragment.setBundleParameters(modifyParams);
        this.fragment.setAssetManagementFlag(this.context);
        this.fragment.setCallback(new HyperPaymentsCallbackAdapter() {
            public WebViewClient createJuspaySafeWebViewClient() {
                return HyperServices.this.merchantCallback.createJuspaySafeWebViewClient();
            }

            public View getMerchantView(ViewGroup viewGroup, MerchantViewType merchantViewType) {
                return HyperServices.this.merchantCallback.getMerchantView(viewGroup, merchantViewType);
            }

            public void onEvent(JSONObject jSONObject, JuspayResponseHandler juspayResponseHandler) {
                if (HyperServices.this.handleOnEvent(jSONObject)) {
                    HyperServices.this.merchantCallback.onEvent(jSONObject, juspayResponseHandler);
                }
            }

            public void onStartWaitingDialogCreated(View view) {
                HyperServices.this.merchantCallback.onStartWaitingDialogCreated(view);
            }
        });
        this.fragment.start(this.context);
        tryToStartLogPusherTimer(HyperSdk.INITIATE);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c2, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void doProcess(org.json.JSONObject r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "info"
            java.lang.String r1 = "process"
            java.lang.String r2 = "started"
            r4.logSafeEvents(r0, r1, r2, r5)     // Catch:{ JSONException -> 0x0060 }
            java.lang.String r0 = "payload"
            org.json.JSONObject r0 = r5.getJSONObject(r0)     // Catch:{ JSONException -> 0x0060 }
            java.lang.String r1 = "merchant_root_view"
            android.view.ViewGroup r2 = r4.container     // Catch:{ JSONException -> 0x0060 }
            r3 = -1
            if (r2 == 0) goto L_0x0023
            android.view.ViewGroup r2 = r4.container     // Catch:{ JSONException -> 0x0060 }
            int r2 = r2.getId()     // Catch:{ JSONException -> 0x0060 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ JSONException -> 0x0060 }
            goto L_0x0027
        L_0x0023:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)     // Catch:{ JSONException -> 0x0060 }
        L_0x0027:
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0060 }
            java.lang.String r1 = "merchant_keyboard_mode"
            androidx.fragment.app.FragmentActivity r2 = r4.activity     // Catch:{ JSONException -> 0x0060 }
            if (r2 == 0) goto L_0x003c
            androidx.fragment.app.FragmentActivity r2 = r4.activity     // Catch:{ JSONException -> 0x0060 }
            android.view.Window r2 = r2.getWindow()     // Catch:{ JSONException -> 0x0060 }
            android.view.WindowManager$LayoutParams r2 = r2.getAttributes()     // Catch:{ JSONException -> 0x0060 }
            int r3 = r2.softInputMode     // Catch:{ JSONException -> 0x0060 }
        L_0x003c:
            r0.put(r1, r3)     // Catch:{ JSONException -> 0x0060 }
            java.lang.String r1 = "processStartedTime"
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x0060 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0060 }
            java.lang.String r1 = "currentActivityId"
            java.lang.String r2 = r4.currentActivityId     // Catch:{ JSONException -> 0x0060 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x0060 }
            java.lang.String r1 = "payload"
            r5.put(r1, r0)     // Catch:{ JSONException -> 0x0060 }
            in.juspay.hypersdk.core.HyperFragment r1 = r4.fragment     // Catch:{ JSONException -> 0x0060 }
            if (r1 == 0) goto L_0x0064
            in.juspay.hypersdk.core.HyperFragment r1 = r4.fragment     // Catch:{ JSONException -> 0x0060 }
            r1.setUpMerchantFragments(r0)     // Catch:{ JSONException -> 0x0060 }
            goto L_0x0064
        L_0x005e:
            r5 = move-exception
            goto L_0x00c3
        L_0x0060:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x005e }
        L_0x0064:
            java.lang.String r0 = "requestId"
            boolean r0 = r5.has(r0)     // Catch:{ all -> 0x005e }
            if (r0 != 0) goto L_0x0079
            java.lang.String r5 = "error"
            java.lang.String r0 = "process"
            java.lang.String r1 = "request_id_present"
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x005e }
            r4.logSafeEvents(r5, r0, r1, r2)     // Catch:{ all -> 0x005e }
            monitor-exit(r4)
            return
        L_0x0079:
            java.lang.String r0 = "requestId"
            java.lang.String r1 = "process"
            java.lang.String r0 = r5.optString(r0, r1)     // Catch:{ all -> 0x005e }
            r4.requestId = r0     // Catch:{ all -> 0x005e }
            android.content.Context r0 = in.juspay.hypersdk.core.JuspayCoreLib.getApplicationContext()     // Catch:{ all -> 0x005e }
            if (r0 == 0) goto L_0x00ae
            java.lang.String r1 = in.juspay.hypersdk.utils.IntegrationUtils.getAppName(r0)     // Catch:{ all -> 0x005e }
            java.lang.String r2 = "CRASHED"
            boolean r1 = in.juspay.hypersdk.data.KeyValueStore.contains(r0, r1, r2)     // Catch:{ all -> 0x005e }
            if (r1 == 0) goto L_0x00ae
            java.lang.String r1 = in.juspay.hypersdk.utils.IntegrationUtils.getAppName(r0)     // Catch:{ all -> 0x005e }
            java.lang.String r2 = "CRASHED"
            r3 = 1
            in.juspay.hypersdk.data.KeyValueStore.remove(r0, r1, r2, r3)     // Catch:{ all -> 0x005e }
            boolean r0 = in.juspay.services.b.a(r0, r5)     // Catch:{ all -> 0x005e }
            if (r0 == 0) goto L_0x00ae
            java.lang.String r0 = "JP_016"
            java.lang.String r1 = "Some error occurred in Juspay Safe Mode"
            r4.startSafeModeSDK(r5, r0, r1)     // Catch:{ all -> 0x005e }
            monitor-exit(r4)
            return
        L_0x00ae:
            in.juspay.hypersdk.core.HyperFragment r0 = r4.fragment     // Catch:{ all -> 0x005e }
            if (r0 == 0) goto L_0x00be
            boolean r0 = r4.isDUIReady     // Catch:{ all -> 0x005e }
            if (r0 == 0) goto L_0x00be
            in.juspay.hypersdk.core.HyperFragment r0 = r4.fragment     // Catch:{ all -> 0x005e }
            java.lang.String r1 = "process"
            r0.onMerchantEvent(r1, r5)     // Catch:{ all -> 0x005e }
            goto L_0x00c1
        L_0x00be:
            r4.addToQueue(r5)     // Catch:{ all -> 0x005e }
        L_0x00c1:
            monitor-exit(r4)
            return
        L_0x00c3:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.services.HyperServices.doProcess(org.json.JSONObject):void");
    }

    public static void exitSDK(HyperPaymentsCallback hyperPaymentsCallback, boolean z, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        notifyMerchant(hyperPaymentsCallback, z, str, str2, "process_result", jSONObject, jSONObject2);
    }

    /* access modifiers changed from: private */
    public String getIdForActivity(FragmentActivity fragmentActivity) {
        for (Entry next : this.activityIds.entrySet()) {
            if (((FragmentActivity) ((WeakReference) next.getKey()).get()) == fragmentActivity) {
                return (String) next.getValue();
            }
        }
        String uuid = UUID.randomUUID().toString();
        this.activityIds.put(new WeakReference(fragmentActivity), uuid);
        return uuid;
    }

    @Keep
    public static JSONObject getVersions(final Context context2) {
        return new JSONObject() {
            {
                try {
                    put("sdkVersion", IntegrationUtils.getSdkVersion(context2));
                } catch (JSONException unused) {
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public void logSafeEvents(String str, String str2, String str3, Object obj) {
        HyperFragment hyperFragment = this.fragment;
        if (hyperFragment == null) {
            SdkTracker.trackBootLifecycle(LifeCycle.HYPER_SDK, str, str2, str3, obj);
            return;
        }
        JuspayServices juspayServices = hyperFragment.getJuspayServices();
        SdkTracker sdkTracker = juspayServices == null ? null : juspayServices.getSdkTracker();
        if (sdkTracker != null) {
            sdkTracker.trackLifecycle(LifeCycle.HYPER_SDK, str, str2, str3, obj);
        } else {
            SdkTracker.trackBootLifecycle(LifeCycle.HYPER_SDK, str, str2, str3, obj);
        }
    }

    private void logSafeExceptions(String str, String str2, String str3, Throwable th) {
        HyperFragment hyperFragment = this.fragment;
        if (hyperFragment == null) {
            SdkTracker.trackBootException(LogCategory.LIFECYCLE, str, str2, str3, th);
            return;
        }
        JuspayServices juspayServices = hyperFragment.getJuspayServices();
        SdkTracker sdkTracker = juspayServices == null ? null : juspayServices.getSdkTracker();
        if (sdkTracker != null) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.LIFECYCLE, str, str2, str3, th);
        } else {
            SdkTracker.trackBootException(LogCategory.LIFECYCLE, str, str2, str3, th);
        }
    }

    public static void notifyMerchant(HyperPaymentsCallback hyperPaymentsCallback, boolean z, String str, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put(REQUEST_ID, jSONObject.optString(REQUEST_ID, ""));
            jSONObject3.put("service", jSONObject.optString("service", "service"));
            jSONObject3.put("error", z);
            jSONObject3.put("errorCode", str);
            jSONObject3.put("errorMessage", str2);
            jSONObject3.put("event", str3);
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            jSONObject3.put("payload", jSONObject2);
            hyperPaymentsCallback.onEvent(jSONObject3, new JuspayResponseHandlerDummyImpl());
        } catch (Exception e2) {
            SdkTracker.trackAndLogBootException(LOG_TAG, "action", "system", HyperSdk.EXIT_SDK_ERROR, "Error while sending response to merchant", e2);
        }
    }

    /* access modifiers changed from: private */
    public void notifyMerchant(String str, String str2, String str3, JSONObject jSONObject) {
        HyperPaymentsCallback hyperPaymentsCallback = this.merchantCallback;
        if (hyperPaymentsCallback != null) {
            notifyMerchant(hyperPaymentsCallback, true, str, str2, str3, jSONObject, null);
        }
    }

    @Deprecated
    @Keep
    public static void preFetch(Context context2, String str) {
        SdkTracker.trackBootLifecycle(LifeCycle.HYPER_SDK, "info", HyperSdk.PREFETCH, PaymentConstants.CLIENT_ID, str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("service", "in.juspay.hyperpay");
            jSONObject.put("payload", new JSONObject().put(PaymentConstants.CLIENT_ID_CAMEL, str));
        } catch (JSONException e2) {
            JuspayLogger.e(LOG_TAG, "Error writing to JSON", e2);
        }
        preFetch(context2, jSONObject);
    }

    @Keep
    public static void preFetch(Context context2, JSONObject jSONObject) {
        PrefetchServices.preFetch(context2, jSONObject);
    }

    @Deprecated
    @Keep
    public static void preFetch(FragmentActivity fragmentActivity, String str) {
        SdkTracker.trackBootLifecycle(LifeCycle.HYPER_SDK, "info", HyperSdk.PREFETCH, PaymentConstants.CLIENT_ID, str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("service", "in.juspay.hyperpay");
            jSONObject.put("payload", new JSONObject().put(PaymentConstants.CLIENT_ID_CAMEL, str));
        } catch (JSONException e2) {
            JuspayLogger.e(LOG_TAG, "Error writing to JSON", e2);
        }
        preFetch(fragmentActivity, jSONObject);
    }

    @Keep
    public static void preFetch(FragmentActivity fragmentActivity, JSONObject jSONObject) {
        preFetch(fragmentActivity.getApplicationContext(), jSONObject);
    }

    /* access modifiers changed from: private */
    public void removeFragment() {
        if (this.fragment != null && this.isFragmentAttached) {
            this.isFragmentAttached = false;
            FragmentActivity fragmentActivity = this.activity;
            if (fragmentActivity == null || ((LifecycleRegistry) fragmentActivity.getLifecycle()).mState != State.DESTROYED) {
                FragmentActivity fragmentActivity2 = this.activity;
                if (fragmentActivity2 != null) {
                    FragmentManager supportFragmentManager = fragmentActivity2.getSupportFragmentManager();
                    if (!supportFragmentManager.isDestroyed() && supportFragmentManager.findFragmentByTag(this.fragmentTag) != null) {
                        commitFragmentTransaction(supportFragmentManager.beginTransaction().remove(this.fragment));
                    }
                }
            }
        }
    }

    private void runOnMainThread(Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            new Handler(Looper.getMainLooper()).post(runnable);
        } else {
            runnable.run();
        }
    }

    /* access modifiers changed from: private */
    public void runProcessWaitQueue() {
        logSafeEvents("info", HyperSdk.PROCESS_WAIT_QUEUE, "pending_processes", Integer.valueOf(this.processWaitingQueue.size()));
        while (this.fragment != null && this.processWaitingQueue.size() > 0) {
            Runnable poll = this.processWaitingQueue.poll();
            if (poll != null) {
                poll.run();
            }
        }
    }

    private void startSafeModeSDK(JSONObject jSONObject, String str, String str2) {
        b.a(this.merchantCallback, this.activity, jSONObject, str, str2);
    }

    @Deprecated
    private JSONObject transformToNewPayload(String str, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (str != null) {
            try {
                jSONObject2.put(REQUEST_ID, str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (jSONObject.has("service")) {
            jSONObject2.put("service", jSONObject.get("service"));
        }
        jSONObject2.put("payload", jSONObject);
        return jSONObject2;
    }

    /* access modifiers changed from: private */
    public synchronized void tryToStartLogPusherTimer(String str) {
        if (!this.isLogPusherRunning) {
            try {
                if (getJuspayServices().getSdkConfigService().getSdkConfig().getJSONObject(SdkTracker.logsConfig).optString("startLogPusherTimerOn", str).equals(str)) {
                    this.isLogPusherRunning = true;
                    new Thread(new Runnable() {
                        public void run() {
                            LogPusher.startLogPusherTimer();
                        }
                    }).start();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public void uncaughtException(Thread thread, Throwable th) {
        String str;
        Context applicationContext = JuspayCoreLib.getApplicationContext();
        if (applicationContext != null) {
            KeyValueStore.write(applicationContext, IntegrationUtils.getAppName(applicationContext), CRASHED, BaseParser.TRUE, true);
            HyperFragment hyperFragment = this.fragment;
            if (hyperFragment != null) {
                JuspayServices juspayServices = hyperFragment.getJuspayServices();
                SdkTracker sdkTracker = juspayServices == null ? null : juspayServices.getSdkTracker();
                if (sdkTracker != null) {
                    str = sdkTracker.getExceptionLog(LogCategory.LIFECYCLE, LifeCycle.HYPER_SDK, System.SDK_CRASHED, "SDK Crashed Uncaught exception handler", th);
                    LogPusher.addLogsToPersistedQueue(str);
                }
            }
            str = SdkTracker.trackAndGetExceptionLog(LogCategory.LIFECYCLE, LifeCycle.HYPER_SDK, System.SDK_CRASHED, "SDK Crashed Uncaught exception handler", th);
            LogPusher.addLogsToPersistedQueue(str);
        }
    }

    private boolean useCommit() {
        if (this.merchantClientId == null) {
            return false;
        }
        JSONObject cachedSdkConfig = SdkConfigService.getCachedSdkConfig();
        if (cachedSdkConfig == null) {
            return false;
        }
        return Utils.optJSONObject(cachedSdkConfig, "useCommitClientIds").optString(this.merchantClientId.toLowerCase().split("_")[0]).equals(BaseParser.TRUE);
    }

    public boolean checkAndStartInitiate(JSONObject jSONObject) {
        a aVar = this.sdkStateReference.get();
        if (aVar == a.INITIATE_STARTED || aVar == a.INITIATE_COMPLETED) {
            notifyMerchant("JP_017", "initiate() can only be called once without terminate()", "initiate_result", jSONObject);
            logSafeEvents("error", HyperSdk.INITIATE, "interrupted", "initiate() can only be called once without terminate()");
            return false;
        }
        this.sdkStateReference.set(a.INITIATE_STARTED);
        SdkTracker.trackBootLifecycle(LifeCycle.HYPER_SDK, "info", HyperSdk.INITIATE, "started", "Started initiating the SDK");
        return true;
    }

    @Keep
    public HyperFragment createFragment() {
        HyperFragment hyperFragment = new HyperFragment();
        ActivityLaunchDelegate activityLaunchDelegate2 = this.activityLaunchDelegate;
        if (activityLaunchDelegate2 != null) {
            hyperFragment.setActivityLaunchDelegate(activityLaunchDelegate2);
        }
        RequestPermissionDelegate requestPermissionDelegate2 = this.requestPermissionDelegate;
        if (requestPermissionDelegate2 != null) {
            hyperFragment.setRequestPermissionDelegate(requestPermissionDelegate2);
        }
        JuspayWebViewConfigurationCallback juspayWebViewConfigurationCallback = this.webViewConfigurationCallback;
        if (juspayWebViewConfigurationCallback != null) {
            hyperFragment.setWebViewConfigurationCallback(juspayWebViewConfigurationCallback);
        }
        return hyperFragment;
    }

    public HyperFragment getFragment() {
        return this.fragment;
    }

    public JuspayServices getJuspayServices() {
        HyperFragment hyperFragment = this.fragment;
        if (hyperFragment == null) {
            return null;
        }
        return hyperFragment.getJuspayServices();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0086 A[Catch:{ Exception -> 0x0098 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008c A[Catch:{ Exception -> 0x0098 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handleOnEvent(org.json.JSONObject r12) {
        /*
            r11 = this;
            java.lang.String r0 = "event"
            java.lang.String r1 = "on_event"
            java.lang.String r2 = "payload"
            r3 = 1
            org.json.JSONObject r4 = r12.optJSONObject(r2)     // Catch:{ Exception -> 0x0098 }
            java.lang.String r5 = r12.optString(r0)     // Catch:{ Exception -> 0x0098 }
            int r6 = r5.hashCode()     // Catch:{ Exception -> 0x0098 }
            r7 = -1917311628(0xffffffff8db82574, float:-1.1348892E-30)
            java.lang.String r8 = "jp_consuming_backpress"
            r9 = -1
            r10 = 0
            if (r6 == r7) goto L_0x002a
            r7 = 731104317(0x2b93c43d, float:1.0499445E-12)
            if (r6 == r7) goto L_0x0022
            goto L_0x0034
        L_0x0022:
            boolean r5 = r5.equals(r8)     // Catch:{ Exception -> 0x0098 }
            if (r5 == 0) goto L_0x0034
            r5 = 0
            goto L_0x0035
        L_0x002a:
            java.lang.String r6 = "onJOSReady"
            boolean r5 = r5.equals(r6)     // Catch:{ Exception -> 0x0098 }
            if (r5 == 0) goto L_0x0034
            r5 = 1
            goto L_0x0035
        L_0x0034:
            r5 = -1
        L_0x0035:
            if (r5 == 0) goto L_0x008c
            if (r5 == r3) goto L_0x008b
            java.lang.String r4 = "default"
            java.lang.String r0 = r12.optString(r0, r4)     // Catch:{ Exception -> 0x0076 }
            int r4 = r0.hashCode()     // Catch:{ Exception -> 0x0076 }
            r5 = 24468461(0x1755bed, float:4.5065347E-38)
            if (r4 == r5) goto L_0x0058
            r5 = 1858061443(0x6ebfc483, float:2.9674602E28)
            if (r4 == r5) goto L_0x004e
            goto L_0x0061
        L_0x004e:
            java.lang.String r4 = "initiate_result"
            boolean r0 = r0.equals(r4)     // Catch:{ Exception -> 0x0076 }
            if (r0 == 0) goto L_0x0061
            r9 = 1
            goto L_0x0061
        L_0x0058:
            java.lang.String r4 = "process_result"
            boolean r0 = r0.equals(r4)     // Catch:{ Exception -> 0x0076 }
            if (r0 == 0) goto L_0x0061
            r9 = 0
        L_0x0061:
            java.lang.String r0 = "ended"
            java.lang.String r4 = "info"
            if (r9 == 0) goto L_0x0073
            if (r9 == r3) goto L_0x006d
            r11.logSafeEvents(r4, r1, r2, r12)     // Catch:{ Exception -> 0x0076 }
            goto L_0x0076
        L_0x006d:
            java.lang.String r2 = "initiate"
        L_0x006f:
            r11.logSafeEvents(r4, r2, r0, r12)     // Catch:{ Exception -> 0x0076 }
            goto L_0x0076
        L_0x0073:
            java.lang.String r2 = "process"
            goto L_0x006f
        L_0x0076:
            java.lang.String r0 = "action"
            java.lang.String r2 = ""
            java.lang.String r12 = r12.optString(r0, r2)     // Catch:{ Exception -> 0x0098 }
            java.lang.String r0 = "DUI_READY"
            boolean r12 = r12.equals(r0)     // Catch:{ Exception -> 0x0098 }
            if (r12 == 0) goto L_0x00a0
            r11.isDUIReady = r3     // Catch:{ Exception -> 0x0098 }
            r11.processQueue()     // Catch:{ Exception -> 0x0098 }
        L_0x008b:
            return r10
        L_0x008c:
            if (r4 != 0) goto L_0x0091
            r11.jpConsumingBackPress = r3     // Catch:{ Exception -> 0x0098 }
            goto L_0x0097
        L_0x0091:
            boolean r12 = r4.getBoolean(r8)     // Catch:{ Exception -> 0x0098 }
            r11.jpConsumingBackPress = r12     // Catch:{ Exception -> 0x0098 }
        L_0x0097:
            return r10
        L_0x0098:
            r12 = move-exception
            java.lang.String r0 = "android"
            java.lang.String r2 = "on_event_failed_during_evaluation"
            r11.logSafeExceptions(r0, r1, r2, r12)
        L_0x00a0:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.services.HyperServices.handleOnEvent(org.json.JSONObject):boolean");
    }

    @Deprecated
    @Keep
    public void initiate(Bundle bundle, JuspayPaymentsCallback juspayPaymentsCallback) {
        initiate(transformToNewPayload(null, Utils.toJSON(bundle)), (HyperPaymentsCallback) HyperPaymentsCallbackAdapter.createJuspayPaymentsDelegate(juspayPaymentsCallback));
    }

    @Keep
    public synchronized void initiate(FragmentActivity fragmentActivity, ViewGroup viewGroup, JSONObject jSONObject, HyperPaymentsCallback hyperPaymentsCallback) {
        this.container = viewGroup;
        SdkTracker.trackBootLifecycle(LifeCycle.HYPER_SDK, "info", HyperSdk.INITIATE, "started", jSONObject);
        initiate(fragmentActivity, jSONObject, hyperPaymentsCallback);
    }

    @Keep
    public synchronized void initiate(FragmentActivity fragmentActivity, JSONObject jSONObject, HyperPaymentsCallback hyperPaymentsCallback) {
        if (this.activity != fragmentActivity) {
            SdkTracker.trackBootLifecycle(LifeCycle.HYPER_SDK, "info", HyperSdk.INITIATE, "activity_changed", BaseParser.TRUE);
        }
        this.activity = fragmentActivity;
        this.currentActivityId = getIdForActivity(fragmentActivity);
        initiate(jSONObject, hyperPaymentsCallback);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:1|2|3|(1:5)(1:6)|7|8|9|10|11|12|(3:14|(1:16)|17)|18) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0044  */
    @androidx.annotation.Keep
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void initiate(final org.json.JSONObject r6, final in.juspay.hypersdk.ui.HyperPaymentsCallback r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.String r0 = "hypersdk"
            java.lang.String r1 = "info"
            java.lang.String r2 = "initiate"
            java.lang.String r3 = "fragment_activity_used"
            androidx.fragment.app.FragmentActivity r4 = r5.activity     // Catch:{ all -> 0x005e }
            if (r4 != 0) goto L_0x0010
            java.lang.String r4 = "false"
            goto L_0x0013
        L_0x0010:
            java.lang.String r4 = "true"
        L_0x0013:
            in.juspay.hypersdk.core.SdkTracker.trackBootLifecycle(r0, r1, r2, r3, r4)     // Catch:{ all -> 0x005e }
            java.lang.String r0 = "hypersdk"
            java.lang.String r1 = "info"
            java.lang.String r2 = "initiate"
            java.lang.String r3 = "started"
            in.juspay.hypersdk.core.SdkTracker.trackBootLifecycle(r0, r1, r2, r3, r6)     // Catch:{ all -> 0x005e }
            java.lang.String r0 = "payload"
            org.json.JSONObject r0 = r6.getJSONObject(r0)     // Catch:{ JSONException -> 0x003e }
            java.lang.String r1 = "initiateStartedTime"
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x003e }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x003e }
            java.lang.String r1 = "payload"
            r6.put(r1, r0)     // Catch:{ JSONException -> 0x003e }
            java.lang.String r1 = "clientId"
            java.lang.String r0 = r0.getString(r1)     // Catch:{ JSONException -> 0x003e }
            r5.merchantClientId = r0     // Catch:{ JSONException -> 0x003e }
        L_0x003e:
            boolean r0 = r5.checkAndStartInitiate(r6)     // Catch:{ all -> 0x005e }
            if (r0 == 0) goto L_0x005c
            in.juspay.services.HyperServices$a r0 = r5.hyperExceptionHandler     // Catch:{ all -> 0x005e }
            if (r0 != 0) goto L_0x004f
            in.juspay.services.HyperServices$a r0 = new in.juspay.services.HyperServices$a     // Catch:{ all -> 0x005e }
            r0.<init>(r5)     // Catch:{ all -> 0x005e }
            r5.hyperExceptionHandler = r0     // Catch:{ all -> 0x005e }
        L_0x004f:
            in.juspay.services.HyperServices$a r0 = r5.hyperExceptionHandler     // Catch:{ all -> 0x005e }
            r0.a()     // Catch:{ all -> 0x005e }
            in.juspay.services.HyperServices$3 r0 = new in.juspay.services.HyperServices$3     // Catch:{ all -> 0x005e }
            r0.<init>(r6, r7)     // Catch:{ all -> 0x005e }
            r5.runOnMainThread(r0)     // Catch:{ all -> 0x005e }
        L_0x005c:
            monitor-exit(r5)
            return
        L_0x005e:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.services.HyperServices.initiate(org.json.JSONObject, in.juspay.hypersdk.ui.HyperPaymentsCallback):void");
    }

    @Keep
    public boolean isInitialised() {
        final a aVar = this.sdkStateReference.get();
        final boolean z = aVar == a.INITIATE_STARTED || aVar == a.INITIATE_COMPLETED;
        SdkTracker.trackBootLifecycle(LifeCycle.HYPER_SDK, "info", HyperSdk.INITIATE, "isInitialised()", new JSONObject() {
            {
                try {
                    put("sdkState", String.valueOf(aVar));
                    put("isInitialised", z);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        });
        return z;
    }

    public JSONObject modifyParams(JSONObject jSONObject) {
        try {
            jSONObject.put("service_based", true);
            jSONObject.put("use_local_assets", this.context.getResources().getBoolean(R.bool.use_local_assets));
            jSONObject.getJSONObject("payload").put("currentActivityId", this.currentActivityId);
        } catch (Exception e2) {
            JuspayLogger.e(LOG_TAG, "Failed to write to JSON", e2);
        }
        return jSONObject;
    }

    @Keep
    public void onActivityResult(int i, int i2, Intent intent) {
        HyperFragment hyperFragment = this.fragment;
        if (hyperFragment != null) {
            hyperFragment.onActivityResult(i & 65535, i2, intent);
        }
    }

    @Keep
    public boolean onBackPressed() {
        SdkTracker.trackBootLifecycle("android", "info", Android.BACK_PRESSED, "consuming_backpress", Boolean.valueOf(this.jpConsumingBackPress));
        if (this.fragment == null || this.isDUIReady || this.queue.isEmpty()) {
            HyperFragment hyperFragment = this.fragment;
            if (hyperFragment == null || !hyperFragment.isAdded() || !this.jpConsumingBackPress) {
                return false;
            }
            this.fragment.onBackPressed();
            return true;
        }
        this.queue.clear();
        String str = this.requestId;
        if (str == null) {
            str = "backpressed";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(REQUEST_ID, str);
            if (this.merchantCallback != null) {
                notifyMerchant("JP_002", "User Aborted Transaction", "process_result", jSONObject);
            }
        } catch (Exception e2) {
            SdkTracker.trackAndLogBootException(LOG_TAG, "action", Action.USER, HyperSdk.EXIT_SDK_ERROR, "Error while giving response to merchant on backpress", e2);
        }
        return true;
    }

    @Keep
    public void onMerchantEvent(String str, JSONObject jSONObject) {
        HyperFragment hyperFragment = this.fragment;
        if (hyperFragment != null) {
            hyperFragment.onMerchantEvent(str, jSONObject);
        }
    }

    @Keep
    public void onMerchantEvent(JSONObject jSONObject) {
        HyperFragment hyperFragment = this.fragment;
        if (hyperFragment != null) {
            hyperFragment.onMerchantEvent(jSONObject);
        }
    }

    @Keep
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        HyperFragment hyperFragment = this.fragment;
        if (hyperFragment != null) {
            hyperFragment.onRequestPermissionsResult(i & 65535, strArr, iArr);
        }
    }

    @Keep
    public synchronized void process(final FragmentActivity fragmentActivity, final ViewGroup viewGroup, final JSONObject jSONObject) {
        int i = AnonymousClass2.f5013a[this.sdkStateReference.get().ordinal()];
        if (i == 1) {
            throw new IllegalStateException("initiate() must be called before calling process()");
        } else if (i == 2) {
            this.processWaitingQueue.add(new Runnable() {
                public void run() {
                    HyperServices.this.process(fragmentActivity, viewGroup, jSONObject);
                }
            });
        } else if (i == 3) {
            runOnMainThread(new Runnable() {
                public void run() {
                    if (!HyperServices.this.isWebViewAvailable) {
                        HyperServices.this.notifyMerchant("JP_020", "No web view is present in the device", "process_result", jSONObject);
                        return;
                    }
                    HyperServices hyperServices = HyperServices.this;
                    if (hyperServices.fragment == null) {
                        hyperServices.logSafeEvents("critical", HyperSdk.PROCESS, "fragment", "fragment is null");
                        return;
                    }
                    if (fragmentActivity != hyperServices.activity) {
                        hyperServices.logSafeEvents("info", HyperSdk.PROCESS, "activity_changed", BaseParser.TRUE);
                    }
                    FragmentActivity fragmentActivity = fragmentActivity;
                    HyperServices hyperServices2 = HyperServices.this;
                    if (fragmentActivity != hyperServices2.activity || !hyperServices2.isFragmentAttached) {
                        HyperServices hyperServices3 = HyperServices.this;
                        hyperServices3.container = viewGroup;
                        hyperServices3.removeFragment();
                        HyperServices hyperServices4 = HyperServices.this;
                        FragmentActivity fragmentActivity2 = fragmentActivity;
                        hyperServices4.activity = fragmentActivity2;
                        hyperServices4.currentActivityId = hyperServices4.getIdForActivity(fragmentActivity2);
                        HyperServices hyperServices5 = HyperServices.this;
                        hyperServices5.fragment.setContainerAndActivity(fragmentActivity, hyperServices5.container);
                        HyperServices.this.addFragment();
                    } else {
                        HyperServices hyperServices6 = HyperServices.this;
                        ViewGroup viewGroup = hyperServices6.container;
                        ViewGroup viewGroup2 = viewGroup;
                        if (viewGroup != viewGroup2) {
                            hyperServices6.container = viewGroup2;
                            hyperServices6.fragment.setContainerAndActivity(fragmentActivity, viewGroup2);
                        }
                    }
                    JuspayServices juspayServices = HyperServices.this.getJuspayServices();
                    if (juspayServices != null) {
                        juspayServices.updateActivity(HyperServices.this.activity);
                    }
                    HyperServices.this.tryToStartLogPusherTimer(HyperSdk.PROCESS);
                    HyperServices.this.doProcess(jSONObject);
                }
            });
        } else if (i == 4) {
            notifyMerchant("JP_017", "process() called after terminate()", "process_result", jSONObject);
            logSafeEvents("error", HyperSdk.PROCESS, "interrupted", "process() called after terminate()");
        }
    }

    @Keep
    public synchronized void process(FragmentActivity fragmentActivity, JSONObject jSONObject) {
        process(fragmentActivity, (ViewGroup) fragmentActivity.getWindow().getDecorView().findViewById(16908290), jSONObject);
    }

    @Deprecated
    @Keep
    public void process(String str, JSONObject jSONObject) {
        try {
            jSONObject = transformToNewPayload(str, jSONObject);
        } catch (Exception e2) {
            logSafeExceptions(LifeCycle.HYPER_SDK, HyperSdk.PROCESS, "Exception while inserting requestId in deprecated process", e2);
        }
        process(jSONObject);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0022, code lost:
        return;
     */
    @androidx.annotation.Keep
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void process(org.json.JSONObject r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            androidx.fragment.app.FragmentActivity r0 = r3.activity     // Catch:{ all -> 0x0023 }
            if (r0 != 0) goto L_0x0010
            java.lang.String r0 = "JP_003"
            java.lang.String r1 = "FragmentActivity needs to be send in process"
            java.lang.String r2 = "process_result"
            r3.notifyMerchant(r0, r1, r2, r4)     // Catch:{ all -> 0x0023 }
            monitor-exit(r3)
            return
        L_0x0010:
            android.view.ViewGroup r0 = r3.container     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x001c
            androidx.fragment.app.FragmentActivity r0 = r3.activity     // Catch:{ all -> 0x0023 }
            android.view.ViewGroup r1 = r3.container     // Catch:{ all -> 0x0023 }
            r3.process(r0, r1, r4)     // Catch:{ all -> 0x0023 }
            goto L_0x0021
        L_0x001c:
            androidx.fragment.app.FragmentActivity r0 = r3.activity     // Catch:{ all -> 0x0023 }
            r3.process(r0, r4)     // Catch:{ all -> 0x0023 }
        L_0x0021:
            monitor-exit(r3)
            return
        L_0x0023:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.services.HyperServices.process(org.json.JSONObject):void");
    }

    public void processQueue() {
        JSONObject poll = this.queue.poll();
        logSafeEvents("info", HyperSdk.PROCESS_QUEUE, "data", poll);
        if (this.isDUIReady && poll != null && this.fragment != null) {
            process(poll);
            processQueue();
        }
    }

    @Deprecated
    @Keep
    public synchronized void resetActivity() {
        resetActivity(this.activity);
    }

    @Keep
    public synchronized void resetActivity(FragmentActivity fragmentActivity) {
        if (fragmentActivity == this.activity) {
            SdkTracker.trackBootLifecycle(LifeCycle.HYPER_SDK, "info", HyperSdk.TERMINATE, "resetActivity()", AnalyticsConstants.CALLED);
            if (this.fragment != null) {
                removeFragment();
                this.fragment.removeActivityAndContainer();
            }
            this.activity = null;
            this.container = null;
        }
    }

    @Keep
    public void setActivityLaunchDelegate(ActivityLaunchDelegate activityLaunchDelegate2) {
        this.activityLaunchDelegate = activityLaunchDelegate2;
        HyperFragment hyperFragment = this.fragment;
        if (hyperFragment != null) {
            hyperFragment.setActivityLaunchDelegate(activityLaunchDelegate2);
        }
    }

    @Keep
    public void setRequestPermissionDelegate(RequestPermissionDelegate requestPermissionDelegate2) {
        this.requestPermissionDelegate = requestPermissionDelegate2;
        HyperFragment hyperFragment = this.fragment;
        if (hyperFragment != null) {
            hyperFragment.setRequestPermissionDelegate(requestPermissionDelegate2);
        }
    }

    @Keep
    public void setWebViewConfigurationCallback(JuspayWebViewConfigurationCallback juspayWebViewConfigurationCallback) {
        this.webViewConfigurationCallback = juspayWebViewConfigurationCallback;
        HyperFragment hyperFragment = this.fragment;
        if (hyperFragment != null) {
            hyperFragment.setWebViewConfigurationCallback(juspayWebViewConfigurationCallback);
        }
    }

    @Keep
    public synchronized void terminate() {
        a aVar = this.sdkStateReference.get();
        if (aVar == a.TERMINATED) {
            SdkTracker.trackBootLifecycle(LifeCycle.HYPER_SDK, "warning", HyperSdk.TERMINATE, "started", "Terminate called again, skipping");
        } else if (aVar == a.INSTANTIATED) {
            SdkTracker.trackBootLifecycle(LifeCycle.HYPER_SDK, "warning", HyperSdk.TERMINATE, "started", "Terminate called without initiate, skipping");
        } else {
            this.sdkStateReference.set(a.TERMINATED);
            SdkTracker.trackBootLifecycle(LifeCycle.HYPER_SDK, "info", HyperSdk.TERMINATE, "started", "Terminating the SDK");
            this.isLogPusherRunning = false;
            if (this.hyperExceptionHandler != null) {
                this.hyperExceptionHandler.b();
                this.hyperExceptionHandler = null;
            }
            this.currentActivityId = null;
            runOnMainThread(new Runnable() {
                public void run() {
                    HyperFragment hyperFragment = HyperServices.this.fragment;
                    if (hyperFragment != null && hyperFragment.isAdded()) {
                        try {
                            HyperServices.this.fragment.destroy();
                            HyperServices.this.removeFragment();
                        } catch (Exception e2) {
                            SdkTracker.trackAndLogBootException(HyperServices.LOG_TAG, LogCategory.LIFECYCLE, LifeCycle.HYPER_SDK, HyperSdk.INITIATE, "Failed to remove the fragment", e2);
                        }
                        HyperServices hyperServices = HyperServices.this;
                        hyperServices.container = null;
                        hyperServices.activity = null;
                        hyperServices.fragment = null;
                        LogPusher.stopLogPusherOnTerminate();
                    }
                }
            });
        }
    }

    public void terminate(JSONObject jSONObject) {
        logSafeEvents("info", HyperSdk.TERMINATE_PROCESS, "request", jSONObject);
        onMerchantEvent(HyperSdk.TERMINATE, jSONObject);
    }
}
