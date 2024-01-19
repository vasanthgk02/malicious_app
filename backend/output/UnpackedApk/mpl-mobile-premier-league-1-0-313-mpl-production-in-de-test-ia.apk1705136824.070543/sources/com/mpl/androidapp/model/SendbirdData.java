package com.mpl.androidapp.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class SendbirdData {
    public Channel channel;
    public String message;

    public static class Channel {
        @SerializedName("channel_url")
        public String channelUrl;
        @SerializedName("custom_type")
        public String customType;
        public String name;

        public String getChannelUrl() {
            return this.channelUrl;
        }

        public String getCustomType() {
            return this.customType;
        }

        public String getName() {
            return this.name;
        }

        public void setChannelUrl(String str) {
            this.channelUrl = str;
        }

        public void setCustomType(String str) {
            this.customType = str;
        }

        public void setName(String str) {
            this.name = str;
        }
    }

    public Channel getChannel() {
        return this.channel;
    }

    public String getMessage() {
        return this.message;
    }

    public void setChannel(Channel channel2) {
        this.channel = channel2;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String toJson() {
        return new Gson().toJson((Object) this);
    }
}
