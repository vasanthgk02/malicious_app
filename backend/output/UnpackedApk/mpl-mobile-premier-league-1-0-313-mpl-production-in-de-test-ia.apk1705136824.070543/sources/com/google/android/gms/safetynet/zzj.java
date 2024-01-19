package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzj implements Creator<SafeBrowsingData> {
    public static void zza(SafeBrowsingData safeBrowsingData, Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, safeBrowsingData.zzm, false);
        SafeParcelWriter.writeParcelable(parcel, 3, safeBrowsingData.zzn, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, safeBrowsingData.zzo, i, false);
        long j = safeBrowsingData.zzp;
        parcel.writeInt(524293);
        parcel.writeLong(j);
        SafeParcelWriter.writeByteArray(parcel, 6, safeBrowsingData.zzq, false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }

    public final Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        DataHolder dataHolder = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        byte[] bArr = null;
        long j = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            char c2 = (char) readInt;
            if (c2 == 2) {
                str = SafeParcelReader.createString(parcel, readInt);
            } else if (c2 == 3) {
                dataHolder = (DataHolder) SafeParcelReader.createParcelable(parcel, readInt, DataHolder.CREATOR);
            } else if (c2 == 4) {
                parcelFileDescriptor = (ParcelFileDescriptor) SafeParcelReader.createParcelable(parcel, readInt, ParcelFileDescriptor.CREATOR);
            } else if (c2 == 5) {
                j = SafeParcelReader.readLong(parcel, readInt);
            } else if (c2 != 6) {
                SafeParcelReader.skipUnknownField(parcel, readInt);
            } else {
                bArr = SafeParcelReader.createByteArray(parcel, readInt);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        SafeBrowsingData safeBrowsingData = new SafeBrowsingData(str, dataHolder, parcelFileDescriptor, j, bArr);
        return safeBrowsingData;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new SafeBrowsingData[i];
    }
}
