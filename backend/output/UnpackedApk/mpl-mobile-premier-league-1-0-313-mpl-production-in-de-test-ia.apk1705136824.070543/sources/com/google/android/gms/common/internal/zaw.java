package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zaw implements Creator {
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        IBinder iBinder = null;
        ConnectionResult connectionResult = null;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c2 = (char) readInt;
            if (c2 == 1) {
                i = SafeParcelReader.readInt(parcel, readInt);
            } else if (c2 == 2) {
                iBinder = SafeParcelReader.readIBinder(parcel, readInt);
            } else if (c2 == 3) {
                connectionResult = (ConnectionResult) SafeParcelReader.createParcelable(parcel, readInt, ConnectionResult.CREATOR);
            } else if (c2 == 4) {
                z = SafeParcelReader.readBoolean(parcel, readInt);
            } else if (c2 != 5) {
                SafeParcelReader.skipUnknownField(parcel, readInt);
            } else {
                z2 = SafeParcelReader.readBoolean(parcel, readInt);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        zav zav = new zav(i, iBinder, connectionResult, z, z2);
        return zav;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zav[i];
    }
}
