package com.mpl.androidapp.utils;

import com.midtrans.sdk.gopaycheckout.core.transaction.TransactionRequestKt;
import com.mpl.androidapp.BuildConfig;
import com.mpl.androidapp.MPLApplication;
import com.mpl.androidapp.R;
import com.mpl.androidapp.updater.util.UpdaterConstant;
import com.razorpay.BaseConstants;

public class MBuildConfigUtils {
    public static String getAPKHash() {
        return BuildConfig.APK_HASH;
    }

    public static String getApkType() {
        String stringInNormalPref = MPLApplication.getInstance() != null ? MSharedPreferencesUtils.getStringInNormalPref(MPLApplication.getInstance(), Constant.HEADER_APK_TYPE, "") : null;
        return (stringInNormalPref == null || stringInNormalPref.equalsIgnoreCase("")) ? BuildConfig.APK_TYPE : stringInNormalPref;
    }

    public static String getAppName() {
        return isCashApp() ? "MPL Pro" : "MPL";
    }

    public static String getAppNameRes() {
        return MPLApplication.getInstance().getResources().getString(R.string.app_name);
    }

    public static String getAppType() {
        return BuildConfig.APP_TYPE;
    }

    public static String getApplicationId() {
        return "com.mpl.androidapp";
    }

    public static String getAppsFlyerKey() {
        return BuildConfig.AF_KEY;
    }

    public static String getBuildFlavor() {
        return BuildConfig.FLAVOR;
    }

    public static String getBuildName() {
        return "Prod";
    }

    public static int getBuildNumber() {
        return BuildConfig.BUILD_NUMBER;
    }

    public static String getBuildTime() {
        return BuildConfig.buildTime;
    }

    public static String getCodePushApiKey() {
        return BuildConfig.CODE_PUSH_API_KEY;
    }

    public static String getCountryCode() {
        return CountryUtils.getSavedCountryCode();
    }

    public static String getCurrencyCode() {
        if (!"in".equalsIgnoreCase(getCountryCode()) && "id".equalsIgnoreCase(getCountryCode())) {
            return TransactionRequestKt.DEFAULT_CURRENCY;
        }
        return "INR";
    }

    public static String getCurrentAppVersionName() {
        return "1.0.313_MPL_Production_IN_DE_TEST_IA";
    }

    public static String getCurrentAppVersionNameForCodePush() {
        return BuildConfig.CODE_PUSH_VERSION_CODE;
    }

    public static int getCurrentReactVersionGradle() {
        return BuildConfig.reactVersion;
    }

    public static String getEnv() {
        return "Prod";
    }

    public static String getFreshChatAppDomain() {
        if ("IN".equalsIgnoreCase(getCountryCode())) {
            return "";
        }
        if ("ID".equalsIgnoreCase(getCountryCode()) || "US".equalsIgnoreCase(getCountryCode())) {
            return "msdk.in.freshchat.com";
        }
        return "";
    }

    public static String getFreshChatAppId() {
        if ("IN".equalsIgnoreCase(getCountryCode())) {
            return BuildConfig.FRESH_CHAT_APP_ID;
        }
        if ("ID".equalsIgnoreCase(getCountryCode())) {
            return BuildConfig.FRESH_CHAT_ID_APP_ID;
        }
        if ("US".equalsIgnoreCase(getCountryCode())) {
            return BuildConfig.FRESH_CHAT_US_APP_ID;
        }
        return BuildConfig.FRESH_CHAT_APP_ID;
    }

    public static String getFreshChatAppKey() {
        if ("IN".equalsIgnoreCase(getCountryCode())) {
            return BuildConfig.FRESH_CHAT_APP_KEY;
        }
        if ("ID".equalsIgnoreCase(getCountryCode())) {
            return BuildConfig.FRESH_CHAT_ID_APP_KEY;
        }
        if ("US".equalsIgnoreCase(getCountryCode())) {
            return BuildConfig.FRESH_CHAT_US_APP_KEY;
        }
        return BuildConfig.FRESH_CHAT_APP_KEY;
    }

    public static String getGoogleApiKey() {
        return BuildConfig.GOOGLE_API_KEY;
    }

    public static String getGoogleSenderId() {
        return BuildConfig.GOOGLE_SENDER_ID;
    }

    public static String getInBrainClientId() {
        return BuildConfig.IN_BRAIN_CLIENT_ID;
    }

    public static String getInBrainClientSecret() {
        return BuildConfig.IN_BRAIN_API_SECRET;
    }

    public static String getInMobiAccountID() {
        return BuildConfig.INMOBI_ACCOUNT_ID;
    }

    public static int getInstalledAppVersionCode() {
        return 1000313;
    }

    public static int getInstalledAppVersionCodeGradle() {
        return 1000313;
    }

    public static String getInstalledAppVersionNameGradle() {
        return "1.0.313_MPL_Production_IN_DE_TEST_IA";
    }

    public static int getLaunchingGameId() {
        return BuildConfig.launchingGameId;
    }

    public static String getMQTTClientTopicEntry() {
        return getBuildFlavor().contains(BaseConstants.DEVELOPMENT) ? "mpldev/client/" : "mpl/client/";
    }

    public static String getMQTTServerTopicEntry() {
        return getBuildFlavor().contains(BaseConstants.DEVELOPMENT) ? "mpldev/server/" : "mpl/server/";
    }

    public static String getMainUrl() {
        return BuildConfig.MAIN_URL;
    }

    public static int getMinVersionForChecking() {
        return getInstalledAppVersionCode() % getMinimumApkVersionCode();
    }

    public static int getMinimumApkVersionCode() {
        if (!"in".equalsIgnoreCase(getCountryCode()) && "id".equalsIgnoreCase(getCountryCode())) {
            return UpdaterConstant.APK_MIN_VERSION_CODE_ID;
        }
        return 1000000;
    }

    public static boolean getPreLoginCarousalEnabled() {
        return true;
    }

    public static boolean getRouteLoginReferral() {
        return false;
    }

    public static String getSearchAPIKey() {
        return BuildConfig.SEARCH_API_KEY;
    }

    public static String getSearchApplicationId() {
        return BuildConfig.SEARCH_APPLICATION_ID;
    }

    public static String getSentryDsnKey() {
        return BuildConfig.SENTRY_DSN;
    }

    public static String getShieldSecretKey() {
        return BuildConfig.DEVICE_ID_SECRET_KEY;
    }

    public static String getShieldSiteID() {
        return BuildConfig.DEVICE_ID_SITE_ID;
    }

    public static String getUserExpAppKey() {
        return BuildConfig.USER_EXP_API_KEY;
    }

    public static String getWebClientID() {
        return BuildConfig.WEB_CLIENT_ID;
    }

    public static String getYellowMessengerBotId() {
        return BuildConfig.YELLOW_MESSENGER_BOT_ID;
    }

    public static String getYellowMessengerBotName() {
        return BuildConfig.YELLOW_MESSENGER_BOT_NAME;
    }

    public static boolean isAgencyBuild() {
        return false;
    }

    public static boolean isCashApp() {
        return true;
    }

    public static boolean isDebuggable() {
        return false;
    }

    public static boolean isDeclutterIaEnabled() {
        return true;
    }

    public static boolean isDevelopmentModeEnabled() {
        isLogEnabled();
        return false;
    }

    public static boolean isGlobalApp() {
        return true;
    }

    public static boolean isIaEnabled() {
        return true;
    }

    public static boolean isLogEnabled() {
        return false;
    }

    public static boolean isPlatformFtueEnabled() {
        return false;
    }

    public static boolean isSandboxMoneyInEnable() {
        return false;
    }

    public static boolean isSecondaryApp() {
        return false;
    }

    public static boolean isUpdateV2ExperimentalEnabledFromGradle() {
        return false;
    }
}
