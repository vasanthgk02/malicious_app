package com.google.android.gms.internal.common;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class zzt extends zzw {
    public final /* synthetic */ zzu zza;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzt(zzu zzu, zzx zzx, CharSequence charSequence) {
        // this.zza = zzu;
        super(zzx, charSequence);
    }

    public final int zzc(int i) {
        return i + 1;
    }

    public final int zzd(int i) {
        zzo zzo = this.zza.zza;
        CharSequence charSequence = this.zzb;
        int length = charSequence.length();
        zzs.zzb(i, length, "index");
        while (i < length) {
            if (zzo.zza(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
