package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.ConcurrentHashMap;

@KeepForSdk
@Deprecated
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public class LibraryVersion {
    static {
        new GmsLogger("LibraryVersion", "");
        new LibraryVersion();
    }

    @VisibleForTesting
    public LibraryVersion() {
        new ConcurrentHashMap();
    }
}
