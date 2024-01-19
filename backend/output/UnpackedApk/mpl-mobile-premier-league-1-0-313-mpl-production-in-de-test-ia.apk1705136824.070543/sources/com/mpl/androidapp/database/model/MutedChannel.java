package com.mpl.androidapp.database.model;

import com.google.gson.Gson;

public class MutedChannel {
    public static final String TYPE_CHANNEL = "channel";
    public static final String TYPE_GROUP = "group";
    public String type;
    public int uid;
    public String url;

    public MutedChannel(String str, String str2) {
        this.type = str;
        this.url = str2;
    }

    public String getType() {
        return this.type;
    }

    public int getUid() {
        return this.uid;
    }

    public String getUrl() {
        return this.url;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUid(int i) {
        this.uid = i;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toJson() {
        return new Gson().toJson((Object) this);
    }
}
