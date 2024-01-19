package com.google.android.gms.internal.location;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzbq<E> extends zzbo<E> {
    public final zzbs<E> zza;

    public zzbq(zzbs<E> zzbs, int i) {
        super(zzbs.size(), i);
        this.zza = zzbs;
    }

    public final E zza(int i) {
        return this.zza.get(i);
    }
}
