package com.freshchat.consumer.sdk.service.e;

import java.util.List;

public class ah implements j {
    public String categoryId;
    public int rh;
    public List<String> tags;

    public ah(int i, String str, List<String> list) {
        this.rh = i;
        this.categoryId = str;
        this.tags = list;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public int iU() {
        return this.rh;
    }
}
