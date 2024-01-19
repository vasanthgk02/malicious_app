package com.mpl.androidapp.miniprofile.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/mpl/androidapp/miniprofile/models/GameStatsPayload;", "", "totalCashWon", "", "totalGamesPlayed", "", "totalGamesWon", "(DII)V", "getTotalCashWon", "()D", "getTotalGamesPlayed", "()I", "getTotalGamesWon", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GameStatsPayload.kt */
public final class GameStatsPayload {
    public final double totalCashWon;
    public final int totalGamesPlayed;
    public final int totalGamesWon;

    public GameStatsPayload(double d2, int i, int i2) {
        this.totalCashWon = d2;
        this.totalGamesPlayed = i;
        this.totalGamesWon = i2;
    }

    public static /* synthetic */ GameStatsPayload copy$default(GameStatsPayload gameStatsPayload, double d2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            d2 = gameStatsPayload.totalCashWon;
        }
        if ((i3 & 2) != 0) {
            i = gameStatsPayload.totalGamesPlayed;
        }
        if ((i3 & 4) != 0) {
            i2 = gameStatsPayload.totalGamesWon;
        }
        return gameStatsPayload.copy(d2, i, i2);
    }

    public final double component1() {
        return this.totalCashWon;
    }

    public final int component2() {
        return this.totalGamesPlayed;
    }

    public final int component3() {
        return this.totalGamesWon;
    }

    public final GameStatsPayload copy(double d2, int i, int i2) {
        return new GameStatsPayload(d2, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GameStatsPayload)) {
            return false;
        }
        GameStatsPayload gameStatsPayload = (GameStatsPayload) obj;
        return Intrinsics.areEqual(Double.valueOf(this.totalCashWon), Double.valueOf(gameStatsPayload.totalCashWon)) && this.totalGamesPlayed == gameStatsPayload.totalGamesPlayed && this.totalGamesWon == gameStatsPayload.totalGamesWon;
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

    public int hashCode() {
        return (((Double.doubleToLongBits(this.totalCashWon) * 31) + this.totalGamesPlayed) * 31) + this.totalGamesWon;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("GameStatsPayload(totalCashWon=");
        outline73.append(this.totalCashWon);
        outline73.append(", totalGamesPlayed=");
        outline73.append(this.totalGamesPlayed);
        outline73.append(", totalGamesWon=");
        return GeneratedOutlineSupport.outline56(outline73, this.totalGamesWon, ')');
    }
}
