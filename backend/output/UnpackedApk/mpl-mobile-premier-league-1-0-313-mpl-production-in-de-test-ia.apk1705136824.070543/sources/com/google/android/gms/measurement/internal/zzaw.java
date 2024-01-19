package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzaw implements Creator {
    public static void zza(zzav zzav, Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, zzav.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 3, zzav.zzb, i, false);
        SafeParcelWriter.writeString(parcel, 4, zzav.zzc, false);
        long j = zzav.zzd;
        parcel.writeInt(524293);
        parcel.writeLong(j);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }

    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        zzat zzat = null;
        String str2 = null;
        long j = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c2 = (char) readInt;
            if (c2 == 2) {
                str = SafeParcelReader.createString(parcel, readInt);
            } else if (c2 == 3) {
                zzat = (zzat) SafeParcelReader.createParcelable(parcel, readInt, zzat.CREATOR);
            } else if (c2 == 4) {
                str2 = SafeParcelReader.createString(parcel, readInt);
            } else if (c2 != 5) {
                SafeParcelReader.skipUnknownField(parcel, readInt);
            } else {
                j = SafeParcelReader.readLong(parcel, readInt);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        zzav zzav = new zzav(str, zzat, str2, j);
        return zzav;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzav[i];
    }
}
