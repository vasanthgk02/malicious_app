package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzha extends zzen {
    public final zzli zza;
    public Boolean zzb;
    public String zzc = null;

    public zzha(zzli zzli) {
        Preconditions.checkNotNull(zzli);
        this.zza = zzli;
    }

    public final String zzd(zzp zzp) {
        zzy(zzp);
        zzli zzli = this.zza;
        try {
            return (String) ((FutureTask) zzli.zzaA().zzh(new zzlb(zzli, zzp))).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            zzli.zzaz().zzd.zzc("Failed to get app instance id. appId", zzey.zzn(zzp.zza), e2);
            return null;
        }
    }

    public final List zze(zzp zzp, boolean z) {
        zzy(zzp);
        String str = zzp.zza;
        Preconditions.checkNotNull(str);
        try {
            List<zzln> list = (List) ((FutureTask) this.zza.zzaA().zzh(new zzgx(this, str))).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzln zzln : list) {
                if (z || !zzlp.zzah(zzln.zzc)) {
                    arrayList.add(new zzll(zzln));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e2) {
            this.zza.zzaz().zzd.zzc("Failed to get user properties. appId", zzey.zzn(zzp.zza), e2);
            return null;
        }
    }

    public final List zzf(String str, String str2, zzp zzp) {
        zzy(zzp);
        String str3 = zzp.zza;
        Preconditions.checkNotNull(str3);
        try {
            return (List) ((FutureTask) this.zza.zzaA().zzh(new zzgo(this, str3, str, str2))).get();
        } catch (InterruptedException | ExecutionException e2) {
            this.zza.zzaz().zzd.zzb("Failed to get conditional user properties", e2);
            return Collections.emptyList();
        }
    }

    public final List zzg(String str, String str2, String str3) {
        zzz(str, true);
        try {
            return (List) ((FutureTask) this.zza.zzaA().zzh(new zzgp(this, str, str2, str3))).get();
        } catch (InterruptedException | ExecutionException e2) {
            this.zza.zzaz().zzd.zzb("Failed to get conditional user properties as", e2);
            return Collections.emptyList();
        }
    }

    public final List zzh(String str, String str2, boolean z, zzp zzp) {
        zzy(zzp);
        String str3 = zzp.zza;
        Preconditions.checkNotNull(str3);
        try {
            List<zzln> list = (List) ((FutureTask) this.zza.zzaA().zzh(new zzgm(this, str3, str, str2))).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzln zzln : list) {
                if (z || !zzlp.zzah(zzln.zzc)) {
                    arrayList.add(new zzll(zzln));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e2) {
            this.zza.zzaz().zzd.zzc("Failed to query user properties. appId", zzey.zzn(zzp.zza), e2);
            return Collections.emptyList();
        }
    }

    public final List zzi(String str, String str2, String str3, boolean z) {
        zzz(str, true);
        try {
            List<zzln> list = (List) ((FutureTask) this.zza.zzaA().zzh(new zzgn(this, str, str2, str3))).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzln zzln : list) {
                if (z || !zzlp.zzah(zzln.zzc)) {
                    arrayList.add(new zzll(zzln));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e2) {
            this.zza.zzaz().zzd.zzc("Failed to get user properties as. appId", zzey.zzn(str), e2);
            return Collections.emptyList();
        }
    }

    public final void zzj(zzp zzp) {
        zzy(zzp);
        zzx(new zzgy(this, zzp));
    }

    public final void zzk(zzav zzav, zzp zzp) {
        Preconditions.checkNotNull(zzav);
        zzy(zzp);
        zzx(new zzgt(this, zzav, zzp));
    }

    public final void zzl(zzav zzav, String str, String str2) {
        Preconditions.checkNotNull(zzav);
        Preconditions.checkNotEmpty(str);
        zzz(str, true);
        zzx(new zzgu(this, zzav, str));
    }

    public final void zzm(zzp zzp) {
        Preconditions.checkNotEmpty(zzp.zza);
        zzz(zzp.zza, false);
        zzx(new zzgq(this, zzp));
    }

    public final void zzn(zzab zzab, zzp zzp) {
        Preconditions.checkNotNull(zzab);
        Preconditions.checkNotNull(zzab.zzc);
        zzy(zzp);
        zzab zzab2 = new zzab(zzab);
        zzab2.zza = zzp.zza;
        zzx(new zzgk(this, zzab2, zzp));
    }

    public final void zzo(zzab zzab) {
        Preconditions.checkNotNull(zzab);
        Preconditions.checkNotNull(zzab.zzc);
        Preconditions.checkNotEmpty(zzab.zza);
        zzz(zzab.zza, true);
        zzx(new zzgl(this, new zzab(zzab)));
    }

    public final void zzp(zzp zzp) {
        Preconditions.checkNotEmpty(zzp.zza);
        Preconditions.checkNotNull(zzp.zzv);
        zzgs zzgs = new zzgs(this, zzp);
        Preconditions.checkNotNull(zzgs);
        if (this.zza.zzaA().zzs()) {
            zzgs.run();
        } else {
            this.zza.zzaA().zzq(zzgs);
        }
    }

    public final void zzq(long j, String str, String str2, String str3) {
        zzgz zzgz = new zzgz(this, str2, str3, str, j);
        zzx(zzgz);
    }

    public final void zzr(Bundle bundle, zzp zzp) {
        zzy(zzp);
        String str = zzp.zza;
        Preconditions.checkNotNull(str);
        zzx(new zzgj(this, str, bundle));
    }

    public final void zzs(zzp zzp) {
        zzy(zzp);
        zzx(new zzgr(this, zzp));
    }

    public final void zzt(zzll zzll, zzp zzp) {
        Preconditions.checkNotNull(zzll);
        zzy(zzp);
        zzx(new zzgw(this, zzll, zzp));
    }

    public final byte[] zzu(zzav zzav, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzav);
        zzz(str, true);
        this.zza.zzaz().zzk.zzb("Log and bundle. event", this.zza.zzn.zzq.zzd(zzav.zza));
        long nanoTime = this.zza.zzaw().nanoTime() / 1000000;
        zzgf zzaA = this.zza.zzaA();
        zzgv zzgv = new zzgv(this, zzav, str);
        zzaA.zzu();
        Preconditions.checkNotNull(zzgv);
        zzgd zzgd = new zzgd(zzaA, zzgv, true);
        if (Thread.currentThread() == zzaA.zzb) {
            zzgd.run();
        } else {
            zzaA.zzt(zzgd);
        }
        try {
            byte[] bArr = (byte[]) zzgd.get();
            if (bArr == null) {
                this.zza.zzaz().zzd.zzb("Log and bundle returned null. appId", zzey.zzn(str));
                bArr = new byte[0];
            }
            this.zza.zzaz().zzk.zzd("Log and bundle processed. event, size, time_ms", this.zza.zzn.zzq.zzd(zzav.zza), Integer.valueOf(bArr.length), Long.valueOf((this.zza.zzaw().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e2) {
            this.zza.zzaz().zzd.zzd("Failed to log and bundle. appId, event, error", zzey.zzn(str), this.zza.zzn.zzq.zzd(zzav.zza), e2);
            return null;
        }
    }

    @VisibleForTesting
    public final void zzx(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        if (this.zza.zzaA().zzs()) {
            runnable.run();
        } else {
            this.zza.zzaA().zzp(runnable);
        }
    }

    public final void zzy(zzp zzp) {
        Preconditions.checkNotNull(zzp);
        Preconditions.checkNotEmpty(zzp.zza);
        zzz(zzp.zza, false);
        this.zza.zzv().zzX(zzp.zzb, zzp.zzq);
    }

    public final void zzz(String str, boolean z) {
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                try {
                    if (this.zzb == null) {
                        if (!"com.google.android.gms".equals(this.zzc) && !UidVerifier.isGooglePlayServicesUid(this.zza.zzn.zze, Binder.getCallingUid())) {
                            if (!GoogleSignatureVerifier.getInstance(this.zza.zzn.zze).isUidGoogleSigned(Binder.getCallingUid())) {
                                z2 = false;
                                this.zzb = Boolean.valueOf(z2);
                            }
                        }
                        z2 = true;
                        this.zzb = Boolean.valueOf(z2);
                    }
                    if (this.zzb.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e2) {
                    this.zza.zzaz().zzd.zzb("Measurement Service called with invalid calling package. appId", zzey.zzn(str));
                    throw e2;
                }
            }
            if (this.zzc == null && GooglePlayServicesUtilLight.uidHasPackageName(this.zza.zzn.zze, Binder.getCallingUid(), str)) {
                this.zzc = str;
            }
            if (!str.equals(this.zzc)) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
            }
            return;
        }
        this.zza.zzaz().zzd.zza("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }
}
