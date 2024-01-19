package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.zav;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zal implements Creator {
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ConnectionResult connectionResult = null;
        zav zav = null;
        int i = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c2 = (char) readInt;
            if (c2 == 1) {
                i = SafeParcelReader.readInt(parcel, readInt);
            } else if (c2 == 2) {
                connectionResult = (ConnectionResult) SafeParcelReader.createParcelable(parcel, readInt, ConnectionResult.CREATOR);
            } else if (c2 != 3) {
                SafeParcelReader.skipUnknownField(parcel, readInt);
            } else {
                zav = (zav) SafeParcelReader.createParcelable(parcel, readInt, zav.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zak(i, connectionResult, zav);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zak[i];
    }
}
