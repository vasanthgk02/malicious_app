package com.google.android.gms.auth.api.identity;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class zbl implements Creator {
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            if (((char) readInt) != 1) {
                SafeParcelReader.skipUnknownField(parcel, readInt);
            } else {
                pendingIntent = (PendingIntent) SafeParcelReader.createParcelable(parcel, readInt, PendingIntent.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new SavePasswordResult(pendingIntent);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new SavePasswordResult[i];
    }
}
