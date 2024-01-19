package com.userexperior.c.b;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class c implements Parcelable {
    public static final Creator<c> CREATOR = new Creator<c>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new c[i];
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public static final String f3863e = c.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public long f3864a = -1;

    /* renamed from: b  reason: collision with root package name */
    public String f3865b;

    /* renamed from: c  reason: collision with root package name */
    public String f3866c;

    /* renamed from: d  reason: collision with root package name */
    public String f3867d;

    /* renamed from: f  reason: collision with root package name */
    public String f3868f;
    @com.userexperior.a.a.a.c(a = "createdAt")
    public long g;

    public c() {
    }

    public c(Parcel parcel) {
        this.f3864a = parcel.readLong();
        this.f3866c = parcel.readString();
        this.f3867d = parcel.readString();
        this.f3865b = parcel.readString();
        this.f3868f = parcel.readString();
        this.g = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.f3865b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f3864a);
        parcel.writeString(this.f3866c);
        parcel.writeString(this.f3867d);
        parcel.writeString(this.f3865b);
        parcel.writeString(this.f3868f);
        parcel.writeLong(this.g);
    }
}
