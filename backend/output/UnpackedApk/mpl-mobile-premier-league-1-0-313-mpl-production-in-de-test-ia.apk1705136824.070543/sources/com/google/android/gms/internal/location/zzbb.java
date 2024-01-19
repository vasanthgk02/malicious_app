package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzbb implements Creator<zzba> {
    public final Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        List<ClientIdentity> list = zzba.zza;
        LocationRequest locationRequest = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        long j = Long.MAX_VALUE;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c2 = (char) readInt;
            if (c2 != 1) {
                switch (c2) {
                    case 5:
                        list = SafeParcelReader.createTypedList(parcel2, readInt, ClientIdentity.CREATOR);
                        break;
                    case 6:
                        str = SafeParcelReader.createString(parcel2, readInt);
                        break;
                    case 7:
                        z = SafeParcelReader.readBoolean(parcel2, readInt);
                        break;
                    case 8:
                        z2 = SafeParcelReader.readBoolean(parcel2, readInt);
                        break;
                    case 9:
                        z3 = SafeParcelReader.readBoolean(parcel2, readInt);
                        break;
                    case 10:
                        str2 = SafeParcelReader.createString(parcel2, readInt);
                        break;
                    case 11:
                        z4 = SafeParcelReader.readBoolean(parcel2, readInt);
                        break;
                    case 12:
                        z5 = SafeParcelReader.readBoolean(parcel2, readInt);
                        break;
                    case 13:
                        str3 = SafeParcelReader.createString(parcel2, readInt);
                        break;
                    case 14:
                        j = SafeParcelReader.readLong(parcel2, readInt);
                        break;
                    default:
                        SafeParcelReader.skipUnknownField(parcel2, readInt);
                        break;
                }
            } else {
                locationRequest = (LocationRequest) SafeParcelReader.createParcelable(parcel2, readInt, LocationRequest.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        zzba zzba = new zzba(locationRequest, list, str, z, z2, z3, str2, z4, z5, str3, j);
        return zzba;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new zzba[i];
    }
}
