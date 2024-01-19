package com.mpl.androidapp.utils;

import android.app.Activity;
import android.app.Application;
import android.app.NotificationManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.EventPublishHelper;
import com.mpl.androidapp.MPLLibInitContentProvider;
import com.mpl.androidapp.R;
import com.mpl.androidapp.config.ConfigManager;
import com.mpl.androidapp.config.UpdaterAnalytics;
import com.mpl.androidapp.game.AllGame;
import com.mpl.androidapp.game.ApkInfo;
import com.mpl.androidapp.game.DeviceSupportRequirement;
import com.mpl.androidapp.react.MPLReactContainerActivity;
import com.mpl.androidapp.react.modules.GameLaunchHelper;
import com.mpl.androidapp.share.utils.Keys.SocialPkgName;
import com.mpl.androidapp.updater.IntegrityCheck;
import com.mpl.androidapp.updater.gameengine.GEInteractor;
import com.mpl.androidapp.updater.interactor.DBInteractor;
import com.mpl.androidapp.updater.util.StatusType;
import com.mpl.androidapp.utils.Constant.EventsConstants;
import com.razorpay.BaseConstants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.apache.fontbox.cmap.CMap;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;
import org.joda.time.DateTime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Util {
    public static final String MY_PREFS_NAME = "sampleAppSharedPrefs";
    public static final List<Intent> POWERMANAGER_INTENTS = Arrays.asList(new Intent[]{new Intent().setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity")), new Intent().setComponent(new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity")), new Intent().setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity")), new Intent().setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.appcontrol.activity.StartupAppControlActivity")), new Intent().setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity")), new Intent().setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.startupapp.StartupAppListActivity")).setData(Uri.fromParts("package", MBuildConfigUtils.getApplicationId(), null)), new Intent().setComponent(new ComponentName("com.oppo.safe", "com.oppo.safe.permission.startup.StartupAppListActivity")), new Intent().setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.AddWhiteListActivity")), new Intent().setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.BgStartUpManager")), new Intent().setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.BgStartUpManagerActivity")), new Intent().setComponent(new ComponentName("com.asus.mobilemanager", "com.asus.mobilemanager.entry.FunctionActivity")), new Intent().setComponent(new ComponentName("com.asus.mobilemanager", "com.asus.mobilemanager.autostart.AutoStartActivity")), new Intent().setComponent(new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity")).setData(Uri.parse("mobilemanager://function/entry/AutoStart")), new Intent().setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.SHOW_APPSEC")).addCategory("android.intent.category.DEFAULT").putExtra("packageName", MBuildConfigUtils.getApplicationId())});
    public static final String TAG = "Util";

    public static void apkInstall(Context context) {
        MLogger.d(Constant.APP_UPDATE_CHECK, "apkInstall: ");
        File apkOutputFile = FileUtils.getApkOutputFile(context, DBInteractor.getCurrentDownloadedAppVersionCode());
        MLogger.d(Constant.APP_UPDATE_CHECK, "apkInstall:installApkFile ", apkOutputFile);
        if (!IntegrityCheck.ApkIntegrityCheck(apkOutputFile)) {
            apkOutputFile.delete();
            UpdaterAnalytics.integrityCheckFailEvent(2, "");
            EventPublishHelper.publishInitialStatusEvent(context, StatusType.DOWNLOADED_APK_INTEGRITY_FAIL);
        } else if (GEInteractor.getInstance().isSpaceAvailableToInstallApp(context)) {
            FileUtils.installApk(context, apkOutputFile);
        } else {
            EventPublishHelper.publishInitialStatusEvent(context, StatusType.INSTALL_APK_LOW_STORAGE);
        }
    }

    public static boolean appInstalledOrNot(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (Exception e2) {
            MLogger.e(TAG, e2);
            return false;
        }
    }

    public static void changeLocal(Context context, String str) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(new Locale(str.toLowerCase()));
        resources.updateConfiguration(configuration, displayMetrics);
    }

    public static void changeToMilliSecond() {
        long j = DateTime.parse(MSharedPreferencesUtils.getRootTime()).iMillis;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        MSharedPreferencesUtils.putServerTime(j);
        MSharedPreferencesUtils.putBootUpTime(elapsedRealtime);
        MSharedPreferencesUtils.putPhoneCurrentTime(timeInMillis);
    }

    public static String convertToTime(Long l) {
        long minutes = TimeUnit.MILLISECONDS.toMinutes(l.longValue());
        return minutes + " mins & " + (TimeUnit.MILLISECONDS.toSeconds(l.longValue()) % 60) + " secs";
    }

    public static void deleteRecursive(File file) throws IOException {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File deleteRecursive : listFiles) {
                    deleteRecursive(deleteRecursive);
                }
            } else {
                throw new NullPointerException("Received null trying to list files of directory '" + file + "'");
            }
        }
        if (!file.delete()) {
            throw new IOException("Failed to delete '" + file + "'");
        }
    }

    public static boolean externalStorageAvailableSpace() {
        if (!CommonUtils.isExternalStorageWritable()) {
            return false;
        }
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        if ((statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong()) / 1048576 > 250) {
            return true;
        }
        return false;
    }

    public static String getAppNameBasedOnGameId(int i) {
        return CommonUtils.getGameInfo(Integer.valueOf(i)) != null ? CommonUtils.getGameInfo(Integer.valueOf(i)).getName() : "";
    }

    public static String getAttributionUrl(int i) {
        AllGame gameInfo = CommonUtils.getGameInfo(Integer.valueOf(i));
        return (gameInfo == null || gameInfo.getGameConfigGameInfo() == null || gameInfo.getGameConfigGameInfo().getApkInfo() == null) ? "" : gameInfo.getGameConfigGameInfo().getApkInfo().getAttributionUrl();
    }

    public static MPLCalendar[] getCalendar(Context context) {
        String[] strArr = {"_id", "calendar_displayName"};
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.android.calendar/calendars"), strArr, null, null, null);
        if (query == null || !query.moveToFirst()) {
            return null;
        }
        MPLCalendar[] mPLCalendarArr = new MPLCalendar[query.getCount()];
        int columnIndex = query.getColumnIndex(strArr[1]);
        int i = 0;
        int columnIndex2 = query.getColumnIndex(strArr[0]);
        do {
            mPLCalendarArr[i] = new MPLCalendar(query.getString(columnIndex), query.getString(columnIndex2));
            i++;
        } while (query.moveToNext());
        if (query.isClosed()) {
            return mPLCalendarArr;
        }
        query.close();
        return mPLCalendarArr;
    }

    public static Date getCurrentTime() {
        long elapsedRealtime = (SystemClock.elapsedRealtime() - MSharedPreferencesUtils.getServerBootUpTimeWhenConfigCall()) + MSharedPreferencesUtils.getServerTime();
        Calendar.getInstance().getTimeInMillis();
        return new Date(elapsedRealtime);
    }

    public static long getDirectorySizeLegacy(File file) {
        long j;
        File[] listFiles = file.listFiles();
        long j2 = 0;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    j = file2.length();
                } else {
                    j = getDirectorySizeLegacy(file2);
                }
                j2 = j + j2;
            }
        }
        return j2;
    }

    public static long getInstalledApkVersion(Context context, String str) {
        long j;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return 0;
            }
            if (VERSION.SDK_INT >= 28) {
                j = packageInfo.getLongVersionCode();
            } else {
                j = (long) packageInfo.versionCode;
            }
            return j;
        } catch (Exception e2) {
            MLogger.e(TAG, "getInstalledApkVersion: ", e2);
            return 0;
        }
    }

    public static String getMainActivityNameBasedOnGameId(int i) {
        AllGame gameInfo = CommonUtils.getGameInfo(Integer.valueOf(i));
        return (gameInfo == null || gameInfo.getGameConfigGameInfo() == null || gameInfo.getGameConfigGameInfo().getApkInfo() == null) ? "" : gameInfo.getGameConfigGameInfo().getApkInfo().getMainActivity();
    }

    public static String getPackageNameBasedOnGameId(int i) {
        AllGame gameInfo = CommonUtils.getGameInfo(Integer.valueOf(i));
        return (gameInfo == null || gameInfo.getGameConfigGameInfo() == null || gameInfo.getGameConfigGameInfo().getApkInfo() == null) ? "" : gameInfo.getGameConfigGameInfo().getApkInfo().getPackageName();
    }

    public static String getRandomSessionString() {
        return UUID.randomUUID().toString();
    }

    public static String getRedirectUrl(int i) {
        return (CommonUtils.getGameInfo(Integer.valueOf(i)) == null || CommonUtils.getGameInfo(Integer.valueOf(i)).getGameConfigGameInfo() == null || CommonUtils.getGameInfo(Integer.valueOf(i)).getGameConfigGameInfo().getApkInfo() == null) ? "" : CommonUtils.getGameInfo(Integer.valueOf(i)).getGameConfigGameInfo().getApkInfo().getRedirectUrl();
    }

    public static Date getSystemTime() {
        return new Date(new DateTime().getMillis());
    }

    public static int getThirdPartyApkDownloadSpaceRequired(int i) {
        AllGame gameInfo = CommonUtils.getGameInfo(Integer.valueOf(i));
        if (gameInfo == null || gameInfo.getGameConfigGameInfo() == null || gameInfo.getGameConfigGameInfo().getApkInfo() == null || gameInfo.getGameConfigGameInfo().getApkInfo().getInstallationSpaceRequired() == null) {
            return 200;
        }
        return gameInfo.getGameConfigGameInfo().getApkInfo().getInstallationSpaceRequired().intValue();
    }

    public static String getThirdPartyApkDownloadUrl(int i) {
        AllGame gameInfo = CommonUtils.getGameInfo(Integer.valueOf(i));
        return (gameInfo == null || gameInfo.getGameConfigGameInfo() == null || gameInfo.getGameConfigGameInfo().getApkInfo() == null) ? "" : gameInfo.getGameConfigGameInfo().getApkInfo().getDownloadUrl();
    }

    public static int getThirdPartyApkDownloadVersion(int i) {
        AllGame gameInfo = CommonUtils.getGameInfo(Integer.valueOf(i));
        if (gameInfo == null || gameInfo.getGameConfigGameInfo() == null || gameInfo.getGameConfigGameInfo().getApkInfo() == null) {
            return 0;
        }
        return Integer.parseInt(gameInfo.getGameConfigGameInfo().getApkInfo().getGameVersion());
    }

    public static String getThirdPartyApkGameIconUrl(int i) {
        AllGame gameInfo = CommonUtils.getGameInfo(Integer.valueOf(i));
        return (gameInfo == null || gameInfo.getIcons() == null || TextUtils.isEmpty(gameInfo.getIcons().getLogo())) ? "" : gameInfo.getIcons().getLogo();
    }

    public static void getTimeFromLib(MTimeListener mTimeListener) {
        mTimeListener.onSuccess(getCurrentTime());
    }

    public static boolean hasPermission(Context context, String str) {
        int checkSelfPermission = ContextCompat.checkSelfPermission(context, str);
        Object[] objArr = new Object[1];
        StringBuilder outline80 = GeneratedOutlineSupport.outline80("permission: ", str, " = \t\t");
        outline80.append(checkSelfPermission == 0 ? "GRANTED" : "DENIED");
        objArr[0] = outline80.toString();
        MLogger.d(TAG, objArr);
        if (checkSelfPermission == 0) {
            return true;
        }
        return false;
    }

    public static boolean is32BitSupported() {
        String[] strArr = Build.SUPPORTED_32_BIT_ABIS;
        return strArr != null && strArr.length > 0;
    }

    public static boolean is64BitSupported() {
        String[] strArr = Build.SUPPORTED_64_BIT_ABIS;
        return strArr != null && strArr.length > 0;
    }

    public static boolean isApkUpdated() {
        boolean z = true;
        try {
            int installedAppVersionCode = MBuildConfigUtils.getInstalledAppVersionCode();
            int currentDownloadedAppVersionCode = DBInteractor.getCurrentDownloadedAppVersionCode();
            MLogger.d(TAG, "isApkUpdated: ", "installedVersion: ", Integer.valueOf(installedAppVersionCode), "downloadedAPK: ", Integer.valueOf(currentDownloadedAppVersionCode));
            if (installedAppVersionCode != currentDownloadedAppVersionCode) {
                z = false;
            }
            return z;
        } catch (Exception unused) {
            MLogger.e(TAG, "isApkUpdated: ");
            return false;
        }
    }

    public static boolean isAppInstalled(Context context, String str) {
        try {
            return appInstalledOrNot(context, str);
        } catch (Exception e2) {
            MLogger.e(TAG, e2);
            return false;
        }
    }

    public static boolean isAssetsAvailable(Context context, String str, String str2) {
        if (context == null) {
            return false;
        }
        try {
            if (context.getResources() == null || context.getResources().getAssets() == null || context.getResources().getAssets().list("") == null) {
                return false;
            }
            return Arrays.asList(context.getResources().getAssets().list(str)).contains(str2);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isAttributionEnabled(int i) {
        if (CommonUtils.getGameInfo(Integer.valueOf(i)) == null || CommonUtils.getGameInfo(Integer.valueOf(i)).getGameConfigGameInfo() == null || CommonUtils.getGameInfo(Integer.valueOf(i)).getGameConfigGameInfo().getApkInfo() == null) {
            return false;
        }
        return CommonUtils.getGameInfo(Integer.valueOf(i)).getGameConfigGameInfo().getApkInfo().isAttributionEnabled();
    }

    public static boolean isAutoDownloadEnabled(int i) {
        AllGame gameInfo = CommonUtils.getGameInfo(Integer.valueOf(i));
        if (gameInfo == null || gameInfo.getGameConfigGameInfo() == null || gameInfo.getGameConfigGameInfo().getApkInfo() == null) {
            return false;
        }
        boolean isAutoDownload = gameInfo.getGameConfigGameInfo().getApkInfo().isAutoDownload();
        MLogger.d(TAG, GameLaunchHelper.TAG, "isAutoDownloadEnabled:Is Auto download Enabled ", Boolean.valueOf(isAutoDownload));
        return isAutoDownload;
    }

    public static boolean isCallable(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public static boolean isClassPresent(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean isComponentPresent(Context context, ComponentName componentName) {
        if (context != null) {
            try {
                if (context.getPackageManager() != null) {
                    context.getPackageManager().getServiceInfo(componentName, 131072);
                }
            } catch (Exception unused) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDeveloperOptionEnabled(Context context) {
        return Secure.getInt(context.getContentResolver(), "development_settings_enabled", 0) == 1;
    }

    public static boolean isEmailPresent(Context context) {
        return appInstalledOrNot(context, SocialPkgName.EMAIL_PACKAGE_NAME);
    }

    public static boolean isFacebookPresent(Context context) {
        return appInstalledOrNot(context, "com.facebook.katana");
    }

    public static boolean isFantasyGameId() {
        return MBuildConfigUtils.getLaunchingGameId() >= 770 && MBuildConfigUtils.getLaunchingGameId() <= 778;
    }

    public static boolean isForceUpdate(int i) {
        if (CommonUtils.getGameInfo(Integer.valueOf(i)) == null || CommonUtils.getGameInfo(Integer.valueOf(i)).getGameConfigGameInfo() == null || CommonUtils.getGameInfo(Integer.valueOf(i)).getGameConfigGameInfo().getApkInfo() == null) {
            return false;
        }
        return CommonUtils.getGameInfo(Integer.valueOf(i)).getGameConfigGameInfo().getApkInfo().getForceUpdate();
    }

    public static boolean isGameSignatureMatched(Context context, int i) {
        AllGame gameInfo = CommonUtils.getGameInfo(Integer.valueOf(i));
        if (gameInfo == null || gameInfo.getGameConfigGameInfo() == null || gameInfo.getGameConfigGameInfo().getApkInfo() == null || TextUtils.isEmpty(gameInfo.getGameConfigGameInfo().getApkInfo().getSignature()) || TextUtils.isEmpty(gameInfo.getGameConfigGameInfo().getApkInfo().getPackageName()) || !isAppInstalled(context, gameInfo.getGameConfigGameInfo().getApkInfo().getPackageName())) {
            return true;
        }
        ApkInfo apkInfo = gameInfo.getGameConfigGameInfo().getApkInfo();
        String signature = apkInfo.getSignature();
        String apkSignedSignature = CommonUtils.getApkSignedSignature(context, apkInfo.getPackageName());
        boolean equalsIgnoreCase = signature.equalsIgnoreCase(apkSignedSignature);
        MLogger.d(TAG, GameLaunchHelper.TAG, "isGameSignatureMatched:signature from server: ", signature, "installedApkSignature: ", apkSignedSignature);
        return equalsIgnoreCase;
    }

    public static boolean isGameSupportedForDevice(Context context, int i) {
        AllGame gameInfo = CommonUtils.getGameInfo(Integer.valueOf(i));
        if (!(gameInfo == null || gameInfo.getGameConfigGameInfo() == null || gameInfo.getGameConfigGameInfo().getApkInfo() == null || gameInfo.getGameConfigGameInfo().getApkInfo().getDeviceSupportRequirement() == null)) {
            DeviceSupportRequirement deviceSupportRequirement = gameInfo.getGameConfigGameInfo().getApkInfo().getDeviceSupportRequirement();
            if (!TextUtils.isEmpty(deviceSupportRequirement.getArchitecture())) {
                try {
                    boolean is32BitSupported = is32BitSupported();
                    boolean is64BitSupported = is64BitSupported();
                    JSONArray jSONArray = new JSONArray(deviceSupportRequirement.getArchitecture());
                    int i2 = 0;
                    while (i2 < jSONArray.length()) {
                        if ("32".equalsIgnoreCase(jSONArray.optString(i2, "")) && !is32BitSupported) {
                            MLogger.d(TAG, GameLaunchHelper.TAG, "isGameSupportedForDevice: 32 bit architecture not supporting");
                            return false;
                        } else if (!"64".equalsIgnoreCase(jSONArray.optString(i2, "")) || is64BitSupported) {
                            i2++;
                        } else {
                            MLogger.d(TAG, GameLaunchHelper.TAG, "isGameSupportedForDevice: 64 bit architecture not supporting");
                            return false;
                        }
                    }
                } catch (Exception e2) {
                    MLogger.e(TAG, "isGameSupportedForDevice: ", e2);
                }
                MLogger.d(TAG, GameLaunchHelper.TAG, "isGameSupportedForDevice: Current Architecture not supporting");
            }
            if (!TextUtils.isEmpty(deviceSupportRequirement.getDeviceName()) && deviceSupportRequirement.getDeviceName().equalsIgnoreCase(Build.DEVICE)) {
                MLogger.d(TAG, GameLaunchHelper.TAG, "isGameSupportedForDevice: Current model not supporting");
                return false;
            } else if (!TextUtils.isEmpty(deviceSupportRequirement.getMinOs()) && Integer.parseInt(deviceSupportRequirement.getMinOs()) >= VERSION.SDK_INT) {
                MLogger.d(TAG, GameLaunchHelper.TAG, "isGameSupportedForDevice: Os version is less than Min Os Version");
                return false;
            } else if (!TextUtils.isEmpty(deviceSupportRequirement.getMaxOs()) && Integer.parseInt(deviceSupportRequirement.getMaxOs()) <= VERSION.SDK_INT) {
                MLogger.d(TAG, GameLaunchHelper.TAG, "isGameSupportedForDevice: Os version is greater than Max Os Version");
                return false;
            } else if (!TextUtils.isEmpty(deviceSupportRequirement.getRam()) && Integer.parseInt(deviceSupportRequirement.getRam()) >= VideoRecordingUtils.getYearClass(context)) {
                MLogger.d(TAG, GameLaunchHelper.TAG, "isGameSupportedForDevice: Ram is less than required Ram to Play!");
                return false;
            }
        }
        return true;
    }

    public static boolean isGameSupportedMaxVersion(int i) {
        AllGame gameInfo = CommonUtils.getGameInfo(Integer.valueOf(i));
        if (gameInfo == null || gameInfo.getGameConfigGameInfo() == null || gameInfo.getGameConfigGameInfo().getApkInfo() == null || gameInfo.getGameConfigGameInfo().getApkInfo().getMinAppVersion() == null) {
            return true;
        }
        Integer minAppVersion = gameInfo.getGameConfigGameInfo().getApkInfo().getMinAppVersion();
        boolean z = minAppVersion.intValue() <= MBuildConfigUtils.getMinVersionForChecking();
        MLogger.d(TAG, GameLaunchHelper.TAG, "isGameSupportedMaxVersion:version from server: ", minAppVersion);
        return z;
    }

    public static boolean isGameSupportedMinVersion(int i) {
        AllGame gameInfo = CommonUtils.getGameInfo(Integer.valueOf(i));
        if (gameInfo == null || gameInfo.getGameConfigGameInfo() == null || gameInfo.getGameConfigGameInfo().getApkInfo() == null || gameInfo.getGameConfigGameInfo().getApkInfo().getMinAppVersion() == null) {
            return true;
        }
        Integer minAppVersion = gameInfo.getGameConfigGameInfo().getApkInfo().getMinAppVersion();
        boolean z = minAppVersion.intValue() <= MBuildConfigUtils.getMinVersionForChecking();
        MLogger.d(TAG, GameLaunchHelper.TAG, "isGameSupportedMinVersion:version from server: ", minAppVersion);
        return z;
    }

    public static boolean isInstagramPresent(Context context) {
        return appInstalledOrNot(context, SocialPkgName.INSTAGRAM_PACKAGE_NAME);
    }

    public static boolean isInstallTrackEnabled(int i) {
        if (CommonUtils.getGameInfo(Integer.valueOf(i)) == null || CommonUtils.getGameInfo(Integer.valueOf(i)).getGameConfigGameInfo() == null || CommonUtils.getGameInfo(Integer.valueOf(i)).getGameConfigGameInfo().getApkInfo() == null) {
            return false;
        }
        return CommonUtils.getGameInfo(Integer.valueOf(i)).getGameConfigGameInfo().getApkInfo().isInstallTrackEnabled();
    }

    public static boolean isMPLSdkUsed(int i) {
        AllGame gameInfo = CommonUtils.getGameInfo(Integer.valueOf(i));
        if (gameInfo == null || gameInfo.getGameConfigGameInfo() == null || gameInfo.getGameConfigGameInfo().getApkInfo() == null) {
            return false;
        }
        boolean isMPLSdk = gameInfo.getGameConfigGameInfo().getApkInfo().isMPLSdk();
        MLogger.d(TAG, GameLaunchHelper.TAG, "isMPLSdkUsed: ", Boolean.valueOf(isMPLSdk));
        return isMPLSdk;
    }

    public static boolean isMagnificationSettingEnabled(Context context) {
        boolean z = true;
        try {
            if (ConfigManager.getPlatformConfig() == null || !ConfigManager.getPlatformConfig().optBoolean("game.accessibility.check.enabled", false)) {
                return false;
            }
            int i = Secure.getInt(context.getContentResolver(), "accessibility_display_magnification_enabled");
            if (i != 1) {
                i = Secure.getInt(context.getContentResolver(), "accessibility_display_magnification_navbar_enabled");
            }
            MLogger.d(TAG, "isMagnificationSettingEnabled: ", Integer.valueOf(i));
            if (i != 1) {
                z = false;
            }
            return z;
        } catch (SettingNotFoundException e2) {
            MLogger.e(TAG, "isMagnificationSettingEnabled: ", e2);
            return false;
        }
    }

    public static boolean isNotificationChannelEnabled(Context context, String str) {
        if (VERSION.SDK_INT < 26) {
            return NotificationManagerCompat.from(context).areNotificationsEnabled();
        }
        boolean z = false;
        if (!TextUtils.isEmpty(str) && ((NotificationManager) context.getSystemService("notification")).getNotificationChannel(str).getImportance() != 0 && NotificationManagerCompat.from(context).areNotificationsEnabled()) {
            z = true;
        }
        return z;
    }

    public static boolean isOriginals(ApkInfo apkInfo) {
        if (apkInfo != null) {
            return apkInfo.isOriginals();
        }
        return false;
    }

    public static boolean isOriginalsApp(int i) {
        if (CommonUtils.getGameInfo(Integer.valueOf(i)) == null || CommonUtils.getGameInfo(Integer.valueOf(i)).getGameConfigGameInfo() == null || CommonUtils.getGameInfo(Integer.valueOf(i)).getGameConfigGameInfo().getApkInfo() == null) {
            return false;
        }
        return CommonUtils.getGameInfo(Integer.valueOf(i)).getGameConfigGameInfo().getApkInfo().isOriginals();
    }

    public static boolean isPlayStoreThirdPartyApp(int i) {
        if (CommonUtils.getGameInfo(Integer.valueOf(i)) == null || CommonUtils.getGameInfo(Integer.valueOf(i)).getGameConfigGameInfo() == null || CommonUtils.getGameInfo(Integer.valueOf(i)).getGameConfigGameInfo().getApkInfo() == null) {
            return false;
        }
        return CommonUtils.getGameInfo(Integer.valueOf(i)).getGameConfigGameInfo().getApkInfo().getShouldLaunchPlayStore();
    }

    public static boolean isPreBuildApkFlow() {
        return !TextUtils.isEmpty(MBuildConfigUtils.getBuildFlavor()) && ("production_callbreak".equalsIgnoreCase(MBuildConfigUtils.getBuildFlavor()) || "production_carrom".equalsIgnoreCase(MBuildConfigUtils.getBuildFlavor()));
    }

    public static boolean isTelegramPresent(Context context) {
        return appInstalledOrNot(context, SocialPkgName.TELEGRAM_PACKAGE_NAME);
    }

    public static boolean isThirdPartyGame(int i) {
        AllGame gameInfo = CommonUtils.getGameInfo(Integer.valueOf(i));
        if (gameInfo == null || gameInfo.getGameConfigGameInfo() == null || gameInfo.getGameConfigGameInfo().getApkInfo() == null) {
            return false;
        }
        return gameInfo.getGameConfigGameInfo().getApkInfo().isThirdParty();
    }

    public static boolean isThisIsAppSealedApk(Application application) {
        boolean z = true;
        if (application == null || application.getApplicationInfo() == null || application.getApplicationInfo().metaData == null) {
            if (!isClassPresent("com.inka.appsealing.AppSealingService") || !isClassPresent("com.inka.appsealing.AppSealingIPService")) {
                z = false;
            }
            return z;
        }
        if (!"com.mpl.androidapp.MPLApplication".equalsIgnoreCase(application.getApplicationInfo().metaData.getString("APPLICATION_CLASS_NAME", "")) || !isClassPresent("com.inka.appsealing.AppSealingService") || !isClassPresent("com.inka.appsealing.AppSealingIPService")) {
            z = false;
        }
        return z;
    }

    public static boolean isTopQuiz(int i) {
        return i == 53 || i == 88;
    }

    public static boolean isTrueCallerPresent(Context context) {
        return appInstalledOrNot(context, BaseConstants.TRUE_CALLER_PKG);
    }

    public static boolean isTwitterPresent(Context context) {
        return appInstalledOrNot(context, "com.twitter.android");
    }

    public static boolean isUsbDebuggingEnabled(Context context) {
        if (Secure.getInt(context.getContentResolver(), "adb_enabled", 0) == 1 || Secure.getInt(context.getContentResolver(), "adb_enabled", 0) == 1) {
            return true;
        }
        return false;
    }

    public static boolean isWhatsappPresent(Context context) {
        return appInstalledOrNot(context, SocialPkgName.WHATSAPP_PACKAGE_NAME);
    }

    public static boolean isYouTubeappPresent(Context context) {
        return appInstalledOrNot(context, "com.google.android.youtube");
    }

    public static Bundle jsonToBundle(JSONObject jSONObject) {
        Bundle bundle = new Bundle();
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String string = jSONObject.getString(next);
                if (!TextUtils.isEmpty(next)) {
                    if (!TextUtils.isEmpty(string)) {
                        bundle.putString(next, string);
                    }
                }
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "jsonToBundle: ", e2);
        }
        return bundle;
    }

    public static Bundle jsonToBundleForFireBase(JSONObject jSONObject) throws JSONException {
        Bundle bundle = new Bundle();
        try {
            Iterator<String> keys = jSONObject.keys();
            int i = 0;
            while (keys.hasNext() && i < 24) {
                String next = keys.next();
                String string = jSONObject.getString(next);
                if (!TextUtils.isEmpty(next)) {
                    if (!TextUtils.isEmpty(string)) {
                        String replace = next.replace(CMap.SPACE, "_");
                        if (replace.length() > 39) {
                            replace = replace.substring(0, 35);
                        }
                        String replace2 = string.replace(CMap.SPACE, "_");
                        if (replace2.length() > 39) {
                            replace2 = replace2.substring(0, 35);
                        }
                        bundle.putString(replace, replace2);
                        i++;
                    }
                }
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "jsonToBundleForFireBase: ", e2);
        }
        return bundle;
    }

    public static HashMap<String, Object> jsonToMap(JSONObject jSONObject) throws JSONException {
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            return jSONObject != JSONObject.NULL ? toMap(jSONObject) : hashMap;
        } catch (Exception unused) {
            return hashMap;
        }
    }

    public static void openAppInPlayStore(Context context) {
        String packageName = context.getPackageName();
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName));
            intent.setFlags(268468224);
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + packageName)));
        }
    }

    public static void openAppThroughPlayStore(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str));
            intent.setPackage("com.android.vending");
            intent.setFlags(268468224);
            context.startActivity(intent);
        } catch (Exception unused) {
            openAppInPlayStore(context, str);
        }
    }

    public static void openLinkInBrowser(Context context) {
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(MSharedPreferencesUtils.getRootDownloadUrl())));
    }

    public static void pushBranchEvent(String str) {
        try {
            MLogger.d(TAG, "pushBranchEvent: ", str);
            char c2 = 65535;
            switch (str.hashCode()) {
                case -184375622:
                    if (str.equals("Reached Bronze Tier")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case -180614038:
                    if (str.equals(EventsConstants.USER_PLAYED_GAME)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -138660635:
                    if (str.equals(EventsConstants.RANKED_FETCHED)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 86288:
                    if (str.equals("WTM")) {
                        c2 = 8;
                        break;
                    }
                    break;
                case 234961968:
                    if (str.equals("User Profile Upgrade")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 280067726:
                    if (str.equals(EventsConstants.USER_LOGGED_ID)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1520734547:
                    if (str.equals(EventsConstants.USER_TOURNAMENT_REGISTRATION_SUCCESS)) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 1627521450:
                    if (str.equals("Share Initiated")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 2084444397:
                    if (str.equals(EventsConstants.MONEY_OUT_EVENT)) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    str = "User_Played_Game";
                    break;
                case 1:
                    str = "START_TRIAL";
                    break;
                case 2:
                    str = "SPEND_CREDITS";
                    break;
                case 3:
                    str = "COMPLETE_REGISTRATION";
                    break;
                case 4:
                    str = "VIEW_ITEM";
                    break;
                case 5:
                    str = "ACHIEVE_LEVEL";
                    break;
                case 6:
                    str = "UNLOCK_ACHIEVEMENT";
                    break;
                case 7:
                    str = "SHARE";
                    break;
                case 8:
                    str = "COMPLETE_TUTORIAL";
                    break;
            }
            CleverTapAnalyticsUtils.pushFireBaseEvents(str);
        } catch (Exception e2) {
            MLogger.e(TAG, "pushBranchEvent: ", e2);
        }
    }

    public static void pushBranchEventWithProp(String str) {
        pushBranchEvent(str);
    }

    public static void pushBranchEventWithPropWithoutStandard(String str) {
        pushBranchEvent(str);
    }

    public static void pushBranchEventWithoutStandard(String str) {
        MLogger.d(TAG, "pushBranchEventWithoutStandard: ", str);
        pushBranchEvent(str);
    }

    public static void pushFacebookEvent(String str) {
        try {
            MLogger.d(TAG, "pushFacebookEvent: ", str);
            sendFacebookEvents(str, new Bundle());
        } catch (Exception e2) {
            MLogger.e(TAG, "pushFacebookEvent: ", e2);
        }
    }

    public static void pushFacebookEventWithProp(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                pushFacebookEvent(str);
                return;
            }
            MLogger.d(TAG, "pushFacebookEventWithProp: ", str, str2);
            JSONObject jSONObject = new JSONObject(str2);
            Bundle bundle = new Bundle();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle.putString(next, jSONObject.optString(next));
            }
            sendFacebookEvents(str, bundle);
        } catch (JSONException e2) {
            MLogger.e(TAG, "pushFacebookEventWithProp: ", e2);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(27:2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|44) */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0119, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x011a, code lost:
        com.mpl.androidapp.utils.MLogger.printStackTrace(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0062 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0077 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x008c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x00a1 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x00b5 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x00c9 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x00dd */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x00f1 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0105 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0023 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0038 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x004d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void requestAutoStartPermission(android.app.Activity r5) {
        /*
            java.lang.String r0 = "com.coloros.safe"
            java.lang.String r1 = "com.coloros.safecenter"
            java.lang.String r2 = android.os.Build.MANUFACTURER
            java.lang.String r3 = "OPPO"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x011d
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x0023 }
            r2.<init>()     // Catch:{ Exception -> 0x0023 }
            android.content.ComponentName r3 = new android.content.ComponentName     // Catch:{ Exception -> 0x0023 }
            java.lang.String r4 = "com.coloros.safecenter.permission.startup.FakeActivity"
            r3.<init>(r1, r4)     // Catch:{ Exception -> 0x0023 }
            android.content.Intent r2 = r2.setComponent(r3)     // Catch:{ Exception -> 0x0023 }
            r5.startActivity(r2)     // Catch:{ Exception -> 0x0023 }
            goto L_0x011d
        L_0x0023:
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x0038 }
            r2.<init>()     // Catch:{ Exception -> 0x0038 }
            android.content.ComponentName r3 = new android.content.ComponentName     // Catch:{ Exception -> 0x0038 }
            java.lang.String r4 = "com.coloros.safecenter.permission.startupapp.StartupAppListActivity"
            r3.<init>(r1, r4)     // Catch:{ Exception -> 0x0038 }
            android.content.Intent r2 = r2.setComponent(r3)     // Catch:{ Exception -> 0x0038 }
            r5.startActivity(r2)     // Catch:{ Exception -> 0x0038 }
            goto L_0x011d
        L_0x0038:
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x004d }
            r2.<init>()     // Catch:{ Exception -> 0x004d }
            android.content.ComponentName r3 = new android.content.ComponentName     // Catch:{ Exception -> 0x004d }
            java.lang.String r4 = "com.coloros.safecenter.permission.startupmanager.StartupAppListActivity"
            r3.<init>(r1, r4)     // Catch:{ Exception -> 0x004d }
            android.content.Intent r2 = r2.setComponent(r3)     // Catch:{ Exception -> 0x004d }
            r5.startActivity(r2)     // Catch:{ Exception -> 0x004d }
            goto L_0x011d
        L_0x004d:
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x0062 }
            r2.<init>()     // Catch:{ Exception -> 0x0062 }
            android.content.ComponentName r3 = new android.content.ComponentName     // Catch:{ Exception -> 0x0062 }
            java.lang.String r4 = "com.coloros.safe.permission.startup.StartupAppListActivity"
            r3.<init>(r0, r4)     // Catch:{ Exception -> 0x0062 }
            android.content.Intent r2 = r2.setComponent(r3)     // Catch:{ Exception -> 0x0062 }
            r5.startActivity(r2)     // Catch:{ Exception -> 0x0062 }
            goto L_0x011d
        L_0x0062:
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x0077 }
            r2.<init>()     // Catch:{ Exception -> 0x0077 }
            android.content.ComponentName r3 = new android.content.ComponentName     // Catch:{ Exception -> 0x0077 }
            java.lang.String r4 = "com.coloros.safe.permission.startupapp.StartupAppListActivity"
            r3.<init>(r0, r4)     // Catch:{ Exception -> 0x0077 }
            android.content.Intent r2 = r2.setComponent(r3)     // Catch:{ Exception -> 0x0077 }
            r5.startActivity(r2)     // Catch:{ Exception -> 0x0077 }
            goto L_0x011d
        L_0x0077:
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x008c }
            r2.<init>()     // Catch:{ Exception -> 0x008c }
            android.content.ComponentName r3 = new android.content.ComponentName     // Catch:{ Exception -> 0x008c }
            java.lang.String r4 = "com.coloros.safe.permission.startupmanager.StartupAppListActivity"
            r3.<init>(r0, r4)     // Catch:{ Exception -> 0x008c }
            android.content.Intent r0 = r2.setComponent(r3)     // Catch:{ Exception -> 0x008c }
            r5.startActivity(r0)     // Catch:{ Exception -> 0x008c }
            goto L_0x011d
        L_0x008c:
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x00a1 }
            r0.<init>()     // Catch:{ Exception -> 0x00a1 }
            android.content.ComponentName r2 = new android.content.ComponentName     // Catch:{ Exception -> 0x00a1 }
            java.lang.String r3 = "com.coloros.safecenter.permission.startsettings"
            r2.<init>(r1, r3)     // Catch:{ Exception -> 0x00a1 }
            android.content.Intent r0 = r0.setComponent(r2)     // Catch:{ Exception -> 0x00a1 }
            r5.startActivity(r0)     // Catch:{ Exception -> 0x00a1 }
            goto L_0x011d
        L_0x00a1:
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x00b5 }
            r0.<init>()     // Catch:{ Exception -> 0x00b5 }
            android.content.ComponentName r2 = new android.content.ComponentName     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r3 = "com.coloros.safecenter.permission.startupapp.startupmanager"
            r2.<init>(r1, r3)     // Catch:{ Exception -> 0x00b5 }
            android.content.Intent r0 = r0.setComponent(r2)     // Catch:{ Exception -> 0x00b5 }
            r5.startActivity(r0)     // Catch:{ Exception -> 0x00b5 }
            goto L_0x011d
        L_0x00b5:
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x00c9 }
            r0.<init>()     // Catch:{ Exception -> 0x00c9 }
            android.content.ComponentName r2 = new android.content.ComponentName     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r3 = "com.coloros.safecenter.permission.startupmanager.startupActivity"
            r2.<init>(r1, r3)     // Catch:{ Exception -> 0x00c9 }
            android.content.Intent r0 = r0.setComponent(r2)     // Catch:{ Exception -> 0x00c9 }
            r5.startActivity(r0)     // Catch:{ Exception -> 0x00c9 }
            goto L_0x011d
        L_0x00c9:
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x00dd }
            r0.<init>()     // Catch:{ Exception -> 0x00dd }
            android.content.ComponentName r2 = new android.content.ComponentName     // Catch:{ Exception -> 0x00dd }
            java.lang.String r3 = "com.coloros.safecenter.permission.startup.startupapp.startupmanager"
            r2.<init>(r1, r3)     // Catch:{ Exception -> 0x00dd }
            android.content.Intent r0 = r0.setComponent(r2)     // Catch:{ Exception -> 0x00dd }
            r5.startActivity(r0)     // Catch:{ Exception -> 0x00dd }
            goto L_0x011d
        L_0x00dd:
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x00f1 }
            r0.<init>()     // Catch:{ Exception -> 0x00f1 }
            android.content.ComponentName r2 = new android.content.ComponentName     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r3 = "com.coloros.privacypermissionsentry.PermissionTopActivity.Startupmanager"
            r2.<init>(r1, r3)     // Catch:{ Exception -> 0x00f1 }
            android.content.Intent r0 = r0.setComponent(r2)     // Catch:{ Exception -> 0x00f1 }
            r5.startActivity(r0)     // Catch:{ Exception -> 0x00f1 }
            goto L_0x011d
        L_0x00f1:
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x0105 }
            r0.<init>()     // Catch:{ Exception -> 0x0105 }
            android.content.ComponentName r2 = new android.content.ComponentName     // Catch:{ Exception -> 0x0105 }
            java.lang.String r3 = "com.coloros.privacypermissionsentry.PermissionTopActivity"
            r2.<init>(r1, r3)     // Catch:{ Exception -> 0x0105 }
            android.content.Intent r0 = r0.setComponent(r2)     // Catch:{ Exception -> 0x0105 }
            r5.startActivity(r0)     // Catch:{ Exception -> 0x0105 }
            goto L_0x011d
        L_0x0105:
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x0119 }
            r0.<init>()     // Catch:{ Exception -> 0x0119 }
            android.content.ComponentName r2 = new android.content.ComponentName     // Catch:{ Exception -> 0x0119 }
            java.lang.String r3 = "com.coloros.safecenter.FakeActivity"
            r2.<init>(r1, r3)     // Catch:{ Exception -> 0x0119 }
            android.content.Intent r0 = r0.setComponent(r2)     // Catch:{ Exception -> 0x0119 }
            r5.startActivity(r0)     // Catch:{ Exception -> 0x0119 }
            goto L_0x011d
        L_0x0119:
            r5 = move-exception
            com.mpl.androidapp.utils.MLogger.printStackTrace(r5)
        L_0x011d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.utils.Util.requestAutoStartPermission(android.app.Activity):void");
    }

    public static void sendFacebookEvents(String str, Bundle bundle) {
        try {
            if (str.equalsIgnoreCase(EventsConstants.USER_TOURNAMENT_REGISTRATION_SUCCESS)) {
                str = "Tournament Registration";
            } else if (str.equalsIgnoreCase(EventsConstants.MONEY_OUT_EVENT)) {
                str = EventsConstants.MONEY_OUT_EVENT;
            } else if (str.equalsIgnoreCase(EventsConstants.MONEY_IN_EVENT)) {
                str = "Purchase";
                if (bundle.containsKey("Amount")) {
                    bundle.putString("_valueToSum", bundle.getString("Amount", ""));
                }
            } else if (str.equalsIgnoreCase(EventsConstants.USER_TEAM_REGISTRATION_SUCCESS)) {
                str = "Super Team Registration";
            } else if (str.equalsIgnoreCase(EventsConstants.USER_BATTLE_STARTED)) {
                str = "Battle Played";
            }
            if (MPLLibInitContentProvider.getLibInitContentProvider() != null) {
                if (bundle.containsKey(EventsConstants.USER_MOBILE_NUMBER)) {
                    bundle.remove(EventsConstants.USER_MOBILE_NUMBER);
                    MLogger.v(TAG, "sendFacebookEvents: ", "Mobile number removed from props");
                }
                if (bundle.containsKey(EventsConstants.PROP_IP_ADDRESS)) {
                    bundle.remove(EventsConstants.PROP_IP_ADDRESS);
                    MLogger.v(TAG, "sendFacebookEvents: ", "Wifi IP Address removed from props");
                }
                if (bundle.containsKey("Total RAM GB")) {
                    bundle.remove("Total RAM GB");
                    MLogger.v(TAG, "sendFacebookEvents: ", "Wifi IP Address removed from props");
                }
                MPLLibInitContentProvider.getLibInitContentProvider().getFacebookAppEventsLogger().loggerImpl.logEvent(str, bundle);
            }
        } catch (Exception unused) {
        }
    }

    public static void shareApp(Context context, String str) {
        String string = context.getResources().getString(R.string.app_name);
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("https://play.google.com/store/apps/details?id=");
        outline73.append(context.getPackageName());
        String sb = outline73.toString();
        String format = String.format("Invite your friends on %s", new Object[]{string});
        String format2 = String.format("Invite Message %s \n User info : %s \n %s", new Object[]{string, str, sb});
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.SUBJECT", format);
        intent.putExtra("android.intent.extra.TEXT", format2);
        intent.setType("text/plain");
        context.startActivity(Intent.createChooser(intent, "ShareApp"));
    }

    public static boolean shouldLaunchSameInstance(int i) {
        AllGame gameInfo = CommonUtils.getGameInfo(Integer.valueOf(i));
        if (gameInfo == null || gameInfo.getGameConfigGameInfo() == null || gameInfo.getGameConfigGameInfo().getApkInfo() == null) {
            return false;
        }
        boolean shouldLaunchSameInstance = gameInfo.getGameConfigGameInfo().getApkInfo().shouldLaunchSameInstance();
        MLogger.d(TAG, GameLaunchHelper.TAG, "shouldLaunch: ", Boolean.valueOf(shouldLaunchSameInstance));
        return shouldLaunchSameInstance;
    }

    public static boolean shouldRedirectToListingScreen() {
        return 1000063 == MBuildConfigUtils.getLaunchingGameId() || 1002070 == MBuildConfigUtils.getLaunchingGameId() || 1002044 == MBuildConfigUtils.getLaunchingGameId() || 1000115 == MBuildConfigUtils.getLaunchingGameId() || 1000117 == MBuildConfigUtils.getLaunchingGameId() || 1000125 == MBuildConfigUtils.getLaunchingGameId() || 1000141 == MBuildConfigUtils.getLaunchingGameId() || 2048 == MBuildConfigUtils.getLaunchingGameId() || 1000169 == MBuildConfigUtils.getLaunchingGameId() || 1000153 == MBuildConfigUtils.getLaunchingGameId() || 64 == MBuildConfigUtils.getLaunchingGameId() || 70 == MBuildConfigUtils.getLaunchingGameId() || 55 == MBuildConfigUtils.getLaunchingGameId();
    }

    public static boolean shouldSendNotification(String str) {
        try {
            if (TextUtils.isEmpty(str) || !CommonUtils.isJSONValid(str)) {
                return false;
            }
            JSONObject jSONObject = new JSONObject(str);
            if ("knockOut Tournament".equalsIgnoreCase(jSONObject.optString("feature", "")) || "knockOut Tournament".equalsIgnoreCase(jSONObject.optString("Feature", "")) || jSONObject.optBoolean("shouldSentOnMQTT", false)) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean shouldShowNotification(int i) {
        if (CommonUtils.getGameInfo(Integer.valueOf(i)) == null || CommonUtils.getGameInfo(Integer.valueOf(i)).getGameConfigGameInfo() == null || CommonUtils.getGameInfo(Integer.valueOf(i)).getGameConfigGameInfo().getApkInfo() == null) {
            return true;
        }
        return CommonUtils.getGameInfo(Integer.valueOf(i)).getGameConfigGameInfo().getApkInfo().isShouldShowNotification();
    }

    public static void showCustomToast(String str) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString(Constant.TOAST_DATA, str);
            if (MPLReactContainerActivity.resultReceiver != null) {
                MPLReactContainerActivity.resultReceiver.send(10, bundle);
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "showCustomToast", e2);
        }
    }

    public static boolean showDownloadPopUp(int i) {
        if (CommonUtils.getGameInfo(Integer.valueOf(i)) == null || CommonUtils.getGameInfo(Integer.valueOf(i)).getGameConfigGameInfo() == null || CommonUtils.getGameInfo(Integer.valueOf(i)).getGameConfigGameInfo().getApkInfo() == null) {
            return false;
        }
        return CommonUtils.getGameInfo(Integer.valueOf(i)).getGameConfigGameInfo().getApkInfo().isShowDownloadPopUp();
    }

    public static void startActivityForResultSafely(Activity activity, Intent intent, int i) {
        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            activity.startActivityForResult(intent, i);
            return;
        }
        MLogger.d(TAG, "No Intent available to handle action");
    }

    public static void startActivitySafely(Context context, Intent intent) {
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
            return;
        }
        MLogger.d(TAG, "No Intent available to handle action");
    }

    public static void startPowerSaverIntent(Activity activity) {
        try {
            if (MSharedPreferencesUtils.getBooleanPref("skipProtectedAppCheck", false, false)) {
                return;
            }
            if ("oppo".equalsIgnoreCase(Build.MANUFACTURER)) {
                requestAutoStartPermission(activity);
                return;
            }
            boolean z = false;
            for (Intent next : POWERMANAGER_INTENTS) {
                if (isCallable(activity, next) && activity != null) {
                    if (MPLReactContainerActivity.resultReceiver != null) {
                        MPLReactContainerActivity.resultReceiver.send(14, null);
                    }
                    activity.startActivity(next);
                    z = true;
                }
            }
            if (!z) {
                MSharedPreferencesUtils.putBooleanPref("skipProtectedAppCheck", true, false);
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "startPowerSaverIntent: ", e2);
        }
    }

    public static void store(Context context, String str, String str2) {
        Editor edit = context.getSharedPreferences(MY_PREFS_NAME, 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static List<Object> toList(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONArray) {
                obj = toList((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = toMap((JSONObject) obj);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    public static HashMap<String, Object> toMap(JSONObject jSONObject) throws JSONException {
        HashMap<String, Object> hashMap = new HashMap<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONArray) {
                obj = toList((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = toMap((JSONObject) obj);
            }
            hashMap.put(next, obj);
        }
        return hashMap;
    }

    public static void uninstallApp(Context context, String str) {
        Intent intent = new Intent("android.intent.action.DELETE");
        intent.setData(Uri.parse("package:" + str));
        intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
        context.startActivity(intent);
    }

    public static void openLinkInBrowser(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }

    public static String getPackageNameBasedOnGameId(ApkInfo apkInfo) {
        return apkInfo != null ? apkInfo.getPackageName() : "";
    }

    public static String getRedirectUrl(ApkInfo apkInfo) {
        return apkInfo != null ? apkInfo.getRedirectUrl() : "";
    }

    public static int getThirdPartyApkDownloadVersion(ApkInfo apkInfo) {
        if (apkInfo != null) {
            return Integer.parseInt(apkInfo.getGameVersion());
        }
        return 0;
    }

    public static boolean isPlayStoreThirdPartyApp(ApkInfo apkInfo) {
        if (apkInfo != null) {
            return apkInfo.getShouldLaunchPlayStore();
        }
        return false;
    }

    public static int getThirdPartyApkDownloadSpaceRequired(ApkInfo apkInfo) {
        if (apkInfo == null || apkInfo.getInstallationSpaceRequired() == null) {
            return 200;
        }
        return apkInfo.getInstallationSpaceRequired().intValue();
    }

    public static void openAppInPlayStore(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str));
            intent.setFlags(268468224);
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + str)));
        }
    }

    public static boolean isGameSupportedMinVersion(ApkInfo apkInfo) {
        boolean z;
        if (apkInfo == null || apkInfo.getMinAppVersion() == null) {
            z = true;
        } else {
            Integer minAppVersion = apkInfo.getMinAppVersion();
            z = minAppVersion.intValue() <= MBuildConfigUtils.getMinVersionForChecking();
            MLogger.d(TAG, GameLaunchHelper.TAG, "isGameSupportedMinVersion:version from server: ", minAppVersion, Boolean.valueOf(z));
        }
        MLogger.d(TAG, GameLaunchHelper.TAG, "isGameSupportedMinVersion:version from server:isSupported ", Boolean.valueOf(z));
        return z;
    }

    public static Bundle jsonToBundle(String str) {
        Bundle bundle = new Bundle();
        try {
            return jsonToBundle(new JSONObject(str));
        } catch (Exception e2) {
            MLogger.e(TAG, "jsonToBundle: ", e2);
            return bundle;
        }
    }

    public static boolean isGameSignatureMatched(Context context, ApkInfo apkInfo) {
        if (apkInfo == null || TextUtils.isEmpty(apkInfo.getSignature()) || TextUtils.isEmpty(apkInfo.getPackageName()) || !isAppInstalled(context, apkInfo.getPackageName())) {
            return true;
        }
        String signature = apkInfo.getSignature();
        String apkSignedSignature = CommonUtils.getApkSignedSignature(context, apkInfo.getPackageName());
        boolean equalsIgnoreCase = signature.equalsIgnoreCase(apkSignedSignature);
        MLogger.d(TAG, GameLaunchHelper.TAG, "isGameSignatureMatched:signature from server: ", signature, "installedApkSignature: ", apkSignedSignature);
        return equalsIgnoreCase;
    }

    public static void pushFacebookEventWithProp(String str, HashMap<String, Object> hashMap) {
        try {
            MLogger.d(TAG, "pushFacebookEventWithProp: ", str, hashMap);
            JSONObject jSONObject = new JSONObject(hashMap);
            Bundle bundle = new Bundle();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle.putString(next, jSONObject.optString(next));
            }
            sendFacebookEvents(str, bundle);
        } catch (Exception e2) {
            MLogger.e(TAG, "pushFacebookEventWithProp: ", e2);
        }
    }

    public static boolean isGameSupportedForDevice(Context context, ApkInfo apkInfo) {
        if (!(apkInfo == null || apkInfo.getDeviceSupportRequirement() == null)) {
            DeviceSupportRequirement deviceSupportRequirement = apkInfo.getDeviceSupportRequirement();
            if (!TextUtils.isEmpty(deviceSupportRequirement.getArchitecture())) {
                try {
                    boolean is32BitSupported = is32BitSupported();
                    boolean is64BitSupported = is64BitSupported();
                    JSONArray jSONArray = new JSONArray(deviceSupportRequirement.getArchitecture());
                    int i = 0;
                    while (i < jSONArray.length()) {
                        if ("32".equalsIgnoreCase(jSONArray.optString(i, "")) && !is32BitSupported) {
                            MLogger.d(TAG, GameLaunchHelper.TAG, "isGameSupportedForDevice: 32 bit architecture not supporting");
                            return false;
                        } else if (!"64".equalsIgnoreCase(jSONArray.optString(i, "")) || is64BitSupported) {
                            i++;
                        } else {
                            MLogger.d(TAG, GameLaunchHelper.TAG, "isGameSupportedForDevice: 64 bit architecture not supporting");
                            return false;
                        }
                    }
                } catch (Exception e2) {
                    MLogger.e(TAG, "isGameSupportedForDevice: ", e2);
                }
                MLogger.d(TAG, GameLaunchHelper.TAG, "isGameSupportedForDevice: Current Architecture not supporting");
            }
            if (!TextUtils.isEmpty(deviceSupportRequirement.getDeviceName()) && deviceSupportRequirement.getDeviceName().equalsIgnoreCase(Build.DEVICE)) {
                MLogger.d(TAG, GameLaunchHelper.TAG, "isGameSupportedForDevice: Current model not supporting");
                return false;
            } else if (!TextUtils.isEmpty(deviceSupportRequirement.getMinOs()) && Integer.parseInt(deviceSupportRequirement.getMinOs()) >= VERSION.SDK_INT) {
                MLogger.d(TAG, GameLaunchHelper.TAG, "isGameSupportedForDevice: Os version is less than Min Os Version");
                return false;
            } else if (!TextUtils.isEmpty(deviceSupportRequirement.getMaxOs()) && Integer.parseInt(deviceSupportRequirement.getMaxOs()) <= VERSION.SDK_INT) {
                MLogger.d(TAG, GameLaunchHelper.TAG, "isGameSupportedForDevice: Os version is greater than Max Os Version");
                return false;
            } else if (!TextUtils.isEmpty(deviceSupportRequirement.getRam()) && Integer.parseInt(deviceSupportRequirement.getRam()) >= VideoRecordingUtils.getYearClass(context)) {
                MLogger.d(TAG, GameLaunchHelper.TAG, "isGameSupportedForDevice: Ram is less than required Ram to Play!");
                return false;
            }
        }
        return true;
    }
}
