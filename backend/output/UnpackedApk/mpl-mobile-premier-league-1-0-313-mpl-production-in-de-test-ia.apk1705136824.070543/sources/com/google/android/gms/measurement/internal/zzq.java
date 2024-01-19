package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzq implements Creator {
    public final Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = "";
        String str2 = str;
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        Boolean bool = null;
        List list = null;
        String str10 = null;
        String str11 = null;
        long j6 = -2147483648L;
        boolean z = true;
        boolean z2 = false;
        int i = 0;
        boolean z3 = true;
        boolean z4 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 2:
                    str3 = SafeParcelReader.createString(parcel2, readInt);
                    break;
                case 3:
                    str4 = SafeParcelReader.createString(parcel2, readInt);
                    break;
                case 4:
                    str5 = SafeParcelReader.createString(parcel2, readInt);
                    break;
                case 5:
                    str6 = SafeParcelReader.createString(parcel2, readInt);
                    break;
                case 6:
                    j = SafeParcelReader.readLong(parcel2, readInt);
                    break;
                case 7:
                    j2 = SafeParcelReader.readLong(parcel2, readInt);
                    break;
                case 8:
                    str7 = SafeParcelReader.createString(parcel2, readInt);
                    break;
                case 9:
                    z = SafeParcelReader.readBoolean(parcel2, readInt);
                    break;
                case 10:
                    z2 = SafeParcelReader.readBoolean(parcel2, readInt);
                    break;
                case 11:
                    j6 = SafeParcelReader.readLong(parcel2, readInt);
                    break;
                case 12:
                    str8 = SafeParcelReader.createString(parcel2, readInt);
                    break;
                case 13:
                    j3 = SafeParcelReader.readLong(parcel2, readInt);
                    break;
                case 14:
                    j4 = SafeParcelReader.readLong(parcel2, readInt);
                    break;
                case 15:
                    i = SafeParcelReader.readInt(parcel2, readInt);
                    break;
                case 16:
                    z3 = SafeParcelReader.readBoolean(parcel2, readInt);
                    break;
                case 18:
                    z4 = SafeParcelReader.readBoolean(parcel2, readInt);
                    break;
                case 19:
                    str9 = SafeParcelReader.createString(parcel2, readInt);
                    break;
                case 21:
                    int readSize = SafeParcelReader.readSize(parcel2, readInt);
                    if (readSize != 0) {
                        SafeParcelReader.zza(parcel2, readInt, readSize, 4);
                        bool = Boolean.valueOf(parcel.readInt() != 0);
                        break;
                    } else {
                        bool = null;
                        break;
                    }
                case 22:
                    j5 = SafeParcelReader.readLong(parcel2, readInt);
                    break;
                case 23:
                    list = SafeParcelReader.createStringList(parcel2, readInt);
                    break;
                case 24:
                    str10 = SafeParcelReader.createString(parcel2, readInt);
                    break;
                case 25:
                    str = SafeParcelReader.createString(parcel2, readInt);
                    break;
                case 26:
                    str2 = SafeParcelReader.createString(parcel2, readInt);
                    break;
                case 27:
                    str11 = SafeParcelReader.createString(parcel2, readInt);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readInt);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        zzp zzp = new zzp(str3, str4, str5, str6, j, j2, str7, z, z2, j6, str8, j3, j4, i, z3, z4, str9, bool, j5, list, str10, str, str2, str11);
        return zzp;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzp[i];
    }
}
