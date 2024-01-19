package com.mpl.androidapp.config;

import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.cleverTap.AssetsAnalytics;
import com.mpl.androidapp.cleverTap.AssetsAnalyticsProps;
import com.mpl.androidapp.updater.model.GameAssets;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.Constant.EventsConstants;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import java.util.HashMap;

public class UpdaterAnalytics {
    public static final String APP = "App";
    public static final String APP_UPDATED = "App Updated";
    public static final String APP_UPDATE_AVAILABLE = "App Update Available";
    public static final String APP_UPDATE_DOWNLOAD = "App Update Downloaded";
    public static final String BUTTON_CLICKED = "Button Clicked";
    public static final String GAME = "Game";
    public static final String GAME_ASSETS_AVAILABLE = "Game Assets Available";
    public static final String GAME_ASSETS_DOWNLOADED = "Game Assets Downloaded V2";
    public static final String GAME_ASSETS_DOWNLOAD_FAILED = "Game Assets Download Failed";
    public static final String GAME_ASSETS_INSTALLED = "Game Assets Installed";
    public static final String INTEGRITY_CHECK_EVENT = "Integrity Check Failed V2";
    public static final String LOW_STORAGE_SPACE_EVENT = "Low Storage Space Prompted";
    public static final String REACT = "React";
    public static final String REACT_UPDATED_INSTALLED = "React Update Installed";
    public static final String REACT_UPDATE_AVAILABLE = "React Update Available";
    public static final String REACT_UPDATE_DOWNLOADED = "React Update Downloaded";

    public static void appUpdateAvailableEvent(boolean z, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("Is Critical", Boolean.valueOf(z));
        hashMap.put(EventsConstants.UPDATE_VERSION, str);
        CleverTapAnalyticsUtils.sendEvent((String) "App Update Available", hashMap);
    }

    public static void appUpdateDownloadEvent(String str, boolean z) {
        HashMap outline87 = GeneratedOutlineSupport.outline87(EventsConstants.UPDATE_VERSION, str);
        outline87.put("Is Background", Boolean.valueOf(z));
        CleverTapAnalyticsUtils.sendEvent((String) APP_UPDATE_DOWNLOAD, outline87);
    }

    public static void gameAssetsAvailableEvent(String str, int i, boolean z, GameAssets gameAssets) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("Game Name", str);
            hashMap.put("Game ID", Integer.valueOf(i));
            hashMap.put("Is Already Downloaded", Boolean.valueOf(z));
            if (gameAssets != null) {
                hashMap.put("Asset Version", Integer.valueOf(gameAssets.getAssetVersion()));
                hashMap.put("Is Retry", Boolean.valueOf(gameAssets.isRetry()));
                hashMap.put(EventsConstants.DOWNLOAD_URL, gameAssets.getUrl());
                hashMap.put("Assets Info", gameAssets.toJSon());
            }
            CleverTapAnalyticsUtils.sendEvent((String) GAME_ASSETS_AVAILABLE, hashMap);
        } catch (Exception unused) {
        }
    }

    public static void gameAssetsDownloadFailedEvent(String str, int i, int i2, boolean z, GameAssets gameAssets, Exception exc) {
        try {
            AssetsAnalyticsProps assetsAnalyticsProps = new AssetsAnalyticsProps();
            HashMap hashMap = new HashMap();
            hashMap.put("Game Name", str);
            hashMap.put("Game ID", Integer.valueOf(i));
            hashMap.put("Update Size", Integer.valueOf(i2));
            hashMap.put("Is Prioritized", Boolean.valueOf(z));
            if (gameAssets != null) {
                hashMap.put("Asset Version", Integer.valueOf(gameAssets.getAssetVersion()));
                hashMap.put("Is Retry", Boolean.valueOf(gameAssets.isRetry()));
                hashMap.put(EventsConstants.DOWNLOAD_URL, gameAssets.getUrl());
                hashMap.put("Assets Info", gameAssets.toJSon());
                assetsAnalyticsProps.setGameName(gameAssets.getGameName());
                assetsAnalyticsProps.setAssetsVersion(gameAssets.getAssetVersion());
                assetsAnalyticsProps.setGameId(gameAssets.getGameId());
            }
            if (exc != null && !TextUtils.isEmpty(exc.getMessage())) {
                hashMap.put(EventsConstants.FAIL_REASON, exc.getMessage());
                assetsAnalyticsProps.setDownloadFailReason(exc.getMessage());
            }
            if (!(exc == null || exc.getCause() == null || TextUtils.isEmpty(exc.getCause().toString()))) {
                hashMap.put("Fail Reason V2", exc.getCause().toString());
                assetsAnalyticsProps.setDownloadFailReasonV2(exc.getCause().toString());
            }
            CleverTapAnalyticsUtils.sendEvent((String) GAME_ASSETS_DOWNLOAD_FAILED, hashMap);
            assetsAnalyticsProps.setAssetsType("Assets");
            assetsAnalyticsProps.setAlreadyDownloaded(false);
            assetsAnalyticsProps.setDownloadSuccess(false);
            AssetsAnalytics.sendGameFileDownloadStatusEvent(assetsAnalyticsProps);
        } catch (Exception unused) {
        }
    }

    public static void gameAssetsDownloadedEvent(String str, int i, int i2, boolean z, GameAssets gameAssets) {
        try {
            HashMap hashMap = new HashMap();
            AssetsAnalyticsProps assetsAnalyticsProps = new AssetsAnalyticsProps();
            hashMap.put("Game Name", str);
            hashMap.put("Game ID", Integer.valueOf(i));
            hashMap.put("Update Size", Integer.valueOf(i2));
            hashMap.put("Is Prioritized", Boolean.valueOf(z));
            if (gameAssets != null) {
                hashMap.put("Asset Version", Integer.valueOf(gameAssets.getAssetVersion()));
                hashMap.put("Is Retry", Boolean.valueOf(gameAssets.isRetry()));
                hashMap.put(EventsConstants.DOWNLOAD_URL, gameAssets.getUrl());
                hashMap.put("Assets Info", gameAssets.toJSon());
                assetsAnalyticsProps.setGameName(gameAssets.getGameName());
                assetsAnalyticsProps.setAssetsVersion(gameAssets.getAssetVersion());
                assetsAnalyticsProps.setGameId(gameAssets.getGameId());
            }
            assetsAnalyticsProps.setAlreadyDownloaded(false);
            assetsAnalyticsProps.setDownloadSuccess(true);
            assetsAnalyticsProps.setAssetsType("Assets");
            AssetsAnalytics.sendGameFileDownloadStatusEvent(assetsAnalyticsProps);
            CleverTapAnalyticsUtils.sendEvent((String) GAME_ASSETS_DOWNLOADED, hashMap);
        } catch (Exception unused) {
        }
    }

    public static void gameAssetsInstalledEvent(String str, int i, GameAssets gameAssets, boolean z, boolean z2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("Game Name", str);
            hashMap.put("Game ID", Integer.valueOf(i));
            hashMap.put("Is Success", Boolean.valueOf(z));
            hashMap.put("Is Already Downloaded", Boolean.valueOf(z2));
            if (gameAssets != null) {
                hashMap.put("Asset Version", Integer.valueOf(gameAssets.getAssetVersion()));
                hashMap.put("Is Retry", Boolean.valueOf(gameAssets.isRetry()));
                hashMap.put(EventsConstants.DOWNLOAD_URL, gameAssets.getUrl());
                hashMap.put("Assets Info", gameAssets.toJSon());
            }
            CleverTapAnalyticsUtils.sendEvent((String) GAME_ASSETS_INSTALLED, hashMap);
        } catch (Exception unused) {
        }
    }

    public static void integrityCheckFailEvent(int i, String str) {
        HashMap hashMap = new HashMap();
        if (i == 1) {
            hashMap.put(EventsConstants.FAIL_REASON, "Bundle Tampered");
        } else if (i == 2) {
            hashMap.put(EventsConstants.FAIL_REASON, "Downloaded APK Tampered");
        } else if (i == 3) {
            hashMap.put(EventsConstants.FAIL_REASON, "Installed APK Tampered");
            hashMap.put("Modification", str);
        }
        CleverTapAnalyticsUtils.sendEvent((String) INTEGRITY_CHECK_EVENT, hashMap);
    }

    public static void integrityFailedCTA() {
        HashMap hashMap = new HashMap();
        hashMap.put(EventsConstants.CTA, "Integrity Fail Download");
        CleverTapAnalyticsUtils.sendEvent((String) "Button Clicked", hashMap);
    }

    public static void internetCheckFailed() {
        HashMap hashMap = new HashMap();
        hashMap.put(EventsConstants.CTA, "Internet Fail Retry");
        CleverTapAnalyticsUtils.sendEvent((String) "Button Clicked", hashMap);
    }

    public static void lowStoragePromptedEvent(String str, String str2, int i) {
        HashMap outline88 = GeneratedOutlineSupport.outline88("Update Type", str, EventsConstants.UPDATE_VERSION, str2);
        outline88.put("Update Size", Integer.valueOf(i));
        CleverTapAnalyticsUtils.sendEvent((String) LOW_STORAGE_SPACE_EVENT, outline88);
    }

    public static void reactUpdateAvailableEvent(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(EventsConstants.UPDATE_VERSION, str);
        CleverTapAnalyticsUtils.sendEvent((String) REACT_UPDATE_AVAILABLE, hashMap);
    }

    public static void reactUpdatedInstalledEvent(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(EventsConstants.UPDATE_VERSION, str);
        hashMap.put("Old Version", str2);
        CleverTapAnalyticsUtils.sendEvent((String) REACT_UPDATED_INSTALLED, hashMap);
    }

    public static void sendAppUpdatedEvent() {
        try {
            String valueOf = String.valueOf(MBuildConfigUtils.getInstalledAppVersionCodeGradle());
            HashMap hashMap = new HashMap();
            hashMap.put(EventsConstants.UPDATE_VERSION, valueOf);
            CleverTapAnalyticsUtils.sendEvent((String) APP_UPDATED, hashMap);
            MSharedPreferencesUtils.setLastInstalledAppVersionEvent(MBuildConfigUtils.getInstalledAppVersionCodeGradle());
        } catch (Exception unused) {
        }
    }

    public static void setReactUpdateDownloadedEvent(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(EventsConstants.UPDATE_VERSION, str);
        hashMap.put("Old Version", str2);
        CleverTapAnalyticsUtils.sendEvent((String) REACT_UPDATE_DOWNLOADED, hashMap);
    }
}
