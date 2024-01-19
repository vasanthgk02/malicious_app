package com.google.android.datatransport.runtime.firebase.transport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class LogSourceMetrics {
    public final List<LogEventDropped> log_event_dropped_;
    public final String log_source_;

    public static final class Builder {
        public List<LogEventDropped> log_event_dropped_ = new ArrayList();
        public String log_source_ = "";
    }

    static {
        Collections.unmodifiableList(new ArrayList());
    }

    public LogSourceMetrics(String str, List<LogEventDropped> list) {
        this.log_source_ = str;
        this.log_event_dropped_ = list;
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
