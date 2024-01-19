package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zaj implements Creator {
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        zaa zaa = null;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        int i4 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 2:
                    i2 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 3:
                    z = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                case 4:
                    i3 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 5:
                    z2 = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                case 6:
                    str = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 7:
                    i4 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 8:
                    str2 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 9:
                    zaa = (zaa) SafeParcelReader.createParcelable(parcel, readInt, zaa.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readInt);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        Field field = new Field(i, i2, z, i3, z2, str, i4, str2, zaa);
        return field;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new Field[i];
    }
}
