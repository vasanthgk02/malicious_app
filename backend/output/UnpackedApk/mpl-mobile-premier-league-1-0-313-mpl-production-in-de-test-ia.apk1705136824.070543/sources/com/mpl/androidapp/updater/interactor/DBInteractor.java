package com.mpl.androidapp.updater.interactor;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.config.ConfigConstant;
import com.mpl.androidapp.updater.util.UpdaterConstant.SharedPref;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.securepreferences.MPreferences;
import org.apache.fontbox.cmap.CMapParser;

public class DBInteractor {
    public static final String TAG = "DBInteractor";

    public static String getAPKSignature() {
        return MPreferences.getString(ConfigConstant.SECURITY_APK_KEY, MBuildConfigUtils.getAPKHash(), false);
    }

    public static int getActiveAppVersionCode() {
        int i = MPreferences.getInt(SharedPref.SHARED_PREF_ACTIVE_ANDROID_VERSION_CODE, MBuildConfigUtils.getInstalledAppVersionCode(), false);
        MLogger.d(TAG, Constant.APP_UPDATE_CHECK, "getActiveAppVersionCode: ", Integer.valueOf(i));
        return i;
    }

    public static int getActiveRNVersionCode() {
        return MPreferences.getInt(SharedPref.SHARED_PREF_ACTIVE_REACT_BUNDLE_VERSION_CODE, 0, false);
    }

    public static int getAppDownloadProgressVersionCode() {
        int i = MPreferences.getInt(SharedPref.SHARED_PREF_APP_IN_PROGRESS_DOWNLOAD_VERSION_CODE, 0, false);
        MLogger.d(TAG, Constant.APP_UPDATE_CHECK, "getAppDownloadProgressVersionCode() called", Integer.valueOf(i));
        return i;
    }

    public static String getAppDownloadURL() {
        return MPreferences.getString(SharedPref.SHARED_PREF_APP_DOWNLOAD_URL, "", false);
    }

    public static String getAppDownloadingHash() {
        String string = MPreferences.getString(SharedPref.SHARED_PREF_APP_DOWNLOADING_HASH, "", false);
        MLogger.d(TAG, Constant.APP_UPDATE_CHECK, "getAppDownloadingHash: ", string);
        return string;
    }

    public static String getAppHash() {
        String string = MPreferences.getString(SharedPref.SHARED_PREF_APP_HASH, "", false);
        MLogger.d(TAG, Constant.APP_UPDATE_CHECK, "getAppHash: ", string);
        return string;
    }

    public static int getCriticalDownloadStartInBackground() {
        int i = MPreferences.getInt(SharedPref.SHARED_PREF_CRITICAL_DOWNLOAD_BACKGROUND, 0, false);
        MLogger.d(TAG, Constant.APP_UPDATE_CHECK, "getCriticalDownloadStartInBackground: ", Integer.valueOf(i));
        return i;
    }

    public static int getCurrentDownloadedAppVersionCode() {
        int i = MPreferences.getInt(SharedPref.SHARED_PREF_ANDROID_VERSION_CODE, MBuildConfigUtils.getInstalledAppVersionCode(), false);
        MLogger.d(TAG, Constant.APP_UPDATE_CHECK, "getCurrentDownloadedAppVersionCode: ", Integer.valueOf(i));
        return i;
    }

    public static int getCurrentDownloadedRNBundleVersionCode() {
        return MPreferences.getInt(SharedPref.SHARED_PREF_DOWNLOADED_REACT_BUNDLE_VERSION_CODE, 0, false);
    }

    public static int getCurrentRNBundleVersionCode() {
        try {
            return MPreferences.getInt(SharedPref.SHARED_PREF_REACT_BUNDLE_VERSION_CODE, 0, false);
        } catch (Exception e2) {
            MLogger.e(TAG, "getCurrentRNBundleVersionCode: ", e2);
            return 0;
        }
    }

    public static int getMinRNVersionCode() {
        return MPreferences.getInt(SharedPref.SHARED_PREF_REACT_MIN_VERSION_CODE, 0, false);
    }

    public static int getRNBundleDownloadProgressVersionCode() {
        return MPreferences.getInt(SharedPref.SHARED_PREF_REACT_BUNDLE_IN_PROGRESS_DOWNLOAD_VERSION_CODE, 0, false);
    }

    public static String getRNBundleDownloadURL() {
        return MPreferences.getString(SharedPref.SHARED_PREF_REACT_BUNDLE_DOWNLOAD_URL, "", false);
    }

    public static String getRNBundleDownloadingHash() {
        return MPreferences.getString(SharedPref.SHARED_PREF_REACT_BUNDLE_DOWNLOADING_HASH, "", false);
    }

    public static boolean getRNBundleReload() {
        return MPreferences.getBoolean(SharedPref.SHARED_PREF_SHOULD_RELOAD_REACT, false, false);
    }

    public static void increaseCriticalDownloadStartInBackground() {
        int criticalDownloadStartInBackground = getCriticalDownloadStartInBackground();
        MLogger.d(TAG, Constant.APP_UPDATE_CHECK, "increaseCriticalDownloadStartInBackground: ", Integer.valueOf(criticalDownloadStartInBackground));
        MPreferences.putInt(SharedPref.SHARED_PREF_CRITICAL_DOWNLOAD_BACKGROUND, criticalDownloadStartInBackground + 1, false);
    }

    public static boolean isFirstLaunchAfterInstallation() {
        return MPreferences.getBoolean(SharedPref.IS_FIRST_TIME_APP_LAUNCHED_AFTER_INSTALL, true, false);
    }

    public static boolean isFirstTimeLaunch() {
        return MPreferences.getBoolean(SharedPref.IS_FIRST_TIME_ASSETS_LOAD, true, false);
    }

    public static boolean isFirstTimeLoad() {
        return MPreferences.getBoolean(SharedPref.IS_FIRST_TIME_APP_LOAD, true, false);
    }

    public static void resetCriticalDownloadStartInBackground() {
        MLogger.d(TAG, Constant.APP_UPDATE_CHECK, "resetCriticalDownloadStartInBackground: ", Integer.valueOf(getCriticalDownloadStartInBackground()));
        MPreferences.putInt(SharedPref.SHARED_PREF_CRITICAL_DOWNLOAD_BACKGROUND, 0, false);
    }

    public static void setActiveAppVersionCode(int i) {
        MLogger.d(TAG, Constant.APP_UPDATE_CHECK, GeneratedOutlineSupport.outline42("setActiveAppVersionCode() called with: versionCode = [", i, CMapParser.MARK_END_OF_ARRAY));
        MPreferences.putInt(SharedPref.SHARED_PREF_ACTIVE_ANDROID_VERSION_CODE, i, false);
    }

    public static void setActiveRNVersionCode(int i) {
        MPreferences.putInt(SharedPref.SHARED_PREF_ACTIVE_REACT_BUNDLE_VERSION_CODE, i, false);
    }

    public static void setAppCriticalUpdate(boolean z) {
        MLogger.d(TAG, Constant.APP_UPDATE_CHECK, "setAppCriticalUpdate() called with: isCritical = [" + z + CMapParser.MARK_END_OF_ARRAY);
        MPreferences.putBoolean(SharedPref.SHARED_PREF_APP_CRITICAL, z, false);
    }

    public static void setAppDownloadProgressVersionCode(int i) {
        MLogger.d(TAG, Constant.APP_UPDATE_CHECK, GeneratedOutlineSupport.outline42("setAppDownloadProgressVersionCode() called with: versionCode = [", i, CMapParser.MARK_END_OF_ARRAY));
        MPreferences.putInt(SharedPref.SHARED_PREF_APP_IN_PROGRESS_DOWNLOAD_VERSION_CODE, i, false);
    }

    public static void setAppDownloadURL(String str) {
        MPreferences.putString(SharedPref.SHARED_PREF_APP_DOWNLOAD_URL, str, false);
    }

    public static void setAppDownloadingHash(String str) {
        MLogger.d(TAG, Constant.APP_UPDATE_CHECK, "setAppDownloadingHash: ", str);
        MPreferences.putString(SharedPref.SHARED_PREF_APP_DOWNLOADING_HASH, str, false);
    }

    public static void setAppHash(String str) {
        MLogger.d(TAG, Constant.APP_UPDATE_CHECK, "setAppHash: ", str);
        MPreferences.putString(SharedPref.SHARED_PREF_APP_HASH, str, false);
    }

    public static void setCurrentDownloadedAppVersionCode(int i) {
        MLogger.d(TAG, Constant.APP_UPDATE_CHECK, GeneratedOutlineSupport.outline42("setCurrentDownloadedAppVersionCode() called with: versionCode = [", i, CMapParser.MARK_END_OF_ARRAY));
        MPreferences.putInt(SharedPref.SHARED_PREF_ANDROID_VERSION_CODE, i, false);
    }

    public static void setCurrentDownloadedRNBundleVersionCode(int i) {
        MPreferences.putInt(SharedPref.SHARED_PREF_DOWNLOADED_REACT_BUNDLE_VERSION_CODE, i, false);
    }

    public static void setCurrentRNBundleVersionCode(int i) {
        MPreferences.putInt(SharedPref.SHARED_PREF_REACT_BUNDLE_VERSION_CODE, i, false);
    }

    public static void setFirstTimeLaunch() {
        MPreferences.putBoolean(SharedPref.IS_FIRST_TIME_ASSETS_LOAD, false, false);
    }

    public static void setIsFirstLaunchAfterInstallation() {
        MPreferences.putBoolean(SharedPref.IS_FIRST_TIME_APP_LAUNCHED_AFTER_INSTALL, false, false);
    }

    public static void setIsFirstTimeLoad() {
        MPreferences.putBoolean(SharedPref.IS_FIRST_TIME_APP_LOAD, false, false);
    }

    public static void setMinAppVersionCode(int i) {
        MLogger.d(TAG, Constant.APP_UPDATE_CHECK, "setMinAppVersionCode: ", Integer.valueOf(i));
        MPreferences.putInt(SharedPref.SHARED_PREF_APP_MIN_VERSION_CODE, i, false);
    }

    public static void setMinRNVersionCode(int i) {
        MPreferences.putInt(SharedPref.SHARED_PREF_REACT_MIN_VERSION_CODE, i, false);
    }

    public static void setRNBundleCriticalUpdate(boolean z) {
        MPreferences.putBoolean(SharedPref.SHARED_PREF_REACT_BUNDLE_CRITICAL, z, false);
    }

    public static void setRNBundleDownloadProgressVersionCode(int i) {
        MPreferences.putInt(SharedPref.SHARED_PREF_REACT_BUNDLE_IN_PROGRESS_DOWNLOAD_VERSION_CODE, i, false);
    }

    public static void setRNBundleDownloadURL(String str) {
        MPreferences.putString(SharedPref.SHARED_PREF_REACT_BUNDLE_DOWNLOAD_URL, str, false);
    }

    public static void setRNBundleDownloadingHash(String str) {
        MPreferences.putString(SharedPref.SHARED_PREF_REACT_BUNDLE_DOWNLOADING_HASH, str, false);
    }

    public static void setRNBundleHash(String str) {
        MPreferences.putString(SharedPref.SHARED_PREF_REACT_BUNDLE_HASH, str, false);
    }

    public static void setRNBundleReload(boolean z) {
        MPreferences.putBoolean(SharedPref.SHARED_PREF_SHOULD_RELOAD_REACT, z, false);
    }
}
