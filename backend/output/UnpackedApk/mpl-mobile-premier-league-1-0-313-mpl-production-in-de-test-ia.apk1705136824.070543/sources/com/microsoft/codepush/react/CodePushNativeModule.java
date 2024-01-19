package com.microsoft.codepush.react;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.ChoreographerCompat.FrameCallback;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.modules.core.ReactChoreographer.CallbackType;
import com.google.android.material.resources.TextAppearanceConfig;
import com.netcore.android.SMTEventParamKeys;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class CodePushNativeModule extends ReactContextBaseJavaModule {
    public boolean _allowed = true;
    public boolean _restartInProgress = false;
    public ArrayList<Boolean> _restartQueue = new ArrayList<>();
    public String mBinaryContentsHash = null;
    public String mClientUniqueId = null;
    public CodePush mCodePush;
    public LifecycleEventListener mLifecycleEventListener = null;
    public int mMinimumBackgroundDuration = 0;
    public SettingsManager mSettingsManager;
    public CodePushTelemetryManager mTelemetryManager;
    public CodePushUpdateManager mUpdateManager;

    public CodePushNativeModule(ReactApplicationContext reactApplicationContext, CodePush codePush, CodePushUpdateManager codePushUpdateManager, CodePushTelemetryManager codePushTelemetryManager, SettingsManager settingsManager) {
        super(reactApplicationContext);
        this.mCodePush = codePush;
        this.mSettingsManager = settingsManager;
        this.mTelemetryManager = codePushTelemetryManager;
        this.mUpdateManager = codePushUpdateManager;
        this.mBinaryContentsHash = CodePushUpdateUtils.getHashForBinaryContents(reactApplicationContext, codePush.mIsDebugMode);
        this.mClientUniqueId = Secure.getString(reactApplicationContext.getContentResolver(), "android_id");
    }

    private void clearLifecycleEventListener() {
        if (this.mLifecycleEventListener != null) {
            getReactApplicationContext().removeLifecycleEventListener(this.mLifecycleEventListener);
            this.mLifecycleEventListener = null;
        }
    }

    private void loadBundle() {
        clearLifecycleEventListener();
        try {
            this.mCodePush.clearDebugCacheIfNeeded(resolveInstanceManager());
        } catch (Exception unused) {
            this.mCodePush.clearDebugCacheIfNeeded(null);
        }
        try {
            final ReactInstanceManager resolveInstanceManager = resolveInstanceManager();
            if (resolveInstanceManager != null) {
                setJSBundle(resolveInstanceManager, this.mCodePush.getJSBundleFileInternal(this.mCodePush.mAssetsBundleFileName));
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        try {
                            ReactInstanceManager reactInstanceManager = resolveInstanceManager;
                            ImageOriginUtils.assertCondition(reactInstanceManager.mHasStartedCreatingInitialContext, "recreateReactContextInBackground should only be called after the initial createReactContextInBackground call.");
                            reactInstanceManager.recreateReactContextInBackgroundInner();
                            CodePushNativeModule.this.mCodePush.initializeUpdateAfterRestart();
                        } catch (Exception unused) {
                            CodePushNativeModule.this.loadBundleLegacy();
                        }
                    }
                });
            }
        } catch (Exception e2) {
            e2.getMessage();
            loadBundleLegacy();
        }
    }

    /* access modifiers changed from: private */
    public void loadBundleLegacy() {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            if (this.mCodePush != null) {
                CodePush.mCurrentInstance = null;
                currentActivity.runOnUiThread(new Runnable(this) {
                    public void run() {
                        currentActivity.recreate();
                    }
                });
                return;
            }
            throw null;
        }
    }

    private void resetReactRootViews(ReactInstanceManager reactInstanceManager) throws NoSuchFieldException, IllegalAccessException {
        Field declaredField = reactInstanceManager.getClass().getDeclaredField("mAttachedRootViews");
        declaredField.setAccessible(true);
        List<ReactRootView> list = (List) declaredField.get(reactInstanceManager);
        for (ReactRootView reactRootView : list) {
            reactRootView.removeAllViews();
            reactRootView.setId(-1);
        }
        declaredField.set(reactInstanceManager, list);
    }

    private ReactInstanceManager resolveInstanceManager() throws NoSuchFieldException, IllegalAccessException {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            return null;
        }
        ((ReactApplication) currentActivity.getApplication()).getReactNativeHost();
        throw null;
    }

    /* access modifiers changed from: private */
    public void restartAppInternal(boolean z) {
        if (this._restartInProgress) {
            this._restartQueue.add(Boolean.valueOf(z));
        } else if (!this._allowed) {
            this._restartQueue.add(Boolean.valueOf(z));
        } else {
            this._restartInProgress = true;
            if (!z || this.mSettingsManager.isPendingUpdate(null)) {
                loadBundle();
                return;
            }
            this._restartInProgress = false;
            if (this._restartQueue.size() > 0) {
                boolean booleanValue = this._restartQueue.get(0).booleanValue();
                this._restartQueue.remove(0);
                restartAppInternal(booleanValue);
            }
        }
    }

    private void setJSBundle(ReactInstanceManager reactInstanceManager, String str) throws IllegalAccessException {
        JSBundleLoader jSBundleLoader;
        try {
            if (str.toLowerCase().startsWith("assets://")) {
                jSBundleLoader = JSBundleLoader.createAssetLoader(getReactApplicationContext(), str, false);
            } else {
                jSBundleLoader = JSBundleLoader.createFileLoader(str);
            }
            Field declaredField = reactInstanceManager.getClass().getDeclaredField("mBundleLoader");
            declaredField.setAccessible(true);
            declaredField.set(reactInstanceManager, jSBundleLoader);
        } catch (Exception unused) {
            throw new IllegalAccessException("Could not setJSBundle");
        }
    }

    @ReactMethod
    public void allow(Promise promise) {
        this._allowed = true;
        if (this._restartQueue.size() > 0) {
            boolean booleanValue = this._restartQueue.get(0).booleanValue();
            this._restartQueue.remove(0);
            restartAppInternal(booleanValue);
        }
        promise.resolve(null);
    }

    @ReactMethod
    public void clearPendingRestart(Promise promise) {
        this._restartQueue.clear();
        promise.resolve(null);
    }

    @ReactMethod
    public void clearUpdates() {
        this.mCodePush.clearUpdates();
    }

    @ReactMethod
    public void disallow(Promise promise) {
        this._allowed = false;
        promise.resolve(null);
    }

    @ReactMethod
    public void downloadAndReplaceCurrentBundle(String str) {
    }

    @ReactMethod
    public void downloadUpdate(final ReadableMap readableMap, final boolean z, final Promise promise) {
        new AsyncTask<Void, Void, Void>() {
            public Object doInBackground(Object[] objArr) {
                Void[] voidArr = (Void[]) objArr;
                try {
                    JSONObject convertReadableToJsonObject = TextAppearanceConfig.convertReadableToJsonObject(readableMap);
                    TextAppearanceConfig.setJSONValueForKey(convertReadableToJsonObject, "binaryModifiedTime", "" + CodePushNativeModule.this.mCodePush.getBinaryResourcesModifiedTime());
                    CodePushUpdateManager access$600 = CodePushNativeModule.this.mUpdateManager;
                    String str = CodePushNativeModule.this.mCodePush.mAssetsBundleFileName;
                    AnonymousClass1 r3 = new DownloadProgressCallback() {
                        public boolean hasScheduledNextFrame = false;
                        public DownloadProgress latestDownloadProgress = null;

                        public void call(DownloadProgress downloadProgress) {
                            if (z) {
                                this.latestDownloadProgress = downloadProgress;
                                if (downloadProgress.mTotalBytes == downloadProgress.mReceivedBytes) {
                                    dispatchDownloadProgressEvent();
                                } else if (!this.hasScheduledNextFrame) {
                                    this.hasScheduledNextFrame = true;
                                    CodePushNativeModule.this.getReactApplicationContext().runOnUiQueueThread(new Runnable() {
                                        public void run() {
                                            ReactChoreographer.getInstance().postFrameCallback(CallbackType.TIMERS_EVENTS, new FrameCallback() {
                                                public void doFrame(long j) {
                                                    DownloadProgress downloadProgress = AnonymousClass1.this.latestDownloadProgress;
                                                    if (!(downloadProgress.mTotalBytes == downloadProgress.mReceivedBytes)) {
                                                        AnonymousClass1.this.dispatchDownloadProgressEvent();
                                                    }
                                                    AnonymousClass1.this.hasScheduledNextFrame = false;
                                                }
                                            });
                                        }
                                    });
                                }
                            }
                        }

                        public void dispatchDownloadProgressEvent() {
                            RCTDeviceEventEmitter rCTDeviceEventEmitter = (RCTDeviceEventEmitter) CodePushNativeModule.this.getReactApplicationContext().getJSModule(RCTDeviceEventEmitter.class);
                            DownloadProgress downloadProgress = this.latestDownloadProgress;
                            if (downloadProgress != null) {
                                WritableNativeMap writableNativeMap = new WritableNativeMap();
                                long j = downloadProgress.mTotalBytes;
                                if (j < 2147483647L) {
                                    writableNativeMap.putInt("totalBytes", (int) j);
                                    writableNativeMap.putInt("receivedBytes", (int) downloadProgress.mReceivedBytes);
                                } else {
                                    writableNativeMap.putDouble("totalBytes", (double) j);
                                    writableNativeMap.putDouble("receivedBytes", (double) downloadProgress.mReceivedBytes);
                                }
                                rCTDeviceEventEmitter.emit("CodePushDownloadProgress", writableNativeMap);
                                return;
                            }
                            throw null;
                        }
                    };
                    if (CodePushNativeModule.this.mCodePush != null) {
                        access$600.downloadPackage(convertReadableToJsonObject, str, r3, CodePush.mPublicKey);
                        promise.resolve(TextAppearanceConfig.convertJsonObjectToWritable(CodePushNativeModule.this.mUpdateManager.getPackage(TextAppearanceConfig.tryGetString(readableMap, "packageHash"))));
                        return null;
                    }
                    throw null;
                } catch (CodePushInvalidUpdateException e2) {
                    CodePushNativeModule.this.mSettingsManager.saveFailedUpdate(TextAppearanceConfig.convertReadableToJsonObject(readableMap));
                    promise.reject((Throwable) e2);
                } catch (CodePushUnknownException | IOException e3) {
                    promise.reject(e3);
                }
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public void getConfiguration(Promise promise) {
        try {
            WritableMap createMap = Arguments.createMap();
            if (this.mCodePush != null) {
                createMap.putString(SMTEventParamKeys.SMT_APP_VERSION, CodePush.sAppVersion);
                createMap.putString("clientUniqueId", this.mClientUniqueId);
                createMap.putString("deploymentKey", this.mCodePush.mDeploymentKey);
                if (this.mCodePush != null) {
                    createMap.putString("serverUrl", CodePush.mServerUrl);
                    if (this.mBinaryContentsHash != null) {
                        createMap.putString("packageHash", this.mBinaryContentsHash);
                    }
                    promise.resolve(createMap);
                    return;
                }
                throw null;
            }
            throw null;
        } catch (CodePushUnknownException e2) {
            promise.reject((Throwable) e2);
        }
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("codePushInstallModeImmediate", Integer.valueOf(CodePushInstallMode.IMMEDIATE.getValue()));
        hashMap.put("codePushInstallModeOnNextRestart", Integer.valueOf(CodePushInstallMode.ON_NEXT_RESTART.getValue()));
        hashMap.put("codePushInstallModeOnNextResume", Integer.valueOf(CodePushInstallMode.ON_NEXT_RESUME.getValue()));
        hashMap.put("codePushInstallModeOnNextSuspend", Integer.valueOf(CodePushInstallMode.ON_NEXT_SUSPEND.getValue()));
        hashMap.put("codePushUpdateStateRunning", Integer.valueOf(CodePushUpdateState.RUNNING.getValue()));
        hashMap.put("codePushUpdateStatePending", Integer.valueOf(CodePushUpdateState.PENDING.getValue()));
        hashMap.put("codePushUpdateStateLatest", Integer.valueOf(CodePushUpdateState.LATEST.getValue()));
        return hashMap;
    }

    @ReactMethod
    public void getLatestRollbackInfo(Promise promise) {
        try {
            JSONObject latestRollbackInfo = this.mSettingsManager.getLatestRollbackInfo();
            if (latestRollbackInfo != null) {
                promise.resolve(TextAppearanceConfig.convertJsonObjectToWritable(latestRollbackInfo));
            } else {
                promise.resolve(null);
            }
        } catch (CodePushUnknownException e2) {
            promise.reject((Throwable) e2);
        }
    }

    public String getName() {
        return "CodePush";
    }

    @ReactMethod
    public void getNewStatusReport(final Promise promise) {
        new AsyncTask<Void, Void, Void>() {
            /* JADX WARNING: Removed duplicated region for block: B:47:0x00db A[Catch:{ JSONException -> 0x0058, CodePushUnknownException -> 0x00eb }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object doInBackground(java.lang.Object[] r4) {
                /*
                    r3 = this;
                    java.lang.Void[] r4 = (java.lang.Void[]) r4
                    r4 = 0
                    com.microsoft.codepush.react.CodePushNativeModule r0 = com.microsoft.codepush.react.CodePushNativeModule.this     // Catch:{ CodePushUnknownException -> 0x00eb }
                    com.microsoft.codepush.react.CodePush r0 = r0.mCodePush     // Catch:{ CodePushUnknownException -> 0x00eb }
                    if (r0 == 0) goto L_0x00ea
                    boolean r0 = com.microsoft.codepush.react.CodePush.sNeedToReportRollback     // Catch:{ CodePushUnknownException -> 0x00eb }
                    if (r0 == 0) goto L_0x0062
                    com.microsoft.codepush.react.CodePushNativeModule r0 = com.microsoft.codepush.react.CodePushNativeModule.this     // Catch:{ CodePushUnknownException -> 0x00eb }
                    com.microsoft.codepush.react.CodePush r0 = r0.mCodePush     // Catch:{ CodePushUnknownException -> 0x00eb }
                    r1 = 0
                    if (r0 == 0) goto L_0x0061
                    com.microsoft.codepush.react.CodePush.sNeedToReportRollback = r1     // Catch:{ CodePushUnknownException -> 0x00eb }
                    com.microsoft.codepush.react.CodePushNativeModule r0 = com.microsoft.codepush.react.CodePushNativeModule.this     // Catch:{ CodePushUnknownException -> 0x00eb }
                    com.microsoft.codepush.react.SettingsManager r0 = r0.mSettingsManager     // Catch:{ CodePushUnknownException -> 0x00eb }
                    org.json.JSONArray r0 = r0.getFailedUpdates()     // Catch:{ CodePushUnknownException -> 0x00eb }
                    int r1 = r0.length()     // Catch:{ CodePushUnknownException -> 0x00eb }
                    if (r1 <= 0) goto L_0x00e1
                    int r1 = r0.length()     // Catch:{ JSONException -> 0x0058 }
                    int r1 = r1 + -1
                    org.json.JSONObject r0 = r0.getJSONObject(r1)     // Catch:{ JSONException -> 0x0058 }
                    com.facebook.react.bridge.WritableMap r0 = com.google.android.material.resources.TextAppearanceConfig.convertJsonObjectToWritable(r0)     // Catch:{ JSONException -> 0x0058 }
                    com.microsoft.codepush.react.CodePushNativeModule r1 = com.microsoft.codepush.react.CodePushNativeModule.this     // Catch:{ JSONException -> 0x0058 }
                    com.microsoft.codepush.react.CodePushTelemetryManager r1 = r1.mTelemetryManager     // Catch:{ JSONException -> 0x0058 }
                    if (r1 == 0) goto L_0x0057
                    com.facebook.react.bridge.WritableMap r1 = com.facebook.react.bridge.Arguments.createMap()     // Catch:{ JSONException -> 0x0058 }
                    java.lang.String r2 = "package"
                    r1.putMap(r2, r0)     // Catch:{ JSONException -> 0x0058 }
                    java.lang.String r0 = "status"
                    java.lang.String r2 = "DeploymentFailed"
                    r1.putString(r0, r2)     // Catch:{ JSONException -> 0x0058 }
                    com.facebook.react.bridge.Promise r0 = r3     // Catch:{ JSONException -> 0x0058 }
                    r0.resolve(r1)     // Catch:{ JSONException -> 0x0058 }
                    goto L_0x00f1
                L_0x0057:
                    throw r4     // Catch:{ JSONException -> 0x0058 }
                L_0x0058:
                    r0 = move-exception
                    com.microsoft.codepush.react.CodePushUnknownException r1 = new com.microsoft.codepush.react.CodePushUnknownException     // Catch:{ CodePushUnknownException -> 0x00eb }
                    java.lang.String r2 = "Unable to read failed updates information stored in SharedPreferences."
                    r1.<init>(r2, r0)     // Catch:{ CodePushUnknownException -> 0x00eb }
                    throw r1     // Catch:{ CodePushUnknownException -> 0x00eb }
                L_0x0061:
                    throw r4     // Catch:{ CodePushUnknownException -> 0x00eb }
                L_0x0062:
                    com.microsoft.codepush.react.CodePushNativeModule r0 = com.microsoft.codepush.react.CodePushNativeModule.this     // Catch:{ CodePushUnknownException -> 0x00eb }
                    com.microsoft.codepush.react.CodePush r0 = r0.mCodePush     // Catch:{ CodePushUnknownException -> 0x00eb }
                    boolean r0 = r0.mDidUpdate     // Catch:{ CodePushUnknownException -> 0x00eb }
                    if (r0 == 0) goto L_0x008e
                    com.microsoft.codepush.react.CodePushNativeModule r0 = com.microsoft.codepush.react.CodePushNativeModule.this     // Catch:{ CodePushUnknownException -> 0x00eb }
                    com.microsoft.codepush.react.CodePushUpdateManager r0 = r0.mUpdateManager     // Catch:{ CodePushUnknownException -> 0x00eb }
                    org.json.JSONObject r0 = r0.getCurrentPackage()     // Catch:{ CodePushUnknownException -> 0x00eb }
                    if (r0 == 0) goto L_0x00e1
                    com.microsoft.codepush.react.CodePushNativeModule r1 = com.microsoft.codepush.react.CodePushNativeModule.this     // Catch:{ CodePushUnknownException -> 0x00eb }
                    com.microsoft.codepush.react.CodePushTelemetryManager r1 = r1.mTelemetryManager     // Catch:{ CodePushUnknownException -> 0x00eb }
                    com.facebook.react.bridge.WritableMap r0 = com.google.android.material.resources.TextAppearanceConfig.convertJsonObjectToWritable(r0)     // Catch:{ CodePushUnknownException -> 0x00eb }
                    com.facebook.react.bridge.WritableMap r0 = r1.getUpdateReport(r0)     // Catch:{ CodePushUnknownException -> 0x00eb }
                    if (r0 == 0) goto L_0x00e1
                    com.facebook.react.bridge.Promise r1 = r3     // Catch:{ CodePushUnknownException -> 0x00eb }
                    r1.resolve(r0)     // Catch:{ CodePushUnknownException -> 0x00eb }
                    goto L_0x00f1
                L_0x008e:
                    com.microsoft.codepush.react.CodePushNativeModule r0 = com.microsoft.codepush.react.CodePushNativeModule.this     // Catch:{ CodePushUnknownException -> 0x00eb }
                    com.microsoft.codepush.react.CodePush r0 = r0.mCodePush     // Catch:{ CodePushUnknownException -> 0x00eb }
                    if (r0 == 0) goto L_0x00e9
                    boolean r0 = com.microsoft.codepush.react.CodePush.sIsRunningBinaryVersion     // Catch:{ CodePushUnknownException -> 0x00eb }
                    if (r0 == 0) goto L_0x00b7
                    com.microsoft.codepush.react.CodePushNativeModule r0 = com.microsoft.codepush.react.CodePushNativeModule.this     // Catch:{ CodePushUnknownException -> 0x00eb }
                    com.microsoft.codepush.react.CodePushTelemetryManager r0 = r0.mTelemetryManager     // Catch:{ CodePushUnknownException -> 0x00eb }
                    com.microsoft.codepush.react.CodePushNativeModule r1 = com.microsoft.codepush.react.CodePushNativeModule.this     // Catch:{ CodePushUnknownException -> 0x00eb }
                    com.microsoft.codepush.react.CodePush r1 = r1.mCodePush     // Catch:{ CodePushUnknownException -> 0x00eb }
                    if (r1 == 0) goto L_0x00b6
                    java.lang.String r1 = com.microsoft.codepush.react.CodePush.sAppVersion     // Catch:{ CodePushUnknownException -> 0x00eb }
                    com.facebook.react.bridge.WritableMap r0 = r0.getBinaryUpdateReport(r1)     // Catch:{ CodePushUnknownException -> 0x00eb }
                    if (r0 == 0) goto L_0x00e1
                    com.facebook.react.bridge.Promise r1 = r3     // Catch:{ CodePushUnknownException -> 0x00eb }
                    r1.resolve(r0)     // Catch:{ CodePushUnknownException -> 0x00eb }
                    goto L_0x00f1
                L_0x00b6:
                    throw r4     // Catch:{ CodePushUnknownException -> 0x00eb }
                L_0x00b7:
                    com.microsoft.codepush.react.CodePushNativeModule r0 = com.microsoft.codepush.react.CodePushNativeModule.this     // Catch:{ CodePushUnknownException -> 0x00eb }
                    com.microsoft.codepush.react.CodePushTelemetryManager r0 = r0.mTelemetryManager     // Catch:{ CodePushUnknownException -> 0x00eb }
                    android.content.SharedPreferences r1 = r0.mSettings     // Catch:{ CodePushUnknownException -> 0x00eb }
                    java.lang.String r2 = "CODE_PUSH_RETRY_DEPLOYMENT_REPORT"
                    java.lang.String r1 = r1.getString(r2, r4)     // Catch:{ CodePushUnknownException -> 0x00eb }
                    if (r1 == 0) goto L_0x00d8
                    r0.clearRetryStatusReport()     // Catch:{ CodePushUnknownException -> 0x00eb }
                    org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00d4 }
                    r0.<init>(r1)     // Catch:{ JSONException -> 0x00d4 }
                    com.facebook.react.bridge.WritableMap r0 = com.google.android.material.resources.TextAppearanceConfig.convertJsonObjectToWritable(r0)     // Catch:{ JSONException -> 0x00d4 }
                    goto L_0x00d9
                L_0x00d4:
                    r0 = move-exception
                    r0.printStackTrace()     // Catch:{ CodePushUnknownException -> 0x00eb }
                L_0x00d8:
                    r0 = r4
                L_0x00d9:
                    if (r0 == 0) goto L_0x00e1
                    com.facebook.react.bridge.Promise r1 = r3     // Catch:{ CodePushUnknownException -> 0x00eb }
                    r1.resolve(r0)     // Catch:{ CodePushUnknownException -> 0x00eb }
                    goto L_0x00f1
                L_0x00e1:
                    com.facebook.react.bridge.Promise r0 = r3     // Catch:{ CodePushUnknownException -> 0x00eb }
                    java.lang.String r1 = ""
                    r0.resolve(r1)     // Catch:{ CodePushUnknownException -> 0x00eb }
                    goto L_0x00f1
                L_0x00e9:
                    throw r4     // Catch:{ CodePushUnknownException -> 0x00eb }
                L_0x00ea:
                    throw r4     // Catch:{ CodePushUnknownException -> 0x00eb }
                L_0x00eb:
                    r0 = move-exception
                    com.facebook.react.bridge.Promise r1 = r3
                    r1.reject(r0)
                L_0x00f1:
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.microsoft.codepush.react.CodePushNativeModule.AnonymousClass5.doInBackground(java.lang.Object[]):java.lang.Object");
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public void getUpdateMetadata(final int i, final Promise promise) {
        new AsyncTask<Void, Void, Void>() {
            public Object doInBackground(Object[] objArr) {
                JSONObject jSONObject;
                Void[] voidArr = (Void[]) objArr;
                try {
                    JSONObject currentPackage = CodePushNativeModule.this.mUpdateManager.getCurrentPackage();
                    if (currentPackage == null) {
                        promise.resolve(null);
                    } else {
                        Boolean bool = Boolean.FALSE;
                        if (currentPackage.has("packageHash")) {
                            bool = Boolean.valueOf(CodePushNativeModule.this.mSettingsManager.isPendingUpdate(currentPackage.optString("packageHash", null)));
                        }
                        if (i == CodePushUpdateState.PENDING.getValue() && !bool.booleanValue()) {
                            promise.resolve(null);
                        } else if (i == CodePushUpdateState.RUNNING.getValue() && bool.booleanValue()) {
                            CodePushUpdateManager access$600 = CodePushNativeModule.this.mUpdateManager;
                            String optString = access$600.getCurrentPackageInfo().optString("previousPackage", null);
                            if (optString == null) {
                                jSONObject = null;
                            } else {
                                jSONObject = access$600.getPackage(optString);
                            }
                            if (jSONObject == null) {
                                promise.resolve(null);
                            } else {
                                promise.resolve(TextAppearanceConfig.convertJsonObjectToWritable(jSONObject));
                            }
                        } else if (CodePushNativeModule.this.mCodePush != null) {
                            if (CodePush.sIsRunningBinaryVersion) {
                                TextAppearanceConfig.setJSONValueForKey(currentPackage, "_isDebugOnly", Boolean.TRUE);
                            }
                            TextAppearanceConfig.setJSONValueForKey(currentPackage, "isPending", bool);
                            promise.resolve(TextAppearanceConfig.convertJsonObjectToWritable(currentPackage));
                        } else {
                            throw null;
                        }
                    }
                } catch (CodePushMalformedDataException e2) {
                    e2.getMessage();
                    CodePushNativeModule.this.clearUpdates();
                    promise.resolve(null);
                } catch (CodePushUnknownException e3) {
                    promise.reject((Throwable) e3);
                }
                return null;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public void installUpdate(ReadableMap readableMap, int i, int i2, Promise promise) {
        final ReadableMap readableMap2 = readableMap;
        final int i3 = i;
        final int i4 = i2;
        final Promise promise2 = promise;
        AnonymousClass6 r0 = new AsyncTask<Void, Void, Void>() {
            public Object doInBackground(Object[] objArr) {
                Void[] voidArr = (Void[]) objArr;
                try {
                    CodePushNativeModule.this.mUpdateManager.installPackage(TextAppearanceConfig.convertReadableToJsonObject(readableMap2), CodePushNativeModule.this.mSettingsManager.isPendingUpdate(null));
                    String tryGetString = TextAppearanceConfig.tryGetString(readableMap2, "packageHash");
                    if (tryGetString != null) {
                        CodePushNativeModule.this.mSettingsManager.savePendingUpdate(tryGetString, false);
                        if (i3 == CodePushInstallMode.ON_NEXT_RESUME.getValue() || i3 == CodePushInstallMode.IMMEDIATE.getValue() || i3 == CodePushInstallMode.ON_NEXT_SUSPEND.getValue()) {
                            CodePushNativeModule.this.mMinimumBackgroundDuration = i4;
                            if (CodePushNativeModule.this.mLifecycleEventListener == null) {
                                CodePushNativeModule.this.mLifecycleEventListener = new LifecycleEventListener() {
                                    public Handler appSuspendHandler = new Handler(Looper.getMainLooper());
                                    public Date lastPausedDate = null;
                                    public Runnable loadBundleRunnable = new Runnable() {
                                        public void run() {
                                            CodePushNativeModule.this.restartAppInternal(false);
                                        }
                                    };

                                    public void onHostDestroy() {
                                    }

                                    public void onHostPause() {
                                        this.lastPausedDate = new Date();
                                        if (i3 == CodePushInstallMode.ON_NEXT_SUSPEND.getValue() && CodePushNativeModule.this.mSettingsManager.isPendingUpdate(null)) {
                                            this.appSuspendHandler.postDelayed(this.loadBundleRunnable, (long) (i4 * 1000));
                                        }
                                    }

                                    public void onHostResume() {
                                        this.appSuspendHandler.removeCallbacks(this.loadBundleRunnable);
                                        if (this.lastPausedDate != null) {
                                            long outline13 = (GeneratedOutlineSupport.outline13() - this.lastPausedDate.getTime()) / 1000;
                                            if (i3 == CodePushInstallMode.IMMEDIATE.getValue() || outline13 >= ((long) CodePushNativeModule.this.mMinimumBackgroundDuration)) {
                                                CodePushNativeModule.this.restartAppInternal(false);
                                            }
                                        }
                                    }
                                };
                                CodePushNativeModule.this.getReactApplicationContext().addLifecycleEventListener(CodePushNativeModule.this.mLifecycleEventListener);
                            }
                        }
                        promise2.resolve("");
                        return null;
                    }
                    throw new CodePushUnknownException("Update package to be installed has no hash.");
                } catch (CodePushUnknownException e2) {
                    promise2.reject((Throwable) e2);
                }
            }
        };
        r0.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public void isFailedUpdate(String str, Promise promise) {
        try {
            promise.resolve(Boolean.valueOf(this.mSettingsManager.isFailedHash(str)));
        } catch (CodePushUnknownException e2) {
            promise.reject((Throwable) e2);
        }
    }

    @ReactMethod
    public void isFirstRun(String str, Promise promise) {
        try {
            promise.resolve(Boolean.valueOf(this.mCodePush.mDidUpdate && str != null && str.length() > 0 && str.equals(this.mUpdateManager.getCurrentPackageInfo().optString("currentPackage", null))));
        } catch (CodePushUnknownException e2) {
            promise.reject((Throwable) e2);
        }
    }

    @ReactMethod
    public void notifyApplicationReady(Promise promise) {
        try {
            this.mSettingsManager.removePendingUpdate();
            promise.resolve("");
        } catch (CodePushUnknownException e2) {
            promise.reject((Throwable) e2);
        }
    }

    @ReactMethod
    public void recordStatusReported(ReadableMap readableMap) {
        try {
            this.mTelemetryManager.recordStatusReported(readableMap);
        } catch (CodePushUnknownException unused) {
        }
    }

    @ReactMethod
    public void restartApp(boolean z, Promise promise) {
        try {
            restartAppInternal(z);
            promise.resolve(null);
        } catch (CodePushUnknownException e2) {
            promise.reject((Throwable) e2);
        }
    }

    @ReactMethod
    public void saveStatusReportForRetry(ReadableMap readableMap) {
        try {
            CodePushTelemetryManager codePushTelemetryManager = this.mTelemetryManager;
            if (codePushTelemetryManager != null) {
                codePushTelemetryManager.mSettings.edit().putString("CODE_PUSH_RETRY_DEPLOYMENT_REPORT", TextAppearanceConfig.convertReadableToJsonObject(readableMap).toString()).commit();
                return;
            }
            throw null;
        } catch (CodePushUnknownException unused) {
        }
    }

    @ReactMethod
    public void setLatestRollbackInfo(String str, Promise promise) {
        try {
            this.mSettingsManager.setLatestRollbackInfo(str);
            promise.resolve(null);
        } catch (CodePushUnknownException e2) {
            promise.reject((Throwable) e2);
        }
    }
}
