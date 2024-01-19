package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@Class
@Reserved
/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzav extends AbstractSafeParcelable {
    public static final Creator<zzav> CREATOR = new zzaw();
    @Field
    public final String zza;
    @Field
    public final zzat zzb;
    @Field
    public final String zzc;
    @Field
    public final long zzd;

    public zzav(zzav zzav, long j) {
        Preconditions.checkNotNull(zzav);
        this.zza = zzav.zza;
        this.zzb = zzav.zzb;
        this.zzc = zzav.zzc;
        this.zzd = j;
    }

    public final String toString() {
        String str = this.zzc;
        String str2 = this.zza;
        String valueOf = String.valueOf(this.zzb);
        StringBuilder outline82 = GeneratedOutlineSupport.outline82("origin=", str, ",name=", str2, ",params=");
        outline82.append(valueOf);
        return outline82.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        zzaw.zza(this, parcel, i);
    }

    @Constructor
    public zzav(@Param(id = 2) String str, @Param(id = 3) zzat zzat, @Param(id = 4) String str2, @Param(id = 5) long j) {
        this.zza = str;
        this.zzb = zzat;
        this.zzc = str2;
        this.zzd = j;
    }
}
