package com.mpl.androidapp.game;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Android implements Serializable {
    public static final long serialVersionUID = -8838802520269906465L;
    @SerializedName("assets")
    @Expose
    public Assets assets;
    @SerializedName("downloadUrl")
    @Expose
    public String downloadUrl;
    @SerializedName("version")
    @Expose
    public String version;

    public Assets getAssets() {
        return this.assets;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public String getVersion() {
        return this.version;
    }

    public void setAssets(Assets assets2) {
        this.assets = assets2;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
