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
public class ConnectionTelemetryConfiguration extends AbstractSafeParcelable {
    @KeepForSdk
    public static final Creator<ConnectionTelemetryConfiguration> CREATOR = new zzl();
    @Field
    public final RootTelemetryConfiguration zza;
    @Field
    public final boolean zzb;
    @Field
    public final boolean zzc;
    @Field
    public final int[] zzd;
    @Field
    public final int zze;
    @Field
    public final int[] zzf;

    @Constructor
    public ConnectionTelemetryConfiguration(@Param(id = 1) RootTelemetryConfiguration rootTelemetryConfiguration, @Param(id = 2) boolean z, @Param(id = 3) boolean z2, @Param(id = 4) int[] iArr, @Param(id = 5) int i, @Param(id = 6) int[] iArr2) {
        this.zza = rootTelemetryConfiguration;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = iArr;
        this.zze = i;
        this.zzf = iArr2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        boolean z = this.zzb;
        parcel.writeInt(262146);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.zzc;
        parcel.writeInt(262147);
        parcel.writeInt(z2 ? 1 : 0);
        SafeParcelWriter.writeIntArray(parcel, 4, this.zzd, false);
        int i2 = this.zze;
        parcel.writeInt(262149);
        parcel.writeInt(i2);
        SafeParcelWriter.writeIntArray(parcel, 6, this.zzf, false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
