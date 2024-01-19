package com.userexperior.c.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.userexperior.a.a.a.c;
import java.util.HashMap;
import org.apache.fontbox.cmap.CMapParser;

public class e implements Parcelable {
    public static final Creator<e> CREATOR = new Creator<e>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new e(parcel, 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new e[i];
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public static final String f3814e = e.class.getSimpleName();
    @c(a = "tn")

    /* renamed from: a  reason: collision with root package name */
    public String f3815a;
    @c(a = "rt")

    /* renamed from: b  reason: collision with root package name */
    public int f3816b;
    @c(a = "ts")

    /* renamed from: c  reason: collision with root package name */
    public long f3817c;
    @c(a = "reqProps")

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, String> f3818d;
    @c(a = "tm")

    /* renamed from: f  reason: collision with root package name */
    public long f3819f;
    @c(a = "sn")
    public String g;
    @c(a = "resProps")
    public HashMap<String, String> h;

    public e(Parcel parcel) {
        this.f3815a = parcel.readString();
        this.g = parcel.readString();
        this.f3816b = parcel.readInt();
        this.f3819f = parcel.readLong();
        this.f3817c = parcel.readLong();
        this.f3818d = (HashMap) parcel.readParcelable(HashMap.class.getClassLoader());
        this.h = (HashMap) parcel.readParcelable(HashMap.class.getClassLoader());
    }

    public /* synthetic */ e(Parcel parcel, byte b2) {
        this(parcel);
    }

    public e(String str, String str2, int i, long j, long j2, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        this.f3815a = str;
        this.g = str2;
        this.f3816b = i;
        this.f3819f = j;
        this.f3817c = j2;
        if (hashMap != null) {
            this.f3818d = hashMap;
        }
        if (hashMap2 != null) {
            this.h = hashMap2;
        }
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("rtl[tn:");
        sb.append(this.f3815a);
        sb.append(";rt:");
        sb.append(this.f3816b);
        sb.append(";tm:");
        sb.append(this.f3819f);
        sb.append(";ts:");
        return GeneratedOutlineSupport.outline58(sb, this.f3817c, CMapParser.MARK_END_OF_ARRAY);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3815a);
        parcel.writeString(this.g);
        parcel.writeInt(this.f3816b);
        parcel.writeLong(this.f3819f);
        parcel.writeLong(this.f3817c);
        parcel.writeParcelable((Parcelable) this.f3818d, i);
        parcel.writeParcelable((Parcelable) this.h, i);
    }
}
