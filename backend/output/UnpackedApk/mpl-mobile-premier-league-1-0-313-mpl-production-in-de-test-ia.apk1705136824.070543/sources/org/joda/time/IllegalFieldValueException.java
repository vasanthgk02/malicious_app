package org.joda.time;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.commons.lang.StringEscapeUtils;

public class IllegalFieldValueException extends IllegalArgumentException {
    public static final long serialVersionUID = 6305711765985447737L;
    public final DateTimeFieldType iDateTimeFieldType;
    public final DurationFieldType iDurationFieldType;
    public final String iFieldName;
    public final Number iLowerBound;
    public String iMessage;
    public final Number iNumberValue;
    public final String iStringValue;
    public final Number iUpperBound;

    public IllegalFieldValueException(DateTimeFieldType dateTimeFieldType, Number number, Number number2, Number number3) {
        super(createMessage(dateTimeFieldType.iName, number, number2, number3, null));
        this.iDateTimeFieldType = dateTimeFieldType;
        this.iDurationFieldType = null;
        this.iFieldName = dateTimeFieldType.iName;
        this.iNumberValue = number;
        this.iStringValue = null;
        this.iLowerBound = number2;
        this.iUpperBound = number3;
        this.iMessage = super.getMessage();
    }

    public static String createMessage(String str, Number number, Number number2, Number number3, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("Value ");
        sb.append(number);
        sb.append(" for ");
        sb.append(str);
        sb.append(' ');
        if (number2 == null) {
            if (number3 == null) {
                sb.append("is not supported");
            } else {
                sb.append("must not be larger than ");
                sb.append(number3);
            }
        } else if (number3 == null) {
            sb.append("must not be smaller than ");
            sb.append(number2);
        } else {
            sb.append("must be in the range [");
            sb.append(number2);
            sb.append(',');
            sb.append(number3);
            sb.append(']');
        }
        if (str2 != null) {
            sb.append(": ");
            sb.append(str2);
        }
        return sb.toString();
    }

    public String getMessage() {
        return this.iMessage;
    }

    public IllegalFieldValueException(DateTimeFieldType dateTimeFieldType, Number number, String str) {
        super(createMessage(dateTimeFieldType.iName, number, null, null, str));
        this.iDateTimeFieldType = dateTimeFieldType;
        this.iDurationFieldType = null;
        this.iFieldName = dateTimeFieldType.iName;
        this.iNumberValue = number;
        this.iStringValue = null;
        this.iLowerBound = null;
        this.iUpperBound = null;
        this.iMessage = super.getMessage();
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public IllegalFieldValueException(DateTimeFieldType dateTimeFieldType, String str) {
        // String str2 = dateTimeFieldType.iName;
        // StringBuffer outline71 = GeneratedOutlineSupport.outline71("Value ");
        // if (str == null) {
            // outline71.append("null");
        // } else {
            // outline71.append(StringEscapeUtils.CSV_QUOTE);
            // outline71.append(str);
            // outline71.append(StringEscapeUtils.CSV_QUOTE);
        // }
        // outline71.append(" for ");
        // outline71.append(str2);
        // outline71.append(' ');
        // outline71.append("is not supported");
        super(outline71.toString());
        this.iDateTimeFieldType = dateTimeFieldType;
        this.iDurationFieldType = null;
        this.iFieldName = dateTimeFieldType.iName;
        this.iStringValue = str;
        this.iNumberValue = null;
        this.iLowerBound = null;
        this.iUpperBound = null;
        this.iMessage = super.getMessage();
    }
}
