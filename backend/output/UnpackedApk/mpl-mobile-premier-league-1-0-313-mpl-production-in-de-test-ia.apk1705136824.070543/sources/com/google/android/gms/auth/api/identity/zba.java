package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.identity.BeginSignInRequest.GoogleIdTokenRequestOptions;
import com.google.android.gms.auth.api.identity.BeginSignInRequest.PasswordRequestOptions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class zba implements Creator {
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        PasswordRequestOptions passwordRequestOptions = null;
        GoogleIdTokenRequestOptions googleIdTokenRequestOptions = null;
        String str = null;
        boolean z = false;
        int i = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c2 = (char) readInt;
            if (c2 == 1) {
                passwordRequestOptions = (PasswordRequestOptions) SafeParcelReader.createParcelable(parcel, readInt, PasswordRequestOptions.CREATOR);
            } else if (c2 == 2) {
                googleIdTokenRequestOptions = (GoogleIdTokenRequestOptions) SafeParcelReader.createParcelable(parcel, readInt, GoogleIdTokenRequestOptions.CREATOR);
            } else if (c2 == 3) {
                str = SafeParcelReader.createString(parcel, readInt);
            } else if (c2 == 4) {
                z = SafeParcelReader.readBoolean(parcel, readInt);
            } else if (c2 != 5) {
                SafeParcelReader.skipUnknownField(parcel, readInt);
            } else {
                i = SafeParcelReader.readInt(parcel, readInt);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        BeginSignInRequest beginSignInRequest = new BeginSignInRequest(passwordRequestOptions, googleIdTokenRequestOptions, str, z, i);
        return beginSignInRequest;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new BeginSignInRequest[i];
    }
}
