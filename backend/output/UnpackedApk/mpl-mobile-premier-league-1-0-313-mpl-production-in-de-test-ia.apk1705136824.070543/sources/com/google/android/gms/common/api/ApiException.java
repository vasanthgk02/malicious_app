package com.google.android.gms.common.api;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public class ApiException extends Exception {
    @Deprecated
    public final Status mStatus;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ApiException(Status status) {
        // int i = status.zzc;
        // String str = status.zzd;
        // str = str == null ? "" : str;
        super(i + ": " + str);
        this.mStatus = status;
    }
}
