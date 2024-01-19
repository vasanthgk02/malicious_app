package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;

@Class
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class zzs extends AbstractSafeParcelable {
    public static final Creator<zzs> CREATOR = new zzt();
    @Field
    public final String zza;
    @Field
    public final zzj zzb;
    @Field
    public final boolean zzc;
    @Field
    public final boolean zzd;

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        r1 = new com.google.android.gms.common.zzk(r2);
     */
    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzs(@com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 1) java.lang.String r1, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 2) android.os.IBinder r2, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 3) boolean r3, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(id = 4) boolean r4) {
        /*
            r0 = this;
            r0.<init>()
            r0.zza = r1
            r1 = 0
            if (r2 != 0) goto L_0x0009
            goto L_0x0022
        L_0x0009:
            com.google.android.gms.common.internal.zzz r2 = com.google.android.gms.common.internal.zzy.zzg(r2)     // Catch:{ RemoteException -> 0x0022 }
            com.google.android.gms.dynamic.IObjectWrapper r2 = r2.zzd()     // Catch:{ RemoteException -> 0x0022 }
            if (r2 != 0) goto L_0x0015
            r2 = r1
            goto L_0x001b
        L_0x0015:
            java.lang.Object r2 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r2)
            byte[] r2 = (byte[]) r2
        L_0x001b:
            if (r2 == 0) goto L_0x0022
            com.google.android.gms.common.zzk r1 = new com.google.android.gms.common.zzk
            r1.<init>(r2)
        L_0x0022:
            r0.zzb = r1
            r0.zzc = r3
            r0.zzd = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.zzs.<init>(java.lang.String, android.os.IBinder, boolean, boolean):void");
    }

    public zzs(String str, zzj zzj, boolean z, boolean z2) {
        this.zza = str;
        this.zzb = zzj;
        this.zzc = z;
        this.zzd = z2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        zzj zzj = this.zzb;
        if (zzj == null) {
            zzj = null;
        }
        SafeParcelWriter.writeIBinder(parcel, 2, zzj, false);
        boolean z = this.zzc;
        parcel.writeInt(262147);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.zzd;
        parcel.writeInt(262148);
        parcel.writeInt(z2 ? 1 : 0);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
