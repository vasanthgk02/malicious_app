package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzbu implements Creator<SleepClassifyEvent> {
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        boolean z = false;
        int i8 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 2:
                    i2 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 3:
                    i3 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 4:
                    i4 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 5:
                    i5 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 6:
                    i6 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 7:
                    i7 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                case 8:
                    z = SafeParcelReader.readBoolean(parcel, readInt);
                    break;
                case 9:
                    i8 = SafeParcelReader.readInt(parcel, readInt);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readInt);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        SleepClassifyEvent sleepClassifyEvent = new SleepClassifyEvent(i, i2, i3, i4, i5, i6, i7, z, i8);
        return sleepClassifyEvent;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new SleepClassifyEvent[i];
    }
}
