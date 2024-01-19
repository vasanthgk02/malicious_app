package com.google.android.gms.appset;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class
/* compiled from: com.google.android.gms:play-services-appset@@16.0.0 */
public final class zzc extends AbstractSafeParcelable {
    public static final Creator<zzc> CREATOR = new zzd();
    @Field
    public final String zza;
    @Field
    public final int zzb;

    @Constructor
    public zzc(@Param(id = 1) String str, @Param(id = 2) int i) {
        this.zza = str;
        this.zzb = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        int i2 = this.zzb;
        parcel.writeInt(262146);
        parcel.writeInt(i2);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
