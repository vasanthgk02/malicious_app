package io.hansel.core.criteria.datatype;

import io.hansel.core.criteria.b;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.utils.HSLUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class NumberDataType extends b implements Serializable {
    private Double getValue(Object obj, String str) {
        if (str != null) {
            Double valueOf = Double.valueOf(str);
            if ((obj instanceof ArrayList) && !((ArrayList) obj).isEmpty()) {
                return valueOf;
            }
        }
        return null;
    }

    public Object average(HashMap<Object, Integer> hashMap) {
        ArrayList arrayList = new ArrayList(hashMap.keySet());
        int size = arrayList.size();
        double d2 = 0.0d;
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = arrayList.get(i2);
            try {
                double doubleValue = Double.valueOf(String.valueOf(obj)).doubleValue();
                int intValue = hashMap.get(obj).intValue();
                i += intValue;
                d2 = (doubleValue * ((double) intValue)) + d2;
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
            }
        }
        return Double.valueOf(d2 / ((double) i));
    }

    public Object count(HashMap<Object, Integer> hashMap) {
        ArrayList arrayList = new ArrayList(hashMap.keySet());
        int size = arrayList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = arrayList.get(i2);
            try {
                Double.valueOf(String.valueOf(obj));
                i += hashMap.get(obj).intValue();
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
            }
        }
        return Integer.valueOf(i);
    }

    public boolean dateEqual(Object obj, String str, String str2) {
        boolean z = false;
        try {
            Double value = getValue(obj, str);
            if (value != null) {
                Double valueOf = Double.valueOf(value.doubleValue() + ((double) HSLUtils.getTimeOffset(str2)));
                if (valueOf.doubleValue() >= ((Double) ((ArrayList) obj).get(0)).doubleValue()) {
                    if (valueOf.doubleValue() < ((Double) ((ArrayList) obj).get(0)).doubleValue() + ((double) HSLUtils.getMillisInADay())) {
                        z = true;
                    }
                }
                return z;
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
        return false;
    }

    public boolean datePost(Object obj, String str, String str2) {
        boolean z = false;
        try {
            Double value = getValue(obj, str);
            if (value != null) {
                if (value.doubleValue() + ((double) HSLUtils.getTimeOffset(str2)) > ((Double) ((ArrayList) obj).get(0)).doubleValue()) {
                    z = true;
                }
                return z;
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
        return false;
    }

    public boolean datePriorTo(Object obj, String str, String str2) {
        boolean z = false;
        try {
            Double value = getValue(obj, str);
            if (value != null) {
                if (value.doubleValue() + ((double) HSLUtils.getTimeOffset(str2)) < ((Double) ((ArrayList) obj).get(0)).doubleValue()) {
                    z = true;
                }
                return z;
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
        return false;
    }

    public boolean equal(Object obj, String str) {
        try {
            Double value = getValue(obj, str);
            if (value != null) {
                return value.equals(((ArrayList) obj).get(0));
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
        return false;
    }

    public boolean greaterThan(Object obj, String str) {
        boolean z = false;
        try {
            Double value = getValue(obj, str);
            if (value != null) {
                if (value.doubleValue() > ((Double) ((ArrayList) obj).get(0)).doubleValue()) {
                    z = true;
                }
                return z;
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
        return false;
    }

    public boolean greaterThanOrEqual(Object obj, String str) {
        boolean z = false;
        try {
            Double value = getValue(obj, str);
            if (value != null) {
                if (value.doubleValue() >= ((Double) ((ArrayList) obj).get(0)).doubleValue()) {
                    z = true;
                }
                return z;
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
        return false;
    }

    public boolean in(Object obj, String str) {
        try {
            Double value = getValue(obj, str);
            if (value != null) {
                return ((ArrayList) obj).contains(value);
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
        return false;
    }

    public boolean lessThan(Object obj, String str) {
        boolean z = false;
        try {
            Double value = getValue(obj, str);
            if (value != null) {
                if (value.doubleValue() < ((Double) ((ArrayList) obj).get(0)).doubleValue()) {
                    z = true;
                }
                return z;
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
        return false;
    }

    public boolean lessThanOrEqual(Object obj, String str) {
        boolean z = false;
        try {
            Double value = getValue(obj, str);
            if (value != null) {
                if (value.doubleValue() <= ((Double) ((ArrayList) obj).get(0)).doubleValue()) {
                    z = true;
                }
                return z;
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
        return false;
    }

    public Object max(HashMap<Object, Integer> hashMap) {
        ArrayList arrayList = new ArrayList(hashMap.keySet());
        int size = arrayList.size();
        double d2 = Double.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            try {
                double doubleValue = Double.valueOf(String.valueOf(arrayList.get(i))).doubleValue();
                if (doubleValue > d2) {
                    d2 = doubleValue;
                }
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
            }
        }
        return Double.valueOf(d2);
    }

    public Object min(HashMap<Object, Integer> hashMap) {
        ArrayList arrayList = new ArrayList(hashMap.keySet());
        int size = arrayList.size();
        double d2 = Double.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            try {
                double doubleValue = Double.valueOf(String.valueOf(arrayList.get(i))).doubleValue();
                if (doubleValue < d2) {
                    d2 = doubleValue;
                }
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
            }
        }
        return Double.valueOf(d2);
    }

    public boolean notEqual(Object obj, String str) {
        try {
            Double value = getValue(obj, str);
            if (value != null) {
                return !value.equals(((ArrayList) obj).get(0));
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
        return false;
    }

    public boolean notIn(Object obj, String str) {
        try {
            Double value = getValue(obj, str);
            if (value != null) {
                return !((ArrayList) obj).contains(value);
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
        return false;
    }

    public Object sum(HashMap<Object, Integer> hashMap) {
        ArrayList arrayList = new ArrayList(hashMap.keySet());
        int size = arrayList.size();
        double d2 = 0.0d;
        for (int i = 0; i < size; i++) {
            Object obj = arrayList.get(i);
            try {
                d2 = (Double.valueOf(String.valueOf(obj)).doubleValue() * ((double) hashMap.get(obj).intValue())) + d2;
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
            }
        }
        return Double.valueOf(d2);
    }
}
