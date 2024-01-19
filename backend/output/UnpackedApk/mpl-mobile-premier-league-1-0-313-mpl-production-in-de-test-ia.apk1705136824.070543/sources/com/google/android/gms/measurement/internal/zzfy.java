package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzo;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzfy implements zzo {
    public final /* synthetic */ String zza;
    public final /* synthetic */ zzfz zzb;

    public zzfy(zzfz zzfz, String str) {
        this.zzb = zzfz;
        this.zza = str;
    }

    public final String zza(String str) {
        Map map = (Map) this.zzb.zzg.get(this.zza);
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return (String) map.get(str);
    }
}
