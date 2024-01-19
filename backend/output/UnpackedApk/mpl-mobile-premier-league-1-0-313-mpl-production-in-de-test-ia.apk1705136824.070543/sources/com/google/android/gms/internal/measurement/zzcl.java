package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class
/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public final class zzcl extends AbstractSafeParcelable {
    public static final Creator<zzcl> CREATOR = new zzcm();
    @Field
    public final long zza;
    @Field
    public final long zzb;
    @Field
    public final boolean zzc;
    @Field
    public final String zzd;
    @Field
    public final String zze;
    @Field
    public final String zzf;
    @Field
    public final Bundle zzg;
    @Field
    public final String zzh;

    @Constructor
    public zzcl(@Param(id = 1) long j, @Param(id = 2) long j2, @Param(id = 3) boolean z, @Param(id = 4) String str, @Param(id = 5) String str2, @Param(id = 6) String str3, @Param(id = 7) Bundle bundle, @Param(id = 8) String str4) {
        this.zza = j;
        this.zzb = j2;
        this.zzc = z;
        this.zzd = str;
        this.zze = str2;
        this.zzf = str3;
        this.zzg = bundle;
        this.zzh = str4;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        long j = this.zza;
        parcel.writeInt(524289);
        parcel.writeLong(j);
        long j2 = this.zzb;
        parcel.writeInt(524290);
        parcel.writeLong(j2);
        boolean z = this.zzc;
        parcel.writeInt(262147);
        parcel.writeInt(z ? 1 : 0);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.zzg, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzh, false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
