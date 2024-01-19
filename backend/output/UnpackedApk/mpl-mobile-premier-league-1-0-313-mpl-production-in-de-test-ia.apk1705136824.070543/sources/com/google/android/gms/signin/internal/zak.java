package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.internal.zav;

@Class
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zak extends AbstractSafeParcelable {
    public static final Creator<zak> CREATOR = new zal();
    @VersionField
    public final int zaa;
    @Field
    public final ConnectionResult zab;
    @Field
    public final zav zac;

    @Constructor
    public zak(@Param(id = 1) int i, @Param(id = 2) ConnectionResult connectionResult, @Param(id = 3) zav zav) {
        this.zaa = i;
        this.zab = connectionResult;
        this.zac = zav;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        int i2 = this.zaa;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zab, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zac, i, false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
