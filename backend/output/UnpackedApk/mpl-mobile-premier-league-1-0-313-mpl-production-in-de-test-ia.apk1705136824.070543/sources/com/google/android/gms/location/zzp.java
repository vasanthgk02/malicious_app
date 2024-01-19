package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzp implements Creator<ActivityTransitionResult> {
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ArrayList<ActivityTransitionEvent> arrayList = null;
        Bundle bundle = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c2 = (char) readInt;
            if (c2 == 1) {
                arrayList = SafeParcelReader.createTypedList(parcel, readInt, ActivityTransitionEvent.CREATOR);
            } else if (c2 != 2) {
                SafeParcelReader.skipUnknownField(parcel, readInt);
            } else {
                bundle = SafeParcelReader.createBundle(parcel, readInt);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new ActivityTransitionResult(arrayList, bundle);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ActivityTransitionResult[i];
    }
}
