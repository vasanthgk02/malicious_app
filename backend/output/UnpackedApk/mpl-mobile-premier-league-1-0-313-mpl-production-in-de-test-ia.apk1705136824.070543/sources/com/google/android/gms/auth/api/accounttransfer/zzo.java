package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException;
import java.util.ArrayList;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzo implements Creator<zzn> {
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        ArrayList arrayList = null;
        zzr zzr = null;
        int i2 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c2 = (char) readInt;
            if (c2 == 1) {
                i = SafeParcelReader.readInt(parcel, readInt);
                hashSet.add(Integer.valueOf(1));
            } else if (c2 == 2) {
                arrayList = SafeParcelReader.createTypedList(parcel, readInt, zzt.CREATOR);
                hashSet.add(Integer.valueOf(2));
            } else if (c2 == 3) {
                i2 = SafeParcelReader.readInt(parcel, readInt);
                hashSet.add(Integer.valueOf(3));
            } else if (c2 != 4) {
                SafeParcelReader.skipUnknownField(parcel, readInt);
            } else {
                zzr = (zzr) SafeParcelReader.createParcelable(parcel, readInt, zzr.CREATOR);
                hashSet.add(Integer.valueOf(4));
            }
        }
        if (parcel.dataPosition() == validateObjectHeader) {
            zzn zzn = new zzn(hashSet, i, arrayList, i2, zzr);
            return zzn;
        }
        throw new ParseException(GeneratedOutlineSupport.outline31(37, "Overread allowed size end=", validateObjectHeader), parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new zzn[i];
    }
}
