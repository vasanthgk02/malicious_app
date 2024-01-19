package com.userexperior.c.c;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public final class d implements Parcelable {
    public static final Creator<d> CREATOR = new Creator<d>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new d[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public String f3884a;

    /* renamed from: b  reason: collision with root package name */
    public String f3885b;

    /* renamed from: c  reason: collision with root package name */
    public String f3886c;

    /* renamed from: d  reason: collision with root package name */
    public List<e> f3887d;

    /* renamed from: e  reason: collision with root package name */
    public String f3888e;

    public d(Parcel parcel) {
        this.f3888e = parcel.readString();
        this.f3884a = parcel.readString();
        this.f3885b = parcel.readString();
        this.f3887d = new ArrayList();
        this.f3886c = parcel.readString();
        parcel.readList(this.f3887d, e.class.getClassLoader());
    }

    public d(List<e> list) {
        this.f3887d = list;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3888e);
        parcel.writeString(this.f3884a);
        parcel.writeString(this.f3885b);
        parcel.writeString(this.f3886c);
        parcel.writeList(this.f3887d);
    }
}
