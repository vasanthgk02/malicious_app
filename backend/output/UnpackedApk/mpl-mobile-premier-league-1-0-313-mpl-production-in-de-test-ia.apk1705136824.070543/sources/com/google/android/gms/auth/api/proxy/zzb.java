package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzb implements Creator<ProxyResponse> {
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        PendingIntent pendingIntent = null;
        Bundle bundle = null;
        byte[] bArr = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c2 = (char) readInt;
            if (c2 == 1) {
                i2 = SafeParcelReader.readInt(parcel, readInt);
            } else if (c2 == 2) {
                pendingIntent = (PendingIntent) SafeParcelReader.createParcelable(parcel, readInt, PendingIntent.CREATOR);
            } else if (c2 == 3) {
                i3 = SafeParcelReader.readInt(parcel, readInt);
            } else if (c2 == 4) {
                bundle = SafeParcelReader.createBundle(parcel, readInt);
            } else if (c2 == 5) {
                bArr = SafeParcelReader.createByteArray(parcel, readInt);
            } else if (c2 != 1000) {
                SafeParcelReader.skipUnknownField(parcel, readInt);
            } else {
                i = SafeParcelReader.readInt(parcel, readInt);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        ProxyResponse proxyResponse = new ProxyResponse(i, i2, pendingIntent, i3, bundle, bArr);
        return proxyResponse;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ProxyResponse[i];
    }
}
