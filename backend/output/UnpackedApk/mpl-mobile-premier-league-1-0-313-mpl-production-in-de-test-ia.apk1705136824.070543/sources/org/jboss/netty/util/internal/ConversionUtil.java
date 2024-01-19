package org.jboss.netty.util.internal;

import com.paynimo.android.payment.util.Constant;
import io.sentry.SentryClient;
import java.util.ArrayList;

public class ConversionUtil {
    public static final String[] INTEGERS = {"0", "1", "2", "3", "4", "5", "6", SentryClient.SENTRY_PROTOCOL_VERSION, "8", "9", Constant.BANKCODE_ICICI, "11", "12", "13", "14", "15"};

    public static boolean toBoolean(Object obj) {
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        boolean z = true;
        if (obj instanceof Number) {
            if (((Number) obj).intValue() == 0) {
                z = false;
            }
            return z;
        }
        String valueOf = String.valueOf(obj);
        if (valueOf.length() == 0) {
            return false;
        }
        try {
            if (Integer.parseInt(valueOf) == 0) {
                z = false;
            }
            return z;
        } catch (NumberFormatException unused) {
            char upperCase = Character.toUpperCase(valueOf.charAt(0));
            return upperCase == 'T' || upperCase == 'Y';
        }
    }

    public static int toInt(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        return Integer.parseInt(String.valueOf(obj));
    }

    public static String toString(int i) {
        if (i >= 0) {
            String[] strArr = INTEGERS;
            if (i < strArr.length) {
                return strArr[i];
            }
        }
        return Integer.toString(i);
    }

    public static String[] toStringArray(Object obj) {
        if (obj instanceof String[]) {
            return (String[]) obj;
        }
        if (!(obj instanceof Iterable)) {
            return String.valueOf(obj).split("[, \\t\\n\\r\\f\\e\\a]");
        }
        ArrayList arrayList = new ArrayList();
        for (Object next : (Iterable) obj) {
            if (next == null) {
                arrayList.add(null);
            } else {
                arrayList.add(String.valueOf(next));
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
