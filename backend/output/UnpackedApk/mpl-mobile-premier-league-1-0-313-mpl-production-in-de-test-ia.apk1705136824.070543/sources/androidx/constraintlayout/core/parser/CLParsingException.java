package androidx.constraintlayout.core.parser;

import com.android.tools.r8.GeneratedOutlineSupport;

public class CLParsingException extends Exception {
    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("CLParsingException (");
        outline73.append(hashCode());
        outline73.append(") : ");
        outline73.append("null (null at line 0)");
        return outline73.toString();
    }
}
