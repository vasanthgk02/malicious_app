package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzoc;
import com.google.android.gms.internal.measurement.zzpp;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzkq {
    public final /* synthetic */ zzkr zza;

    public zzkq(zzkr zzkr) {
        this.zza = zzkr;
    }

    public final void zza() {
        this.zza.zzg();
        if (this.zza.zzs.zzm().zzk(this.zza.zzs.zzr.currentTimeMillis())) {
            this.zza.zzs.zzm().zzg.zza(true);
            RunningAppProcessInfo runningAppProcessInfo = new RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.zza.zzs.zzaz().zzl.zza("Detected application was in foreground");
                zzc(this.zza.zzs.zzr.currentTimeMillis(), false);
            }
        }
    }

    public final void zzb(long j, boolean z) {
        this.zza.zzg();
        this.zza.zzm();
        if (this.zza.zzs.zzm().zzk(j)) {
            this.zza.zzs.zzm().zzg.zza(true);
            zzpp.zzc();
            if (this.zza.zzs.zzk.zzs(null, zzel.zzaI)) {
                this.zza.zzs.zzh().zzo();
            }
        }
        this.zza.zzs.zzm().zzj.zzb(j);
        if (this.zza.zzs.zzm().zzg.zzb()) {
            zzc(j, z);
        }
    }

    @VisibleForTesting
    public final void zzc(long j, boolean z) {
        this.zza.zzg();
        if (this.zza.zzs.zzJ()) {
            this.zza.zzs.zzm().zzj.zzb(j);
            this.zza.zzs.zzaz().zzl.zzb("Session started, time", Long.valueOf(this.zza.zzs.zzr.elapsedRealtime()));
            Long valueOf = Long.valueOf(j / 1000);
            this.zza.zzs.zzq().zzaa("auto", "_sid", valueOf, j);
            this.zza.zzs.zzm().zzg.zza(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", valueOf.longValue());
            if (this.zza.zzs.zzk.zzs(null, zzel.zzaa) && z) {
                bundle.putLong("_aib", 1);
            }
            this.zza.zzs.zzq().zzI("auto", "_s", j, bundle);
            zzoc.zzc();
            if (this.zza.zzs.zzk.zzs(null, zzel.zzad)) {
                String zza2 = this.zza.zzs.zzm().zzo.zza();
                if (!TextUtils.isEmpty(zza2)) {
                    this.zza.zzs.zzq().zzI("auto", "_ssr", j, GeneratedOutlineSupport.outline14("_ffr", zza2));
                }
            }
        }
    }
}
