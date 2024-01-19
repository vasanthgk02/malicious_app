package com.mpl.androidapp.updater.util;

import android.content.Context;
import com.mpl.androidapp.EventPublishHelper;
import com.mpl.androidapp.MPLApplication;
import com.mpl.androidapp.config.UpdaterAnalytics;
import com.mpl.androidapp.updater.interactor.DBInteractor;
import com.mpl.androidapp.updater.model.GameAssets;
import com.mpl.androidapp.updater.rules.DownloadRules;
import com.mpl.androidapp.updater.util.UpdaterConstant.Response;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import org.json.JSONObject;

public class ResponseUtil {
    public static final String TAG = "ResponseUtil";

    public static void appUpdateAvailableEvent(int i, int i2) {
        if (MBuildConfigUtils.getInstalledAppVersionCode() < i) {
            UpdaterAnalytics.appUpdateAvailableEvent(i2 > MBuildConfigUtils.getInstalledAppVersionCode(), String.valueOf(i));
        }
    }

    public static void parseAndroidAppDownloadURL(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("payload");
            if (optJSONObject != null) {
                optJSONObject.optInt(Response.VERSION_CODE);
                String optString = optJSONObject.optString("description", "");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(Response.SLIM_APK);
                if (optJSONObject2 != null) {
                    DBInteractor.setAppDownloadURL(optJSONObject2.optString("url"));
                    DBInteractor.setAppDownloadingHash(optJSONObject2.optString(Response.HASH));
                }
                DBInteractor.setAppCriticalUpdate(optJSONObject.optBoolean("critical"));
                if (optString != null) {
                    MSharedPreferencesUtils.saveStringInNormalPref(MPLApplication.getInstance(), Response.RELEASE_NOTES, optString);
                }
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "parseAndroidAppDownloadURL:", e2);
        }
    }

    public static GameAssets parseAssetsDetails(String str) {
        GameAssets gameAssets = null;
        try {
            GameAssets gameAssets2 = new GameAssets();
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("payload");
                if (optJSONObject != null) {
                    gameAssets2.setUrl(optJSONObject.optString("url"));
                    gameAssets2.setGameName(optJSONObject.optString("gameName"));
                    gameAssets2.setSize(optJSONObject.optLong(Response.SIZE));
                    gameAssets2.setAssetVersion(optJSONObject.optInt("assetVersion"));
                }
                MLogger.d(TAG, "parseAssetsDetails: ", gameAssets2.toJSon());
                return gameAssets2;
            } catch (Exception e2) {
                e = e2;
                gameAssets = gameAssets2;
                MLogger.e(TAG, "parseAssetsDetails: ", e);
                return gameAssets;
            }
        } catch (Exception e3) {
            e = e3;
            MLogger.e(TAG, "parseAssetsDetails: ", e);
            return gameAssets;
        }
    }

    public static void parseRNBundleDownloadURL(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("payload");
            if (optJSONObject != null) {
                optJSONObject.optInt(Response.VERSION_CODE);
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(Response.DOWNLOAD_URL);
                if (optJSONObject2 != null) {
                    DBInteractor.setRNBundleDownloadURL(optJSONObject2.optString("url"));
                    DBInteractor.setRNBundleDownloadingHash(optJSONObject2.optString(Response.HASH));
                }
                String optString = optJSONObject.optString(Response.SHOULD_RELOAD, "");
                MLogger.d(TAG, "parseRNBundleDownloadURL: ", optString);
                DBInteractor.setRNBundleReload(optString.equalsIgnoreCase("IMMEDIATE"));
                DBInteractor.setRNBundleCriticalUpdate(optJSONObject.optBoolean("critical"));
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "parseRNBundleDownloadURL", e2);
        }
    }

    public static void parseResponse(Context context, StatusType statusType) {
        int i;
        try {
            boolean isCriticalUpdate = MSharedPreferencesUtils.isCriticalUpdate();
            int updateApkVersion = MSharedPreferencesUtils.getUpdateApkVersion();
            int updateReactVersion = MSharedPreferencesUtils.getUpdateReactVersion();
            int updateReactVersion2 = MSharedPreferencesUtils.getUpdateReactVersion();
            if (isCriticalUpdate) {
                i = MSharedPreferencesUtils.getUpdateApkVersion();
            } else {
                i = MBuildConfigUtils.getInstalledAppVersionCode();
            }
            int i2 = i;
            if (!MSharedPreferencesUtils.getUpdaterV2Enabled()) {
                appUpdateAvailableEvent(updateApkVersion, i2);
                rnBundleUpdateAvailableEvent(updateReactVersion2);
            }
            DBInteractor.setActiveRNVersionCode(updateReactVersion2);
            DBInteractor.setActiveAppVersionCode(updateApkVersion);
            DBInteractor.setMinRNVersionCode(updateReactVersion);
            DBInteractor.setMinAppVersionCode(i2);
            MLogger.d(TAG, Constant.APP_UPDATE_CHECK, "\nminAppVersionCode", Integer.valueOf(i2), "\nactiveAppVersionCode", Integer.valueOf(updateApkVersion), "\nisCritical", Boolean.valueOf(isCriticalUpdate), "\nminRNBundleVersionCode", Integer.valueOf(updateReactVersion), "\nactiveRNBundleVersionCode", Integer.valueOf(updateReactVersion2));
            MLogger.d(TAG, Constant.LOADING_TAG, "parseResponse: ");
            DownloadRules.setRules(context, i2, updateReactVersion, updateReactVersion2, updateApkVersion, statusType, isCriticalUpdate);
        } catch (Exception e2) {
            MLogger.e(TAG, Constant.APP_UPDATE_CHECK, "parseResponse", e2);
            EventPublishHelper.publishInitialStatusEvent(context, StatusType.GENERIC_CONNECTION_ERROR);
        }
    }

    public static void rnBundleUpdateAvailableEvent(int i) {
        if (DBInteractor.getCurrentRNBundleVersionCode() < i) {
            UpdaterAnalytics.reactUpdateAvailableEvent(String.valueOf(i));
        }
    }
}
