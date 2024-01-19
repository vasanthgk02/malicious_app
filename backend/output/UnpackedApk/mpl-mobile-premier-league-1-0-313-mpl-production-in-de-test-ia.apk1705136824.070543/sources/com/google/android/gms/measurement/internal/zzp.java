package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.List;

@Class
@Reserved
/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzp extends AbstractSafeParcelable {
    public static final Creator<zzp> CREATOR = new zzq();
    @Field
    public final String zza;
    @Field
    public final String zzb;
    @Field
    public final String zzc;
    @Field
    public final String zzd;
    @Field
    public final long zze;
    @Field
    public final long zzf;
    @Field
    public final String zzg;
    @Field
    public final boolean zzh;
    @Field
    public final boolean zzi;
    @Field
    public final long zzj;
    @Field
    public final String zzk;
    @Field
    public final long zzl;
    @Field
    public final long zzm;
    @Field
    public final int zzn;
    @Field
    public final boolean zzo;
    @Field
    public final boolean zzp;
    @Field
    public final String zzq;
    @Field
    public final Boolean zzr;
    @Field
    public final long zzs;
    @Field
    public final List zzt;
    @Field
    public final String zzu;
    @Field
    public final String zzv;
    @Field
    public final String zzw;
    @Field
    public final String zzx;

    public zzp(String str, String str2, String str3, long j, String str4, long j2, long j3, String str5, boolean z, boolean z2, String str6, long j4, long j5, int i, boolean z3, boolean z4, String str7, Boolean bool, long j6, List list, String str8, String str9, String str10) {
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        this.zzb = true != TextUtils.isEmpty(str2) ? str2 : null;
        this.zzc = str3;
        this.zzj = j;
        this.zzd = str4;
        this.zze = j2;
        this.zzf = j3;
        this.zzg = str5;
        this.zzh = z;
        this.zzi = z2;
        this.zzk = str6;
        this.zzl = j4;
        this.zzm = j5;
        this.zzn = i;
        this.zzo = z3;
        this.zzp = z4;
        this.zzq = str7;
        this.zzr = bool;
        this.zzs = j6;
        this.zzt = list;
        this.zzu = null;
        this.zzv = str8;
        this.zzw = str9;
        this.zzx = str10;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzd, false);
        long j = this.zze;
        parcel.writeInt(524294);
        parcel.writeLong(j);
        long j2 = this.zzf;
        parcel.writeInt(524295);
        parcel.writeLong(j2);
        SafeParcelWriter.writeString(parcel, 8, this.zzg, false);
        boolean z = this.zzh;
        parcel.writeInt(262153);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.zzi;
        parcel.writeInt(262154);
        parcel.writeInt(z2 ? 1 : 0);
        long j3 = this.zzj;
        parcel.writeInt(524299);
        parcel.writeLong(j3);
        SafeParcelWriter.writeString(parcel, 12, this.zzk, false);
        long j4 = this.zzl;
        parcel.writeInt(524301);
        parcel.writeLong(j4);
        long j5 = this.zzm;
        parcel.writeInt(524302);
        parcel.writeLong(j5);
        int i2 = this.zzn;
        parcel.writeInt(262159);
        parcel.writeInt(i2);
        boolean z3 = this.zzo;
        parcel.writeInt(262160);
        parcel.writeInt(z3 ? 1 : 0);
        boolean z4 = this.zzp;
        parcel.writeInt(262162);
        parcel.writeInt(z4 ? 1 : 0);
        SafeParcelWriter.writeString(parcel, 19, this.zzq, false);
        Boolean bool = this.zzr;
        if (bool != null) {
            parcel.writeInt(262165);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        long j6 = this.zzs;
        parcel.writeInt(524310);
        parcel.writeLong(j6);
        SafeParcelWriter.writeStringList(parcel, 23, this.zzt, false);
        SafeParcelWriter.writeString(parcel, 24, this.zzu, false);
        SafeParcelWriter.writeString(parcel, 25, this.zzv, false);
        SafeParcelWriter.writeString(parcel, 26, this.zzw, false);
        SafeParcelWriter.writeString(parcel, 27, this.zzx, false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }

    @Constructor
    public zzp(@Param(id = 2) String str, @Param(id = 3) String str2, @Param(id = 4) String str3, @Param(id = 5) String str4, @Param(id = 6) long j, @Param(id = 7) long j2, @Param(id = 8) String str5, @Param(id = 9) boolean z, @Param(id = 10) boolean z2, @Param(id = 11) long j3, @Param(id = 12) String str6, @Param(id = 13) long j4, @Param(id = 14) long j5, @Param(id = 15) int i, @Param(id = 16) boolean z3, @Param(id = 18) boolean z4, @Param(id = 19) String str7, @Param(id = 21) Boolean bool, @Param(id = 22) long j6, @Param(id = 23) List list, @Param(id = 24) String str8, @Param(id = 25) String str9, @Param(id = 26) String str10, @Param(id = 27) String str11) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzj = j3;
        this.zzd = str4;
        this.zze = j;
        this.zzf = j2;
        this.zzg = str5;
        this.zzh = z;
        this.zzi = z2;
        this.zzk = str6;
        this.zzl = j4;
        this.zzm = j5;
        this.zzn = i;
        this.zzo = z3;
        this.zzp = z4;
        this.zzq = str7;
        this.zzr = bool;
        this.zzs = j6;
        this.zzt = list;
        this.zzu = str8;
        this.zzv = str9;
        this.zzw = str10;
        this.zzx = str11;
    }
}
