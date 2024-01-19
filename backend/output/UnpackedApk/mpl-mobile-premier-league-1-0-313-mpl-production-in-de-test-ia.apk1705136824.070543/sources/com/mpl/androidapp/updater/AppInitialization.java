package com.mpl.androidapp.updater;

import android.content.Context;
import com.mpl.androidapp.EventPublishHelper;
import com.mpl.androidapp.config.UpdaterAnalytics;
import com.mpl.androidapp.updater.gameengine.GEInteractor;
import com.mpl.androidapp.updater.interactor.DBInteractor;
import com.mpl.androidapp.updater.repo.DownloadHelper;
import com.mpl.androidapp.updater.util.GEUtil;
import com.mpl.androidapp.updater.util.StatusType;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.FileUtils;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import java.io.File;

public class AppInitialization {
    public static final String TAG = "AppInitialization";

    public static AppInitialization from(Context context) {
        try {
            if (!DBInteractor.isFirstTimeLaunch()) {
                if (GEUtil.getGameAssetsDownloadDirPath(context).exists()) {
                    if (!MSharedPreferencesUtils.getBooleanInNormalPref(context, Constant.IS_PRE_BUNDLE_ASSETS_DELETED_DUE_TO_ART_CHANGE, false)) {
                        GEInteractor.getInstance().deletePreBundleAssetsDueToArtChange(context);
                        GEInteractor.getInstance().initializeGameAssetsFirstTime(context, null);
                        MSharedPreferencesUtils.saveBooleanInNormalPref(context, Constant.IS_PRE_BUNDLE_ASSETS_DELETED_DUE_TO_ART_CHANGE, true);
                    }
                    return new AppInitialization();
                }
            }
            GEInteractor.getInstance().initializeGameAssetsFirstTime(context, null);
            DBInteractor.setFirstTimeLaunch();
            MSharedPreferencesUtils.saveBooleanInNormalPref(context, Constant.IS_PRE_BUNDLE_ASSETS_DELETED_DUE_TO_ART_CHANGE, true);
        } catch (Exception unused) {
        }
        return new AppInitialization();
    }

    public void checkUpdateAvailableCall(Context context, StatusType statusType) {
        MLogger.d(TAG, Constant.APP_UPDATE_CHECK, "checkUpdateAvailableCall: ", statusType.name());
        if (MBuildConfigUtils.isGlobalApp()) {
            DownloadHelper.getInstance().preLoginCall(context, statusType);
        } else {
            DownloadHelper.getInstance().checkUpdateAvailable(context, statusType, false, null, false);
        }
        if (statusType != StatusType.DOWNLOADED_APK_INTEGRITY_FAIL && statusType != StatusType.INTEGRITY_BUNDLE_RESOURCE_FAIL) {
            MLogger.d(TAG, "checkUpdateAvailableCall: ");
            EventPublishHelper.publishInitialStatusEvent(context, StatusType.CHECKING_UPDATE);
        }
    }

    public boolean installedApkIntegrityCheckFail(Context context) {
        return IntegrityCheck.installedApkIntegrityCheck(context);
    }

    public boolean isLocalAppUpdateAvailable() {
        boolean z = DBInteractor.getCurrentDownloadedAppVersionCode() > MBuildConfigUtils.getInstalledAppVersionCode();
        MLogger.d(TAG, Constant.APP_UPDATE_CHECK, "isLocalAppUpdateAvailable: ", Boolean.valueOf(z));
        return z;
    }

    public boolean isSafeToLoadRnBundle(Context context) {
        return IntegrityCheck.RNBundleAvailableIntegrityCheck(context);
    }

    public boolean updateApp(Context context) {
        MLogger.d(TAG, Constant.APP_UPDATE_CHECK, "updateApp: ");
        File apkOutputFile = FileUtils.getApkOutputFile(context, DBInteractor.getCurrentDownloadedAppVersionCode());
        if (IntegrityCheck.ApkIntegrityCheck(apkOutputFile)) {
            EventPublishHelper.publishInitialStatusEvent(context, StatusType.INSTALL);
            return true;
        }
        UpdaterAnalytics.integrityCheckFailEvent(2, "File is corrupted or deleted from storage");
        MLogger.d(TAG, Constant.APP_UPDATE_CHECK, "Corrupted apk deleted: ", Boolean.valueOf(apkOutputFile.delete()));
        return false;
    }
}
