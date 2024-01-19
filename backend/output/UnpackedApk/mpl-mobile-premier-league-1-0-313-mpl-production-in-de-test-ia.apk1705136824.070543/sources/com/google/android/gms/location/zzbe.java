package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzbe implements Creator<LocationAvailability> {
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j = 0;
        zzbo[] zzboArr = null;
        int i = 1000;
        int i2 = 1;
        int i3 = 1;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c2 = (char) readInt;
            if (c2 == 1) {
                i2 = SafeParcelReader.readInt(parcel, readInt);
            } else if (c2 == 2) {
                i3 = SafeParcelReader.readInt(parcel, readInt);
            } else if (c2 == 3) {
                j = SafeParcelReader.readLong(parcel, readInt);
            } else if (c2 == 4) {
                i = SafeParcelReader.readInt(parcel, readInt);
            } else if (c2 != 5) {
                SafeParcelReader.skipUnknownField(parcel, readInt);
            } else {
                zzboArr = (zzbo[]) SafeParcelReader.createTypedArray(parcel, readInt, zzbo.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        LocationAvailability locationAvailability = new LocationAvailability(i, i2, i3, j, zzboArr);
        return locationAvailability;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new LocationAvailability[i];
    }
}
