package com.google.android.gms.measurement.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final /* synthetic */ class zzfu implements Callable {
    public final /* synthetic */ zzfz zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzfu(zzfz zzfz, String str) {
        this.zza = zzfz;
        this.zzb = str;
    }

    public final Object call() {
        zzfz zzfz = this.zza;
        String str = this.zzb;
        zzal zzal = zzfz.zzf.zze;
        zzli.zzak(zzal);
        zzg zzj = zzal.zzj(str);
        HashMap outline88 = GeneratedOutlineSupport.outline88("platform", "android", "package_name", str);
        zzfz.zzs.zzk.zzh();
        outline88.put("gmp_version", Long.valueOf(61000));
        if (zzj != null) {
            String zzw = zzj.zzw();
            if (zzw != null) {
                outline88.put("app_version", zzw);
            }
            outline88.put("app_version_int", Long.valueOf(zzj.zzb()));
            outline88.put("dynamite_version", Long.valueOf(zzj.zzk()));
        }
        return outline88;
    }
}
