package com.google.android.datatransport.runtime;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class EventInternal {

    public static abstract class Builder {
        public final Builder addMetadata(String str, String str2) {
            getAutoMetadata().put(str, str2);
            return this;
        }

        public abstract EventInternal build();

        public abstract Map<String, String> getAutoMetadata();

        public abstract Builder setEncodedPayload(EncodedPayload encodedPayload);

        public abstract Builder setEventMillis(long j);

        public abstract Builder setTransportName(String str);

        public abstract Builder setUptimeMillis(long j);
    }

    public static Builder builder() {
        com.google.android.datatransport.runtime.AutoValue_EventInternal.Builder builder = new com.google.android.datatransport.runtime.AutoValue_EventInternal.Builder();
        builder.autoMetadata = new HashMap();
        return builder;
    }

    public final String get(String str) {
        String str2 = ((AutoValue_EventInternal) this).autoMetadata.get(str);
        return str2 == null ? "" : str2;
    }

    public final int getInteger(String str) {
        String str2 = ((AutoValue_EventInternal) this).autoMetadata.get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public final Map<String, String> getMetadata() {
        return Collections.unmodifiableMap(((AutoValue_EventInternal) this).autoMetadata);
    }

    public Builder toBuilder() {
        com.google.android.datatransport.runtime.AutoValue_EventInternal.Builder builder = new com.google.android.datatransport.runtime.AutoValue_EventInternal.Builder();
        AutoValue_EventInternal autoValue_EventInternal = (AutoValue_EventInternal) this;
        builder.setTransportName(autoValue_EventInternal.transportName);
        builder.code = autoValue_EventInternal.code;
        builder.setEncodedPayload(autoValue_EventInternal.encodedPayload);
        builder.setEventMillis(autoValue_EventInternal.eventMillis);
        builder.setUptimeMillis(autoValue_EventInternal.uptimeMillis);
        builder.autoMetadata = new HashMap(autoValue_EventInternal.autoMetadata);
        return builder;
    }
}
