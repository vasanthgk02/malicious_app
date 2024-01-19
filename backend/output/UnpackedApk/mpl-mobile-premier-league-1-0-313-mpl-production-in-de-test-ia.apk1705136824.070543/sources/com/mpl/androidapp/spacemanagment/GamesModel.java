package com.mpl.androidapp.spacemanagment;

import android.graphics.drawable.Drawable;

public class GamesModel {
    public String appName;
    public int gameId;
    public Drawable icon;
    public String imageUrl;
    public boolean isUninstall;
    public long lastUpdatedTime;
    public String packageName;
    public long size;
    public String versionNo;

    public String getAppName() {
        return this.appName;
    }

    public int getGameId() {
        return this.gameId;
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public long getLastUpdatedTime() {
        return this.lastUpdatedTime;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public Long getSize() {
        return Long.valueOf(this.size);
    }

    public String getVersionNo() {
        return this.versionNo;
    }

    public boolean isUninstall() {
        return this.isUninstall;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setGameId(int i) {
        this.gameId = i;
    }

    public void setIcon(Drawable drawable) {
        this.icon = drawable;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setLastUpdatedTime(long j) {
        this.lastUpdatedTime = j;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public void setUninstall(boolean z) {
        this.isUninstall = z;
    }

    public void setVersionNo(String str) {
        this.versionNo = str;
    }
}
