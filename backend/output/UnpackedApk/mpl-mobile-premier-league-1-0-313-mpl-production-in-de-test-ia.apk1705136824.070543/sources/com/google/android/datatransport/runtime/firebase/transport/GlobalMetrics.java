package com.google.android.datatransport.runtime.firebase.transport;

public final class GlobalMetrics {
    public final StorageMetrics storage_metrics_;

    public static final class Builder {
        public StorageMetrics storage_metrics_ = null;
    }

    public GlobalMetrics(StorageMetrics storageMetrics) {
        this.storage_metrics_ = storageMetrics;
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
