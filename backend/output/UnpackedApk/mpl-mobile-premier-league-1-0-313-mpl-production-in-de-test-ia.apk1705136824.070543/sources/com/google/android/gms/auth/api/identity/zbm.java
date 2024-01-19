package com.google.android.gms.auth.api.identity;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class zbm implements Creator {
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
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
                    str3 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 4:
                    str4 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 5:
                    uri = (Uri) SafeParcelReader.createParcelable(parcel, readInt, Uri.CREATOR);
                    break;
                case 6:
                    str5 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 7:
                    str6 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 8:
                    str7 = SafeParcelReader.createString(parcel, readInt);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readInt);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        SignInCredential signInCredential = new SignInCredential(str, str2, str3, str4, uri, str5, str6, str7);
        return signInCredential;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new SignInCredential[i];
    }
}
