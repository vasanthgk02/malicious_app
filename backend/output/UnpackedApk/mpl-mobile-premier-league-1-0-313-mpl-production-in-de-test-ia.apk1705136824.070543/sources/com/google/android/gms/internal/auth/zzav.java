package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@Class
/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzav extends AbstractSafeParcelable {
    public static final Creator<zzav> CREATOR = new zzaw();
    @VersionField
    public final int zza;
    @Field
    public final String zzb;
    @Field
    public final int zzc;

    @Constructor
    public zzav(@Param(id = 1) int i, @Param(id = 2) String str, @Param(id = 3) int i2) {
        this.zza = 1;
        Preconditions.checkNotNull(str);
        this.zzb = str;
        this.zzc = i2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        int i2 = this.zza;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        int i3 = this.zzc;
        parcel.writeInt(262147);
        parcel.writeInt(i3);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }

    public zzav(String str, int i) {
        this(1, str, i);
    }
}
