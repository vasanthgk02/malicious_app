package net.sf.json.util;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import net.sf.ezmorph.MorphUtils;
import net.sf.ezmorph.MorpherRegistry;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONFunction;
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;
import net.sf.json.JSONString;
import net.sf.json.regexp.RegexpUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.fontbox.cmap.CMapParser;
import org.apache.pdfbox.filter.ASCII85InputStream;

public final class JSONUtils {
    public static /* synthetic */ Class class$java$lang$Boolean;
    public static /* synthetic */ Class class$java$lang$Character;
    public static /* synthetic */ Class class$java$lang$Double;
    public static /* synthetic */ Class class$java$lang$Number;
    public static /* synthetic */ Class class$java$lang$String;
    public static /* synthetic */ Class class$java$util$Collection;
    public static /* synthetic */ Class class$net$sf$json$JSONArray;
    public static final MorpherRegistry morpherRegistry;

    static {
        MorpherRegistry morpherRegistry2 = new MorpherRegistry();
        morpherRegistry = morpherRegistry2;
        MorphUtils.registerStandardMorphers(morpherRegistry2);
    }

    public static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public static String getFunctionParams(String str) {
        return RegexpUtils.getMatchera("^function[ ]?\\((.*?)\\).*").getGroupIfMatches(str, 1);
    }

    public static int hashCode(Object obj) {
        if (obj == null) {
            return 3392940;
        }
        if ((obj instanceof JSON) || (obj instanceof String) || (obj instanceof JSONFunction)) {
            return obj.hashCode();
        }
        return String.valueOf(obj).hashCode();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        if (r0.isAssignableFrom(r1) != false) goto L_0x002c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isArray(java.lang.Class r1) {
        /*
            if (r1 == 0) goto L_0x002e
            boolean r0 = r1.isArray()
            if (r0 != 0) goto L_0x002c
            java.lang.Class r0 = class$java$util$Collection
            if (r0 != 0) goto L_0x0014
            java.lang.String r0 = "java.util.Collection"
            java.lang.Class r0 = class$(r0)
            class$java$util$Collection = r0
        L_0x0014:
            boolean r0 = r0.isAssignableFrom(r1)
            if (r0 != 0) goto L_0x002c
            java.lang.Class r0 = class$net$sf$json$JSONArray
            if (r0 != 0) goto L_0x0026
            java.lang.String r0 = "net.sf.json.JSONArray"
            java.lang.Class r0 = class$(r0)
            class$net$sf$json$JSONArray = r0
        L_0x0026:
            boolean r1 = r0.isAssignableFrom(r1)
            if (r1 == 0) goto L_0x002e
        L_0x002c:
            r1 = 1
            goto L_0x002f
        L_0x002e:
            r1 = 0
        L_0x002f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sf.json.util.JSONUtils.isArray(java.lang.Class):boolean");
    }

    public static boolean isBoolean(Object obj) {
        return (obj instanceof Boolean) || (obj != null && obj.getClass() == Boolean.TYPE);
    }

    public static boolean isFunction(Object obj) {
        boolean z = true;
        if (!(obj instanceof String)) {
            return obj instanceof JSONFunction;
        }
        String str = (String) obj;
        if (!str.startsWith("function") || !RegexpUtils.getMatchera("^function[ ]?\\(.*?\\)[ \n\t]*\\{.*?\\}$").matches(str)) {
            z = false;
        }
        return z;
    }

    public static boolean isFunctionHeader(Object obj) {
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.startsWith("function") && RegexpUtils.getMatchera("^function[ ]?\\(.*?\\)$").matches(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNull(Object obj) {
        if (obj instanceof JSONObject) {
            return ((JSONObject) obj).nullObject;
        }
        return JSONNull.instance.equals(obj);
    }

    public static boolean isNumber(Object obj) {
        if ((obj == null || obj.getClass() != Byte.TYPE) && ((obj == null || obj.getClass() != Short.TYPE) && ((obj == null || obj.getClass() != Integer.TYPE) && ((obj == null || obj.getClass() != Long.TYPE) && ((obj == null || obj.getClass() != Float.TYPE) && (obj == null || obj.getClass() != Double.TYPE)))))) {
            return obj instanceof Number;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        if (r0.isAssignableFrom(r2.getClass()) != false) goto L_0x002b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isString(java.lang.Object r2) {
        /*
            boolean r0 = r2 instanceof java.lang.String
            if (r0 != 0) goto L_0x002b
            boolean r0 = r2 instanceof java.lang.Character
            if (r0 != 0) goto L_0x002b
            if (r2 == 0) goto L_0x0029
            java.lang.Class r0 = r2.getClass()
            java.lang.Class r1 = java.lang.Character.TYPE
            if (r0 == r1) goto L_0x002b
            java.lang.Class r0 = class$java$lang$String
            if (r0 != 0) goto L_0x001e
            java.lang.String r0 = "java.lang.String"
            java.lang.Class r0 = class$(r0)
            class$java$lang$String = r0
        L_0x001e:
            java.lang.Class r2 = r2.getClass()
            boolean r2 = r0.isAssignableFrom(r2)
            if (r2 == 0) goto L_0x0029
            goto L_0x002b
        L_0x0029:
            r2 = 0
            return r2
        L_0x002b:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sf.json.util.JSONUtils.isString(java.lang.Object):boolean");
    }

    public static boolean mayBeJSON(String str) {
        return str != null && ("null".equals(str) || ((str.startsWith("[") && str.endsWith(CMapParser.MARK_END_OF_ARRAY)) || (str.startsWith("{") && str.endsWith("}"))));
    }

    public static String quote(String str) {
        int i;
        if (isFunction(str)) {
            return str;
        }
        if (str == null || str.length() == 0) {
            return "\"\"";
        }
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length * 2);
        char[] charArray = str.toCharArray();
        char[] cArr = new char[1030];
        stringBuffer.append(StringEscapeUtils.CSV_QUOTE);
        int i2 = 0;
        int i3 = 0;
        char c2 = 0;
        while (i2 < length) {
            if (i3 > 1024) {
                stringBuffer.append(cArr, 0, i3);
                i3 = 0;
            }
            char c3 = charArray[i2];
            if (c3 != '\"') {
                if (c3 == '/') {
                    if (c2 == '<') {
                        cArr[i3] = '\\';
                        i3++;
                    }
                    i = i3 + 1;
                    cArr[i3] = c3;
                } else if (c3 != '\\') {
                    if (c3 < ' ') {
                        switch (c3) {
                            case 8:
                                int i4 = i3 + 1;
                                cArr[i3] = '\\';
                                i3 = i4 + 1;
                                cArr[i4] = 'b';
                                break;
                            case 9:
                                int i5 = i3 + 1;
                                cArr[i3] = '\\';
                                i3 = i5 + 1;
                                cArr[i5] = 't';
                                break;
                            case 10:
                                int i6 = i3 + 1;
                                cArr[i3] = '\\';
                                i3 = i6 + 1;
                                cArr[i6] = 'n';
                                break;
                            case 12:
                                int i7 = i3 + 1;
                                cArr[i3] = '\\';
                                i3 = i7 + 1;
                                cArr[i7] = 'f';
                                break;
                            case 13:
                                int i8 = i3 + 1;
                                cArr[i3] = '\\';
                                i3 = i8 + 1;
                                cArr[i8] = 'r';
                                break;
                            default:
                                StringBuffer outline71 = GeneratedOutlineSupport.outline71("000");
                                outline71.append(Integer.toHexString(c3));
                                String stringBuffer2 = outline71.toString();
                                int length2 = stringBuffer2.length();
                                int i9 = i3 + 1;
                                cArr[i3] = '\\';
                                int i10 = i9 + 1;
                                cArr[i9] = ASCII85InputStream.PADDING_U;
                                int i11 = i10 + 1;
                                cArr[i10] = stringBuffer2.charAt(length2 - 4);
                                int i12 = i11 + 1;
                                cArr[i11] = stringBuffer2.charAt(length2 - 3);
                                int i13 = i12 + 1;
                                cArr[i12] = stringBuffer2.charAt(length2 - 2);
                                i3 = i13 + 1;
                                cArr[i13] = stringBuffer2.charAt(length2 - 1);
                                break;
                        }
                        i2++;
                        c2 = c3;
                    } else {
                        i = i3 + 1;
                        cArr[i3] = c3;
                    }
                }
                i3 = i;
                i2++;
                c2 = c3;
            }
            int i14 = i3 + 1;
            cArr[i3] = '\\';
            i3 = i14 + 1;
            cArr[i14] = c3;
            i2++;
            c2 = c3;
        }
        stringBuffer.append(cArr, 0, i3);
        stringBuffer.append(StringEscapeUtils.CSV_QUOTE);
        return stringBuffer.toString();
    }

    public static String stripQuotes(String str) {
        if (str.length() < 2) {
            return str;
        }
        if (str.startsWith("'") && str.endsWith("'")) {
            return str.substring(1, str.length() - 1);
        }
        if (str.startsWith("\"") && str.endsWith("\"")) {
            str = str.substring(1, str.length() - 1);
        }
        return str;
    }

    public static void testValidity(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Double) {
            Double d2 = (Double) obj;
            if (d2.isInfinite() || d2.isNaN()) {
                throw new JSONException((String) "JSON does not allow non-finite numbers");
            }
        } else if (obj instanceof Float) {
            Float f2 = (Float) obj;
            if (f2.isInfinite() || f2.isNaN()) {
                throw new JSONException((String) "JSON does not allow non-finite numbers.");
            }
        } else {
            if ((obj instanceof BigDecimal) || (obj instanceof BigInteger)) {
            }
        }
    }

    public static Number transformNumber(Number number) {
        if (number instanceof Float) {
            return new Double(number.toString());
        }
        if (number instanceof Short) {
            return new Integer(number.intValue());
        }
        if (number instanceof Byte) {
            return new Integer(number.intValue());
        }
        if (number instanceof Long) {
            if (number.longValue() <= new Long(2147483647L).longValue() && number.longValue() >= -2147483648L) {
                return new Integer(number.intValue());
            }
        }
        return number;
    }

    public static String valueToString(Object obj) {
        if (obj == null || isNull(obj)) {
            return "null";
        }
        if (obj instanceof JSONFunction) {
            return ((JSONFunction) obj).toString();
        }
        if (obj instanceof JSONString) {
            try {
                String jSONString = ((JSONString) obj).toJSONString();
                if (jSONString instanceof String) {
                    return jSONString;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Bad value from toJSONString: ");
                stringBuffer.append(jSONString);
                throw new JSONException(stringBuffer.toString());
            } catch (Exception e2) {
                throw new JSONException((Throwable) e2);
            }
        } else if (obj instanceof Number) {
            Number number = (Number) obj;
            testValidity(number);
            String obj2 = number.toString();
            if (obj2.indexOf(46) > 0 && obj2.indexOf(101) < 0 && obj2.indexOf(69) < 0) {
                while (obj2.endsWith("0")) {
                    obj2 = obj2.substring(0, obj2.length() - 1);
                }
                if (obj2.endsWith(".")) {
                    obj2 = obj2.substring(0, obj2.length() - 1);
                }
            }
            return obj2;
        } else if ((obj instanceof Boolean) || (obj instanceof JSONObject) || (obj instanceof JSONArray)) {
            return obj.toString();
        } else {
            return quote(obj.toString());
        }
    }

    public static boolean isArray(Object obj) {
        return (obj != null && obj.getClass().isArray()) || (obj instanceof Collection) || (obj instanceof JSONArray);
    }
}
