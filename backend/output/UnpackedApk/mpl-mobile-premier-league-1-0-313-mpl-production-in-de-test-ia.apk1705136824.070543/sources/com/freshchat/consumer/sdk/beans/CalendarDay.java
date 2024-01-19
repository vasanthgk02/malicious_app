package com.freshchat.consumer.sdk.beans;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.R;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.lang.text.ExtendedMessageFormat;

public class CalendarDay {
    public final String day;
    public final Map<PartOfDay, List<TimeSlot>> timeSlotsMap = new TreeMap(new Comparator<PartOfDay>() {
        public int compare(PartOfDay partOfDay, PartOfDay partOfDay2) {
            return partOfDay.startHour - partOfDay2.startHour;
        }
    });

    public enum PartOfDay {
        MORNING(0, 12, R.string.freshchat_calendar_part_of_day_morning),
        AFTERNOON(12, 16, R.string.freshchat_calendar_part_of_day_afternoon),
        EVENING(16, 20, R.string.freshchat_calendar_part_of_day_evening),
        NIGHT(20, 24, R.string.freshchat_calendar_part_of_day_night);
        
        public final int endHour;
        public final int startHour;
        public final int stringResId;

        /* access modifiers changed from: public */
        PartOfDay(int i, int i2, int i3) {
            this.startHour = i;
            this.endHour = i2;
            this.stringResId = i3;
        }

        public static PartOfDay getPartOfDay(int i) {
            for (PartOfDay partOfDay : values()) {
                if (partOfDay.startHour <= i && i < partOfDay.endHour) {
                    return partOfDay;
                }
            }
            return null;
        }

        public int getEndHour() {
            return this.endHour;
        }

        public int getStartHour() {
            return this.startHour;
        }

        public int getStringResId() {
            return this.stringResId;
        }
    }

    public static class TimeSlot implements Parcelable, Comparable<TimeSlot> {
        public static final Creator<TimeSlot> CREATOR = new Creator<TimeSlot>() {
            public TimeSlot createFromParcel(Parcel parcel) {
                return new TimeSlot(parcel);
            }

            public TimeSlot[] newArray(int i) {
                return new TimeSlot[i];
            }
        };
        public final long fromMillis;
        public final long toMillis;

        public TimeSlot(long j, long j2) {
            this.fromMillis = j;
            this.toMillis = j2;
        }

        public TimeSlot(Parcel parcel) {
            this.fromMillis = parcel.readLong();
            this.toMillis = parcel.readLong();
        }

        public int compareTo(TimeSlot timeSlot) {
            return (int) (this.fromMillis - timeSlot.fromMillis);
        }

        public int describeContents() {
            return 0;
        }

        public long getFromMillis() {
            return this.fromMillis;
        }

        public long getToMillis() {
            return this.toMillis;
        }

        public String toString() {
            StringBuilder outline77 = GeneratedOutlineSupport.outline77("TimeSlot{", " fromMillis : '");
            outline77.append(this.fromMillis);
            outline77.append(ExtendedMessageFormat.QUOTE);
            outline77.append(", toMillis : '");
            outline77.append(this.toMillis);
            outline77.append(ExtendedMessageFormat.QUOTE);
            outline77.append('}');
            return outline77.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.fromMillis);
            parcel.writeLong(this.toMillis);
        }
    }

    public CalendarDay(String str) {
        this.day = str;
    }

    public String getDay() {
        return this.day;
    }

    public Map<PartOfDay, List<TimeSlot>> getTimeSlotsMap() {
        return this.timeSlotsMap;
    }
}
