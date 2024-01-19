package org.joda.time.format;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import org.apache.commons.lang.StringEscapeUtils;

public class FormatUtils {
    public static final double LOG_10 = Math.log(10.0d);

    public static void appendPaddedInteger(StringBuffer stringBuffer, int i, int i2) {
        try {
            appendPaddedInteger((Appendable) stringBuffer, i, i2);
        } catch (IOException unused) {
        }
    }

    public static void appendUnpaddedInteger(Appendable appendable, int i) throws IOException {
        if (i < 0) {
            appendable.append('-');
            if (i != Integer.MIN_VALUE) {
                i = -i;
            } else {
                appendable.append("2147483648");
                return;
            }
        }
        if (i < 10) {
            appendable.append((char) (i + 48));
        } else if (i < 100) {
            int i2 = ((i + 1) * 13421772) >> 27;
            appendable.append((char) (i2 + 48));
            appendable.append((char) (((i - (i2 << 3)) - (i2 << 1)) + 48));
        } else {
            appendable.append(Integer.toString(i));
        }
    }

    public static String createErrorMessage(String str, int i) {
        String str2;
        int i2 = i + 32;
        if (str.length() <= i2 + 3) {
            str2 = str;
        } else {
            str2 = str.substring(0, i2).concat("...");
        }
        if (i <= 0) {
            return "Invalid format: \"" + str2 + StringEscapeUtils.CSV_QUOTE;
        } else if (i >= str.length()) {
            return GeneratedOutlineSupport.outline52("Invalid format: \"", str2, "\" is too short");
        } else {
            StringBuilder outline80 = GeneratedOutlineSupport.outline80("Invalid format: \"", str2, "\" is malformed at \"");
            outline80.append(str2.substring(i));
            outline80.append(StringEscapeUtils.CSV_QUOTE);
            return outline80.toString();
        }
    }

    public static int parseTwoDigits(CharSequence charSequence, int i) {
        int charAt = charSequence.charAt(i) - '0';
        return (charSequence.charAt(i + 1) + ((charAt << 3) + (charAt << 1))) - 48;
    }

    public static void appendPaddedInteger(Appendable appendable, int i, int i2) throws IOException {
        if (i < 0) {
            appendable.append('-');
            if (i != Integer.MIN_VALUE) {
                i = -i;
            } else {
                while (i2 > 10) {
                    appendable.append('0');
                    i2--;
                }
                appendable.append("2147483648");
                return;
            }
        }
        if (i < 10) {
            while (i2 > 1) {
                appendable.append('0');
                i2--;
            }
            appendable.append((char) (i + 48));
        } else if (i < 100) {
            while (i2 > 2) {
                appendable.append('0');
                i2--;
            }
            int i3 = ((i + 1) * 13421772) >> 27;
            appendable.append((char) (i3 + 48));
            appendable.append((char) (((i - (i3 << 3)) - (i3 << 1)) + 48));
        } else {
            int log = i < 1000 ? 3 : i < 10000 ? 4 : ((int) (Math.log((double) i) / LOG_10)) + 1;
            while (i2 > log) {
                appendable.append('0');
                i2--;
            }
            appendable.append(Integer.toString(i));
        }
    }

    public static void appendUnpaddedInteger(StringBuffer stringBuffer, long j) {
        int i = (int) j;
        if (((long) i) == j) {
            try {
                appendUnpaddedInteger((Appendable) stringBuffer, i);
            } catch (IOException unused) {
            }
        } else {
            stringBuffer.append(Long.toString(j));
        }
    }
}
