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
import java.util.Arrays;

@Class
/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public class SleepClassifyEvent extends AbstractSafeParcelable {
    public static final Creator<SleepClassifyEvent> CREATOR = new zzbu();
    @Field
    public final int zza;
    @Field
    public final int zzb;
    @Field
    public final int zzc;
    @Field
    public final int zzd;
    @Field
    public final int zze;
    @Field
    public final int zzf;
    @Field
    public final int zzg;
    @Field
    public final boolean zzh;
    @Field
    public final int zzi;

    @ShowFirstParty
    @Constructor
    public SleepClassifyEvent(@Param(id = 1) int i, @Param(id = 2) int i2, @Param(id = 3) int i3, @Param(id = 4) int i4, @Param(id = 5) int i5, @Param(id = 6) int i6, @Param(id = 7) int i7, @Param(id = 8) boolean z, @Param(id = 9) int i8) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = i5;
        this.zzf = i6;
        this.zzg = i7;
        this.zzh = z;
        this.zzi = i8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SleepClassifyEvent)) {
            return false;
        }
        SleepClassifyEvent sleepClassifyEvent = (SleepClassifyEvent) obj;
        return this.zza == sleepClassifyEvent.zza && this.zzb == sleepClassifyEvent.zzb;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zza), Integer.valueOf(this.zzb)});
    }

    public String toString() {
        int i = this.zza;
        int i2 = this.zzb;
        int i3 = this.zzc;
        int i4 = this.zzd;
        StringBuilder sb = new StringBuilder(65);
        sb.append(i);
        sb.append(" Conf:");
        sb.append(i2);
        sb.append(" Motion:");
        sb.append(i3);
        sb.append(" Light:");
        sb.append(i4);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Preconditions.checkNotNull(parcel);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        int i2 = this.zza;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        int i3 = this.zzb;
        parcel.writeInt(262146);
        parcel.writeInt(i3);
        int i4 = this.zzc;
        parcel.writeInt(262147);
        parcel.writeInt(i4);
        int i5 = this.zzd;
        parcel.writeInt(262148);
        parcel.writeInt(i5);
        int i6 = this.zze;
        parcel.writeInt(262149);
        parcel.writeInt(i6);
        int i7 = this.zzf;
        parcel.writeInt(262150);
        parcel.writeInt(i7);
        int i8 = this.zzg;
        parcel.writeInt(262151);
        parcel.writeInt(i8);
        boolean z = this.zzh;
        parcel.writeInt(262152);
        parcel.writeInt(z ? 1 : 0);
        int i9 = this.zzi;
        parcel.writeInt(262153);
        parcel.writeInt(i9);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
