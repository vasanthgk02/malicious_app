package com.mpl.androidapp.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.mpl.androidapp.MPLApplication;
import com.mpl.androidapp.config.ConfigConstant;
import com.mpl.androidapp.config.ConfigManager;
import com.mpl.androidapp.game.AllGame;
import com.mpl.androidapp.game.AssetsInfo;
import com.mpl.androidapp.updater.gameengine.GEInteractor;
import com.mpl.androidapp.updater.interactor.FileInteractor;
import com.mpl.androidapp.updater.util.GEUtil;
import com.mpl.androidapp.updater.util.UpdaterConstant.GEFile;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.jboss.netty.channel.ChannelPipelineCoverage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AssetsUtils {
    public static final String TAG = "AssetsUtils";
    public static JSONObject assetsJson;
    public static final List<String> sAssetsIncreaseTimeOutIds = new ArrayList();
    public static final HashMap<Integer, AssetsInfo> sAssetsVersionSupportMap = listOfGameAssetsVersionAvailable(MPLApplication.getInstance());
    public static Set<Integer> sCurrentlyDownloadingAssets = new HashSet();

    public static void addCurrentlyDownloadingAssetsIds(int i) {
        if (sCurrentlyDownloadingAssets == null) {
            sCurrentlyDownloadingAssets = new HashSet();
        }
        sCurrentlyDownloadingAssets.add(Integer.valueOf(i));
    }

    public static void addGameIdForMergedAssetsDownload(int i) {
        Set<String> stringSet = MSharedPreferencesUtils.getStringSet(Constant.MERGED_BUNDLE_GAME_IDS, new HashSet());
        stringSet.add("" + i);
        MSharedPreferencesUtils.putStringSet(Constant.MERGED_BUNDLE_GAME_IDS, stringSet);
    }

    public static void deleteCurrentlyDownloadingAssetsIds(int i) {
        Set<Integer> set = sCurrentlyDownloadingAssets;
        if (set != null) {
            set.remove(Integer.valueOf(i));
        }
    }

    public static JSONObject getAssetsJson() {
        return assetsJson;
    }

    public static HashMap<Integer, AssetsInfo> getAssetsVersionSupportMap() {
        return sAssetsVersionSupportMap;
    }

    public static int getCurrentlyDownloadingAssetsPosition(int i) {
        try {
            if (sCurrentlyDownloadingAssets != null) {
                int i2 = 0;
                for (Integer equals : sCurrentlyDownloadingAssets) {
                    if (equals.equals(Integer.valueOf(i))) {
                        return i2;
                    }
                    i2++;
                }
            }
        } catch (Exception unused) {
        }
        return -1;
    }

    public static int getGameVersion(int i) {
        if (isAssetsVersioningEnabled(i)) {
            JSONObject jSONObject = assetsJson;
            if (jSONObject != null && jSONObject.has(String.valueOf(i))) {
                return assetsJson.optInt(String.valueOf(i));
            }
            if (getGameVersionForGameIdFromServer(i) > 0) {
                return getGameVersionForGameIdFromServer(i);
            }
            if (getGameVersionForGameIdFromServerInGameInfo(i) > 0) {
                return getGameVersionForGameIdFromServerInGameInfo(i);
            }
            if (getGameVersionForGameIdFromLocal(i) > 0) {
                return getGameVersionForGameIdFromLocal(i);
            }
        }
        if (!isNewAssetsApiCallRequiredV2(i) || getGameVersionForGameIdFromLocal(i) <= 0) {
            return 1;
        }
        return getGameVersionForGameIdFromLocal(i);
    }

    public static int getGameVersionForGameIdFromLocal(int i) {
        HashMap<Integer, AssetsInfo> hashMap = sAssetsVersionSupportMap;
        if (hashMap == null || !hashMap.containsKey(Integer.valueOf(i)) || sAssetsVersionSupportMap.get(Integer.valueOf(i)) == null) {
            return -1;
        }
        return sAssetsVersionSupportMap.get(Integer.valueOf(i)).getGameVersion();
    }

    public static int getGameVersionForGameIdFromServer(int i) {
        AllGame gameInfo = CommonUtils.getGameInfo(Integer.valueOf(i));
        if (gameInfo == null || gameInfo.getGameVersion() == null || gameInfo.getGameVersion().intValue() <= 0) {
            return -1;
        }
        return gameInfo.getGameVersion().intValue();
    }

    public static int getGameVersionForGameIdFromServerInGameInfo(int i) {
        AllGame gameInfo = CommonUtils.getGameInfo(Integer.valueOf(i));
        if (!(gameInfo == null || gameInfo.getGameConfigGameInfo() == null)) {
            if (i > 1000000 && gameInfo.getGameConfigGameInfo().getBattleGameVersion() != null) {
                return gameInfo.getGameConfigGameInfo().getBattleGameVersion().intValue();
            }
            if (i < 1000000 && gameInfo.getGameConfigGameInfo().getTournamentGameVersion() != null) {
                return gameInfo.getGameConfigGameInfo().getTournamentGameVersion().intValue();
            }
        }
        return -1;
    }

    public static int increaseTimeOut() {
        if (ConfigManager.getNormalConfig() != null) {
            return ConfigManager.getNormalConfig().optInt(ConfigConstant.ANDROID_ASSETS_DOWNLOAD_TIMEOUT, 30000);
        }
        return 30000;
    }

    public static boolean isAssetsDirectoryCheckEnabled() {
        if (ConfigManager.getPlatformConfig() == null || !ConfigManager.getPlatformConfig().optBoolean(ConfigConstant.GAME_ASSETS_DIRECTORY_CHECK_ENABLED, false)) {
            return false;
        }
        return true;
    }

    public static boolean isAssetsDirectoryCheckFromGameEnabled() {
        if (!isAssetsDirectoryCheckEnabled() || ConfigManager.getPlatformConfig() == null || !ConfigManager.getPlatformConfig().optBoolean(ConfigConstant.GAME_ASSETS_DIRECTORY_CHECK_FROM_GAME_ENABLED, false)) {
            return false;
        }
        return true;
    }

    public static boolean isAssetsVersioningEnabled(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        if (ConfigManager.getPlatformConfig() != null && ConfigManager.getPlatformConfig().optBoolean("game.assets.version.enabledV2", false) && getAssetsJson() != null && getAssetsJson().has(String.valueOf(i))) {
            z = true;
        }
        return z;
    }

    public static boolean isBundleMergeFlow() {
        return MBuildConfigUtils.getInstalledAppVersionCode() >= 1000131;
    }

    public static boolean isCurrentlyDownloadingAssets(int i) {
        Set<Integer> set = sCurrentlyDownloadingAssets;
        if (set == null) {
            return false;
        }
        return set.contains(Integer.valueOf(i));
    }

    public static boolean isFirstTimeAssetsValidation(Context context) {
        return MSharedPreferencesUtils.getBooleanInNormalPref(context, "is_assets_mapping_done_first_time", false);
    }

    public static boolean isGameAssetsVersionValid(Context context, int i) {
        boolean z;
        boolean z2;
        try {
            if (!isAssetsVersioningEnabled(i)) {
                if (!isNewAssetsApiCallRequiredV2(i)) {
                    z2 = false;
                    MLogger.d(TAG, "isGameAssetsVersionValid: isConfigOn -->", Boolean.valueOf(z2));
                    if (i > 0 && z2 && MSharedPreferencesUtils.getDownloadedAssetVersion(context, i, 0) < getGameVersion(i)) {
                        z = false;
                        MLogger.d(TAG, "isGameAssetsVersionValid: ", Boolean.valueOf(z));
                        return z;
                    }
                    z = true;
                    MLogger.d(TAG, "isGameAssetsVersionValid: ", Boolean.valueOf(z));
                    return z;
                }
            }
            z2 = true;
            MLogger.d(TAG, "isGameAssetsVersionValid: isConfigOn -->", Boolean.valueOf(z2));
            z = false;
        } catch (Exception e2) {
            MLogger.e(TAG, "isGameAssetsVersionValid: ", e2);
        }
        MLogger.d(TAG, "isGameAssetsVersionValid: ", Boolean.valueOf(z));
        return z;
    }

    public static boolean isIncreasedTimeOutGameId(int i) {
        List<String> list = sAssetsIncreaseTimeOutIds;
        return list != null && (list.contains("All") || sAssetsIncreaseTimeOutIds.contains(ChannelPipelineCoverage.ALL) || sAssetsIncreaseTimeOutIds.contains(String.valueOf(i)));
    }

    public static boolean isMergedAssetsAreDownloaded(int i) {
        int changeToBattleGameId = CommonUtils.changeToBattleGameId(i);
        Set<String> stringSet = MSharedPreferencesUtils.getStringSet(Constant.MERGED_BUNDLE_GAME_IDS, new HashSet());
        return stringSet.contains("" + changeToBattleGameId);
    }

    public static boolean isNewAssetsApiCallRequiredV2(int i) {
        if (!(ConfigManager.getNormalConfig() == null || ConfigManager.getNormalConfig().optJSONArray("game.assets.new.call.gameIds") == null || ConfigManager.getNormalConfig().optJSONArray("game.assets.new.call.gameIds").length() <= 0)) {
            JSONArray optJSONArray = ConfigManager.getNormalConfig().optJSONArray("game.assets.new.call.gameIds");
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                if (optJSONArray.optInt(i2, -3) == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isNewDownloader(int i) {
        JSONObject platformConfig = ConfigManager.getPlatformConfig();
        JSONObject normalConfig = ConfigManager.getNormalConfig();
        boolean z = true;
        if (platformConfig != null && platformConfig.optBoolean("assets.downloadmanager.enabled", false)) {
            return true;
        }
        if (normalConfig != null && normalConfig.optJSONArray("game.change.download.method") != null) {
            JSONArray optJSONArray = normalConfig.optJSONArray("game.change.download.method");
            int i2 = 0;
            while (true) {
                if (optJSONArray == null || i2 >= optJSONArray.length()) {
                    break;
                } else if (i == optJSONArray.optInt(i2)) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        z = false;
        return z;
    }

    public static boolean isNewDownloaderPoker() {
        if (ConfigManager.getPlatformConfig() == null || !ConfigManager.getPlatformConfig().optBoolean("game.change.download.method.pokerV2", false)) {
            return false;
        }
        return true;
    }

    public static boolean isPokerGameAssetsAvailable(Context context, int i, int i2) {
        boolean isWebViewBundleAvailable = FileUtils.isWebViewBundleAvailable(context, String.valueOf(i), Constant.POKER_ASSETS_FOLDER_NAME, (long) i2);
        MLogger.d(TAG, "gameId: ", Integer.valueOf(i), "assetsVersion: ", Integer.valueOf(i2), "isAssetsAvailable: ", Boolean.valueOf(isWebViewBundleAvailable));
        return isWebViewBundleAvailable;
    }

    public static boolean isPokerGameId(int i) {
        return false;
    }

    public static boolean isSendingHashInConfigEnabled() {
        if (ConfigManager.getPlatformConfig() == null || !ConfigManager.getPlatformConfig().optBoolean(ConfigConstant.GAME_ASSETS_SENDING_IN_CONFIG_ENABLED, false)) {
            return false;
        }
        return true;
    }

    public static HashMap<Integer, AssetsInfo> listOfGameAssetsVersionAvailable(Context context) {
        MLogger.d(TAG, "listOfGameAssetsVersionAvailable:[START] ");
        HashMap<Integer, AssetsInfo> hashMap = new HashMap<>();
        String readFromAssets = AssetsConfigReader.readFromAssets(context, "game/game_assets_version.json");
        if (!TextUtils.isEmpty(readFromAssets)) {
            try {
                JSONObject jSONObject = new JSONObject(readFromAssets);
                Iterator<String> keys = jSONObject.keys();
                Gson gson = new Gson();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject optJSONObject = jSONObject.optJSONObject(next);
                    if (optJSONObject != null) {
                        hashMap.put(Integer.valueOf(next), (AssetsInfo) gson.fromJson(optJSONObject.toString(), AssetsInfo.class));
                    }
                }
            } catch (JSONException e2) {
                MLogger.e(TAG, "", e2);
            }
        }
        MLogger.d(TAG, "listOfGameAssetsVersionAvailable:[END] ");
        return hashMap;
    }

    public static void mapAllAssetsVersionFirstTime(final Context context) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                MLogger.d(AssetsUtils.TAG, "mapAllAssetsVersionFirstTime:[START] ");
                if (!AssetsUtils.isFirstTimeAssetsValidation(context)) {
                    MLogger.d(AssetsUtils.TAG, "mapAllAssetsVersionFirstTime: Doing first time mapping");
                    HashMap<Integer, AssetsInfo> assetsVersionSupportMap = AssetsUtils.getAssetsVersionSupportMap();
                    GEInteractor instance = GEInteractor.getInstance();
                    for (Entry next : assetsVersionSupportMap.entrySet()) {
                        Integer num = (Integer) next.getKey();
                        AssetsInfo assetsInfo = (AssetsInfo) next.getValue();
                        if (instance.isGameCodeAvailable(context, num.intValue()) && instance.isAssetsAvailable(context, num.intValue())) {
                            MLogger.d(AssetsUtils.TAG, "mapAllAssetsVersionFirstTime: ", num, Integer.valueOf(assetsInfo.getAssetVersion()));
                            MSharedPreferencesUtils.setDownloadedAssetVersion(context, num.intValue(), assetsInfo.getAssetVersion());
                        }
                    }
                    AssetsUtils.setFirstTimeAssetsValidation(context);
                }
                MLogger.d(AssetsUtils.TAG, "mapAllAssetsVersionFirstTime:[END] ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
        });
    }

    public static void movePokerAssets(Context context, int i, int i2) {
        try {
            MLogger.d(TAG, "movePokerAssets gameId:", Integer.valueOf(i), "assetsVersion: ", Integer.valueOf(i2));
            int intInNormalPref = MSharedPreferencesUtils.getIntInNormalPref(context, Constant.POKER_ZIP_VERSION, 0);
            String gameAssetsInternalStorageZipPath = GEUtil.getGameAssetsInternalStorageZipPath(context);
            long j = (long) i2;
            File file = new File(FileUtils.getWebViewBundleExtractOrDownloadDirPath(context, String.valueOf(i), j), "webApp.zip");
            File file2 = new File(FileUtils.getWebViewBundleExtractOrDownloadDirPath(context, String.valueOf(i), j), Constant.WEB_VIEW_FILE_NAME);
            MLogger.d(TAG, "movePokerAssets:destination ", file.getAbsolutePath());
            MLogger.d(TAG, "movePokerAssets:source ", gameAssetsInternalStorageZipPath);
            CommonUtils.copyFiles(gameAssetsInternalStorageZipPath, file.getAbsolutePath());
            if (FileInteractor.performWebAssetsFileOperationAfterDownload(context, String.valueOf(i), i2, intInNormalPref)) {
                new File(file2, GEFile.GAME_DIR_NEW_88).renameTo(new File(file2, Constant.POKER_ASSETS_FOLDER_NAME));
                MSharedPreferencesUtils.saveIntInNormalPref(context, Constant.POKER_ZIP_VERSION, i2);
                FileUtils.deleteFolder(GEUtil.getGameAssetsDownloadDirPath(context));
                FileUtils.deleteFile(gameAssetsInternalStorageZipPath);
                File gameAssetsDownloadDirPath = GEUtil.getGameAssetsDownloadDirPath(context);
                if (!gameAssetsDownloadDirPath.exists()) {
                    MLogger.d(TAG, "movePokerAssets:assetsFolderCreated ", Boolean.valueOf(gameAssetsDownloadDirPath.mkdirs()));
                    return;
                }
                return;
            }
            MLogger.d(TAG, "movePokerAssets:downloadFile Downloading is failed ");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void prepareListForBundleTimeOutChecking() {
        if (ConfigManager.getNormalConfig() != null && ConfigManager.getNormalConfig().optJSONArray(ConfigConstant.ANDROID_ASSETS_DOWNLOAD_TIMEOUT_GAME_IDS) != null) {
            JSONArray optJSONArray = ConfigManager.getNormalConfig().optJSONArray(ConfigConstant.ANDROID_ASSETS_DOWNLOAD_TIMEOUT_GAME_IDS);
            int i = 0;
            while (optJSONArray != null && i < optJSONArray.length()) {
                sAssetsIncreaseTimeOutIds.add(optJSONArray.optString(i));
                i++;
            }
        }
    }

    public static void setAssetsJson(JSONObject jSONObject) {
        assetsJson = jSONObject;
    }

    public static void setFirstTimeAssetsValidation(Context context) {
        MSharedPreferencesUtils.saveBooleanInNormalPref(context, "is_assets_mapping_done_first_time", true);
    }
}
