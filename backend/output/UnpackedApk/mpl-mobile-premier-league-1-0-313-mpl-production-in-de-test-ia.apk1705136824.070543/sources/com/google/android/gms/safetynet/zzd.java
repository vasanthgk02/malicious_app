package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@Class
@Reserved
public final class zzd extends AbstractSafeParcelable {
    public static final Creator<zzd> CREATOR = new zze();
    @Field
    public final long zzf;
    @Field
    public final HarmfulAppsData[] zzg;
    @Field
    public final int zzh;
    @Field
    public final boolean zzi;

    @Constructor
    public zzd(@Param(id = 2) long j, @Param(id = 3) HarmfulAppsData[] harmfulAppsDataArr, @Param(id = 4) int i, @Param(id = 5) boolean z) {
        this.zzf = j;
        this.zzg = harmfulAppsDataArr;
        this.zzi = z;
        if (z) {
            this.zzh = i;
        } else {
            this.zzh = -1;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        long j = this.zzf;
        parcel.writeInt(524290);
        parcel.writeLong(j);
        SafeParcelWriter.writeTypedArray(parcel, 3, this.zzg, i, false);
        int i2 = this.zzh;
        parcel.writeInt(262148);
        parcel.writeInt(i2);
        boolean z = this.zzi;
        parcel.writeInt(262149);
        parcel.writeInt(z ? 1 : 0);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
