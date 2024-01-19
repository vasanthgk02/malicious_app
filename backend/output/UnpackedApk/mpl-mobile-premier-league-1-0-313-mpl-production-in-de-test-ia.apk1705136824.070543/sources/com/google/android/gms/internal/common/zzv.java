package com.google.android.gms.internal.common;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class zzv implements Iterable {
    public final /* synthetic */ CharSequence zza;
    public final /* synthetic */ zzx zzb;

    public zzv(zzx zzx, CharSequence charSequence) {
        this.zzb = zzx;
        this.zza = charSequence;
    }

    public final Iterator iterator() {
        return this.zzb.zzh(this.zza);
    }

    public final String toString() {
        StringBuilder outline72 = GeneratedOutlineSupport.outline72('[');
        Iterator it = iterator();
        try {
            if (it.hasNext()) {
                outline72.append(zzq.zza(it.next(), ", "));
                while (it.hasNext()) {
                    outline72.append(", ");
                    outline72.append(zzq.zza(it.next(), ", "));
                }
            }
            outline72.append(']');
            return outline72.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
