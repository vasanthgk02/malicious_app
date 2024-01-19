package com.google.android.gms.location;

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
/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class LocationSettingsStates extends AbstractSafeParcelable {
    public static final Creator<LocationSettingsStates> CREATOR = new zzbn();
    @Field
    public final boolean zza;
    @Field
    public final boolean zzb;
    @Field
    public final boolean zzc;
    @Field
    public final boolean zzd;
    @Field
    public final boolean zze;
    @Field
    public final boolean zzf;

    @Constructor
    public LocationSettingsStates(@Param(id = 1) boolean z, @Param(id = 2) boolean z2, @Param(id = 3) boolean z3, @Param(id = 4) boolean z4, @Param(id = 5) boolean z5, @Param(id = 6) boolean z6) {
        this.zza = z;
        this.zzb = z2;
        this.zzc = z3;
        this.zzd = z4;
        this.zze = z5;
        this.zzf = z6;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        boolean z = this.zza;
        parcel.writeInt(262145);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.zzb;
        parcel.writeInt(262146);
        parcel.writeInt(z2 ? 1 : 0);
        boolean z3 = this.zzc;
        parcel.writeInt(262147);
        parcel.writeInt(z3 ? 1 : 0);
        boolean z4 = this.zzd;
        parcel.writeInt(262148);
        parcel.writeInt(z4 ? 1 : 0);
        boolean z5 = this.zze;
        parcel.writeInt(262149);
        parcel.writeInt(z5 ? 1 : 0);
        boolean z6 = this.zzf;
        parcel.writeInt(262150);
        parcel.writeInt(z6 ? 1 : 0);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
