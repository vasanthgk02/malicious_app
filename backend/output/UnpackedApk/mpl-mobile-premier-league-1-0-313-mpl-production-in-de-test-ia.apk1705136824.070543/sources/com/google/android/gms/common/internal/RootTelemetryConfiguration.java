package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@KeepForSdk
@Class
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public class RootTelemetryConfiguration extends AbstractSafeParcelable {
    @KeepForSdk
    public static final Creator<RootTelemetryConfiguration> CREATOR = new zzai();
    @Field
    public final int zza;
    @Field
    public final boolean zzb;
    @Field
    public final boolean zzc;
    @Field
    public final int zzd;
    @Field
    public final int zze;

    @Constructor
    public RootTelemetryConfiguration(@Param(id = 1) int i, @Param(id = 2) boolean z, @Param(id = 3) boolean z2, @Param(id = 4) int i2, @Param(id = 5) int i3) {
        this.zza = i;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = i2;
        this.zze = i3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        int i2 = this.zza;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        boolean z = this.zzb;
        parcel.writeInt(262146);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.zzc;
        parcel.writeInt(262147);
        parcel.writeInt(z2 ? 1 : 0);
        int i3 = this.zzd;
        parcel.writeInt(262148);
        parcel.writeInt(i3);
        int i4 = this.zze;
        parcel.writeInt(262149);
        parcel.writeInt(i4);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
