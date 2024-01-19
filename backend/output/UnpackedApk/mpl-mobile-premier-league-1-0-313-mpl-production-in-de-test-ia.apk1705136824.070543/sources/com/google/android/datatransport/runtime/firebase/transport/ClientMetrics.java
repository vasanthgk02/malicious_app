package com.google.android.datatransport.runtime.firebase.transport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ClientMetrics {
    public final String app_namespace_;
    public final GlobalMetrics global_metrics_;
    public final List<LogSourceMetrics> log_source_metrics_;
    public final TimeWindow window_;

    public static final class Builder {
        public String app_namespace_ = "";
        public GlobalMetrics global_metrics_ = null;
        public List<LogSourceMetrics> log_source_metrics_ = new ArrayList();
        public TimeWindow window_ = null;

        public ClientMetrics build() {
            return new ClientMetrics(this.window_, Collections.unmodifiableList(this.log_source_metrics_), this.global_metrics_, this.app_namespace_);
        }
    }

    static {
        Collections.unmodifiableList(new ArrayList());
    }

    public ClientMetrics(TimeWindow timeWindow, List<LogSourceMetrics> list, GlobalMetrics globalMetrics, String str) {
        this.window_ = timeWindow;
        this.log_source_metrics_ = list;
        this.global_metrics_ = globalMetrics;
        this.app_namespace_ = str;
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
