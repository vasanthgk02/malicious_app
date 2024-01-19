package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.material.datepicker.CalendarConstraints.DateValidator;
import java.util.Arrays;

public class DateValidatorPointForward implements DateValidator {
    public static final Creator<DateValidatorPointForward> CREATOR = new Creator<DateValidatorPointForward>() {
        public Object createFromParcel(Parcel parcel) {
            return new DateValidatorPointForward(parcel.readLong(), null);
        }

        public Object[] newArray(int i) {
            return new DateValidatorPointForward[i];
        }
    };
    public final long point;

    public DateValidatorPointForward(long j) {
        this.point = j;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DateValidatorPointForward)) {
            return false;
        }
        if (this.point != ((DateValidatorPointForward) obj).point) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.point)});
    }

    public boolean isValid(long j) {
        return j >= this.point;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.point);
    }

    public DateValidatorPointForward(long j, AnonymousClass1 r3) {
        this.point = j;
    }
}
