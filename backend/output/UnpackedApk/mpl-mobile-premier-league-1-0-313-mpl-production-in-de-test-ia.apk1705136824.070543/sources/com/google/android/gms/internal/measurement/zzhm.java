package com.google.android.gms.internal.measurement;

import a.a.a.a.d.b;
import android.content.Context;
import android.database.ContentObserver;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzhm implements zzhj {
    public static zzhm zza;
    public final Context zzb;
    public final ContentObserver zzc;

    public zzhm() {
        this.zzb = null;
        this.zzc = null;
    }

    public zzhm(Context context) {
        this.zzb = context;
        this.zzc = new zzhl(this, null);
        context.getContentResolver().registerContentObserver(zzgz.zza, true, this.zzc);
    }

    public static zzhm zza(Context context) {
        zzhm zzhm;
        zzhm zzhm2;
        synchronized (zzhm.class) {
            try {
                if (zza == null) {
                    if (b.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
                        zzhm2 = new zzhm(context);
                    } else {
                        zzhm2 = new zzhm();
                    }
                    zza = zzhm2;
                }
                zzhm = zza;
            }
        }
        return zzhm;
    }

    public static synchronized void zze() {
        synchronized (zzhm.class) {
            zzhm zzhm = zza;
            if (zzhm != null) {
                Context context = zzhm.zzb;
                if (!(context == null || zzhm.zzc == null)) {
                    context.getContentResolver().unregisterContentObserver(zza.zzc);
                }
            }
            zza = null;
        }
    }

    /* renamed from: zzc */
    public final String zzb(String str) {
        if (this.zzb == null) {
            return null;
        }
        try {
            return (String) zzhh.zza(new zzhk(this, str));
        } catch (IllegalStateException | NullPointerException | SecurityException unused) {
            "Unable to read GServices for: ".concat(String.valueOf(str));
            return null;
        }
    }

    public final /* synthetic */ String zzd(String str) {
        return zzgz.zza(this.zzb.getContentResolver(), str, null);
    }
}
