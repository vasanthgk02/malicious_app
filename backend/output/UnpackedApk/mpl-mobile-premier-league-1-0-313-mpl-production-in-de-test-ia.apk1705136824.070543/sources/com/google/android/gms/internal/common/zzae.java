package com.google.android.gms.internal.common;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class zzae extends zzz {
    public final zzag zza;

    public zzae(zzag zzag, int i) {
        super(zzag.size(), i);
        this.zza = zzag;
    }

    public final Object zza(int i) {
        return this.zza.get(i);
    }
}
