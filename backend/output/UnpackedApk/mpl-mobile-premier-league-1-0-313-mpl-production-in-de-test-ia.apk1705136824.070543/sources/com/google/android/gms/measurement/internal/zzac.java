package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzac implements Creator {
    public final Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        String str = null;
        String str2 = null;
        zzll zzll = null;
        String str3 = null;
        zzav zzav = null;
        zzav zzav2 = null;
        zzav zzav3 = null;
        boolean z = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 2:
                    str = SafeParcelReader.createString(parcel2, readInt);
                    break;
                case 3:
                    str2 = SafeParcelReader.createString(parcel2, readInt);
                    break;
                case 4:
                    zzll = (zzll) SafeParcelReader.createParcelable(parcel2, readInt, zzll.CREATOR);
                    break;
                case 5:
                    j = SafeParcelReader.readLong(parcel2, readInt);
                    break;
                case 6:
                    z = SafeParcelReader.readBoolean(parcel2, readInt);
                    break;
                case 7:
                    str3 = SafeParcelReader.createString(parcel2, readInt);
                    break;
                case 8:
                    zzav = (zzav) SafeParcelReader.createParcelable(parcel2, readInt, zzav.CREATOR);
                    break;
                case 9:
                    j2 = SafeParcelReader.readLong(parcel2, readInt);
                    break;
                case 10:
                    zzav2 = (zzav) SafeParcelReader.createParcelable(parcel2, readInt, zzav.CREATOR);
                    break;
                case 11:
                    j3 = SafeParcelReader.readLong(parcel2, readInt);
                    break;
                case 12:
                    zzav3 = (zzav) SafeParcelReader.createParcelable(parcel2, readInt, zzav.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readInt);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        zzab zzab = new zzab(str, str2, zzll, j, z, str3, zzav, j2, zzav2, j3, zzav3);
        return zzab;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzab[i];
    }
}
