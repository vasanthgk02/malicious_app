package com.google.android.gms.auth.api.identity;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class zbi implements Creator {
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        PendingIntent pendingIntent = null;
        String str = null;
        String str2 = null;
        List list = null;
        String str3 = null;
        int i = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    pendingIntent = (PendingIntent) SafeParcelReader.createParcelable(parcel, readInt, PendingIntent.CREATOR);
                    break;
                case 2:
                    str = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 3:
                    str2 = SafeParcelReader.createString(parcel, readInt);
                    break;
                case 4:
                    list = SafeParcelReader.createStringList(parcel, readInt);
                    break;
                case 5:
                    str3 = SafeParcelReader.createString(parcel, readInt);
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
        SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest = new SaveAccountLinkingTokenRequest(pendingIntent, str, str2, list, str3, i);
        return saveAccountLinkingTokenRequest;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new SaveAccountLinkingTokenRequest[i];
    }
}
