package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.Arrays;

@Class
@Reserved
/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class LocationRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<LocationRequest> CREATOR = new zzbf();
    @Field
    public int zza;
    @Field
    public long zzb;
    @Field
    public long zzc;
    @Field
    public boolean zzd;
    @Field
    public long zze;
    @Field
    public int zzf;
    @Field
    public float zzg;
    @Field
    public long zzh;
    @Field
    public boolean zzi;

    @Deprecated
    public LocationRequest() {
        this.zza = 102;
        this.zzb = 3600000;
        this.zzc = 600000;
        this.zzd = false;
        this.zze = Long.MAX_VALUE;
        this.zzf = Integer.MAX_VALUE;
        this.zzg = 0.0f;
        this.zzh = 0;
        this.zzi = false;
    }

    public static LocationRequest create() {
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.zzi = true;
        return locationRequest;
    }

    public static void zza(long j) {
        if (j < 0) {
            StringBuilder sb = new StringBuilder(38);
            sb.append("invalid interval: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof LocationRequest) {
            LocationRequest locationRequest = (LocationRequest) obj;
            if (this.zza == locationRequest.zza && this.zzb == locationRequest.zzb && this.zzc == locationRequest.zzc && this.zzd == locationRequest.zzd && this.zze == locationRequest.zze && this.zzf == locationRequest.zzf && this.zzg == locationRequest.zzg && getMaxWaitTime() == locationRequest.getMaxWaitTime() && this.zzi == locationRequest.zzi) {
                return true;
            }
        }
        return false;
    }

    public long getMaxWaitTime() {
        long j = this.zzh;
        long j2 = this.zzb;
        return j < j2 ? j2 : j;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zza), Long.valueOf(this.zzb), Float.valueOf(this.zzg), Long.valueOf(this.zzh)});
    }

    public LocationRequest setFastestInterval(long j) {
        zza(j);
        this.zzd = true;
        this.zzc = j;
        return this;
    }

    public LocationRequest setInterval(long j) {
        zza(j);
        this.zzb = j;
        if (!this.zzd) {
            this.zzc = (long) (((double) j) / 6.0d);
        }
        return this;
    }

    public LocationRequest setPriority(int i) {
        if (i == 100 || i == 102 || i == 104 || i == 105) {
            this.zza = i;
            return this;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline31(28, "invalid quality: ", i));
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Request[");
        int i = this.zza;
        outline73.append(i != 100 ? i != 102 ? i != 104 ? i != 105 ? "???" : "PRIORITY_NO_POWER" : "PRIORITY_LOW_POWER" : "PRIORITY_BALANCED_POWER_ACCURACY" : "PRIORITY_HIGH_ACCURACY");
        if (this.zza != 105) {
            outline73.append(" requested=");
            outline73.append(this.zzb);
            outline73.append("ms");
        }
        outline73.append(" fastest=");
        outline73.append(this.zzc);
        outline73.append("ms");
        if (this.zzh > this.zzb) {
            outline73.append(" maxWait=");
            outline73.append(this.zzh);
            outline73.append("ms");
        }
        if (this.zzg > 0.0f) {
            outline73.append(" smallestDisplacement=");
            outline73.append(this.zzg);
            outline73.append("m");
        }
        long j = this.zze;
        if (j != Long.MAX_VALUE) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            outline73.append(" expireIn=");
            outline73.append(j - elapsedRealtime);
            outline73.append("ms");
        }
        if (this.zzf != Integer.MAX_VALUE) {
            outline73.append(" num=");
            outline73.append(this.zzf);
        }
        outline73.append(']');
        return outline73.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        int i2 = this.zza;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        long j = this.zzb;
        parcel.writeInt(524290);
        parcel.writeLong(j);
        long j2 = this.zzc;
        parcel.writeInt(524291);
        parcel.writeLong(j2);
        boolean z = this.zzd;
        parcel.writeInt(262148);
        parcel.writeInt(z ? 1 : 0);
        long j3 = this.zze;
        parcel.writeInt(524293);
        parcel.writeLong(j3);
        int i3 = this.zzf;
        parcel.writeInt(262150);
        parcel.writeInt(i3);
        float f2 = this.zzg;
        parcel.writeInt(262151);
        parcel.writeFloat(f2);
        long j4 = this.zzh;
        parcel.writeInt(524296);
        parcel.writeLong(j4);
        boolean z2 = this.zzi;
        parcel.writeInt(262153);
        parcel.writeInt(z2 ? 1 : 0);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }

    @Constructor
    public LocationRequest(@Param(id = 1) int i, @Param(id = 2) long j, @Param(id = 3) long j2, @Param(id = 4) boolean z, @Param(id = 5) long j3, @Param(id = 6) int i2, @Param(id = 7) float f2, @Param(id = 8) long j4, @Param(id = 9) boolean z2) {
        this.zza = i;
        this.zzb = j;
        this.zzc = j2;
        this.zzd = z;
        this.zze = j3;
        this.zzf = i2;
        this.zzg = f2;
        this.zzh = j4;
        this.zzi = z2;
    }
}
