package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class zza implements Creator {
    public final Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        String str = null;
        List list = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        float f2 = 0.0f;
        boolean z = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    i = SafeParcelReader.readInt(parcel2, readInt);
                    break;
                case 2:
                    j = SafeParcelReader.readLong(parcel2, readInt);
                    break;
                case 4:
                    str = SafeParcelReader.createString(parcel2, readInt);
                    break;
                case 5:
                    i3 = SafeParcelReader.readInt(parcel2, readInt);
                    break;
                case 6:
                    list = SafeParcelReader.createStringList(parcel2, readInt);
                    break;
                case 8:
                    j2 = SafeParcelReader.readLong(parcel2, readInt);
                    break;
                case 10:
                    str3 = SafeParcelReader.createString(parcel2, readInt);
                    break;
                case 11:
                    i2 = SafeParcelReader.readInt(parcel2, readInt);
                    break;
                case 12:
                    str2 = SafeParcelReader.createString(parcel2, readInt);
                    break;
                case 13:
                    str4 = SafeParcelReader.createString(parcel2, readInt);
                    break;
                case 14:
                    i4 = SafeParcelReader.readInt(parcel2, readInt);
                    break;
                case 15:
                    f2 = SafeParcelReader.readFloat(parcel2, readInt);
                    break;
                case 16:
                    j3 = SafeParcelReader.readLong(parcel2, readInt);
                    break;
                case 17:
                    str5 = SafeParcelReader.createString(parcel2, readInt);
                    break;
                case 18:
                    z = SafeParcelReader.readBoolean(parcel2, readInt);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readInt);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        WakeLockEvent wakeLockEvent = new WakeLockEvent(i, j, i2, str, i3, list, str2, j2, i4, str3, str4, f2, j3, str5, z);
        return wakeLockEvent;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new WakeLockEvent[i];
    }
}