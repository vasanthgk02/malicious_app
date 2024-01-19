package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class zzp implements Creator {
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        IBinder iBinder = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c2 = (char) readInt;
            if (c2 == 1) {
                str = SafeParcelReader.createString(parcel, readInt);
            } else if (c2 == 2) {
                z = SafeParcelReader.readBoolean(parcel, readInt);
            } else if (c2 == 3) {
                z2 = SafeParcelReader.readBoolean(parcel, readInt);
            } else if (c2 == 4) {
                iBinder = SafeParcelReader.readIBinder(parcel, readInt);
            } else if (c2 != 5) {
                SafeParcelReader.skipUnknownField(parcel, readInt);
            } else {
                z3 = SafeParcelReader.readBoolean(parcel, readInt);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        zzo zzo = new zzo(str, z, z2, iBinder, z3);
        return zzo;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzo[i];
    }
}
