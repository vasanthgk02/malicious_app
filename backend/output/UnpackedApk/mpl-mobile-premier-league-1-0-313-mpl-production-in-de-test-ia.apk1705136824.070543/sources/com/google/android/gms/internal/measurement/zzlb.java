package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public final class zzlb implements zzlv {
    public static final zzlh zza = new zzkz();
    public final zzlh zzb;

    public zzlb() {
        zzlh zzlh;
        zzlh[] zzlhArr = new zzlh[2];
        zzlhArr[0] = zzjx.zza();
        try {
            zzlh = (zzlh) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            zzlh = zza;
        }
        zzlhArr[1] = zzlh;
        zzla zzla = new zzla(zzlhArr);
        zzkk.zzf(zzla, "messageInfoFactory");
        this.zzb = zzla;
    }

    public static boolean zzb(zzlg zzlg) {
        return zzlg.zzc() == 1;
    }

    public final zzlu zza(Class cls) {
        zzlm zzlm;
        Class<zzkc> cls2 = zzkc.class;
        zzlw.zzG(cls);
        zzlg zzb2 = this.zzb.zzb(cls);
        if (!zzb2.zzb()) {
            if (cls2.isAssignableFrom(cls)) {
                if (zzb(zzb2)) {
                    zzlm = zzlm.zzl(cls, zzb2, zzlp.zzb(), zzkx.zzd(), zzlw.zzB(), zzjr.zzb(), zzlf.zzb());
                } else {
                    zzlm = zzlm.zzl(cls, zzb2, zzlp.zzb(), zzkx.zzd(), zzlw.zzB(), null, zzlf.zzb());
                }
            } else if (zzb(zzb2)) {
                zzlm = zzlm.zzl(cls, zzb2, zzlp.zza(), zzkx.zzc(), zzlw.zzz(), zzjr.zza(), zzlf.zza());
            } else {
                zzlm = zzlm.zzl(cls, zzb2, zzlp.zza(), zzkx.zzc(), zzlw.zzA(), null, zzlf.zza());
            }
            return zzlm;
        } else if (cls2.isAssignableFrom(cls)) {
            return zzln.zzc(zzlw.zzB(), zzjr.zzb(), zzb2.zza());
        } else {
            return zzln.zzc(zzlw.zzz(), zzjr.zza(), zzb2.zza());
        }
    }
}
