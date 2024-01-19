package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzm implements Creator<TokenData> {
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        Long l = null;
        List list = null;
        String str2 = null;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 2:
                    str = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 3:
                    l = SafeParcelReader.readLongObject(parcel, readInt);
                    break;
                case 4:
                    z = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                case 5:
                    z2 = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                case 6:
                    list = SafeParcelReader.createStringList(parcel, readInt);
                    break;
                case 7:
                    str2 = SafeParcelReader.createString(parcel, readInt);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readInt);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        TokenData tokenData = new TokenData(i, str, l, z, z2, list, str2);
        return tokenData;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new TokenData[i];
    }
}
