package com.userexperior.c.c;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class f implements Parcelable {
    public static final Creator<f> CREATOR = new Creator<f>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new f(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new f[i];
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public static final String f3891f = f.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public String f3892a;

    /* renamed from: b  reason: collision with root package name */
    public List<e> f3893b;

    /* renamed from: c  reason: collision with root package name */
    public String f3894c;

    /* renamed from: d  reason: collision with root package name */
    public String f3895d;

    /* renamed from: e  reason: collision with root package name */
    public String f3896e;
    public String g;

    public f(Parcel parcel) {
        this.f3892a = parcel.readString();
        this.g = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.f3893b = arrayList;
        parcel.readList(arrayList, e.class.getClassLoader());
    }

    public f(List<e> list) {
        this.f3893b = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3892a);
        parcel.writeString(this.g);
        parcel.writeList(this.f3893b);
    }
}
