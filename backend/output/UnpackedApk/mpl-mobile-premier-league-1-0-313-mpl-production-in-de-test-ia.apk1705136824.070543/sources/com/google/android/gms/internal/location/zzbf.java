package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzbf implements Creator<zzbe> {
    public final Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        double d2 = 0.0d;
        double d3 = 0.0d;
        String str = null;
        long j = 0;
        int i = 0;
        short s = 0;
        float f2 = 0.0f;
        int i2 = 0;
        int i3 = -1;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    str = SafeParcelReader.createString(parcel2, readInt);
                    break;
                case 2:
                    j = SafeParcelReader.readLong(parcel2, readInt);
                    break;
                case 3:
                    SafeParcelReader.zzb(parcel2, readInt, 4);
                    s = (short) parcel.readInt();
                    break;
                case 4:
                    d2 = SafeParcelReader.readDouble(parcel2, readInt);
                    break;
                case 5:
                    d3 = SafeParcelReader.readDouble(parcel2, readInt);
                    break;
                case 6:
                    f2 = SafeParcelReader.readFloat(parcel2, readInt);
                    break;
                case 7:
                    i = SafeParcelReader.readInt(parcel2, readInt);
                    break;
                case 8:
                    i2 = SafeParcelReader.readInt(parcel2, readInt);
                    break;
                case 9:
                    i3 = SafeParcelReader.readInt(parcel2, readInt);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readInt);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        zzbe zzbe = new zzbe(str, i, s, d2, d3, f2, j, i2, i3);
        return zzbe;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new zzbe[i];
    }
}
