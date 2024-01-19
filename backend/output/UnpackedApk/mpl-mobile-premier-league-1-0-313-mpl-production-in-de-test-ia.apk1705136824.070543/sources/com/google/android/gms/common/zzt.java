package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class zzt implements Creator {
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        boolean z = false;
        String str = null;
        IBinder iBinder = null;
        boolean z2 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c2 = (char) readInt;
            if (c2 == 1) {
                str = SafeParcelReader.createString(parcel, readInt);
            } else if (c2 == 2) {
                iBinder = SafeParcelReader.readIBinder(parcel, readInt);
            } else if (c2 == 3) {
                z = SafeParcelReader.readBoolean(parcel, readInt);
            } else if (c2 != 4) {
                SafeParcelReader.skipUnknownField(parcel, readInt);
            } else {
                z2 = SafeParcelReader.readBoolean(parcel, readInt);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzs(str, iBinder, z, z2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzs[i];
    }
}
