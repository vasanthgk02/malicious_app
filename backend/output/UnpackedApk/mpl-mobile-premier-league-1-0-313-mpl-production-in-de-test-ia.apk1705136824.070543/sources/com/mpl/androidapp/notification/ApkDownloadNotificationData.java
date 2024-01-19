package com.mpl.androidapp.notification;

import android.content.Context;
import com.mpl.androidapp.cleverTap.AssetsAnalytics;
import org.json.JSONObject;

public class ApkDownloadNotificationData {
    public Context context;
    public String gameIconUrl;
    public int gameId;
    public String gameName;
    public boolean isDownloaded;
    public boolean isForceUpdate;
    public String packageName;
    public int percentage;
    public String serverVersion;

    public Context getContext() {
        return this.context;
    }

    public String getGameIconUrl() {
        return this.gameIconUrl;
    }

    public int getGameId() {
        return this.gameId;
    }

    public String getGameName() {
        return this.gameName;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getPercentage() {
        return this.percentage;
    }

    public String getServerVersion() {
        return this.serverVersion;
    }

    public boolean isDownloaded() {
        return this.isDownloaded;
    }

    public boolean isForceUpdate() {
        return this.isForceUpdate;
    }

    public void setContext(Context context2) {
        this.context = context2;
    }

    public void setDownloaded(boolean z) {
        this.isDownloaded = z;
    }

    public void setForceUpdate(boolean z) {
        this.isForceUpdate = z;
    }

    public void setGameIconUrl(String str) {
        this.gameIconUrl = str;
    }

    public void setGameId(int i) {
        this.gameId = i;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setPercentage(int i) {
        this.percentage = i;
    }

    public void setServerVersion(String str) {
        this.serverVersion = str;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("Percentage", this.percentage);
            jSONObject.put(AssetsAnalytics.PROP_IS_FORCE_UPDATE, this.isForceUpdate);
            jSONObject.put("Game Name", this.gameName);
            jSONObject.put("Game Id", this.gameId);
            jSONObject.put(AssetsAnalytics.PROP_GAME_VERSION, this.serverVersion);
            jSONObject.put("Is Downloaded", this.isDownloaded);
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
