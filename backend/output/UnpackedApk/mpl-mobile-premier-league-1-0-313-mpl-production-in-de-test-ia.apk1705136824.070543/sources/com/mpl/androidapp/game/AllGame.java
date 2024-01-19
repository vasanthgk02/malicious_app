package com.mpl.androidapp.game;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class AllGame implements Serializable {
    public static final long serialVersionUID = -7123583063196836860L;
    @SerializedName("assetsVersion")
    @Expose
    public Integer assetsVersion;
    @SerializedName("battleSupported")
    @Expose
    public Boolean battleSupported;
    @SerializedName("displayOrder")
    @Expose
    public Integer displayOrder;
    @SerializedName("extraInfo")
    @Expose
    public String extraInfo;
    @SerializedName("fantasyGame")
    @Expose
    public Boolean fantasyGame;
    public GameConfigGameInfo gameConfigGameInfo;
    @SerializedName("gameInfo")
    @Expose
    public String gameInfo;
    @SerializedName("gameType")
    @Expose
    public String gameType;
    @SerializedName("gameVersion")
    @Expose
    public Integer gameVersion;
    @SerializedName("icons")
    @Expose
    public Icons icons;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("isActive")
    @Expose
    public Boolean isActive;
    @SerializedName("isAssetCritical")
    @Expose
    public Boolean isAssetCritical;
    @SerializedName("isBattleSupported")
    @Expose
    public Boolean isBattleSupported;
    @SerializedName("isNew")
    @Expose
    public Boolean isNew;
    @SerializedName("isRandom")
    @Expose
    public Boolean isRandom;
    @SerializedName("isTournamentSupported")
    @Expose
    public Boolean isTournamentSupported;
    @SerializedName("landscape")
    @Expose
    public Boolean landscape;
    @SerializedName("leaderboardSupported")
    @Expose
    public Boolean leaderboardSupported;
    @SerializedName("locked")
    @Expose
    public Boolean locked;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("platforms")
    @Expose
    public Platforms platforms;
    @SerializedName("totalCashWon")
    @Expose
    public Integer totalCashWon;
    @SerializedName("totalWinners")
    @Expose
    public Integer totalWinners;
    @SerializedName("tournamentSupported")
    @Expose
    public Boolean tournamentSupported;

    public Boolean getAssetCritical() {
        return this.isAssetCritical;
    }

    public Integer getAssetsVersion() {
        return this.assetsVersion;
    }

    public Boolean getBattleSupported() {
        return this.battleSupported;
    }

    public Integer getDisplayOrder() {
        return this.displayOrder;
    }

    public String getExtraInfo() {
        return this.extraInfo;
    }

    public Boolean getFantasyGame() {
        return this.fantasyGame;
    }

    public GameConfigGameInfo getGameConfigGameInfo() {
        return this.gameConfigGameInfo;
    }

    public String getGameInfo() {
        return this.gameInfo;
    }

    public String getGameType() {
        return this.gameType;
    }

    public Integer getGameVersion() {
        return this.gameVersion;
    }

    public Icons getIcons() {
        return this.icons;
    }

    public Integer getId() {
        return this.id;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public Boolean getIsBattleSupported() {
        return this.isBattleSupported;
    }

    public Boolean getIsNew() {
        return this.isNew;
    }

    public Boolean getIsRandom() {
        return this.isRandom;
    }

    public Boolean getIsTournamentSupported() {
        return this.isTournamentSupported;
    }

    public Boolean getLandscape() {
        return this.landscape;
    }

    public Boolean getLeaderboardSupported() {
        return this.leaderboardSupported;
    }

    public Boolean getLocked() {
        return this.locked;
    }

    public String getName() {
        return this.name;
    }

    public Platforms getPlatforms() {
        return this.platforms;
    }

    public Integer getTotalCashWon() {
        return this.totalCashWon;
    }

    public Integer getTotalWinners() {
        return this.totalWinners;
    }

    public Boolean getTournamentSupported() {
        return this.tournamentSupported;
    }

    public void setAssetCritical(Boolean bool) {
        this.isAssetCritical = bool;
    }

    public void setAssetsVersion(Integer num) {
        this.assetsVersion = num;
    }

    public void setBattleSupported(Boolean bool) {
        this.battleSupported = bool;
    }

    public void setDisplayOrder(Integer num) {
        this.displayOrder = num;
    }

    public void setExtraInfo(String str) {
        this.extraInfo = str;
    }

    public void setFantasyGame(Boolean bool) {
        this.fantasyGame = bool;
    }

    public void setGameConfigGameInfo(GameConfigGameInfo gameConfigGameInfo2) {
        this.gameConfigGameInfo = gameConfigGameInfo2;
    }

    public void setGameInfo(String str) {
        this.gameInfo = str;
    }

    public void setGameType(String str) {
        this.gameType = str;
    }

    public void setGameVersion(Integer num) {
        this.gameVersion = num;
    }

    public void setIcons(Icons icons2) {
        this.icons = icons2;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public void setIsActive(Boolean bool) {
        this.isActive = bool;
    }

    public void setIsBattleSupported(Boolean bool) {
        this.isBattleSupported = bool;
    }

    public void setIsNew(Boolean bool) {
        this.isNew = bool;
    }

    public void setIsRandom(Boolean bool) {
        this.isRandom = bool;
    }

    public void setIsTournamentSupported(Boolean bool) {
        this.isTournamentSupported = bool;
    }

    public void setLandscape(Boolean bool) {
        this.landscape = bool;
    }

    public void setLeaderboardSupported(Boolean bool) {
        this.leaderboardSupported = bool;
    }

    public void setLocked(Boolean bool) {
        this.locked = bool;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPlatforms(Platforms platforms2) {
        this.platforms = platforms2;
    }

    public void setTotalCashWon(Integer num) {
        this.totalCashWon = num;
    }

    public void setTotalWinners(Integer num) {
        this.totalWinners = num;
    }

    public void setTournamentSupported(Boolean bool) {
        this.tournamentSupported = bool;
    }
}
