package com.getkeepsafe.relinker;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Arrays;

public class MissingLibraryException extends RuntimeException {
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MissingLibraryException(String str, String[] strArr, String[] strArr2) {
        // StringBuilder outline80 = GeneratedOutlineSupport.outline80("Could not find '", str, "'. Looked for: ");
        // outline80.append(Arrays.toString(strArr));
        // outline80.append(", but only found: ");
        super(GeneratedOutlineSupport.outline62(outline80, Arrays.toString(strArr2), "."));
    }
}
