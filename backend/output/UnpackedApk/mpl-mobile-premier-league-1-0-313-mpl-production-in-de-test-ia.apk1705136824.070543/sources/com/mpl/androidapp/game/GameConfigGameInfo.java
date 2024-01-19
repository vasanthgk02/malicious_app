package com.mpl.androidapp.game;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.text.ExtendedMessageFormat;

public class GameConfigGameInfo {
    @SerializedName("apkInfo")
    public ApkInfo apkInfo;
    public Integer battleGameVersion;
    public Integer tournamentGameVersion;

    public ApkInfo getApkInfo() {
        return this.apkInfo;
    }

    public Integer getBattleGameVersion() {
        return this.battleGameVersion;
    }

    public Integer getTournamentGameVersion() {
        return this.tournamentGameVersion;
    }

    public void setApkInfo(ApkInfo apkInfo2) {
        this.apkInfo = apkInfo2;
    }

    public void setBattleGameVersion(Integer num) {
        this.battleGameVersion = num;
    }

    public void setTournamentGameVersion(Integer num) {
        this.tournamentGameVersion = num;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("GameConfigGameInfo{apkInfo = '");
        outline73.append(this.apkInfo);
        outline73.append(ExtendedMessageFormat.QUOTE);
        outline73.append("}");
        return outline73.toString();
    }
}
