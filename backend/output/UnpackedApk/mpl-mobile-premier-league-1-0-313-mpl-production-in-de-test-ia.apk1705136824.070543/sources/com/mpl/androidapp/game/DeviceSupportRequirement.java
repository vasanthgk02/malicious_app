package com.mpl.androidapp.game;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeviceSupportRequirement {
    @SerializedName("architecture")
    @Expose
    public String architecture;
    @SerializedName("deviceName")
    @Expose
    public String deviceName;
    @SerializedName("maxOs")
    @Expose
    public String maxOs;
    @SerializedName("minOs")
    @Expose
    public String minOs;
    @SerializedName("ram")
    @Expose
    public String ram;
    @SerializedName("storage")
    @Expose
    public String storage;

    public String getArchitecture() {
        return this.architecture;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getMaxOs() {
        return this.maxOs;
    }

    public String getMinOs() {
        return this.minOs;
    }

    public String getRam() {
        return this.ram;
    }

    public String getStorage() {
        return this.storage;
    }

    public void setArchitecture(String str) {
        this.architecture = str;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setMaxOs(String str) {
        this.maxOs = str;
    }

    public void setMinOs(String str) {
        this.minOs = str;
    }

    public void setRam(String str) {
        this.ram = str;
    }

    public void setStorage(String str) {
        this.storage = str;
    }
}
