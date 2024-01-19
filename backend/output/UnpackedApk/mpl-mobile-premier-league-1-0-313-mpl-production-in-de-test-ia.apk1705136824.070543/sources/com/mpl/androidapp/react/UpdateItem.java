package com.mpl.androidapp.react;

public class UpdateItem {
    public String mUpdateDesc;
    public String mUpdateImageUrl;

    public UpdateItem(String str, String str2) {
        this.mUpdateImageUrl = str;
        this.mUpdateDesc = str2;
    }

    public String getUpdateDesc() {
        return this.mUpdateDesc;
    }

    public String getUpdateImageUrl() {
        return this.mUpdateImageUrl;
    }

    public void setUpdateDesc(String str) {
        this.mUpdateDesc = str;
    }

    public void setUpdateImageUrl(String str) {
        this.mUpdateImageUrl = str;
    }

    public UpdateItem() {
    }
}
