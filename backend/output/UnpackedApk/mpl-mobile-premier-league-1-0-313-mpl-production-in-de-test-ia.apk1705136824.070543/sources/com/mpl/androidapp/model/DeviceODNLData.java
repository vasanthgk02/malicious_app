package com.mpl.androidapp.model;

import com.google.gson.annotations.SerializedName;

public class DeviceODNLData {
    @SerializedName("device_intelligence")
    public DeviceIntelligence deviceIntelligence;
    @SerializedName("platform")
    public String platform;
    @SerializedName("session_id")
    public String sessionId;
    @SerializedName("timestamp")
    public String timestamp;
    @SerializedName("version")
    public String version;

    public static class DeviceIntelligence {
        @SerializedName("app_tampering")
        public boolean appTampering;
        @SerializedName("device_score")
        public int deviceScore;
        @SerializedName("is_emulated")
        public boolean isEmulated;
        @SerializedName("is_jailbroken")
        public boolean isJailbroken;
        @SerializedName("running_clone_apps")
        public boolean runningCloneApps;
        @SerializedName("running_gps_spoofers")
        public boolean runningGpsSpoofers;
        @SerializedName("running_vpn_spoofers")
        public boolean runningVpnSpoofers;
        @SerializedName("shield_id")
        public String shieldId;
        @SerializedName("suspicious_factory_reset")
        public boolean suspiciousFactoryReset;
        @SerializedName("virtual_os")
        public boolean virtualOs;

        public boolean getAppTampering() {
            return this.appTampering;
        }

        public int getDeviceScore() {
            return this.deviceScore;
        }

        public boolean getIsEmulated() {
            return this.isEmulated;
        }

        public boolean getIsJailbroken() {
            return this.isJailbroken;
        }

        public boolean getRunningCloneApps() {
            return this.runningCloneApps;
        }

        public boolean getRunningGpsSpoofers() {
            return this.runningGpsSpoofers;
        }

        public boolean getRunningVpnSpoofers() {
            return this.runningVpnSpoofers;
        }

        public String getShieldId() {
            return this.shieldId;
        }

        public boolean getSuspiciousFactoryReset() {
            return this.suspiciousFactoryReset;
        }

        public boolean getVirtualOs() {
            return this.virtualOs;
        }

        public void setAppTampering(boolean z) {
            this.appTampering = z;
        }

        public void setDeviceScore(int i) {
            this.deviceScore = i;
        }

        public void setIsEmulated(boolean z) {
            this.isEmulated = z;
        }

        public void setIsJailbroken(boolean z) {
            this.isJailbroken = z;
        }

        public void setRunningCloneApps(boolean z) {
            this.runningCloneApps = z;
        }

        public void setRunningGpsSpoofers(boolean z) {
            this.runningGpsSpoofers = z;
        }

        public void setRunningVpnSpoofers(boolean z) {
            this.runningVpnSpoofers = z;
        }

        public void setShieldId(String str) {
            this.shieldId = str;
        }

        public void setSuspiciousFactoryReset(boolean z) {
            this.suspiciousFactoryReset = z;
        }

        public void setVirtualOs(boolean z) {
            this.virtualOs = z;
        }
    }

    public DeviceIntelligence getDeviceIntelligence() {
        return this.deviceIntelligence;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getVersion() {
        return this.version;
    }

    public void setDeviceIntelligence(DeviceIntelligence deviceIntelligence2) {
        this.deviceIntelligence = deviceIntelligence2;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
