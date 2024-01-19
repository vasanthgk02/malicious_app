package com.google.firebase.perf.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.TimeUnit;

public class Timer implements Parcelable {
    public static final Creator<Timer> CREATOR = new Creator<Timer>() {
        public Object createFromParcel(Parcel parcel) {
            return new Timer(parcel, null);
        }

        public Object[] newArray(int i) {
            return new Timer[i];
        }
    };
    public long highResTime;
    public long timeInMicros;

    public Timer() {
        this.timeInMicros = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
        this.highResTime = System.nanoTime();
    }

    public int describeContents() {
        return 0;
    }

    public long getDurationMicros() {
        return TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - this.highResTime);
    }

    public void reset() {
        this.timeInMicros = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
        this.highResTime = System.nanoTime();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.timeInMicros);
        parcel.writeLong(this.highResTime);
    }

    public long getDurationMicros(Timer timer) {
        return TimeUnit.NANOSECONDS.toMicros(timer.highResTime - this.highResTime);
    }

    @VisibleForTesting
    public Timer(long j) {
        this.timeInMicros = j;
        this.highResTime = TimeUnit.MICROSECONDS.toNanos(j);
    }

    public Timer(Parcel parcel, AnonymousClass1 r4) {
        this.timeInMicros = parcel.readLong();
        this.highResTime = parcel.readLong();
    }
}
