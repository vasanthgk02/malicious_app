package com.google.android.gms.common;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class zzv extends zzx {
    public final Callable zze;

    public /* synthetic */ zzv(Callable callable) {
        super(false, 1, null, null);
        this.zze = callable;
    }

    public final String zza() {
        try {
            return (String) this.zze.call();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
