package com.mpl.androidapp.model;

import java.util.List;

public class GameReplayConfigModel {
    public boolean audioEnabled;
    public int bitRate;
    public List<String> blackListedManufacturer;
    public List<String> blackListedModel;
    public int fps;
    public List<Integer> gameReplayEnabled;
    public int height;
    public boolean isLowRamCheckRequired;
    public String minAvailableRAM;
    public String minTotalRAM;
    public String streamUrl;
    public int width;

    public int getBitRate() {
        return this.bitRate;
    }

    public List<String> getBlackListedManufacturer() {
        return this.blackListedManufacturer;
    }

    public List<String> getBlackListedModel() {
        return this.blackListedModel;
    }

    public int getFps() {
        return this.fps;
    }

    public List<Integer> getGameReplayEnabled() {
        return this.gameReplayEnabled;
    }

    public int getHeight() {
        return this.height;
    }

    public String getMinAvailableRAM() {
        return this.minAvailableRAM;
    }

    public String getMinTotalRAM() {
        return this.minTotalRAM;
    }

    public String getStreamUrl() {
        return this.streamUrl;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isAudioEnabled() {
        return this.audioEnabled;
    }

    public boolean isLowRamCheckRequired() {
        return this.isLowRamCheckRequired;
    }

    public void setAudioEnabled(boolean z) {
        this.audioEnabled = z;
    }

    public void setBitRate(int i) {
        this.bitRate = i;
    }

    public void setBlackListedManufacturer(List<String> list) {
        this.blackListedManufacturer = list;
    }

    public void setBlackListedModel(List<String> list) {
        this.blackListedModel = list;
    }

    public void setFps(int i) {
        this.fps = i;
    }

    public void setGameReplayEnabled(List<Integer> list) {
        this.gameReplayEnabled = list;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setLowRamCheckRequired(boolean z) {
        this.isLowRamCheckRequired = z;
    }

    public void setMinAvailableRAM(String str) {
        this.minAvailableRAM = str;
    }

    public void setMinTotalRAM(String str) {
        this.minTotalRAM = str;
    }

    public void setStreamUrl(String str) {
        this.streamUrl = str;
    }

    public void setWidth(int i) {
        this.width = i;
    }
}
