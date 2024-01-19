package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.util.List;

@KeepForSdk
@Class
@Deprecated
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class WakeLockEvent extends StatsEvent {
    public static final Creator<WakeLockEvent> CREATOR = new zza();
    @VersionField
    public final int zza;
    @Field
    public final long zzb;
    @Field
    public int zzc;
    @Field
    public final String zzd;
    @Field
    public final String zze;
    @Field
    public final String zzf;
    @Field
    public final int zzg;
    @Field
    public final List zzh;
    @Field
    public final String zzi;
    @Field
    public final long zzj;
    @Field
    public int zzk;
    @Field
    public final String zzl;
    @Field
    public final float zzm;
    @Field
    public final long zzn;
    @Field
    public final boolean zzo;
    public long zzp = -1;

    @Constructor
    public WakeLockEvent(@Param(id = 1) int i, @Param(id = 2) long j, @Param(id = 11) int i2, @Param(id = 4) String str, @Param(id = 5) int i3, @Param(id = 6) List list, @Param(id = 12) String str2, @Param(id = 8) long j2, @Param(id = 14) int i4, @Param(id = 10) String str3, @Param(id = 13) String str4, @Param(id = 15) float f2, @Param(id = 16) long j3, @Param(id = 17) String str5, @Param(id = 18) boolean z) {
        this.zza = i;
        this.zzb = j;
        this.zzc = i2;
        this.zzd = str;
        this.zze = str3;
        this.zzf = str5;
        this.zzg = i3;
        this.zzh = list;
        this.zzi = str2;
        this.zzj = j2;
        this.zzk = i4;
        this.zzl = str4;
        this.zzm = f2;
        this.zzn = j3;
        this.zzo = z;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        int i2 = this.zza;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        long j = this.zzb;
        parcel.writeInt(524290);
        parcel.writeLong(j);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        int i3 = this.zzg;
        parcel.writeInt(262149);
        parcel.writeInt(i3);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzh, false);
        long j2 = this.zzj;
        parcel.writeInt(524296);
        parcel.writeLong(j2);
        SafeParcelWriter.writeString(parcel, 10, this.zze, false);
        int i4 = this.zzc;
        parcel.writeInt(262155);
        parcel.writeInt(i4);
        SafeParcelWriter.writeString(parcel, 12, this.zzi, false);
        SafeParcelWriter.writeString(parcel, 13, this.zzl, false);
        int i5 = this.zzk;
        parcel.writeInt(262158);
        parcel.writeInt(i5);
        float f2 = this.zzm;
        parcel.writeInt(262159);
        parcel.writeFloat(f2);
        long j3 = this.zzn;
        parcel.writeInt(524304);
        parcel.writeLong(j3);
        SafeParcelWriter.writeString(parcel, 17, this.zzf, false);
        boolean z = this.zzo;
        parcel.writeInt(262162);
        parcel.writeInt(z ? 1 : 0);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
