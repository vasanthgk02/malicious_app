package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zze implements Creator<zzd> {
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j = 0;
        HarmfulAppsData[] harmfulAppsDataArr = null;
        int i = 0;
        boolean z = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c2 = (char) readInt;
            if (c2 == 2) {
                j = SafeParcelReader.readLong(parcel, readInt);
            } else if (c2 == 3) {
                harmfulAppsDataArr = (HarmfulAppsData[]) SafeParcelReader.createTypedArray(parcel, readInt, HarmfulAppsData.CREATOR);
            } else if (c2 == 4) {
                i = SafeParcelReader.readInt(parcel, readInt);
            } else if (c2 != 5) {
                SafeParcelReader.skipUnknownField(parcel, readInt);
            } else {
                z = SafeParcelReader.readBoolean(parcel, readInt);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        zzd zzd = new zzd(j, harmfulAppsDataArr, i, z);
        return zzd;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzd[i];
    }
}
