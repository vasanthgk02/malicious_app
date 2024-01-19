package com.freshchat.consumer.sdk.beans;

import com.google.gson.annotations.SerializedName;

public class BHWeekDays {
    @SerializedName("5")
    public String dayFiveTimings;
    @SerializedName("4")
    public String dayFourTimings;
    @SerializedName("1")
    public String dayOneTimings;
    @SerializedName("6")
    public String daySixTimings;
    @SerializedName("3")
    public String dayThreeTimings;
    @SerializedName("2")
    public String dayTwoTimings;
    @SerializedName("0")
    public String dayZeroTimings;

    public String getDayFiveTimings() {
        return this.dayFiveTimings;
    }

    public String getDayFourTimings() {
        return this.dayFourTimings;
    }

    public String getDayOneTimings() {
        return this.dayOneTimings;
    }

    public String getDaySixTimings() {
        return this.daySixTimings;
    }

    public String getDayThreeTimings() {
        return this.dayThreeTimings;
    }

    public String getDayTwoTimings() {
        return this.dayTwoTimings;
    }

    public String getDayZeroTimings() {
        return this.dayZeroTimings;
    }

    public void setDayFiveTimings(String str) {
        this.dayFiveTimings = str;
    }

    public void setDayFourTimings(String str) {
        this.dayFourTimings = str;
    }

    public void setDayOneTimings(String str) {
        this.dayOneTimings = str;
    }

    public void setDaySixTimings(String str) {
        this.daySixTimings = str;
    }

    public void setDayThreeTimings(String str) {
        this.dayThreeTimings = str;
    }

    public void setDayTwoTimings(String str) {
        this.dayTwoTimings = str;
    }

    public void setDayZeroTimings(String str) {
        this.dayZeroTimings = str;
    }
}
