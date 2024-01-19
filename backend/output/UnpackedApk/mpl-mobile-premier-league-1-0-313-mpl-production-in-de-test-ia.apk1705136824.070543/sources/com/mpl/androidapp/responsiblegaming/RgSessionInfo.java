package com.mpl.androidapp.responsiblegaming;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;

public class RgSessionInfo {
    public long rgLastWarningDuration;
    public long rgSessionDuration;
    public long rgSessionEnd;
    public String rgSessionId;
    public int rgWarningCount;

    public static String milliToMinSec(long j) {
        return String.valueOf(j / 60000) + " min" + String.valueOf((j / 1000) % 60) + " seconds";
    }

    public long getRgLastWarningDuration() {
        return this.rgLastWarningDuration;
    }

    public long getRgSessionDuration() {
        return this.rgSessionDuration;
    }

    public long getRgSessionEnd() {
        return this.rgSessionEnd;
    }

    public String getRgSessionId() {
        return this.rgSessionId;
    }

    public int getRgWarningCount() {
        return this.rgWarningCount;
    }

    public void setRgLastWarningDuration(long j) {
        this.rgLastWarningDuration = j;
    }

    public void setRgSessionDuration(long j) {
        this.rgSessionDuration = j;
    }

    public void setRgSessionEnd(long j) {
        this.rgSessionEnd = j;
    }

    public void setRgSessionId(String str) {
        this.rgSessionId = str;
    }

    public void setRgWarningCount(int i) {
        this.rgWarningCount = i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("RG_SESSION_DURATION=");
        outline73.append(milliToMinSec(this.rgSessionDuration));
        StringBuilder sb = new StringBuilder(outline73.toString());
        StringBuilder outline732 = GeneratedOutlineSupport.outline73("RG_SESSION_END=");
        DateTime dateTime = new DateTime(this.rgSessionEnd);
        long j = ((long) 330) * ((long) 60000);
        if (j < -2147483648L || j > 2147483647L) {
            try {
                throw new ArithmeticException("Multiplication overflows an int: " + 330 + " * " + 60000);
            } catch (ArithmeticException unused) {
                throw new IllegalArgumentException("Offset is too large");
            }
        } else {
            outline732.append(DateTimeFormat.forPattern("HH:mm:ss").print(dateTime.withZone(DateTimeZone.forOffsetMillis((int) j))));
            outline732.append("| ");
            sb.append(outline732.toString());
            sb.append("RG_LAST_WARNING_DURATION=" + milliToMinSec(this.rgLastWarningDuration) + "| ");
            sb.append("RG_WARNING_COUNT=" + this.rgWarningCount + "| ");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("RG_SESSION_ID=");
            sb2.append(this.rgSessionId);
            sb.append(sb2.toString());
            return sb.toString();
        }
    }
}
