package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzs implements Creator<zzr> {
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        List list = null;
        List list2 = null;
        List list3 = null;
        List list4 = null;
        List list5 = null;
        int i = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 2:
                    list = SafeParcelReader.createStringList(parcel, readInt);
                    break;
                case 3:
                    list2 = SafeParcelReader.createStringList(parcel, readInt);
                    break;
                case 4:
                    list3 = SafeParcelReader.createStringList(parcel, readInt);
                    break;
                case 5:
                    list4 = SafeParcelReader.createStringList(parcel, readInt);
                    break;
                case 6:
                    list5 = SafeParcelReader.createStringList(parcel, readInt);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readInt);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        zzr zzr = new zzr(i, list, list2, list3, list4, list5);
        return zzr;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new zzr[i];
    }
}
