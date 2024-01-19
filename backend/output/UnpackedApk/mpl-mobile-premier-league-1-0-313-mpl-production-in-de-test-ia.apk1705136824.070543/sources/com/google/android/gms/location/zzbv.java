package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzbv implements Creator<SleepSegmentEvent> {
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j = 0;
        long j2 = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c2 = (char) readInt;
            if (c2 == 1) {
                j = SafeParcelReader.readLong(parcel, readInt);
            } else if (c2 == 2) {
                j2 = SafeParcelReader.readLong(parcel, readInt);
            } else if (c2 == 3) {
                i = SafeParcelReader.readInt(parcel, readInt);
            } else if (c2 == 4) {
                i2 = SafeParcelReader.readInt(parcel, readInt);
            } else if (c2 != 5) {
                SafeParcelReader.skipUnknownField(parcel, readInt);
            } else {
                i3 = SafeParcelReader.readInt(parcel, readInt);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        SleepSegmentEvent sleepSegmentEvent = new SleepSegmentEvent(j, j2, i, i2, i3);
        return sleepSegmentEvent;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new SleepSegmentEvent[i];
    }
}
