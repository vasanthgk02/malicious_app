package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class
/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzab extends AbstractSafeParcelable {
    public static final Creator<zzab> CREATOR = new zzac();
    @Field
    public String zza;
    @Field
    public String zzb;
    @Field
    public zzll zzc;
    @Field
    public long zzd;
    @Field
    public boolean zze;
    @Field
    public String zzf;
    @Field
    public final zzav zzg;
    @Field
    public long zzh;
    @Field
    public zzav zzi;
    @Field
    public final long zzj;
    @Field
    public final zzav zzk;

    public zzab(zzab zzab) {
        Preconditions.checkNotNull(zzab);
        this.zza = zzab.zza;
        this.zzb = zzab.zzb;
        this.zzc = zzab.zzc;
        this.zzd = zzab.zzd;
        this.zze = zzab.zze;
        this.zzf = zzab.zzf;
        this.zzg = zzab.zzg;
        this.zzh = zzab.zzh;
        this.zzi = zzab.zzi;
        this.zzj = zzab.zzj;
        this.zzk = zzab.zzk;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzc, i, false);
        long j = this.zzd;
        parcel.writeInt(524293);
        parcel.writeLong(j);
        boolean z = this.zze;
        parcel.writeInt(262150);
        parcel.writeInt(z ? 1 : 0);
        SafeParcelWriter.writeString(parcel, 7, this.zzf, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzg, i, false);
        long j2 = this.zzh;
        parcel.writeInt(524297);
        parcel.writeLong(j2);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzi, i, false);
        long j3 = this.zzj;
        parcel.writeInt(524299);
        parcel.writeLong(j3);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzk, i, false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }

    @Constructor
    public zzab(@Param(id = 2) String str, @Param(id = 3) String str2, @Param(id = 4) zzll zzll, @Param(id = 5) long j, @Param(id = 6) boolean z, @Param(id = 7) String str3, @Param(id = 8) zzav zzav, @Param(id = 9) long j2, @Param(id = 10) zzav zzav2, @Param(id = 11) long j3, @Param(id = 12) zzav zzav3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzll;
        this.zzd = j;
        this.zze = z;
        this.zzf = str3;
        this.zzg = zzav;
        this.zzh = j2;
        this.zzi = zzav2;
        this.zzj = j3;
        this.zzk = zzav3;
    }
}
