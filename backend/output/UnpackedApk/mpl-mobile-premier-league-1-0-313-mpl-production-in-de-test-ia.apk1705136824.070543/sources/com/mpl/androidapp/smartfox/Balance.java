package com.mpl.androidapp.smartfox;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Balance implements Serializable {
    public static final long serialVersionUID = 6451171094678111399L;
    @SerializedName("bonusBalance")
    @Expose
    public Double bonusBalance;
    @SerializedName("depositBalance")
    @Expose
    public Double depositBalance;
    @SerializedName("heartBalance")
    @Expose
    public Double heartBalance;
    @SerializedName("tokenBalance")
    @Expose
    public Double tokenBalance;
    @SerializedName("totalBalance")
    @Expose
    public Double totalBalance;
    @SerializedName("userId")
    @Expose
    public Integer userId;
    @SerializedName("withdrawableBalance")
    @Expose
    public Double withdrawableBalance;

    public int describeContents() {
        return 0;
    }

    public Double getBonusBalance() {
        return this.bonusBalance;
    }

    public Double getDepositBalance() {
        return this.depositBalance;
    }

    public Double getTotalBalance() {
        return this.totalBalance;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setBonusBalance(Double d2) {
        this.bonusBalance = d2;
    }

    public void setDepositBalance(Double d2) {
        this.depositBalance = d2;
    }

    public void setTotalBalance(Double d2) {
        this.totalBalance = d2;
    }

    public void setUserId(Integer num) {
        this.userId = num;
    }
}
