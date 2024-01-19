package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class zbe implements Creator {
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        CredentialPickerConfig credentialPickerConfig = null;
        String[] strArr = null;
        String str = null;
        String str2 = null;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c2 = (char) readInt;
            if (c2 != 1000) {
                switch (c2) {
                    case 1:
                        credentialPickerConfig = (CredentialPickerConfig) SafeParcelReader.createParcelable(parcel, readInt, CredentialPickerConfig.CREATOR);
                        break;
                    case 2:
                        z = SafeParcelReader.readBoolean(parcel, readInt);
                        break;
                    case 3:
                        z2 = SafeParcelReader.readBoolean(parcel, readInt);
                        break;
                    case 4:
                        strArr = SafeParcelReader.createStringArray(parcel, readInt);
                        break;
                    case 5:
                        z3 = SafeParcelReader.readBoolean(parcel, readInt);
                        break;
                    case 6:
                        str = SafeParcelReader.createString(parcel, readInt);
                        break;
                    case 7:
                        str2 = SafeParcelReader.createString(parcel, readInt);
                        break;
                    default:
                        SafeParcelReader.skipUnknownField(parcel, readInt);
                        break;
                }
            } else {
                i = SafeParcelReader.readInt(parcel, readInt);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        HintRequest hintRequest = new HintRequest(i, credentialPickerConfig, z, z2, strArr, z3, str, str2);
        return hintRequest;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new HintRequest[i];
    }
}
