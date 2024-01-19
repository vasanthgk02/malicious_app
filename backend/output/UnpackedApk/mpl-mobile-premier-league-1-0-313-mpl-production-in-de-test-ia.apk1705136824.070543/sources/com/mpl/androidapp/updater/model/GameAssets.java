package com.mpl.androidapp.updater.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.cleverTap.AssetsAnalytics;
import org.apache.commons.lang.text.ExtendedMessageFormat;
import org.json.JSONObject;

public class GameAssets {
    public int assetVersion;
    public int gameId;
    public String gameName;
    public int gameVersion;
    public String hash;
    public boolean isRetry;
    public long size;
    public String url;

    public boolean equals(Object obj) {
        return this.gameId == ((Integer) obj).intValue();
    }

    public int getAssetVersion() {
        return this.assetVersion;
    }

    public int getGameId() {
        return this.gameId;
    }

    public String getGameName() {
        return this.gameName;
    }

    public int getGameVersion() {
        return this.gameVersion;
    }

    public String getHash() {
        return this.hash;
    }

    public long getSize() {
        return this.size;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isRetry() {
        return this.isRetry;
    }

    public void setAssetVersion(int i) {
        this.assetVersion = i;
    }

    public void setGameId(int i) {
        this.gameId = i;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public void setGameVersion(int i) {
        this.gameVersion = i;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public void setRetry(boolean z) {
        this.isRetry = z;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toJSon() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("Game Name", this.gameName);
            jSONObject.put("Game Id", this.gameId);
            jSONObject.put("Asset Version", this.assetVersion);
            jSONObject.put(AssetsAnalytics.PROP_GAME_VERSION, this.gameVersion);
            jSONObject.put("URL", this.url);
            jSONObject.put("Hash", this.hash);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("GameAssets{gameName='");
        GeneratedOutlineSupport.outline99(outline73, this.gameName, ExtendedMessageFormat.QUOTE, ", gameId=");
        outline73.append(this.gameId);
        outline73.append(", url='");
        GeneratedOutlineSupport.outline99(outline73, this.url, ExtendedMessageFormat.QUOTE, ", size=");
        outline73.append(this.size);
        outline73.append('}');
        return outline73.toString();
    }
}
