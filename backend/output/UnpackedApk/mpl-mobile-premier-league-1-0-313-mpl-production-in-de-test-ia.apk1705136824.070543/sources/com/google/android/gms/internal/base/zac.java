package com.google.android.gms.internal.base;

import android.os.BadParcelableException;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.android.tools.r8.GeneratedOutlineSupport;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zac {
    public static final ClassLoader zaa = zac.class.getClassLoader();

    public static Parcelable zaa(Parcel parcel, Creator creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (Parcelable) creator.createFromParcel(parcel);
    }

    public static void zab(Parcel parcel) {
        int dataAvail = parcel.dataAvail();
        if (dataAvail > 0) {
            throw new BadParcelableException(GeneratedOutlineSupport.outline41("Parcel data not fully consumed, unread size: ", dataAvail));
        }
    }

    public static void zac(Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }

    public static void zad(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }

    public static void zae(Parcel parcel, IInterface iInterface) {
        if (iInterface == null) {
            parcel.writeStrongBinder(null);
        } else {
            parcel.writeStrongBinder(iInterface.asBinder());
        }
    }
}
