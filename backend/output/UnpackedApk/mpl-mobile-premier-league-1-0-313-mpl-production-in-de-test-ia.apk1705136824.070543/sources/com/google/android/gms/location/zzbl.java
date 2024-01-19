package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzbl implements Creator<LocationSettingsRequest> {
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        boolean z = false;
        List list = null;
        zzbj zzbj = null;
        boolean z2 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c2 = (char) readInt;
            if (c2 == 1) {
                list = SafeParcelReader.createTypedList(parcel, readInt, LocationRequest.CREATOR);
            } else if (c2 == 2) {
                z = SafeParcelReader.readBoolean(parcel, readInt);
            } else if (c2 == 3) {
                z2 = SafeParcelReader.readBoolean(parcel, readInt);
            } else if (c2 != 5) {
                SafeParcelReader.skipUnknownField(parcel, readInt);
            } else {
                zzbj = (zzbj) SafeParcelReader.createParcelable(parcel, readInt, zzbj.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new LocationSettingsRequest(list, z, z2, zzbj);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new LocationSettingsRequest[i];
    }
}
