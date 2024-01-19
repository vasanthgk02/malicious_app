package com.xiaomi.clientreport.data;

import org.json.JSONObject;

public class PerfClientReport extends a {
    public static final long DEFAULT_VALUE = -1;
    public int code;
    public long perfCounts = -1;
    public long perfLatencies = -1;

    public static PerfClientReport getBlankInstance() {
        return new PerfClientReport();
    }

    public JSONObject toJson() {
        return null;
    }

    public String toJsonString() {
        return super.toJsonString();
    }
}
