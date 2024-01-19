package com.google.android.gms.internal.measurement;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzad implements Iterator {
    public final /* synthetic */ zzae zza;
    public int zzb = 0;

    public zzad(zzae zzae) {
        this.zza = zzae;
    }

    public final boolean hasNext() {
        return this.zzb < this.zza.zzc();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        if (this.zzb < this.zza.zzc()) {
            zzae zzae = this.zza;
            int i = this.zzb;
            this.zzb = i + 1;
            return zzae.zze(i);
        }
        throw new NoSuchElementException(GeneratedOutlineSupport.outline41("Out of bounds index: ", this.zzb));
    }
}
