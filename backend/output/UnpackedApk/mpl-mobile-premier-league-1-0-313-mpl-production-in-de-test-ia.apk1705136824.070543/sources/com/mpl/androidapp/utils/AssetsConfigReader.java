package com.mpl.androidapp.utils;

import android.content.Context;
import android.text.TextUtils;
import com.mpl.androidapp.unity.usecases.LogCrashAnalyticsUseCase;
import com.mpl.androidapp.updater.model.GameAssets;
import com.mpl.androidapp.updater.util.UpdaterConstant.Assets;
import com.mpl.androidapp.updater.util.UpdaterConstant.Response;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AssetsConfigReader {
    public static final String TAG = "AssetsConfigReader";

    public static GameAssets getGameObjectForAsset(Context context, int i) {
        GameAssets gameAssets = null;
        try {
            String readFromAssets = readFromAssets(context, "game/game_assets_config.json");
            if (TextUtils.isEmpty(readFromAssets)) {
                return null;
            }
            JSONArray optJSONArray = new JSONObject(readFromAssets).optJSONArray(Response.GAME_ASSETS_ID);
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return null;
            }
            GameAssets gameAssets2 = new GameAssets();
            int i2 = 0;
            while (i2 < optJSONArray.length()) {
                try {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    int optInt = optJSONObject.optInt("game_id");
                    gameAssets2.setGameId(optJSONObject.optInt("game_id"));
                    gameAssets2.setGameName(optJSONObject.optString(Assets.GAME_NAME));
                    gameAssets2.setAssetVersion(optJSONObject.optInt("assetVersion", 1));
                    gameAssets2.setGameVersion(optJSONObject.optInt("gameVersion", 1));
                    if (optInt == i) {
                        break;
                    }
                    i2++;
                } catch (Exception e2) {
                    e = e2;
                    gameAssets = gameAssets2;
                    MLogger.e(TAG, "Error while parsing local json:->" + e);
                    return gameAssets;
                }
            }
            return gameAssets2;
        } catch (Exception e3) {
            e = e3;
            MLogger.e(TAG, "Error while parsing local json:->" + e);
            return gameAssets;
        }
    }

    public static int getVersionCode(Context context) {
        String readFromAssets = readFromAssets(context, "bundle/app.json");
        if (TextUtils.isEmpty(readFromAssets)) {
            return 0;
        }
        try {
            return new JSONObject(readFromAssets).optInt(Response.VERSION_CODE);
        } catch (JSONException e2) {
            MLogger.e(TAG, "", e2);
            return 0;
        }
    }

    public static List<GameAssets> listOfGameAssetsAvailable(Context context) {
        ArrayList arrayList = new ArrayList();
        String readFromAssets = readFromAssets(context, "game/game_assets_config.json");
        if (!TextUtils.isEmpty(readFromAssets)) {
            try {
                JSONArray optJSONArray = new JSONObject(readFromAssets).optJSONArray(Response.GAME_ASSETS_ID);
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        GameAssets gameAssets = new GameAssets();
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        gameAssets.setGameId(optJSONObject.optInt("game_id"));
                        gameAssets.setGameName(optJSONObject.optString(Assets.GAME_NAME));
                        gameAssets.setAssetVersion(optJSONObject.optInt("assetVersion", 1));
                        gameAssets.setGameVersion(optJSONObject.optInt("gameVersion", 1));
                        arrayList.add(gameAssets);
                    }
                }
            } catch (Exception e2) {
                MLogger.e(TAG, "", e2);
            }
        }
        return arrayList;
    }

    public static List<Integer> listOfGameAssetsAvailableArray(Context context) {
        ArrayList arrayList = new ArrayList();
        String readFromAssets = readFromAssets(context, "game/game_assets_config.json");
        if (!TextUtils.isEmpty(readFromAssets)) {
            try {
                JSONArray optJSONArray = new JSONObject(readFromAssets).optJSONArray(Response.GAME_ASSETS_ID);
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        arrayList.add(Integer.valueOf(optJSONArray.optJSONObject(i).optInt("game_id")));
                    }
                }
            } catch (JSONException e2) {
                MLogger.e(TAG, "", e2);
            }
        }
        return arrayList;
    }

    public static List<Integer> listOfGameCodeAvailable(Context context) {
        ArrayList arrayList = new ArrayList();
        String readFromAssets = readFromAssets(context, LogCrashAnalyticsUseCase.GAME_CONFIG_JSON_PATH);
        if (!TextUtils.isEmpty(readFromAssets)) {
            try {
                JSONArray optJSONArray = new JSONObject(readFromAssets).optJSONArray("game_code_id");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        arrayList.add(Integer.valueOf(optJSONArray.getInt(i)));
                    }
                }
            } catch (JSONException e2) {
                MLogger.e(TAG, "", e2);
            }
        }
        return arrayList;
    }

    public static String readFromAssets(Context context, String str) {
        try {
            InputStream open = context.getAssets().open(str);
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            return new String(bArr, "UTF-8");
        } catch (IOException e2) {
            MLogger.e(TAG, "", e2);
            return null;
        }
    }
}
