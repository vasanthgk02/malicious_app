package com.userexperior.c.c;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.userexperior.models.recording.enums.d;

public class e implements Parcelable {
    public static final Creator<e> CREATOR = new Creator<e>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new e[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public String f3889a;

    /* renamed from: b  reason: collision with root package name */
    public d f3890b;

    public e(Parcel parcel) {
        this.f3889a = parcel.readString();
        this.f3890b = (d) parcel.readSerializable();
    }

    public e(String str, d dVar) {
        this.f3889a = str;
        this.f3890b = dVar;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3889a);
        parcel.writeSerializable(this.f3890b);
    }
}
