package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class zba implements Creator {
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        Uri uri = null;
        List list = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    str = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 2:
                    str2 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 3:
                    uri = (Uri) SafeParcelReader.createParcelable(parcel, readInt, Uri.CREATOR);
                    break;
                case 4:
                    list = SafeParcelReader.createTypedList(parcel, readInt, IdToken.CREATOR);
                    break;
                case 5:
                    str3 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 6:
                    str4 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 9:
                    str5 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 10:
                    str6 = SafeParcelReader.createString(parcel, readInt);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readInt);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        Credential credential = new Credential(str, str2, uri, list, str3, str4, str5, str6);
        return credential;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new Credential[i];
    }
}
