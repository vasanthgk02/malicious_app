package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.location.zzbe;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzau implements Creator<GeofencingRequest> {
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ArrayList<zzbe> arrayList = null;
        String str = "";
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c2 = (char) readInt;
            if (c2 == 1) {
                arrayList = SafeParcelReader.createTypedList(parcel, readInt, zzbe.CREATOR);
            } else if (c2 == 2) {
                i = SafeParcelReader.readInt(parcel, readInt);
            } else if (c2 == 3) {
                str = SafeParcelReader.createString(parcel, readInt);
            } else if (c2 != 4) {
                SafeParcelReader.skipUnknownField(parcel, readInt);
            } else {
                str2 = SafeParcelReader.createString(parcel, readInt);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new GeofencingRequest(arrayList, i, str, str2);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new GeofencingRequest[i];
    }
}
