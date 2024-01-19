package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.Arrays;

@ShowFirstParty
@Class
/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzbo extends AbstractSafeParcelable {
    public static final Creator<zzbo> CREATOR = new zzbp();
    @Field
    public final int zza;
    @Field
    public final int zzb;
    @Field
    public final long zzc;
    @Field
    public final long zzd;

    @Constructor
    public zzbo(@Param(id = 1) int i, @Param(id = 2) int i2, @Param(id = 3) long j, @Param(id = 4) long j2) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = j;
        this.zzd = j2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzbo) {
            zzbo zzbo = (zzbo) obj;
            if (this.zza == zzbo.zza && this.zzb == zzbo.zzb && this.zzc == zzbo.zzc && this.zzd == zzbo.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzb), Integer.valueOf(this.zza), Long.valueOf(this.zzd), Long.valueOf(this.zzc)});
    }

    public final String toString() {
        StringBuilder outline77 = GeneratedOutlineSupport.outline77("NetworkLocationStatus:", " Wifi status: ");
        outline77.append(this.zza);
        outline77.append(" Cell status: ");
        outline77.append(this.zzb);
        outline77.append(" elapsed time NS: ");
        outline77.append(this.zzd);
        outline77.append(" system time ms: ");
        outline77.append(this.zzc);
        return outline77.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        int i2 = this.zza;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        int i3 = this.zzb;
        parcel.writeInt(262146);
        parcel.writeInt(i3);
        long j = this.zzc;
        parcel.writeInt(524291);
        parcel.writeLong(j);
        long j2 = this.zzd;
        parcel.writeInt(524292);
        parcel.writeLong(j2);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
