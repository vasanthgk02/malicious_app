package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzu implements Creator<zzt> {
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        zzv zzv = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c2 = (char) readInt;
            if (c2 == 1) {
                i = SafeParcelReader.readInt(parcel, readInt);
                hashSet.add(Integer.valueOf(1));
            } else if (c2 == 2) {
                zzv = (zzv) SafeParcelReader.createParcelable(parcel, readInt, zzv.CREATOR);
                hashSet.add(Integer.valueOf(2));
            } else if (c2 == 3) {
                str = SafeParcelReader.createString(parcel, readInt);
                hashSet.add(Integer.valueOf(3));
            } else if (c2 == 4) {
                str2 = SafeParcelReader.createString(parcel, readInt);
                hashSet.add(Integer.valueOf(4));
            } else if (c2 != 5) {
                SafeParcelReader.skipUnknownField(parcel, readInt);
            } else {
                str3 = SafeParcelReader.createString(parcel, readInt);
                hashSet.add(Integer.valueOf(5));
            }
        }
        if (parcel.dataPosition() == validateObjectHeader) {
            zzt zzt = new zzt(hashSet, i, zzv, str, str2, str3);
            return zzt;
        }
        throw new ParseException(GeneratedOutlineSupport.outline31(37, "Overread allowed size end=", validateObjectHeader), parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new zzt[i];
    }
}
