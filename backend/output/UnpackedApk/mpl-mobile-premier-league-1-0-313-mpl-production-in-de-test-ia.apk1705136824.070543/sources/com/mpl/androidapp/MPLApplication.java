package com.mpl.androidapp;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.media.AudioAttributes.Builder;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Process;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.hilt.work.HiltWorkerFactory;
import androidx.multidex.MultiDex;
import androidx.work.Configuration;
import androidx.work.Configuration.Provider;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.mpl.analytics.MPLAnalytics;
import com.mpl.androidapp.database.DatabaseClient;
import com.mpl.androidapp.database.NotificationDataManager;
import com.mpl.androidapp.exception.HookActivityManager;
import com.mpl.androidapp.responsiblegaming.RgSessionManager;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.Constant.ChannelConstants;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.netcore.android.Smartech;
import com.netcore.android.preference.SMTPreferenceConstants;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.apache.fontbox.cmap.CMapParser;
import timber.log.Timber;
import timber.log.Timber.DebugTree;

public class MPLApplication extends Hilt_MPLApplication implements Provider {
    public static final String TAG = "AppLoading:MPLApp";
    public static MPLApplication instance;
    public static DatabaseClient mDatabaseClient;
    public static RgSessionManager mRgSessionManager;
    public static MPLAnalytics mplAnalytics;
    public static NotificationDataManager notificationDataManager;
    public HiltWorkerFactory workerFactory;

    private void appsFlyerInitalization() {
        AnonymousClass1 r0 = new AppsFlyerConversionListener() {
            public void onAppOpenAttribution(Map<String, String> map) {
                for (String next : map.keySet()) {
                    StringBuilder outline80 = GeneratedOutlineSupport.outline80("onAppOpen_attribute: ", next, " = ");
                    outline80.append(map.get(next));
                    MLogger.d(Constant.APPS_FLYER_TAG, MPLApplication.TAG, outline80.toString());
                }
            }

            public void onAttributionFailure(String str) {
                MLogger.d(Constant.APPS_FLYER_TAG, MPLApplication.TAG, "error getting conversion data: ", str);
            }

            public void onConversionDataFail(String str) {
                MLogger.d(MPLApplication.TAG, GeneratedOutlineSupport.outline52("onConversionDataFail() called with: s = [", str, CMapParser.MARK_END_OF_ARRAY));
            }

            public void onConversionDataSuccess(Map<String, Object> map) {
                HashMap hashMap = new HashMap();
                for (String next : map.keySet()) {
                    StringBuilder outline80 = GeneratedOutlineSupport.outline80("conversion_attribute: ", next, " = ");
                    outline80.append(map.get(next));
                    MLogger.d(Constant.APPS_FLYER_TAG, MPLApplication.TAG, outline80.toString());
                    hashMap.put(next, map.get(next));
                }
                if (map.containsKey(SMTPreferenceConstants.SMT_IS_FIRST_LAUNCH) && ((Boolean) map.get(SMTPreferenceConstants.SMT_IS_FIRST_LAUNCH)).booleanValue()) {
                    if (map.containsKey("Referral Source")) {
                        CleverTapAnalyticsUtils.sendEvent((String) Constant.REFERRAL_ATTRIBUTION_DETECTED, hashMap);
                        if (map.containsKey("Feature")) {
                            MSharedPreferencesUtils.setAFReferralFeature(MPLApplication.instance, "Feature", String.valueOf(map.get("Feature")));
                        }
                    }
                    if (map.containsKey("shouldSkipFTUE") && ((Boolean) map.get("shouldSkipFTUE")).booleanValue()) {
                        MSharedPreferencesUtils.saveBooleanInNormalPref(MPLApplication.instance, "shouldSkipFTUE", ((Boolean) map.get("shouldSkipFTUE")).booleanValue());
                    }
                    MSharedPreferencesUtils.saveUserCameFromReferral(MPLApplication.instance, true);
                    CleverTapAnalyticsUtils.sendEvent((String) Constant.ATTRIBUTION_DETECTED, hashMap);
                    CleverTapAnalyticsUtils.sendEventsToAppsFlyer(MPLApplication.instance, "af_user_came_from_referral", hashMap);
                }
            }
        };
        AppsFlyerLib.getInstance().setResolveDeepLinkURLs("https://getmpl.com", "https://www.mpl.live/", "https://mpl.live/");
        if (MBuildConfigUtils.getBuildFlavor().contains("appBazaarPro")) {
            String format = new SimpleDateFormat("ddMMMyyyy", Locale.getDefault()).format(Calendar.getInstance().getTime());
            MLogger.d(TAG, "appsFlyerInitalization: ", format);
            AppsFlyerLib instance2 = AppsFlyerLib.getInstance();
            instance2.setPreinstallAttribution("indusos_int", "affiliate-PS_AppBazaar-" + format, "IndusOS");
        }
        if (MBuildConfigUtils.getBuildFlavor().equalsIgnoreCase("production_samsung")) {
            String format2 = new SimpleDateFormat("ddMMMyyyy", Locale.getDefault()).format(Calendar.getInstance().getTime());
            MLogger.d(TAG, "appsFlyerInitalization: ", format2);
            AppsFlyerLib instance3 = AppsFlyerLib.getInstance();
            instance3.setPreinstallAttribution("samsunggalaxystoreindusappbazaar_int", "PS_SamsungBazaar-" + format2, "SamsungOS");
        }
        AppsFlyerLib.getInstance().setDebugLog(MBuildConfigUtils.isLogEnabled());
        String cleverTapAttributionIdentifier = getMplAnalytics().getCleverTapAttributionIdentifier();
        AppsFlyerLib.getInstance().setCustomerUserId(cleverTapAttributionIdentifier);
        AppsFlyerLib.getInstance().init(MBuildConfigUtils.getAppsFlyerKey(), r0, getApplicationContext());
        AppsFlyerLib.getInstance().start(this);
        MLogger.d(TAG, "appsFlyerInitalization: ", cleverTapAttributionIdentifier);
    }

    private void createChallengesNotificationChannel() {
        if (VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(Constant.CHALLENGES_CHANNEL_ID, Constant.CHALLENGES_CHANNEL_ID, 4);
            notificationChannel.setDescription(Constant.CHALLENGES_CHANNEL_ID);
            notificationChannel.enableVibration(true);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(-65536);
            notificationChannel.setShowBadge(true);
            notificationChannel.setLockscreenVisibility(1);
            notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            Uri defaultUri = RingtoneManager.getDefaultUri(2);
            if (defaultUri != null) {
                notificationChannel.setSound(defaultUri, new Builder().setUsage(5).setContentType(4).build());
            }
            NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
    }

    private void createClientNotificationChannel() {
        if (VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(Constant.CLIENT_CHANNEL_ID, "Client Specific", 4);
            notificationChannel.setDescription("MPL Messages");
            notificationChannel.enableVibration(true);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(-65536);
            notificationChannel.setShowBadge(true);
            notificationChannel.setLockscreenVisibility(1);
            notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            Uri defaultUri = RingtoneManager.getDefaultUri(2);
            if (defaultUri != null) {
                notificationChannel.setSound(defaultUri, new Builder().setUsage(5).setContentType(4).build());
            }
            NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
    }

    private void createGameNotificationChannel() {
        if (VERSION.SDK_INT >= 26) {
            String string = getString(R.string.channel_name_game_playing);
            String string2 = getString(R.string.channel_description_game_playing);
            NotificationChannel notificationChannel = new NotificationChannel(ChannelConstants.GAME_PLAY_CHANNEL_ID, string, 1);
            notificationChannel.setDescription(string2);
            notificationChannel.enableLights(true);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
    }

    private void createGroupNotificationChannel() {
        if (VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(Constant.GROUPS_CHANNEL_ID, Constant.GROUPS_CHANNEL_ID, 4);
            notificationChannel.setDescription("Groups Messages");
            notificationChannel.enableVibration(true);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(-65536);
            notificationChannel.setShowBadge(true);
            notificationChannel.setLockscreenVisibility(1);
            notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            Uri defaultUri = RingtoneManager.getDefaultUri(2);
            if (defaultUri != null) {
                notificationChannel.setSound(defaultUri, new Builder().setUsage(5).setContentType(4).build());
            }
            NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
    }

    private void createPlayPauseNotificationChannel() {
        if (VERSION.SDK_INT >= 26) {
            String string = getString(R.string.channel_name_game_play_pause);
            String string2 = getString(R.string.channel_description_game_play_pause);
            NotificationChannel notificationChannel = new NotificationChannel(ChannelConstants.GAME_PLAY_PAUSE_CHANNEL_ID, string, 3);
            notificationChannel.setDescription(string2);
            notificationChannel.enableLights(true);
            notificationChannel.enableVibration(true);
            notificationChannel.setLightColor(-65536);
            notificationChannel.setShowBadge(true);
            notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            Uri defaultUri = RingtoneManager.getDefaultUri(2);
            if (defaultUri != null) {
                notificationChannel.setSound(defaultUri, new Builder().setUsage(5).setContentType(4).build());
            }
            NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
    }

    private void createSpinwheelNotificationChannel() {
        if (VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(Constant.SPIN_WHEEL_CHANNEL_ID, "Spin Wheel", 4);
            notificationChannel.setDescription("Notification");
            NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
    }

    public static DatabaseClient getDatabaseClient() {
        return mDatabaseClient;
    }

    public static MPLApplication getInstance() {
        return instance;
    }

    public static MPLAnalytics getMplAnalytics() {
        return mplAnalytics;
    }

    public static NotificationDataManager getNotificationDataManager() {
        return notificationDataManager;
    }

    private String getProcessName(Context context) {
        if (context == null) {
            return null;
        }
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
            for (RunningAppProcessInfo next : runningAppProcesses) {
                if (next.pid == Process.myPid()) {
                    return next.processName;
                }
            }
        }
        return null;
    }

    public static RgSessionManager getRgSessionManager() {
        return mRgSessionManager;
    }

    private void initAnalytics() {
        mplAnalytics = MPLAnalytics.from(this);
        registerActivityLifecycleCallbacks(new MPLApplicationLifeCycleCallback());
        mplAnalytics.setDebugLevel(MBuildConfigUtils.isLogEnabled() ? 2 : -1);
        mplAnalytics.setNotificationHandler();
    }

    private void initDatabaseClient() {
        MLogger.d(TAG, "initDatabaseClient: ", Integer.valueOf(instance.hashCode()));
        mDatabaseClient = DatabaseClient.getInstance(instance);
    }

    private void initDatabaseNotification() {
        notificationDataManager = new NotificationDataManager(instance);
    }

    private void initPreferences() {
        MSharedPreferencesUtils.setLogEnableForPreference();
        MSharedPreferencesUtils.initSharedPreferences(instance, "");
        MSharedPreferencesUtils.setIsUserPlayingGame(false);
    }

    private void initializeHansel() {
        try {
            Smartech.getInstance(new WeakReference(getApplicationContext())).initializeSdk(getInstance());
        } catch (Exception unused) {
        }
    }

    private void notificationChannel() {
        if (VERSION.SDK_INT >= 26) {
            if (getMplAnalytics() != null) {
                getMplAnalytics().createNotificationChannel(getApplicationContext(), "assets", getString(R.string.default_notif), "Assets Download Messages", 3, true);
                getMplAnalytics().createNotificationChannel(getApplicationContext(), "MPL", "Transactional", "All Transactional Messages", 4, true);
                getMplAnalytics().createNotificationChannel(getApplicationContext(), Constant.GAME_CHANNEL_ID, "Transactional", "All Transactional Messages", 2, true);
                getMplAnalytics().createNotificationChannel(getApplicationContext(), (String) ChannelConstants.CHAT_NOTIFICATION_CHANNEL_ID, (CharSequence) ChannelConstants.CHAT_NOTIFICATION_CHANNEL_NAME, (String) ChannelConstants.CHAT_NOTIFICATION_CHANNEL_DESC, 5, true, (String) "notification_sound.mp3");
                getMplAnalytics().createNotificationChannel(getApplicationContext(), (String) ChannelConstants.MPL_SOUND_NOTIFICATION_CHANNEL_ID, (CharSequence) "Transactional", (String) "All Transactional Messages", 5, true, (String) "notification_sound.mp3");
            }
            createSpinwheelNotificationChannel();
            createChallengesNotificationChannel();
            createGroupNotificationChannel();
            createClientNotificationChannel();
            createGameNotificationChannel();
            createPlayPauseNotificationChannel();
            return;
        }
    }

    private void saveDeviceId() {
        try {
            MSharedPreferencesUtils.setDeviceIdForPreLogin(instance, Secure.getString(getContentResolver(), "android_id"));
        } catch (Exception unused) {
        }
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
        HookActivityManager.hook();
    }

    public String getFileProviderAuthority() {
        return MBuildConfigUtils.getApplicationId() + ".provider";
    }

    public Configuration getWorkManagerConfiguration() {
        Configuration.Builder builder = new Configuration.Builder();
        builder.mWorkerFactory = this.workerFactory;
        return new Configuration(builder);
    }

    public void onCreate() {
        instance = this;
        initAnalytics();
        super.onCreate();
        try {
            if (VERSION.SDK_INT >= 28) {
                String processName = getProcessName(instance.getApplicationContext());
                String packageName = getPackageName();
                MLogger.d(TAG, "onCreate: ", processName, packageName);
                if (!packageName.equals(processName)) {
                    WebView.setDataDirectorySuffix(processName);
                }
            }
        } catch (Exception unused) {
        }
        if (MBuildConfigUtils.isLogEnabled()) {
            Timber.plant(new DebugTree());
        }
        notificationChannel();
        initPreferences();
        appsFlyerInitalization();
        initializeHansel();
        initDatabaseClient();
        initDatabaseNotification();
        MLogger.d(TAG, "onCreate:[END] ");
        MSharedPreferencesUtils.saveLongInNormalPref(instance, "app_launch_loading_time", System.currentTimeMillis());
        if (TextUtils.isEmpty(MSharedPreferencesUtils.getStringInNormalPref(this, Constant.USER_UUID, ""))) {
            MSharedPreferencesUtils.saveStringInNormalPref(this, Constant.USER_UUID, UUID.randomUUID().toString());
        }
        String stringInNormalPref = MSharedPreferencesUtils.getStringInNormalPref(instance, Constant.HEADER_APK_TYPE, "");
        if (stringInNormalPref == null || stringInNormalPref.equalsIgnoreCase("")) {
            MSharedPreferencesUtils.saveStringInNormalPref(instance, Constant.HEADER_APK_TYPE, MBuildConfigUtils.getApkType());
        }
        saveDeviceId();
        mRgSessionManager = new RgSessionManager(getContentResolver());
    }

    public void onLowMemory() {
        super.onLowMemory();
        MLogger.d(TAG, "onLowMemory() called");
    }

    public void onTerminate() {
        super.onTerminate();
        MSharedPreferencesUtils.setIsUserPlayingGame(false);
        MLogger.d(TAG, "onTerminate() called");
    }

    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        MLogger.d(TAG, GeneratedOutlineSupport.outline42("onTrimMemory() called with: level = [", i, CMapParser.MARK_END_OF_ARRAY));
        if (i >= 40) {
            MLogger.d(TAG, GeneratedOutlineSupport.outline42("onTrimMemory() called with: level = [", i, "] and GarbageCollected"));
            System.gc();
        }
    }
}
