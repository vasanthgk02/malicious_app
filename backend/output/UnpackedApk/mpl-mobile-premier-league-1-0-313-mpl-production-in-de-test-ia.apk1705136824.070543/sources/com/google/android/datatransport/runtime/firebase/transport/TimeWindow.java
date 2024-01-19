package com.google.android.datatransport.runtime.firebase.transport;

public final class TimeWindow {
    public final long end_ms_;
    public final long start_ms_;

    public static final class Builder {
        public long end_ms_ = 0;
        public long start_ms_ = 0;
    }

    public TimeWindow(long j, long j2) {
        this.start_ms_ = j;
        this.end_ms_ = j2;
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
