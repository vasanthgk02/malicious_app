package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.util.Arrays;

@Class
/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public class AccountChangeEvent extends AbstractSafeParcelable {
    public static final Creator<AccountChangeEvent> CREATOR = new zza();
    @VersionField
    public final int zza;
    @Field
    public final long zzb;
    @Field
    public final String zzc;
    @Field
    public final int zzd;
    @Field
    public final int zze;
    @Field
    public final String zzf;

    @Constructor
    public AccountChangeEvent(@Param(id = 1) int i, @Param(id = 2) long j, @Param(id = 3) String str, @Param(id = 4) int i2, @Param(id = 5) int i3, @Param(id = 6) String str2) {
        this.zza = i;
        this.zzb = j;
        Preconditions.checkNotNull(str);
        this.zzc = str;
        this.zzd = i2;
        this.zze = i3;
        this.zzf = str2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AccountChangeEvent)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
        return this.zza == accountChangeEvent.zza && this.zzb == accountChangeEvent.zzb && Objects.equal(this.zzc, accountChangeEvent.zzc) && this.zzd == accountChangeEvent.zzd && this.zze == accountChangeEvent.zze && Objects.equal(this.zzf, accountChangeEvent.zzf);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zza), Long.valueOf(this.zzb), this.zzc, Integer.valueOf(this.zzd), Integer.valueOf(this.zze), this.zzf});
    }

    public String toString() {
        int i = this.zzd;
        String str = i != 1 ? i != 2 ? i != 3 ? i != 4 ? "UNKNOWN" : "RENAMED_TO" : "RENAMED_FROM" : "REMOVED" : "ADDED";
        String str2 = this.zzc;
        String str3 = this.zzf;
        int i2 = this.zze;
        StringBuilder sb = new StringBuilder(GeneratedOutlineSupport.outline6(String.valueOf(str2).length(), 91, str.length(), String.valueOf(str3).length()));
        GeneratedOutlineSupport.outline103(sb, "AccountChangeEvent {accountName = ", str2, ", changeType = ", str);
        sb.append(", changeData = ");
        sb.append(str3);
        sb.append(", eventIndex = ");
        sb.append(i2);
        sb.append("}");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        int i2 = this.zza;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        long j = this.zzb;
        parcel.writeInt(524290);
        parcel.writeLong(j);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        int i3 = this.zzd;
        parcel.writeInt(262148);
        parcel.writeInt(i3);
        int i4 = this.zze;
        parcel.writeInt(262149);
        parcel.writeInt(i4);
        SafeParcelWriter.writeString(parcel, 6, this.zzf, false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
