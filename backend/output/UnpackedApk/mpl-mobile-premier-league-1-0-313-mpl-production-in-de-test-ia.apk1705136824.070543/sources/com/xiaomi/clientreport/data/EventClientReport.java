package com.xiaomi.clientreport.data;

import org.json.JSONObject;

public class EventClientReport extends a {
    public String eventContent;
    public String eventId;
    public long eventTime;
    public int eventType;

    public static EventClientReport getBlankInstance() {
        return new EventClientReport();
    }

    public JSONObject toJson() {
        return null;
    }

    public String toJsonString() {
        return super.toJsonString();
    }
}
