package com.mpl.androidapp.cleverTap;

import com.mpl.androidapp.utils.AssetsUtils;

public class AssetsAnalyticsProps {
    public String assetsInstalledFailReason;
    public long assetsSize;
    public String assetsType;
    public int assetsVersion;
    public String downloadFailReason;
    public String downloadFailReasonV2;
    public boolean downloadSuccess;
    public long downloadTime;
    public String downloadType;
    public int gameId;
    public String gameName;
    public int installedVersion;
    public boolean isAlreadyDownloaded;
    public boolean isAssetsInstallSuccess;
    public boolean isAvailableOnServer;
    public boolean isBackground;
    public boolean isLatest;
    public boolean isUpdateAssets;
    public int queuePriority;
    public boolean queued;
    public boolean retry;
    public int retryCount;
    public String screenName;
    public int serverVersion;

    public String getAssetsInstalledFailReason() {
        return this.assetsInstalledFailReason;
    }

    public long getAssetsSize() {
        return this.assetsSize;
    }

    public String getAssetsType() {
        return this.assetsType;
    }

    public int getAssetsVersion() {
        return this.assetsVersion;
    }

    public String getDownloadFailReason() {
        return this.downloadFailReason;
    }

    public String getDownloadFailReasonV2() {
        return this.downloadFailReasonV2;
    }

    public String getDownloadMode() {
        int i = this.gameId;
        if (i != 0 && AssetsUtils.isNewDownloader(i)) {
            return "Android Downloader";
        }
        if (this.gameId != 1000167 || !AssetsUtils.isNewDownloaderPoker()) {
            return "MPL Downloader";
        }
        return "Android Downloader";
    }

    public long getDownloadTime() {
        return this.downloadTime;
    }

    public String getDownloadType() {
        return this.downloadType;
    }

    public int getGameId() {
        return this.gameId;
    }

    public String getGameName() {
        return this.gameName;
    }

    public int getInstalledVersion() {
        return this.installedVersion;
    }

    public int getQueuePriority() {
        return this.queuePriority;
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    public String getScreenName() {
        return this.screenName;
    }

    public int getServerVersion() {
        return this.serverVersion;
    }

    public boolean isAlreadyDownloaded() {
        return this.isAlreadyDownloaded;
    }

    public boolean isAssetsInstallSuccess() {
        return this.isAssetsInstallSuccess;
    }

    public boolean isAvailableOnServer() {
        return this.isAvailableOnServer;
    }

    public boolean isBackground() {
        return this.isBackground;
    }

    public boolean isDownloadSuccess() {
        return this.downloadSuccess;
    }

    public boolean isLatest() {
        return this.isLatest;
    }

    public boolean isQueued() {
        return this.queued;
    }

    public boolean isRetry() {
        return this.retry;
    }

    public boolean isUpdateAssets() {
        return this.isUpdateAssets;
    }

    public void setAlreadyDownloaded(boolean z) {
        this.isAlreadyDownloaded = z;
    }

    public void setAssetsInstallSuccess(boolean z) {
        this.isAssetsInstallSuccess = z;
    }

    public void setAssetsInstalledFailReason(String str) {
        this.assetsInstalledFailReason = str;
    }

    public void setAssetsSize(long j) {
        this.assetsSize = j;
    }

    public void setAssetsType(String str) {
        this.assetsType = str;
    }

    public void setAssetsVersion(int i) {
        this.assetsVersion = i;
    }

    public void setAvailableOnServer(boolean z) {
        this.isAvailableOnServer = z;
    }

    public void setBackground(boolean z) {
        this.isBackground = z;
    }

    public void setDownloadFailReason(String str) {
        this.downloadFailReason = str;
    }

    public void setDownloadFailReasonV2(String str) {
        this.downloadFailReasonV2 = str;
    }

    public void setDownloadSuccess(boolean z) {
        this.downloadSuccess = z;
    }

    public void setDownloadTime(long j) {
        this.downloadTime = j;
    }

    public void setDownloadType(String str) {
        this.downloadType = str;
    }

    public void setGameId(int i) {
        this.gameId = i;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public void setInstalledVersion(int i) {
        this.installedVersion = i;
    }

    public void setLatest(boolean z) {
        this.isLatest = z;
    }

    public void setQueuePriority(int i) {
        this.queuePriority = i;
    }

    public void setQueued(boolean z) {
        this.queued = z;
    }

    public void setRetry(boolean z) {
        this.retry = z;
    }

    public void setRetryCount(int i) {
        this.retryCount = i;
    }

    public void setScreenName(String str) {
        this.screenName = str;
    }

    public void setServerVersion(int i) {
        this.serverVersion = i;
    }

    public void setUpdateAssets(boolean z) {
        this.isUpdateAssets = z;
    }
}
