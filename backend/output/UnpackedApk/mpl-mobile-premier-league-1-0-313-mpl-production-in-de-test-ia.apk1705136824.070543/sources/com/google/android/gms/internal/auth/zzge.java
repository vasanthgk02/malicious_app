package com.google.android.gms.internal.auth;

import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzge extends zzgl {
    public zzge(int i) {
        super(i, null);
    }

    public final void zza() {
        if (!zzj()) {
            for (int i = 0; i < zzb(); i++) {
                Entry zzg = zzg(i);
                if (((zzek) zzg.getKey()).zzc()) {
                    zzg.setValue(Collections.unmodifiableList((List) zzg.getValue()));
                }
            }
            for (Entry entry : zzc()) {
                if (((zzek) entry.getKey()).zzc()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zza();
    }
}
