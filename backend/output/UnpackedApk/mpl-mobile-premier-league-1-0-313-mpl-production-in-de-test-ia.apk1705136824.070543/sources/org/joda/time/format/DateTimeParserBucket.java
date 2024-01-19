package org.joda.time.format;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Arrays;
import java.util.Locale;
import org.apache.commons.lang.StringEscapeUtils;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.IllegalInstantException;

public class DateTimeParserBucket {
    public final Chronology iChrono;
    public final Integer iDefaultPivotYear;
    public final int iDefaultYear;
    public final DateTimeZone iDefaultZone;
    public final Locale iLocale;
    public final long iMillis;
    public Integer iOffset;
    public Integer iPivotYear;
    public SavedField[] iSavedFields;
    public int iSavedFieldsCount;
    public boolean iSavedFieldsShared;
    public Object iSavedState;
    public DateTimeZone iZone;

    public static class SavedField implements Comparable<SavedField> {
        public DateTimeField iField;
        public Locale iLocale;
        public String iText;
        public int iValue;

        public long set(long j, boolean z) {
            long j2;
            String str = this.iText;
            if (str == null) {
                j2 = this.iField.setExtended(j, this.iValue);
            } else {
                j2 = this.iField.set(j, str, this.iLocale);
            }
            return z ? this.iField.roundFloor(j2) : j2;
        }

        public int compareTo(SavedField savedField) {
            DateTimeField dateTimeField = savedField.iField;
            int compareReverse = DateTimeParserBucket.compareReverse(this.iField.getRangeDurationField(), dateTimeField.getRangeDurationField());
            if (compareReverse != 0) {
                return compareReverse;
            }
            return DateTimeParserBucket.compareReverse(this.iField.getDurationField(), dateTimeField.getDurationField());
        }
    }

    public class SavedState {
        public final Integer iOffset;
        public final SavedField[] iSavedFields;
        public final int iSavedFieldsCount;
        public final DateTimeZone iZone;

        public SavedState() {
            this.iZone = DateTimeParserBucket.this.iZone;
            this.iOffset = DateTimeParserBucket.this.iOffset;
            this.iSavedFields = DateTimeParserBucket.this.iSavedFields;
            this.iSavedFieldsCount = DateTimeParserBucket.this.iSavedFieldsCount;
        }
    }

    public DateTimeParserBucket(long j, Chronology chronology, Locale locale, Integer num, int i) {
        Chronology chronology2 = DateTimeUtils.getChronology(chronology);
        this.iMillis = j;
        this.iDefaultZone = chronology2.getZone();
        this.iChrono = chronology2.withUTC();
        this.iLocale = locale == null ? Locale.getDefault() : locale;
        this.iDefaultYear = i;
        this.iDefaultPivotYear = num;
        this.iZone = this.iDefaultZone;
        this.iPivotYear = num;
        this.iSavedFields = new SavedField[8];
    }

    public static int compareReverse(DurationField durationField, DurationField durationField2) {
        if (durationField == null || !durationField.isSupported()) {
            return (durationField2 == null || !durationField2.isSupported()) ? 0 : -1;
        }
        if (durationField2 == null || !durationField2.isSupported()) {
            return 1;
        }
        return -durationField.compareTo(durationField2);
    }

    public long computeMillis(boolean z, CharSequence charSequence) {
        SavedField[] savedFieldArr = this.iSavedFields;
        int i = this.iSavedFieldsCount;
        if (this.iSavedFieldsShared) {
            savedFieldArr = (SavedField[]) savedFieldArr.clone();
            this.iSavedFields = savedFieldArr;
            this.iSavedFieldsShared = false;
        }
        if (i > 10) {
            Arrays.sort(savedFieldArr, 0, i);
        } else {
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = i2;
                while (i3 > 0) {
                    int i4 = i3 - 1;
                    if (savedFieldArr[i4].compareTo(savedFieldArr[i3]) <= 0) {
                        break;
                    }
                    SavedField savedField = savedFieldArr[i3];
                    savedFieldArr[i3] = savedFieldArr[i4];
                    savedFieldArr[i4] = savedField;
                    i3 = i4;
                }
            }
        }
        if (i > 0) {
            DurationField field = DurationFieldType.MONTHS_TYPE.getField(this.iChrono);
            DurationField field2 = DurationFieldType.DAYS_TYPE.getField(this.iChrono);
            DurationField durationField = savedFieldArr[0].iField.getDurationField();
            if (compareReverse(durationField, field) >= 0 && compareReverse(durationField, field2) <= 0) {
                saveField(DateTimeFieldType.YEAR_TYPE, this.iDefaultYear);
                return computeMillis(z, charSequence);
            }
        }
        long j = this.iMillis;
        int i5 = 0;
        while (i5 < i) {
            try {
                j = savedFieldArr[i5].set(j, z);
                i5++;
            } catch (IllegalFieldValueException e2) {
                if (charSequence != null) {
                    String str = "Cannot parse \"" + charSequence + StringEscapeUtils.CSV_QUOTE;
                    if (e2.iMessage == null) {
                        e2.iMessage = str;
                    } else if (str != null) {
                        StringBuilder outline78 = GeneratedOutlineSupport.outline78(str, ": ");
                        outline78.append(e2.iMessage);
                        e2.iMessage = outline78.toString();
                    }
                }
                throw e2;
            }
        }
        if (z) {
            int i6 = 0;
            while (i6 < i) {
                if (!savedFieldArr[i6].iField.isLenient()) {
                    j = savedFieldArr[i6].set(j, i6 == i + -1);
                }
                i6++;
            }
        }
        Integer num = this.iOffset;
        if (num != null) {
            j -= (long) num.intValue();
        } else {
            DateTimeZone dateTimeZone = this.iZone;
            if (dateTimeZone != null) {
                int offsetFromLocal = dateTimeZone.getOffsetFromLocal(j);
                j -= (long) offsetFromLocal;
                if (offsetFromLocal != this.iZone.getOffset(j)) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Illegal instant due to time zone offset transition (");
                    outline73.append(this.iZone);
                    outline73.append(')');
                    String sb = outline73.toString();
                    if (charSequence != null) {
                        sb = "Cannot parse \"" + charSequence + "\": " + sb;
                    }
                    throw new IllegalInstantException(sb);
                }
            }
        }
        return j;
    }

    public final SavedField obtainSaveField() {
        SavedField[] savedFieldArr = this.iSavedFields;
        int i = this.iSavedFieldsCount;
        if (i == savedFieldArr.length || this.iSavedFieldsShared) {
            SavedField[] savedFieldArr2 = new SavedField[(i == savedFieldArr.length ? i * 2 : savedFieldArr.length)];
            System.arraycopy(savedFieldArr, 0, savedFieldArr2, 0, i);
            this.iSavedFields = savedFieldArr2;
            this.iSavedFieldsShared = false;
            savedFieldArr = savedFieldArr2;
        }
        this.iSavedState = null;
        SavedField savedField = savedFieldArr[i];
        if (savedField == null) {
            savedField = new SavedField();
            savedFieldArr[i] = savedField;
        }
        this.iSavedFieldsCount = i + 1;
        return savedField;
    }

    public boolean restoreState(Object obj) {
        boolean z;
        if (obj instanceof SavedState) {
            SavedState savedState = (SavedState) obj;
            if (this != DateTimeParserBucket.this) {
                z = false;
            } else {
                this.iZone = savedState.iZone;
                this.iOffset = savedState.iOffset;
                this.iSavedFields = savedState.iSavedFields;
                if (savedState.iSavedFieldsCount < this.iSavedFieldsCount) {
                    this.iSavedFieldsShared = true;
                }
                this.iSavedFieldsCount = savedState.iSavedFieldsCount;
                z = true;
            }
            if (z) {
                this.iSavedState = obj;
                return true;
            }
        }
        return false;
    }

    public void saveField(DateTimeFieldType dateTimeFieldType, int i) {
        SavedField obtainSaveField = obtainSaveField();
        obtainSaveField.iField = dateTimeFieldType.getField(this.iChrono);
        obtainSaveField.iValue = i;
        obtainSaveField.iText = null;
        obtainSaveField.iLocale = null;
    }

    public void setOffset(Integer num) {
        this.iSavedState = null;
        this.iOffset = num;
    }
}
