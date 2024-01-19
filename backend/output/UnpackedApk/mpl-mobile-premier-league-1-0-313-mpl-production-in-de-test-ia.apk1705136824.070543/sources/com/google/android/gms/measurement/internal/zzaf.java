package com.google.android.gms.measurement.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.mpl.androidapp.utils.Constant;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzaf extends zzhb {
    public Boolean zza;
    public zzae zzb = zzad.zza;
    public Boolean zzc;

    public zzaf(zzgi zzgi) {
        super(zzgi);
    }

    public static final long zzA() {
        return ((Long) zzel.zzC.zza(null)).longValue();
    }

    public static final long zzz() {
        return ((Long) zzel.zzc.zza(null)).longValue();
    }

    public final String zzB(String str, String str2) {
        Class<String> cls = String.class;
        try {
            String str3 = (String) Class.forName("android.os.SystemProperties").getMethod(Constant.GET, new Class[]{cls, cls}).invoke(null, new Object[]{str, ""});
            Preconditions.checkNotNull(str3);
            return str3;
        } catch (ClassNotFoundException e2) {
            this.zzs.zzaz().zzd.zzb("Could not find SystemProperties class", e2);
            return "";
        } catch (NoSuchMethodException e3) {
            this.zzs.zzaz().zzd.zzb("Could not find SystemProperties.get() method", e3);
            return "";
        } catch (IllegalAccessException e4) {
            this.zzs.zzaz().zzd.zzb("Could not access SystemProperties.get()", e4);
            return "";
        } catch (InvocationTargetException e5) {
            this.zzs.zzaz().zzd.zzb("SystemProperties.get() threw an exception", e5);
            return "";
        }
    }

    public final double zza(String str, zzek zzek) {
        if (str == null) {
            return ((Double) zzek.zza(null)).doubleValue();
        }
        String zza2 = this.zzb.zza(str, zzek.zzb);
        if (TextUtils.isEmpty(zza2)) {
            return ((Double) zzek.zza(null)).doubleValue();
        }
        try {
            return ((Double) zzek.zza(Double.valueOf(Double.parseDouble(zza2)))).doubleValue();
        } catch (NumberFormatException unused) {
            return ((Double) zzek.zza(null)).doubleValue();
        }
    }

    public final int zzb(String str) {
        return Math.max(Math.min(zze(str, zzel.zzG), 2000), 500);
    }

    public final int zzc() {
        zzlp zzv = this.zzs.zzv();
        Boolean bool = zzv.zzs.zzt().zzc;
        return (zzv.zzm() >= 201500 || (bool != null && !bool.booleanValue())) ? 100 : 25;
    }

    public final int zzd(String str) {
        return Math.max(Math.min(zze(str, zzel.zzH), 100), 25);
    }

    public final int zze(String str, zzek zzek) {
        if (str == null) {
            return ((Integer) zzek.zza(null)).intValue();
        }
        String zza2 = this.zzb.zza(str, zzek.zzb);
        if (TextUtils.isEmpty(zza2)) {
            return ((Integer) zzek.zza(null)).intValue();
        }
        try {
            return ((Integer) zzek.zza(Integer.valueOf(Integer.parseInt(zza2)))).intValue();
        } catch (NumberFormatException unused) {
            return ((Integer) zzek.zza(null)).intValue();
        }
    }

    public final int zzf(String str, zzek zzek, int i, int i2) {
        return Math.max(Math.min(zze(str, zzek), i2), i);
    }

    public final long zzh() {
        zzaa zzaa = this.zzs.zzj;
        return 61000;
    }

    public final long zzi(String str, zzek zzek) {
        if (str == null) {
            return ((Long) zzek.zza(null)).longValue();
        }
        String zza2 = this.zzb.zza(str, zzek.zzb);
        if (TextUtils.isEmpty(zza2)) {
            return ((Long) zzek.zza(null)).longValue();
        }
        try {
            return ((Long) zzek.zza(Long.valueOf(Long.parseLong(zza2)))).longValue();
        } catch (NumberFormatException unused) {
            return ((Long) zzek.zza(null)).longValue();
        }
    }

    @VisibleForTesting
    public final Bundle zzj() {
        try {
            if (this.zzs.zze.getPackageManager() == null) {
                this.zzs.zzaz().zzd.zza("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(this.zzs.zze).getApplicationInfo(this.zzs.zze.getPackageName(), 128);
            if (applicationInfo != null) {
                return applicationInfo.metaData;
            }
            this.zzs.zzaz().zzd.zza("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (NameNotFoundException e2) {
            this.zzs.zzaz().zzd.zzb("Failed to load metadata: Package name not found", e2);
            return null;
        }
    }

    @VisibleForTesting
    public final Boolean zzk(String str) {
        Preconditions.checkNotEmpty(str);
        Bundle zzj = zzj();
        if (zzj == null) {
            this.zzs.zzaz().zzd.zza("Failed to load metadata: Metadata bundle is null");
            return null;
        } else if (!zzj.containsKey(str)) {
            return null;
        } else {
            return Boolean.valueOf(zzj.getBoolean(str));
        }
    }

    public final boolean zzr() {
        Boolean zzk = zzk("google_analytics_adid_collection_enabled");
        return zzk == null || zzk.booleanValue();
    }

    public final boolean zzs(String str, zzek zzek) {
        if (str == null) {
            return ((Boolean) zzek.zza(null)).booleanValue();
        }
        String zza2 = this.zzb.zza(str, zzek.zzb);
        if (TextUtils.isEmpty(zza2)) {
            return ((Boolean) zzek.zza(null)).booleanValue();
        }
        return ((Boolean) zzek.zza(Boolean.valueOf("1".equals(zza2)))).booleanValue();
    }

    public final boolean zzt(String str) {
        return "1".equals(this.zzb.zza(str, "gaia_collection_enabled"));
    }

    public final boolean zzu() {
        Boolean zzk = zzk("google_analytics_automatic_screen_reporting_enabled");
        return zzk == null || zzk.booleanValue();
    }

    public final boolean zzv() {
        zzaa zzaa = this.zzs.zzj;
        Boolean zzk = zzk("firebase_analytics_collection_deactivated");
        return zzk != null && zzk.booleanValue();
    }

    public final boolean zzw(String str) {
        return "1".equals(this.zzb.zza(str, "measurement.event_sampling_enabled"));
    }

    public final boolean zzx() {
        if (this.zza == null) {
            Boolean zzk = zzk("app_measurement_lite");
            this.zza = zzk;
            if (zzk == null) {
                this.zza = Boolean.FALSE;
            }
        }
        return this.zza.booleanValue() || !this.zzs.zzi;
    }
}
