package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzk implements Creator<ActivityRecognitionResult> {
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j = 0;
        long j2 = 0;
        List list = null;
        Bundle bundle = null;
        int i = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c2 = (char) readInt;
            if (c2 == 1) {
                list = SafeParcelReader.createTypedList(parcel, readInt, DetectedActivity.CREATOR);
            } else if (c2 == 2) {
                j = SafeParcelReader.readLong(parcel, readInt);
            } else if (c2 == 3) {
                j2 = SafeParcelReader.readLong(parcel, readInt);
            } else if (c2 == 4) {
                i = SafeParcelReader.readInt(parcel, readInt);
            } else if (c2 != 5) {
                SafeParcelReader.skipUnknownField(parcel, readInt);
            } else {
                bundle = SafeParcelReader.createBundle(parcel, readInt);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        ActivityRecognitionResult activityRecognitionResult = new ActivityRecognitionResult(list, j, j2, i, bundle);
        return activityRecognitionResult;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ActivityRecognitionResult[i];
    }
}
