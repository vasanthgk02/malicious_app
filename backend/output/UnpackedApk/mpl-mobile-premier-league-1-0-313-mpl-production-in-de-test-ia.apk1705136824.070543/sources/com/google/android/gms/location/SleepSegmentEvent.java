package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
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
public class SleepSegmentEvent extends AbstractSafeParcelable {
    public static final Creator<SleepSegmentEvent> CREATOR = new zzbv();
    @Field
    public final long zza;
    @Field
    public final long zzb;
    @Field
    public final int zzc;
    @Field
    public final int zzd;
    @Field
    public final int zze;

    @ShowFirstParty
    @Constructor
    public SleepSegmentEvent(@Param(id = 1) long j, @Param(id = 2) long j2, @Param(id = 3) int i, @Param(id = 4) int i2, @Param(id = 5) int i3) {
        Preconditions.checkArgument(j <= j2, "endTimeMillis must be greater than or equal to startTimeMillis");
        this.zza = j;
        this.zzb = j2;
        this.zzc = i;
        this.zzd = i2;
        this.zze = i3;
    }

    public boolean equals(Object obj) {
        if (obj instanceof SleepSegmentEvent) {
            SleepSegmentEvent sleepSegmentEvent = (SleepSegmentEvent) obj;
            if (this.zza == sleepSegmentEvent.zza && this.zzb == sleepSegmentEvent.zzb && this.zzc == sleepSegmentEvent.zzc && this.zzd == sleepSegmentEvent.zzd && this.zze == sleepSegmentEvent.zze) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.zza), Long.valueOf(this.zzb), Integer.valueOf(this.zzc)});
    }

    public String toString() {
        long j = this.zza;
        long j2 = this.zzb;
        int i = this.zzc;
        StringBuilder sb = new StringBuilder(84);
        sb.append("startMillis=");
        sb.append(j);
        sb.append(", endMillis=");
        sb.append(j2);
        sb.append(", status=");
        sb.append(i);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Preconditions.checkNotNull(parcel);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        long j = this.zza;
        parcel.writeInt(524289);
        parcel.writeLong(j);
        long j2 = this.zzb;
        parcel.writeInt(524290);
        parcel.writeLong(j2);
        int i2 = this.zzc;
        parcel.writeInt(262147);
        parcel.writeInt(i2);
        int i3 = this.zzd;
        parcel.writeInt(262148);
        parcel.writeInt(i3);
        int i4 = this.zze;
        parcel.writeInt(262149);
        parcel.writeInt(i4);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
