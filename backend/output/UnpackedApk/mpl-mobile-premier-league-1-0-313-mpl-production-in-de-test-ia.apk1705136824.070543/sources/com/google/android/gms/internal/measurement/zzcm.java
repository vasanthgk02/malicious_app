package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public final class zzcm implements Creator {
    public final Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j = 0;
        long j2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        Bundle bundle = null;
        String str4 = null;
        boolean z = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    j = SafeParcelReader.readLong(parcel2, readInt);
                    break;
                case 2:
                    j2 = SafeParcelReader.readLong(parcel2, readInt);
                    break;
                case 3:
                    z = SafeParcelReader.readBoolean(parcel2, readInt);
                    break;
                case 4:
                    str = SafeParcelReader.createString(parcel2, readInt);
                    break;
                case 5:
                    str2 = SafeParcelReader.createString(parcel2, readInt);
                    break;
                case 6:
                    str3 = SafeParcelReader.createString(parcel2, readInt);
                    break;
                case 7:
                    bundle = SafeParcelReader.createBundle(parcel2, readInt);
                    break;
                case 8:
                    str4 = SafeParcelReader.createString(parcel2, readInt);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readInt);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        zzcl zzcl = new zzcl(j, j2, z, str, str2, str3, bundle, str4);
        return zzcl;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzcl[i];
    }
}
