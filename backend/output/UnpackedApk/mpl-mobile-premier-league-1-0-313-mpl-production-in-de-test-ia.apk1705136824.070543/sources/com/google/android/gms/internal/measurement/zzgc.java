package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.safetynet.zzk;
import java.util.List;
import org.apache.pdfbox.pdmodel.interactive.form.PDChoice;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzgc extends zzkc implements zzlk {
    public static final /* synthetic */ int zza = 0;
    public static final zzgc zze;
    public boolean zzA;
    public String zzB = "";
    public long zzC;
    public int zzD;
    public String zzE = "";
    public String zzF = "";
    public boolean zzG;
    public zzkj zzH = zzkc.zzbG();
    public String zzI = "";
    public int zzJ;
    public int zzK;
    public int zzL;
    public String zzM = "";
    public long zzN;
    public long zzO;
    public String zzP = "";
    public String zzQ = "";
    public int zzR;
    public String zzS = "";
    public zzgf zzT;
    public zzkh zzU = zzkc.zzbD();
    public long zzV;
    public long zzW;
    public String zzX = "";
    public String zzY = "";
    public int zzZ;
    public boolean zzaa;
    public String zzab = "";
    public boolean zzac;
    public zzfy zzad;
    public String zzae = "";
    public zzkj zzaf = zzkc.zzbG();
    public String zzag = "";
    public int zzf;
    public int zzg;
    public int zzh;
    public zzkj zzi = zzkc.zzbG();
    public zzkj zzj = zzkc.zzbG();
    public long zzk;
    public long zzl;
    public long zzm;
    public long zzn;
    public long zzo;
    public String zzp = "";
    public String zzq = "";
    public String zzr = "";
    public String zzs = "";
    public int zzt;
    public String zzu = "";
    public String zzv = "";
    public String zzw = "";
    public long zzx;
    public long zzy;
    public String zzz = "";

    static {
        zzgc zzgc = new zzgc();
        zze = zzgc;
        zzkc.zzbM(zzgc.class, zzgc);
    }

    public static /* synthetic */ void zzQ(zzgc zzgc, long j) {
        zzgc.zzf |= 1073741824;
        zzgc.zzO = j;
    }

    public static /* synthetic */ void zzR(zzgc zzgc) {
        zzgc.zzf &= Integer.MAX_VALUE;
        zzgc.zzP = zze.zzP;
    }

    public static /* synthetic */ void zzS(zzgc zzgc, int i) {
        zzgc.zzg |= 2;
        zzgc.zzR = i;
    }

    public static /* synthetic */ void zzT(zzgc zzgc, int i, zzfs zzfs) {
        zzfs.getClass();
        zzgc.zzbO();
        zzgc.zzi.set(i, zzfs);
    }

    public static /* synthetic */ void zzU(zzgc zzgc, String str) {
        str.getClass();
        zzgc.zzg |= 4;
        zzgc.zzS = str;
    }

    public static /* synthetic */ void zzV(zzgc zzgc, zzgf zzgf) {
        zzgf.getClass();
        zzgc.zzT = zzgf;
        zzgc.zzg |= 8;
    }

    public static /* synthetic */ void zzW(zzgc zzgc, Iterable iterable) {
        zzkh zzkh = zzgc.zzU;
        if (!zzkh.zzc()) {
            int size = zzkh.size();
            zzgc.zzU = zzkh.zzg(size == 0 ? 10 : size + size);
        }
        zzil.zzbw(iterable, zzgc.zzU);
    }

    public static /* synthetic */ void zzX(zzgc zzgc, zzfs zzfs) {
        zzfs.getClass();
        zzgc.zzbO();
        zzgc.zzi.add(zzfs);
    }

    public static /* synthetic */ void zzY(zzgc zzgc, long j) {
        zzgc.zzg |= 16;
        zzgc.zzV = j;
    }

    public static /* synthetic */ void zzZ(zzgc zzgc, long j) {
        zzgc.zzg |= 32;
        zzgc.zzW = j;
    }

    public static /* synthetic */ void zzaA(zzgc zzgc, String str) {
        str.getClass();
        zzgc.zzf |= 2048;
        zzgc.zzu = str;
    }

    public static /* synthetic */ void zzaB(zzgc zzgc, String str) {
        str.getClass();
        zzgc.zzf |= 4096;
        zzgc.zzv = str;
    }

    public static /* synthetic */ void zzaC(zzgc zzgc, String str) {
        str.getClass();
        zzgc.zzf |= 8192;
        zzgc.zzw = str;
    }

    public static /* synthetic */ void zzaD(zzgc zzgc, long j) {
        zzgc.zzf |= 16384;
        zzgc.zzx = j;
    }

    public static /* synthetic */ void zzaE(zzgc zzgc, long j) {
        zzgc.zzf |= 32768;
        zzgc.zzy = 61000;
    }

    public static /* synthetic */ void zzaF(zzgc zzgc, String str) {
        str.getClass();
        zzgc.zzf |= 65536;
        zzgc.zzz = str;
    }

    public static /* synthetic */ void zzaG(zzgc zzgc) {
        zzgc.zzf &= -65537;
        zzgc.zzz = zze.zzz;
    }

    public static /* synthetic */ void zzaH(zzgc zzgc, boolean z) {
        zzgc.zzf |= 131072;
        zzgc.zzA = z;
    }

    public static /* synthetic */ void zzaI(zzgc zzgc) {
        zzgc.zzf &= -131073;
        zzgc.zzA = false;
    }

    public static /* synthetic */ void zzaJ(zzgc zzgc, String str) {
        str.getClass();
        zzgc.zzf |= 262144;
        zzgc.zzB = str;
    }

    public static /* synthetic */ void zzaK(zzgc zzgc) {
        zzgc.zzf &= -262145;
        zzgc.zzB = zze.zzB;
    }

    public static /* synthetic */ void zzaL(zzgc zzgc, long j) {
        zzgc.zzf |= 524288;
        zzgc.zzC = j;
    }

    public static /* synthetic */ void zzaM(zzgc zzgc, int i) {
        zzgc.zzf |= 1048576;
        zzgc.zzD = i;
    }

    public static /* synthetic */ void zzaN(zzgc zzgc, String str) {
        zzgc.zzf |= PDChoice.FLAG_MULTI_SELECT;
        zzgc.zzE = str;
    }

    public static /* synthetic */ void zzaO(zzgc zzgc) {
        zzgc.zzf &= -2097153;
        zzgc.zzE = zze.zzE;
    }

    public static /* synthetic */ void zzaP(zzgc zzgc, String str) {
        str.getClass();
        zzgc.zzf |= 4194304;
        zzgc.zzF = str;
    }

    public static /* synthetic */ void zzaQ(zzgc zzgc, boolean z) {
        zzgc.zzf |= PDTextField.FLAG_DO_NOT_SCROLL;
        zzgc.zzG = z;
    }

    public static /* synthetic */ void zzaR(zzgc zzgc, Iterable iterable) {
        zzkj zzkj = zzgc.zzH;
        if (!zzkj.zzc()) {
            zzgc.zzH = zzkc.zzbH(zzkj);
        }
        zzil.zzbw(iterable, zzgc.zzH);
    }

    public static /* synthetic */ void zzaT(zzgc zzgc, String str) {
        str.getClass();
        zzgc.zzf |= 16777216;
        zzgc.zzI = str;
    }

    public static /* synthetic */ void zzaU(zzgc zzgc, int i) {
        zzgc.zzf |= 33554432;
        zzgc.zzJ = i;
    }

    public static /* synthetic */ void zzaV(zzgc zzgc, int i) {
        zzgc.zzf |= 1;
        zzgc.zzh = 1;
    }

    public static /* synthetic */ void zzaW(zzgc zzgc) {
        zzgc.zzf &= -268435457;
        zzgc.zzM = zze.zzM;
    }

    public static /* synthetic */ void zzaX(zzgc zzgc, long j) {
        zzgc.zzf |= 536870912;
        zzgc.zzN = j;
    }

    public static /* synthetic */ void zzaa(zzgc zzgc, String str) {
        zzgc.zzg |= 128;
        zzgc.zzY = str;
    }

    public static /* synthetic */ void zzab(zzgc zzgc, Iterable iterable) {
        zzgc.zzbO();
        zzil.zzbw(iterable, zzgc.zzi);
    }

    public static /* synthetic */ void zzac(zzgc zzgc, String str) {
        str.getClass();
        zzgc.zzg |= 8192;
        zzgc.zzae = str;
    }

    public static /* synthetic */ void zzad(zzgc zzgc) {
        zzgc.zzg &= -8193;
        zzgc.zzae = zze.zzae;
    }

    public static /* synthetic */ void zzae(zzgc zzgc, Iterable iterable) {
        zzkj zzkj = zzgc.zzaf;
        if (!zzkj.zzc()) {
            zzgc.zzaf = zzkc.zzbH(zzkj);
        }
        zzil.zzbw(iterable, zzgc.zzaf);
    }

    public static /* synthetic */ void zzag(zzgc zzgc, String str) {
        str.getClass();
        zzgc.zzg |= 16384;
        zzgc.zzag = str;
    }

    public static /* synthetic */ void zzah(zzgc zzgc, int i) {
        zzgc.zzbO();
        zzgc.zzi.remove(i);
    }

    public static /* synthetic */ void zzai(zzgc zzgc, int i, zzgl zzgl) {
        zzgl.getClass();
        zzgc.zzbP();
        zzgc.zzj.set(i, zzgl);
    }

    public static /* synthetic */ void zzaj(zzgc zzgc, zzgl zzgl) {
        zzgl.getClass();
        zzgc.zzbP();
        zzgc.zzj.add(zzgl);
    }

    public static /* synthetic */ void zzak(zzgc zzgc, Iterable iterable) {
        zzgc.zzbP();
        zzil.zzbw(iterable, zzgc.zzj);
    }

    public static /* synthetic */ void zzal(zzgc zzgc, int i) {
        zzgc.zzbP();
        zzgc.zzj.remove(i);
    }

    public static /* synthetic */ void zzam(zzgc zzgc, long j) {
        zzgc.zzf |= 2;
        zzgc.zzk = j;
    }

    public static /* synthetic */ void zzan(zzgc zzgc, long j) {
        zzgc.zzf |= 4;
        zzgc.zzl = j;
    }

    public static /* synthetic */ void zzao(zzgc zzgc, long j) {
        zzgc.zzf |= 8;
        zzgc.zzm = j;
    }

    public static /* synthetic */ void zzap(zzgc zzgc, long j) {
        zzgc.zzf |= 16;
        zzgc.zzn = j;
    }

    public static /* synthetic */ void zzaq(zzgc zzgc) {
        zzgc.zzf &= -17;
        zzgc.zzn = 0;
    }

    public static /* synthetic */ void zzar(zzgc zzgc, long j) {
        zzgc.zzf |= 32;
        zzgc.zzo = j;
    }

    public static /* synthetic */ void zzas(zzgc zzgc) {
        zzgc.zzf &= -33;
        zzgc.zzo = 0;
    }

    public static /* synthetic */ void zzat(zzgc zzgc, String str) {
        zzgc.zzf |= 64;
        zzgc.zzp = "android";
    }

    public static /* synthetic */ void zzau(zzgc zzgc, String str) {
        str.getClass();
        zzgc.zzf |= 128;
        zzgc.zzq = str;
    }

    public static /* synthetic */ void zzav(zzgc zzgc) {
        zzgc.zzf &= -129;
        zzgc.zzq = zze.zzq;
    }

    public static /* synthetic */ void zzaw(zzgc zzgc, String str) {
        str.getClass();
        zzgc.zzf |= 256;
        zzgc.zzr = str;
    }

    public static /* synthetic */ void zzax(zzgc zzgc) {
        zzgc.zzf &= -257;
        zzgc.zzr = zze.zzr;
    }

    public static /* synthetic */ void zzay(zzgc zzgc, String str) {
        str.getClass();
        zzgc.zzf |= 512;
        zzgc.zzs = str;
    }

    public static /* synthetic */ void zzaz(zzgc zzgc, int i) {
        zzgc.zzf |= 1024;
        zzgc.zzt = i;
    }

    private final void zzbO() {
        zzkj zzkj = this.zzi;
        if (!zzkj.zzc()) {
            this.zzi = zzkc.zzbH(zzkj);
        }
    }

    private final void zzbP() {
        zzkj zzkj = this.zzj;
        if (!zzkj.zzc()) {
            this.zzj = zzkc.zzbH(zzkj);
        }
    }

    public static zzgb zzu() {
        return (zzgb) zze.zzbA();
    }

    public final String zzA() {
        return this.zzu;
    }

    public final String zzB() {
        return this.zzw;
    }

    public final String zzC() {
        return this.zzY;
    }

    public final String zzD() {
        return this.zzr;
    }

    public final String zzE() {
        return this.zzP;
    }

    public final String zzF() {
        return this.zzI;
    }

    public final String zzG() {
        return this.zzF;
    }

    public final String zzH() {
        return this.zzE;
    }

    public final String zzI() {
        return this.zzq;
    }

    public final String zzJ() {
        return this.zzp;
    }

    public final String zzK() {
        return this.zzz;
    }

    public final String zzL() {
        return this.zzae;
    }

    public final String zzM() {
        return this.zzs;
    }

    public final List zzN() {
        return this.zzH;
    }

    public final List zzO() {
        return this.zzi;
    }

    public final List zzP() {
        return this.zzj;
    }

    public final int zza() {
        return this.zzJ;
    }

    public final boolean zzaY() {
        return this.zzA;
    }

    public final boolean zzaZ() {
        return this.zzG;
    }

    public final int zzb() {
        return this.zzD;
    }

    public final boolean zzba() {
        return (this.zzf & 1073741824) != 0;
    }

    public final boolean zzbb() {
        return (this.zzf & 33554432) != 0;
    }

    public final boolean zzbc() {
        return (this.zzf & 1048576) != 0;
    }

    public final boolean zzbd() {
        return (this.zzf & 536870912) != 0;
    }

    public final boolean zzbe() {
        return (this.zzg & 128) != 0;
    }

    public final boolean zzbf() {
        return (this.zzf & 524288) != 0;
    }

    public final boolean zzbg() {
        return (this.zzg & 16) != 0;
    }

    public final boolean zzbh() {
        return (this.zzf & 8) != 0;
    }

    public final boolean zzbi() {
        return (this.zzf & 16384) != 0;
    }

    public final boolean zzbj() {
        return (this.zzf & 131072) != 0;
    }

    public final boolean zzbk() {
        return (this.zzf & 32) != 0;
    }

    public final boolean zzbl() {
        return (this.zzf & 16) != 0;
    }

    public final boolean zzbm() {
        return (this.zzf & 1) != 0;
    }

    public final boolean zzbn() {
        return (this.zzg & 2) != 0;
    }

    public final boolean zzbo() {
        return (this.zzf & PDTextField.FLAG_DO_NOT_SCROLL) != 0;
    }

    public final boolean zzbp() {
        return (this.zzg & 8192) != 0;
    }

    public final boolean zzbq() {
        return (this.zzf & 4) != 0;
    }

    public final boolean zzbr() {
        return (this.zzf & 1024) != 0;
    }

    public final boolean zzbs() {
        return (this.zzf & 2) != 0;
    }

    public final boolean zzbt() {
        return (this.zzf & 32768) != 0;
    }

    public final int zzc() {
        return this.zzi.size();
    }

    public final int zzd() {
        return this.zzh;
    }

    public final int zze() {
        return this.zzR;
    }

    public final int zzf() {
        return this.zzt;
    }

    public final int zzg() {
        return this.zzj.size();
    }

    public final long zzh() {
        return this.zzO;
    }

    public final long zzi() {
        return this.zzN;
    }

    public final long zzj() {
        return this.zzC;
    }

    public final long zzk() {
        return this.zzV;
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(1);
        }
        if (i2 == 2) {
            return zzkc.zzbL(zze, "\u00014\u0000\u0002\u0001A4\u0000\u0005\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဂ\u0001\u0005ဂ\u0002\u0006ဂ\u0003\u0007ဂ\u0005\bဈ\u0006\tဈ\u0007\nဈ\b\u000bဈ\t\fင\n\rဈ\u000b\u000eဈ\f\u0010ဈ\r\u0011ဂ\u000e\u0012ဂ\u000f\u0013ဈ\u0010\u0014ဇ\u0011\u0015ဈ\u0012\u0016ဂ\u0013\u0017င\u0014\u0018ဈ\u0015\u0019ဈ\u0016\u001aဂ\u0004\u001cဇ\u0017\u001d\u001b\u001eဈ\u0018\u001fင\u0019 င\u001a!င\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဈ\u001f&ဈ 'င!)ဈ\",ဉ#-\u001d.ဂ$/ဂ%2ဈ&4ဈ'5ဌ(7ဇ)9ဈ*:ဇ+;ဉ,?ဈ-@\u001aAဈ.", new Object[]{"zzf", "zzg", "zzh", "zzi", zzfs.class, "zzj", zzgl.class, zzk.TAG, "zzl", "zzm", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzD", "zzE", "zzF", "zzn", "zzG", "zzH", zzfo.class, "zzI", "zzJ", "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", "zzQ", "zzR", "zzS", "zzT", "zzU", "zzV", "zzW", "zzX", "zzY", "zzZ", zzfk.zza, "zzaa", "zzab", "zzac", "zzad", "zzae", "zzaf", "zzag"});
        } else if (i2 == 3) {
            return new zzgc();
        } else {
            if (i2 == 4) {
                return new zzgb(null);
            }
            if (i2 != 5) {
                return null;
            }
            return zze;
        }
    }

    public final long zzm() {
        return this.zzm;
    }

    public final long zzn() {
        return this.zzx;
    }

    public final long zzo() {
        return this.zzo;
    }

    public final long zzp() {
        return this.zzn;
    }

    public final long zzq() {
        return this.zzl;
    }

    public final long zzr() {
        return this.zzk;
    }

    public final long zzs() {
        return this.zzy;
    }

    public final zzfs zzt(int i) {
        return (zzfs) this.zzi.get(i);
    }

    public final zzgl zzw(int i) {
        return (zzgl) this.zzj.get(i);
    }

    public final String zzx() {
        return this.zzS;
    }

    public final String zzy() {
        return this.zzv;
    }

    public final String zzz() {
        return this.zzB;
    }
}
