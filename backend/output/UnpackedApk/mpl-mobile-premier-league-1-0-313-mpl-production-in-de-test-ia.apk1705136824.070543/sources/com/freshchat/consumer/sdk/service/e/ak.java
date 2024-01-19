package com.freshchat.consumer.sdk.service.e;

import java.util.List;

public class ak implements j {
    public final int rh;
    public final String rj;
    public final List<String> tags;

    public ak(String str, int i, List<String> list) {
        this.rj = str;
        this.rh = i;
        this.tags = list;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public int iU() {
        return this.rh;
    }

    public String iW() {
        return this.rj;
    }
}
