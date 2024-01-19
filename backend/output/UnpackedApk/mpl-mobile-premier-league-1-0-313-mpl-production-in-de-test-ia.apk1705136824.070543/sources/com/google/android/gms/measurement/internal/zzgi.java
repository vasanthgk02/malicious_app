package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzcl;
import com.google.android.gms.internal.measurement.zzhy;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzgi implements zzhd {
    public static volatile zzgi zzd;
    public zzep zzA;
    public boolean zzB = false;
    public Boolean zzC;
    public long zzD;
    public volatile Boolean zzE;
    public volatile boolean zzF;
    public int zzG;
    public final AtomicInteger zzH = new AtomicInteger(0);
    @VisibleForTesting
    public Boolean zza;
    @VisibleForTesting
    public Boolean zzb;
    @VisibleForTesting
    public final long zzc;
    public final Context zze;
    public final String zzf;
    public final String zzg;
    public final String zzh;
    public final boolean zzi;
    public final zzaa zzj;
    public final zzaf zzk;
    public final zzfn zzl;
    public final zzey zzm;
    public final zzgf zzn;
    public final zzkr zzo;
    public final zzlp zzp;
    public final zzet zzq;
    public final Clock zzr;
    public final zzjb zzs;
    public final zzin zzt;
    public final zzd zzu;
    public final zzir zzv;
    public final String zzw;
    public zzer zzx;
    public zzkb zzy;
    public zzap zzz;

    public zzgi(zzhl zzhl) {
        long j;
        boolean z = false;
        Preconditions.checkNotNull(zzhl);
        Context context = zzhl.zza;
        zzaa zzaa = new zzaa();
        this.zzj = zzaa;
        ImageOriginUtils.zza = zzaa;
        this.zze = context;
        this.zzf = zzhl.zzb;
        this.zzg = zzhl.zzc;
        this.zzh = zzhl.zzd;
        this.zzi = zzhl.zzh;
        this.zzE = zzhl.zze;
        this.zzw = zzhl.zzj;
        this.zzF = true;
        zzcl zzcl = zzhl.zzg;
        if (zzcl != null) {
            Bundle bundle = zzcl.zzg;
            if (bundle != null) {
                Object obj = bundle.get("measurementEnabled");
                if (obj instanceof Boolean) {
                    this.zza = (Boolean) obj;
                }
                Object obj2 = zzcl.zzg.get("measurementDeactivated");
                if (obj2 instanceof Boolean) {
                    this.zzb = (Boolean) obj2;
                }
            }
        }
        zzhy.zze(this.zze);
        DefaultClock defaultClock = DefaultClock.zza;
        this.zzr = defaultClock;
        Long l = zzhl.zzi;
        if (l != null) {
            j = l.longValue();
        } else {
            j = defaultClock.currentTimeMillis();
        }
        this.zzc = j;
        this.zzk = new zzaf(this);
        zzfn zzfn = new zzfn(this);
        zzfn.zzv();
        this.zzl = zzfn;
        zzey zzey = new zzey(this);
        zzey.zzv();
        this.zzm = zzey;
        zzlp zzlp = new zzlp(this);
        zzlp.zzv();
        this.zzp = zzlp;
        this.zzq = new zzet(new zzhk(this));
        this.zzu = new zzd(this);
        zzjb zzjb = new zzjb(this);
        zzjb.zzb();
        this.zzs = zzjb;
        zzin zzin = new zzin(this);
        zzin.zzb();
        this.zzt = zzin;
        zzkr zzkr = new zzkr(this);
        zzkr.zzb();
        this.zzo = zzkr;
        zzir zzir = new zzir(this);
        zzir.zzv();
        this.zzv = zzir;
        zzgf zzgf = new zzgf(this);
        zzgf.zzv();
        this.zzn = zzgf;
        zzcl zzcl2 = zzhl.zzg;
        z = (zzcl2 == null || zzcl2.zzb == 0) ? true : z;
        if (this.zze.getApplicationContext() instanceof Application) {
            zzin zzq2 = zzq();
            if (zzq2.zzs.zze.getApplicationContext() instanceof Application) {
                Application application = (Application) zzq2.zzs.zze.getApplicationContext();
                if (zzq2.zza == null) {
                    zzq2.zza = new zzim(zzq2);
                }
                if (z) {
                    application.unregisterActivityLifecycleCallbacks(zzq2.zza);
                    application.registerActivityLifecycleCallbacks(zzq2.zza);
                    zzq2.zzs.zzaz().zzl.zza("Registered activity lifecycle callback");
                }
            }
        } else {
            zzaz().zzg.zza("Application context is not an Application");
        }
        this.zzn.zzp(new zzgh(this, zzhl));
    }

    public static final void zzO() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    public static final void zzQ(zzf zzf2) {
        if (zzf2 == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzf2.zza) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(zzf2.getClass())));
        }
    }

    public static final void zzR(zzhc zzhc) {
        if (zzhc == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzhc.zzx()) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(zzhc.getClass())));
        }
    }

    public static zzgi zzp(Context context, zzcl zzcl, Long l) {
        if (zzcl != null && (zzcl.zze == null || zzcl.zzf == null)) {
            zzcl zzcl2 = new zzcl(zzcl.zza, zzcl.zzb, zzcl.zzc, zzcl.zzd, null, null, zzcl.zzg, null);
            zzcl = zzcl2;
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzd == null) {
            synchronized (zzgi.class) {
                if (zzd == null) {
                    zzd = new zzgi(new zzhl(context, zzcl, l));
                }
            }
        } else if (zzcl != null) {
            Bundle bundle = zzcl.zzg;
            if (bundle != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
                Preconditions.checkNotNull(zzd);
                zzd.zzE = Boolean.valueOf(zzcl.zzg.getBoolean("dataCollectionDefaultEnabled"));
            }
        }
        Preconditions.checkNotNull(zzd);
        return zzd;
    }

    public final boolean zzI() {
        return this.zzE != null && this.zzE.booleanValue();
    }

    public final boolean zzJ() {
        return zza() == 0;
    }

    @Pure
    public final boolean zzL() {
        return TextUtils.isEmpty(this.zzf);
    }

    public final boolean zzM() {
        if (this.zzB) {
            zzaA().zzg();
            Boolean bool = this.zzC;
            if (bool == null || this.zzD == 0 || (!bool.booleanValue() && Math.abs(this.zzr.elapsedRealtime() - this.zzD) > 1000)) {
                this.zzD = this.zzr.elapsedRealtime();
                boolean z = true;
                Boolean valueOf = Boolean.valueOf(zzv().zzad("android.permission.INTERNET") && zzv().zzad("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.zze).isCallerInstantApp() || this.zzk.zzx() || (zzlp.zzaj(this.zze) && zzlp.zzak(this.zze))));
                this.zzC = valueOf;
                if (valueOf.booleanValue()) {
                    zzlp zzv2 = zzv();
                    String zzm2 = zzh().zzm();
                    zzep zzh2 = zzh();
                    zzh2.zza();
                    if (!zzv2.zzX(zzm2, zzh2.zzl)) {
                        zzep zzh3 = zzh();
                        zzh3.zza();
                        if (TextUtils.isEmpty(zzh3.zzl)) {
                            z = false;
                        }
                    }
                    this.zzC = Boolean.valueOf(z);
                }
            }
            return this.zzC.booleanValue();
        }
        throw new IllegalStateException("AppMeasurement is not initialized");
    }

    public final int zza() {
        zzaA().zzg();
        if (this.zzk.zzv()) {
            return 1;
        }
        Boolean bool = this.zzb;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        zzaA().zzg();
        if (!this.zzF) {
            return 8;
        }
        Boolean zzd2 = zzm().zzd();
        if (zzd2 == null) {
            zzaf zzaf = this.zzk;
            zzaa zzaa = zzaf.zzs.zzj;
            Boolean zzk2 = zzaf.zzk("firebase_analytics_collection_enabled");
            if (zzk2 == null) {
                Boolean bool2 = this.zza;
                if (bool2 != null) {
                    if (bool2.booleanValue()) {
                        return 0;
                    }
                    return 5;
                } else if (this.zzE == null || this.zzE.booleanValue()) {
                    return 0;
                } else {
                    return 7;
                }
            } else if (zzk2.booleanValue()) {
                return 0;
            } else {
                return 4;
            }
        } else if (zzd2.booleanValue()) {
            return 0;
        } else {
            return 3;
        }
    }

    @Pure
    public final zzgf zzaA() {
        zzR(this.zzn);
        return this.zzn;
    }

    @Pure
    public final Context zzav() {
        return this.zze;
    }

    @Pure
    public final Clock zzaw() {
        return this.zzr;
    }

    @Pure
    public final zzaa zzax() {
        return this.zzj;
    }

    @Pure
    public final zzey zzaz() {
        zzR(this.zzm);
        return this.zzm;
    }

    @Pure
    public final zzd zzd() {
        zzd zzd2 = this.zzu;
        if (zzd2 != null) {
            return zzd2;
        }
        throw new IllegalStateException("Component not created");
    }

    @Pure
    public final zzaf zzf() {
        return this.zzk;
    }

    @Pure
    public final zzap zzg() {
        zzR(this.zzz);
        return this.zzz;
    }

    @Pure
    public final zzep zzh() {
        zzQ(this.zzA);
        return this.zzA;
    }

    @Pure
    public final zzer zzi() {
        zzQ(this.zzx);
        return this.zzx;
    }

    @Pure
    public final zzet zzj() {
        return this.zzq;
    }

    @Pure
    public final zzfn zzm() {
        zzfn zzfn = this.zzl;
        if (zzfn != null) {
            return zzfn;
        }
        throw new IllegalStateException("Component not created");
    }

    @Pure
    public final zzin zzq() {
        zzQ(this.zzt);
        return this.zzt;
    }

    @Pure
    public final zzir zzr() {
        zzR(this.zzv);
        return this.zzv;
    }

    @Pure
    public final zzjb zzs() {
        zzQ(this.zzs);
        return this.zzs;
    }

    @Pure
    public final zzkb zzt() {
        zzQ(this.zzy);
        return this.zzy;
    }

    @Pure
    public final zzkr zzu() {
        zzQ(this.zzo);
        return this.zzo;
    }

    @Pure
    public final zzlp zzv() {
        zzlp zzlp = this.zzp;
        if (zzlp != null) {
            return zzlp;
        }
        throw new IllegalStateException("Component not created");
    }
}
