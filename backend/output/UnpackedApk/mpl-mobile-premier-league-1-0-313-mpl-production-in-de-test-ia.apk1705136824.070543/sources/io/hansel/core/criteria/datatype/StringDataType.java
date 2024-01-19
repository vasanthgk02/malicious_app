package io.hansel.core.criteria.datatype;

import io.hansel.core.criteria.b;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.utils.HSLUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class StringDataType extends b implements Serializable {
    private String[] normalizeVersion(String[] strArr, int i) {
        String str;
        String[] strArr2 = new String[i];
        int length = strArr.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            str = "0";
            if (i2 >= length) {
                break;
            }
            String str2 = strArr[i2];
            if (!str2.isEmpty()) {
                str = str2;
            }
            strArr2[i3] = str;
            i3++;
            i2++;
        }
        while (i3 < i) {
            strArr2[i3] = str;
            i3++;
        }
        return strArr2;
    }

    private String[] removeEmptyValues(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].isEmpty()) {
                strArr2[i] = "0";
            } else {
                strArr2[i] = strArr[i];
            }
        }
        return strArr2;
    }

    private int versionCompare(String str, String str2) {
        if (!(str == null || str2 == null)) {
            String trim = str.trim();
            String trim2 = str2.trim();
            if (!trim.isEmpty() && !trim2.isEmpty()) {
                String numericValue = HSLUtils.getNumericValue(trim);
                String numericValue2 = HSLUtils.getNumericValue(trim2);
                String[] split = numericValue.split("\\.");
                String[] split2 = numericValue2.split("\\.");
                String[] removeEmptyValues = removeEmptyValues(split);
                String[] removeEmptyValues2 = removeEmptyValues(split2);
                if (removeEmptyValues.length != removeEmptyValues2.length) {
                    if (removeEmptyValues.length > removeEmptyValues2.length) {
                        removeEmptyValues2 = normalizeVersion(removeEmptyValues2, removeEmptyValues.length);
                    } else {
                        removeEmptyValues = normalizeVersion(removeEmptyValues, removeEmptyValues2.length);
                    }
                }
                int i = 0;
                int length = removeEmptyValues.length;
                int length2 = removeEmptyValues2.length;
                while (i < length && i < length2 && removeEmptyValues[i].equals(removeEmptyValues2[i])) {
                    i++;
                }
                return Integer.signum((i >= removeEmptyValues.length || i >= removeEmptyValues2.length) ? removeEmptyValues.length - removeEmptyValues2.length : Integer.valueOf(removeEmptyValues[i]).compareTo(Integer.valueOf(removeEmptyValues2[i])));
            }
        }
        return -2;
    }

    public Object count(HashMap<Object, Integer> hashMap) {
        ArrayList arrayList = new ArrayList(hashMap.keySet());
        int size = arrayList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = arrayList.get(i2);
            try {
                String.valueOf(obj);
                Integer num = hashMap.get(obj);
                i += num == null ? 0 : num.intValue();
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
            }
        }
        return Integer.valueOf(i);
    }

    public boolean equal(Object obj, String str) {
        boolean z = false;
        try {
            if ((obj instanceof ArrayList) && !((ArrayList) obj).isEmpty()) {
                if (str != null) {
                    z = str.equals(((ArrayList) obj).get(0));
                } else if (((ArrayList) obj).get(0) == null) {
                    z = true;
                }
                return z;
            }
        } catch (Exception e2) {
            HSLLogger.printStackTrace(e2);
        }
        return false;
    }

    public boolean in(Object obj, String str) {
        if (str != null) {
            try {
                if (obj instanceof ArrayList) {
                    return ((ArrayList) obj).contains(str);
                }
            } catch (Exception e2) {
                HSLLogger.printStackTrace(e2);
            }
        }
        return false;
    }

    public boolean isContainedIn(Object obj, String str) {
        if (str != null) {
            try {
                if ((obj instanceof ArrayList) && !((ArrayList) obj).isEmpty()) {
                    return str.contains((String) ((ArrayList) obj).get(0));
                }
            } catch (Exception e2) {
                HSLLogger.printStackTrace(e2);
            }
        }
        return false;
    }

    public boolean isNotContainedIn(Object obj, String str) {
        if (str != null) {
            try {
                if ((obj instanceof ArrayList) && !((ArrayList) obj).isEmpty()) {
                    return !str.contains((String) ((ArrayList) obj).get(0));
                }
            } catch (Exception e2) {
                HSLLogger.printStackTrace(e2);
            }
        }
        return false;
    }

    public Object max(HashMap<Object, Integer> hashMap) {
        ArrayList arrayList = new ArrayList(hashMap.keySet());
        int size = arrayList.size();
        String str = "";
        for (int i = 0; i < size; i++) {
            try {
                String valueOf = String.valueOf(arrayList.get(i));
                if (valueOf.compareTo(str) > 0) {
                    str = valueOf;
                }
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
            }
        }
        return str;
    }

    public Object min(HashMap<Object, Integer> hashMap) {
        ArrayList arrayList = new ArrayList(hashMap.keySet());
        int size = arrayList.size();
        String str = "";
        for (int i = 0; i < size; i++) {
            try {
                String valueOf = String.valueOf(arrayList.get(i));
                if (valueOf.compareTo(str) < 0) {
                    str = valueOf;
                }
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
            }
        }
        return str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
        if (r4.equals(((java.util.ArrayList) r3).get(0)) == false) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean notEqual(java.lang.Object r3, java.lang.String r4) {
        /*
            r2 = this;
            r0 = 0
            boolean r1 = r3 instanceof java.util.ArrayList     // Catch:{ Exception -> 0x0027 }
            if (r1 == 0) goto L_0x002b
            r1 = r3
            java.util.ArrayList r1 = (java.util.ArrayList) r1     // Catch:{ Exception -> 0x0027 }
            boolean r1 = r1.isEmpty()     // Catch:{ Exception -> 0x0027 }
            if (r1 != 0) goto L_0x002b
            if (r4 != 0) goto L_0x0019
            java.util.ArrayList r3 = (java.util.ArrayList) r3     // Catch:{ Exception -> 0x0027 }
            java.lang.Object r3 = r3.get(r0)     // Catch:{ Exception -> 0x0027 }
            if (r3 == 0) goto L_0x0026
            goto L_0x0025
        L_0x0019:
            java.util.ArrayList r3 = (java.util.ArrayList) r3     // Catch:{ Exception -> 0x0027 }
            java.lang.Object r3 = r3.get(r0)     // Catch:{ Exception -> 0x0027 }
            boolean r3 = r4.equals(r3)     // Catch:{ Exception -> 0x0027 }
            if (r3 != 0) goto L_0x0026
        L_0x0025:
            r0 = 1
        L_0x0026:
            return r0
        L_0x0027:
            r3 = move-exception
            io.hansel.core.logger.HSLLogger.printStackTrace(r3)
        L_0x002b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.core.criteria.datatype.StringDataType.notEqual(java.lang.Object, java.lang.String):boolean");
    }

    public boolean notIn(Object obj, String str) {
        if (str != null) {
            try {
                if (obj instanceof ArrayList) {
                    return !((ArrayList) obj).contains(str);
                }
            } catch (Exception e2) {
                HSLLogger.printStackTrace(e2);
            }
        }
        return false;
    }

    public boolean regex(Object obj, String str) {
        if (str != null) {
            try {
                if ((obj instanceof ArrayList) && !((ArrayList) obj).isEmpty()) {
                    return str.matches((String) ((ArrayList) obj).get(0));
                }
            } catch (Exception e2) {
                HSLLogger.printStackTrace(e2);
            }
        }
        return false;
    }

    public boolean versionEqual(Object obj, String str) {
        boolean z = false;
        if (str != null) {
            try {
                if ((obj instanceof ArrayList) && !((ArrayList) obj).isEmpty()) {
                    if (versionCompare(str, (String) ((ArrayList) obj).get(0)) == 0) {
                        z = true;
                    }
                    return z;
                }
            } catch (Exception e2) {
                HSLLogger.printStackTrace(e2);
            }
        }
        return false;
    }

    public boolean versionGreaterThan(Object obj, String str) {
        boolean z = false;
        if (str != null) {
            try {
                if ((obj instanceof ArrayList) && !((ArrayList) obj).isEmpty()) {
                    if (versionCompare(str, (String) ((ArrayList) obj).get(0)) == 1) {
                        z = true;
                    }
                    return z;
                }
            } catch (Exception e2) {
                HSLLogger.printStackTrace(e2);
            }
        }
        return false;
    }

    public boolean versionGreaterThanOrEqual(Object obj, String str) {
        boolean z = false;
        if (str != null) {
            try {
                if ((obj instanceof ArrayList) && !((ArrayList) obj).isEmpty()) {
                    int versionCompare = versionCompare(str, (String) ((ArrayList) obj).get(0));
                    if (versionCompare == 1 || versionCompare == 0) {
                        z = true;
                    }
                    return z;
                }
            } catch (Exception e2) {
                HSLLogger.printStackTrace(e2);
            }
        }
        return false;
    }

    public boolean versionLessThan(Object obj, String str) {
        boolean z = false;
        if (str != null) {
            try {
                if ((obj instanceof ArrayList) && !((ArrayList) obj).isEmpty()) {
                    if (versionCompare(str, (String) ((ArrayList) obj).get(0)) == -1) {
                        z = true;
                    }
                    return z;
                }
            } catch (Exception e2) {
                HSLLogger.printStackTrace(e2);
            }
        }
        return false;
    }

    public boolean versionLessThanOrEqual(Object obj, String str) {
        boolean z = false;
        if (str != null) {
            try {
                if ((obj instanceof ArrayList) && !((ArrayList) obj).isEmpty()) {
                    int versionCompare = versionCompare(str, (String) ((ArrayList) obj).get(0));
                    if (versionCompare == -1 || versionCompare == 0) {
                        z = true;
                    }
                    return z;
                }
            } catch (Exception e2) {
                HSLLogger.printStackTrace(e2);
            }
        }
        return false;
    }
}
