package com.mpl.androidapp.database.model;

public class Asset {
    public int appVersion;
    public int assetVersion;
    public long firstDownloadTime;
    public int gameId;
    public int gameVersion;
    public long lastModifiedTime;
    public int modifiedAppVersion;
    public int modifiedReactVersion;
    public int reactVersion;
    public int uid;

    public int getAppVersion() {
        return this.appVersion;
    }

    public int getAssetVersion() {
        return this.assetVersion;
    }

    public long getFirstDownloadTime() {
        return this.firstDownloadTime;
    }

    public int getGameId() {
        return this.gameId;
    }

    public int getGameVersion() {
        return this.gameVersion;
    }

    public long getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    public int getModifiedAppVersion() {
        return this.modifiedAppVersion;
    }

    public int getModifiedReactVersion() {
        return this.modifiedReactVersion;
    }

    public int getReactVersion() {
        return this.reactVersion;
    }

    public int getUid() {
        return this.uid;
    }

    public void setAppVersion(int i) {
        this.appVersion = i;
    }

    public void setAssetVersion(int i) {
        this.assetVersion = i;
    }

    public void setFirstDownloadTime(long j) {
        this.firstDownloadTime = j;
    }

    public void setGameId(int i) {
        this.gameId = i;
    }

    public void setGameVersion(int i) {
        this.gameVersion = i;
    }

    public void setLastModifiedTime(long j) {
        this.lastModifiedTime = j;
    }

    public void setModifiedAppVersion(int i) {
        this.modifiedAppVersion = i;
    }

    public void setModifiedReactVersion(int i) {
        this.modifiedReactVersion = i;
    }

    public void setReactVersion(int i) {
        this.reactVersion = i;
    }

    public void setUid(int i) {
        this.uid = i;
    }
}
