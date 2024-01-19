package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class zzq extends AbstractSafeParcelable {
    public static final Creator<zzq> CREATOR = new zzr();
    @Field
    public final boolean zza;
    @Field
    public final String zzb;
    @Field
    public final int zzc;
    @Field
    public final int zzd;

    @Constructor
    public zzq(@Param(id = 1) boolean z, @Param(id = 2) String str, @Param(id = 3) int i, @Param(id = 4) int i2) {
        this.zza = z;
        this.zzb = str;
        this.zzc = ImageOriginUtils.zza2(i) - 1;
        this.zzd = ImageOriginUtils.zza1(i2) - 1;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        boolean z = this.zza;
        parcel.writeInt(262145);
        parcel.writeInt(z ? 1 : 0);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        int i2 = this.zzc;
        parcel.writeInt(262147);
        parcel.writeInt(i2);
        int i3 = this.zzd;
        parcel.writeInt(262148);
        parcel.writeInt(i3);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
