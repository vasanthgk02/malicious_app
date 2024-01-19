package com.mpl.androidapp.react.modules;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.crimzoncode.tqcontests.QuizActivity;
import com.crimzoncode.tqcontests.util.TQConstants;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.gson.Gson;
import com.mpl.androidapp.MPLApplication;
import com.mpl.androidapp.WebViewActivity;
import com.mpl.androidapp.cleverTap.MplCtEventConstants.CtNativeLaunchInitiated;
import com.mpl.androidapp.cleverTap.MplCtEventInitiate;
import com.mpl.androidapp.cleverTap.MplCtEventInitiate.CtEventConstants;
import com.mpl.androidapp.config.ConfigConstant;
import com.mpl.androidapp.config.ConfigManager;
import com.mpl.androidapp.game.AllGame;
import com.mpl.androidapp.game.GameRunningState;
import com.mpl.androidapp.game.MPLUnityPlayerActivity;
import com.mpl.androidapp.miniprofile.ct.C.Config;
import com.mpl.androidapp.model.GameReplayConfigModel;
import com.mpl.androidapp.react.MPLReactContainerActivity;
import com.mpl.androidapp.react.RNConstant;
import com.mpl.androidapp.react.RNListener;
import com.mpl.androidapp.smartfox.MPLSFS2XConnectorActivity;
import com.mpl.androidapp.unity.features.InvokeMplFeatures;
import com.mpl.androidapp.updater.downloadmanager.DownloadNotificationDisplayFeature;
import com.mpl.androidapp.updater.downloadmanager.di.entrypoints.NotificationDisplayEntryPoint;
import com.mpl.androidapp.updater.gameengine.GEInteractor;
import com.mpl.androidapp.updater.interactor.DBInteractor;
import com.mpl.androidapp.updater.util.GEUtil;
import com.mpl.androidapp.utils.AppsflyerUtils;
import com.mpl.androidapp.utils.AssetsConfigReader;
import com.mpl.androidapp.utils.AssetsUtils;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.CommonUtils;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.Constant.EventsConstants;
import com.mpl.androidapp.utils.Constant.VideoRecordingConstants;
import com.mpl.androidapp.utils.CountryUtils;
import com.mpl.androidapp.utils.GameConstant;
import com.mpl.androidapp.utils.LocaleHelper;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.mpl.androidapp.utils.Util;
import com.mpl.androidapp.utils.VideoRecordingUtils;
import com.mpl.payment.braintree.BraintreeConstants;
import com.netcore.android.SMTConfigConstants;
import com.razorpay.BaseConstants;
import com.twitter.sdk.android.tweetui.TweetUtils;
import io.hansel.actions.configs.HanselConfigs;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ReactModule(name = "IntentHelper")
public class IntentHelper extends ReactContextBaseJavaModule {
    public static final String TAG = "IntentHelper";
    public String hash;
    public boolean isAssetsDirFromGameEnabled = false;
    public boolean isAssetsDirectoryCheckEnabled = false;
    public int mCheckingGameId;
    public Context mContext;

    public class RedirectClass {
        public final JSONObject gameObject;

        public RedirectClass(JSONObject jSONObject) {
            this.gameObject = jSONObject;
        }

        public String getRedirectActivity() {
            String optString = IntentHelper.this.getExtraInfoJSON(this.gameObject).optString("redirectActivity", "");
            if (TextUtils.isEmpty(optString) && this.gameObject.has("redirectActivity")) {
                optString = this.gameObject.optString("redirectActivity", "");
            }
            return TextUtils.isEmpty(optString) ? Util.getMainActivityNameBasedOnGameId(this.gameObject.optInt("GameId", 0)) : optString;
        }

        public String getRedirectAuthHeader() {
            return this.gameObject.optString("redirectAuth", "");
        }

        public String getRedirectPackage() {
            String optString = IntentHelper.this.getExtraInfoJSON(this.gameObject).optString("redirectPackage", "");
            if (TextUtils.isEmpty(optString) && this.gameObject.has("redirectPackage")) {
                optString = this.gameObject.optString("redirectPackage", "");
            }
            return TextUtils.isEmpty(optString) ? Util.getPackageNameBasedOnGameId(this.gameObject.optInt("GameId", 0)) : optString;
        }

        public String getRedirectUrl() {
            String optString = this.gameObject.optString("redirectUrl", "");
            return (!this.gameObject.has("redirectUrlV2") || TextUtils.isEmpty(this.gameObject.optString("redirectUrlV2", ""))) ? optString : this.gameObject.optString("redirectUrlV2", "");
        }
    }

    public IntentHelper(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        MLogger.d(TAG, "IntentHelper: ");
        this.mContext = reactApplicationContext.getApplicationContext();
        reactApplicationContext.addLifecycleEventListener(new LifecycleEventListener() {
            public void onHostDestroy() {
            }

            public void onHostPause() {
            }

            public void onHostResume() {
                IntentHelper intentHelper = IntentHelper.this;
                intentHelper.setGameIsAlreadyRunning(intentHelper.mCheckingGameId, false);
            }
        });
    }

    private void addCommonParamsForAllGames(JSONObject jSONObject) {
        try {
            int optInt = jSONObject.optInt("GameId", 0);
            MLogger.d(TAG, "addCommonParamsForAllGames: ", Integer.valueOf(optInt));
            jSONObject.put(GameConstant.GAME_APP_ID, MBuildConfigUtils.getApplicationId());
            jSONObject.put(GameConstant.GAME_COUNTRY_CODE, MBuildConfigUtils.getCountryCode());
            jSONObject.put(GameConstant.GAME_IS_NEWLY_DOWNLOADED_ASSETS, AssetsUtils.isMergedAssetsAreDownloaded(optInt));
            jSONObject.put(GameConstant.GAME_IS_AGENCY_BUILD, MBuildConfigUtils.isAgencyBuild());
            jSONObject.put(GameConstant.GAME_SSO_REFRESH_TOKEN_ENABLED, false);
            jSONObject.put(GameConstant.GAME_SELECTED_LANGUAGE, LocaleHelper.getSelectedLanguage());
            jSONObject.put(GameConstant.ASSETS_DIRECTORY_HASH, this.hash);
            jSONObject.put(GameConstant.ASSETS_DIRECTORY_MATCH_ENABLED, AssetsUtils.isAssetsDirectoryCheckFromGameEnabled());
            if (AssetsUtils.isSendingHashInConfigEnabled()) {
                if (AssetsUtils.isMergedAssetsAreDownloaded(optInt)) {
                    jSONObject.put(GameConstant.ASSETS_FILES_HASH_JSON, GEUtil.getAssetsFileHashJsonForAssets(this.mContext, CommonUtils.changeToBattleGameId(jSONObject.optInt("GameId", 0))));
                } else {
                    jSONObject.put(GameConstant.ASSETS_FILES_HASH_JSON, GEUtil.getAssetsFileHashJsonForAssets(this.mContext, optInt));
                }
            }
            if (!jSONObject.has(GameConstant.HOST_URL)) {
                jSONObject.put(GameConstant.HOST_URL, MBuildConfigUtils.getMainUrl());
            }
            if (!jSONObject.has(SMTConfigConstants.SCREEN_ORIENTATION_LANDSCAPE) && jSONObject.has("gameInfoExtra")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("gameInfoExtra");
                if (optJSONObject != null) {
                    AllGame allGame = (AllGame) new Gson().fromJson(optJSONObject.toString(), AllGame.class);
                    if (allGame != null) {
                        jSONObject.put(SMTConfigConstants.SCREEN_ORIENTATION_LANDSCAPE, allGame.getLandscape());
                    }
                }
            }
            if (MPLApplication.getMplAnalytics() != null) {
                jSONObject.put("MPLProCTId", MPLApplication.getMplAnalytics().getCleverTapId());
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "addCommonParamsForAllGames: ", e2);
            StringBuilder sb = new StringBuilder();
            sb.append("addCommonParamsForAllGames: ");
            showToast(GeneratedOutlineSupport.outline39(e2, sb));
        }
    }

    private void addConfigFromExtraInfo(JSONObject jSONObject) {
        MLogger.d(TAG, "addConfigFromExtraInfo: ");
        int i = -1;
        try {
            if (getExtraInfoJSON(jSONObject).has("delayStart") && getExtraInfoJSON(jSONObject).optInt("delayStart") > 0) {
                i = getExtraInfoJSON(jSONObject).optInt("delayStart");
            }
            jSONObject.put("TouchTimeInterval", getExtraInfoJSON(jSONObject).optInt("touchTimeInterval", 0));
            if (i > 0) {
                jSONObject.put(GameConstant.GAME_DELAY_START, i);
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "addConfigFromExtraInfo: ", e2);
            StringBuilder sb = new StringBuilder();
            sb.append("addConfigFromExtraInfo: ");
            showToast(GeneratedOutlineSupport.outline39(e2, sb));
        }
    }

    private void addExtraDataForCodeMergeGames(JSONObject jSONObject) {
        try {
            MLogger.d(TAG, "addExtraDataForCodeMergeGames");
            jSONObject.put(GameConstant.GAME_IS_ADS_ENABLED, isAdsEnabled(jSONObject));
            jSONObject.put(GameConstant.GAME_IS_ANZU_ADS_ENABLED, isAnzuAdsEnable(jSONObject));
            jSONObject.put(GameConstant.GAME_MOBILE_NUMBER, CountryUtils.getUniqueIdForThirdPartySDKs());
            jSONObject.put(GameConstant.GAME_PHOTON_APP_ID, MSharedPreferencesUtils.getPhotonAppId());
            jSONObject.put(GameConstant.GAME_IS_TIER_ENABLED, MSharedPreferencesUtils.isTierEnabledForGame());
            jSONObject.put(GameConstant.AUTH_TOKEN, MSharedPreferencesUtils.getAccessUserToken());
            jSONObject.put(GameConstant.GAME_REACT_VERSION, String.valueOf(DBInteractor.getCurrentRNBundleVersionCode()));
            jSONObject.put(GameConstant.GAME_IS_ROOTED, MSharedPreferencesUtils.isPhoneRooted());
            jSONObject.put(GameConstant.GAME_IS_MOD_APP_FOUND, MSharedPreferencesUtils.isGameTamperedAppPresent());
            jSONObject.put(GameConstant.GAME_ANDROID_APP_VERSION_CODE, String.valueOf(MBuildConfigUtils.getInstalledAppVersionCode()));
            jSONObject.put(GameConstant.GAME_ANDROID_APP_VERSION_NAME, String.valueOf(MBuildConfigUtils.getCurrentAppVersionName()));
            jSONObject.put(GameConstant.GAME_ANDROID_APP_TYPE, MBuildConfigUtils.getAppType());
            jSONObject.put(GameConstant.GAME_PHOTON_APP_ID, MSharedPreferencesUtils.getPhotonAppId());
            jSONObject.put("isAudioSettingsEnabled", MSharedPreferencesUtils.isUserAudioEnable());
            jSONObject.put(GameConstant.IS_QUIT_BY_ANDROID, isUnityCloseRequired());
            jSONObject.put(GameConstant.IS_PERMISSION_ACCEPTED, false);
            jSONObject.put(GameConstant.IS_LOCAL_VOICE_CHAT_MUTE, MSharedPreferencesUtils.getBooleanPref(Constant.IS_LOCAL_VOICE_CHAT_MUTED, false, false));
            jSONObject.put(GameConstant.IS_REMOTE_VOICE_CHAT_MUTE, MSharedPreferencesUtils.getBooleanPref(Constant.IS_REMOTE_VOICE_CHAT_MUTED, false, false));
            jSONObject.put(GameConstant.IS_VOICE_CHAT_REQUIRED, MSharedPreferencesUtils.isGameAudioRecordingFeatureEnabled());
            jSONObject.put(GameConstant.IS_VOICE_CHAT_REQUIRED_FOR_LOBBY, jSONObject.optBoolean("enableAudioChat", true));
            jSONObject.put(GameConstant.IS_VERIFIED_PROFILE, MSharedPreferencesUtils.isVerifiedProfile());
            jSONObject.put(GameConstant.GAME_IS_FTUE, getExtraInfoJSON(jSONObject).optBoolean("isFTUE", false));
            jSONObject.put(GameConstant.GAME_IS_CHALLENGE_ENABLED, MSharedPreferencesUtils.isChallengeEnabled());
            jSONObject.put(GameConstant.GAME_GUEST_USER, MSharedPreferencesUtils.getGuestUserLogin());
        } catch (Exception e2) {
            MLogger.e(TAG, "addExtraDataForCodeMergeGames: ", e2);
            StringBuilder sb = new StringBuilder();
            sb.append("addExtraDataForCodeMergeGames: ");
            showToast(GeneratedOutlineSupport.outline39(e2, sb));
        }
    }

    private void addExtraDataForThirdPartyGames(JSONObject jSONObject) {
        try {
            MLogger.d(TAG, "addExtraDataForThirdPartyGames: ");
            String accessUserToken = MSharedPreferencesUtils.getAccessUserToken();
            jSONObject.put("oAuthToken", accessUserToken);
            jSONObject.put("oAuth", accessUserToken);
            jSONObject.put(GameConstant.AUTH_TOKEN, accessUserToken);
            jSONObject.put("GameId", jSONObject.optInt("GameId", 0));
        } catch (Exception e2) {
            MLogger.e(TAG, "addExtraDataForThirdPartyGames: ", e2);
            StringBuilder sb = new StringBuilder();
            sb.append("addExtraDataForThirdPartyGames: ");
            showToast(GeneratedOutlineSupport.outline39(e2, sb));
        }
    }

    private void addProfileDataForCodeMergeGames(JSONObject jSONObject) {
        try {
            MLogger.d(TAG, "addProfileDataForCodeMergeGames: ");
            JSONObject jSONObject2 = new JSONObject();
            if (!MSharedPreferencesUtils.getGuestUserLogin()) {
                jSONObject2 = new JSONObject(MSharedPreferencesUtils.getUserBalance());
            }
            JSONObject jSONObject3 = new JSONObject(MSharedPreferencesUtils.getUserProfile());
            if (!MSharedPreferencesUtils.getGuestUserLogin()) {
                jSONObject3.put("BonusBalance", jSONObject2.optInt("bonusBalance"));
                jSONObject3.put("DepositBalance", jSONObject2.optInt("depositBalance"));
                jSONObject3.put("WithdrawableBalance", jSONObject2.optInt("withdrawableBalance"));
                jSONObject3.put("TotalBalance", jSONObject2.optInt("totalBalance"));
                jSONObject3.put("TokenBalance", jSONObject2.optInt("tokenBalance"));
                jSONObject.put("Balance", jSONObject2);
            }
            jSONObject3.put(GameConstant.IS_VERIFIED_PROFILE, MSharedPreferencesUtils.isVerifiedProfile());
            if (isUserNameEnabled() && !TextUtils.isEmpty(jSONObject3.optString("userName", ""))) {
                jSONObject3.put("displayName", jSONObject3.optString("userName", ""));
            }
            jSONObject.put("Profile", jSONObject3);
        } catch (Exception e2) {
            MLogger.e(TAG, "addProfileDataForCodeMergeGames: ", e2);
            StringBuilder sb = new StringBuilder();
            sb.append("addProfileDataForCodeMergeGames: ");
            showToast(GeneratedOutlineSupport.outline39(e2, sb));
        }
    }

    private void addProfileDataForThirdPartyGames(JSONObject jSONObject) {
        try {
            MLogger.d(TAG, "addProfileDataForThirdPartyGames: ");
            JSONObject jSONObject2 = new JSONObject(MSharedPreferencesUtils.getUserProfile());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("id", jSONObject2.optInt("id", 0));
            if (isUserNameEnabled()) {
                if (!TextUtils.isEmpty(jSONObject2.optString("userName", ""))) {
                    jSONObject3.put("displayName", jSONObject2.optString("userName", ""));
                    jSONObject3.put("avatar", jSONObject2.optString("avatar", ""));
                    jSONObject.put("Profile", jSONObject3);
                    jSONObject.put("userId", jSONObject2.optInt("id", 0));
                }
            }
            jSONObject3.put("displayName", jSONObject2.optString("displayName", ""));
            jSONObject3.put("avatar", jSONObject2.optString("avatar", ""));
            jSONObject.put("Profile", jSONObject3);
            jSONObject.put("userId", jSONObject2.optInt("id", 0));
        } catch (JSONException e2) {
            MLogger.e(TAG, "addProfileDataForThirdPartyGames: ", e2);
            showToast("addProfileDataForThirdPartyGames: " + e2.getMessage());
        }
    }

    private void addingThirdPartyExtraToGameObject(JSONObject jSONObject) {
        try {
            MLogger.d(TAG, "addingThirdPartyExtraToGameObject");
            if (jSONObject.has("gameConfig") && jSONObject.optJSONObject("gameConfig") != null) {
                JSONObject optJSONObject = jSONObject.optJSONObject("gameConfig");
                if (optJSONObject != null && optJSONObject.has("thirdPartyExtra")) {
                    String optString = optJSONObject.optString("thirdPartyExtra");
                    jSONObject.put("thirdPartyExtra", optString);
                    JSONObject jSONObject2 = new JSONObject(optString);
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        Object obj = jSONObject2.get(next);
                        jSONObject.put(next, obj);
                        MLogger.d(TAG, "launchGameAfterRecordingResult: ", next, obj);
                    }
                }
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "addingThirdPartyExtraToGameObject: ", e2);
            StringBuilder sb = new StringBuilder();
            sb.append("addingThirdPartyExtraToGameObject: ");
            showToast(GeneratedOutlineSupport.outline39(e2, sb));
        }
    }

    private void checkAssetsValidation(JSONObject jSONObject) {
        try {
            MLogger.d(TAG, "checkAssetsValidation: ");
            HashMap hashMap = new HashMap();
            long optLong = jSONObject.optLong("TournamentId", -990);
            int optInt = jSONObject.optInt("GameId", -999);
            hashMap.put("Game Id", String.valueOf(optInt));
            hashMap.put("Game Name", jSONObject.optString("GameName", "No Game Name Found"));
            hashMap.put(EventsConstants.USER_MOBILE_NUMBER, CountryUtils.getUniqueIdForThirdPartySDKs());
            hashMap.put(EventsConstants.PARAMS_TRIGGER_REASON, "Asset Bundle Mismatch");
            hashMap.put(EventsConstants.PARAMS_ACTION_TAKEN, "STOPPED");
            hashMap.put(EventsConstants.PARAMS_SOURCE, TAG);
            hashMap.put(EventsConstants.PARAMS_TOURNAMENT_ID, Long.valueOf(optLong));
            hashMap.put(EventsConstants.PARAMS_SESSION_ID, jSONObject.optString(TQConstants.SESSION_ID, "No Session Id Found"));
            hashMap.put("Start Time", String.valueOf(jSONObject.optLong(GameConstant.GAME_START_TIME, -998)));
            CleverTapAnalyticsUtils.sendEvent((String) Constant.EVENT_USER_GAME_FRAUD, hashMap);
            MLogger.d(Constant.ASSETS_CHECKING, "Assets are modified");
            if (GEInteractor.getInstance().deleteAssets(this.mContext, optInt) && AssetsConfigReader.listOfGameAssetsAvailableArray(this.mContext).contains(Integer.valueOf(optInt))) {
                GEInteractor.getInstance().initializeGameAssetsFirstTime(this.mContext, new RNListener() {
                    public boolean isHasRequiredPermission() {
                        return false;
                    }

                    public void publishResult(String str) {
                        MLogger.d(IntentHelper.TAG, "publishResult: ", str);
                    }
                });
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "checkAssetsValidation: ", e2);
        }
    }

    /* access modifiers changed from: private */
    public JSONObject getExtraInfoJSON(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            String optString = jSONObject.optString(BraintreeConstants.NS_EXTRAINFO, "");
            if (!TextUtils.isEmpty(optString)) {
                return new JSONObject(optString);
            }
            return jSONObject2;
        } catch (Exception e2) {
            MLogger.e(TAG, "getExtraInfoJSON: ", e2);
            StringBuilder sb = new StringBuilder();
            sb.append("getExtraInfoJSON: ");
            showToast(GeneratedOutlineSupport.outline39(e2, sb));
            return jSONObject2;
        }
    }

    private boolean isAdsEnabled(JSONObject jSONObject) {
        if (!ConfigManager.getPlatformConfig().optBoolean("game.inmobi.ads.enabled", false) || !getExtraInfoJSON(jSONObject).optBoolean("ads.enabledv2", false)) {
            return false;
        }
        return true;
    }

    private boolean isAnzuAdsEnable(JSONObject jSONObject) {
        if (!ConfigManager.getPlatformConfig().optBoolean("game.anzu.ads.enabled", false) || !getExtraInfoJSON(jSONObject).optBoolean("ads.anzu.enabledv2", false)) {
            return false;
        }
        return true;
    }

    private boolean isGameIsAlreadyRunning(int i) {
        MLogger.d(TAG, "isMultiLaunchGameCheckEnabled: ", "\nLaunching Game Id: ", Integer.valueOf(i), "\nMPLUnityPlayerActivity.active: ", Boolean.valueOf(GameRunningState.INSTANCE.getIS_GAME_RUNNING()));
        if (!isRunningGameCheckRequired(i) || !GameRunningState.INSTANCE.getIS_GAME_RUNNING()) {
            return false;
        }
        return true;
    }

    private boolean isKafkaEnabled() {
        if (ConfigManager.getKafkaConfig() == null || !ConfigManager.getKafkaConfig().optBoolean("enabledv1", false)) {
            return false;
        }
        return true;
    }

    private boolean isRunningGameCheckRequired(int i) {
        boolean z;
        if (ConfigManager.getPlatformConfig().optBoolean("game.multiple.tap.enabled", false)) {
            return true;
        }
        JSONArray optJSONArray = ConfigManager.getNormalConfig().optJSONArray("game.multiple.tab.disabled.gameids");
        int i2 = 0;
        while (true) {
            if (optJSONArray == null || i2 >= optJSONArray.length()) {
                z = false;
            } else if (optJSONArray.optInt(i2) == i) {
                this.mCheckingGameId = i;
                z = true;
                break;
            } else {
                i2++;
            }
        }
        z = false;
        MLogger.d(TAG, "isRunningGameCheckRequired", "\nGame Ids from Server: ", optJSONArray, "RequireCheck: ", Boolean.valueOf(z));
        return z;
    }

    public static boolean isUserNameEnabled() {
        boolean z;
        boolean optBoolean = ConfigManager.getHanselConfig().optBoolean(Config.HANSEL_KEY_PROFILE_USERNAME_SURFACE_ENABLED, false);
        try {
            if (!(ConfigManager.getNormalConfig() == null || ConfigManager.getNormalConfig().optJSONObject(Config.ZK_KEY_USER_NAME_ENABLED_KEY) == null)) {
                JSONObject optJSONObject = ConfigManager.getNormalConfig().optJSONObject(Config.ZK_KEY_USER_NAME_ENABLED_KEY);
                if (optJSONObject != null) {
                    z = optJSONObject.optBoolean("usernameEnabled", false);
                    if (!z && optBoolean) {
                        return true;
                    }
                }
            }
        } catch (Exception e2) {
            MLogger.d(TAG, e2.getMessage());
        }
        z = false;
        return !z ? false : false;
    }

    private boolean isWebRedirectGame(JSONObject jSONObject) {
        if (MSharedPreferencesUtils.getGamesWithoutAssetsDownload().contains(String.valueOf(jSONObject.optInt("GameId", 0))) || jSONObject.optBoolean("isRedirect", false)) {
            return true;
        }
        return false;
    }

    private void launchMultiTableUnityGame(String str, String str2, long j) {
        MLogger.d(TAG, "launchMultiTableUnityGame: ");
        try {
            JSONArray jSONArray = new JSONArray(str);
            JSONObject jSONObject = new JSONObject();
            if (jSONArray.length() > 0 && jSONArray.optJSONObject(0) != null) {
                int optInt = jSONArray.optJSONObject(0).optInt("GameId", 0);
                if (isGameIsAlreadyRunning(optInt)) {
                    MLogger.d(TAG, "launchMultiTableUnityGame Game launch is already in process");
                    return;
                }
                setGameIsAlreadyRunning(optInt, true);
                try {
                    JSONArray jSONArray2 = new JSONArray(str);
                    if (jSONArray2.length() > 0) {
                        sendEventLaunchStarted(((JSONObject) jSONArray2.get(0)).toString(), "");
                    }
                } catch (Exception unused) {
                    sendEventLaunchStarted(str, "Error while parcing the json");
                }
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                updateGameConfigData(jSONArray.optJSONObject(i));
            }
            JSONObject mergeJSON = CommonUtils.mergeJSON(jSONObject, jSONArray.optJSONObject(0));
            mergeJSON.put("multiTableConfig", jSONArray);
            mergeJSON.put("location", str2);
            launchUnityGame(mergeJSON.toString(), j);
        } catch (Exception e2) {
            Object[] objArr = new Object[2];
            objArr[0] = "Unable to lunch the game launchMultiTableUnityGame";
            objArr[1] = e2.getMessage() != null ? e2.getMessage() : "Launch fail";
            MLogger.e(TAG, objArr);
            StringBuilder sb = new StringBuilder();
            sb.append("launchMultiTableUnityGame: ");
            showToast(GeneratedOutlineSupport.outline39(e2, sb));
            sendEventLaunchStarted(str, e2.getMessage());
        }
    }

    private void launchUnityGame(String str, long j) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put(GameConstant.START_TIME_FROM_NATIVE, j);
            int optInt = jSONObject.optInt("GameId", 0);
            MLogger.d(TAG, Constant.GAME_LAUNCH_TAG, Integer.valueOf(optInt));
            if (AssetsUtils.isMergedAssetsAreDownloaded(optInt)) {
                this.hash = MSharedPreferencesUtils.getGameHashForGameId(CommonUtils.changeToBattleGameId(optInt));
            } else {
                this.hash = MSharedPreferencesUtils.getGameHashForGameId(optInt);
            }
            this.isAssetsDirectoryCheckEnabled = AssetsUtils.isAssetsDirectoryCheckEnabled();
            this.isAssetsDirFromGameEnabled = AssetsUtils.isAssetsDirectoryCheckFromGameEnabled();
            MSharedPreferencesUtils.setIsUserPlayingGame(true);
            removeNotificationForCurrentGameId(optInt);
            FirebaseCrashlytics.getInstance().setCustomKey((String) "playing_game_id", optInt);
            if (!isWebRedirectGame(jSONObject) && !MSharedPreferencesUtils.isGamesIdWithoutAssetsDownload(optInt) && !ConfigManager.shouldMatchInAndroid(optInt)) {
                if (!GEInteractor.isValidGameAssets(getReactApplicationContext().getApplicationContext(), optInt, false, this.hash, this.isAssetsDirectoryCheckEnabled)) {
                    checkAssetsValidation(jSONObject);
                }
            }
            MLogger.d(Constant.ASSETS_CHECKING, "Assets are valid");
            updateGameConfigData(jSONObject);
            startGame(jSONObject, new RedirectClass(jSONObject));
        } catch (Exception e2) {
            Object[] objArr = new Object[2];
            objArr[0] = "Unable to lunch the game launchUnityGame";
            objArr[1] = e2.getMessage() != null ? e2.getMessage() : "Launch fail";
            MLogger.e(TAG, objArr);
            showToast(Constant.GAME_LAUNCH_TAG + e2.getMessage());
        } finally {
            MLogger.d(TAG, "making isGameLaunchInProcess false");
        }
    }

    private Bundle prepareIntentBundleData(JSONObject jSONObject) {
        MLogger.i(TAG, "prepareIntentBundleData: ");
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty("")) {
            String optString = jSONObject.optString("GameName");
            String optString2 = jSONObject.optString(CtEventConstants.TOURNAMENT_NAME);
            int optInt = jSONObject.optInt("TournamentId");
            boolean optBoolean = jSONObject.optBoolean("IsSponsored");
            bundle.putLong(VideoRecordingConstants.VIDEO_RECORD_START_TIME, System.currentTimeMillis());
            bundle.putString("gameName", optString);
            bundle.putString(VideoRecordingConstants.TOURNAMENT_NAME, optString2);
            bundle.putInt("tournamentId", optInt);
            bundle.getBoolean(VideoRecordingConstants.IS_SPONSER_TOURNAMENT, optBoolean);
        }
        return bundle;
    }

    private void processAfterGameLaunch() {
        try {
            MLogger.d(TAG, "processAfterGameLaunch");
            VideoRecordingUtils.increaseUserPlayedGame(MPLApplication.getInstance());
            MSharedPreferencesUtils.saveBooleanInNormalPref(MPLApplication.getInstance(), Constant.IS_USER_PLAYED_GAME_V2, true);
            if (!MSharedPreferencesUtils.isGamePlayedBranchEventPushedV2() && VideoRecordingUtils.getTotalUserPlayedGame(MPLApplication.getInstance()) == 4) {
                MSharedPreferencesUtils.setGamePlayedBranchEventPushedV2(true);
                Util.pushBranchEventWithPropWithoutStandard(EventsConstants.RANKED_FETCHED);
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "processAfterGameLaunch: ", e2);
            StringBuilder sb = new StringBuilder();
            sb.append("processAfterGameLaunch: ");
            showToast(GeneratedOutlineSupport.outline39(e2, sb));
        }
    }

    private void removeExtraDataFromGameConfig(JSONObject jSONObject) {
        jSONObject.remove("redirectPackage");
        jSONObject.remove("redirectActivity");
        jSONObject.remove("gameInfoExtra");
        jSONObject.remove("redirectUrl");
        jSONObject.remove("redirectUrlV2");
        jSONObject.remove("redirectAuth");
    }

    private void removeNotificationForCurrentGameId(int i) {
        Context context = this.mContext;
        if (context != null) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.cancel(i);
            }
        }
    }

    private void sendWebLaunchEvent(JSONObject jSONObject) {
        String optString = jSONObject.optString("GameName", "");
        String optString2 = jSONObject.optString(CtEventConstants.TOURNAMENT_NAME, "");
        String optString3 = jSONObject.optString("redirectUrl", "");
        int optInt = jSONObject.optInt("TournamentId", 0);
        if (optInt == 0) {
            optInt = jSONObject.optInt("BattleId", 0);
        }
        boolean optBoolean = jSONObject.optBoolean("IsSponsored", false);
        HashMap outline87 = GeneratedOutlineSupport.outline87("Game Name", optString);
        outline87.put("App Start Time", Long.valueOf(System.currentTimeMillis()));
        outline87.put("Tournament Name", optString2);
        outline87.put(EventsConstants.PARAMS_TOURNAMENT_ID, Integer.valueOf(optInt));
        outline87.put("Is Sponsor", Boolean.valueOf(optBoolean));
        outline87.put("Redirect Url", optString3);
        outline87.put("Is Success", Boolean.valueOf(!TextUtils.isEmpty(optString3)));
        CleverTapAnalyticsUtils.sendWebAppOpenEvent(outline87);
    }

    private void setFrameRate(JSONObject jSONObject, JSONObject jSONObject2) {
        int i = 60;
        try {
            if (jSONObject2.has("game.frameRate")) {
                JSONObject optJSONObject = jSONObject2.optJSONObject("game.frameRate");
                String valueOf = String.valueOf(jSONObject.optInt("GameId", 0));
                if (optJSONObject != null && optJSONObject.has(valueOf)) {
                    i = optJSONObject.getInt(valueOf);
                }
                jSONObject.put(GameConstant.GAME_FRAME_RATE, i);
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "error in getting key: ", e2.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void setGameIsAlreadyRunning(int i, boolean z) {
        GameRunningState.INSTANCE.setIS_GAME_RUNNING(isRunningGameCheckRequired(i) && z);
    }

    private Intent setLaunchingIntentData(Intent intent, JSONObject jSONObject, Bundle bundle, RedirectClass redirectClass) {
        int optInt = jSONObject.optInt("GameId", 0);
        String optString = jSONObject.optString("GameName", "");
        boolean z = MSharedPreferencesUtils.getGamesWithoutAssetsDownload().contains(String.valueOf(optInt)) || jSONObject.optBoolean("isRedirect", false);
        intent.putExtra(GameConstant.IS_KAFKA_ENABLED, isKafkaEnabled());
        intent.putExtra(GameConstant.GAME_IS_SCREEN_SHARE_UI_DISABLED, ConfigManager.getPlatformConfig().optBoolean(GameConstant.GAME_IS_SCREEN_SHARE_UI_DISABLED, false));
        intent.putExtra(GameConstant.GAME_IS_SCREEN_SHARE_OPTION, ConfigManager.getNormalConfig().optString(GameConstant.GAME_IS_SCREEN_SHARE_OPTION, "default"));
        if (Util.isMPLSdkUsed(optInt) && !Util.shouldLaunchSameInstance(optInt)) {
            intent.addFlags(1140916224);
        }
        intent.putExtra("GameId", optInt);
        intent.putExtra("TournamentId", jSONObject.optInt("TournamentId", 0));
        intent.putExtra(GameConstant.IS_OVERLAY_DETECTION_REQUIRED, isOverlayDetectionRequired(optInt));
        intent.putExtra(GameConstant.IS_QUIT_BY_ANDROID, isUnityCloseRequired());
        intent.setData(Uri.parse(jSONObject.toString()));
        if (z) {
            intent.putExtra(RNConstant.EXTRA_WEB_LOAD_URL, redirectClass.getRedirectUrl());
            intent.putExtra(RNConstant.EXTRA_WEB_LOAD_HEADER, redirectClass.getRedirectAuthHeader());
            intent.putExtra("gameId", optInt);
            intent.putExtra("gameName", optString);
            intent.putExtra(RNConstant.EXTRA_USER_AUTH, MSharedPreferencesUtils.getAccessUserToken());
            if (Util.isTopQuiz(optInt)) {
                intent.putExtra(TQConstants.ENVIRONMENT, MBuildConfigUtils.getBuildFlavor().contains(BaseConstants.DEVELOPMENT) ? TQConstants.ENVIRONMENT_DEBUG : TQConstants.ENVIRONMENT_PROD);
                intent.putExtra(TQConstants.IS_SECURE, ConfigManager.getPlatformConfig().optBoolean(ConfigConstant.WEBVIEW_RECORDING_DISABLED, true));
            }
        } else if (ConfigManager.shouldMatchInAndroid(optInt) && !TextUtils.isEmpty(redirectClass.getRedirectPackage()) && !TextUtils.isEmpty(redirectClass.getRedirectActivity())) {
            intent.putExtra("redirectPackage", redirectClass.getRedirectPackage());
            intent.putExtra("redirectActivity", redirectClass.getRedirectActivity());
        }
        intent.putExtra(GameConstant.GAME_IS_ADS_ENABLED, isAdsEnabled(jSONObject));
        intent.putExtra(GameConstant.GAME_IS_ANZU_ADS_ENABLED, isAnzuAdsEnable(jSONObject));
        intent.putExtra(GameConstant.ASSETS_DIRECTORY_MATCH_ENABLED, this.isAssetsDirFromGameEnabled);
        intent.putExtra(GameConstant.ASSETS_DIRECTORY_HASH, this.hash);
        intent.putExtra(GameConstant.GAME_INTERNAL_USER, CommonUtils.isInternalUser());
        intent.putExtra(Constant.EXTRA_APPSFLYER_EVENT_FILTERING_STATUS, AppsflyerUtils.mAppsflyerEventFilteringEnabled);
        intent.putParcelableArrayListExtra(Constant.EXTRA_APPSFLYER_EVENT_FILTERING_LIST, (ArrayList) AppsflyerUtils.mAppsflyerWhitelistedEvents);
        intent.putExtras(bundle);
        try {
            jSONObject.put(GameConstant.PRE_PROCESS_TIME_FROM_NATIVE, System.currentTimeMillis() - jSONObject.optLong(GameConstant.START_TIME_FROM_NATIVE));
            jSONObject.put(GameConstant.PRE_PROCESS_END_TIME_FROM_NATIVE, System.currentTimeMillis());
        } catch (Exception e2) {
            MLogger.e(TAG, "setLaunchingIntentData: ", e2);
        }
        intent.putExtra((!z || Util.isTopQuiz(optInt)) ? "json_extra" : "postData", jSONObject.toString());
        return intent;
    }

    private void setUserLevelLogConfig(JSONObject jSONObject, JSONObject jSONObject2) {
        boolean z;
        try {
            int optInt = new JSONObject(MSharedPreferencesUtils.getUserProfile()).optInt("id", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("game.userLevelLoggerEnabled");
            int i = 0;
            while (true) {
                if (i >= (optJSONArray != null ? optJSONArray.length() : 0)) {
                    z = false;
                    break;
                } else if (optJSONArray.getInt(i) == optInt) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            jSONObject2.put(GameConstant.GAME_IS_USER_LEVEL_LOGGER_ENABLED, z);
        } catch (Exception e2) {
            MLogger.e(TAG, "error in getting key: ", e2.getMessage());
        }
    }

    private void showToast(String str) {
        if (getCurrentActivity() != null) {
            CommonUtils.showToast(getCurrentActivity(), MBuildConfigUtils.isLogEnabled(), str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x005a A[SYNTHETIC, Splitter:B:12:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x014e A[SYNTHETIC, Splitter:B:49:0x014e] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x017a A[Catch:{ Exception -> 0x01d0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void startGame(org.json.JSONObject r19, com.mpl.androidapp.react.modules.IntentHelper.RedirectClass r20) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            r2 = r20
            java.lang.String r3 = "gameId"
            java.lang.String r4 = "GameId"
            java.lang.String r5 = "startGame: "
            java.lang.String r6 = "IntentHelper"
            r7 = 2
            r8 = 1
            r9 = 0
            android.app.Activity r10 = r18.getCurrentActivity()     // Catch:{ Exception -> 0x01d0 }
            r18.removeExtraDataFromGameConfig(r19)     // Catch:{ Exception -> 0x01d0 }
            int r11 = r0.optInt(r4, r9)     // Catch:{ Exception -> 0x01d0 }
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x01d0 }
            r7[r9] = r5     // Catch:{ Exception -> 0x01d0 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r11)     // Catch:{ Exception -> 0x01d0 }
            r7[r8] = r12     // Catch:{ Exception -> 0x01d0 }
            com.mpl.androidapp.utils.MLogger.d(r6, r7)     // Catch:{ Exception -> 0x01d0 }
            java.util.HashSet r7 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getGamesWithoutAssetsDownload()     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r12 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x01d0 }
            boolean r7 = r7.contains(r12)     // Catch:{ Exception -> 0x01d0 }
            if (r7 != 0) goto L_0x0042
            java.lang.String r7 = "isRedirect"
            boolean r7 = r0.optBoolean(r7, r9)     // Catch:{ Exception -> 0x01d0 }
            if (r7 == 0) goto L_0x0040
            goto L_0x0042
        L_0x0040:
            r7 = 0
            goto L_0x0043
        L_0x0042:
            r7 = 1
        L_0x0043:
            java.lang.Class r9 = r1.getLaunchingActivityClassName(r0, r7)     // Catch:{ Exception -> 0x01d0 }
            android.os.Bundle r12 = r18.prepareIntentBundleData(r19)     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r13 = r20.getRedirectPackage()     // Catch:{ Exception -> 0x01d0 }
            boolean r13 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r14 = "GameStartTimeFromNative"
            java.lang.String r15 = "gameLaunchTime"
            r8 = 3
            if (r13 != 0) goto L_0x0146
            java.lang.String r13 = r20.getRedirectActivity()     // Catch:{ Exception -> 0x01d0 }
            boolean r13 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x01d0 }
            if (r13 != 0) goto L_0x0146
            boolean r13 = com.mpl.androidapp.config.ConfigManager.shouldMatchInAndroid(r11)     // Catch:{ Exception -> 0x01d0 }
            if (r13 != 0) goto L_0x0146
            com.google.gson.Gson r7 = new com.google.gson.Gson     // Catch:{ Exception -> 0x01d0 }
            r7.<init>()     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r9 = r19.toString()     // Catch:{ Exception -> 0x01d0 }
            java.lang.Class<com.mpl.androidapp.utils.ThirdPartyGameParamConstants> r13 = com.mpl.androidapp.utils.ThirdPartyGameParamConstants.class
            java.lang.Object r9 = r7.fromJson(r9, r13)     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r7 = r7.toJson(r9)     // Catch:{ Exception -> 0x01d0 }
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x01d0 }
            r9.<init>(r7)     // Catch:{ Exception -> 0x01d0 }
            boolean r7 = r9.has(r4)     // Catch:{ Exception -> 0x01d0 }
            if (r7 != 0) goto L_0x00a0
            boolean r7 = r9.has(r3)     // Catch:{ Exception -> 0x01d0 }
            if (r7 == 0) goto L_0x00a0
            int r3 = r9.optInt(r3)     // Catch:{ Exception -> 0x01d0 }
            r9.put(r4, r3)     // Catch:{ Exception -> 0x01d0 }
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r3 = "launchGameAfterRecordingResult:saving GameId "
            r7 = 0
            r4[r7] = r3     // Catch:{ Exception -> 0x01d0 }
            com.mpl.androidapp.utils.MLogger.d(r6, r4)     // Catch:{ Exception -> 0x01d0 }
        L_0x00a0:
            android.content.Intent r3 = new android.content.Intent     // Catch:{ Exception -> 0x01d0 }
            r3.<init>()     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r4 = com.mpl.androidapp.utils.Util.getPackageNameBasedOnGameId(r11)     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r7 = "com.mpl.poolchamps"
            boolean r4 = r4.equals(r7)     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r7 = "PoolLog"
            if (r4 == 0) goto L_0x00d5
            android.content.Intent r3 = new android.content.Intent     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r4 = "android.intent.action.VIEW"
            r3.<init>(r4)     // Catch:{ Exception -> 0x01d0 }
            r4 = 335577088(0x14008000, float:6.487592E-27)
            r3.addFlags(r4)     // Catch:{ Exception -> 0x01d0 }
            java.lang.Object[] r4 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x01d0 }
            r8 = 0
            r4[r8] = r7     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r7 = "Launching conditional pool champs with id "
            r8 = 1
            r4[r8] = r7     // Catch:{ Exception -> 0x01d0 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r11)     // Catch:{ Exception -> 0x01d0 }
            r8 = 2
            r4[r8] = r7     // Catch:{ Exception -> 0x01d0 }
            com.mpl.androidapp.utils.MLogger.d(r6, r4)     // Catch:{ Exception -> 0x01d0 }
            goto L_0x00e3
        L_0x00d5:
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x01d0 }
            r8 = 0
            r4[r8] = r7     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r7 = "Launching other games"
            r8 = 1
            r4[r8] = r7     // Catch:{ Exception -> 0x01d0 }
            com.mpl.androidapp.utils.MLogger.d(r6, r4)     // Catch:{ Exception -> 0x01d0 }
        L_0x00e3:
            android.content.ComponentName r4 = new android.content.ComponentName     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r7 = r20.getRedirectPackage()     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r8 = r20.getRedirectActivity()     // Catch:{ Exception -> 0x01d0 }
            r4.<init>(r7, r8)     // Catch:{ Exception -> 0x01d0 }
            r3.setComponent(r4)     // Catch:{ Exception -> 0x01d0 }
            r1.setLaunchingIntentData(r3, r9, r12, r2)     // Catch:{ Exception -> 0x01d0 }
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0143 }
            r4 = 0
            r2[r4] = r15     // Catch:{ Exception -> 0x01d0 }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x01d0 }
            long r12 = r0.optLong(r14)     // Catch:{ Exception -> 0x01d0 }
            long r7 = r7 - r12
            java.lang.Long r0 = java.lang.Long.valueOf(r7)     // Catch:{ Exception -> 0x01d0 }
            r4 = 1
            r2[r4] = r0     // Catch:{ Exception -> 0x01d0 }
            com.mpl.androidapp.utils.MLogger.d(r6, r2)     // Catch:{ Exception -> 0x01d0 }
            boolean r0 = com.mpl.androidapp.utils.Util.isMPLSdkUsed(r11)     // Catch:{ Exception -> 0x01d0 }
            if (r0 != 0) goto L_0x012c
            boolean r0 = com.mpl.androidapp.utils.Util.shouldLaunchSameInstance(r11)     // Catch:{ Exception -> 0x01d0 }
            if (r0 == 0) goto L_0x011c
            goto L_0x012c
        L_0x011c:
            if (r10 == 0) goto L_0x0123
            r10.startActivity(r3)     // Catch:{ Exception -> 0x01d0 }
            goto L_0x01ec
        L_0x0123:
            com.facebook.react.bridge.ReactApplicationContext r0 = r18.getReactApplicationContext()     // Catch:{ Exception -> 0x01d0 }
            r0.startActivity(r3)     // Catch:{ Exception -> 0x01d0 }
            goto L_0x01ec
        L_0x012c:
            r0 = 4322(0x10e2, float:6.056E-42)
            if (r10 == 0) goto L_0x0135
            r10.startActivityForResult(r3, r0)     // Catch:{ Exception -> 0x01d0 }
            goto L_0x01ec
        L_0x0135:
            com.facebook.react.bridge.ReactApplicationContext r2 = r18.getReactApplicationContext()     // Catch:{ Exception -> 0x01d0 }
            android.os.Bundle r4 = new android.os.Bundle     // Catch:{ Exception -> 0x01d0 }
            r4.<init>()     // Catch:{ Exception -> 0x01d0 }
            r2.startActivityForResult(r3, r0, r4)     // Catch:{ Exception -> 0x01d0 }
            goto L_0x01ec
        L_0x0143:
            r0 = move-exception
            goto L_0x01d2
        L_0x0146:
            r3 = 1002(0x3ea, float:1.404E-42)
            java.lang.String r4 = "PreProcessTimeFromNative"
            java.lang.String r11 = "Time taken in pre processing game config"
            if (r10 == 0) goto L_0x017a
            android.content.Intent r13 = new android.content.Intent     // Catch:{ Exception -> 0x01d0 }
            r13.<init>(r10, r9)     // Catch:{ Exception -> 0x01d0 }
            r1.setLaunchingIntentData(r13, r0, r12, r2)     // Catch:{ Exception -> 0x01d0 }
            java.lang.Object[] r2 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x01d0 }
            r8 = 0
            r2[r8] = r15     // Catch:{ Exception -> 0x01d0 }
            r8 = 1
            r2[r8] = r11     // Catch:{ Exception -> 0x01d0 }
            long r8 = r0.optLong(r4)     // Catch:{ Exception -> 0x01d0 }
            java.lang.Long r4 = java.lang.Long.valueOf(r8)     // Catch:{ Exception -> 0x01d0 }
            r8 = 2
            r2[r8] = r4     // Catch:{ Exception -> 0x01d0 }
            com.mpl.androidapp.utils.MLogger.d(r6, r2)     // Catch:{ Exception -> 0x01d0 }
            if (r7 == 0) goto L_0x0176
            r18.sendWebLaunchEvent(r19)     // Catch:{ Exception -> 0x01d0 }
            r10.startActivityForResult(r13, r3)     // Catch:{ Exception -> 0x01d0 }
            goto L_0x01ec
        L_0x0176:
            r10.startActivity(r13)     // Catch:{ Exception -> 0x01d0 }
            goto L_0x01ec
        L_0x017a:
            android.content.Intent r10 = new android.content.Intent     // Catch:{ Exception -> 0x01d0 }
            com.facebook.react.bridge.ReactApplicationContext r13 = r18.getReactApplicationContext()     // Catch:{ Exception -> 0x01d0 }
            r10.<init>(r13, r9)     // Catch:{ Exception -> 0x01d0 }
            r1.setLaunchingIntentData(r10, r0, r12, r2)     // Catch:{ Exception -> 0x01d0 }
            java.lang.Object[] r2 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x01d0 }
            r9 = 0
            r2[r9] = r15     // Catch:{ Exception -> 0x01d0 }
            r9 = 1
            r2[r9] = r11     // Catch:{ Exception -> 0x01d0 }
            long r16 = r0.optLong(r4)     // Catch:{ Exception -> 0x01d0 }
            java.lang.Long r4 = java.lang.Long.valueOf(r16)     // Catch:{ Exception -> 0x01d0 }
            r9 = 2
            r2[r9] = r4     // Catch:{ Exception -> 0x01d0 }
            com.mpl.androidapp.utils.MLogger.d(r6, r2)     // Catch:{ Exception -> 0x01d0 }
            java.lang.Object[] r2 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x01d0 }
            r4 = 0
            r2[r4] = r15     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r4 = "Time taken in from play button click"
            r8 = 1
            r2[r8] = r4     // Catch:{ Exception -> 0x01d0 }
            long r8 = r0.optLong(r14)     // Catch:{ Exception -> 0x01d0 }
            java.lang.String r4 = "gameLaunchTimeStamp"
            long r13 = r0.optLong(r4)     // Catch:{ Exception -> 0x01d0 }
            long r8 = r8 - r13
            java.lang.Long r4 = java.lang.Long.valueOf(r8)     // Catch:{ Exception -> 0x01d0 }
            r8 = 2
            r2[r8] = r4     // Catch:{ Exception -> 0x01d0 }
            com.mpl.androidapp.utils.MLogger.d(r6, r2)     // Catch:{ Exception -> 0x01d0 }
            if (r7 == 0) goto L_0x01c8
            r18.sendWebLaunchEvent(r19)     // Catch:{ Exception -> 0x01d0 }
            com.facebook.react.bridge.ReactApplicationContext r0 = r18.getReactApplicationContext()     // Catch:{ Exception -> 0x01d0 }
            r0.startActivityForResult(r10, r3, r12)     // Catch:{ Exception -> 0x01d0 }
            goto L_0x01ec
        L_0x01c8:
            com.facebook.react.bridge.ReactApplicationContext r0 = r18.getReactApplicationContext()     // Catch:{ Exception -> 0x01d0 }
            r0.startActivity(r10)     // Catch:{ Exception -> 0x01d0 }
            goto L_0x01ec
        L_0x01d0:
            r0 = move-exception
            r2 = 2
        L_0x01d2:
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r5
            r3 = 1
            r2[r3] = r0
            com.mpl.androidapp.utils.MLogger.e(r6, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline39(r0, r2)
            r1.showToast(r0)
        L_0x01ec:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.react.modules.IntentHelper.startGame(org.json.JSONObject, com.mpl.androidapp.react.modules.IntentHelper$RedirectClass):void");
    }

    private void universalUnityKeyMappings(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            if (jSONObject2.has("game.unityConfigs")) {
                JSONObject optJSONObject = jSONObject2.optJSONObject("game.unityConfigs");
                if (optJSONObject != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        Object obj = optJSONObject.get(next);
                        if (obj instanceof String) {
                            jSONObject.put(next, optJSONObject.optString(next, ""));
                        } else if (obj instanceof Integer) {
                            jSONObject.put(next, optJSONObject.optInt(next, 0));
                        } else if (obj instanceof Boolean) {
                            jSONObject.put(next, optJSONObject.optBoolean(next, false));
                        } else if (obj instanceof Double) {
                            jSONObject.put(next, optJSONObject.optDouble(next, 0.0d));
                        } else if (obj instanceof JSONObject) {
                            jSONObject.put(next, optJSONObject.optJSONObject(next));
                        } else if (obj instanceof JSONArray) {
                            jSONObject.put(next, optJSONObject.optJSONArray(next));
                        }
                    }
                }
            }
        } catch (Exception e2) {
            String message = e2.getMessage();
            MLogger.e(TAG, "error in unityConfig parsing: ", message);
            showToast("error in unityConfig parsing: " + message);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0065 A[SYNTHETIC, Splitter:B:14:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0079 A[Catch:{ Exception -> 0x0081 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateGameConfigData(org.json.JSONObject r12) {
        /*
            r11 = this;
            java.lang.String r0 = "IntentHelper"
            java.lang.String r1 = "updateGameConfigData: "
            r2 = 1
            r3 = 2
            r4 = 0
            java.lang.String r5 = "GameId"
            int r5 = r12.optInt(r5, r4)     // Catch:{ Exception -> 0x0081 }
            java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0081 }
            r6[r4] = r1     // Catch:{ Exception -> 0x0081 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0081 }
            r6[r2] = r7     // Catch:{ Exception -> 0x0081 }
            com.mpl.androidapp.utils.MLogger.d(r0, r6)     // Catch:{ Exception -> 0x0081 }
            r11.addConfigFromExtraInfo(r12)     // Catch:{ Exception -> 0x0081 }
            r11.addingThirdPartyExtraToGameObject(r12)     // Catch:{ Exception -> 0x0081 }
            android.content.Context r6 = r11.mContext     // Catch:{ Exception -> 0x0081 }
            com.mpl.androidapp.utils.MSharedPreferencesUtils.increaseGamePlayedForGameID(r6, r5)     // Catch:{ Exception -> 0x0081 }
            com.mpl.androidapp.utils.MSharedPreferencesUtils.putOrUpdateGamePlayedTime(r5)     // Catch:{ Exception -> 0x0081 }
            boolean r6 = r11.isWebRedirectGame(r12)     // Catch:{ Exception -> 0x0081 }
            if (r6 != 0) goto L_0x0042
            boolean r6 = com.mpl.androidapp.utils.Util.isThirdPartyGame(r5)     // Catch:{ Exception -> 0x0081 }
            if (r6 == 0) goto L_0x003b
            boolean r6 = com.mpl.androidapp.config.ConfigManager.shouldMatchInAndroid(r5)     // Catch:{ Exception -> 0x0081 }
            if (r6 != 0) goto L_0x003b
            goto L_0x0042
        L_0x003b:
            r11.addProfileDataForCodeMergeGames(r12)     // Catch:{ Exception -> 0x0081 }
            r11.addExtraDataForCodeMergeGames(r12)     // Catch:{ Exception -> 0x0081 }
            goto L_0x0048
        L_0x0042:
            r11.addProfileDataForThirdPartyGames(r12)     // Catch:{ Exception -> 0x0081 }
            r11.addExtraDataForThirdPartyGames(r12)     // Catch:{ Exception -> 0x0081 }
        L_0x0048:
            r11.updateZKNormalConfigs(r12)     // Catch:{ Exception -> 0x0081 }
            r11.updateZKPlatformConfigs(r12)     // Catch:{ Exception -> 0x0081 }
            r11.updateHanselConfig(r12)     // Catch:{ Exception -> 0x0081 }
            r11.addCommonParamsForAllGames(r12)     // Catch:{ Exception -> 0x0081 }
            com.mpl.androidapp.react.modules.IntentHelper$RedirectClass r6 = new com.mpl.androidapp.react.modules.IntentHelper$RedirectClass     // Catch:{ Exception -> 0x0081 }
            r6.<init>(r12)     // Catch:{ Exception -> 0x0081 }
            java.lang.String r7 = r6.getRedirectPackage()     // Catch:{ Exception -> 0x0081 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0081 }
            java.lang.String r8 = "InstalledApkVersionCode"
            if (r7 != 0) goto L_0x0079
            android.content.Context r5 = r11.mContext     // Catch:{ Exception -> 0x0081 }
            java.lang.String r6 = r6.getRedirectPackage()     // Catch:{ Exception -> 0x0081 }
            long r5 = com.mpl.androidapp.utils.Util.getInstalledApkVersion(r5, r6)     // Catch:{ Exception -> 0x0081 }
            r9 = 0
            int r7 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r7 <= 0) goto L_0x009a
            r12.put(r8, r5)     // Catch:{ Exception -> 0x0081 }
            goto L_0x009a
        L_0x0079:
            int r5 = com.mpl.androidapp.utils.AssetsUtils.getGameVersion(r5)     // Catch:{ Exception -> 0x0081 }
            r12.put(r8, r5)     // Catch:{ Exception -> 0x0081 }
            goto L_0x009a
        L_0x0081:
            r12 = move-exception
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r4] = r1
            r3[r2] = r12
            com.mpl.androidapp.utils.MLogger.e(r0, r3)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            java.lang.String r12 = com.android.tools.r8.GeneratedOutlineSupport.outline39(r12, r0)
            r11.showToast(r12)
        L_0x009a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.react.modules.IntentHelper.updateGameConfigData(org.json.JSONObject):void");
    }

    private void updateHanselConfig(JSONObject jSONObject) {
        try {
            JSONObject hanselConfig = ConfigManager.getHanselConfig();
            if (hanselConfig != null) {
                jSONObject.put(GameConstant.GAME_COLLECTIBLE_HANSEL, hanselConfig.optBoolean("game_collectable_enabled", false));
                jSONObject.put(GameConstant.GAME_STREAK_ON_HANSEL, hanselConfig.optBoolean("game_streak_on_hansel", false));
                jSONObject.put(GameConstant.RANDOMIZER_ON_HANSEL, hanselConfig.optBoolean("game_randomiser_enabled", true));
                jSONObject.put(GameConstant.GAME_IN_APPSHARE_HANSEL, hanselConfig.optBoolean("game_in_appshare_enabled", false));
                jSONObject.put(GameConstant.IS_PRACTICE_HANSEL_ENABLED, hanselConfig.optBoolean("game_practice_enabled", false));
                jSONObject.put(GameConstant.GAME_REPLAY_SURFACE_ENABLED, hanselConfig.optBoolean("game_replay_surface_enabled", false));
                jSONObject.put(GameConstant.GAME_STATS_ON_HANSEL, hanselConfig.optBoolean("game_stats_on_hansel", false));
                jSONObject.put(GameConstant.MINI_PROFILE_ON_HANSEL, hanselConfig.optBoolean("mini_profile_on_hansel", false));
                boolean optBoolean = jSONObject.optBoolean("isScoreMetricsFeatureRequired", false);
                MLogger.d(TAG, "updateHanselConfig:isScoreMetricsFeatureRequired before hansel config ", Boolean.valueOf(optBoolean));
                if (optBoolean) {
                    boolean optBoolean2 = hanselConfig.optBoolean("game_score_metrics_enabled", false);
                    MLogger.d(TAG, "updateHanselConfig: isScoreMetricsFeatureRequiredHansel after hansel config:", Boolean.valueOf(optBoolean2));
                    jSONObject.put("isScoreMetricsFeatureRequired", optBoolean2);
                }
                jSONObject.put("isBroadcastFeatureEnabled", hanselConfig.optBoolean(Config.HANSEL_KEY_FEATURE_ENABLED, false));
                jSONObject.put(GameConstant.GAME_IS_REALITY_CHECK_ENABLED, HanselConfigs.getBoolean("reality_check_enabled", false));
                jSONObject.put(GameConstant.GAME_IS_INTRACTIVE_FTUE_ENABLED, true);
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "updateHanselConfig: ", e2);
            StringBuilder sb = new StringBuilder();
            sb.append("updateHanselConfig: ");
            showToast(GeneratedOutlineSupport.outline39(e2, sb));
        }
    }

    private void updateZKNormalConfigs(JSONObject jSONObject) {
        String str;
        boolean z;
        boolean z2;
        JSONObject jSONObject2 = jSONObject;
        String str2 = GameConstant.IS_INTERACTIVE_FTUE_CROSS_BUTTON_MM;
        String str3 = GameConstant.GAME_IS_SCREEN_SHARE_OPTION;
        String str4 = TAG;
        String str5 = GameConstant.GAME_REPLAY_CONFIG;
        try {
            int optInt = jSONObject2.optInt("GameId", 0);
            JSONObject normalConfig = ConfigManager.getNormalConfig();
            if (normalConfig != null) {
                setFrameRate(jSONObject2, normalConfig);
                setUserLevelLogConfig(normalConfig, jSONObject2);
                setUserLevelLogConfig(normalConfig, jSONObject2);
                if (normalConfig.has(GameConstant.IS_DLL_BASED_GAME)) {
                    jSONObject2.put(GameConstant.IS_DLL_BASED_GAME, normalConfig.optBoolean(GameConstant.IS_DLL_BASED_GAME, false));
                }
                if (normalConfig.has(GameConstant.DLL_NAME)) {
                    jSONObject2.put(GameConstant.DLL_NAME, normalConfig.optString(GameConstant.DLL_NAME, ""));
                }
                if (normalConfig.has(GameConstant.POKER_PUZZLE_CONFIG)) {
                    jSONObject2.put(GameConstant.POKER_PUZZLE_CONFIG, normalConfig.optJSONObject(GameConstant.POKER_PUZZLE_CONFIG));
                }
                if (normalConfig.has(Config.ZK_KEY_USER_NAME_ENABLED_KEY) && normalConfig.optJSONObject(Config.ZK_KEY_USER_NAME_ENABLED_KEY) != null) {
                    jSONObject2.put(GameConstant.IS_UNITY_MINI_PROFILE_ENABLED, normalConfig.optJSONObject(Config.ZK_KEY_USER_NAME_ENABLED_KEY).optBoolean("isUnityMiniProfileEnabled", false));
                }
                if (normalConfig.has("game.fraud.warning.message")) {
                    jSONObject2.put(GameConstant.GAME_FRAUD_WARNING_MESSAGE, normalConfig.optString("game.fraud.warning.message", ""));
                }
                if (normalConfig.has("game.fraud.block.message")) {
                    jSONObject2.put(GameConstant.GAME_FRAUD_BLOCK_MESSAGE, normalConfig.optString("game.fraud.block.message", ""));
                }
                if (normalConfig.has("game.fraud.developer.disabled.gameIds")) {
                    jSONObject2.put(GameConstant.GAME_FRAUD_DEVELOPER_OPTION_DISABLED_GAME_IDs, normalConfig.optJSONArray("game.fraud.developer.disabled.gameIds"));
                }
                if (normalConfig.has("game.history.replay.gameIds")) {
                    jSONObject2.put(GameConstant.GAME_HISTORY_REPLAY_GAME_ID_S, normalConfig.optJSONArray("game.history.replay.gameIds"));
                }
                if (normalConfig.has("game.nudge.percentage")) {
                    jSONObject2.put(GameConstant.GAME_NUDGE_PERCENTAGE, normalConfig.optInt("game.nudge.percentage"));
                }
                if (normalConfig.has("game.guest.max.gameplay")) {
                    jSONObject2.put(GameConstant.GAME_GUEST_USER_GAMEPLAY, normalConfig.optInt("game.guest.max.gameplay", 2));
                }
                if (normalConfig.has("game.masking.gameIds")) {
                    jSONObject2.put(GameConstant.GAME_MASKING_GAME_IDS, normalConfig.optJSONArray("game.masking.gameIds"));
                }
                if (normalConfig.has(GameConstant.RESULT_SCREEN_IMPROVEMENT_CONFIGS)) {
                    jSONObject2.put(GameConstant.RESULT_SCREEN_IMPROVEMENT_CONFIGS, normalConfig.optJSONObject(GameConstant.RESULT_SCREEN_IMPROVEMENT_CONFIGS));
                }
                if (normalConfig.has("game.isUsingOldRngAlgoIDs")) {
                    JSONArray optJSONArray = normalConfig.optJSONArray("game.isUsingOldRngAlgoIDs");
                    int i = 0;
                    while (true) {
                        if (i >= (optJSONArray != null ? optJSONArray.length() : 0)) {
                            z2 = false;
                            break;
                        } else if (optJSONArray.optInt(i) == optInt) {
                            z2 = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                    jSONObject2.put(GameConstant.GAME_IS_USING_NEW_RNG_ALGO_IDS, z2);
                }
                String str6 = str5;
                if (!normalConfig.has(str6) || normalConfig.optJSONObject(str6) == null) {
                    String str7 = str4;
                } else {
                    JSONObject optJSONObject = normalConfig.optJSONObject(str6);
                    GameReplayConfigModel gameReplayConfigModel = (GameReplayConfigModel) new Gson().fromJson(optJSONObject.toString(), GameReplayConfigModel.class);
                    Iterator<String> keys = optJSONObject.keys();
                    Iterator<String> it = null;
                    if ((TextUtils.isEmpty(Build.BRAND) || gameReplayConfigModel.getBlackListedManufacturer() == null || !gameReplayConfigModel.getBlackListedManufacturer().contains(Build.BRAND.toLowerCase(Locale.ROOT))) && (TextUtils.isEmpty(Build.MODEL) || gameReplayConfigModel.getBlackListedModel() == null || !gameReplayConfigModel.getBlackListedModel().contains(Build.MODEL.toLowerCase(Locale.ROOT)))) {
                        str = str4;
                    } else {
                        str = str4;
                        try {
                            MLogger.d(str, "launchGameAfterRecordingResult:gameReplay is disabled due to make or mode restriction");
                            keys = null;
                        } catch (Exception e2) {
                            e = e2;
                            MLogger.e(str, "updateZKConfigs: ", e);
                            StringBuilder sb = new StringBuilder();
                            sb.append("updateZKConfigs: ");
                            showToast(GeneratedOutlineSupport.outline39(e, sb));
                        }
                    }
                    if (!CommonUtils.isMinRamSupportedForGameReplay(gameReplayConfigModel)) {
                        MLogger.d(str, "launchGameAfterRecordingResult:gameReplay is disabled due to Min RAM support");
                        keys = null;
                    }
                    if (!CommonUtils.isAvailableRamSupportedForGameReplay(gameReplayConfigModel)) {
                        MLogger.d(str, "launchGameAfterRecordingResult:gameReplay is disabled due to Available RAM");
                    } else {
                        it = keys;
                    }
                    while (it != null && it.hasNext()) {
                        String next = it.next();
                        Object obj = optJSONObject.get(next);
                        jSONObject2.put(next, obj);
                        MLogger.d(str, "launchGameAfterRecordingResult:gameReplay ", next, obj);
                    }
                }
                String str8 = str3;
                if (normalConfig.has(str8)) {
                    jSONObject2.put(str8, normalConfig.optString(str8, "default"));
                }
                jSONObject2.put(GameConstant.GAME_RECONNECTION_MM_TIME, normalConfig.optInt("game.reconnection.mm.time", 10));
                jSONObject2.put(GameConstant.GAME_IS_SFS_FAILURE_ATTEMPTS, normalConfig.optInt("game.sfs.failure.attempts", 0));
                jSONObject2.put(GameConstant.GAME_IS_AUTH_FAILURE_ATTEMPTS, normalConfig.optInt("game.auth.failure.attempts", 10));
                jSONObject2.put(GameConstant.GAME_IS_CLOSEBUTTON_ENABLED, normalConfig.optBoolean("game.close.button.enabled", false));
                jSONObject2.put(GameConstant.GAME_REALITY_CHECK_SESSIONS, normalConfig.optDouble("game.reality.check.session", 0.0d));
                jSONObject2.put(GameConstant.GAME_REALITY_CHECK_TIMER_DURATION, normalConfig.optDouble("game.reality.check.timer.duration", 0.0d));
                jSONObject2.put(GameConstant.GAME_FRAUD_CHECK_ENABLED_FOR_GAME_ID, normalConfig.optJSONArray("fraudCheckEnabledGameIdList"));
                if (normalConfig.has("game.loggerEnabled")) {
                    JSONArray optJSONArray2 = normalConfig.optJSONArray("game.loggerEnabled");
                    int i2 = 0;
                    while (true) {
                        if (i2 >= (optJSONArray2 != null ? optJSONArray2.length() : 0)) {
                            z = false;
                            break;
                        } else if (optJSONArray2.getInt(i2) == optInt) {
                            z = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    jSONObject2.put(GameConstant.GAME_IS_LOGGER_ENABLED, z);
                }
                String str9 = str2;
                if (normalConfig.has(str9)) {
                    jSONObject2.put(str9, normalConfig.optBoolean(str9));
                }
                if (normalConfig.has("unity.constants.sockTimeout")) {
                    jSONObject2.put(GameConstant.UNITY_SOCKET_TIMEOUT, normalConfig.optInt("unity.constants.sockTimeout"));
                }
                if (normalConfig.has("unity.constants.socketPingInterval")) {
                    jSONObject2.put(GameConstant.UNITY_SOCKET_PING_INTERVAL, normalConfig.optInt("unity.constants.socketPingInterval"));
                }
                if (normalConfig.has("unity.constants.socketPongWaitInterval")) {
                    jSONObject2.put(GameConstant.UNITY_SOCKET_PONG_WAIT_INTERVAL, normalConfig.optInt("unity.constants.socketPongWaitInterval"));
                }
                if (normalConfig.has("unity.constants.socketMaxPongDelay")) {
                    jSONObject2.put(GameConstant.UNITY_SOCKET_MAX_PONG_INTERVAL, normalConfig.optInt("unity.constants.socketMaxPongDelay"));
                }
            }
        } catch (Exception e3) {
            e = e3;
            str = str4;
            MLogger.e(str, "updateZKConfigs: ", e);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("updateZKConfigs: ");
            showToast(GeneratedOutlineSupport.outline39(e, sb2));
        }
    }

    private void updateZKPlatformConfigs(JSONObject jSONObject) {
        boolean z;
        try {
            JSONObject platformConfig = ConfigManager.getPlatformConfig();
            int optInt = jSONObject.optInt("GameId", 0);
            if (platformConfig != null) {
                universalUnityKeyMappings(jSONObject, platformConfig);
                try {
                    JSONArray optJSONArray = platformConfig.optJSONArray("game.BoardMMEnabled");
                    int i = 0;
                    while (true) {
                        if (i >= (optJSONArray != null ? optJSONArray.length() : 0)) {
                            z = false;
                            break;
                        } else if (optJSONArray.getInt(i) == optInt) {
                            z = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                    jSONObject.put(GameConstant.GAME_IS_LUDO_TABLE_MM_ENABLED, z);
                } catch (Exception e2) {
                    MLogger.e(TAG, "error in getting key: ", e2.getMessage());
                }
                jSONObject.put(GameConstant.UNITY_GLOBAL_MM_ENABLED, platformConfig.optBoolean(GameConstant.UNITY_GLOBAL_MM_ENABLED, false));
                jSONObject.put(GameConstant.UNITY_KEY_IS_UNITY_CRASH_FEATURE_ENABLED, InvokeMplFeatures.INSTANCE.isUnityCrashFeatureEnabled(this.mContext));
                jSONObject.put(GameConstant.ENABLE_GAME_FESTIVE_THEME, platformConfig.optBoolean("game.festiveTheme2022", false));
                jSONObject.put(GameConstant.ENABLE_BATTLE_DATA_SUBMISSION_RETRY_LOGIC, platformConfig.optBoolean("game.enableBattleDataSubmissionRetryLogic", false));
                jSONObject.put(GameConstant.GAME_SCENE_ASYNC, platformConfig.optBoolean("game.loadSceneSynchronously", false));
                jSONObject.put(GameConstant.GAME_UNITY_UID, platformConfig.optBoolean(GameConstant.GAME_UNITY_UID, false));
                jSONObject.put(GameConstant.IS_MM_SOUND_ENABLED, platformConfig.optBoolean("game.isMMSoundEnabled", true));
                jSONObject.put(GameConstant.GAME_FRAUD_DEVELOPER_OPTION_ENABLED, platformConfig.optBoolean("game.fraud.developer.enabled", false));
                jSONObject.put(GameConstant.GAME_FRAUD_MAGNIFICATION_CHECK_ENABLED, platformConfig.optBoolean("game.fraud.magnification.enabled", false));
                jSONObject.put(GameConstant.GAME_SCORE_GAME_PLAY_SYNC_FIX, platformConfig.optBoolean("game.scoreGamePlaySyncFix", false));
                jSONObject.put(GameConstant.GAME_SCORE_GAME_PLAY_SYNC_SYNC, platformConfig.optBoolean("game.isScoreGamePlaySync", false));
                jSONObject.put(GameConstant.GAME_IS_BATTLE_FINISH_SYNC, platformConfig.optBoolean("game.isBattleFinishSync", false));
                jSONObject.put(GameConstant.GAME_IS_BALANCE_CHECK_API_CALL, platformConfig.optBoolean("game.isBalanceCheckApiCall", false));
                jSONObject.put(GameConstant.GAME_IS_ON_READY_ENABLED, platformConfig.optBoolean("game.isOnReadyEnabled", false));
                jSONObject.put(GameConstant.GAME_SCORE_RESULT_SYNC_FIX, platformConfig.optBoolean("game.scoreResultSyncFix", false));
                jSONObject.put(GameConstant.GAME_NEW_DISCONNECTION_RULES, platformConfig.optBoolean("game.newDisconnetionRules", false));
                jSONObject.put(GameConstant.GAME_SHOW_REFUND_POP_UP, platformConfig.optBoolean("game.refund.popup.show", false));
                jSONObject.put(GameConstant.GAME_PING_CHECK_ENABLED, platformConfig.optBoolean("game.ping.check.enabled", false));
                jSONObject.put(GameConstant.GAME_SHOW_MINIMISE_POP_UP_ENABLED, platformConfig.optBoolean("game.minimise.popup.enabled", false));
                jSONObject.put(GameConstant.GAME_TRAIL_ENABLE, platformConfig.optBoolean("game.collectible.trial.enabled", false));
                jSONObject.put(GameConstant.GAME_FESTIVE_THEME_ON, platformConfig.optBoolean("game.festivenew.theme.enabled", false));
                jSONObject.put(GameConstant.GAME_NEW_THIRD_PARTY_FLOW_ENABLED, platformConfig.optBoolean("game.use.third.party.flow.enabled", false));
                jSONObject.put(GameConstant.GAME_IS_CLOSE_BUTTON_ACTIVE, platformConfig.optBoolean("game.close.button.enabled", false));
                jSONObject.put(GameConstant.GAME_IS_MASKING_ENABLED, platformConfig.optBoolean("game.masking.enabled", false));
                jSONObject.put(GameConstant.GAME_IS_USING_NEW_RNG_ALGO, platformConfig.optBoolean("game.isUsingNewRngAlgo", false));
                jSONObject.put(GameConstant.GAME_PAUSE_NOTIFICATION_ENABLED, platformConfig.optBoolean("game.pause.notification.enabled", false));
                jSONObject.put(GameConstant.GAME_IS_REFRESH_TOKEN_ENABLED, platformConfig.optBoolean("game.refreshToken.enabled", false));
                jSONObject.put(GameConstant.GAME_IS_SCREEN_SHARE_UI_DISABLED, platformConfig.optBoolean(GameConstant.GAME_IS_SCREEN_SHARE_UI_DISABLED, false));
                jSONObject.put(GameConstant.GAME_IS_UNITY_LOCALIZATION_ENABLED, platformConfig.optBoolean("unity.localisation", false));
                jSONObject.put(GameConstant.GAME_FRAUD_BLOCK_ENABLED, platformConfig.optBoolean("game.fraud.block.enabled", false));
                jSONObject.put(GameConstant.GAME_BACK_UP_MODULE_ENABLE, platformConfig.optBoolean("game.enableGameDataBackupModule", false));
                jSONObject.put(GameConstant.GAME_BACK_UP_MODULE_KEY, platformConfig.optString("game.gameDataBackupModuleKey", ""));
                jSONObject.put(GameConstant.GAME_BACK_UP_MODULE_IV, platformConfig.optString("game.gameDataBackupModuleIv", ""));
                jSONObject.put(GameConstant.ENABLE_RNG_NEW_HASH_ID_LOGIC, platformConfig.optBoolean("game.rngEnableNewHashIdLogic", false));
            }
        } catch (Exception e3) {
            MLogger.e(TAG, "updateZKConfigs: ", e3);
            StringBuilder sb = new StringBuilder();
            sb.append("updateZKConfigs: ");
            showToast(GeneratedOutlineSupport.outline39(e3, sb));
        }
    }

    @ReactMethod
    public void deleteFile(String str) {
        if (!TextUtils.isEmpty(str)) {
            boolean delete = new File(str).delete();
            MLogger.d(VideoRecordingConstants.TAG, "isDeleted " + delete);
        }
    }

    public Class<?> getLaunchingActivityClassName(JSONObject jSONObject, boolean z) {
        int optInt = jSONObject.optInt("GameId", 0);
        return z ? Util.isTopQuiz(optInt) ? QuizActivity.class : WebViewActivity.class : ConfigManager.shouldMatchInAndroid(optInt) ? MPLSFS2XConnectorActivity.class : MPLUnityPlayerActivity.class;
    }

    public String getName() {
        return TAG;
    }

    public boolean isOverlayDetectionRequired(int i) {
        return MSharedPreferencesUtils.isOverlayDetectionRequiredInGame(i);
    }

    public boolean isUnityCloseRequired() {
        return MSharedPreferencesUtils.isUnityCloseRequired();
    }

    @ReactMethod
    public void launchGame(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        MLogger.d(TAG, "launchGame:starting Is game already running");
        try {
            int optInt = new JSONObject(str).optInt("GameId", 0);
            MLogger.d(TAG, Constant.GAME_LAUNCH_TAG, Integer.valueOf(optInt));
            if (isGameIsAlreadyRunning(optInt)) {
                MLogger.d(TAG, "launchUnityGame Game launch is already in process");
                return;
            }
            setGameIsAlreadyRunning(optInt, true);
            sendEventLaunchStarted(str, "");
            launchUnityGame(str, currentTimeMillis);
            processAfterGameLaunch();
            MLogger.d(TAG, "launchGame: ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        } catch (Exception e2) {
            Object[] objArr = new Object[2];
            objArr[0] = "Unable to lunch the game launchUnityGame";
            objArr[1] = e2.getMessage() != null ? e2.getMessage() : "Launch fail";
            MLogger.e(TAG, objArr);
            StringBuilder sb = new StringBuilder();
            sb.append(Constant.GAME_LAUNCH_TAG);
            showToast(GeneratedOutlineSupport.outline39(e2, sb));
            sendEventLaunchStarted(str, e2.getMessage());
        }
    }

    @ReactMethod
    public void launchMultiTableGame(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        MLogger.d(TAG, "launchMultiTableGame:starting Is game already running");
        launchMultiTableUnityGame(str, str2, currentTimeMillis);
        processAfterGameLaunch();
    }

    @ReactMethod
    public void optionalDownloadUserVisit(Double d2) {
        try {
            String valueOf = String.valueOf(Math.round(d2.doubleValue()));
            if (getCurrentActivity() != null) {
                NotificationDisplayEntryPoint notificationDisplayEntryPoint = (NotificationDisplayEntryPoint) TweetUtils.fromApplication(getCurrentActivity(), NotificationDisplayEntryPoint.class);
                DownloadNotificationDisplayFeature downloadNotificationDisplayFeature = new DownloadNotificationDisplayFeature(notificationDisplayEntryPoint.ioDispatcher(), notificationDisplayEntryPoint.optionalDownloadVisitInsertUseCase(), notificationDisplayEntryPoint.OptionalDownloadVisitUpdateUseCase(), notificationDisplayEntryPoint.optionalDownloadVisitCheckUseCase(), notificationDisplayEntryPoint.optionalDownloadVisitDeleteUseCase());
                downloadNotificationDisplayFeature.runUpdateFeature(valueOf);
            }
        } catch (Exception unused) {
            MLogger.e(TAG, "optionalDownloadUserVisit: ");
        }
    }

    public void sendEventLaunchStarted(String str, String str2) {
        if (str == null || str.length() <= 0) {
            MplCtEventInitiate.INSTANCE.sendEventNativeLaunchStatus(CtNativeLaunchInitiated.EVENT_NAME_LAUNCH_INITIATED, str, false, "Error parsing json");
        } else if (!str2.isEmpty()) {
            MplCtEventInitiate.INSTANCE.sendEventNativeLaunchStatus(CtNativeLaunchInitiated.EVENT_NAME_LAUNCH_INITIATED, str, false, str2);
        } else {
            MplCtEventInitiate.INSTANCE.sendEventNativeLaunchStatus(CtNativeLaunchInitiated.EVENT_NAME_LAUNCH_INITIATED, str, true, "");
        }
    }

    @ReactMethod
    public void toggleScreenSecure(Boolean bool) {
        if (getCurrentActivity() != null) {
            ((MPLReactContainerActivity) getCurrentActivity()).setScreenSecure(bool);
        }
    }
}
