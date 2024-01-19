package com.google.android.gms.common.api;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class BatchResult implements Result {
    public final Status zaa;

    public BatchResult(Status status, PendingResult[] pendingResultArr) {
        this.zaa = status;
    }

    public Status getStatus() {
        return this.zaa;
    }
}
