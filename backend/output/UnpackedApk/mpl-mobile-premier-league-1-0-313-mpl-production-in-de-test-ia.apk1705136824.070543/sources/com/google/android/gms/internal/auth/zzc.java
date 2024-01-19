package com.google.android.gms.internal.auth;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzc {
    public static final ClassLoader zza = zzc.class.getClassLoader();

    public static <T extends Parcelable> T zza(Parcel parcel, Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (Parcelable) creator.createFromParcel(parcel);
    }

    public static void zzb(Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }

    public static void zzc(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }

    public static void zzd(Parcel parcel, IInterface iInterface) {
        if (iInterface == null) {
            parcel.writeStrongBinder(null);
        } else {
            parcel.writeStrongBinder(iInterface.asBinder());
        }
    }

    public static boolean zze(Parcel parcel) {
        return parcel.readInt() != 0;
    }
}
