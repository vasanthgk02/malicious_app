package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zza implements Creator<AccountChangeEvent> {
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        long j = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 2:
                    j = SafeParcelReader.readLong(parcel, readInt);
                    break;
                case 3:
                    str = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 4:
                    i2 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 5:
                    i3 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 6:
                    str2 = SafeParcelReader.createString(parcel, readInt);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readInt);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        AccountChangeEvent accountChangeEvent = new AccountChangeEvent(i, j, str, i2, i3, str2);
        return accountChangeEvent;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new AccountChangeEvent[i];
    }
}
