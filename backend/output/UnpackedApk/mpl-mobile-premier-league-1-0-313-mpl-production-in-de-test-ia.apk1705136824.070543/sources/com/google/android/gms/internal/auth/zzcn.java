package com.google.android.gms.internal.auth;

import a.a.a.a.d.b;
import android.content.Context;
import android.database.ContentObserver;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzcn implements zzck {
    public static zzcn zza;
    public final Context zzb;
    public final ContentObserver zzc;

    public zzcn() {
        this.zzb = null;
        this.zzc = null;
    }

    public zzcn(Context context) {
        this.zzb = context;
        this.zzc = new zzcm(this, null);
        context.getContentResolver().registerContentObserver(zzcb.zza, true, this.zzc);
    }

    public static zzcn zza(Context context) {
        zzcn zzcn;
        zzcn zzcn2;
        synchronized (zzcn.class) {
            try {
                if (zza == null) {
                    if (b.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
                        zzcn2 = new zzcn(context);
                    } else {
                        zzcn2 = new zzcn();
                    }
                    zza = zzcn2;
                }
                zzcn = zza;
            }
        }
        return zzcn;
    }

    public static synchronized void zze() {
        synchronized (zzcn.class) {
            if (!(zza == null || zza.zzb == null || zza.zzc == null)) {
                zza.zzb.getContentResolver().unregisterContentObserver(zza.zzc);
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
            return (String) zzci.zza(new zzcl(this, str));
        } catch (IllegalStateException | SecurityException unused) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                "Unable to read GServices for: ".concat(valueOf);
            } else {
                new String("Unable to read GServices for: ");
            }
            return null;
        }
    }

    public final /* synthetic */ String zzd(String str) {
        return zzcb.zza(this.zzb.getContentResolver(), str, null);
    }
}
