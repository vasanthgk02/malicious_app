package com.google.android.gms.internal.common;

import org.jspecify.nullness.NullMarked;

@NullMarked
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class zzai extends zzag {
    public static final zzag zza = new zzai(new Object[0], 0);
    public final transient Object[] zzb;
    public final transient int zzc;

    public zzai(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    public final Object get(int i) {
        zzs.zza(i, this.zzc, "index");
        Object obj = this.zzb[i];
        obj.getClass();
        return obj;
    }

    public final int size() {
        return this.zzc;
    }

    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    public final int zzb() {
        return this.zzc;
    }

    public final int zzc() {
        return 0;
    }

    public final boolean zzf() {
        return false;
    }

    public final Object[] zzg() {
        return this.zzb;
    }
}
