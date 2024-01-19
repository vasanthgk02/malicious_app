package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;

@Class
@Reserved
/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzba extends AbstractSafeParcelable {
    public static final Creator<zzba> CREATOR = new zzbb();
    public static final List<ClientIdentity> zza = Collections.emptyList();
    @Field
    public final LocationRequest zzb;
    @Field
    public final List<ClientIdentity> zzc;
    @Field
    public final String zzd;
    @Field
    public final boolean zze;
    @Field
    public final boolean zzf;
    @Field
    public final boolean zzg;
    @Field
    public final String zzh;
    @Field
    public final boolean zzi;
    @Field
    public boolean zzj;
    @Field
    public String zzk;
    @Field
    public long zzl;

    @Constructor
    public zzba(@Param(id = 1) LocationRequest locationRequest, @Param(id = 5) List<ClientIdentity> list, @Param(id = 6) String str, @Param(id = 7) boolean z, @Param(id = 8) boolean z2, @Param(id = 9) boolean z3, @Param(id = 10) String str2, @Param(id = 11) boolean z4, @Param(id = 12) boolean z5, @Param(id = 13) String str3, @Param(id = 14) long j) {
        this.zzb = locationRequest;
        this.zzc = list;
        this.zzd = str;
        this.zze = z;
        this.zzf = z2;
        this.zzg = z3;
        this.zzh = str2;
        this.zzi = z4;
        this.zzj = z5;
        this.zzk = str3;
        this.zzl = j;
    }

    public static zzba zza(String str, LocationRequest locationRequest) {
        zzba zzba = new zzba(locationRequest, zza, null, false, false, false, null, false, false, null, Long.MAX_VALUE);
        return zzba;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzba) {
            zzba zzba = (zzba) obj;
            if (Objects.equal(this.zzb, zzba.zzb) && Objects.equal(this.zzc, zzba.zzc) && Objects.equal(this.zzd, zzba.zzd) && this.zze == zzba.zze && this.zzf == zzba.zzf && this.zzg == zzba.zzg && Objects.equal(this.zzh, zzba.zzh) && this.zzi == zzba.zzi && this.zzj == zzba.zzj && Objects.equal(this.zzk, zzba.zzk)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zzb.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.zzb);
        if (this.zzd != null) {
            sb.append(" tag=");
            sb.append(this.zzd);
        }
        if (this.zzh != null) {
            sb.append(" moduleId=");
            sb.append(this.zzh);
        }
        if (this.zzk != null) {
            sb.append(" contextAttributionTag=");
            sb.append(this.zzk);
        }
        sb.append(" hideAppOps=");
        sb.append(this.zze);
        sb.append(" clients=");
        sb.append(this.zzc);
        sb.append(" forceCoarseLocation=");
        sb.append(this.zzf);
        if (this.zzg) {
            sb.append(" exemptFromBackgroundThrottle");
        }
        if (this.zzi) {
            sb.append(" locationSettingsIgnored");
        }
        if (this.zzj) {
            sb.append(" inaccurateLocationsDelayed");
        }
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzb, i, false);
        SafeParcelWriter.writeTypedList(parcel, 5, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzd, false);
        boolean z = this.zze;
        parcel.writeInt(262151);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.zzf;
        parcel.writeInt(262152);
        parcel.writeInt(z2 ? 1 : 0);
        boolean z3 = this.zzg;
        parcel.writeInt(262153);
        parcel.writeInt(z3 ? 1 : 0);
        SafeParcelWriter.writeString(parcel, 10, this.zzh, false);
        boolean z4 = this.zzi;
        parcel.writeInt(262155);
        parcel.writeInt(z4 ? 1 : 0);
        boolean z5 = this.zzj;
        parcel.writeInt(262156);
        parcel.writeInt(z5 ? 1 : 0);
        SafeParcelWriter.writeString(parcel, 13, this.zzk, false);
        long j = this.zzl;
        parcel.writeInt(524302);
        parcel.writeLong(j);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }

    public final zzba zzb(long j) {
        if (this.zzb.getMaxWaitTime() <= this.zzb.zzb) {
            this.zzl = MqttAsyncClient.DISCONNECT_TIMEOUT;
            return this;
        }
        LocationRequest locationRequest = this.zzb;
        long j2 = locationRequest.zzb;
        long maxWaitTime = locationRequest.getMaxWaitTime();
        StringBuilder sb = new StringBuilder(120);
        sb.append("could not set max age when location batching is requested, interval=");
        sb.append(j2);
        sb.append("maxWaitTime=");
        sb.append(maxWaitTime);
        throw new IllegalArgumentException(sb.toString());
    }

    public final zzba zzc(String str) {
        this.zzk = str;
        return this;
    }

    public final zzba zzd(boolean z) {
        this.zzj = true;
        return this;
    }
}
