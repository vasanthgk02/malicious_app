package com.userexperior.c.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class c implements Parcelable {
    public static final Creator<c> CREATOR = new Creator<c>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new c[i];
        }
    };
    @com.userexperior.a.a.a.c(a = "x")

    /* renamed from: a  reason: collision with root package name */
    public double f3809a;
    @com.userexperior.a.a.a.c(a = "y")

    /* renamed from: b  reason: collision with root package name */
    public double f3810b;
    @com.userexperior.a.a.a.c(a = "time")

    /* renamed from: c  reason: collision with root package name */
    public long f3811c;

    public c(double d2, double d3, long j) {
        this.f3809a = d2;
        this.f3810b = d3;
        this.f3811c = j;
    }

    public c(Parcel parcel) {
        this.f3809a = parcel.readDouble();
        this.f3810b = parcel.readDouble();
        this.f3811c = parcel.readLong();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.f3809a);
        parcel.writeDouble(this.f3810b);
        parcel.writeLong(this.f3811c);
    }
}
