package com.microsoft.codepush.react;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.devsupport.DevInternalSettings;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.modules.network.NetworkingModule;
import com.facebook.react.uimanager.ViewManager;
import com.google.android.material.resources.TextAppearanceConfig;
import com.mpl.androidapp.updater.util.UpdaterConstant.Response;
import com.netcore.android.SMTEventParamKeys;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class CodePush implements ReactPackage {
    public static CodePush mCurrentInstance = null;
    public static String mPublicKey = null;
    public static String mServerUrl = "https://codepush.appcenter.ms/";
    public static String sAppVersion;
    public static boolean sIsRunningBinaryVersion;
    public static boolean sNeedToReportRollback;
    public String mAssetsBundleFileName;
    public Context mContext;
    public String mDeploymentKey;
    public boolean mDidUpdate = false;
    public final boolean mIsDebugMode;
    public SettingsManager mSettingsManager;
    public CodePushTelemetryManager mTelemetryManager;
    public CodePushUpdateManager mUpdateManager;

    public CodePush(String str, Context context, boolean z) {
        this.mContext = context.getApplicationContext();
        this.mUpdateManager = new CodePushUpdateManager(context.getFilesDir().getAbsolutePath());
        this.mTelemetryManager = new CodePushTelemetryManager(this.mContext);
        this.mDeploymentKey = str;
        this.mIsDebugMode = z;
        this.mSettingsManager = new SettingsManager(this.mContext);
        if (sAppVersion == null) {
            try {
                sAppVersion = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionName;
            } catch (NameNotFoundException e2) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unable to get package info for ");
                outline73.append(this.mContext.getPackageName());
                throw new CodePushUnknownException(outline73.toString(), e2);
            }
        }
        mCurrentInstance = this;
        String customPropertyFromStringsIfExist = getCustomPropertyFromStringsIfExist("PublicKey");
        if (customPropertyFromStringsIfExist != null) {
            mPublicKey = customPropertyFromStringsIfExist;
        }
        String customPropertyFromStringsIfExist2 = getCustomPropertyFromStringsIfExist("ServerUrl");
        if (customPropertyFromStringsIfExist2 != null) {
            mServerUrl = customPropertyFromStringsIfExist2;
        }
        clearDebugCacheIfNeeded(null);
        initializeUpdateAfterRestart();
    }

    public void clearDebugCacheIfNeeded(ReactInstanceManager reactInstanceManager) {
        if (this.mIsDebugMode && this.mSettingsManager.isPendingUpdate(null)) {
            boolean z = false;
            if (reactInstanceManager != null) {
                DevSupportManager devSupportManager = reactInstanceManager.mDevSupportManager;
                if (devSupportManager != null) {
                    DevInternalSettings devInternalSettings = (DevInternalSettings) devSupportManager.getDevSettings();
                    Method[] methods = devInternalSettings.getClass().getMethods();
                    int length = methods.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        Method method = methods[i];
                        if (method.getName().equals("isReloadOnJSChangeEnabled")) {
                            try {
                                z = ((Boolean) method.invoke(devInternalSettings, new Object[0])).booleanValue();
                                break;
                            } catch (Exception unused) {
                            }
                        } else {
                            i++;
                        }
                    }
                }
            }
            if (!z) {
                File file = new File(this.mContext.getFilesDir(), "ReactNativeDevBundle.js");
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    public void clearUpdates() {
        TextAppearanceConfig.deleteDirectoryAtPath(this.mUpdateManager.getCodePushPath());
        this.mSettingsManager.removePendingUpdate();
        this.mSettingsManager.mSettings.edit().remove("CODE_PUSH_FAILED_UPDATES").commit();
    }

    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        CodePushNativeModule codePushNativeModule = new CodePushNativeModule(reactApplicationContext, this, this.mUpdateManager, this.mTelemetryManager, this.mSettingsManager);
        CodePushDialog codePushDialog = new CodePushDialog(reactApplicationContext);
        ArrayList arrayList = new ArrayList();
        arrayList.add(codePushNativeModule);
        arrayList.add(codePushDialog);
        return arrayList;
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return new ArrayList();
    }

    public long getBinaryResourcesModifiedTime() {
        try {
            return Long.parseLong(this.mContext.getResources().getString(this.mContext.getResources().getIdentifier("CODE_PUSH_APK_BUILD_TIME", NetworkingModule.REQUEST_BODY_KEY_STRING, this.mContext.getPackageName())).replaceAll("\"", ""));
        } catch (Exception e2) {
            throw new CodePushUnknownException("Error in getting binary resources modified time", e2);
        }
    }

    public final String getCustomPropertyFromStringsIfExist(String str) {
        String packageName = this.mContext.getPackageName();
        Resources resources = this.mContext.getResources();
        int identifier = resources.getIdentifier("CodePush" + str, NetworkingModule.REQUEST_BODY_KEY_STRING, packageName);
        if (identifier != 0) {
            String string = this.mContext.getString(identifier);
            if (!string.isEmpty()) {
                return string;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0043, code lost:
        if ((!sAppVersion.equals(r3.optString(com.netcore.android.SMTEventParamKeys.SMT_APP_VERSION, null))) != false) goto L_0x0045;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getJSBundleFileInternal(java.lang.String r7) {
        /*
            r6 = this;
            r6.mAssetsBundleFileName = r7
            java.lang.String r0 = "assets://"
            java.lang.String r7 = com.android.tools.r8.GeneratedOutlineSupport.outline50(r0, r7)
            r0 = 0
            com.microsoft.codepush.react.CodePushUpdateManager r1 = r6.mUpdateManager     // Catch:{ CodePushMalformedDataException -> 0x0012 }
            java.lang.String r2 = r6.mAssetsBundleFileName     // Catch:{ CodePushMalformedDataException -> 0x0012 }
            java.lang.String r1 = r1.getCurrentPackageBundlePath(r2)     // Catch:{ CodePushMalformedDataException -> 0x0012 }
            goto L_0x001a
        L_0x0012:
            r1 = move-exception
            r1.getMessage()
            r6.clearUpdates()
            r1 = r0
        L_0x001a:
            r2 = 1
            if (r1 != 0) goto L_0x0020
            sIsRunningBinaryVersion = r2
            return r7
        L_0x0020:
            com.microsoft.codepush.react.CodePushUpdateManager r3 = r6.mUpdateManager
            org.json.JSONObject r3 = r3.getCurrentPackage()
            boolean r4 = r6.isPackageBundleLatest(r3)
            r5 = 0
            if (r4 == 0) goto L_0x0030
            sIsRunningBinaryVersion = r5
            return r1
        L_0x0030:
            r6.mDidUpdate = r5
            boolean r1 = r6.mIsDebugMode
            if (r1 == 0) goto L_0x0045
            java.lang.String r1 = "appVersion"
            java.lang.String r0 = r3.optString(r1, r0)
            java.lang.String r1 = sAppVersion
            boolean r0 = r1.equals(r0)
            r0 = r0 ^ r2
            if (r0 == 0) goto L_0x0048
        L_0x0045:
            r6.clearUpdates()
        L_0x0048:
            sIsRunningBinaryVersion = r2
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.codepush.react.CodePush.getJSBundleFileInternal(java.lang.String):java.lang.String");
    }

    public void initializeUpdateAfterRestart() {
        this.mDidUpdate = false;
        JSONObject pendingUpdate = this.mSettingsManager.getPendingUpdate();
        if (pendingUpdate != null) {
            JSONObject currentPackage = this.mUpdateManager.getCurrentPackage();
            if (currentPackage != null) {
                if (!isPackageBundleLatest(currentPackage)) {
                    if (!sAppVersion.equals(currentPackage.optString(SMTEventParamKeys.SMT_APP_VERSION, null))) {
                        return;
                    }
                }
                try {
                    if (pendingUpdate.getBoolean("isLoading")) {
                        sNeedToReportRollback = true;
                        rollbackPackage();
                        return;
                    }
                    this.mDidUpdate = true;
                    this.mSettingsManager.savePendingUpdate(pendingUpdate.getString(Response.HASH), true);
                } catch (JSONException e2) {
                    throw new CodePushUnknownException("Unable to read pending update metadata stored in SharedPreferences", e2);
                }
            }
        }
    }

    public final boolean isPackageBundleLatest(JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("binaryModifiedTime", null);
            Long valueOf = optString != null ? Long.valueOf(Long.parseLong(optString)) : null;
            return valueOf != null && valueOf.longValue() == getBinaryResourcesModifiedTime() && sAppVersion.equals(jSONObject.optString(SMTEventParamKeys.SMT_APP_VERSION, null));
        } catch (NumberFormatException e2) {
            throw new CodePushUnknownException("Error in reading binary modified date from package metadata", e2);
        }
    }

    public final void rollbackPackage() {
        this.mSettingsManager.saveFailedUpdate(this.mUpdateManager.getCurrentPackage());
        CodePushUpdateManager codePushUpdateManager = this.mUpdateManager;
        JSONObject currentPackageInfo = codePushUpdateManager.getCurrentPackageInfo();
        TextAppearanceConfig.deleteDirectoryAtPath(codePushUpdateManager.getCurrentPackageFolderPath());
        TextAppearanceConfig.setJSONValueForKey(currentPackageInfo, "currentPackage", currentPackageInfo.optString("previousPackage", null));
        TextAppearanceConfig.setJSONValueForKey(currentPackageInfo, "previousPackage", null);
        codePushUpdateManager.updateCurrentPackageInfo(currentPackageInfo);
        this.mSettingsManager.removePendingUpdate();
    }
}
