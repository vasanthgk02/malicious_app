package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zan implements Creator {
    public final Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        long j = 0;
        long j2 = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = -1;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    i = SafeParcelReader.readInt(parcel2, readInt);
                    break;
                case 2:
                    i2 = SafeParcelReader.readInt(parcel2, readInt);
                    break;
                case 3:
                    i3 = SafeParcelReader.readInt(parcel2, readInt);
                    break;
                case 4:
                    j = SafeParcelReader.readLong(parcel2, readInt);
                    break;
                case 5:
                    j2 = SafeParcelReader.readLong(parcel2, readInt);
                    break;
                case 6:
                    str = SafeParcelReader.createString(parcel2, readInt);
                    break;
                case 7:
                    str2 = SafeParcelReader.createString(parcel2, readInt);
                    break;
                case 8:
                    i4 = SafeParcelReader.readInt(parcel2, readInt);
                    break;
                case 9:
                    i5 = SafeParcelReader.readInt(parcel2, readInt);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readInt);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        MethodInvocation methodInvocation = new MethodInvocation(i, i2, i3, j, j2, str, str2, i4, i5);
        return methodInvocation;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new MethodInvocation[i];
    }
}
