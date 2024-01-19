package com.google.android.datatransport.runtime.firebase.transport;

public final class StorageMetrics {
    public final long current_cache_size_bytes_;
    public final long max_cache_size_bytes_;

    public static final class Builder {
        public long current_cache_size_bytes_ = 0;
        public long max_cache_size_bytes_ = 0;
    }

    public StorageMetrics(long j, long j2) {
        this.current_cache_size_bytes_ = j;
        this.max_cache_size_bytes_ = j2;
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
