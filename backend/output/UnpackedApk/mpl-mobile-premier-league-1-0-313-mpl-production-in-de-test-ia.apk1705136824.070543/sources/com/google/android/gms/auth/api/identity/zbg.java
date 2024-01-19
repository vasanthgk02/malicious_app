package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.identity.BeginSignInRequest.GoogleIdTokenRequestOptions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class zbg implements Creator {
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        List list = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    z = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                case 2:
                    str = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 3:
                    str2 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 4:
                    z2 = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                case 5:
                    str3 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 6:
                    list = SafeParcelReader.createStringList(parcel, readInt);
                    break;
                case 7:
                    z3 = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readInt);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        GoogleIdTokenRequestOptions googleIdTokenRequestOptions = new GoogleIdTokenRequestOptions(z, str, str2, z2, str3, list, z3);
        return googleIdTokenRequestOptions;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new GoogleIdTokenRequestOptions[i];
    }
}
