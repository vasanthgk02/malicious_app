package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class zbf implements Creator {
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        boolean z = false;
        int i = 0;
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
                    z = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                case 6:
                    i = SafeParcelReader.readInt(parcel, readInt);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readInt);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        GetSignInIntentRequest getSignInIntentRequest = new GetSignInIntentRequest(str, str2, str3, str4, z, i);
        return getSignInIntentRequest;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new GetSignInIntentRequest[i];
    }
}
