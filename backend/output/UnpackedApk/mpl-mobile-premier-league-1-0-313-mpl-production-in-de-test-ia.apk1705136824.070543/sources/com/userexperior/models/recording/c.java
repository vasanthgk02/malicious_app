package com.userexperior.models.recording;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class c implements Parcelable {
    public static final Creator<c> CREATOR = new Creator<c>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new c(parcel, 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new c[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f4074a;

    /* renamed from: b  reason: collision with root package name */
    public int f4075b;

    public c(Bitmap bitmap, int i) {
        this.f4074a = bitmap;
        this.f4075b = i;
    }

    public c(Parcel parcel) {
        this.f4074a = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.f4075b = parcel.readInt();
    }

    public /* synthetic */ c(Parcel parcel, byte b2) {
        this(parcel);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f4074a, i);
        parcel.writeInt(this.f4075b);
    }
}
