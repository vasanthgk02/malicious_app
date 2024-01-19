package com.microsoft.codepush.react;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.app.NotificationCompatJellybean;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.android.material.resources.TextAppearanceConfig;
import com.netcore.android.SMTEventParamKeys;

public class CodePushTelemetryManager {
    public SharedPreferences mSettings;

    public CodePushTelemetryManager(Context context) {
        this.mSettings = context.getSharedPreferences("CodePush", 0);
    }

    public final void clearRetryStatusReport() {
        this.mSettings.edit().remove("CODE_PUSH_RETRY_DEPLOYMENT_REPORT").commit();
    }

    public WritableMap getBinaryUpdateReport(String str) {
        String str2 = null;
        String string = this.mSettings.getString("CODE_PUSH_LAST_DEPLOYMENT_REPORT", null);
        if (string == null) {
            clearRetryStatusReport();
            WritableMap createMap = Arguments.createMap();
            createMap.putString(SMTEventParamKeys.SMT_APP_VERSION, str);
            return createMap;
        } else if (string.equals(str)) {
            return null;
        } else {
            clearRetryStatusReport();
            WritableMap createMap2 = Arguments.createMap();
            if (string.contains(":")) {
                String[] split = string.split(":");
                String str3 = split.length > 0 ? split[0] : null;
                String[] split2 = string.split(":");
                if (split2.length > 1) {
                    str2 = split2[1];
                }
                createMap2.putString(SMTEventParamKeys.SMT_APP_VERSION, str);
                createMap2.putString("previousDeploymentKey", str3);
                createMap2.putString("previousLabelOrAppVersion", str2);
            } else {
                createMap2.putString(SMTEventParamKeys.SMT_APP_VERSION, str);
                createMap2.putString("previousLabelOrAppVersion", string);
            }
            return createMap2;
        }
    }

    public final String getPackageStatusReportIdentifier(ReadableMap readableMap) {
        String tryGetString = TextAppearanceConfig.tryGetString(readableMap, "deploymentKey");
        String tryGetString2 = TextAppearanceConfig.tryGetString(readableMap, NotificationCompatJellybean.KEY_LABEL);
        if (tryGetString == null || tryGetString2 == null) {
            return null;
        }
        return GeneratedOutlineSupport.outline52(tryGetString, ":", tryGetString2);
    }

    public WritableMap getUpdateReport(WritableMap writableMap) {
        String packageStatusReportIdentifier = getPackageStatusReportIdentifier(writableMap);
        String str = null;
        String string = this.mSettings.getString("CODE_PUSH_LAST_DEPLOYMENT_REPORT", null);
        if (packageStatusReportIdentifier == null) {
            return null;
        }
        if (string == null) {
            clearRetryStatusReport();
            WritableMap createMap = Arguments.createMap();
            createMap.putMap("package", writableMap);
            createMap.putString("status", "DeploymentSucceeded");
            return createMap;
        } else if (string.equals(packageStatusReportIdentifier)) {
            return null;
        } else {
            clearRetryStatusReport();
            WritableMap createMap2 = Arguments.createMap();
            if (string.contains(":")) {
                String[] split = string.split(":");
                String str2 = split.length > 0 ? split[0] : null;
                String[] split2 = string.split(":");
                if (split2.length > 1) {
                    str = split2[1];
                }
                createMap2.putMap("package", writableMap);
                createMap2.putString("status", "DeploymentSucceeded");
                createMap2.putString("previousDeploymentKey", str2);
                createMap2.putString("previousLabelOrAppVersion", str);
            } else {
                createMap2.putMap("package", writableMap);
                createMap2.putString("status", "DeploymentSucceeded");
                createMap2.putString("previousLabelOrAppVersion", string);
            }
            return createMap2;
        }
    }

    public void recordStatusReported(ReadableMap readableMap) {
        if (!readableMap.hasKey("status") || !"DeploymentFailed".equals(readableMap.getString("status"))) {
            if (readableMap.hasKey(SMTEventParamKeys.SMT_APP_VERSION)) {
                this.mSettings.edit().putString("CODE_PUSH_LAST_DEPLOYMENT_REPORT", readableMap.getString(SMTEventParamKeys.SMT_APP_VERSION)).commit();
            } else if (readableMap.hasKey("package")) {
                this.mSettings.edit().putString("CODE_PUSH_LAST_DEPLOYMENT_REPORT", getPackageStatusReportIdentifier(readableMap.getMap("package"))).commit();
            }
        }
    }
}
