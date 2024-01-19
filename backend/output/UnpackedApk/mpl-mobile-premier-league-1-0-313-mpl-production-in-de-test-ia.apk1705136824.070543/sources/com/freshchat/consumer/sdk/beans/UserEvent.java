package com.freshchat.consumer.sdk.beans;

import java.util.Map;

public class UserEvent {
    public String eventName;
    public long occTime;
    public Map<String, Object> properties;

    public UserEvent(String str, Map<String, Object> map, long j) {
        this.eventName = str;
        this.properties = map;
        this.occTime = j;
    }

    public String getEventName() {
        return this.eventName;
    }

    public long getOccTime() {
        return this.occTime;
    }

    public Map<String, Object> getProperties() {
        return this.properties;
    }
}
