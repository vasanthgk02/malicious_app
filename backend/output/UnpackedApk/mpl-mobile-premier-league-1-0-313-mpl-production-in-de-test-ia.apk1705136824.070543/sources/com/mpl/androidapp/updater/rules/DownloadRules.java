package com.mpl.androidapp.updater.rules;

import android.content.Context;
import com.mpl.androidapp.EventPublishHelper;
import com.mpl.androidapp.config.ConfigManager;
import com.mpl.androidapp.config.UpdaterAnalytics;
import com.mpl.androidapp.updater.IntegrityCheck;
import com.mpl.androidapp.updater.gameengine.GEInteractor;
import com.mpl.androidapp.updater.interactor.DBInteractor;
import com.mpl.androidapp.updater.util.ServiceUtil;
import com.mpl.androidapp.updater.util.StatusType;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.FileUtils;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import java.io.File;

public class DownloadRules {
    public static final String TAG = "DownloadRules";

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0096  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void downloadNonCriticalUpdate(android.content.Context r16) {
        /*
            r0 = r16
            org.json.JSONObject r1 = com.mpl.androidapp.config.ConfigManager.getNormalConfig()
            java.lang.String r2 = "updates.apk.delay.timeV2"
            r3 = 0
            int r1 = r1.optInt(r2, r3)
            long r1 = (long) r1
            org.json.JSONObject r4 = com.mpl.androidapp.config.ConfigManager.getNormalConfig()
            java.lang.String r5 = "updates.apk.delay.time.unitV2"
            java.lang.String r6 = "D"
            java.lang.String r4 = r4.optString(r5, r6)
            java.lang.String r4 = r4.toUpperCase()
            boolean r5 = com.mpl.androidapp.utils.MSharedPreferencesUtils.isNewUserFromLoginResponse()
            java.lang.String r7 = "AppUpdateCheck:"
            java.lang.String r8 = "DownloadRules"
            r9 = 2
            r10 = 1
            r11 = 0
            int r13 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r13 <= 0) goto L_0x00ac
            if (r5 == 0) goto L_0x00ac
            java.util.Date r5 = com.mpl.androidapp.utils.Util.getCurrentTime()
            long r11 = r5.getTime()
            java.lang.String r5 = "loginTimeUpdaterV2"
            long r11 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getLongPref(r5, r11, r10)
            java.util.Date r5 = com.mpl.androidapp.utils.Util.getCurrentTime()
            long r13 = r5.getTime()
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.MILLISECONDS
            long r13 = r13 - r11
            long r11 = r5.toDays(r13)
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L_0x009c
            int r15 = r4.hashCode()
            r5 = 68
            if (r15 == r5) goto L_0x0078
            r5 = 72
            if (r15 == r5) goto L_0x006e
            r5 = 77
            if (r15 == r5) goto L_0x0064
            goto L_0x0080
        L_0x0064:
            java.lang.String r5 = "M"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0080
            r5 = 0
            goto L_0x0081
        L_0x006e:
            java.lang.String r5 = "H"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0080
            r5 = 1
            goto L_0x0081
        L_0x0078:
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0080
            r5 = 2
            goto L_0x0081
        L_0x0080:
            r5 = -1
        L_0x0081:
            if (r5 == 0) goto L_0x0096
            if (r5 == r10) goto L_0x008f
            if (r5 == r9) goto L_0x0088
            goto L_0x009c
        L_0x0088:
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS
            long r11 = r4.toDays(r13)
            goto L_0x009c
        L_0x008f:
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS
            long r11 = r4.toHours(r13)
            goto L_0x009c
        L_0x0096:
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS
            long r11 = r4.toMinutes(r13)
        L_0x009c:
            int r4 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r4 >= 0) goto L_0x00ac
            java.lang.Object[] r0 = new java.lang.Object[r9]
            r0[r3] = r7
            java.lang.String r1 = "downloadNonCriticalUpdate:No update required "
            r0[r10] = r1
            com.mpl.androidapp.utils.MLogger.d(r8, r0)
            return
        L_0x00ac:
            java.lang.Object[] r1 = new java.lang.Object[r9]
            r1[r3] = r7
            java.lang.String r2 = "downloadNonCriticalUpdate:[START]"
            r1[r10] = r2
            com.mpl.androidapp.utils.MLogger.d(r8, r1)
            boolean r1 = com.mpl.androidapp.utils.MBuildConfigUtils.isCashApp()
            if (r1 != 0) goto L_0x00c6
            boolean r1 = com.mpl.androidapp.utils.MSharedPreferencesUtils.isProAppDownloadRequired()
            if (r1 == 0) goto L_0x00c4
            goto L_0x00c6
        L_0x00c4:
            r1 = 0
            goto L_0x00c7
        L_0x00c6:
            r1 = 1
        L_0x00c7:
            int r2 = com.mpl.androidapp.updater.interactor.DBInteractor.getCurrentDownloadedAppVersionCode()
            int r4 = com.mpl.androidapp.updater.interactor.DBInteractor.getActiveAppVersionCode()
            java.io.File r5 = com.mpl.androidapp.utils.FileUtils.getApkOutputFile(r0, r2)
            boolean r5 = com.mpl.androidapp.updater.IntegrityCheck.ApkIntegrityCheck(r5)
            int r6 = com.mpl.androidapp.updater.interactor.DBInteractor.getCurrentRNBundleVersionCode()
            int r11 = com.mpl.androidapp.updater.interactor.DBInteractor.getActiveRNVersionCode()
            int r12 = com.mpl.androidapp.updater.interactor.DBInteractor.getMinRNVersionCode()
            com.mpl.androidapp.updater.gameengine.GEInteractor r13 = com.mpl.androidapp.updater.gameengine.GEInteractor.getInstance()
            boolean r13 = r13.isSpaceAvailable(r0)
            r14 = 18
            java.lang.Object[] r14 = new java.lang.Object[r14]
            r14[r3] = r7
            java.lang.String r7 = "downloadNonCriticalUpdate: "
            r14[r10] = r7
            java.lang.String r7 = "\nisCashApp"
            r14[r9] = r7
            r7 = 3
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r1)
            r14[r7] = r9
            r7 = 4
            java.lang.String r9 = "\ndownloadedVersionCode"
            r14[r7] = r9
            r7 = 5
            java.lang.Integer r9 = java.lang.Integer.valueOf(r2)
            r14[r7] = r9
            r7 = 6
            java.lang.String r9 = "\nactiveAppVersionCode"
            r14[r7] = r9
            r7 = 7
            java.lang.Integer r9 = java.lang.Integer.valueOf(r4)
            r14[r7] = r9
            r7 = 8
            java.lang.String r9 = "\nisFileAvailable"
            r14[r7] = r9
            r7 = 9
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r5)
            r14[r7] = r9
            r7 = 10
            java.lang.String r9 = "\ncurrentRNBundleVersionCode"
            r14[r7] = r9
            r7 = 11
            java.lang.Integer r9 = java.lang.Integer.valueOf(r6)
            r14[r7] = r9
            r7 = 12
            java.lang.String r9 = "\nminRNBundleVersionCode"
            r14[r7] = r9
            r7 = 13
            java.lang.Integer r9 = java.lang.Integer.valueOf(r12)
            r14[r7] = r9
            r7 = 14
            java.lang.String r9 = "\nisSpaceAvailable"
            r14[r7] = r9
            r7 = 15
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r13)
            r14[r7] = r9
            r7 = 16
            java.lang.String r9 = "\nactiveRNBundleVersionCode"
            r14[r7] = r9
            r7 = 17
            java.lang.Integer r9 = java.lang.Integer.valueOf(r11)
            r14[r7] = r9
            com.mpl.androidapp.utils.MLogger.d(r8, r14)
            if (r1 == 0) goto L_0x0190
            if (r2 < r4) goto L_0x016d
            if (r5 != 0) goto L_0x0190
            int r1 = com.mpl.androidapp.utils.MBuildConfigUtils.getInstalledAppVersionCode()
            if (r2 <= r1) goto L_0x0190
        L_0x016d:
            if (r13 == 0) goto L_0x0181
            int r1 = com.mpl.androidapp.updater.interactor.DBInteractor.getActiveAppVersionCode()
            com.mpl.androidapp.updater.interactor.DBInteractor.setAppDownloadProgressVersionCode(r1)
            com.mpl.androidapp.updater.util.ServiceUtil r1 = com.mpl.androidapp.updater.util.ServiceUtil.getInstance()
            r1.startService(r0, r3)
            com.mpl.androidapp.EventPublishHelper.bindServiceEvent(r0, r10)
            goto L_0x01bc
        L_0x0181:
            java.lang.String r1 = java.lang.String.valueOf(r4)
            java.lang.String r2 = "App"
            com.mpl.androidapp.config.UpdaterAnalytics.lowStoragePromptedEvent(r2, r1, r3)
            com.mpl.androidapp.updater.util.StatusType r1 = com.mpl.androidapp.updater.util.StatusType.NO_STORAGE
            com.mpl.androidapp.EventPublishHelper.publishInitialStatusEvent(r0, r1)
            goto L_0x01bc
        L_0x0190:
            if (r6 < r12) goto L_0x019a
            if (r6 < r11) goto L_0x019a
            boolean r1 = com.mpl.androidapp.updater.IntegrityCheck.RNBundleAvailableIntegrityCheck(r16)
            if (r1 != 0) goto L_0x01bc
        L_0x019a:
            if (r13 == 0) goto L_0x01ae
            int r1 = com.mpl.androidapp.updater.interactor.DBInteractor.getActiveRNVersionCode()
            com.mpl.androidapp.updater.interactor.DBInteractor.setRNBundleDownloadProgressVersionCode(r1)
            com.mpl.androidapp.updater.util.ServiceUtil r1 = com.mpl.androidapp.updater.util.ServiceUtil.getInstance()
            r1.startService(r0, r10)
            com.mpl.androidapp.EventPublishHelper.bindServiceEvent(r0, r3)
            goto L_0x01bc
        L_0x01ae:
            java.lang.String r1 = java.lang.String.valueOf(r12)
            java.lang.String r2 = "React"
            com.mpl.androidapp.config.UpdaterAnalytics.lowStoragePromptedEvent(r2, r1, r3)
            com.mpl.androidapp.updater.util.StatusType r1 = com.mpl.androidapp.updater.util.StatusType.NO_STORAGE
            com.mpl.androidapp.EventPublishHelper.publishInitialStatusEvent(r0, r1)
        L_0x01bc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.updater.rules.DownloadRules.downloadNonCriticalUpdate(android.content.Context):void");
    }

    public static void setRules(Context context, int i, int i2, int i3, int i4, StatusType statusType, boolean z) {
        Context context2 = context;
        int i5 = i;
        int currentRNBundleVersionCode = DBInteractor.getCurrentRNBundleVersionCode();
        boolean z2 = MBuildConfigUtils.isCashApp() || MSharedPreferencesUtils.isProAppDownloadRequired();
        int currentDownloadedAppVersionCode = DBInteractor.getCurrentDownloadedAppVersionCode();
        File apkOutputFile = FileUtils.getApkOutputFile(context2, currentDownloadedAppVersionCode);
        boolean exists = apkOutputFile.exists();
        boolean ApkIntegrityCheck = IntegrityCheck.ApkIntegrityCheck(apkOutputFile);
        int criticalDownloadStartInBackground = DBInteractor.getCriticalDownloadStartInBackground();
        int optInt = ConfigManager.getNormalConfig().optInt("updater.critical.download.count", 3);
        MLogger.d(TAG, Constant.LOADING_TAG, "setRules:[START] ");
        MLogger.d(TAG, Constant.APP_UPDATE_CHECK, Constant.ISCASHAPP, Boolean.valueOf(z2), "\ndownloadedVersionCode", Integer.valueOf(currentDownloadedAppVersionCode), "\nminAppVersionCode", Integer.valueOf(i), "\nminRNBundleVersionCode", Integer.valueOf(i2), "\nactiveAppVersionCode", Integer.valueOf(i4), "\nstatusType", statusType, "\ncurrentRNBundleVersionCode", Integer.valueOf(currentRNBundleVersionCode), "\nisApkFileAvailable", Boolean.valueOf(exists), "\nisFileIntegritySuccess", Boolean.valueOf(ApkIntegrityCheck), "\ncriticalDownloadCount", Integer.valueOf(criticalDownloadStartInBackground), "\ncriticalDownloadCountFromServer", Integer.valueOf(optInt), "\nisCritical", Boolean.valueOf(z), "\nactiveRNBundleVersionCode", Integer.valueOf(i3));
        boolean isSpaceAvailable = GEInteractor.getInstance().isSpaceAvailable(context2);
        if (!IntegrityCheck.RNBundleAvailableIntegrityCheck(context)) {
            if (isSpaceAvailable) {
                DBInteractor.setRNBundleDownloadProgressVersionCode(DBInteractor.getActiveRNVersionCode());
                ServiceUtil.getInstance().startService(context2, true);
                EventPublishHelper.bindServiceEvent(context2, false);
            } else {
                UpdaterAnalytics.lowStoragePromptedEvent(UpdaterAnalytics.REACT, String.valueOf(DBInteractor.getActiveRNVersionCode()), 0);
                EventPublishHelper.publishInitialStatusEvent(context2, StatusType.NO_STORAGE);
            }
        } else if (z2 && (currentDownloadedAppVersionCode < i5 || (!ApkIntegrityCheck && currentDownloadedAppVersionCode > MBuildConfigUtils.getInstalledAppVersionCode()))) {
            Object[] objArr = new Object[3];
            objArr[0] = Constant.APP_UPDATE_CHECK;
            objArr[1] = "Critical Download is getting triggered because downloaded version is less than minAppVersion ";
            objArr[2] = Boolean.valueOf(currentDownloadedAppVersionCode < i5);
            MLogger.d(TAG, objArr);
            MLogger.d(TAG, Constant.APP_UPDATE_CHECK, "Critical Download is getting triggered because file is not available", Boolean.valueOf(ApkIntegrityCheck));
            Object[] objArr2 = new Object[3];
            objArr2[0] = Constant.APP_UPDATE_CHECK;
            objArr2[1] = "Critical Download is getting triggered because downloaded version is greater than install version ";
            objArr2[2] = Boolean.valueOf(currentDownloadedAppVersionCode > MBuildConfigUtils.getInstalledAppVersionCode());
            MLogger.d(TAG, objArr2);
            if (isSpaceAvailable) {
                DBInteractor.increaseCriticalDownloadStartInBackground();
                if (z || criticalDownloadStartInBackground > optInt) {
                    MLogger.d(TAG, Constant.APP_UPDATE_CHECK, "setRules:Starting critical update ");
                    DBInteractor.setAppDownloadProgressVersionCode(DBInteractor.getActiveAppVersionCode());
                    ServiceUtil.getInstance().startService(context2, false);
                    EventPublishHelper.publishInitialStatusEvent(context2, StatusType.DOWNLOADING);
                    EventPublishHelper.bindServiceEvent(context2, true);
                } else {
                    MLogger.d(TAG, Constant.APP_UPDATE_CHECK, "setRules:Skipping critical update and starting React ");
                    EventPublishHelper.publishInitialStatusEvent(context2, StatusType.PROCEED);
                }
            } else {
                UpdaterAnalytics.lowStoragePromptedEvent(UpdaterAnalytics.APP, String.valueOf(i), 0);
                EventPublishHelper.publishInitialStatusEvent(context2, StatusType.NO_STORAGE);
            }
        } else if (z2 || currentDownloadedAppVersionCode >= i5) {
            MLogger.d(Constant.LOADING_TAG, "setRules:Starting React ");
            EventPublishHelper.publishInitialStatusEvent(context2, StatusType.PROCEED);
        } else {
            EventPublishHelper.publishInitialStatusEvent(context2, StatusType.PLAY_STORE_DOWNLOAD_CRITICAL);
        }
        MLogger.d(Constant.LOADING_TAG, "setRules:[END] ", TAG);
    }
}
