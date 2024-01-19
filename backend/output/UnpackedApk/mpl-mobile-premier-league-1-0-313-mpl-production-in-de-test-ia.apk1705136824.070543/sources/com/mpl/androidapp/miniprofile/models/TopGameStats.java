package com.mpl.androidapp.miniprofile.models;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\f\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/mpl/androidapp/miniprofile/models/TopGameStats;", "", "gameID", "", "gameName", "gameIconUrl", "totalCashWon", "", "totalGamesPlayed", "totalGamesWon", "(IIIDII)V", "getGameID", "()I", "getGameIconUrl", "getGameName", "getTotalCashWon", "()D", "getTotalGamesPlayed", "getTotalGamesWon", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TopGameStats.kt */
public final class TopGameStats {
    public final int gameID;
    public final int gameIconUrl;
    public final int gameName;
    public final double totalCashWon;
    public final int totalGamesPlayed;
    public final int totalGamesWon;

    public TopGameStats(int i, int i2, int i3, double d2, int i4, int i5) {
        this.gameID = i;
        this.gameName = i2;
        this.gameIconUrl = i3;
        this.totalCashWon = d2;
        this.totalGamesPlayed = i4;
        this.totalGamesWon = i5;
    }

    public final int getGameID() {
        return this.gameID;
    }

    public final int getGameIconUrl() {
        return this.gameIconUrl;
    }

    public final int getGameName() {
        return this.gameName;
    }

    public final double getTotalCashWon() {
        return this.totalCashWon;
    }

    public final int getTotalGamesPlayed() {
        return this.totalGamesPlayed;
    }

    public final int getTotalGamesWon() {
        return this.totalGamesWon;
    }
}
