package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import java.util.Set;

public interface EncodedDestination {
    byte[] getExtras();

    String getName();

    Set<Encoding> getSupportedEncodings();
}
