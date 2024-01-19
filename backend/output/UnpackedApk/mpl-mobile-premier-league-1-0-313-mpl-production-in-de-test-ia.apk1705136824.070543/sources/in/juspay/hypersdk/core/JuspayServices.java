package in.juspay.hypersdk.core;

import android.app.Activity;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.Build.VERSION;
import android.security.keystore.KeyGenParameterSpec.Builder;
import android.security.keystore.KeyInfo;
import android.widget.FrameLayout;
import in.juspay.hypersdk.core.Labels.Device;
import in.juspay.hypersdk.core.Labels.HyperSdk;
import in.juspay.hypersdk.core.PaymentConstants.SubCategory.Action;
import in.juspay.hypersdk.data.KeyValueStore;
import in.juspay.hypersdk.data.SdkInfo;
import in.juspay.hypersdk.data.SessionInfo;
import in.juspay.hypersdk.mystique.ErrorCallback;
import in.juspay.hypersdk.services.FileProviderService;
import in.juspay.hypersdk.services.RemoteAssetService;
import in.juspay.hypersdk.services.SdkConfigService;
import in.juspay.hypersdk.utils.IntegrationUtils;
import in.juspay.hypersdk.utils.Utils;
import java.lang.ref.WeakReference;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.util.Arrays;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.json.JSONObject;

public class JuspayServices {
    public final String LOG_TAG;
    public WeakReference<Activity> activity;
    public FrameLayout container;
    public Context context;
    public final DuiLogger duiLogger;
    public DynamicUI dynamicUI;
    public ErrorCallback errorCallback;
    public final FileProviderService fileProviderService;
    public final RemoteAssetService remoteAssetService;
    public final SdkConfigService sdkConfigService;
    public final SdkInfo sdkInfo;
    public final SdkTracker sdkTracker;
    public final SessionInfo sessionInfo;

    public JuspayServices(Context context2, FrameLayout frameLayout) {
        this(context2, null, frameLayout);
    }

    public JuspayServices(Context context2, ErrorCallback errorCallback2, FrameLayout frameLayout) {
        this(context2, errorCallback2, true, frameLayout);
    }

    public JuspayServices(Context context2, ErrorCallback errorCallback2, boolean z, FrameLayout frameLayout) {
        this.LOG_TAG = JuspayServices.class.getSimpleName();
        this.container = frameLayout;
        this.sdkInfo = IntegrationUtils.getSdkInfo(context2);
        this.errorCallback = errorCallback2;
        this.context = context2.getApplicationContext();
        if (errorCallback2 == null) {
            this.errorCallback = new ErrorCallback() {
                public void onError(String str, String str2) {
                    JuspayLogger.e("DynamicUI", String.format("%s %s", new Object[]{str, str2}));
                    JuspayServices.this.sdkTracker.trackAction(Action.DUI, "error", HyperSdk.MYSTIQUE, str.toLowerCase(), str2);
                }

                public void onException(String str, String str2, Throwable th) {
                    JuspayLogger.e("DynamicUI", String.format("%s %s", new Object[]{str, str2}));
                    JuspayServices.this.sdkTracker.trackException("action", Action.DUI, HyperSdk.MYSTIQUE, str2, th);
                }
            };
        }
        this.duiLogger = new DuiLogger() {
            public void d(String str, String str2) {
            }

            public void e(String str, String str2) {
                JuspayLogger.e(str, str2);
                JuspayServices.this.sdkTracker.trackAction(Action.DUI, "error", HyperSdk.MYSTIQUE, str.toLowerCase(), str2);
            }

            public void i(String str, String str2) {
            }
        };
        this.sdkConfigService = new SdkConfigService(this);
        this.sdkTracker = new SdkTracker(this);
        this.sessionInfo = new SessionInfo(this, z);
        this.fileProviderService = new FileProviderService(this);
        this.remoteAssetService = new RemoteAssetService(this);
        this.sdkConfigService.renewConfig(context2);
        this.sessionInfo.createSessionDataMap();
        this.sessionInfo.logSessionInfo();
        this.sessionInfo.logDeviceIdentifiers();
        logMemoryInfo(this.sdkTracker, context2);
        logEncryptionSupport(this.sdkTracker, context2);
    }

    private void logMemoryInfo(SdkTracker sdkTracker2, Context context2) {
        MemoryInfo memoryInfo = Utils.getMemoryInfo(context2);
        if (memoryInfo != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("available_memory", memoryInfo.availMem);
                jSONObject.put("threshold_memory", memoryInfo.threshold);
                jSONObject.put("total_memory", memoryInfo.totalMem);
                sdkTracker2.trackContext("device", "info", Device.MEMORY, "memory_info", jSONObject);
            } catch (Exception e2) {
                SdkTracker sdkTracker3 = sdkTracker2;
                sdkTracker3.trackAndLogException(this.LOG_TAG, "action", "system", "session_info", "Exception while logging memory_info", e2);
            }
        }
    }

    public void addJsToWebView(String str) {
        DynamicUI dynamicUI2 = this.dynamicUI;
        if (dynamicUI2 != null) {
            dynamicUI2.addJsToWebView(str);
        }
    }

    public void destroy() {
        DynamicUI dynamicUI2 = this.dynamicUI;
        if (dynamicUI2 != null) {
            dynamicUI2.destroy();
        }
        this.container = null;
        this.dynamicUI = null;
        this.context = null;
    }

    public FrameLayout getContainer() {
        return this.container;
    }

    public Context getContext() {
        return this.context;
    }

    public DynamicUI getDynamicUI() {
        return this.dynamicUI;
    }

    public FileProviderService getFileProviderService() {
        return this.fileProviderService;
    }

    public RemoteAssetService getRemoteAssetService() {
        return this.remoteAssetService;
    }

    public SdkConfigService getSdkConfigService() {
        return this.sdkConfigService;
    }

    public final SdkInfo getSdkInfo() {
        return this.sdkInfo;
    }

    public SdkTracker getSdkTracker() {
        return this.sdkTracker;
    }

    public SessionInfo getSessionInfo() {
        return this.sessionInfo;
    }

    public void logEncryptionSupport(final SdkTracker sdkTracker2, Context context2) {
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isStrongBoxBacked", context2.getPackageManager().hasSystemFeature("android.hardware.strongbox_keystore"));
        } catch (Exception e2) {
            sdkDebug(this.LOG_TAG, Arrays.toString(e2.getStackTrace()));
        }
        new Thread(new Runnable() {
            public void run() {
                try {
                    if (KeyValueStore.read(JuspayServices.this, "isHardwareBacked", null) == null) {
                        KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                        if (VERSION.SDK_INT >= 23) {
                            instance.initialize(new Builder("juspay", 3).build());
                            PrivateKey privateKey = instance.generateKeyPair().getPrivate();
                            KeyInfo keyInfo = (KeyInfo) KeyFactory.getInstance(privateKey.getAlgorithm(), "AndroidKeyStore").getKeySpec(privateKey, KeyInfo.class);
                            jSONObject.put("isHardwareBacked", keyInfo.isInsideSecureHardware());
                            JuspayServices juspayServices = JuspayServices.this;
                            KeyValueStore.write(juspayServices, "isHardwareBacked", keyInfo.isInsideSecureHardware() + "");
                        } else {
                            jSONObject.put("isHardwareBacked", false);
                            KeyValueStore.write(JuspayServices.this, "isHardwareBacked", BaseParser.FALSE);
                        }
                        sdkTracker2.trackContext("device", "info", Device.PHONE_STATE, jSONObject);
                    }
                } catch (Exception e2) {
                    JuspayServices juspayServices2 = JuspayServices.this;
                    juspayServices2.sdkDebug(juspayServices2.LOG_TAG, Arrays.toString(e2.getStackTrace()));
                }
            }
        }).start();
    }

    public void sdkDebug(String str, String str2) {
        if (this.sdkInfo.isSdkDebuggable()) {
            JuspayLogger.d(str, str2);
        }
    }

    public void setContainer(FrameLayout frameLayout) {
        this.container = frameLayout;
    }

    public void setSdkTrackerEndpointSandbox(Boolean bool) {
        SdkTracker sdkTracker2 = this.sdkTracker;
        if (sdkTracker2 != null) {
            sdkTracker2.setEndPointSandbox(bool);
        }
    }

    public void start(JSONObject jSONObject) {
        if (this.dynamicUI == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            jSONObject.put(PaymentConstants.SDK_NAME, this.sdkInfo.getSdkName());
            jSONObject.put("sdkVersion", this.sdkInfo.getSdkVersion());
            this.sessionInfo.setBundleParams(jSONObject);
            WeakReference<Activity> weakReference = this.activity;
            Context context2 = weakReference != null ? (Activity) weakReference.get() : null;
            if (context2 == null) {
                context2 = this.context;
            }
            DynamicUI dynamicUI2 = new DynamicUI(context2, getContainer(), this.errorCallback);
            this.dynamicUI = dynamicUI2;
            dynamicUI2.setLogger(this.duiLogger);
            return;
        }
        throw new IllegalStateException("SDK already running");
    }

    public void updateActivity(Activity activity2) {
        DynamicUI dynamicUI2;
        FrameLayout frameLayout;
        this.activity = new WeakReference<>(activity2);
        if (activity2 != null) {
            this.context = activity2.getApplicationContext();
            this.dynamicUI.setActivity(activity2);
            dynamicUI2 = this.dynamicUI;
            frameLayout = getContainer();
        } else {
            DynamicUI dynamicUI3 = this.dynamicUI;
            if (dynamicUI3 != null) {
                dynamicUI3.resetActivity();
                dynamicUI2 = this.dynamicUI;
                frameLayout = null;
            } else {
                return;
            }
        }
        dynamicUI2.setContainer(frameLayout);
    }
}
