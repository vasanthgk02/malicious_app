package com.userexperior.c.c;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.userexperior.a.a.a.c;
import com.userexperior.models.recording.enums.e;
import com.userexperior.models.recording.enums.g;

public class b implements Parcelable {
    public static final Creator<b> CREATOR = new Creator<b>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new b[i];
        }
    };
    @c(a = "recordingQuality")

    /* renamed from: a  reason: collision with root package name */
    public g f3881a;
    @c(a = "recordType")

    /* renamed from: b  reason: collision with root package name */
    public e f3882b;
    @c(a = "imageFormat")

    /* renamed from: c  reason: collision with root package name */
    public String f3883c;

    public b(Parcel parcel) {
        this.f3881a = g.values()[parcel.readInt()];
        this.f3882b = e.values()[parcel.readInt()];
        this.f3883c = parcel.readString();
    }

    public b(g gVar, e eVar, String str) {
        this.f3881a = gVar;
        this.f3882b = eVar;
        this.f3883c = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f3881a.ordinal());
        parcel.writeInt(this.f3882b.ordinal());
        parcel.writeString(this.f3883c);
    }
}
