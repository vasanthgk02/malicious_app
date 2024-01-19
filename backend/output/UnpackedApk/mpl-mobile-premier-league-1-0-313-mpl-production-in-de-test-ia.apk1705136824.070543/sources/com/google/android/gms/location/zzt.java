package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzt implements Creator<zzs> {
    public final Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j = 50;
        long j2 = Long.MAX_VALUE;
        boolean z = true;
        float f2 = 0.0f;
        int i = Integer.MAX_VALUE;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c2 = (char) readInt;
            if (c2 == 1) {
                z = SafeParcelReader.readBoolean(parcel2, readInt);
            } else if (c2 == 2) {
                j = SafeParcelReader.readLong(parcel2, readInt);
            } else if (c2 == 3) {
                f2 = SafeParcelReader.readFloat(parcel2, readInt);
            } else if (c2 == 4) {
                j2 = SafeParcelReader.readLong(parcel2, readInt);
            } else if (c2 != 5) {
                SafeParcelReader.skipUnknownField(parcel2, readInt);
            } else {
                i = SafeParcelReader.readInt(parcel2, readInt);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        zzs zzs = new zzs(z, j, f2, j2, i);
        return zzs;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new zzs[i];
    }
}
