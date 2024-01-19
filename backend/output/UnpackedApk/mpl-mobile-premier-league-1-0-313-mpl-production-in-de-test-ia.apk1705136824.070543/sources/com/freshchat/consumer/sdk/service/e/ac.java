package com.freshchat.consumer.sdk.service.e;

import com.freshchat.consumer.sdk.beans.UserEvent;
import java.util.Map;

public class ac implements j {
    public final String gH;
    public final Map<String, UserEvent> mG;

    public ac(String str, Map<String, UserEvent> map) {
        this.gH = str;
        this.mG = map;
    }

    public String bj() {
        return this.gH;
    }

    public Map<String, UserEvent> gM() {
        return this.mG;
    }
}
