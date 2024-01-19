package com.cfg.mendikot.app;

import android.content.Context;
import com.cfg.utilities.Handle;
import java.util.HashMap;

public class SDKConfig {
    public String assetsDirectoryName;
    public Context context;
    public boolean emojiEnabled = false;
    public String externalAuthToken;
    public Handle fileHandle;
    public HashMap<String, String> helpUrlMap;
    public boolean isSecure = true;
    public ISDKListener listener;
    public SDKMode mode = SDKMode.STAGE;
    public HashMap<String, Integer> socketConfigMap;

    public SDKConfig() {
    }

    public SDKConfig(SDKConfig sDKConfig) {
        this.context = sDKConfig.context;
        this.externalAuthToken = sDKConfig.externalAuthToken;
        this.mode = sDKConfig.mode;
        this.isSecure = sDKConfig.isSecure;
        this.emojiEnabled = sDKConfig.emojiEnabled;
        this.listener = sDKConfig.listener;
        this.helpUrlMap = sDKConfig.helpUrlMap;
        this.socketConfigMap = sDKConfig.socketConfigMap;
    }

    public String getAssetsDirectoryName() {
        return this.assetsDirectoryName;
    }

    public Context getContext() {
        return this.context;
    }

    public String getExternalAuthToken() {
        return this.externalAuthToken;
    }

    public Handle getFileHandle() {
        return this.fileHandle;
    }

    public HashMap<String, String> getHelpUrl() {
        return this.helpUrlMap;
    }

    public SDKMode getMode() {
        return this.mode;
    }

    public ISDKListener getSDKListener() {
        return this.listener;
    }

    public HashMap<String, Integer> getSocketConfigMap() {
        return this.socketConfigMap;
    }

    public boolean isEmojiEnabled() {
        return this.emojiEnabled;
    }

    public boolean isSecure() {
        return this.isSecure;
    }

    public void setAssetsDirectoryName(String str) {
        this.assetsDirectoryName = str;
    }

    public void setContext(Context context2) {
        this.context = context2;
    }

    public void setEmojiEnabled(boolean z) {
        this.emojiEnabled = z;
    }

    public void setExternalAuthToken(String str) {
        this.externalAuthToken = str;
    }

    public void setFileHandle(Handle handle) {
        this.fileHandle = handle;
    }

    public void setHelpUrl(HashMap<String, String> hashMap) {
        this.helpUrlMap = hashMap;
    }

    public void setMode(SDKMode sDKMode) {
        this.mode = sDKMode;
    }

    public void setSDKListener(ISDKListener iSDKListener) {
        this.listener = iSDKListener;
    }

    public void setSecure(boolean z) {
        this.isSecure = z;
    }

    public void setSocketConfigMap(HashMap<String, Integer> hashMap) {
        this.socketConfigMap = hashMap;
    }
}
