package com.freshchat.consumer.sdk.beans;

import com.google.gson.annotations.SerializedName;

public class BHWorkingDays {
    @SerializedName("5")
    public boolean dayFive;
    @SerializedName("4")
    public boolean dayFour;
    @SerializedName("1")
    public boolean dayOne;
    @SerializedName("6")
    public boolean daySix;
    @SerializedName("3")
    public boolean dayThree;
    @SerializedName("2")
    public boolean dayTwo;
    @SerializedName("0")
    public boolean dayZero;

    public boolean isWorkingOnDayFive() {
        return this.dayFive;
    }

    public boolean isWorkingOnDayFour() {
        return this.dayFour;
    }

    public boolean isWorkingOnDayOne() {
        return this.dayOne;
    }

    public boolean isWorkingOnDaySix() {
        return this.daySix;
    }

    public boolean isWorkingOnDayThree() {
        return this.dayThree;
    }

    public boolean isWorkingOnDayTwo() {
        return this.dayTwo;
    }

    public boolean isWorkingOnDayZero() {
        return this.dayZero;
    }

    public void setWorkingOnDayFive(boolean z) {
        this.dayFive = z;
    }

    public void setWorkingOnDayFour(boolean z) {
        this.dayFour = z;
    }

    public void setWorkingOnDayOne(boolean z) {
        this.dayOne = z;
    }

    public void setWorkingOnDaySix(boolean z) {
        this.daySix = z;
    }

    public void setWorkingOnDayThree(boolean z) {
        this.dayThree = z;
    }

    public void setWorkingOnDayTwo(boolean z) {
        this.dayTwo = z;
    }

    public void setWorkingOnDayZero(boolean z) {
        this.dayZero = z;
    }
}
