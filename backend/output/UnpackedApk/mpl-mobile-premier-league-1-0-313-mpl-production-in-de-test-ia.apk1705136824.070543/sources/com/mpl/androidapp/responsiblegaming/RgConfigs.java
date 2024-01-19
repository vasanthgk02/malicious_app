package com.mpl.androidapp.responsiblegaming;

import com.android.tools.r8.GeneratedOutlineSupport;

public class RgConfigs {
    public String isRgGamingOn;
    public int maxWarningCount;
    public int primaryWarningIntervalMinutes;
    public int secondaryWarningIntervalMinutes;
    public int sessionTimeOutMinutes;

    public RgConfigs(int i, int i2, int i3, int i4, String str) {
        this.sessionTimeOutMinutes = i;
        this.primaryWarningIntervalMinutes = i2;
        this.secondaryWarningIntervalMinutes = i3;
        this.maxWarningCount = i4;
        this.isRgGamingOn = str;
    }

    public String getIsRgGamingOn() {
        return this.isRgGamingOn;
    }

    public int getMaxWarningCount() {
        return this.maxWarningCount;
    }

    public int getPrimaryWarningIntervalMinutes() {
        return this.primaryWarningIntervalMinutes;
    }

    public int getSecondaryWarningIntervalMinutes() {
        return this.secondaryWarningIntervalMinutes;
    }

    public int getSessionTimeOutMinutes() {
        return this.sessionTimeOutMinutes;
    }

    public void setIsRgGamingOn(String str) {
        this.isRgGamingOn = str;
    }

    public void setMaxWarningCount(int i) {
        this.maxWarningCount = i;
    }

    public void setPrimaryWarningIntervalMinutes(int i) {
        this.primaryWarningIntervalMinutes = i;
    }

    public void setSecondaryWarningIntervalMinutes(int i) {
        this.secondaryWarningIntervalMinutes = i;
    }

    public void setSessionTimeOutMinutes(int i) {
        this.sessionTimeOutMinutes = i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("SESSION_TIMEOUT_MIN=");
        outline73.append(this.sessionTimeOutMinutes);
        StringBuilder sb = new StringBuilder(outline73.toString());
        StringBuilder outline732 = GeneratedOutlineSupport.outline73("PRIMARY_WARNING_INTERVAL_MIN=");
        outline732.append(this.primaryWarningIntervalMinutes);
        outline732.append(" | ");
        sb.append(outline732.toString());
        sb.append("SECONDARY_WARNING_INTERVAL_MIN=" + this.secondaryWarningIntervalMinutes + " | ");
        sb.append("MAX_WARNING_COUNT=" + this.maxWarningCount + " | ");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("IS_RG_GAMING_ON=");
        sb2.append(this.isRgGamingOn);
        sb.append(sb2.toString());
        return sb.toString();
    }

    public RgConfigs() {
    }
}
