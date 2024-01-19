package com.mpl.androidapp.game;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApkInfo {
    @SerializedName("apkHash")
    @Expose
    public String apkHash;
    @SerializedName("assetsVersion")
    @Expose
    public Integer assetsVersion;
    @SerializedName("attributionUrl")
    @Expose
    public String attributionUrl;
    @SerializedName("authUrl")
    @Expose
    public String authUrl = "";
    @SerializedName("autoDownload")
    @Expose
    public boolean autoDownload = false;
    @SerializedName("deviceSupportMessage")
    @Expose
    public String deviceSupportMessage;
    @SerializedName("deviceSupportRequirement")
    @Expose
    public DeviceSupportRequirement deviceSupportRequirement;
    @SerializedName("deviceSupportTitle")
    @Expose
    public String deviceSupportTitle;
    @SerializedName("downloadUrl")
    @Expose
    public String downloadUrl;
    @SerializedName("extraInfo")
    @Expose
    public String extraInfo;
    @SerializedName("forceUpdate")
    @Expose
    public boolean forceUpdate;
    @SerializedName("gameId")
    @Expose
    public Integer gameId;
    @SerializedName("gameName")
    @Expose
    public String gameName;
    @SerializedName("gamePlays")
    @Expose
    public String gamePlays;
    @SerializedName("gameVersion")
    @Expose
    public String gameVersion;
    @SerializedName("installTrackUrl")
    @Expose
    public String installTrackUrl;
    @SerializedName("installationSpaceRequired")
    @Expose
    public Integer installationSpaceRequired;
    @SerializedName("installs")
    @Expose
    public String installs;
    @SerializedName("isAttributionEnabled")
    @Expose
    public boolean isAttributionEnabled = false;
    @SerializedName("isCredentialEnabled")
    @Expose
    public boolean isCredentialEnabled = false;
    @SerializedName("isInstallTrackEnabled")
    @Expose
    public boolean isInstallTrackEnabled = false;
    @SerializedName("isMPLSdk")
    @Expose
    public boolean isMPLSdk;
    @SerializedName("isOriginals")
    @Expose
    public boolean isOriginals = false;
    @SerializedName("isPlayStoreApp")
    @Expose
    public boolean isPlayStoreApp = false;
    @SerializedName("isSecureAuth")
    @Expose
    public boolean isSecureAuth = false;
    @SerializedName("isThirdParty")
    @Expose
    public boolean isThirdParty;
    @SerializedName("isThirdPartyMatchMaking")
    @Expose
    public boolean isThirdPartyMatchMaking;
    @SerializedName("isWebSupport")
    @Expose
    public boolean isWebSupport;
    @SerializedName("isWebSupportMatchMaking")
    @Expose
    public boolean isWebSupportMatchMaking;
    @SerializedName("isWebSupportSDK")
    @Expose
    public boolean isWebSupportSDK;
    @SerializedName("launchingIndex")
    @Expose
    public int launchingIndex = 0;
    @SerializedName("logo")
    @Expose
    public String logo;
    @SerializedName("mainActivity")
    @Expose
    public String mainActivity;
    @SerializedName("minAppVersion")
    @Expose
    public Integer minAppVersion;
    @SerializedName("packageName")
    @Expose
    public String packageName;
    @SerializedName("rating")
    @Expose
    public String rating;
    @SerializedName("redirectHeader")
    @Expose
    public String redirectHeader;
    @SerializedName("redirectUrl")
    @Expose
    public String redirectUrl;
    @SerializedName("shouldAlwaysOpenPS")
    @Expose
    public boolean shouldAlwaysOpenPS = false;
    @SerializedName("shouldLaunchPlayStore")
    @Expose
    public boolean shouldLaunchPlayStore;
    @SerializedName("shouldLaunchSameInstance")
    @Expose
    public boolean shouldLaunchSameInstance = false;
    @SerializedName("shouldShowNotification")
    @Expose
    public boolean shouldShowNotification = true;
    @SerializedName("showDownloadPopUp")
    @Expose
    public boolean showDownloadPopUp = true;
    @SerializedName("showInstallToast")
    @Expose
    public boolean showInstallToast = true;
    @SerializedName("signature")
    @Expose
    public String signature;
    @SerializedName("size")
    @Expose
    public String size;

    public ApkInfo() {
        Integer valueOf = Integer.valueOf(0);
        this.assetsVersion = valueOf;
        this.installationSpaceRequired = valueOf;
        this.minAppVersion = valueOf;
    }

    public String getApkHash() {
        return this.apkHash;
    }

    public Integer getAssetsVersion() {
        return this.assetsVersion;
    }

    public String getAttributionUrl() {
        return this.attributionUrl;
    }

    public String getAuthUrl() {
        return this.authUrl;
    }

    public String getDeviceSupportMessage() {
        return this.deviceSupportMessage;
    }

    public DeviceSupportRequirement getDeviceSupportRequirement() {
        return this.deviceSupportRequirement;
    }

    public String getDeviceSupportTitle() {
        return this.deviceSupportTitle;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public String getExtraInfo() {
        return this.extraInfo;
    }

    public boolean getForceUpdate() {
        return this.forceUpdate;
    }

    public Integer getGameId() {
        return this.gameId;
    }

    public String getGameName() {
        return this.gameName;
    }

    public String getGamePlays() {
        return this.gamePlays;
    }

    public String getGameVersion() {
        return this.gameVersion;
    }

    public String getInstallTrackUrl() {
        return this.installTrackUrl;
    }

    public Integer getInstallationSpaceRequired() {
        return this.installationSpaceRequired;
    }

    public String getInstalls() {
        return this.installs;
    }

    public int getLaunchingIndex() {
        return this.launchingIndex;
    }

    public String getLogo() {
        return this.logo;
    }

    public String getMainActivity() {
        return this.mainActivity;
    }

    public Integer getMinAppVersion() {
        return this.minAppVersion;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getRating() {
        return this.rating;
    }

    public String getRedirectHeader() {
        return this.redirectHeader;
    }

    public String getRedirectUrl() {
        return this.redirectUrl;
    }

    public boolean getShouldLaunchPlayStore() {
        return this.shouldLaunchPlayStore;
    }

    public String getSignature() {
        return this.signature;
    }

    public String getSize() {
        return this.size;
    }

    public boolean isAttributionEnabled() {
        return this.isAttributionEnabled;
    }

    public boolean isAutoDownload() {
        return this.autoDownload;
    }

    public boolean isCredentialEnabled() {
        return this.isCredentialEnabled;
    }

    public boolean isInstallTrackEnabled() {
        return this.isInstallTrackEnabled;
    }

    public boolean isMPLSdk() {
        return this.isMPLSdk;
    }

    public boolean isOriginals() {
        return this.isOriginals;
    }

    public boolean isPlayStoreApp() {
        return this.isPlayStoreApp;
    }

    public boolean isSecureAuth() {
        return this.isSecureAuth;
    }

    public boolean isShouldAlwaysOpenPS() {
        return this.shouldAlwaysOpenPS;
    }

    public boolean isShouldShowNotification() {
        return this.shouldShowNotification;
    }

    public boolean isShowDownloadPopUp() {
        return this.showDownloadPopUp;
    }

    public boolean isShowInstallToast() {
        return this.showInstallToast;
    }

    public boolean isThirdParty() {
        return this.isThirdParty;
    }

    public boolean isThirdPartyMatchMaking() {
        return this.isThirdPartyMatchMaking;
    }

    public boolean isWebSupport() {
        return this.isWebSupport;
    }

    public boolean isWebSupportMatchMaking() {
        return this.isWebSupportMatchMaking;
    }

    public boolean isWebSupportSDK() {
        return this.isWebSupportSDK;
    }

    public void setApkHash(String str) {
        this.apkHash = str;
    }

    public void setAssetsVersion(Integer num) {
        this.assetsVersion = num;
    }

    public void setAttributionEnabled(boolean z) {
        this.isAttributionEnabled = z;
    }

    public void setAttributionUrl(String str) {
        this.attributionUrl = str;
    }

    public void setAuthUrl(String str) {
        this.authUrl = str;
    }

    public void setAutoDownload(boolean z) {
        this.autoDownload = z;
    }

    public void setCredentialEnabled(boolean z) {
        this.isCredentialEnabled = z;
    }

    public void setDeviceSupportMessage(String str) {
        this.deviceSupportMessage = str;
    }

    public void setDeviceSupportRequirement(DeviceSupportRequirement deviceSupportRequirement2) {
        this.deviceSupportRequirement = deviceSupportRequirement2;
    }

    public void setDeviceSupportTitle(String str) {
        this.deviceSupportTitle = str;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public void setExtraInfo(String str) {
        this.extraInfo = str;
    }

    public void setForceUpdate(boolean z) {
        this.forceUpdate = z;
    }

    public void setGameId(Integer num) {
        this.gameId = num;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public void setGamePlays(String str) {
        this.gamePlays = str;
    }

    public void setGameVersion(String str) {
        this.gameVersion = str;
    }

    public void setInstallTrackEnabled(boolean z) {
        this.isInstallTrackEnabled = z;
    }

    public void setInstallTrackUrl(String str) {
        this.installTrackUrl = str;
    }

    public void setInstallationSpaceRequired(Integer num) {
        this.installationSpaceRequired = num;
    }

    public void setInstalls(String str) {
        this.installs = str;
    }

    public void setIsThirdParty(boolean z) {
        this.isThirdParty = z;
    }

    public void setIsThirdPartyMatchMaking(boolean z) {
        this.isThirdPartyMatchMaking = z;
    }

    public void setIsWebSupport(boolean z) {
        this.isWebSupport = z;
    }

    public void setIsWebSupportMatchMaking(boolean z) {
        this.isWebSupportMatchMaking = z;
    }

    public void setLaunchingIndex(int i) {
        this.launchingIndex = i;
    }

    public void setLogo(String str) {
        this.logo = str;
    }

    public void setMPLSdk(boolean z) {
        this.isMPLSdk = z;
    }

    public void setMainActivity(String str) {
        this.mainActivity = str;
    }

    public void setMinAppVersion(Integer num) {
        this.minAppVersion = num;
    }

    public void setOriginals(boolean z) {
        this.isOriginals = z;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setPlayStoreApp(boolean z) {
        this.isPlayStoreApp = z;
    }

    public void setRating(String str) {
        this.rating = str;
    }

    public void setRedirectHeader(String str) {
        this.redirectHeader = str;
    }

    public void setRedirectUrl(String str) {
        this.redirectUrl = str;
    }

    public void setSecureAuth(boolean z) {
        this.isSecureAuth = z;
    }

    public void setShouldAlwaysOpenPS(boolean z) {
        this.shouldAlwaysOpenPS = z;
    }

    public void setShouldLaunchPlayStore(boolean z) {
        this.shouldLaunchPlayStore = z;
    }

    public void setShouldLaunchSameInstance(boolean z) {
        this.shouldLaunchSameInstance = z;
    }

    public void setShouldShowNotification(boolean z) {
        this.shouldShowNotification = z;
    }

    public void setShowDownloadPopUp(boolean z) {
        this.showDownloadPopUp = z;
    }

    public void setShowInstallToast(boolean z) {
        this.showInstallToast = z;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public void setSize(String str) {
        this.size = str;
    }

    public void setWebSupportSDK(boolean z) {
        this.isWebSupportSDK = z;
    }

    public boolean shouldLaunchSameInstance() {
        return this.shouldLaunchSameInstance;
    }
}
