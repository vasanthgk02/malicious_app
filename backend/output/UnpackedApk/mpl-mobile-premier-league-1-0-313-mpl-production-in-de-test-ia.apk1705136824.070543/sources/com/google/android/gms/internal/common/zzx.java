package com.google.android.gms.internal.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jspecify.nullness.NullMarked;

@NullMarked
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class zzx {
    public final zzo zza;
    public final boolean zzb;
    public final zzu zzc;

    public zzx(zzu zzu, boolean z, zzo zzo, int i, byte[] bArr) {
        this.zzc = zzu;
        this.zzb = z;
        this.zza = zzo;
    }

    public static zzx zzc(zzo zzo) {
        zzx zzx = new zzx(new zzu(zzo), false, zzn.zza, Integer.MAX_VALUE, null);
        return zzx;
    }

    /* access modifiers changed from: private */
    public final Iterator zzh(CharSequence charSequence) {
        return new zzt(this.zzc, this, charSequence);
    }

    public final zzx zzb() {
        zzx zzx = new zzx(this.zzc, true, this.zza, Integer.MAX_VALUE, null);
        return zzx;
    }

    public final Iterable zzd(CharSequence charSequence) {
        return new zzv(this, charSequence);
    }

    public final List zzf(CharSequence charSequence) {
        if (charSequence != null) {
            Iterator zzh = zzh(charSequence);
            ArrayList arrayList = new ArrayList();
            while (zzh.hasNext()) {
                arrayList.add((String) zzh.next());
            }
            return Collections.unmodifiableList(arrayList);
        }
        throw null;
    }
}
