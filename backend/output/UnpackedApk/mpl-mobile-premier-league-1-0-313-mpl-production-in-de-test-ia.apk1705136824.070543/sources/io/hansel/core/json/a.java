package io.hansel.core.json;

import org.apache.pdfbox.pdfparser.BaseParser;

public class a {
    public static double a(double d2) {
        if (!Double.isInfinite(d2) && !Double.isNaN(d2)) {
            return d2;
        }
        throw new CoreJSONException("Forbidden numeric value: " + d2);
    }

    public static CoreJSONException a(Object obj, Object obj2, String str) {
        if (obj2 == null) {
            throw new CoreJSONException("Value at " + obj + " is null.");
        }
        throw new CoreJSONException("Value " + obj2 + " at " + obj + " of type " + obj2.getClass().getName() + " cannot be converted to " + str);
    }

    public static CoreJSONException a(Object obj, String str) {
        if (obj == null) {
            throw new CoreJSONException("Value is null.");
        }
        throw new CoreJSONException("Value " + obj + " of type " + obj.getClass().getName() + " cannot be converted to " + str);
    }

    public static Boolean a(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (BaseParser.TRUE.equalsIgnoreCase(str)) {
                return Boolean.TRUE;
            }
            if (BaseParser.FALSE.equalsIgnoreCase(str)) {
                return Boolean.FALSE;
            }
        }
        return null;
    }

    public static Double b(Object obj) {
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (obj instanceof String) {
            try {
                return Double.valueOf((String) obj);
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public static Integer c(Object obj) {
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (obj instanceof String) {
            try {
                return Integer.valueOf((int) Double.parseDouble((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public static Long d(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf((long) Double.parseDouble((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public static String e(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj != null) {
            return String.valueOf(obj);
        }
        return null;
    }
}
