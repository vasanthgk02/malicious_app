package org.apache.commons.lang;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Collection;
import java.util.Map;

public class Validate {
    public static void allElementsOfType(Collection<Object> collection, Class cls, String str) {
        notNull(collection);
        notNull(cls);
        for (Object isInstance : collection) {
            if (!cls.isInstance(isInstance)) {
                throw new IllegalArgumentException(str);
            }
        }
    }

    public static void isTrue(boolean z, String str, Object obj) {
        if (!z) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(obj);
            throw new IllegalArgumentException(stringBuffer.toString());
        }
    }

    public static void noNullElements(Object[] objArr, String str) {
        notNull(objArr);
        int i = 0;
        while (i < objArr.length) {
            if (objArr[i] != null) {
                i++;
            } else {
                throw new IllegalArgumentException(str);
            }
        }
    }

    public static void notEmpty(Object[] objArr, String str) {
        if (objArr == null || objArr.length == 0) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void notNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void isTrue(boolean z, String str, long j) {
        if (!z) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(j);
            throw new IllegalArgumentException(stringBuffer.toString());
        }
    }

    public static void notNull(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("The validated object is null");
        }
    }

    public static void isTrue(boolean z, String str, double d2) {
        if (!z) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(d2);
            throw new IllegalArgumentException(stringBuffer.toString());
        }
    }

    public static void notEmpty(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            throw new IllegalArgumentException("The validated array is empty");
        }
    }

    public static void isTrue(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void isTrue(boolean z) {
        if (!z) {
            throw new IllegalArgumentException("The validated expression is false");
        }
    }

    public static void noNullElements(Object[] objArr) {
        notNull(objArr);
        int i = 0;
        while (i < objArr.length) {
            if (objArr[i] != null) {
                i++;
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("The validated array contains null element at index: ");
                stringBuffer.append(i);
                throw new IllegalArgumentException(stringBuffer.toString());
            }
        }
    }

    public static void notEmpty(Collection collection, String str) {
        if (collection == null || collection.size() == 0) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void allElementsOfType(Collection<Object> collection, Class cls) {
        notNull(collection);
        notNull(cls);
        int i = 0;
        for (Object isInstance : collection) {
            if (cls.isInstance(isInstance)) {
                i++;
            } else {
                StringBuffer outline71 = GeneratedOutlineSupport.outline71("The validated collection contains an element not of type ");
                outline71.append(cls.getName());
                outline71.append(" at index: ");
                outline71.append(i);
                throw new IllegalArgumentException(outline71.toString());
            }
        }
    }

    public static void notEmpty(Collection collection) {
        if (collection == null || collection.size() == 0) {
            throw new IllegalArgumentException("The validated collection is empty");
        }
    }

    public static void noNullElements(Collection<Object> collection, String str) {
        notNull(collection);
        for (Object obj : collection) {
            if (obj == null) {
                throw new IllegalArgumentException(str);
            }
        }
    }

    public static void notEmpty(Map map, String str) {
        if (map == null || map.size() == 0) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void notEmpty(Map map) {
        if (map == null || map.size() == 0) {
            throw new IllegalArgumentException("The validated map is empty");
        }
    }

    public static void noNullElements(Collection<Object> collection) {
        notNull(collection);
        int i = 0;
        for (Object obj : collection) {
            if (obj != null) {
                i++;
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("The validated collection contains null element at index: ");
                stringBuffer.append(i);
                throw new IllegalArgumentException(stringBuffer.toString());
            }
        }
    }

    public static void notEmpty(String str, String str2) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void notEmpty(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("The validated string is empty");
        }
    }
}
