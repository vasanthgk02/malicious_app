package org.apache.commons.lang;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Arrays;

public class IncompleteArgumentException extends IllegalArgumentException {
    public static final long serialVersionUID = 4954193403612068178L;

    public IncompleteArgumentException(String str) {
        super(GeneratedOutlineSupport.outline49(str, " is incomplete."));
    }

    public static final String safeArrayToString(Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        return Arrays.asList(objArr).toString();
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public IncompleteArgumentException(String str, String[] strArr) {
        // StringBuffer stringBuffer = new StringBuffer();
        // stringBuffer.append(str);
        // stringBuffer.append(" is missing the following items: ");
        // stringBuffer.append(safeArrayToString(strArr));
        super(stringBuffer.toString());
    }
}
