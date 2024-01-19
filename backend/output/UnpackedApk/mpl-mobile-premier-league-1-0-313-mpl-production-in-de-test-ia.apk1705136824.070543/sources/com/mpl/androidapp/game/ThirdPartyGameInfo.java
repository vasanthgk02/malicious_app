package com.mpl.androidapp.game;

public class ThirdPartyGameInfo {
    public String mDownloadUrl;
    public int mGameId;
    public String mGameName;
    public int mGameVersion;
    public String mMainActivity;
    public String mPackageName;

    public String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    public int getGameId() {
        return this.mGameId;
    }

    public String getGameName() {
        return this.mGameName;
    }

    public int getGameVersion() {
        return this.mGameVersion;
    }

    public String getMainActivity() {
        return this.mMainActivity;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public void setDownloadUrl(String str) {
        this.mDownloadUrl = str;
    }

    public void setGameId(int i) {
        this.mGameId = i;
    }

    public void setGameName(String str) {
        this.mGameName = str;
    }

    public void setGameVersion(int i) {
        this.mGameVersion = i;
    }

    public void setMainActivity(String str) {
        this.mMainActivity = str;
    }

    public void setPackageName(String str) {
        this.mPackageName = str;
    }
}
