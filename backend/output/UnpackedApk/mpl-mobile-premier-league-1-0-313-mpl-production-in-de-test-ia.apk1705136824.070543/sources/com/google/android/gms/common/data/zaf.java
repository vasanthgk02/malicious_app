package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zaf implements Creator {
    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        String[] strArr = null;
        CursorWindow[] cursorWindowArr = null;
        Bundle bundle = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c2 = (char) readInt;
            if (c2 == 1) {
                strArr = SafeParcelReader.createStringArray(parcel, readInt);
            } else if (c2 == 2) {
                cursorWindowArr = (CursorWindow[]) SafeParcelReader.createTypedArray(parcel, readInt, CursorWindow.CREATOR);
            } else if (c2 == 3) {
                i3 = SafeParcelReader.readInt(parcel, readInt);
            } else if (c2 == 4) {
                bundle = SafeParcelReader.createBundle(parcel, readInt);
            } else if (c2 != 1000) {
                SafeParcelReader.skipUnknownField(parcel, readInt);
            } else {
                i2 = SafeParcelReader.readInt(parcel, readInt);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i3, bundle);
        dataHolder.zab = new Bundle();
        int i4 = 0;
        while (true) {
            String[] strArr2 = dataHolder.zag;
            if (i4 >= strArr2.length) {
                break;
            }
            dataHolder.zab.putInt(strArr2[i4], i4);
            i4++;
        }
        dataHolder.zac = new int[dataHolder.zah.length];
        int i5 = 0;
        while (true) {
            CursorWindow[] cursorWindowArr2 = dataHolder.zah;
            if (i < cursorWindowArr2.length) {
                dataHolder.zac[i] = i5;
                i5 += dataHolder.zah[i].getNumRows() - (i5 - cursorWindowArr2[i].getStartPosition());
                i++;
            } else {
                dataHolder.zad = i5;
                return dataHolder;
            }
        }
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new DataHolder[i];
    }
}
