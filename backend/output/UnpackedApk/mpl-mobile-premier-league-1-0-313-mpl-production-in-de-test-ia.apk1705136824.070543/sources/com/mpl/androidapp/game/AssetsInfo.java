package com.mpl.androidapp.game;

public class AssetsInfo {
    public int assetVersion;
    public int gameVersion;
    public int maxGameSupport;
    public int minApkVersionSupport;

    public AssetsInfo(int i, int i2) {
        this.minApkVersionSupport = i;
        this.assetVersion = i2;
    }

    public int getAssetVersion() {
        return this.assetVersion;
    }

    public int getGameVersion() {
        return this.gameVersion;
    }

    public int getMaxGameSupport() {
        return this.maxGameSupport;
    }

    public int getMinApkVersionSupport() {
        return this.minApkVersionSupport;
    }

    public void setAssetVersion(int i) {
        this.assetVersion = i;
    }

    public void setGameVersion(int i) {
        this.gameVersion = i;
    }

    public void setMaxGameSupport(int i) {
        this.maxGameSupport = i;
    }

    public void setMinApkVersionSupport(int i) {
        this.minApkVersionSupport = i;
    }
}
