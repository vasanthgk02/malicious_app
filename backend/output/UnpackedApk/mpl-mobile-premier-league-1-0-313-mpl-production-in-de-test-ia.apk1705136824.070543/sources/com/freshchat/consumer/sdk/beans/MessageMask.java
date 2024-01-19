package com.freshchat.consumer.sdk.beans;

public class MessageMask {
    public String regex;
    public String replacementStr;

    public String getRegex() {
        return this.regex;
    }

    public String getReplacementStr() {
        return this.replacementStr;
    }

    public void setRegex(String str) {
        this.regex = str;
    }

    public void setReplacementStr(String str) {
        this.replacementStr = str;
    }
}
