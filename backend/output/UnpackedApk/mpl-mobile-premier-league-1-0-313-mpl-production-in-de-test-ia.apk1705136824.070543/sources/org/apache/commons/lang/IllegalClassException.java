package org.apache.commons.lang;

import com.android.tools.r8.GeneratedOutlineSupport;

public class IllegalClassException extends IllegalArgumentException {
    public static final long serialVersionUID = 8063272569377254819L;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public IllegalClassException(Class cls, Object obj) {
        // StringBuffer outline71 = GeneratedOutlineSupport.outline71("Expected: ");
        // outline71.append(safeGetClassName(cls));
        // outline71.append(", actual: ");
        // outline71.append(obj == null ? "null" : obj.getClass().getName());
        super(outline71.toString());
    }

    public static final String safeGetClassName(Class cls) {
        if (cls == null) {
            return null;
        }
        return cls.getName();
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public IllegalClassException(Class cls, Class cls2) {
        // StringBuffer outline71 = GeneratedOutlineSupport.outline71("Expected: ");
        // outline71.append(safeGetClassName(cls));
        // outline71.append(", actual: ");
        // outline71.append(safeGetClassName(cls2));
        super(outline71.toString());
    }

    public IllegalClassException(String str) {
        super(str);
    }
}
