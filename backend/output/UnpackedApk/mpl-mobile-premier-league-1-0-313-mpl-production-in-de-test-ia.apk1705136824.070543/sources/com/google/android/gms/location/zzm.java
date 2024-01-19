package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzm implements Creator<ActivityTransitionEvent> {
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c2 = (char) readInt;
            if (c2 == 1) {
                i = SafeParcelReader.readInt(parcel, readInt);
            } else if (c2 == 2) {
                i2 = SafeParcelReader.readInt(parcel, readInt);
            } else if (c2 != 3) {
                SafeParcelReader.skipUnknownField(parcel, readInt);
            } else {
                j = SafeParcelReader.readLong(parcel, readInt);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new ActivityTransitionEvent(i, i2, j);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ActivityTransitionEvent[i];
    }
}