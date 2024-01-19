package com.mpl.androidapp.utils;

import com.android.tools.r8.GeneratedOutlineSupport;

public class OriginalGameConstant {
    public boolean isBattle;
    public boolean isKO;
    public boolean isTournament;
    public int tournamentId;

    public int getTournamentId() {
        return this.tournamentId;
    }

    public boolean isBattle() {
        return this.isBattle;
    }

    public boolean isKO() {
        return this.isKO;
    }

    public boolean isTournament() {
        return this.isTournament;
    }

    public void setBattle(boolean z) {
        this.isBattle = z;
    }

    public void setKO(boolean z) {
        this.isKO = z;
    }

    public void setTournament(boolean z) {
        this.isTournament = z;
    }

    public void setTournamentId(int i) {
        this.tournamentId = i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("OriginalGameConstant{tournamentId=");
        outline73.append(this.tournamentId);
        outline73.append(", isKO=");
        outline73.append(this.isKO);
        outline73.append(", isTournament=");
        outline73.append(this.isTournament);
        outline73.append(", isBattle=");
        return GeneratedOutlineSupport.outline65(outline73, this.isBattle, '}');
    }
}
