package com.mpl.androidapp.smartfox;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GameConfig implements Serializable {
    public static final long serialVersionUID = 2224758570060235294L;
    @SerializedName("IsKnockoutLobby")
    @Expose
    public Boolean IsKnockoutLobby;
    @SerializedName("AppId")
    @Expose
    public String appId;
    @SerializedName("AppType")
    @Expose
    public String appType;
    @SerializedName("AppVersionCode")
    @Expose
    public String appVersionCode;
    @SerializedName("AppVersionName")
    @Expose
    public String appVersionName;
    @SerializedName("ApplyBonusLimit")
    @Expose
    public Boolean applyBonusLimit;
    @SerializedName("AuthToken")
    @Expose
    public String authToken;
    @SerializedName("AutoStartTimer")
    @Expose
    public Double autoStartTimer;
    @SerializedName("Balance")
    @Expose
    public Balance balance;
    @SerializedName("battingMultiplayer")
    @Expose
    public Boolean battingMultiplayer;
    @SerializedName("BattleAgainTimeout")
    @Expose
    public Double battleAgainTimeout;
    @SerializedName("BattleScoreSyncInSec")
    @Expose
    public Double battleScoreSyncInSec;
    @SerializedName("BonusLimit")
    @Expose
    public Double bonusLimit;
    @SerializedName("CallbackUrl")
    @Expose
    public String callbackUrl;
    @SerializedName("ConnectionRetryTimeout")
    @Expose
    public Double connectionRetryTimeout;
    @SerializedName("CountryCode")
    @Expose
    public String countryCode;
    @SerializedName("CreateGameTimeout")
    @Expose
    public Double createGameTimeout;
    @SerializedName("DynamicRewards")
    @Expose
    public List<DynamicReward> dynamicRewards = new ArrayList();
    @SerializedName("enableAudioChat")
    @Expose
    public Boolean enableAudioChat;
    @SerializedName("EntryCurrency")
    @Expose
    public String entryCurrency;
    @SerializedName("EntryFee")
    @Expose
    public Double entryFee;
    @SerializedName("extraInfo")
    @Expose
    public String extraInfo;
    @SerializedName("GameConfigName")
    @Expose
    public String gameConfigName;
    @SerializedName("GameId")
    @Expose
    public Integer gameId;
    @SerializedName("GameName")
    @Expose
    public String gameName;
    @SerializedName("Host")
    @Expose
    public String host;
    @SerializedName("ICLostMessage")
    @Expose
    public String iCLostMessage;
    @SerializedName("ICLostTitle")
    @Expose
    public String iCLostTitle;
    @SerializedName("InstalledApkVersionCode")
    @Expose
    public int installedApkVersionCode;
    @SerializedName("Is1v1")
    @Expose
    public Boolean is1v1;
    @SerializedName("Is1vN")
    @Expose
    public Boolean is1vN;
    @SerializedName("IsAutoStartEnabled")
    @Expose
    public Boolean isAutoStartEnabled;
    @SerializedName("isChallengeEnabled")
    @Expose
    public Boolean isChallengeEnabled;
    @SerializedName("IsFTUE")
    @Expose
    public Boolean isFTUE;
    @SerializedName("isItQuitByAndroid")
    @Expose
    public Boolean isItQuitByAndroid;
    @SerializedName("IsLocalChannelMuted")
    @Expose
    public Boolean isLocalChannelMuted;
    @SerializedName("IsModAppFound")
    @Expose
    public Boolean isModAppFound;
    @SerializedName("IsPermissionAccepted")
    @Expose
    public Boolean isPermissionAccepted;
    @SerializedName("IsRemoteChannelMuted")
    @Expose
    public Boolean isRemoteChannelMuted;
    @SerializedName("IsRooted")
    @Expose
    public Boolean isRooted;
    @SerializedName("isTierEnabled")
    @Expose
    public Boolean isTierEnabled;
    @SerializedName("IsUpsellEnabled")
    @Expose
    public Boolean isUpsellEnabled;
    @SerializedName("IsVoiceChatRequired")
    @Expose
    public Boolean isVoiceChatRequired;
    @SerializedName("IsVoiceChatRequiredLobby")
    @Expose
    public Boolean isVoiceChatRequiredLobby;
    @SerializedName("LobbyActiveEndTime")
    @Expose
    public String lobbyActiveEndTime;
    @SerializedName("LobbyEndTime")
    @Expose
    public String lobbyEndTime;
    @SerializedName("LobbyId")
    @Expose
    public Double lobbyId;
    @SerializedName("MaxBonusPercentage")
    @Expose
    public Double maxBonusPercentage;
    @SerializedName("MaxPauseDuration")
    @Expose
    public Double maxPauseDuration;
    @SerializedName("MaxPongDelay")
    @Expose
    public Double maxPongDelay;
    @SerializedName("MobileNumber")
    @Expose
    public String mobileNumber;
    @SerializedName("PhotonAppId")
    @Expose
    public String photonAppId;
    @SerializedName("PingInterval")
    @Expose
    public Double pingInterval;
    @SerializedName("Profile")
    @Expose
    public Profile profile;
    @SerializedName("ReactVersion")
    @Expose
    public String reactVersion;
    @SerializedName("SequenceInterval")
    @Expose
    public Double sequenceInterval;
    @SerializedName("SessionId")
    @Expose
    public String sessionId;
    @SerializedName("SingleEntryBattle")
    @Expose
    public Boolean singleEntryBattle;
    @SerializedName("sponsorBattle")
    @Expose
    public Boolean sponsorBattle;
    @SerializedName("StartTime")
    @Expose
    public Long startTime;
    @SerializedName("thirdPartyExtra")
    @Expose
    public String thirdPartyExtra;
    @SerializedName("TotalPlayers")
    @Expose
    public Double totalPlayers;
    @SerializedName("TournamentDescription")
    @Expose
    public String tournamentDescription;
    @SerializedName("TournamentId")
    @Expose
    public Long tournamentId;
    @SerializedName("TournamentName")
    @Expose
    public String tournamentName;
    @SerializedName("UserMatchRatingMax")
    @Expose
    public Double userMatchRatingMax;
    @SerializedName("UserMatchRatingMin")
    @Expose
    public Double userMatchRatingMin;
    @SerializedName("UserRating")
    @Expose
    public Double userRating;
    @SerializedName("WinningAmount")
    @Expose
    public Double winningAmount;
    @SerializedName("Zone")
    @Expose
    public String zone;

    public int describeContents() {
        return 0;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppType() {
        return this.appType;
    }

    public String getAppVersionCode() {
        return this.appVersionCode;
    }

    public String getAppVersionName() {
        return this.appVersionName;
    }

    public Boolean getApplyBonusLimit() {
        return this.applyBonusLimit;
    }

    public String getAuthToken() {
        return this.authToken;
    }

    public Double getAutoStartTimer() {
        return this.autoStartTimer;
    }

    public Balance getBalance() {
        return this.balance;
    }

    public Boolean getBattingMultiplayer() {
        return this.battingMultiplayer;
    }

    public Double getBattleAgainTimeout() {
        return this.battleAgainTimeout;
    }

    public Double getBattleScoreSyncInSec() {
        return this.battleScoreSyncInSec;
    }

    public Double getBonusLimit() {
        return this.bonusLimit;
    }

    public String getCallbackUrl() {
        return this.callbackUrl;
    }

    public Double getConnectionRetryTimeout() {
        return this.connectionRetryTimeout;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public Double getCreateGameTimeout() {
        return this.createGameTimeout;
    }

    public List<DynamicReward> getDynamicRewards() {
        return this.dynamicRewards;
    }

    public Boolean getEnableAudioChat() {
        return this.enableAudioChat;
    }

    public String getEntryCurrency() {
        return this.entryCurrency;
    }

    public Double getEntryFee() {
        return this.entryFee;
    }

    public String getExtraInfo() {
        return this.extraInfo;
    }

    public String getGameConfigName() {
        return this.gameConfigName;
    }

    public Integer getGameId() {
        return this.gameId;
    }

    public String getGameName() {
        return this.gameName;
    }

    public String getHost() {
        return this.host;
    }

    public String getICLostMessage() {
        return this.iCLostMessage;
    }

    public String getICLostTitle() {
        return this.iCLostTitle;
    }

    public int getInstalledApkVersionCode() {
        return this.installedApkVersionCode;
    }

    public Boolean getIs1v1() {
        return this.is1v1;
    }

    public Boolean getIs1vN() {
        return this.is1vN;
    }

    public Boolean getIsAutoStartEnabled() {
        return this.isAutoStartEnabled;
    }

    public Boolean getIsChallengeEnabled() {
        return this.isChallengeEnabled;
    }

    public Boolean getIsFTUE() {
        return this.isFTUE;
    }

    public Boolean getIsItQuitByAndroid() {
        return this.isItQuitByAndroid;
    }

    public Boolean getIsLocalChannelMuted() {
        return this.isLocalChannelMuted;
    }

    public Boolean getIsModAppFound() {
        return this.isModAppFound;
    }

    public Boolean getIsPermissionAccepted() {
        return this.isPermissionAccepted;
    }

    public Boolean getIsRemoteChannelMuted() {
        return this.isRemoteChannelMuted;
    }

    public Boolean getIsRooted() {
        return this.isRooted;
    }

    public Boolean getIsTierEnabled() {
        return this.isTierEnabled;
    }

    public Boolean getIsUpsellEnabled() {
        return this.isUpsellEnabled;
    }

    public Boolean getIsVoiceChatRequired() {
        return this.isVoiceChatRequired;
    }

    public Boolean getIsVoiceChatRequiredLobby() {
        return this.isVoiceChatRequiredLobby;
    }

    public Boolean getKnockoutLobby() {
        return this.IsKnockoutLobby;
    }

    public String getLobbyActiveEndTime() {
        return this.lobbyActiveEndTime;
    }

    public String getLobbyEndTime() {
        return this.lobbyEndTime;
    }

    public Double getLobbyId() {
        return this.lobbyId;
    }

    public Double getMaxBonusPercentage() {
        return this.maxBonusPercentage;
    }

    public Double getMaxPauseDuration() {
        return this.maxPauseDuration;
    }

    public Double getMaxPongDelay() {
        return this.maxPongDelay;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public String getPhotonAppId() {
        return this.photonAppId;
    }

    public Double getPingInterval() {
        return this.pingInterval;
    }

    public Profile getProfile() {
        return this.profile;
    }

    public String getReactVersion() {
        return this.reactVersion;
    }

    public Double getSequenceInterval() {
        return this.sequenceInterval;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public Boolean getSingleEntryBattle() {
        return this.singleEntryBattle;
    }

    public Boolean getSponsorBattle() {
        return this.sponsorBattle;
    }

    public Long getStartTime() {
        return this.startTime;
    }

    public String getThirdPartyExtra() {
        return this.thirdPartyExtra;
    }

    public Double getTotalPlayers() {
        return this.totalPlayers;
    }

    public String getTournamentDescription() {
        return this.tournamentDescription;
    }

    public Long getTournamentId() {
        return this.tournamentId;
    }

    public String getTournamentName() {
        return this.tournamentName;
    }

    public Double getUserMatchRatingMax() {
        return this.userMatchRatingMax;
    }

    public Double getUserMatchRatingMin() {
        return this.userMatchRatingMin;
    }

    public Double getUserRating() {
        return this.userRating;
    }

    public Double getWinningAmount() {
        return this.winningAmount;
    }

    public String getZone() {
        return this.zone;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setAppType(String str) {
        this.appType = str;
    }

    public void setAppVersionCode(String str) {
        this.appVersionCode = str;
    }

    public void setAppVersionName(String str) {
        this.appVersionName = str;
    }

    public void setApplyBonusLimit(Boolean bool) {
        this.applyBonusLimit = bool;
    }

    public void setAuthToken(String str) {
        this.authToken = str;
    }

    public void setAutoStartTimer(Double d2) {
        this.autoStartTimer = d2;
    }

    public void setBalance(Balance balance2) {
        this.balance = balance2;
    }

    public void setBattingMultiplayer(Boolean bool) {
        this.battingMultiplayer = bool;
    }

    public void setBattleAgainTimeout(Double d2) {
        this.battleAgainTimeout = d2;
    }

    public void setBattleScoreSyncInSec(Double d2) {
        this.battleScoreSyncInSec = d2;
    }

    public void setBonusLimit(Double d2) {
        this.bonusLimit = d2;
    }

    public void setCallbackUrl(String str) {
        this.callbackUrl = str;
    }

    public void setConnectionRetryTimeout(Double d2) {
        this.connectionRetryTimeout = d2;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public void setCreateGameTimeout(Double d2) {
        this.createGameTimeout = d2;
    }

    public void setDynamicRewards(List<DynamicReward> list) {
        this.dynamicRewards = list;
    }

    public void setEnableAudioChat(Boolean bool) {
        this.enableAudioChat = bool;
    }

    public void setEntryCurrency(String str) {
        this.entryCurrency = str;
    }

    public void setEntryFee(Double d2) {
        this.entryFee = d2;
    }

    public void setExtraInfo(String str) {
        this.extraInfo = str;
    }

    public void setGameConfigName(String str) {
        this.gameConfigName = str;
    }

    public void setGameId(Integer num) {
        this.gameId = num;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setICLostMessage(String str) {
        this.iCLostMessage = str;
    }

    public void setICLostTitle(String str) {
        this.iCLostTitle = str;
    }

    public void setInstalledApkVersionCode(int i) {
        this.installedApkVersionCode = i;
    }

    public void setIs1v1(Boolean bool) {
        this.is1v1 = bool;
    }

    public void setIs1vN(Boolean bool) {
        this.is1vN = bool;
    }

    public void setIsAutoStartEnabled(Boolean bool) {
        this.isAutoStartEnabled = bool;
    }

    public void setIsChallengeEnabled(Boolean bool) {
        this.isChallengeEnabled = bool;
    }

    public void setIsFTUE(Boolean bool) {
        this.isFTUE = bool;
    }

    public void setIsItQuitByAndroid(Boolean bool) {
        this.isItQuitByAndroid = bool;
    }

    public void setIsLocalChannelMuted(Boolean bool) {
        this.isLocalChannelMuted = bool;
    }

    public void setIsModAppFound(Boolean bool) {
        this.isModAppFound = bool;
    }

    public void setIsPermissionAccepted(Boolean bool) {
        this.isPermissionAccepted = bool;
    }

    public void setIsRemoteChannelMuted(Boolean bool) {
        this.isRemoteChannelMuted = bool;
    }

    public void setIsRooted(Boolean bool) {
        this.isRooted = bool;
    }

    public void setIsTierEnabled(Boolean bool) {
        this.isTierEnabled = bool;
    }

    public void setIsUpsellEnabled(Boolean bool) {
        this.isUpsellEnabled = bool;
    }

    public void setIsVoiceChatRequired(Boolean bool) {
        this.isVoiceChatRequired = bool;
    }

    public void setIsVoiceChatRequiredLobby(Boolean bool) {
        this.isVoiceChatRequiredLobby = bool;
    }

    public void setKnockoutLobby(Boolean bool) {
        this.IsKnockoutLobby = bool;
    }

    public void setLobbyActiveEndTime(String str) {
        this.lobbyActiveEndTime = str;
    }

    public void setLobbyEndTime(String str) {
        this.lobbyEndTime = str;
    }

    public void setLobbyId(Double d2) {
        this.lobbyId = d2;
    }

    public void setMaxBonusPercentage(Double d2) {
        this.maxBonusPercentage = d2;
    }

    public void setMaxPauseDuration(Double d2) {
        this.maxPauseDuration = d2;
    }

    public void setMaxPongDelay(Double d2) {
        this.maxPongDelay = d2;
    }

    public void setMobileNumber(String str) {
        this.mobileNumber = str;
    }

    public void setPhotonAppId(String str) {
        this.photonAppId = str;
    }

    public void setPingInterval(Double d2) {
        this.pingInterval = d2;
    }

    public void setProfile(Profile profile2) {
        this.profile = profile2;
    }

    public void setReactVersion(String str) {
        this.reactVersion = str;
    }

    public void setSequenceInterval(Double d2) {
        this.sequenceInterval = d2;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setSingleEntryBattle(Boolean bool) {
        this.singleEntryBattle = bool;
    }

    public void setSponsorBattle(Boolean bool) {
        this.sponsorBattle = bool;
    }

    public void setStartTime(Long l) {
        this.startTime = l;
    }

    public void setThirdPartyExtra(String str) {
        this.thirdPartyExtra = str;
    }

    public void setTotalPlayers(Double d2) {
        this.totalPlayers = d2;
    }

    public void setTournamentDescription(String str) {
        this.tournamentDescription = str;
    }

    public void setTournamentId(Long l) {
        this.tournamentId = l;
    }

    public void setTournamentName(String str) {
        this.tournamentName = str;
    }

    public void setUserMatchRatingMax(Double d2) {
        this.userMatchRatingMax = d2;
    }

    public void setUserMatchRatingMin(Double d2) {
        this.userMatchRatingMin = d2;
    }

    public void setUserRating(Double d2) {
        this.userRating = d2;
    }

    public void setWinningAmount(Double d2) {
        this.winningAmount = d2;
    }

    public void setZone(String str) {
        this.zone = str;
    }
}
