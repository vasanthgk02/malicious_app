package com.mpl.androidapp.updater.util;

import android.content.Context;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.config.ConfigConstant;
import com.mpl.androidapp.config.ConfigHelper;
import com.mpl.androidapp.okhttp3.MemoryLruCache;
import com.mpl.androidapp.updater.gameengine.GEInteractor;
import com.mpl.androidapp.updater.util.UpdaterConstant.GEFile;
import com.mpl.androidapp.updater.util.UpdaterConstant.Response;
import com.mpl.androidapp.utils.AssetsUtils;
import com.mpl.androidapp.utils.CommonUtils;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.FileUtils;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import com.mpl.androidapp.utils.MLogger;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GEUtil {
    public static final String TAG = "com.mpl.androidapp.updater.util.GEUtil";

    public static JSONObject getAssetsFileHashJsonForAssets(Context context, int i) {
        MLogger.d(TAG, Constant.ASSETS_CHECKING, "getAssetsFileHashJsonForAssets: ", Integer.valueOf(i));
        StringBuilder sb = new StringBuilder();
        try {
            if (AssetsUtils.isMergedAssetsAreDownloaded(i)) {
                i = CommonUtils.changeToBattleGameId(i);
            }
            FileInputStream fileInputStream = new FileInputStream(new File(getGameAssetsPathByGameId(context, i), "mpl-manifest.json"));
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    fileInputStream.close();
                    dataInputStream.close();
                    bufferedReader.close();
                    return new JSONObject(sb.toString());
                }
            }
        } catch (IOException | JSONException e2) {
            MLogger.printStackTrace(e2);
            return new JSONObject();
        }
    }

    public static HashMap<String, String> getFileHashForAssets(Context context, int i) {
        MLogger.d(TAG, Constant.ASSETS_CHECKING, "getFileHashForAssets: ", Integer.valueOf(i));
        StringBuilder sb = new StringBuilder();
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(getGameAssetsPathByGameId(context, i), "mpl-manifest.json"));
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            fileInputStream.close();
            dataInputStream.close();
            bufferedReader.close();
            JSONObject jSONObject = new JSONObject(sb.toString());
            String optString = jSONObject.optString("signature", "");
            JSONArray optJSONArray = jSONObject.optJSONArray("assets");
            HashMap<String, String> hashMap = new HashMap<>();
            if (optJSONArray != null) {
                int length = jSONObject.optJSONArray("assets").length();
                StringBuilder sb2 = new StringBuilder();
                if (length > 0) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                        MLogger.d(Constant.ASSETS_CHECKING, "", jSONObject2.toString());
                        hashMap.put(jSONObject2.getString("file"), jSONObject2.getString(Response.HASH));
                        sb2.append(jSONObject2.getString(Response.HASH));
                    }
                }
                if (!TextUtils.isEmpty(optString) && optString != null) {
                    hashMap.put(Constant.SIGNATURE_KEY, optString);
                }
                hashMap.put(Constant.MD5_KEY, sb2.toString());
                hashMap.put(Constant.JSON_LENGTH, String.valueOf(length));
            }
            return hashMap;
        } catch (IOException | JSONException e2) {
            MLogger.printStackTrace(e2);
            return null;
        }
    }

    public static File getGameAssetsDownloadDirPath(Context context) {
        if (MBuildConfigUtils.getInstalledAppVersionCodeGradle() % 1000000 > 87) {
            return new File(getGameDirInternalStoragePath(context), GEFile.GAME_DIR_NEW_88);
        }
        if (MBuildConfigUtils.getInstalledAppVersionCodeGradle() % 1000000 > 25) {
            return new File(getGameDirInternalStoragePath(context), GEFile.GAME_DIR_NEW);
        }
        return new File(getGameDirInternalStoragePath(context), "assets");
    }

    public static String getGameAssetsInternalStorageZipPath(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(getGameDirInternalStoragePath(context));
        return GeneratedOutlineSupport.outline62(sb, File.separator, GEFile.GAME_ASSETS_NEW_ZIP_88);
    }

    public static String getGameAssetsPathByGameId(Context context, int i) {
        return getGameAssetsDownloadDirPath(context).getAbsolutePath() + File.separator + i + File.separator;
    }

    public static String getGameAssetsRelativeZipPath() {
        return GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73("game"), File.separator, GEFile.GAME_ASSETS_NEW_ZIP_88);
    }

    public static String getGameDirInternalStoragePath(Context context) {
        try {
            File appExternalDownloadStoragePath = FileUtils.getAppExternalDownloadStoragePath(context);
            if (appExternalDownloadStoragePath == null || (!appExternalDownloadStoragePath.exists() && !appExternalDownloadStoragePath.mkdirs())) {
                MLogger.d(TAG, "Unable to create Game assets directory");
            }
            if (appExternalDownloadStoragePath != null) {
                return appExternalDownloadStoragePath.getAbsolutePath();
            }
        } catch (Exception e2) {
            MLogger.printStackTrace(e2);
        }
        return "";
    }

    public static File getOldGameAssetsDownloadDirPath(Context context) {
        return new File(getGameDirInternalStoragePath(context), "assets");
    }

    public static File getSponsorAssetsDownloadDirPath(Context context) {
        return new File(getGameDirInternalStoragePath(context), Constant.SPONSOR);
    }

    public static boolean validateGameJson(Context context, int i) {
        boolean z;
        if (!new File(getGameAssetsPathByGameId(context, i), "mpl-manifest.json").exists()) {
            MLogger.d(Constant.ASSETS_CHECKING, "Json is not present/deleted in assets bundle");
        } else {
            MLogger.d(Constant.ASSETS_CHECKING, "Json is present validating Json First");
            HashMap<String, String> fileHashForAssets = getFileHashForAssets(context, i);
            if (fileHashForAssets != null) {
                byte[] reconstructKey = ConfigHelper.getInstance().reconstructKey(ConfigConstant.P1, MemoryLruCache.getCacheLru2());
                byte[] GetMD5HashOfString = GEInteractor.GetMD5HashOfString(fileHashForAssets.get(Constant.MD5_KEY));
                z = ConfigHelper.getInstance().isValidSignature(fileHashForAssets.get(Constant.SIGNATURE_KEY), GetMD5HashOfString, reconstructKey);
                MLogger.d(Constant.ASSETS_CHECKING, "JSON: ", Boolean.valueOf(z));
                return z;
            }
        }
        z = false;
        MLogger.d(Constant.ASSETS_CHECKING, "JSON: ", Boolean.valueOf(z));
        return z;
    }
}
