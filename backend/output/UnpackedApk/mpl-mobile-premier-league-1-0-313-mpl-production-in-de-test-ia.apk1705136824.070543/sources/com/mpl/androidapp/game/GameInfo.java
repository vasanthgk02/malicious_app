package com.mpl.androidapp.game;

public class GameInfo {
    public final boolean isActive;
    public final boolean isBattleSupports;
    public final boolean isLandScape;
    public final int mId;
    public final String mName;

    public GameInfo(String str, int i, boolean z, boolean z2, boolean z3) {
        this.mName = str;
        this.mId = i;
        this.isLandScape = z;
        this.isBattleSupports = z2;
        this.isActive = z3;
    }

    public int getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public boolean isBattleSupports() {
        return this.isBattleSupports;
    }

    public boolean isLandScape() {
        return this.isLandScape;
    }
}
