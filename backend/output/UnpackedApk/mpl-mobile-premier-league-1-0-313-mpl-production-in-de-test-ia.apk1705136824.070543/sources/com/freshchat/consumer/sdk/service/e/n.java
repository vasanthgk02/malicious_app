package com.freshchat.consumer.sdk.service.e;

public class n implements j {
    public String categoryId;
    public a gu;
    public String v;

    public enum a {
        Upvote,
        Downvote
    }

    public n(String str, String str2, a aVar) {
        this.categoryId = str;
        this.v = str2;
        this.gu = aVar;
    }

    public String dJ() {
        return this.v;
    }

    public a dK() {
        return this.gu;
    }

    public String getCategoryId() {
        return this.categoryId;
    }
}
