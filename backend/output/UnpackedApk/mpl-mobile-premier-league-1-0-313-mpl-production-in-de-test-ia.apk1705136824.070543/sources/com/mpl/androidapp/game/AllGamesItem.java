package com.mpl.androidapp.game;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.text.ExtendedMessageFormat;

public class AllGamesItem {
    @SerializedName("battleSupported")
    public boolean battleSupported;
    @SerializedName("displayOrder")
    public int displayOrder;
    @SerializedName("extraInfo")
    public String extraInfo;
    @SerializedName("fantasyGame")
    public boolean fantasyGame;
    @SerializedName("gameInfo")
    public String gameInfo;
    @SerializedName("gameType")
    public String gameType;
    @SerializedName("icons")
    public Icons icons;
    @SerializedName("id")
    public int id;
    @SerializedName("isActive")
    public boolean isActive;
    @SerializedName("isBattleSupported")
    public boolean isBattleSupported;
    @SerializedName("isNew")
    public boolean isNew;
    @SerializedName("isRandom")
    public boolean isRandom;
    @SerializedName("isTournamentSupported")
    public boolean isTournamentSupported;
    @SerializedName("landscape")
    public boolean landscape;
    @SerializedName("leaderboardSupported")
    public boolean leaderboardSupported;
    @SerializedName("locked")
    public boolean locked;
    @SerializedName("name")
    public String name;
    @SerializedName("platforms")
    public Platforms platforms;
    @SerializedName("totalCashWon")
    public int totalCashWon;
    @SerializedName("totalWinners")
    public int totalWinners;
    @SerializedName("tournamentSupported")
    public boolean tournamentSupported;

    public int getDisplayOrder() {
        return this.displayOrder;
    }

    public String getExtraInfo() {
        return this.extraInfo;
    }

    public String getGameInfo() {
        return this.gameInfo;
    }

    public String getGameType() {
        return this.gameType;
    }

    public Icons getIcons() {
        return this.icons;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Platforms getPlatforms() {
        return this.platforms;
    }

    public int getTotalCashWon() {
        return this.totalCashWon;
    }

    public int getTotalWinners() {
        return this.totalWinners;
    }

    public boolean isBattleSupported() {
        return this.battleSupported;
    }

    public boolean isFantasyGame() {
        return this.fantasyGame;
    }

    public boolean isIsActive() {
        return this.isActive;
    }

    public boolean isIsBattleSupported() {
        return this.isBattleSupported;
    }

    public boolean isIsNew() {
        return this.isNew;
    }

    public boolean isIsRandom() {
        return this.isRandom;
    }

    public boolean isIsTournamentSupported() {
        return this.isTournamentSupported;
    }

    public boolean isLandscape() {
        return this.landscape;
    }

    public boolean isLeaderboardSupported() {
        return this.leaderboardSupported;
    }

    public boolean isLocked() {
        return this.locked;
    }

    public boolean isTournamentSupported() {
        return this.tournamentSupported;
    }

    public void setBattleSupported(boolean z) {
        this.battleSupported = z;
    }

    public void setDisplayOrder(int i) {
        this.displayOrder = i;
    }

    public void setExtraInfo(String str) {
        this.extraInfo = str;
    }

    public void setFantasyGame(boolean z) {
        this.fantasyGame = z;
    }

    public void setGameInfo(String str) {
        this.gameInfo = str;
    }

    public void setGameType(String str) {
        this.gameType = str;
    }

    public void setIcons(Icons icons2) {
        this.icons = icons2;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setIsActive(boolean z) {
        this.isActive = z;
    }

    public void setIsBattleSupported(boolean z) {
        this.isBattleSupported = z;
    }

    public void setIsNew(boolean z) {
        this.isNew = z;
    }

    public void setIsRandom(boolean z) {
        this.isRandom = z;
    }

    public void setIsTournamentSupported(boolean z) {
        this.isTournamentSupported = z;
    }

    public void setLandscape(boolean z) {
        this.landscape = z;
    }

    public void setLeaderboardSupported(boolean z) {
        this.leaderboardSupported = z;
    }

    public void setLocked(boolean z) {
        this.locked = z;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPlatforms(Platforms platforms2) {
        this.platforms = platforms2;
    }

    public void setTotalCashWon(int i) {
        this.totalCashWon = i;
    }

    public void setTotalWinners(int i) {
        this.totalWinners = i;
    }

    public void setTournamentSupported(boolean z) {
        this.tournamentSupported = z;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("AllGamesItem{gameType = '");
        GeneratedOutlineSupport.outline99(outline73, this.gameType, ExtendedMessageFormat.QUOTE, ",leaderboardSupported = '");
        outline73.append(this.leaderboardSupported);
        outline73.append(ExtendedMessageFormat.QUOTE);
        outline73.append(",gameInfo = '");
        GeneratedOutlineSupport.outline99(outline73, this.gameInfo, ExtendedMessageFormat.QUOTE, ",displayOrder = '");
        outline73.append(this.displayOrder);
        outline73.append(ExtendedMessageFormat.QUOTE);
        outline73.append(",tournamentSupported = '");
        outline73.append(this.tournamentSupported);
        outline73.append(ExtendedMessageFormat.QUOTE);
        outline73.append(",battleSupported = '");
        outline73.append(this.battleSupported);
        outline73.append(ExtendedMessageFormat.QUOTE);
        outline73.append(",isBattleSupported = '");
        outline73.append(this.isBattleSupported);
        outline73.append(ExtendedMessageFormat.QUOTE);
        outline73.append(",isTournamentSupported = '");
        outline73.append(this.isTournamentSupported);
        outline73.append(ExtendedMessageFormat.QUOTE);
        outline73.append(",isNew = '");
        outline73.append(this.isNew);
        outline73.append(ExtendedMessageFormat.QUOTE);
        outline73.append(",isActive = '");
        outline73.append(this.isActive);
        outline73.append(ExtendedMessageFormat.QUOTE);
        outline73.append(",icons = '");
        outline73.append(this.icons.toString());
        outline73.append(ExtendedMessageFormat.QUOTE);
        outline73.append(",platforms = '");
        outline73.append(this.platforms.toString());
        outline73.append(ExtendedMessageFormat.QUOTE);
        outline73.append(",isRandom = '");
        outline73.append(this.isRandom);
        outline73.append(ExtendedMessageFormat.QUOTE);
        outline73.append(",totalCashWon = '");
        outline73.append(this.totalCashWon);
        outline73.append(ExtendedMessageFormat.QUOTE);
        outline73.append(",name = '");
        GeneratedOutlineSupport.outline99(outline73, this.name, ExtendedMessageFormat.QUOTE, ",totalWinners = '");
        outline73.append(this.totalWinners);
        outline73.append(ExtendedMessageFormat.QUOTE);
        outline73.append(",id = '");
        outline73.append(this.id);
        outline73.append(ExtendedMessageFormat.QUOTE);
        outline73.append(",locked = '");
        outline73.append(this.locked);
        outline73.append(ExtendedMessageFormat.QUOTE);
        outline73.append(",landscape = '");
        outline73.append(this.landscape);
        outline73.append(ExtendedMessageFormat.QUOTE);
        outline73.append(",extraInfo = '");
        GeneratedOutlineSupport.outline99(outline73, this.extraInfo, ExtendedMessageFormat.QUOTE, ",fantasyGame = '");
        outline73.append(this.fantasyGame);
        outline73.append(ExtendedMessageFormat.QUOTE);
        outline73.append("}");
        return outline73.toString();
    }
}
