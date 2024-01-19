package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.format.DateUtils;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public final class Month implements Comparable<Month>, Parcelable {
    public static final Creator<Month> CREATOR = new Creator<Month>() {
        public Object createFromParcel(Parcel parcel) {
            return Month.create(parcel.readInt(), parcel.readInt());
        }

        public Object[] newArray(int i) {
            return new Month[i];
        }
    };
    public final int daysInMonth = this.firstOfMonth.getActualMaximum(5);
    public final int daysInWeek = this.firstOfMonth.getMaximum(7);
    public final Calendar firstOfMonth;
    public String longName;
    public final int month;
    public final long timeInMillis = this.firstOfMonth.getTimeInMillis();
    public final int year = this.firstOfMonth.get(1);

    public Month(Calendar calendar) {
        calendar.set(5, 1);
        Calendar dayCopy = UtcDates.getDayCopy(calendar);
        this.firstOfMonth = dayCopy;
        this.month = dayCopy.get(2);
    }

    public static Month create(long j) {
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(j);
        return new Month(utcCalendar);
    }

    public int daysFromStartOfWeekToFirstOfMonth() {
        int firstDayOfWeek = this.firstOfMonth.get(7) - this.firstOfMonth.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.daysInWeek : firstDayOfWeek;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month2 = (Month) obj;
        if (!(this.month == month2.month && this.year == month2.year)) {
            z = false;
        }
        return z;
    }

    public String getLongName(Context context) {
        if (this.longName == null) {
            long timeInMillis2 = this.firstOfMonth.getTimeInMillis();
            this.longName = DateUtils.formatDateTime(context, timeInMillis2 - ((long) TimeZone.getDefault().getOffset(timeInMillis2)), 36);
        }
        return this.longName;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.month), Integer.valueOf(this.year)});
    }

    public Month monthsLater(int i) {
        Calendar dayCopy = UtcDates.getDayCopy(this.firstOfMonth);
        dayCopy.add(2, i);
        return new Month(dayCopy);
    }

    public int monthsUntil(Month month2) {
        if (this.firstOfMonth instanceof GregorianCalendar) {
            return (month2.month - this.month) + ((month2.year - this.year) * 12);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.year);
        parcel.writeInt(this.month);
    }

    public int compareTo(Month month2) {
        return this.firstOfMonth.compareTo(month2.firstOfMonth);
    }

    public static Month create(int i, int i2) {
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.set(1, i);
        utcCalendar.set(2, i2);
        return new Month(utcCalendar);
    }
}
