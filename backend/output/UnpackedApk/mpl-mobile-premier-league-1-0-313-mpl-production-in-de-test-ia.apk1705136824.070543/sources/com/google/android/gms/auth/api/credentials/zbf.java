package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class zbf implements Creator {
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c2 = (char) readInt;
            if (c2 == 1) {
                str = SafeParcelReader.createString(parcel, readInt);
            } else if (c2 != 2) {
                SafeParcelReader.skipUnknownField(parcel, readInt);
            } else {
                str2 = SafeParcelReader.createString(parcel, readInt);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new IdToken(str, str2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new IdToken[i];
    }
}