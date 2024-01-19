package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzbf implements Creator<LocationRequest> {
    public final Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j = 3600000;
        long j2 = 600000;
        long j3 = Long.MAX_VALUE;
        long j4 = 0;
        int i = 102;
        boolean z = false;
        int i2 = Integer.MAX_VALUE;
        float f2 = 0.0f;
        boolean z2 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    i = SafeParcelReader.readInt(parcel2, readInt);
                    break;
                case 2:
                    j = SafeParcelReader.readLong(parcel2, readInt);
                    break;
                case 3:
                    j2 = SafeParcelReader.readLong(parcel2, readInt);
                    break;
                case 4:
                    z = SafeParcelReader.readBoolean(parcel2, readInt);
                    break;
                case 5:
                    j3 = SafeParcelReader.readLong(parcel2, readInt);
                    break;
                case 6:
                    i2 = SafeParcelReader.readInt(parcel2, readInt);
                    break;
                case 7:
                    f2 = SafeParcelReader.readFloat(parcel2, readInt);
                    break;
                case 8:
                    j4 = SafeParcelReader.readLong(parcel2, readInt);
                    break;
                case 9:
                    z2 = SafeParcelReader.readBoolean(parcel2, readInt);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readInt);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        LocationRequest locationRequest = new LocationRequest(i, j, j2, z, j3, i2, f2, j4, z2);
        return locationRequest;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new LocationRequest[i];
    }
}
