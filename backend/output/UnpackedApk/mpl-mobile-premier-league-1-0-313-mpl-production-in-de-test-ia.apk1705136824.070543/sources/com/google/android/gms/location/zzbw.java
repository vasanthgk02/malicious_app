package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzbw implements Creator<SleepSegmentRequest> {
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ArrayList<zzbx> arrayList = null;
        int i = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c2 = (char) readInt;
            if (c2 == 1) {
                arrayList = SafeParcelReader.createTypedList(parcel, readInt, zzbx.CREATOR);
            } else if (c2 != 2) {
                SafeParcelReader.skipUnknownField(parcel, readInt);
            } else {
                i = SafeParcelReader.readInt(parcel, readInt);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new SleepSegmentRequest(arrayList, i);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new SleepSegmentRequest[i];
    }
}
