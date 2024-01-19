package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.concurrent.atomic.AtomicLong;

public class Counter implements Parcelable {
    public static final Creator<Counter> CREATOR = new Creator<Counter>() {
        public Object createFromParcel(Parcel parcel) {
            return new Counter(parcel, null);
        }

        public Object[] newArray(int i) {
            return new Counter[i];
        }
    };
    public final AtomicLong count;
    public final String name;

    public Counter(String str) {
        this.name = str;
        this.count = new AtomicLong(0);
    }

    public int describeContents() {
        return 0;
    }

    public long getCount() {
        return this.count.get();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeLong(this.count.get());
    }

    public Counter(Parcel parcel, AnonymousClass1 r4) {
        this.name = parcel.readString();
        this.count = new AtomicLong(parcel.readLong());
    }
}
