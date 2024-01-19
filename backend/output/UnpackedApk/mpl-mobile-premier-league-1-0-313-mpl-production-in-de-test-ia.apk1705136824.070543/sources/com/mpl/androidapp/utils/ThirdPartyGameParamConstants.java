package com.mpl.androidapp.utils;

import com.google.gson.annotations.SerializedName;
import com.mpl.androidapp.updater.interactor.DBInteractor;

public class ThirdPartyGameParamConstants {
    public String AppId = MBuildConfigUtils.getApplicationId();
    public String AppType = MBuildConfigUtils.getAppType();
    public String AppVersionCode = String.valueOf(MBuildConfigUtils.getInstalledAppVersionCode());
    public String AppVersionName = String.valueOf(MBuildConfigUtils.getCurrentAppVersionName());
    public String AuthToken;
    public String CallbackUrl;
    public String CountryCode;
    public Double EntryFee;
    public boolean FraudBlockEnabled;
    public String GameName;
    public String HostUrl;
    public int InstalledApkVersionCode;
    public boolean IsLogEnabled = MBuildConfigUtils.isLogEnabled();
    public String LobbyId;
    public String MPLProCTId;
    public UserProfile Profile;
    public String ReactVersion = String.valueOf(DBInteractor.getCurrentRNBundleVersionCode());
    public boolean ShowMinimisePopupEnabled;
    public String TournamentId;
    public Double WinningAmount;
    public String gameConfig;
    @SerializedName(alternate = {"GameId"}, value = "gameId")
    public int gameId;
    public boolean isCashApp = MBuildConfigUtils.isCashApp();
    public boolean landscape;
    public String oAuth;
    public String oAuthToken;
    public String thirdPartyExtra;
    public int userId;

    public static class UserProfile {
        public String avatar;
        public String displayName;
        public String id;

        public String getAvatar() {
            return this.avatar;
        }

        public String getDisplayName() {
            return this.displayName;
        }

        public String getId() {
            return this.id;
        }

        public void setAvatar(String str) {
            this.avatar = str;
        }

        public void setDisplayName(String str) {
            this.displayName = str;
        }

        public void setId(String str) {
            this.id = str;
        }
    }

    public String getAppId() {
        return this.AppId;
    }

    public String getAppType() {
        return this.AppType;
    }

    public String getAppVersionCode() {
        return this.AppVersionCode;
    }

    public String getAppVersionName() {
        return this.AppVersionName;
    }

    public String getAuthToken() {
        return this.AuthToken;
    }

    public String getCallbackUrl() {
        return this.CallbackUrl;
    }

    public String getCountryCode() {
        return this.CountryCode;
    }

    public Double getEntryFee() {
        return this.EntryFee;
    }

    public boolean getFraudBlockEnabled() {
        return this.FraudBlockEnabled;
    }

    public String getGameConfig() {
        return this.gameConfig;
    }

    public int getGameId() {
        return this.gameId;
    }

    public String getGameName() {
        return this.GameName;
    }

    public String getHostUrl() {
        return this.HostUrl;
    }

    public int getInstalledApkVersionCode() {
        return this.InstalledApkVersionCode;
    }

    public String getLobbyId() {
        return this.LobbyId;
    }

    public String getMPLProCTId() {
        return this.MPLProCTId;
    }

    public UserProfile getProfile() {
        return this.Profile;
    }

    public String getReactVersion() {
        return this.ReactVersion;
    }

    public String getThirdPartyExtra() {
        return this.thirdPartyExtra;
    }

    public String getTournamentId() {
        return this.TournamentId;
    }

    public int getUserId() {
        return this.userId;
    }

    public Double getWinningAmount() {
        return this.WinningAmount;
    }

    public String getoAuth() {
        return this.oAuth;
    }

    public String getoAuthToken() {
        return this.oAuthToken;
    }

    public boolean isCashApp() {
        return this.isCashApp;
    }

    public boolean isLandscape() {
        return this.landscape;
    }

    public boolean isLogEnabled() {
        return this.IsLogEnabled;
    }

    public boolean isShowMinimisePopupEnabled() {
        return this.ShowMinimisePopupEnabled;
    }

    public void setAppId(String str) {
        this.AppId = str;
    }

    public void setAppType(String str) {
        this.AppType = str;
    }

    public void setAppVersionCode(String str) {
        this.AppVersionCode = str;
    }

    public void setAppVersionName(String str) {
        this.AppVersionName = str;
    }

    public void setAuthToken(String str) {
        this.AuthToken = str;
    }

    public void setCallbackUrl(String str) {
        this.CallbackUrl = str;
    }

    public void setCashApp(boolean z) {
        this.isCashApp = z;
    }

    public void setCountryCode(String str) {
        this.CountryCode = str;
    }

    public void setEntryFee(Double d2) {
        this.EntryFee = d2;
    }

    public void setFraudBlockEnabled(boolean z) {
        this.FraudBlockEnabled = z;
    }

    public void setGameConfig(String str) {
        this.gameConfig = str;
    }

    public void setGameId(int i) {
        this.gameId = i;
    }

    public void setGameName(String str) {
        this.GameName = str;
    }

    public void setHostUrl(String str) {
        this.HostUrl = str;
    }

    public void setInstalledApkVersionCode(int i) {
        this.InstalledApkVersionCode = i;
    }

    public void setLandscape(boolean z) {
        this.landscape = z;
    }

    public void setLobbyId(String str) {
        this.LobbyId = str;
    }

    public void setLogEnabled(boolean z) {
        this.IsLogEnabled = z;
    }

    public void setMPLProCTId(String str) {
        this.MPLProCTId = str;
    }

    public void setProfile(UserProfile userProfile) {
        this.Profile = userProfile;
    }

    public void setReactVersion(String str) {
        this.ReactVersion = str;
    }

    public void setShowMinimisePopupEnabled(boolean z) {
        this.ShowMinimisePopupEnabled = z;
    }

    public void setThirdPartyExtra(String str) {
        this.thirdPartyExtra = str;
    }

    public void setTournamentId(String str) {
        this.TournamentId = str;
    }

    public void setUserId(int i) {
        this.userId = i;
    }

    public void setWinningAmount(Double d2) {
        this.WinningAmount = d2;
    }

    public void setoAuth(String str) {
        this.oAuth = str;
    }

    public void setoAuthToken(String str) {
        this.oAuthToken = str;
    }
}
