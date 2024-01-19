package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzg {
    public long zzA;
    public long zzB;
    public String zzC;
    public boolean zzD;
    public long zzE;
    public long zzF;
    public final zzgi zza;
    public final String zzb;
    public String zzc;
    public String zzd;
    public String zze;
    public String zzf;
    public long zzg;
    public long zzh;
    public long zzi;
    public String zzj;
    public long zzk;
    public String zzl;
    public long zzm;
    public long zzn;
    public boolean zzo;
    public long zzp;
    public boolean zzq;
    public String zzr;
    public Boolean zzs;
    public long zzt;
    public List zzu;
    public String zzv;
    public long zzw;
    public long zzx;
    public long zzy;
    public long zzz;

    public zzg(zzgi zzgi, String str) {
        Preconditions.checkNotNull(zzgi);
        Preconditions.checkNotEmpty(str);
        this.zza = zzgi;
        this.zzb = str;
        zzgi.zzaA().zzg();
    }

    public final List zzC() {
        this.zza.zzaA().zzg();
        return this.zzu;
    }

    public final void zzE() {
        this.zza.zzaA().zzg();
        long j = this.zzg + 1;
        if (j > 2147483647L) {
            this.zza.zzaz().zzg.zzb("Bundle index overflow. appId", zzey.zzn(this.zzb));
            j = 0;
        }
        this.zzD = true;
        this.zzg = j;
    }

    public final void zzF(String str) {
        this.zza.zzaA().zzg();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzD |= true ^ zzlp.zzal(this.zzr, str);
        this.zzr = str;
    }

    public final void zzG(boolean z) {
        this.zza.zzaA().zzg();
        this.zzD |= this.zzq != z;
        this.zzq = z;
    }

    public final void zzH(long j) {
        this.zza.zzaA().zzg();
        this.zzD |= this.zzp != j;
        this.zzp = j;
    }

    public final void zzI(String str) {
        this.zza.zzaA().zzg();
        this.zzD |= !zzlp.zzal(this.zzc, str);
        this.zzc = str;
    }

    public final void zzJ(String str) {
        this.zza.zzaA().zzg();
        this.zzD |= !zzlp.zzal(this.zzl, str);
        this.zzl = str;
    }

    public final void zzK(String str) {
        this.zza.zzaA().zzg();
        this.zzD |= !zzlp.zzal(this.zzj, str);
        this.zzj = str;
    }

    public final void zzL(long j) {
        this.zza.zzaA().zzg();
        this.zzD |= this.zzk != j;
        this.zzk = j;
    }

    public final void zzM(long j) {
        this.zza.zzaA().zzg();
        this.zzD |= this.zzE != j;
        this.zzE = j;
    }

    public final void zzT(long j) {
        this.zza.zzaA().zzg();
        this.zzD |= this.zzn != j;
        this.zzn = j;
    }

    public final void zzU(long j) {
        this.zza.zzaA().zzg();
        this.zzD |= this.zzt != j;
        this.zzt = j;
    }

    public final void zzV(long j) {
        this.zza.zzaA().zzg();
        this.zzD |= this.zzF != j;
        this.zzF = j;
    }

    public final void zzW(String str) {
        this.zza.zzaA().zzg();
        this.zzD |= !zzlp.zzal(this.zzf, str);
        this.zzf = str;
    }

    public final void zzX(String str) {
        this.zza.zzaA().zzg();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzD |= true ^ zzlp.zzal(this.zzd, str);
        this.zzd = str;
    }

    public final void zzY(long j) {
        this.zza.zzaA().zzg();
        this.zzD |= this.zzm != j;
        this.zzm = j;
    }

    public final void zzZ(String str) {
        this.zza.zzaA().zzg();
        this.zzD |= !zzlp.zzal(this.zzC, str);
        this.zzC = str;
    }

    public final long zza() {
        this.zza.zzaA().zzg();
        return this.zzp;
    }

    public final void zzaa(long j) {
        this.zza.zzaA().zzg();
        this.zzD |= this.zzi != j;
        this.zzi = j;
    }

    public final void zzab(long j) {
        boolean z = true;
        Preconditions.checkArgument(j >= 0);
        this.zza.zzaA().zzg();
        boolean z2 = this.zzD;
        if (this.zzg == j) {
            z = false;
        }
        this.zzD = z | z2;
        this.zzg = j;
    }

    public final void zzac(long j) {
        this.zza.zzaA().zzg();
        this.zzD |= this.zzh != j;
        this.zzh = j;
    }

    public final void zzad(boolean z) {
        this.zza.zzaA().zzg();
        this.zzD |= this.zzo != z;
        this.zzo = z;
    }

    public final void zzaf(String str) {
        this.zza.zzaA().zzg();
        this.zzD |= !zzlp.zzal(this.zze, str);
        this.zze = str;
    }

    public final void zzag(List list) {
        this.zza.zzaA().zzg();
        List list2 = this.zzu;
        if (!(list2 == null && list == null) && (list2 == null || !list2.equals(list))) {
            this.zzD = true;
            this.zzu = list != null ? new ArrayList(list) : null;
        }
    }

    public final void zzah(String str) {
        this.zza.zzaA().zzg();
        this.zzD |= !zzlp.zzal(this.zzv, str);
        this.zzv = str;
    }

    public final boolean zzai() {
        this.zza.zzaA().zzg();
        return this.zzq;
    }

    public final boolean zzaj() {
        this.zza.zzaA().zzg();
        return this.zzo;
    }

    public final long zzb() {
        this.zza.zzaA().zzg();
        return this.zzk;
    }

    public final long zzc() {
        this.zza.zzaA().zzg();
        return this.zzE;
    }

    public final long zzj() {
        this.zza.zzaA().zzg();
        return this.zzn;
    }

    public final long zzk() {
        this.zza.zzaA().zzg();
        return this.zzt;
    }

    public final long zzl() {
        this.zza.zzaA().zzg();
        return this.zzF;
    }

    public final long zzm() {
        this.zza.zzaA().zzg();
        return this.zzm;
    }

    public final long zzn() {
        this.zza.zzaA().zzg();
        return this.zzi;
    }

    public final long zzo() {
        this.zza.zzaA().zzg();
        return this.zzg;
    }

    public final long zzp() {
        this.zza.zzaA().zzg();
        return this.zzh;
    }

    public final String zzr() {
        this.zza.zzaA().zzg();
        return this.zzr;
    }

    public final String zzs() {
        this.zza.zzaA().zzg();
        String str = this.zzC;
        zzZ(null);
        return str;
    }

    public final String zzt() {
        this.zza.zzaA().zzg();
        return this.zzb;
    }

    public final String zzu() {
        this.zza.zzaA().zzg();
        return this.zzc;
    }

    public final String zzv() {
        this.zza.zzaA().zzg();
        return this.zzl;
    }

    public final String zzw() {
        this.zza.zzaA().zzg();
        return this.zzj;
    }

    public final String zzx() {
        this.zza.zzaA().zzg();
        return this.zzf;
    }

    public final String zzy() {
        this.zza.zzaA().zzg();
        return this.zzd;
    }
}
