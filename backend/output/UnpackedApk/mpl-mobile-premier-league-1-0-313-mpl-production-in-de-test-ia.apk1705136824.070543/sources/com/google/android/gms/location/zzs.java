package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
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
public final class zzs extends AbstractSafeParcelable {
    public static final Creator<zzs> CREATOR = new zzt();
    @Field
    public boolean zza;
    @Field
    public long zzb;
    @Field
    public float zzc;
    @Field
    public long zzd;
    @Field
    public int zze;

    public zzs() {
        this.zza = true;
        this.zzb = 50;
        this.zzc = 0.0f;
        this.zzd = Long.MAX_VALUE;
        this.zze = Integer.MAX_VALUE;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzs)) {
            return false;
        }
        zzs zzs = (zzs) obj;
        return this.zza == zzs.zza && this.zzb == zzs.zzb && Float.compare(this.zzc, zzs.zzc) == 0 && this.zzd == zzs.zzd && this.zze == zzs.zze;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.zza), Long.valueOf(this.zzb), Float.valueOf(this.zzc), Long.valueOf(this.zzd), Integer.valueOf(this.zze)});
    }

    public final String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("DeviceOrientationRequest[mShouldUseMag=");
        outline73.append(this.zza);
        outline73.append(" mMinimumSamplingPeriodMs=");
        outline73.append(this.zzb);
        outline73.append(" mSmallestAngleChangeRadians=");
        outline73.append(this.zzc);
        long j = this.zzd;
        if (j != Long.MAX_VALUE) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            outline73.append(" expireIn=");
            outline73.append(j - elapsedRealtime);
            outline73.append("ms");
        }
        if (this.zze != Integer.MAX_VALUE) {
            outline73.append(" num=");
            outline73.append(this.zze);
        }
        outline73.append(']');
        return outline73.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        boolean z = this.zza;
        parcel.writeInt(262145);
        parcel.writeInt(z ? 1 : 0);
        long j = this.zzb;
        parcel.writeInt(524290);
        parcel.writeLong(j);
        float f2 = this.zzc;
        parcel.writeInt(262147);
        parcel.writeFloat(f2);
        long j2 = this.zzd;
        parcel.writeInt(524292);
        parcel.writeLong(j2);
        int i2 = this.zze;
        parcel.writeInt(262149);
        parcel.writeInt(i2);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }

    @Constructor
    public zzs(@Param(id = 1) boolean z, @Param(id = 2) long j, @Param(id = 3) float f2, @Param(id = 4) long j2, @Param(id = 5) int i) {
        this.zza = z;
        this.zzb = j;
        this.zzc = f2;
        this.zzd = j2;
        this.zze = i;
    }
}
