package com.mpl.androidapp.cleverTap;

import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.Constant.EventsConstants;
import java.util.HashMap;

public class AssetsAnalytics {
    public static final String EVENT_BUTTON_CLICKED = "Button Clicked";
    public static final String EVENT_GAME_DOWNLOAD_COMPLETED = "Game Download Completed";
    public static final String EVENT_GAME_DOWNLOAD_INITIATED = "Game Download Initiated";
    public static final String EVENT_GAME_FILE_AVAILABLE = "Game File Available";
    public static final String EVENT_GAME_FILE_DOWNLOAD_INITIATED = "Game File Download Initiated";
    public static final String EVENT_GAME_FILE_DOWNLOAD_STATUS = "Game File Download Status";
    public static final String EVENT_GAME_FILE_INSTALL_STATUS = "Game File Install Status";
    public static final String EVENT_GAME_FILE_STATUS = "Game File Status";
    public static final String EVENT_GAME_INSTALLED_COMPLETED = "Game Install Completed";
    public static final String EVENT_GUERRILLA_PERMISSION_GRANTED = "Guerrilla Permission Granted";
    public static final String PROP_ENTRY_POINT = "Entry Point";
    public static final String PROP_GAME_DOWNLOAD_SIZE = "Download Size";
    public static final String PROP_GAME_ID = "Game Id";
    public static final String PROP_GAME_INSTALLED_VERSION = "Game Installed Version";
    public static final String PROP_GAME_INSTALL_COUNT = "Install Count";
    public static final String PROP_GAME_IS_INSTALL_SUCCESS = "Is Success";
    public static final String PROP_GAME_NAME = "Game Name";
    public static final String PROP_GAME_PLAYED = "Games Played";
    public static final String PROP_GAME_SERVER_VERSION = "Game Server Version";
    public static final String PROP_GAME_VERSION = "Game Version";
    public static final String PROP_IS_FORCE_UPDATE = "Is Force Update";

    public static void sendGameFileAvailableEvent(AssetsAnalyticsProps assetsAnalyticsProps) {
        HashMap hashMap = new HashMap();
        hashMap.put("Game Name", assetsAnalyticsProps.getGameName());
        hashMap.put("Game ID", Integer.valueOf(assetsAnalyticsProps.getGameId()));
        hashMap.put("Is Available", Boolean.valueOf(assetsAnalyticsProps.isAvailableOnServer()));
        hashMap.put("Screen Name", assetsAnalyticsProps.getScreenName());
        hashMap.put("Is Update", Boolean.valueOf(assetsAnalyticsProps.isUpdateAssets()));
        hashMap.put(PROP_GAME_VERSION, Integer.valueOf(assetsAnalyticsProps.getAssetsVersion()));
        hashMap.put("Game File version installed", Integer.valueOf(assetsAnalyticsProps.getInstalledVersion()));
        hashMap.put("Game File version available", Integer.valueOf(assetsAnalyticsProps.getServerVersion()));
        hashMap.put("Game File Size", Long.valueOf(assetsAnalyticsProps.getAssetsSize()));
        hashMap.put("Download Mode", assetsAnalyticsProps.getDownloadMode());
        CleverTapAnalyticsUtils.sendEvent((String) EVENT_GAME_FILE_AVAILABLE, hashMap);
    }

    public static void sendGameFileDownloadInitiatedEvent(AssetsAnalyticsProps assetsAnalyticsProps) {
        HashMap hashMap = new HashMap();
        hashMap.put("Is Type", assetsAnalyticsProps.getAssetsType());
        hashMap.put("Is Update", Boolean.valueOf(assetsAnalyticsProps.isUpdateAssets()));
        hashMap.put("Game Name", assetsAnalyticsProps.getGameName());
        hashMap.put("Game ID", Integer.valueOf(assetsAnalyticsProps.getGameId()));
        hashMap.put("Asset Type", assetsAnalyticsProps.getAssetsType());
        hashMap.put("Game File Size", Long.valueOf(assetsAnalyticsProps.getAssetsSize()));
        hashMap.put("Download Type", assetsAnalyticsProps.getDownloadType());
        hashMap.put("Is Queued", Boolean.valueOf(assetsAnalyticsProps.isQueued()));
        hashMap.put("Queue Priority", Integer.valueOf(assetsAnalyticsProps.getQueuePriority()));
        hashMap.put(PROP_GAME_VERSION, Integer.valueOf(assetsAnalyticsProps.getAssetsVersion()));
        hashMap.put("Download Mode", assetsAnalyticsProps.getDownloadMode());
        CleverTapAnalyticsUtils.sendEvent((String) EVENT_GAME_FILE_DOWNLOAD_INITIATED, hashMap);
    }

    public static void sendGameFileDownloadStatusEvent(AssetsAnalyticsProps assetsAnalyticsProps) {
        HashMap hashMap = new HashMap();
        hashMap.put("Is Type", assetsAnalyticsProps.getAssetsType());
        hashMap.put("Game Name", assetsAnalyticsProps.getGameName());
        hashMap.put("Game ID", Integer.valueOf(assetsAnalyticsProps.getGameId()));
        hashMap.put("Is Success", Boolean.valueOf(assetsAnalyticsProps.isDownloadSuccess()));
        hashMap.put(EventsConstants.FAIL_REASON, assetsAnalyticsProps.getDownloadFailReason());
        hashMap.put("Fail Reason V2", assetsAnalyticsProps.getDownloadFailReasonV2());
        hashMap.put(PROP_GAME_VERSION, Integer.valueOf(assetsAnalyticsProps.getAssetsVersion()));
        hashMap.put("Download Mode", assetsAnalyticsProps.getDownloadMode());
        CleverTapAnalyticsUtils.sendEvent((String) EVENT_GAME_FILE_DOWNLOAD_STATUS, hashMap);
    }

    public static void sendGameFileInstallStatusEvent(AssetsAnalyticsProps assetsAnalyticsProps) {
        HashMap hashMap = new HashMap();
        hashMap.put("Background Screen Name", Boolean.valueOf(assetsAnalyticsProps.isBackground()));
        hashMap.put("Game Name", assetsAnalyticsProps.getGameName());
        hashMap.put("Game ID", Integer.valueOf(assetsAnalyticsProps.getGameId()));
        hashMap.put("Is Type", assetsAnalyticsProps.getAssetsType());
        hashMap.put("Is Success", Boolean.valueOf(assetsAnalyticsProps.isAssetsInstallSuccess()));
        hashMap.put(EventsConstants.FAIL_REASON, assetsAnalyticsProps.getAssetsInstalledFailReason());
        hashMap.put("Download Mode", assetsAnalyticsProps.getDownloadMode());
        CleverTapAnalyticsUtils.sendEvent((String) EVENT_GAME_FILE_INSTALL_STATUS, hashMap);
    }

    public static void sendGameFileStatusEvent(AssetsAnalyticsProps assetsAnalyticsProps) {
        HashMap hashMap = new HashMap();
        hashMap.put("Is Downloaded", Boolean.valueOf(assetsAnalyticsProps.isAlreadyDownloaded()));
        hashMap.put("Is Type", assetsAnalyticsProps.getAssetsType());
        hashMap.put("Game Name", assetsAnalyticsProps.getGameName());
        hashMap.put("Game ID", Integer.valueOf(assetsAnalyticsProps.getGameId()));
        hashMap.put("Is Latest", Boolean.valueOf(assetsAnalyticsProps.isLatest()));
        CleverTapAnalyticsUtils.sendEvent((String) EVENT_GAME_FILE_STATUS, hashMap);
    }
}
