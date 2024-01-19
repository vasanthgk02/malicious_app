package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.FeaturesSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.SessionSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.SettingsData;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class SettingsV3JsonTransform implements SettingsJsonTransform {
    public static final String CRASHLYTICS_APP_URL = "https://update.crashlytics.com/spi/v1/platforms/android/apps";
    public static final String CRASHLYTICS_APP_URL_FORMAT = "https://update.crashlytics.com/spi/v1/platforms/android/apps/%s";
    public static final String NDK_REPORTS_URL_FORMAT = "https://reports.crashlytics.com/sdk-api/v1/platforms/android/apps/%s/minidumps";
    public static final String REPORTS_URL_FORMAT = "https://reports.crashlytics.com/spi/v1/platforms/android/apps/%s/reports";

    public static AppSettingsData buildAppDataFrom(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        String str;
        String string = jSONObject2.getString("status");
        boolean equals = AppSettingsData.STATUS_NEW.equals(string);
        String string2 = jSONObject.getString(SettingsJsonConstants.FABRIC_BUNDLE_ID);
        String string3 = jSONObject.getString(SettingsJsonConstants.FABRIC_ORGANIZATION_ID);
        if (equals) {
            str = CRASHLYTICS_APP_URL;
        } else {
            str = String.format(Locale.US, CRASHLYTICS_APP_URL_FORMAT, new Object[]{string2});
        }
        AppSettingsData appSettingsData = new AppSettingsData(string, str, String.format(Locale.US, REPORTS_URL_FORMAT, new Object[]{string2}), String.format(Locale.US, NDK_REPORTS_URL_FORMAT, new Object[]{string2}), string2, string3, jSONObject2.optBoolean(SettingsJsonConstants.APP_UPDATE_REQUIRED_KEY, false), jSONObject2.optInt(SettingsJsonConstants.APP_REPORT_UPLOAD_VARIANT_KEY, 0), jSONObject2.optInt(SettingsJsonConstants.APP_NATIVE_REPORT_UPLOAD_VARIANT_KEY, 0));
        return appSettingsData;
    }

    public static FeaturesSettingsData buildFeaturesSessionDataFrom(JSONObject jSONObject) {
        return new FeaturesSettingsData(jSONObject.optBoolean(SettingsJsonConstants.FEATURES_COLLECT_REPORTS_KEY, true), jSONObject.optBoolean(SettingsJsonConstants.FEATURES_COLLECT_ANRS_KEY, false));
    }

    public static SessionSettingsData defaultSessionData() {
        return new SessionSettingsData(8, 4);
    }

    public static long getExpiresAtFrom(CurrentTimeProvider currentTimeProvider, long j, JSONObject jSONObject) {
        if (jSONObject.has(SettingsJsonConstants.EXPIRES_AT_KEY)) {
            return jSONObject.optLong(SettingsJsonConstants.EXPIRES_AT_KEY);
        }
        return (j * 1000) + currentTimeProvider.getCurrentTimeMillis();
    }

    private JSONObject toAppJson(AppSettingsData appSettingsData) throws JSONException {
        return new JSONObject().put("status", appSettingsData.status).put(SettingsJsonConstants.APP_UPDATE_REQUIRED_KEY, appSettingsData.updateRequired).put(SettingsJsonConstants.APP_REPORT_UPLOAD_VARIANT_KEY, appSettingsData.reportUploadVariant).put(SettingsJsonConstants.APP_NATIVE_REPORT_UPLOAD_VARIANT_KEY, appSettingsData.nativeReportUploadVariant);
    }

    private JSONObject toFabricJson(AppSettingsData appSettingsData) throws JSONException {
        return new JSONObject().put(SettingsJsonConstants.FABRIC_BUNDLE_ID, appSettingsData.bundleId).put(SettingsJsonConstants.FABRIC_ORGANIZATION_ID, appSettingsData.organizationId);
    }

    private JSONObject toFeaturesJson(FeaturesSettingsData featuresSettingsData) throws JSONException {
        return new JSONObject().put(SettingsJsonConstants.FEATURES_COLLECT_REPORTS_KEY, featuresSettingsData.collectReports);
    }

    public SettingsData buildFromJson(CurrentTimeProvider currentTimeProvider, JSONObject jSONObject) throws JSONException {
        int optInt = jSONObject.optInt(SettingsJsonConstants.SETTINGS_VERSION, 0);
        int optInt2 = jSONObject.optInt(SettingsJsonConstants.CACHE_DURATION_KEY, SettingsJsonConstants.SETTINGS_CACHE_DURATION_DEFAULT);
        SettingsData settingsData = new SettingsData(getExpiresAtFrom(currentTimeProvider, (long) optInt2, jSONObject), buildAppDataFrom(jSONObject.getJSONObject(SettingsJsonConstants.FABRIC_KEY), jSONObject.getJSONObject("app")), defaultSessionData(), buildFeaturesSessionDataFrom(jSONObject.getJSONObject(SettingsJsonConstants.FEATURES_KEY)), optInt, optInt2);
        return settingsData;
    }

    public JSONObject toJson(SettingsData settingsData) throws JSONException {
        return new JSONObject().put(SettingsJsonConstants.EXPIRES_AT_KEY, settingsData.expiresAtMillis).put(SettingsJsonConstants.CACHE_DURATION_KEY, settingsData.cacheDuration).put(SettingsJsonConstants.SETTINGS_VERSION, settingsData.settingsVersion).put(SettingsJsonConstants.FEATURES_KEY, toFeaturesJson(settingsData.featuresData)).put("app", toAppJson(settingsData.appData)).put(SettingsJsonConstants.FABRIC_KEY, toFabricJson(settingsData.appData));
    }
}
