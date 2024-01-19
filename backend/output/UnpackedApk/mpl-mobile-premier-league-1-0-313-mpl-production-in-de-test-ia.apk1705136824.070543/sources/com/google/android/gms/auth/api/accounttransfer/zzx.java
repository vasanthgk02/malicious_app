package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzx implements Creator<DeviceMetaData> {
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j = 0;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c2 = (char) readInt;
            if (c2 == 1) {
                i = SafeParcelReader.readInt(parcel, readInt);
            } else if (c2 == 2) {
                z = SafeParcelReader.readBoolean(parcel, readInt);
            } else if (c2 == 3) {
                j = SafeParcelReader.readLong(parcel, readInt);
            } else if (c2 != 4) {
                SafeParcelReader.skipUnknownField(parcel, readInt);
            } else {
                z2 = SafeParcelReader.readBoolean(parcel, readInt);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        DeviceMetaData deviceMetaData = new DeviceMetaData(i, z, j, z2);
        return deviceMetaData;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new DeviceMetaData[i];
    }
}
