package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@Class
/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public class DeviceMetaData extends AbstractSafeParcelable {
    public static final Creator<DeviceMetaData> CREATOR = new zzx();
    @VersionField
    public final int zza;
    @Field
    public boolean zzb;
    @Field
    public long zzc;
    @Field
    public final boolean zzd;

    @Constructor
    public DeviceMetaData(@Param(id = 1) int i, @Param(id = 2) boolean z, @Param(id = 3) long j, @Param(id = 4) boolean z2) {
        this.zza = i;
        this.zzb = z;
        this.zzc = j;
        this.zzd = z2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        int i2 = this.zza;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        boolean z = this.zzb;
        parcel.writeInt(262146);
        parcel.writeInt(z ? 1 : 0);
        long j = this.zzc;
        parcel.writeInt(524291);
        parcel.writeLong(j);
        boolean z2 = this.zzd;
        parcel.writeInt(262148);
        parcel.writeInt(z2 ? 1 : 0);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
