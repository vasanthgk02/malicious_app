package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@20.1.2 */
public final class zzcx extends zzdt {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ Context zzc;
    public final /* synthetic */ Bundle zzd;
    public final /* synthetic */ zzee zze;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzcx(zzee zzee, String str, String str2, Context context, Bundle bundle) {
        // this.zze = zzee;
        // this.zza = str;
        // this.zzb = str2;
        // this.zzc = context;
        // this.zzd = bundle;
        super(zzee, true);
    }

    public final void zza() {
        String str;
        String str2;
        String str3;
        try {
            if (zzee.zzV(this.zza, this.zzb)) {
                String str4 = this.zzb;
                str2 = this.zza;
                str = str4;
                str3 = this.zze.zzd;
            } else {
                str3 = null;
                str2 = null;
                str = null;
            }
            Preconditions.checkNotNull(this.zzc);
            zzee zzee = this.zze;
            zzee.zzj = zzee.zzf(this.zzc, true);
            if (this.zze.zzj == null) {
                this.zze.zzd;
                return;
            }
            int localVersion = DynamiteModule.getLocalVersion(this.zzc, ModuleDescriptor.MODULE_ID);
            int zza2 = DynamiteModule.zza(this.zzc, ModuleDescriptor.MODULE_ID, false);
            zzcl zzcl = new zzcl(61000, (long) Math.max(localVersion, zza2), zza2 < localVersion, str3, str2, str, this.zzd, ImageOriginUtils.zza(this.zzc));
            zzcc zze2 = this.zze.zzj;
            Preconditions.checkNotNull(zze2);
            zze2.initialize(new ObjectWrapper(this.zzc), zzcl, this.zzh);
        } catch (Exception e2) {
            this.zze.zzS(e2, true, false);
        }
    }
}
