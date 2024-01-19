package com.google.android.gms.internal.auth;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzfi implements zzgc {
    public static final zzfo zza = new zzfg();
    public final zzfo zzb;

    public zzfi() {
        zzfo zzfo;
        zzfo[] zzfoArr = new zzfo[2];
        zzfoArr[0] = zzen.zza();
        try {
            zzfo = (zzfo) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            zzfo = zza;
        }
        zzfoArr[1] = zzfo;
        zzfh zzfh = new zzfh(zzfoArr);
        zzev.zzf(zzfh, "messageInfoFactory");
        this.zzb = zzfh;
    }

    public static boolean zzb(zzfn zzfn) {
        return zzfn.zzc() == 1;
    }

    public final <T> zzgb<T> zza(Class<T> cls) {
        zzft<T> zzft;
        Class<zzeq> cls2 = zzeq.class;
        zzgd.zzg(cls);
        zzfn zzb2 = this.zzb.zzb(cls);
        if (!zzb2.zzb()) {
            if (cls2.isAssignableFrom(cls)) {
                if (zzb(zzb2)) {
                    zzft = zzft.zzj(cls, zzb2, zzfw.zzb(), zzfe.zzd(), zzgd.zzc(), zzej.zzb(), zzfm.zzb());
                } else {
                    zzft = zzft.zzj(cls, zzb2, zzfw.zzb(), zzfe.zzd(), zzgd.zzc(), null, zzfm.zzb());
                }
            } else if (zzb(zzb2)) {
                zzft = zzft.zzj(cls, zzb2, zzfw.zza(), zzfe.zzc(), zzgd.zza(), zzej.zza(), zzfm.zza());
            } else {
                zzft = zzft.zzj(cls, zzb2, zzfw.zza(), zzfe.zzc(), zzgd.zzb(), null, zzfm.zza());
            }
            return zzft;
        } else if (cls2.isAssignableFrom(cls)) {
            return zzfu.zzb(zzgd.zzc(), zzej.zzb(), zzb2.zza());
        } else {
            return zzfu.zzb(zzgd.zza(), zzej.zza(), zzb2.zza());
        }
    }
}
