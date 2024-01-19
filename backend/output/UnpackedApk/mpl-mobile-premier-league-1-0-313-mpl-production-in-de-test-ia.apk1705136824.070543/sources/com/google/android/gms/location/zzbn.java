package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzbn implements Creator<LocationSettingsStates> {
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    z = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                case 2:
                    z2 = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                case 3:
                    z3 = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                case 4:
                    z4 = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                case 5:
                    z5 = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                case 6:
                    z6 = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readInt);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        LocationSettingsStates locationSettingsStates = new LocationSettingsStates(z, z2, z3, z4, z5, z6);
        return locationSettingsStates;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new LocationSettingsStates[i];
    }
}
