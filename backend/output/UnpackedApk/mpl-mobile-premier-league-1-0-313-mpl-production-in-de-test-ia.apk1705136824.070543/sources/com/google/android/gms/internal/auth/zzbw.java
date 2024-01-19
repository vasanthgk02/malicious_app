package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@ShowFirstParty
@Class
/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzbw extends AbstractSafeParcelable {
    public static final Creator<zzbw> CREATOR = new zzbx();
    @VersionField
    public final int zza;
    @Field
    public String zzb;

    public zzbw() {
        this.zza = 1;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        int i2 = this.zza;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }

    public final zzbw zza(String str) {
        this.zzb = str;
        return this;
    }

    @Constructor
    public zzbw(@Param(id = 1) int i, @Param(id = 2) String str) {
        this.zza = i;
        this.zzb = str;
    }
}
