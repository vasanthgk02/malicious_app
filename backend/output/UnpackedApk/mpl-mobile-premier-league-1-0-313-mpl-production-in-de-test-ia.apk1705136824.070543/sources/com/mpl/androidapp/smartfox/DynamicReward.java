package com.mpl.androidapp.smartfox;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DynamicReward implements Serializable {
    public static final long serialVersionUID = -5785436339659871941L;
    @SerializedName("cashWinning")
    @Expose
    public Double cashWinning;
    @SerializedName("playerCount")
    @Expose
    public Integer playerCount;
    @SerializedName("rankWiseWinning")
    @Expose
    public List<Double> rankWiseWinning = new ArrayList();

    public int describeContents() {
        return 0;
    }

    public Double getCashWinning() {
        return this.cashWinning;
    }

    public Integer getPlayerCount() {
        return this.playerCount;
    }

    public List<Double> getRankWiseWinning() {
        return this.rankWiseWinning;
    }

    public void setCashWinning(Double d2) {
        this.cashWinning = d2;
    }

    public void setPlayerCount(Integer num) {
        this.playerCount = num;
    }

    public void setRankWiseWinning(List<Double> list) {
        this.rankWiseWinning = list;
    }
}
