package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzjb extends zzf {
    @VisibleForTesting
    public zziu zza;
    public volatile zziu zzb;
    public volatile zziu zzc;
    public final Map zzd = new ConcurrentHashMap();
    public Activity zze;
    public volatile boolean zzf;
    public volatile zziu zzg;
    public zziu zzh;
    public boolean zzi;
    public final Object zzj = new Object();
    public String zzl;

    public zzjb(zzgi zzgi) {
        super(zzgi);
    }

    public final void zzA(Activity activity, zziu zziu, boolean z) {
        zziu zziu2;
        zziu zziu3;
        zziu zziu4 = zziu;
        if (this.zzb == null) {
            zziu2 = this.zzc;
        } else {
            zziu2 = this.zzb;
        }
        zziu zziu5 = zziu2;
        if (zziu4.zzb == null) {
            zziu zziu6 = new zziu(zziu4.zza, activity != null ? zzl(activity.getClass(), "Activity") : null, zziu4.zzc, zziu4.zze, zziu4.zzf);
            zziu3 = zziu6;
        } else {
            zziu3 = zziu4;
        }
        this.zzc = this.zzb;
        this.zzb = zziu3;
        long elapsedRealtime = this.zzs.zzr.elapsedRealtime();
        zzgf zzaA = this.zzs.zzaA();
        zziw zziw = new zziw(this, zziu3, zziu5, elapsedRealtime, z);
        zzaA.zzp(zziw);
    }

    public final void zzB(zziu zziu, zziu zziu2, long j, boolean z, Bundle bundle) {
        Bundle bundle2;
        long j2;
        zziu zziu3 = zziu;
        zziu zziu4 = zziu2;
        long j3 = j;
        Bundle bundle3 = bundle;
        zzg();
        boolean z2 = false;
        boolean z3 = zziu4 == null || zziu4.zzc != zziu3.zzc || !zzlp.zzal(zziu4.zzb, zziu3.zzb) || !zzlp.zzal(zziu4.zza, zziu3.zza);
        if (z && this.zza != null) {
            z2 = true;
        }
        if (z3) {
            if (bundle3 != null) {
                bundle2 = new Bundle(bundle3);
            } else {
                bundle2 = new Bundle();
            }
            Bundle bundle4 = bundle2;
            zzlp.zzK(zziu3, bundle4, true);
            if (zziu4 != null) {
                String str = zziu4.zza;
                if (str != null) {
                    bundle4.putString("_pn", str);
                }
                String str2 = zziu4.zzb;
                if (str2 != null) {
                    bundle4.putString("_pc", str2);
                }
                bundle4.putLong("_pi", zziu4.zzc);
            }
            if (z2) {
                zzkp zzkp = this.zzs.zzu().zzb;
                long j4 = j3 - zzkp.zzb;
                zzkp.zzb = j3;
                if (j4 > 0) {
                    this.zzs.zzv().zzI(bundle4, j4);
                }
            }
            if (!this.zzs.zzk.zzu()) {
                bundle4.putLong("_mst", 1);
            }
            String str3 = true != zziu3.zze ? "auto" : "app";
            long currentTimeMillis = this.zzs.zzr.currentTimeMillis();
            if (zziu3.zze) {
                long j5 = zziu3.zzf;
                if (j5 != 0) {
                    j2 = j5;
                    this.zzs.zzq().zzI(str3, "_vs", j2, bundle4);
                }
            }
            j2 = currentTimeMillis;
            this.zzs.zzq().zzI(str3, "_vs", j2, bundle4);
        }
        if (z2) {
            zzC(this.zza, true, j3);
        }
        this.zza = zziu3;
        if (zziu3.zze) {
            this.zzh = zziu3;
        }
        zzkb zzt = this.zzs.zzt();
        zzt.zzg();
        zzt.zza();
        zzt.zzR(new zzjj(zzt, zziu3));
    }

    public final void zzC(zziu zziu, boolean z, long j) {
        this.zzs.zzd().zzf(this.zzs.zzr.elapsedRealtime());
        if (this.zzs.zzu().zzb.zzd(zziu != null && zziu.zzd, z, j) && zziu != null) {
            zziu.zzd = false;
        }
    }

    public final boolean zzf() {
        return false;
    }

    public final zziu zzj(boolean z) {
        zza();
        zzg();
        if (!z) {
            return this.zza;
        }
        zziu zziu = this.zza;
        return zziu != null ? zziu : this.zzh;
    }

    @VisibleForTesting
    public final String zzl(Class cls, String str) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            return "Activity";
        }
        String[] split = canonicalName.split("\\.");
        int length = split.length;
        String str2 = length > 0 ? split[length - 1] : "";
        int length2 = str2.length();
        zzaf zzaf = this.zzs.zzk;
        if (length2 > 100) {
            str2 = str2.substring(0, 100);
        }
        return str2;
    }

    public final void zzr(Activity activity, Bundle bundle) {
        if (this.zzs.zzk.zzu() && bundle != null) {
            Bundle bundle2 = bundle.getBundle("com.google.app_measurement.screen_service");
            if (bundle2 != null) {
                this.zzd.put(activity, new zziu(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
            }
        }
    }

    public final void zzy(String str, zziu zziu) {
        zzg();
        synchronized (this) {
            String str2 = this.zzl;
            if (str2 == null || str2.equals(str) || zziu != null) {
                this.zzl = str;
            }
        }
    }

    public final zziu zzz(Activity activity) {
        Preconditions.checkNotNull(activity);
        zziu zziu = (zziu) this.zzd.get(activity);
        if (zziu == null) {
            zziu zziu2 = new zziu(null, zzl(activity.getClass(), "Activity"), this.zzs.zzv().zzq());
            this.zzd.put(activity, zziu2);
            zziu = zziu2;
        }
        return this.zzg != null ? this.zzg : zziu;
    }
}
