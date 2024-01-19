package org.joda.time.tz;

import org.joda.time.DateTimeZone;

public final class DateTimeZoneBuilder$DSTZone extends DateTimeZone {
    public static final long serialVersionUID = 6941492635554961361L;
    public final DateTimeZoneBuilder$Recurrence iEndRecurrence;
    public final int iStandardOffset;
    public final DateTimeZoneBuilder$Recurrence iStartRecurrence;

    public DateTimeZoneBuilder$DSTZone(String str, int i, DateTimeZoneBuilder$Recurrence dateTimeZoneBuilder$Recurrence, DateTimeZoneBuilder$Recurrence dateTimeZoneBuilder$Recurrence2) {
        super(str);
        this.iStandardOffset = i;
        this.iStartRecurrence = dateTimeZoneBuilder$Recurrence;
        this.iEndRecurrence = dateTimeZoneBuilder$Recurrence2;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DateTimeZoneBuilder$DSTZone)) {
            return false;
        }
        DateTimeZoneBuilder$DSTZone dateTimeZoneBuilder$DSTZone = (DateTimeZoneBuilder$DSTZone) obj;
        if (!this.iID.equals(dateTimeZoneBuilder$DSTZone.iID) || this.iStandardOffset != dateTimeZoneBuilder$DSTZone.iStandardOffset || !this.iStartRecurrence.equals(dateTimeZoneBuilder$DSTZone.iStartRecurrence) || !this.iEndRecurrence.equals(dateTimeZoneBuilder$DSTZone.iEndRecurrence)) {
            z = false;
        }
        return z;
    }

    public final DateTimeZoneBuilder$Recurrence findMatchingRecurrence(long j) {
        long j2;
        int i = this.iStandardOffset;
        DateTimeZoneBuilder$Recurrence dateTimeZoneBuilder$Recurrence = this.iStartRecurrence;
        DateTimeZoneBuilder$Recurrence dateTimeZoneBuilder$Recurrence2 = this.iEndRecurrence;
        try {
            j2 = dateTimeZoneBuilder$Recurrence.next(j, i, dateTimeZoneBuilder$Recurrence2.iSaveMillis);
        } catch (ArithmeticException | IllegalArgumentException unused) {
            j2 = j;
        }
        try {
            j = dateTimeZoneBuilder$Recurrence2.next(j, i, dateTimeZoneBuilder$Recurrence.iSaveMillis);
        } catch (ArithmeticException | IllegalArgumentException unused2) {
        }
        return j2 > j ? dateTimeZoneBuilder$Recurrence : dateTimeZoneBuilder$Recurrence2;
    }

    public String getNameKey(long j) {
        return findMatchingRecurrence(j).iNameKey;
    }

    public int getOffset(long j) {
        return this.iStandardOffset + findMatchingRecurrence(j).iSaveMillis;
    }

    public int getStandardOffset(long j) {
        return this.iStandardOffset;
    }

    public boolean isFixed() {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        if (r5 < 0) goto L_0x0016;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long nextTransition(long r9) {
        /*
            r8 = this;
            int r0 = r8.iStandardOffset
            org.joda.time.tz.DateTimeZoneBuilder$Recurrence r1 = r8.iStartRecurrence
            org.joda.time.tz.DateTimeZoneBuilder$Recurrence r2 = r8.iEndRecurrence
            r3 = 0
            int r5 = r2.iSaveMillis     // Catch:{ ArithmeticException | IllegalArgumentException -> 0x0016 }
            long r5 = r1.next(r9, r0, r5)     // Catch:{ ArithmeticException | IllegalArgumentException -> 0x0016 }
            int r7 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r7 <= 0) goto L_0x0017
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 >= 0) goto L_0x0017
        L_0x0016:
            r5 = r9
        L_0x0017:
            int r1 = r1.iSaveMillis     // Catch:{ ArithmeticException | IllegalArgumentException -> 0x0028 }
            long r0 = r2.next(r9, r0, r1)     // Catch:{ ArithmeticException | IllegalArgumentException -> 0x0028 }
            int r2 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r2 <= 0) goto L_0x0026
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 >= 0) goto L_0x0026
            goto L_0x0029
        L_0x0026:
            r9 = r0
            goto L_0x0029
        L_0x0028:
        L_0x0029:
            int r0 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r0 <= 0) goto L_0x002e
            r5 = r9
        L_0x002e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.tz.DateTimeZoneBuilder$DSTZone.nextTransition(long):long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
        if (r7 > 0) goto L_0x0019;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long previousTransition(long r11) {
        /*
            r10 = this;
            r0 = 1
            long r11 = r11 + r0
            int r2 = r10.iStandardOffset
            org.joda.time.tz.DateTimeZoneBuilder$Recurrence r3 = r10.iStartRecurrence
            org.joda.time.tz.DateTimeZoneBuilder$Recurrence r4 = r10.iEndRecurrence
            r5 = 0
            int r7 = r4.iSaveMillis     // Catch:{ ArithmeticException | IllegalArgumentException -> 0x0019 }
            long r7 = r3.previous(r11, r2, r7)     // Catch:{ ArithmeticException | IllegalArgumentException -> 0x0019 }
            int r9 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r9 >= 0) goto L_0x001a
            int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r9 <= 0) goto L_0x001a
        L_0x0019:
            r7 = r11
        L_0x001a:
            int r3 = r3.iSaveMillis     // Catch:{ ArithmeticException | IllegalArgumentException -> 0x002b }
            long r2 = r4.previous(r11, r2, r3)     // Catch:{ ArithmeticException | IllegalArgumentException -> 0x002b }
            int r4 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r4 >= 0) goto L_0x0029
            int r4 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x0029
            goto L_0x002c
        L_0x0029:
            r11 = r2
            goto L_0x002c
        L_0x002b:
        L_0x002c:
            int r2 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r2 <= 0) goto L_0x0031
            goto L_0x0032
        L_0x0031:
            r7 = r11
        L_0x0032:
            long r7 = r7 - r0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.tz.DateTimeZoneBuilder$DSTZone.previousTransition(long):long");
    }
}
