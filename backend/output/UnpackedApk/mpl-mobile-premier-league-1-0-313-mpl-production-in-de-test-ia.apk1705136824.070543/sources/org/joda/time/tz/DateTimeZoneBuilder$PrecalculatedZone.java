package org.joda.time.tz;

import java.io.DataInput;
import java.io.IOException;
import java.util.Arrays;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.joda.time.DateTimeZone;

public final class DateTimeZoneBuilder$PrecalculatedZone extends DateTimeZone {
    public static final long serialVersionUID = 7811976468055766265L;
    public final String[] iNameKeys;
    public final int[] iStandardOffsets;
    public final DateTimeZoneBuilder$DSTZone iTailZone;
    public final long[] iTransitions;
    public final int[] iWallOffsets;

    public DateTimeZoneBuilder$PrecalculatedZone(String str, long[] jArr, int[] iArr, int[] iArr2, String[] strArr, DateTimeZoneBuilder$DSTZone dateTimeZoneBuilder$DSTZone) {
        super(str);
        this.iTransitions = jArr;
        this.iWallOffsets = iArr;
        this.iStandardOffsets = iArr2;
        this.iNameKeys = strArr;
        this.iTailZone = dateTimeZoneBuilder$DSTZone;
    }

    public static DateTimeZoneBuilder$PrecalculatedZone readFrom(DataInput dataInput, String str) throws IOException {
        int i;
        int readUnsignedShort = dataInput.readUnsignedShort();
        String[] strArr = new String[readUnsignedShort];
        for (int i2 = 0; i2 < readUnsignedShort; i2++) {
            strArr[i2] = dataInput.readUTF();
        }
        int readInt = dataInput.readInt();
        long[] jArr = new long[readInt];
        int[] iArr = new int[readInt];
        int[] iArr2 = new int[readInt];
        String[] strArr2 = new String[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            jArr[i3] = TypeUtilsKt.readMillis(dataInput);
            iArr[i3] = (int) TypeUtilsKt.readMillis(dataInput);
            iArr2[i3] = (int) TypeUtilsKt.readMillis(dataInput);
            if (readUnsignedShort < 256) {
                try {
                    i = dataInput.readUnsignedByte();
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw new IOException("Invalid encoding");
                }
            } else {
                i = dataInput.readUnsignedShort();
            }
            strArr2[i3] = strArr[i];
        }
        DateTimeZoneBuilder$DSTZone dateTimeZoneBuilder$DSTZone = null;
        if (dataInput.readBoolean()) {
            dateTimeZoneBuilder$DSTZone = new DateTimeZoneBuilder$DSTZone(str, (int) TypeUtilsKt.readMillis(dataInput), DateTimeZoneBuilder$Recurrence.readFrom(dataInput), DateTimeZoneBuilder$Recurrence.readFrom(dataInput));
        }
        DateTimeZoneBuilder$PrecalculatedZone dateTimeZoneBuilder$PrecalculatedZone = new DateTimeZoneBuilder$PrecalculatedZone(str, jArr, iArr, iArr2, strArr2, dateTimeZoneBuilder$DSTZone);
        return dateTimeZoneBuilder$PrecalculatedZone;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DateTimeZoneBuilder$PrecalculatedZone)) {
            return false;
        }
        DateTimeZoneBuilder$PrecalculatedZone dateTimeZoneBuilder$PrecalculatedZone = (DateTimeZoneBuilder$PrecalculatedZone) obj;
        if (this.iID.equals(dateTimeZoneBuilder$PrecalculatedZone.iID) && Arrays.equals(this.iTransitions, dateTimeZoneBuilder$PrecalculatedZone.iTransitions) && Arrays.equals(this.iNameKeys, dateTimeZoneBuilder$PrecalculatedZone.iNameKeys) && Arrays.equals(this.iWallOffsets, dateTimeZoneBuilder$PrecalculatedZone.iWallOffsets) && Arrays.equals(this.iStandardOffsets, dateTimeZoneBuilder$PrecalculatedZone.iStandardOffsets)) {
            DateTimeZoneBuilder$DSTZone dateTimeZoneBuilder$DSTZone = this.iTailZone;
            DateTimeZoneBuilder$DSTZone dateTimeZoneBuilder$DSTZone2 = dateTimeZoneBuilder$PrecalculatedZone.iTailZone;
            if (dateTimeZoneBuilder$DSTZone != null) {
            }
        }
        z = false;
        return z;
    }

    public String getNameKey(long j) {
        long[] jArr = this.iTransitions;
        int binarySearch = Arrays.binarySearch(jArr, j);
        if (binarySearch >= 0) {
            return this.iNameKeys[binarySearch];
        }
        int i = ~binarySearch;
        if (i < jArr.length) {
            return i > 0 ? this.iNameKeys[i - 1] : "UTC";
        }
        DateTimeZoneBuilder$DSTZone dateTimeZoneBuilder$DSTZone = this.iTailZone;
        if (dateTimeZoneBuilder$DSTZone == null) {
            return this.iNameKeys[i - 1];
        }
        return dateTimeZoneBuilder$DSTZone.findMatchingRecurrence(j).iNameKey;
    }

    public int getOffset(long j) {
        long[] jArr = this.iTransitions;
        int binarySearch = Arrays.binarySearch(jArr, j);
        if (binarySearch >= 0) {
            return this.iWallOffsets[binarySearch];
        }
        int i = ~binarySearch;
        if (i >= jArr.length) {
            DateTimeZoneBuilder$DSTZone dateTimeZoneBuilder$DSTZone = this.iTailZone;
            if (dateTimeZoneBuilder$DSTZone == null) {
                return this.iWallOffsets[i - 1];
            }
            return dateTimeZoneBuilder$DSTZone.getOffset(j);
        } else if (i > 0) {
            return this.iWallOffsets[i - 1];
        } else {
            return 0;
        }
    }

    public int getStandardOffset(long j) {
        long[] jArr = this.iTransitions;
        int binarySearch = Arrays.binarySearch(jArr, j);
        if (binarySearch >= 0) {
            return this.iStandardOffsets[binarySearch];
        }
        int i = ~binarySearch;
        if (i >= jArr.length) {
            DateTimeZoneBuilder$DSTZone dateTimeZoneBuilder$DSTZone = this.iTailZone;
            if (dateTimeZoneBuilder$DSTZone == null) {
                return this.iStandardOffsets[i - 1];
            }
            return dateTimeZoneBuilder$DSTZone.iStandardOffset;
        } else if (i > 0) {
            return this.iStandardOffsets[i - 1];
        } else {
            return 0;
        }
    }

    public boolean isFixed() {
        return false;
    }

    public long nextTransition(long j) {
        long[] jArr = this.iTransitions;
        int binarySearch = Arrays.binarySearch(jArr, j);
        int i = binarySearch >= 0 ? binarySearch + 1 : ~binarySearch;
        if (i < jArr.length) {
            return jArr[i];
        }
        if (this.iTailZone == null) {
            return j;
        }
        long j2 = jArr[jArr.length - 1];
        if (j < j2) {
            j = j2;
        }
        return this.iTailZone.nextTransition(j);
    }

    public long previousTransition(long j) {
        long[] jArr = this.iTransitions;
        int binarySearch = Arrays.binarySearch(jArr, j);
        if (binarySearch >= 0) {
            if (j > Long.MIN_VALUE) {
                j--;
            }
            return j;
        }
        int i = ~binarySearch;
        if (i < jArr.length) {
            if (i > 0) {
                long j2 = jArr[i - 1];
                if (j2 > Long.MIN_VALUE) {
                    return j2 - 1;
                }
            }
            return j;
        }
        DateTimeZoneBuilder$DSTZone dateTimeZoneBuilder$DSTZone = this.iTailZone;
        if (dateTimeZoneBuilder$DSTZone != null) {
            long previousTransition = dateTimeZoneBuilder$DSTZone.previousTransition(j);
            if (previousTransition < j) {
                return previousTransition;
            }
        }
        long j3 = jArr[i - 1];
        return j3 > Long.MIN_VALUE ? j3 - 1 : j;
    }
}
