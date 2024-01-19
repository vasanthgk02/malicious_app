package com.userexperior.c.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.userexperior.a.a.a.c;

public class d implements Parcelable {
    public static final Creator<d> CREATOR = new Creator<d>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new d[i];
        }
    };
    @c(a = "type")

    /* renamed from: a  reason: collision with root package name */
    public String f3812a;
    @c(a = "latency")

    /* renamed from: b  reason: collision with root package name */
    public long f3813b;

    public d(Parcel parcel) {
        this.f3812a = parcel.readString();
        this.f3813b = parcel.readLong();
    }

    public d(String str, long j) {
        this.f3812a = str;
        this.f3813b = j;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3812a);
        parcel.writeLong(this.f3813b);
    }
}
