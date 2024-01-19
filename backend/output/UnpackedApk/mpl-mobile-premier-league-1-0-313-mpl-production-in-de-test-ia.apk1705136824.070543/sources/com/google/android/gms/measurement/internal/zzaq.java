package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzaq {
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final long zzd;
    public final long zze;
    public final zzat zzf;

    public zzaq(zzgi zzgi, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzat zzat;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.zza = str2;
        this.zzb = str3;
        this.zzc = true == TextUtils.isEmpty(str) ? null : str;
        this.zzd = j;
        this.zze = j2;
        if (j2 != 0 && j2 > j) {
            zzgi.zzaz().zzg.zzb("Event created with reverse previous/current timestamps. appId", zzey.zzn(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            zzat = new zzat(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String str4 = (String) it.next();
                if (str4 == null) {
                    zzgi.zzaz().zzd.zza("Param name can't be null");
                    it.remove();
                } else {
                    Object zzA = zzgi.zzv().zzA(str4, bundle2.get(str4));
                    if (zzA == null) {
                        zzgi.zzaz().zzg.zzb("Param value can't be null", zzgi.zzq.zze(str4));
                        it.remove();
                    } else {
                        zzgi.zzv().zzO(bundle2, str4, zzA);
                    }
                }
            }
            zzat = new zzat(bundle2);
        }
        this.zzf = zzat;
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        return GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline82("Event{appId='", str, "', name='", str2, "', params="), this.zzf.toString(), "}");
    }

    public final zzaq zza(zzgi zzgi, long j) {
        zzaq zzaq = new zzaq(zzgi, this.zzc, this.zza, this.zzb, this.zzd, j, this.zzf);
        return zzaq;
    }

    public zzaq(zzgi zzgi, String str, String str2, String str3, long j, long j2, zzat zzat) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzat);
        this.zza = str2;
        this.zzb = str3;
        this.zzc = true == TextUtils.isEmpty(str) ? null : str;
        this.zzd = j;
        this.zze = j2;
        if (j2 != 0 && j2 > j) {
            zzgi.zzaz().zzg.zzc("Event created with reverse previous/current timestamps. appId, name", zzey.zzn(str2), zzey.zzn(str3));
        }
        this.zzf = zzat;
    }
}
