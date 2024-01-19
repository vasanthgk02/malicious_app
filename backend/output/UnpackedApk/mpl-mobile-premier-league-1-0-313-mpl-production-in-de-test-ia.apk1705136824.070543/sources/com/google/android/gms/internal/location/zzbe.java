package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

@Class
@Reserved
@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzbe extends AbstractSafeParcelable implements Geofence {
    public static final Creator<zzbe> CREATOR = new zzbf();
    @Field
    public final String zza;
    @Field
    public final long zzb;
    @Field
    public final short zzc;
    @Field
    public final double zzd;
    @Field
    public final double zze;
    @Field
    public final float zzf;
    @Field
    public final int zzg;
    @Field
    public final int zzh;
    @Field
    public final int zzi;

    @Constructor
    public zzbe(@Param(id = 1) String str, @Param(id = 7) int i, @Param(id = 3) short s, @Param(id = 4) double d2, @Param(id = 5) double d3, @Param(id = 6) float f2, @Param(id = 2) long j, @Param(id = 8) int i2, @Param(id = 9) int i3) {
        String str2;
        if (str == null || str.length() > 100) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2 = "requestId is null or too long: ".concat(valueOf);
            } else {
                str2 = new String("requestId is null or too long: ");
            }
            throw new IllegalArgumentException(str2);
        } else if (f2 <= 0.0f) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("invalid radius: ");
            sb.append(f2);
            throw new IllegalArgumentException(sb.toString());
        } else if (d2 > 90.0d || d2 < -90.0d) {
            StringBuilder sb2 = new StringBuilder(42);
            sb2.append("invalid latitude: ");
            sb2.append(d2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (d3 > 180.0d || d3 < -180.0d) {
            StringBuilder sb3 = new StringBuilder(43);
            sb3.append("invalid longitude: ");
            sb3.append(d3);
            throw new IllegalArgumentException(sb3.toString());
        } else {
            int i4 = i & 7;
            if (i4 != 0) {
                this.zzc = s;
                this.zza = str;
                this.zzd = d2;
                this.zze = d3;
                this.zzf = f2;
                this.zzb = j;
                this.zzg = i4;
                this.zzh = i2;
                this.zzi = i3;
                return;
            }
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline31(46, "No supported transition specified: ", i));
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzbe) {
            zzbe zzbe = (zzbe) obj;
            return this.zzf == zzbe.zzf && this.zzd == zzbe.zzd && this.zze == zzbe.zze && this.zzc == zzbe.zzc;
        }
    }

    public final String getRequestId() {
        return this.zza;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.zzd);
        long doubleToLongBits2 = Double.doubleToLongBits(this.zze);
        return ((((Float.floatToIntBits(this.zzf) + ((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31)) * 31) + this.zzc) * 31) + this.zzg;
    }

    public final String toString() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[9];
        short s = this.zzc;
        objArr[0] = s != -1 ? s != 1 ? "UNKNOWN" : "CIRCLE" : "INVALID";
        objArr[1] = this.zza.replaceAll("\\p{C}", ColorPropConverter.PREFIX_ATTR);
        objArr[2] = Integer.valueOf(this.zzg);
        objArr[3] = Double.valueOf(this.zzd);
        objArr[4] = Double.valueOf(this.zze);
        objArr[5] = Float.valueOf(this.zzf);
        objArr[6] = Integer.valueOf(this.zzh / 1000);
        objArr[7] = Integer.valueOf(this.zzi);
        objArr[8] = Long.valueOf(this.zzb);
        return String.format(locale, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", objArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        long j = this.zzb;
        parcel.writeInt(524290);
        parcel.writeLong(j);
        short s = this.zzc;
        parcel.writeInt(262147);
        parcel.writeInt(s);
        double d2 = this.zzd;
        parcel.writeInt(524292);
        parcel.writeDouble(d2);
        double d3 = this.zze;
        parcel.writeInt(524293);
        parcel.writeDouble(d3);
        float f2 = this.zzf;
        parcel.writeInt(262150);
        parcel.writeFloat(f2);
        int i2 = this.zzg;
        parcel.writeInt(262151);
        parcel.writeInt(i2);
        int i3 = this.zzh;
        parcel.writeInt(262152);
        parcel.writeInt(i3);
        int i4 = this.zzi;
        parcel.writeInt(262153);
        parcel.writeInt(i4);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }
}
