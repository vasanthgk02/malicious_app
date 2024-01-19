package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.Arrays;

@KeepForSdk
@Class
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public class Feature extends AbstractSafeParcelable {
    public static final Creator<Feature> CREATOR = new zzc();
    @Field
    public final String zza;
    @Field
    @Deprecated
    public final int zzb;
    @Field
    public final long zzc;

    @Constructor
    public Feature(@Param(id = 1) String str, @Param(id = 2) int i, @Param(id = 3) long j) {
        this.zza = str;
        this.zzb = i;
        this.zzc = j;
    }

    @KeepForSdk
    public Feature(String str, long j) {
        this.zza = str;
        this.zzc = j;
        this.zzb = -1;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            String str = this.zza;
            if (((str != null && str.equals(feature.zza)) || (this.zza == null && feature.zza == null)) && getVersion() == feature.getVersion()) {
                return true;
            }
        }
        return false;
    }

    @KeepForSdk
    public long getVersion() {
        long j = this.zzc;
        return j == -1 ? (long) this.zzb : j;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, Long.valueOf(getVersion())});
    }

    public final String toString() {
        ToStringHelper toStringHelper = new ToStringHelper(this);
        toStringHelper.add("name", this.zza);
        toStringHelper.add("version", Long.valueOf(getVersion()));
        return toStringHelper.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        int i2 = this.zzb;
        parcel.writeInt(262146);
        parcel.writeInt(i2);
        long version = getVersion();
        parcel.writeInt(524291);
        parcel.writeLong(version);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
