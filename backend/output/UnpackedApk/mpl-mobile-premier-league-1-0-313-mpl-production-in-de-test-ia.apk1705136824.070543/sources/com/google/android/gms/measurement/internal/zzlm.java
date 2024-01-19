package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzlm implements Creator {
    public static void zza(zzll zzll, Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        int i2 = zzll.zza;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        SafeParcelWriter.writeString(parcel, 2, zzll.zzb, false);
        long j = zzll.zzc;
        parcel.writeInt(524291);
        parcel.writeLong(j);
        SafeParcelWriter.writeLongObject(parcel, 4, zzll.zzd, false);
        SafeParcelWriter.writeString(parcel, 6, zzll.zze, false);
        SafeParcelWriter.writeString(parcel, 7, zzll.zzf, false);
        Double d2 = zzll.zzg;
        if (d2 != null) {
            parcel.writeInt(524296);
            parcel.writeDouble(d2.doubleValue());
        }
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }

    public final Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        Long l = null;
        Float f2 = null;
        String str2 = null;
        String str3 = null;
        Double d2 = null;
        long j = 0;
        int i = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    i = SafeParcelReader.readInt(parcel2, readInt);
                    break;
                case 2:
                    str = SafeParcelReader.createString(parcel2, readInt);
                    break;
                case 3:
                    j = SafeParcelReader.readLong(parcel2, readInt);
                    break;
                case 4:
                    l = SafeParcelReader.readLongObject(parcel2, readInt);
                    break;
                case 5:
                    int readSize = SafeParcelReader.readSize(parcel2, readInt);
                    if (readSize != 0) {
                        SafeParcelReader.zza(parcel2, readInt, readSize, 4);
                        f2 = Float.valueOf(parcel.readFloat());
                        break;
                    } else {
                        f2 = null;
                        break;
                    }
                case 6:
                    str2 = SafeParcelReader.createString(parcel2, readInt);
                    break;
                case 7:
                    str3 = SafeParcelReader.createString(parcel2, readInt);
                    break;
                case 8:
                    int readSize2 = SafeParcelReader.readSize(parcel2, readInt);
                    if (readSize2 != 0) {
                        SafeParcelReader.zza(parcel2, readInt, readSize2, 8);
                        d2 = Double.valueOf(parcel.readDouble());
                        break;
                    } else {
                        d2 = null;
                        break;
                    }
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readInt);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        zzll zzll = new zzll(i, str, j, l, f2, str2, str3, d2);
        return zzll;
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzll[i];
    }
}
