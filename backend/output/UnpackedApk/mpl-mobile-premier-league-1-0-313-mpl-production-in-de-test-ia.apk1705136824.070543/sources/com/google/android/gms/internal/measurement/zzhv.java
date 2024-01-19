package com.google.android.gms.internal.measurement;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzhv {
    public final String zza;
    public final Uri zzb;
    public final String zzc;
    public final String zzd;
    public final boolean zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final zzic zzi;

    public zzhv(Uri uri) {
        this(null, uri, "", "", false, false, false, false, null);
    }

    public zzhv(String str, Uri uri, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, zzic zzic) {
        this.zza = null;
        this.zzb = uri;
        this.zzc = "";
        this.zzd = "";
        this.zze = z;
        this.zzf = false;
        this.zzg = z3;
        this.zzh = false;
        this.zzi = null;
    }

    public final zzhv zza() {
        zzhv zzhv = new zzhv(null, this.zzb, this.zzc, this.zzd, this.zze, false, true, false, null);
        return zzhv;
    }

    public final zzhv zzb() {
        if (this.zzc.isEmpty()) {
            zzhv zzhv = new zzhv(null, this.zzb, this.zzc, this.zzd, true, false, this.zzg, false, null);
            return zzhv;
        }
        throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
    }

    public final zzhy zzc(String str, double d2) {
        return new zzht(this, "measurement.test.double_flag", Double.valueOf(-3.0d), true);
    }

    public final zzhy zzd(String str, long j) {
        return new zzhr(this, str, Long.valueOf(j), true);
    }

    public final zzhy zze(String str, String str2) {
        return new zzhu(this, str, str2, true);
    }

    public final zzhy zzf(String str, boolean z) {
        return new zzhs(this, str, Boolean.valueOf(z), true);
    }
}
