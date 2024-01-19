package com.mpl.androidapp.smartfox;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.text.ExtendedMessageFormat;

public class GameCountItem {
    @SerializedName("battleSupported")
    public boolean battleSupported;
    @SerializedName("battlesCount")
    public int battlesCount;
    @SerializedName("count")
    public int count;
    @SerializedName("gameIconUrl")
    public String gameIconUrl;
    @SerializedName("gameId")
    public int gameId;
    @SerializedName("gameName")
    public String gameName;
    @SerializedName("tournamentSupported")
    public boolean tournamentSupported;

    public int getBattlesCount() {
        return this.battlesCount;
    }

    public int getCount() {
        return this.count;
    }

    public String getGameIconUrl() {
        return this.gameIconUrl;
    }

    public int getGameId() {
        return this.gameId;
    }

    public String getGameName() {
        return this.gameName;
    }

    public boolean isBattleSupported() {
        return this.battleSupported;
    }

    public boolean isTournamentSupported() {
        return this.tournamentSupported;
    }

    public void setBattleSupported(boolean z) {
        this.battleSupported = z;
    }

    public void setBattlesCount(int i) {
        this.battlesCount = i;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setGameIconUrl(String str) {
        this.gameIconUrl = str;
    }

    public void setGameId(int i) {
        this.gameId = i;
    }

    public void setGameName(String str) {
        this.gameName = str;
    }

    public void setTournamentSupported(boolean z) {
        this.tournamentSupported = z;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("GameCountItem{gameId = '");
        outline73.append(this.gameId);
        outline73.append(ExtendedMessageFormat.QUOTE);
        outline73.append(",gameIconUrl = '");
        GeneratedOutlineSupport.outline99(outline73, this.gameIconUrl, ExtendedMessageFormat.QUOTE, ",gameName = '");
        GeneratedOutlineSupport.outline99(outline73, this.gameName, ExtendedMessageFormat.QUOTE, ",count = '");
        outline73.append(this.count);
        outline73.append(ExtendedMessageFormat.QUOTE);
        outline73.append(",tournamentSupported = '");
        outline73.append(this.tournamentSupported);
        outline73.append(ExtendedMessageFormat.QUOTE);
        outline73.append(",battleSupported = '");
        outline73.append(this.battleSupported);
        outline73.append(ExtendedMessageFormat.QUOTE);
        outline73.append(",battlesCount = '");
        outline73.append(this.battlesCount);
        outline73.append(ExtendedMessageFormat.QUOTE);
        outline73.append("}");
        return outline73.toString();
    }
}
