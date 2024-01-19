package com.google.android.datatransport.cct;

import androidx.annotation.Keep;
import com.google.android.datatransport.runtime.backends.AutoValue_CreationContext;
import com.google.android.datatransport.runtime.backends.BackendFactory;
import com.google.android.datatransport.runtime.backends.CreationContext;
import com.google.android.datatransport.runtime.backends.TransportBackend;

@Keep
public class CctBackendFactory implements BackendFactory {
    public TransportBackend create(CreationContext creationContext) {
        AutoValue_CreationContext autoValue_CreationContext = (AutoValue_CreationContext) creationContext;
        return new CctTransportBackend(autoValue_CreationContext.applicationContext, autoValue_CreationContext.wallClock, autoValue_CreationContext.monotonicClock);
    }
}
