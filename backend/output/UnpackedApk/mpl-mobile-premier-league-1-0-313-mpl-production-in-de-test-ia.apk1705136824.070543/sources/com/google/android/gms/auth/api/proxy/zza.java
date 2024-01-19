package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zza implements Creator<ProxyRequest> {
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        byte[] bArr = null;
        Bundle bundle = null;
        long j = 0;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c2 = (char) readInt;
            if (c2 == 1) {
                str = SafeParcelReader.createString(parcel, readInt);
            } else if (c2 == 2) {
                i2 = SafeParcelReader.readInt(parcel, readInt);
            } else if (c2 == 3) {
                j = SafeParcelReader.readLong(parcel, readInt);
            } else if (c2 == 4) {
                bArr = SafeParcelReader.createByteArray(parcel, readInt);
            } else if (c2 == 5) {
                bundle = SafeParcelReader.createBundle(parcel, readInt);
            } else if (c2 != 1000) {
                SafeParcelReader.skipUnknownField(parcel, readInt);
            } else {
                i = SafeParcelReader.readInt(parcel, readInt);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        ProxyRequest proxyRequest = new ProxyRequest(i, str, i2, j, bArr, bundle);
        return proxyRequest;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ProxyRequest[i];
    }
}
